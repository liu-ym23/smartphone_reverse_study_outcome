package com.larus.audio.asr;

import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.larus.audio.call.aec.BackTraceRecorderAecImpl;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hga.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j0 implements h68.c {
    public static final long n = 0;
    public static final /* synthetic */ int o = 0;
    public final String a;
    public final y58.a b;
    public final hga.c c;
    public final BackTraceRecorderAecImpl d;
    public final LinkedBlockingQueue<r58.d> e;
    public final ReentrantLock f;
    public final Object g;
    public Thread h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile AsrDataSourceState l;
    public final b m;

    public static final class a {
    }

    @Override // h68.c
    public final h68.a stop() {
        this.i = false;
        Thread r0 = this.h;
        if (r0 == null) goto L19;
        r0.interrupt();
    L19:
        Thread r1 = this.h;     // Catch: InterruptedException -> L9
        if (r1 == null) goto L10;
        ThreadMethodProxy.join(r1, 500);     // Catch: InterruptedException -> L9
    L10:
        this.h = null;
        this.e.clear();
        this.d.c();
        this.l = AsrDataSourceState.STOPPED;
        if (this.k == true) goto L13;
        this.c.stop();     // Catch: Exception -> L16
        return new h68.a.b(null);
    L16:
        e = move-exception;
        return new h68.a.C0110a(-2002, "recordStopFail", e);
    L13:
        return new h68.a.b(null);
    L9:
        ThreadMethodProxy.currentThread().interrupt();
        goto L10
    }

    static {
        n = TimeUnit.MINUTES.toMillis(10);
    }

    @Override // h68.c
    public final int b() {
        y58.a r0 = this.b;
        if (r0.s == 0) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return 2560;
    L14:
        return this.c.a();
    L5:
        if (r0.r != 2) goto L9;
        if (r0.v != 2) goto L9;
        r1 = true;
        goto L10
    }

    @Override // h68.c
    public final h68.a prepare() {
        if (this.j == true) goto L13;
        Object r0 = this.g;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.j == false) goto L11;
        monitor-exit(r0);
        goto L13
    L11:
        this.d.e(new i0(this));     // Catch: Throwable -> L15
        this.m.d();     // Catch: Throwable -> L15
        this.j = true;     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
    L13:
        this.d.c();
        this.d.h();
        this.l = AsrDataSourceState.INITIALIZED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a release() {
        if (this.i == false) goto L5;
        stop();
    L5:
        this.d.g();
        this.l = AsrDataSourceState.UNINITIALIZED;
        if (this.k == true) goto L8;
        this.c.release();     // Catch: Exception -> L11
        return new h68.a.b(null);
    L11:
        e = move-exception;
        return new h68.a.C0110a(-2003, "recordReleaseFail", e);
    L8:
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        Long r1 = this.b.k;     // Catch: Exception -> L9
        if (r1 == null) goto L6;
        long r2 = r1.longValue();     // Catch: Exception -> L9
        long r3 = System.currentTimeMillis() - r2;     // Catch: Exception -> L9
    L7:
        ObricBackTraceLogDelegate.b.a("long_press", r3);     // Catch: Exception -> L9
        b.a.a(this.m, r3, "obric_backtrace_asr");     // Catch: Exception -> L9
        IWakeupLatencyTrackService.a.b(ObricWakeupLatencyTrackService.b);     // Catch: Exception -> L9
        this.m.f("obric_backtrace_asr");     // Catch: Exception -> L9
        this.c.start();     // Catch: Exception -> L9
        this.i = true;     // Catch: Exception -> L9
        this.h = ThreadsKt.thread$default(false, false, null, "capture-aec-data-producer", 0, new h0(this), 23, null);     // Catch: Exception -> L9
        this.l = AsrDataSourceState.STARTED;     // Catch: Exception -> L9
        return new h68.a.b(null);
    L6:
        r3 = 50;
    L9:
        e = move-exception;
        return new h68.a.C0110a(-2004, "recordStartFail", e);
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.l;
    }

    public final void c(r58.d r7) {
        int r0 = c68.b.a;
        c68.b.d("CaptureBackTraceRecorderAsrDataSource", "onAecAudioDataReceived size=" + r7.a + ", isRunning=" + this.i);
        if (this.i == true) goto L5;
        return;
    L5:
        this.m.g();
        y58.a r1 = this.b;
        int r2 = 0;
        if (r1.s == 0) goto L8;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L15;
        this.e.offer(r7);
        return;
    L15:
        int r4 = RangesKt.coerceIn(r7.a, 0, r7.b.length);
    L16:
        if (r2 >= r4) goto L20;
        int r5 = Math.min(2560, r4 - r2);
        int r6 = r2 + r5;
        this.e.offer(new r58.d(r5, ArraysKt.copyOfRange(r7.b, r2, r6)));
        r2 = r6;
        goto L16
    L20:
        return;
    L8:
        if (r1.r != 2) goto L12;
        if (r1.v != 2) goto L12;
        r3 = true;
        goto L13
    }

    @Override // h68.c
    public final h68.a read(byte[] r9) {
        Intrinsics.checkNotNullParameter(r9, "buffer");
        if (this.i == true) goto L19;
        if (this.e.isEmpty() == false) goto L19;
        return new h68.a.b(0);
    L19:
        r58.d r4 = this.e.poll(1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L15 InterruptedException -> L17
        if (r4 == null) goto L12;
        int r2 = Math.min(r9.length, r4.a);     // Catch: Exception -> L15 InterruptedException -> L17
        System.arraycopy(r4.b, 0, r9, 0, r2);     // Catch: Exception -> L15 InterruptedException -> L17
        return new h68.a.b(Integer.valueOf(r2));
    L12:
        return new h68.a.b(0);
    L17:
        ThreadMethodProxy.currentThread().interrupt();
        return new h68.a.C0110a(-1, "Read interrupted", null);
    L15:
        e = move-exception;
        c68.b.c("CaptureBackTraceRecorderAsrDataSource", "Unexpected error while taking AEC data", e);
        return new h68.a.C0110a(-1, "Take AEC data failed", null);
    }

    public j0(String r1, y58.a r2, hga.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = new BackTraceRecorderAecImpl();
        this.e = new LinkedBlockingQueue();
        this.f = new ReentrantLock();
        this.g = new Object();
        this.l = AsrDataSourceState.UNINITIALIZED;
        this.m = ObricBackTraceLogDelegate.b.c();
    }
}
