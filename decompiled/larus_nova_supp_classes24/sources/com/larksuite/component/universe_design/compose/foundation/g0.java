package com.larksuite.component.universe_design.compose.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g0 {
    public final e0 a;
    public final d0 b;
    public final f0 c;
    public final h0 d;

    public final long a() {
        return this.d.a.b;
    }

    public final long b() {
        return this.d.f.a;
    }

    public g0(e0 r2, d0 r3, f0 r4, h0 r5) {
        Intrinsics.checkNotNullParameter(r2, "base");
        Intrinsics.checkNotNullParameter(r3, "alpha");
        Intrinsics.checkNotNullParameter(r4, "theme");
        Intrinsics.checkNotNullParameter(r5, "colors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
