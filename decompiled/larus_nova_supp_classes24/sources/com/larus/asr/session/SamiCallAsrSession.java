package com.larus.asr.session;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.asr.session.clicktalk.ClickTalkAsrRoute;
import com.larus.asr.x5;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.im.observer.MessageListState;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.spi.audio.IObricAsrService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SamiCallAsrSession implements o {
    public long A;
    public final ConcurrentHashMap<String, Long> B;
    public final CopyOnWriteArraySet<String> C;
    public final CopyOnWriteArraySet<String> D;
    public final ConcurrentHashMap<String, String> E;
    public final Lazy F;
    public Function1<? super String, Boolean> G;
    public Function2<? super String, ? super Boolean, Unit> H;
    public Function1<? super com.larus.audio.b, Boolean> I;
    public Function1<? super com.larus.audio.a, Boolean> J;
    public Function2<? super String, ? super byte[], Unit> K;
    public Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> L;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> M;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> N;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> O;
    public final Lazy P;
    public final b Q;
    public final p a;
    public final String b;
    public final boolean c;
    public final Function0<maa.e> d;
    public final VoiceInputType e;
    public boolean f;
    public boolean g;
    public g2 h;
    public final f2a.d i;
    public RealtimeCallParam j;
    public final AtomicReference<String> k;
    public final AtomicReference<String> l;
    public boolean m;
    public boolean n;
    public BotModel o;
    public Integer p;
    public String q;
    public JSONObject r;
    public final Lazy s;
    public CompletableJob t;
    public CoroutineScope u;
    public com.larus.asr.session.clicktalk.l v;
    public final Lazy w;
    public final boolean x;
    public final Lazy y;
    public final SamiCallAsrSession$asrResultListener$1 z;

    public static final class a {
    }

    public static final class b implements nf9.b {
        public final /* synthetic */ SamiCallAsrSession a;

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

        public b(SamiCallAsrSession r1) {
            this.a = r1;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            SamiCallAsrSession.a(this.a, r1, r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            SamiCallAsrSession.a(this.a, r1, r2);
        }
    }

    static {
    }

    public final void f() {
        this.m = false;
        ObricAsrDelegate.b.s(false);
        this.q = null;
        this.o = null;
        this.p = null;
        this.j = null;
        this.r = null;
        this.v = null;
        this.l.set("");
        this.n = false;
        this.f = false;
        Job.DefaultImpls.cancel$default(this.t, null, 1, null);
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent$f r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.O.get();
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
        if (this.j != null) goto L5;
    L7:
        c5.c();
        a5.b();
        return;
    L5:
        if (this.n == true) goto L7;
        FLogger.a.i("SamiCallAsrSession", "clear() fallback close active click talk session");
        c(ExitClickSpeakerType.DESTROY);
        goto L7
    }

    public final n e() {
        return (n) this.F.getValue();
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return this.f;
    }

    public static void b(JSONObject r6) {
        ObricEnrollInteropDelegate r0 = ObricEnrollInteropDelegate.b;
        if (r0.d() == false) goto L5;
        String r1 = null;
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r6.put("dora_engine_version", r1);
        return;
    L16:
        String r3 = AccountService.a.getUserId();
        String r4 = ObricAsrDelegate.b.c();
        JSONObject r5 = new JSONObject();
        r5.put("engine_version", "1.0.0.100");
        r5.put("voice_print_id", r3 + '-' + r4);
        r6.put("dora_engine_version", r5.toString());
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = r0.v();
        goto L6
    }

    public static /* synthetic */ void d(SamiCallAsrSession r1) {
        r1.c(ExitClickSpeakerType.MANUAL);
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.N.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.M.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.N.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "withExtHandle");
        this.L = r2;
    }

    public final void c(final ExitClickSpeakerType r2) {
        Intrinsics.checkNotNullParameter(r2, "exitClickSpeakerType");
        com.larus.utils.t0.a(new t1(r2, this));
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.M.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
        this.H = r1;
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("SamiCallAsrSession", "notifyStateChanged state: " + r4.getClass());
        this.O.set(r4);
        Iterator<T> r0 = this.M.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.bmhome.chat.component.bottom.core.speaker.h) r0.next()).a(r4);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.asr.session.clicktalk.k, com.larus.asr.session.e2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.asr.session.clicktalk.m] */
    public final void i(final Function1<? super String, Unit> r19, Map<String, Object> r20) {
        int r1 = -1;
        if (r20 == null) goto L8;
        Object r2 = r20.get("wakeup_from");
        if (r2 == null) goto L8;
        r1 = tx9.l3.e(r2, -1);
    L8:
        if (r20 == null) goto L10;
        Object r0 = r20.get("click_talk_param");
    L12:
        if ((r0 instanceof RealtimeCallParam) == false) goto L14;
        RealtimeCallParam r3 = (RealtimeCallParam) r0;
    L15:
        if (r3 != null) goto L17;
        r3 = new RealtimeCallParam();
    L17:
        final RealtimeCallParam r7 = r3;
        Context r4 = this.a.getSessionContext();
        wc9.e r5 = this.a.h();
        if (r5 == null) goto L20;
        String r6 = r5.a;
    L21:
        BotModel r8 = this.a.i();
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("Oneshot params, enable: ");
        RealtimeCallParam.l r11 = r7.M;
        if (r11 == null) goto L24;
        Boolean r12 = Boolean.valueOf(r11.a);
    L25:
        r10.append(r12);
        r10.append(", keyword: ");
        RealtimeCallParam.l r13 = r7.M;
        if (r13 == null) goto L28;
        String r14 = r13.b;
    L29:
        r10.append(r14);
        r10.append(", offset: ");
        RealtimeCallParam.l r15 = r7.M;
        if (r15 == null) goto L32;
        Long r16 = Long.valueOf(r15.c);
    L33:
        r10.append(r16);
        r9.i("SamiCallAsrSession", r10.toString());
        r9.i("SamiCallAsrSession", "startClickTalk() called");
        if (this.m == false) goto L37;
        r9.e("SamiCallAsrSession", "startClickTalk ignored, isClickTalk=" + this.m + ", isClosing=" + this.n);
        return;
    L37:
        this.A = System.currentTimeMillis();
        r9.i("SamiCallAsrSession", "startTimeMillis = " + this.A);
        Integer r17 = Integer.valueOf(r1);
        this.j = r7;
        this.q = r6;
        this.o = r8;
        this.p = r17;
        if (r6 == null) goto L40;
        com.larus.im.d.e().registerOnMessageChangedObserver(r6, this.Q);
    L40:
        RealtimeCallParam r21 = this.j;
        if (r21 == null) goto L69;
        JSONObject r22 = new JSONObject();
        this.r = r22;
        r22.put("task_id", r21.o.a);
        JSONObject r23 = this.r;
        if (r23 == null) goto L45;
        r23.put("bot_id", r21.o.h);
    L45:
        JSONObject r24 = this.r;
        if (r24 == null) goto L48;
        r24.put("conversation_id", r21.l.c);
    L48:
        JSONObject r25 = this.r;
        if (r25 == null) goto L51;
        r25.put("recommend_from", r21.p.f);
    L51:
        JSONObject r26 = this.r;
        if (r26 == null) goto L54;
        r26.put("chat_type", r21.p.g);
    L54:
        JSONObject r27 = this.r;
        if (r27 == null) goto L57;
        r27.put("bot_type", r21.p.g);
    L57:
        JSONObject r29 = this.r;
        if (r29 == null) goto L60;
        r29.put("bot_name", r21.o.i);
    L60:
        JSONObject r30 = this.r;
        if (r30 == null) goto L63;
        r30.put("llm_model", r21.o.e);
    L63:
        JSONObject r31 = this.r;
        if (r31 == null) goto L67;
        r31.put("voice_style", r21.o.d);
    L67:
        if (r21.p.h == null) goto L69;
        SystemClock.elapsedRealtime();
    L69:
        ObricAsrDelegate r32 = ObricAsrDelegate.b;
        String r33 = r32.g();
        boolean r34 = false;
        if (r33 == null) goto L72;
        boolean r110 = true;
    L74:
        if (r110 == false) goto L96;
        RealtimeCallParam r111 = this.j;
        if (r111 == null) goto L96;
        if (r111.l.a.length() <= 0) goto L80;
        boolean r112 = true;
    L81:
        if (r112 == false) goto L88;
        IObricAsrService r113 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
        if (r113 == null) goto L88;
        String r114 = r111.l.a;
        if (r33 != null) goto L87;
        r33 = "";
    L87:
        r113.l(r114, r33);
    L88:
        String r35 = r111.l.o;
        if (r35.length() != 0) goto L91;
        boolean r115 = true;
    L93:
        if (r115 == false) goto L95;
        RealtimeCallParam.d r36 = r111.l;
        JSONObject r116 = new JSONObject();
        r116.put("enable_speaker_identify", r110);
        b(r116);
        r36.a(r116.toString());
        goto L96
    L95:
        JSONObject r117 = new JSONObject(r35);
        r117.put("enable_speaker_identify", r110);
        b(r117);
        r111.l.a(r117.toString());
        goto L96
    L91:
        r115 = false;
        goto L93
    L80:
        r112 = false;
    L96:
        StringBuilder r37 = new StringBuilder("initVoiceAuthenticationParams ");
        r37.append(r110);
        r37.append(" and asrConfig.extra is ");
        RealtimeCallParam r118 = this.j;
        if (r118 == null) goto L101;
        RealtimeCallParam.d r119 = r118.l;
        if (r119 == null) goto L101;
        String r120 = r119.o;
    L102:
        r37.append(r120);
        r9.i("SamiCallAsrSession", r37.toString());
        if (this.j == null) goto L105;
        BuildersKt.launch$default(this.u, null, null, new SamiCallAsrSession$initRealtimeCallParams$1$1(r4, null), 3, null);
    L105:
        RealtimeCallParam r38 = this.j;
        if (r38 == null) goto L113;
        RealtimeCallParam.d r39 = r38.l;
        if (r39 == null) goto L113;
        String r40 = r39.a;
        if (r40 == null) goto L113;
        String r121 = r40;
    L114:
        maa.e r122 = (maa.e) this.d.invoke();
        if (r122 == null) goto L143;
        RealtimeCallParam r41 = this.j;
        if (r41 == null) goto L122;
        RealtimeCallParam.d r42 = r41.l;
        if (r42 == null) goto L122;
        String r123 = r42.o;
    L123:
        String r43 = r122.Js(r121, r123, this.x, AccountService.a.getUserId(), r32.c());
        if (r43 != null) goto L126;
    L129:
        boolean r44 = true;
    L130:
        if (r44 == true) goto L143;
        RealtimeCallParam r45 = this.j;
        if (r45 == null) goto L136;
        RealtimeCallParam.d r46 = r45.l;
        if (r46 == null) goto L136;
        r46.a(r43);
    L136:
        StringBuilder r47 = new StringBuilder("initRelativeContentSessionParams json is ");
        RealtimeCallParam r48 = this.j;
        if (r48 == null) goto L141;
        RealtimeCallParam.d r49 = r48.l;
        if (r49 == null) goto L141;
        String r50 = r49.o;
    L142:
        r47.append(r50);
        r9.i("SamiCallAsrSession", r47.toString());
    L141:
        r50 = null;
        goto L142
    L126:
        if (r43.length() == 0) goto L129;
        r44 = false;
    L122:
        r123 = null;
    L143:
        RealtimeCallParam r51 = this.j;
        if (r51 == null) goto L152;
        String r52 = r51.l.o;
        if (r52.length() != 0) goto L149;
        r34 = true;
    L149:
        if (r34 == false) goto L151;
        RealtimeCallParam.d r53 = r51.l;
        JSONObject r54 = new JSONObject();
        r54.put("enable_third_party_accessory_connection", ObricChatSPIServiceDelegate.b.a());
        r53.a(r54.toString());
        goto L152
    L151:
        JSONObject r55 = new JSONObject(r52);
        r55.put("enable_third_party_accessory_connection", ObricChatSPIServiceDelegate.b.a());
        r51.l.a(r55.toString());
    L152:
        StringBuilder r56 = new StringBuilder("initBluetoothDeviceParams json is ");
        RealtimeCallParam r57 = this.j;
        if (r57 == null) goto L157;
        RealtimeCallParam.d r59 = r57.l;
        if (r59 == null) goto L157;
        String r60 = r59.o;
    L158:
        r56.append(r60);
        r9.i("SamiCallAsrSession", r56.toString());
        final Ref.ObjectRef r124 = new Ref.ObjectRef();
        com.larus.asr.session.clicktalk.r r61 = (com.larus.asr.session.clicktalk.r) this.w.getValue();
        com.larus.platform.api.f2.a r62 = com.larus.platform.api.f2.a;
        boolean r63 = r62.g();
        boolean r64 = r62.useNewAsrTasksV2();
        r61.getClass();
        if (r63 == false) goto L161;
        ClickTalkAsrRoute r65 = ClickTalkAsrRoute.AUTO_STOP;
    L164:
        r124.element = r65;
        if (r65 == ClickTalkAsrRoute.FLOW_ASR_TASK) goto L167;
    L169:
        final String r66 = UUID.randomUUID().toString();
        this.l.set(r66);
        ClickTalkAsrRoute r67 = (ClickTalkAsrRoute) r124.element;
        if (this.t.isActive() == true) goto L172;
        this.t = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.u = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(this.t));
    L172:
        final com.larus.asr.session.clicktalk.r r68 = (com.larus.asr.session.clicktalk.r) this.w.getValue();
        ClickTalkAsrRoute r125 = (ClickTalkAsrRoute) r124.element;
        final ?? r126 = new e2(r66, this, r7, r124, r19);
        r68.getClass();
        Intrinsics.checkNotNullParameter(r125, "route");
        Intrinsics.checkNotNullParameter(r7, "callParam");
        Intrinsics.checkNotNullParameter(r126, "eventListener");
        com.larus.audio.call.util.e.a.i("ClickTalkAsrServiceFactory", "create " + r125);
        int r69 = com.larus.asr.session.clicktalk.r.a.a[r125.ordinal()];
        if (r69 != 1) goto L175;
        com.larus.asr.session.clicktalk.l r70 = new com.larus.asr.session.clicktalk.t(r68.e, r126);
    L183:
        this.v = r70;
        if (r124.element != ClickTalkAsrRoute.REALTIME_SERVICE) goto L186;
        com.larus.utils.t0.a.post((Runnable) this.P.getValue());
        return;
    L186:
        r70.r(r7);
        return;
    L175:
        if (r69 != 2) goto L177;
        r70 = new com.larus.asr.session.clicktalk.i(r68.b, r68.c, r68.d, new com.larus.asr.session.clicktalk.m(r68, r126), r126);
        goto L183
    L177:
        if (r69 != 3) goto L180;
        r70 = new com.larus.asr.session.clicktalk.a0(r68.a(r126), r7, (CoroutineScope) r68.e.invoke(), r126);
        goto L183
    L180:
        throw new NoWhenBranchMatchedException();
    L167:
        if (this.j != null) goto L169;
        r9.w("SamiCallAsrSession", "FLOW_ASR_TASK start ignored currentCallParam is null");
        r124.element = ClickTalkAsrRoute.REALTIME_SERVICE;
        goto L169
    L161:
        if (r64 == false) goto L163;
        r65 = ClickTalkAsrRoute.FLOW_ASR_TASK;
        goto L164
    L163:
        r65 = ClickTalkAsrRoute.REALTIME_SERVICE;
    L157:
        r60 = null;
    L113:
        r121 = "";
    L101:
        r120 = null;
        goto L102
    L72:
        r110 = false;
        goto L74
    L32:
        r16 = null;
        goto L33
    L28:
        r14 = null;
        goto L29
    L24:
        r12 = null;
        goto L25
    L20:
        r6 = null;
        goto L21
    L14:
        r3 = null;
        goto L15
    L10:
        r0 = null;
        goto L12
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r13, Message r14) {
        Intrinsics.checkNotNullParameter(r13, "taskId");
        this.g = true;
        this.k.set("");
        boolean r1 = this.a.Sa();
        if (r1 == false) goto L6;
        if (r14 == null) goto L6;
        e().cancelAudioText(r14);
    L6:
        FLogger.a.i("SamiCallAsrSession", "setSpeakerVisible: onCancel called: " + r1);
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        if (this.a.F9() == null) goto L11;
        if (r14 == null) goto L10;
        e().deleteOnNoAudioContent(r14);
    L10:
        this.a.ca(null);
    L11:
        x5.a().d(r13);
        if (x5.c().a() == false) goto L14;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SamiCallAsrSession$cancel$3(null), 3, null);
    L14:
        this.f = false;
        this.a.L8(false, false, "onCancel:" + r13, VoiceInputType.TouchSpeaker, r13);
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
    }

    public static final void a(SamiCallAsrSession r6, String r7, Message r8) {
        r6.getClass();
        RealtimeCallParam r3 = r6.j;     // Catch: Exception -> L48
        String r4 = null;
        if (r3 == null) goto L8;
        RealtimeCallParam.d r5 = r3.l;     // Catch: Exception -> L48
        if (r5 == null) goto L8;
        String r9 = r5.c;     // Catch: Exception -> L48
    L10:
        if (Intrinsics.areEqual(r7, r9) == false) goto L52;
        String r10 = r8.getMessageId();     // Catch: Exception -> L48
        if (r10 != null) goto L15;
        return;
    L15:
        if (ObricRealtimeCallServiceDelegate.b.i(r8) == false) goto L30;
        Map r11 = r8.getExt();     // Catch: Exception -> L48
        if (r11 == null) goto L19;
        String r12 = (String) r11.get("local_call_id");     // Catch: Exception -> L48
    L20:
        RealtimeCallParam r13 = r6.j;     // Catch: Exception -> L48
        if (r13 == null) goto L24;
        r4 = r13.e;     // Catch: Exception -> L48
    L24:
        if (Intrinsics.areEqual(r12, r4) == false) goto L30;
        r6.C.add(r10);     // Catch: Exception -> L48
        if (r6.B.get(r10) == null) goto L28;
        r6.B.remove(r10);     // Catch: Exception -> L48
        return;
    L28:
        r6.B.put(r10, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L48
        return;
    L19:
        r12 = null;
    L30:
        if (com.larus.im.bean.message.a.r0(r8) == false) goto L32;
    L46:
        FLogger.a.i("SamiCallAsrSession", "msgStatusLocal=" + r8.getMessageStatusLocal() + ", isServerLoading=" + com.larus.im.bean.message.a.r0(r8) + ", msgStatus=" + r8.getMessageStatus());     // Catch: Exception -> L48
        return;
    L32:
        if (r8.getMessageStatusLocal() == (-1)) goto L46;
        MessageStatus r14 = r8.getMessageStatus();     // Catch: Exception -> L48
        if (r14 == null) goto L38;
        boolean r15 = true;
        if (r14.isVisible() != true) goto L38;
    L39:
        if (r15 == false) goto L46;
        if (r6.C.contains(r8.getReplyId()) == false) goto L56;
        FLogger.a.i("SamiCallAsrSession", "msgId=" + r8.getMessageId() + ", replyId=" + r8.getReplyId() + ", state=" + r8.getMessageStatus());     // Catch: Exception -> L48
        r6.D.add(r8.getMessageId());     // Catch: Exception -> L48
        String r16 = r8.getReplyId();     // Catch: Exception -> L48
        if (r16 == null) goto L57;
        r6.E.put(r16, r10);     // Catch: Exception -> L48
        return;
    L57:
        return;
    L56:
        return;
    L38:
        r15 = false;
        goto L39
    L52:
        return;
    L8:
        r9 = null;
    L48:
        e = move-exception;
        FLogger.a.e("SamiCallAsrSession", e.getMessage());
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r10, Message r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        this.g = false;
        this.k.set("");
        FLogger r0 = FLogger.a;
        r0.i("SamiCallAsrSession", "setSpeakerVisible: onSubmit called");
        this.a.setKeepScreenOn(false);
        e2a.e.c();
        this.f = false;
        this.a.L8(false, false, "onSubmit2:" + r10, VoiceInputType.TouchSpeaker, r10);
        r0.i("SamiCallAsrSession", "ChatBottomComponentWrapper AsrClientManager.stopAsrStream 02");
        com.larus.audio.k0 r13 = x5.a();
        if (r11 == null) goto L5;
        String r2 = r11.getLocalMessageId();
    L6:
        boolean r14 = r13.g(r10, r2, this.a.I9());
        if (r11 == null) goto L26;
        Map r15 = r11.getBusinessExt();
        if (r15 == null) goto L11;
        String r16 = (String) r15.get("tag_audio_text_info");
    L12:
        if (r16 == null) goto L20;
        int r3 = ve8.e.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        Object r17 = Result.constructor-impl(new Gson().fromJson(r16, AudioTextExtra.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r17) == true) goto L20;
    L21:
        AudioTextExtra r19 = (AudioTextExtra) r17;
        if (r19 == null) goto L26;
        Long r110 = r19.getRecordTime();
        if (r110 == null) goto L26;
        long r5 = r110.longValue();
    L27:
        long r6 = SystemClock.elapsedRealtime() - r5;
        if (r14 == false) goto L30;
    L32:
        FLogger.a.w("SamiCallAsrSession", "setSpeakerVisible: onSubmit skip, duration=" + r6);
        if (r11 == null) goto L35;
        e().deleteOnNoAudioContent(r11);
    L35:
        if (r11 == null) goto L37;
        String r111 = r11.getLocalMessageId();
    L39:
        if (com.larus.media.o.a() == false) goto L41;
        MediaResourceManager.a r112 = new MediaResourceManager.a();
        r112.a = 3;
        r112.b = r111;
        r112.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        MediaResourceManager.d(r112);
    L41:
        this.a.ca(null);
        this.a.m8();
        if (x5.c().a() == false) goto L47;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SamiCallAsrSession$submit$2(null), 3, null);
        return;
    L47:
        return;
    L37:
        r111 = null;
        goto L39
    L30:
        if (r6 <= 500) goto L32;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        r17 = null;
        goto L21
    L11:
        r16 = null;
    L26:
        r5 = 0;
        goto L27
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void h(SamiCallAsrSession r6, String r7, Message r8, String r9) {
        r6.g(r7, false, r8, r9, true);
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.G = r5;
        this.I = r2;
        this.J = r3;
        this.K = r4;
    }

    public SamiCallAsrSession(p r2, String r3, boolean r4, Function0<? extends maa.e> r5, VoiceInputType r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r5, "getClickTalkAbility");
        Intrinsics.checkNotNullParameter(r6, "voiceInputType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.i = new f2a.d("VoiceInput", "SamiCallAsrSession");
        this.k = new AtomicReference("");
        this.l = new AtomicReference("");
        this.s = LazyKt.lazy(new k2());
        this.t = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.u = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(this.t));
        this.w = LazyKt.lazy(new l2(this));
        this.x = ObricAsrDelegate.b.p();
        this.y = LazyKt.lazy(new m2());
        this.z = new SamiCallAsrSession$asrResultListener$1(this);
        this.B = new ConcurrentHashMap();
        this.C = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.E = new ConcurrentHashMap();
        this.F = LazyKt.lazy(new n2(this));
        this.G = new o2();
        this.I = new p2();
        this.K = new q2();
        this.L = new u1();
        this.M = new CopyOnWriteArraySet();
        this.N = new CopyOnWriteArraySet();
        this.O = new AtomicReference();
        this.P = LazyKt.lazy(new v1(this));
        this.Q = new b(this);
    }

    public final Object g(String r8, boolean r9, Message r10, String r11, boolean r12) {
        if (r9 == false) goto L5;
        FLogger.a.i("SamiCallAsrSession", "setSpeakerVisible visible isSpeaking:" + this.f);
        this.a.sb("ban_speaker_visible_" + r11);
        e2a.e.b();
        this.a.L8(true, r12, r11, this.e, r8);
        this.a.Ja(r8, r10);
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("SamiCallAsrSession", "setSpeakerVisible invisible");
        this.f = false;
        this.a.L8(false, false, r11, this.e, r8);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [com.larus.asr.session.j2] */
    @Override // com.larus.asr.session.o
    public final void pa(final String r60, final boolean r61, final boolean r62, final com.larus.audio.asr.c0 r63, final long r64, Long r66, Integer r67, d58.a r68) {
        Intrinsics.checkNotNullParameter(r60, "itemId");
        Intrinsics.checkNotNullParameter(r63, "traceInfo");
        Intrinsics.checkNotNullParameter(r68, "durationConfig");
        final String r7 = UUID.randomUUID().toString();
        this.k.set(r7);
        wc9.e r0 = this.a.h();
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (r1 != null) goto L9;
        String r10 = "";
    L10:
        BotModel r2 = this.a.i();
        if (r2 == null) goto L13;
        String r3 = r2.getBotId();
    L14:
        if (r3 != null) goto L16;
        String r9 = "";
    L17:
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r10, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        f2a.c r4 = this.i.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put(new f2a.f("from_text_area"), String.valueOf(r61));
        r5.put(new f2a.f("asr_only"), "false");
        r5.put(f2a.f.h, r10);
        r5.put(f2a.f.e, r9);
        r4.d(r5);
        r4.c.d = "invokeOnSpeak";
        List r6 = CollectionsKt.listOf(r63.a);
        f2a.g r8 = r4.c;
        r8.b = r6;
        r8.e = r63.b;
        f2a.c.c(r4, null, 15);
        boolean r12 = this.c;
        final String r14 = r9;
        final String r11 = r10;
        String r15 = r10;
        final ?? r13 = new j2(this, r63, r60, r64, r62, r7, r61, r11, r14);
        FLogger.a.i("SamiCallAsrSession", "tryPrepareMessage asrOnly: " + r12 + " voiceInputType: " + this.e);
        if (r12 == true) goto L20;
        e().breakAnswer(r15);
        ObricChatSPIServiceDelegate.b.g(r15);
        e().prepareAudioText(r15, this.a.h(), r14, this.a.M1(), new w1(this, r14, r13));
        return;
    L20:
        String r30 = UUID.randomUUID().toString();
        r13.invoke(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r30, r30, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -49153, 31, null));
        return;
    L16:
        r9 = r3;
        goto L17
    L13:
        r3 = null;
        goto L14
    L9:
        r10 = r1;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
