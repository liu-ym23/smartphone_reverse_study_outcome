package com.larus.tts.impl;

import com.larus.bmhome.chat.model.repo.x1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {1043}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $readMessage;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1(ChatTitleTtsComponent r1, Message r2, Continuation<? super ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1> r3) {
        this.this$0 = r1;
        this.$readMessage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1(this.this$0, this.$readMessage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("ChatTitleTtsComponent", "[TTS] tryStartTtsWhenTtsOpen");
        Integer r14 = m58.y.a.b(AppHost.a.getApplication());
        boolean r2 = false;
        if (r14 == null) goto L11;
        int r15 = r14.intValue();
    L13:
        if (z2.a.T2() == 0) goto L15;
        r2 = true;
    L15:
        if (r15 > 0) goto L17;
        if (r2 == false) goto L21;
    L17:
        ChatTitleTtsComponent r16 = this.this$0;
        int r3 = ChatTitleTtsComponent.v;
        x1 r4 = r16.X2();
        Message r5 = this.$readMessage;
        TtsScene r9 = TtsScene.Auto_Other;
        this.label = 1;
        if (x1.b.b(r4, r5, null, false, "click_tts_icon", null, r9, this, 54) != r0) goto L21;
        return r0;
    L11:
        r15 = 0;
        goto L13
    }
}
