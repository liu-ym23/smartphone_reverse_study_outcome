package com.larus.asr.session;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.KmpAsrSessionAdapter;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.asr.x5;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.MessageMenu;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.media.MediaResourceManager;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SendMessageAsrSession implements o {
    public final Handler A;
    public final n3 B;
    public volatile boolean C;
    public final p a;
    public final String b;
    public final VoiceInputType c;
    public e3 d;
    public boolean e;
    public boolean f;
    public final f2a.d g;
    public final Lazy h;
    public Function1<? super String, Boolean> i;
    public Function2<? super String, ? super String, Boolean> j;
    public Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> k;
    public Function2<? super String, ? super Boolean, Unit> l;
    public Function1<? super com.larus.audio.b, Boolean> m;
    public Function1<? super com.larus.audio.a, Boolean> n;
    public String o;
    public Function2<? super String, ? super byte[], Unit> p;
    public Function0<Unit> q;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> r;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> s;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> t;
    public boolean u;
    public volatile Long v;
    public volatile Long w;
    public final Lazy x;
    public final Lazy y;
    public d58.a z;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
        this.C = true;
        this.v = null;
        this.A.removeCallbacks(this.B);
        KmpAsrSessionAdapter r1 = (KmpAsrSessionAdapter) this.y.getValue();
        r1.c();
        lw5.e r2 = r1.b;
        if (r2 == null) goto L5;
        r2.V2(false, false);
    L5:
        r1.b = null;
        c5.c();
        a5.b();
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.t.get();
    }

    public final n e() {
        return (n) this.h.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.x.getValue()).booleanValue();
    }

    public final boolean g() {
        if (this.a.ob() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.a.Cb() == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(com.larus.platform.service.z2.a.voiceInputHandsfreeConfig().getHandsfreeAsrEndBehavior(), "backfill") == false) goto L9;
        goto L8
    }

    public final void i() {
        this.A.removeCallbacks(this.B);
        if (this.a.B5() != AsrInputMode.HANDSFREE) goto L5;
        boolean r0 = true;
    L6:
        d58.a r1 = this.z;
        if (r0 == false) goto L9;
        long r2 = r1.a;
    L11:
        if (r2 <= 0) goto L18;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("arm max duration timer: ");
        r4.append(r2);
        r4.append("ms, taskId=");
        r4.append(this.b);
        r4.append(", mode=");
        if (r0 == false) goto L15;
        String r5 = "HANDSFREE";
    L16:
        r4.append(r5);
        r3.i("SendMessageAsrSession", r4.toString());
        this.A.postDelayed(this.B, r2);
        return;
    L15:
        r5 = "LONG_PRESS";
        goto L16
    L18:
        return;
    L9:
        r2 = r1.b;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
        if (f() == false) goto L6;
        ((KmpAsrSessionAdapter) this.y.getValue()).c();
        return;
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return this.e;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.s.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.r.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.s.remove(r2);
    }

    public final void b(String r3) {
        if (com.larus.media.o.a() == false) goto L6;
        MediaResourceManager.a r0 = new MediaResourceManager.a();
        r0.a = 3;
        r0.b = r3;
        r0.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r4 = MediaResourceManager.a;
        MediaResourceManager.d(r0);
        return;
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "withExtHandle");
        this.k = r2;
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.r.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
        this.l = r1;
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("SendMessageAsrSession", "notifyStateChanged state: " + r4.getClass());
        this.t.set(r4);
        Iterator<T> r0 = this.r.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.bmhome.chat.component.bottom.core.speaker.h) r0.next()).a(r4);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.j = r2;
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent$f r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.q = r2;
    }

    public final boolean c(Message r3, String r4) {
        if (this.a.m2(r4) == true) goto L6;
        return false;
    L6:
        FLogger.a.i("SendMessageAsrSession", "backfillIfVoiceRetained: appended into input text, delete local msg " + r3.getLocalMessageId());
        e().deleteOnNoAudioContent(r3);
        return true;
    }

    public final JSONObject d(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("local_message_id", r3);
        r0.put("item_id", r4);
        if (com.larus.bmhome.utils.i.f(this.a.h()) == false) goto L7;
        hq9.g1 r5 = com.larus.platform.service.z2.a.getAsrCheckAudioConfig();
        if (r5 == null) goto L7;
        int r6 = r5.a();
    L8:
        r0.put("check_audio_tag", r6);
        e58.a.a(r0);
        e58.a.d(r0, this.a.L0(), this.a.E9());
        e58.a.c(r0);
        e58.a.b(r0);
        return r0;
    L7:
        r6 = 0;
        goto L8
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r11, Message r12) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        boolean r0 = true;
        this.C = true;
        this.A.removeCallbacks(this.B);
        this.f = true;
        if (this.a.Sa() == false) goto L6;
        if (r12 == null) goto L6;
        e().cancelAudioText(r12);
    L6:
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        if (this.a.F9() == null) goto L12;
        if (r12 == null) goto L10;
        e().deleteOnNoAudioContent(r12);
    L10:
        this.a.ca(null);
    L12:
        if (f() == false) goto L14;
        ((KmpAsrSessionAdapter) this.y.getValue()).a(r11);
    L15:
        this.d = null;
        IObricDoraService r13 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r13 != null) goto L18;
    L20:
        r0 = false;
    L22:
        if (x5.c().a() == false) goto L27;
        if (r0 == true) goto L25;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SendMessageAsrSession$cancel$3(null), 3, null);
        goto L27
    L25:
        if (this.u == false) goto L26;
    L27:
        if (r0 == true) goto L29;
    L31:
        this.e = false;
        this.a.L8(false, false, "onCancel:" + r11, VoiceInputType.TouchSpeaker, r11);
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
        return;
    L29:
        if (this.u == false) goto L31;
        this.u = false;
        goto L31
    L18:
        if (r13.t() != true) goto L20;
    L14:
        x5.a().d(r11);
        goto L15
    }

    /* JADX WARN: Type inference failed for: r2v20, types: [com.larus.asr.session.n3] */
    public SendMessageAsrSession(p r2, String r3, VoiceInputType r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = new f2a.d("VoiceInput", "SendMessageAsrSession");
        this.h = LazyKt.lazy(new m3(this));
        this.i = new o3();
        this.j = new p3(this);
        this.k = new q3();
        this.m = new r3();
        this.n = new w2();
        this.p = new x2();
        this.q = new y2();
        this.r = new CopyOnWriteArraySet();
        this.s = new CopyOnWriteArraySet();
        this.t = new AtomicReference();
        this.x = LazyKt.lazy(new z2());
        this.y = LazyKt.lazy(new a3());
        this.z = d58.a.d;
        this.A = new Handler(Looper.getMainLooper());
        this.B = new n3(this);
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r24, final Message r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r24, "taskId");
        this.w = Long.valueOf(System.currentTimeMillis());
        boolean r9 = true;
        this.C = true;
        this.A.removeCallbacks(this.B);
        this.f = false;
        FLogger r11 = FLogger.a;
        r11.i("SendMessageAsrSession", "setSpeakerVisible: onSubmit called");
        this.a.setKeepScreenOn(false);
        e2a.e.c();
        this.e = false;
        this.a.L8(false, false, "onSubmit2:" + r24, VoiceInputType.TouchSpeaker, r24);
        r11.i("SendMessageAsrSession", "ChatBottomComponentWrapper AsrClientManager.stopAsrStream 02");
        if (f() == false) goto L6;
        boolean r0 = ((KmpAsrSessionAdapter) this.y.getValue()).f(r24);
    L5:
        boolean r2 = r0;
        if (r25 == null) goto L31;
        Map r1 = r25.getBusinessExt();
        if (r1 == null) goto L16;
        String r3 = (String) r1.get("tag_audio_text_info");
    L17:
        if (r3 == null) goto L25;
        int r6 = ve8.e.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L21
        Object r4 = Result.constructor-impl(new Gson().fromJson(r3, AudioTextExtra.class));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r4) == true) goto L25;
    L26:
        AudioTextExtra r5 = (AudioTextExtra) r4;
        if (r5 == null) goto L31;
        Long r8 = r5.getRecordTime();
        if (r8 == null) goto L31;
        long r10 = r8.longValue();
    L32:
        long r13 = SystemClock.elapsedRealtime() - r10;
        ObricAsrDelegate r12 = ObricAsrDelegate.b;
        if (r12.m() == true) goto L35;
    L37:
        boolean r14 = false;
    L38:
        if (r14 == false) goto L61;
        Long r15 = this.v;
        if (r15 == null) goto L61;
        if (r15.longValue() <= 0) goto L45;
        boolean r16 = true;
    L46:
        if (r16 == true) goto L49;
        r15 = null;
    L49:
        if (r15 == null) goto L61;
        Long r17 = Long.valueOf(System.currentTimeMillis() - r15.longValue());
        long r19 = r17.longValue();
        if (1 <= r19) goto L53;
    L55:
        boolean r20 = false;
    L56:
        if (r20 == true) goto L59;
        r17 = null;
    L59:
        if (r17 == null) goto L61;
        long r21 = Math.max(r13, r17.longValue());
    L62:
        e3 r22 = this.d;
        if (r22 == null) goto L65;
        r22.invoke();
        this.d = null;
    L125:
        this.a.ca(null);
        this.a.m8();
        IObricDoraService r23 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r23 != null) goto L128;
    L130:
        r9 = false;
    L132:
        if (x5.c().a() == false) goto L137;
        if (r9 == true) goto L135;
    L136:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SendMessageAsrSession$submit$2(null), 3, null);
        goto L137
    L135:
        if (this.u == false) goto L136;
    L137:
        if (r9 == true) goto L139;
        return;
    L139:
        if (this.u == false) goto L145;
        this.u = false;
        return;
    L145:
        return;
    L128:
        if (r23.t() != true) goto L130;
    L65:
        if (r2 == false) goto L67;
    L118:
        FLogger.a.w("SendMessageAsrSession", "setSpeakerVisible: onSubmit skip, duration=" + r13 + ", effectiveDuration=" + r21 + ", preStartTime=" + this.v + ", minDuration=500");
        if (r25 == null) goto L121;
        e().deleteOnNoAudioContent(r25);
    L121:
        if (r25 == null) goto L123;
        String r27 = r25.getLocalMessageId();
    L124:
        b(r27);
        goto L125
    L123:
        r27 = null;
        goto L124
    L67:
        if (r21 <= 500) goto L118;
        ChatBottomSpeakerComponent r29 = this.a;
        if ((r29 instanceof ChatBottomSpeakerComponent) == false) goto L71;
        ChatBottomSpeakerComponent r30 = r29;
    L72:
        if (r30 == null) goto L77;
        if (r25 == null) goto L75;
        String r31 = r25.getLocalMessageId();
    L76:
        boolean r32 = r30.X3(r31);
    L78:
        IAIChatControlTraceService.Companion r110 = IAIChatControlTraceService.a;
        if (r25 == null) goto L81;
        String r33 = r25.getLocalMessageId();
    L82:
        String r34 = "";
        if (r33 != null) goto L85;
        String r111 = "";
    L86:
        r110.ub(r111, r26, r13, Math.min(r13, this.a.Ea()), this.a.Qa());
        FLogger r35 = FLogger.a;
        StringBuilder r36 = new StringBuilder("setSpeakerVisible: onSubmit called, duration=");
        r36.append(r13);
        r36.append("  ");
        if (r25 == null) goto L89;
        String r37 = r25.getLocalMessageId();
    L90:
        r36.append(r37);
        r35.i("SendMessageAsrSession", r36.toString());
        if (r25 == null) goto L125;
        if ((!this.a.ya()) == false) goto L95;
        Message r38 = r25;
    L96:
        if (r38 == null) goto L125;
        if (g() == false) goto L101;
        r35.i("SendMessageAsrSession", "onSubmit: handsfree backfill, skip submitAudioText to avoid msg-list loading");
        goto L125
    L101:
        if (this.a.Ra() == false) goto L103;
        HashMap<String, Function0<Unit>> r39 = a5.a;
        a5.a(r38.getLocalMessageId(), new b3(this, r25));
    L105:
        if (com.larus.platform.service.z2.a.getSendMessageNetworkToastConfig().a() != 1) goto L125;
        int r40 = com.larus.utils.f0.a;
        AppHost.Companion r41 = AppHost.a;
        if (com.larus.utils.f0.a(r41.getApplication()) == true) goto L125;
        t19.s r42 = t19.s.a;
        Application r43 = r41.getApplication();
        r42.getClass();
        t19.s.s(r43, 2131908080);
        Function2<? super String, ? super Boolean, Unit> r44 = this.l;
        if (r44 == null) goto L116;
        String r45 = r25.getContent();
        if (r45 == null) goto L114;
        r34 = r45;
    L114:
        r44.invoke(r34, Boolean.valueOf(r32));
    L116:
        if (((Boolean) this.n.invoke(new com.larus.audio.a(r25.getContent(), r32))).booleanValue() == false) goto L125;
        e().deleteOnNoAudioContent(r25);
        goto L125
    L103:
        e().submitAudioText(r25);
        goto L105
    L95:
        r38 = null;
        goto L96
    L89:
        r37 = null;
        goto L90
    L85:
        r111 = r33;
        goto L86
    L81:
        r33 = null;
        goto L82
    L75:
        r31 = null;
        goto L76
    L77:
        r32 = false;
        goto L78
    L71:
        r30 = null;
        goto L72
    L53:
        if (r19 >= 5001) goto L55;
        r20 = true;
        goto L56
    L45:
        r16 = false;
    L61:
        r21 = r13;
        goto L62
    L35:
        if (r12.a() == false) goto L37;
        r14 = true;
    L21:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        r4 = null;
        goto L26
    L16:
        r3 = null;
    L31:
        r10 = 0;
        goto L32
    L6:
        com.larus.audio.k0 r47 = x5.a();
        if (r25 == null) goto L9;
        String r48 = r25.getLocalMessageId();
    L10:
        r0 = r47.g(r24, r48, this.a.I9());
        goto L5
    L9:
        r48 = null;
        goto L10
    }

    public final i3 a(Message r8, String r9, com.larus.audio.asr.c0 r10, VoiceInputType r11) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r9, "currentTaskId");
        Intrinsics.checkNotNullParameter(r10, "traceInfo");
        Intrinsics.checkNotNullParameter(r11, "voiceInputType");
        return new i3(this, r10, r8, r9, r11);
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, final Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.i = r5;
        this.j = new v2(r5);
        this.m = r2;
        this.n = r3;
        this.p = r4;
    }

    public static /* synthetic */ void k(SendMessageAsrSession r6, String r7, Message r8, String r9, int r10) {
        if ((r10 & 4) == 0) goto L5;
        r8 = null;
    L5:
        Message r3 = r8;
        if ((r10 & 16) == 0) goto L8;
        boolean r5 = true;
    L9:
        r6.j(r7, false, r3, r9, r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    public final Object j(String r8, boolean r9, Message r10, String r11, boolean r12) {
        if (r9 == false) goto L5;
        FLogger.a.i("SendMessageAsrSession", "setSpeakerVisible visible isSpeaking:" + this.e);
        this.a.sb("ban_speaker_visible_" + r11);
        e2a.e.b();
        this.a.L8(true, r12, r11, VoiceInputType.TouchSpeaker, r8);
        this.a.Ja(r8, r10);
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("SendMessageAsrSession", "setSpeakerVisible invisible");
        this.e = false;
        this.a.L8(false, false, r11, VoiceInputType.TouchSpeaker, r8);
        goto L7
    }

    public final void h(Message r42, String r43, String r44, String r45, String r46, VoiceInputType r47, com.larus.audio.b r48) {
        String r3 = null;
        if (r48 == null) goto L7;
        com.larus.audio.c r4 = r48.g;
        if (r4 == null) goto L7;
        String r10 = r4.d;
    L9:
        if (((Boolean) this.j.invoke(r44, r10)).booleanValue() == false) goto L16;
        if (this.a.ob() == false) goto L13;
        FLogger.a.i("SendMessageAsrSession", "realSendAudioMsg: handsfree backfill intercepted, delete local msg " + r42.getLocalMessageId());
        e().deleteOnNoAudioContent(r42);
        return;
    L13:
        FLogger.a.i("SendMessageAsrSession", "realSendAudioMsg: intercepted by legacy interceptor, skip auto delete");
        return;
    L16:
        if (this.f == false) goto L19;
        FLogger.a.i("SendMessageAsrSession", "realSendAudioMsg: intercepted by isCancel=true ,content(" + g2a.d.b(r44) + "), taskId = " + r43);
        return;
    L19:
        ChatBottomSpeakerComponent r5 = this.a;
        if ((r5 instanceof ChatBottomSpeakerComponent) == false) goto L22;
        ChatBottomSpeakerComponent r6 = r5;
    L23:
        if (r6 == null) goto L28;
        if (r42 == null) goto L26;
        String r12 = r42.getLocalMessageId();
    L27:
        boolean r7 = r6.X3(r12);
    L29:
        if (r48 != null) goto L31;
    L34:
        com.larus.bmhome.chat.component.bottom.core.speaker.a r2 = (com.larus.bmhome.chat.component.bottom.core.speaker.a) this.k.invoke(r44);
        if (r2.a == false) goto L38;
        e().deleteOnNoAudioContentWithoutContent(r42);
        return;
    L38:
        String r13 = this.a.ub(r44);
        ChatBottomSpeakerComponent r8 = this.a;
        if ((r8 instanceof ChatBottomSpeakerComponent) == false) goto L41;
        ChatBottomSpeakerComponent r9 = r8;
    L43:
        if (r9 != null) goto L45;
    L47:
        boolean r11 = false;
    L48:
        if (r11 == false) goto L51;
        e().deleteOnNoAudioContent(r42);
        return;
    L51:
        Map r14 = r2.b;
        if (this.a.ya() == false) goto L56;
        this.a.ib(r44, r14, r47);
        return;
    L56:
        if (this.a.Ua(r44) == true) goto L59;
        e().deleteOnNoAudioContent(r42);
        return;
    L59:
        FLogger.a.i("SendMessageAsrSession", "onSpeak: content(" + g2a.d.b(r13) + "), taskId = " + r43);
        wc9.e r1 = this.a.h();
        if (r1 == null) goto L63;
        r3 = r1.a;
    L63:
        if (r3 != null) goto L65;
        String r15 = "";
    L66:
        IAIChatService.a.c(r15, r43);
        AttachmentInfo r24 = this.a.X9();
        WeakReference r16 = MessageMenu.x;
        MessageMenu.a.a();
        if (r24 == null) goto L88;
        ArrayList r17 = new ArrayList();
        String r26 = r24.getFilePath();
        String r27 = r24.getTosKey();
        Integer r19 = r24.getHeight();
        if (r19 == null) goto L71;
        int r20 = r19.intValue();
    L72:
        Integer r29 = Integer.valueOf(r20);
        Integer r21 = r24.getWidth();
        if (r21 == null) goto L75;
        int r22 = r21.intValue();
    L76:
        r17.add(new ai8.e(r26, r27, r29, Integer.valueOf(r22), null, null, null, null, null, null, false, this.a.M1(), null, null, 28656));
        Map r23 = this.a.eb(r13, r42, null, r24, r14);
        r23.put("is_audio", String.valueOf(true));
        if (com.larus.utils.o0.d(r10) == false) goto L82;
        if (r10 != null) goto L80;
        r10 = "";
    L80:
        r23.put("asr_log_id", r10);
    L82:
        if (r13.length() <= 0) goto L84;
        boolean r110 = true;
    L85:
        if (r110 == false) goto L87;
        r17.add(new ai8.h(r13, null, null, null, r23, null, false, false, this.a.M1(), null, 750));
    L87:
        e().sendFileAndTxt(this.a.h(), "speak", r17, r24.getFromScene(), this.w);
        e().deleteOnNoAudioContent(r42);
    L117:
        this.a.Gb(r43);
        IAIChatRenderTraceService.a.j(r43);
        return;
    L84:
        r110 = false;
        goto L85
    L75:
        r22 = 0;
        goto L76
    L71:
        r20 = 0;
        goto L72
    L88:
        ReferenceInfo r111 = this.a.G9();
        String r112 = r15;
        Map r25 = this.a.eb(r13, r42, r111, r24, r14);
        if (com.larus.utils.o0.d(r45) == false) goto L95;
        if (r45 != null) goto L92;
        String r30 = "";
    L93:
        r25.put("audio_data_tos_uri", r30);
        goto L95
    L92:
        r30 = r45;
    L95:
        if (com.larus.utils.o0.d(r46) == false) goto L101;
        if (r46 != null) goto L98;
        String r31 = "";
    L99:
        r25.put("audio_event_resp", r31);
        goto L101
    L98:
        r31 = r46;
    L101:
        if (com.larus.utils.o0.d(r10) == false) goto L106;
        if (r10 != null) goto L104;
        r10 = "";
    L104:
        r25.put("asr_log_id", r10);
    L106:
        if (r111 != null) goto L109;
        r13 = this.a.Jb(r13);
    L109:
        String r113 = r13;
        String r114 = r42.getLocalMessageId();
        if (r111 != null) goto L112;
        ReferenceInfo r115 = com.larus.bmhome.chat.bean.d.b1(r42);
    L113:
        ai8.b r32 = new ai8.b(r113, r114, r115, r25, r42.getBusinessExt(), false, this.a.M1(), this.w, 32);
        if (r111 != null) goto L116;
        this.a.Ga(r42);
    L116:
        e().sendAudioText(r112, r32, r42, r47);
        goto L117
    L112:
        r115 = r111;
        goto L113
    L65:
        r15 = r3;
        goto L66
    L45:
        if (r9.c4(r13) != true) goto L47;
        r11 = true;
        goto L48
    L41:
        r9 = null;
        goto L43
    L31:
        if (((Boolean) this.m.invoke(com.larus.audio.b.a(r48, r7))).booleanValue() == false) goto L34;
        e().deleteOnNoAudioContentWithoutContent(r42);
        return;
    L26:
        r12 = null;
        goto L27
    L28:
        r7 = false;
        goto L29
    L22:
        r6 = null;
    L7:
        r10 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [com.larus.asr.session.g3] */
    @Override // com.larus.asr.session.o
    public final void pa(final String r20, final boolean r21, final boolean r22, final com.larus.audio.asr.c0 r23, final long r24, final Long r26, final Integer r27, d58.a r29) {
        Intrinsics.checkNotNullParameter(r20, "itemId");
        Intrinsics.checkNotNullParameter(r23, "traceInfo");
        Intrinsics.checkNotNullParameter(r29, "durationConfig");
        this.z = r29;
        this.v = r26;
        wc9.e r0 = this.a.h();
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (r1 != null) goto L9;
        String r11 = "";
    L10:
        BotModel r2 = this.a.i();
        if (r2 == null) goto L13;
        String r3 = r2.getBotId();
    L14:
        if (r3 != null) goto L16;
        String r10 = "";
    L17:
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r11, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        f2a.c r4 = this.g.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put(new f2a.f("from_text_area"), String.valueOf(r21));
        r5.put(new f2a.f("asr_only"), "false");
        r5.put(f2a.f.h, r11);
        r5.put(f2a.f.e, r10);
        r4.d(r5);
        r4.c.d = "invokeOnSpeak";
        List r6 = CollectionsKt.listOf(r23.a);
        f2a.g r7 = r4.c;
        r7.b = r6;
        r7.e = r23.b;
        f2a.c.c(r4, null, 15);
        final String r14 = r10;
        final String r12 = r11;
        String r15 = r11;
        final ?? r13 = new g3(this, r23, r20, r24, r26, r22, r27, r21, r12, r14);
        FLogger.a.i("SendMessageAsrSession", "tryPrepareMessage asrOnly: false voiceInputType: " + this.c);
        if (com.larus.platform.exp.s.d == true) goto L20;
        e().breakAnswer(r15);
    L20:
        e().prepareAudioText(r15, this.a.h(), r14, this.a.M1(), new k3(this, r14, r13));
        return;
    L16:
        r10 = r3;
        goto L17
    L13:
        r3 = null;
        goto L14
    L9:
        r11 = r1;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
