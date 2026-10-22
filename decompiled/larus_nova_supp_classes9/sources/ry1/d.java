package ry1;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final void a(View r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r6, "rect");
        int r0 = MathKt.roundToInt(r5.getTranslationX());
        int r1 = MathKt.roundToInt(r5.getTranslationY());
        r6.set(r5.getLeft() + r0, r5.getTop() + r1, r5.getRight() + r0, r5.getBottom() + r1);
    }
}
