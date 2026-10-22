package mc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AccelerateInterpolator f9332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f9333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable f9334k;

    public a(Drawable r8, Drawable r10) {
        i.f(r8, "startDrawable");
        i.f(r10, "endDrawable");
        this.f9333j = r8;
        this.f9334k = r10;
        this.f9331h = true;
        this.f9332i = new AccelerateInterpolator();
    }

    public final void a(Canvas r8, int r10) {
        Rect r11 = getBounds();
        Drawable r12 = this.f9333j;
        r12.setBounds(r11);
        Rect r13 = getBounds();
        Drawable r14 = this.f9334k;
        r14.setBounds(r13);
        boolean r15 = this.f9331h;
        if (r15 == false) goto L5;
        r12.setAlpha(255 - r10);
    L5:
        r12.draw(r8);
        if (r15 == false) goto L8;
        r12.setAlpha(255);
    L8:
        if (r10 <= 0) goto L11;
        r14.setAlpha(r10);
        r14.draw(r8);
        r14.setAlpha(255);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        int r10 = this.f9324a;
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L11;
        long r11 = SystemClock.uptimeMillis() - this.f9325b;
        int r12 = this.f9326c;
        if (r11 < r12) goto L9;
        this.f9329f = this.f9328e;
        this.f9324a = 0;
        goto L11
    L9:
        float r13 = this.f9332i.getInterpolation(r11 / r12);
        int r14 = this.f9327d;
        this.f9329f = r14 + ((int) ((this.f9328e - r14) * r13));
    L11:
        int r15 = this.f9329f;
        if (this.f9324a != 0) goto L21;
        if (r15 != 0) goto L16;
        Rect r16 = getBounds();
        Drawable r17 = this.f9333j;
    L18:
        r17.setBounds(r16);
        r17.draw(r8);
        return;
    L16:
        if (r15 != 255) goto L19;
        r16 = getBounds();
        r17 = this.f9334k;
        goto L18
    L19:
        a(r8, r15);
        return;
    L21:
        a(r8, r15);
        if (this.f9324a != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.f9325b = SystemClock.uptimeMillis();
        this.f9324a = 2;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f9333j.getIntrinsicHeight(), this.f9334k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f9333j.getIntrinsicWidth(), this.f9334k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        this.f9333j.setAlpha(r8);
        this.f9334k.setAlpha(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        this.f9333j.setColorFilter(r8);
        this.f9334k.setColorFilter(r8);
    }
}
