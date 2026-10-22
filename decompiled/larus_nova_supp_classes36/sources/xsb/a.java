package xsb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends Drawable {
    public final int a;
    public final int b;
    public RectF c;
    public final Paint d;
    public final Path e;
    public final int f;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        RectF r0 = this.c;
        if (r0 == null) goto L6;
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(this.f);
        float r1 = r0.height() / 2.0f;
        this.e.reset();
        this.e.addRoundRect(r0, r1, r1, Path.Direction.CW);
        r5.drawPath(this.e, this.d);
        return;
    }

    public a(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r3;
        this.b = r4;
        this.d = new Paint();
        this.e = new Path();
        this.f = UIUtils.getColor(r2, 2131108731);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r2, int r3, int r4, int r5) {
        super.setBounds(r2, r3, r4, r5);
        this.c = new RectF(r2, r3, r4, r5);
    }
}
