package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MentionPanelView$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public MentionPanelView$3(Object r8) {
        super(0, r8, MentionPanelListView.class, "unlockHeight", "unlockHeight()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m68invoke() {
        MentionPanelListView r0 = (MentionPanelListView) ((CallableReference) this).receiver;
        r0.f(true);
        r0.j(0);
        r0.h = null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m68invoke();
        return Unit.INSTANCE;
    }
}
