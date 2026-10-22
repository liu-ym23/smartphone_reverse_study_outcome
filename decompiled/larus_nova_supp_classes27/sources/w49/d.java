package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final HeadControlGestureType a;
    public final boolean b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "HeadControlPracticeState(expectedGesture=" + this.a + ", isSuccess=" + this.b + ')';
    }

    public /* synthetic */ d(int r2) {
        this(HeadControlGestureType.NOD, false);
    }

    public d(HeadControlGestureType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "expectedGesture");
        this.a = r2;
        this.b = r3;
    }
}
