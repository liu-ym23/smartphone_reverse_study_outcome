package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z {
    public final String a;
    public final d1 b;
    public final d1 c;
    public final c1 d;
    public final List<c1> e;
    public final List<x0> f;
    public final b0 g;
    public final String h;

    public z(String r2, d1 r3, d1 r4, c1 r5, List r6, List r7, b0 r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r6, "detailLottieSpecs");
        Intrinsics.checkNotNullParameter(r7, "detailImageSpecs");
        Intrinsics.checkNotNullParameter(r9, "cardContentType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
