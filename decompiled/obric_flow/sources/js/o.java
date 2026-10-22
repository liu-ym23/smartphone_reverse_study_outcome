package js;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Direction f18474a;

    public o(Direction r5) {
        Intrinsics.checkNotNullParameter(r5, "blurDirection");
        this.f18474a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L9;
        return false;
    L9:
        if (this.f18474a == ((o) r5).f18474a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f18474a.hashCode();
    }

    public final String toString() {
        return "MaterialLayerSpec(blurDirection=" + this.f18474a + ')';
    }
}
