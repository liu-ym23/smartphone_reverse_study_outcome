package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes.dex */
public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapperCompat(Drawable r10) {
        setDrawable(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        this.mDrawable.draw(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r10) {
        return this.mDrawable.getPadding(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        this.mDrawable.setBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        return this.mDrawable.setLevel(r10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r10, Runnable r11, long r12) {
        scheduleSelf(r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.mDrawable.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r10) {
        DrawableCompat.setAutoMirrored(this.mDrawable, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r10) {
        this.mDrawable.setChangingConfigurations(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mDrawable.setColorFilter(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r10) {
        this.mDrawable.setDither(r10);
    }

    public void setDrawable(@Nullable Drawable r10) {
        Drawable r11 = this.mDrawable;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.mDrawable = r10;
        if (r10 == null) goto L9;
        r10.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        this.mDrawable.setFilterBitmap(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r10, float r11) {
        DrawableCompat.setHotspot(this.mDrawable, r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r10, int r11, int r12, int r13) {
        DrawableCompat.setHotspotBounds(this.mDrawable, r10, r11, r12, r13);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r10) {
        return this.mDrawable.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r10) {
        DrawableCompat.setTint(this.mDrawable, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r10) {
        DrawableCompat.setTintList(this.mDrawable, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r10) {
        DrawableCompat.setTintMode(this.mDrawable, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        if (super.setVisible(r10, r11) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawable.setVisible(r10, r11) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r10, Runnable r11) {
        unscheduleSelf(r11);
    }
}
