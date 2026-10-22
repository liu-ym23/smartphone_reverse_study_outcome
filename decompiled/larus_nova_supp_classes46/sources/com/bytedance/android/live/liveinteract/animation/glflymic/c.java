package com.bytedance.android.live.liveinteract.animation.glflymic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements com.bytedance.android.live.core.gl.primitive.b {
    public final a a;

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "converter");
        this.a = r2;
    }

    public final float[] a(float[] r4) {
        Intrinsics.checkNotNullParameter(r4, "position");
        return this.a.a(r4[0], r4[1]);
    }

    public final float b(float r3) {
        a r0 = this.a;
        return (r0.e / r0.a) * r3;
    }
}
