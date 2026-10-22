package com.bytedance.gkfs.io;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final k d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4885c;

    static {
        d = new k(0, 0, 6);
    }

    public k(int r5, long r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 1;
    L6:
        if ((r11 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        this.f4883a = r5;
        this.f4884b = 0;
        this.f4885c = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof k) == false) goto L12;
        k r10 = (k) r5;
        int r11 = r10.f4883a;
        if (this.f4883a == r11) goto L8;
        return false;
    L8:
        if (this.f4884b == r10.f4884b) goto L10;
        return false;
    L10:
        if (this.f4885c == r10.f4885c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f4883a * 31;
        long r10 = this.f4884b;
        int r11 = (r5 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.f4885c;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSFileHeaderMeta(version=");
        r5.append(this.f4883a);
        r5.append(", fileOriginSize=");
        r5.append(this.f4884b);
        r5.append(", size=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f4885c, ')');
    }

    public k(int r5, long r10, long r11) {
        this.f4883a = r5;
        this.f4884b = r10;
        this.f4885c = r11;
    }
}
