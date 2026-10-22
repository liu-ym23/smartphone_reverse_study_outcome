package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerObservation;", "", "commonSatisfied", "", "strictlySatisfied", "fastTaskWaiting", "slowTaskWaiting", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZ)V", "getCommonSatisfied", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStrictlySatisfied", "getFastTaskWaiting", "()Z", "getSlowTaskWaiting", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZ)Lcom/obric/memorydata/task/metrics/IndexPowerObservation;", "equals", "other", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f12950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f12951b;
    private final boolean c;
    private final boolean d;

    public l(Boolean r1, Boolean r2, boolean r3, boolean r4) {
        this.f12950a = r1;
        this.f12951b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Boolean a() {
        return this.f12950a;
    }

    public final Boolean b() {
        return this.f12951b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12950a, r6.f12950a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12951b, r6.f12951b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.f12950a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.f12951b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IndexPowerObservation(commonSatisfied=" + this.f12950a + ", strictlySatisfied=" + this.f12951b + ", fastTaskWaiting=" + this.c + ", slowTaskWaiting=" + this.d + ')';
    }
}
