package com.squareup.kotlinpoet;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a0 {
    public static final /* synthetic */ int e = 0;

    static {
        new h(false, CollectionsKt.emptyList(), new ym.d(MapsKt.emptyMap()));
    }

    @Override // com.squareup.kotlinpoet.a0
    public final a0 a(Map r5, boolean r10, List r11) {
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r5, "tags");
        throw new UnsupportedOperationException("dynamic doesn't support copying");
    }

    @Override // com.squareup.kotlinpoet.a0
    public final f c(f r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.b("dynamic", false);
        return r5;
    }
}
