package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ChatInputMentionPanelController$officeMentionConfig$1 extends FunctionReferenceImpl implements Function0<String> {
    public ChatInputMentionPanelController$officeMentionConfig$1(Object r8) {
        super(0, r8, CoreInputAbility.class, "getConversationId", "getConversationId()Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m59invoke() {
        return ((CoreInputAbility) ((CallableReference) this).receiver).v();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m59invoke();
    }
}
