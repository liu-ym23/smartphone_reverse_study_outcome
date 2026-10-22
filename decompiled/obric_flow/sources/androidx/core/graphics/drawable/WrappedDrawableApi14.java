package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
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

    public WrappedDrawableApi14(@NonNull WrappedDrawableState r5, @Nullable Resources r10) {
        this.mState = r5;
        updateLocalState(r10);
    }

    @NonNull
    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    private void updateLocalState(@Nullable Resources r5) {
        WrappedDrawableState r10 = this.mState;
        if (r10 == null) goto L8;
        Drawable.ConstantState r11 = r10.mDrawableState;
        if (r11 == null) goto L9;
        setWrappedDrawable(r11.newDrawable(r5));
        return;
    L9:
        return;
    }

    private boolean updateTint(int[] r5) {
        if (isCompatTintEnabled() == true) goto L5;
        return false;
    L5:
        WrappedDrawableState r10 = this.mState;
        ColorStateList r11 = r10.mTint;
        PorterDuff.Mode r12 = r10.mTintMode;
        if (r11 == null) goto L16;
        if (r12 == null) goto L16;
        int r13 = r11.getColorForState(r5, r11.getDefaultColor());
        if (this.mColorFilterSet == true) goto L11;
    L14:
        setColorFilter(r13, r12);
        this.mCurrentColor = r13;
        this.mCurrentMode = r12;
        this.mColorFilterSet = true;
        return true;
    L11:
        if (r13 != this.mCurrentColor) goto L14;
        if (r12 != this.mCurrentMode) goto L14;
    L17:
        return false;
    L16:
        this.mColorFilterSet = false;
        clearColorFilter();
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        this.mDrawable.draw(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r5 = super.getChangingConfigurations();
        WrappedDrawableState r10 = this.mState;
        if (r10 == null) goto L5;
        int r11 = r10.getChangingConfigurations();
    L6:
        int r12 = this.mDrawable.getChangingConfigurations();
        return r12 | (r5 | r11);
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState r5 = this.mState;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.canConstantState() == false) goto L10;
        WrappedDrawableState r10 = this.mState;
        r10.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    L10:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
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
    @RequiresApi(23)
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
    public boolean getPadding(@NonNull Rect r5) {
        return this.mDrawable.getPadding(r5);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
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
    public void invalidateDrawable(@NonNull Drawable r5) {
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
        WrappedDrawableState r5 = this.mState;
        if (r5 == null) goto L7;
        ColorStateList r10 = r5.mTint;
    L8:
        if (r10 == null) goto L12;
        if (r10.isStateful() == false) goto L12;
    L13:
        return true;
    L12:
        if (this.mDrawable.isStateful() == true) goto L13;
        return false;
    L7:
        r10 = null;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L17:
        return this;
    L5:
        if (super.mutate() != this) goto L17;
        this.mState = mutateConstantState();
        Drawable r5 = this.mDrawable;
        if (r5 == null) goto L9;
        r5.mutate();
    L9:
        WrappedDrawableState r10 = this.mState;
        if (r10 == null) goto L16;
        Drawable r11 = this.mDrawable;
        if (r11 == null) goto L14;
        Drawable.ConstantState r12 = r11.getConstantState();
    L15:
        r10.mDrawableState = r12;
        goto L16
    L14:
        r12 = null;
    L16:
        this.mMutated = true;
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.mDrawable;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int r5) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        return this.mDrawable.setLevel(r5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10, long r11) {
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

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r5) {
        this.mDrawable.setFilterBitmap(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] r5) {
        boolean r10 = this.mDrawable.setState(r5);
        if (updateTint(r5) == true) goto L7;
        if (r10 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r5) {
        setTintList(ColorStateList.valueOf(r5));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r5) {
        this.mState.mTint = r5;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r5) {
        this.mState.mTintMode = r5;
        updateTint(getState());
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

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void setWrappedDrawable(Drawable r5) {
        Drawable r10 = this.mDrawable;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.mDrawable = r5;
        if (r5 == null) goto L10;
        r5.setCallback(this);
        setVisible(r5.isVisible(), true);
        setState(r5.getState());
        setLevel(r5.getLevel());
        setBounds(r5.getBounds());
        WrappedDrawableState r11 = this.mState;
        if (r11 == null) goto L10;
        r11.mDrawableState = r5.getConstantState();
    L10:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10) {
        unscheduleSelf(r10);
    }

    public WrappedDrawableApi14(@Nullable Drawable r5) {
        this.mState = mutateConstantState();
        setWrappedDrawable(r5);
    }
}
