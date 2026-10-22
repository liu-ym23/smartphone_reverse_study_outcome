package aab;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ImageSpan b(Layout r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        CharSequence r5 = r2.getText();
        if ((r5 instanceof Spanned) == false) goto L5;
        Spanned r6 = (Spanned) r5;
    L6:
        if (r6 == null) goto L8;
        ImageSpan[] r7 = (ImageSpan[]) r6.getSpans(r3, r4, ImageSpan.class);
    L9:
        boolean r8 = true;
        if (r7 != null) goto L12;
    L18:
        if (r8 == false) goto L21;
        return null;
    L21:
        return (ImageSpan) ArraysKt.first(r7);
    L12:
        if (r7.length != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L18;
        r8 = false;
        goto L18
    L14:
        r9 = false;
        goto L15
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public static Rect a(ImageSpan r6, View r7, Layout r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r6, "imageSpan");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "layout");
        Rect r0 = new Rect();
        Drawable r1 = r6.getDrawable();
        int r2 = r8.getLineForOffset(r9);
        float r11 = r8.getPrimaryHorizontal(r9);
        float r12 = r8.getPrimaryHorizontal(r10);
        r8.getLineBounds(r2, r0);
        int r13 = r6.getVerticalAlignment();
        if (r13 == 1) goto L7;
        if (r13 == 2) goto L6;
        r0.top += r0.height() - r1.getIntrinsicHeight();
    L8:
        int[] r14 = new int[2];
        r7.getLocationOnScreen(r14);
        int r15 = (r14[1] - r7.getScrollY()) + r7.getPaddingTop();
        r0.top += r15;
        r0.bottom += r15;
        int r16 = r0.left + MathKt.roundToInt(((r14[0] + r11) + r7.getPaddingLeft()) - r7.getScrollX());
        r0.left = r16;
        r0.right = MathKt.roundToInt((r16 + r12) - r11);
        return r0;
    L6:
        int r17 = (r0.height() - r1.getIntrinsicHeight()) / 2;
        r0.top += r17;
        r0.bottom -= r17;
        goto L8
    L7:
        r0.top += (r0.height() - r1.getIntrinsicHeight()) / 2;
        r0.offset(0, r8.getLineDescent(r2) * (-1));
        goto L8
    }
}
