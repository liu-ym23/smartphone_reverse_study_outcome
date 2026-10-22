package m;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f9233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f9234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f9235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f9236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f9239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f9240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f9241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f9242k;

    public b(float r8, ColorStateList r10) {
        this.f9237f = false;
        this.f9238g = true;
        this.f9242k = PorterDuff.Mode.SRC_IN;
        this.f9232a = r8;
        this.f9233b = new Paint(5);
        b(r10);
        this.f9234c = new RectF();
        this.f9235d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList r8, PorterDuff.Mode r10) {
        if (r8 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r8.getColorForState(getState(), 0), r10);
    L7:
        return null;
    }

    public final void b(ColorStateList r8) {
        if (r8 != null) goto L4;
        r8 = ColorStateList.valueOf(0);
    L4:
        this.f9239h = r8;
        int r10 = r8.getColorForState(getState(), this.f9239h.getDefaultColor());
        this.f9233b.setColor(r10);
    }

    public final void c(Rect r13) {
        if (r13 != null) goto L4;
        r13 = getBounds();
    L4:
        RectF r8 = this.f9234c;
        r8.set(r13.left, r13.top, r13.right, r13.bottom);
        Rect r10 = this.f9235d;
        r10.set(r13);
        if (this.f9237f == false) goto L14;
        float r14 = this.f9236e;
        float r11 = this.f9232a;
        boolean r12 = this.f9238g;
        float r15 = 1.5f * r14;
        if (r12 == false) goto L9;
        r15 = (float) (((1.0d - c.f9243a) * ((double) r11)) + ((double) r15));
    L10:
        if (r12 == false) goto L12;
        r14 = (float) (((1.0d - c.f9243a) * ((double) r11)) + ((double) r14));
    L12:
        r10.inset((int) Math.ceil(r14), (int) Math.ceil(r15));
        r8.set(r10);
        return;
    L9:
        int r16 = c.f9244b;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Paint r10 = this.f9233b;
        if (this.f9240i != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        RectF r12 = this.f9234c;
        float r13 = this.f9232a;
        r8.drawRoundRect(r12, r13, r13, r10);
        if (r11 == false) goto L12;
        r10.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (r10.getColorFilter() != null) goto L7;
        r10.setColorFilter(this.f9240i);
        r11 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r8) {
        r8.setRoundRect(this.f9235d, this.f9232a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList r8 = this.f9241j;
        if (r8 != null) goto L5;
    L6:
        ColorStateList r10 = this.f9239h;
        if (r10 == null) goto L11;
        if (r10.isStateful() == false) goto L11;
    L12:
        return true;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    L5:
        if (r8.isStateful() == true) goto L12;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        super.onBoundsChange(r8);
        c(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r8) {
        ColorStateList r10 = this.f9239h;
        int r11 = r10.getColorForState(r8, r10.getDefaultColor());
        Paint r12 = this.f9233b;
        if (r11 == r12.getColor()) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        r12.setColor(r11);
    L8:
        ColorStateList r14 = this.f9241j;
        if (r14 == null) goto L14;
        PorterDuff.Mode r15 = this.f9242k;
        if (r15 == null) goto L14;
        this.f9240i = a(r14, r15);
        return true;
    L14:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        this.f9233b.setAlpha(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        this.f9233b.setColorFilter(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r8) {
        this.f9241j = r8;
        this.f9240i = a(r8, this.f9242k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r8) {
        this.f9242k = r8;
        this.f9240i = a(this.f9241j, r8);
        invalidateSelf();
    }
}
