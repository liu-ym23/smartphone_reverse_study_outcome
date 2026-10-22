package e;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f7099a;

    public a(Drawable r8) {
        Drawable r10 = this.f7099a;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.f7099a = r8;
        if (r8 == null) goto L9;
        r8.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r8) {
        this.f7099a.draw(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.f7099a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f7099a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7099a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7099a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f7099a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f7099a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f7099a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect r8) {
        return this.f7099a.getPadding(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f7099a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f7099a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r8) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return b0.a.C0028a.d(this.f7099a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f7099a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f7099a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        this.f7099a.setBounds(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r8) {
        return this.f7099a.setLevel(r8);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r8, Runnable r10, long r11) {
        scheduleSelf(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        this.f7099a.setAlpha(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean r8) {
        b0.a.C0028a.e(this.f7099a, r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int r8) {
        this.f7099a.setChangingConfigurations(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        this.f7099a.setColorFilter(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r8) {
        this.f7099a.setDither(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r8) {
        this.f7099a.setFilterBitmap(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r8, float r10) {
        b0.a.b.e(this.f7099a, r8, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r8, int r10, int r11, int r12) {
        b0.a.b.f(this.f7099a, r8, r10, r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r8) {
        return this.f7099a.setState(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int r8) {
        b0.a.b.g(this.f7099a, r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r8) {
        b0.a.b(this.f7099a, r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r8) {
        b0.a.c(this.f7099a, r8);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r8, boolean r10) {
        if (super.setVisible(r8, r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f7099a.setVisible(r8, r10) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r8, Runnable r10) {
        unscheduleSelf(r10);
    }
}
