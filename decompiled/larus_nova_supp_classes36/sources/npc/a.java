package npc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        long r1 = this.d;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "DoubaoFileForwardRequest(resourceUri=" + this.a + ", fileName=" + this.b + ", storageType=" + this.c + ", fileSize=" + this.d + ", mimeType=" + this.e + ')';
    }

    public final boolean a() {
        if ((!StringsKt.isBlank(this.a)) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.b)) == false) goto L9;
        if (this.c <= 0) goto L9;
        return true;
    }

    public a(String r2, String r3, int r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r2, "resourceUri");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        Intrinsics.checkNotNullParameter(r7, "mimeType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
