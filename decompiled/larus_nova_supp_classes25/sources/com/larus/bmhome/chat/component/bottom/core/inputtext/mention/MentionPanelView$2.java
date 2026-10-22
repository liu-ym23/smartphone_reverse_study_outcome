package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MentionPanelView$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public MentionPanelView$2(Object r8) {
        super(0, r8, MentionPanelListView.class, "contentHeightPx", "contentHeightPx()I", 0);
    }

    public final Integer invoke() {
        MentionPanelListView r0 = (MentionPanelListView) ((CallableReference) this).receiver;
        int r1 = r0.g(r0.k);
        Integer r2 = r0.h;
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L7:
        return Integer.valueOf(Math.max(r1, r3));
    L5:
        r3 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m67invoke() {
        return invoke();
    }
}
