package com.bytedance.android.ec.common.impl.sku.utils;

import android.view.Choreographer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Choreographer.FrameCallback {
    public final /* synthetic */ f a;

    public o(f r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r10) {
        f r11 = this.a;
        int r12 = r11.a + 1;
        r11.a = r12;
        if (r12 < r11.b) goto L5;
        r11.c.run();
        return;
    L5:
        int r13 = p.a;
        Intrinsics.checkNotNullParameter(r11, "runner");
        Choreographer.getInstance().postFrameCallback(new o(r11));
    }
}
