package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f7847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawableProperties f7848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f7849c;

    static {
        new Matrix();
    }

    public ForwardingDrawable(Drawable r5) {
        this.f7848b = new DrawableProperties();
        this.f7847a = r5;
        DrawableUtils.a(r5, this, this);
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public final Drawable a(Drawable r5) {
        return b(r5);
    }

    public Drawable b(Drawable r5) {
        Drawable r10 = this.f7847a;
        DrawableUtils.a(r10, null, null);
        DrawableUtils.a(r5, null, null);
        DrawableUtils.a(r5, this.f7848b);
        if (r5 == null) goto L7;
        if (r5 == this) goto L7;
        r5.setBounds(getBounds());
        r5.setChangingConfigurations(getChangingConfigurations());
        r5.setLevel(getLevel());
        r5.setVisible(isVisible(), false);
        r5.setState(getState());
    L7:
        DrawableUtils.a(r5, this, this);
        this.f7847a = r5;
        invalidateSelf();
        return r10;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public final Drawable c() {
        return this.f7847a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Drawable r10 = this.f7847a;
        if (r10 == null) goto L6;
        r10.draw(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        Drawable r5 = this.f7847a;
        if (r5 != null) goto L7;
        return super.getConstantState();
    L7:
        return r5.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f7847a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r5 = this.f7847a;
        if (r5 != null) goto L7;
        return super.getIntrinsicHeight();
    L7:
        return r5.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r5 = this.f7847a;
        if (r5 != null) goto L7;
        return super.getIntrinsicWidth();
    L7:
        return r5.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable r5 = this.f7847a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect r5) {
        Drawable r10 = this.f7847a;
        if (r10 != null) goto L7;
        return super.getPadding(r5);
    L7:
        return r10.getPadding(r5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable r5 = this.f7847a;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable r5 = this.f7847a;
        if (r5 == null) goto L5;
        r5.mutate();
    L5:
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.f7847a;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r5) {
        Drawable r10 = this.f7847a;
        if (r10 != null) goto L7;
        return super.onLevelChange(r5);
    L7:
        return r10.setLevel(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r5) {
        Drawable r10 = this.f7847a;
        if (r10 != null) goto L7;
        return super.onStateChange(r5);
    L7:
        return r10.setState(r5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        scheduleSelf(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f7848b.f7835a = r5;
        Drawable r10 = this.f7847a;
        if (r10 == null) goto L6;
        r10.setAlpha(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        DrawableProperties r10 = this.f7848b;
        r10.f7837c = r5;
        r10.f7836b = true;
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L6;
        r11.setColorFilter(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r5) {
        DrawableProperties r10 = this.f7848b;
        r10.d = r5 ? 1 : 0;
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L6;
        r11.setDither(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r5) {
        DrawableProperties r10 = this.f7848b;
        r10.e = r5 ? 1 : 0;
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L6;
        r11.setFilterBitmap(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float r5, float r10) {
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L6;
        r11.setHotspot(r5, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        Drawable r12 = this.f7847a;
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.setVisible(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        unscheduleSelf(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void a(TransformCallback r5) {
        this.f7849c = (Drawable) r5;
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void a(Matrix r5) {
        b(r5);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void a(RectF r5) {
        ?? r10 = this.f7849c;
        if (r10 == 0) goto L6;
        r10.a(r5);
        return;
    L6:
        r5.set(getBounds());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    public final void b(Matrix r5) {
        ?? r10 = this.f7849c;
        if (r10 == 0) goto L6;
        r10.a(r5);
        return;
    L6:
        r5.reset();
    }
}
