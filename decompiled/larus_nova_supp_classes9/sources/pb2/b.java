package pb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends pb2.a {
    public static final Paint u = null;
    public final String n;
    public final int o;
    public final float p;
    public final float q;
    public final float r;
    public final boolean s;
    public final int t;

    public static final class a {
    }

    static {
        u = new Paint();
    }

    public final void a(Canvas r4, CharSequence r5, int r6, int r7, Paint r8) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r8, "paint");
        super.a(r4, r5, r6, r7, r8);
        Paint r9 = u;
        float r10 = r7;
        r9.setTextSize(this.p * r10);
        r9.setColor(this.o);
        int r0 = (int) r9.measureText(this.n);
        if (this.s == false) goto L5;
        r6 = r6 - r7;
    L5:
        int r1 = RangesKt.coerceAtMost(r0, r6);
        float r11 = ((r7 / 2) + ((r9.getFontMetrics().descent - r9.getFontMetrics().ascent) * this.r)) - r9.getFontMetrics().descent;
        if (this.s == false) goto L10;
        float r13 = ((r6 - r1) * this.q) + r10;
        float r14 = r13 - r10;
        int r2 = this.t;
        if (r14 < r2) goto L11;
        r13 = r13 - r2;
    L11:
        r4.drawText(this.n, r13, r11, r9);
        return;
    L10:
        r13 = (r6 - r1) * this.q;
        goto L11
    }

    public b(Drawable r2, String r3, int r4, float r5, float r6, float r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        Intrinsics.checkNotNullParameter(r3, "contentText");
        super(r2);
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.s = r8;
        this.t = r9;
        Paint r10 = u;
        r10.setStyle(Paint.Style.FILL_AND_STROKE);
        r10.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }
}
