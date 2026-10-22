package com.obric.memorydata.union.build.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SummaryCountShrink;", "", "groupsTotal", "", "groupsCountDecreased", "countSumBefore", "countSumAfter", "<init>", "(IIII)V", "getGroupsTotal", "()I", "getGroupsCountDecreased", "getCountSumBefore", "getCountSumAfter", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13140b;
    private final int c;
    private final int d;

    public s(int r1, int r2, int r3, int r4) {
        this.f13139a = r1;
        this.f13140b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final int a() {
        return this.f13139a;
    }

    public final int b() {
        return this.f13140b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.memorydata.plugin");
        if (this.f13139a == r6.f13139a) goto L12;
        return false;
    L12:
        if (this.f13140b == r6.f13140b) goto L15;
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
        return (((((Integer.hashCode(this.f13139a) * 31) + Integer.hashCode(this.f13140b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "SummaryCountShrink(groupsTotal=" + this.f13139a + ", groupsCountDecreased=" + this.f13140b + ", countSumBefore=" + this.c + ", countSumAfter=" + this.d + ')';
    }
}
