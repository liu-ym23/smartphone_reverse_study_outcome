package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.tts.TtsScene;
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
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ String $streamEndTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1(ChatMessageReceiverModel r1, String r2, Message r3, Continuation<? super ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1> r4) {
        this.this$0 = r1;
        this.$streamEndTraceId = r2;
        this.$message = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1(this.this$0, this.$streamEndTraceId, this.$message, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r8);
        RefreshTraceSource r5 = RefreshTraceSource.STREAM_END;
        ChatMessageReceiverModel.u(this.this$0, null, "onStreamEnd", this.$streamEndTraceId, r5, 3);
        ChatMessageReceiverModel r9 = this.this$0;
        r9.getClass();
        if (com.larus.platform.exp.h.a == true) goto L7;
        boolean r10 = z2.a.enableTtsWhenStreaming();
    L8:
        if (r10 == false) goto L11;
        ChatMessageReceiverModel r11 = this.this$0;
        r11.u.a(r11.r, r11.n, this.$message, TtsScene.Auto_Streaming);
    L11:
        return Unit.INSTANCE;
    L7:
        r10 = r9.v;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
