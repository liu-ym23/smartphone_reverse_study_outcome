package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Stack {
    private static final String CAUSE_CAPTION = "Caused by: ";
    public static final String DIED_PROCESS_STACK = "DiedProcess.unknownReason: App was killed, please see logcat.\n";
    private static final StackTraceElement EMPTY = null;
    private static final int END_STACK_COUNT = 128;
    private static final int MAX_STACK_COUNT = 256;
    public static final String NO_STACK = "InvalidStack.NoStackAvailable: Not OOM.\n";
    public static final String NO_STACK_ANR = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    public static final String NO_STACK_OOM = "InvalidStack.NoStackAvailable: Is OOM.\n";
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    public static class StackLines {
        public int end;
        public int start;

        public StackLines(int r2, int r3) {
            this.start = -1;
            this.end = -1;
            this.start = r2;
            this.end = r3;
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put(CommonConsts.APM_INNER_EVENT_COST_START, this.start);     // Catch: Throwable -> L5
            r0.put("end", this.end);     // Catch: Throwable -> L5
        L4:
            return r0;
        }
    }

    static {
        EMPTY = new StackTraceElement("", "", "", 0);
    }

    private Stack() {
    }

    public static JSONObject getAllStackTraces(String r16) {
        Map<Thread, StackTraceElement[]> r5 = Thread.getAllStackTraces();     // Catch: Throwable -> L32
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L32
        if (r5 != null) goto L6;
        return null;
    L6:
        r6.put("thread_all_count", r5.size());     // Catch: Throwable -> L32
        JSONArray r7 = new JSONArray();     // Catch: Throwable -> L32
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r8 = r5.entrySet().iterator();     // Catch: Throwable -> L32
    L8:
        if (r8.hasNext() == false) goto L30;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L32
        Thread r11 = (Thread) ZeusTransformUtils.preCheckCast(r9.getKey(), Thread.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        String r12 = r11.getName();     // Catch: Throwable -> L32
        if (r16 == null) goto L18;
        if (r16.equals(r12) == true) goto L8;
        if (r12.startsWith(r16) == true) goto L8;
        if (r12.endsWith(r16) == true) goto L8;
    L18:
        r10.put(LBSLightLocationTraceLogger.THREAD_NAME, r11.getName() + "(" + r11.getId() + ")");     // Catch: Throwable -> L32
        StackTraceElement[] r13 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r9.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r13 == null) goto L27;
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L32
        int r15 = r13.length;     // Catch: Throwable -> L32
        int r17 = 0;
    L21:
        if (r17 >= r15) goto L23;
        StackTraceElement r18 = r13[r17];     // Catch: Throwable -> L32
        r14.put(r18.getClassName() + "." + r18.getMethodName() + "(" + r18.getLineNumber() + ")");     // Catch: Throwable -> L32
        r17 = r17 + 1;     // Catch: Throwable -> L32
        goto L21
    L23:
        r10.put("thread_stack", r14);     // Catch: Throwable -> L32
        if (r14.length() > 0) goto L27;
        boolean r19 = false;
    L28:
        if (r19 == false) goto L8;
        r7.put(r10);     // Catch: Throwable -> L32
    L27:
        r19 = true;
        goto L28
    L30:
        r6.put("thread_stacks", r7);     // Catch: Throwable -> L32
        return r6;
    L32:
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String getExceptionStack(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        printStackTrace(r2, r1);     // Catch: Throwable -> L6
        String r3 = r0.toString();     // Catch: Throwable -> L6
        r1.close();
        return r3;
    L7:
        r1.close();
        return "";
    }

    public static String getExceptionStackStart(Throwable r2, int r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        StackTraceElement[] r0 = r2.getStackTrace();
        return getExceptionStackStartEnd(r2, r0, r3, r0.length);
    }

    private static String getExceptionStackStartEnd(Throwable r1, StackTraceElement[] r2, int r3, int r4) {
        if (r3 >= 0) goto L4;
        return null;
    L4:
        if (r3 >= r2.length) goto L13;
        if (r4 > r3) goto L7;
        return null;
    L7:
        if (r4 > r2.length) goto L15;
        r1.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r2, r3, r4), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        String r5 = getExceptionStack(r1);
        r1.setStackTrace(r2);
        return r5;
    L15:
        return null;
    L13:
        return null;
    }

    public static StackTraceElement[] getExceptionTraceElement(Throwable r2) {
        ArrayList r0 = new ArrayList();
        printStackTrace(r2, r0);     // Catch: Throwable -> L6
    L5:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.toArray(new StackTraceElement[r0.size()]), StackTraceElement[].class, "com.obric.memorydata.plugin");
    }

    public static JSONArray getMatchLines(StackTraceElement[] r5, String r6) {
        StackLines r0 = new StackLines(-1, -1);
        JSONArray r2 = new JSONArray();
        int r3 = 0;
    L4:
        if (r3 >= r5.length) goto L15;
        if (r0.start != (-1)) goto L11;
        if (r5[r3].getClassName().contains(r6) == false) goto L13;
        r0.start = r3;
        r0.end = r3;
    L13:
        r3 = r3 + 1;
        goto L4
    L11:
        if (r5[r3].getClassName().contains(r6) == true) goto L13;
        r0.end = r3;
        r2.put(r0.toJson());
        r0 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r0.start == (-1)) goto L17;
        r0.end = r5.length;
        r2.put(r0.toJson());
    L17:
        return r2;
    }

    public static JSONArray getMatchLines(StackTraceElement[] r5, String[] r6) {
        StackLines r0 = new StackLines(-1, -1);
        JSONArray r2 = new JSONArray();
        int r3 = 0;
    L4:
        if (r3 >= r5.length) goto L15;
        if (r0.start != (-1)) goto L11;
        if (stringContains(r5[r3].getClassName(), r6) == false) goto L13;
        r0.start = r3;
        r0.end = r3;
    L13:
        r3 = r3 + 1;
        goto L4
    L11:
        if (stringContains(r5[r3].getClassName(), r6) == true) goto L13;
        r0.end = r3;
        r2.put(r0.toJson());
        r0 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r0.start == (-1)) goto L17;
        r0.end = r5.length;
        r2.put(r0.toJson());
    L17:
        return r2;
    }

    public static JSONArray getMatchLines(String[] r5, String r6) {
        StackLines r0 = new StackLines(-1, -1);
        JSONArray r2 = new JSONArray();
        int r3 = 0;
    L4:
        if (r3 >= r5.length) goto L15;
        if (r0.start != (-1)) goto L11;
        if (r5[r3].contains(r6) == false) goto L13;
        r0.start = r3;
        r0.end = r3;
    L13:
        r3 = r3 + 1;
        goto L4
    L11:
        if (r5[r3].contains(r6) == true) goto L13;
        r0.end = r3;
        r2.put(r0.toJson());
        r0 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r0.start == (-1)) goto L17;
        r0.end = r5.length;
        r2.put(r0.toJson());
    L17:
        return r2;
    }

    public static String getStackInfo(StackTraceElement[] r4) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        getStackTraceElementInfo(r4[r2], r0);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static String getStackTraceElementInfo(StackTraceElement r1) {
        return getStackTraceElementInfo(r1, new StringBuilder()).toString();
    }

    public static StringBuilder getStackTraceElementInfo(StackTraceElement r2, StringBuilder r3) {
        String r0 = r2.getClassName();
        r3.append("  at ").append(r0).append(".").append(r2.getMethodName()).append("(").append(r2.getFileName()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r2.getLineNumber()).append(")\n");
        return r3;
    }

    private static void printEnclosedStackTrace(Throwable r18, PrintWriter r19, StackTraceElement[] r20, String r21, String r22, Set<Throwable> r23, int r24) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.memorydata.plugin");
        if (r11.contains(r18) == false) goto L5;
        r19.println("\t[CIRCULAR REFERENCE:" + r18 + "]");
        return;
    L5:
        r11.add(r18);
        StackTraceElement[] r12 = r18.getStackTrace();
        if (r12.length <= r24) goto L8;
        boolean r1 = true;
    L9:
        r19.println(r22 + r21 + r18);
        int r3 = r12.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= r3) goto L17;
        StackTraceElement r7 = r12[r4];
        if (r1 == false) goto L16;
        if (r5 <= r24) goto L16;
        r19.println("\t... skip " + ((r12.length - r5) - (r24 / 2)) + " lines");
    L16:
        r19.println("\tat " + r7);
        r5 = r5 + 1;
        r4 = r4 + 1;
    L17:
        if (r1 == false) goto L23;
        int r2 = r12.length - (r24 / 2);
    L20:
        if (r2 >= r12.length) goto L23;
        r19.println("\tat " + r12[r2]);
        r2 = r2 + 1;
    L23:
        if (Build.VERSION.SDK_INT < 19) goto L31;
        Throwable[] r14 = r18.getSuppressed();
        int r15 = r14.length;
        int r8 = 0;
    L25:
        if (r8 >= r15) goto L31;
        Throwable r6 = r14[r8];
        String r9 = r22 + "\t";
        int r10 = r24 / 2;
        if (r10 <= 10) goto L29;
        int r16 = r10;
    L30:
        printEnclosedStackTrace(r6, r19, r12, SUPPRESSED_CAPTION, r9, r11, r16);
        r8 = r8 + 1;
        goto L25
    L29:
        r16 = 10;
    L31:
        Throwable r0 = r18.getCause();
        if (r0 == null) goto L48;
        int r13 = r24 / 2;
        if (r13 <= 10) goto L36;
        int r17 = r13;
    L37:
        printEnclosedStackTrace(r0, r19, r12, CAUSE_CAPTION, r22, r11, r17);
        return;
    L36:
        r17 = 10;
        goto L37
    L48:
        return;
    L8:
        r1 = false;
        goto L9
    }

    private static void printEnclosedStackTrace(Throwable r17, List<StackTraceElement> r18, StackTraceElement[] r19, String r20, String r21, Set<Throwable> r22, int r23) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r22, Set.class, "com.obric.memorydata.plugin");
        if (r3.contains(r17) == false) goto L5;
        r2.add(EMPTY);
        return;
    L5:
        r3.add(r17);
        StackTraceElement[] r11 = r17.getStackTrace();
        if (r11.length <= r23) goto L8;
        boolean r4 = true;
    L9:
        r2.add(EMPTY);
        int r6 = r11.length;
        int r7 = 0;
        int r8 = 0;
    L10:
        if (r7 >= r6) goto L16;
        StackTraceElement r9 = r11[r7];
        if (r4 == false) goto L15;
        if (r8 <= r23) goto L15;
        r2.add(EMPTY);
    L15:
        r2.add(r9);
        r8 = r8 + 1;
        r7 = r7 + 1;
    L16:
        if (r4 == false) goto L22;
        int r5 = r11.length - (r23 / 2);
    L19:
        if (r5 >= r11.length) goto L22;
        r2.add(r11[r5]);
        r5 = r5 + 1;
    L22:
        if (Build.VERSION.SDK_INT < 19) goto L30;
        Throwable[] r13 = r17.getSuppressed();
        int r14 = r13.length;
        int r15 = 0;
    L24:
        if (r15 >= r14) goto L30;
        Throwable r10 = r13[r15];
        String r12 = r21 + "\t";
        int r16 = r23 / 2;
        if (r16 <= 10) goto L28;
        int r110 = r16;
    L29:
        printEnclosedStackTrace(r10, r2, r11, SUPPRESSED_CAPTION, r12, r3, r110);
        r15 = r15 + 1;
        goto L24
    L28:
        r110 = 10;
    L30:
        Throwable r24 = r17.getCause();
        if (r24 == null) goto L47;
        int r0 = r23 / 2;
        if (r0 <= 10) goto L35;
        int r111 = r0;
    L36:
        printEnclosedStackTrace(r24, r2, r11, CAUSE_CAPTION, r21, r3, r111);
        return;
    L35:
        r111 = 10;
        goto L36
    L47:
        return;
    L8:
        r4 = false;
        goto L9
    }

    private static void printStackTrace(Throwable r12, PrintWriter r13) {
        if (r12 == null) goto L38;
        if (r13 == null) goto L40;
        Set r0 = Collections.newSetFromMap(new IdentityHashMap());
        r0.add(r12);
        r13.println(r12);
        StackTraceElement[] r8 = r12.getStackTrace();
        if (r8.length <= 384) goto L8;
        boolean r1 = true;
    L9:
        int r2 = r8.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= r2) goto L18;
        StackTraceElement r7 = r8[r4];
        if (r1 == false) goto L17;
        if (r5 <= 256) goto L17;
        r13.println("\t... skip " + ((r8.length - r5) - 128) + " lines");
    L17:
        r13.println("\tat " + r7);
        r5 = r5 + 1;
        r4 = r4 + 1;
    L18:
        if (r1 == false) goto L24;
        int r3 = r8.length - 128;
    L21:
        if (r3 >= r8.length) goto L24;
        r13.println("\tat " + r8[r3]);
        r3 = r3 + 1;
    L24:
        if (Build.VERSION.SDK_INT < 19) goto L28;
        Throwable[] r9 = r12.getSuppressed();
        int r10 = r9.length;
        int r11 = 0;
    L26:
        if (r11 >= r10) goto L28;
        printEnclosedStackTrace(r9[r11], r13, r8, SUPPRESSED_CAPTION, "\t", r0, 128);
        r11 = r11 + 1;
    L28:
        Throwable r6 = r12.getCause();
        if (r6 == null) goto L39;
        printEnclosedStackTrace(r6, r13, r8, CAUSE_CAPTION, "", r0, 128);
        return;
    L39:
        return;
    L8:
        r1 = false;
        goto L9
    L40:
        return;
    }

    private static void printStackTrace(Throwable r12, List<StackTraceElement> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L38;
        if (r14 == null) goto L40;
        Set r7 = Collections.newSetFromMap(new IdentityHashMap());
        r7.add(r12);
        r14.add(EMPTY);
        StackTraceElement[] r8 = r12.getStackTrace();
        if (r8.length <= 384) goto L9;
        boolean r0 = true;
    L10:
        int r1 = r8.length;
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r3 >= r1) goto L18;
        StackTraceElement r5 = r8[r3];
        if (r0 == false) goto L17;
        if (r4 <= 256) goto L17;
        r14.add(EMPTY);
    L17:
        r14.add(r5);
        r4 = r4 + 1;
        r3 = r3 + 1;
    L18:
        if (r0 == false) goto L24;
        int r2 = r8.length - 128;
    L21:
        if (r2 >= r8.length) goto L24;
        r14.add(r8[r2]);
        r2 = r2 + 1;
    L24:
        if (Build.VERSION.SDK_INT < 19) goto L28;
        Throwable[] r9 = r12.getSuppressed();
        int r10 = r9.length;
        int r11 = 0;
    L26:
        if (r11 >= r10) goto L28;
        printEnclosedStackTrace(r9[r11], r14, r8, SUPPRESSED_CAPTION, "\t", r7, 128);
        r11 = r11 + 1;
    L28:
        Throwable r6 = r12.getCause();
        if (r6 == null) goto L39;
        printEnclosedStackTrace(r6, r14, r8, CAUSE_CAPTION, "", r7, 128);
        return;
    L39:
        return;
    L9:
        r0 = false;
        goto L10
    L40:
        return;
    }

    public static boolean stringContains(String r4, String[] r5) {
        if (r5 != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        int r1 = r5.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (r4.contains(r5[r2]) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }
}
