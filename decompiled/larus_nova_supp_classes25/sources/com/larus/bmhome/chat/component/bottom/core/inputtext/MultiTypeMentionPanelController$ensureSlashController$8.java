package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MultiTypeMentionPanelController$ensureSlashController$8 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiTypeMentionPanelController$ensureSlashController$8(Object r8) {
        super(0, r8, MultiTypeMentionPanelController.class, "showProjectPanelFromSlash", "showProjectPanelFromSlash()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m64invoke() {
        MultiTypeMentionPanelController r0 = (MultiTypeMentionPanelController) ((CallableReference) this).receiver;
        int r1 = r0.T.getSelectionStart();
        if (r1 >= 0) goto L5;
        return;
    L5:
        if (r1 != r0.T.getSelectionEnd()) goto L10;
        r0.G = new k1(r1, r1, "", MultiTypePanelTrigger.EXTERNAL_SKILL);
        r0.H = Integer.valueOf(r1);
        r0.M = false;
        r0.q();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m64invoke();
        return Unit.INSTANCE;
    }
}
