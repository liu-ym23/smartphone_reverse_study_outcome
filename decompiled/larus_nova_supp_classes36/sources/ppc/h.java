package ppc;

import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final ImageView c(g r3) {
        ImageView r0 = new ImageView(r3.getActivity());
        r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r0.setAdjustViewBounds(true);
        r0.setContentDescription(null);
        GradientDrawable r1 = new GradientDrawable();
        r1.setColor(0);
        r1.setCornerRadius(y9c.d.a(12));
        r0.setBackground(r1);
        r0.setClipToOutline(true);
        return r0;
    }

    public static final void a(TextView r0, String r1) {
        r0.setText(r1);
        if (StringsKt.isBlank(r1) == false) goto L5;
        int r2 = 8;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static final Size b(int r5, int r6) {
        int r0 = y9c.d.a(120);
        if (r5 <= 0) goto L13;
        if (r6 <= 0) goto L13;
        int r1 = y9c.d.a(220);
        int r2 = y9c.d.a(180);
        float r7 = r5 / r6;
        if (r7 < 1.0f) goto L9;
        Pair r8 = TuplesKt.to(Integer.valueOf(r1), Integer.valueOf((int) (r1 / r7)));
    L11:
        return new Size(RangesKt.coerceIn(((Number) r8.component1()).intValue(), y9c.d.a(80), r1), RangesKt.coerceIn(((Number) r8.component2()).intValue(), y9c.d.a(80), r2));
    L9:
        r8 = TuplesKt.to(Integer.valueOf((int) (r2 * r7)), Integer.valueOf(r2));
    L13:
        return new Size(r0, r0);
    }
}
