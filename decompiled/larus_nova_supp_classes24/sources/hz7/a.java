package hz7;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends ColorDrawable {
    public final Paint a;
    public Shader b;
    public Shader c;
    public int d;
    public int e;
    public float f;

    /* JADX INFO: renamed from: hz7.a$a, reason: collision with other inner class name */
    public static final class C0112a {
    }

    static {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public a() {
        this.a = new Paint();
        this.f = 2.25f;
    }

    public final void b(int r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        this.b = null;
        this.a.setShader(null);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        r13.drawColor(this.d);
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
    L10:
        int r0 = this.e;
        int[] r9 = {r0, r0, 0};
        float[] r1 = {0.0f, 0.33f, 1.0f};
        this.b = new RadialGradient(0.0f, 0.0f, 240.0f, r9, r1, Shader.TileMode.CLAMP);
        this.c = new RadialGradient(0.0f, 0.0f, 210.0f, r9, r1, Shader.TileMode.CLAMP);
    L11:
        float r2 = this.f;
        int r10 = r13.save();
        r13.scale(r2, r2, 0.0f, 0.0f);
        int r11 = r13.save();     // Catch: Throwable -> L20
        r13.translate(300.0f, 70.0f);     // Catch: Throwable -> L20
        Shader r3 = this.b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L17
        a(r13, r3, -320.0f, 10.0f, 0.33f, 0.0f, 240.0f);     // Catch: Throwable -> L17
        Shader r4 = this.c;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L17
        a(r13, r4, 10.0f, -80.0f, 0.875f, -45.0f, 210.0f);     // Catch: Throwable -> L17
        Shader r5 = this.b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L17
        a(r13, r5, 296.0f, 30.0f, 0.33f, 0.0f, 240.0f);     // Catch: Throwable -> L17
        r13.restoreToCount(r11);     // Catch: Throwable -> L20
        r13.restoreToCount(r10);
        return;
    L17:
        th = move-exception;
        r13.restoreToCount(r11);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r13.restoreToCount(r10);
        throw th;
    L8:
        if (this.c == null) goto L10;
        goto L10
    }

    @Override // android.graphics.drawable.ColorDrawable
    public final void setColor(int r1) {
        super.setColor(r1);
        this.d = r1;
        invalidateSelf();
    }

    public final void a(Canvas r8, Shader r9, float r10, float r11, float r12, float r13, float r14) {
        this.a.setShader(r9);
        int r15 = r8.save();
        r8.translate(r10, r11);
        int r16 = r8.save();     // Catch: Throwable -> L17
        r8.scale(1.0f, r12, 0.0f, 0.0f);     // Catch: Throwable -> L17
        int r17 = r8.save();     // Catch: Throwable -> L14
        r8.rotate(r13, 0.0f, 0.0f);     // Catch: Throwable -> L14
        float r3 = -r14;
        r8.drawOval(r3, r3, r14, r14, this.a);     // Catch: Throwable -> L11
        r8.restoreToCount(r17);     // Catch: Throwable -> L14
        r8.restoreToCount(r16);     // Catch: Throwable -> L17
        r8.restoreToCount(r15);
        return;
    L11:
        th = move-exception;
        r8.restoreToCount(r17);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r8.restoreToCount(r16);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r8.restoreToCount(r15);
        throw th;
    }
}
