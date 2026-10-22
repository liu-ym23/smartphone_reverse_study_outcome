package com.larus.audio.asr;

import android.media.AudioManager;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.larus.audio.call.aec.BackTraceRecorderAecImpl;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g0 implements h68.c {
    public static final long n = 0;
    public final String a;
    public final y58.a b;
    public final r58.c c;
    public final AudioManager d;
    public final BackTraceRecorderAecImpl e;
    public final LinkedBlockingQueue<r58.d> f;
    public final ReentrantLock g;
    public final Object h;
    public Thread i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public final hga.b m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioRecordState.values().length];
            r0[AudioRecordState.UNINITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AudioRecordState.INITIALIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AudioRecordState.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AudioRecordState.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        n = TimeUnit.MINUTES.toMillis(10);
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        r58.c r0 = this.c;
        if (r0 == null) goto L5;
        AudioRecordState r1 = r0.l();
    L7:
        if (r1 != null) goto L9;
        int r2 = -1;
    L10:
        if (r2 == (-1)) goto L26;
        if (r2 == 1) goto L30;
        if (r2 == 2) goto L29;
        if (r2 == 3) goto L28;
        if (r2 != 4) goto L21;
        return AsrDataSourceState.STOPPED;
    L21:
        throw new NoWhenBranchMatchedException();
    L28:
        return AsrDataSourceState.STARTED;
    L29:
        return AsrDataSourceState.INITIALIZED;
    L30:
        return AsrDataSourceState.UNINITIALIZED;
    L26:
        return AsrDataSourceState.UNINITIALIZED;
    L9:
        r2 = b.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // h68.c
    public final int b() {
        y58.a r0 = this.b;
        if (r0.s == 0) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        return 2560;
    L13:
        r58.c r2 = this.c;
        if (r2 != null) goto L18;
        return -1;
    L18:
        return r2.c();
    L5:
        if (r0.r != 2) goto L9;
        if (r0.v != 2) goto L9;
        r1 = true;
        goto L10
    }

    @Override // h68.c
    public final h68.a prepare() {
        r58.c r0 = this.c;
        if (r0 == null) goto L6;
        r0.prepare();
    L6:
        if (this.k == true) goto L16;
        Object r1 = this.h;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (this.k == false) goto L14;
        monitor-exit(r1);
        goto L16
    L14:
        this.e.e(new d0(this));     // Catch: Throwable -> L18
        this.m.d();     // Catch: Throwable -> L18
        this.k = true;     // Catch: Throwable -> L18
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r1);
    L16:
        this.e.c();
        this.e.h();
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a release() {
        if (this.j == false) goto L5;
        stop();
    L5:
        this.e.g();
        if (this.l == true) goto L8;
        r58.c r0 = this.c;     // Catch: Exception -> L14
        if (r0 == null) goto L12;
        r0.release();     // Catch: Exception -> L14
    L12:
        return new h68.a.b(null);
    L14:
        e = move-exception;
        return new h68.a.C0110a(-2003, "recordReleaseFail", e);
    L8:
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        y58.a r3 = this.b;
        if (r3.s != 0) goto L5;
        Long r4 = r3.k;     // Catch: Exception -> L21
        if (r4 == null) goto L9;
        long r6 = System.currentTimeMillis() - r4.longValue();     // Catch: Exception -> L21
    L10:
        int r5 = c68.b.a;     // Catch: Exception -> L21
        c68.b.d("BackTraceRecorderAsrDataSource", "set back trace record length(ms): " + r6);     // Catch: Exception -> L21
        this.d.setParameters("backtrace_history_length=" + r6);     // Catch: Exception -> L21
        ObricBackTraceLogDelegate.b.a("long_press", r6);     // Catch: Exception -> L21
        hga.b.a.a(this.m, r6, "obric_backtrace_asr");     // Catch: Exception -> L21
        r58.c r1 = this.c;     // Catch: Exception -> L21
        if (r1 == null) goto L13;
        r1.j();     // Catch: Exception -> L21
    L13:
        r58.c r2 = this.c;     // Catch: Exception -> L21
        if (r2 == null) goto L16;
        r2.g(new e0(this));     // Catch: Exception -> L21
    L16:
        IWakeupLatencyTrackService.a.b(ObricWakeupLatencyTrackService.b);     // Catch: Exception -> L21
        this.m.f("obric_backtrace_asr");     // Catch: Exception -> L21
        r58.c r0 = this.c;     // Catch: Exception -> L21
        if (r0 == null) goto L19;
        r0.start();     // Catch: Exception -> L21
    L19:
        this.j = true;     // Catch: Exception -> L21
        this.i = ThreadsKt.thread$default(false, false, null, "aec-data-producer", 0, new f0(this), 23, null);     // Catch: Exception -> L21
        return new h68.a.b(null);
    L9:
        r6 = 50;
    L21:
        e = move-exception;
        return new h68.a.C0110a(-2004, "recordStartFail", e);
    L5:
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a stop() {
        c68.b.e("BackTraceRecorderAsrDataSource", "Try stop backtrace audio record reading thread");
        this.j = false;
        Thread r0 = this.i;
        if (r0 == null) goto L24;
        r0.interrupt();
    L24:
        Thread r1 = this.i;     // Catch: InterruptedException -> L9
        if (r1 == null) goto L10;
        ThreadMethodProxy.join(r1, 500);     // Catch: InterruptedException -> L9
    L10:
        this.i = null;
        this.f.clear();
        this.e.c();
        if (this.l == true) goto L13;
        r58.c r2 = this.c;     // Catch: Exception -> L19
        if (r2 == null) goto L17;
        r2.stop();     // Catch: Exception -> L19
    L17:
        return new h68.a.b(null);
    L19:
        e = move-exception;
        return new h68.a.C0110a(-2002, "recordStopFail", e);
    L13:
        return new h68.a.b(null);
    L9:
        ThreadMethodProxy.currentThread().interrupt();
        goto L10
    }

    public final String toString() {
        r58.c r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void c(r58.d r7) {
        int r0 = c68.b.a;
        c68.b.d("BackTraceRecorderAsrDataSource", "onAecAudioDataReceived, aec out data size: " + r7.a + ", mIsRunning:" + this.j);
        if (this.j == true) goto L6;
        c68.b.e("BackTraceRecorderAsrDataSource", "Not running, dropping AEC data.");
        return;
    L6:
        this.m.g();
        y58.a r1 = this.b;
        int r2 = 0;
        if (r1.s == 0) goto L9;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
        this.f.offer(r7);
        return;
    L16:
        int r4 = RangesKt.coerceIn(r7.a, 0, r7.b.length);
    L17:
        if (r2 >= r4) goto L21;
        int r5 = Math.min(2560, r4 - r2);
        int r6 = r2 + r5;
        this.f.offer(new r58.d(r5, ArraysKt.copyOfRange(r7.b, r2, r6)));
        r2 = r6;
        goto L17
    L21:
        return;
    L9:
        if (r1.r != 2) goto L13;
        if (r1.v != 2) goto L13;
        r3 = true;
        goto L14
    }

    @Override // h68.c
    public final h68.a read(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        if (this.b.s == 0) goto L7;
        Thread.sleep(40);
        return new h68.a.b(0);
    L7:
        if (this.j == true) goto L26;
        if (this.f.isEmpty() == false) goto L26;
        c68.b.d("BackTraceRecorderAsrDataSource", "read: Not running and queue is empty, returning 0.");
        return new h68.a.b(0);
    L26:
        r58.d r5 = this.f.poll(1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L22 InterruptedException -> L24
        if (r5 == null) goto L16;
        int r2 = Math.min(r10.length, r5.a);     // Catch: Exception -> L22 InterruptedException -> L24
        System.arraycopy(r5.b, 0, r10, 0, r2);     // Catch: Exception -> L22 InterruptedException -> L24
        if (r2 >= r5.a) goto L28;
        c68.b.e("BackTraceRecorderAsrDataSource", "read buffer is smaller than AEC data. Data truncated.");     // Catch: Exception -> L22 InterruptedException -> L24
    L28:
        return new h68.a.b(Integer.valueOf(r2));
    L16:
        return new h68.a.b(0);
    L24:
        ThreadMethodProxy.currentThread().interrupt();
        c68.b.e("BackTraceRecorderAsrDataSource", "Read thread interrupted while waiting for AEC data.");
        return new h68.a.C0110a(-1, "Read interrupted", null);
    L22:
        e = move-exception;
        c68.b.c("BackTraceRecorderAsrDataSource", "Unexpected error while taking AEC data", e);
        return new h68.a.C0110a(-1, "Take AEC data failed", null);
    }

    public g0(String r3, y58.a r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "asrConfig");
        this.a = r3;
        this.b = r4;
        IAudioRecorderFactory r5 = (IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class);
        if (r5 == null) goto L5;
        r58.c r6 = r5.a(AudioRecordType.BackTraceRecord, MapsKt.mapOf(TuplesKt.to("context", AppHost.a.getApplication())));
    L6:
        this.c = r6;
        Object r7 = AppHost.a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.media.AudioManager");
        this.d = (AudioManager) r7;
        this.e = new BackTraceRecorderAecImpl();
        this.f = new LinkedBlockingQueue();
        this.g = new ReentrantLock();
        this.h = new Object();
        this.m = ObricBackTraceLogDelegate.b.c();
        return;
    L5:
        r6 = null;
        goto L6
    }
}
