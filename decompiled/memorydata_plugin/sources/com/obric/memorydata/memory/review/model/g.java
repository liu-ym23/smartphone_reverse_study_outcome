package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J=\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "pageCursor", "", "pageSize", "", "observeFromTimeMillis", "", "windowEndTimeMillis", "<init>", "(Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;Ljava/lang/String;IJJ)V", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getPageCursor", "()Ljava/lang/String;", "getPageSize", "()I", "getObserveFromTimeMillis", "()J", "getWindowEndTimeMillis", "normalizedPageSize", "getNormalizedPageSize", "cursor", "getCursor", "startTimeMillis", "getStartTimeMillis", "endTimeMillis", "getEndTimeMillis", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryReviewModule f10391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10392b;
    private final int c;
    private final long d;
    private final long e;

    public g(MemoryReviewModule r2, String r3, int r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "module");
        this.f10391a = r2;
        this.f10392b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }

    public final MemoryReviewModule a() {
        return this.f10391a;
    }

    public final String b() {
        return this.f10392b;
    }

    public final long c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final int e() {
        return RangesKt.coerceIn(this.c, 1, 10);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (this.f10391a == r10.f10391a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10392b, r10.f10392b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10391a.hashCode() * 31;
        String r1 = this.f10392b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryReviewPageRequest(module=" + this.f10391a + ", pageCursor=" + this.f10392b + ", pageSize=" + this.c + ", observeFromTimeMillis=" + this.d + ", windowEndTimeMillis=" + this.e + ')';
    }
}
