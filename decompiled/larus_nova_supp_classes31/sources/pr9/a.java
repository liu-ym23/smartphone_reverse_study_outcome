package pr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final int c;
    public boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.c) * 31;
        if (this.d == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CustomAosExportPreloadModel(aid=" + this.a + ", needCachePicture=" + this.b + ", priority=" + this.c + ", preloadVideoData=" + this.d + ')';
    }

    public a(String r2, boolean r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        Intrinsics.checkNotNullParameter(r2, "aid");
        this.a = r2;
        this.b = r3;
        this.c = 0;
        this.d = false;
    }
}
