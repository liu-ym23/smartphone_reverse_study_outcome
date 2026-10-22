package com.larus.asr.session;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.asr.x5;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.media.MediaResourceManager;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class InputTextAsrSession2 implements o {
    public final p a;
    public final String b;
    public c0 c;
    public boolean d;
    public boolean e;
    public final f2a.d f;
    public final Lazy g;
    public Function1<? super String, Boolean> h;
    public Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> i;
    public Function2<? super String, ? super Boolean, Unit> j;
    public Function1<? super com.larus.audio.b, Boolean> k;
    public Function1<? super com.larus.audio.a, Boolean> l;
    public Function2<? super String, ? super byte[], Unit> m;
    public Function0<Unit> n;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> o;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> p;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> q;
    public boolean r;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.q.get();
    }

    public final n b() {
        return (n) this.g.getValue();
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
        c5.c();
        a5.b();
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return this.d;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.p.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.o.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.p.remove(r2);
    }

    public final void a(String r3) {
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
        this.i = r2;
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.o.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
        this.j = r1;
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("InputTextAsrSession2", "notifyStateChanged state: " + r4.getClass());
        this.q.set(r4);
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.bmhome.chat.component.bottom.core.speaker.h) r0.next()).a(r4);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent$f r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.n = r2;
    }

    public InputTextAsrSession2(p r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.a = r2;
        this.b = r3;
        this.f = new f2a.d("VoiceInput", "InputTextAsrSession2");
        this.g = LazyKt.lazy(new d0(this));
        this.h = new e0();
        this.i = new f0();
        this.k = new g0();
        this.l = new h0();
        this.m = new i0();
        this.n = new j0();
        this.o = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new AtomicReference();
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r10, Message r11) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        boolean r0 = true;
        this.e = true;
        if (this.a.Sa() == false) goto L6;
        if (r11 == null) goto L6;
        b().cancelAudioText(r11);
    L6:
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        x5.a().d(r10);
        this.c = null;
        IObricDoraService r2 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r2 != null) goto L9;
    L11:
        r0 = false;
    L13:
        if (x5.c().a() == false) goto L18;
        if (r0 == true) goto L16;
    L17:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InputTextAsrSession2$cancel$2(null), 3, null);
        goto L18
    L16:
        if (this.r == false) goto L17;
    L18:
        if (r0 == true) goto L20;
    L22:
        this.d = false;
        this.a.L8(false, false, "onCancel:" + r10, VoiceInputType.TouchSpeaker, r10);
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
        return;
    L20:
        if (this.r == false) goto L22;
        this.r = false;
        goto L22
    L9:
        if (r2.t() != true) goto L11;
        goto L11
    }

    public final void c(String r4, com.larus.audio.b r5, Message r6) {
        if (((Boolean) this.h.invoke(r4)).booleanValue() == false) goto L5;
        return;
    L5:
        ChatBottomSpeakerComponent r0 = this.a;
        String r2 = null;
        if ((r0 instanceof ChatBottomSpeakerComponent) == false) goto L8;
        ChatBottomSpeakerComponent r1 = r0;
    L9:
        if (r1 == null) goto L13;
        if (r6 == null) goto L12;
        r2 = r6.getLocalMessageId();
    L12:
        boolean r3 = r1.X3(r2);
    L14:
        if (r5 == null) goto L20;
        if (((Boolean) this.k.invoke(com.larus.audio.b.a(r5, r3))).booleanValue() == false) goto L20;
        b().deleteOnNoAudioContentWithoutContent(r6);
        return;
    L20:
        if (this.e == false) goto L24;
        FLogger.a.i("InputTextAsrSession2", "realSendAudioMsg: intercepted by isCancel=true ,content(" + g2a.d.b(r4) + "), taskId = " + this.b);
        return;
    L24:
        if (((com.larus.bmhome.chat.component.bottom.core.speaker.a) this.i.invoke(r4)).a == false) goto L26;
        return;
    L26:
        this.a.J9(r4, true);
        return;
    L13:
        r3 = false;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r12, final Message r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        this.e = false;
        FLogger r1 = FLogger.a;
        r1.i("InputTextAsrSession2", "setSpeakerVisible: onSubmit called");
        this.a.setKeepScreenOn(false);
        e2a.e.c();
        this.d = false;
        this.a.L8(false, false, "onSubmit2:" + r12, VoiceInputType.TouchSpeaker, r12);
        r1.i("InputTextAsrSession2", "ChatBottomComponentWrapper AsrClientManager.stopAsrStream 02");
        com.larus.audio.k0 r2 = x5.a();
        if (r13 == null) goto L5;
        String r4 = r13.getLocalMessageId();
    L6:
        boolean r15 = r2.g(r12, r4, this.a.I9());
        if (r13 == null) goto L26;
        Map r3 = r13.getBusinessExt();
        if (r3 == null) goto L11;
        String r5 = (String) r3.get("tag_audio_text_info");
    L12:
        if (r5 == null) goto L20;
        int r6 = ve8.e.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        Object r8 = Result.constructor-impl(new Gson().fromJson(r5, AudioTextExtra.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r8) == true) goto L20;
    L21:
        AudioTextExtra r9 = (AudioTextExtra) r8;
        if (r9 == null) goto L26;
        Long r10 = r9.getRecordTime();
        if (r10 == null) goto L26;
        long r11 = r10.longValue();
    L27:
        long r16 = SystemClock.elapsedRealtime() - r11;
        c0 r17 = this.c;
        boolean r19 = true;
        if (r17 == null) goto L30;
        r17.invoke();
        this.c = null;
    L86:
        this.a.m8();
        IObricDoraService r110 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r110 != null) goto L89;
    L91:
        r19 = false;
    L93:
        if (x5.c().a() == false) goto L98;
        if (r19 == true) goto L96;
    L97:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InputTextAsrSession2$submit$2(null), 3, null);
        goto L98
    L96:
        if (this.r == false) goto L97;
    L98:
        if (r19 == true) goto L100;
        return;
    L100:
        if (this.r == false) goto L106;
        this.r = false;
        return;
    L106:
        return;
    L89:
        if (r110.t() != true) goto L91;
    L30:
        if (r15 == false) goto L32;
    L79:
        FLogger.a.w("InputTextAsrSession2", "setSpeakerVisible: onSubmit skip, duration=" + r16);
        if (r13 == null) goto L82;
        b().deleteOnNoAudioContent(r13);
    L82:
        if (r13 == null) goto L84;
        String r111 = r13.getLocalMessageId();
    L85:
        a(r111);
        goto L86
    L84:
        r111 = null;
        goto L85
    L32:
        if (r16 <= 500) goto L79;
        ChatBottomSpeakerComponent r112 = this.a;
        if ((r112 instanceof ChatBottomSpeakerComponent) == false) goto L36;
        ChatBottomSpeakerComponent r113 = r112;
    L37:
        if (r113 == null) goto L42;
        if (r13 == null) goto L40;
        String r20 = r13.getLocalMessageId();
    L41:
        boolean r114 = r113.X3(r20);
    L43:
        IAIChatControlTraceService.Companion r21 = IAIChatControlTraceService.a;
        if (r13 == null) goto L46;
        String r22 = r13.getLocalMessageId();
    L47:
        String r23 = "";
        if (r22 != null) goto L50;
        r22 = "";
    L50:
        IAIChatControlTraceService.a.f(r21, r22, r14, r16);
        FLogger r115 = FLogger.a;
        StringBuilder r24 = new StringBuilder("setSpeakerVisible: onSubmit called, duration=");
        r24.append(r16);
        r24.append("  ");
        if (r13 == null) goto L53;
        String r25 = r13.getLocalMessageId();
    L54:
        r24.append(r25);
        r115.i("InputTextAsrSession2", r24.toString());
        if (r13 == null) goto L86;
        if ((!this.a.ya()) == false) goto L59;
        Message r116 = r13;
    L60:
        if (r116 == null) goto L86;
        if (this.a.Ra() == false) goto L64;
        HashMap<String, Function0<Unit>> r26 = a5.a;
        a5.a(r116.getLocalMessageId(), new k0(this, r13));
    L66:
        if (com.larus.platform.service.z2.a.getSendMessageNetworkToastConfig().a() != 1) goto L86;
        AppHost.Companion r117 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r117.getApplication()) == true) goto L86;
        t19.s r27 = t19.s.a;
        Application r118 = r117.getApplication();
        r27.getClass();
        t19.s.s(r118, 2131908080);
        Function2<? super String, ? super Boolean, Unit> r119 = this.j;
        if (r119 == null) goto L77;
        String r29 = r13.getContent();
        if (r29 == null) goto L75;
        r23 = r29;
    L75:
        r119.invoke(r23, Boolean.valueOf(r114));
    L77:
        if (((Boolean) this.l.invoke(new com.larus.audio.a(r13.getContent(), r114))).booleanValue() == false) goto L86;
        b().deleteOnNoAudioContent(r13);
        goto L86
    L64:
        b().submitAudioText(r13);
        goto L66
    L59:
        r116 = null;
        goto L60
    L53:
        r25 = null;
        goto L54
    L46:
        r22 = null;
        goto L47
    L40:
        r20 = null;
        goto L41
    L42:
        r114 = false;
        goto L43
    L36:
        r113 = null;
    L16:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        r8 = null;
        goto L21
    L11:
        r5 = null;
    L26:
        r11 = 0;
        goto L27
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.h = r5;
        this.k = r2;
        this.l = r3;
        this.m = r4;
    }

    public static /* synthetic */ void e(InputTextAsrSession2 r6, String r7, Message r8, String r9, int r10) {
        if ((r10 & 4) == 0) goto L5;
        r8 = null;
    L5:
        Message r3 = r8;
        if ((r10 & 16) == 0) goto L8;
        boolean r5 = true;
    L9:
        r6.d(r7, false, r3, r9, r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    public final Object d(String r8, boolean r9, Message r10, String r11, boolean r12) {
        if (r9 == false) goto L5;
        FLogger.a.i("InputTextAsrSession2", "setSpeakerVisible visible isSpeaking:" + this.d);
        this.a.sb("ban_speaker_visible_" + r11);
        e2a.e.b();
        this.a.L8(true, r12, r11, VoiceInputType.TouchSpeaker, r8);
        this.a.Ja(r8, r10);
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("InputTextAsrSession2", "setSpeakerVisible invisible");
        this.d = false;
        this.a.L8(false, false, r11, VoiceInputType.TouchSpeaker, r8);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.asr.session.v] */
    @Override // com.larus.asr.session.o
    public final void pa(final String r61, final boolean r62, final boolean r63, final com.larus.audio.asr.c0 r64, final long r65, final Long r67, final Integer r68, d58.a r69) {
        Intrinsics.checkNotNullParameter(r61, "itemId");
        Intrinsics.checkNotNullParameter(r64, "traceInfo");
        Intrinsics.checkNotNullParameter(r69, "durationConfig");
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
        String r13 = "";
    L18:
        if (this.a.xa() == false) goto L20;
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r11, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
    L20:
        f2a.c r4 = this.f.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put(new f2a.f("from_text_area"), String.valueOf(r62));
        r5.put(new f2a.f("asr_only"), "true");
        r5.put(f2a.f.h, r11);
        r5.put(f2a.f.e, r13);
        r4.d(r5);
        r4.c.d = "invokeOnSpeak";
        List r6 = CollectionsKt.listOf(r64.a);
        f2a.g r7 = r4.c;
        r7.b = r6;
        r7.e = r64.b;
        f2a.c.c(r4, null, 15);
        final String r10 = r11;
        final String r12 = r13;
        ?? r14 = new v(this, r64, r61, r65, r67, r63, r68, r62, r10, r12);
        String r31 = UUID.randomUUID().toString();
        r14.invoke(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r31, r31, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -49153, 31, null));
        return;
    L16:
        r13 = r3;
        goto L18
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
