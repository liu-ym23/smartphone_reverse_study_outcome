package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5415a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile dh f5416b;

    static {
    }

    public static void a() {
    }

    public static void a(dh r2) {
        dh r3 = (dh) ZeusTransformUtils.wrapperContextForParams(r2, dh.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        f5416b = r3;
        return;
    }

    public static dh b() {
        return f5416b;
    }
}
