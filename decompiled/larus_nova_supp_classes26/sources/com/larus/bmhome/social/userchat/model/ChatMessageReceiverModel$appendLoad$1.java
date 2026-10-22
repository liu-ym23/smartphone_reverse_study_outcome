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
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$appendLoad$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$appendLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vr8.b $callback;
    final /* synthetic */ Integer $messageLimit;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$appendLoad$1(ChatMessageReceiverModel r1, vr8.b r2, Integer r3, Continuation<? super ChatMessageReceiverModel$appendLoad$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$messageLimit = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$appendLoad$1(this.this$0, this.$callback, this.$messageLimit, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r21);
        if (com.larus.platform.exp.p.e == false) goto L15;
        if (this.this$0.L.a() == LoadState.READY_TO_LOAD) goto L15;
        if (this.this$0.L.a() != LoadState.COMPLETE) goto L11;
        this.$callback.a(com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a, this.this$0.n.size(), true);
    L13:
        return Unit.INSTANCE;
    L11:
        this.$callback.b(com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a);
    L15:
        if (this.this$0.n.isEmpty() == true) goto L17;
        Long r1 = this.this$0.x;
        if (r1 == null) goto L24;
        long r4 = r1.longValue();
    L25:
        long r9 = r4;
        if (r9 > 1000) goto L32;
        FLogger.a.w("ChatMessageReceiverModel#appendLoad", "try to append load from illegal cursor: " + r9 + ", Abort");
        this.$callback.a(com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a, this.this$0.n.size(), true);
        ChatMessageReceiverModel.c r2 = this.this$0.q;
        if (r2 == null) goto L31;
        r2.b(null);
    L31:
        return Unit.INSTANCE;
    L32:
        FLogger.a.i("ChatMessageReceiverModel#appendLoad", "requestMaxIndex: " + r9);
        this.this$0.L.b(LoadState.LOADING);
        ChatMessageReceiverModel r6 = this.this$0;
        String r7 = r6.b;
        int r8 = r6.c;
        Integer r3 = this.$messageLimit;
        if (r3 == null) goto L35;
        int r5 = r3.intValue();
    L36:
        ChatMessageReceiverModel.n(r6, r7, r8, r9, false, r5, 0, com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a, this.$callback, null, false, 808);
        return Unit.INSTANCE;
    L35:
        r5 = r6.G.b();
        goto L36
    L24:
        r4 = Long.MAX_VALUE;
        goto L25
    L17:
        if (this.this$0.N == true) goto L20;
        FLogger.a.i("ChatMessageReceiverModel#appendLoad", "add pendingAppendLoadCallback before initLoaded");
        this.this$0.O = this.$callback;
    L20:
        return Unit.INSTANCE;
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
