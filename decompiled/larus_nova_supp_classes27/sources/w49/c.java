package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final HeadControlActionOption a;
    public final HeadControlActionOption b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "HeadControlOptionState(nodOption=" + this.a + ", shakeOption=" + this.b + ')';
    }

    public /* synthetic */ c(int r1) {
        HeadControlActionOption r2 = HeadControlActionOption.NONE;
        this(r2, r2);
    }

    public c(HeadControlActionOption r2, HeadControlActionOption r3) {
        Intrinsics.checkNotNullParameter(r2, "nodOption");
        Intrinsics.checkNotNullParameter(r3, "shakeOption");
        this.a = r2;
        this.b = r3;
    }

    public static c a(c r1, HeadControlActionOption r2, HeadControlActionOption r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.b;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "nodOption");
        Intrinsics.checkNotNullParameter(r3, "shakeOption");
        return new c(r2, r3);
    }
}
