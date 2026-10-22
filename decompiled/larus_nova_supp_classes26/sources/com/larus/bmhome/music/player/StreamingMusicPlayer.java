package com.larus.bmhome.music.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.bmhome.music.widget.MusicPlayerDetailFragment;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class StreamingMusicPlayer implements com.larus.bmhome.music.player.a, e, com.larus.bmhome.music.player.a.InterfaceC0021a {
    public static boolean n;
    public static final String o = null;
    public static k p;
    public static MediaPlayer q;
    public static final a1 r = null;
    public final com.larus.bmhome.music.player.a.InterfaceC0021a a;
    public final String b;
    public j c;
    public long d;
    public k e;
    public volatile boolean f;
    public boolean g;
    public final b h;
    public final VideoEngineMusicPlayerViewImpl i;
    public Job j;
    public boolean k;
    public final c l;
    public com.larus.media.model.a m;

    public static final class a {
    }

    public final class b implements e78.c {
        public boolean a;
        public GlobalAudioStateEnum b;
        public final /* synthetic */ StreamingMusicPlayer c;

        public final void a() {
        }

        public final boolean b() {
            return false;
        }

        public final void c() {
        }

        public final void d() {
        }

        public final boolean e() {
            return false;
        }

        public final String getBizScene() {
            return "music";
        }

        public final String getScene() {
            return "music";
        }

        public final GlobalAudioStateEnum getState() {
            if (this.a == true) goto L5;
            boolean r0 = StreamingMusicPlayer.n;
            MediaPlayer r1 = StreamingMusicPlayer.q;
            if (r1 != null) goto L11;
            return GlobalAudioStateEnum.STOPPED;
        L11:
            if (r1.isPlaying() == false) goto L14;
            return GlobalAudioStateEnum.PLAYING;
        L14:
            return GlobalAudioStateEnum.PAUSED;
        L5:
            return this.b;
        }

        public final boolean pause() {
            final StreamingMusicPlayer r0 = this.c;
            Runnable r1 = new t(r0);
            boolean r2 = StreamingMusicPlayer.n;
            r0.w(r1);
            return true;
        }

        public final boolean play() {
            final StreamingMusicPlayer r0 = this.c;
            Runnable r1 = new s(r0);
            boolean r2 = StreamingMusicPlayer.n;
            r0.w(r1);
            return true;
        }

        public final boolean stop() {
            final StreamingMusicPlayer r0 = this.c;
            Runnable r1 = new u(r0);
            boolean r2 = StreamingMusicPlayer.n;
            r0.w(r1);
            return true;
        }

        public b(StreamingMusicPlayer r1) {
            this.c = r1;
            this.b = GlobalAudioStateEnum.STOPPED;
        }
    }

    public static final class c implements com.larus.media.v {
        public boolean a;
        public final /* synthetic */ StreamingMusicPlayer b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MediaResourceManager.FlowAudioBroadcastEvent.values().length];
                r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public c(StreamingMusicPlayer r1) {
            this.b = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            String r3 = r2.getScene();
            switch(r3.hashCode()) {
                case -2131014600: goto L21;
                case -1947208172: goto L18;
                case -1943468978: goto L15;
                case -1353089642: goto L12;
                case 3089402: goto L9;
                case 602811105: goto L6;
                default: goto L32;
            };
        L32:
            return false;
        L6:
            if (r3.equals("CALL_TTS_PLAY") == true) goto L31;
            return false;
        L31:
            return true;
        L9:
            if (r3.equals("dora") == false) goto L33;
            return true;
        L33:
            return false;
        L12:
            if (r3.equals("TTS_SAMPLE") == false) goto L34;
            return true;
        L34:
            return false;
        L15:
            if (r3.equals("O_CALL") == false) goto L35;
            return true;
        L35:
            return false;
        L18:
            if (r3.equals("NAVIGATION") == false) goto L36;
            return true;
        L36:
            return false;
        L21:
            if (r3.equals("IM_TTS") == false) goto L37;
            return true;
        L37:
            return false;
        }

        public final void e(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.d(r2);
            final StreamingMusicPlayer r3 = this.b;
            r3.k = false;
            r3.w(new w(r3));
        }

        public final void f(MediaResourceManager.a r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            Intrinsics.checkNotNullParameter(r6, "event");
            if (com.larus.media.o.a() == false) goto L18;
            MediaResourceManager.FlowAudioBroadcastEvent r0 = r6.c;
            if (r0 != null) goto L7;
            int r1 = -1;
        L9:
            if (r1 != 1) goto L11;
            FLogger.a.i("StreamingMusicPlayer", "event asrWaitReplyBegin , msgId: " + r6.b);
            this.a = true;
            return;
        L11:
            if (r1 == 2) goto L13;
            FLogger.a.i("StreamingMusicPlayer", "else  msgId: " + r6.b);
            this.a = false;
            return;
        L13:
            FLogger.a.i("StreamingMusicPlayer", "event asrWaitReplyEnd , msgId: " + r6.b);
            if (this.a == false) goto L20;
            this.a = false;
            final StreamingMusicPlayer r7 = this.b;
            r7.w(new z(r7));
            return;
        L20:
            return;
        L7:
            r1 = a.a[r0.ordinal()];
            goto L9
        }

        public final void a(lk9.g r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.f(r2, r3);
            final StreamingMusicPlayer r4 = this.b;
            if (r4.k == false) goto L8;
            r4.k = false;
            if (this.a == true) goto L9;
            r4.w(new v(r4));
            return;
        L9:
            return;
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r2, final float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.g(r2, r3);
            this.b.w(new y(this, r3));
        }

        public final void i(lk9.g r3, lk9.g r4) {
            Intrinsics.checkNotNullParameter(r3, "current");
            Intrinsics.checkNotNullParameter(r4, "applicant");
            com.larus.media.v.a.e(r3, r4);
            MediaPlayer r5 = StreamingMusicPlayer.q;     // Catch: IllegalStateException -> L12
            if (r5 != null) goto L6;
        L8:
            boolean r6 = false;
        L9:
            if (r6 == false) goto L17;
            final StreamingMusicPlayer r7 = this.b;     // Catch: IllegalStateException -> L12
            r7.k = true;     // Catch: IllegalStateException -> L12
            r7.w(new x(r7));     // Catch: IllegalStateException -> L12
            return;
        L17:
            return;
        L6:
            if (r5.isPlaying() != true) goto L8;
            r6 = true;
        L12:
            e = move-exception;
            FLogger.a.e("StreamingMusicPlayer", "illegal is playing check media player", e);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            this.b.getClass();
            String r4 = r2.getScene();
            boolean r5 = true;
            switch(r4.hashCode()) {
                case -1989469372: goto L25;
                case -1833998801: goto L22;
                case 96896: goto L19;
                case 3089402: goto L9;
                case 93217264: goto L6;
                default: goto L27;
            };
        L27:
            r5 = false;
        L28:
            if (r5 == false) goto L35;
            if (com.larus.media.o.a() == false) goto L35;
            return MediaOccupyStrategy.PAUSE;
        L35:
            return MediaOccupyStrategy.INTERRUPT;
        L6:
            if (r4.equals("VOICE_COMPONENT") == true) goto L28;
        L9:
            if (r4.equals("dora") == false) goto L27;
            IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r6 == null) goto L27;
            com.larus.home.impl.sdk.s r7 = r6.s0();
            if (r7 == null) goto L27;
            if (r7.c() != true) goto L27;
        L19:
            if (r4.equals("asr") == true) goto L28;
        L22:
            if (r4.equals("SYSTEM") == true) goto L28;
        L25:
            if (r4.equals("UGC_VOICE") == false) goto L27;
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.music.player.StreamingMusicPlayer$onError$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.player.StreamingMusicPlayer$onError$1", f = "StreamingMusicPlayerBuilder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ StreamingMusicPlayer this$0;

        public AnonymousClass1(StreamingMusicPlayer r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            StreamingMusicPlayer r3 = this.this$0;
            boolean r0 = StreamingMusicPlayer.n;
            r3.t();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void F6() {
        this.a.F6();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void FK() {
        this.a.FK();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void GP(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "bizExtra");
        this.a.GP(r2);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Ij(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "bizExtra");
        this.a.Ij(r2);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lf() {
        this.a.Lf();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lr() {
        this.a.Lr();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void OK() {
        this.a.OK();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Pe(float r2, boolean r3) {
        this.a.Pe(r2, r3);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void UY() {
        this.a.UY();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void eb(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "bizExtra");
        this.a.eb(r2);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void f20() {
        this.a.f20();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final CoroutineScope getScope() {
        return this.a.getScope();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final Context getViewContext() {
        return this.a.getViewContext();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void hideLoadingView() {
        this.a.hideLoadingView();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void mP(int r2, boolean r3) {
        this.a.mP(r2, r3);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void r30(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "uniId");
        Intrinsics.checkNotNullParameter(r3, "bizExtra");
        this.a.r30(r2, r3);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void showLoadingView() {
        this.a.showLoadingView();
    }

    static {
        o = z2.a.musicCreateStreamingHost();
        r = new a1();
    }

    @Override // com.larus.bmhome.music.player.a
    public final boolean a() {
        if (this.e.e == false) goto L5;
    L8:
        return true;
    L5:
        if (this.i.D() == true) goto L8;
        return false;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void c() {
        GlobalAudioController.a.d(this.h);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.m);
        this.g = false;
        this.i.c();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void g() {
        if (a() == true) goto L6;
        return;
    L6:
        if (this.e.e == true) goto L10;
        this.i.g();
        return;
    L10:
        if (this.g == false) goto L12;
        return;
    L12:
        j r1 = this.c;
        if (r1 == null) goto L15;
        String r2 = r1.f();
    L16:
        String r3 = r2;
        String r4 = r();
        j r5 = this.c;
        if (r5 == null) goto L23;
        Message r6 = r5.j;
        if (r6 == null) goto L23;
        boolean r7 = true;
        if (com.larus.im.bean.message.a.V(r6) != true) goto L23;
    L24:
        if (r7 == false) goto L26;
        int r8 = MediaLevel.PLAY_HIGH.getValue();
    L27:
        int r12 = r8;
        com.larus.media.model.a r9 = new com.larus.media.model.a(r3, r4, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), r12, false, this.l, 1196);
        this.m = r9;
        MediaResourceManager.m(r9, new q(this), new r(this), 0, 8);
        return;
    L26:
        r8 = MediaLevel.PLAY_DEFAULT.getValue();
    L23:
        r7 = false;
        goto L24
    L15:
        r2 = null;
        goto L16
    }

    @Override // com.larus.bmhome.music.player.a
    public final void i() {
        if (this.e.e == false) goto L5;
        k(false);
        return;
    L5:
        this.i.i();
    }

    @Override // com.larus.bmhome.music.player.a
    public final boolean isStreaming() {
        return this.e.e;
    }

    public final void n() {
        FLogger.a.i("StreamingMusicPlayer", "[bindListenerToMediaPlayer] " + Reflection.getOrCreateKotlinClass(this.a.getClass()).getSimpleName());
        a1 r0 = r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        List<WeakReference<e>> r1 = CollectionsKt.toMutableList(r0.a);
        r1.add(new WeakReference(this));
        r0.a = r1;
    }

    public final String o() {
        j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onAttachedToWindow() {
        this.i.onAttachedToWindow();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onDestroyed() {
        GlobalAudioController.a.d(this.h);
        if (this.e.e == false) goto L5;
        y(true);
    L5:
        this.i.onDestroyed();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onDetachedFromWindow() {
        this.i.onDetachedFromWindow();
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.j = null;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onPaused() {
        this.a.Ij(q());
        this.i.onPaused();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onResumed() {
        this.a.GP(q());
        this.i.onResumed();
    }

    public final String p() {
        return "https://" + o + '/' + StringsKt.removeSuffix(StringsKt.removePrefix(this.e.b, "\""), "\"");
    }

    public final Map<String, String> q() {
        LinkedHashMap r0 = new LinkedHashMap();
        j r1 = this.c;
        if (r1 == null) goto L15;
        String r2 = r1.g();
        String r3 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r0.put(MusicAppletPage.KEY_CONVERSATION_ID, r2);
        String r4 = r1.d();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r0.put("bot_id", r4);
        String r5 = r1.j();
        if (r5 == null) goto L14;
        r3 = r5;
    L14:
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
    L15:
        return r0;
    }

    public final String r() {
        j r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.k;
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = this.b;
        if (r2 != null) goto L11;
        return "music";
    L11:
        return r2;
    }

    public final void s() {
        f r0 = f.a;
        f.a(this.c, this);
        this.e = k.a(this.e, null, null, 0.0f, 0.0f, true, false, 0, 239);
        t();
        k r1 = p;
        if (r1 == null) goto L5;
        String r2 = r1.b;
    L6:
        BuildersKt.launch$default(getScope(), Dispatchers.getIO(), null, new StreamingMusicPlayer$playAudio$1(this, r2, null), 2, null);
        p = this.e;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void t() {
        if (this.e.e == false) goto L5;
        w(new l(this));
        return;
    L5:
        w(new m(this));
    }

    public final void x() {
        this.j = BuildersKt.launch$default(getScope(), Dispatchers.getIO(), null, new StreamingMusicPlayer$startUpdateProgress$1(this, null), 2, null);
    }

    @Override // com.larus.bmhome.music.player.a
    public final j data() {
        return this.c;
    }

    public static final void m(StreamingMusicPlayer r15) {
        r15.getClass();
        FLogger r0 = FLogger.a;
        r0.i("StreamingMusicPlayer", "[resumePlayingStream]");
        GlobalAudioObserver r1 = GlobalAudioObserver.a;
        r1.e("music", r15.p(), null);
        r1.c("music", GlobalAudioStateEnum.PLAYING, r15.q());
        MediaPlayer r2 = q;
        if (r2 != null) goto L5;
    L8:
        r15.x();
        k r3 = k.a(r15.e, null, null, 0.0f, 0.0f, true, false, 0, 239);
        r15.e = r3;
        p = r3;
        StringBuilder r4 = new StringBuilder("[resumePlayingStream] update playing state cache ");
        k r5 = p;
        if (r5 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r5.e);
    L12:
        r4.append(r6);
        r4.append(' ');
        r4.append(p);
        r4.append(' ');
        r0.i("StreamingMusicPlayer", r4.toString());
        BuildersKt.launch$default(r15.getScope(), Dispatchers.getMain(), null, new StreamingMusicPlayer$resumePlayingStream$1(r15, null), 2, null);
        return;
    L11:
        r6 = null;
        goto L12
    L5:
        if (fna.g.d() == true) goto L7;
        r2.start();
        goto L8
    L7:
        r2.start();
        gna.a.c(r2.hashCode());
        goto L8
    }

    @Override // com.larus.bmhome.music.player.a
    public final void b(float r4) {
        FLogger.a.i("StreamingMusicPlayer", "update progress " + r4);
        if (this.e.e == true) goto L5;
        this.i.b(r4);
        return;
    L5:
        if (r4 > 2.0f) goto L7;
        return;
    L7:
        if (r4 >= 98.0f) goto L15;
        mP((int) r4, false);
        if (this.e.c <= 0.0f) goto L11;
        Pe(r4, true);
        return;
    L11:
        Pe(0.0f, false);
        return;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void d(j r22) {
        Intrinsics.checkNotNullParameter(r22, "musicPlayerData");
        this.c = r22;
        FLogger r2 = FLogger.a;
        r2.i("StreamingMusicPlayer", "[bindData] " + r22);
        StringBuilder r3 = new StringBuilder("[bindData] Debug Message Message id ");
        r3.append(o());
        r3.append(" bind data, ");
        k r5 = p;
        Boolean r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.b;
    L6:
        r3.append(r7);
        r3.append(' ');
        r2.i("StreamingMusicPlayer", r3.toString());
        String r4 = r22.f();
        if (TextUtils.isEmpty(r4) == true) goto L137;
        StringBuilder r8 = new StringBuilder("[bindData] Debug Message cached chunk ");
        k r9 = p;
        if (r9 == null) goto L11;
        String r10 = r9.b;
    L12:
        r8.append(r10);
        r8.append(' ');
        r2.i("StreamingMusicPlayer", r8.toString());
        StringBuilder r11 = new StringBuilder("[bindData] Debug Message current task ");
        ad9.b r12 = r22.g;
        if (r12 == null) goto L15;
        String r13 = r12.getItemId();
    L16:
        r11.append(r13);
        r11.append(" chunk ");
        r11.append(r4);
        r11.append(' ');
        r2.i("StreamingMusicPlayer", r11.toString());
        k r14 = p;
        boolean r15 = false;
        if (r14 == null) goto L55;
        String r16 = r14.b;
        j r17 = this.c;
        if (r17 == null) goto L23;
        Message r18 = r17.j;
        if (r18 == null) goto L23;
        Boolean r19 = Boolean.valueOf(r18.isNewBlockType());
    L25:
        if (c0.a(r4, r16, r19) == false) goto L55;
        StringBuilder r20 = new StringBuilder("[bindData] Debug Message playing state cache active music bind again resume progress ");
        k r110 = p;
        if (r110 == null) goto L29;
        Integer r111 = Integer.valueOf(r110.g);
    L30:
        r20.append(r111);
        r20.append(' ');
        r2.i("StreamingMusicPlayer", r20.toString());
        com.larus.bmhome.music.player.b.a.getClass();
        if (com.larus.bmhome.music.player.b.a.h == true) goto L33;
    L34:
        n();
    L36:
        if ((this.a instanceof LyricsToSongCardView) == false) goto L45;
        k r21 = p;
        if (r21 != null) goto L40;
    L42:
        boolean r23 = false;
    L43:
        if (r23 == false) goto L45;
        f r24 = f.a;
        f.d(this.c, this);
        goto L45
    L40:
        if (r21.e != true) goto L42;
        r23 = true;
    L45:
        k r25 = p;
        if (r25 == null) goto L48;
        float r26 = r25.d;
    L49:
        b(r26);
        k r27 = p;
        if (r27 != null) goto L62;
        ad9.b r112 = r22.g;
        if (r4 != null) goto L54;
        r4 = "";
    L54:
        r27 = new k(r112, r4, 252);
    L62:
        this.e = r27;
        IAIChatUgcAIGCService.Companion r28 = IAIChatUgcAIGCService.a;
        Message r29 = r28.b0().b();
        if (r29 == null) goto L65;
        String r30 = r29.getMessageId();
    L66:
        StringBuilder r31 = new StringBuilder("[judgeIsNeedAutoPlay] chatMessageId:");
        r31.append(o());
        r31.append(", autoPlay:");
        j r113 = this.c;
        if (r113 == null) goto L69;
        Boolean r114 = Boolean.valueOf(r113.b());
    L70:
        r31.append(r114);
        r31.append(", autoPlayMulti:");
        j r115 = this.c;
        if (r115 == null) goto L73;
        Boolean r116 = Boolean.valueOf(r115.c());
    L74:
        r31.append(r116);
        r31.append(", lastMediaId:");
        r31.append(r30);
        r31.append(", chunkUrl:");
        r31.append(this.e.b);
        r31.append(", allowAutoPlay");
        r2.i("StreamingMusicPlayer", r31.toString());
        StringBuilder r32 = new StringBuilder();
        j r33 = this.c;
        if (r33 == null) goto L77;
        String r34 = r33.o();
    L78:
        r32.append(r34);
        r32.append(o());
        String r35 = r32.toString();
        Lazy r36 = i.a;
        Context r37 = getViewContext();
        Intrinsics.checkNotNullParameter(r37, "context");
        IVideoController r38 = (IVideoController) i.c().get(r37.toString());
        if (r38 == null) goto L81;
        String r39 = r38.getMediaId();
    L83:
        if (Intrinsics.areEqual(r35, r39) == false) goto L85;
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] chatMessageId:" + o() + ", backEndVideoEnginePlayerHandling");
    L130:
        StringBuilder r40 = new StringBuilder("[bindData] binding again playing chunks ");
        r40.append(this.e.e);
        r40.append(" playing state ");
        k r41 = p;
        if (r41 == null) goto L133;
        r6 = Boolean.valueOf(r41.e);
    L133:
        r40.append(r6);
        r40.append(' ');
        r2.i("StreamingMusicPlayer", r40.toString());
        if (this.e.e == false) goto L136;
        r2.i("StreamingMusicPlayer", "[bindData]  again state playing chunk ");
        x();
        t();
        return;
    L136:
        r2.i("StreamingMusicPlayer", "[bindData] set auto play false, cause by state.playingChunk is false");
        this.i.d(j.a(r22, null, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108607));
        return;
    L85:
        f r42 = f.a;
        if (f.e == false) goto L88;
        r2.i("StreamingMusicPlayer", "MusicPlayerBuilder(" + r42 + ").pausing");
        goto L130
    L88:
        k r43 = this.e;
        if (r43.e == false) goto L91;
    L94:
        boolean r44 = true;
    L95:
        if (r44 == false) goto L103;
        String r45 = r43.b;
        j r46 = this.c;
        if (r46 == null) goto L99;
        String r47 = r46.f();
    L101:
        if (Intrinsics.areEqual(r45, r47) == false) goto L103;
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] chatMessageId:" + o() + ", onPlaying");
        goto L130
    L99:
        r47 = null;
    L103:
        String r48 = o();
        Message r49 = r28.b0().b();
        if (r49 == null) goto L106;
        String r50 = r49.getMessageId();
    L107:
        boolean r51 = TextUtils.equals(r48, r50);
        com.larus.bmhome.music.player.b.a.getClass();
        if (com.larus.bmhome.music.player.b.a.i == true) goto L111;
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] disallow auto play:" + o() + ", auto play");
        goto L130
    L111:
        if (ce8.c.a() == false) goto L113;
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] disallow auto play, isContinuousTalk mode");
        goto L130
    L113:
        j r52 = this.c;
        if (r52 == null) goto L116;
        Boolean r53 = Boolean.valueOf(r52.b());
    L118:
        if (Intrinsics.areEqual(r53, Boolean.TRUE) == false) goto L129;
        if (r51 == true) goto L128;
        j r54 = this.c;
        if (r54 == null) goto L127;
        Message r55 = r54.j;
        if (r55 == null) goto L127;
        if (com.larus.im.bean.message.a.V(r55) != true) goto L127;
        r15 = true;
    L127:
        if (r15 == false) goto L129;
    L128:
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] chatMessageId:" + o() + ", auto play");
        r28.b0().a();
        s();
    L129:
        r2.i("StreamingMusicPlayer", "[judgeIsNeedAutoPlay] chatMessageId:" + o() + ", no need to auto play");
        goto L130
    L116:
        r53 = null;
        goto L118
    L106:
        r50 = null;
        goto L107
    L91:
        if (r43.h == true) goto L94;
        r44 = false;
        goto L95
    L81:
        r39 = null;
        goto L83
    L77:
        r34 = null;
        goto L78
    L73:
        r116 = null;
        goto L74
    L69:
        r114 = null;
        goto L70
    L65:
        r30 = null;
        goto L66
    L48:
        r26 = 0.0f;
        goto L49
    L33:
        if ((this.a instanceof MusicPlayerDetailFragment) == false) goto L36;
    L29:
        r111 = null;
    L23:
        r19 = null;
    L55:
        r2.i("StreamingMusicPlayer", "[bindData] Debug Message playing state no cached music new state ");
        j r117 = this.c;
        if (r117 == null) goto L58;
        ad9.b r118 = r117.g;
    L59:
        if (r4 != null) goto L61;
        r4 = "";
    L61:
        r27 = new k(r118, r4, 252);
        goto L62
    L58:
        r118 = null;
        goto L59
    L15:
        r13 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L137:
        r2.i("StreamingMusicPlayer", "[bindData] set auto play false, cause by preloadUrl is false");
        this.e = k.a(this.e, null, null, 0.0f, 0.0f, false, false, 0, 239);
        this.i.d(j.a(r22, null, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108607));
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a
    public final void e(j r42) {
        Intrinsics.checkNotNullParameter(r42, "musicPlayerData");
        FLogger.a.d("SimpleMusicPlayerViewImpl", "Message id " + o() + "  Music by chunking => [appendData] " + r42.o());
        j r5 = this.c;
        if (r5 != null) goto L5;
        return;
    L5:
        j r1 = j.a(r5, r42.p(), r42.o(), false, false, null, 0, null, null, false, null, null, null, false, false, null, 67107903);
        this.c = r1;
        if (TextUtils.isEmpty(r42.p()) == true) goto L9;
        this.i.d(j.a(r1, null, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108607));
        return;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void h(boolean r4) {
        j r0 = this.c;
        if (r0 == null) goto L5;
        String r1 = r0.p();
    L6:
        boolean r2 = false;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L17;
        if (this.e.e == true) goto L17;
        r2 = true;
    L17:
        if (r2 == false) goto L20;
        FLogger.a.i("StreamingMusicPlayer", "[parentClick] dispatchToBackEndVideoEnginePlayer");
        this.i.h(r4);
        return;
    L20:
        if (this.e.e == true) goto L22;
        FLogger.a.i("StreamingMusicPlayer", "[parentClick] consumed, playAudio");
        s();
        return;
    L22:
        if (this.f == false) goto L25;
        FLogger.a.i("StreamingMusicPlayer", "[parentClick] disallowedByMediaPlayer");
        return;
    L25:
        FLogger.a.i("StreamingMusicPlayer", "[parentClick] consumed, pause");
        k(true);
        return;
    L9:
        if (this.i.c == null) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a
    public final void k(boolean r2) {
        if (this.e.e == false) goto L5;
        y(r2);
        return;
    L5:
        this.i.k(r2);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r5) {
        j r6 = this.c;
        if (r6 == null) goto L5;
        String r7 = r6.f();
    L6:
        k r1 = p;
        if (r1 == null) goto L31;
        String r2 = r1.b;
        j r3 = this.c;
        if (r3 == null) goto L13;
        Message r4 = r3.j;
        if (r4 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r4.isNewBlockType());
    L15:
        if (c0.a(r7, r2, r8) == false) goto L33;
        GlobalAudioObserver.a.c("music", GlobalAudioStateEnum.PAUSED, q());
        u(true);
        FLogger.a.i("StreamingMusicPlayer", "[MediaPlayer] " + q + " onCompletion");
        j r9 = this.c;
        if (r9 == null) goto L20;
        ad9.b r10 = r9.g;
    L21:
        com.larus.bmhome.music.player.b.a.getClass();
        com.larus.bmhome.music.player.b.a.b(r10, r9);
        String r11 = o();
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        if (r10 == null) goto L26;
        String r12 = r10.getItemId();
    L27:
        com.larus.bmhome.music.player.b.a.d(r11, r12, 0);
        y(true);
        if (com.larus.bmhome.music.player.b.a.h == false) goto L32;
        q = null;
        s();
        return;
    L32:
        return;
    L26:
        r12 = null;
        goto L27
    L20:
        r10 = null;
        goto L21
    L33:
        return;
    L13:
        r8 = null;
        goto L15
    L31:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r4) {
        j r5 = this.c;
        Boolean r0 = null;
        if (r5 == null) goto L5;
        String r6 = r5.f();
    L6:
        k r1 = p;
        if (r1 == null) goto L21;
        if (r1 == null) goto L10;
        String r2 = r1.b;
    L11:
        j r3 = this.c;
        if (r3 == null) goto L17;
        Message r7 = r3.j;
        if (r7 == null) goto L17;
        r0 = Boolean.valueOf(r7.isNewBlockType());
    L17:
        if (c0.a(r6, r2, r0) == false) goto L22;
        x();
        return;
    L22:
        return;
    L10:
        r2 = null;
        goto L11
    L21:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a
    public final void seekTo(int r21) {
        if (this.e.e == false) goto L8;
        y(true);
        j r2 = this.c;
        if (r2 == null) goto L7;
        this.i.d(j.a(r2, null, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108607));
    L7:
        f20();
    L8:
        this.i.seekTo(r21);
    }

    public final void u(boolean r21) {
        if (n == true) goto L5;
        return;
    L5:
        this.a.eb(q());
        int r1 = 0;
        n = false;
        long r2 = AppHost.a.getAppClock().currentTimeMillis() - this.d;
        j r4 = this.c;
        if (r4 == null) goto L10;
        Message r5 = r4.j;
        if (r5 == null) goto L10;
        String r6 = com.larus.bmhome.chat.bean.d.x(r5).getOnboardingCardID();
    L12:
        if (com.larus.utils.o0.d(r6) == false) goto L14;
        String r7 = "onboarding_card_function_click";
    L15:
        String r8 = r7;
        j r9 = this.c;
        if (r9 == null) goto L21;
        String r10 = r9.h();
        if (r10 == null) goto L21;
        String r16 = r10;
    L22:
        j r11 = this.c;
        if (r11 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r21 == false) goto L30;
        String r13 = "auto_end";
    L33:
        j r14 = this.c;
        if (r14 == null) goto L42;
        ad9.b r15 = r14.g;
        if (r15 == null) goto L42;
        String r17 = r15.getItemId();
        if (r17 == null) goto L42;
        Integer r18 = StringsKt.toIntOrNull(r17);
        if (r18 == null) goto L42;
        r1 = r18.intValue();
    L42:
        String r19 = String.valueOf(r1 + 1);
        String r20 = o();
        j r3 = this.c;
        if (r3 == null) goto L48;
        String r22 = r3.f();
        if (r22 == null) goto L48;
        String r110 = r22;
    L49:
        j r23 = this.c;
        if (r23 == null) goto L52;
        String r24 = r23.d();
    L53:
        if (r24 != null) goto L55;
        String r111 = "";
    L56:
        j r25 = this.c;
        if (r25 == null) goto L62;
        String r26 = r25.e();
        if (r26 == null) goto L62;
        String r112 = r26;
    L63:
        int r113 = (int) r2;
        j r27 = this.c;
        if (r27 == null) goto L69;
        String r28 = r27.n();
        if (r28 == null) goto L69;
        String r114 = r28;
    L70:
        kr8.l.a.b(new kr8.w(r8, r13, r20, r19, r113, r111, r110, "ai_generated", r112, r16, r114, null, 4097), null, 3);
        return;
    L69:
        r114 = "";
    L62:
        r112 = "";
        goto L63
    L55:
        r111 = r24;
        goto L56
    L52:
        r24 = null;
    L48:
        r110 = "";
        goto L49
    L30:
        if (r12 == false) goto L32;
        r13 = "music_detail_page_button";
        goto L33
    L32:
        r13 = "music_card_button";
        goto L33
    L25:
        if (r11.i() != true) goto L27;
        r12 = true;
    L21:
        r16 = "";
        goto L22
    L14:
        r7 = "chat_action_bar";
    L10:
        r6 = null;
        goto L12
    }

    public final void v(long r8) {
        this.a.F6();
        j r0 = this.c;
        if (r0 == null) goto L17;
        Message r2 = r0.j;
        if (r2 == null) goto L18;
        nq9.f r1 = m3.a.o();
        if (r1 == null) goto L19;
        r1.b();
        i1a.a r3 = i1a.a.a;
        j r4 = this.c;
        if (r4 == null) goto L14;
        ad9.b r5 = r4.g;
        if (r5 == null) goto L14;
        String r6 = r5.getItemId();
        if (r6 == null) goto L14;
    L15:
        r3.g(r2, r6, r8, true);
        return;
    L14:
        r6 = "";
        goto L15
    L19:
        return;
    L18:
        return;
    }

    public final void w(Runnable r7) {
        BuildersKt.launch$default(getScope(), Dispatchers.getMain(), null, new StreamingMusicPlayer$runOnUI$1(r7, null), 2, null);
    }

    public final void y(boolean r25) {
        u(false);
        MediaPlayer r4 = q;     // Catch: IllegalStateException -> L26
        if (r4 == null) goto L8;
        boolean r5 = true;
        if (r4.isPlaying() != true) goto L8;
    L9:
        if (r5 == false) goto L25;
        MediaPlayer r6 = q;     // Catch: IllegalStateException -> L26
        if (r6 == null) goto L14;
        int r7 = r6.getCurrentPosition();     // Catch: IllegalStateException -> L26
    L55:
        FLogger.a.e("StreamingMusicPlayer", "pause " + q);     // Catch: IllegalStateException -> L23
        MediaPlayer r0 = q;     // Catch: IllegalStateException -> L23
        if (r0 != null) goto L18;
    L21:
        GlobalAudioObserver.a.c("music", GlobalAudioStateEnum.PAUSED, q());     // Catch: IllegalStateException -> L23
    L29:
        int r12 = r7;
    L30:
        k r1 = k.a(this.e, null, null, 0.0f, 0.0f, false, true, r12, 143);
        this.e = r1;
        k r8 = p;
        Boolean r9 = null;
        if (r8 == null) goto L33;
        String r10 = r8.b;
    L34:
        String r2 = r1.b;
        j r11 = this.c;
        if (r11 == null) goto L39;
        Message r13 = r11.j;
        if (r13 == null) goto L39;
        Boolean r14 = Boolean.valueOf(r13.isNewBlockType());
    L41:
        if (c0.a(r10, r2, r14) == false) goto L46;
        p = this.e;
        FLogger r3 = FLogger.a;
        StringBuilder r15 = new StringBuilder("update playing state cache 504 ");
        k r16 = p;
        if (r16 == null) goto L45;
        r9 = Boolean.valueOf(r16.e);
    L45:
        r15.append(r9);
        r15.append(' ');
        r15.append(p);
        r15.append(' ');
        r3.i("StreamingMusicPlayer", r15.toString());
    L46:
        j r17 = this.c;
        if (r17 == null) goto L49;
        FLogger.a.i("StreamingMusicPlayer", "update playing state before retain " + this.e + ' ');
        this.i.d(j.a(r17, null, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108095));
    L49:
        if (r25 == false) goto L51;
        FLogger.a.i("StreamingMusicPlayer", "stopAudio: mediaApplicant: " + this.m);
        Lazy r18 = MediaResourceManager.a;
        MediaResourceManager.a(this.m);
        this.g = false;
    L51:
        t();
        return;
    L39:
        r14 = null;
        goto L41
    L33:
        r10 = null;
        goto L34
    L18:
        if (fna.g.d() == true) goto L20;
        r0.pause();     // Catch: IllegalStateException -> L23
        goto L21
    L20:
        r0.pause();     // Catch: IllegalStateException -> L23
        gna.a.a(r0.hashCode());     // Catch: IllegalStateException -> L23
    L23:
        e = e;
    L28:
        FLogger.a.e("StreamingMusicPlayer", "illegal is playing check media player", e);
        goto L29
    L14:
        r7 = 0;
        goto L55
    L25:
        r12 = 0;
    L8:
        r5 = false;
    L26:
        e = e;
        r7 = 0;
        goto L28
    }

    public StreamingMusicPlayer(com.larus.bmhome.music.player.a.InterfaceC0021a r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "playerView");
        this.a = r17;
        this.b = r18;
        this.e = new k(null, null, 255);
        b r2 = new b(this);
        this.h = r2;
        VideoEngineMusicPlayerViewImpl r3 = new VideoEngineMusicPlayerViewImpl(r17, null);
        Intrinsics.checkNotNullParameter(r2, "participant");
        r3.v = r2;
        this.i = r3;
        f.e = false;
        c r14 = new c(this);
        this.l = r14;
        String r4 = r();
        int r12 = MediaLevel.PLAY_DEFAULT.getValue();
        this.m = new com.larus.media.model.a(null, r4, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), r12, false, r14, 1197);
    }

    public static final void l(StreamingMusicPlayer r27, float r28) {
        String r1 = StringsKt.removeSuffix(StringsKt.removePrefix(r27.e.b, "\""), "\"");
        FLogger r2 = FLogger.a;
        r2.i("StreamingMusicPlayer", "[playNewStream] real start playing chunk https://" + o + '/' + r1);
        k r4 = p;
        if (r4 == null) goto L5;
        k r5 = r27.e;
        k r6 = k.a(r4, r5.a, r5.b, 0.0f, 0.0f, false, false, 0, 252);
    L6:
        p = r6;
        StringBuilder r7 = new StringBuilder("[playNewStream] ");
        r7.append(Reflection.getOrCreateKotlinClass(r27.a.getClass()).getSimpleName());
        r7.append(" update playing state cache ");
        k r8 = p;
        if (r8 == null) goto L9;
        Boolean r9 = Boolean.valueOf(r8.e);
    L10:
        r7.append(r9);
        r7.append(' ');
        r7.append(p);
        r7.append(' ');
        r2.i("StreamingMusicPlayer", r7.toString());
        MediaPlayer r10 = q;
        if (r10 == null) goto L13;
        r10.setOnCompletionListener(new n());
    L13:
        MediaPlayer r11 = q;
        if (r11 == null) goto L16;
        r11.setOnErrorListener(new o());
    L16:
        MediaPlayer r12 = q;
        if (r12 == null) goto L19;
        r12.setOnPreparedListener(new p());
    L19:
        MediaPlayer r13 = q;
        if (r13 != null) goto L22;
    L25:
        MediaPlayer r14 = q;
        if (r14 == null) goto L28;
        r14.release();
    L28:
        MediaPlayer r15 = new MediaPlayer();
        r27.f = true;
        r15.setAudioStreamType(3);
        int r16 = 0;
        r15.setDataSource(r27.getViewContext(), UriProtector.parse(r27.p()), MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Api-Resource-ID", "bigmusic.fetch_content"), TuplesKt.to("X-Api-App-Key", "ziGOgUwSLu"), TuplesKt.to("X-tt-Token", String.valueOf(AccountService.a.getXTTToken())), TuplesKt.to("x-ttnet-req-biz-id", "Audio")}));
        a1 r17 = r;
        r15.setOnCompletionListener(r17);
        r15.setOnErrorListener(r17);
        r15.setOnPreparedListener(r17);
        r27.n();
        BuildersKt.launch$default(r27.getScope(), Dispatchers.getMain(), null, new StreamingMusicPlayer$playNewStream$4$1(r27, null), 2, null);
        r15.setVolume(r28, r28);
        r2.i("StreamingMusicPlayer", "[playNewStream] MediaPlayer set volume " + q + ' ');
        r15.prepare();
        r2.i("StreamingMusicPlayer", "[playNewStream] MediaPlayer playing prepared " + q + ' ');
        GlobalAudioObserver r18 = GlobalAudioObserver.a;
        r18.e("music", r27.p(), null);
        r18.c("music", GlobalAudioStateEnum.PLAYING, r27.q());
        if (fna.g.d() == true) goto L31;
        r15.start();
    L32:
        r27.x();
        r27.f = false;
        r2.i("StreamingMusicPlayer", "[playNewStream] MediaPlayer playing started " + q + ' ');
        if (n == true) goto L100;
        n = true;
        r27.d = AppHost.a.getAppClock().currentTimeMillis();
        StringBuilder r19 = new StringBuilder();
        r19.append(r27.o());
        r19.append('_');
        j r20 = r27.c;
        if (r20 == null) goto L40;
        ad9.b r21 = r20.g;
        if (r21 == null) goto L40;
        String r22 = r21.getItemId();
    L41:
        r19.append(r22);
        r27.a.r30(r19.toString(), r27.q());
        j r23 = r27.c;
        String r24 = "";
        if (r23 == null) goto L47;
        String r25 = r23.h();
        if (r25 == null) goto L47;
        String r110 = r25;
    L48:
        j r26 = r27.c;
        if (r26 == null) goto L57;
        ad9.b r29 = r26.g;
        if (r29 == null) goto L57;
        String r30 = r29.getItemId();
        if (r30 == null) goto L57;
        Integer r31 = StringsKt.toIntOrNull(r30);
        if (r31 == null) goto L57;
        r16 = r31.intValue();
    L57:
        String r111 = String.valueOf(r16 + 1);
        String r112 = r27.o();
        j r32 = r27.c;
        if (r32 == null) goto L63;
        String r33 = r32.f();
        if (r33 == null) goto L63;
        String r210 = r33;
    L64:
        j r34 = r27.c;
        if (r34 == null) goto L67;
        String r35 = r34.d();
    L68:
        if (r35 != null) goto L70;
        String r211 = "";
    L71:
        j r36 = r27.c;
        if (r36 == null) goto L77;
        String r37 = r36.e();
        if (r37 == null) goto L77;
        String r212 = r37;
    L78:
        j r38 = r27.c;
        if (r38 == null) goto L84;
        String r39 = r38.n();
        if (r39 == null) goto L84;
        String r213 = r39;
    L85:
        kr8.l.a.b(new kr8.x(r110, "auto_start", r112, r111, "chat_action_bar", null, r210, "ai_generated", r211, r212, r213, null, 4161), null, 3);
        j r3 = r27.c;
        if (r3 == null) goto L100;
        Message r40 = r3.j;
        if (r40 == null) goto L100;
        nq9.f r41 = m3.a.o();
        if (r41 == null) goto L100;
        r41.b();
        i1a.a r42 = i1a.a.a;
        j r0 = r27.c;
        if (r0 == null) goto L99;
        ad9.b r43 = r0.g;
        if (r43 == null) goto L99;
        String r44 = r43.getItemId();
        if (r44 == null) goto L99;
        r24 = r44;
    L99:
        r42.i(r40, r24, true);
    L84:
        r213 = "";
    L77:
        r212 = "";
        goto L78
    L70:
        r211 = r35;
        goto L71
    L67:
        r35 = null;
    L63:
        r210 = "";
    L47:
        r110 = "";
    L40:
        r22 = null;
    L100:
        r2.i("StreamingMusicPlayer", "[playNewStream] MediaPlayer playing reported " + q);
        q = r15;
        return;
    L31:
        r15.start();
        gna.a.c(r15.hashCode());
        goto L32
    L22:
        if (fna.g.d() == true) goto L24;
        r13.stop();
        goto L25
    L24:
        r13.stop();
        gna.a.a(r13.hashCode());
        goto L25
    L9:
        r9 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a
    public final void f(boolean r2, boolean r3) {
        j r0 = this.c;
        if (r0 == null) goto L5;
        r0.h = r2;
    L5:
        if (r0 == null) goto L7;
        r0.i = r3;
    L7:
        this.i.f(r2, r3);
    }

    @Override // com.larus.bmhome.music.player.a
    public final int j(String r3, Function1<? super Integer, Unit> r4) {
        k r0 = this.e;
        if (r0.e == false) goto L6;
        return ((int) r0.c) / GuidePriority.COMMERCE_CREDIT_PRIORITY;
    L6:
        return this.i.j(r3, r4);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r11, int r12, int r13) {
        j r14 = this.c;
        if (r14 == null) goto L5;
        String r15 = r14.f();
    L6:
        k r1 = p;
        if (r1 == null) goto L24;
        String r2 = r1.b;
        j r3 = this.c;
        if (r3 == null) goto L13;
        Message r4 = r3.j;
        if (r4 == null) goto L13;
        Boolean r5 = Boolean.valueOf(r4.isNewBlockType());
    L15:
        if (c0.a(r15, r2, r5) == false) goto L25;
        GlobalAudioObserver.a.f("music", Integer.valueOf(r12), Integer.valueOf(r13));
        FLogger r16 = FLogger.a;
        r16.e("StreamingMusicPlayer", "[MediaPlayer] onError, what:" + r12 + ", extra:" + r13);
        this.e = k.a(this.e, null, null, 0.0f, 0.0f, false, false, 0, 239);
        p = null;
        StringBuilder r17 = new StringBuilder("[MediaPlayer] update playing state cache 320 ");
        k r6 = p;
        if (r6 == null) goto L20;
        Boolean r7 = Boolean.valueOf(r6.e);
    L21:
        r17.append(r7);
        r17.append(' ');
        r17.append(p);
        r17.append(' ');
        r16.i("StreamingMusicPlayer", r17.toString());
        BuildersKt.launch$default(getScope(), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
        v(30022);
        return false;
    L20:
        r7 = null;
        goto L21
    L25:
        return false;
    L13:
        r5 = null;
        goto L15
    L24:
        return false;
    L5:
        r15 = null;
        goto L6
    }
}
