package com.larus.contextwindow.impl.component;

import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    public final Object invoke(Object r3) {
        IndexedValue r4 = (IndexedValue) r3;
        int r0 = ContextWindowEntryFeature.z;
        Intrinsics.checkNotNullParameter(r4, "it");
        return Long.valueOf(((ContextWindowMessageSnapshot) r4.getValue()).c);
    }
}
