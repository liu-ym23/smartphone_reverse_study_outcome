package d72;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends Drawable {
    public final Paint a;
    public final RectF b;
    public final Path c;
    public final float[] d;
    public final float[] e;
    public final float[] f;
    public final boolean g;
    public final boolean h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.b.set(getBounds());
        this.c.reset();
        boolean r0 = this.g;
        if (r0 == true) goto L5;
    L7:
        if (r0 == false) goto L9;
    L11:
        if (r0 == true) goto L13;
    L15:
        this.c.addRect(this.b, Path.Direction.CCW);
    L16:
        r5.drawPath(this.c, this.a);
        return;
    L13:
        if (this.h == false) goto L15;
        this.c.addRoundRect(this.b, this.f, Path.Direction.CCW);
        goto L16
    L9:
        if (this.h == false) goto L11;
        this.c.addRoundRect(this.b, this.e, Path.Direction.CCW);
        goto L16
    L5:
        if (this.h == true) goto L7;
        this.c.addRoundRect(this.b, this.d, Path.Direction.CCW);
        goto L16
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
        invalidateSelf();
    }

    public a(int r10, boolean r11, boolean r13) {
        this.g = r11;
        this.h = r13;
        Paint r14 = new Paint(1);
        r14.setColor(r10);
        r14.setStyle(Paint.Style.FILL);
        Unit r15 = Unit.INSTANCE;
        this.a = r14;
        this.b = new RectF();
        this.c = new Path();
        float r16 = UtilityKotlinExtentionsKt.h(8);
        this.d = new float[]{r16, r16, r16, r16, 0.0f, 0.0f, 0.0f, 0.0f};
        this.e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r16, r16, r16, r16};
        this.f = new float[]{r16, r16, r16, r16, r16, r16, r16, r16};
    }
}
