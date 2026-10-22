package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5617a = "/a/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f5618b = "b";
    static final String c = "c";
    static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static long l;
    private static Vector<fw> m;

    static {
        m = new Vector();
    }

    public static String a(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("AMSKLG_CFG", 0).getString(r3, "");
    }

    static List<fw> a() {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L10
        monitor-enter(r0);     // Catch: Throwable -> L10
        Vector<fw> r1 = m;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return m;
    }

    public static void a(Context r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        q.b(th, "Lg", "proL");
        return;
    L4:
        if ((System.currentTimeMillis() - l) >= 60000) goto L6;
        return;
    L6:
        l = System.currentTimeMillis();     // Catch: Throwable -> L8
        bp.a().b(new AnonymousClass1(r5));     // Catch: Throwable -> L8
    }

    public static void a(Context r2, String r3, String r4) {
        SharedPreferences.Editor r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("AMSKLG_CFG", 0).edit();
        r5.putString(r3, r4);
        r5.apply();
    }

    public static void a(fw r2) {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        if (r2 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        if (m.contains(r2) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        m.add(r2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    static boolean a(String[] r6, String r7) {
        if (r6 == null) goto L28;
        if (r7 == null) goto L28;
        String[] r8 = r7.split("\n");     // Catch: Throwable -> L26
        int r1 = r8.length;     // Catch: Throwable -> L26
        int r2 = 0;
    L7:
        boolean r3 = true;
        if (r2 >= r1) goto L20;
        String r4 = r8[r2].trim();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r4) == false) goto L12;
    L16:
        r3 = false;
    L17:
        if (r3 == true) goto L18;
        r2 = r2 + 1;     // Catch: Throwable -> L26
        goto L7
    L18:
        return false;
    L12:
        if (r4.startsWith("at ") == false) goto L16;
        if (r4.contains("uncaughtException") == false) goto L16;
    L20:
        int r5 = r8.length;     // Catch: Throwable -> L26
        int r9 = 0;
    L21:
        if (r9 >= r5) goto L28;
        if (b(r6, r8[r9].trim()) == true) goto L24;
        r9 = r9 + 1;
        goto L21
    L24:
        return true;
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    }

    public static void b(Context r2, String r3) {
        SharedPreferences.Editor r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("AMSKLG_CFG", 0).edit();
        r4.remove(r3);
        r4.apply();
    }

    static boolean b(String[] r5, String r6) {
        if (r5 == null) goto L21;
        if (r6 == null) goto L21;
        int r1 = r5.length;     // Catch: Throwable -> L19
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        String r3 = r5[r2];     // Catch: Throwable -> L19
        r6 = r6.trim();     // Catch: Throwable -> L19
        if (r6.startsWith("at ") == false) goto L18;
        if (r6.contains(r3 + ".") == false) goto L18;
        if (r6.endsWith(")") == false) goto L18;
        if (r6.contains("uncaughtException") == true) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
    L19:
        th = move-exception;
        th.printStackTrace();
    L21:
        return false;
    }

    public static String c(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + f5617a + r3;
    }
}
