package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", OpenPageMethod.ALIGN_LEFT, "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,118:1\n38#2:119\n49#2:120\n60#2:121\n71#2:122\n*S KotlinDebug\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n*L\n66#1:119\n66#1:120\n66#1:121\n66#1:122\n*E\n"})
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable r5, @Px int r10, @Px int r11, Bitmap.Config r12) {
        if ((r5 instanceof BitmapDrawable) == false) goto L19;
        BitmapDrawable r13 = (BitmapDrawable) r5;
        if (r13.getBitmap() == null) goto L18;
        if (r12 == null) goto L10;
        if (r13.getBitmap().getConfig() != r12) goto L19;
    L10:
        if (r10 != r13.getBitmap().getWidth()) goto L16;
        if (r11 != r13.getBitmap().getHeight()) goto L16;
        return r13.getBitmap();
    L16:
        return Bitmap.createScaledBitmap(r13.getBitmap(), r10, r11, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        Rect r14 = r5.getBounds();
        int r15 = r14.left;
        int r16 = r14.top;
        int r17 = r14.right;
        int r18 = r14.bottom;
        if (r12 != null) goto L22;
        r12 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r19 = Bitmap.createBitmap(r10, r11, r12);
        r5.setBounds(0, 0, r10, r11);
        r5.draw(new Canvas(r19));
        r5.setBounds(r15, r16, r17, r18);
        return r19;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable r5, int r10, int r11, Bitmap.Config r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.getIntrinsicWidth();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.getIntrinsicHeight();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return toBitmap(r5, r10, r11, r12);
    }

    public static final Bitmap toBitmapOrNull(Drawable r5, @Px int r10, @Px int r11, Bitmap.Config r12) {
        if ((r5 instanceof BitmapDrawable) == false) goto L9;
        if (((BitmapDrawable) r5).getBitmap() != null) goto L9;
        return null;
    L9:
        return toBitmap(r5, r10, r11, r12);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable r5, int r10, int r11, Bitmap.Config r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.getIntrinsicWidth();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.getIntrinsicHeight();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return toBitmapOrNull(r5, r10, r11, r12);
    }

    public static final void updateBounds(Drawable r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setBounds(r10, r11, r12, r13);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.getBounds().left;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.getBounds().top;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getBounds().right;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.getBounds().bottom;
    L14:
        updateBounds(r5, r10, r11, r12, r13);
    }
}
