package li;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f19663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f19664b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r5;
        if (Intrinsics.areEqual(this.f19663a, r10.f19663a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19664b, r10.f19664b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String[] r5 = this.f19663a;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = this.f19664b.hashCode();
        return r11 + (r10 * 31);
    L5:
        r10 = Arrays.hashCode(r5);
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxAuthStrategyConfig(lynxSignVerifyWhiteList=");
        r5.append(Arrays.toString(this.f19663a));
        r5.append(", forceDegradeCodeList=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f19664b, ')');
    }
}
