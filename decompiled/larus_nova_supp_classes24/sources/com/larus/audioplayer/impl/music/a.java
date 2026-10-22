package com.larus.audioplayer.impl.music;

import a88.e;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k4;
import com.larus.platform.api.n0;
import com.larus.platform.api.w0;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoService;
import e88.d;
import e88.f;
import e88.g;
import e88.t;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements w0 {
    public static final /* synthetic */ int A = 0;
    public final e a;
    public final e78.c b;
    public boolean c;
    public boolean d;
    public volatile boolean e;
    public final IVideoController f;
    public volatile int g;
    public boolean h;
    public float i;
    public volatile boolean j;
    public String k;
    public String l;
    public e88.b m;
    public final ArrayList<Function0<Unit>> n;
    public a88.c o;
    public b p;
    public boolean q;
    public volatile boolean r;
    public volatile boolean s;
    public boolean t;
    public Long u;
    public Long v;
    public Long w;
    public final com.larus.media.model.a x;
    public final com.larus.media.model.a y;
    public com.larus.media.model.a z;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.music.a$a, reason: collision with other inner class name */
    public static final class C0088a {
    }

    public interface b {
        void a(e r1, a r2);

        void b(e r1, a r2, int r3);
    }

    public final class c implements n0 {
        public final Object a;
        public int b;
        public final /* synthetic */ a c;

        public final void b(Integer r1, Integer r2) {
        }

        public final void onPrepared() {
        }

        public final void onRenderStart() {
        }

        public final void onCompletion() {
            if (h("onCompletion") == false) goto L5;
            return;
        L5:
            e r0 = this.c.a;
            i1.a(r0.m, r0.a);
            FLogger.a.i("MusicPlayEngine", "callback onCompletion, musicId:" + this.c.a.a);
            a r1 = this.c;
            a88.c r2 = r1.o;
            if (r2 == null) goto L9;
            r2.f(r1.a.a);
            return;
        }

        public final void onPrepare() {
            if (h("onPrepare") == false) goto L6;
            return;
        L6:
            if (this.c.g != 1) goto L8;
            return;
        L8:
            FLogger.a.i("MusicPlayEngine", "callback onPrepare, musicId:" + this.c.a.a);
            a r0 = this.c;
            a88.c r1 = r0.o;
            if (r1 == null) goto L12;
            r1.d(r0.a.a);
            return;
        }

        public c(a r1) {
            this.c = r1;
            this.a = new Object();
        }

        public final void c(int r2) {
            if (h("onPlaybackStateChanged") == false) goto L5;
            return;
        L5:
            Object r0 = this.a;
            monitor-enter(r0);
            g(r2);     // Catch: Throwable -> L10
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final void d(int r5) {
            if (h("onLoadStateChanged") == false) goto L5;
            return;
        L5:
            e r0 = this.c.a;
            i1.f(r0.m, r0.a, r5);
            if (r5 != 3) goto L8;
            FLogger.a.e("MusicPlayEngine", "load_state_error. musicId:" + this.c.a.a + ", video_model:" + this.c.a.b);
        L8:
            FLogger.a.i("MusicPlayEngine", "callback onLoadStateChanged, loadState: " + r5 + ", musicId:" + this.c.a.a);
            a r1 = this.c;
            a88.c r2 = r1.o;
            if (r2 == null) goto L12;
            r2.i(r1.a.a, r5);
            return;
        }

        public final void g(int r11) {
            int r3 = this.c.g;
            this.c.j = false;
            Boolean r0 = null;
            if (r11 != 3) goto L7;
            this.c.g = r11;
            f(this, r11, r3, null, 28);
            return;
        L7:
            if (r11 == 0) goto L29;
            if (r11 != 1) goto L10;
            a r1 = this.c;
            r1.h = true;
            boolean r2 = !r1.s;
            Long r4 = this.c.u;
            if (r4 == null) goto L22;
            Long r5 = Long.valueOf(System.currentTimeMillis() - r4.longValue());
        L23:
            a r6 = this.c;
            r6.u = null;
            r6.s = true;
            Boolean r7 = Boolean.valueOf(r2);
            if (r2 == false) goto L26;
            r0 = Boolean.valueOf(this.c.t);
        L26:
            e(r11, r3, r5, r7, r0);
            a r8 = this.c;
            b r9 = r8.p;
            if (r9 == null) goto L40;
            r9.b(r8.a, r8, 3);
        L40:
            this.c.g = r11;
            FLogger.a.i("MusicPlayEngine", "callback onPlaybackStateChanged, playbackState: " + r11 + ", musicId:" + this.c.a.a);
            a r10 = this.c;
            a88.c r12 = r10.o;
            if (r12 == null) goto L44;
            r12.g(r10.a.a, r11);
            return;
        L44:
            return;
        L22:
            r5 = null;
            goto L23
        L10:
            if (r11 != 2) goto L40;
            a r13 = this.c;
            r13.h = true;
            Long r14 = r13.v;
            if (r14 == null) goto L15;
            Long r15 = Long.valueOf(System.currentTimeMillis() - r14.longValue());
        L16:
            this.c.v = null;
            f(this, r11, r3, r15, 24);
            a r16 = this.c;
            b r17 = r16.p;
            if (r17 == null) goto L40;
            r17.b(r16.a, r16, 2);
            goto L40
        L15:
            r15 = null;
            goto L16
        L29:
            a r19 = this.c;
            r19.h = false;
            Long r20 = r19.w;
            if (r20 == null) goto L32;
            Long r21 = Long.valueOf(System.currentTimeMillis() - r20.longValue());
        L33:
            this.c.w = null;
            f(this, r11, r3, r21, 24);
            this.c.b();
            a r22 = this.c;
            b r23 = r22.p;
            if (r23 == null) goto L36;
            r23.b(r22.a, r22, 1);
        L36:
            a r24 = this.c;
            b r25 = r24.p;
            if (r25 == null) goto L39;
            r25.a(r24.a, r24);
        L39:
            this.c.e();
            goto L40
        L32:
            r21 = null;
            goto L33
        }

        public final boolean h(String r4) {
            if (this.c.e == true) goto L6;
            return false;
        L6:
            FLogger.a.i("MusicPlayEngine", "ignore " + r4 + " after background audio takeover, musicId:" + this.c.a.a);
            return true;
        }

        public final void onVideoStatusException(int r4) {
            if (h("onVideoStatusException") == false) goto L5;
            return;
        L5:
            FLogger.a.e("MusicPlayEngine", "callback onVideoStatusException, status " + r4 + ". musicId:" + this.c.a.a + ", video_model:" + this.c.a.b);
            a r5 = this.c;
            a88.c r0 = r5.o;
            if (r0 == null) goto L9;
            r0.h(r5.a.a);
            return;
        }

        public final void a(Integer r8, Integer r9) {
            if (h("onError") == false) goto L5;
            return;
        L5:
            e r0 = this.c.a;
            i1.e(r0.m, r0.a, GlobalAudioErrorType.SDK, "sdk_error_code_" + r8, r8, 96);
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("callback onError. code ");
            Object r3 = "unknown";
            if (r8 != null) goto L8;
            Object r4 = "unknown";
        L9:
            r2.append(r4);
            r2.append(", internalCode ");
            if (r9 == null) goto L13;
            r3 = r9;
        L13:
            r2.append(r3);
            r2.append(", musicId:");
            r2.append(this.c.a.a);
            r2.append(", video_model:");
            r2.append(this.c.a.b);
            r1.e("MusicPlayEngine", r2.toString());
            a r5 = this.c;
            a88.c r6 = r5.o;
            if (r6 == null) goto L16;
            r6.onError(r5.a.a);
        L16:
            GlobalAudioObserver.a.f(GlobalAudioSceneEnum.PLUGIN_MUSIC, r8, r9);
            return;
        L8:
            r4 = r8;
            goto L9
        }

        public static /* synthetic */ void f(c r6, int r7, int r8, Long r9, int r10) {
            if ((r10 & 4) == 0) goto L5;
            r9 = null;
        L5:
            r6.e(r7, r8, r9, null, null);
        }

        public final void e(int r9, int r10, Long r11, Boolean r12, Boolean r13) {
            if (r9 != this.b) goto L5;
            return;
        L5:
            this.b = r9;
            e r0 = this.c.a;
            i1.i(r0.m, r0.a, r9, r10, r11, r12, r13);
        }
    }

    static {
    }

    public final void b() {
        FLogger.a.i("MusicPlayEngine", "abandon audio focus actively, musicId: " + this.a.a + ", currentMusicMediaApplicant: " + this.z);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.z);
    }

    public final void c() {
        if (this.e == false) goto L6;
        FLogger.a.i("MusicPlayEngine", "background audio takeover already cancelled music, musicId:" + this.a.a);
        return;
    L6:
        FLogger.a.i("MusicPlayEngine", "background audio takeover cancels music engine, musicId:" + this.a.a + ", isVideoModelReady:" + this.c + ", isWorking:" + this.h + ", playbackState:" + this.g);
        this.e = true;
        this.m = null;
        this.j = false;
        this.g = 0;
        this.h = false;
        b();
        a88.c r3 = this.o;
        if (r3 == null) goto L9;
        r3.g(this.a.a, 0);
    L9:
        this.o = null;
        b r1 = this.p;
        if (r1 == null) goto L12;
        r1.b(this.a, this, 1);
    L12:
        b r0 = this.p;
        if (r0 == null) goto L16;
        r0.a(this.a, this);
    L16:
        if (this.p != null) goto L18;
        this.f.release();
    L18:
        e();
    }

    public final void e() {
        if (this.n.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.n);
        this.n.clear();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Function0) r1.next()).invoke();
        goto L7
    }

    public final String getId() {
        e r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    public final IVideoController.PlayType getStatus() {
        return this.f.d();
    }

    public final boolean a() {
        return this.j;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [e88.c] */
    public final void d(boolean r8) {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L24;
        final ?? r0 = new e88.c(this);
        FLogger r1 = FLogger.a;
        r1.i("MusicPlayEngine", "requireAudioFocus before assignment: isAuto: " + r8 + ", currentMusicMediaApplicant=" + this.z);
        if (r8 == true) goto L10;
    L11:
        if (r8 == false) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        b();
    L18:
        if (r8 == false) goto L20;
        com.larus.media.model.a r6 = this.y;
    L21:
        this.z = r6;
        r1.i("MusicPlayEngine", "requireAudioFocus after assignment: isAuto: " + r8 + ", currentMusicMediaApplicant=" + this.z);
        Lazy r9 = MediaResourceManager.a;
        final Function0 r3 = null;
        MediaResourceManager.m(this.z, new d(this, r0), new e88.e(this, r3), 0, 8);
        return;
    L20:
        r6 = this.x;
        goto L21
    L13:
        if (Intrinsics.areEqual(this.z, this.x) == true) goto L15;
    L14:
        r5 = true;
        goto L16
    L10:
        if (Intrinsics.areEqual(this.z, this.y) == false) goto L14;
    }

    public final void h(Function0<Unit> r4) {
        if (this.d == false) goto L5;
    L15:
        if (r4 == null) goto L18;
        r4.invoke();
        return;
    L18:
        return;
    L5:
        if (this.h == false) goto L15;
        if (this.g == 0) goto L10;
        this.w = Long.valueOf(System.currentTimeMillis());
        e r0 = this.a;
        i1.j(r0.m, r0.a, this.g);
    L10:
        this.j = false;
        if (r4 == null) goto L13;
        this.n.add(r4);
    L13:
        this.f.stop();
    }

    public final void f(boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "pausedReason");
        if (this.d == false) goto L5;
        return;
    L5:
        this.j = false;
        if (this.g != 0) goto L10;
        FLogger.a.i("MusicPlayEngine", "ignore pausing because stopped, musicId: " + this.a.a + ", pauseReason: " + r8);
        return;
    L10:
        if (this.g == 2) goto L12;
        this.v = Long.valueOf(System.currentTimeMillis());
        e r0 = this.a;
        i1.g(r0.m, r8, r0.a, this.g);
        FLogger.a.i("MusicPlayEngine", "pause playing, musicId: " + this.a.a + ", reason: " + r8);
        this.k = r8;
        if (r7 == true) goto L20;
        this.q = true;
        b();
    L20:
        this.f.b();
        return;
    L12:
        if (Intrinsics.areEqual(r8, "default") == false) goto L22;
        FLogger.a.i("MusicPlayEngine", "only do prepare pausing, musicId: " + this.a.a + ", newReason: " + r8 + ", oldReason: " + this.k);
        this.k = r8;
        if (r7 == true) goto L23;
        this.q = true;
        b();
        return;
    L23:
        return;
    }

    public a(e r29, String r30, MusicPlayManager.b r31) {
        Intrinsics.checkNotNullParameter(r29, GlobalAudioSceneEnum.MUSIC);
        this.a = r29;
        this.b = r31;
        c r2 = new c(this);
        this.i = 1.0f;
        this.n = new ArrayList();
        IVideoController r3 = VideoService.a.f("music_play_engine", null);
        r3.p(r2);
        r3.h(new k4(GlobalAudioSceneEnum.MUSIC, r29.c, r29.d, r29.a, r29.k, r29.l));
        r3.f(r29.b, new f(this, r3));
        r3.s(new g(this));
        this.f = r3;
        t r1 = new t(this);
        com.larus.media.model.a r4 = new com.larus.media.model.a(null, GlobalAudioSceneEnum.MUSIC, false, 0, 2, false, 0, false, false, 0, false, r1, 2029);
        this.x = r4;
        this.y = new com.larus.media.model.a(null, "plugin_auto_play", false, 0, 2, false, 0, false, false, 0, false, r1, 2029);
        this.z = r4;
    }

    public static void g(a r2, boolean r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = "default";
    L11:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "playReason");
        if (r2.d == false) goto L14;
        return;
    L14:
        if (r2.e == false) goto L17;
        return;
    L17:
        if (r2.q == false) goto L20;
        if (r4 == false) goto L20;
        FLogger.a.i("MusicPlayEngine", "MediaApplicant try play when actively paused");
        return;
    L20:
        r2.l = r5;
        r2.q = false;
        r2.j = true;
        boolean r7 = !r2.r;
        r2.r = true;
        if (r2.g == 1) goto L24;
        r2.u = Long.valueOf(System.currentTimeMillis());
        e r8 = r2.a;
        i1.h(r8.m, r5, r8.a, r7, r2.g);
    L24:
        if (r2.c == true) goto L26;
        r2.m = new e88.b(r2, r3);
        return;
    L26:
        r2.d(r3);
    }
}
