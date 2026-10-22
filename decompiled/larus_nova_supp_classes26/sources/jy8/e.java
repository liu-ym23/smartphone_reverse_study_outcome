package jy8;

import com.larus.canvas.service.bean.Icon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final long a;
    public final String b;
    public final String c;
    public final boolean d;
    public final Icon e;
    public final boolean f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r1 + r3) * 31;
        Icon r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.f == true) goto L15;
        r2 = 1237;
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "DropDownBoxSelectItem(id=" + this.a + ", itemName=" + this.b + ", desc=" + this.c + ", isSelected=" + this.d + ", icon=" + this.e + ", showDivider=" + this.f + ')';
    }

    public e(long r2, String r4, String r5, boolean r6, Icon r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "itemName");
        Intrinsics.checkNotNullParameter(r5, "desc");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
