package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.monitor.TriggerStage;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 {
    public final z64.c a;
    public final String b;
    public final int c;
    public final TriggerStage d;
    public final boolean e;
    public final long f;
    public final long g;
    public final AtomicLong h;
    public final com.bytedance.badger.C.a i;

    public /* synthetic */ n0(z64.c r13, int r14, TriggerStage r15, com.bytedance.badger.C.a r16, int r17) {
        if ((r17 & 32) == 0) goto L5;
        long r6 = SystemClock.elapsedRealtime();
    L7:
        if ((r17 & 64) == 0) goto L9;
        long r8 = SystemClock.uptimeMillis();
    L11:
        if ((r17 & 128) == 0) goto L13;
        AtomicLong r1 = new AtomicLong(0);
    L14:
        AtomicLong r10 = r1;
        if ((r17 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L17;
        com.bytedance.badger.C.a r12 = com.bytedance.badger.C.a.b;
    L18:
        this(r13, "/passport/dtrait/sinr/", r14, r15, false, r6, r8, r10, r12);
        return;
    L17:
        r12 = r16;
        goto L18
    L13:
        r1 = null;
        goto L14
    L9:
        r8 = 0;
        goto L11
    L5:
        r6 = 0;
        goto L7
    }

    public n0(z64.c r1, String r2, int r3, TriggerStage r4, boolean r5, long r6, long r8, AtomicLong r10, com.bytedance.badger.C.a r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r10;
        this.i = r12;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L38:
        return true;
    L5:
        if ((r8 instanceof n0) == false) goto L37;
        n0 r9 = (n0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == false) goto L37;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L37;
        if (this.c != r9.c) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L37;
        if (Intrinsics.areEqual(this.d, r9.d) == false) goto L37;
        if (this.e != r9.e) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L37;
        if (this.f != r9.f) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L37;
        if (this.g != r9.g) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == false) goto L37;
        if (Intrinsics.areEqual(this.h, r9.h) == false) goto L37;
        if (Intrinsics.areEqual(this.i, r9.i) == false) goto L37;
    L30:
        r4 = false;
        goto L31
    L25:
        r3 = false;
        goto L26
    L20:
        r2 = false;
        goto L21
    L13:
        r1 = false;
    L37:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        z64.c r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        TriggerStage r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.e;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        long r14 = this.f;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.g;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        AtomicLong r18 = this.h;
        if (r18 == null) goto L20;
        int r19 = r18.hashCode();
    L21:
        int r20 = (r17 + r19) * 31;
        com.bytedance.badger.C.a r22 = this.i;
        if (r22 == null) goto L25;
        r1 = r22.hashCode();
    L25:
        return r20 + r1;
    L20:
        r19 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportContext(request=" + this.a + ", path=" + this.b + ", timeout=" + this.c + ", triggerStage=" + this.d + ", isTimeoutRetry=" + this.e + ", startTime=" + this.f + ", startUptime=" + this.g + ", timeoutElapsedTimeMs=" + this.h + ", compensateType=" + this.i + ")";
    }
}
