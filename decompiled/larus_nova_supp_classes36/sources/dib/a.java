package dib;

import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final int a;
    public final int b;
    public final ArrowDirection c;
    public final float d;
    public final float e;

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
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        return "PopoverPosition(popoverLeft=" + this.a + ", popoverTop=" + this.b + ", arrowDirection=" + this.c + ", arrowX=" + this.d + ", arrowY=" + this.e + ')';
    }

    public a(int r2, int r3, ArrowDirection r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r4, "arrowDirection");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
