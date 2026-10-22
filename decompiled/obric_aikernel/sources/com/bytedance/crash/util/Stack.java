package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.CommonConsts;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

        public StackLines(int r10, int r11) {
            this.start = -1;
            this.end = -1;
            this.start = r10;
            this.end = r11;
        }

        public JSONObject toJson() {
            JSONObject r10 = new JSONObject();
            r10.put(CommonConsts.APM_INNER_EVENT_COST_START, this.start);     // Catch: Throwable -> L5
            r10.put("end", this.end);     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    static {
        EMPTY = new StackTraceElement("", "", "", 0);
    }

    private Stack() {
    }

    @Nullable
    public static JSONObject getAllStackTraces(String r16) {
        Map<Thread, StackTraceElement[]> r10 = Thread.getAllStackTraces();     // Catch: Throwable -> L32
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L32
        if (r10 != null) goto L6;
        return null;
    L6:
        r11.put("thread_all_count", r10.size());     // Catch: Throwable -> L32
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L32
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r13 = r10.entrySet().iterator();     // Catch: Throwable -> L32
    L8:
        if (r13.hasNext() == false) goto L30;
        Map.Entry<Thread, StackTraceElement[]> r14 = r13.next();     // Catch: Throwable -> L32
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L32
        Thread r17 = r14.getKey();     // Catch: Throwable -> L32
        String r18 = r17.getName();     // Catch: Throwable -> L32
        if (r16 == null) goto L18;
        if (r16.equals(r18) == true) goto L8;
        if (r18.startsWith(r16) == true) goto L8;
        if (r18.endsWith(r16) == true) goto L8;
    L18:
        r15.put("thread_name", r17.getName() + "(" + r17.getId() + ")");     // Catch: Throwable -> L32
        StackTraceElement[] r19 = r14.getValue();     // Catch: Throwable -> L32
        if (r19 == null) goto L27;
        JSONArray r110 = new JSONArray();     // Catch: Throwable -> L32
        int r111 = r19.length;     // Catch: Throwable -> L32
        int r112 = 0;
    L21:
        if (r112 >= r111) goto L23;
        StackTraceElement r113 = r19[r112];     // Catch: Throwable -> L32
        r110.put(r113.getClassName() + "." + r113.getMethodName() + "(" + r113.getLineNumber() + ")");     // Catch: Throwable -> L32
        r112 = r112 + 1;     // Catch: Throwable -> L32
        goto L21
    L23:
        r15.put("thread_stack", r110);     // Catch: Throwable -> L32
        if (r110.length() > 0) goto L27;
        boolean r20 = false;
    L28:
        if (r20 == false) goto L8;
        r12.put(r15);     // Catch: Throwable -> L32
    L27:
        r20 = true;
        goto L28
    L30:
        r11.put("thread_stacks", r12);     // Catch: Throwable -> L32
        return r11;
    L32:
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    @NonNull
    public static String getExceptionStack(@NonNull Throwable r10) {
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        printStackTrace(r10, r12);     // Catch: Throwable -> L6
        String r13 = r11.toString();     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L7:
        r12.close();
        return "";
    }

    public static String getExceptionStackStart(Throwable r10, int r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StackTraceElement[] r12 = r10.getStackTrace();
        return getExceptionStackStartEnd(r10, r12, r11, r12.length);
    }

    private static String getExceptionStackStartEnd(Throwable r10, StackTraceElement[] r11, int r12, int r13) {
        if (r12 >= 0) goto L4;
        return null;
    L4:
        if (r12 >= r11.length) goto L13;
        if (r13 > r12) goto L7;
        return null;
    L7:
        if (r13 > r11.length) goto L15;
        r10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r11, r12, r13));
        String r14 = getExceptionStack(r10);
        r10.setStackTrace(r11);
        return r14;
    L15:
        return null;
    L13:
        return null;
    }

    public static StackTraceElement[] getExceptionTraceElement(@NonNull Throwable r10) {
        ArrayList r11 = new ArrayList();
        printStackTrace(r10, r11);     // Catch: Throwable -> L6
    L5:
        return (StackTraceElement[]) r11.toArray(new StackTraceElement[r11.size()]);
    }

    public static JSONArray getMatchLines(StackTraceElement[] r10, String r11) {
        StackLines r12 = new StackLines(-1, -1);
        JSONArray r13 = new JSONArray();
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L15;
        if (r12.start != (-1)) goto L11;
        if (r10[r14].getClassName().contains(r11) == false) goto L13;
        r12.start = r14;
        r12.end = r14;
    L13:
        r14 = r14 + 1;
        goto L4
    L11:
        if (r10[r14].getClassName().contains(r11) == true) goto L13;
        r12.end = r14;
        r13.put(r12.toJson());
        r12 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r12.start == (-1)) goto L17;
        r12.end = r10.length;
        r13.put(r12.toJson());
    L17:
        return r13;
    }

    public static JSONArray getMatchLines(StackTraceElement[] r10, String[] r11) {
        StackLines r12 = new StackLines(-1, -1);
        JSONArray r13 = new JSONArray();
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L15;
        if (r12.start != (-1)) goto L11;
        if (stringContains(r10[r14].getClassName(), r11) == false) goto L13;
        r12.start = r14;
        r12.end = r14;
    L13:
        r14 = r14 + 1;
        goto L4
    L11:
        if (stringContains(r10[r14].getClassName(), r11) == true) goto L13;
        r12.end = r14;
        r13.put(r12.toJson());
        r12 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r12.start == (-1)) goto L17;
        r12.end = r10.length;
        r13.put(r12.toJson());
    L17:
        return r13;
    }

    public static JSONArray getMatchLines(String[] r10, String r11) {
        StackLines r12 = new StackLines(-1, -1);
        JSONArray r13 = new JSONArray();
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L15;
        if (r12.start != (-1)) goto L11;
        if (r10[r14].contains(r11) == false) goto L13;
        r12.start = r14;
        r12.end = r14;
    L13:
        r14 = r14 + 1;
        goto L4
    L11:
        if (r10[r14].contains(r11) == true) goto L13;
        r12.end = r14;
        r13.put(r12.toJson());
        r12 = new StackLines(-1, -1);
        goto L13
    L15:
        if (r12.start == (-1)) goto L17;
        r12.end = r10.length;
        r13.put(r12.toJson());
    L17:
        return r13;
    }

    public static String getStackInfo(StackTraceElement[] r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        getStackTraceElementInfo(r10[r13], r11);
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static String getStackTraceElementInfo(StackTraceElement r10) {
        return getStackTraceElementInfo(r10, new StringBuilder()).toString();
    }

    public static StringBuilder getStackTraceElementInfo(StackTraceElement r10, StringBuilder r11) {
        String r12 = r10.getClassName();
        r11.append("  at ");
        r11.append(r12);
        r11.append(".");
        r11.append(r10.getMethodName());
        r11.append("(");
        r11.append(r10.getFileName());
        r11.append(":");
        r11.append(r10.getLineNumber());
        r11.append(")\n");
        return r11;
    }

    private static void printEnclosedStackTrace(Throwable r18, PrintWriter r19, StackTraceElement[] r20, String r21, String r22, Set<Throwable> r23, int r24) {
        if (r23.contains(r18) == false) goto L5;
        r19.println("\t[CIRCULAR REFERENCE:" + r18 + "]");
        return;
    L5:
        r23.add(r18);
        StackTraceElement[] r12 = r18.getStackTrace();
        if (r12.length <= r24) goto L8;
        boolean r10 = true;
    L9:
        r19.println(r22 + r21 + r18);
        int r11 = r12.length;
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r13 >= r11) goto L17;
        StackTraceElement r15 = r12[r13];
        if (r10 == false) goto L16;
        if (r14 <= r24) goto L16;
        r19.println("\t... skip " + ((r12.length - r14) - (r24 / 2)) + " lines");
    L16:
        r19.println("\tat " + r15);
        r14 = r14 + 1;
        r13 = r13 + 1;
    L17:
        if (r10 == false) goto L23;
        int r16 = r12.length - (r24 / 2);
    L20:
        if (r16 >= r12.length) goto L23;
        r19.println("\tat " + r12[r16]);
        r16 = r16 + 1;
    L23:
        if (Build.VERSION.SDK_INT < 19) goto L31;
        Throwable[] r17 = r18.getSuppressed();
        int r110 = r17.length;
        int r25 = 0;
    L25:
        if (r25 >= r110) goto L31;
        Throwable r26 = r17[r25];
        String r27 = r22 + "\t";
        int r28 = r24 / 2;
        if (r28 <= 10) goto L29;
        int r111 = r28;
    L30:
        printEnclosedStackTrace(r26, r19, r12, SUPPRESSED_CAPTION, r27, r23, r111);
        r25 = r25 + 1;
        goto L25
    L29:
        r111 = 10;
    L31:
        Throwable r29 = r18.getCause();
        if (r29 == null) goto L48;
        int r30 = r24 / 2;
        if (r30 <= 10) goto L36;
        int r31 = r30;
    L37:
        printEnclosedStackTrace(r29, r19, r12, CAUSE_CAPTION, r22, r23, r31);
        return;
    L36:
        r31 = 10;
        goto L37
    L48:
        return;
    L8:
        r10 = false;
        goto L9
    }

    private static void printEnclosedStackTrace(Throwable r17, List<StackTraceElement> r18, StackTraceElement[] r19, String r20, String r21, Set<Throwable> r22, int r23) {
        if (r22.contains(r17) == false) goto L5;
        r18.add(EMPTY);
        return;
    L5:
        r22.add(r17);
        StackTraceElement[] r11 = r17.getStackTrace();
        if (r11.length <= r23) goto L8;
        boolean r10 = true;
    L9:
        r18.add(EMPTY);
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r13 >= r12) goto L16;
        StackTraceElement r15 = r11[r13];
        if (r10 == false) goto L15;
        if (r14 <= r23) goto L15;
        r18.add(EMPTY);
    L15:
        r18.add(r15);
        r14 = r14 + 1;
        r13 = r13 + 1;
    L16:
        if (r10 == false) goto L22;
        int r16 = r11.length - (r23 / 2);
    L19:
        if (r16 >= r11.length) goto L22;
        r18.add(r11[r16]);
        r16 = r16 + 1;
    L22:
        if (Build.VERSION.SDK_INT < 19) goto L30;
        Throwable[] r110 = r17.getSuppressed();
        int r111 = r110.length;
        int r112 = 0;
    L24:
        if (r112 >= r111) goto L30;
        Throwable r24 = r110[r112];
        String r25 = r21 + "\t";
        int r26 = r23 / 2;
        if (r26 <= 10) goto L28;
        int r113 = r26;
    L29:
        printEnclosedStackTrace(r24, r18, r11, SUPPRESSED_CAPTION, r25, r22, r113);
        r112 = r112 + 1;
        goto L24
    L28:
        r113 = 10;
    L30:
        Throwable r27 = r17.getCause();
        if (r27 == null) goto L47;
        int r28 = r23 / 2;
        if (r28 <= 10) goto L35;
        int r29 = r28;
    L36:
        printEnclosedStackTrace(r27, r18, r11, CAUSE_CAPTION, r21, r22, r29);
        return;
    L35:
        r29 = 10;
        goto L36
    L47:
        return;
    L8:
        r10 = false;
        goto L9
    }

    private static void printStackTrace(Throwable r12, PrintWriter r13) {
        if (r12 == null) goto L38;
        if (r13 == null) goto L40;
        Set r10 = Collections.newSetFromMap(new IdentityHashMap());
        r10.add(r12);
        r13.println(r12);
        StackTraceElement[] r11 = r12.getStackTrace();
        if (r11.length <= 384) goto L8;
        boolean r14 = true;
    L9:
        int r15 = r11.length;
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r16 >= r15) goto L18;
        StackTraceElement r18 = r11[r16];
        if (r14 == false) goto L17;
        if (r17 <= 256) goto L17;
        StringBuilder r19 = new StringBuilder();
        r19.append("\t... skip ");
        r19.append((r11.length - r17) - 128);
        r19.append(" lines");
        r13.println(r19.toString());
    L17:
        r13.println("\tat " + r18);
        r17 = r17 + 1;
        r16 = r16 + 1;
    L18:
        if (r14 == false) goto L24;
        int r20 = r11.length - 128;
    L21:
        if (r20 >= r11.length) goto L24;
        r13.println("\tat " + r11[r20]);
        r20 = r20 + 1;
    L24:
        if (Build.VERSION.SDK_INT < 19) goto L28;
        Throwable[] r21 = r12.getSuppressed();
        int r110 = r21.length;
        int r111 = 0;
    L26:
        if (r111 >= r110) goto L28;
        printEnclosedStackTrace(r21[r111], r13, r11, SUPPRESSED_CAPTION, "\t", r10, 128);
        r111 = r111 + 1;
    L28:
        Throwable r22 = r12.getCause();
        if (r22 == null) goto L39;
        printEnclosedStackTrace(r22, r13, r11, CAUSE_CAPTION, "", r10, 128);
        return;
    L39:
        return;
    L8:
        r14 = false;
        goto L9
    L40:
        return;
    }

    private static void printStackTrace(Throwable r12, List<StackTraceElement> r13) {
        if (r12 == null) goto L37;
        if (r13 == null) goto L39;
        Set r10 = Collections.newSetFromMap(new IdentityHashMap());
        r10.add(r12);
        r13.add(EMPTY);
        StackTraceElement[] r11 = r12.getStackTrace();
        if (r11.length <= 384) goto L8;
        boolean r14 = true;
    L9:
        int r15 = r11.length;
        int r16 = 0;
        int r17 = 0;
    L10:
        if (r16 >= r15) goto L17;
        StackTraceElement r18 = r11[r16];
        if (r14 == false) goto L16;
        if (r17 <= 256) goto L16;
        r13.add(EMPTY);
    L16:
        r13.add(r18);
        r17 = r17 + 1;
        r16 = r16 + 1;
    L17:
        if (r14 == false) goto L23;
        int r19 = r11.length - 128;
    L20:
        if (r19 >= r11.length) goto L23;
        r13.add(r11[r19]);
        r19 = r19 + 1;
    L23:
        if (Build.VERSION.SDK_INT < 19) goto L27;
        Throwable[] r20 = r12.getSuppressed();
        int r110 = r20.length;
        int r111 = 0;
    L25:
        if (r111 >= r110) goto L27;
        printEnclosedStackTrace(r20[r111], r13, r11, SUPPRESSED_CAPTION, "\t", r10, 128);
        r111 = r111 + 1;
    L27:
        Throwable r21 = r12.getCause();
        if (r21 == null) goto L38;
        printEnclosedStackTrace(r21, r13, r11, CAUSE_CAPTION, "", r10, 128);
        return;
    L38:
        return;
    L8:
        r14 = false;
        goto L9
    L39:
        return;
    }

    public static boolean stringContains(String r10, String[] r11) {
        if (r11 != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L14;
        if (r10.contains(r11[r13]) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return true;
    }
}
