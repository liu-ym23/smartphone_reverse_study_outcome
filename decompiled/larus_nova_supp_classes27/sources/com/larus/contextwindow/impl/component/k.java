package com.larus.contextwindow.impl.component;

import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Function1 {
    public /* synthetic */ k() {
    }

    public final Object invoke(Object r2) {
        IndexedValue r3 = (IndexedValue) r2;
        int r0 = ContextWindowEntryFeature.z;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Integer.valueOf(r3.getIndex());
    }
}
