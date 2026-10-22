package com.larus.avlink;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.x2;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w implements r58.c {
    public final Function0<Unit> a;
    public AudioRecordState b;
    public final PipedInputStream c;
    public final PipedOutputStream d;
    public final BlockingQueue<byte[]> e;
    public final com.larus.audio.call.util.o f;
    public final AtomicBoolean g;
    public final x h;
    public boolean i;
    public boolean j;
    public Function0<Unit> k;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r1, long r3) {
    }

    @Override // r58.c
    public final int c() {
        return 80;
    }

    @Override // r58.c
    public final long d(long r1) {
        return 0;
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r1) {
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
    }

    @Override // r58.c
    public final void j() {
    }

    @Override // r58.c
    public final void prepare() {
        n1.a("DoraAudioRecorder", "prepare");
        m(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void release() {
        n1.a("DoraAudioRecorder", "release");
        this.g.set(true);
        this.c.close();     // Catch: Exception -> L5
        this.d.close();     // Catch: Exception -> L5
        ((LinkedBlockingQueue) this.e).clear();     // Catch: Exception -> L5
    L7:
        m(AudioRecordState.UNINITIALIZED);
        n1.b("DoraAudioRecorder", "unRegisterDoraVoiceCallback");
        Map r0 = x2.a;
        x2.k(this.h);
        return;
    L5:
        e = move-exception;
        n1.c("DoraAudioRecorder", "stream release exception", e);
        goto L7
    }

    @Override // r58.c
    public final void start() {
        n1.a("DoraAudioRecorder", "start");
        m(AudioRecordState.STARTED);
    }

    @Override // r58.c
    public final void stop() {
        n1.a("DoraAudioRecorder", "stop");
        m(AudioRecordState.STOPPED);
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.b;
    }

    public w(int r6) {
        this.a = null;
        this.b = AudioRecordState.UNINITIALIZED;
        PipedInputStream r0 = new PipedInputStream(40000);
        this.c = r0;
        PipedOutputStream r1 = new PipedOutputStream();
        this.d = r1;
        this.e = new LinkedBlockingQueue();
        this.f = new com.larus.audio.call.util.o(300);
        this.g = new AtomicBoolean(false);
        this.h = new x(this);
        this.i = true;
        r0.connect(r1);     // Catch: Exception -> L5
    L7:
        n1.b("DoraAudioRecorder", "registerDoraVoiceCallback");
        Map r7 = x2.a;
        x2.d(this.h);
        m(AudioRecordState.INITIALIZED);
        return;
    L5:
        e = move-exception;
        n1.c("DoraAudioRecorder", "stream connect exception", e);
        goto L7
    }

    @Override // r58.c
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // r58.c
    public final void e(Function0<Unit> r4) {
        this.d.close();     // Catch: Exception -> L4
    L6:
        this.k = r4;
        this.j = true;
        return;
    L4:
        e = move-exception;
        n1.c("DoraAudioRecorder", "pendingStop failed", e);
        goto L6
    }

    @Override // r58.c
    public final void h(v58.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioRecordConfig");
        n1.a("DoraAudioRecorder", "config");
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "onAudioDataReceived");
        byte[] r1 = new byte[80];
    L4:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L42;
        if (this.g.get() == true) goto L43;
        byte[] r2 = new byte[256];
        Intrinsics.checkNotNullParameter(r1, "buffer");
        int r4 = i(r1, 80);
        int r5 = 0;
        if (r4 > 0) goto L33;
    L24:
        Pair r3 = new Pair(Integer.valueOf(r4), Integer.valueOf(r5));
        int r6 = ((Number) r3.component1()).intValue();
        int r7 = ((Number) r3.component2()).intValue();
        if (r6 == 0) goto L4;
        if (r6 <= 0) goto L29;
        r12.invoke(new r58.d(r6, Arrays.copyOf(r1, r6)), Arrays.copyOf(r2, r7));
        goto L4
    L29:
        n1.b("DoraAudioRecorder", "audioRecord record failed, error code: " + r6);
        return;
    L33:
    L22:
        th = th;
    L23:
        n1.a("DoraAudioRecorder", "vad read " + com.larus.utils.u0.a(th));
        goto L24
    L10:
        if (((LinkedBlockingQueue) this.e).size() <= 0) goto L24;
        byte[] r8 = (byte[]) ((LinkedBlockingQueue) this.e).poll(0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        if (r8 == null) goto L15;
        int r9 = r8.length;     // Catch: Throwable -> L22
    L16:
        if (r9 > 0) goto L31;
    L21:
        r5 = r9;
        goto L24
    L31:
        System.arraycopy(r8, 0, r2, 0, r8.length);     // Catch: Throwable -> L19
        n1.a("DoraAudioRecorder", "vad read: " + r8.length);     // Catch: Throwable -> L19
    L19:
        th = th;
        r5 = r9;
        goto L23
    L15:
        r9 = 0;
        goto L16
    L43:
        return;
    }

    public final void m(AudioRecordState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        n1.a("DoraAudioRecorder", "#onStateChange state:" + r3);
        this.b = r3;
    }

    @Override // r58.c
    public final int i(byte[] r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "buffer");
        if (this.i == false) goto L7;
        this.i = false;
        Function0<Unit> r1 = this.a;
        if (r1 == null) goto L7;
        r1.invoke();
    L7:
        final Ref.IntRef r2 = new Ref.IntRef();
        r2.element = this.c.read(r6, 0, r7);     // Catch: Exception -> L10
    L13:
        if (r2.element == 80) goto L15;
        n1.b("DoraAudioRecorder", "read: " + r2.element + ", pendingStop:" + this.j);
    L17:
        if (r2.element != (-1)) goto L25;
        if (this.j == false) goto L25;
        this.j = false;
        Function0<Unit> r8 = this.k;
        if (r8 == null) goto L23;
        r8.invoke();
    L23:
        stop();
    L25:
        return r2.element;
    L15:
        this.f.a(new v(r2, this));
    L10:
        e = move-exception;
        n1.c("DoraAudioRecorder", "read failed: " + r2.element, e);
        r2.element = -1;
        goto L13
    }
}
