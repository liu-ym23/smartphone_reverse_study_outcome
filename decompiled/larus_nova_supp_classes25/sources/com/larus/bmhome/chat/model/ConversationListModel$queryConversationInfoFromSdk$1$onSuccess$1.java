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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1", f = "ConversationListModel.kt", i = {}, l = {818}, m = "invokeSuspend", n = {}, s = {})
final class ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.j $result;
    final /* synthetic */ String $source;
    int label;

    public ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1(String r1, wc9.j r2, Continuation<? super ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1> r3) {
        this.$source = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1(this.$source, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        CompletableDeferred<Boolean> r7 = ConversationListModel.f;
        if (r7 == null) goto L19;
        Boxing.boxBoolean(r7.complete(Boxing.boxBoolean(true)));
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FLogger r8 = FLogger.a;
        StringBuilder r2 = new StringBuilder("queryConversationInfoFromSdkV2 source=");
        r2.append(this.$source);
        r2.append(" success: size = ");
        List r3 = this.$result.a;
        if (r3 == null) goto L11;
        Integer r4 = Boxing.boxInt(r3.size());
    L12:
        r2.append(r4);
        r2.append(", done = ");
        r2.append(this.$result.b);
        r8.w("ConversationListModel_IMSDK", r2.toString());
        ConversationListModel r9 = ConversationListModel.a;
        wc9.j r10 = this.$result;
        ConversationListModel.v = r10.b;
        ConversationListModel r5 = ConversationListModel.a;
        List r11 = r10.a;
        String r12 = this.$source;
        r5.getClass();
        String r13 = ConversationListModel.k(r12, "getPagingCvsList");
        this.label = 1;
        if (ConversationListModel.i(r5, r11, true, r13, this) != r0) goto L15;
        return r0;
    L11:
        r4 = null;
        goto L12
    }
}
