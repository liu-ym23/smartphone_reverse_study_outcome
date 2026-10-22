package com.bytedance.common.utility;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1987a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f1988b;
    private static String c;
    private static int d;

    public static class a {
        public a() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        boolean r0 = true;
    L6:
        f1987a = r0;
        c = "";
        d = -1;
        f1988b = new a();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.widthPixels;
    }

    public static int b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.heightPixels;
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (h.a(c) == false) goto L10;
        if (r3 == null) goto L10;
        int r0 = a(r3);
        int r4 = b(r3);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        c = r0 + "*" + r4;
    L10:
        return c;
    }

    public static int d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (d != (-1)) goto L7;
        if (r4 == null) goto L7;
        d = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().densityDpi;
    L7:
        return d;
    }
}
