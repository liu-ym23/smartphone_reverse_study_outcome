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

    VectorDrawableCommon() {
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.applyTheme(r11, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.clearColorFilter();
        return;
    L6:
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getCurrent();
    L7:
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getMinimumHeight();
    L7:
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getMinimumWidth();
    L7:
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.getPadding(r10);
    L7:
        return super.getPadding(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getState();
    L7:
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getTransparentRegion();
    L7:
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.jumpToCurrentState(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setBounds(r10);
        return;
    L6:
        super.onBoundsChange(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.setLevel(r10);
    L7:
        return super.onLevelChange(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setChangingConfigurations(r10);
        return;
    L6:
        super.setChangingConfigurations(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r10, PorterDuff.Mode r11) {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 == null) goto L6;
        r12.setColorFilter(r10, r11);
        return;
    L6:
        super.setColorFilter(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setFilterBitmap(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r10, float r11) {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 == null) goto L6;
        DrawableCompat.setHotspot(r12, r10, r11);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r10, int r11, int r12, int r13) {
        Drawable r14 = this.mDelegateDrawable;
        if (r14 == null) goto L6;
        DrawableCompat.setHotspotBounds(r14, r10, r11, r12, r13);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.setState(r10);
    L7:
        return super.setState(r10);
    }
}
