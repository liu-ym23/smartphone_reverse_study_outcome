package u7a;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final Bitmap a;
    public final l b;
    public final Drawable c;
    public final boolean d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Paint j;
    public final Rect k;
    public Rect l;

    public final Bitmap a() {
        if (this.d == true) goto L5;
        Drawable r0 = this.c;
        if ((r0 instanceof BitmapDrawable) == true) goto L9;
        return null;
    L9:
        return ((BitmapDrawable) r0).getBitmap();
    L5:
        return this.a;
    }

    public a(u07.a r4) {
        this.e = 1.0f;
        this.b = r4;
        Bitmap r0 = r4.b;
        if (r0 == null) goto L5;
        this.a = r0;
        this.d = true;
        Paint r1 = new Paint();
        this.j = r1;
        r1.setAntiAlias(true);
        this.k = new Rect(0, 0, r0.getWidth(), r0.getHeight());
        return;
    L5:
        Drawable r5 = r4.c;
        if (r5 == null) goto L10;
        this.c = r5;
        return;
    }

    public a(Drawable r2) {
        this.e = 1.0f;
        this.c = r2;
    }

    public final void b(int r2, int r3, int r4, int r5) {
        if (this.d == true) goto L5;
        this.c.setBounds(r2, r3, r4, r5);
        return;
    L5:
        if (this.l != null) goto L8;
        this.l = new Rect();
    L8:
        if (this.f == r2) goto L10;
    L15:
        this.l.set(r2, r3, r4, r5);
    L16:
        this.f = r2;
        this.g = r3;
        this.i = r4;
        this.h = r5;
        return;
    L10:
        if (this.i != r4) goto L15;
        if (this.g != r3) goto L15;
        if (this.h == r5) goto L16;
        goto L15
    }
}
