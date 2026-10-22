package js;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends fj.a {
    public k(float[] r5, int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "colors");
        Intrinsics.checkNotNullParameter(r5, "positions");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        ((k) r5).getClass();
        int[] r10 = ks.b.f19477a;
        if (Arrays.equals(r10, r10) == false) goto L14;
        float[] r11 = ks.b.f19478b;
        if (Arrays.equals(r11, r11) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r5 = Arrays.hashCode(ks.b.f19477a) * 31;
        return Arrays.hashCode(ks.b.f19478b) + r5;
    }

    public final String toString() {
        return "LinearGradient(colors=" + Arrays.toString(ks.b.f19477a) + ", positions=" + Arrays.toString(ks.b.f19478b) + ')';
    }
}
