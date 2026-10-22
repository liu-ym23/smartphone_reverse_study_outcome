package com.bytedance.gkfs.storage;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4914b;

    public a() {
        this.f4913a = 0;
        this.f4914b = 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L10;
        a r10 = (a) r5;
        long r11 = r10.f4913a;
        if (this.f4913a == r11) goto L8;
        return false;
    L8:
        if (this.f4914b == r10.f4914b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r5 = this.f4913a;
        return (((int) (r5 ^ (r5 >>> 32))) * 31) + this.f4914b;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ChunkBlockIndexingInfo(offset=");
        r5.append(this.f4913a);
        r5.append(", size=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.f4914b, ")");
    }

    public a(int r5, long r10) {
        this.f4913a = r10;
        this.f4914b = r5;
    }
}
