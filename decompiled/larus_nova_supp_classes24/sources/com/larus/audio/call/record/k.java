package com.larus.audio.call.record;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k extends c {
    public static final /* synthetic */ int j = 0;
    public final j e;
    public volatile b f;
    public boolean g;
    public final buc.a h;
    public Function2<? super Boolean, ? super String, Unit> i;

    public static final class a {
        public static k a(CaptureBackTraceReadScene r7, long r8, String r10, int r11) {
            Intrinsics.checkNotNullParameter(r7, "scene");
            Intrinsics.checkNotNullParameter(r10, "reason");
            h r0 = i.a;
            l r1 = new l(r7, r8, r10, r11);
            Intrinsics.checkNotNullParameter(r1, "request");
            h r9 = i.a;
            if (r9 == null) goto L5;
            tia.k r12 = r9.a(r1);
        L6:
            if (r12 != null) goto L9;
            return null;
        L9:
            return new k(r12);
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class b extends PthreadThreadV2 {
        public final /* synthetic */ k v;
        public final /* synthetic */ Function2<r58.d, byte[], Unit> w;

        public final void l() {
            byte[] r1 = new byte[RangesKt.coerceAtLeast(this.v.e.a(), 1)];     // Catch: Throwable -> L26
        L5:
            if (isInterrupted() == true) goto L24;
            if (this.v.h.c() == true) goto L24;
            int r2 = this.v.e.read(r1);     // Catch: Throwable -> L26
            if (r2 < 0) goto L10;
            if (r2 == 0) goto L30;
            if (this.v.h.c() == true) goto L24;
            this.w.invoke(new r58.d(r2, Arrays.copyOf(r1, r2)), null);     // Catch: Throwable -> L26
            goto L5
        L30:
            Thread.sleep(20);     // Catch: InterruptedException -> L18 Throwable -> L26
        L18:
            interrupt();     // Catch: Throwable -> L26
            goto L24
        L10:
            Function2<? super Boolean, ? super String, Unit> r3 = this.v.i;     // Catch: Throwable -> L26
            if (r3 == null) goto L24;
            r3.invoke(Boolean.FALSE, "capture reader read failed: " + r2);     // Catch: Throwable -> L26
        L24:
            this.v.a = false;
            return;
        L26:
            th = move-exception;
            this.v.a = false;
            throw th;
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(k r1, Function2<? super r58.d, ? super byte[], Unit> r2) {
            this.v = r1;
            this.w = r2;
            super("flow-capture-audio-reader");
        }
    }

    static {
    }

    @Override // v68.a
    public final void release() {
        com.larus.audio.call.util.e.a.i("CaptureBackTraceAudioRecorderWrapper", "release");
        if (this.h.a(false, true) == true) goto L5;
        return;
    L5:
        stopRecord();
        b r0 = this.f;
        if (r0 == null) goto L8;
        r0.interrupt();
    L8:
        this.e.release();
        this.f = null;
        this.g = false;
        this.d.a();
    }

    @Override // v68.a
    public final void stopRecord() {
        com.larus.audio.call.util.e.a.i("CaptureBackTraceAudioRecorderWrapper", "stop");
        this.a = false;
        this.e.stop();
    }

    public k(j r2) {
        super(true);
        this.e = r2;
        this.h = buc.b.a(false);
    }

    @Override // v68.a
    public final void e(Function0<Unit> r1) {
        stopRecord();
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
        this.i = r1;
    }

    @Override // v68.a
    public final boolean start(Function1<? super Exception, Unit> r7) {
        com.larus.audio.call.util.e.a.i("CaptureBackTraceAudioRecorderWrapper", "start recordStarted=" + this.a);
        if (this.a == false) goto L12;
        PthreadThreadV2 r0 = this.f;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        return true;
    L7:
        if (ThreadMethodProxy.isAlive(r0) != true) goto L9;
        r1 = true;
    L12:
        PthreadThreadV2 r2 = this.f;
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L23;
        this.a = false;
        Function2<? super Boolean, ? super String, Unit> r8 = this.i;
        if (r8 == null) goto L22;
        r8.invoke(Boolean.FALSE, "capture reader thread is not alive");
    L22:
        return false;
    L23:
        this.a = true;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        Object r5 = Result.constructor-impl(Boolean.valueOf(this.e.start()));     // Catch: Throwable -> L26
    L28:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        String r9 = "capture reader start failed";
        if (r6 == null) goto L31;
        com.larus.audio.call.util.e.a.e("CaptureBackTraceAudioRecorderWrapper", "capture reader start failed", r6);
    L31:
        Object r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == true) goto L35;
        r10 = r5;
    L35:
        boolean r11 = ((Boolean) r10).booleanValue();
        Throwable r12 = Result.exceptionOrNull-impl(r5);
        if (r12 == null) goto L41;
        String r13 = r12.getMessage();
        if (r13 == null) goto L41;
        r9 = r13;
    L41:
        if (r11 == true) goto L50;
        this.a = false;
        Throwable r14 = Result.exceptionOrNull-impl(r5);
        if ((r14 instanceof Exception) == false) goto L45;
        Exception r15 = (Exception) r14;
    L46:
        if (r15 != null) goto L48;
        r15 = new IllegalStateException(r9);
    L48:
        if (r7 == null) goto L50;
        r7.invoke(r15);
        goto L50
    L45:
        r15 = null;
    L50:
        Function2<? super Boolean, ? super String, Unit> r16 = this.i;
        if (r16 == null) goto L56;
        Boolean r17 = Boolean.valueOf(r11);
        if (r11 == false) goto L55;
        r9 = "";
    L55:
        r16.invoke(r17, r9);
    L56:
        return r11;
    L26:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L15:
        if (ThreadMethodProxy.isAlive(r2) != true) goto L17;
        r3 = true;
        goto L18
    }

    @Override // v68.a
    public final void d(v58.a r3, Function2<? super r58.d, ? super byte[], Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onAudioDataReceived");
        com.larus.audio.call.util.e.a.i("CaptureBackTraceAudioRecorderWrapper", "init initialized=" + this.g + " released=" + this.h.c());
        if (this.g == false) goto L5;
        return;
    L5:
        if (this.h.c() == true) goto L38;
        boolean r5 = true;
        this.g = true;
        PthreadThreadV2 r0 = this.f;
        if (r0 != null) goto L10;
    L12:
        r5 = false;
    L13:
        if (r5 == false) goto L17;
        b r6 = this.f;
        if (r6 == null) goto L17;
        r6.interrupt();
    L17:
        this.f = new b(this, r4);
        if (com.larus.audio.call.f.d().k == false) goto L34;
        PthreadThreadV2 r7 = this.f;
        if (r7 == null) goto L34;
        ThreadMethodProxy.setPriority(r7, 10);
    L34:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L28
        PthreadThreadV2 r9 = this.f;     // Catch: Throwable -> L28
        if (r9 == null) goto L25;
        ThreadMethodProxy.start(r9);     // Catch: Throwable -> L28
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L28
    L30:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L37;
        com.larus.audio.call.util.e.a.e("CaptureBackTraceAudioRecorderWrapper", "start reader thread failed", r12);
        return;
    L37:
        return;
    L25:
        r10 = null;
    L28:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L10:
        if (ThreadMethodProxy.isAlive(r0) != true) goto L12;
    }
}
