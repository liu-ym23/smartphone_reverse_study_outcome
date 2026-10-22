package com.larus.asr.session;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i1 implements o {
    public static final /* synthetic */ int k = 0;
    public final p a;
    public final String b;
    public final Function0<xa8.d> c;
    public final f2a.d d;
    public final Lazy e;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> f;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> g;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> h;
    public boolean i;
    public final j1 j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "withExtHandle");
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return false;
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
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
        return this.h.get();
    }

    public final int b() {
        return Intrinsics.areEqual(((Keva) this.e.getValue()).getString(AccountService.a.getUserId().concat("-selected_translator_mode"), "1"), "1") ? 1 : 0;
    }

    public final xa8.d c() {
        return (xa8.d) this.c.invoke();
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
        if (this.i == false) goto L6;
        String r0 = this.b;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().j(r0);
        this.i = false;
        return;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("QuicInterpretAsrSession", "notifyStateChanged state: " + r4.getClass());
        this.h.set(r4);
        Iterator<com.larus.bmhome.chat.component.bottom.core.speaker.h> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r4);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r9, Message r10) {
        Intrinsics.checkNotNullParameter(r9, "taskId");
        if (this.i == false) goto L5;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r11 = IFlowAsrClientService.a.a();
        r11.f(r9);
        r11.j(r9);
        this.i = false;
    L22:
        this.a.L8(false, false, "onCancel:" + r9, VoiceInputType.TouchSpeaker, r9);
        FLogger.a.i("QuicInterpretAsrSession", "onCancel setSpeakerViewVisible : false");
        return;
    L5:
        xa8.d r12 = c();
        boolean r2 = true;
        if (r12 != null) goto L8;
    L10:
        boolean r13 = false;
    L11:
        if (r13 == false) goto L22;
        xa8.d r14 = c();
        if (r14 != null) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L22;
        FLogger.a.i("QuicInterpretAsrSession", "speaker cancel");
        xa8.d r15 = c();
        if (r15 == null) goto L22;
        r15.gq(0);
        goto L22
    L15:
        if (r14.Ig() == true) goto L17;
    L8:
        if (r12.K70() != true) goto L10;
        r13 = true;
        goto L11
    }

    public i1(p r2, String r3, com.larus.asr.x0 r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "abilityGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new f2a.d("VoiceInput", "QuicInterpretAsrSession");
        this.e = LazyKt.lazy(new e1());
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
        this.h = new AtomicReference();
        this.j = new j1(this);
    }

    public static final void a(i1 r4, byte[] r5, JSONObject r6) {
        r4.getClass();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("enableSimultaneousInterpretationForcePlay = ");
        com.larus.platform.service.z2 r2 = com.larus.platform.service.z2.a;
        r1.append(r2.A2().getForcePlay());
        r1.append(" , checkTtsStatus = ");
        r1.append(r4.a.I9());
        r0.i("QuicInterpretAsrSession", r1.toString());
        if (r2.A2().getForcePlay() == false) goto L5;
    L7:
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_PLAYING);
        r0.i("QuicInterpretAsrSession", "simultaneousTranslator onReceiveAudioData " + r5.length + " , extraJson : " + r6);
        if (r6 == null) goto L10;
        String r7 = r6.optString("status");
    L12:
        if (Intrinsics.areEqual(r7, "1") == false) goto L16;
        r0.i("QuicInterpretAsrSession", "simultaneousTranslator onReceiveAudioData end");
        return;
    L16:
        return;
    L10:
        r7 = null;
        goto L12
    L5:
        if (r4.a.I9() == true) goto L7;
        r0.i("QuicInterpretAsrSession", "tts switch off, stopPlayAudioData");
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r7, Message r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "taskId");
        if (this.i == false) goto L5;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().r(r7);
    L8:
        this.a.L8(false, false, "onCancel:" + r7, VoiceInputType.TouchSpeaker, r7);
        FLogger.a.i("QuicInterpretAsrSession", "onSubmit setSpeakerViewVisible : false");
        return;
    L5:
        xa8.d r10 = c();
        if (r10 == null) goto L8;
        r10.JX();
        goto L8
    }

    public static void d(i1 r8, String r9, boolean r10, String r11) {
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (r10 == false) goto L5;
        FLogger.a.i("QuicInterpretAsrSession", "setSpeakerVisible visible isSpeaking:false");
        r8.a.sb("ban_speaker_visible_".concat(r11));
        e2a.e.b();
        r8.a.L8(true, true, r11, VoiceInputType.TouchSpeaker, r9);
        r8.a.Ja(r9, null);
    L6:
        Unit r12 = Unit.INSTANCE;
        return;
    L5:
        FLogger.a.i("QuicInterpretAsrSession", "setSpeakerVisible invisible");
        r8.a.L8(false, false, r11, VoiceInputType.TouchSpeaker, r9);
        goto L6
    }

    @Override // com.larus.asr.session.o
    public final void pa(String r7, boolean r8, boolean r9, com.larus.audio.asr.c0 r10, long r11, Long r13, Integer r14, d58.a r15) {
        Intrinsics.checkNotNullParameter(r7, "itemId");
        Intrinsics.checkNotNullParameter(r10, "traceInfo");
        Intrinsics.checkNotNullParameter(r15, "durationConfig");
        wc9.e r12 = this.a.h();
        if (r12 == null) goto L5;
        String r16 = r12.a;
    L6:
        String r17 = "";
        if (r16 != null) goto L9;
        r16 = "";
    L9:
        BotModel r19 = this.a.i();
        if (r19 == null) goto L12;
        String r110 = r19.getBotId();
    L13:
        if (r110 == null) goto L16;
        r17 = r110;
    L16:
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r16, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        f2a.c r111 = this.d.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put(new f2a.f("from_text_area"), String.valueOf(r8));
        r112.put(new f2a.f("asr_only"), "false");
        r112.put(f2a.f.h, r16);
        r112.put(f2a.f.e, r17);
        r111.d(r112);
        r111.c.d = "invokeOnSpeak";
        List r20 = CollectionsKt.listOf(r10.a);
        f2a.g r21 = r111.c;
        r21.b = r20;
        r21.e = r10.b;
        f2a.c.c(r111, null, 15);
        final String r22 = this.b;
        this.a.Bb(new a1(this, r22));
        return;
    L12:
        r110 = null;
        goto L13
    L5:
        r16 = null;
        goto L6
    }
}
