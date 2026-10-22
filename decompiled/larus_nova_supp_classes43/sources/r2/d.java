package r2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final a e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
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
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.d;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return ((r12 + r10) * 31) + this.e.hashCode();
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletChatActionBarGroupItem(id=" + this.a + ", title=" + this.b + ", iconUrl=" + this.c + ", darkModeIconUrl=" + this.d + ", action=" + this.e + ')';
    }

    public d(String r10, String r11, String r12, String r13, a r14) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r14, "action");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
