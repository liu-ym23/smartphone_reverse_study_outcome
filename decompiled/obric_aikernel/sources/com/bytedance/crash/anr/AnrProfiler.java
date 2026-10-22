package com.bytedance.crash.anr;

import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AnrProfiler {
    private static final String FILE_NAME = "/anr_profiler";
    private long mNativeManager;

    public static class Parser {
        private static final String ANR_ML_FEATURES = "anr_ml_features";
        private static final String FILTER_PREFIX = "npth_profiler_";
        private static final String MEMORY_STREAM = "MEMORY_STREAM";
        private static final int PARAMS_ANR_INFO = 3;
        private static final int PARAMS_ANR_TIME = 0;
        private static final int PARAMS_HEAP_SIZE = 4;
        private static final int PARAMS_LEFT_TS = 2;
        private static final int PARAMS_LOGCAT_GC_SCORE = 8;
        private static final int PARAMS_MAX = 9;
        private static final int PARAMS_RIGHT_TS = 1;
        private static final int PARAMS_TRACE_FILE = 5;
        private static final int PARAMS_TRACE_STM = 7;
        private static final int PARAMS_TRACE_UTM = 6;
        private static final String SCHED_STREAM = "SCHED_STREAM";
        private static final String TAG_ANR_REASON = "ANR_REASON";
        private static final String TAG_ANR_TIME = "ANR_TIME";
        private static final String TAG_CPU_FREQS = "CPU_FREQS";
        private static final String TAG_CPU_JIFFS = "CPU_JIFFS";
        private static final String TAG_CPU_LOADS = "CPU_LOADS";
        private static final String TAG_CPU_SCHED = "CPU_SCHED";
        private static final String TAG_DURATION = "DURATION";
        private static final String TAG_GC_STATE = "GC_STATE";
        private static final String TAG_JVM_STATE = "JVM_STATE";
        private static final String TAG_PAGE_FAULT = "PAGE_FAULT";
        private static final String TAG_PROC_MEMORY = "PROC_MEMORY";
        private static final String TAG_SYS_MEMORY = "SYS_MEMORY";
        private boolean isSuccess;
        private final File mDirectory;

        Parser(File r10, @NonNull JSONObject r11, AnrTraceParser r12, AnrInfoParser r13) {
            this.isSuccess = false;
            this.mDirectory = r10;
            NativeBridge.nAnrNativeProfilerFormat(r10 + AnrProfiler.FILE_NAME + ".inf", buildPriorParameters(r11, r12, r13));
        }

        private static Pair<Long, Long> getLongestMsgRange(JSONObject r10) {
            JSONObject r11 = r10.optJSONObject(CrashBody.LOGCAT_ANR_INFO);
            if (r11 == null) goto L9;
            long r12 = r11.optLong("cost");
            long r13 = r11.optLong("longMsgEnd");
            if (r12 < 1000) goto L9;
            if (r13 <= r12) goto L9;
            long r14 = r13 - r12;
        L11:
            if (r14 != (-1)) goto L16;
            JSONObject r15 = r10.optJSONObject("history_details");
            if (r15 == null) goto L16;
            r14 = r15.optLong("longestMsgStartWallTime");
            r13 = r15.optLong("longestMsgEndWallTime");
        L16:
            return new Pair(Long.valueOf(r14), Long.valueOf(r13));
        L9:
            r14 = -1;
            r13 = -1;
            goto L11
        }

        private static String getTime(String r10) {
            String r11 = null;
            r11 = r10.trim().split(" ")[1];     // Catch: Exception -> L9
            if (TextUtils.isEmpty(r11) == false) goto L7;
            return "";
        L7:
            return r11.substring(0, 8);
        L10:
            return r11;
        }

        private void pushAnrReasonToFilters(@NonNull JSONObject r10, String r11) {
            JSONUtils.put(r10, "npth_profiler_anr_reason", r11.trim());
        }

        private void pushCpuFrequenciesToFilters(@NonNull JSONObject r11, String r12) {
            Matcher r10 = Pattern.compile("^ (\\d{1,2})% (.+)$").matcher(r12);
            if (r10.find() == true) goto L6;
            JSONUtils.put(r11, "npth_profiler_cpu_efficiency", "unavailable");
            return;
        L6:
            int r13 = Integer.parseInt(r10.group(1));
            NumRanges r14 = new NumRanges("%");
            r14.set(0, 100, 10);
            JSONUtils.put(r11, "npth_profiler_cpu_efficiency", r14.get(r13));
            Matcher r15 = Pattern.compile("\\[(\\d+\\.\\d+)-\\d+\\.\\d+\\]\\{([\\d-]+)\\}(?:,\\\\s*)?").matcher(r10.group(2));
            double r16 = 0.0d;
        L8:
            if (r15.find() == false) goto L16;
            double r17 = Double.parseDouble(r15.group(1));
            String r18 = r15.group(2);
            if (r18 != null) goto L12;
        L14:
            int r19 = 1;
        L15:
            r16 = r16 + (r17 * ((double) r19));
            goto L8
        L12:
            if (r18.contains("-") == false) goto L14;
            String[] r20 = r18.split("-");
            r19 = (Integer.parseInt(r20[1]) - Integer.parseInt(r20[0])) + 1;
            goto L15
        L16:
            JSONUtils.put(r11, "npth_profiler_cpu_total_power", Long.valueOf((long) r16));
        }

        private void pushCpuJiffiesToFilters(@NonNull JSONObject r12, String r13) {
            Matcher r11 = Pattern.compile("^ Thread \\d+ = (\\d+) \\+ (\\d+), Process \\d+ = (\\d+) \\+ (\\d+)$").matcher(r13);
            if (r11.find() == true) goto L5;
            return;
        L5:
            if (r11.groupCount() != 4) goto L18;
            int r10 = Integer.parseInt(r11.group(1));
            int r14 = Integer.parseInt(r11.group(2));
            int r15 = Integer.parseInt(r11.group(3));
            int r16 = Integer.parseInt(r11.group(4));
            NumRanges r17 = new NumRanges("%");
            r17.set(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
            int r18 = r16 + r15;
            if (r18 == 0) goto L10;
            JSONUtils.put(r12, "npth_profiler_jiff_thread_ratio", r17.get(((r10 + r14) * 100) / r18));
        L10:
            int r19 = r14 + r10;
            if (r19 == 0) goto L13;
            JSONUtils.put(r12, "npth_profiler_jiff_thread_user_ratio", r17.get((r10 * 100) / r19));
        L13:
            if (r18 == 0) goto L17;
            JSONUtils.put(r12, "npth_profiler_jiff_process_user_ratio", r17.get((r15 * 100) / r18));
            return;
        L17:
            return;
        }

        private void pushCpuLoadsToFilters(@NonNull JSONObject r10, String r11) {
            Matcher r12 = Pattern.compile("^ (\\d+)\\.\\d{2} \\(.*\\)$").matcher(r11);
            if (r12.find() == true) goto L5;
            return;
        L5:
            if (r12.groupCount() != 1) goto L10;
            int r13 = Integer.parseInt(r12.group(1));
            NumRanges r14 = new NumRanges("");
            r14.set(new Long[]{0L, 4L, 10L, 30L, 60L, 100L, 150L, 200L});
            JSONUtils.put(r10, "npth_profiler_loads", r14.get(r13));
            return;
        }

        private void pushCpuSchedToFilters(@NonNull JSONObject r31, String r32) {
            Matcher r10 = Pattern.compile("^ Exec \\d+\\.\\d+\\((\\d+)%\\), Wait (.*), Sleep (.*), IOWait (.*)$").matcher(r32);
            if (r10.find() == false) goto L23;
            char r11 = 4;
            if (r10.groupCount() != 4) goto L27;
            NumRanges r12 = new NumRanges("%");
            r12.set(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
            JSONUtils.put(r31, "npth_profiler_exec_ratio", r12.get(Integer.parseInt(r10.group(1))));
            String[] r13 = {"wait_ratio", "sleep_ratio", "iowait_ratio"};
            int r14 = 0;
        L8:
            if (r14 >= 3) goto L28;
            String r15 = r10.group(r14 + 2);
            String r16 = "---";
            if ("---".equals(r15) == true) goto L20;
            Matcher r17 = Pattern.compile("^\\d+\\.\\d+\\((\\d+)%\\)$").matcher(r15);
            if (r17.find() == true) goto L14;
        L19:
            char r28 = 4;
        L22:
            JSONUtils.put(r31, FILTER_PREFIX + r13[r14], r16);
            r14 = r14 + 1;
            r11 = r28;
            goto L8
        L14:
            if (r17.groupCount() != 1) goto L19;
            if (r14 != 2) goto L17;
            r28 = 4;
            r12.set(new Long[]{0L, 1L, 5L, 10L, 25L, 50L, 75L, 100L});
        L18:
            r16 = r12.get(Integer.parseInt(r17.group(1)));
            goto L22
        L17:
            r28 = 4;
            goto L18
        L20:
            r28 = r11;
            goto L22
        L28:
            return;
        L27:
            return;
        }

        private void pushGcStateToFilters(@NonNull JSONObject r30, String r31) {
            Matcher r10 = Pattern.compile("^ JavaHeap \\d+MB, Time (\\d+)\\.(\\d+), BlockTime (\\d+)\\.(\\d+), Count (\\d+), BlockCount (\\d+), MainWaitGcTime (\\d+)\\.(\\d+), MainGcTime (\\d+)\\.(\\d+)$").matcher(r31);
            if (r10.find() == true) goto L5;
            return;
        L5:
            if (r10.groupCount() != 10) goto L10;
            long r11 = (Long.parseLong(r10.group(1)) * 1000) + Long.parseLong(r10.group(2));
            long r12 = (Long.parseLong(r10.group(3)) * 1000) + Long.parseLong(r10.group(4));
            long r14 = Long.parseLong(r10.group(5));
            long r13 = Long.parseLong(r10.group(6));
            long r15 = (Long.parseLong(r10.group(7)) * 1000) + Long.parseLong(r10.group(8));
            long r16 = (Long.parseLong(r10.group(9)) * 1000) + Long.parseLong(r10.group(10));
            NumRanges r17 = new NumRanges("ms");
            r17.set(new Long[]{0L, 1L, 500L, 1000L, 1500L, 2000L, Long.valueOf(WsConstants.EXIT_DELAY_TIME), 5000L});
            JSONUtils.put(r30, "npth_profiler_gc_time", r17.get(r11));
            JSONUtils.put(r30, "npth_profiler_gc_block_time", r17.get(r12));
            JSONUtils.put(r30, "npth_profiler_main_wait_gc_time", r17.get(r15));
            JSONUtils.put(r30, "npth_profiler_main_gc_time", r17.get(r16));
            NumRanges r18 = new NumRanges("");
            r18.set(new Long[]{0L, 1L, 5L, 10L, 50L, 100L});
            JSONUtils.put(r30, "npth_profiler_gc_count", r18.get(r14));
            JSONUtils.put(r30, "npth_profiler_gc_block_count", r18.get(r13));
            return;
        }

        private void pushJvmStateToFilters(@NonNull JSONObject r10, String r11) {
            Matcher r12 = Pattern.compile("^ JavaLock (.*)$").matcher(r11);
            if (r12.find() == true) goto L5;
            return;
        L5:
            if (r12.groupCount() != 1) goto L10;
            JSONUtils.put(r10, "npth_profiler_java_lock_owner", r12.group(1));
            return;
        }

        private void pushPageFaultToFilters(@NonNull JSONObject r10, String r11) {
            Matcher r12 = Pattern.compile("^ Thread (\\d+) (\\d+), Process (\\d+) (\\d+)$").matcher(r11);
            if (r12.find() == true) goto L5;
            return;
        L5:
            if (r12.groupCount() != 4) goto L12;
            NumRanges r13 = new NumRanges("");
            int r14 = 0;
            r13.set(new Long[]{0L, 1L, 10L, 100L, 1000L, Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), 100000L});
            String[] r15 = {"thread_minor", "thread_major", "process_minor", "process_major"};
        L8:
            if (r14 >= 4) goto L13;
            int r16 = r14 + 1;
            JSONUtils.put(r10, "npth_profiler_fault_" + r15[r14], r13.get(Long.parseLong(r12.group(r16))));
            r14 = r16;
            goto L8
        L13:
            return;
        }

        private void pushProcessMemoryToFilters(@NonNull JSONObject r10, String r11) {
            Matcher r12 = Pattern.compile("^ VSS \\d+\\([+-]\\d+\\)MB, RSS (\\d+)\\([+-]\\d+\\)MB, SWAP (\\d+)\\([+-]\\d+\\)MB$").matcher(r11);
            if (r12.find() == true) goto L5;
            return;
        L5:
            if (r12.groupCount() != 2) goto L10;
            long r13 = Long.parseLong(r12.group(1)) + Long.parseLong(r12.group(2));
            NumRanges r14 = new NumRanges("MB");
            r14.set(new Long[]{0L, 1L, 64L, 128L, 256L, 512L, 768L, 1024L, 1536L, Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)});
            JSONUtils.put(r10, "npth_profiler_procram_total", r14.get(r13));
            return;
        }

        private void pushSchedStream(@NonNull JSONObject r10, String r11, String r12, String r13) {
            if (this.isSuccess == false) goto L44;
            return;
        L44:
            String[] r14 = r11.trim().split(" ");     // Catch: Throwable -> L33
            boolean r15 = false;
            String r16 = r14[0];     // Catch: Throwable -> L33
            int r17 = Integer.parseInt(r14[3]);     // Catch: Throwable -> L33
            if (r16.startsWith(r12) == false) goto L28;
            if (r10.has("lifecycle_from_adj") == false) goto L42;
            boolean r18 = r10.optBoolean(Constants.IS_BACKGROUND_ADJ);     // Catch: Throwable -> L33
            if (r17 <= 200) goto L13;
            r15 = true;
        L13:
            StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L33
            String r20 = "b";
            if (r15 == false) goto L17;
            String r21 = "b";
        L18:
            r19.append(r21);     // Catch: Throwable -> L33
            r19.append("_");     // Catch: Throwable -> L33
            if (r18 == true) goto L22;
            r20 = "f";
        L22:
            r19.append(r20);     // Catch: Throwable -> L33
            r10.put("anr_process_lifecycle", r19);     // Catch: Throwable -> L33
            goto L42
        L17:
            r21 = "f";
        L42:
            r10.put("npth_profiler_main_nice", String.valueOf(r14[4]));     // Catch: Throwable -> L36
        L47:
            r10.put("npth_profiler_main_group", r14[2]);     // Catch: Throwable -> L37
        L40:
            r10.put("npth_profiler_process_adj", r14[3]);     // Catch: Throwable -> L38
        L26:
            this.isSuccess = true;     // Catch: Throwable -> L33
            return;
        L28:
            if (r16.startsWith(r13) == false) goto L50;
            if (r17 <= 200) goto L45;
            r15 = true;
        L45:
            r10.put(Constants.IS_BACKGROUND_ADJ, r15);     // Catch: Throwable -> L39
            r10.put("lifecycle_from_adj", 1);     // Catch: Throwable -> L39
            return;
        L52:
            return;
        L50:
            return;
        L33:
            th = move-exception;
            NpthMonitor.reportInnerException("pushLifecycleFilters", th);
        }

        private void pushSystemMemoryToFilters(@NonNull JSONObject r30, String r31) {
            Matcher r10 = Pattern.compile("^ Total (\\d+)MB, Used \\d+\\([+-]\\d+\\)MB, Free \\d+\\([+-]\\d+\\)MB, Swapped (\\d+)\\(([+-])(\\d+)\\)MB$").matcher(r31);
            if (r10.find() == true) goto L5;
            return;
        L5:
            if (r10.groupCount() != 4) goto L10;
            long r11 = Long.parseLong(r10.group(1));
            long r12 = Long.parseLong(r10.group(2));
            String r13 = r10.group(3);
            long r14 = Long.parseLong(r10.group(4));
            JSONUtils.put(r30, "npth_profiler_sysram_total_size", ((r11 / 1024) + 1) + "GB");
            NumRanges r15 = new NumRanges("MB");
            r15.set(new Long[]{0L, 1L, 128L, 256L, 512L, 1024L, 1536L, Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH), 3072L, 4096L});
            JSONUtils.put(r30, "npth_profiler_sysram_swapped_size", r15.get(r12));
            r15.set(new Long[]{0L, 1L, 16L, 32L, 64L, 128L, 256L, 512L});
            JSONUtils.put(r30, "npth_profiler_sysram_swapped_delta", r13 + " " + r15.get(r14));
            return;
        }

        long[] buildPriorParameters(@NonNull JSONObject r10, AnrTraceParser r11, AnrInfoParser r12) {
            long[] r13 = new long[9];
            int r14 = 0;
            r13[0] = r10.optLong("crash_time");
            Pair<Long, Long> r15 = getLongestMsgRange(r10);
            r13[2] = ((Long) r15.first).longValue();
            r13[1] = ((Long) r15.second).longValue();
            if (r12.isValid() == false) goto L8;
            long r16 = 4294967296L;
            AnrInfoParser.CpuUsage r17 = r12.mCloserCpuUsage;
            if (r17 == null) goto L7;
            r16 = 4294967296L | ((long) ((int) r17.mKswapdTotalRatio));
        L7:
            r13[3] = r16;
        L8:
            JSONObject r18 = r10.optJSONObject("app_memory_info");
            long r19 = 0;
            if (r18 != null) goto L11;
        L13:
            long r20 = 0;
        L15:
            if (r20 > 0) goto L17;
        L18:
            r20 = (Runtime.getRuntime().maxMemory() / 1024) / 1024;
        L19:
            r13[4] = r20;
            if (r11.hasMainStack() == true) goto L22;
        L37:
            JSONObject r21 = r10.optJSONObject(CrashBody.LOGCAT_GC_INFO);
            if (r21 == null) goto L40;
            r14 = r21.optInt("gcScore");
        L40:
            r13[8] = r14;
            return r13;
        L22:
            if (r11.isWaitForGc() == false) goto L24;
            long r22 = 2;
        L25:
            long r23 = 1 | r22;
            if (r11.isPerformingGc() == false) goto L28;
            long r24 = 4;
        L29:
            long r25 = r23 | r24;
            if (r11.isLockedByJava() == false) goto L32;
            long r26 = 8;
        L33:
            long r27 = r25 | r26;
            if (r11.isLockedByNative() == false) goto L36;
            r19 = 16;
        L36:
            r13[5] = r27 | r19;
            r13[6] = r11.getUserTick();
            r13[7] = r11.getSysTick();
            goto L37
        L32:
            r26 = 0;
            goto L33
        L28:
            r24 = 0;
            goto L29
        L24:
            r22 = 0;
            goto L25
        L17:
            if (r20 <= 1024) goto L19;
        L11:
            if (r18.has("max_memory") == false) goto L13;
            r20 = (r18.optLong("max_memory") / 1024) / 1024;
            goto L15
        }

        public void pushToCrashBody(@NonNull JSONObject r10, File r11) {
            String r12 = FileSystemUtils.readUtf8File(new File(r11, "anr_ml_features.json"));
            if (r12 == null) goto L18;
            JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Throwable -> L14
        L18:
            String r13 = FileUtils.readFile(new File(r11, "/anr_profiler.txt"));     // Catch: Throwable -> L15
            JSONUtils.put(r10, "anr_profiler", r13);     // Catch: Throwable -> L15
            if (r13.isEmpty() == false) goto L8;
            return;
        L8:
            if (r13.length() <= 10) goto L21;
            JSONObject r14 = r10.optJSONObject("filters");     // Catch: Throwable -> L15
            if (r14 != null) goto L12;
            r14 = new JSONObject();     // Catch: Throwable -> L15
            r10.put("filters", r14);     // Catch: Throwable -> L15
        L12:
            JSONUtils.put(r14, "has_anr_profiler", "true");     // Catch: Throwable -> L15
            return;
        L21:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void pushToFilters(@NonNull JSONObject r12) {
            File r10 = new File(this.mDirectory + AnrProfiler.FILE_NAME + ".txt");
            if (r10.exists() == true) goto L5;
            return;
        L5:
            BufferedReader r11 = null;
            String r13 = null;
            BufferedReader r14 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L85
            Object[] r15 = false;
            String r16 = null;
        L90:
            String r17 = r14.readLine();     // Catch: Throwable -> L80
            if (r17 == null) goto L79;
            String[] r18 = r17.split(">");     // Catch: Throwable -> L80
            byte r19 = 2;
            if (r18.length != 2) goto L12;
            String r20 = r18[0].trim();     // Catch: Throwable -> L80
            switch(r20.hashCode()) {
                case -1771995437: goto L56;
                case -1427608066: goto L53;
                case -1276471214: goto L50;
                case -1209385580: goto L47;
                case -892691330: goto L44;
                case -523188726: goto L41;
                case -315273688: goto L38;
                case 1317675854: goto L35;
                case 1367485235: goto L32;
                case 2060837732: goto L29;
                case 2064264317: goto L26;
                case 2066285238: goto L23;
                case 2072399136: goto L20;
                default: goto L58;
            };     // Catch: Throwable -> L83
        L58:
            r19 = -1;
        L59:
            switch(r19) {
                case 0: goto L73;
                case 1: goto L72;
                case 2: goto L71;
                case 3: goto L70;
                case 4: goto L69;
                case 5: goto L68;
                case 6: goto L67;
                case 7: goto L66;
                case 8: goto L64;
                case 9: goto L65;
                case 10: goto L63;
                case 11: goto L62;
                case 12: goto L61;
                default: goto L90;
            };     // Catch: Throwable -> L83
        L61:
            r15 = false;
            goto L90
        L62:
            r15 = true;
            goto L90
        L63:
            pushSystemMemoryToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L64:
            pushAnrReasonToFilters(r12, r18[1]);     // Catch: Throwable -> L83
        L65:
            pushProcessMemoryToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L66:
            pushJvmStateToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L67:
            pushGcStateToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L68:
            pushPageFaultToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L69:
            pushCpuFrequenciesToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L70:
            pushCpuJiffiesToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L71:
            pushCpuSchedToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L72:
            pushCpuLoadsToFilters(r12, r18[1]);     // Catch: Throwable -> L83
            goto L90
        L73:
            Pair r21 = AnrProfiler.access$100(r18[1]);     // Catch: Throwable -> L83
            if (r21 == null) goto L90;
            String r22 = (String) r21.second;     // Catch: Throwable -> L83
            r13 = (String) r21.first;     // Catch: Throwable -> L84
        L78:
            r16 = r22;
            goto L90
        L20:
            if (r20.equals(TAG_CPU_SCHED) == false) goto L58;
        L23:
            if (r20.equals(TAG_CPU_LOADS) == false) goto L58;
            r19 = 1;
            goto L59
        L26:
            if (r20.equals(TAG_CPU_JIFFS) == false) goto L58;
            r19 = 3;
            goto L59
        L29:
            if (r20.equals(TAG_CPU_FREQS) == false) goto L58;
            r19 = 4;
            goto L59
        L32:
            if (r20.equals(TAG_JVM_STATE) == false) goto L58;
            r19 = 7;
            goto L59
        L35:
            if (r20.equals(TAG_GC_STATE) == false) goto L58;
            r19 = 6;
            goto L59
        L38:
            if (r20.equals(SCHED_STREAM) == false) goto L58;
            r19 = 11;
            goto L59
        L41:
            if (r20.equals(TAG_PROC_MEMORY) == false) goto L58;
            r19 = 9;
            goto L59
        L44:
            if (r20.equals(MEMORY_STREAM) == false) goto L58;
            r19 = 12;
            goto L59
        L47:
            if (r20.equals(TAG_DURATION) == false) goto L58;
            r19 = 0;
            goto L59
        L50:
            if (r20.equals(TAG_PAGE_FAULT) == false) goto L58;
            r19 = 5;
            goto L59
        L53:
            if (r20.equals(TAG_ANR_REASON) == false) goto L58;
            r19 = 8;
            goto L59
        L56:
            if (r20.equals(TAG_SYS_MEMORY) == false) goto L58;
            r19 = 10;
            goto L59
        L12:
            if (r15 == false) goto L90;
            pushSchedStream(r12, r17, r13, r16);     // Catch: Throwable -> L80
            goto L90
        L79:
            FileSystemUtils.close(r14);
            return;
        L80:
            r11 = r14;
        L81:
            FileSystemUtils.close(r11);
        }
    }

    public AnrProfiler() {
    }

    static /* synthetic */ long access$002(AnrProfiler r10, long r11) {
        r10.mNativeManager = r11;
        return r11;
    }

    static /* synthetic */ Pair access$100(String r10) {
        return getANRTime(r10);
    }

    private static Pair<String, String> getANRTime(String r10) {
        int r11 = r10.indexOf(40);     // Catch: Exception -> L5
        int r12 = r10.lastIndexOf(41);     // Catch: Exception -> L5
        int r13 = r10.indexOf(TypedValues.TransitionType.S_TO);     // Catch: Exception -> L5
        return new Pair(r10.substring(r11 + 12, r13 - 5), r10.substring(r13 + 14, r12 - 4));
    L5:
        e = move-exception;
        NpthMonitor.reportInnerException("getANRTime", e);
        return null;
    }

    public static synchronized void setMonitorJvm() {
        monitor-enter(AnrProfiler.class);
        Thread r10 = Looper.getMainLooper().getThread();     // Catch: Throwable -> L10
        Field r11 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L10
        r11.setAccessible(true);     // Catch: Throwable -> L10
        int r12 = NativeBridge.nAnrNativeProfilerJvmStart(r11.getLong(r10));     // Catch: Throwable -> L10
        int r13 = NativeBridge.getJvmMonitorState();     // Catch: Throwable -> L10
        int r14 = NativeBridge.getApexVersion();     // Catch: Throwable -> L10
        AppMonitor r15 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L10
        if (r15 == null) goto L7;
        r15.addTag("jvm_monitor_state", String.valueOf(r13));     // Catch: Throwable -> L10
        r15.addTag("apex_version", String.valueOf(r14));     // Catch: Throwable -> L10
    L7:
        NpthLog.d("setMonitorJvm " + r12 + ", " + r13);     // Catch: Throwable -> L10
    L8:
        monitor-exit(AnrProfiler.class);
    }

    public static void startJvmLockMonitor(boolean r10) {
        if (r10 == true) goto L4;
        return;
    L4:
        DefaultWorkThread.post(new AnonymousClass2());
    }

    public void dumpWithNativeInfo(File r10, long r11) {
        long r12 = this.mNativeManager;
        if (r12 == 0) goto L6;
        NativeBridge.nAnrNativeProfilerDump(r12, r10 + FILE_NAME + ".inf", r11);
        return;
    }

    public void exit() {
        long r10 = this.mNativeManager;
        if (r10 == 0) goto L6;
        NativeBridge.nAnrNativeProfilerExit(r10);
        return;
    }

    public void start() {
        DefaultWorkThread.post(new AnonymousClass1(this));
    }

    public void stop() {
        long r10 = this.mNativeManager;
        if (r10 == 0) goto L6;
        NativeBridge.nAnrNativeProfilerStop(r10);
        return;
    }
}
