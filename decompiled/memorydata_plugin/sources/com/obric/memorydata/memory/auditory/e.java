package com.obric.memorydata.memory.auditory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/auditory/AuditoryScheduleState;", "", "intervalSeconds", "", "drainOnly", "", "<init>", "(Ljava/lang/Long;Z)V", "getIntervalSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDrainOnly", "()Z", "component1", "component2", "copy", "(Ljava/lang/Long;Z)Lcom/obric/memorydata/memory/auditory/AuditoryScheduleState;", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f10072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10073b;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public e(Long r1, boolean r2) {
        this.f10072a = r1;
        this.f10073b = r2;
    }

    public /* synthetic */ e(Long r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }

    public final Long a() {
        return this.f10072a;
    }

    public final boolean b() {
        return this.f10073b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10072a, r6.f10072a) == true) goto L12;
        return false;
    L12:
        if (this.f10073b == r6.f10073b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r0 = this.f10072a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Boolean.hashCode(this.f10073b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "AuditoryScheduleState(intervalSeconds=" + this.f10072a + ", drainOnly=" + this.f10073b + ')';
    }
}
