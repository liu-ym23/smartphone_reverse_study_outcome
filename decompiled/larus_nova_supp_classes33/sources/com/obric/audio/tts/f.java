package com.obric.audio.tts;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory;
import com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory;
import com.larus.audio.audiov3.task.TtsManager;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.home.impl.sdk.s;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import ic8.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final f a = null;
    public static final CoroutineScope b = null;
    public static final AtomicLong c = null;
    public static volatile String d;
    public static volatile q58.a e;
    public static final g68.e f = null;
    public static final LinkedBlockingQueue<byte[]> g = null;
    public static final PThreadPoolExecutor h = null;
    public static volatile boolean i;
    public static volatile boolean j;
    public static final AtomicBoolean k = null;
    public static volatile AudioPlayerState l;
    public static u58.a m;
    public static final com.larus.media.model.a n = null;
    public static final com.larus.media.model.a o = null;
    public static com.larus.media.model.a p;
    public static final b q = null;

    public static final class a {
        public final String a;
        public final SpeakerVoice b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MainBotVoice(botId=" + this.a + ", voice=" + this.b + ')';
        }

        public a(String r2, SpeakerVoice r3) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r3, "voice");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements q58.b {
        public b() {
        }

        public final void a(AudioPlayerErrorEnum r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            int r0 = c68.b.a;
            c68.b.b("ObricTtsClient", "audioPlayer onFailed code=" + r3.getCode() + " msg=" + r3.getMassage());
        }

        public final void b(AudioPlayerState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            int r0 = c68.b.a;
            c68.b.a("ObricTtsClient", "audioPlayer onStateChange state=" + r3);
            f r1 = f.a;
            f.l = r3;
        }
    }

    public static final class c implements v {
        public c() {
        }

        public final boolean b(lk9.g r7) {
            Intrinsics.checkNotNullParameter(r7, "applicant");
            String r0 = f.p.b;
            if (Intrinsics.areEqual(r7.getScene(), "dora") == true) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r1 == false) goto L12;
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] canMixWith=false (DORA)");
            return false;
        L12:
            Map r2 = o0.a;
            boolean r3 = o0.a(r0, r7.getScene());
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] canMixWith current=" + r0 + ", applicant=" + r7.getScene() + " canMix=" + r3);
            return r3;
        L5:
            if (Intrinsics.areEqual(r0, "OBRIC_DORA") == true) goto L7;
            r1 = true;
            goto L9
        }

        public final void e(final lk9.g r4) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            v.a.d(r4);
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] onMediaInterrupted applicant=" + r4.getScene());
            t0.e(new h(r4));
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] onMediaResume applicant=" + r4.getScene() + " volumeFactor=" + r5);
            t0.e(new j());
            v.a.f(r4, r5);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            v.a.c(r1, r2);
        }

        public final void g(lk9.g r4, final float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] onMediaVolumeChange applicant=" + r4.getScene() + " volumeFactor=" + r5);
            t0.e(new i(this, r5));
            v.a.g(r4, r5);
        }

        public final void i(lk9.g r3, lk9.g r4) {
            Intrinsics.checkNotNullParameter(r3, "current");
            Intrinsics.checkNotNullParameter(r4, "applicant");
            v.a.e(r3, r4);
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] onMediaPaused applicant=" + r4.getScene());
            t0.e(new k());
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r7, lk9.g r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "current");
            Intrinsics.checkNotNullParameter(r8, "applicant");
            Map r0 = o0.a;
            if (o0.c(r7.getScene(), r8.getScene()) == false) goto L20;
            f.a.getClass();
            boolean r3 = false;
            if (Intrinsics.areEqual(r8.getScene(), "dora") == false) goto L16;
            IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r1 == null) goto L13;
            s r2 = r1.s0();
            if (r2 == null) goto L13;
            if (r2.L() != true) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L16;
            r3 = true;
        L13:
            r4 = false;
        L16:
            if (r3 == false) goto L20;
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy DORA pause, current=" + r7.getScene() + ", applicant=" + r8.getScene());
            return MediaOccupyStrategy.PAUSE;
        L20:
            if (Intrinsics.areEqual(r8.getScene(), "SYSTEM") == true) goto L22;
            MediaOccupyStrategy r10 = o0.b(r7.getScene(), r8.getScene());
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy current=" + r7.getScene() + ", applicant=" + r8.getScene() + " strategy=" + r10);
            return r10;
        L22:
            if (r9 != (-3)) goto L24;
        L26:
            MediaOccupyStrategy r11 = MediaOccupyStrategy.PAUSE;
        L27:
            FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy SYSTEM focusChange=" + r9 + " strategy=" + r11);
            return r11;
        L24:
            if (r9 == (-2)) goto L26;
            r11 = MediaOccupyStrategy.INTERRUPT;
            goto L27
        }
    }

    public f() {
    }

    static {
        a = new f();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new AtomicLong(0);
        d = "";
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().r();
        f = TtsManager.a;
        g = new LinkedBlockingQueue();
        h = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("bricTtsClient"));
        k = new AtomicBoolean(false);
        l = AudioPlayerState.STOPPED;
        c r0 = new c();
        com.larus.media.model.a r15 = new com.larus.media.model.a(null, "OBRIC_TTS", false, 1, 2, false, 0, false, false, 0, false, r0, 2021);
        n = r15;
        o = new com.larus.media.model.a(null, "OBRIC_DORA", false, 1, 2, false, 0, false, false, 0, false, r0, 2021);
        p = r15;
        q = new b();
    }

    public static void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Lazy r1 = MediaResourceManager.a;     // Catch: Throwable -> L4
        MediaResourceManager.a(p);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L12;
        FLogger.a.e("ObricTtsClient", "abandonMedia error: " + r3.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static q58.a d() {
        q58.a r0 = e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        IAudioPlayerFactory r1 = (IAudioPlayerFactory) ServiceManager.get().getService(IAudioPlayerFactory.class);
        if (r1 != null) goto L23;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] startByText skip, IAudioPlayerFactory not found");
        return null;
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = Result.constructor-impl(r1.create());     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L17;
        int r5 = c68.b.a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] create AudioPlayer failed: " + r4.getMessage());
    L17:
        if (Result.isFailure-impl(r2) == false) goto L19;
        r2 = null;
    L19:
        q58.a r6 = (q58.a) r2;
        if (r6 == null) goto L25;
        e = r6;
        return r6;
    L25:
        return null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static u58.a e() {
        u58.a r0 = m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        IAudioPlayerConfigFactory r1 = (IAudioPlayerConfigFactory) ServiceManager.get().getService(IAudioPlayerConfigFactory.class);
        if (r1 != null) goto L23;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] startByText skip, IAudioPlayerConfigFactory not found");
        return null;
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = Result.constructor-impl(r1.a(24000, 4, 2));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L17;
        int r5 = c68.b.a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] create AudioPlayerConfig failed: " + r4.getMessage());
    L17:
        if (Result.isFailure-impl(r2) == false) goto L19;
        r2 = null;
    L19:
        u58.a r6 = (u58.a) r2;
        if (r6 == null) goto L25;
        m = r6;
        return r6;
    L25:
        return null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static void f(final String r2, final q58.a r3) {
        int r0 = c68.b.a;
        c68.b.a("ObricTtsClient", "[OBRIC_TTS] tryPlay taskId=" + r2);
        h.submit(new com.obric.audio.tts.c(r2, r3));
    }

    public final synchronized void c(String r6, boolean r7) {
        monitor-enter(this);
        String r1 = d;     // Catch: Throwable -> L20
        int r2 = c68.b.a;     // Catch: Throwable -> L20
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] cancelTtsAndStopPlay taskId=" + r1 + " reason=" + r6);     // Catch: Throwable -> L20
        boolean r8 = true;
        i = true;     // Catch: Throwable -> L20
        j = false;     // Catch: Throwable -> L20
        LinkedBlockingQueue<byte[]> r3 = g;     // Catch: Throwable -> L20
        r3.clear();     // Catch: Throwable -> L20
        r3.offer(new byte[0]);     // Catch: Throwable -> L20
        q58.a r4 = e;     // Catch: Throwable -> L20
        if (r4 != null) goto L8;
    L11:
        if (r1.length() > 0) goto L14;
        r8 = false;
    L14:
        if (r8 == false) goto L16;
        g68.e r9 = f;     // Catch: Throwable -> L20
        r9.cancel(r1);     // Catch: Throwable -> L20
        r9.stop(r1);     // Catch: Throwable -> L20
        r9.c(r1);     // Catch: Throwable -> L20
    L16:
        if (r7 == false) goto L18;
        a();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L8:
        if (r4.getPlayState() == AudioPlayerState.STOPPED) goto L11;
        r4.stop();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static final Object b(f r19, long r20, Continuation r22) {
        r19.getClass();
        if ((r22 instanceof ObricTtsClient$resolveMainBotVoice$1) == false) goto L7;
        ObricTtsClient$resolveMainBotVoice$1 r1 = (ObricTtsClient$resolveMainBotVoice$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ObricTtsClient$resolveMainBotVoice$1 r7 = r1;
        Object r0 = r7.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        boolean r12 = true;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        long r5 = r7.J$0;
        String r6 = (String) r7.L$1;
        String r8 = (String) r7.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L15
    L71:
        Object r9 = Result.constructor-impl((BotModel) r0);     // Catch: Throwable -> L15
    L80:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L84;
        int r11 = c68.b.a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice query failed requestId=" + r5 + " mainBotId=" + r8 + " error=" + r10.getMessage());
    L84:
        if (Result.isFailure-impl(r9) == false) goto L86;
        r9 = null;
    L86:
        BotModel r13 = (BotModel) r9;
        if (r13 != null) goto L89;
        int r14 = c68.b.a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice failed, botRepo returned null requestId=" + r5 + " mainBotId=" + r8);
    L110:
        return null;
    L89:
        SpeakerVoice r15 = r13.getVoiceType();
        if (r15 == null) goto L100;
        String r16 = r15.getStyleId();
        if (r16 != null) goto L94;
    L97:
        if (r12 == true) goto L100;
        int r17 = c68.b.a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice success requestId=" + r5 + " mainBotId=" + r8 + " idSource=" + r6 + " voiceSource=main_bot_repo voiceId=" + r15.getId() + " styleId=" + r15.getStyleId());
        return new a(r8, r15);
    L94:
        if (StringsKt.isBlank(r16) == true) goto L97;
        r12 = false;
    L100:
        int r18 = c68.b.a;
        StringBuilder r21 = new StringBuilder("[OBRIC_TTS] resolveMainBotVoice failed, voice is invalid requestId=");
        r21.append(r5);
        r21.append(" mainBotId=");
        r21.append(r8);
        r21.append(" voiceId=");
        if (r15 == null) goto L103;
        String r23 = r15.getId();
    L104:
        r21.append(r23);
        r21.append(" styleId=");
        if (r15 == null) goto L107;
        String r24 = r15.getStyleId();
    L108:
        r21.append(r24);
        c68.b.b("ObricTtsClient", r21.toString());
        goto L110
    L107:
        r24 = null;
        goto L108
    L103:
        r23 = null;
    L15:
        th = th;
        long r110 = r5;
        String r25 = r6;
        String r26 = r8;
    L79:
        Result.Companion r27 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        r6 = r25;
        r8 = r26;
        r5 = r110;
        goto L80
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r28 = r7.J$0;
        ResultKt.throwOnFailure(r0);
    L25:
        List r29 = (List) r0;
        if (r29 == null) goto L32;
        String r30 = (String) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L32;
        if ((!StringsKt.isBlank(r30)) == false) goto L32;
        r110 = r28;
    L33:
        c1 r31 = (c1) AuthModelDelegate.b.a().getValue();
        if (r31 == null) goto L42;
        h0 r32 = (h0) r31.d;
        if (r32 == null) goto L42;
        String r33 = r32.b();
        if (r33 == null) goto L42;
        if ((!StringsKt.isBlank(r33)) == false) goto L42;
    L43:
        LaunchInfo r34 = LaunchCacheDelegate.b.c();
        if (r34 == null) goto L50;
        String r35 = r34.W();
        if (r35 == null) goto L50;
        if ((!StringsKt.isBlank(r35)) == false) goto L50;
    L51:
        if (r30 != null) goto L55;
        if (r33 != null) goto L54;
        String r36 = r35;
    L56:
        if (r30 == null) goto L59;
        String r37 = "main_conversation";
    L58:
        String r38 = r37;
        if (r36 != null) goto L64;
        int r39 = c68.b.a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice failed, mainBotId is empty requestId=" + r110);
        goto L110
    L64:
        int r40 = c68.b.a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice begin requestId=" + r110 + " mainBotId=" + r36 + " idSource=" + r38 + " forceNew=false");
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L76
        IBotRepoService r42 = zh8.a.e;     // Catch: Throwable -> L76
        r7.L$0 = r36;     // Catch: Throwable -> L76
        r7.L$1 = r38;     // Catch: Throwable -> L76
        r7.J$0 = r110;     // Catch: Throwable -> L76
        r7.label = 2;     // Catch: Throwable -> L76
        String r111 = r38;
        String r112 = r36;
        r0 = IBotRepoService.b.a(r42, r36, false, null, false, r7, 28);     // Catch: Throwable -> L74
        if (r0 == r3) goto L119;
        r5 = r110;
        r6 = r111;
        r8 = r112;
        goto L71
    L119:
        return r3;
    L74:
        th = th;
    L78:
        r25 = r111;
        r26 = r112;
    L76:
        th = th;
        r111 = r38;
        r112 = r36;
        goto L78
    L59:
        if (r33 == null) goto L61;
        r37 = "runtime_launch";
        goto L58
    L61:
        r37 = "persisted_launch";
        goto L58
    L54:
        r36 = r33;
        goto L56
    L55:
        r36 = r30;
    L50:
        r35 = null;
    L42:
        r33 = null;
    L32:
        r110 = r28;
        r30 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r0);
        wc9.e r43 = (wc9.e) AuthModelDelegate.b.y().getValue();
        r28 = r20;
        if (r43 == null) goto L32;
        r7.J$0 = r28;
        r7.label = 1;
        r0 = n.c(r43, r7);
        if (r0 != r3) goto L25;
        return r3;
    L7:
        r1 = new ObricTtsClient$resolveMainBotVoice$1(r19, r22);
        goto L8
    }
}
