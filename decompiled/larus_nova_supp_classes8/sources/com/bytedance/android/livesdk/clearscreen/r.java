package com.bytedance.android.livesdk.clearscreen;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    public final boolean a;
    public final ZoomType b;

    public final ZoomType getType() {
        return this.b;
    }

    public r(boolean r2, ZoomType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
    }
}
