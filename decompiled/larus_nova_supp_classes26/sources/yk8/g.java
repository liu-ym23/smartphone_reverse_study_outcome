package yk8;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final Integer a;
    public final int b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final vl8.g j;
    public final Integer k;

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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r4 = 1231;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.h == true) goto L18;
        r4 = 1237;
    L18:
        int r9 = (((((r8 + r4) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        Integer r10 = this.k;
        if (r10 == null) goto L23;
        r1 = r10.hashCode();
    L23:
        return r9 + r1;
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FileCardViewInput(iconRes=" + this.a + ", fallbackIconRes=" + this.b + ", fileName=" + this.c + ", fileType=" + this.d + ", showFileType=" + this.e + ", fileSizeText=" + this.f + ", showFileActions=" + this.g + ", showPlayAudioButton=" + this.h + ", url=" + this.i + ", playbackState=" + this.j + ", rootBackgroundRes=" + this.k + ')';
    }

    public g(Integer r2, int r3, String r4, String r5, boolean r6, String r7, boolean r8, boolean r9, String r10, vl8.g r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "fileType");
        Intrinsics.checkNotNullParameter(r7, "fileSizeText");
        Intrinsics.checkNotNullParameter(r10, ShareType.URL);
        Intrinsics.checkNotNullParameter(r11, "playbackState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
