package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class AnswerActionGenerator$buildTtsAction$1$creator$1 extends FunctionReferenceImpl implements Function0<Long> {
    public AnswerActionGenerator$buildTtsAction$1$creator$1(Object r8) {
        super(0, r8, a2.class, "getUniqueChatKey", "getUniqueChatKey()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(((a2) ((CallableReference) this).receiver).b());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m94invoke() {
        return invoke();
    }
}
