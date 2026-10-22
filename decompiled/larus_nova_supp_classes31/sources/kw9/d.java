package kw9;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final String a;
    public final int b;
    public final ShareScene c;
    public final com.larus.bmhome.share.panel.h d;
    public final by7.e e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        com.larus.bmhome.share.panel.h r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        by7.e r5 = this.e;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        if (this.f == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveShareParams(fileToken=" + this.a + ", fileType=" + this.b + ", shareScene=" + this.c + ", eventParam=" + this.d + ", trackNode=" + this.e + ", needChangeShareContent=" + this.f + ')';
    }

    public d(String r2, int r3, ShareScene r4, com.larus.bmhome.share.panel.h r5) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r4, "shareScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = false;
    }
}
