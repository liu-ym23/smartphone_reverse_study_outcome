package yq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final long a;
    public final long b;
    public final String c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.c;
        if (r4 != null) goto L5;
        int r5 = 0;
    L7:
        return r2 + r5;
    L5:
        r5 = r4.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowDataLoaderCacheInfo(mediaSize=" + this.a + ", cacheSizeFromZero=" + this.b + ", localFilePath=" + this.c + ')';
    }

    public /* synthetic */ a(int r7) {
        this(0, 0, null);
    }

    public a(long r1, long r3, String r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
