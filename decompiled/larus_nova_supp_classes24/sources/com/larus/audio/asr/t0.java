package com.larus.audio.asr;

import c68.b;
import com.larus.asr.u2;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import java.io.ByteArrayOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t0 implements h68.c {
    public final String a;
    public final h68.c b;
    public final Lazy c;

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.b.a();
    }

    @Override // h68.c
    public final int b() {
        return this.b.b();
    }

    @Override // h68.c
    public final h68.a prepare() {
        return this.b.prepare();
    }

    @Override // h68.c
    public final h68.a release() {
        h68.a r0 = this.b.release();
        a r1 = (a) this.c.getValue();
        Object r3 = r1.d;
        monitor-enter(r3);
        int r4 = b.a;     // Catch: Throwable -> L26
        b.d("AsrAudioFileStore", "[release][" + r1.b + "][" + r1.a + ']');     // Catch: Throwable -> L26
        boolean r2 = r1.a();     // Catch: Throwable -> L26
        Unit r5 = null;
        if (r1.c != null) goto L7;
    L10:
        Boolean r6 = null;
    L11:
        monitor-exit(r3);
        if (r6 == null) goto L25;
        boolean r7 = r6.booleanValue();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
        Function1<Boolean, Unit> r9 = r1.c;     // Catch: Throwable -> L19
        if (r9 == null) goto L17;
        r9.invoke(Boolean.valueOf(r7));     // Catch: Throwable -> L19
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r10 = Result.constructor-impl(r5);     // Catch: Throwable -> L19
    L21:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L24;
        int r12 = b.a;
        b.c("AsrAudioFileStore", "[" + r1.b + "] notify audio file save result failed", r11);
    L24:
        Result.box-impl(r10);
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        return r0;
    L7:
        if (r1.f == true) goto L10;
        r1.f = true;     // Catch: Throwable -> L26
        r6 = Boolean.valueOf(r2);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // h68.c
    public final h68.a start() {
        h68.a r0 = this.b.start();
        if ((r0 instanceof h68.a.b) == false) goto L15;
        a r1 = (a) this.c.getValue();
        Object r3 = r1.d;
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r1.e != null) goto L9;
        int r4 = b.a;     // Catch: Throwable -> L12
        b.d("AsrAudioFileStore", "[prepareForStart][" + r1.b + "][" + r1.a + ']');     // Catch: Throwable -> L12
        r1.e = new ByteArrayOutputStream();     // Catch: Throwable -> L12
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r3);
    L15:
        return r0;
    }

    @Override // h68.c
    public final h68.a stop() {
        return this.b.stop();
    }

    @Override // h68.c
    public final h68.a read(byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "buffer");
        h68.a r0 = this.b.read(r8);
        if ((r0 instanceof h68.a.b) == false) goto L5;
        h68.a.b r1 = (h68.a.b) r0;
    L6:
        if (r1 == null) goto L29;
        Integer r2 = r1.a;
        if (r2 == null) goto L29;
        int r3 = r2.intValue();
        if (r3 <= 0) goto L29;
        a r4 = (a) this.c.getValue();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "data");
        Object r5 = r4.d;
        monitor-enter(r5);
        ByteArrayOutputStream r6 = r4.e;     // Catch: Throwable -> L26
        if (r6 != null) goto L30;
        monitor-exit(r5);
        goto L29
    L30:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        r6.write(r8, 0, r3);     // Catch: Throwable -> L19
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L26
        if (r10 == null) goto L24;
        int r11 = b.a;     // Catch: Throwable -> L26
        b.c("AsrAudioFileStore", "[writeFrame] [" + r4.b + "] write retryable audio file failed path=" + r4.a, r10);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r5);
        goto L29
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L26
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        return r0;
    L5:
        r1 = null;
        goto L6
    }

    public t0(String r2, h68.c r3, final String r4, final u2 r5) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "origin");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new s0(r4, this, r5));
    }
}
