package com.bytedance.crash.dumper;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import com.loc.o;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
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
            int r1 = this.anrLogStage;
            if (r1 != 0) goto L5;
            return "none";
        L5:
            if (r1 != 1) goto L7;
            return "found";
        L7:
            if (r1 != 2) goto L9;
            return "parsed_log";
        L9:
            if (r1 != 3) goto L11;
            return "dropped";
        L11:
            if (r1 == 4) goto L14;
            return "wrong";
        L14:
            return "parsed_msg";
        }

        void setStage(int r2) {
            if (r2 <= this.anrLogStage) goto L6;
            this.anrLogStage = r2;
            return;
        }

        JSONObject toJson() {
            if (this.cost == 0) goto L13;
            int r0 = this.anrLogStage;
            if (r0 == 2) goto L8;
            if (r0 == 4) goto L8;
            return null;
        L8:
            JSONObject r1 = new JSONObject();
            r1.put("cost", this.cost);     // Catch: JSONException -> L15
            r1.put("longMsgEnd", this.msgEnd);     // Catch: JSONException -> L15
            if (this.anrLogStage != 4) goto L12;
            r1.put("when", this.when);     // Catch: JSONException -> L15
            r1.put("what", this.what);     // Catch: JSONException -> L15
            r1.put(TypedValues.AttributesType.S_TARGET, this.target);     // Catch: JSONException -> L15
            JSONUtils.put(r1, this.lastKey, this.lastValue);     // Catch: JSONException -> L15
        L12:
            return r1;
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

        LogcatGcInfo(long r4) {
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
            this.duration = r4;
        }

        long calLogcatGcScore() {
            long r0 = this.duration;
            if (r0 != 0) goto L5;
            return 0;
        L5:
            long r2 = ((this.mainPerform + this.mainWait) * 100) / r0;
            long r6 = (this.blockGcCost * 100) / r0;
            long r4 = (this.gcCost * 25) / r0;
            this.logcatGcScore = r2;
            if (r2 > 30) goto L9;
            this.logcatGcScore = r2 + r6;
        L9:
            if (r6 > 30) goto L12;
            this.logcatGcScore += r4;
        L12:
            if (this.logcatGcScore <= 500) goto L15;
            this.logcatGcScore = 500;
        L15:
            return this.logcatGcScore;
        }

        String getLongestGcCause() {
            String r0 = this.blockGcCause;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Iterator<Map.Entry<String, Long>> r1 = this.blockGcCauseMap.entrySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (((Long) ZeusTransformUtils.preCheckCast(r2.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue() <= this.blockGcCauseCost) goto L7;
            this.blockGcCauseCost = ((Long) ZeusTransformUtils.preCheckCast(r2.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue();
            this.blockGcCause = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
            goto L7
        L12:
            return this.blockGcCause;
        }

        void recordGcCause(String r4, long r5) {
            Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.blockGcCauseMap.get(r4), Long.class, "com.obric.memorydata.plugin");
            Map<String, Long> r3 = this.blockGcCauseMap;
            if (r0 != null) goto L5;
            Long r6 = Long.valueOf(r5);
        L6:
            r3.put(r4, r6);
            return;
        L5:
            r6 = Long.valueOf(r0.longValue() + r5);
            goto L6
        }

        JSONObject toJson() {
            if (this.gcCount != 0) goto L5;
            return null;
        L5:
            if (this.mainWait == 0) goto L15;
            JSONObject r0 = new JSONObject();
            r0.put("blockGcCost", this.blockGcCost);     // Catch: JSONException -> L12
            r0.put("blockGcCount", this.blockGcCount);     // Catch: JSONException -> L12
            r0.put("gcCount", this.gcCount);     // Catch: JSONException -> L12
            r0.put("gcCost", this.gcCost);     // Catch: JSONException -> L12
            r0.put("mainWaitCount", this.mainWaitCount);     // Catch: JSONException -> L12
            r0.put("mainWait", this.mainWait);     // Catch: JSONException -> L12
            r0.put("mainPerformCount", this.mainPerformCount);     // Catch: JSONException -> L12
            r0.put("mainPerform", this.mainPerform);     // Catch: JSONException -> L12
            r0.put("blockGcCause", getLongestGcCause());     // Catch: JSONException -> L12
            r0.put("blockGcCauseCost", this.blockGcCauseCost);     // Catch: JSONException -> L12
            r0.put("gcScore", calLogcatGcScore());     // Catch: JSONException -> L12
        L9:
            return r0;
        L15:
            return null;
        }
    }

    public Logcat() {
    }

    private static String getCostRange(long r4) {
        NumRanges r0 = new NumRanges("ms");
        r0.set(new Long[]{0L, 1000L, 2000L, 3000L, 5000L, 7000L, 10000L});
        return r0.get(r4);
    }

    private static String getCountRange(int r4) {
        NumRanges r0 = new NumRanges("");
        r0.set(new Long[]{0L, 1L, 5L, 10L, 20L});
        return r0.get(r4);
    }

    private static int getLogContentType(String r1) {
        if (r1.contains("ANR_LOG") == false) goto L7;
        return 0;
    L7:
        if (r1.contains("GC freed") == false) goto L11;
        return 1;
    L11:
        if (r1.contains("WaitForGcToComplete blocked") == false) goto L14;
        return 2;
    L14:
        return -1;
    }

    private static long getTimeStampFromLog(long r2, String r4) {
        Date r3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Object[]{new Date(r2)}) + "-" + r4.substring(0, 18));     // Catch: Throwable -> L5
    L6:
        if (r3 != null) goto L12;
        return -1;
    L12:
        return r3.getTime();
    L5:
        r3 = null;
        goto L6
    }

    public static boolean isLogcatExists(File r4) {
        File r0 = new File(r4, FILE_NAME);     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L5;
        return false;
    L5:
        if (r0.isDirectory() == true) goto L16;
        if (r0.length() < 50) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L18:
        return true;
    }

    public static void npthDump(File r1, boolean r2) {
        NativeBridge.dumpLogcat(r1.getAbsolutePath(), 1, r2);     // Catch: Throwable -> L4
        return;
    }

    private static void parseAnrLog(AnrLogInfo r16, long r17, long r19, String r21) {
        if (r21.contains("Blocked msg") == true) goto L5;
        return;
    L5:
        r16.setStage(1);
        Matcher r1 = Pattern.compile(".*?Blocked msg = (\\{.*?\\}) , cost\\s+=\\s+(\\d+)\\s+ms").matcher(r21);     // Catch: Throwable -> L20
        if (r1.find() == false) goto L24;
        r16.setStage(2);     // Catch: Throwable -> L20
        String r10 = r1.group(1);     // Catch: Throwable -> L20
        long r11 = Integer.parseInt(r1.group(2));     // Catch: Throwable -> L20
        long r13 = -1;
        int r15 = -1;
        if (shouldDropCurrentLog(r16, r17, r19, r11) == false) goto L12;
        r16.setStage(3);     // Catch: Throwable -> L20
        return;
    L12:
        r16.msgEnd = r19;     // Catch: Throwable -> L20
        r16.cost = r11;     // Catch: Throwable -> L20
        r16.clearMsgInfo();     // Catch: Throwable -> L20
        String r2 = null;
        if (r10 == null) goto L17;
        Matcher r3 = Pattern.compile(".*?when=(\\S+)\\s+what=(\\d+)\\s+target=(\\S+)\\s+(.*?)=(.*?)\\}$").matcher(r10);     // Catch: Throwable -> L20
        if (r3.find() == false) goto L17;
        r13 = parseSpecialTimeFormat(r3.group(1));     // Catch: Throwable -> L20
        r15 = Integer.parseInt(r3.group(2));     // Catch: Throwable -> L20
        r2 = r3.group(3);     // Catch: Throwable -> L20
        String r4 = r3.group(4);     // Catch: Throwable -> L20
        String r5 = r3.group(5);     // Catch: Throwable -> L20
        r16.setStage(4);     // Catch: Throwable -> L20
    L18:
        r16.when = r13;     // Catch: Throwable -> L20
        r16.what = r15;     // Catch: Throwable -> L20
        r16.target = r2;     // Catch: Throwable -> L20
        r16.lastKey = r4;     // Catch: Throwable -> L20
        r16.lastValue = r5;     // Catch: Throwable -> L20
        return;
    L17:
        r5 = null;
        r4 = null;
        goto L18
    L24:
        return;
    L20:
        th = move-exception;
        NpthMonitor.reportInnerException("parseAnrLogException", th);
    }

    private static void parseGcLog(LogcatGcInfo r2, long r3, int r5, long r6, long r8, long r10, String r12) {
        if (r6 <= (5000 + r3)) goto L5;
        return;
    L5:
        if (r6 >= (r3 - 30000)) goto L8;
        return;
    L8:
        if (r5 != 1) goto L17;
        r2.gcCount++;
        Matcher r7 = Pattern.compile("(\\S+)\\s+.*?GC freed.*?paused \\S+ total (\\S+)").matcher(r12);
        if (r7.find() == false) goto L25;
        String r9 = r7.group(1);
        float r4 = parseRegularTimeFormat(r7.group(2));
        r2.gcCost = (long) (r2.gcCost + r4);
        if ("Background".equals(r9) == true) goto L15;
        r2.blockGcCost = (long) (r2.blockGcCost + r4);
        r2.blockGcCount++;
    L15:
        if (r8 != r10) goto L26;
        r2.mainPerform = (long) (r2.mainPerform + r4);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if (r5 != 2) goto L28;
        Matcher r11 = Pattern.compile("WaitForGcToComplete blocked \\S+ on (\\S+) for (\\S+)").matcher(r12);
        if (r11.find() == false) goto L29;
        String r13 = r11.group(1);
        long r14 = (long) parseRegularTimeFormat(r11.group(2));
        r2.recordGcCause(r13, r14);
        if (r8 != r10) goto L30;
        r2.mainWait++;
        r2.mainWait += r14;
        return;
    L30:
        return;
    L29:
        return;
    }

    private static float parseRegularTimeFormat(String r9) {
        if (r9 != null) goto L5;
    L53:
        return 0.0f;
    L5:
        if (r9.length() < 2) goto L53;
        byte r1 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r9.length()) goto L16;
        if (Character.isDigit(r9.charAt(r3)) == true) goto L15;
        if (r9.charAt(r3) == '.') goto L15;
    L17:
        if (r3 != (-1)) goto L55;
        return 0.0f;
    L55:
        String r4 = r9.substring(0, r3);     // Catch: Throwable -> L54
        String r10 = r9.substring(r3);     // Catch: Throwable -> L54
        float r5 = Float.parseFloat(r4);     // Catch: Throwable -> L54
        int r6 = r10.hashCode();     // Catch: Throwable -> L54
        if (r6 == 115) goto L38;
        if (r6 == 3494) goto L35;
        if (r6 == 3525) goto L32;
        if (r6 == 3742) goto L29;
    L40:
        r1 = -1;
    L41:
        if (r1 == 0) goto L52;
        if (r1 == 1) goto L50;
        if (r1 == 2) goto L60;
        if (r1 == 3) goto L48;
        return 0.0f;
    L48:
        return r5 * 1000.0f;
    L60:
        return r5;
    L50:
        return r5 / 1000.0f;
    L52:
        return r5 / 1000000.0f;
    L29:
        if (r10.equals("us") == false) goto L40;
        r1 = 1;
        goto L41
    L32:
        if (r10.equals("ns") == false) goto L40;
    L35:
        if (r10.equals("ms") == false) goto L40;
        r1 = 2;
        goto L41
    L38:
        if (r10.equals("s") == false) goto L40;
        r1 = 3;
    L15:
        r3 = r3 + 1;
        goto L9
    L16:
        r3 = -1;
        goto L17
    }

    private static long parseSpecialTimeFormat(String r10) {
        if (r10 != null) goto L4;
        return -1;
    L4:
        if (r10.isEmpty() == true) goto L64;
        boolean r0 = r10.startsWith("-");
        if (r0 == false) goto L9;
    L10:
        r10 = r10.substring(1);
    L11:
        long r2 = 0;
        Matcher r11 = Pattern.compile("(\\d+)([dhms]+)").matcher(r10);
    L13:
        if (r11.find() == false) goto L44;
        long r4 = Long.parseLong(r11.group(1));
        byte r6 = 2;
        String r7 = r11.group(2);
        r7.hashCode();
        switch(r7.hashCode()) {
            case 100: goto L33;
            case 104: goto L29;
            case 109: goto L26;
            case 115: goto L22;
            case 3494: goto L18;
            default: goto L16;
        };
    L16:
        r6 = -1;
    L36:
        switch(r6) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L43;
            default: goto L13;
        };
    L38:
        long r8 = 1000;
    L42:
        r4 = r4 * r8;
        goto L43
    L39:
        r8 = 60000;
        goto L42
    L40:
        r8 = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        goto L42
    L41:
        r8 = WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
    L43:
        r2 = r2 + r4;
        goto L13
    L18:
        if (r7.equals("ms") == false) goto L58;
        r6 = 4;
        goto L36
    L58:
        r6 = -1;
        goto L36
    L22:
        if (r7.equals("s") == false) goto L59;
        r6 = 3;
        goto L36
    L59:
        r6 = -1;
        goto L36
    L26:
        if (r7.equals("m") == true) goto L36;
        r6 = -1;
        goto L36
    L29:
        if (r7.equals(o.g) == false) goto L61;
        r6 = 1;
        goto L36
    L61:
        r6 = -1;
        goto L36
    L33:
        if (r7.equals("d") == false) goto L62;
        r6 = 0;
        goto L36
    L62:
        r6 = -1;
        goto L36
    L44:
        if (r0 == true) goto L46;
        return r2;
    L46:
        return -r2;
    L9:
        if (r10.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L11;
    L64:
        return -1;
    }

    public static void pushTo(JSONObject r6, File r7) {
        File r0 = new File(r7, FILE_NAME);
        if (r0.exists() == true) goto L5;
    L8:
        npthDump(r7, false);
        r0 = new File(r7, FILE_NAME);
        if (r0.exists() == true) goto L11;
        return;
    L11:
        if (r0.isDirectory() == true) goto L58;
    L13:
        int r8 = (int) r0.length();
        JSONArray r1 = new JSONArray();
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L26
    L42:
        String r4 = r3.readLine();     // Catch: Throwable -> L24
        if (r4 == null) goto L22;
        if (r8 >= 524288) goto L21;
        r1.put(r4);     // Catch: Throwable -> L24
    L21:
        r8 = r8 - (r4.length() + 1);
        goto L42
    L22:
        r3.close();     // Catch: IOException -> L39
    L52:
    L24:
        th = th;
        r2 = r3;
    L48:
        NpthLog.i(th);     // Catch: Throwable -> L34
        if (r2 == null) goto L31;
        r2.close();     // Catch: IOException -> L39
    L34:
        th = move-exception;
        if (r2 != null) goto L50;
    L37:
        throw th;
    L50:
        r2.close();     // Catch: IOException -> L41
    L26:
        th = th;
    L31:
        if (r1.length() == 0) goto L56;
        r6.put(Constants.LOGCAT, r1);     // Catch: JSONException -> L40
        return;
    L57:
        return;
    L56:
        return;
    L58:
        return;
    L5:
        if (r0.isDirectory() == true) goto L8;
        if (r0.length() >= 50) goto L13;
        goto L8
    }

    public static void pushToAnrFeature(JSONObject r24) {
        JSONArray r2 = r24.optJSONArray(Constants.LOGCAT);
        JSONObject r3 = r24.optJSONObject("filters");
        long r14 = r24.optLong("crash_time");
        int r12 = r24.optInt(CrashBody.PID);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.length() == 0) goto L73;
        if (r3 == null) goto L74;
        LogcatGcInfo r13 = new LogcatGcInfo(30000);
        AnrLogInfo r16 = new AnrLogInfo();
        int r10 = 1;
        int r11 = r2.length() - 1;
    L9:
        if (r11 <= 0) goto L48;
        String r0 = r2.getString(r11);     // Catch: Exception -> L44
        if (TextUtils.isEmpty(r0) == false) goto L13;
    L12:
        int r23 = r10;
        int r18 = r11;
        int r21 = r12;
        LogcatGcInfo r22 = r13;
        long r19 = r14;
    L47:
        r11 = r18 - 1;
        r14 = r19;
        r12 = r21;
        r13 = r22;
        r10 = r23;
        goto L9
    L13:
        long r8 = getTimeStampFromLog(r14, r0);     // Catch: Exception -> L44
        String r1 = r0.substring(19);     // Catch: Exception -> L44
        int r7 = getLogContentType(r1);     // Catch: Exception -> L44
        if (r7 == (-1)) goto L12;
        Matcher r4 = Pattern.compile("(\\d+)\\s+(\\d+) \\S\\s+[\\s\\S]*:([\\s\\S]*)").matcher(r1);     // Catch: Exception -> L44
        if (r4.find() == false) goto L12;
        String r6 = r4.group(r10);     // Catch: Exception -> L44
        String r15 = r4.group(2);     // Catch: Exception -> L42
        String r5 = r4.group(3);     // Catch: Exception -> L42
        if (r6 == null) goto L23;
        long r25 = Long.parseLong(r6);     // Catch: Exception -> L42
    L24:
        if (r15 == null) goto L26;
        long r110 = Long.parseLong(r15);     // Catch: Exception -> L42
        long r9 = 0;
    L28:
        if (r25 != r9) goto L30;
    L41:
        r18 = r11;
        r21 = r12;
        r22 = r13;
        r19 = r14;
        r23 = 1;
        goto L47
    L30:
        if (r12 != r25) goto L41;
        if (r5 == null) goto L41;
        if (r7 != 0) goto L36;
        parseAnrLog(r16, r14, r8, r5);     // Catch: Exception -> L42
        goto L41
    L36:
        r18 = r11;
        r23 = 1;
        long r17 = r25;
        r21 = r12;
        r22 = r13;
        long r111 = r110;
        r19 = r14;
        parseGcLog(r13, r14, r7, r8, r17, r111, r5);     // Catch: Exception -> L39
    L39:
        e = e;
    L46:
        NpthLog.e(new RuntimeException(e));
        goto L47
    L26:
        r9 = 0;
        r110 = 0;
        goto L28
    L23:
        r25 = 0;
    L42:
        e = e;
        r18 = r11;
        r21 = r12;
        r22 = r13;
        r19 = r14;
        r23 = 1;
    L44:
        e = e;
        r23 = r10;
        r18 = r11;
        r21 = r12;
        r22 = r13;
        r19 = r14;
        goto L46
    L48:
        LogcatGcInfo r26 = r13;
        long r20 = 0;
        JSONUtils.put(r24, CrashBody.LOGCAT_GC_INFO, r26.toJson());     // Catch: Throwable -> L58
        if (r26.blockGcCause == null) goto L56;
        r3.put("logcat_gc_cause", r26.blockGcCause);     // Catch: Throwable -> L58
        r3.put("logcat_gc_cause_cost", getCostRange(r26.blockGcCauseCost));     // Catch: Throwable -> L58
        r3.put("logcat_gc_count_range", getCountRange(r26.blockGcCount));     // Catch: Throwable -> L58
        r3.put("logcat_gc_total_cost_range", getCostRange(r26.blockGcCost));     // Catch: Throwable -> L58
        if (r26.blockGcCount == 0) goto L55;
        r20 = r26.blockGcCost / ((long) r26.blockGcCount);     // Catch: Throwable -> L58
    L55:
        r3.put("logcat_gc_avg_cost_range", getCostRange(r20));     // Catch: Throwable -> L58
    L56:
        JSONUtils.put(r24, CrashBody.LOGCAT_ANR_INFO, r16.toJson());     // Catch: Throwable -> L58
        JSONUtils.put(r3, "anr_log_tag", r16.getAnrLogTag());     // Catch: Throwable -> L58
        return;
    L75:
        return;
    L74:
        return;
    }

    private static boolean shouldDropCurrentLog(AnrLogInfo r6, long r7, long r9, long r11) {
        long r0 = r7 - 20000;
        long r8 = r7 - 10000;
        if (r9 >= r0) goto L5;
        return true;
    L5:
        long r2 = r6.cost;
        if (r2 > 0) goto L13;
        if (r11 >= 2000) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (r11 > r2) goto L15;
        return true;
    L15:
        if (r9 >= r8) goto L18;
        return true;
    L18:
        return false;
    }
}
