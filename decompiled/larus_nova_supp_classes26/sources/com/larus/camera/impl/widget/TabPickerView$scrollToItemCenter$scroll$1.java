package com.larus.camera.impl.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class TabPickerView$scrollToItemCenter$scroll$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public TabPickerView$scrollToItemCenter$scroll$1(Object r8) {
        super(2, r8, RecyclerView.class, "smoothScrollBy", "smoothScrollBy(II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, int r3) {
        ((RecyclerView) ((CallableReference) this).receiver).smoothScrollBy(r2, r3);
    }
}
