package com.obric.assistant.component.clicktalk;

import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2", f = "ChatClickTalkComponent.kt", i = {}, l = {918}, m = "invokeSuspend", n = {}, s = {})
public final class ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    int label;
    final /* synthetic */ ChatClickTalkComponent this$0;

    public ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2(ChatClickTalkComponent r1, Continuation<? super ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super wc9.e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ChatClickTalkComponent r8 = this.this$0;
        this.label = 1;
        int r2 = ChatClickTalkComponent.L0;
        r8.getClass();
        e r3 = new e(r8);
        r7 = TimeoutKt.c(RangesKt.coerceAtLeast(ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS, 0), new ChatClickTalkComponent$suspendCoroutine$2(r3, null), this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
