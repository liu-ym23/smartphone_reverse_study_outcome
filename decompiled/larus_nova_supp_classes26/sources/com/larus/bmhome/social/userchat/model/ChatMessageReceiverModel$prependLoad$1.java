package com.larus.bmhome.social.userchat.model;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$prependLoad$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$prependLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vr8.b $callback;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$prependLoad$1(ChatMessageReceiverModel r1, vr8.b r2, Continuation<? super ChatMessageReceiverModel$prependLoad$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatMessageReceiverModel$prependLoad$1(this.this$0, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r20);
        if (this.this$0.n.isEmpty() == true) goto L7;
        Long r1 = this.this$0.w;
        if (r1 == null) goto L11;
        long r2 = r1.longValue();
    L12:
        long r8 = r2 + (((long) this.this$0.G.b()) * 1000);
        FLogger.a.i("ChatMessageReceiverModel#prependLoad", "requestMaxIndex: " + r8);
        this.this$0.M.b(LoadState.LOADING);
        ChatMessageReceiverModel r5 = this.this$0;
        ChatMessageReceiverModel.n(r5, r5.b, r5.c, r8, false, r5.G.b(), 0, com.larus.bmhome.social.page.datasource.event.e.a.b.a, this.$callback, this.this$0.M, false, 552);
        return Unit.INSTANCE;
    L11:
        r2 = Long.MIN_VALUE;
        goto L12
    L7:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
