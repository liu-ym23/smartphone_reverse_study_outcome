package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v0 {
    public final DoraObricGlassesExploreSectionType a;
    public final String b;
    public final d1 c;
    public final List<r0> d;

    public final DoraObricGlassesExploreSectionType getType() {
        return this.a;
    }

    public v0(DoraObricGlassesExploreSectionType r2, String r3, d1 r4, List<r0> r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
