package sp9;

import android.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static float a(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "matrix");
        float[] r0 = new float[9];
        r2.getValues(r0);
        float r3 = r0[0];
        float r1 = r0[3];
        return (float) Math.sqrt((r3 * r3) + (r1 * r1));
    }
}
