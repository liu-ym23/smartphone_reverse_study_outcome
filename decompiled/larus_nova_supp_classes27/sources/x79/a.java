package x79;

import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final BaseFileSelectFromType h;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.f;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.g == true) goto L15;
        r2 = 1237;
    L15:
        return ((r6 + r2) * 31) + this.h.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BaseFileSelectConfig(fileUri=" + this.a + ", fileName=" + this.b + ", visitTime=" + this.c + ", iconRes=" + this.d + ", isSelected=" + this.e + ", thumbnailUrl=" + this.f + ", isImage=" + this.g + ", fromType=" + this.h + ')';
    }

    public a(String r3, String r4, String r5, int r6, boolean r7, BaseFileSelectFromType r8, int r9) {
        if ((r9 & 64) == 0) goto L6;
        r7 = false;
    L6:
        if ((r9 & 128) == 0) goto L8;
        r8 = BaseFileSelectFromType.LOCAL;
    L8:
        Intrinsics.checkNotNullParameter(r3, "fileUri");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "visitTime");
        Intrinsics.checkNotNullParameter(r8, "fromType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = false;
        this.f = null;
        this.g = r7;
        this.h = r8;
    }
}
