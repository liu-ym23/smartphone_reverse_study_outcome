package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable r5, int r6, int r7, Bitmap.Config r8) {
        if (ZeusTransformUtils.instanceOf(r5, BitmapDrawable.class) == true) goto L5;
    L19:
        Rect r0 = r5.getBounds();
        int r1 = r0.left;
        int r2 = r0.top;
        int r3 = r0.right;
        int r4 = r0.bottom;
        if (r8 != null) goto L22;
        r8 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r9 = Bitmap.createBitmap(r6, r7, r8);
        r5.setBounds(0, 0, r6, r7);
        r5.draw(new Canvas(r9));
        r5.setBounds(r1, r2, r3, r4);
        return r9;
    L5:
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap() == null) goto L18;
        if (r8 == null) goto L10;
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap().getConfig() != r8) goto L19;
    L10:
        if (r6 != ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap().getWidth()) goto L16;
        if (r7 != ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap().getHeight()) goto L16;
        return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();
    L16:
        return Bitmap.createScaledBitmap(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap(), r6, r7, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return toBitmap(r0, r1, r2, r3);
    }

    public static final Bitmap toBitmapOrNull(Drawable r2, int r3, int r4, Bitmap.Config r5) {
        if (ZeusTransformUtils.instanceOf(r2, BitmapDrawable.class) == false) goto L9;
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r2, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap() != null) goto L9;
        return null;
    L9:
        return toBitmap(r2, r3, r4, r5);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return toBitmapOrNull(r0, r1, r2, r3);
    }

    public static final void updateBounds(Drawable r0, int r1, int r2, int r3, int r4) {
        r0.setBounds(r1, r2, r3, r4);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getBounds().left;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getBounds().top;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getBounds().right;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getBounds().bottom;
    L14:
        updateBounds(r0, r1, r2, r3, r4);
    }
}
