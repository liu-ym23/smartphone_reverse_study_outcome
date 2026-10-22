package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatBackgroundHelper {
    private int mBackgroundResId;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;

    @NonNull
    private final View mView;

    public AppCompatBackgroundHelper(@NonNull View r5) {
        this.mBackgroundResId = -1;
        this.mView = r5;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r5) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r10 = this.mTmpInfo;
        r10.clear();
        ColorStateList r11 = ViewCompat.getBackgroundTintList(this.mView);
        if (r11 == null) goto L8;
        r10.mHasTintList = true;
        r10.mTintList = r11;
    L8:
        PorterDuff.Mode r12 = ViewCompat.getBackgroundTintMode(this.mView);
        if (r12 == null) goto L12;
        r10.mHasTintMode = true;
        r10.mTintMode = r12;
    L12:
        if (r10.mHasTintList == false) goto L14;
    L18:
        AppCompatDrawableManager.tintDrawable(r5, r10, this.mView.getDrawableState());
        return true;
    L14:
        if (r10.mHasTintMode == true) goto L18;
        return false;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        if (this.mInternalBackgroundTint == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void applySupportBackgroundTint() {
        Drawable r5 = this.mView.getBackground();
        if (r5 != null) goto L5;
        return;
    L5:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L7;
    L9:
        TintInfo r10 = this.mBackgroundTint;
        if (r10 == null) goto L12;
        AppCompatDrawableManager.tintDrawable(r5, r10, this.mView.getDrawableState());
        return;
    L12:
        TintInfo r11 = this.mInternalBackgroundTint;
        if (r11 == null) goto L18;
        AppCompatDrawableManager.tintDrawable(r5, r11, this.mView.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (applyFrameworkTintUsingColorFilter(r5) == false) goto L9;
    }

    public ColorStateList getSupportBackgroundTintList() {
        TintInfo r5 = this.mBackgroundTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintList;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r5 = this.mBackgroundTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintMode;
    }

    public void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r10, R.styleable.ViewBackgroundHelper, r11, 0);
        View r12 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r12, r12.getContext(), R.styleable.ViewBackgroundHelper, r10, r5.getWrappedTypeArray(), r11, 0);
    L8:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(R.styleable.ViewBackgroundHelper_android_background) == false) goto L11;
        this.mBackgroundResId = r5.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);     // Catch: Throwable -> L8
        ColorStateList r13 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);     // Catch: Throwable -> L8
        if (r13 == null) goto L11;
        setInternalBackgroundTint(r13);     // Catch: Throwable -> L8
    L11:
        if (r5.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint) == false) goto L14;
        ViewCompat.setBackgroundTintList(this.mView, r5.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));     // Catch: Throwable -> L8
    L14:
        if (r5.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode) == false) goto L16;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r5.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));     // Catch: Throwable -> L8
    L16:
        r5.recycle();
    }

    public void onSetBackgroundDrawable(Drawable r5) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int r5) {
        this.mBackgroundResId = r5;
        AppCompatDrawableManager r10 = this.mDrawableManager;
        if (r10 == null) goto L5;
        ColorStateList r11 = r10.getTintList(this.mView.getContext(), r5);
    L6:
        setInternalBackgroundTint(r11);
        applySupportBackgroundTint();
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void setInternalBackgroundTint(ColorStateList r5) {
        if (r5 != null) goto L4;
        this.mInternalBackgroundTint = null;
    L8:
        applySupportBackgroundTint();
        return;
    L4:
        if (this.mInternalBackgroundTint != null) goto L6;
        this.mInternalBackgroundTint = new TintInfo();
    L6:
        TintInfo r10 = this.mInternalBackgroundTint;
        r10.mTintList = r5;
        r10.mHasTintList = true;
        goto L8
    }

    public void setSupportBackgroundTintList(ColorStateList r5) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r10 = this.mBackgroundTint;
        r10.mTintList = r5;
        r10.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r5) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r10 = this.mBackgroundTint;
        r10.mTintMode = r5;
        r10.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
