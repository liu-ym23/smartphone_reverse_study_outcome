package fy8;

import com.larus.canvas.feature.ability.CanvasInputEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final CanvasInputEventType a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CanvasInputEvent(eventType=" + this.a + ", prompt=" + this.b + ')';
    }

    public g() {
        this(CanvasInputEventType.NONE, "");
    }

    public g(CanvasInputEventType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r3, "prompt");
        this.a = r2;
        this.b = r3;
    }
}
