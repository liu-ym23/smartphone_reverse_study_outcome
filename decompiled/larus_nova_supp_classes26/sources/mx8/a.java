package mx8;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public boolean a;
    public float b;
    public float c;
    public final Matrix d;
    public final Matrix e;
    public final RectF f;
    public final RectF g;
    public float h;
    public float i;
    public float j;
    public float k;

    public final void b() {
        this.d.reset();
        float r0 = this.j / 2.0f;
        float r2 = this.k / 2.0f;
        Matrix r3 = this.d;
        float r4 = this.b;
        r3.postScale(r4, r4, r0, r2);
        this.d.postTranslate((this.h / 2.0f) - r0, (this.i / 2.0f) - r2);
        this.d.postRotate(this.c, this.h / 2.0f, this.i / 2.0f);
        this.d.invert(this.e);
        this.d.mapRect(this.g, this.f);
    }

    public a() {
        this.b = 1.0f;
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new RectF();
        this.g = new RectF();
    }

    public final float a(float r5) {
        float r0 = this.k;
        if (r0 <= 0.0f) goto L15;
        float r2 = this.j;
        if (r2 > 0.0f) goto L8;
        return 1.0f;
    L8:
        if ((r5 % 180) != 0.0f) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L14;
        return Math.min(this.h / r2, this.i / r0);
    L14:
        return Math.min(this.i / r2, this.h / r0);
    L10:
        r6 = false;
        goto L11
    L15:
        return 1.0f;
    }
}
