package com.larus.feedback.impl.service;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector$collect$messageLists$1$1$1", f = "RecentFeedbackMessageCollector.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class RecentFeedbackMessageCollector$collect$messageLists$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Message>>, Object> {
    final /* synthetic */ e $conversation;
    int label;

    public RecentFeedbackMessageCollector$collect$messageLists$1$1$1(e r1, Continuation<? super RecentFeedbackMessageCollector$collect$messageLists$1$1$1> r2) {
        this.$conversation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecentFeedbackMessageCollector$collect$messageLists$1$1$1(this.$conversation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Message>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        return r18;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        RecentFeedbackMessageCollector r3 = RecentFeedbackMessageCollector.a;
        e r4 = this.$conversation;
        this.label = 1;
        j r5 = new j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        String r7 = r4.a;
        Integer r6 = r4.j;
        if (r6 == null) goto L11;
        int r8 = r6.intValue();
    L12:
        MessageListRequest r9 = new MessageListRequest(r7, r8, 0, 20, 0, null, false, 116, null);
        d.e().getMessageListFromLocal(r9, new c(r5));
        Object r10 = r5.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r10 != r1) goto L18;
        return r1;
    L18:
        return r10;
    L11:
        r8 = 1;
        goto L12
    }
}
