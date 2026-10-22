package com.larus.audio.utils;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.SoundsSource;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y0 implements Runnable {
    public final /* synthetic */ SoundsSource a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ y0(SoundsSource r1, byte[] r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoundsSource r0 = this.a;
        byte[] r1 = this.b;
        if (SoundsMobHelper.q == true) goto L6;
        return;
    L6:
        if (r0 != SoundsSource.MESSAGE_TTS) goto L8;
    L9:
        List r2 = ArraysKt.toMutableList(r1);
        Byte r3 = SoundsMobHelper.u;
        int r4 = 0;
        if (r3 == null) goto L13;
        ListProtector.add(r2, 0, Byte.valueOf(r3.byteValue()));
    L13:
        if ((r2.size() % 2) != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        SoundsMobHelper.u = (Byte) ListProtector.remove(r2, CollectionsKt.getLastIndex(r2));
    L18:
        int r6 = r1.length / 2;
        float[] r7 = new float[r6];
    L19:
        if (r4 >= r6) goto L35;
        int r8 = r4 * 2;
        int r9 = (r1[r8 + 1] << 8) | (r1[r8] & 255);
        if (r9 < 32768) goto L23;
        r9 = r9 - 65536;
    L23:
        r7[r4] = r9 / 32768.0f;
        r4 = r4 + 1;
        goto L19
    L35:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L26
        long r11 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26
        SoundsMobHelper r12 = SoundsMobHelper.a;     // Catch: Throwable -> L26
        SoundsMobHelper.l().process(r7, r6, 1);     // Catch: Throwable -> L26
        SoundsMobHelper.r += SystemClock.elapsedRealtime() - r11;     // Catch: Throwable -> L26
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L42;
        EnsureManager.ensureNotReachHere(r14);
        m58.v r15 = m58.h.i;
        if (r15 == null) goto L40;
        r15.e("SoundsMobHelper", "onPlayDataReceived. err=" + r14);
        return;
    L40:
        return;
    L42:
        return;
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L15:
        r5 = false;
        goto L16
    L8:
        if (r0 == SoundsSource.REALTIME_CALL) goto L9;
    }
}
