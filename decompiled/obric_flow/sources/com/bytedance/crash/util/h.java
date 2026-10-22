package com.bytedance.crash.util;

import android.text.TextUtils;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4186a = 0;

    static {
        new StackTraceElement("", "", "", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String a(Throwable r5) {
        StringWriter r10 = new StringWriter();
        PrintWriter r11 = new PrintWriter(r10);
        h(r5, r11);     // Catch: Throwable -> L6
        String r12 = r10.toString();     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L7:
        r11.close();
        return "";
    }

    public static String b(byte[] r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.length <= 0) goto L14;
        char[] r5 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] r11 = new char[r10.length * 2];
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= r12) goto L10;
        byte r15 = r10[r13];
        int r16 = r14 + 1;
        r11[r14] = r5[(r15 >>> 4) & 15];
        r14 = r14 + 2;
        r11[r16] = r5[r15 & 15];
        r13 = r13 + 1;
        goto L7
    L10:
        return new String(r11);
    L14:
        return "";
    }

    public static String c(StackTraceElement[] r10) {
        StringBuilder r5 = new StringBuilder();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        StackTraceElement r13 = r10[r12];
        String r14 = r13.getClassName();
        r5.append("  at ");
        r5.append(r14);
        r5.append(".");
        r5.append(r13.getMethodName());
        r5.append("(");
        r5.append(r13.getFileName());
        r5.append(":");
        r5.append(r13.getLineNumber());
        r5.append(")\n");
        r12 = r12 + 1;
        goto L3
    L6:
        return r5.toString();
    }

    public static JSONObject d(String r14) {
        Map<Thread, StackTraceElement[]> r5 = Thread.getAllStackTraces();     // Catch: Throwable -> L28
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L28
        if (r5 != null) goto L6;
        return null;
    L6:
        r10.put("thread_all_count", r5.size());     // Catch: Throwable -> L28
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L28
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r12 = r5.entrySet().iterator();     // Catch: Throwable -> L28
    L8:
        if (r12.hasNext() == false) goto L26;
        Map.Entry<Thread, StackTraceElement[]> r13 = r12.next();     // Catch: Throwable -> L28
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L28
        Thread r16 = r13.getKey();     // Catch: Throwable -> L28
        String r17 = r16.getName();     // Catch: Throwable -> L28
        if (r14 == null) goto L18;
        if (r14.equals(r17) == true) goto L8;
        if (r17.startsWith(r14) == true) goto L8;
        if (r17.endsWith(r14) == true) goto L8;
    L18:
        r15.put("thread_name", r16.getName() + "(" + r16.getId() + ")");     // Catch: Throwable -> L28
        StackTraceElement[] r18 = r13.getValue();     // Catch: Throwable -> L28
        if (r18 == null) goto L25;
        JSONArray r19 = new JSONArray();     // Catch: Throwable -> L28
        int r20 = r18.length;     // Catch: Throwable -> L28
        int r110 = 0;
    L21:
        if (r110 >= r20) goto L23;
        StackTraceElement r111 = r18[r110];     // Catch: Throwable -> L28
        r19.put(r111.getClassName() + "." + r111.getMethodName() + "(" + r111.getLineNumber() + ")");     // Catch: Throwable -> L28
        r110 = r110 + 1;     // Catch: Throwable -> L28
        goto L21
    L23:
        r15.put("thread_stack", r19);     // Catch: Throwable -> L28
        if (r19.length() <= 0) goto L8;
    L25:
        r11.put(r15);     // Catch: Throwable -> L28
        goto L8
    L26:
        r10.put("thread_stacks", r11);     // Catch: Throwable -> L28
        return r10;
    L28:
        return null;
    }

    public static void e(int r5, String r10, String r11, Throwable r12) {
        StackTraceElement[] r13 = r12.getStackTrace();
        NativeTools.k().c(r5, r11);     // Catch: Throwable -> L14
        NativeTools.k().c(r5, r10);     // Catch: Throwable -> L14
    L4:
        k(r5, r12);
        int r14 = r13.length;
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r16 >= r14) goto L7;
        g(r13[r16], r5);
        r16 = r16 + 1;
        goto L5
    L7:
        Throwable[] r17 = r12.getSuppressed();
        int r18 = r17.length;
    L8:
        if (r15 >= r18) goto L10;
        e(r5, "Suppressed: ", r11 + Profiler.DATA_SEP, r17[r15]);
        r15 = r15 + 1;
        goto L8
    L10:
        Throwable r19 = r12.getCause();
        if (r19 == null) goto L19;
        e(r5, "Caused by: ", r11, r19);
        return;
    }

    public static void f(int r10, Throwable r11) {
        if (r11 == null) goto L17;
        if (r10 <= 0) goto L19;
        k(r10, r11);
        StackTraceElement[] r5 = r11.getStackTrace();
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L8;
        g(r5[r14], r10);
        r14 = r14 + 1;
        goto L6
    L8:
        Throwable[] r15 = r11.getSuppressed();
        int r16 = r15.length;
    L9:
        if (r13 >= r16) goto L11;
        e(r10, "Suppressed: ", Profiler.DATA_SEP, r15[r13]);
        r13 = r13 + 1;
        goto L9
    L11:
        Throwable r17 = r11.getCause();
        if (r17 == null) goto L18;
        e(r10, "Caused by: ", "", r17);
        return;
    L18:
        return;
    L19:
        return;
    }

    public static void g(StackTraceElement r5, int r10) {
        NativeTools.k().c(r10, "\tat ");     // Catch: Throwable -> L19
        String r11 = r5.getClassName();     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r11);     // Catch: Throwable -> L19
        NativeTools.k().c(r10, ".");     // Catch: Throwable -> L19
        String r12 = r5.getMethodName();     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r12);     // Catch: Throwable -> L19
        if (r5.isNativeMethod() == false) goto L7;
        NativeTools.k().c(r10, "(Native Method)");     // Catch: Throwable -> L19
    L17:
        NativeTools.k().c(r10, "\n");     // Catch: Throwable -> L19
        return;
    L7:
        if (r5.getFileName() == null) goto L14;
        if (r5.getLineNumber() < 0) goto L12;
        NativeTools.k().c(r10, "(");     // Catch: Throwable -> L19
        String r13 = r5.getFileName();     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r13);     // Catch: Throwable -> L19
        NativeTools.k().c(r10, ":");     // Catch: Throwable -> L19
        String r14 = String.valueOf(r5.getLineNumber());     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r14);     // Catch: Throwable -> L19
        NativeTools.k().c(r10, ")");     // Catch: Throwable -> L19
        goto L17
    L12:
        NativeTools.k().c(r10, "(");     // Catch: Throwable -> L19
        String r15 = r5.getFileName();     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r15);     // Catch: Throwable -> L19
        NativeTools.k().c(r10, ")");     // Catch: Throwable -> L19
        goto L17
    L14:
        if (r5.getLineNumber() < 0) goto L16;
        NativeTools.k().c(r10, "(Unknown Source:");     // Catch: Throwable -> L19
        String r16 = String.valueOf(r5.getLineNumber());     // Catch: Throwable -> L19
        NativeTools.k().c(r10, r16);     // Catch: Throwable -> L19
        NativeTools.k().c(r10, ")");     // Catch: Throwable -> L19
        goto L17
    L16:
        NativeTools.k().c(r10, "(Unknown Source)");     // Catch: Throwable -> L19
    }

    public static void h(Throwable r10, PrintWriter r11) {
        if (r10 == null) goto L34;
        Set r5 = Collections.newSetFromMap(new IdentityHashMap());
        r5.add(r10);
        r11.println(r10);
        StackTraceElement[] r12 = r10.getStackTrace();
        if (r12.length <= 384) goto L6;
        boolean r13 = true;
    L7:
        int r14 = r12.length;
        int r15 = 0;
        int r16 = 0;
    L9:
        if (r15 >= r14) goto L16;
        StackTraceElement r17 = r12[r15];
        if (r13 == false) goto L15;
        if (r16 <= 256) goto L15;
        StringBuilder r18 = new StringBuilder("\t... skip ");
        r18.append((r12.length - r16) - 128);
        r18.append(" lines");
        r11.println(r18.toString());
    L15:
        r11.println("\tat " + r17);
        r16 = r16 + 1;
        r15 = r15 + 1;
    L16:
        if (r13 == false) goto L21;
        int r19 = r12.length - 128;
    L19:
        if (r19 >= r12.length) goto L21;
        r11.println("\tat " + r12[r19]);
        r19 = r19 + 1;
    L21:
        Throwable[] r20 = r10.getSuppressed();
        int r21 = r20.length;
        int r22 = 0;
    L22:
        if (r22 >= r21) goto L24;
        i(r20[r22], r11, "Suppressed: ", Profiler.DATA_SEP, r5, 128);
        r22 = r22 + 1;
        goto L22
    L24:
        Throwable r23 = r10.getCause();
        if (r23 == null) goto L35;
        i(r23, r11, "Caused by: ", "", r5, 128);
        return;
    L35:
        return;
    L6:
        r13 = false;
        goto L7
    }

    public static void i(Throwable r10, PrintWriter r11, String r12, String r13, Set r14, int r15) {
        if (r14.contains(r10) == false) goto L6;
        r11.println("\t[CIRCULAR REFERENCE:" + r10 + "]");
        return;
    L6:
        r14.add(r10);
        StackTraceElement[] r5 = r10.getStackTrace();
        int r16 = 0;
        if (r5.length <= r15) goto L9;
        boolean r17 = true;
    L10:
        r11.println(r13 + r12 + r10);
        int r18 = r5.length;
        int r19 = 0;
        int r20 = 0;
    L12:
        if (r19 >= r18) goto L18;
        StackTraceElement r21 = r5[r19];
        if (r17 == false) goto L17;
        if (r20 <= r15) goto L17;
        r11.println("\t... skip " + ((r5.length - r20) - (r15 / 2)) + " lines");
    L17:
        r11.println("\tat " + r21);
        r20 = r20 + 1;
        r19 = r19 + 1;
    L18:
        if (r17 == false) goto L23;
        int r110 = r5.length - (r15 / 2);
    L21:
        if (r110 >= r5.length) goto L23;
        r11.println("\tat " + r5[r110]);
        r110 = r110 + 1;
    L23:
        Throwable[] r111 = r10.getSuppressed();
        int r22 = r111.length;
    L25:
        if (r16 >= r22) goto L31;
        Throwable r23 = r111[r16];
        String r24 = io.reactivex.internal.observers.h.b(r13, Profiler.DATA_SEP);
        int r25 = r15 / 2;
        if (r25 <= 10) goto L29;
        int r26 = r25;
    L30:
        i(r23, r11, "Suppressed: ", r24, r14, r26);
        r16 = r16 + 1;
        goto L25
    L29:
        r26 = 10;
        goto L30
    L31:
        Throwable r27 = r10.getCause();
        if (r27 == null) goto L47;
        int r112 = r15 / 2;
        if (r112 <= 10) goto L36;
        int r28 = r112;
    L37:
        i(r27, r11, "Caused by: ", r13, r14, r28);
        return;
    L36:
        r28 = 10;
        goto L37
    L47:
        return;
    L9:
        r17 = false;
        goto L10
    }

    public static String j(String r10) {
        BufferedReader r5 = null;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        File r11 = new File(r10);
        if (r11.exists() == true) goto L8;
        return null;
    L8:
        LinkedList r12 = new LinkedList();
        StringBuilder r13 = new StringBuilder();
        int r14 = 0;
        BufferedReader r15 = new BufferedReader(new FileReader(r11));     // Catch: Throwable -> L34
        int r16 = 0;
    L35:
        String r17 = r15.readLine();     // Catch: Throwable -> L22
        if (r17 == null) goto L21;
        if (r16 > 256) goto L16;
        r13.append(r17);     // Catch: Throwable -> L22
        r13.append('\n');     // Catch: Throwable -> L22
    L20:
        r16 = r16 + 1;
        goto L35
    L16:
        r12.add(r17);     // Catch: Throwable -> L22
        if (r12.size() <= 256) goto L20;
        r12.poll();     // Catch: Throwable -> L22
        r14 = r14 + 1;
        goto L20
    L21:
        com.bytedance.android.anniex.base.service.f.h(r15);
    L25:
        if (r12.isEmpty() == true) goto L33;
        if (r14 == 0) goto L28;
        r13.append("\t... skip ");
        r13.append(r14);
        r13.append(" lines\n");
    L28:
        Iterator r18 = r12.iterator();
    L30:
        if (r18.hasNext() == false) goto L33;
        r13.append((String) r18.next());
        r13.append('\n');
    L33:
        return r13.toString();
    L22:
        r5 = r15;
    L23:
        com.bytedance.android.anniex.base.service.f.h(r5);
        goto L25
    }

    public static void k(int r5, Throwable r10) {
        String r11 = r10.getLocalizedMessage();
        String r12 = r10.getClass().getName();     // Catch: Throwable -> L8
        NativeTools.k().c(r5, r12);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        NativeTools.k().c(r5, ": ");     // Catch: Throwable -> L8
        NativeTools.k().c(r5, r11);     // Catch: Throwable -> L8
    L6:
        NativeTools.k().c(r5, "\n");     // Catch: Throwable -> L8
        return;
    }

    public static boolean l(Throwable r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = 0;
    L6:
        if (r5 == null) goto L16;
        if ((r5 instanceof OutOfMemoryError) == true) goto L9;
        if (r10 > 20) goto L13;
        r10 = r10 + 1;     // Catch: Throwable -> L17
        r5 = r5.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }
}
