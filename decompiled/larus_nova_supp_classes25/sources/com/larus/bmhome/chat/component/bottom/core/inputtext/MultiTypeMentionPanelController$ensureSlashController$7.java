package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MultiTypeMentionPanelController$ensureSlashController$7 extends FunctionReferenceImpl implements Function1<k1, Boolean> {
    public MultiTypeMentionPanelController$ensureSlashController$7(Object r8) {
        super(1, r8, MultiTypeMentionPanelController.class, "consumeQuery", "consumeQuery(Lcom/larus/bmhome/chat/component/bottom/core/inputtext/MultiTypePanelQueryRange;)Z", 0);
    }

    public final Boolean invoke(k1 r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        MultiTypeMentionPanelController r0 = (MultiTypeMentionPanelController) ((CallableReference) this).receiver;
        int r1 = MultiTypeMentionPanelController.c0;
        return Boolean.valueOf(r0.c(r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((k1) r1);
    }
}
