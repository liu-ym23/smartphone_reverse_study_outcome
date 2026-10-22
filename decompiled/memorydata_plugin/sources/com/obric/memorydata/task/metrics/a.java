package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003Jc\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u00062"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricSample;", "", "schemaVersion", "", "windowStartUtcMs", "", "windowEndUtcMs", "snapshotAtMs", "taskType", "Lcom/obric/memorydata/task/metrics/IndexPowerTaskType;", "conditionKnownDurationMs", "conditionSatisfiedDurationMs", "taskWaitKnownDurationMs", "taskWaitUnsatisfiedDurationMs", "<init>", "(IJJJLcom/obric/memorydata/task/metrics/IndexPowerTaskType;JJJJ)V", "getSchemaVersion", "()I", "getWindowStartUtcMs", "()J", "getWindowEndUtcMs", "getSnapshotAtMs", "getTaskType", "()Lcom/obric/memorydata/task/metrics/IndexPowerTaskType;", "getConditionKnownDurationMs", "getConditionSatisfiedDurationMs", "getTaskWaitKnownDurationMs", "getTaskWaitUnsatisfiedDurationMs", "conditionSatisfiedRate", "", "getConditionSatisfiedRate", "()Ljava/lang/Double;", "taskPowerWaitRate", "getTaskPowerWaitRate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12938b;
    private final long c;
    private final long d;
    private final IndexPowerTaskType e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;

    public a(int r5, long r6, long r8, long r10, IndexPowerTaskType r12, long r13, long r15, long r17, long r19) {
        Intrinsics.checkNotNullParameter(r12, "taskType");
        this.f12937a = r5;
        this.f12938b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r13;
        this.g = r15;
        this.h = r17;
        this.i = r19;
    }

    public final int a() {
        return this.f12937a;
    }

    public final long b() {
        return this.f12938b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final IndexPowerTaskType e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        if (this.f12937a == r10.f12937a) goto L12;
        return false;
    L12:
        if (this.f12938b == r10.f12938b) goto L15;
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
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
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
        return (((((((((((((((Integer.hashCode(this.f12937a) * 31) + Long.hashCode(this.f12938b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i);
    }

    public final long i() {
        return this.i;
    }

    public String toString() {
        return "IndexPowerMetricSample(schemaVersion=" + this.f12937a + ", windowStartUtcMs=" + this.f12938b + ", windowEndUtcMs=" + this.c + ", snapshotAtMs=" + this.d + ", taskType=" + this.e + ", conditionKnownDurationMs=" + this.f + ", conditionSatisfiedDurationMs=" + this.g + ", taskWaitKnownDurationMs=" + this.h + ", taskWaitUnsatisfiedDurationMs=" + this.i + ')';
    }
}
