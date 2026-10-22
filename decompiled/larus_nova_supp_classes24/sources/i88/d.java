package i88;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends BasePostprocessor {
    public d() {
    }

    public final void process(Bitmap r5) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Paint r0 = new Paint();
        int r1 = j0.a;
        r0.setColorFilter(new LightingColorFilter(j0.a(2131103292), 1));
        new Canvas(r5).drawBitmap(r5, 0.0f, 0.0f, r0);
    }
}
