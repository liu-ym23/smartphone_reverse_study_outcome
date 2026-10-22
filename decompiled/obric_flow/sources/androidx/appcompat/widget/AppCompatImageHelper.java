package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel;
    private TintInfo mTmpInfo;

    @NonNull
    private final ImageView mView;

    public AppCompatImageHelper(@NonNull ImageView r5) {
        this.mLevel = 0;
        this.mView = r5;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r5) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r10 = this.mTmpInfo;
        r10.clear();
        ColorStateList r11 = ImageViewCompat.getImageTintList(this.mView);
        if (r11 == null) goto L8;
        r10.mHasTintList = true;
        r10.mTintList = r11;
    L8:
        PorterDuff.Mode r12 = ImageViewCompat.getImageTintMode(this.mView);
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
        if (this.mInternalImageTint == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void applyImageLevel() {
        if (this.mView.getDrawable() == null) goto L6;
        this.mView.getDrawable().setLevel(this.mLevel);
        return;
    }

    public void applySupportImageTint() {
        Drawable r5 = this.mView.getDrawable();
        if (r5 == null) goto L5;
        DrawableUtils.fixDrawable(r5);
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L9;
    L11:
        TintInfo r10 = this.mImageTint;
        if (r10 == null) goto L14;
        AppCompatDrawableManager.tintDrawable(r5, r10, this.mView.getDrawableState());
        return;
    L14:
        TintInfo r11 = this.mInternalImageTint;
        if (r11 == null) goto L20;
        AppCompatDrawableManager.tintDrawable(r5, r11, this.mView.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (applyFrameworkTintUsingColorFilter(r5) == false) goto L11;
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo r5 = this.mImageTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintList;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r5 = this.mImageTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintMode;
    }

    public boolean hasOverlappingRendering() {
        if ((this.mView.getBackground() instanceof RippleDrawable) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public void loadFromAttributes(AttributeSet r10, int r11) {
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r10, R.styleable.AppCompatImageView, r11, 0);
        ImageView r12 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r12, r12.getContext(), R.styleable.AppCompatImageView, r10, r5.getWrappedTypeArray(), r11, 0);
        Drawable r13 = this.mView.getDrawable();     // Catch: Throwable -> L10
        if (r13 != null) goto L12;
        int r14 = r5.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);     // Catch: Throwable -> L10
        if (r14 == (-1)) goto L12;
        r13 = AppCompatResources.getDrawable(this.mView.getContext(), r14);     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        this.mView.setImageDrawable(r13);     // Catch: Throwable -> L10
    L12:
        if (r13 == null) goto L15;
        DrawableUtils.fixDrawable(r13);     // Catch: Throwable -> L10
    L15:
        if (r5.hasValue(R.styleable.AppCompatImageView_tint) == false) goto L18;
        ImageViewCompat.setImageTintList(this.mView, r5.getColorStateList(R.styleable.AppCompatImageView_tint));     // Catch: Throwable -> L10
    L18:
        if (r5.hasValue(R.styleable.AppCompatImageView_tintMode) == false) goto L20;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r5.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));     // Catch: Throwable -> L10
    L20:
        r5.recycle();
        return;
    L10:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public void obtainLevelFromDrawable(@NonNull Drawable r5) {
        this.mLevel = r5.getLevel();
    }

    public void setImageResource(int r5) {
        if (r5 == 0) goto L7;
        Drawable r10 = AppCompatResources.getDrawable(this.mView.getContext(), r5);
        if (r10 == null) goto L6;
        DrawableUtils.fixDrawable(r10);
    L6:
        this.mView.setImageDrawable(r10);
    L8:
        applySupportImageTint();
        return;
    L7:
        this.mView.setImageDrawable(null);
        goto L8
    }

    public void setInternalImageTint(ColorStateList r5) {
        if (r5 != null) goto L4;
        this.mInternalImageTint = null;
    L8:
        applySupportImageTint();
        return;
    L4:
        if (this.mInternalImageTint != null) goto L6;
        this.mInternalImageTint = new TintInfo();
    L6:
        TintInfo r10 = this.mInternalImageTint;
        r10.mTintList = r5;
        r10.mHasTintList = true;
        goto L8
    }

    public void setSupportImageTintList(ColorStateList r5) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r10 = this.mImageTint;
        r10.mTintList = r5;
        r10.mHasTintList = true;
        applySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode r5) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r10 = this.mImageTint;
        r10.mTintMode = r5;
        r10.mHasTintMode = true;
        applySupportImageTint();
    }
}
