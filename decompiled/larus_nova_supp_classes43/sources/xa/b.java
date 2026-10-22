package xa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b<T> {
    public final PredictElementType a;
    public final T b;
    public final double c;

    public final String toString() {
        return "Prediction(elementType=" + this.a + ", value=" + this.b + ", confidence=" + this.c + ')';
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        T r1 = this.b;
        if (r1 == null) goto L5;
        int r10 = r1.hashCode();
    L7:
        return r0 + r10;
    L5:
        r10 = 0;
        goto L7
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.b, r11.b) == false) goto L13;
        return true;
    }

    public b(PredictElementType r10, T r11, double r12) {
        Intrinsics.checkNotNullParameter(r10, "elementType");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
