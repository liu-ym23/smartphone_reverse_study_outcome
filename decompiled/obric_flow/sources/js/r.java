package js;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends jm.c {
    public final Direction d;
    public final Direction e;

    public r(Direction r5, Direction r10) {
        Intrinsics.checkNotNullParameter(r5, "direction");
        Intrinsics.checkNotNullParameter(r10, "gradientAlphaDirection");
        this.d = r5;
        this.e = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r10 = (r) r5;
        Direction r11 = r10.d;
        if (this.d == r11) goto L12;
        return false;
    L12:
        if (this.e == r10.e) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(0.3f), Float.valueOf(0.3f)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(16.0f), Float.valueOf(16.0f)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.d.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(0.3f, (this.e.hashCode() + r5) * 31, 31);
        return Float.hashCode(16.0f) + r10;
    }

    public final String toString() {
        return "ScanWindow(direction=" + this.d + ", gradientAlphaDirection=" + this.e + ", featherRatio=0.3, minFeatherDp=16.0)";
    }
}
