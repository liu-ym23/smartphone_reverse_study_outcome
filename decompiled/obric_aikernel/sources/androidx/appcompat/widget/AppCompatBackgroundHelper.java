package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

    AppCompatBackgroundHelper(@NonNull View r10) {
        this.mBackgroundResId = -1;
        this.mView = r10;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r10) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r11 = this.mTmpInfo;
        r11.clear();
        ColorStateList r12 = ViewCompat.getBackgroundTintList(this.mView);
        if (r12 == null) goto L8;
        r11.mHasTintList = true;
        r11.mTintList = r12;
    L8:
        PorterDuff.Mode r13 = ViewCompat.getBackgroundTintMode(this.mView);
        if (r13 == null) goto L12;
        r11.mHasTintMode = true;
        r11.mTintMode = r13;
    L12:
        if (r11.mHasTintList == false) goto L14;
    L18:
        AppCompatDrawableManager.tintDrawable(r10, r11, this.mView.getDrawableState());
        return true;
    L14:
        if (r11.mHasTintMode == true) goto L18;
        return false;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 > 21) goto L5;
        if (r10 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalBackgroundTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applySupportBackgroundTint() {
        Drawable r10 = this.mView.getBackground();
        if (r10 != null) goto L5;
        return;
    L5:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L7;
    L9:
        TintInfo r11 = this.mBackgroundTint;
        if (r11 == null) goto L12;
        AppCompatDrawableManager.tintDrawable(r10, r11, this.mView.getDrawableState());
        return;
    L12:
        TintInfo r12 = this.mInternalBackgroundTint;
        if (r12 == null) goto L18;
        AppCompatDrawableManager.tintDrawable(r10, r12, this.mView.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (applyFrameworkTintUsingColorFilter(r10) == false) goto L9;
    }

    ColorStateList getSupportBackgroundTintList() {
        TintInfo r10 = this.mBackgroundTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintList;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r10 = this.mBackgroundTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r12 = this.mView.getContext();
        int[] r13 = R.styleable.ViewBackgroundHelper;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r12, r10, r13, r11, 0);
        View r15 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14.getWrappedTypeArray(), r11, 0);
        int r16 = R.styleable.ViewBackgroundHelper_android_background;     // Catch: Throwable -> L16
        if (r14.hasValue(r16) == false) goto L8;
        this.mBackgroundResId = r14.getResourceId(r16, -1);     // Catch: Throwable -> L16
        ColorStateList r17 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);     // Catch: Throwable -> L16
        if (r17 == null) goto L8;
        setInternalBackgroundTint(r17);     // Catch: Throwable -> L16
    L8:
        int r18 = R.styleable.ViewBackgroundHelper_backgroundTint;     // Catch: Throwable -> L16
        if (r14.hasValue(r18) == false) goto L11;
        ViewCompat.setBackgroundTintList(this.mView, r14.getColorStateList(r18));     // Catch: Throwable -> L16
    L11:
        int r19 = R.styleable.ViewBackgroundHelper_backgroundTintMode;     // Catch: Throwable -> L16
        if (r14.hasValue(r19) == false) goto L14;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(r19, -1), null));     // Catch: Throwable -> L16
    L14:
        r14.recycle();
        return;
    L16:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    void onSetBackgroundDrawable(Drawable r10) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int r10) {
        this.mBackgroundResId = r10;
        AppCompatDrawableManager r11 = this.mDrawableManager;
        if (r11 == null) goto L5;
        ColorStateList r12 = r11.getTintList(this.mView.getContext(), r10);
    L6:
        setInternalBackgroundTint(r12);
        applySupportBackgroundTint();
        return;
    L5:
        r12 = null;
        goto L6
    }

    void setInternalBackgroundTint(ColorStateList r10) {
        if (r10 != null) goto L4;
        this.mInternalBackgroundTint = null;
    L8:
        applySupportBackgroundTint();
        return;
    L4:
        if (this.mInternalBackgroundTint != null) goto L6;
        this.mInternalBackgroundTint = new TintInfo();
    L6:
        TintInfo r11 = this.mInternalBackgroundTint;
        r11.mTintList = r10;
        r11.mHasTintList = true;
        goto L8
    }

    void setSupportBackgroundTintList(ColorStateList r10) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r11 = this.mBackgroundTint;
        r11.mTintList = r10;
        r11.mHasTintList = true;
        applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(PorterDuff.Mode r10) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r11 = this.mBackgroundTint;
        r11.mTintMode = r10;
        r11.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
