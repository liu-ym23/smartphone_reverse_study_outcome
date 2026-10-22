package an;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Shader f326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f327c;
    public int d;
    public final Paint e;
    public int[] f;
    public float[] g;

    public a() {
        this.f327c = 0;
        this.d = 0;
        this.e = new Paint(1);
        this.f = null;
        this.g = null;
    }

    @Override // an.c
    public final void a(int r5, int r10) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        if (this.f326b != null) goto L5;
        LynxLog.b(4, "gradient", "BackgroundGradientLayer.draw() must be called after setBounds()");
    L5:
        Paint r10 = this.e;
        r10.setShader(this.f326b);
        Path r11 = this.f328a;
        if (r11 == null) goto L9;
        r5.drawPath(r11, r10);
        return;
    L9:
        r5.drawRect(getBounds(), r10);
    }

    @Override // an.c
    public final int e() {
        return this.d;
    }

    @Override // an.c
    public final int f() {
        return this.f327c;
    }

    @Override // an.c
    public final boolean g() {
        return true;
    }

    @Override // an.c
    public final void h() {
    }

    @Override // an.c
    public final void i() {
    }

    public final void j(ReadableArray r5, ReadableArray r10) {
        if (r10.size() != 0) goto L5;
    L8:
        this.f = new int[r5.size()];
        if (r10.size() != r5.size()) goto L11;
        this.g = new float[r10.size()];
    L11:
        int r11 = 0;
    L12:
        int[] r12 = this.f;
        if (r11 >= r12.length) goto L18;
        r12[r11] = (int) r5.getLong(r11);
        float[] r13 = this.g;
        if (r13 == null) goto L17;
        r13[r11] = ((float) r10.getDouble(r11)) / 100.0f;
    L17:
        r11 = r11 + 1;
        goto L12
    L18:
        return;
    L5:
        if (r5.size() == r10.size()) goto L8;
        LynxLog.b(4, "Gradient", "native parser error, color and stop must have same size");
    }
}
