package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MultiTypeMentionPanelController$ensureProjectController$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiTypeMentionPanelController$ensureProjectController$3(Object r8) {
        super(0, r8, MultiTypeMentionPanelController.class, "finishProjectPanel", "finishProjectPanel()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m63invoke() {
        MultiTypeMentionPanelController r0 = (MultiTypeMentionPanelController) ((CallableReference) this).receiver;
        r0.M = false;
        k1 r1 = r0.G;
        if (r1 == null) goto L5;
        r0.c(r1);
    L5:
        r0.k(MultiTypePanelTrigger.SLASH);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m63invoke();
        return Unit.INSTANCE;
    }
}
