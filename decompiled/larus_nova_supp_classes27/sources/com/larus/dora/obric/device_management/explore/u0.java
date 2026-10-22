package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 {
    public final DoraObricGlassesExploreSectionType a;
    public final String b;
    public final List<q0> c;

    public final DoraObricGlassesExploreSectionType getType() {
        return this.a;
    }

    public u0(DoraObricGlassesExploreSectionType r2, String r3, String r4, List<q0> r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
