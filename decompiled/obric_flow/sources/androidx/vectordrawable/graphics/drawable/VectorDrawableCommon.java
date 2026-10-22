package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* JADX INFO: loaded from: classes.dex */
abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    public VectorDrawableCommon() {
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.applyTheme(r10, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        r5.clearColorFilter();
        return;
    L6:
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getCurrent();
    L7:
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getMinimumHeight();
    L7:
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getMinimumWidth();
    L7:
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getPadding(r5);
    L7:
        return super.getPadding(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getState();
    L7:
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getTransparentRegion();
    L7:
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        DrawableCompat.jumpToCurrentState(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    L6:
        super.onBoundsChange(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.setLevel(r5);
    L7:
        return super.onLevelChange(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setChangingConfigurations(r5);
        return;
    L6:
        super.setChangingConfigurations(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r5, PorterDuff.Mode r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setColorFilter(r5, r10);
        return;
    L6:
        super.setColorFilter(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setFilterBitmap(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r5, float r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setHotspot(r11, r5, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r5, int r10, int r11, int r12) {
        Drawable r13 = this.mDelegateDrawable;
        if (r13 == null) goto L6;
        DrawableCompat.setHotspotBounds(r13, r5, r10, r11, r12);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.setState(r5);
    L7:
        return super.setState(r5);
    }
}
