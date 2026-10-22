package com.ss.android.deviceregister.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Api;
import com.ss.android.deviceregister.d.f;
import com.ss.android.deviceregister.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f<SharedPreferences> f15184b;

    static {
        f15184b = new AnonymousClass1();
    }

    static /* synthetic */ f a() {
        return f15184b;
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (i.a() == false) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (f15183a == false) goto L12;
        return true;
    L12:
        return c(r4).getBoolean(Api.KEY_STARTED, false);
    }

    public static void b(Context r2) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        f15183a = true;
        com.bytedance.common.utility.a.c.a(new AnonymousClass2(r3));
    }

    private static SharedPreferences c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(f15184b.c(new Object[]{r5}), SharedPreferences.class, "com.obric.memorydata.plugin");
    }
}
