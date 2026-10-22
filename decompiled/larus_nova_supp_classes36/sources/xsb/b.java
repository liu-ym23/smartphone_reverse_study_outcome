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
public final class b extends Drawable {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public RectF e;
    public final Paint f;
    public final Path g;
    public final a h;
    public final int i;

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
        RectF r0 = this.e;
        if (r0 == null) goto L5;
        this.f.setAntiAlias(true);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(this.i);
        float r1 = r0.height() / 2.0f;
        this.g.reset();
        this.g.addRoundRect(r0, r1, r1, Path.Direction.CW);
        r5.drawPath(this.g, this.f);
    L5:
        int r2 = r5.getSaveCount();
        r5.save();
        this.h.draw(r5);
        r5.restoreToCount(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r5, int r6, int r7, int r8) {
        a r0 = this.h;
        int r3 = r8 - r6;
        r0.setBounds(r5, r6, ((r0.a * r3) / r0.b) + r5, r3 + r6);
        super.setBounds(r5, r6, r7, r8);
        this.e = new RectF(r5, r6, r7, r8);
    }

    public b(Context r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.f = new Paint();
        this.g = new Path();
        this.i = UIUtils.getColor(r2, 2131106784);
        if (r6 == 0) goto L5;
        this.c = (r5 * r4) / r6;
        this.d = r4;
    L5:
        this.h = new a(r2, this.c, this.d);
    }
}
