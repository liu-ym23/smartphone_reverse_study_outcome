package es8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.holder.helper.s;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import f2a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Map<String, Long> a;
    public final Set<String> b;
    public final Lazy c;
    public final Lazy d;
    public final f2a.d e;
    public b f;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final List<Message> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "PatchSendMessages(collectionId=" + this.a + ", messages=" + this.b + ')';
        }

        public b(String r2, List<Message> r3) {
            Intrinsics.checkNotNullParameter(r3, "messages");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public c() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashSet();
        this.c = LazyKt.lazy(new es8.a());
        this.d = LazyKt.lazy(new es8.b());
        this.e = new f2a.d("ChatCommon", "MessageAutoTtsReader");
    }

    public final boolean b(String r4) {
        if (Intrinsics.areEqual(r4, ((Keva) this.d.getValue()).getString("key.tts.play.sub.msg.id", "")) == false) goto L5;
        return true;
    L5:
        ((Keva) this.d.getValue()).storeString("key.tts.play.sub.msg.id", r4);
        return false;
    }

    public final synchronized void c(Message r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "msg");     // Catch: Throwable -> L27
        if (r4.getMessageStatusLocal() == 11) goto L8;
        monitor-exit(this);
        return;
    L8:
        b r0 = this.f;     // Catch: Throwable -> L27
        if (r0 == null) goto L11;
        String r1 = r0.a;     // Catch: Throwable -> L27
    L12:
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
    L23:
        b r3 = new b(com.larus.im.bean.message.a.g(r4), CollectionsKt.listOf(r4));     // Catch: Throwable -> L27
    L24:
        this.f = r3;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L20:
        if (Intrinsics.areEqual(r1, com.larus.im.bean.message.a.g(r4)) == false) goto L23;
        List r5 = CollectionsKt.plus(r0.b, r4);     // Catch: Throwable -> L27
        String r6 = r0.a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r5, "messages");     // Catch: Throwable -> L27
        r3 = new b(r6, r5);     // Catch: Throwable -> L27
        goto L24
    L14:
        if (r1.length() == 0) goto L17;
        r2 = false;
        goto L18
    L11:
        r1 = null;
    L27:
        th = move-exception;
        throw th;
    }

    public final void d(List<Message> r7) {
        Intrinsics.checkNotNullParameter(r7, "msgList");
        Message r0 = (Message) CollectionsKt.firstOrNull(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getConversationId();
        if (r1 != null) goto L9;
        return;
    L9:
        if (ObricTtsControlDelegate.b.e() == false) goto L11;
    L12:
        int r2 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r0, "message");
        if (com.larus.im.bean.message.a.r0(r0) == false) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L23;
        FLogger.a.i("MsgAutoReader", "[TTS] is loading or deep thinking case, skip update index");
        return;
    L23:
        if (com.larus.bmhome.chat.bean.d.G0(r0) == false) goto L25;
    L30:
        int r4 = ChatMessageReceiverModel.P;
        long r5 = ChatMessageReceiverModel.a.a(r7);
        Long r8 = (Long) ((LinkedHashMap) this.a).get(r1);
        if (r8 != null) goto L33;
    L34:
        this.a.put(r1, Long.valueOf(r5));
        f2a.c r9 = this.e.b("[TTS] updateTTSRecord update play index:  " + r5);
        r9.c.b = CollectionsKt.listOf("TtsPlay");
        f2a.c.c(r9, null, 15);
        return;
    L33:
        if (r5 > r8.longValue()) goto L34;
        return;
    L25:
        if (com.larus.bmhome.chat.bean.d.C0(r0) == false) goto L30;
        if (com.larus.im.bean.message.a.n0(r0) == true) goto L30;
        FLogger.a.i("MsgAutoReader", "[TTS] is regen message cases, skip update index");
        return;
    L15:
        if (com.larus.bmhome.chat.bean.d.f0(r0) == true) goto L18;
        r3 = false;
        goto L19
    L11:
        if (z2.a.skipUpdateIndexWhenLoading() == false) goto L23;
        goto L12
    }

    public final void a(ChatMessageReceiverModel.d r26, List r27, Message r28, TtsScene r29) {
        Intrinsics.checkNotNullParameter(r27, "messageList");
        Intrinsics.checkNotNullParameter(r28, "msg");
        Intrinsics.checkNotNullParameter(r29, "fromScene");
        if (r26 != null) goto L5;
        return;
    L5:
        String r11 = "";
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r27), r28) == true) goto L8;
    L28:
        boolean r5 = false;
    L29:
        if (r5 == true) goto L55;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r27), r28) == false) goto L55;
        if (com.larus.im.bean.message.a.E0(r28) == false) goto L55;
        List r12 = s.a(r28);
        if (r12 == null) goto L37;
        Message r13 = (Message) CollectionsKt.firstOrNull(r12);
    L38:
        if (r13 == null) goto L55;
        String r14 = r13.getMessageId();
        if (r14 != null) goto L42;
    L44:
        boolean r10 = false;
    L45:
        if (r10 == true) goto L55;
        if (com.larus.im.bean.message.a.r0(r13) == true) goto L55;
        String r15 = r28.getMessageId();
        if (r15 != null) goto L52;
        r15 = "";
    L52:
        if (b(r15) == true) goto L55;
        r26.a(r13, r29);
        r5 = true;
        goto L55
    L42:
        if (StringsKt.contains$default(r14, "#", false, 2, null) != true) goto L44;
        r10 = true;
        goto L45
    L37:
        r13 = null;
    L55:
        if (r5 == false) goto L58;
        FLogger.a.i("MsgAutoReader", "alreadyPlay read, skip auto play!");
        return;
    L58:
        Iterator r6 = r27.iterator();
    L60:
        if (r6.hasNext() == false) goto L74;
        Object r16 = r6.next();
        Message r17 = (Message) r16;
        if (r17 != null) goto L64;
    L70:
        boolean r8 = false;
    L71:
        if (r8 == false) goto L60;
    L75:
        Message r18 = (Message) r16;
        if (Intrinsics.areEqual(r18, r28) == true) goto L78;
        f2a.c r1 = this.e.b("[TTS][NOT_LAST_READABLE] tts not play");
        r1.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r2 = new Pair[11];
        f r3 = f.i;
        String r7 = r28.getMessageId();
        if (r7 != null) goto L196;
        r7 = "";
    L196:
        r2[0] = TuplesKt.to(r3, r7);
        f r4 = new f("reply_id");
        String r9 = r28.getReplyId();
        if (r9 != null) goto L199;
        r9 = "";
    L199:
        r2[1] = TuplesKt.to(r4, r9);
        f r19 = new f("local_message_id");
        String r20 = r28.getLocalMessageId();
        if (r20 != null) goto L202;
        r20 = "";
    L202:
        r2[2] = TuplesKt.to(r19, r20);
        r2[3] = TuplesKt.to(f.g, Integer.valueOf(r28.getContentType()));
        r2[4] = TuplesKt.to(new f("status"), String.valueOf(r28.getMessageStatus()));
        r2[5] = TuplesKt.to(new f("status_local"), Integer.valueOf(r28.getMessageStatusLocal()));
        f r21 = new f("last_text_message_response_id");
        if (r18 == null) goto L205;
        String r22 = r18.getMessageId();
    L206:
        if (r22 != null) goto L208;
        r22 = "";
    L208:
        r2[6] = TuplesKt.to(r21, r22);
        f r23 = new f("last_text_message_reply_id");
        if (r18 == null) goto L211;
        String r24 = r18.getReplyId();
    L212:
        if (r24 == null) goto L215;
        r11 = r24;
    L215:
        r2[7] = TuplesKt.to(r23, r11);
        f r25 = new f("last_text_message_content_type");
        if (r18 == null) goto L218;
        Integer r30 = Integer.valueOf(r18.getContentType());
    L219:
        r2[8] = TuplesKt.to(r25, String.valueOf(r30));
        f r31 = new f("last_text_message_status");
        if (r18 == null) goto L222;
        MessageStatus r32 = r18.getMessageStatus();
    L223:
        r2[9] = TuplesKt.to(r31, String.valueOf(r32));
        f r33 = new f("last_text_message_status_local");
        if (r18 == null) goto L226;
        Integer r34 = Integer.valueOf(r18.getMessageStatusLocal());
    L227:
        r2[10] = TuplesKt.to(r33, String.valueOf(r34));
        r1.d(MapsKt.mapOf(r2));
        f2a.c.c(r1, null, 15);
        return;
    L226:
        r34 = null;
        goto L227
    L222:
        r32 = null;
        goto L223
    L218:
        r30 = null;
        goto L219
    L211:
        r24 = null;
        goto L212
    L205:
        r22 = null;
        goto L206
    L78:
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L97;
        b r35 = this.f;
        if (r35 == null) goto L93;
        List<Message> r36 = r35.b;
        if (r36 == null) goto L93;
        ArrayList r110 = new ArrayList();
        Iterator<T> r37 = r36.iterator();
    L85:
        if (r37.hasNext() == false) goto L91;
        String r38 = ((Message) r37.next()).getMessageId();
        if (r38 == null) goto L85;
        r110.add(r38);
        goto L85
    L91:
        if (CollectionsKt.contains(r110, r28.getReplyId()) != true) goto L93;
        boolean r39 = true;
    L94:
        if (r39 == true) goto L129;
        FLogger.a.i("MsgAutoReader", "msg_id=" + r28.getMessageId() + " is not send msg!");
        return;
    L129:
        f2a.c r40 = this.e.b("[TTS][PLAY] tts can play");
        r40.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r111 = new Pair[5];
        f r41 = f.i;
        String r210 = r28.getMessageId();
        if (r210 != null) goto L132;
        String r112 = "";
    L133:
        r111[0] = TuplesKt.to(r41, r112);
        f r113 = new f("local_message_id");
        String r211 = r28.getLocalMessageId();
        if (r211 != null) goto L136;
        String r42 = "";
    L137:
        r111[1] = TuplesKt.to(r113, r42);
        f r43 = f.g;
        r111[2] = TuplesKt.to(r43, Integer.valueOf(r28.getContentType()));
        r111[3] = TuplesKt.to(new f("status"), String.valueOf(r28.getMessageStatus()));
        r111[4] = TuplesKt.to(new f("status_local"), Integer.valueOf(r28.getMessageStatusLocal()));
        r40.d(MapsKt.mapOf(r111));
        f2a.c.c(r40, null, 15);
        ObricTtsControlDelegate r44 = ObricTtsControlDelegate.b;
        if (r44.e() == false) goto L143;
        if (r44.d(r28, r27) == true) goto L143;
        FLogger.a.i("MsgAutoReader", "[TTS][OBRIC_NOT_PLAY_CASE] did not match");
        return;
    L143:
        if (r44.e() == true) goto L145;
    L148:
        r26.a(r28, r29);
        int r45 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r28, "message");
        boolean r46 = com.larus.im.bean.message.a.r0(r28);
        boolean r47 = com.larus.bmhome.chat.bean.d.f0(r28);
        if (r46 == true) goto L153;
        if (r47 == true) goto L153;
        boolean r48 = false;
    L154:
        z2 r49 = z2.a;
        if (r49.enableTtsMarkOpt() == false) goto L177;
        if (r48 == true) goto L158;
    L163:
        boolean r50 = true;
    L164:
        if (r50 == false) goto L192;
        Map<String, Long> r51 = this.a;
        String r52 = r28.getConversationId();
        if (r52 != null) goto L168;
        r52 = "";
    L168:
        r51.put(r52, Long.valueOf(r28.getLocalIndex()));
        f2a.c r0 = this.e.b("[TTS] update play index:  " + r28.getLocalIndex());
        r0.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r53 = new Pair[9];
        String r54 = r28.getMessageId();
        if (r54 != null) goto L171;
        r54 = "";
    L171:
        r53[0] = TuplesKt.to(r41, r54);
        f r55 = new f("local_message_id");
        String r56 = r28.getLocalMessageId();
        if (r56 == null) goto L175;
        r11 = r56;
    L175:
        r53[1] = TuplesKt.to(r55, r11);
        r53[2] = TuplesKt.to(r43, Integer.valueOf(r28.getContentType()));
        r53[3] = TuplesKt.to(new f("status"), String.valueOf(r28.getMessageStatus()));
        r53[4] = TuplesKt.to(new f("status_local"), Integer.valueOf(r28.getMessageStatusLocal()));
        r53[5] = TuplesKt.to(new f("isReceived"), Boolean.valueOf(com.larus.im.bean.message.a.n0(r28)));
        f r57 = new f("isServerLoading");
        Intrinsics.checkNotNullParameter(r28, "message");
        r53[6] = TuplesKt.to(r57, Boolean.valueOf(com.larus.im.bean.message.a.r0(r28)));
        r53[7] = TuplesKt.to(new f("isDeepThinkingTyping"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r28)));
        r53[8] = TuplesKt.to(new f("serverLoadingNotInterruptTts"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.L(r28)));
        r0.d(MapsKt.mapOf(r53));
        f2a.c.c(r0, null, 15);
    L192:
        return;
    L158:
        if (r49.startTtsWhenReceiveContent() == false) goto L160;
    L162:
        r50 = false;
        goto L164
    L160:
        if (com.larus.bmhome.chat.bean.d.L(r28) == true) goto L162;
    L177:
        if (r48 == true) goto L192;
        if (com.larus.bmhome.chat.bean.d.L(r28) == true) goto L192;
        Map<String, Long> r58 = this.a;
        String r59 = r28.getConversationId();
        if (r59 != null) goto L183;
        r59 = "";
    L183:
        r58.put(r59, Long.valueOf(r28.getLocalIndex()));
        f2a.c r60 = this.e.b("[TTS] update play index:  " + r28.getLocalIndex());
        r60.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r61 = new Pair[8];
        String r62 = r28.getMessageId();
        if (r62 != null) goto L186;
        r62 = "";
    L186:
        r61[0] = TuplesKt.to(r41, r62);
        f r63 = new f("local_message_id");
        String r64 = r28.getLocalMessageId();
        if (r64 == null) goto L190;
        r11 = r64;
    L190:
        r61[1] = TuplesKt.to(r63, r11);
        r61[2] = TuplesKt.to(r43, Integer.valueOf(r28.getContentType()));
        r61[3] = TuplesKt.to(new f("status"), String.valueOf(r28.getMessageStatus()));
        r61[4] = TuplesKt.to(new f("status_local"), Integer.valueOf(r28.getMessageStatusLocal()));
        r61[5] = TuplesKt.to(new f("isReceived"), Boolean.valueOf(com.larus.im.bean.message.a.n0(r28)));
        f r65 = new f("isServerLoading");
        Intrinsics.checkNotNullParameter(r28, "message");
        r61[6] = TuplesKt.to(r65, Boolean.valueOf(com.larus.im.bean.message.a.r0(r28)));
        r61[7] = TuplesKt.to(new f("isDeepThinkingTyping"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r28)));
        r60.d(MapsKt.mapOf(r61));
        f2a.c.c(r60, null, 15);
        return;
    L153:
        r48 = true;
        goto L154
    L145:
        if (r44.u(r28) == false) goto L148;
        FLogger.a.i("MsgAutoReader", "[TTS][OBRIC_CONTINUOUS_TALK_SKIP] msgId=" + r28.getMessageId() + " skip IM auto tts");
        return;
    L136:
        r42 = r211;
        goto L137
    L132:
        r112 = r210;
    L93:
        r39 = false;
        goto L94
    L97:
        Long r66 = (Long) ((LinkedHashMap) this.a).get(r28.getConversationId());
        if (r66 == null) goto L100;
        long r67 = r66.longValue();
    L102:
        if (r67 < r28.getLocalIndex()) goto L129;
        String r68 = r28.getMessageId();
        if (r68 != null) goto L106;
    L114:
        StringBuilder r69 = new StringBuilder();
        String r70 = r28.getConversationId();
        if (r70 != null) goto L117;
        r70 = "";
    L117:
        r69.append(r70);
        r69.append(':');
        String r71 = r28.getLocalMessageId();
        if (r71 != null) goto L120;
        r71 = "";
    L120:
        r69.append(r71);
        r69.append(':');
        r69.append(r28.getLocalIndex());
        r68 = r69.toString();
    L122:
        if (this.b.add(r68) == false) goto L234;
        f2a.c r72 = this.e.b("[TTS][ALREADY PLAYED] tts not play");
        r72.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r73 = new Pair[3];
        f r74 = f.i;
        String r75 = r28.getMessageId();
        if (r75 == null) goto L127;
        r11 = r75;
    L127:
        r73[0] = TuplesKt.to(r74, r11);
        r73[1] = TuplesKt.to(new f("last_index"), Long.valueOf(r67));
        r73[2] = TuplesKt.to(new f("this_index"), Long.valueOf(r28.getLocalIndex()));
        r72.d(MapsKt.mapOf(r73));
        f2a.c.c(r72, null, 15);
        return;
    L234:
        return;
    L106:
        if (r68.length() <= 0) goto L108;
        boolean r76 = true;
    L109:
        if (r76 == true) goto L112;
        r68 = null;
    L112:
        if (r68 == null) goto L114;
    L108:
        r76 = false;
        goto L109
    L100:
        r67 = 0;
        goto L102
    L64:
        if (o0.d(r17.getMessageId()) == false) goto L70;
        if (Intrinsics.areEqual(r17.getSenderId(), AccountService.a.getUserId()) == true) goto L70;
        if (ArraysKt.contains(new Integer[]{1, Integer.valueOf(GuideTipType.FORCE_SHOW), 2022}, Integer.valueOf(r17.getContentType())) == false) goto L70;
        r8 = true;
        goto L71
    L74:
        r16 = null;
        goto L75
    L8:
        if (com.larus.bmhome.chat.bean.d.x0(r28) == false) goto L28;
        List r77 = r28.getSubList();
        if (r77 == null) goto L28;
        Message r78 = (Message) CollectionsKt.firstOrNull(r77);
        if (r78 == null) goto L28;
        String r114 = r78.getMessageId();
        if (r114 != null) goto L16;
    L18:
        boolean r115 = false;
    L19:
        if (r115 == true) goto L28;
        ConcurrentHashMap<String, Integer> r116 = w2.a;
        if (w2.a(r28.getMessageId()) != 0) goto L28;
        String r117 = r28.getMessageId();
        if (r117 != null) goto L26;
        r117 = "";
    L26:
        if (b(r117) == true) goto L28;
        r26.a(r78, r29);
        r5 = true;
        goto L29
    L16:
        if (StringsKt.contains$default(r114, "#", false, 2, null) != true) goto L18;
        r115 = true;
        goto L19
    }
}
