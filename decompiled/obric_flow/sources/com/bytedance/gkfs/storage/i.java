package com.bytedance.gkfs.storage;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4939c;
    public final long d;
    public final long e;

    public i(long r5, long r10, int r11, int r12, long r13) {
        this.f4937a = r11;
        this.f4938b = r12;
        this.f4939c = r5;
        this.d = r10;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof i) == false) goto L16;
        i r10 = (i) r5;
        int r11 = r10.f4937a;
        if (this.f4937a == r11) goto L8;
        return false;
    L8:
        if (this.f4938b == r10.f4938b) goto L10;
        return false;
    L10:
        if (this.f4939c == r10.f4939c) goto L12;
        return false;
    L12:
        if (this.d == r10.d) goto L14;
        return false;
    L14:
        if (this.e == r10.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r5 = ((this.f4937a * 31) + this.f4938b) * 31;
        long r10 = this.f4939c;
        int r11 = (r5 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.d;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = this.e;
        return r13 + ((int) (r14 ^ (r14 >>> 32)));
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSGeneralStorageInfo(fileCount=");
        r5.append(this.f4937a);
        r5.append(", chunkCount=");
        r5.append(this.f4938b);
        r5.append(", chunkSize=");
        r5.append(this.f4939c);
        r5.append(", originSize=");
        r5.append(this.d);
        r5.append(", dilutedSize=");
        return j0.o(r5, this.e, ")");
    }
}
