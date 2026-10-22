package t49;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final int a;
    public final List<String> b;
    public final CharSequence c;
    public final float d;
    public final int e;
    public final c f;

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        CharSequence r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31;
        c r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "Reel(id=" + this.a + ", entries=" + this.b + ", tag=" + this.c + ", widthWeight=" + this.d + ", selectedIndex=" + this.e + ", reelChangedListener=" + this.f + ')';
    }

    public b(int r2, List r3, int r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "entries");
        this.a = r2;
        this.b = r3;
        this.c = "";
        this.d = 1.0f;
        this.e = r4;
        this.f = r5;
    }
}
