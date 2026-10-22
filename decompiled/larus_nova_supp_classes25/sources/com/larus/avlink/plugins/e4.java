package com.larus.avlink.plugins;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e4 extends PthreadThreadV2 {
    public final /* synthetic */ d4 v;

    public final void l() {
        d4 r0 = this.v;
        boolean r1 = false;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L39
        int r3 = d4.s;     // Catch: Throwable -> L39
        r0.getClass();     // Catch: Throwable -> L39
        Integer r4 = Integer.valueOf(AudioTrack.getMinBufferSize(24000, 4, 2));     // Catch: Throwable -> L39
        if (r4.intValue() <= 0) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
        int r8 = r4.intValue();     // Catch: Throwable -> L39
    L13:
        r0.l = new AudioTrack(3, 24000, 4, 2, r8, 1);     // Catch: Throwable -> L39
        AudioTrack r6 = r0.l;     // Catch: Throwable -> L39
        if (r6 == null) goto L16;
        r6.setVolume(1.0f);     // Catch: Throwable -> L39
    L16:
        AudioTrack r7 = r0.l;     // Catch: Throwable -> L39
        if (r7 == null) goto L23;
        if (fna.g.d() == true) goto L21;
        r7.play();     // Catch: Throwable -> L39
        goto L23
    L21:
        r7.play();     // Catch: Throwable -> L39
        gna.a.c(r7.hashCode());     // Catch: Throwable -> L39
    L23:
        if (isInterrupted() == true) goto L37;
        byte[] r9 = r0.g.poll(100, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L39
        if (r9 != null) goto L26;
        long r10 = SystemClock.elapsedRealtime() - r0.k;     // Catch: Throwable -> L39
        if (r0.h == true) goto L33;
        if (r0.g.isEmpty() == false) goto L33;
        r1 = r0.i;     // Catch: Throwable -> L39
        com.larus.avlink.n1.d(r0.f, "finish TTSPlay without pending, source=queue_drained");     // Catch: Throwable -> L39
    L33:
        if (r0.j == false) goto L23;
        if (r10 < 1200) goto L23;
        r1 = r0.i;     // Catch: Throwable -> L39
        com.larus.avlink.n1.d(r0.f, "idle stop without pending, idleMs=" + r10);     // Catch: Throwable -> L39
        goto L37
    L26:
        d4.j3(r0, r9);     // Catch: Throwable -> L39
    L37:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        d4 r12 = this.v;
        Throwable r13 = Result.exceptionOrNull-impl(r11);
        if (r13 == null) goto L44;
        com.larus.avlink.n1.c(r12.f, "play thread error", r13);
    L44:
        d4 r14 = this.v;
        int r15 = d4.s;
        r14.k3();
        com.larus.avlink.n1.d(this.v.f, "comfort voice finished, naturalFinish=" + r1);
        return;
    L12:
        r8 = 4800;
        goto L13
    L6:
        r5 = false;
    L39:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
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

    public e4(d4 r1) {
        this.v = r1;
        super("dora-tts-play");
    }
}
