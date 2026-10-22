package com.larus.asr.session;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
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
public class LiveTutorAsrOnlySession implements o {
    public final p a;
    public final String b;
    public final VoiceInputType c;
    public boolean d;
    public final f2a.d e;
    public Function0<Unit> f;
    public final Lazy g;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> h;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> i;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "withExtHandle");
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.j.get();
    }

    public void a() {
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a);
        VoiceInputType.a r0 = VoiceInputType.Companion;
        VoiceInputType r1 = this.c;
        r0.getClass();
        if (VoiceInputType.a.a(r1) == true) goto L5;
        this.f.invoke();
    L5:
        this.a.onAsrStart(this.b);
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return this.d;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.i.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.i.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("LiveTutorAsrOnlySession", "notifyStateChanged state: " + r4.getClass());
        this.j.set(r4);
        Iterator<T> r0 = this.h.iterator();
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
        this.f = r2;
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r14, Message r15) {
        Intrinsics.checkNotNullParameter(r14, "taskId");
        if (this.a.Sa() == false) goto L6;
        if (r15 == null) goto L6;
        ((n) this.g.getValue()).cancelAudioText(r15);
    L6:
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        x5.a().d(r14);
        if (x5.c().a() == false) goto L9;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LiveTutorAsrOnlySession$cancel$2(null), 3, null);
    L9:
        this.d = false;
        this.a.L8(false, false, "onCancel:" + r14, VoiceInputType.TouchSpeaker, r14);
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
    }

    public LiveTutorAsrOnlySession(p r2, String r3, VoiceInputType r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new f2a.d("VoiceInput", "LiveTutorAsrOnlySession");
        this.f = new r0();
        this.g = LazyKt.lazy(new s0(this));
        this.h = new CopyOnWriteArraySet();
        this.i = new CopyOnWriteArraySet();
        this.j = new AtomicReference();
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r11, final Message r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        FLogger r0 = FLogger.a;
        r0.i("LiveTutorAsrOnlySession", "setSpeakerVisible: onSubmit called");
        this.a.setKeepScreenOn(false);
        e2a.e.c();
        this.d = false;
        this.a.L8(false, false, "onSubmit2:" + r11, VoiceInputType.TouchSpeaker, r11);
        r0.i("LiveTutorAsrOnlySession", "ChatBottomComponentWrapper AsrClientManager.stopAsrStream 02");
        com.larus.audio.k0 r1 = x5.a();
        if (r12 == null) goto L5;
        String r3 = r12.getLocalMessageId();
    L6:
        boolean r14 = r1.g(r11, r3, this.a.I9());
        if (r12 == null) goto L26;
        Map r2 = r12.getBusinessExt();
        if (r2 == null) goto L11;
        String r4 = (String) r2.get("tag_audio_text_info");
    L12:
        if (r4 == null) goto L20;
        int r5 = ve8.e.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl(new Gson().fromJson(r4, AudioTextExtra.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == true) goto L20;
    L21:
        AudioTextExtra r8 = (AudioTextExtra) r7;
        if (r8 == null) goto L26;
        Long r9 = r8.getRecordTime();
        if (r9 == null) goto L26;
        long r10 = r9.longValue();
    L27:
        long r15 = SystemClock.elapsedRealtime() - r10;
        if (r14 == false) goto L30;
    L57:
        FLogger.a.w("LiveTutorAsrOnlySession", "setSpeakerVisible: onSubmit skip, duration=" + r15);
        if (r12 == null) goto L60;
        ((n) this.g.getValue()).deleteOnNoAudioContent(r12);
    L60:
        if (r12 == null) goto L62;
        String r16 = r12.getLocalMessageId();
    L64:
        if (com.larus.media.o.a() == false) goto L66;
        MediaResourceManager.a r17 = new MediaResourceManager.a();
        r17.a = 3;
        r17.b = r16;
        r17.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r19 = MediaResourceManager.a;
        MediaResourceManager.d(r17);
    L66:
        this.a.m8();
        if (x5.c().a() == false) goto L72;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LiveTutorAsrOnlySession$submit$2(null), 3, null);
        return;
    L72:
        return;
    L62:
        r16 = null;
        goto L64
    L30:
        if (r15 <= 500) goto L57;
        IAIChatControlTraceService.Companion r110 = IAIChatControlTraceService.a;
        if (r12 == null) goto L34;
        String r20 = r12.getLocalMessageId();
    L35:
        if (r20 != null) goto L37;
        r20 = "";
    L37:
        IAIChatControlTraceService.a.f(r110, r20, r13, r15);
        FLogger r111 = FLogger.a;
        StringBuilder r112 = new StringBuilder("setSpeakerVisible: onSubmit called, duration=");
        r112.append(r15);
        r112.append("  ");
        if (r12 == null) goto L40;
        String r21 = r12.getLocalMessageId();
    L41:
        r112.append(r21);
        r111.i("LiveTutorAsrOnlySession", r112.toString());
        if (r12 == null) goto L66;
        if ((!this.a.ya()) == false) goto L46;
        Message r113 = r12;
    L47:
        if (r113 == null) goto L66;
        if (this.a.Ra() == false) goto L51;
        HashMap<String, Function0<Unit>> r22 = a5.a;
        a5.a(r113.getLocalMessageId(), new v0(this, r12));
    L53:
        if (com.larus.platform.service.z2.a.getSendMessageNetworkToastConfig().a() != 1) goto L66;
        AppHost.Companion r114 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r114.getApplication()) == true) goto L66;
        t19.s r115 = t19.s.a;
        Application r116 = r114.getApplication();
        r115.getClass();
        t19.s.s(r116, 2131908080);
        goto L66
    L51:
        ((n) this.g.getValue()).submitAudioText(r12);
        goto L53
    L46:
        r113 = null;
        goto L47
    L40:
        r21 = null;
        goto L41
    L34:
        r20 = null;
    L16:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        r7 = null;
        goto L21
    L11:
        r4 = null;
    L26:
        r10 = 0;
        goto L27
    L5:
        r3 = null;
        goto L6
    }

    public void b(Message r8, String r9, boolean r10, com.larus.audio.asr.c0 r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r9, "itemId");
        Intrinsics.checkNotNullParameter(r11, "traceInfo");
        String r13 = r8.getLocalMessageId();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        d(this, r13, true, r8, "perm_pass2", null, 48);
        a();
    }

    public final Unit c(String r8, boolean r9, Message r10, String r11, boolean r12, VoiceInputType r13) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Intrinsics.checkNotNullParameter(r11, "reason");
        Intrinsics.checkNotNullParameter(r13, "voiceInputType");
        if (r9 == false) goto L5;
        FLogger.a.i("LiveTutorAsrOnlySession", "setSpeakerVisible visible ");
        this.a.sb("ban_speaker_visible_" + r11);
        e2a.e.b();
        this.a.L8(true, r12, r11, r13, r8);
        this.a.Ja(r8, r10);
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("LiveTutorAsrOnlySession", "setSpeakerVisible invisible");
        this.d = false;
        this.a.L8(false, false, r11, r13, r8);
        goto L7
    }

    public static /* synthetic */ void d(LiveTutorAsrOnlySession r7, String r8, boolean r9, Message r10, String r11, VoiceInputType r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r10 = null;
    L5:
        Message r3 = r10;
        if ((r13 & 16) == 0) goto L8;
        boolean r5 = true;
    L10:
        if ((r13 & 32) == 0) goto L12;
        r12 = r7.c;
    L12:
        r7.c(r8, r9, r3, r11, r5, r12);
        return;
    L8:
        r5 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.larus.asr.session.t0] */
    @Override // com.larus.asr.session.o
    public final void pa(final String r59, final boolean r510, final boolean r60, final com.larus.audio.asr.c0 r61, final long r62, Long r64, Integer r65, d58.a r66) {
        Intrinsics.checkNotNullParameter(r59, "itemId");
        Intrinsics.checkNotNullParameter(r61, "traceInfo");
        Intrinsics.checkNotNullParameter(r66, "durationConfig");
        wc9.e r0 = this.a.h();
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (r1 != null) goto L9;
        final String r8 = "";
    L10:
        BotModel r2 = this.a.i();
        if (r2 == null) goto L13;
        String r3 = r2.getBotId();
    L14:
        if (r3 != null) goto L16;
        final String r9 = "";
    L17:
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r8, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        f2a.c r4 = this.e.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put(new f2a.f("from_text_area"), String.valueOf(r510));
        r5.put(new f2a.f("asr_only"), "true");
        r5.put(f2a.f.h, r8);
        r5.put(f2a.f.e, r9);
        r4.d(r5);
        r4.c.d = "invokeOnSpeak";
        List r6 = CollectionsKt.listOf(r61.a);
        f2a.g r7 = r4.c;
        r7.b = r6;
        r7.e = r61.b;
        f2a.c.c(r4, null, 15);
        ?? r11 = new t0(this, r61, r59, r62, r60, r510, r8, r9);
        String r29 = UUID.randomUUID().toString();
        r11.invoke(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r29, r29, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -49153, 31, null));
        return;
    L16:
        r9 = r3;
        goto L17
    L13:
        r3 = null;
        goto L14
    L9:
        r8 = r1;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
