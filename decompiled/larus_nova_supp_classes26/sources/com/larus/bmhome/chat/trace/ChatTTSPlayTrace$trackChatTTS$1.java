package com.larus.bmhome.chat.trace;

import android.app.Application;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.c1;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatTTSPlayTrace$trackChatTTS$1", f = "ChatTTSPlayTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTTSPlayTrace$trackChatTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $chatMessage;
    final /* synthetic */ long $playTotalDuration;
    final /* synthetic */ String $toTtsSpeakerId;
    final /* synthetic */ String $trackVoiceID;
    int label;

    public ChatTTSPlayTrace$trackChatTTS$1(Message r1, String r2, String r3, long r4, Continuation<? super ChatTTSPlayTrace$trackChatTTS$1> r6) {
        this.$chatMessage = r1;
        this.$trackVoiceID = r2;
        this.$toTtsSpeakerId = r3;
        this.$playTotalDuration = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatTTSPlayTrace$trackChatTTS$1(this.$chatMessage, this.$trackVoiceID, this.$toTtsSpeakerId, this.$playTotalDuration, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L80;
        ResultKt.throwOnFailure(r28);
        BotInfoCache r1 = BotInfoCache.INSTANCE;
        String r2 = this.$chatMessage.getConversationId();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        String r6 = r1.getBotId(r2);
        String r4 = this.$chatMessage.getMessageId();
        String r5 = this.$chatMessage.getConversationId();
        Function0<String> r3 = ChatTTSPlayTrace.j;
        if (r3 == null) goto L10;
        String r7 = (String) r3.invoke();
    L11:
        String r10 = ChatTTSPlayTrace.h;
        String r11 = ChatTTSPlayTrace.g;
        AudioServiceDelegate r8 = AudioServiceDelegate.a;
        BotModel r9 = r8.i0().i();
        if (r9 == null) goto L16;
        SpeakerVoice r12 = r9.getVoiceType();
        if (r12 == null) goto L16;
        String r13 = r12.getStyleId();
    L17:
        BotModel r14 = r8.i0().i();
        if (r14 == null) goto L22;
        SpeakerVoice r15 = r14.getVoiceType();
        if (r15 == null) goto L22;
        String r16 = r15.getName();
    L23:
        String r17 = CollectionsKt.joinToString$default(ChatTTSPlayTrace.m, ",", null, null, 0, null, null, 62, null);
        String r18 = CollectionsKt.joinToString$default(ChatTTSPlayTrace.n, ",", null, null, 0, null, null, 62, null);
        long r19 = System.currentTimeMillis() - ChatTTSPlayTrace.i;
        String r20 = l3.f(Boxing.boxBoolean(com.larus.im.bean.message.a.C0(this.$chatMessage)));
        if (r20 != null) goto L26;
        r20 = TriggerSendLoading.NO_LOADING;
    L26:
        by7.e r21 = ChatTTSPlayTrace.c;
        JSONObject r110 = new JSONObject();
        Message r22 = this.$chatMessage;
        long r23 = this.$playTotalDuration;
        String r24 = r20;
        r110.put("is_message_finished_generation", !com.larus.bmhome.chat.bean.d.Q0(r22) ? 1 : 0);
        l0.a.getClass();
        s r25 = l0.a.b.get(r22.getMessageId());
        if (r25 == null) goto L31;
        String r26 = r17;
        if (r25.n != true) goto L32;
        boolean r27 = true;
    L33:
        if (r27 == true) goto L35;
    L37:
        long r29 = 0;
    L38:
        String r30 = r16;
        r110.put("is_message_fully_shown", r29);
        r110.put("duration", r23);
        String r31 = com.larus.im.bean.message.a.K(r22);
        if (r31 == null) goto L41;
        Object r32 = Boxing.boxInt(r31.length());
    L42:
        r110.put("content_length", r32);
        m58.y r33 = m58.y.a;
        m58.b r34 = m58.h.k;
        if (r34 == null) goto L45;
        Application r35 = r34.getApplication();
    L46:
        Integer r36 = r33.b(r35);
        if (r36 == null) goto L49;
        int r37 = r36.intValue();
    L50:
        r110.put("tts_speaker_volume", r37);
        r110.put("message_type", r22.getContentType());
        com.larus.bmhome.actionbar.model.r r38 = com.larus.bmhome.actionbar.util.h.a(r22);
        if (r38 == null) goto L53;
        Object r39 = r38.a;
    L54:
        r110.put("action_bar_template_id", r39);
        r110.put("action_bar_key", com.larus.bmhome.chat.bean.d.i(r22));
        if (com.larus.bmhome.chat.bean.d.G0(r22) == false) goto L60;
        String r40 = r22.getLocalMessageId();
        if (r40 == null) goto L76;
    L59:
        String r41 = r40;
    L77:
        r110.put("scene", IAIChatControlTraceService.a.Ia(r41));
        c1.a(r4, r5, r6, r7, this.$trackVoiceID, this.$toTtsSpeakerId, r10, r11, Boxing.boxLong(r19), r13, r30, r26, r18, r24, null, r110, r21, 16384);
        return Unit.INSTANCE;
    L76:
        r41 = "";
        goto L77
    L60:
        wq8.b r42 = ChatTTSPlayTrace.d;
        if (r42 == null) goto L74;
        List<Message> r43 = r42.getCurrentList();
        if (r43 == null) goto L74;
        Iterator<T> r44 = r43.iterator();
    L66:
        if (r44.hasNext() == false) goto L70;
        Object r45 = r44.next();
        if (Intrinsics.areEqual(((Message) r45).getMessageId(), r22.getReplyId()) == false) goto L66;
    L71:
        Message r46 = (Message) r45;
        if (r46 == null) goto L74;
        r40 = r46.getLocalMessageId();
    L75:
        if (r40 != null) goto L59;
    L70:
        r45 = null;
    L74:
        r40 = null;
        goto L75
    L53:
        r39 = null;
        goto L54
    L49:
        r37 = 0;
        goto L50
    L45:
        r35 = null;
        goto L46
    L41:
        r32 = null;
        goto L42
    L35:
        if (r25.o == false) goto L37;
        r29 = 1;
    L32:
        r27 = false;
        goto L33
    L31:
        r26 = r17;
    L22:
        r16 = null;
    L16:
        r13 = null;
        goto L17
    L10:
        r7 = null;
        goto L11
    L80:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
