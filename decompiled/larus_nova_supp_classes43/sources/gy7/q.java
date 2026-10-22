package gy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public final String a;
    public final String b;

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof q) == true) goto L8;
        return false;
    L8:
        q r11 = (q) r10;
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.a, r11.a) == false) goto L13;
        return true;
    }

    public q(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        Intrinsics.checkNotNullParameter(r11, "sessionKey");
        this.b = r10;
        this.a = r11;
    }
}
