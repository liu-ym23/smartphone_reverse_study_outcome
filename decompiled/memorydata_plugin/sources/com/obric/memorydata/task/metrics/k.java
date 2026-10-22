package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsTotals;", "", "commonKnownDurationMs", "", "commonSatisfiedDurationMs", "strictlyKnownDurationMs", "strictlySatisfiedDurationMs", "fastTaskWaitingKnownDurationMs", "fastTaskWaitingUnsatisfiedDurationMs", "slowTaskWaitingKnownDurationMs", "slowTaskWaitingUnsatisfiedDurationMs", "<init>", "(JJJJJJJJ)V", "getCommonKnownDurationMs", "()J", "getCommonSatisfiedDurationMs", "getStrictlyKnownDurationMs", "getStrictlySatisfiedDurationMs", "getFastTaskWaitingKnownDurationMs", "getFastTaskWaitingUnsatisfiedDurationMs", "getSlowTaskWaitingKnownDurationMs", "getSlowTaskWaitingUnsatisfiedDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12949b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;

    public k() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public k(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18) {
        this.f12948a = r4;
        this.f12949b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r18;
    }

    public /* synthetic */ k(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, int r35, DefaultConstructorMarker r36) {
        long r2 = 0;
        if ((r35 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r35 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r35 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r12 = 0;
    L23:
        if ((r35 & 32) == 0) goto L25;
        long r14 = 0;
    L27:
        if ((r35 & 64) == 0) goto L29;
        long r16 = 0;
    L31:
        if ((r35 & 128) != 0) goto L34;
        r2 = r33;
    L34:
        this(r4, r6, r8, r10, r12, r14, r16, r2);
        return;
    L29:
        r16 = r31;
        goto L31
    L25:
        r14 = r29;
        goto L27
    L21:
        r12 = r27;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r8 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public final long a() {
        return this.f12948a;
    }

    public final k a(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) {
        return new k(r19, r21, r23, r25, r27, r29, r31, r33);
    }

    public final long b() {
        return this.f12949b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.memorydata.plugin");
        if (this.f12948a == r10.f12948a) goto L12;
        return false;
    L12:
        if (this.f12949b == r10.f12949b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f12948a) * 31) + Long.hashCode(this.f12949b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h);
    }

    public String toString() {
        return "IndexPowerMetricsTotals(commonKnownDurationMs=" + this.f12948a + ", commonSatisfiedDurationMs=" + this.f12949b + ", strictlyKnownDurationMs=" + this.c + ", strictlySatisfiedDurationMs=" + this.d + ", fastTaskWaitingKnownDurationMs=" + this.e + ", fastTaskWaitingUnsatisfiedDurationMs=" + this.f + ", slowTaskWaitingKnownDurationMs=" + this.g + ", slowTaskWaitingUnsatisfiedDurationMs=" + this.h + ')';
    }
}
