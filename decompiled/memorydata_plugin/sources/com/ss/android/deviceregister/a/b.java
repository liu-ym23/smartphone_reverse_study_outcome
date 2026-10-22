package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f15127a = "applog_stats";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15128b;
    private static boolean c;

    static {
    }

    public static SharedPreferences a(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(a(), 0);
    }

    public static String a() {
        return f15127a;
    }

    public static void a(boolean r0) {
        c = r0;
    }

    public static boolean b() {
        return c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f15128b) == false) goto L6;
        f15128b = com.ss.android.deviceregister.b.a.a.c.a("c25zc2RrX29wZW51ZGlk");
    L6:
        return f15128b;
    }
}
