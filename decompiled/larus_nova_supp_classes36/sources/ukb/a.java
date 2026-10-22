package ukb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BitmapDrawable {
    public final Resources a;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r9) {
        Bitmap r0 = getBitmap();
        if (r0 != null) goto L5;
    L35:
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Draw after bitmap recycled");
        return;
    L5:
        if (r0.isRecycled() == true) goto L35;
        int r2 = r0.getWidth();
        int r3 = r0.getHeight();
        if (r2 <= 0) goto L33;
        if (r3 <= 0) goto L33;
        if (r0.getByteCount() > 104857600) goto L15;
        super.draw(r9);
        return;
    L15:
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Try too draw too large bitmap(" + r0.getByteCount() + "), avoid crash");
        Resources r4 = this.a;
        int r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels;
        Resources r6 = this.a;
        float r7 = (r2 * 1.0f) / r5;
        float r8 = (r3 * 1.0f) / WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).heightPixels;
        if (r7 <= r8) goto L18;
        Bitmap r10 = a(r0, 1.0f / r7);
    L19:
        if (r10 != null) goto L22;
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Failed to scale bitmap");
        return;
    L22:
        boolean r11 = false;
        Log.i("CustomBitmapDrawable", String.format("originWidth is %s, originHeight is %s, newWidth is %s, newHeight is %s", new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r10.getWidth()), Integer.valueOf(r10.getHeight())}));
        Object r12 = com.ss.android.lark.image.utils.e.a(this, "mBitmapState");
        if (r12 == null) goto L26;
        r11 = com.ss.android.lark.image.utils.e.b(r12, "mBitmap", r10);
    L26:
        if (r11 == true) goto L28;
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Failed to replace bitmap");
        return;
    L28:
        if (r0.isRecycled() == true) goto L30;
        r0.recycle();
    L30:
        super.draw(r9);
        return;
    L18:
        r10 = a(r0, 1.0f / r8);
    L33:
        Log.e("CustomBitmapDrawable", "currentWidth:" + r2 + ", currentWidth:" + r2);
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "resolution is invalid, Failed to scale bitmap");
    }

    public a(Resources r1, Bitmap r2) {
        super(r1, r2);
        this.a = r1;
    }

    public static Bitmap a(Bitmap r7, float r8) {
        Matrix r5 = new Matrix();
        r5.postScale(r8, r8);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, false);
    }
}
