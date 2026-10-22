package pp9;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements b {
    public a() {
    }

    @Override // pp9.b
    public final Matrix a(RectF r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r5, "previewBaseRect");
        Intrinsics.checkNotNullParameter(r6, "fromRect");
        Matrix r0 = new Matrix();
        float r2 = 1.0f / Math.min(r5.width() / r6.width(), r5.height() / r6.height());
        r0.setScale(r2, r2, r5.centerX(), r5.centerY());
        r0.postTranslate(r6.centerX() - r5.centerX(), r6.centerY() - r5.centerY());
        return r0;
    }
}
