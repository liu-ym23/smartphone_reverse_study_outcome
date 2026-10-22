package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n¨\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap r5, Function1<? super Canvas, Unit> r10) {
        r10.invoke(new Canvas(r5));
        return r5;
    }

    public static final boolean contains(Bitmap r5, Point r10) {
        int r11 = r5.getWidth();
        int r12 = r10.x;
        if (r12 < 0) goto L10;
        if (r12 >= r11) goto L10;
        int r13 = r10.y;
        if (r13 < 0) goto L10;
        if (r13 >= r5.getHeight()) goto L10;
        return true;
    L10:
        return false;
    }

    public static final Bitmap createBitmap(int r5, int r10, Bitmap.Config r11) {
        return Bitmap.createBitmap(r5, r10, r11);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r5, int r10, Bitmap.Config r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = Bitmap.Config.ARGB_8888;
    L6:
        return Bitmap.createBitmap(r5, r10, r11);
    }

    public static final int get(Bitmap r5, int r10, int r11) {
        return r5.getPixel(r10, r11);
    }

    public static final Bitmap scale(Bitmap r5, int r10, int r11, boolean r12) {
        return Bitmap.createScaledBitmap(r5, r10, r11, r12);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap r5, int r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = true;
    L6:
        return Bitmap.createScaledBitmap(r5, r10, r11, r12);
    }

    public static final void set(Bitmap r5, int r10, int r11, @ColorInt int r12) {
        r5.setPixel(r10, r11, r12);
    }

    public static final boolean contains(Bitmap r5, PointF r10) {
        float r11 = r10.x;
        if (r11 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r11 >= r5.getWidth()) goto L11;
        float r12 = r10.y;
        if (r12 < 0.0f) goto L11;
        if (r12 >= r5.getHeight()) goto L11;
        return true;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int r5, int r10, Bitmap.Config r11, boolean r12, ColorSpace r13) {
        return Bitmap.createBitmap(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r5, int r10, Bitmap.Config r11, boolean r12, ColorSpace r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r11 = Bitmap.Config.ARGB_8888;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r12 = true;
    L9:
        if ((r14 & 16) == 0) goto L12;
        r13 = ColorSpace.get(ColorSpace.Named.SRGB);
    L12:
        return Bitmap.createBitmap(r5, r10, r11, r12, r13);
    }
}
