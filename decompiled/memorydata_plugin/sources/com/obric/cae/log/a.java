package com.obric.cae.log;

import android.os.SystemProperties;
import android.util.Log;
import com.obric.cae.libs.utils.c;
import com.obric.cae.location.city.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7318b;
    public static volatile boolean c;
    public static final ConcurrentHashMap<String, ReentrantReadWriteLock> d = null;
    public static final ConcurrentHashMap<String, File> e = null;
    public static final ConcurrentHashMap<String, Integer> f = null;
    public static AtomicBoolean g;

    static {
        if (SystemProperties.getInt("ro.debuggable", 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        f7317a = r0;
        f7318b = true;
        c = false;
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new AtomicBoolean(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static File a(String r1, int r2) {
        if (r2 <= 0) goto L6;
        r1 = r1 + "#user_" + r2;
    L6:
        return b(r1);
    }

    public static String a() {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        if (r0 != null) goto L7;
        return "";
    L7:
        if (r0.length >= 4) goto L11;
        StackTraceElement r1 = r0[r0.length - 1];
    L10:
        return r1.getMethodName();
    L11:
        r1 = r0[3];
        goto L10
    }

    public static String a(String r3) {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        if (r0.length >= 5) goto L6;
        return r3;
    L6:
        return "[" + r0[4].getMethodName() + "] " + r3;
    }

    public static String a(String r2, String r3) {
        if (f7318b == false) goto L7;
        return e(r2, "CommSenseLog", r3, "CommSenseLog");
    L7:
        if (a(2) == false) goto L14;
        String r4 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.a("CommSenseLog", r4);
        return null;
    L11:
        Log.v("CommSenseLog", r4);
        return null;
    L14:
        return null;
    }

    public static void a(File r4, PrintWriter r5, Function<String, String> r6) {
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r6, Function.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.exists() == false) goto L44;
        ReentrantReadWriteLock r0 = (ReentrantReadWriteLock) ZeusTransformUtils.preCheckCast(d.computeIfAbsent(r4.getAbsolutePath(), $$Lambda$6Fv9S2hO6l_LZSmv4LA8zUYDwI.INSTANCE), ReentrantReadWriteLock.class, "com.obric.memorydata.plugin");
        r0.readLock().lock();
        BufferedReader r2 = new BufferedReader(Files.newBufferedReader(r4.toPath()));     // Catch: Throwable -> L26 IOException -> L28
    L36:
        String r8 = r2.readLine();     // Catch: Throwable -> L20
        if (r8 == null) goto L18;
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        if (r7 == null) goto L16;
        r8 = (String) ZeusTransformUtils.preCheckCast(r7.apply(r8), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L16:
        r5.println(r8);     // Catch: Throwable -> L20
        goto L36
    L13:
        r5.println("dump interrupted");     // Catch: Throwable -> L20
    L18:
        r2.close();     // Catch: Throwable -> L26 IOException -> L28
    L30:
        r0.readLock().unlock();
        return;
    L20:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L26 IOException -> L28
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26 IOException -> L28
    L26:
        th = move-exception;
        r0.readLock().unlock();
        throw th;
    L28:
        e = move-exception;
        r5.println("Error reading log file: " + e.getMessage());     // Catch: Throwable -> L26
        a("CommSenseLog", "dumpFileContent failed", e);     // Catch: Throwable -> L26
        goto L30
    }

    public static void a(File r5, String r6) {
        if (r5 != null) goto L6;
        Log.d("CommSenseLog", "write2FileWithBuffer, file is null");
        return;
    L6:
        File r1 = r5.getParentFile();
        if (r1 != null) goto L9;
    L14:
        ReentrantReadWriteLock r2 = (ReentrantReadWriteLock) ZeusTransformUtils.preCheckCast(d.computeIfAbsent(r5.getAbsolutePath(), $$Lambda$voUF2SoMZfQQDsQWUiW1Yom67Mk.INSTANCE), ReentrantReadWriteLock.class, "com.obric.memorydata.plugin");
        r2.writeLock().lock();
        BufferedOutputStream r3 = new BufferedOutputStream(new FileOutputStream(r5, true), 8192);     // Catch: Throwable -> L25 IOException -> L27
        r3.write(r6.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L19
        r3.close();     // Catch: Throwable -> L25 IOException -> L27
    L29:
        r2.writeLock().unlock();
        return;
    L19:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27
    L25:
        th = move-exception;
        r2.writeLock().unlock();
        throw th;
    L27:
        e = move-exception;
        a("CommSenseLog", "writeWithBuffer failed", e);     // Catch: Throwable -> L25
        goto L29
    L9:
        if (r1.exists() == true) goto L14;
        if (r1.mkdirs() == true) goto L14;
        Log.e("CommSenseLog", "Failed to create parent directories: " + r1.getAbsolutePath());
    }

    public static void a(String r1, int r2, File r3) {
        if (r2 <= 0) goto L5;
        r1 = r1 + "#user_" + r2;
    L5:
        a(r1, r3);
    }

    public static void a(String r4, File r5) {
        Log.d("CommSenseLog", f.a("recordFileWithKey: ", r4, ", file: ").append(r5.getAbsolutePath()).toString());
        ConcurrentHashMap<String, File> r0 = e;
        if (((File) ZeusTransformUtils.preCheckCast(r0.putIfAbsent(r4, r5), File.class, "com.obric.memorydata.plugin")) != null) goto L6;
        r0.put(r4, r5);
        f.put(r4, 0);
        return;
    }

    public static void a(String r1, String r2, File r3) {
        a(r1, r2, r3, e(r1, "CommSenseLog", r2, "CommSenseLog"));
    }

    public static void a(String r1, String r2, File r3, String r4) {
        if (r4 != null) goto L5;
        StringBuilder r5 = new StringBuilder().append(r1).append(": ").append(c(r2));
    L6:
        b(r5.toString(), r3);
        return;
    L5:
        r5 = new StringBuilder().append(r1).append(": ").append(r4);
        goto L6
    }

    public static void a(String r1, String r2, String r3, String r4) {
        if (a(6) == false) goto L9;
        String r5 = c.a(r2, r3, r4, true);
        boolean r6 = c;
        String r7 = k(r1, r5);
        if (r6 == false) goto L7;
        com.ss.android.agilelogger.a.e("CommSenseLog", r7);
        return;
    L7:
        Log.e("CommSenseLog", r7);
        return;
    }

    public static void a(String r2, String r3, Throwable r4) {
        if (f7318b == false) goto L7;
        a(r2, "CommSenseLog", r3, "CommSenseLog");
        return;
    L7:
        if (a(6) == false) goto L13;
        String r5 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.b("CommSenseLog", r5, r4);
        return;
    L11:
        Log.e("CommSenseLog", r5, r4);
        return;
    }

    public static boolean a(int r1) {
        if (f7317a == false) goto L5;
        int r0 = 3;
    L6:
        if (r0 > r1) goto L8;
        return true;
    L8:
        return false;
    L5:
        r0 = 4;
        goto L6
    }

    public static File b(String r9) {
        ConcurrentHashMap<String, File> r0 = e;
        if (r0.containsKey(r9) == false) goto L18;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r0.get(r9), File.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
    L17:
        return r1;
    L7:
        if (r1.exists() == false) goto L17;
        if (r1.isFile() == false) goto L17;
        if (com.obric.cae.libs.utils.a.a(r1, 100) == false) goto L17;
        ConcurrentHashMap<String, Integer> r2 = f;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r9), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L15;
        r3 = 0;
    L15:
        StringBuilder r4 = new StringBuilder().append(r1.getAbsolutePath().replaceAll("\\.\\d{3}$", "")).append(".");
        Locale r6 = Locale.US;
        Integer r5 = Integer.valueOf(r3.intValue() + 1);
        File r7 = new File(r4.append(String.format(r6, "%03d", new Object[]{r5})).toString());
        r0.put(r9, r7);
        r2.put(r9, r5);
        return r7;
    L18:
        Log.d("CommSenseLog", "getRecordFile: " + r9 + ", file not found.");
        return null;
    }

    public static void b(String r5, File r6) {
        if (g.get() == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r0);
        a(r6, String.format(Locale.CHINA, "%tm-%td %tH:%tM:%tS.%tL", new Object[]{r2, r2, r2, r2, r2, r2}) + "  " + r5 + "\n");
    }

    public static void b(String r0, String r1) {
        a(r0, a(r1));
    }

    public static void b(String r1, String r2, File r3) {
        a(r1, r2, r3, d(r1, "CommSenseLog", r2, "CommSenseLog"));
    }

    public static void b(String r1, String r2, String r3, String r4) {
        if (a(5) == false) goto L9;
        String r5 = c.a(r2, r3, r4, true);
        boolean r6 = c;
        String r7 = k(r1, r5);
        if (r6 == false) goto L7;
        com.ss.android.agilelogger.a.d("CommSenseLog", r7);
        return;
    L7:
        Log.w("CommSenseLog", r7);
        return;
    }

    public static void b(String r0, String r1, Throwable r2) {
        a(r0, a(r1), r2);
    }

    public static String c(String r2) {
        return c.a("CommSenseLog", r2, "CommSenseLog", true);
    }

    public static String c(String r2, String r3) {
        if (f7318b == false) goto L7;
        return d(r2, "CommSenseLog", r3, "CommSenseLog");
    L7:
        if (a(3) == false) goto L14;
        String r4 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.b("CommSenseLog", r4);
        return null;
    L11:
        Log.d("CommSenseLog", r4);
        return null;
    L14:
        return null;
    }

    public static String c(String r1, String r2, String r3, String r4) {
        if (a(4) == false) goto L9;
        String r5 = c.a(r2, r3, r4, true);
        boolean r6 = c;
        String r7 = k(r1, r5);
        if (r6 == false) goto L7;
        com.ss.android.agilelogger.a.c("CommSenseLog", r7);
    L8:
        return r5;
    L7:
        Log.i("CommSenseLog", r7);
        goto L8
    L9:
        return null;
    }

    public static void c(String r1, String r2, File r3) {
        a(r1, r2, r3, c(r1, "CommSenseLog", r2, "CommSenseLog"));
    }

    public static String d(String r7) {
        if (r7 != null) goto L4;
        return "";
    L4:
        if (r7.isEmpty() == true) goto L53;
        int r0 = r7.indexOf("=CommSenseLog EN=");
        if (r0 >= 0) goto L9;
        return r7;
    L9:
        int r1 = r0 + 17;
        int r2 = r1;
    L11:
        if (r2 >= r7.length()) goto L35;
        char r3 = r7.charAt(r2);
        if (r3 < 'A') goto L17;
        if (r3 > 'Z') goto L17;
    L32:
        boolean r4 = true;
    L33:
        if (r4 == false) goto L35;
        r2 = r2 + 1;
    L17:
        if (r3 < 'a') goto L21;
        if (r3 <= 'z') goto L32;
    L21:
        if (r3 < '0') goto L25;
        if (r3 <= '9') goto L32;
    L25:
        if (r3 == '+') goto L32;
        if (r3 == '/') goto L32;
        if (r3 == '=') goto L32;
        r4 = false;
    L35:
        if (r2 != r1) goto L37;
        return r7;
    L37:
        String r5 = r7.substring(r0, r2);
        String r6 = c.b("CommSenseLog", r5, "CommSenseLog", true);
        if (r6 != null) goto L40;
        return r7;
    L40:
        if (r6.isEmpty() == false) goto L42;
        return r7;
    L42:
        if (r6.equals(r5) == false) goto L45;
        return r7;
    L45:
        return r7.substring(0, r0) + r6 + r7.substring(r2);
    L53:
        return "";
    }

    public static String d(String r1, String r2, String r3, String r4) {
        if (a(3) == false) goto L9;
        String r5 = c.a(r2, r3, r4, true);
        boolean r6 = c;
        String r7 = k(r1, r5);
        if (r6 == false) goto L7;
        com.ss.android.agilelogger.a.b("CommSenseLog", r7);
    L8:
        return r5;
    L7:
        Log.d("CommSenseLog", r7);
        goto L8
    L9:
        return null;
    }

    public static void d(String r0, String r1) {
        c(r0, a(r1));
    }

    public static String e(String r2, String r3) {
        if (f7318b == false) goto L7;
        return c(r2, "CommSenseLog", r3, "CommSenseLog");
    L7:
        if (a(4) == false) goto L14;
        String r4 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.c("CommSenseLog", r4);
        return null;
    L11:
        Log.i("CommSenseLog", r4);
        return null;
    L14:
        return null;
    }

    public static String e(String r1, String r2, String r3, String r4) {
        if (a(2) == false) goto L9;
        String r5 = c.a(r2, r3, r4, true);
        boolean r6 = c;
        String r7 = k(r1, r5);
        if (r6 == false) goto L7;
        com.ss.android.agilelogger.a.a("CommSenseLog", r7);
    L8:
        return r5;
    L7:
        Log.v("CommSenseLog", r7);
        goto L8
    L9:
        return null;
    }

    public static /* synthetic */ ReentrantReadWriteLock e(String r0) {
        return new ReentrantReadWriteLock();
    }

    public static /* synthetic */ ReentrantReadWriteLock f(String r0) {
        return new ReentrantReadWriteLock();
    }

    public static void f(String r0, String r1) {
        e(r0, a(r1));
    }

    public static void g(String r2, String r3) {
        if (f7318b == false) goto L7;
        b(r2, "CommSenseLog", r3, "CommSenseLog");
        return;
    L7:
        if (a(5) == false) goto L13;
        String r4 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.d("CommSenseLog", r4);
        return;
    L11:
        Log.w("CommSenseLog", r4);
        return;
    }

    public static void h(String r0, String r1) {
        g(r0, a(r1));
    }

    public static void i(String r2, String r3) {
        if (f7318b == false) goto L7;
        a(r2, "CommSenseLog", r3, "CommSenseLog");
        return;
    L7:
        if (a(6) == false) goto L13;
        String r4 = k(r2, r3);
        if (c == false) goto L11;
        com.ss.android.agilelogger.a.e("CommSenseLog", r4);
        return;
    L11:
        Log.e("CommSenseLog", r4);
        return;
    }

    public static void j(String r0, String r1) {
        i(r0, a(r1));
    }

    public static String k(String r2, String r3) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        return "<" + r2 + "> " + r3;
    }
}
