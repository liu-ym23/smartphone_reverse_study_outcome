package com.larus.bmhome.chat;

import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 implements t1a.c {
    public volatile int A;
    public volatile int B;
    public long C;
    public final String a;
    public final long b;
    public final long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public volatile long s;
    public volatile int t;
    public String u;
    public String v;
    public boolean w;
    public long x;
    public volatile int y;
    public volatile int z;

    public static final class a {
    }

    static {
    }

    public i1() {
        this(0, 0, 1048575);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r9 = (i1) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.e;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.f;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.g;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.h;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.i;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        long r17 = this.j;
        int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        long r19 = this.k;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.l;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.m;
        int r24 = (r22 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
        long r25 = this.n;
        int r26 = (r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31;
        long r27 = this.o;
        int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
        long r29 = this.p;
        int r30 = (r28 + ((int) (r29 ^ (r29 >>> 32)))) * 31;
        long r31 = this.q;
        int r32 = (r30 + ((int) (r31 ^ (r31 >>> 32)))) * 31;
        long r33 = this.r;
        int r34 = (r32 + ((int) (r33 ^ (r33 >>> 32)))) * 31;
        long r35 = this.s;
        return ((r34 + ((int) (r35 ^ (r35 >>> 32)))) * 31) + this.t;
    }

    public final String toString() {
        return "ChatPageMetrics(pageTraceId=" + this.a + ", initTime=" + this.b + ", imInitTime=" + this.c + ", createStartTime=" + this.d + ", createViewStartTime=" + this.e + ", startTime=" + this.f + ", resumeStartTime=" + this.g + ", resumeEndTime=" + this.h + ", conversationChangeStartTime=" + this.i + ", conversationChangeEndTime=" + this.j + ", botChangeStartTime=" + this.k + ", botChangeEndTime=" + this.l + ", actionBarLoadStartTime=" + this.m + ", actionBarFirstFrameTime=" + this.n + ", wcbLoadedTime=" + this.o + ", localMsgListCallbackTime=" + this.p + ", remoteMsgListCallbackTime=" + this.q + ", localMsgListRenderTime=" + this.r + ", remoteMsgListRenderTime=" + this.s + ", firstScreenMsgListCount=" + this.t + ')';
    }

    public final synchronized void a(String r11, long r12) {
        monitor-enter(this);
        long r1 = this.x;     // Catch: Throwable -> L21
        if (r1 > 0) goto L7;
    L9:
        long r2 = 0;
    L10:
        long r5 = this.b;     // Catch: Throwable -> L21
        if (r5 > 0) goto L13;
    L15:
        long r6 = 0;
    L16:
        FLogger.a.d("ChatPageMetrics", "record stage=" + r11 + " delta=" + r2 + " pageDuration=" + r6);     // Catch: Throwable -> L21
        if (r12 <= 0) goto L19;
        this.x = r12;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L13:
        if (r12 <= 0) goto L15;
        r6 = r12 - r5;     // Catch: Throwable -> L21
        goto L16
    L7:
        if (r12 <= 0) goto L9;
        r2 = r12 - r1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public i1(long r5, long r7, int r9) {
        if ((r9 & 1) == 0) goto L5;
        String r0 = UUID.randomUUID().toString();
    L7:
        if ((r9 & 2) == 0) goto L10;
        r5 = 0;
    L10:
        if ((r9 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        if ((r9 & 524288) == 0) goto L15;
        int r10 = -1;
    L16:
        Intrinsics.checkNotNullParameter(r0, "pageTraceId");
        this.a = r0;
        this.b = r5;
        this.c = r7;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = r10;
        this.u = "";
        this.v = "";
        FLogger.a.d("ChatPageMetrics", "record stage=initTime time=" + r5 + " pageTraceId=" + r0);
        this.x = r5;
        return;
    L15:
        r10 = 0;
        goto L16
    L5:
        r0 = null;
        goto L7
    }
}
