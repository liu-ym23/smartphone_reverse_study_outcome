package com.larus.bmhome.chat;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class CommonChatListFragment$showScreenMenu$1$2$1$actionExecutor$1 extends FunctionReferenceImpl implements Function1<a, String> {
    public CommonChatListFragment$showScreenMenu$1$2$1$actionExecutor$1(Object r8) {
        super(1, r8, CommonChatListFragment.class, "getRecommendFromString", "getRecommendFromString(Lcom/larus/bmhome/chat/model/api/ConversationData;)Ljava/lang/String;", 0);
    }

    public final String invoke(a r2) {
        return ((CommonChatListFragment) ((CallableReference) this).receiver).aa0(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }
}
