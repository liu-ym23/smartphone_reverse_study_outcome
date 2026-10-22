package fn8;

import android.util.Size;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final RichMediaKind e;
    public final String f;
    public final Size g;
    public final String h;
    public final d0 i;
    public final String j;
    public final List<a> k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final String o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        d0 r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.k.hashCode()) * 31;
        int r14 = 1231;
        if (this.l == false) goto L21;
        int r15 = 1231;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.m == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.n == true) goto L30;
        r14 = 1237;
    L30:
        int r19 = (r18 + r14) * 31;
        String r20 = this.o;
        if (r20 == null) goto L35;
        r2 = r20.hashCode();
    L35:
        return r19 + r2;
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "RichMediaItemViewConfig(stableKey=" + this.a + ", position=" + this.b + ", blockId=" + this.c + ", messageId=" + this.d + ", mediaKind=" + this.e + ", coverUrl=" + this.f + ", itemSize=" + this.g + ", bizTag=" + this.h + ", sourceIcon=" + this.i + ", caption=" + this.j + ", actions=" + this.k + ", enableInlinePlayback=" + this.l + ", autoPlayAnimatedCover=" + this.m + ", enableCreationSingleImageExposure=" + this.n + ", creationSingleImageExposureCellId=" + this.o + ')';
    }

    public x(String r9, int r10, String r11, String r12, RichMediaKind r13, String r14, Size r15, String r16, d0 r17, String r18, List<a> r19, boolean r20, boolean r21, boolean r22, String r23) {
        Intrinsics.checkNotNullParameter(r9, "stableKey");
        Intrinsics.checkNotNullParameter(r13, "mediaKind");
        Intrinsics.checkNotNullParameter(r14, "coverUrl");
        Intrinsics.checkNotNullParameter(r15, "itemSize");
        Intrinsics.checkNotNullParameter(r16, "bizTag");
        Intrinsics.checkNotNullParameter(r19, "actions");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
    }
}
