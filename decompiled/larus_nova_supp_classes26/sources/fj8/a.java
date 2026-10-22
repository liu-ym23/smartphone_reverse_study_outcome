package fj8;

import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final ButtonStatus d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return ((((((((((r4 + r1) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BrowserControlBlockInput(isFold=" + this.a + ", forceHideArrow=" + this.b + ", disableHeaderInteraction=" + this.c + ", buttonStatus=" + this.d + ", title=" + this.e + ", url=" + this.f + ", leftDarkIcon=" + this.g + ", leftLightIcon=" + this.h + ')';
    }

    public a(boolean r2, boolean r3, boolean r4, ButtonStatus r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "buttonStatus");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r7, ShareType.URL);
        Intrinsics.checkNotNullParameter(r8, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r9, "leftLightIcon");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
