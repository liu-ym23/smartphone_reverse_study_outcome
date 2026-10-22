package com.bytedance.ai.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements g2.d {
    public static final g a = null;
    public static g2.d b;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // g2.d
    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.d(r10, r11);
        return;
    }

    @Override // g2.d
    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.e(r10, r11);
        return;
    }

    @Override // g2.d
    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.i(r10, r11);
        return;
    }

    @Override // g2.d
    public final void w(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.w(r10, r11);
        return;
    }

    @Override // g2.d
    public final void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.e(r10, r11, r12);
        return;
    }

    @Override // g2.d
    public final void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        g2.d r0 = b;
        if (r0 == null) goto L6;
        r0.w(r10, r11, r12);
        return;
    }
}
