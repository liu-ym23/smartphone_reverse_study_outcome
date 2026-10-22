package t38;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final List<String> b;
    public final int c;
    public final String d;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoubaoOpenAuthCodeRequest(clientKey=" + this.a + ", scopes=" + this.b + ", aid=" + this.c + ", source=" + this.d + ')';
    }

    public a(List r4) {
        Intrinsics.checkNotNullParameter("tyfhrugobjy5d9cu", "clientKey");
        Intrinsics.checkNotNullParameter(r4, "scopes");
        Intrinsics.checkNotNullParameter("jsb", "source");
        this.a = "tyfhrugobjy5d9cu";
        this.b = r4;
        this.c = 482431;
        this.d = "jsb";
    }
}
