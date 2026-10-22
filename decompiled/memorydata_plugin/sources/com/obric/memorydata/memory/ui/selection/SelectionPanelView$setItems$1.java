package com.obric.memorydata.memory.ui.selection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class SelectionPanelView$setItems$1<V> extends FunctionReferenceImpl implements Function2<V, Integer, Unit> {
    SelectionPanelView$setItems$1(Object r8) {
        super(2, r8, SelectionPanelView.class, "handleItemClick", "handleItemClick(Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Object r3, Integer r4) {
        invoke((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, SelectionPanelItemView.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Incorrect types in method signature: (TV;I)V */
    public final void invoke(SelectionPanelItemView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        SelectionPanelView.a((SelectionPanelView) ZeusTransformUtils.preCheckCast(this.receiver, SelectionPanelView.class, "com.obric.memorydata.plugin"), r3, r4);
    }
}
