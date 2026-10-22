package zt8;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Integer e;
    public final boolean f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        Integer r8 = this.e;
        if (r8 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r7 + r9) * 31;
        if (this.f == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.g == true) goto L27;
        r2 = 1237;
    L27:
        return r12 + r2;
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = r8.hashCode();
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "HostWebFragmentConfig(url=" + this.a + ", hideTitleBar=" + this.b + ", isNotFullPage=" + this.c + ", isShowProgressBar=" + this.d + ", webViewBgColor=" + this.e + ", hideGoForwardAndBack=" + this.f + ", offscreenPreRaster=" + this.g + ')';
    }

    public b(String r3, boolean r4, boolean r5, Integer r6, boolean r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r4 = true;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r5 = true;
    L9:
        if ((r8 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 64) == 0) goto L14;
        r7 = false;
    L14:
        Intrinsics.checkNotNullParameter(r3, ShareType.URL);
        this.a = r3;
        this.b = true;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
        this.g = r7;
    }
}
