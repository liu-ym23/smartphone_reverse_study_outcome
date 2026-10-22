package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final WcbSurface a;
    public final WcbMode b;

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
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "WcbSceneKey(surface=" + this.a + ", mode=" + this.b + ')';
    }

    public d(WcbSurface r2, WcbMode r3) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        Intrinsics.checkNotNullParameter(r3, "mode");
        this.a = r2;
        this.b = r3;
    }
}
