package com.larus.bmhome.chat.trace;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageTrace$onMessageDelete$1", f = "ChatMessageTrace.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"isTTSReading"}, s = {"Z$0"})
final class ChatMessageTrace$onMessageDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Integer $botType;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ Message $data;
    final /* synthetic */ JSONObject $traceInfo;
    boolean Z$0;
    int label;

    public ChatMessageTrace$onMessageDelete$1(Message r1, String r2, JSONObject r3, Integer r4, String r5, Continuation<? super ChatMessageTrace$onMessageDelete$1> r6) {
        this.$data = r1;
        this.$botId = r2;
        this.$traceInfo = r3;
        this.$botType = r4;
        this.$clickFrom = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatMessageTrace$onMessageDelete$1(this.$data, this.$botId, this.$traceInfo, this.$botType, this.$clickFrom, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        boolean r3 = this.Z$0;
        ResultKt.throwOnFailure(r21);
        Object r4 = r21;
    L12:
        SpeakerVoice r5 = (SpeakerVoice) r4;
        JSONObject r18 = yc9.c0.c(this.$data, this.$traceInfo);
        String r8 = this.$data.getConversationId();
        if (com.larus.bmhome.chat.bean.d.z0(this.$data) == false) goto L15;
        String r6 = "1";
    L16:
        String r9 = r6;
        if (r3 == false) goto L19;
        long r7 = 1;
    L20:
        String r11 = this.$data.getMessageId();
        String r12 = com.larus.bmhome.chat.bean.d.B(this.$data);
        Map r17 = com.larus.bmhome.chat.bean.d.l(this.$data);
        if (com.larus.bmhome.chat.bean.d.G0(this.$data) == false) goto L23;
        String r10 = "user";
    L24:
        String r13 = r10;
        if (r3 == false) goto L32;
        if (r5 == null) goto L28;
        String r14 = r5.getId();
    L29:
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        Long r15 = StringsKt.toLongOrNull(r14);
    L33:
        if (r3 == false) goto L36;
        if (r5 == null) goto L36;
        String r16 = r5.getStyleId();
    L37:
        if (r3 == false) goto L40;
        if (r5 == null) goto L40;
        String r19 = r5.getName();
    L41:
        z1.b(this.$botId, this.$botType, this.$clickFrom, r8, r9, Boxing.boxLong(r7), r11, r12, r13, r15, r16, r19, r17, r18, 16384);
        return Unit.INSTANCE;
    L40:
        r19 = null;
    L36:
        r16 = null;
        goto L37
    L28:
        r14 = null;
        goto L29
    L32:
        r15 = null;
        goto L33
    L23:
        r10 = "bot";
        goto L24
    L19:
        r7 = 0;
        goto L20
    L15:
        r6 = TriggerSendLoading.NO_LOADING;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        int r20 = com.larus.bmhome.chat.model.a0.a;
        boolean r22 = com.larus.bmhome.chat.model.a0.b(this.$data);
        ChatMessageTrace r23 = ChatMessageTrace.a;
        String r24 = this.$botId;
        this.Z$0 = r22;
        this.label = 1;
        r4 = ChatMessageTrace.b(r23, r24, this);
        if (r4 != r1) goto L11;
        return r1;
    L11:
        r3 = r22;
        goto L12
    }
}
