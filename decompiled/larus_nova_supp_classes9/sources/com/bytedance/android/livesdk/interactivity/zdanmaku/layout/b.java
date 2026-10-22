package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final int a;
    public a b;

    public b(a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuConfig");
        this.b = r2;
        int r0 = r2.e;
        this.a = (r3 - r0) / (r2.d + r0);
    }
}
