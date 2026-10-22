package com.larus.bmhome.music.player;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.VideoEngineState;
import com.larus.platform.api.j4;
import com.larus.platform.api.k4;
import com.larus.platform.api.l4;
import com.larus.platform.service.m3;
import com.larus.platform.service.q3;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class VideoEngineMusicPlayerViewImpl implements com.larus.bmhome.music.player.a, com.larus.bmhome.music.player.a.InterfaceC0021a {
    public static boolean I;
    public boolean A;
    public boolean B;
    public final j C;
    public com.larus.media.model.a D;
    public final g E;
    public final i F;
    public final long G;
    public long H;
    public final com.larus.bmhome.music.player.a.InterfaceC0021a a;
    public final String b;
    public com.larus.bmhome.music.player.j c;
    public float d;
    public boolean e;
    public long f;
    public com.larus.platform.api.p0 g;
    public c h;
    public d i;
    public final com.larus.bmhome.music.repo.a j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public Integer r;
    public long s;
    public boolean t;
    public GlobalAudioStateEnum u;
    public e78.c v;
    public IVideoController w;
    public String x;
    public IVideoController.PlayType y;
    public final h z;

    public static final class a {
    }

    public final class b implements e78.c {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;

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
            return this.a.u;
        }

        public final boolean pause() {
            final VideoEngineMusicPlayerViewImpl r0 = this.a;
            VideoEngineMusicPlayerViewImpl.m(r0, new h0(r0));
            return true;
        }

        public final boolean play() {
            final VideoEngineMusicPlayerViewImpl r0 = this.a;
            VideoEngineMusicPlayerViewImpl.m(r0, new i0(r0));
            return true;
        }

        public final boolean stop() {
            final VideoEngineMusicPlayerViewImpl r0 = this.a;
            VideoEngineMusicPlayerViewImpl.m(r0, new j0(r0));
            return true;
        }

        public b(VideoEngineMusicPlayerViewImpl r1) {
            this.a = r1;
        }
    }

    public final class c extends Handler {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;

        public c(VideoEngineMusicPlayerViewImpl r2, Looper r3) {
            Intrinsics.checkNotNullParameter(r3, "looper");
            this.a = r2;
            super(r3);
        }

        public final void a(d r3, long r4, boolean r6) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r6 == false) goto L6;
            VideoEngineMusicPlayerViewImpl r7 = this.a;
            r7.H = System.currentTimeMillis();
            postDelayed(r3, r4);
            return;
        L6:
            this.a.H = 0;
        }
    }

    public final class d implements Runnable {
        public final VideoEngineMusicPlayerViewImpl a;
        public final long b;
        public c c;
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl d;

        public final void a() {
            IVideoController r0 = this.d.w;
            if (r0 == null) goto L5;
            int r1 = r0.getCurrentPlaybackTime();
        L6:
            IVideoController r2 = this.d.w;
            if (r2 == null) goto L9;
            int r3 = r2.n();
        L11:
            if (r1 >= 0) goto L14;
            FLogger.a.e("SimpleMusicPlayerViewImpl", "[ProgressUpdateTask] run, current:" + r1);
            return;
        L14:
            if (r3 != 0) goto L18;
            FLogger.a.e("SimpleMusicPlayerViewImpl", "[ProgressUpdateTask] run, max:" + r3);
            return;
        L18:
            if (this.d.D() == false) goto L26;
            com.larus.bmhome.music.player.b.a r4 = com.larus.bmhome.music.player.b.a;
            String r5 = this.d.t();
            com.larus.bmhome.music.player.j r6 = this.d.c;
            if (r6 == null) goto L24;
            ad9.b r7 = r6.g;
            if (r7 == null) goto L24;
            String r8 = r7.getItemId();
        L25:
            r4.getClass();
            com.larus.bmhome.music.player.b.a.d(r5, r8, r1);
        L24:
            r8 = null;
        L26:
            VideoEngineMusicPlayerViewImpl r9 = this.a;
            if (r9 == null) goto L29;
            r9.b((r1 * 100.0f) / r3);
        L29:
            long r10 = System.currentTimeMillis();
            VideoEngineMusicPlayerViewImpl r11 = this.d;
            if ((r10 - r11.H) >= r11.G) goto L35;
            c r12 = this.c;
            if (r12 == null) goto L36;
            r12.a(this, this.b, true);
            return;
        L36:
            return;
        L35:
            return;
        L9:
            r3 = 100;
            goto L11
        L5:
            r1 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(VideoEngineMusicPlayerViewImpl r1, VideoEngineMusicPlayerViewImpl r2, long r3) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IVideoController.PlayType.values().length];
            r0[IVideoController.PlayType.PLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IVideoController.PlayType.PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class f implements l4 {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;
        public final /* synthetic */ Function1<Integer, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(VideoEngineMusicPlayerViewImpl r1, Function1<? super Integer, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r2, com.larus.video.impl.sdk.a r3) {
            if (r3 == null) goto L12;
            VideoEngineMusicPlayerViewImpl r4 = this.a;
            Function1<Integer, Unit> r0 = this.b;
            IVideoController r5 = r4.w;
            if (r5 == null) goto L6;
            Integer r6 = Integer.valueOf(r5.e(r3));
        L7:
            if (r6 == null) goto L9;
            int r7 = r6.intValue();
        L10:
            r0.invoke(Integer.valueOf(r7));
            return;
        L9:
            r7 = 30;
            goto L10
        L6:
            r6 = null;
            goto L7
        }
    }

    public static final class g implements e2a.a {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;

        public final void a() {
        }

        public final void b() {
        }

        public final void c() {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[InterruptCallback] onSpeakStart chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            this.a.k(false);
            this.a.H(false);
        }

        public g(VideoEngineMusicPlayerViewImpl r1) {
            this.a = r1;
        }
    }

    public static final class h implements j4 {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;

        public h(VideoEngineMusicPlayerViewImpl r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.p0 r4, boolean r5) {
            FLogger r0 = FLogger.a;
            r0.d("SimpleMusicPlayerViewImpl", "[onMediaControllerFocusChange] chatMessageId:" + this.a.t() + ", vid:" + this.a.x() + ", mediaTypeChange:" + r5);
            if (r4 != null) goto L5;
        L8:
            r0.d("SimpleMusicPlayerViewImpl", "[onMediaControllerFocusChange] videoModel changed, trigger resetUIStatus");
            this.a.J(r5);
            return;
        L5:
            if (Intrinsics.areEqual(r4, this.a.g) == false) goto L8;
            r0.d("SimpleMusicPlayerViewImpl", "Message id " + this.a.t() + "  Music singer " + this.a.x() + " => [MediaControllerFocusChangeListener]#resetProgress");
        }
    }

    public static final class i implements com.larus.platform.api.n0 {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;

        public final void b(Integer r1, Integer r2) {
        }

        public final JSONObject e() {
            kr8.n r0 = kr8.n.a;
            com.larus.bmhome.music.player.j r1 = this.a.c;
            String r2 = null;
            if (r1 == null) goto L5;
            kr8.o r3 = r1.d;
        L6:
            if (r1 == null) goto L9;
            r2 = r1.h();
        L9:
            if (Intrinsics.areEqual(r2, MusicAppletPage.SOURCE_TEMPLATE_LIST) == false) goto L11;
            String r4 = "template_page";
        L13:
            return kr8.n.c(r3, r4, false);
        L11:
            r4 = f();
            goto L13
        L5:
            r3 = null;
            goto L6
        }

        public final String f() {
            com.larus.bmhome.music.player.j r0 = this.a.c;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r3 == false) goto L11;
            return "music_detail";
        L11:
            if (r0 != null) goto L13;
        L15:
            r1 = false;
        L16:
            if (r1 == false) goto L18;
            return "music_detail";
        L18:
            if (r0 == null) goto L21;
            String r2 = r0.h();
            if (r2 == null) goto L21;
            return r2;
        L21:
            return "";
        L13:
            if (r0.i != true) goto L15;
        L5:
            if (r0.h != true) goto L7;
            r3 = true;
            goto L9
        }

        public final String g() {
            com.larus.bmhome.music.player.j r0 = this.a.c;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.k();
        L7:
            if (TextUtils.isEmpty(r2) == true) goto L14;
            com.larus.bmhome.music.player.j r3 = this.a.c;
            if (r3 == null) goto L12;
            String r4 = r3.k();
            if (r4 == null) goto L12;
            return r4;
        L12:
            return "";
        L14:
            com.larus.bmhome.music.player.j r5 = this.a.c;
            if (r5 == null) goto L17;
            String r6 = r5.h();
        L19:
            if (Intrinsics.areEqual(r6, MusicAppletPage.SOURCE_TEMPLATE_LIST) == false) goto L21;
            return MusicAppletPage.SOURCE_TEMPLATE_LIST;
        L21:
            com.larus.bmhome.music.player.j r7 = this.a.c;
            if (r7 == null) goto L24;
            String r8 = r7.h();
        L26:
            if (Intrinsics.areEqual(r8, "creation_list") == true) goto L52;
            com.larus.bmhome.music.player.j r9 = this.a.c;
            if (r9 == null) goto L30;
            String r10 = r9.h();
        L32:
            if (Intrinsics.areEqual(r10, "creation_others") == true) goto L56;
            com.larus.bmhome.music.player.j r11 = this.a.c;
            if (r11 == null) goto L37;
            String r12 = r11.h();
        L39:
            if (Intrinsics.areEqual(r12, "creation_detail") == false) goto L42;
            return "click_creation_detail";
        L42:
            com.larus.bmhome.music.player.j r13 = this.a.c;
            if (r13 == null) goto L48;
            Message r14 = r13.j;
            if (r14 == null) goto L48;
            r1 = com.larus.bmhome.chat.bean.d.x(r14).getOnboardingCardID();
        L48:
            if (com.larus.utils.o0.d(r1) == false) goto L50;
            return "onboarding_card_function_click";
        L50:
            return "chat_action_bar";
        L37:
            r12 = null;
            goto L39
        L56:
            return "click_creation_list";
        L30:
            r10 = null;
            goto L32
        L52:
            return "click_creation_list";
        L24:
            r8 = null;
            goto L26
        L17:
            r6 = null;
            goto L19
        L5:
            r2 = null;
            goto L7
        }

        public final void onCompletion() {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onCompletion chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            VideoEngineMusicPlayerViewImpl r0 = this.a;
            com.larus.bmhome.music.player.j r1 = r0.c;
            String r2 = null;
            if (r1 == null) goto L5;
            ad9.b r3 = r1.g;
        L6:
            r0.H(true);
            com.larus.bmhome.music.player.b.a r4 = com.larus.bmhome.music.player.b.a;
            com.larus.bmhome.music.player.j r5 = this.a.c;
            r4.getClass();
            com.larus.bmhome.music.player.b.a.b(r3, r5);
            String r6 = this.a.t();
            if (r3 == null) goto L9;
            r2 = r3.getItemId();
        L9:
            com.larus.bmhome.music.player.b.a.d(r6, r2, 0);
            if (com.larus.bmhome.music.player.b.a.h == false) goto L13;
            VideoEngineMusicPlayerViewImpl r7 = this.a;
            r7.n = true;
            VideoEngineMusicPlayerViewImpl.F(r7, 0, false, 3);
            return;
        L13:
            return;
        L5:
            r3 = null;
            goto L6
        }

        public final void onPrepare() {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onPrepare, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            VideoEngineMusicPlayerViewImpl.o(this.a);
        }

        public final void onPrepared() {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onPrepared, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
        }

        public final void onRenderStart() {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onRenderStart, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            VideoEngineMusicPlayerViewImpl r0 = this.a;
            if (r0.t == false) goto L19;
            com.larus.bmhome.music.player.j r1 = r0.c;
            if (r1 == null) goto L20;
            Message r2 = r1.j;
            if (r2 == null) goto L21;
            nq9.f r3 = m3.a.o();
            if (r3 == null) goto L22;
            r3.b();
            i1a.a r4 = i1a.a.a;
            com.larus.bmhome.music.player.j r5 = r0.c;
            if (r5 == null) goto L16;
            ad9.b r6 = r5.g;
            if (r6 == null) goto L16;
            String r7 = r6.getItemId();
            if (r7 == null) goto L16;
        L17:
            r4.i(r2, r7, false);
            return;
        L16:
            r7 = "";
            goto L17
        L22:
            return;
        L21:
            return;
        L20:
            return;
        }

        public i(VideoEngineMusicPlayerViewImpl r1) {
            this.a = r1;
        }

        public final void c(int r32) {
            String r9 = "music_card_button";
            String r10 = "click_template";
            if (r32 != this.a.q(VideoEngineState.PLAYBACK_STATE_PLAYING)) goto L132;
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onPlaybackStateChanged:PLAYBACK_STATE_PLAYING, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            VideoEngineMusicPlayerViewImpl.n(this.a, GlobalAudioStateEnum.PLAYING);
            VideoEngineMusicPlayerViewImpl r1 = this.a;
            r1.y = IVideoController.PlayType.PAUSE;
            r1.A();
            this.a.L();
            if (VideoEngineMusicPlayerViewImpl.I == false) goto L7;
            int r2 = 0;
        L121:
            VideoEngineMusicPlayerViewImpl r3 = this.a;
            int r4 = r3.k;
            if (r4 == 0) goto L124;
            r3.seekTo(r4);
            this.a.k = r2;
        L124:
            com.larus.bmhome.music.player.j r5 = this.a.c;
            if (r5 == null) goto L260;
            ad9.b r6 = r5.g;
            if (r6 == null) goto L261;
            com.larus.bmhome.music.player.b.a r7 = com.larus.bmhome.music.player.b.a;
            String r8 = r5.j();
            if (r8 != null) goto L131;
            r8 = "";
        L131:
            r7.getClass();
            com.larus.bmhome.music.player.b.a.a(r6, r8);
            return;
        L261:
            return;
        L260:
            return;
        L7:
            VideoEngineMusicPlayerViewImpl.I = true;
            this.a.f = AppHost.a.getAppClock().currentTimeMillis();
            VideoEngineMusicPlayerViewImpl r11 = this.a;
            com.larus.bmhome.music.player.j r12 = r11.c;
            if (r12 != null) goto L10;
        L12:
            boolean r13 = false;
        L13:
            if (r13 == false) goto L18;
            com.larus.platform.service.o.a.b("music_play_start", com.larus.utils.f.c(new Pair[]{TuplesKt.to("bot_id", r11.s()), TuplesKt.to("song_id", this.a.w())}));
            VideoEngineMusicPlayerViewImpl r14 = this.a;
            com.larus.bmhome.music.player.a.InterfaceC0021a r15 = r14.a;
            String r16 = r14.w();
            if (r16 != null) goto L17;
            r16 = "";
        L17:
            r15.r30(r16, this.a.u());
        L120:
            r2 = 0;
            this.a.l = false;
            goto L121
        L18:
            String r18 = f();
            com.larus.bmhome.music.player.j r17 = this.a.c;
            if (r17 != null) goto L21;
        L23:
            boolean r19 = false;
        L24:
            VideoEngineMusicPlayerViewImpl r20 = this.a;
            if (r20.n == false) goto L27;
            r20.n = false;
        L67:
            r9 = "auto_start";
        L68:
            String r110 = r9;
        L69:
            String r21 = this.a.t();
            com.larus.bmhome.music.player.j r22 = this.a.c;
            if (r22 == null) goto L78;
            ad9.b r23 = r22.g;
            if (r23 == null) goto L78;
            String r24 = r23.getItemId();
            if (r24 == null) goto L78;
            Integer r25 = StringsKt.toIntOrNull(r24);
            if (r25 == null) goto L78;
            int r26 = r25.intValue();
        L79:
            String r27 = String.valueOf(r26 + 1);
            String r28 = g();
            com.larus.bmhome.music.player.j r29 = this.a.c;
            if (r29 == null) goto L85;
            String r30 = r29.o();
            if (r30 == null) goto L85;
            String r210 = r30;
        L86:
            String r31 = this.a.s();
            if (r31 != null) goto L89;
            String r211 = "";
        L90:
            com.larus.bmhome.music.player.j r33 = this.a.c;
            if (r33 == null) goto L96;
            String r34 = r33.e();
            if (r34 == null) goto L96;
            String r212 = r34;
        L97:
            com.larus.bmhome.music.player.j r35 = this.a.c;
            if (r35 == null) goto L103;
            String r36 = r35.n();
            if (r36 == null) goto L103;
            String r213 = r36;
        L104:
            com.larus.bmhome.music.player.j r37 = this.a.c;
            if (r37 != null) goto L107;
        L109:
            boolean r38 = false;
        L110:
            if (r38 == false) goto L112;
            String r214 = "1";
        L113:
            kr8.l.a.b(new kr8.x(r18, r110, r21, r27, r28, r210, null, "ai_generated", r211, r212, r213, r214, 129), e(), 1);
            StringBuilder r39 = new StringBuilder();
            r39.append(this.a.t());
            r39.append('_');
            com.larus.bmhome.music.player.j r40 = this.a.c;
            if (r40 == null) goto L118;
            ad9.b r41 = r40.g;
            if (r41 == null) goto L118;
            String r42 = r41.getItemId();
        L119:
            r39.append(r42);
            String r43 = r39.toString();
            VideoEngineMusicPlayerViewImpl r44 = this.a;
            r44.a.r30(r43, r44.u());
        L118:
            r42 = null;
            goto L119
        L112:
            r214 = TriggerSendLoading.NO_LOADING;
            goto L113
        L107:
            if (r37.e != true) goto L109;
            r38 = true;
        L103:
            r213 = "";
        L96:
            r212 = "";
            goto L97
        L89:
            r211 = r31;
        L85:
            r210 = "";
        L78:
            r26 = 0;
            goto L79
        L27:
            com.larus.bmhome.music.player.j r45 = r20.c;
            if (r45 != null) goto L30;
        L32:
            boolean r46 = false;
        L33:
            if (r46 == true) goto L35;
        L37:
            if (r45 != null) goto L39;
        L41:
            boolean r47 = false;
        L42:
            if (r47 == true) goto L44;
        L46:
            if (r45 == null) goto L48;
            String r48 = r45.h();
        L50:
            if (Intrinsics.areEqual(r48, "creation_detail") == false) goto L52;
            r110 = "creation_detail";
            goto L69
        L52:
            if (r19 == true) goto L54;
            com.larus.bmhome.music.player.j r49 = this.a.c;
            if (r49 == null) goto L60;
            String r50 = r49.h();
        L62:
            if (Intrinsics.areEqual(r50, MusicAppletPage.SOURCE_TEMPLATE_LIST) == false) goto L64;
        L63:
            r110 = r10;
            goto L69
        L64:
            VideoEngineMusicPlayerViewImpl r51 = this.a;
            if (r51.A == false) goto L68;
            r51.t = true;
            goto L67
        L60:
            r50 = null;
            goto L62
        L54:
            if (this.a.A == false) goto L56;
            r9 = "show_music_detail";
            goto L68
        L56:
            r9 = "music_detail_page_button";
            goto L68
        L48:
            r48 = null;
            goto L50
        L44:
            if (r20.l == true) goto L46;
            r10 = "click_previous";
            goto L63
        L39:
            if (r45.i != true) goto L41;
            r47 = true;
            goto L42
        L35:
            if (r20.l == true) goto L37;
            r10 = "click_next";
            goto L63
        L30:
            if (r45.h != true) goto L32;
            r46 = true;
            goto L33
        L21:
            if (r17.i() != true) goto L23;
            r19 = true;
            goto L24
        L10:
            if (r12.f != true) goto L12;
            r13 = true;
            goto L13
        L132:
            VideoEngineMusicPlayerViewImpl r52 = this.a;
            VideoEngineState r53 = VideoEngineState.PLAYBACK_STATE_PAUSED;
            if (r32 == r52.q(r53)) goto L141;
            if (r32 == this.a.q(VideoEngineState.PLAYBACK_STATE_STOPPED)) goto L141;
            if (r32 != this.a.q(VideoEngineState.PLAYBACK_STATE_ERROR)) goto L263;
            VideoEngineMusicPlayerViewImpl.n(this.a, GlobalAudioStateEnum.STOPPED);
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onPlaybackStateChanged:PLAYBACK_STATE_ERROR, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            this.a.l();
            this.a.A();
            this.a.H(true);
            this.a.G(30033);
            return;
        L263:
            return;
        L141:
            VideoEngineMusicPlayerViewImpl r54 = this.a;
            if (r32 != r54.q(r53)) goto L144;
            GlobalAudioStateEnum r55 = GlobalAudioStateEnum.PAUSED;
        L145:
            VideoEngineMusicPlayerViewImpl.n(r54, r55);
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onPlaybackStateChanged:PLAYBACK_STATE_PAUSED|PLAYBACK_STATE_STOPPED, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            if (this.a.s >= (System.currentTimeMillis() - ((long) 500))) goto L148;
            this.a.FK();
        L148:
            this.a.A();
            if (r32 == this.a.q(VideoEngineState.PLAYBACK_STATE_STOPPED)) goto L151;
        L153:
            boolean r56 = false;
        L155:
            if (VideoEngineMusicPlayerViewImpl.I == false) goto L265;
            VideoEngineMusicPlayerViewImpl r57 = this.a;
            r57.a.eb(r57.u());
            VideoEngineMusicPlayerViewImpl.I = false;
            long r58 = AppHost.a.getAppClock().currentTimeMillis();
            VideoEngineMusicPlayerViewImpl r59 = this.a;
            long r60 = r58 - r59.f;
            com.larus.bmhome.music.player.j r61 = r59.c;
            if (r61 != null) goto L160;
        L162:
            boolean r62 = false;
        L163:
            if (r62 == false) goto L169;
            com.larus.platform.service.o r63 = com.larus.platform.service.o.a;
            Pair[] r64 = new Pair[4];
            r64[0] = TuplesKt.to("bot_id", r59.s());
            r64[1] = TuplesKt.to("song_id", this.a.w());
            r64[2] = TuplesKt.to("duration", Long.valueOf(r60));
            com.larus.bmhome.music.player.j r65 = this.a.c;
            if (r65 == null) goto L167;
            String r66 = r65.k();
        L168:
            r64[3] = TuplesKt.to("show_from", r66);
            r63.b("music_play_end", com.larus.utils.f.c(r64));
        L258:
            this.a.m = false;
            return;
        L167:
            r66 = null;
            goto L168
        L169:
            String r215 = f();
            com.larus.bmhome.music.player.j r67 = this.a.c;
            if (r67 != null) goto L172;
        L174:
            boolean r68 = false;
        L175:
            if (r56 == false) goto L177;
            String r69 = "auto_end";
        L212:
            String r111 = r69;
        L213:
            String r70 = g();
            com.larus.bmhome.music.player.j r71 = this.a.c;
            if (r71 == null) goto L222;
            ad9.b r72 = r71.g;
            if (r72 == null) goto L222;
            String r73 = r72.getItemId();
            if (r73 == null) goto L222;
            Integer r74 = StringsKt.toIntOrNull(r73);
            if (r74 == null) goto L222;
            int r75 = r74.intValue();
            int r76 = 1;
        L223:
            String r216 = String.valueOf(r75 + r76);
            String r217 = this.a.t();
            com.larus.bmhome.music.player.j r77 = this.a.c;
            if (r77 == null) goto L229;
            String r78 = r77.o();
            if (r78 == null) goto L229;
            String r218 = r78;
        L230:
            String r79 = this.a.s();
            if (r79 != null) goto L233;
            String r219 = "";
        L234:
            com.larus.bmhome.music.player.j r80 = this.a.c;
            if (r80 == null) goto L240;
            String r81 = r80.e();
            if (r81 == null) goto L240;
            String r220 = r81;
        L241:
            int r82 = (int) r60;
            com.larus.bmhome.music.player.j r83 = this.a.c;
            if (r83 == null) goto L247;
            String r84 = r83.n();
            if (r84 == null) goto L247;
            String r221 = r84;
        L248:
            com.larus.bmhome.music.player.j r85 = this.a.c;
            if (r85 != null) goto L251;
        L253:
            boolean r86 = false;
        L254:
            if (r86 == false) goto L256;
            String r222 = "1";
        L257:
            kr8.l.a.b(new kr8.w(r70, r111, r217, r216, r82, r219, r218, "ai_generated", r220, r215, r221, r222, 1), e(), 1);
            goto L258
        L256:
            r222 = TriggerSendLoading.NO_LOADING;
            goto L257
        L251:
            if (r85.e != true) goto L253;
            r86 = true;
        L247:
            r221 = "";
        L240:
            r220 = "";
            goto L241
        L233:
            r219 = r79;
        L229:
            r218 = "";
        L222:
            r76 = 1;
            r75 = 0;
            goto L223
        L177:
            VideoEngineMusicPlayerViewImpl r87 = this.a;
            com.larus.bmhome.music.player.j r88 = r87.c;
            if (r88 != null) goto L180;
        L182:
            boolean r89 = false;
        L183:
            if (r89 == true) goto L185;
        L187:
            if (r88 != null) goto L189;
        L191:
            boolean r90 = false;
        L192:
            if (r90 == true) goto L194;
        L196:
            if (r88 == null) goto L198;
            String r91 = r88.h();
        L200:
            if (Intrinsics.areEqual(r91, "creation_detail") == false) goto L202;
            r111 = "creation_detail";
            goto L213
        L202:
            if (r68 == false) goto L204;
            r69 = "music_detail_page_button";
            goto L212
        L204:
            com.larus.bmhome.music.player.j r92 = this.a.c;
            if (r92 == null) goto L207;
            String r93 = r92.h();
        L209:
            if (Intrinsics.areEqual(r93, MusicAppletPage.SOURCE_TEMPLATE_LIST) == false) goto L211;
            r69 = "click_template";
            goto L212
        L211:
            r69 = "music_card_button";
            goto L212
        L207:
            r93 = null;
            goto L209
        L198:
            r91 = null;
            goto L200
        L194:
            if (r87.m == true) goto L196;
            r69 = "click_previous";
            goto L212
        L189:
            if (r88.i != true) goto L191;
            r90 = true;
            goto L192
        L185:
            if (r87.m == true) goto L187;
            r69 = "click_next";
            goto L212
        L180:
            if (r88.h != true) goto L182;
            r89 = true;
            goto L183
        L172:
            if (r67.i() != true) goto L174;
            r68 = true;
            goto L175
        L160:
            if (r61.f != true) goto L162;
            r62 = true;
            goto L163
        L265:
            return;
        L151:
            if (this.a.m == true) goto L153;
            r56 = true;
            goto L155
        L144:
            r55 = GlobalAudioStateEnum.STOPPED;
            goto L145
        }

        public final void d(int r5) {
            if (r5 != this.a.q(VideoEngineState.LOAD_STATE_STALLED)) goto L8;
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onLoadStateChanged:LOAD_STATE_STALLED, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            VideoEngineMusicPlayerViewImpl.o(this.a);
            if (NetworkUtils.isNetworkAvailable(this.a.getViewContext()) == true) goto L14;
            t19.s r6 = t19.s.a;
            Context r0 = this.a.getViewContext();
            r6.getClass();
            t19.s.b(r0, 2131906741, false);
            return;
        L14:
            return;
        L8:
            if (r5 != this.a.q(VideoEngineState.LOAD_STATE_ERROR)) goto L11;
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onLoadStateChanged:LOAD_STATE_ERROR, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            this.a.k(true);
            this.a.G(30034);
            return;
        L11:
            if (r5 != this.a.q(VideoEngineState.PLAYBACK_STATE_PLAYING)) goto L17;
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onLoadStateChanged:PLAYBACK_STATE_PLAYING, chatMessageId:" + this.a.t() + ", vid:" + this.a.x());
            this.a.A();
            return;
        }

        public final void onVideoStatusException(int r4) {
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onVideoStatusException chatMessageId:" + this.a.t() + ", vid:" + this.a.x() + ", status:" + r4);
            this.a.H(true);
        }

        public final void a(Integer r3, Integer r4) {
            GlobalAudioObserver.a.f("music", r3, r4);
            t19.s r5 = t19.s.a;
            Context r0 = this.a.getViewContext();
            r5.getClass();
            t19.s.b(r0, 2131908360, false);
            FLogger.a.d("SimpleMusicPlayerViewImpl", "[IFlowVideoEngineCallback] onError chatMessageId:" + this.a.t() + ", vid:" + this.a.x() + ", code:" + r3);
            this.a.G(30032);
            this.a.H(true);
        }
    }

    public static final class j implements com.larus.media.v {
        public ValueAnimator a;
        public boolean b;
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl c;

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

        public j(VideoEngineMusicPlayerViewImpl r1) {
            this.c = r1;
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

        public final void e(lk9.g r1) {
            com.larus.media.v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            Intrinsics.checkNotNullParameter(r6, "event");
            if (com.larus.media.o.a() == false) goto L20;
            MediaResourceManager.FlowAudioBroadcastEvent r0 = r6.c;
            if (r0 != null) goto L7;
            int r1 = -1;
        L9:
            if (r1 != 1) goto L11;
            FLogger.a.i("SimpleMusicPlayerViewImpl", "event asrWaitReplyBegin , msgId: " + r6.b);
            this.b = true;
            return;
        L11:
            if (r1 == 2) goto L13;
            FLogger.a.i("SimpleMusicPlayerViewImpl", "else  msgId: " + r6.b);
            this.b = false;
            return;
        L13:
            FLogger.a.i("SimpleMusicPlayerViewImpl", "event asrWaitReplyEnd , msgId: " + r6.b);
            if (this.b == false) goto L22;
            this.b = false;
            final VideoEngineMusicPlayerViewImpl r7 = this.c;
            c r2 = r7.h;
            if (r2 == null) goto L23;
            r2.post(new y0(r7, this));
            return;
        L23:
            return;
        L22:
            return;
        L7:
            r1 = a.a[r0.ordinal()];
            goto L9
        }

        public final void a(lk9.g r3, final float r4) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.f(r3, r4);
            final VideoEngineMusicPlayerViewImpl r5 = this.c;
            if (r5.B == false) goto L10;
            r5.B = false;
            if (this.b == true) goto L11;
            c r0 = r5.h;
            if (r0 == null) goto L12;
            r0.post(new s0(r5, this, r4));
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r3, final float r4) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.g(r3, r4);
            final VideoEngineMusicPlayerViewImpl r5 = this.c;
            r5.d = r4;
            c r0 = r5.h;
            if (r0 == null) goto L6;
            r0.post(new k0(this, r5, r4));
            return;
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r3, lk9.g r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "current");
            Intrinsics.checkNotNullParameter(r4, "applicant");
            boolean r6 = false;
            if (com.larus.media.o.a() == true) goto L9;
            final VideoEngineMusicPlayerViewImpl r7 = this.c;
            r7.B = false;
            c r8 = r7.h;
            if (r8 == null) goto L8;
            r8.post(new q0(r7, this));
        L8:
            return MediaOccupyStrategy.INTERRUPT;
        L9:
            this.c.getClass();
            String r9 = r4.getScene();
            boolean r1 = true;
            switch(r9.hashCode()) {
                case -1989469372: goto L32;
                case -1833998801: goto L29;
                case 96896: goto L26;
                case 3089402: goto L16;
                case 93217264: goto L13;
                default: goto L34;
            };
        L34:
            boolean r10 = false;
        L35:
            if (r10 == false) goto L51;
            IVideoController r11 = this.c.w;
            if (r11 != null) goto L39;
        L41:
            if (r6 == false) goto L50;
            VideoEngineMusicPlayerViewImpl r12 = this.c;
            r12.B = true;
            IVideoController r13 = r12.w;
            if (r13 == null) goto L45;
            final float r14 = r13.g();
        L46:
            final VideoEngineMusicPlayerViewImpl r15 = this.c;
            c r16 = r15.h;
            if (r16 == null) goto L50;
            r16.post(new r0(this, r14, r15));
            goto L50
        L45:
            r14 = 1.0f;
        L50:
            return MediaOccupyStrategy.PAUSE;
        L39:
            if (r11.p3() != true) goto L41;
            r6 = true;
            goto L41
        L51:
            this.c.B = false;
            if (Intrinsics.areEqual(r4.getScene(), "music") == true) goto L69;
            if (Intrinsics.areEqual(r4.getScene(), "music_gen") == true) goto L69;
            IVideoController r17 = this.c.w;
            if (r17 != null) goto L59;
        L61:
            r1 = false;
        L62:
            if (r1 == false) goto L67;
            if (this.c.D() == false) goto L67;
            this.c.k(false);
            this.c.FK();
            this.c.A();
            this.c.B();
        L67:
            return MediaOccupyStrategy.INTERRUPT;
        L59:
            if (r17.p3() != true) goto L61;
        L69:
            return MediaOccupyStrategy.INTERRUPT;
        L13:
            if (r9.equals("VOICE_COMPONENT") == false) goto L34;
        L33:
            r10 = true;
            goto L35
        L16:
            if (r9.equals("dora") == false) goto L34;
            IFlowSdkDepend r18 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r18 == null) goto L34;
            com.larus.home.impl.sdk.s r19 = r18.s0();
            if (r19 == null) goto L34;
            if (r19.c() != true) goto L34;
        L26:
            if (r9.equals("asr") == true) goto L33;
        L29:
            if (r9.equals("SYSTEM") == true) goto L33;
        L32:
            if (r9.equals("UGC_VOICE") == false) goto L34;
            goto L33
        }
    }

    static {
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

    @Override // com.larus.bmhome.music.player.a
    public final boolean isStreaming() {
        return false;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void mP(int r2, boolean r3) {
        this.a.mP(r2, r3);
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onAttachedToWindow() {
        this.o = true;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[onAttachedToWindow] chatMessageId:" + t() + ", vid:" + x());
        if (this.o == true) goto L5;
    L13:
        IVideoController r0 = this.w;
        if (r0 == null) goto L17;
        r0.q(this.z, t());
        return;
    L17:
        return;
    L5:
        if (this.p == true) goto L13;
        if (TextUtils.isEmpty(y()) == true) goto L13;
        List r1 = e2a.e.a;
        g r2 = this.E;
        if (r2 == null) goto L13;
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) e2a.e.a;
        if (r3.contains(r2) == true) goto L13;
        r3.add(r2);
        goto L13
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onDestroyed() {
        this.p = true;
        this.o = false;
        GlobalAudioController.a.d(this.v);
        k(true);
        M();
        IVideoController r0 = this.w;
        if (r0 == null) goto L5;
        r0.D(this.z, t());
    L5:
        IVideoController r1 = this.w;
        if (r1 == null) goto L8;
        r1.l();
    L8:
        List r2 = e2a.e.a;
        g r3 = this.E;
        if (r3 == null) goto L11;
        ((CopyOnWriteArrayList) e2a.e.a).remove(r3);
    L11:
        String r4 = this.x;
        if (r4 == null) goto L14;
        com.larus.bmhome.music.player.i.f(r4);
    L24:
        this.w = null;
        com.larus.bmhome.music.player.f.e = false;
        return;
    L14:
        Lazy r5 = com.larus.bmhome.music.player.i.a;
        Context r6 = this.a.getViewContext();
        Intrinsics.checkNotNullParameter(r6, "context");
        String r7 = r6.toString();
        IVideoController r8 = (IVideoController) com.larus.bmhome.music.player.i.c().get(r7);
        if (r8 == null) goto L24;
        ConcurrentHashMap r9 = com.larus.bmhome.music.player.i.c();
        monitor-enter(r9);
    L26:
        th = move-exception;
        throw th;
    L20:
        if (r8.isReleased() == true) goto L22;
        r8.release();     // Catch: Throwable -> L26
    L22:
        IVideoController r10 = (IVideoController) com.larus.bmhome.music.player.i.c().remove(r7);     // Catch: Throwable -> L26
        monitor-exit(r9);
        goto L24
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onDetachedFromWindow() {
        this.o = false;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[onDetachedFromWindow] chatMessageId:" + t() + ", vid:" + x());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        List r2 = e2a.e.a;     // Catch: Throwable -> L12
        g r3 = this.E;     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        ((CopyOnWriteArrayList) e2a.e.a).remove(r3);     // Catch: Throwable -> L12
    L6:
        IVideoController r4 = this.w;     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.D(this.z, t());     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.e("SimpleMusicPlayerViewImpl", "[onDetachedFromWindow] error: " + r7.getMessage());
    L18:
        this.g = null;
        return;
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
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

    public final void A() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[hideLoading] chatMessageId:" + t() + ", vid:" + x());
        hideLoadingView();
    }

    public final void B() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[hideProgress] chatMessageId:" + t() + ", vid:" + x());
        Lf();
        N();
    }

    public final void C() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[initEngineCallBack] chatMessageId:$" + t() + ", vid:" + x());
        IVideoController r0 = this.w;
        if (r0 == null) goto L6;
        r0.p(this.F);
        return;
    }

    public final boolean D() {
        String r0 = x() + t();
        IVideoController r1 = this.w;
        if (r1 == null) goto L5;
        String r2 = r1.getMediaId();
    L7:
        return Intrinsics.areEqual(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean E() {
        IVideoController r0 = this.w;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.p3();
    }

    public final void I() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[resetProgress] chatMessageId:" + t() + ", vid:" + x());
        if (this.k != 0) goto L6;
        mP(2, false);
        Pe(2.0f, false);
        return;
    }

    public final void L() {
        FLogger r0 = FLogger.a;
        r0.d("SimpleMusicPlayerViewImpl", "[showProgress] chatMessageId:" + t() + ", vid:" + x());
        UY();
        r0.d("SimpleMusicPlayerViewImpl", "[updateProgressWithLoop] chatMessageId:" + t() + ", vid:" + x());
        c r1 = this.h;
        if (r1 == null) goto L5;
        r1.a(this.i, 0, true);
    L5:
        f20();
    }

    public final void M() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[stop] chatMessageId:" + t() + ", vid:" + x());
        IVideoController r0 = this.w;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public final void N() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[stopUpdateProgress] chatMessageId:" + t() + ", vid:" + x());
        c r0 = this.h;
        if (r0 == null) goto L6;
        r0.a(this.i, 0, false);
        return;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void c() {
        GlobalAudioController.a.d(this.v);
        l();
        this.B = false;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void i() {
        FLogger.a.i("SimpleMusicPlayerViewImpl", "[tryToggle]");
        z(true, false, false);
    }

    public final void l() {
        FLogger.a.i("SimpleMusicPlayerViewImpl", "abandonAudioFocus mediaApplicant: " + this.D);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.D);
        this.e = false;
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onPaused() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", this + " onPaused");
        com.larus.bmhome.music.player.f r0 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.f.e = true;
        this.a.Ij(u());
    }

    @Override // com.larus.bmhome.music.player.a
    public final void onResumed() {
        FLogger.a.d("SimpleMusicPlayerViewImpl", this + " resumed");
        com.larus.bmhome.music.player.f r0 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.f.e = false;
        this.a.GP(u());
    }

    public final void p() {
        IVideoController.PlayType r0 = this.y;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[changePlayStatus] chatMessageId:" + t() + ", vid:" + x() + ", status:PLAY");
        f20();
        return;
    L9:
        if (r1 == 2) goto L11;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[changePlayStatus] chatMessageId:" + t() + ", vid:" + x() + ", status:" + this.y);
        FK();
        A();
        B();
        return;
    L11:
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[changePlayStatus] chatMessageId:" + t() + ", vid:" + x() + ", status:PAUSE");
        FK();
        A();
        B();
        return;
    L5:
        r1 = e.a[r0.ordinal()];
        goto L7
    }

    public final Boolean r() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.c());
    }

    public final String s() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final String t() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.j();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final Map<String, String> u() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.larus.bmhome.music.player.j r1 = this.c;
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

    public final String v() {
        com.larus.bmhome.music.player.j r0 = this.c;
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

    public final String w() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m();
    }

    public final String x() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o();
    }

    public final String y() {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p();
    }

    @Override // com.larus.bmhome.music.player.a
    public final boolean a() {
        return D();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void g() {
        if (D() == true) goto L5;
        return;
    L5:
        if (this.e == true) goto L14;
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 == null) goto L10;
        String r1 = r0.o();
    L11:
        String r2 = r1;
        String r3 = v();
        int r11 = MediaLevel.PLAY_HIGH.getValue();
        com.larus.media.model.a r4 = new com.larus.media.model.a(r2, r3, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), r11, false, this.C, 1196);
        this.D = r4;
        MediaResourceManager.m(r4, new f0(this), new g0(this), 0, 8);
        return;
    L10:
        r1 = null;
        goto L11
    }

    @Override // com.larus.bmhome.music.player.a
    public final com.larus.bmhome.music.player.j data() {
        return this.c;
    }

    public static final void o(VideoEngineMusicPlayerViewImpl r3) {
        r3.getClass();
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[showLoading] chatMessageId:" + r3.t() + ", vid:" + r3.x());
        r3.Lf();
        r3.I();
        r3.OK();
        r3.showLoadingView();
    }

    public final void G(long r8) {
        this.a.F6();
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 == null) goto L17;
        Message r2 = r0.j;
        if (r2 == null) goto L18;
        nq9.f r1 = m3.a.o();
        if (r1 == null) goto L19;
        r1.b();
        i1a.a r3 = i1a.a.a;
        com.larus.bmhome.music.player.j r4 = this.c;
        if (r4 == null) goto L14;
        ad9.b r5 = r4.g;
        if (r5 == null) goto L14;
        String r6 = r5.getItemId();
        if (r6 == null) goto L14;
    L15:
        r3.g(r2, r6, r8, false);
        return;
    L14:
        r6 = "";
        goto L15
    L19:
        return;
    L18:
        return;
    }

    public final void H(boolean r6) {
        FLogger r0 = FLogger.a;
        r0.d("SimpleMusicPlayerViewImpl", "[reset] chatMessageId:" + t() + ", vid:" + x());
        Lf();
        hideLoadingView();
        this.y = IVideoController.PlayType.PLAY;
        N();
        FK();
        if (r6 == false) goto L9;
        Lr();
        r0.d("SimpleMusicPlayerViewImpl", "[reset] chatMessageId:" + t() + ", vid:" + x() + ", trigger stop");
        if (D() == true) goto L7;
        return;
    L7:
        M();
        return;
    }

    public final void J(boolean r7) {
        IVideoController.PlayType r0 = this.y;
        IVideoController.PlayType r1 = IVideoController.PlayType.PLAY;
        if (r0 != r1) goto L7;
        if (r7 == true) goto L7;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[resetUIStatus] chatMessageId:" + t() + ", vid:" + x() + ", ignore");
        return;
    L7:
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[resetUIStatus] chatMessageId:" + t() + ", vid:" + x() + ", status:" + this.y + ", mediaTypeChange:" + r7);
        Lf();
        I();
        OK();
        hideLoadingView();
        this.y = r1;
        FK();
    }

    @Override // com.larus.bmhome.music.player.a
    public final void b(float r6) {
        com.larus.bmhome.music.player.f r0 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.j r1 = this.c;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[check can play] id ");
        r3.append(com.larus.bmhome.music.player.f.c);
        r3.append(" self ");
        String r4 = null;
        if (r1 == null) goto L5;
        String r5 = r1.j();
    L6:
        r3.append(r5);
        r3.append(' ');
        if (r1 == null) goto L11;
        ad9.b r7 = r1.g;
        if (r7 == null) goto L11;
        String r8 = r7.getItemId();
    L12:
        r3.append(r8);
        r2.i("acquirePlay", r3.toString());
        String r9 = com.larus.bmhome.music.player.f.c;
        StringBuilder r10 = new StringBuilder();
        if (r1 == null) goto L15;
        String r11 = r1.j();
    L16:
        r10.append(r11);
        if (r1 == null) goto L21;
        ad9.b r12 = r1.g;
        if (r12 == null) goto L21;
        r4 = r12.getItemId();
    L21:
        r10.append(r4);
        if (Intrinsics.areEqual(r9, r10.toString()) == true) goto L26;
        H(false);
        return;
    L26:
        if (r6 < 98.0f) goto L28;
        H(false);
        return;
    L28:
        float r13 = RangesKt.coerceAtLeast(r6, 3.0f);
        mP((int) r13, false);
        Pe(r13, true);
        return;
    L15:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a
    public final void d(com.larus.bmhome.music.player.j r21) {
        Intrinsics.checkNotNullParameter(r21, "musicPlayerData");
        boolean r8 = false;
        this.p = false;
        String r1 = r21.c;
        this.x = r1;
        Lazy r2 = com.larus.bmhome.music.player.i.a;
        String r9 = null;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L18;
        IVideoController r4 = this.w;
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L49;
        String r6 = this.x;
        Intrinsics.checkNotNull(r6);
        this.w = com.larus.bmhome.music.player.i.b(r6);
    L49:
        FLogger r7 = FLogger.a;
        r7.i("SimpleMusicPlayerViewImpl", "[bindData] musicPlayerData:" + r21 + "  mData is " + this.c);
        if (TextUtils.isEmpty(r21.p()) == false) goto L53;
        this.a.FK();
        return;
    L53:
        boolean r10 = StreamingMusicPlayer.n;
        com.larus.bmhome.music.player.j r11 = this.c;
        if (r11 == null) goto L57;
        String r12 = r11.f();
        if (r12 == null) goto L57;
    L58:
        Message r13 = r21.j;
        if (r13 == null) goto L61;
        Boolean r14 = Boolean.valueOf(r13.isNewBlockType());
    L62:
        Intrinsics.checkNotNullParameter(r12, "detailChunkUrl");
        k r15 = StreamingMusicPlayer.p;
        if (r15 == null) goto L65;
        String r16 = r15.b;
    L67:
        if (c0.a(r12, r16, r14) == false) goto L83;
        k r17 = StreamingMusicPlayer.p;
        if (r17 != null) goto L71;
    L73:
        boolean r18 = false;
    L74:
        if (r18 == false) goto L83;
        if (r17 == null) goto L77;
        k r19 = k.a(r17, null, null, 0.0f, 0.0f, false, false, 0, 143);
    L78:
        StreamingMusicPlayer.p = r19;
        StringBuilder r20 = new StringBuilder("update playing state cache 552 ");
        k r22 = StreamingMusicPlayer.p;
        if (r22 == null) goto L81;
        Boolean r23 = Boolean.valueOf(r22.e);
    L82:
        r20.append(r23);
        r20.append(' ');
        r20.append(StreamingMusicPlayer.p);
        r20.append(' ');
        r7.i("StreamingMusicPlayer", r20.toString());
    L84:
        if (r17 == null) goto L86;
        int r24 = r17.g;
    L87:
        this.q = r24;
        if (r17 == null) goto L90;
        float r25 = r17.c;
    L91:
        com.larus.bmhome.music.player.j r26 = this.c;
        if (r26 == null) goto L94;
        String r27 = r26.o();
    L95:
        boolean r28 = Intrinsics.areEqual(r27, r21.o());
        this.c = r21;
        GlobalScope r29 = r21.a;
        if (r29 != null) goto L98;
        r29 = GlobalScope.INSTANCE;
    L98:
        GlobalScope r110 = r29;
        int r30 = this.q;
        if (r30 <= 0) goto L101;
        b((r30 * 100.0f) / r25);
    L101:
        if (r28 == true) goto L103;
        this.g = null;
    L120:
        BuildersKt.launch$default(r110, kr8.t.a, null, new VideoEngineMusicPlayerViewImpl$bindData$1(this, r21, r28, r110, null), 2, null);
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 != null) goto L123;
    L125:
        if (r8 == false) goto L145;
        com.larus.platform.service.o r31 = com.larus.platform.service.o.a;
        JSONObject r32 = new JSONObject();
        com.larus.bmhome.music.player.j r33 = this.c;
        if (r33 == null) goto L129;
        String r34 = r33.d();
    L130:
        r32.put("bot_id", r34);
        r32.put("song_id", w());
        r32.put(MusicAppletPage.KEY_MESSAGE_ID, t());
        com.larus.bmhome.music.player.j r35 = this.c;
        if (r35 == null) goto L134;
        String r36 = r35.g();
        if (r36 == null) goto L134;
    L135:
        r32.put(MusicAppletPage.KEY_CONVERSATION_ID, r36);
        com.larus.bmhome.music.player.j r37 = this.c;
        if (r37 == null) goto L138;
        r9 = r37.k();
    L138:
        r32.put("show_from", r9);
        Unit r38 = Unit.INSTANCE;
        r31.reportEvent("music_card_show", r32);
        return;
    L134:
        r36 = "";
        goto L135
    L129:
        r34 = null;
        goto L130
    L145:
        return;
    L123:
        if (r0.f != true) goto L125;
        r8 = true;
        goto L125
    L103:
        if (D() == true) goto L105;
    L107:
        Lr();
        H(false);
        IVideoController.PlayType r39 = IVideoController.PlayType.PLAY;
    L108:
        this.y = r39;
        IVideoController r40 = this.w;
        if (r40 == null) goto L111;
        int r41 = r40.getCurrentPlaybackTime();
    L112:
        IVideoController r42 = this.w;
        if (r42 == null) goto L115;
        int r43 = r42.n();
    L116:
        if (r43 != 0) goto L118;
        return;
    L118:
        b((r41 * 100.0f) / r43);
        goto L120
    L115:
        r43 = 100;
        goto L116
    L111:
        r41 = 0;
        goto L112
    L105:
        if (E() == false) goto L107;
        A();
        C();
        L();
        com.larus.bmhome.music.player.f r44 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.f.d(this.c, this);
        r39 = IVideoController.PlayType.PAUSE;
        goto L108
    L94:
        r27 = null;
        goto L95
    L90:
        r25 = 60000.0f;
        goto L91
    L86:
        r24 = 0;
        goto L87
    L81:
        r23 = null;
        goto L82
    L77:
        r19 = null;
        goto L78
    L71:
        if (r17.f != true) goto L73;
        r18 = true;
    L83:
        r17 = null;
        goto L84
    L65:
        r16 = null;
        goto L67
    L61:
        r14 = null;
    L57:
        r12 = "";
        goto L58
    L12:
        if (r4.isReleased() == true) goto L14;
        r5 = true;
        goto L15
    L18:
        IVideoController r45 = this.w;
        if (r45 != null) goto L21;
    L26:
        String r46 = this.x;
        if (r46 == null) goto L30;
        IVideoController r47 = com.larus.bmhome.music.player.i.b(r46);
        if (r47 == null) goto L30;
    L48:
        this.w = r47;
    L30:
        Context r48 = this.a.getViewContext();
        Intrinsics.checkNotNullParameter(r48, "context");
        String r49 = r48.toString();
        Ref.ObjectRef r50 = new Ref.ObjectRef();
        Object r51 = com.larus.bmhome.music.player.i.c().get(r49);
        r50.element = r51;
        if (r51 != null) goto L33;
    L34:
        ConcurrentHashMap r52 = com.larus.bmhome.music.player.i.c();
        monitor-enter(r52);
        Object r53 = com.larus.bmhome.music.player.i.c().get(r49);     // Catch: Throwable -> L140
        r50.element = r53;     // Catch: Throwable -> L140
        if (r53 != null) goto L45;
        com.larus.video.impl.sdk.o r54 = q3.b("", null, 6);     // Catch: Throwable -> L140
        if (r54 == null) goto L41;
        r54.I(true);     // Catch: Throwable -> L140
    L42:
        r50.element = r54;     // Catch: Throwable -> L140
        if (r54 == null) goto L45;
        com.larus.bmhome.music.player.i.c().put(r49, r54);     // Catch: Throwable -> L140
        goto L45
    L41:
        r54 = null;
    L45:
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L140
        monitor-exit(r52);
    L47:
        r47 = (IVideoController) r50.element;
    L140:
        th = move-exception;
        throw th;
    L33:
        if (((IVideoController) r51).isReleased() == false) goto L47;
    L21:
        if (r45.isReleased() != true) goto L23;
        boolean r56 = true;
    L24:
        if (r56 == false) goto L26;
    L23:
        r56 = false;
        goto L24
    L5:
        if (StringsKt.startsWith$default(r1, "music_applet:", false, 2, null) != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.bmhome.music.player.a
    public final void e(com.larus.bmhome.music.player.j r3) {
        Intrinsics.checkNotNullParameter(r3, "musicPlayerData");
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[appendData] chatMessageId:" + t() + ", vid:" + x() + ", status:" + this.y);
    }

    @Override // com.larus.bmhome.music.player.a
    public final void h(boolean r4) {
        FLogger.a.i("SimpleMusicPlayerViewImpl", "[parentClick]  compatResume " + r4);
        z(false, r4, true);
    }

    @Override // com.larus.bmhome.music.player.a
    public final void k(boolean r4) {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[pause] abandonMedia:" + r4 + ", chatMessageId: " + t() + ", vid:" + x());
        if (r4 == false) goto L5;
        l();
    L5:
        A();
        N();
        Lr();
        IVideoController r5 = this.w;
        if (r5 == null) goto L8;
        r5.b();
    L8:
        this.y = IVideoController.PlayType.PLAY;
    }

    public final int q(VideoEngineState r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IVideoController r0 = this.w;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.G(r2);
    }

    @Override // com.larus.bmhome.music.player.a
    public final void seekTo(int r4) {
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[seekTo] millisecond: " + r4 + ' ');
        IVideoController r0 = this.w;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.p3() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        IVideoController r1 = this.w;
        if (r1 == null) goto L14;
        r1.A(r4, null);
        return;
    L14:
        return;
    L12:
        F(this, r4, false, 2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public VideoEngineMusicPlayerViewImpl(com.larus.bmhome.music.player.a.InterfaceC0021a r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "playerView");
        this.a = r17;
        this.b = r18;
        this.d = 1.0f;
        this.j = new com.larus.bmhome.music.repo.a();
        this.r = 0;
        this.s = System.currentTimeMillis();
        this.u = GlobalAudioStateEnum.STOPPED;
        this.v = new b(this);
        this.y = IVideoController.PlayType.PLAY;
        this.z = new h(this);
        j r14 = new j(this);
        this.C = r14;
        String r4 = v();
        int r12 = MediaLevel.PLAY_HIGH.getValue();
        this.D = new com.larus.media.model.a(null, r4, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), r12, false, r14, 1197);
        this.E = new g(this);
        this.F = new i(this);
        this.G = 1000;
        this.H = System.currentTimeMillis();
    }

    public static final void m(VideoEngineMusicPlayerViewImpl r6, Runnable r7) {
        BuildersKt.launch$default(r6.getScope(), Dispatchers.getMain(), null, new VideoEngineMusicPlayerViewImpl$runOnUI$1(r7, null), 2, null);
    }

    public static final void n(VideoEngineMusicPlayerViewImpl r3, GlobalAudioStateEnum r4) {
        if (r3.u != r4) goto L5;
        boolean r0 = true;
    L6:
        r3.u = r4;
        if (r0 == true) goto L9;
        GlobalAudioObserver.a.c("music", r4, r3.u());
    L9:
        e78.c r5 = r3.v;
        if ((r5 instanceof StreamingMusicPlayer.b) == false) goto L12;
        StreamingMusicPlayer.b r6 = (StreamingMusicPlayer.b) r5;
    L13:
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r4, "state");
        r6.b = r4;
        return;
    L16:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void K(int r11, boolean r12) {
        FLogger r0 = FLogger.a;
        r0.i("SimpleMusicPlayerViewImpl", "[resetViewModelAndPlay] toDuration: " + r11 + ", retainedDuration: " + this.q + ", byResume: " + r12 + ", chatMessageId:" + t());
        if (r11 == 0) goto L5;
    L8:
        this.k = r11;
    L10:
        if (r11 != 0) goto L12;
        this.k = this.q;
        this.q = 0;
    L12:
        L();
        boolean r3 = true;
        AudioServiceDelegate.a.i0().cancel("PlayMusic", true);
        if (D() == false) goto L21;
        IVideoController r13 = this.w;
        if (r13 != null) goto L17;
    L19:
        r3 = false;
    L20:
        if (r3 == true) goto L21;
    L57:
        r0.i("SimpleMusicPlayerViewImpl", "[resetViewModelAndPlay] call play");
        IVideoController r14 = this.w;
        if (r14 == null) goto L60;
        r14.E(x() + t());
    L60:
        IVideoController r15 = this.w;
        if (r15 == null) goto L63;
        r15.k(s());
    L63:
        C();
        IVideoController r16 = this.w;
        if (r16 == null) goto L66;
        r16.c(this.d);
    L66:
        IVideoController r17 = this.w;
        if (r17 == null) goto L69;
        r17.play();
    L69:
        IAIChatUgcAIGCService.a.b0().a();
        return;
    L17:
        if (r13.z() != true) goto L19;
    L21:
        com.larus.platform.api.p0 r18 = this.g;
        if (r18 == null) goto L57;
        r0.i("SimpleMusicPlayerViewImpl", "[resetViewModelAndPlay] set video model");
        IVideoController r1 = this.w;
        if (r1 == null) goto L26;
        r1.j(r18, false);
    L26:
        IVideoController r19 = this.w;
        if (r19 == null) goto L57;
        String r4 = this.v.getScene();
        com.larus.bmhome.music.player.j r2 = this.c;
        if (r2 == null) goto L34;
        String r5 = r2.n();
        if (r5 == null) goto L34;
        String r6 = r5;
    L35:
        com.larus.bmhome.music.player.j r7 = this.c;
        if (r7 == null) goto L41;
        String r8 = r7.j();
        if (r8 == null) goto L41;
        String r9 = r8;
    L42:
        com.larus.bmhome.music.player.j r10 = this.c;
        if (r10 == null) goto L48;
        String r20 = r10.g();
        if (r20 == null) goto L48;
        String r21 = r20;
    L49:
        com.larus.bmhome.music.player.j r22 = this.c;
        if (r22 == null) goto L55;
        String r23 = r22.j();
        if (r23 == null) goto L55;
        String r24 = r23;
    L56:
        r19.h(new k4(r4, r6, "", r9, r21, r24));
    L55:
        r24 = "";
    L48:
        r21 = "";
    L41:
        r9 = "";
    L34:
        r6 = "";
        goto L35
    L5:
        if (this.q != 0) goto L8;
        if (r12 == true) goto L8;
        I();
        goto L10
    }

    @Override // com.larus.bmhome.music.player.a
    public final void f(boolean r2, boolean r3) {
        com.larus.bmhome.music.player.j r0 = this.c;
        if (r0 == null) goto L5;
        r0.h = r2;
    L5:
        if (r0 == null) goto L8;
        r0.i = r3;
        return;
    }

    @Override // com.larus.bmhome.music.player.a
    public final int j(String r9, Function1<? super Integer, Unit> r10) {
        int r1 = 30000;
        if (D() == false) goto L20;
        IVideoController r11 = this.w;
        if (r11 == null) goto L7;
        Integer r12 = Integer.valueOf(r11.n());
    L9:
        if (this.s <= (System.currentTimeMillis() - ((long) 500))) goto L15;
        Integer r13 = this.r;
        if (r13 == null) goto L14;
        r1 = r13.intValue();
    L14:
        return r1 / GuidePriority.COMMERCE_CREDIT_PRIORITY;
    L15:
        this.r = r12;
        if (r12 == null) goto L19;
        r1 = r12.intValue();
    L19:
        return r1 / GuidePriority.COMMERCE_CREDIT_PRIORITY;
    L7:
        r12 = null;
        goto L9
    L20:
        if (r10 == null) goto L25;
        if (r9 == null) goto L25;
        IVideoController r0 = this.w;
        if (r0 == null) goto L25;
        r0.f(r9, new f(this, r10));
    L25:
        Integer r14 = this.r;
        if (r14 == null) goto L29;
        r1 = r14.intValue();
    L29:
        return r1 / GuidePriority.COMMERCE_CREDIT_PRIORITY;
    }

    public final void z(final boolean r24, final boolean r25, boolean r26) {
        FLogger r2 = FLogger.a;
        r2.i("SimpleMusicPlayerViewImpl", "[handleClickOrAutoPlay] " + com.larus.bmhome.music.player.f.e + " status " + this.y + " video model " + y());
        if (r24 == true) goto L5;
    L7:
        int r5 = 0;
        if (D() == false) goto L10;
    L16:
        com.larus.bmhome.music.player.f r3 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.f.a(this.c, this);
        String r4 = y();
        if (r4 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L29;
        if (r24 == true) goto L27;
        if (r26 == false) goto L27;
        t19.s r1 = t19.s.a;
        Context r7 = getViewContext();
        r1.getClass();
        t19.s.b(r7, 2131905568, false);
    L27:
        G(30038);
        return;
    L29:
        p();
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = true;
        IVideoController.PlayType r9 = this.y;
        if (r9 != null) goto L32;
        int r10 = -1;
    L33:
        if (r10 != 1) goto L35;
        r2.i("SimpleMusicPlayerViewImpl", "[handleClickOrAutoPlay] request media, mediaScene: " + v() + ", before mediaApplicant: " + this.D);
        if (r24 == true) goto L46;
        this.l = true;
    L46:
        if (Intrinsics.areEqual(this.D.b, v()) == true) goto L52;
        com.larus.bmhome.music.player.j r11 = this.c;
        if (r11 == null) goto L50;
        String r12 = r11.o();
    L51:
        this.D = new com.larus.media.model.a(r12, v(), false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), MediaLevel.PLAY_HIGH.getValue(), false, this.C, 1196);
        goto L52
    L50:
        r12 = null;
    L52:
        r2.i("SimpleMusicPlayerViewImpl", "[handleClickOrAutoPlay] request media, mediaScene: " + v() + ", after mediaApplicant: " + this.D);
        Lazy r13 = MediaResourceManager.a;
        MediaResourceManager.m(this.D, new d0(this, r8, r25, r24), new e0(this, r8), 0, 8);
    L53:
        if (r24 == true) goto L74;
        com.larus.bmhome.music.player.j r14 = this.c;
        if (r14 == null) goto L60;
        if (r14.f != true) goto L60;
        boolean r15 = true;
    L61:
        if (r15 == false) goto L75;
        com.larus.platform.service.o r16 = com.larus.platform.service.o.a;
        JSONObject r17 = new JSONObject();
        if (this.y == IVideoController.PlayType.PLAY) goto L66;
        r5 = 1;
    L66:
        r17.put("to_status", r5);
        r17.put("bot_id", s());
        r17.put("song_id", w());
        r17.put(MusicAppletPage.KEY_MESSAGE_ID, t());
        com.larus.bmhome.music.player.j r18 = this.c;
        if (r18 == null) goto L70;
        String r19 = r18.g();
        if (r19 == null) goto L70;
    L71:
        r17.put(MusicAppletPage.KEY_CONVERSATION_ID, r19);
        Unit r20 = Unit.INSTANCE;
        r16.reportEvent("music_card_click", r17);
        return;
    L70:
        r19 = "";
        goto L71
    L75:
        return;
    L60:
        r15 = false;
        goto L61
    L74:
        return;
    L35:
        if (r10 == 2) goto L39;
        if (r24 == true) goto L38;
        this.m = true;
    L38:
        k(true);
        goto L53
    L39:
        if (r24 == true) goto L41;
        this.m = true;
    L41:
        k(true);
        goto L53
    L32:
        r10 = e.a[r9.ordinal()];
        goto L33
    L19:
        if (r4.length() == 0) goto L22;
        r6 = false;
        goto L23
    L10:
        if (this.y != IVideoController.PlayType.PLAY) goto L16;
        if (NetworkUtils.isNetworkAvailable(getViewContext()) == true) goto L16;
        if (r26 == false) goto L73;
        t19.s r21 = t19.s.a;
        Context r22 = getViewContext();
        r21.getClass();
        t19.s.b(r22, 2131906741, false);
        return;
    L73:
        return;
    L5:
        if (com.larus.bmhome.music.player.f.e == false) goto L7;
    }

    public static void F(VideoEngineMusicPlayerViewImpl r6, int r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r7 = 0;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r8 = false;
    L8:
        com.larus.bmhome.music.player.j r10 = r6.c;
        if (r10 == null) goto L14;
        CoroutineScope r0 = r10.a;
        if (r0 == null) goto L15;
        BuildersKt.launch$default(r0, null, null, new VideoEngineMusicPlayerViewImpl$play$1(r6, r7, r8, null), 3, null);
        return;
    L15:
        return;
    }
}
