package cf;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public static final float[] a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$centerLocationInScreen");
        int[] r1 = new int[2];
        r10.getLocationOnScreen(r1);
        return new float[]{r1[0] + (r10.getWidth() / 2.0f), r1[1] + (r10.getHeight() / 2.0f)};
    }
}
