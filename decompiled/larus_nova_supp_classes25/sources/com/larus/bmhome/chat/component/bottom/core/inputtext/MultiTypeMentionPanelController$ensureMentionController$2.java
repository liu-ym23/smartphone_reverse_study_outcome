package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MultiTypeMentionPanelController$ensureMentionController$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiTypeMentionPanelController$ensureMentionController$2(Object r8) {
        super(0, r8, MultiTypeMentionPanelController.class, "switchMentionToSkillPanel", "switchMentionToSkillPanel()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m61invoke() {
        MultiTypeMentionPanelController r0 = (MultiTypeMentionPanelController) ((CallableReference) this).receiver;
        if (r0.A == false) goto L22;
        k1 r1 = r0.G;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.d != MultiTypePanelTrigger.MENTION) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r1 = null;
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        if (r0.c(r1) == false) goto L23;
        r0.n(false);
        return;
    L23:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m61invoke();
        return Unit.INSTANCE;
    }
}
