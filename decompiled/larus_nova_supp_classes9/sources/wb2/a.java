package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.widget.a {
    public a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        if ((r10 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r11 = (BitmapDrawable) r10;
        if (r11.getBitmap() != null) goto L7;
        return;
    L7:
        if (r11.getBitmap().isRecycled() == true) goto L12;
        r1.save();
        r10.draw(r1);
        r1.restore();
        return;
    L12:
        return;
    L9:
        r1.save();
        r10.draw(r1);
        r1.restore();
    }
}
