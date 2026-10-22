package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class InputPanelListView$view$1$1 extends FunctionReferenceImpl implements Function1<Integer, String> {
    public InputPanelListView$view$1$1(Object r8) {
        super(1, r8, InputPanelListView.c.class, "headerTitleAt", "headerTitleAt(I)Ljava/lang/String;", 0);
    }

    public final String invoke(int r3) {
        Object r4 = CollectionsKt.getOrNull(((InputPanelListView.c) ((CallableReference) this).receiver).a, r3);
        if ((r4 instanceof o.b) == false) goto L5;
        o.b r5 = (o.b) r4;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.a;
    L5:
        r5 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
