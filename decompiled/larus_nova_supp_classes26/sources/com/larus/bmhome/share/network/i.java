package com.larus.bmhome.share.network;

import androidx.fragment.app.DialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final String a;
    public final Long b;
    public final jr9.a c;
    public final SaveMessageShareInfo d;
    public final g e;
    public final com.larus.bmhome.share.panel.b f;
    public final DialogFragment g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Long r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        SaveMessageShareInfo r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        g r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.f.hashCode()) * 31;
        DialogFragment r11 = this.g;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareDetailData(usedApi=" + this.a + ", code=" + this.b + ", shareItemConfig=" + this.c + ", saveMessageShareInfo=" + this.d + ", shareCodePreviewData=" + this.e + ", flowShareContent=" + this.f + ", shareDialog=" + this.g + ')';
    }

    public i(String r3, Long r4, jr9.a r5, SaveMessageShareInfo r6, g r7, com.larus.bmhome.share.panel.b r8, DialogFragment r9, int r10) {
        if ((r10 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r10 & 16) == 0) goto L8;
        r7 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "usedApi");
        Intrinsics.checkNotNullParameter(r5, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r8, "flowShareContent");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
