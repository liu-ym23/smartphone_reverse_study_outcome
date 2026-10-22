package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class fc {
    public static int a(Context r2, String r3, String r4, int r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getInt(r4, r5);
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "getPrefsInt");
        return r5;
    }

    public static long a(Context r2, String r3, String r4, long r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getLong(r4, r5);
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "getPrefsLong");
        return r5;
    }

    public static SharedPreferences.Editor a(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).edit();
    }

    public static String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return "00:00:00:00:00:00";
    L6:
        return a(r4, "pref", "smac", "00:00:00:00:00:00");
    }

    public static String a(Context r2, String r3, String r4, String r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getString(r4, r5);
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "getPrefsInt");
        return r5;
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        r3.apply();
    }

    public static void a(SharedPreferences.Editor r2, String r3) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).remove(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "setPrefsLong");
    }

    public static void a(SharedPreferences.Editor r2, String r3, int r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putInt(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "setPrefsInt");
    }

    public static void a(SharedPreferences.Editor r2, String r3, long r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putLong(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "setPrefsLong");
    }

    public static void a(SharedPreferences.Editor r2, String r3, String r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putString(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "setPrefsStr");
    }

    public static void a(SharedPreferences.Editor r2, String r3, boolean r4) {
        ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin")).putBoolean(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "updatePrefsBoolean");
    }

    public static boolean a(Context r2, String r3, String r4, boolean r5) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r3, 0).getBoolean(r4, r5);
    L5:
        th = move-exception;
        ev.a(th, "SpUtil", "getPrefsBoolean");
        return r5;
    }
}
