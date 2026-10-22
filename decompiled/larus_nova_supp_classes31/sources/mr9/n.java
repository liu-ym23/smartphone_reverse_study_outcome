package mr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public final String a;
    public final String b;
    public final e c;

    public n() {
        this("", "", null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        e r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "VideoUploadResult(vid=" + this.a + ", space=" + this.b + ", meta=" + this.c + ')';
    }

    public n(String r2, String r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        Intrinsics.checkNotNullParameter(r3, "space");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
