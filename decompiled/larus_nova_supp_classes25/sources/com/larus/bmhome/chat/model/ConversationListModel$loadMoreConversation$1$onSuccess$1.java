package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$loadMoreConversation$1$onSuccess$1", f = "ConversationListModel.kt", i = {}, l = {876}, m = "invokeSuspend", n = {}, s = {})
final class ConversationListModel$loadMoreConversation$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.j $result;
    final /* synthetic */ String $source;
    int label;

    public ConversationListModel$loadMoreConversation$1$onSuccess$1(String r1, wc9.j r2, Continuation<? super ConversationListModel$loadMoreConversation$1$onSuccess$1> r3) {
        this.$source = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationListModel$loadMoreConversation$1$onSuccess$1(this.$source, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        ConversationListModel.w = false;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger r8 = FLogger.a;
        StringBuilder r2 = new StringBuilder("loadMoreConversation source=");
        r2.append(this.$source);
        r2.append(" success: size = ");
        List r4 = this.$result.a;
        if (r4 == null) goto L11;
        Integer r5 = Boxing.boxInt(r4.size());
    L12:
        r2.append(r5);
        r2.append(", done = ");
        r2.append(this.$result.b);
        r8.i("ConversationListModel_IMSDK", r2.toString());
        ConversationListModel r9 = ConversationListModel.a;
        wc9.j r10 = this.$result;
        ConversationListModel.v = r10.b;
        ConversationListModel r3 = ConversationListModel.a;
        List r11 = r10.a;
        String r6 = this.$source;
        r3.getClass();
        String r12 = ConversationListModel.k(r6, "success");
        this.label = 1;
        if (ConversationListModel.i(r3, r11, false, r12, this) != r0) goto L15;
        return r0;
    L11:
        r5 = null;
        goto L12
    }
}
