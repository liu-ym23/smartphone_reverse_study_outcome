package ez;

import android.graphics.Bitmap;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Bitmap a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final int h;
    public final String i;
    public final HashMap<String, String> j;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L26;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Bitmap r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (((((r16 + r18) * 31) + this.g) * 31) + this.h) * 31;
        String r21 = this.i;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        HashMap<String, String> r24 = this.j;
        if (r24 == null) goto L34;
        r1 = r24.hashCode();
    L34:
        return r23 + r1;
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiSearchParams(bitmap=" + this.a + ", pageType=" + this.b + ", enterFrom=" + this.c + ", openSearchPage=" + this.d + ", enterFromSecond=" + this.e + ", searchFrom=" + this.f + ", showBg=" + this.g + ", showSelector=" + this.h + ", federationInfo=" + this.i + ", logMap=" + this.j + ")";
    }

    public a(Bitmap r5, String r6, String r7, HashMap r8) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter("result", "pageType");
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        Intrinsics.checkNotNullParameter("visual_live_screenshot_entrance", "openSearchPage");
        Intrinsics.checkNotNullParameter("visual_live_screenshot_entrance", "enterFromSecond");
        Intrinsics.checkNotNullParameter("live_screenshot_click", "searchFrom");
        Intrinsics.checkNotNullParameter(r7, "federationInfo");
        Intrinsics.checkNotNullParameter(r8, "logMap");
        this.a = r5;
        this.b = "result";
        this.c = r6;
        this.d = "visual_live_screenshot_entrance";
        this.e = "visual_live_screenshot_entrance";
        this.f = "live_screenshot_click";
        this.g = 1;
        this.h = 1;
        this.i = r7;
        this.j = r8;
    }
}
