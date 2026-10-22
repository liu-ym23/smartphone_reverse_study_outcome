package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f7829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawableProperties f7830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable[] f7831c;
    public final DrawableParent[] d;
    public final Rect e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7832h;

    public ArrayDrawable(Drawable[] r5) {
        this.f7830b = new DrawableProperties();
        this.e = new Rect();
        int r10 = 0;
        this.f = false;
        this.g = false;
        this.f7832h = false;
        this.f7831c = r5;
    L3:
        Drawable[] r11 = this.f7831c;
        if (r10 >= r11.length) goto L6;
        DrawableUtils.a(r11[r10], this, this);
        r10 = r10 + 1;
        goto L3
    L6:
        this.d = new DrawableParent[r11.length];
    }

    public final Drawable a(int r5) {
        if (r5 < 0) goto L10;
        Drawable[] r10 = this.f7831c;
        if (r5 >= r10.length) goto L8;
        return r10[r5];
    L8:
        throw new IllegalArgumentException();
    L10:
        throw new IllegalArgumentException();
    }

    public final DrawableParent b(final int r5) {
        if (r5 < 0) goto L13;
        DrawableParent[] r10 = this.d;
        if (r5 >= r10.length) goto L11;
        if (r10[r5] != null) goto L9;
        r10[r5] = new AnonymousClass1(this, r5);
    L9:
        return r10[r5];
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IllegalArgumentException();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        int r5 = 0;
        int r10 = -1;
    L3:
        Drawable[] r11 = this.f7831c;
        if (r5 >= r11.length) goto L9;
        Drawable r12 = r11[r5];
        if (r12 == null) goto L8;
        r10 = Math.max(r10, r12.getIntrinsicHeight());
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r10 <= 0) goto L11;
        return r10;
    L11:
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        int r5 = 0;
        int r10 = -1;
    L3:
        Drawable[] r11 = this.f7831c;
        if (r5 >= r11.length) goto L9;
        Drawable r12 = r11[r5];
        if (r12 == null) goto L8;
        r10 = Math.max(r10, r12.getIntrinsicWidth());
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r10 <= 0) goto L11;
        return r10;
    L11:
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f7831c.length != 0) goto L6;
        return -2;
    L6:
        int r5 = 1;
        int r10 = -1;
    L7:
        Drawable[] r11 = this.f7831c;
        if (r5 >= r11.length) goto L13;
        Drawable r12 = r11[r5];
        if (r12 == null) goto L12;
        r10 = Drawable.resolveOpacity(r10, r12.getOpacity());
    L12:
        r5 = r5 + 1;
        goto L7
    L13:
        return r10;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect r5) {
        int r10 = 0;
        r5.left = 0;
        r5.top = 0;
        r5.right = 0;
        r5.bottom = 0;
        Rect r11 = this.e;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r10 >= r12.length) goto L9;
        Drawable r13 = r12[r10];
        if (r13 == null) goto L8;
        r13.getPadding(r11);
        r5.left = Math.max(r5.left, r11.left);
        r5.top = Math.max(r5.top, r11.top);
        r5.right = Math.max(r5.right, r11.right);
        r5.bottom = Math.max(r5.bottom, r11.bottom);
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (this.g == true) goto L16;
        this.f = false;
        int r5 = 0;
    L5:
        Drawable[] r10 = this.f7831c;
        boolean r11 = true;
        if (r5 >= r10.length) goto L14;
        Drawable r12 = r10[r5];
        boolean r13 = this.f;
        if (r12 != null) goto L10;
    L12:
        r11 = false;
    L13:
        this.f = r13 | r11;
        r5 = r5 + 1;
        goto L5
    L10:
        if (r12.isStateful() == false) goto L12;
    L14:
        this.g = true;
    L16:
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        int r5 = 0;
    L3:
        Drawable[] r10 = this.f7831c;
        if (r5 >= r10.length) goto L9;
        Drawable r11 = r10[r5];
        if (r11 == null) goto L8;
        r11.mutate();
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        this.f7832h = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        int r10 = 0;
    L3:
        Drawable[] r11 = this.f7831c;
        if (r10 >= r11.length) goto L9;
        Drawable r12 = r11[r10];
        if (r12 == null) goto L8;
        r12.setBounds(r5);
    L8:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r5) {
        int r10 = 0;
        boolean r11 = false;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r10 >= r12.length) goto L11;
        Drawable r13 = r12[r10];
        if (r13 == null) goto L10;
        if (r13.setLevel(r5) == false) goto L10;
        r11 = true;
    L10:
        r10 = r10 + 1;
        goto L3
    L11:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r5) {
        int r10 = 0;
        boolean r11 = false;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r10 >= r12.length) goto L11;
        Drawable r13 = r12[r10];
        if (r13 == null) goto L10;
        if (r13.setState(r5) == false) goto L10;
        r11 = true;
    L10:
        r10 = r10 + 1;
        goto L3
    L11:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        scheduleSelf(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        DrawableProperties r10 = this.f7830b;
        r10.f7837c = r5;
        r10.f7836b = true;
        int r11 = 0;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r11 >= r12.length) goto L9;
        Drawable r13 = r12[r11];
        if (r13 == null) goto L8;
        r13.setColorFilter(r5);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r5) {
        DrawableProperties r10 = this.f7830b;
        r10.d = r5 ? 1 : 0;
        int r11 = 0;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r11 >= r12.length) goto L9;
        Drawable r13 = r12[r11];
        if (r13 == null) goto L8;
        r13.setDither(r5);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r5) {
        DrawableProperties r10 = this.f7830b;
        r10.e = r5 ? 1 : 0;
        int r11 = 0;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r11 >= r12.length) goto L9;
        Drawable r13 = r12[r11];
        if (r13 == null) goto L8;
        r13.setFilterBitmap(r5);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float r5, float r10) {
        int r11 = 0;
    L3:
        Drawable[] r12 = this.f7831c;
        if (r11 >= r12.length) goto L9;
        Drawable r13 = r12[r11];
        if (r13 == null) goto L8;
        r13.setHotspot(r5, r10);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        int r12 = 0;
    L3:
        Drawable[] r13 = this.f7831c;
        if (r12 >= r13.length) goto L9;
        Drawable r14 = r13[r12];
        if (r14 == null) goto L8;
        r14.setVisible(r5, r10);
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        unscheduleSelf(r10);
    }

    public final Drawable a(int r5, Drawable r10) {
        if (r5 < 0) goto L21;
        Drawable[] r11 = this.f7831c;
        if (r5 >= r11.length) goto L19;
        Drawable r12 = r11[r5];
        if (r10 == r12) goto L17;
        if (r10 != null) goto L9;
    L11:
        DrawableUtils.a(this.f7831c[r5], null, null);
        DrawableUtils.a(r10, null, null);
        DrawableUtils.a(r10, this.f7830b);
        if (r10 == null) goto L16;
        if (r10 == this) goto L16;
        r10.setBounds(getBounds());
        r10.setChangingConfigurations(getChangingConfigurations());
        r10.setLevel(getLevel());
        r10.setVisible(isVisible(), false);
        r10.setState(getState());
    L16:
        DrawableUtils.a(r10, this, this);
        this.g = false;
        this.f7831c[r5] = r10;
        invalidateSelf();
        goto L17
    L9:
        if (this.f7832h == false) goto L11;
        r10.mutate();
    L17:
        return r12;
    L19:
        throw new IllegalArgumentException();
    L21:
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void a(TransformCallback r5) {
        this.f7829a = (Drawable) r5;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void a(Matrix r5) {
        ?? r10 = this.f7829a;
        if (r10 == 0) goto L6;
        r10.a(r5);
        return;
    L6:
        r5.reset();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void a(RectF r5) {
        ?? r10 = this.f7829a;
        if (r10 == 0) goto L6;
        r10.a(r5);
        return;
    L6:
        r5.set(getBounds());
    }
}
