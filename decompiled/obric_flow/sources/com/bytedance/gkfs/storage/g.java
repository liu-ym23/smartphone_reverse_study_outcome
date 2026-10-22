package com.bytedance.gkfs.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4933c;
    public final long d;
    public final long e;
    public final i f;

    public g(int r5, int r10, long r11, long r12, long r13, i r14) {
        this.f4931a = r5;
        this.f4932b = r10;
        this.f4933c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof g) == false) goto L18;
        g r10 = (g) r5;
        int r11 = r10.f4931a;
        if (this.f4931a == r11) goto L8;
        return false;
    L8:
        if (this.f4932b == r10.f4932b) goto L10;
        return false;
    L10:
        if (this.f4933c == r10.f4933c) goto L12;
        return false;
    L12:
        if (this.d == r10.d) goto L14;
        return false;
    L14:
        if (this.e == r10.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r5 = ((((this.f4931a * 31) + ((int) 0)) * 31) + this.f4932b) * 31;
        long r10 = this.f4933c;
        int r11 = (r5 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.d;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = this.e;
        int r15 = this.f.hashCode();
        return r15 + ((r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31);
    }

    public final String toString() {
        return "GkFSChunkTidyInfo(deleteChunkCount=" + this.f4931a + ", deleteChunkSize=0, refsReduceChunkCount=" + this.f4932b + ", indexingCost=" + this.f4933c + ", ioCost=" + this.d + ", timeCost=" + this.e + ", generalStorageInfo=" + this.f + ")";
    }
}
