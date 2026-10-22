package a7a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b extends d {
    public Shader b;
    public int c;
    public int d;
    public final Paint e;
    public int[] f;
    public float[] g;

    @Override // a7a.d
    public final boolean c() {
        return true;
    }

    @Override // a7a.d
    public final void d() {
    }

    @Override // a7a.d
    public final void e() {
    }

    @Override // a7a.d
    public final void g(int r1, int r2) {
    }

    public b() {
        this.c = 0;
        this.d = 0;
        this.e = new Paint(1);
        this.f = null;
        this.g = null;
    }

    @Override // a7a.d
    public final int a() {
        return this.d;
    }

    @Override // a7a.d
    public final int b() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        if (this.b != null) goto L5;
        LLog.e("gradient", "BackgroundGradientLayer.draw() must be called after setBounds()");
    L5:
        this.e.setShader(this.b);
        Path r0 = this.a;
        if (r0 == null) goto L8;
        r3.drawPath(r0, this.e);
        return;
    L8:
        r3.drawRect(getBounds(), this.e);
    }

    public final void k(ReadableArray r5, ReadableArray r6) {
        if (r6.size() != 0) goto L5;
    L8:
        this.f = new int[r5.size()];
        if (r6.size() != r5.size()) goto L11;
        this.g = new float[r6.size()];
    L11:
        int r0 = 0;
    L12:
        int[] r1 = this.f;
        if (r0 >= r1.length) goto L18;
        r1[r0] = (int) r5.getLong(r0);
        float[] r2 = this.g;
        if (r2 == null) goto L17;
        r2[r0] = ((float) r6.getDouble(r0)) / 100.0f;
    L17:
        r0 = r0 + 1;
        goto L12
    L18:
        return;
    L5:
        if (r5.size() == r6.size()) goto L8;
        LLog.e("Gradient", "native parser error, color and stop must have same size");
    }
}
