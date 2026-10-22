package com.larus.avlink.plugins;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.l;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d4 extends com.larus.audio.call.arch.a<n4> implements t4 {
    public static final /* synthetic */ int s = 0;
    public final String f;
    public final LinkedBlockingQueue<byte[]> g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile long k;
    public volatile AudioTrack l;
    public volatile e4 m;
    public volatile boolean n;
    public final Object o;
    public volatile long p;
    public volatile boolean q;
    public final com.larus.media.model.a r;

    public static final class a {
    }

    public static final class b implements com.larus.media.v {
        public final /* synthetic */ d4 a;

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public b(d4 r1) {
            this.a = r1;
        }

        public final void e(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.d(r2);
            this.a.l3("media_interrupted");
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            com.larus.media.v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    public static final class c implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ d4 c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public c(d4 r1) {
            this.c = r1;
            this.a = r1.f;
            this.b = DataType.PLAYER;
        }

        public final void a(l r11) {
            Intrinsics.checkNotNullParameter(r11, "frame");
            d4 r0 = this.c;
            int r1 = d4.s;
            r0.getClass();
            if (this.c.L1(r11) == true) goto L5;
            return;
        L5:
            d4 r2 = this.c;
            r2.getClass();
            IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r3 == null) goto L16;
            DeviceService r4 = r3.device();
            if (r4 == null) goto L16;
            boolean r5 = r4.p0(null);
            boolean r6 = r4.f0();
            if (r5 == false) goto L16;
            if (r6 == false) goto L16;
            if (Intrinsics.areEqual(((n4) r2.getContext()).params().k.o, "dora_si") == true) goto L16;
            boolean r7 = true;
        L17:
            if (r7 == true) goto L20;
            return;
        L20:
            if (this.c.j == true) goto L22;
            ouc.d0 r8 = r11.b();
            String r9 = sf9.a.d(r8, "event");
            String r10 = sf9.a.c(r8, "scene", "");
            String r12 = sf9.a.c(r8, "tts_content_scene", "");
            com.larus.avlink.n1.d(this.c.f, "receive TTSPlay first frame, wearablePlayEvent=" + r9 + ", wearablePlayScene=" + r10 + ", ttsContentScene=" + r12 + ", status=" + sf9.a.b(r8, "status", 0) + ", taskId=" + sf9.a.c(r8, "task_id", "") + ", queryRound=" + r11.c() + ", replyRound=" + ((String) r11.i.getValue()));
        L22:
            final d4 r13 = this.c;
            monitor-enter(r13);
        L39:
            th = move-exception;
            throw th;
        L25:
            if (r13.i == false) goto L29;
            r13.h = true;     // Catch: Throwable -> L39
            monitor-exit(r13);
        L37:
            this.c.j = true;
            this.c.k = SystemClock.elapsedRealtime();
            this.c.g.offer(r11.a);
            return;
        L29:
            com.larus.avlink.n1.d(r13.f, "startIfNeeded source=tts_play_frame");     // Catch: Throwable -> L39
            r13.i = true;     // Catch: Throwable -> L39
            r13.h = true;     // Catch: Throwable -> L39
            r13.j = false;     // Catch: Throwable -> L39
            r13.k = SystemClock.elapsedRealtime();     // Catch: Throwable -> L39
            if (r13.q == true) goto L35;
            r13.q = true;     // Catch: Throwable -> L39
            com.larus.call_plugins_doubao_common.k r14 = r13.getContext().c(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null);     // Catch: Throwable -> L39
            if (r14 == null) goto L35;
            r14.O0();     // Catch: Throwable -> L39
        L35:
            Lazy r15 = MediaResourceManager.a;     // Catch: Throwable -> L39
            MediaResourceManager.m(r13.r, new b4(r13), new c4(r13), 0, 8);     // Catch: Throwable -> L39
            monitor-exit(r13);
        L16:
            r7 = false;
            goto L17
        }
    }

    static {
    }

    public final synchronized void k3() {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        if (this.i == false) goto L6;
    L9:
        boolean r0 = true;
    L54:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        AudioTrack r4 = this.l;     // Catch: Throwable -> L21
        if (r4 != null) goto L14;
        Unit r5 = null;
    L19:
        Result.constructor-impl(r5);     // Catch: Throwable -> L21
    L56:
        AudioTrack r6 = this.l;     // Catch: Throwable -> L29
        if (r6 == null) goto L26;
        r6.release();     // Catch: Throwable -> L29
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L29
    L27:
        Result.constructor-impl(r7);     // Catch: Throwable -> L29
    L31:
        this.l = null;     // Catch: Throwable -> L51
        this.m = null;     // Catch: Throwable -> L51
        this.h = false;     // Catch: Throwable -> L51
        this.i = false;     // Catch: Throwable -> L51
        this.j = false;     // Catch: Throwable -> L51
        if (this.q == false) goto L37;
        this.q = false;     // Catch: Throwable -> L51
        com.larus.call_plugins_doubao_common.k r2 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null);     // Catch: Throwable -> L51
        if (r2 == null) goto L37;
        r2.o0();     // Catch: Throwable -> L51
    L37:
        if (r0 == false) goto L39;
        this.p = SystemClock.elapsedRealtime();     // Catch: Throwable -> L51
    L39:
        Object r1 = this.o;     // Catch: Throwable -> L51
        monitor-enter(r1);     // Catch: Throwable -> L51
        this.o.notifyAll();     // Catch: Throwable -> L48
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(r1);     // Catch: Throwable -> L51
        if (this.n == false) goto L46;
        Lazy r9 = MediaResourceManager.a;     // Catch: Throwable -> L51
        MediaResourceManager.a(this.r);     // Catch: Throwable -> L51
        this.n = false;     // Catch: Throwable -> L51
    L46:
        monitor-exit(this);
        return;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L26:
        r7 = null;
    L29:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L51
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L31
    L14:
        if (fna.g.d() == true) goto L16;
        r4.stop();     // Catch: Throwable -> L21
    L17:
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        goto L19
    L16:
        r4.stop();     // Catch: Throwable -> L21
        gna.a.a(r4.hashCode());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L51
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L56
    L6:
        if (this.j == true) goto L9;
        r0 = false;
        goto L54
    }

    @Override // com.larus.avlink.plugins.t4
    public final void G2() {
        Intrinsics.checkNotNullParameter("normal_tts_frame", "source");
        long r1 = SystemClock.elapsedRealtime();
        Object r3 = this.o;
        monitor-enter(r3);
        boolean r4 = false;
    L37:
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        if (this.p <= 0) goto L8;
        long r6 = RangesKt.coerceAtLeast((this.p + 250) - r5, 0);     // Catch: Throwable -> L32
    L9:
        long r11 = 20;
        if (this.i == false) goto L13;
    L17:
        if (r11 <= 0) goto L18;
        if (r4 == true) goto L35;
        com.larus.avlink.n1.d(this.f, "delay normal tts for TTSPlay, source=normal_tts_frame, isPlaying=" + this.i + ", remainGapMs=" + r6);     // Catch: Throwable -> L32
        r4 = true;
    L35:
        this.o.wait(r11);     // Catch: InterruptedException -> L29 Throwable -> L32
    L29:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L32
        com.larus.avlink.n1.d(this.f, "wait TTSPlay interrupted, source=normal_tts_frame");     // Catch: Throwable -> L32
        return;
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r3);
        long r7 = SystemClock.elapsedRealtime() - r1;
        if (r7 <= 0) goto L40;
        com.larus.avlink.n1.d(this.f, "normal tts allowed after TTSPlay, source=normal_tts_frame, waitCostMs=" + r7);
        return;
    L40:
        return;
    L13:
        if (r6 <= 0) goto L15;
        r11 = RangesKt.coerceAtMost(r6, 20);     // Catch: Throwable -> L32
        goto L17
    L15:
        r11 = 0;
        goto L17
    L8:
        r6 = 0;
    L32:
        th = move-exception;
        throw th;
    }

    public final com.larus.im.service.audio.x Q2() {
        return new c(this);
    }

    public final void g3() {
        super.g3();
        l3("session_stop");
    }

    public final String T2() {
        return this.f;
    }

    public d4(n4 r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        super(r15);
        this.f = "DoraTtsPlayPlugin";
        this.g = new LinkedBlockingQueue();
        this.o = new Object();
        this.r = new com.larus.media.model.a(null, "dora", false, 1, 2, false, 0, false, false, 0, false, new b(this), 2021);
    }

    @Override // com.larus.avlink.plugins.t4
    public final boolean L1(l r6) {
        Intrinsics.checkNotNullParameter(r6, "frame");
        ouc.d0 r7 = r6.b();
        String r0 = sf9.a.d(r7, "tts_content_scene");
        if (Intrinsics.areEqual(r0, "wakeup_comfort") == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        com.larus.avlink.n1.d(this.f, "frame: " + r7 + ",ttsContentScene=" + r0 + ", isSupportedTtsContentScene=" + r1);
        return r1;
    L5:
        if (Intrinsics.areEqual(r0, "query_comfort") == true) goto L8;
        r1 = false;
        goto L9
    }

    public final synchronized void l3(String r4) {
        monitor-enter(this);
        com.larus.avlink.n1.d(this.f, "stopNow source=" + r4 + ", isPlaying=" + this.i);     // Catch: Throwable -> L10
        this.h = false;     // Catch: Throwable -> L10
        this.i = false;     // Catch: Throwable -> L10
        this.j = false;     // Catch: Throwable -> L10
        this.g.clear();     // Catch: Throwable -> L10
        e4 r5 = this.m;     // Catch: Throwable -> L10
        if (r5 == null) goto L7;
        r5.interrupt();     // Catch: Throwable -> L10
    L7:
        k3();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static final void j3(d4 r5, byte[] r6) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L26;
        if (r5.i == false) goto L37;
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L38;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        AudioTrack r3 = r5.l;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        int r4 = r3.write(r6, r0, r6.length - r0);     // Catch: Throwable -> L16
    L14:
        Object r7 = Result.constructor-impl(Integer.valueOf(r4));     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L22;
        com.larus.avlink.n1.c(r5.f, "write pcm error", r8);
        r7 = -1;
    L22:
        int r1 = ((Number) r7).intValue();
        if (r1 <= 0) goto L24;
        r0 = r0 + r1;
        goto L4
    L24:
        Thread.sleep(10);
        goto L4
    L13:
        r4 = -1;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L38:
        return;
    L37:
        return;
    }
}
