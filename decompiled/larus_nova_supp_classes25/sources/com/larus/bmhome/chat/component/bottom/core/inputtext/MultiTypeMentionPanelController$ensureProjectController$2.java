package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MultiTypeMentionPanelController$ensureProjectController$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiTypeMentionPanelController$ensureProjectController$2(Object r8) {
        super(0, r8, MultiTypeMentionPanelController.class, "returnToSlashPanel", "returnToSlashPanel()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m62invoke() {
        MultiTypeMentionPanelController r0 = (MultiTypeMentionPanelController) ((CallableReference) this).receiver;
        ProjectPanelController r1 = r0.a0;
        if (r1 == null) goto L6;
        r1.b();
    L6:
        if (r0.M == false) goto L8;
        r0.M = false;
        r0.b(MultiTypePanelTrigger.SLASH);
        return;
    L8:
        k1 r2 = r0.G;
        if (r2 != null) goto L11;
        r0.b(MultiTypePanelTrigger.SLASH);
        return;
    L11:
        SlashPanelController r3 = r0.i();
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r4 = r0.W;
        if (r4 == null) goto L14;
        r4.e.i(true);
    L14:
        r3.l(r2);
        r0.p(true);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m62invoke();
        return Unit.INSTANCE;
    }
}
