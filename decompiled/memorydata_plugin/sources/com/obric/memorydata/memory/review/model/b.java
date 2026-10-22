package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewCursorValue;", "", "windowEndTimeMillis", "", "lastCreatedAt", "lastRecordId", "", "<init>", "(JJLjava/lang/String;)V", "getWindowEndTimeMillis", "()J", "getLastCreatedAt", "getLastRecordId", "()Ljava/lang/String;", "updateTimeMillis", "getUpdateTimeMillis", "recordId", "getRecordId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10383b;
    private final String c;

    public b(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "lastRecordId");
        this.f10382a = r2;
        this.f10383b = r4;
        this.c = r6;
    }

    public final long a() {
        return this.f10382a;
    }

    public final long b() {
        return this.f10383b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (this.f10382a == r10.f10382a) goto L12;
        return false;
    L12:
        if (this.f10383b == r10.f10383b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f10382a) * 31) + Long.hashCode(this.f10383b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MemoryReviewCursorValue(windowEndTimeMillis=" + this.f10382a + ", lastCreatedAt=" + this.f10383b + ", lastRecordId=" + this.c + ')';
    }
}
