package vjb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FrameLayout {
    public final float a;
    public final Paint b;
    public final RectF c;
    public final int[] d;
    public final int[] e;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        if (getChildCount() != 0) goto L5;
        boolean r0 = true;
    L6:
        View r3 = null;
        if (r0 == true) goto L16;
        View r1 = getChildAt(0);
        if ((r1 instanceof ViewGroup) == false) goto L12;
        ViewGroup r2 = (ViewGroup) r1;
    L13:
        if (r2 == null) goto L16;
        r3 = r2.findViewById(2131364903);
        goto L16
    L12:
        r2 = null;
    L16:
        if (r3 == null) goto L18;
        r3.getLocationInWindow(this.d);
        getLocationInWindow(this.e);
        int[] r4 = this.d;
        int r5 = r4[0];
        int[] r6 = this.e;
        float r8 = r5 - r6[0];
        float r9 = r4[1] - r6[1];
        this.c.set(r8, r9, r3.getWidth() + r8, r3.getHeight() + r9);
        RectF r10 = this.c;
        float r11 = this.a;
        r7.drawRoundRect(r10, r11, r11, this.b);
    L18:
        super.dispatchDraw(r7);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public a(Context r2, int r3, float r4, float r5, float r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r4;
        Paint r8 = new Paint(1);
        r8.setColor(r3);
        r8.setShadowLayer(r6, 0.0f, r5, r7);
        this.b = r8;
        this.c = new RectF();
        this.d = new int[2];
        this.e = new int[2];
        setWillNotDraw(false);
        setLayerType(1, null);
        int r9 = (int) (Math.abs(0.0f) + r6);
        setPadding(r9, (int) RangesKt.coerceAtLeast(r6 - r5, 0.0f), r9, (int) RangesKt.coerceAtLeast(r6 + r5, 0.0f));
        setClipToPadding(false);
        setClipChildren(false);
    }
}
