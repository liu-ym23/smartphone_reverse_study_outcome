package com.bytedance.crash.dumper;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Logcat {
    private static final String FILE_NAME = "logcat.txt";
    private static final int LOG_TYPE_ANR = 0;
    private static final int LOG_TYPE_FINISH_GC = 1;
    private static final int LOG_TYPE_IGNORE = -1;
    private static final int LOG_TYPE_WAIT_GC = 2;
    private static final int MAX_SIZE = 524288;
    private static final int TIME_STAMP_POS_END = 18;

    static class AnrLogInfo {
        private static final int STAGE_DROPPED = 3;
        private static final int STAGE_FOUND = 1;
        private static final int STAGE_NONE = 0;
        private static final int STAGE_PARSED_LOG = 2;
        private static final int STAGE_PARSED_MSG = 4;
        int anrLogStage;
        long cost;
        String lastKey;
        String lastValue;
        long msgEnd;
        String target;
        long what;
        long when;

        AnrLogInfo() {
            this.cost = 0;
            this.msgEnd = 0;
            this.anrLogStage = 0;
        }

        void clearMsgInfo() {
            this.when = -1;
            this.what = -1;
            this.target = null;
            this.lastKey = null;
            this.lastValue = null;
        }

        String getAnrLogTag() {
            int r10 = this.anrLogStage;
            if (r10 != 0) goto L5;
            return "none";
        L5:
            if (r10 != 1) goto L7;
            return "found";
        L7:
            if (r10 != 2) goto L9;
            return "parsed_log";
        L9:
            if (r10 != 3) goto L11;
            return "dropped";
        L11:
            if (r10 == 4) goto L14;
            return "wrong";
        L14:
            return "parsed_msg";
        }

        void setStage(int r10) {
            if (r10 <= this.anrLogStage) goto L6;
            this.anrLogStage = r10;
            return;
        }

        JSONObject toJson() {
            if (this.cost == 0) goto L13;
            int r10 = this.anrLogStage;
            if (r10 == 2) goto L8;
            if (r10 == 4) goto L8;
            return null;
        L8:
            JSONObject r11 = new JSONObject();
            r11.put("cost", this.cost);     // Catch: JSONException -> L15
            r11.put("longMsgEnd", this.msgEnd);     // Catch: JSONException -> L15
            if (this.anrLogStage != 4) goto L12;
            r11.put("when", this.when);     // Catch: JSONException -> L15
            r11.put("what", this.what);     // Catch: JSONException -> L15
            r11.put(TypedValues.AttributesType.S_TARGET, this.target);     // Catch: JSONException -> L15
            JSONUtils.put(r11, this.lastKey, this.lastValue);     // Catch: JSONException -> L15
        L12:
            return r11;
        L13:
            return null;
        }
    }

    static class LogcatGcInfo {
        String blockGcCause;
        long blockGcCauseCost;
        Map<String, Long> blockGcCauseMap;
        long blockGcCost;
        int blockGcCount;
        long duration;
        long gcCost;
        int gcCount;
        long logcatGcScore;
        long mainPerform;
        int mainPerformCount;
        long mainWait;
        int mainWaitCount;

        LogcatGcInfo(long r10) {
            this.blockGcCost = 0;
            this.gcCost = 0;
            this.mainWait = 0;
            this.mainPerform = 0;
            this.blockGcCount = 0;
            this.gcCount = 0;
            this.mainWaitCount = 0;
            this.mainPerformCount = 0;
            this.logcatGcScore = 0;
            this.blockGcCause = null;
            this.blockGcCauseCost = 0;
            this.blockGcCauseMap = new HashMap();
            this.duration = r10;
        }

        long calLogcatGcScore() {
            long r10 = this.duration;
            if (r10 != 0) goto L5;
            return 0;
        L5:
            long r11 = ((this.mainPerform + this.mainWait) * 100) / r10;
            long r12 = (this.blockGcCost * 100) / r10;
            long r13 = (this.gcCost * 25) / r10;
            this.logcatGcScore = r11;
            if (r11 > 30) goto L9;
            this.logcatGcScore = r11 + r12;
        L9:
            if (r12 > 30) goto L12;
            this.logcatGcScore += r13;
        L12:
            if (this.logcatGcScore <= 500) goto L15;
            this.logcatGcScore = 500;
        L15:
            return this.logcatGcScore;
        }

        String getLongestGcCause() {
            String r10 = this.blockGcCause;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Iterator<Map.Entry<String, Long>> r11 = this.blockGcCauseMap.entrySet().iterator();
        L7:
            if (r11.hasNext() == false) goto L12;
            Map.Entry<String, Long> r12 = r11.next();
            if (r12.getValue().longValue() <= this.blockGcCauseCost) goto L7;
            this.blockGcCauseCost = r12.getValue().longValue();
            this.blockGcCause = r12.getKey();
            goto L7
        L12:
            return this.blockGcCause;
        }

        void recordGcCause(String r10, long r11) {
            Long r12 = this.blockGcCauseMap.get(r10);
            Map<String, Long> r13 = this.blockGcCauseMap;
            if (r12 != null) goto L5;
            Long r14 = Long.valueOf(r11);
        L6:
            r13.put(r10, r14);
            return;
        L5:
            r14 = Long.valueOf(r12.longValue() + r11);
            goto L6
        }

        JSONObject toJson() {
            if (this.gcCount != 0) goto L5;
            return null;
        L5:
            if (this.mainWait == 0) goto L15;
            JSONObject r10 = new JSONObject();
            r10.put("blockGcCost", this.blockGcCost);     // Catch: JSONException -> L12
            r10.put("blockGcCount", this.blockGcCount);     // Catch: JSONException -> L12
            r10.put("gcCount", this.gcCount);     // Catch: JSONException -> L12
            r10.put("gcCost", this.gcCost);     // Catch: JSONException -> L12
            r10.put("mainWaitCount", this.mainWaitCount);     // Catch: JSONException -> L12
            r10.put("mainWait", this.mainWait);     // Catch: JSONException -> L12
            r10.put("mainPerformCount", this.mainPerformCount);     // Catch: JSONException -> L12
            r10.put("mainPerform", this.mainPerform);     // Catch: JSONException -> L12
            r10.put("blockGcCause", getLongestGcCause());     // Catch: JSONException -> L12
            r10.put("blockGcCauseCost", this.blockGcCauseCost);     // Catch: JSONException -> L12
            r10.put("gcScore", calLogcatGcScore());     // Catch: JSONException -> L12
        L9:
            return r10;
        L15:
            return null;
        }
    }

    public Logcat() {
    }

    private static String getCostRange(long r10) {
        NumRanges r11 = new NumRanges("ms");
        r11.set(new Long[]{0L, 1000L, 2000L, Long.valueOf(WsConstants.EXIT_DELAY_TIME), 5000L, 7000L, Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS)});
        return r11.get(r10);
    }

    private static String getCountRange(int r10) {
        NumRanges r11 = new NumRanges("");
        r11.set(new Long[]{0L, 1L, 5L, 10L, 20L});
        return r11.get(r10);
    }

    private static int getLogContentType(String r10) {
        if (r10.contains("ANR_LOG") == false) goto L7;
        return 0;
    L7:
        if (r10.contains("GC freed") == false) goto L11;
        return 1;
    L11:
        if (r10.contains("WaitForGcToComplete blocked") == false) goto L14;
        return 2;
    L14:
        return -1;
    }

    private static long getTimeStampFromLog(long r10, String r11) {
        String r12 = r11.substring(0, 18);     // Catch: Throwable -> L5
        Date r13 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Object[]{new Date(r10)}) + "-" + r12);     // Catch: Throwable -> L5
    L6:
        if (r13 != null) goto L12;
        return -1;
    L12:
        return r13.getTime();
    L5:
        r13 = null;
        goto L6
    }

    public static boolean isLogcatExists(File r10) {
        File r11 = new File(r10, FILE_NAME);     // Catch: Throwable -> L13
        if (r11.exists() == true) goto L5;
        return false;
    L5:
        if (r11.isDirectory() == true) goto L16;
        if (r11.length() < 50) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L18:
        return true;
    }

    public static void npthDump(File r10, boolean r11) {
        NativeBridge.dumpLogcat(r10.getAbsolutePath(), 1, r11);     // Catch: Throwable -> L4
        return;
    }

    private static void parseAnrLog(AnrLogInfo r16, long r17, long r19, String r21) {
        if (r21.contains("Blocked msg") == true) goto L5;
        return;
    L5:
        r16.setStage(1);
        Matcher r10 = Pattern.compile(".*?Blocked msg = (\\{.*?\\}) , cost\\s+=\\s+(\\d+)\\s+ms").matcher(r21);     // Catch: Throwable -> L20
        if (r10.find() == false) goto L24;
        r16.setStage(2);     // Catch: Throwable -> L20
        String r11 = r10.group(1);     // Catch: Throwable -> L20
        long r12 = Integer.parseInt(r10.group(2));     // Catch: Throwable -> L20
        long r13 = -1;
        int r15 = -1;
        if (shouldDropCurrentLog(r16, r17, r19, r12) == false) goto L12;
        r16.setStage(3);     // Catch: Throwable -> L20
        return;
    L12:
        r16.msgEnd = r19;     // Catch: Throwable -> L20
        r16.cost = r12;     // Catch: Throwable -> L20
        r16.clearMsgInfo();     // Catch: Throwable -> L20
        String r14 = null;
        if (r11 == null) goto L17;
        Matcher r18 = Pattern.compile(".*?when=(\\S+)\\s+what=(\\d+)\\s+target=(\\S+)\\s+(.*?)=(.*?)\\}$").matcher(r11);     // Catch: Throwable -> L20
        if (r18.find() == false) goto L17;
        r13 = parseSpecialTimeFormat(r18.group(1));     // Catch: Throwable -> L20
        r15 = Integer.parseInt(r18.group(2));     // Catch: Throwable -> L20
        r14 = r18.group(3);     // Catch: Throwable -> L20
        String r20 = r18.group(4);     // Catch: Throwable -> L20
        String r22 = r18.group(5);     // Catch: Throwable -> L20
        r16.setStage(4);     // Catch: Throwable -> L20
    L18:
        r16.when = r13;     // Catch: Throwable -> L20
        r16.what = r15;     // Catch: Throwable -> L20
        r16.target = r14;     // Catch: Throwable -> L20
        r16.lastKey = r20;     // Catch: Throwable -> L20
        r16.lastValue = r22;     // Catch: Throwable -> L20
        return;
    L17:
        r22 = null;
        r20 = null;
        goto L18
    L24:
        return;
    L20:
        th = move-exception;
        NpthMonitor.reportInnerException("parseAnrLogException", th);
    }

    private static void parseGcLog(LogcatGcInfo r10, long r11, int r12, long r13, long r14, long r15, String r16) {
        if (r13 <= (5000 + r11)) goto L5;
        return;
    L5:
        if (r13 >= (r11 - WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) goto L8;
        return;
    L8:
        if (r12 != 1) goto L17;
        r10.gcCount++;
        Matcher r17 = Pattern.compile("(\\S+)\\s+.*?GC freed.*?paused \\S+ total (\\S+)").matcher(r16);
        if (r17.find() == false) goto L25;
        String r18 = r17.group(1);
        float r19 = parseRegularTimeFormat(r17.group(2));
        r10.gcCost = (long) (r10.gcCost + r19);
        if ("Background".equals(r18) == true) goto L15;
        r10.blockGcCost = (long) (r10.blockGcCost + r19);
        r10.blockGcCount++;
    L15:
        if (r14 != r15) goto L26;
        r10.mainPerform = (long) (r10.mainPerform + r19);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if (r12 != 2) goto L28;
        Matcher r20 = Pattern.compile("WaitForGcToComplete blocked \\S+ on (\\S+) for (\\S+)").matcher(r16);
        if (r20.find() == false) goto L29;
        String r21 = r20.group(1);
        long r22 = (long) parseRegularTimeFormat(r20.group(2));
        r10.recordGcCause(r21, r22);
        if (r14 != r15) goto L30;
        long r23 = r10.mainWait + 1;
        r10.mainWait = r23;
        r10.mainWait = r23 + r22;
        return;
    L30:
        return;
    L29:
        return;
    }

    private static float parseRegularTimeFormat(String r10) {
        if (r10 != null) goto L5;
    L53:
        return 0.0f;
    L5:
        if (r10.length() < 2) goto L53;
        byte r11 = 0;
        int r12 = 0;
    L9:
        if (r12 >= r10.length()) goto L16;
        if (Character.isDigit(r10.charAt(r12)) == true) goto L15;
        if (r10.charAt(r12) == '.') goto L15;
    L17:
        if (r12 != (-1)) goto L55;
        return 0.0f;
    L55:
        String r13 = r10.substring(0, r12);     // Catch: Throwable -> L54
        String r14 = r10.substring(r12);     // Catch: Throwable -> L54
        float r15 = Float.parseFloat(r13);     // Catch: Throwable -> L54
        int r16 = r14.hashCode();     // Catch: Throwable -> L54
        if (r16 == 115) goto L38;
        if (r16 == 3494) goto L35;
        if (r16 == 3525) goto L32;
        if (r16 == 3742) goto L29;
    L40:
        r11 = -1;
    L41:
        if (r11 == 0) goto L52;
        if (r11 == 1) goto L50;
        if (r11 == 2) goto L60;
        if (r11 == 3) goto L48;
        return 0.0f;
    L48:
        return r15 * 1000.0f;
    L60:
        return r15;
    L50:
        return r15 / 1000.0f;
    L52:
        return r15 / 1000000.0f;
    L29:
        if (r14.equals("us") == false) goto L40;
        r11 = 1;
        goto L41
    L32:
        if (r14.equals("ns") == false) goto L40;
    L35:
        if (r14.equals("ms") == false) goto L40;
        r11 = 2;
        goto L41
    L38:
        if (r14.equals("s") == false) goto L40;
        r11 = 3;
    L15:
        r12 = r12 + 1;
        goto L9
    L16:
        r12 = -1;
        goto L17
    }

    private static long parseSpecialTimeFormat(String r10) {
        if (r10 != null) goto L4;
        return -1;
    L4:
        if (r10.isEmpty() == true) goto L64;
        boolean r11 = r10.startsWith("-");
        if (r11 == false) goto L9;
    L10:
        r10 = r10.substring(1);
    L11:
        long r12 = 0;
        Matcher r13 = Pattern.compile("(\\d+)([dhms]+)").matcher(r10);
    L13:
        if (r13.find() == false) goto L44;
        long r14 = Long.parseLong(r13.group(1));
        byte r15 = 2;
        String r16 = r13.group(2);
        r16.hashCode();
        switch(r16.hashCode()) {
            case 100: goto L33;
            case 104: goto L29;
            case 109: goto L26;
            case 115: goto L22;
            case 3494: goto L18;
            default: goto L16;
        };
    L16:
        r15 = -1;
    L36:
        switch(r15) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L43;
            default: goto L13;
        };
    L38:
        long r17 = 1000;
    L42:
        r14 = r14 * r17;
        goto L43
    L39:
        r17 = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        goto L42
    L40:
        r17 = 3600000;
        goto L42
    L41:
        r17 = 86400000;
    L43:
        r12 = r12 + r14;
        goto L13
    L18:
        if (r16.equals("ms") == false) goto L58;
        r15 = 4;
        goto L36
    L58:
        r15 = -1;
        goto L36
    L22:
        if (r16.equals("s") == false) goto L59;
        r15 = 3;
        goto L36
    L59:
        r15 = -1;
        goto L36
    L26:
        if (r16.equals("m") == true) goto L36;
        r15 = -1;
        goto L36
    L29:
        if (r16.equals("h") == false) goto L61;
        r15 = 1;
        goto L36
    L61:
        r15 = -1;
        goto L36
    L33:
        if (r16.equals("d") == false) goto L62;
        r15 = 0;
        goto L36
    L62:
        r15 = -1;
        goto L36
    L44:
        if (r11 == true) goto L46;
        return r12;
    L46:
        return -r12;
    L9:
        if (r10.startsWith("+") == false) goto L11;
    L64:
        return -1;
    }

    public static void pushTo(JSONObject r10, File r11) {
        File r12 = new File(r11, FILE_NAME);
        if (r12.exists() == true) goto L5;
    L8:
        npthDump(r11, false);
        r12 = new File(r11, FILE_NAME);
        if (r12.exists() == true) goto L11;
        return;
    L11:
        if (r12.isDirectory() == true) goto L58;
    L13:
        int r13 = (int) r12.length();
        JSONArray r14 = new JSONArray();
        BufferedReader r15 = null;
        BufferedReader r16 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L26
    L42:
        String r17 = r16.readLine();     // Catch: Throwable -> L24
        if (r17 == null) goto L22;
        if (r13 >= 524288) goto L21;
        r14.put(r17);     // Catch: Throwable -> L24
    L21:
        r13 = r13 - (r17.length() + 1);
        goto L42
    L22:
        r16.close();     // Catch: IOException -> L39
    L52:
    L24:
        th = th;
        r15 = r16;
    L48:
        NpthLog.i(th);     // Catch: Throwable -> L34
        if (r15 == null) goto L31;
        r15.close();     // Catch: IOException -> L39
    L34:
        th = move-exception;
        if (r15 != null) goto L50;
    L37:
        throw th;
    L50:
        r15.close();     // Catch: IOException -> L41
    L26:
        th = th;
    L31:
        if (r14.length() == 0) goto L56;
        r10.put(Constants.LOGCAT, r14);     // Catch: JSONException -> L40
        return;
    L57:
        return;
    L56:
        return;
    L58:
        return;
    L5:
        if (r12.isDirectory() == true) goto L8;
        if (r12.length() >= 50) goto L13;
        goto L8
    }

    public static void pushToAnrFeature(JSONObject r24) {
        JSONArray r10 = r24.optJSONArray(Constants.LOGCAT);
        JSONObject r11 = r24.optJSONObject("filters");
        long r14 = r24.optLong("crash_time");
        int r12 = r24.optInt("pid");
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() == 0) goto L73;
        if (r11 == null) goto L74;
        LogcatGcInfo r13 = new LogcatGcInfo(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        AnrLogInfo r16 = new AnrLogInfo();
        int r15 = 1;
        int r17 = r10.length() - 1;
    L9:
        if (r17 <= 0) goto L48;
        String r18 = r10.getString(r17);     // Catch: Exception -> L44
        if (TextUtils.isEmpty(r18) == false) goto L13;
    L12:
        int r23 = r15;
        int r19 = r17;
        int r21 = r12;
        LogcatGcInfo r22 = r13;
        long r110 = r14;
    L47:
        r17 = r19 - 1;
        r14 = r110;
        r12 = r21;
        r13 = r22;
        r15 = r23;
        goto L9
    L13:
        long r20 = getTimeStampFromLog(r14, r18);     // Catch: Exception -> L44
        String r25 = r18.substring(19);     // Catch: Exception -> L44
        int r26 = getLogContentType(r25);     // Catch: Exception -> L44
        if (r26 == (-1)) goto L12;
        Matcher r27 = Pattern.compile("(\\d+)\\s+(\\d+) \\S\\s+[\\s\\S]*:([\\s\\S]*)").matcher(r25);     // Catch: Exception -> L44
        if (r27.find() == false) goto L12;
        String r28 = r27.group(r15);     // Catch: Exception -> L44
        String r111 = r27.group(2);     // Catch: Exception -> L42
        String r29 = r27.group(3);     // Catch: Exception -> L42
        if (r28 == null) goto L23;
        long r210 = Long.parseLong(r28);     // Catch: Exception -> L42
    L24:
        if (r111 == null) goto L26;
        long r112 = Long.parseLong(r111);     // Catch: Exception -> L42
        long r30 = 0;
    L28:
        if (r210 != r30) goto L30;
    L41:
        r19 = r17;
        r21 = r12;
        r22 = r13;
        r110 = r14;
        r23 = 1;
        goto L47
    L30:
        if (r12 != r210) goto L41;
        if (r29 == null) goto L41;
        if (r26 != 0) goto L36;
        parseAnrLog(r16, r14, r20, r29);     // Catch: Exception -> L42
        goto L41
    L36:
        r19 = r17;
        r23 = 1;
        long r113 = r210;
        r21 = r12;
        r22 = r13;
        long r114 = r112;
        r110 = r14;
        parseGcLog(r13, r14, r26, r20, r113, r114, r29);     // Catch: Exception -> L39
    L39:
        e = e;
    L46:
        NpthLog.e(new RuntimeException(e));
        goto L47
    L26:
        r30 = 0;
        r112 = 0;
        goto L28
    L23:
        r210 = 0;
    L42:
        e = e;
        r19 = r17;
        r21 = r12;
        r22 = r13;
        r110 = r14;
        r23 = 1;
    L44:
        e = e;
        r23 = r15;
        r19 = r17;
        r21 = r12;
        r22 = r13;
        r110 = r14;
        goto L46
    L48:
        LogcatGcInfo r211 = r13;
        long r31 = 0;
        JSONUtils.put(r24, CrashBody.LOGCAT_GC_INFO, r211.toJson());     // Catch: Throwable -> L58
        String r32 = r211.blockGcCause;     // Catch: Throwable -> L58
        if (r32 == null) goto L56;
        r11.put("logcat_gc_cause", r32);     // Catch: Throwable -> L58
        r11.put("logcat_gc_cause_cost", getCostRange(r211.blockGcCauseCost));     // Catch: Throwable -> L58
        r11.put("logcat_gc_count_range", getCountRange(r211.blockGcCount));     // Catch: Throwable -> L58
        r11.put("logcat_gc_total_cost_range", getCostRange(r211.blockGcCost));     // Catch: Throwable -> L58
        int r33 = r211.blockGcCount;     // Catch: Throwable -> L58
        if (r33 == 0) goto L55;
        r31 = r211.blockGcCost / ((long) r33);     // Catch: Throwable -> L58
    L55:
        r11.put("logcat_gc_avg_cost_range", getCostRange(r31));     // Catch: Throwable -> L58
    L56:
        JSONUtils.put(r24, CrashBody.LOGCAT_ANR_INFO, r16.toJson());     // Catch: Throwable -> L58
        JSONUtils.put(r11, "anr_log_tag", r16.getAnrLogTag());     // Catch: Throwable -> L58
        return;
    L75:
        return;
    L74:
        return;
    }

    private static boolean shouldDropCurrentLog(AnrLogInfo r10, long r11, long r12, long r13) {
        long r14 = r11 - 20000;
        long r15 = r11 - WorkRequest.MIN_BACKOFF_MILLIS;
        if (r12 >= r14) goto L5;
        return true;
    L5:
        long r16 = r10.cost;
        if (r16 > 0) goto L13;
        if (r13 >= 2000) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (r13 > r16) goto L15;
        return true;
    L15:
        if (r12 >= r15) goto L18;
        return true;
    L18:
        return false;
    }
}
