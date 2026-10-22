package com.larus.audio.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrAudioRecordException;
import com.larus.asr.s2;
import com.larus.asr.t2;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sw5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r implements sw5.a {
    public final String b;
    public final h68.c c;
    public final n58.a d;
    public final Function1<byte[], Unit> e;
    public final List<b> f;
    public final AtomicBoolean g;
    public final ExecutorService h;
    public final Object i;
    public volatile Future<?> j;

    public static final class a {
    }

    static {
    }

    public final void getRecordAmplitude() {
    }

    public final List<b> k0() {
        Object r0 = this.i;
        monitor-enter(r0);
        List<b> r1 = CollectionsKt.toList(this.f);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startRecorder() {
        if (this.g.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        h68.a r0 = this.c.prepare();
        if ((r0 instanceof h68.a.C0110a) == true) goto L22;
        h68.a r1 = this.c.start();
        if ((r1 instanceof h68.a.C0110a) == true) goto L15;
        Iterator<T> r2 = k0().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((b) r2.next()).A1();
        goto L11
    L13:
        this.j = this.h.submit(new p(this));
        return;
    L15:
        this.g.set(false);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        Result.constructor-impl(u());     // Catch: Throwable -> L18
    L21:
        throw new FlowAsrAudioRecordException(k0.a((h68.a.C0110a) r1, FlowAsrErrorType.SOURCE_START_FAILED));
    L18:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L22:
        this.g.set(false);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        Result.constructor-impl(u());     // Catch: Throwable -> L25
    L28:
        throw new FlowAsrAudioRecordException(k0.a((h68.a.C0110a) r0, FlowAsrErrorType.SOURCE_PREPARE_FAILED));
    L25:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public final void stopRecorder() {
        boolean r1 = false;
        if (this.g.getAndSet(false) == false) goto L5;
    L6:
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        h68.a r2 = this.c.stop();
    L11:
        Future<?> r3 = this.j;
        if (r3 != null) goto L35;
    L19:
        if (r1 == true) goto L21;
    L26:
        h68.a r0 = u();
        this.h.shutdownNow();
        if ((r2 instanceof h68.a.C0110a) == true) goto L34;
        if ((r0 instanceof h68.a.C0110a) == true) goto L32;
        return;
    L32:
        throw new FlowAsrAudioRecordException(k0.a((h68.a.C0110a) r0, FlowAsrErrorType.SOURCE_RELEASE_FAILED));
    L34:
        throw new FlowAsrAudioRecordException(k0.a((h68.a.C0110a) r2, FlowAsrErrorType.SOURCE_STOP_FAILED));
    L21:
        if ((r2 instanceof h68.a.C0110a) == true) goto L26;
        Iterator<T> r4 = k0().iterator();
    L24:
        if (r4.hasNext() == false) goto L26;
        ((b) r4.next()).a2();
        goto L24
    L35:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        Result.constructor-impl(r3.get(500, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L16
    L18:
        this.j = null;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L10:
        r2 = new h68.a.b(null);
        goto L11
    L5:
        if (this.c.a() != AsrDataSourceState.STARTED) goto L8;
        goto L6
    }

    public final h68.a u() {
        if (this.c.a() != AsrDataSourceState.UNINITIALIZED) goto L6;
        return new h68.a.b(null);
    L6:
        return this.c.release();
    }

    public final void C1(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.i;
        monitor-enter(r0);
        ((ArrayList) this.f).add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void M0(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.i;
        monitor-enter(r0);
        ((ArrayList) this.f).remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public r(String r2, t0 r3, s2 r4, t2 r5) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = new ArrayList();
        this.g = new AtomicBoolean(false);
        this.h = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AsrDataSourceAudioRecordAdapter"));
        this.i = new Object();
        int r6 = c68.b.a;
        c68.b.d("AsrDataSourceAudioRecordAdapter", "init with taskId: " + r2);
    }
}
