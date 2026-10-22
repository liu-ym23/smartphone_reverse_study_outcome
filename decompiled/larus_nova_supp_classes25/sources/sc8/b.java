package sc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final long i;
    public final int j;
    public final BubbleBannerSource k;
    public final pc8.c l;
    public final Map<String, String> m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r4 = this.f;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.h;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.i;
        int r14 = (((((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.j) * 31) + this.k.hashCode()) * 31;
        pc8.c r15 = this.l;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        Map<String, String> r18 = this.m;
        if (r18 == null) goto L27;
        r1 = r18.hashCode();
    L27:
        return r17 + r1;
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerEvent(bannerSource=" + this.a + ", promptId=" + this.b + ", conversationId=" + this.c + ", queryMessageId=" + this.d + ", title=" + this.e + ", content=" + this.f + ", icon=" + this.g + ", buttonText=" + this.h + ", autoDismissSeconds=" + this.i + ", priority=" + this.j + ", source=" + this.k + ", extraInfo=" + this.l + ", ext=" + this.m + ')';
    }

    public b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, long r10, int r12, BubbleBannerSource r13, pc8.c r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r3, "promptId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "queryMessageId");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r13, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
    }
}
