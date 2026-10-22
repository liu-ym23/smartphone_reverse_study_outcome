package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle$Event;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.speaker.ChatSpeakerPressLifecycle$observe$2", f = "ChatSpeakerPressLifecycle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSpeakerPressLifecycle$observe$2 extends SuspendLambda implements Function3<FlowCollector<? super e.c>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ e this$0;

    public ChatSpeakerPressLifecycle$observe$2(e r1, Continuation<? super ChatSpeakerPressLifecycle$observe$2> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super e.c> r2, Throwable r3, Continuation<? super Unit> r4) {
        ChatSpeakerPressLifecycle$observe$2 r5 = new ChatSpeakerPressLifecycle$observe$2(this.this$0, r4);
        r5.L$0 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        Throwable r5 = (Throwable) this.L$0;
        FLogger.a.e("ChatSpeakerPressLifecycle", "[" + this.this$0.d + "][observe error: " + r5.getMessage(), r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
