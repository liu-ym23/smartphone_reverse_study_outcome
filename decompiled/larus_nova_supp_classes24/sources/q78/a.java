package q78;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final int a;
    public final String b;
    public final int c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "AudioDeviceInfoWrapper(id=" + this.a + ", productName=" + this.b + ", type=" + this.c + ", isSource=" + this.d + ')';
    }

    public final int getType() {
        return this.c;
    }

    public a(int r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "productName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
