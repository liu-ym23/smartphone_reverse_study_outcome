package kw9;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final String a;
    public final ShareScene b;
    public final com.larus.bmhome.share.panel.h c;
    public final by7.e d;
    public final boolean e;

    public g() {
        this(null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        com.larus.bmhome.share.panel.h r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        by7.e r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L19:
        return r8 + r9;
    L17:
        r9 = 1237;
        goto L19
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SheetShareParams(token=" + this.a + ", shareScene=" + this.b + ", eventParam=" + this.c + ", trackNode=" + this.d + ", needChangeShareContent=" + this.e + ')';
    }

    public g(String r3, com.larus.bmhome.share.panel.h r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 2) == 0) goto L8;
        ShareScene r0 = ShareScene.SHEET;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        Intrinsics.checkNotNullParameter(r0, "shareScene");
        this.a = r3;
        this.b = r0;
        this.c = r4;
        this.d = null;
        this.e = false;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
