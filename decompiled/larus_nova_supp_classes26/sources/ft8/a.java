package ft8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final RectF a;
    public final RectF b;
    public final int c;
    public final int d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "CropEditOperation(showRect=" + this.a + ", totalRect=" + this.b + ", angle=" + this.c + ", sourceWidth=" + this.d + ", sourceHeight=" + this.e + ')';
    }

    public a(RectF r2, RectF r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "showRect");
        Intrinsics.checkNotNullParameter(r3, "totalRect");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
