package com.bytedance.android.live.profit.fansclub.widget;

import com.bytedance.android.anya.BaseMVIComposableView;
import eu0.h;
import eu0.j;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class FansClubWidgetService$unloadEntranceMVIView$1 extends MutablePropertyReference0Impl {
    public FansClubWidgetService$unloadEntranceMVIView$1(a r7) {
        super(r7, a.class, "entranceView", "getEntranceView()Lcom/bytedance/android/anya/BaseMVIComposableView;", 0);
    }

    public Object get() {
        BaseMVIComposableView<j, h> r0 = ((a) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L5:
        return r0;
    }

    public void set(Object r2) {
        BaseMVIComposableView<j, h> r3 = (BaseMVIComposableView) r2;
        ((a) ((CallableReference) this).receiver).b = r3;
    }
}
