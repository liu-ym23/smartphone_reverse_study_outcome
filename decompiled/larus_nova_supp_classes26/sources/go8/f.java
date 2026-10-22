package go8;

import com.larus.bmhome.chat.layout.widget.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final int a;
    public final boolean b;
    public final u c;
    public final float d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d);
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetViewInput(maxWidth=" + this.a + ", needAdjustCorner=" + this.b + ", widgetRenderData=" + this.c + ", radius=" + this.d + ')';
    }

    public f(int r2, boolean r3, u r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "widgetRenderData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
