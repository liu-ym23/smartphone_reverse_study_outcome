package r9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12702a = null;

    static {
        f12702a = new a();
    }

    private a() {
    }

    private final Bitmap b(Context r10, Drawable r11, Float r12, Float r13) {
        if ((r11 instanceof BitmapDrawable) == false) goto L9;
        if (r12 != null) goto L9;
        if (r13 != null) goto L9;
        Bitmap r14 = ((BitmapDrawable) r11).getBitmap();
        String r15 = "drawable.bitmap";
    L7:
        Intrinsics.checkNotNullExpressionValue(r14, r15);
        return r14;
    L9:
        Resources r16 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r16, "context.resources");
        float r17 = r16.getDisplayMetrics().density;
        if (r12 == null) goto L12;
        int r18 = (int) (r12.floatValue() * r17);
    L13:
        if (r13 == null) goto L15;
        int r19 = (int) (r13.floatValue() * r17);
    L16:
        r14 = Bitmap.createBitmap(r18, r19, Bitmap.Config.ARGB_8888);
        Canvas r20 = new Canvas(r14);
        r11.setBounds(0, 0, r20.getWidth(), r20.getHeight());
        r11.draw(r20);
        r15 = "bitmap";
        goto L7
    L15:
        r19 = RangesKt.coerceAtLeast(r11.getIntrinsicHeight(), 1);
        goto L16
    L12:
        r18 = RangesKt.coerceAtLeast(r11.getIntrinsicWidth(), 1);
        goto L13
    }

    static /* synthetic */ Bitmap c(a r10, Context r11, Drawable r12, Float r13, Float r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = null;
    L9:
        return r10.b(r11, r12, r13, r14);
    }

    public final Drawable a(Context r10, Drawable r11, float r12, float r13, float r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "drawable");
        Resources r16 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r16, "context.resources");
        int r17 = (int) (r14 * r16.getDisplayMetrics().density);
        GradientDrawable r18 = new GradientDrawable();
        r18.setShape(1);
        r18.setStroke(r17, r15);
        r18.setColor(0);
        if (r12 > 0.0f) goto L5;
    L8:
        Bitmap r19 = c(this, r10, r11, null, null, 12, null);
    L9:
        RoundedBitmapDrawable r20 = RoundedBitmapDrawableFactory.create(r10.getResources(), r19);
        r20.setCircular(true);
        Intrinsics.checkNotNullExpressionValue(r20, "RoundedBitmapDrawableFac…ular = true\n            }");
        return new LayerDrawable(new Drawable[]{r20, r18});
    L5:
        if (r13 <= 0.0f) goto L8;
        r19 = b(r10, r11, Float.valueOf(r12), Float.valueOf(r13));
        goto L9
    }
}
