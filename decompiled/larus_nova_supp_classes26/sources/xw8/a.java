package xw8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends Drawable {
    public final int a;
    public final int b;
    public final Paint c;

    /* JADX INFO: renamed from: xw8.a$a, reason: collision with other inner class name */
    public static final class C0141a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r3.drawRect(getBounds(), this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r11) {
        Intrinsics.checkNotNullParameter(r11, "bounds");
        super.onBoundsChange(r11);
        this.c.setShader(new LinearGradient(0.0f, r11.top, 0.0f, r11.bottom, new int[]{this.a, this.b}, new float[]{0.12201f, 0.26414f}, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.c.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
        invalidateSelf();
    }

    public a(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = new Paint(1);
    }
}
