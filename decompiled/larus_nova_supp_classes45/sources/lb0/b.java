package lb0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends Drawable implements a {
    public float a;
    public final Paint b;
    public Integer c;
    public Integer d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return (int) (this.a * 255);
    }

    public b() {
        this.a = 0.7f;
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setStyle(Paint.Style.FILL);
        Unit r1 = Unit.INSTANCE;
        this.b = r0;
        this.c = Integer.valueOf(ColorProtector.parseColor("#395A88"));
        this.d = Integer.valueOf(ColorProtector.parseColor("#4C78B8"));
    }

    @Override // lb0.a
    public final Integer a() {
        return this.d;
    }

    @Override // lb0.a
    public final float c() {
        return this.a;
    }

    @Override // lb0.a
    public final Integer e() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable, lb0.a
    public final void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // lb0.a
    public final void b(Integer r1) {
        this.c = r1;
    }

    @Override // lb0.a
    public final void d(Integer r1) {
        this.d = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        float r4 = getBounds().width();
        float r0 = getBounds().height();
        if (this.c == null) goto L5;
    L6:
        Paint r1 = this.b;
        Integer r3 = this.c;
        if (r3 == null) goto L9;
        int r5 = r3.intValue();
    L10:
        int r11 = r5;
        Integer r6 = this.d;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        r1.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r0, r11, r7, Shader.TileMode.MIRROR));
        r14.drawRect(0.0f, 0.0f, r4, r0, this.b);
        return;
    L13:
        r7 = ColorProtector.parseColor("#5A8FDB");
        goto L14
    L9:
        r5 = ColorProtector.parseColor("#395A88");
        goto L10
    L5:
        if (this.d != null) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
        this.a = r1 / 255;
    }
}
