package k50;

import android.opengl.GLSurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final n50.a a(GLSurfaceView r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getScene");
        Object r2 = r1.getTag(2131388091);
        if ((r2 instanceof n50.a) == true) goto L6;
        r2 = null;
    L6:
        return (n50.a) r2;
    }

    public static final void b(GLSurfaceView r1, c r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setFpsStabilizer");
        Intrinsics.checkNotNullParameter(r2, "fpsStabilizer");
        r1.setTag(2131388097, r2);
    }

    public static final void c(GLSurfaceView r1, j50.a r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setScene");
        Intrinsics.checkNotNullParameter(r2, "scene");
        r1.setTag(2131388091, r2);
    }
}
