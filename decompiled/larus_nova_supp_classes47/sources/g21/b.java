package g21;

import fr2.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends a {
    public final l d;

    public final String toString() {
        return "LayerRenderView(render=" + this.b + ')';
    }

    public b(l r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        super(r2, r3);
        this.d = r2;
    }
}
