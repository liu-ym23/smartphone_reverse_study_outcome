package com.bytedance.ttnet.a;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3201a = "ttnet_debug_mode";

    static {
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (c() == true) goto L6;
        Logger.d(f3201a, "debug_mode close");
        return;
    L6:
        b(r3);
    }

    public static boolean a() {
        if (c() == true) goto L7;
        return false;
    L7:
        return b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static void b() {
        Logger.setLogLevel(2);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
    }

    private static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Logger.d(f3201a, "debug_mode open");
        if (b.a(r3) == false) goto L6;
        b();
        return;
    }

    private static boolean c() {
        if (TTNetInit.ENV.RELEASE == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }
}
