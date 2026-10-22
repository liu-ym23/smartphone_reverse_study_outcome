package n82;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends ScalingUtils.AbstractScaleType {
    public d() {
    }

    public final void getTransformImpl(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
        if (r2 != null) goto L4;
        return;
    L4:
        float r9 = r2.left;
        float r10 = r2.top;
        if (r1 == null) goto L7;
        r1.setScale(r8, r8);
    L7:
        if (r1 == null) goto L10;
        r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        return;
    }
}
