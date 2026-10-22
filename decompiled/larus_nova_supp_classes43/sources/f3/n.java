package f3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public final boolean a;
    public final String b;
    public final j c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof n) == true) goto L8;
        return false;
    L8:
        n r11 = (n) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "ParamFieldModel(required=" + this.a + ", keyPath=" + this.b + ", defaultValue=" + this.c + ')';
    }

    public n() {
        this(false, "", new j(0));
    }

    public n(boolean r10, String r11, j r12) {
        Intrinsics.checkNotNullParameter(r11, "keyPath");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
