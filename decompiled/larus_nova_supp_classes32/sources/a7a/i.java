package a7a;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.GradientUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends b {
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final float l;
    public final float m;
    public final float n;
    public final int o;
    public final float p;
    public final int q;
    public final PointF r;

    public static float l(int r1, float r2, float r3) {
        if (r1 == 11) goto L11;
        switch(r1) {
            case 32: goto L8;
            case 33: goto L12;
            case 34: goto L12;
            case 35: goto L8;
            case 36: goto L7;
            default: goto L5;
        };
    L5:
        return r2;
    L8:
        return 0.0f;
    L12:
        return r3;
    L7:
        return r3 * 0.5f;
    L11:
        return (r3 * r2) / 100.0f;
    }

    public i(ReadableArray r8) {
        this.h = 0;
        this.i = 0;
        this.j = 36;
        this.k = 36;
        this.l = 0.5f;
        this.m = 0.5f;
        this.r = new PointF(0.5f, 0.5f);
        if (r8 != null) goto L7;
        LLog.e("RadialGradient", "native parser error, array is null");
        return;
    L7:
        if (r8.size() == 3) goto L9;
        LLog.e("RadialGradient", "native parser error, array.size must be 3");
    L9:
        ReadableArray r1 = r8.getArray(0);
        this.h = (int) r1.getLong(0);
        int r2 = (int) r1.getLong(1);
        this.i = r2;
        this.j = (int) r1.getLong(2);
        this.l = (float) r1.getDouble(3);
        this.k = (int) r1.getLong(4);
        this.m = (float) r1.getDouble(5);
        if (r2 != 4) goto L12;
        this.n = (float) r1.getDouble(10);
        this.o = r1.getInt(11);
        this.p = (float) r1.getDouble(12);
        this.q = r1.getInt(13);
    L12:
        k(r8.getArray(1), r8.getArray(2));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r14) {
        this.c = r14.width();
        this.d = r14.height();
        this.r.x = l(this.j, this.l, this.c);
        this.r.y = l(this.k, this.m, this.d);
        PointF r0 = this.r;
        float r8 = r0.x;
        float r1 = r0.y;
        int r2 = this.i;
        boolean r7 = true;
        if (r2 == 4) goto L5;
        PointF r3 = GradientUtils.b(this.h, r2, r8, r1, this.c, this.d);
    L14:
        int[] r4 = this.f;
        if (r4 != null) goto L17;
    L40:
        this.b = null;
    L41:
        super.setBounds(r14);
        return;
    L17:
        if (r4.length < 2) goto L40;
        float[] r5 = this.g;
        if (r5 != null) goto L22;
    L43:
        float r6 = r3.x;     // Catch: Exception -> L38
        if (r6 == 0.0f) goto L31;
        if (r3.y == 0.0f) goto L31;
        r7 = false;
    L31:
        if (r7 == false) goto L33;
        float r11 = 1.0f;
    L34:
        this.b = new RadialGradient(r8, r1, Math.max(r3.x, 1.0f), this.f, this.g, Shader.TileMode.CLAMP);     // Catch: Exception -> L38
        if (r11 == 1.0f) goto L41;
        Matrix r9 = new Matrix();     // Catch: Exception -> L38
        r9.preScale(1.0f, 1.0f / r11, r8, r1);     // Catch: Exception -> L38
        this.b.setLocalMatrix(r9);     // Catch: Exception -> L38
        goto L41
    L33:
        r11 = r6 / r3.y;     // Catch: Exception -> L38
    L38:
        e = move-exception;
        this.b = null;
        e.printStackTrace();
        LLog.w("BackgroundRadialGradientLayer", "exception:\n" + e.toString());
        goto L41
    L22:
        if (r5.length == r4.length) goto L43;
        this.b = null;
        goto L41
    L5:
        if (this.o != 1) goto L7;
        float r10 = this.c * this.n;
    L9:
        if (this.q != 1) goto L11;
        float r12 = this.d * this.p;
    L12:
        r3 = new PointF(r10, r12);
        goto L14
    L11:
        r12 = this.p;
        goto L12
    L7:
        r10 = this.n;
        goto L9
    }
}
