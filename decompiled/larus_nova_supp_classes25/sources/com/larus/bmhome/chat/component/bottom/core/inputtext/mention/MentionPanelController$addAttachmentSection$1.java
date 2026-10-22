package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MentionPanelController$addAttachmentSection$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public MentionPanelController$addAttachmentSection$1(Object r8) {
        super(0, r8, MentionPanelController.class, "openAttachmentDomain", "openAttachmentDomain()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m65invoke() {
        MentionPanelController r0 = (MentionPanelController) ((CallableReference) this).receiver;
        if (r0.x == MentionPanelController.Page.ROOT) goto L5;
        return;
    L5:
        if (r0.J == false) goto L13;
        k1 r1 = r0.n;
        if (r1 == null) goto L14;
        MentionPanelListView.f r2 = r0.c.a(MentionPanelSection.ATTACHMENT);
        r0.c.b();
        r0.x = MentionPanelController.Page.ATTACHMENT_DOMAIN;
        r0.y = null;
        r0.Q.setEnabled(true);
        r0.p(r1);
        r0.c.c(r2);
        return;
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m65invoke();
        return Unit.INSTANCE;
    }
}
