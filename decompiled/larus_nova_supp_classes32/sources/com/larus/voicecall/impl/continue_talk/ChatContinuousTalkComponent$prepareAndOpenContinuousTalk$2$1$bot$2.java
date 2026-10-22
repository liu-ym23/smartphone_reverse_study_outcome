package com.larus.voicecall.impl.continue_talk;

import com.larus.im.bean.bot.BotModel;
import com.obric.assistant.AutoEndConversationTime;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/bot/BotModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2", f = "ChatContinuousTalkComponent.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BotModel>, Object> {
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    public ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2(ChatContinuousTalkComponent r1, Continuation<? super ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BotModel> r2) {
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
        ChatContinuousTalkComponent r8 = this.this$0;
        this.label = 1;
        int r2 = ChatContinuousTalkComponent.M;
        r8.getClass();
        m r3 = new m(r8);
        r7 = TimeoutKt.b(RangesKt.coerceAtLeast(AutoEndConversationTime.AFTER_10_SECONDS, 0), new ChatContinuousTalkComponent$suspendCoroutine$2(r3, null), this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
