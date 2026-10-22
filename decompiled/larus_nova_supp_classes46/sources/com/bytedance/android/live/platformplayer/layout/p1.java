package com.bytedance.android.live.platformplayer.layout;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p1 extends e {
    public final RectF a;
    public final boolean b;
    public final Integer c;
    public final boolean d;
    public final Matrix e;
    public final String f;

    public p1(RectF r2, boolean r3, Integer r4, boolean r5, Matrix r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "gridMatrix");
        Intrinsics.checkNotNullParameter(r7, "seiRaw");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
