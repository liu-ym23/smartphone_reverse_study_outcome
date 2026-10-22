package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y {
    public final String a;
    public final String b;
    public final String c;
    public final b1 d;
    public final List<b1> e;
    public final List<DoraObricGlassesImageResource> f;
    public final a0 g;
    public final String h;

    public y(String r2, String r3, String r4, b1 r5, List r6, List r7, a0 r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r6, "detailLotties");
        Intrinsics.checkNotNullParameter(r7, "detailImages");
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
