package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final BubbleBannerSource a;
    public final String b;
    public final String c;
    public final com.larus.bmhome.chat.bubble.floating.a d;
    public final String e;
    public final h f;
    public final c g;
    public final a h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.f.hashCode()) * 31;
        c r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        a r11 = this.h;
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
        return "BubbleBannerInput(source=" + this.a + ", conversationId=" + this.b + ", bannerSource=" + this.c + ", uiStyle=" + this.d + ", queryMessageId=" + this.e + ", strategy=" + this.f + ", extraInfo=" + this.g + ", clickAction=" + this.h + ')';
    }

    public d(BubbleBannerSource r2, String r3, String r4, com.larus.bmhome.chat.bubble.floating.a r5, String r6, h r7, c r8, a r9) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "uiStyle");
        Intrinsics.checkNotNullParameter(r7, "strategy");
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
