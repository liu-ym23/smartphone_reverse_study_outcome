package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MentionPanelController$addSkillSection$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public MentionPanelController$addSkillSection$2(Object r8) {
        super(0, r8, MentionPanelController.class, "openSkillDomain", "openSkillDomain()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m66invoke() {
        MentionPanelController r0 = (MentionPanelController) ((CallableReference) this).receiver;
        if (r0.x != MentionPanelController.Page.ROOT) goto L20;
        k1 r1 = r0.n;
        if (r1 != null) goto L8;
        return;
    L8:
        if (StringsKt.trim(r1.c).toString().length() <= 0) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L19;
        MentionPanelListView.f r3 = r0.c.a(MentionPanelSection.SKILL);
        r0.c.b();
        r0.x = MentionPanelController.Page.SKILL_DOMAIN;
        r0.y = null;
        r0.Q.setEnabled(true);
        r0.p(r1);
        r0.c.c(r3);
        return;
    L19:
        return;
    L10:
        r2 = false;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m66invoke();
        return Unit.INSTANCE;
    }
}
