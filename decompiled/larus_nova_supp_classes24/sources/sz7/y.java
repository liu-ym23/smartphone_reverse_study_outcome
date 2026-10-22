package sz7;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import com.larksuite.component.ui.avatar.BorderProperty;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y extends BitmapDrawable {
    public final BitmapDrawable a;
    public final BorderProperty b;
    public final RectF c;
    public final RectF d;
    public final RectF e;
    public final Path f;
    public final Paint g;
    public final int h;
    public final int i;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        if (getBitmap().isRecycled() == true) goto L36;
        this.c.set(getBounds());
        float r0 = (this.h * 1.0f) / 2;
        this.e.set(this.c);
        this.e.inset(r0, r0);
        this.d.set(this.c);
        RectF r1 = this.d;
        float r2 = this.h;
        r1.inset(r2, r2);
        BitmapDrawable r3 = this.a;
        if ((r3 instanceof BitmapDrawable) == false) goto L34;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r4 = r3.getBitmap();
        if (r4 != null) goto L10;
    L33:
        Log.i("RounderCornersBitmapDrawable", "bitmap recycled");
        goto L34
    L10:
        if (r4.isRecycled() == true) goto L33;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Object r5 = com.ss.android.lark.image.utils.e.a(this.a, "mBlendModeFilter");
        if (r5 != null) goto L17;
    L29:
        boolean r6 = false;
    L30:
        this.g.setAntiAlias(true);
        int r7 = r9.getSaveCount();
        r9.save();
        this.f.reset();
        Path r8 = this.f;
        RectF r10 = this.d;
        float r11 = this.i;
        r8.addRoundRect(r10, r11, r11, Path.Direction.CW);
        r9.clipPath(this.f);
        r9.drawBitmap(r4, null, this.c, this.a.getPaint());
        r9.restoreToCount(r7);
        if (r6 == false) goto L34;
        getPaint().setColorFilter(null);
        goto L34
    L17:
        if ((r5 instanceof BlendModeColorFilter) == false) goto L29;
        if (this.a.getPaint().getColorFilter() != null) goto L29;
        this.a.getPaint().setColorFilter((ColorFilter) r5);
    L28:
        r6 = true;
        goto L30
    L21:
        Object r12 = com.ss.android.lark.image.utils.e.a(this.a, "mTintFilter");
        if (r12 == null) goto L29;
        if ((r12 instanceof PorterDuffColorFilter) == false) goto L29;
        if (this.a.getPaint().getColorFilter() != null) goto L29;
        this.a.getPaint().setColorFilter((ColorFilter) r12);
    L34:
        this.g.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(this.b.getBorderColor());
        this.g.setStrokeWidth(this.b.getBorderWidthPx());
        this.f.reset();
        Path r13 = this.f;
        RectF r14 = this.e;
        float r15 = this.i;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        r9.drawPath(this.f, this.g);
        return;
    }

    public y(Resources r2, BitmapDrawable r3, BorderProperty r4) {
        Intrinsics.checkNotNullParameter(r2, "res");
        Intrinsics.checkNotNullParameter(r3, "srcDrawable");
        Intrinsics.checkNotNullParameter(r4, "borderProperty");
        super(r2, r3.getBitmap());
        this.a = r3;
        this.b = r4;
        this.c = new RectF();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Path();
        this.g = new Paint();
        this.h = r4.getBorderWidthPx();
        this.i = r4.getBorderRadiusPx();
    }
}
