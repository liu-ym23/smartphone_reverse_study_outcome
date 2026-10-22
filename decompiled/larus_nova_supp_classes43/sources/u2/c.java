package u2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final b f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.f.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoubaoAppsMeta(doubaoAppletKey=" + this.a + ", doubaoAppletName=" + this.b + ", doubaoAppletIcon=" + this.c + ", doubaoAppletVersion=" + this.d + ", doubaoAppletType=" + this.e + ", messageData=" + this.f + ')';
    }

    public c(String r10, String r11, String r12, String r13, String r14, b r15) {
        Intrinsics.checkNotNullParameter(r10, "doubaoAppletKey");
        Intrinsics.checkNotNullParameter(r11, "doubaoAppletName");
        Intrinsics.checkNotNullParameter(r12, "doubaoAppletIcon");
        Intrinsics.checkNotNullParameter(r13, "doubaoAppletVersion");
        Intrinsics.checkNotNullParameter(r15, "messageData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
