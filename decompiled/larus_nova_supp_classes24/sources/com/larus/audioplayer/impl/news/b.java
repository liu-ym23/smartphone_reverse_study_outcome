package com.larus.audioplayer.impl.news;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k4;
import com.larus.platform.api.n0;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoService;
import f88.a0;
import f88.b0;
import f88.p;
import f88.q;
import f88.r;
import f88.s;
import f88.y;
import f88.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;
import org.json.JSONObject;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int B = 0;
    public float A;
    public final String a;
    public final int b;
    public final String c;
    public final b88.a d;
    public final JSONObject e;
    public final e78.c f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final Function1<String, Unit> l;
    public final IVideoController m;
    public final c n;
    public boolean o;
    public String p;
    public volatile boolean q;
    public int r;
    public int s;
    public volatile boolean t;
    public boolean u;
    public Long v;
    public Long w;
    public Long x;
    public final ArrayList<Function0<Unit>> y;
    public InterfaceC0090b z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.news.b$b, reason: collision with other inner class name */
    public interface InterfaceC0090b {
        void a(String r1, b r2, int r3);

        void b(String r1, b r2, int r3);

        void l(String r1, b r2);
    }

    public final class c implements n0 {
        public UrlAudioPlayStatus a;
        public boolean b;
        public final com.larus.media.model.a c;
        public final Object d;
        public int e;
        public final /* synthetic */ b f;

        public static final class a implements v {
            public String a;
            public boolean b;
            public boolean c;
            public ValueAnimator d;
            public final /* synthetic */ b e;

            /* JADX INFO: renamed from: com.larus.audioplayer.impl.news.b$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0091a {
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

            public a(b r1) {
                this.e = r1;
            }

            public final boolean b(g r2) {
                Intrinsics.checkNotNullParameter(r2, "applicant");
                Map r0 = o0.a;
                return o0.a(this.e.g, r2.getScene());
            }

            public final void e(final g r4) {
                Intrinsics.checkNotNullParameter(r4, "applicant");
                v.a.d(r4);
                this.b = false;
                Handler r0 = new Handler(Looper.getMainLooper());
                final b r1 = this.e;
                r0.post(new a0(this, r1, r4));
            }

            public final void f(MediaResourceManager.a r6) {
                Intrinsics.checkNotNullParameter(r6, "event");
                Intrinsics.checkNotNullParameter(r6, "event");
                if (o.a() == false) goto L23;
                MediaResourceManager.FlowAudioBroadcastEvent r0 = r6.c;
                if (r0 != null) goto L7;
                int r1 = -1;
            L9:
                if (r1 != 1) goto L11;
                FLogger.a.i("UrlAudioPlayer", "event asrWaitReplyBegin , msgId: " + r6.b);
                this.c = true;
                return;
            L11:
                if (r1 == 2) goto L13;
                FLogger.a.i("UrlAudioPlayer", "else  msgId: " + r6.b);
                this.c = false;
                return;
            L13:
                int r2 = r6.a;
                if (r2 == 4) goto L18;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L18;
                return;
            L18:
                FLogger.a.i("UrlAudioPlayer", "event asrWaitReplyEnd , msgId: " + r6.b);
                if (this.c == false) goto L26;
                this.c = false;
                Handler r7 = new Handler(Looper.getMainLooper());
                final b r3 = this.e;
                r7.post(new z(this, r3));
                return;
            L26:
                return;
            L7:
                r1 = C0091a.a[r0.ordinal()];
                goto L9
            }

            public final void a(final g r9, final float r10) {
                Intrinsics.checkNotNullParameter(r9, "applicant");
                v.a.f(r9, r10);
                String r0 = this.a;
                if (r0 != null) goto L5;
                r0 = "";
            L5:
                final String r6 = r0;
                this.a = null;
                this.e.m.c(r10);
                this.e.A = r10;
                if (this.b == false) goto L11;
                this.b = false;
                if (this.c == true) goto L12;
                Handler r1 = new Handler(Looper.getMainLooper());
                final b r5 = this.e;
                r1.post(new b0(this, r10, r9, r5, r6));
                return;
            L12:
                return;
            }

            public final void d(g r1, g r2) {
                v.a.c(r1, r2);
            }

            public final void g(g r4, final float r5) {
                Intrinsics.checkNotNullParameter(r4, "applicant");
                v.a.g(r4, r5);
                FLogger.a.i("UrlAudioPlayer", "audio focus onMediaVolumeChange. applicant:" + r4 + ", volumeFactor: " + r5 + ", audioUrl: " + this.e.a + '.');
                this.e.A = r5;
                Handler r6 = new Handler(Looper.getMainLooper());
                final b r0 = this.e;
                r6.post(new s(this, r0, r5));
            }

            public final void i(g r3, final g r4) {
                Intrinsics.checkNotNullParameter(r3, "current");
                Intrinsics.checkNotNullParameter(r4, "applicant");
                v.a.e(r3, r4);
                this.b = true;
                Handler r5 = new Handler(Looper.getMainLooper());
                final b r0 = this.e;
                r5.postAtFrontOfQueue(new y(this, r0, r4));
                this.a = r4.getScene();
            }

            public final MediaOccupyStrategy c(g r1, g r2, int r3) {
                return v.a.a(this, r1, r2, r3);
            }

            public final MediaOccupyStrategy h(g r1, g r2, int r3) {
                Intrinsics.checkNotNullParameter(r1, "current");
                Intrinsics.checkNotNullParameter(r2, "applicant");
                Map r4 = o0.a;
                return o0.b(this.e.g, r2.getScene());
            }
        }

        public final void b(Integer r1, Integer r2) {
        }

        public final void onPrepared() {
        }

        public final void onRenderStart() {
        }

        public final void e() {
            FLogger.a.i("UrlAudioPlayer", "abandon audio focus actively, audioUrl: " + this.f.a);
            Lazy r0 = MediaResourceManager.a;
            MediaResourceManager.a(this.c);
        }

        public final void h() {
            UrlAudioPlayStatus r0 = UrlAudioPlayStatus.ERROR;
            this.a = r0;
            b r1 = this.f;
            b88.a r2 = r1.d;
            if (r2 == null) goto L6;
            r2.d(r1.a, r1.c, r1.b, r0);
            return;
        }

        public final void onCompletion() {
            i1.a(this.f.a(), this.f.a);
            b r0 = this.f;
            b88.a r1 = r0.d;
            if (r1 == null) goto L5;
            r1.d(r0.a, r0.c, r0.b, UrlAudioPlayStatus.FINISH);
        L5:
            FLogger.a.i("UrlAudioPlayer", "callback onPrepare, audioUrl: " + this.f.a);
        }

        public final void onPrepare() {
            UrlAudioPlayStatus r0 = this.a;
            if (r0 != UrlAudioPlayStatus.PLAYING) goto L5;
            return;
        L5:
            UrlAudioPlayStatus r1 = UrlAudioPlayStatus.PREPARE;
            if (r0 != r1) goto L8;
            return;
        L8:
            this.a = r1;
            b r2 = this.f;
            b88.a r3 = r2.d;
            if (r3 == null) goto L11;
            r3.d(r2.a, r2.c, r2.b, r1);
        L11:
            FLogger.a.i("UrlAudioPlayer", "callback onPrepare, audioUrl: " + this.f.a);
        }

        public c(b r19) {
            this.f = r19;
            this.a = UrlAudioPlayStatus.STOPPED;
            this.c = new com.larus.media.model.a(null, r19.g, false, 0, 2, false, 0, false, false, 0, false, new a(r19), 2029);
            this.d = new Object();
        }

        public final void c(int r2) {
            Object r0 = this.d;
            monitor-enter(r0);
            i(r2);     // Catch: Throwable -> L7
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final void d(int r5) {
            i1.f(this.f.a(), this.f.a, r5);
            if (r5 == 1) goto L9;
            if (r5 != 3) goto L11;
            FLogger.a.e("UrlAudioPlayer", "load_state_error: " + this.f.a);
            h();
        L11:
            b r1 = this.f;
            InterfaceC0090b r2 = r1.z;
            if (r2 == null) goto L14;
            r2.a(r1.a, r1, r5);
        L14:
            FLogger.a.i("UrlAudioPlayer", "callback onLoadStateChanged, loadState: " + r5 + ", audioUrl: " + this.f.a);
            return;
        L9:
            if (this.a == UrlAudioPlayStatus.PLAYING) goto L11;
            c(1);
            goto L11
        }

        public final void i(int r13) {
            b r0 = this.f;
            int r3 = r0.s;
            if (r13 != 3) goto L7;
            h();
            this.f.s = r13;
            g(this, r13, r3, null, 28);
            return;
        L7:
            if (r13 == 0) goto L39;
            if (r13 != 1) goto L10;
            UrlAudioPlayStatus r2 = this.a;
            UrlAudioPlayStatus r9 = UrlAudioPlayStatus.PLAYING;
            if (r2 != r9) goto L26;
            return;
        L26:
            boolean r1 = !r0.t;
            Long r4 = this.f.v;
            if (r4 == null) goto L29;
            Long r5 = Long.valueOf(System.currentTimeMillis() - r4.longValue());
        L30:
            b r6 = this.f;
            r6.v = null;
            r6.t = true;
            Boolean r7 = Boolean.valueOf(r1);
            if (r1 == false) goto L33;
            Boolean r8 = Boolean.valueOf(this.f.u);
        L34:
            f(r13, r3, r5, r7, r8);
            this.b = true;
            b r10 = this.f;
            r10.o = true;
            this.a = r9;
            r10.r = 3;
            InterfaceC0090b r11 = r10.z;
            if (r11 == null) goto L37;
            r11.b(r10.a, r10, 3);
        L37:
            UrlAudioPlayStatus r12 = this.a;
        L59:
            FLogger.a.i("UrlAudioPlayer", "callback onPlaybackStateChanged, playbackState: " + r13 + ", audioUrl: " + this.f.a);
            b r14 = this.f;
            r14.s = r13;
            b88.a r15 = r14.d;
            if (r15 == null) goto L64;
            r15.d(r14.a, r14.c, r14.b, r12);
            return;
        L64:
            return;
        L33:
            r8 = null;
            goto L34
        L29:
            r5 = null;
            goto L30
        L10:
            if (r13 == 2) goto L13;
            r0.o = false;
            r12 = UrlAudioPlayStatus.UNKNOWN;
            this.a = r12;
            goto L59
        L13:
            if (this.b == true) goto L15;
            return;
        L15:
            Long r16 = r0.w;
            if (r16 == null) goto L18;
            Long r17 = Long.valueOf(System.currentTimeMillis() - r16.longValue());
        L19:
            this.f.w = null;
            g(this, r13, r3, r17, 24);
            b r19 = this.f;
            r19.o = true;
            this.a = UrlAudioPlayStatus.PAUSED;
            r19.r = 2;
            InterfaceC0090b r20 = r19.z;
            if (r20 == null) goto L22;
            r20.b(r19.a, r19, 2);
        L22:
            r12 = this.a;
            goto L59
        L18:
            r17 = null;
            goto L19
        L39:
            if (this.b == true) goto L41;
            return;
        L41:
            Long r21 = r0.x;
            if (r21 == null) goto L44;
            Long r22 = Long.valueOf(System.currentTimeMillis() - r21.longValue());
        L45:
            this.f.x = null;
            g(this, r13, r3, r22, 24);
            this.f.o = false;
            e();
            this.a = UrlAudioPlayStatus.STOPPED;
            b r23 = this.f;
            r23.r = 1;
            InterfaceC0090b r24 = r23.z;
            if (r24 == null) goto L48;
            r24.b(r23.a, r23, 1);
        L48:
            b r25 = this.f;
            InterfaceC0090b r26 = r25.z;
            if (r26 == null) goto L51;
            r26.l(r25.a, r25);
        L51:
            b r27 = this.f;
            if (r27.y.isEmpty() == true) goto L58;
            ArrayList r29 = new ArrayList(r27.y);
            r27.y.clear();
            Iterator r30 = r29.iterator();
        L56:
            if (r30.hasNext() == false) goto L58;
            ((Function0) r30.next()).invoke();
        L58:
            r12 = this.a;
            goto L59
        L44:
            r22 = null;
            goto L45
        }

        public final void onVideoStatusException(int r4) {
            h();
            FLogger.a.e("UrlAudioPlayer", "callback onVideoStatusException, status " + r4 + ": " + this.f.a);
        }

        public final void a(Integer r8, Integer r9) {
            i1.e(this.f.a(), this.f.a, GlobalAudioErrorType.SDK, "sdk_error_code_" + r8, r8, 96);
            Lazy r0 = MediaResourceManager.a;
            MediaResourceManager.a(this.c);
            h();
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("callback onError, code ");
            Object r3 = "unknown";
            if (r8 != null) goto L5;
            Object r4 = "unknown";
        L6:
            r2.append(r4);
            r2.append(", internalCode ");
            if (r9 == null) goto L10;
            r3 = r9;
        L10:
            r2.append(r3);
            r2.append(": ");
            r2.append(this.f.a);
            r1.e("UrlAudioPlayer", r2.toString());
            b r5 = this.f;
            if (r5.j == false) goto L14;
            GlobalAudioObserver.a.f(r5.h, r8, r9);
            return;
        L14:
            return;
        L5:
            r4 = r8;
            goto L6
        }

        public static /* synthetic */ void g(c r6, int r7, int r8, Long r9, int r10) {
            if ((r10 & 4) == 0) goto L5;
            r9 = null;
        L5:
            r6.f(r7, r8, r9, null, null);
        }

        public final void f(int r9, int r10, Long r11, Boolean r12, Boolean r13) {
            if (r9 != this.e) goto L5;
            return;
        L5:
            this.e = r9;
            i1.i(this.f.a(), this.f.a, r9, r10, r11, r12, r13);
        }
    }

    static {
    }

    public final String a() {
        if (this.e.has("scene") == false) goto L6;
        return JSONObjectProtectorUtils.getString(this.e, "scene");
    L6:
        return "unknown";
    L11:
        return "unknown";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [f88.o, java.lang.Object] */
    public final synchronized void c(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "playReason");     // Catch: Throwable -> L19
        if (this.q == true) goto L7;
        boolean r1 = true;
    L8:
        this.q = true;     // Catch: Throwable -> L19
        if (this.r == 3) goto L12;
        this.v = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L19
        i1.h(a(), r7, this.a, r1, this.s);     // Catch: Throwable -> L19
    L12:
        if (this.k == true) goto L16;
        this.m.play();     // Catch: Throwable -> L19
        FLogger.a.i("UrlAudioPlayer", "start playing without requesting audio focus: " + this.a);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        c r8 = this.n;     // Catch: Throwable -> L19
        final ?? r0 = new f88.o(this);     // Catch: Throwable -> L19
        r8.getClass();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r0, "onSuccess");     // Catch: Throwable -> L19
        Lazy r2 = MediaResourceManager.a;     // Catch: Throwable -> L19
        com.larus.media.model.a r3 = r8.c;     // Catch: Throwable -> L19
        final b r9 = r8.f;     // Catch: Throwable -> L19
        final Function0 r4 = null;
        MediaResourceManager.m(r3, new q(r9, r0), new r(r9, r4), 0, 8);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L7:
        r1 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Function0<Unit> r5) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.r == 1) goto L8;
        this.x = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L19
        i1.j(a(), this.a, this.s);     // Catch: Throwable -> L19
    L8:
        if (this.o == true) goto L14;
        this.m.stop();     // Catch: Throwable -> L19
        if (r5 == null) goto L12;
        r5.invoke();     // Catch: Throwable -> L19
    L12:
        monitor-exit(this);
        return;
    L14:
        if (r5 == null) goto L16;
        this.y.add(r5);     // Catch: Throwable -> L19
    L16:
        this.m.stop();     // Catch: Throwable -> L19
        FLogger.a.i("UrlAudioPlayer", "stop playing: " + this.a);     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    public final synchronized void b(boolean r6, String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "pausedReason");     // Catch: Throwable -> L24
        UrlAudioPlayStatus r3 = this.n.a;     // Catch: Throwable -> L24
        if (r3 != UrlAudioPlayStatus.STOPPED) goto L10;
        FLogger.a.i("UrlAudioPlayer", "ignore pausing because stopped: " + this.a + ", pauseReason: " + r7);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (r3 == UrlAudioPlayStatus.PAUSED) goto L12;
        this.w = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L24
        i1.g(a(), r7, this.a, this.s);     // Catch: Throwable -> L24
        this.p = r7;     // Catch: Throwable -> L24
        if (r6 == true) goto L21;
        this.n.e();     // Catch: Throwable -> L24
    L21:
        this.m.b();     // Catch: Throwable -> L24
        FLogger.a.i("UrlAudioPlayer", "pause playing: " + this.a + ", reason: " + r7);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L12:
        if (Intrinsics.areEqual(r7, "default") == false) goto L16;
        FLogger.a.i("UrlAudioPlayer", "only do prepare pausing: " + this.a + ", newReason: " + r7 + ", oldReason: " + this.p);     // Catch: Throwable -> L24
        this.p = r7;     // Catch: Throwable -> L24
        if (r6 == true) goto L16;
        this.n.e();     // Catch: Throwable -> L24
    L16:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public b(String r17, int r19, com.larus.video.impl.sdk.a r110, String r20, b88.a r21, k4 r22, JSONObject r23, com.larus.audioplayer.impl.news.a.b r24, JSONObject r25, String r26, String r27, boolean r29, boolean r210, boolean r30, Function1 r31, int r32) {
        if ((r32 & 4) == 0) goto L5;
        com.larus.video.impl.sdk.a r5 = null;
    L7:
        if ((r32 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r32 & 16) == 0) goto L13;
        b88.a r7 = null;
    L15:
        if ((r32 & 64) == 0) goto L17;
        JSONObject r8 = new JSONObject();
    L19:
        if ((r32 & 128) == 0) goto L21;
        com.larus.audioplayer.impl.news.a.b r9 = null;
    L23:
        if ((r32 & 256) == 0) goto L25;
        JSONObject r10 = null;
    L27:
        if ((r32 & 512) == 0) goto L29;
        String r11 = "NEWS";
    L31:
        if ((r32 & 1024) == 0) goto L33;
        String r12 = GlobalAudioSceneEnum.PLUGIN_AUDIO;
    L35:
        if ((r32 & 2048) == 0) goto L37;
        boolean r13 = true;
    L39:
        if ((r32 & 4096) == 0) goto L41;
        boolean r14 = true;
    L43:
        if ((r32 & 8192) == 0) goto L45;
        boolean r15 = true;
    L47:
        if ((r32 & 16384) == 0) goto L49;
        Function1 r4 = null;
    L50:
        com.larus.video.impl.sdk.a r111 = r5;
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r22, "mediaScene");
        Intrinsics.checkNotNullParameter(r8, "traceInfo");
        Intrinsics.checkNotNullParameter(r11, "focusScene");
        Intrinsics.checkNotNullParameter(r12, "globalAudioScene");
        this.a = r17;
        this.b = r19;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r4;
        c r16 = new c(this);
        this.n = r16;
        this.r = 1;
        this.y = new ArrayList();
        this.A = 1.0f;
        IVideoController r33 = VideoService.a.f("url_audio_play_engine", null);
        r33.h(r22);
        r33.p(r16);
        if (r19 != SOURCE_TYPE.LOCAL_FILE.getValue()) goto L53;
        r33.setLocalURL(r17);
    L54:
        if (r10 == null) goto L59;
        JSONObject r3 = r10.optJSONObject("volume");
        if (r3 == null) goto L59;
        r33.B((float) r3.optDouble("loudness"), (float) r3.optDouble("peak"));
    L59:
        if (r19 != SOURCE_TYPE.URL.getValue()) goto L62;
        r33.setDirectUrlUseDataLoader(r17, d88.a.a(r17));
    L65:
        r33.s(new p(this));
        this.m = r33;
        return;
    L62:
        if (r19 != SOURCE_TYPE.VIDEO_MODEL.getValue()) goto L65;
        if (r111 == null) goto L65;
        r33.j(r111, false);
        goto L65
    L53:
        r33.setDirectUrlUseDataLoader(r17, d88.a.a(r17));
        goto L54
    L49:
        r4 = r31;
        goto L50
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r210;
        goto L43
    L37:
        r13 = r29;
        goto L39
    L33:
        r12 = r27;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r5 = r110;
        goto L7
    }
}
