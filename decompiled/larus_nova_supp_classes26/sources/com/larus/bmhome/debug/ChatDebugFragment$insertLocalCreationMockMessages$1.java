package com.larus.bmhome.debug;

import android.content.Context;
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
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment$insertLocalCreationMockMessages$1", f = "ChatDebugFragment.kt", i = {}, l = {606}, m = "invokeSuspend", n = {}, s = {})
final class ChatDebugFragment$insertLocalCreationMockMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ ChatDebugFragment this$0;

    public ChatDebugFragment$insertLocalCreationMockMessages$1(ChatDebugFragment r1, String r2, String r3, Context r4, Continuation<? super ChatDebugFragment$insertLocalCreationMockMessages$1> r5) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$botId = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatDebugFragment$insertLocalCreationMockMessages$1(this.this$0, this.$conversationId, this.$botId, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        int r6 = ((Number) r5).intValue();
        if (r6 <= 0) goto L14;
        t19.s r2 = t19.s.a;
        r2.getClass();
        t19.s.p(this.$context, "已复用 " + r6 + " 条 bot block 消息注入 local mock 内容");
    L16:
        return Unit.INSTANCE;
    L14:
        t19.s r7 = t19.s.a;
        Context r3 = this.$context;
        r7.getClass();
        t19.s.t(r3, "当前会话内未找到可复用的真实 bot creation block 消息，未执行 local mock 覆盖");
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatDebugFragment r8 = this.this$0;
        String r4 = this.$conversationId;
        String r9 = this.$botId;
        this.label = 1;
        r5 = ChatDebugFragment.S90(r8, r4, r9, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
