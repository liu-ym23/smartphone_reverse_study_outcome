package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3842a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3843b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private c.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    public interface a {
        void actualDraw(Canvas r1);

        boolean actualIsOpaque();
    }

    static {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        int r0 = 2;
    L5:
        f3842a = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        r0 = 1;
        goto L5
    L9:
        r0 = 0;
        goto L5
    }

    public b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f3843b = r4;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        this.c = r5;
        r5.setWillNotDraw(false);
        this.d = new Path();
        this.e = new Paint(7);
        Paint r6 = new Paint(1);
        this.f = r6;
        r6.setColor(0);
    }

    private float b(c.d r7) {
        return com.google.android.material.f.a.a(r7.f3848a, r7.f3849b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    private void b(Canvas r5) {
        if (j() == false) goto L6;
        Rect r0 = this.h.getBounds();
        float r1 = this.g.f3848a - (r0.width() / 2.0f);
        float r2 = this.g.f3849b - (r0.height() / 2.0f);
        r5.translate(r1, r2);
        this.h.draw(r5);
        r5.translate(-r1, -r2);
        return;
    }

    private void g() {
        if (f3842a != 1) goto L7;
        this.d.rewind();
        c.d r0 = this.g;
        if (r0 == null) goto L7;
        this.d.addCircle(r0.f3848a, this.g.f3849b, this.g.c, Path.Direction.CW);
    L7:
        this.c.invalidate();
    }

    private boolean h() {
        c.d r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (f3842a != 0) goto L17;
        if (r1 == false) goto L13;
        return false;
    L13:
        if (this.j == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return !r1;
    L5:
        if (r0.a() == true) goto L8;
        r1 = false;
        goto L10
    }

    private boolean i() {
        if (this.i == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.f.getColor()) == 0) goto L7;
        return true;
    }

    private boolean j() {
        if (this.i == false) goto L5;
    L9:
        return false;
    L5:
        if (this.h == null) goto L9;
        if (this.g == null) goto L9;
        return true;
    }

    public void a() {
        if (f3842a != 0) goto L15;
        this.i = true;
        this.j = false;
        this.c.buildDrawingCache();
        Bitmap r2 = this.c.getDrawingCache();
        if (r2 == null) goto L7;
    L11:
        if (r2 == null) goto L13;
        this.e.setShader(new BitmapShader(r2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    L13:
        this.i = false;
        this.j = true;
        return;
    L7:
        if (this.c.getWidth() == 0) goto L11;
        if (this.c.getHeight() == 0) goto L11;
        r2 = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        this.c.draw(r3);
        goto L11
    }

    public void a(int r2) {
        this.f.setColor(r2);
        this.c.invalidate();
    }

    public void a(Canvas r9) {
        if (h() == false) goto L22;
        int r0 = f3842a;
        if (r0 != 0) goto L7;
        r9.drawCircle(this.g.f3848a, this.g.f3849b, this.g.c, this.e);
        if (i() == false) goto L25;
        r9.drawCircle(this.g.f3848a, this.g.f3849b, this.g.c, this.f);
    L25:
        b(r9);
        return;
    L7:
        if (r0 != 1) goto L9;
        int r1 = r9.save();
        r9.clipPath(this.d);
        this.f3843b.actualDraw(r9);
        if (i() == false) goto L18;
        r9.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
    L18:
        r9.restoreToCount(r1);
        goto L25
    L9:
        if (r0 != 2) goto L14;
        this.f3843b.actualDraw(r9);
        if (i() == false) goto L25;
    L24:
        r9.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r0);
    L22:
        this.f3843b.actualDraw(r9);
        if (i() == false) goto L25;
        goto L24
    }

    public void a(Drawable r1) {
        this.h = r1;
        this.c.invalidate();
    }

    public void a(c.d r3) {
        if (r3 != null) goto L4;
        this.g = null;
    L11:
        g();
        return;
    L4:
        c.d r0 = this.g;
        if (r0 != null) goto L7;
        this.g = new c.d(r3);
    L9:
        if (com.google.android.material.f.a.b(r3.c, b(r3), 1.0E-4f) == false) goto L11;
        this.g.c = Float.MAX_VALUE;
        goto L11
    L7:
        r0.a(r3);
        goto L9
    }

    public void b() {
        if (f3842a != 0) goto L6;
        this.j = false;
        this.c.destroyDrawingCache();
        this.e.setShader(null);
        this.c.invalidate();
        return;
    }

    public c.d c() {
        if (this.g != null) goto L6;
        return null;
    L6:
        c.d r0 = new c.d(this.g);
        if (r0.a() == false) goto L9;
        r0.c = b(r0);
    L9:
        return r0;
    }

    public int d() {
        return this.f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public boolean f() {
        if (this.f3843b.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (h() == true) goto L7;
        return true;
    }
}
