package w98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final Long a;
    public final Long b;
    public final Long c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public int h;
    public int i;
    public final Long j;
    public b k;
    public int l;
    public boolean m;
    public final int n;

    public a() {
        this(null, null, null, 0, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((((r18 + r20) * 31) + this.h) * 31) + this.i) * 31;
        Long r22 = this.j;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        b r25 = this.k;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        int r26 = (((r24 + r1) * 31) + this.l) * 31;
        if (this.m == false) goto L41;
        int r27 = 1231;
    L43:
        return ((r26 + r27) * 31) + this.n;
    L41:
        r27 = 1237;
        goto L43
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveAITraceModel(startTime=" + this.a + ", wakeStartTime=" + this.b + ", p2pConnectionDurationMillis=" + this.c + ", onConnectFinishTime=" + this.d + ", onFirstVideoIFrameReceivedTime=" + this.e + ", onFirstVideoCodecInfoReceivedTime=" + this.f + ", onFirstFileDownlinkReceivedTime=" + this.g + ", frameCount=" + this.h + ", fps=" + this.i + ", disconnectTime=" + this.j + ", mirrorData=" + this.k + ", requestKeyFrameCount=" + this.l + ", hasReportedVideoInit=" + this.m + ", wakeMode=" + this.n + ')';
    }

    public a(Long r4, Long r5, Long r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 256) == 0) goto L14;
        int r0 = 2;
    L16:
        if ((r8 & 8192) == 0) goto L18;
        r7 = 0;
    L18:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = r0;
        this.j = null;
        this.k = null;
        this.l = 0;
        this.m = false;
        this.n = r7;
        return;
    L14:
        r0 = 0;
        goto L16
    }
}
