package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, TintAwareDrawable, WrappedDrawable {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    WrappedDrawableState mState;

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    WrappedDrawableApi14(Drawable r2) {
        this.mState = mutateConstantState();
        setWrappedDrawable(r2);
    }

    WrappedDrawableApi14(WrappedDrawableState r1, Resources r2) {
        this.mState = r1;
        updateLocalState(r2);
    }

    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    private void updateLocalState(Resources r2) {
        WrappedDrawableState r0 = this.mState;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.mDrawableState == null) goto L9;
        setWrappedDrawable(this.mState.mDrawableState.newDrawable(r2));
        return;
    }

    private boolean updateTint(int[] r5) {
        if (isCompatTintEnabled() == true) goto L5;
        return false;
    L5:
        ColorStateList r0 = this.mState.mTint;
        PorterDuff.Mode r2 = this.mState.mTintMode;
        if (r0 == null) goto L16;
        if (r2 == null) goto L16;
        int r6 = r0.getColorForState(r5, r0.getDefaultColor());
        if (this.mColorFilterSet == true) goto L11;
    L14:
        setColorFilter(r6, r2);
        this.mCurrentColor = r6;
        this.mCurrentMode = r2;
        this.mColorFilterSet = true;
        return true;
    L11:
        if (r6 != this.mCurrentColor) goto L14;
        if (r2 != this.mCurrentMode) goto L14;
    L17:
        return false;
    L16:
        this.mColorFilterSet = false;
        clearColorFilter();
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r1) {
        this.mDrawable.draw(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r0 = super.getChangingConfigurations();
        WrappedDrawableState r1 = this.mState;
        if (r1 == null) goto L5;
        int r2 = r1.getChangingConfigurations();
    L6:
        int r3 = this.mDrawable.getChangingConfigurations();
        return r3 | (r0 | r2);
    L5:
        r2 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState r0 = this.mState;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.canConstantState() == false) goto L10;
        WrappedDrawableState r1 = this.mState;
        r1.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    L10:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
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
    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.mDrawable);
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
    public boolean getPadding(Rect r1) {
        return this.mDrawable.getPadding(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isCompatTintEnabled() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isCompatTintEnabled() == false) goto L7;
        WrappedDrawableState r0 = this.mState;
        if (r0 == null) goto L7;
        ColorStateList r1 = r0.mTint;
    L8:
        if (r1 == null) goto L12;
        if (r1.isStateful() == false) goto L12;
    L13:
        return true;
    L12:
        if (this.mDrawable.isStateful() == true) goto L13;
        return false;
    L7:
        r1 = null;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L17:
        return this;
    L5:
        if (super.mutate() != this) goto L17;
        this.mState = mutateConstantState();
        Drawable r0 = this.mDrawable;
        if (r0 == null) goto L9;
        r0.mutate();
    L9:
        WrappedDrawableState r1 = this.mState;
        if (r1 == null) goto L16;
        Drawable r2 = this.mDrawable;
        if (r2 == null) goto L14;
        Drawable.ConstantState r3 = r2.getConstantState();
    L15:
        r1.mDrawableState = r3;
        goto L16
    L14:
        r3 = null;
    L16:
        this.mMutated = true;
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        Drawable r0 = this.mDrawable;
        if (r0 == null) goto L6;
        r0.setBounds(r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r1) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, r1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r1) {
        return this.mDrawable.setLevel(r1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        scheduleSelf((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.mDrawable.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r1) {
        DrawableCompat.setAutoMirrored(this.mDrawable, r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r1) {
        this.mDrawable.setChangingConfigurations(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.mDrawable.setColorFilter(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r1) {
        this.mDrawable.setDither(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r1) {
        this.mDrawable.setFilterBitmap(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r2) {
        boolean r0 = this.mDrawable.setState(r2);
        if (updateTint(r2) == true) goto L7;
        if (r0 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r1) {
        setTintList(ColorStateList.valueOf(r1));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        this.mState.mTint = r2;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        this.mState.mTintMode = r2;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        if (super.setVisible(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawable.setVisible(r2, r3) == true) goto L8;
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void setWrappedDrawable(Drawable r3) {
        Drawable r0 = this.mDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mDrawable = r3;
        if (r3 == null) goto L10;
        r3.setCallback(this);
        setVisible(r3.isVisible(), true);
        setState(r3.getState());
        setLevel(r3.getLevel());
        setBounds(r3.getBounds());
        WrappedDrawableState r1 = this.mState;
        if (r1 == null) goto L10;
        r1.mDrawableState = r3.getConstantState();
    L10:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r2, Runnable r3) {
        unscheduleSelf((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }
}
