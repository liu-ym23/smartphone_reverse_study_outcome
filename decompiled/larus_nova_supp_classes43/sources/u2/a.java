package u2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final b a;
    public final h b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final String i;
    public boolean j;
    public boolean k;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
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
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        int r10 = 1231;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (((((r0 + r1) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L9;
        int r12 = 1231;
    L10:
        int r13 = (r11 + r12) * 31;
        if (this.k == true) goto L15;
        r10 = 1237;
    L15:
        return r13 + r10;
    L9:
        r12 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletGrantingCardData(msgData=" + this.a + ", grantingType=" + this.b + ", icon=" + this.c + ", sourceName=" + this.d + ", title=" + this.e + ", subTitle=" + this.f + ", showOperateButton=" + this.g + ", agreeTitle=" + this.h + ", rejectedTitle=" + this.i + ", agreeLoading=" + this.j + ", rejectedLoading=" + this.k + ')';
    }

    public static a a(a r16, boolean r17, boolean r18, int r19) {
        String r10 = null;
        if ((r19 & 1) == 0) goto L5;
        b r11 = r16.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        h r12 = r16.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r13 = r16.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r14 = r16.d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r15 = r16.e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r110 = r16.f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        boolean r111 = r16.g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r112 = r16.h;
    L35:
        if ((r19 & 256) == 0) goto L37;
        r10 = r16.i;
    L37:
        String r113 = r10;
        if ((r19 & 512) == 0) goto L40;
        boolean r114 = r16.j;
    L42:
        if ((r19 & 1024) == 0) goto L44;
        boolean r115 = r16.k;
    L45:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r11, "msgData");
        Intrinsics.checkNotNullParameter(r12, "grantingType");
        Intrinsics.checkNotNullParameter(r13, "icon");
        Intrinsics.checkNotNullParameter(r14, "sourceName");
        Intrinsics.checkNotNullParameter(r15, "title");
        Intrinsics.checkNotNullParameter(r110, "subTitle");
        Intrinsics.checkNotNullParameter(r112, "agreeTitle");
        Intrinsics.checkNotNullParameter(r113, "rejectedTitle");
        return new a(r11, r12, r13, r14, r15, r110, r111, r112, r113, r114, r115);
    L44:
        r115 = r18;
        goto L45
    L40:
        r114 = r17;
        goto L42
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = false;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r15 = null;
        goto L23
    L17:
        r14 = null;
        goto L19
    L13:
        r13 = null;
        goto L15
    L9:
        r12 = null;
        goto L11
    L5:
        r11 = null;
        goto L7
    }

    public a(b r10, h r11, String r12, String r13, String r14, String r15, boolean r16, String r17, String r18, boolean r19, boolean r110) {
        Intrinsics.checkNotNullParameter(r10, "msgData");
        Intrinsics.checkNotNullParameter(r11, "grantingType");
        Intrinsics.checkNotNullParameter(r12, "icon");
        Intrinsics.checkNotNullParameter(r13, "sourceName");
        Intrinsics.checkNotNullParameter(r14, "title");
        Intrinsics.checkNotNullParameter(r15, "subTitle");
        Intrinsics.checkNotNullParameter(r17, "agreeTitle");
        Intrinsics.checkNotNullParameter(r18, "rejectedTitle");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
    }
}
