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

    WrappedDrawableApi14(@Nullable Drawable r10) {
        this.mState = mutateConstantState();
        setWrappedDrawable(r10);
    }

    WrappedDrawableApi14(@NonNull WrappedDrawableState r10, @Nullable Resources r11) {
        this.mState = r10;
        updateLocalState(r11);
    }

    @NonNull
    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    private void updateLocalState(@Nullable Resources r10) {
        WrappedDrawableState r11 = this.mState;
        if (r11 == null) goto L8;
        Drawable.ConstantState r12 = r11.mDrawableState;
        if (r12 == null) goto L9;
        setWrappedDrawable(r12.newDrawable(r10));
        return;
    L9:
        return;
    }

    private boolean updateTint(int[] r10) {
        if (isCompatTintEnabled() == true) goto L5;
        return false;
    L5:
        WrappedDrawableState r11 = this.mState;
        ColorStateList r12 = r11.mTint;
        PorterDuff.Mode r13 = r11.mTintMode;
        if (r12 == null) goto L16;
        if (r13 == null) goto L16;
        int r14 = r12.getColorForState(r10, r12.getDefaultColor());
        if (this.mColorFilterSet == true) goto L11;
    L14:
        setColorFilter(r14, r13);
        this.mCurrentColor = r14;
        this.mCurrentMode = r13;
        this.mColorFilterSet = true;
        return true;
    L11:
        if (r14 != this.mCurrentColor) goto L14;
        if (r13 != this.mCurrentMode) goto L14;
    L17:
        return false;
    L16:
        this.mColorFilterSet = false;
        clearColorFilter();
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        this.mDrawable.draw(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r10 = super.getChangingConfigurations();
        WrappedDrawableState r11 = this.mState;
        if (r11 == null) goto L5;
        int r12 = r11.getChangingConfigurations();
    L6:
        int r13 = this.mDrawable.getChangingConfigurations();
        return r13 | (r10 | r12);
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState r10 = this.mState;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.canConstantState() == false) goto L10;
        WrappedDrawableState r11 = this.mState;
        r11.mChangingConfigurations = getChangingConfigurations();
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
    public boolean getPadding(@NonNull Rect r10) {
        return this.mDrawable.getPadding(r10);
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
    public void invalidateDrawable(@NonNull Drawable r10) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    protected boolean isCompatTintEnabled() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isCompatTintEnabled() == false) goto L7;
        WrappedDrawableState r10 = this.mState;
        if (r10 == null) goto L7;
        ColorStateList r11 = r10.mTint;
    L8:
        if (r11 == null) goto L12;
        if (r11.isStateful() == false) goto L12;
    L13:
        return true;
    L12:
        if (this.mDrawable.isStateful() == true) goto L13;
        return false;
    L7:
        r11 = null;
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
        Drawable r10 = this.mDrawable;
        if (r10 == null) goto L9;
        r10.mutate();
    L9:
        WrappedDrawableState r11 = this.mState;
        if (r11 == null) goto L16;
        Drawable r12 = this.mDrawable;
        if (r12 == null) goto L14;
        Drawable.ConstantState r13 = r12.getConstantState();
    L15:
        r11.mDrawableState = r13;
        goto L16
    L14:
        r13 = null;
    L16:
        this.mMutated = true;
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Drawable r11 = this.mDrawable;
        if (r11 == null) goto L6;
        r11.setBounds(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int r10) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        return this.mDrawable.setLevel(r10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11, long r12) {
        scheduleSelf(r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.mDrawable.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
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

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        this.mDrawable.setFilterBitmap(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] r10) {
        boolean r11 = this.mDrawable.setState(r10);
        if (updateTint(r10) == true) goto L7;
        if (r11 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r10) {
        setTintList(ColorStateList.valueOf(r10));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r10) {
        this.mState.mTint = r10;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r10) {
        this.mState.mTintMode = r10;
        updateTint(getState());
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

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void setWrappedDrawable(Drawable r10) {
        Drawable r11 = this.mDrawable;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.mDrawable = r10;
        if (r10 == null) goto L10;
        r10.setCallback(this);
        setVisible(r10.isVisible(), true);
        setState(r10.getState());
        setLevel(r10.getLevel());
        setBounds(r10.getBounds());
        WrappedDrawableState r12 = this.mState;
        if (r12 == null) goto L10;
        r12.mDrawableState = r10.getConstantState();
    L10:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11) {
        unscheduleSelf(r11);
    }
}
