package com.bytedance.ttnet.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3202a = "ttnet_debug_setting";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3203b = "log_switcher";
    private static String c = "x86_support";

    static {
    }

    private static String a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getSharedPreferences(f3202a, 0).getString(r4, null);
    }

    public static boolean a(Context r2) {
        return "true".equals(a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), f3203b));
    }

    public static boolean b(Context r2) {
        return "true".equals(a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), c));
    }
}
