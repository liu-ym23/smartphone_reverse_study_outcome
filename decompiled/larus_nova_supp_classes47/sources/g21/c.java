package g21;

import android.view.SurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends a {
    public final String toString() {
        return "SurfaceRenderView(render=" + this.b + ')';
    }

    public c(SurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        super(r2, true);
    }

    public c(SurfaceView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
        super(r2, r3);
    }
}
