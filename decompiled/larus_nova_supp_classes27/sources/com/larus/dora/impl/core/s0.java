package com.larus.dora.impl.core;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;
import qk4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 {
    public static final s0 a = null;
    public static final AtomicInteger b = null;

    public s0() {
    }

    static {
        a = new s0();
        b = new AtomicInteger(0);
    }

    public final Object a(qk4.b r16, long r17, Continuation r110) {
        if ((r110 instanceof DoraRequestX$request$2) == false) goto L7;
        DoraRequestX$request$2 r1 = (DoraRequestX$request$2) r110;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r1.J$0;
        int r6 = r1.I$0;
        qk4.b r7 = (e) r1.L$0;
        ResultKt.throwOnFailure(r0);
        long r8 = r5;
        int r9 = r6;
        qk4.b r10 = r7;
    L18:
        v39.b r11 = (v39.b) r0;
        if (r11 != null) goto L22;
        b(r9, r10, r8, true, "timeout");
        return v39.b.e.b;
    L22:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        int r12 = b.incrementAndGet();
        AtomicBoolean r13 = new AtomicBoolean(false);
        long r14 = SystemClock.elapsedRealtime();
        DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1 r15 = new DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1(null, r12, r16, r13, r14);
        r1.L$0 = r16;
        r1.I$0 = r12;
        r1.J$0 = r14;
        r1.label = 1;
        Object r18 = TimeoutKt.c(r17, r15, r1);
        if (r18 != r3) goto L17;
        return r3;
    L17:
        r9 = r12;
        r0 = r18;
        r10 = r16;
        r8 = r14;
    L7:
        r1 = new DoraRequestX$request$2(this, r110);
        goto L8
    }

    public static /* synthetic */ void c(int r6, e r7, long r8, String r10) {
        b(r6, r7, r8, false, r10);
    }

    public static final void b(int r4, e r5, long r6, boolean r8, String r9) {
        if (r8 == false) goto L5;
        g49.d.e("DoraRequestX", "id: " + r4 + ", " + r5 + ", " + r9 + ", cost: " + (SystemClock.elapsedRealtime() - r6));
        return;
    L5:
        g49.d.d("DoraRequestX", "id: " + r4 + ", " + r5 + ", " + r9 + ", cost: " + (SystemClock.elapsedRealtime() - r6));
    }
}
