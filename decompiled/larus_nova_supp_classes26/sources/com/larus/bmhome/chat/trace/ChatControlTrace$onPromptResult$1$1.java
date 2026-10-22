package com.larus.bmhome.chat.trace;

import android.os.Bundle;
import android.os.SystemClock;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace$onPromptResult$1$1", f = "ChatControlTrace.kt", i = {}, l = {2904}, m = "invokeSuspend", n = {}, s = {})
public final class ChatControlTrace$onPromptResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errResult;
    final /* synthetic */ Message $msg;
    final /* synthetic */ Message $this_with;
    final /* synthetic */ String $token;
    int label;

    public ChatControlTrace$onPromptResult$1$1(String r1, Message r2, String r3, Message r4, Continuation<? super ChatControlTrace$onPromptResult$1$1> r5) {
        this.$token = r1;
        this.$msg = r2;
        this.$errResult = r3;
        this.$this_with = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatControlTrace$onPromptResult$1$1(this.$token, this.$msg, this.$errResult, this.$this_with, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        Long r9 = ChatControlTrace.g0.remove(this.$token);
        if (r9 == null) goto L34;
        long r2 = r9.longValue();
        List r10 = this.$msg.getSuggestQuestions();
        if (r10 == null) goto L16;
        int r11 = r10.size();
    L17:
        Pair[] r4 = new Pair[8];
        if (this.$errResult != null) goto L20;
        String r5 = "1";
    L21:
        r4[0] = TuplesKt.to("success", r5);
        String r3 = this.$this_with.getReplyId();
        String r6 = "";
        if (r3 != null) goto L24;
        r3 = "";
    L24:
        r4[1] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r3);
        String r7 = this.$this_with.getConversationId();
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        r4[2] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r7);
        String r12 = this.$this_with.getSectionId();
        if (r12 == null) goto L31;
        r6 = r12;
    L31:
        r4[3] = TuplesKt.to("section_id", r6);
        r4[4] = TuplesKt.to("result", this.$errResult);
        r4[5] = TuplesKt.to("duration", Boxing.boxLong(SystemClock.elapsedRealtime() - r2));
        r4[6] = TuplesKt.to("quantity", Boxing.boxInt(r11));
        r4[7] = TuplesKt.to("use_nickname", this.$msg.isConnectCallerName());
        Bundle r13 = com.larus.utils.f.c(r4);
        com.larus.platform.service.o.a.b("receive_prompt", r13);
        ChatControlTrace.f0.remove(this.$token);
        return Unit.INSTANCE;
    L20:
        r5 = TriggerSendLoading.NO_LOADING;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L34:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
