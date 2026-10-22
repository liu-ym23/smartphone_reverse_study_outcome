package fy8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final int a;
    public final Map<String, String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "InstructionInitConfig(canvasType=" + this.a + ", traceMap=" + this.b + ')';
    }

    public l(int r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "traceMap");
        this.a = r2;
        this.b = r3;
    }
}
