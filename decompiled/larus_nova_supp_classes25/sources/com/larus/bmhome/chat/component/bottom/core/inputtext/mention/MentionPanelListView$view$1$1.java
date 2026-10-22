package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MentionPanelListView$view$1$1 extends FunctionReferenceImpl implements Function1<Integer, String> {
    public MentionPanelListView$view$1$1(Object r8) {
        super(1, r8, MentionPanelListView.PanelAdapter.class, "headerTitleAt", "headerTitleAt(I)Ljava/lang/String;", 0);
    }

    public final String invoke(int r4) {
        MentionPanelListView.PanelAdapter r0 = (MentionPanelListView.PanelAdapter) ((CallableReference) this).receiver;
        if (r0.c == false) goto L11;
        Object r5 = CollectionsKt.getOrNull(r0.a, r4);
        if ((r5 instanceof y.a) == false) goto L7;
        y.a r6 = (y.a) r5;
    L8:
        if (r6 != null) goto L10;
        return null;
    L10:
        return r6.a;
    L7:
        r6 = null;
        goto L8
    L11:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
