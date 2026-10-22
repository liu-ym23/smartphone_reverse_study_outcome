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
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3143j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f3144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final View f3145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Path f3146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final Paint f3147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    private final Paint f3148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private c.e f3149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f3150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3152i;

    public interface a {
        void actualDraw(Canvas r10);

        boolean actualIsOpaque();
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 21) goto L7;
        int r11 = 2;
    L5:
        f3143j = r11;
        return;
    L7:
        if (r10 < 18) goto L9;
        r11 = 1;
        goto L5
    L9:
        r11 = 0;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a r10) {
        this.f3144a = r10;
        View r11 = (View) r10;
        this.f3145b = r11;
        r11.setWillNotDraw(false);
        this.f3146c = new Path();
        this.f3147d = new Paint(7);
        Paint r12 = new Paint(1);
        this.f3148e = r12;
        r12.setColor(0);
    }

    private void d(@NonNull Canvas r10) {
        if (o() == false) goto L6;
        Rect r11 = this.f3150g.getBounds();
        float r12 = this.f3149f.f3157a - (r11.width() / 2.0f);
        float r13 = this.f3149f.f3158b - (r11.height() / 2.0f);
        r10.translate(r12, r13);
        this.f3150g.draw(r10);
        r10.translate(-r12, -r13);
        return;
    }

    private float g(@NonNull c.e r10) {
        return y5.a.b(r10.f3157a, r10.f3158b, 0.0f, 0.0f, this.f3145b.getWidth(), this.f3145b.getHeight());
    }

    private void i() {
        if (f3143j != 1) goto L7;
        this.f3146c.rewind();
        c.e r10 = this.f3149f;
        if (r10 == null) goto L7;
        this.f3146c.addCircle(r10.f3157a, r10.f3158b, r10.f3159c, Path.Direction.CW);
    L7:
        this.f3145b.invalidate();
    }

    private boolean n() {
        c.e r10 = this.f3149f;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (f3143j != 0) goto L17;
        if (r11 == false) goto L13;
        return false;
    L13:
        if (this.f3152i == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return !r11;
    L5:
        if (r10.a() == true) goto L8;
        r11 = false;
        goto L10
    }

    private boolean o() {
        if (this.f3151h == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f3150g == null) goto L9;
        if (this.f3149f == null) goto L9;
        return true;
    }

    private boolean p() {
        if (this.f3151h == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.f3148e.getColor()) == 0) goto L7;
        return true;
    }

    public void a() {
        if (f3143j != 0) goto L15;
        this.f3151h = true;
        this.f3152i = false;
        this.f3145b.buildDrawingCache();
        Bitmap r10 = this.f3145b.getDrawingCache();
        if (r10 == null) goto L7;
    L11:
        if (r10 == null) goto L13;
        Paint r11 = this.f3147d;
        Shader.TileMode r12 = Shader.TileMode.CLAMP;
        r11.setShader(new BitmapShader(r10, r12, r12));
    L13:
        this.f3151h = false;
        this.f3152i = true;
        return;
    L7:
        if (this.f3145b.getWidth() == 0) goto L11;
        if (this.f3145b.getHeight() == 0) goto L11;
        r10 = Bitmap.createBitmap(this.f3145b.getWidth(), this.f3145b.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r10);
        this.f3145b.draw(r13);
        goto L11
    }

    public void b() {
        if (f3143j != 0) goto L6;
        this.f3152i = false;
        this.f3145b.destroyDrawingCache();
        this.f3147d.setShader(null);
        this.f3145b.invalidate();
        return;
    }

    public void c(@NonNull Canvas r10) {
        if (n() == false) goto L22;
        int r11 = f3143j;
        if (r11 != 0) goto L7;
        c.e r12 = this.f3149f;
        r10.drawCircle(r12.f3157a, r12.f3158b, r12.f3159c, this.f3147d);
        if (p() == false) goto L25;
        c.e r13 = this.f3149f;
        r10.drawCircle(r13.f3157a, r13.f3158b, r13.f3159c, this.f3148e);
    L25:
        d(r10);
        return;
    L7:
        if (r11 != 1) goto L9;
        int r14 = r10.save();
        r10.clipPath(this.f3146c);
        this.f3144a.actualDraw(r10);
        if (p() == false) goto L18;
        r10.drawRect(0.0f, 0.0f, this.f3145b.getWidth(), this.f3145b.getHeight(), this.f3148e);
    L18:
        r10.restoreToCount(r14);
        goto L25
    L9:
        if (r11 != 2) goto L14;
        this.f3144a.actualDraw(r10);
        if (p() == false) goto L25;
    L24:
        r10.drawRect(0.0f, 0.0f, this.f3145b.getWidth(), this.f3145b.getHeight(), this.f3148e);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r11);
    L22:
        this.f3144a.actualDraw(r10);
        if (p() == false) goto L25;
        goto L24
    }

    @Nullable
    public Drawable e() {
        return this.f3150g;
    }

    @ColorInt
    public int f() {
        return this.f3148e.getColor();
    }

    @Nullable
    public c.e h() {
        c.e r10 = this.f3149f;
        if (r10 != null) goto L6;
        return null;
    L6:
        c.e r11 = new c.e(r10);
        if (r11.a() == false) goto L9;
        r11.f3159c = g(r11);
    L9:
        return r11;
    }

    public boolean j() {
        if (this.f3144a.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (n() == true) goto L7;
        return true;
    }

    public void k(@Nullable Drawable r10) {
        this.f3150g = r10;
        this.f3145b.invalidate();
    }

    public void l(@ColorInt int r10) {
        this.f3148e.setColor(r10);
        this.f3145b.invalidate();
    }

    public void m(@Nullable c.e r10) {
        if (r10 != null) goto L4;
        this.f3149f = null;
    L11:
        i();
        return;
    L4:
        c.e r11 = this.f3149f;
        if (r11 != null) goto L7;
        this.f3149f = new c.e(r10);
    L9:
        if (y5.a.c(r10.f3159c, g(r10), 1.0E-4f) == false) goto L11;
        this.f3149f.f3159c = Float.MAX_VALUE;
        goto L11
    L7:
        r11.c(r10);
        goto L9
    }
}
