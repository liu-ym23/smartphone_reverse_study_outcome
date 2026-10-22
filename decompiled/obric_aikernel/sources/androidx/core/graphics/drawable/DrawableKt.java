package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,118:1\n38#2:119\n49#2:120\n60#2:121\n71#2:122\n*S KotlinDebug\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n*L\n66#1:119\n66#1:120\n66#1:121\n66#1:122\n*E\n"})
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable r10, @Px int r11, @Px int r12, Bitmap.Config r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BitmapDrawable) == false) goto L19;
        BitmapDrawable r14 = (BitmapDrawable) r10;
        if (r14.getBitmap() == null) goto L18;
        if (r13 == null) goto L10;
        if (r14.getBitmap().getConfig() != r13) goto L19;
    L10:
        if (r11 == r14.getBitmap().getWidth()) goto L12;
    L15:
        Bitmap r15 = Bitmap.createScaledBitmap(r14.getBitmap(), r11, r12, true);
        Intrinsics.checkNotNullExpressionValue(r15, "createScaledBitmap(bitmap, width, height, true)");
        return r15;
    L12:
        if (r12 != r14.getBitmap().getHeight()) goto L15;
        Bitmap r16 = r14.getBitmap();
        Intrinsics.checkNotNullExpressionValue(r16, "bitmap");
        return r16;
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        Rect r17 = r10.getBounds();
        Intrinsics.checkNotNullExpressionValue(r17, "bounds");
        int r18 = r17.left;
        int r19 = r17.top;
        int r20 = r17.right;
        int r21 = r17.bottom;
        if (r13 != null) goto L22;
        r13 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r22 = Bitmap.createBitmap(r11, r12, r13);
        r10.setBounds(0, 0, r11, r12);
        r10.draw(new Canvas(r22));
        r10.setBounds(r18, r19, r20, r21);
        Intrinsics.checkNotNullExpressionValue(r22, "bitmap");
        return r22;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable r10, int r11, int r12, Bitmap.Config r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.getIntrinsicWidth();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.getIntrinsicHeight();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = null;
    L12:
        return toBitmap(r10, r11, r12, r13);
    }

    public static final Bitmap toBitmapOrNull(Drawable r10, @Px int r11, @Px int r12, Bitmap.Config r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BitmapDrawable) == false) goto L9;
        if (((BitmapDrawable) r10).getBitmap() != null) goto L9;
        return null;
    L9:
        return toBitmap(r10, r11, r12, r13);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable r10, int r11, int r12, Bitmap.Config r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.getIntrinsicWidth();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.getIntrinsicHeight();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = null;
    L12:
        return toBitmapOrNull(r10, r11, r12, r13);
    }

    public static final void updateBounds(Drawable r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setBounds(r11, r12, r13, r14);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.getBounds().left;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.getBounds().top;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.getBounds().right;
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.getBounds().bottom;
    L14:
        updateBounds(r10, r11, r12, r13, r14);
    }
}
