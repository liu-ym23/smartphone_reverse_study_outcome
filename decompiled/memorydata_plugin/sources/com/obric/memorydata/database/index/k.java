package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/index/CoverageRoundInitialization;", "", "policyVersion", "", "sourceTimestamp", "", "requiredCount", "state", "<init>", "(IJII)V", "getPolicyVersion", "()I", "getSourceTimestamp", "()J", "getRequiredCount", "getState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9422b;
    private final int c;
    private final int d;

    public k() {
        this(0, 0, 0, 0, 15, null);
    }

    public k(int r1, long r2, int r4, int r5) {
        this.f9421a = r1;
        this.f9422b = r2;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ k(int r2, long r3, int r5, int r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = -1;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0;
    L14:
        this(r2, r3, r5, r6);
    }

    public final int a() {
        return this.f9421a;
    }

    public final long b() {
        return this.f9422b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.memorydata.plugin");
        if (this.f9421a == r10.f9421a) goto L12;
        return false;
    L12:
        if (this.f9422b == r10.f9422b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f9421a) * 31) + Long.hashCode(this.f9422b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "CoverageRoundInitialization(policyVersion=" + this.f9421a + ", sourceTimestamp=" + this.f9422b + ", requiredCount=" + this.c + ", state=" + this.d + ')';
    }
}
