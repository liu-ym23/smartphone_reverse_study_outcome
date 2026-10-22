package pb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends pb2.a {
    public static final Paint s = null;
    public final Rect n;
    public final NinePatchDrawable o;
    public final String p;
    public final int q;
    public final float r;

    public static final class a {
    }

    public final void setWidthAndHeight(int r1, int r2) {
    }

    static {
        Paint r0 = new Paint();
        r0.setTextAlign(Paint.Align.LEFT);
        r0.setAntiAlias(true);
        r0.setStyle(Paint.Style.FILL_AND_STROKE);
        r0.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        s = r0;
    }

    public c(NinePatchDrawable r5, String r6, int r7, float r8) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        Intrinsics.checkNotNullParameter(r6, "content");
        super(r5);
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        Rect r9 = new Rect();
        this.n = r9;
        r5.getPadding(r9);
        Rect r0 = new Rect();
        Paint r1 = s;
        r1.setTextSize(r8);
        r1.getTextBounds(r6, 0, r6.length(), r0);
        r5.getBounds().right += Math.max(0, r0.width() - ((r5.getBounds().width() - r9.left) - r9.right));
        int r10 = r5.getBounds().width();
        int r11 = r5.getBounds().height();
        ((lk6.c) this).a = r10;
        ((lk6.c) this).b = r11;
    }

    public final void a(Canvas r4, CharSequence r5, int r6, int r7, Paint r8) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r8, "paint");
        super.a(r4, r5, r6, r7, r8);
        Paint r9 = s;
        r9.setTextSize(this.r);
        r9.setColor(this.q);
        r4.drawText(this.p, this.n.left, ((this.o.getIntrinsicHeight() / 2) + ((r9.getFontMetrics().descent - r9.getFontMetrics().ascent) / 2)) - r9.getFontMetrics().descent, r9);
    }

    @Override // pb2.a
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        return super.getSize(r2, r3, r4, r5, r6);
    }
}
