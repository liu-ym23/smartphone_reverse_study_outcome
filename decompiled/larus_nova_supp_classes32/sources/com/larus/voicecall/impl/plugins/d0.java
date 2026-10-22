package com.larus.voicecall.impl.plugins;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.service.AccountService;
import com.larus.tts.UserSettingRepoDelegate;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements v {
    public final String f;
    public z2a.a g;
    public String h;
    public String i;
    public String j;
    public long k;
    public long l;
    public long m;
    public final e n;
    public final c o;
    public final b p;

    public static final class a {
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ d0 a;
        public final /* synthetic */ com.larus.audio.call.arch.c b;

        public final void onPlayComplete() {
            FLogger.a.i(this.a.f, "QuicSimultaneousTranslatorPlugin onPlayComplete");
            z2a.a r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            IChatRepoService r1 = zh8.a.a;
            zh8.a.a.getReceiver().c().r6(null);
        }

        public final void f(TtsPlayEndType r21) {
            Intrinsics.checkNotNullParameter(r21, "endType");
            Intrinsics.checkNotNullParameter(r21, "endType");
            FLogger.a.i(this.a.f, "QuicSimultaneousTranslatorPlugin onPlayEnd");
            z2a.a r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            d0 r1 = this.a;
            Long r2 = Long.valueOf(r1.l - r1.k);
            d0 r3 = this.a;
            Long r4 = Long.valueOf(r3.m - r3.k);
            Long r5 = Long.valueOf(System.currentTimeMillis() - this.a.k);
            String r6 = this.b.params().e;
            JSONObject r7 = new JSONObject();
            Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
            if (r2 != null) goto L21;
        L10:
            if (r4 == null) goto L12;
            r7.put("receive_tts_first_package", r4.longValue());     // Catch: JSONException -> L8
        L12:
            if (r5 == null) goto L14;
            r7.put("receive_tts_end", r5.longValue());     // Catch: JSONException -> L8
        L14:
            if (r6 == null) goto L16;
            r7.put("session_id", r6);     // Catch: JSONException -> L8
        L16:
            r7.put("scene", "interpret");     // Catch: JSONException -> L8
        L19:
            TrackParams r8 = new TrackParams().merge(r7);
            by7.a r9 = new by7.a("flow_quic_call_message");
            r9.a.merge(r8);
            r9.b();
            d0 r10 = this.a;
            tx9.c1.a(r10.h, null, null, null, null, null, r10.i, "auto_end", null, null, null, null, null, null, "1", null, null, 114494);
            return;
        L8:
            e = move-exception;
            FLogger.a.e("FinishEventHelper", "error in FinishEventHelper finishTTS " + e.getLocalizedMessage());
            goto L19
        L21:
            r7.put("receive_asr_info_duration", r2.longValue());     // Catch: JSONException -> L8
            goto L10
        }

        public b(d0 r1, com.larus.audio.call.arch.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements nf9.b {
        public final /* synthetic */ d0 a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public c(d0 r1) {
            this.a = r1;
        }

        public final void c(String r4, Message r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            FLogger r7 = FLogger.a;
            r7.i(this.a.f, "changeListener onUpdateMessage, local msg id : " + r5.getLocalMessageId() + ", status : " + r5.getMessageStatus() + ", content : " + r5.getContent());
            Map r8 = r5.getBusinessExt();
            if (r8 == null) goto L5;
            String r9 = (String) r8.get("biz_interpret_fake_loading");
        L7:
            if (Intrinsics.areEqual(r9, "1") == true) goto L9;
            return;
        L9:
            if (r5.getMessageStatusLocal() != 0) goto L16;
            r7.i(this.a.f, "changeListener onUpdateMessage, local msg id : " + r5.getLocalMessageId() + ", BIZ_INTERPRET_FAKE_LOADING ！！！");
            NativeMessageServiceImpl r10 = com.larus.im.d.e();
            String r11 = r5.getLocalMessageId();
            if (r11 != null) goto L13;
            r11 = NameKeys.UnloadStrategy_No_Strategy;
        L13:
            r10.x(r11, new e0(), null);
            return;
        L16:
            return;
        L5:
            r9 = null;
            goto L7
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (com.larus.bmhome.chat.bean.d.K0(r2) == false) goto L6;
            d0 r4 = this.a;
            r4.l = System.currentTimeMillis();
            return;
        }
    }

    public static final class d implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ d0 c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public d(d0 r1) {
            this.c = r1;
            this.a = r1.f;
            this.b = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r3) {
            Intrinsics.checkNotNullParameter(r3, "frame");
            z2a.a r0 = this.c.g;
            if (r0 == null) goto L6;
            r0.b(r3.a, com.larus.voicecall.impl.util.d.d(r3.b()));
            return;
        }
    }

    public static final class e extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ d0 b;
        public final /* synthetic */ com.larus.audio.call.arch.c c;

        public final String g() {
            return this.a;
        }

        public final void n(com.larus.im.service.audio.z0.a r177) {
            Intrinsics.checkNotNullParameter(r177, "event");
            FLogger r2 = FLogger.a;
            r2.i(this.b.f, "QuicSimultaneousTranslatorPlugin onReceiveEvent : ".concat(r177.getClass().getSimpleName()));
            if ((r177 instanceof pf9.z) == false) goto L5;
            pf9.z r3 = (pf9.z) r177;
        L6:
            if (r3 == null) goto L9;
            d0 r5 = this.b;
            r2.i(r5.f, "FlowLLMQueryBeginEvent : " + r3.e + ", addMessage");
            r5.j = r3.e;
        L9:
            if ((r177 instanceof pf9.d0) == false) goto L11;
            pf9.d0 r4 = (pf9.d0) r177;
        L12:
            if (r4 == null) goto L24;
            d0 r6 = this.b;
            r6.j = null;
            if (UserSettingRepoDelegate.a.b() == 0) goto L16;
            boolean r7 = true;
        L17:
            r2.i(r6.f, "FlowLLMReplyBeginEvent ： " + r7);
            if (com.larus.platform.service.z2.a.A2().getForcePlay() == false) goto L21;
            if (r7 == true) goto L21;
            String r8 = "simultaneous_interpretation";
        L22:
            r6.i = r8;
            r6.m = System.currentTimeMillis();
            com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
            JSONObject r10 = new JSONObject();
            r10.put("message_id", r6.h);
            r10.put("start_method", r6.i);
            r10.put("is_simultaneous_interpretation", "1");
            Unit r11 = Unit.INSTANCE;
            r9.reportEvent("start_tts", r10);
        L21:
            r8 = "auto_play";
            goto L22
        L16:
            r7 = false;
        L24:
            if ((r177 instanceof pf9.f0) == false) goto L26;
            pf9.f0 r12 = (pf9.f0) r177;
        L27:
            if (r12 == null) goto L43;
            d0 r13 = this.b;
            if (r12.getType() != ReplyType.Text) goto L40;
            r2.i(r13.f, "QuicSimultaneousTranslatorPlugin Text : " + r12.d);
            ReplyStage r14 = r12.d;
            if (r14 != ReplyStage.Update) goto L33;
        L34:
            String r15 = r13.f;
            StringBuilder r16 = new StringBuilder("QuicSimultaneousTranslatorPlugin process messageId : ");
            pf9.k0 r17 = r12.b;
            if (r17 == null) goto L37;
            String r18 = r17.f;
        L38:
            r16.append(r18);
            r2.i(r15, r16.toString());
            zh8.a.a.getReceiver().c().r6(pf9.i.f(r12));
            r13.h = pf9.i.f(r12);
            goto L40
        L37:
            r18 = null;
            goto L38
        L33:
            if (r14 == ReplyStage.Begin) goto L34;
        L40:
            if (r12.getType() != ReplyType.Sentence) goto L43;
            r2.i(r13.f, "QuicSimultaneousTranslatorPlugin Sentence : " + r12.d);
        L43:
            if ((r177 instanceof pf9.a0) == false) goto L45;
            pf9.a0 r1 = (pf9.a0) r177;
        L46:
            if (r1 == null) goto L150;
            d0 r19 = this.b;
            RealtimeCallParam r20 = this.c.params();
            r19.getClass();
            RealtimeCallParam.k r21 = r20.p;
            String r110 = r21.b;
            String r111 = r21.d;
            RealtimeCallParam.p r22 = r20.o;
            String r23 = r22.h;
            String r112 = r20.l.c;
            String r113 = r20.w;
            String r114 = r22.f;
            String r115 = r22.d;
            String r24 = r22.g;
            String r25 = r21.e;
            if (r25 != null) goto L50;
            r25 = r21.J;
        L50:
            String r26 = r25;
            String r27 = r21.f;
            String r28 = r21.g;
            RealtimeCallParam.n r29 = r21.h;
            if (r29 == null) goto L53;
            String r210 = r29.a;
        L54:
            if (r29 == null) goto L56;
            String r211 = r29.b;
        L57:
            if (r29 == null) goto L59;
            String r212 = r29.c;
        L60:
            if (r29 == null) goto L62;
            String r213 = r29.d;
        L63:
            if (r29 == null) goto L65;
            String r214 = r29.e;
        L66:
            if (r29 == null) goto L68;
            String r215 = r29.f;
        L69:
            String r0 = r21.k;
            String r30 = r21.l;
            String r31 = r21.m;
            RealtimeCallUtil.a.getClass();
            com.larus.voicecall.impl.scene.o r32 = RealtimeCallUtil.l;
            if (r32 == null) goto L77;
            SceneModel r33 = r32.a;
            if (r33 == null) goto L77;
            String r34 = r33.getKey();
            if (r34 == null) goto L77;
            String r56 = r34;
        L78:
            RealtimeCallParam.k r35 = r20.p;
            String r116 = r35.i;
            String r117 = r20.e;
            String r36 = r35.n;
            long r37 = com.larus.utils.z0.c(RealtimeCallUtil.z);
            RealtimeCallParam.c r38 = r20.p.o;
            if (r38 == null) goto L81;
            String r77 = r38.b;
        L82:
            if (r38 == null) goto L84;
            String r78 = r38.c;
        L85:
            if (r38 == null) goto L89;
            String r39 = r38.a;
            if (r39 == null) goto L89;
            Long r76 = StringsKt.toLongOrNull(r39);
        L90:
            RealtimeCallParam.k r40 = r20.p;
            RealtimeCallParam.c r41 = r40.o;
            if (r41 == null) goto L93;
            String r42 = r41.d;
        L95:
            if (r42 != null) goto L97;
            String r62 = NameKeys.UnloadStrategy_No_Strategy;
        L98:
            String r43 = r40.H;
            String r44 = r40.I;
            int r45 = com.larus.utils.j0.a;
            l3.b(r23, r28, null, null, r112, r111, "private", r113, null, null, "0", null, "text", null, r110, r210, r211, r215, r26, r27, "speak", r212, r213, r214, null, null, r30, r31, r23, null, null, null, null, null, null, r0, null, null, null, null, null, null, null, r114, r115, r24, null, 5, "translate_btn", null, null, r56, r116, null, null, com.larus.utils.j0.d(2131906742), null, r62, "1", r117, r36, null, null, null, null, null, null, null, null, null, Long.valueOf(r37), r76, r77, r78, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r43, r44, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2046465227, -862982201, -4685886, -234893313, -1, 255);
            String r46 = r19.h;
            RealtimeCallParam.k r47 = r20.p;
            String r118 = r47.d;
            String r48 = r47.b;
            RealtimeCallParam.p r49 = r20.o;
            String r119 = r49.h;
            String r50 = r20.l.c;
            String r51 = r20.w;
            String r120 = r49.f;
            String r121 = r49.d;
            String r52 = r49.g;
            String r53 = r47.e;
            if (r53 != null) goto L101;
            r53 = r47.J;
        L101:
            String r216 = r53;
            String r122 = r47.f;
            String r123 = r47.g;
            RealtimeCallParam.n r54 = r47.h;
            if (r54 == null) goto L104;
            String r217 = r54.a;
        L105:
            if (r54 == null) goto L107;
            String r218 = r54.b;
        L108:
            if (r54 == null) goto L110;
            String r219 = r54.c;
        L111:
            if (r54 == null) goto L113;
            String r220 = r54.d;
        L114:
            if (r54 == null) goto L116;
            String r221 = r54.e;
        L117:
            if (r54 == null) goto L119;
            String r222 = r54.f;
        L120:
            String r55 = r47.k;
            String r57 = r47.l;
            String r58 = r47.m;
            com.larus.voicecall.impl.scene.o r59 = RealtimeCallUtil.l;
            if (r59 == null) goto L128;
            SceneModel r60 = r59.a;
            if (r60 == null) goto L128;
            String r61 = r60.getKey();
            if (r61 == null) goto L128;
            String r510 = r61;
        L129:
            RealtimeCallParam.k r63 = r20.p;
            String r124 = r63.i;
            String r125 = r20.e;
            String r64 = r63.n;
            long r310 = com.larus.utils.z0.c(RealtimeCallUtil.z);
            RealtimeCallParam.c r65 = r20.p.o;
            if (r65 == null) goto L132;
            String r72 = r65.b;
        L133:
            if (r65 == null) goto L135;
            String r73 = r65.c;
        L136:
            if (r65 == null) goto L140;
            String r66 = r65.a;
            if (r66 == null) goto L140;
            Long r71 = StringsKt.toLongOrNull(r66);
        L141:
            RealtimeCallParam.k r67 = r20.p;
            RealtimeCallParam.c r68 = r67.o;
            if (r68 == null) goto L144;
            String r69 = r68.d;
        L145:
            if (r69 != null) goto L147;
            String r610 = NameKeys.UnloadStrategy_No_Strategy;
        L148:
            l3.d(r119, r123, null, null, r50, r118, null, "private", r51, null, "0", r46, "text", null, r48, r217, r218, r222, r216, r122, null, "speak", r219, r220, r221, null, 1L, null, r55, r57, r58, r119, null, null, null, null, null, null, null, null, null, null, null, null, r120, r121, r52, 5, com.larus.utils.j0.d(2131906742), "translate_btn", null, r510, null, null, null, null, null, r124, r610, "1", null, null, null, r64, r125, Long.valueOf(r310), r71, r72, r73, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r67.H, r67.I, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1585375847, 1048707041, -5106, -193, Integer.MAX_VALUE);
            return;
        L147:
            r610 = r69;
            goto L148
        L144:
            r69 = null;
        L140:
            r71 = null;
            goto L141
        L135:
            r73 = null;
            goto L136
        L132:
            r72 = null;
        L128:
            r510 = "other";
            goto L129
        L119:
            r222 = null;
            goto L120
        L116:
            r221 = null;
            goto L117
        L113:
            r220 = null;
            goto L114
        L110:
            r219 = null;
            goto L111
        L107:
            r218 = null;
            goto L108
        L104:
            r217 = null;
            goto L105
        L97:
            r62 = r42;
            goto L98
        L93:
            r42 = null;
        L89:
            r76 = null;
            goto L90
        L84:
            r78 = null;
            goto L85
        L81:
            r77 = null;
        L77:
            r56 = "other";
            goto L78
        L68:
            r215 = null;
            goto L69
        L65:
            r214 = null;
            goto L66
        L62:
            r213 = null;
            goto L63
        L59:
            r212 = null;
            goto L60
        L56:
            r211 = null;
            goto L57
        L53:
            r210 = null;
            goto L54
        L150:
            return;
        L45:
            r1 = null;
            goto L46
        L26:
            r12 = null;
            goto L27
        L11:
            r4 = null;
            goto L12
        L5:
            r3 = null;
            goto L6
        }

        public e(d0 r1, com.larus.audio.call.arch.c r2) {
            this.b = r1;
            this.c = r2;
            this.a = "QuicInterpretPluginMediaSessionListener";
        }
    }

    public static final class f implements IIMCallback<Message> {
        public final /* synthetic */ d0 a;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public f(d0 r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r5) {
            Message r6 = (Message) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            FLogger.a.i(this.a.f, "add fake loading onSuccess, local msg id : " + r6.getLocalMessageId());
            this.a.j = null;
        }
    }

    static {
    }

    public final com.larus.im.service.audio.x Q2() {
        return new d(this);
    }

    @Override // com.larus.voicecall.impl.plugins.v
    public final void a2() {
        FLogger.a.i(this.f, "triggerTranslatorFinish, currentFakeLoadingLocalMsgID = " + this.j);
        id9.d r1 = getContext().j();
        if (r1 == null) goto L5;
        r1.p(TriggerMode.END_ASR, new JSONObject().toString());
    L5:
        com.larus.audio.call.arch.b.a(getContext()).R1("translator");
        String r10 = this.j;
        if (r10 == null) goto L12;
        f r2 = new f(this);
        yc9.f0 r3 = new yc9.f0(getContext().params().o.c, null, AccountService.a.getUserId(), 0, 0, null, r10, null, 0, null, true, null, null, null, null, null, null, com.larus.utils.h.c(new LinkedHashMap(), new Pair[]{TuplesKt.to("biz_audio_url", "is_mock_sending"), TuplesKt.to("biz_interpret_fake_loading", "1")}), null, null, null, 532667114);
        NativeMessageServiceImpl r4 = com.larus.im.d.e();
        String r5 = this.j;
        if (r5 != null) goto L10;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r4.m(r5, new f0(r3, r2));
        return;
    }

    public final void b3() {
        FLogger.a.i(this.f, "onRelease");
        if (this.j == null) goto L9;
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r1 = this.j;
        if (r1 != null) goto L7;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r0.m(r1, new g0(this));
        return;
    }

    public final void e3() {
        super.e3();
        com.larus.audio.call.arch.b.a(getContext()).e0().i(this.p);
        com.larus.im.d.e().registerOnMessageChangedObserver(getContext().params().o.c, this.o);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return this.n;
    }

    public final String T2() {
        return this.f;
    }

    public d0(com.larus.audio.call.arch.c r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "QuicInterpretPlugin" + hashCode();
        this.n = new e(this, r3);
        this.o = new c(this);
        this.p = new b(this, r3);
    }

    @Override // com.larus.voicecall.impl.plugins.v
    public final void C(String r4) {
        Intrinsics.checkNotNullParameter(r4, "endMethod");
        FLogger.a.i(this.f, "stopAudioPlay, stopAudioPlay ".concat(r4));
        com.larus.audio.call.arch.b.a(getContext()).e0().d(true, true, "client_interrupt");
    }

    @Override // com.larus.voicecall.impl.plugins.v
    public final void U1(com.larus.im.service.audio.l r3) {
        Intrinsics.checkNotNullParameter(r3, "frame");
        this.k = System.currentTimeMillis();
        z2a.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(r3.a);
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.v
    public final void d2(z2a.a r5) {
        Intrinsics.checkNotNullParameter(r5, "receiver");
        FLogger.a.i(this.f, "registerTranslatorAudioFrameReceiver in plugin， receiver = " + r5);
        this.g = r5;
    }
}
