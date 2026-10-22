package u7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends Drawable {
    public final m.b a;
    public int b;
    public int c;
    public Matrix d;
    public final Matrix e;
    public final a f;
    public int g;
    public String h;
    public String i;

    public final void a() {
        a r0 = this.f;
        Rect r1 = getBounds();
        int r2 = r1.width();
        int r3 = r1.height();
        if (r0.d == false) goto L5;
        int r4 = r0.a.getWidth();
    L6:
        this.b = r4;
        if (r0.d == false) goto L9;
        int r5 = r0.a.getHeight();
    L10:
        this.c = r5;
        if (r4 <= 0) goto L24;
        if (r5 <= 0) goto L24;
        if (r4 != r2) goto L19;
        if (r5 != r3) goto L19;
        r0.b(r1.left, r1.top, r1.right, r1.bottom);
        this.d = null;
        return;
    L19:
        if (this.a != m.b.a) goto L22;
        r0.b(r1.left, r1.top, r1.right, r1.bottom);
        this.d = null;
        return;
    L22:
        r0.b(0, 0, r4, r5);
        this.a.a(this.e, r1, r4, r5);
        this.d = this.e;
        return;
    L24:
        r0.b(r1.left, r1.top, r1.right, r1.bottom);
        this.d = null;
        return;
    L9:
        r5 = r0.c.getIntrinsicHeight();
        goto L10
    L5:
        r4 = r0.c.getIntrinsicWidth();
        goto L6
    }

    public final void b() {
        a r0 = this.f;
        if (r0 == null) goto L10;
        u07.a r1 = r0.b;
        if (r1 == null) goto L11;
        CloseableReference r2 = r1.a;
        if (r2 == null) goto L12;
        CloseableReference.closeSafely(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        a r0 = this.f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        if (r0.d == false) goto L18;
        Bitmap r1 = r0.a;
        if (r1 != null) goto L11;
    L16:
        return -3;
    L11:
        if (r1.hasAlpha() == true) goto L16;
        if (r0.j.getAlpha() < 255) goto L16;
        return -1;
    L18:
        return r0.c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r13) {
        a r0 = this.f;
        if (r0 == null) goto L37;
        int r1 = this.b;
        if (r0.d == false) goto L7;
        int r2 = r0.a.getWidth();
    L8:
        if (r1 != r2) goto L16;
        int r3 = this.c;
        a r4 = this.f;
        if (r4.d == false) goto L12;
        int r5 = r4.a.getHeight();
    L13:
        if (r3 != r5) goto L16;
        boolean r6 = false;
    L17:
        if (r6 == false) goto L20;
        a();
    L20:
        if (TextUtils.isEmpty(this.h) == true) goto L26;
        Bitmap r7 = this.f.a();
        if (r7 == null) goto L26;
        k.a(getBounds().width(), getBounds().height(), r7.getWidth(), r7.getHeight(), this.a, this.h, this.i, r13, this.f.a(), this.g);
        return;
    L26:
        if (this.d == null) goto L32;
        int r8 = r13.save();
        r13.clipRect(getBounds());
        r13.concat(this.d);
        a r9 = this.f;
        if (r9.d == false) goto L30;
        r13.drawBitmap(r9.a, r9.k, r9.l, r9.j);
    L31:
        r13.restoreToCount(r8);
        return;
    L30:
        r9.c.draw(r13);
        goto L31
    L32:
        a r10 = this.f;
        if (r10.d == false) goto L35;
        r13.drawBitmap(r10.a, r10.k, r10.l, r10.j);
        return;
    L35:
        r10.c.draw(r13);
        return;
    L12:
        r5 = r4.c.getIntrinsicHeight();
    L16:
        r6 = true;
        goto L17
    L7:
        r2 = r0.c.getIntrinsicWidth();
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r1) {
        if (this.f == null) goto L6;
        a();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r4) {
        this.g = r4;
        a r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d == false) goto L9;
        float r2 = r4;
        if (r0.e == r2) goto L12;
        r0.e = r2;
        r0.j.setAlpha(r4);
        return;
    L12:
        return;
    L9:
        r0.c.setAlpha(r4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r3) {
        a r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d == false) goto L7;
        r0.j.setColorFilter(r3);
        return;
    L7:
        r0.c.setColorFilter(r3);
    }

    public j(a r2, m.b r3) {
        this.b = 0;
        this.c = 0;
        this.e = new Matrix();
        this.g = 255;
        this.f = r2;
        this.a = r3;
    }
}
