package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f5649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static byte[] f5650b;
    private String c;

    static {
    }

    public z(String r2) {
        if (TextUtils.isDigitsOnly(r2) == false) goto L5;
        r2 = "SPUtil";
    L5:
        this.c = ft.a(r2);
    }

    public static int a(Context r2, String r3, String r4, int r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getInt(r4, r5);
    L5:
        th = move-exception;
        q.b(th, "csp", "giv");
        return r5;
    }

    public static long a(Context r2, String r3, String r4, long r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getLong(r4, r5);
    L5:
        th = move-exception;
        q.b(th, "csp", "glv");
        return r5;
    }

    public static SharedPreferences.Editor a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        n.a(th, "sp", "ge");
        goto L11
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        return r4.getSharedPreferences(r3, 0).edit();
    }

    public static String a(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return "";
    L9:
        return fx.a(b(r5, fx.d(r5.getSharedPreferences(r3, 0).getString(r4, ""))));
    L11:
        return "";
    }

    public static void a(Context r2, String r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return;
    L13:
        SharedPreferences.Editor r7 = r6.getSharedPreferences(r3, 0).edit();     // Catch: Throwable -> L12
        r7.putString(r4, fx.g(a(r6, fx.a(r5))));     // Catch: Throwable -> L12
        a(r7);     // Catch: Throwable -> L12
        return;
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.apply();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        n.a(th, "sp", "cm");
    }

    public static void a(SharedPreferences.Editor r2, String r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
    L9:
        th = move-exception;
        n.a(th, "sp", "rk");
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r4.remove(r3);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static void a(SharedPreferences.Editor r2, String r3, int r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putInt(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q.b(th, "csp", "putPrefsInt");
    }

    public static void a(SharedPreferences.Editor r2, String r3, long r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r5.putLong(r3, r4);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        q.b(th, "csp", "plv");
        return;
    }

    public static void a(SharedPreferences.Editor r2, String r3, String r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
    L11:
        th = move-exception;
        n.a(th, "sp", "ps");
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r5.putString(r3, r4);     // Catch: Throwable -> L11
        return;
    L18:
        return;
    }

    public static void a(SharedPreferences.Editor r2, String r3, boolean r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putBoolean(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q.b(th, "csp", "setPrefsStr");
    }

    public static boolean a(Context r2, String r3, String r4, boolean r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getBoolean(r4, r5);
    L5:
        th = move-exception;
        q.b(th, "csp", "gbv");
        return r5;
    }

    private static byte[] a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        byte[] r0 = f5649a;
        if (r0 != null) goto L9;
    L11:
        byte[] r4 = fm.f(r3).getBytes();
        f5649a = r4;
        return r4;
    L9:
        if (r0.length <= 0) goto L11;
        return r0;
    L5:
        return new byte[0];
    }

    public static byte[] a(Context r2, byte[] r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return fq.b(a(r4), r3, b(r4));
    L6:
        return new byte[0];
    }

    public static String b(Context r2, String r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.getSharedPreferences(r3, 0).getString(r4, r5);
    L9:
        th = move-exception;
        q.b(th, "csp", "gsv");
        return r5;
    }

    private static byte[] b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        byte[] r0 = f5650b;
        if (r0 != null) goto L5;
    L7:
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 9) goto L10;
        f5650b = Arrays.copyOfRange(a(r4), 0, a(r4).length / 2);
    L15:
        return f5650b;
    L10:
        f5650b = new byte[a(r4).length / 2];
    L11:
        byte[] r1 = f5650b;
        if (r2 >= r1.length) goto L15;
        r1[r2] = a(r4)[r2];
        r2 = r2 + 1;
        goto L11
    L5:
        if (r0.length <= 0) goto L7;
        return r0;
    }

    public static byte[] b(Context r2, byte[] r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return fq.a(a(r4), r3, b(r4));
    L6:
        return new byte[0];
    }
}
