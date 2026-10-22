package com.larus.bmhome.chat.trace;

import android.app.Application;
import com.larus.bmhome.music.applet.MusicAppletPage;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatTTSPlayTrace$mobTTSStart$1", f = "ChatTTSPlayTrace.kt", i = {0, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {196, 198, 209, 214}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "playingMsg", "extra", "botId", "$this$launch", "playingMsg", "extra", "botModel"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class ChatTTSPlayTrace$mobTTSStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msgId;
    final /* synthetic */ JSONObject $traceInfo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public ChatTTSPlayTrace$mobTTSStart$1(String r1, JSONObject r2, Continuation<? super ChatTTSPlayTrace$mobTTSStart$1> r3) {
        this.$msgId = r1;
        this.$traceInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatTTSPlayTrace$mobTTSStart$1 r0 = new ChatTTSPlayTrace$mobTTSStart$1(this.$msgId, this.$traceInfo, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r9 = "";
        String r11 = null;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        BotModel r3 = (BotModel) this.L$3;
        JSONObject r4 = (JSONObject) this.L$2;
        Message r6 = (Message) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        Message r8 = r6;
        Object r10 = r24;
    L70:
        wc9.e r12 = (wc9.e) r10;
        if (r12 != null) goto L74;
        r4.put(MusicAppletPage.KEY_CONVERSATION_ID, r8.getConversationId());
        ChatTTSPlayTrace.e(ChatTTSPlayTrace.b, "conversation_empty", r4);
        return Unit.INSTANCE;
    L74:
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r13 = this.$traceInfo;
        if (r13 != null) goto L77;
        r13 = new JSONObject();
    L77:
        r13.put("start_method", ChatTTSPlayTrace.h);
        r13.put(MusicAppletPage.KEY_MESSAGE_ID, r8.getMessageId());
        m58.y r14 = m58.y.a;
        m58.b r15 = m58.h.k;
        if (r15 == null) goto L80;
        Application r16 = r15.getApplication();
    L81:
        Integer r17 = r14.b(r16);
        if (r17 == null) goto L84;
        int r18 = r17.intValue();
    L85:
        r13.put("tts_speaker_volume", r18);
        r13.put("message_type", r8.getContentType());
        com.larus.bmhome.actionbar.model.r r19 = com.larus.bmhome.actionbar.util.h.a(r8);
        if (r19 == null) goto L88;
        Integer r20 = r19.a;
    L89:
        r13.put("action_bar_template_id", r20);
        r13.put("action_bar_key", com.larus.bmhome.chat.bean.d.i(r8));
        String r21 = l3.f(Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r8)));
        if (r21 != null) goto L92;
        r21 = TriggerSendLoading.NO_LOADING;
    L92:
        r13.put("is_deep_thinking", r21);
        if (com.larus.bmhome.chat.bean.d.G0(r8) == false) goto L95;
        String r22 = r8.getLocalMessageId();
    L112:
        IAIChatControlTraceService.Companion r23 = IAIChatControlTraceService.a;
        if (r22 == null) goto L116;
        r9 = r22;
    L116:
        r13.put("scene", r23.Ia(r9));
        if (r3 == null) goto L121;
        SpeakerVoice r25 = r3.getVoiceType();
        if (r25 == null) goto L121;
        String r26 = r25.getStyleId();
    L122:
        r13.put("speaker_id", r26);
        if (r3 == null) goto L127;
        SpeakerVoice r27 = r3.getVoiceType();
        if (r27 == null) goto L127;
        String r28 = r27.getName();
    L128:
        r13.put("speaker_name", r28);
        if (r3 == null) goto L133;
        SpeakerVoice r29 = r3.getVoiceType();
        if (r29 == null) goto L133;
        r11 = r29.getId();
    L133:
        r13.put("voice_id", r11);
        r13.put("bot_id", r8.getSenderId());
        r13.put(MusicAppletPage.KEY_CONVERSATION_ID, r12.a);
        r13.put("chat_type", ic8.n.i(r12));
        Unit r30 = Unit.INSTANCE;
        r5.reportEvent("start_tts", r13);
        return Unit.INSTANCE;
    L127:
        r28 = null;
    L121:
        r26 = null;
        goto L122
    L95:
        wq8.b r31 = ChatTTSPlayTrace.d;
        if (r31 == null) goto L109;
        List<Message> r32 = r31.getCurrentList();
        if (r32 == null) goto L109;
        Iterator<T> r33 = r32.iterator();
    L101:
        if (r33.hasNext() == false) goto L105;
        Object r34 = r33.next();
        if (Intrinsics.areEqual(((Message) r34).getMessageId(), r8.getReplyId()) == false) goto L101;
    L106:
        Message r35 = (Message) r34;
        if (r35 == null) goto L109;
        r22 = r35.getLocalMessageId();
    L110:
        if (r22 != null) goto L112;
        r22 = "";
        goto L112
    L105:
        r34 = null;
    L109:
        r22 = null;
        goto L110
    L88:
        r20 = null;
        goto L89
    L84:
        r18 = 0;
        goto L85
    L80:
        r16 = null;
        goto L81
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        String r36 = (String) this.L$3;
        JSONObject r37 = (JSONObject) this.L$2;
        r8 = (Message) this.L$1;
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        String r111 = r36;
        r4 = r37;
        Object r38 = r24;
    L52:
        BotModel r39 = (BotModel) r38;
        if (r39 != null) goto L56;
        r4.put("bot_id", r111);
        ChatTTSPlayTrace.e(ChatTTSPlayTrace.b, "bot_model_empty", r4);
        return Unit.INSTANCE;
    L56:
        ChatTTSPlayTrace r112 = ChatTTSPlayTrace.b;
        String r113 = r8.getConversationId();
        if (r113 != null) goto L59;
        String r114 = "";
    L60:
        this.L$0 = r110;
        this.L$1 = r8;
        this.L$2 = r4;
        this.L$3 = r39;
        this.label = 4;
        r112.getClass();
        kotlinx.coroutines.j r40 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r40.C();
        com.larus.im.service.r.a.c(com.larus.im.d.d(), r114, true, new e0(r40), null, null, 24);
        r10 = r40.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
        DebugProbesKt.probeCoroutineSuspended(this);
    L64:
        if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r10 = (wc9.e) r10;
    L67:
        if (r10 != r1) goto L69;
        return r1;
    L69:
        r3 = r39;
        goto L70
    L59:
        r114 = r113;
        goto L60
    L12:
        CoroutineScope r41 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        Object r42 = r24;
    L34:
        Message r115 = (Message) r42;
    L35:
        Message r210 = r115;
        r110 = r41;
        JSONObject r43 = new JSONObject();
        r43.put(MusicAppletPage.KEY_MESSAGE_ID, this.$msgId);
        r43.put("playing_msg_id", ChatTTSPlayTrace.f);
        if (r210 != null) goto L39;
        ChatTTSPlayTrace.e(ChatTTSPlayTrace.b, "cur_play_msg_empty", r43);
        return Unit.INSTANCE;
    L39:
        r43.put("message_type", r210.getContentType());
        r111 = r210.getSenderId();
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        ChatTTSPlayTrace r116 = ChatTTSPlayTrace.b;
        this.L$0 = r110;
        this.L$1 = r210;
        this.L$2 = r43;
        this.L$3 = r111;
        this.label = 3;
        r116.getClass();
        kotlinx.coroutines.j r44 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r44.C();
        com.larus.im.d.a().getBot(r111, false, "default", true, new d0(r44));
        r38 = r44.B();
        if (r38 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(this);
    L46:
        if (r38 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        r38 = (BotModel) r38;
    L49:
        if (r38 != r1) goto L51;
        return r1;
    L51:
        r8 = r210;
        r4 = r43;
        goto L52
    L13:
        r41 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
    L17:
        ChatTTSPlayTrace.b.getClass();
        ChatTTSPlayTrace.f();
        r115 = ChatTTSPlayTrace.l;
        if (r115 != null) goto L35;
        String r117 = this.$msgId;
        if (r117 != null) goto L22;
        r117 = "";
    L22:
        this.L$0 = r41;
        this.label = 2;
        if (StringsKt.isBlank(r117) == false) goto L25;
        r42 = null;
    L32:
        if (r42 != r1) goto L34;
        return r1;
    L25:
        kotlinx.coroutines.j r45 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r45.C();
        com.larus.im.d.e().m(r117, new f0(r45));
        r42 = r45.B();
        if (r42 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(this);
    L29:
        if (r42 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        r42 = (Message) r42;
        goto L32
    L14:
        ResultKt.throwOnFailure(r24);
        r41 = (CoroutineScope) this.L$0;
        this.L$0 = r41;
        this.label = 1;
        if (DelayKt.delay(100, this) != r1) goto L17;
        return r1;
    }
}
