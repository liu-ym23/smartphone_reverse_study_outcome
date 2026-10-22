package jy8;

import com.larus.canvas.service.bean.Icon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final long a;
    public final String b;
    public final Icon c;
    public final Icon d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        Icon r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        Icon r6 = this.d;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        int r7 = (r5 + r3) * 31;
        int r8 = 1231;
        if (this.e == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.f == true) goto L19;
        r8 = 1237;
    L19:
        return r10 + r8;
    L13:
        r9 = 1237;
        goto L14
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasOptionListItem(id=" + this.a + ", itemName=" + this.b + ", cover=" + this.c + ", icon=" + this.d + ", isCoverLoading=" + this.e + ", isIconLoading=" + this.f + ')';
    }

    public d(long r3, String r5, Icon r6, Icon r7, boolean r8, boolean r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r5 = "";
    L6:
        if ((r10 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r7 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r8 = false;
    L15:
        if ((r10 & 32) == 0) goto L17;
        r9 = false;
    L17:
        Intrinsics.checkNotNullParameter(r5, "itemName");
        this.a = r3;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
