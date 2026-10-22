package com.larus.dora.obric.device_management.explore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 {
    public final String a;
    public final d1 b;
    public final d1 c;
    public final Map<String, String> d;
    public final DoraObricGlassesExploreActionStateType e;

    public b0(String r2, d1 r3, d1 r4, Map<String, String> r5, DoraObricGlassesExploreActionStateType r6) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "extras");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
