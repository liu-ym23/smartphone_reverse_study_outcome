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

    public DrawableWrapperCompat(Drawable r5) {
        setDrawable(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        this.mDrawable.draw(r5);
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
    public boolean getPadding(Rect r5) {
        return this.mDrawable.getPadding(r5);
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
    public void invalidateDrawable(Drawable r5) {
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
    public void onBoundsChange(Rect r5) {
        this.mDrawable.setBounds(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        return this.mDrawable.setLevel(r5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        scheduleSelf(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.mDrawable.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r5) {
        DrawableCompat.setAutoMirrored(this.mDrawable, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r5) {
        this.mDrawable.setChangingConfigurations(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mDrawable.setColorFilter(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r5) {
        this.mDrawable.setDither(r5);
    }

    public void setDrawable(@Nullable Drawable r5) {
        Drawable r10 = this.mDrawable;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.mDrawable = r5;
        if (r5 == null) goto L9;
        r5.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r5) {
        this.mDrawable.setFilterBitmap(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r5, float r10) {
        DrawableCompat.setHotspot(this.mDrawable, r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r5, int r10, int r11, int r12) {
        DrawableCompat.setHotspotBounds(this.mDrawable, r5, r10, r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r5) {
        return this.mDrawable.setState(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r5) {
        DrawableCompat.setTint(this.mDrawable, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r5) {
        DrawableCompat.setTintList(this.mDrawable, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r5) {
        DrawableCompat.setTintMode(this.mDrawable, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        if (super.setVisible(r5, r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawable.setVisible(r5, r10) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r5, Runnable r10) {
        unscheduleSelf(r10);
    }
}
