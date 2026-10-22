package n82;

import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(GradientDrawable r3, float r4) {
        r3.setCornerRadii(new float[]{0.0f, 0.0f, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f});
    }

    public static GradientDrawable a(int r2, int r3, GradientDrawable.Orientation r4) {
        Intrinsics.checkNotNullParameter(r4, "orientation");
        int[] r0 = {r2, r3};
        GradientDrawable r5 = new GradientDrawable();
        r5.setColors(r0);
        r5.setOrientation(r4);
        return r5;
    }
}
