package wia;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w {
    public final long a;
    public final String b;
    public final String c;
    public final int d;
    public final com.obric.capabilitykit.m e;

    public w(long r2, String r4, String r5, int r6, com.obric.capabilitykit.m r7) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r7, "action");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public /* synthetic */ w(String r8, String r9, int r10, com.obric.capabilitykit.m r11) {
        this(-1, r8, r9, r10, r11);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w) == true) goto L8;
        return false;
    L8:
        w r9 = (w) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "EntityHistoryDao(indexId=" + this.a + ", id=" + this.b + ", data=" + this.c + ", type=" + this.d + ", action=" + this.e + ')';
    }
}
