package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
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

    public AppCompatImageHelper(@NonNull ImageView r10) {
        this.mLevel = 0;
        this.mView = r10;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r10) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r11 = this.mTmpInfo;
        r11.clear();
        ColorStateList r12 = ImageViewCompat.getImageTintList(this.mView);
        if (r12 == null) goto L8;
        r11.mHasTintList = true;
        r11.mTintList = r12;
    L8:
        PorterDuff.Mode r13 = ImageViewCompat.getImageTintMode(this.mView);
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
        if (this.mInternalImageTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applyImageLevel() {
        if (this.mView.getDrawable() == null) goto L6;
        this.mView.getDrawable().setLevel(this.mLevel);
        return;
    }

    void applySupportImageTint() {
        Drawable r10 = this.mView.getDrawable();
        if (r10 == null) goto L5;
        DrawableUtils.fixDrawable(r10);
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L9;
    L11:
        TintInfo r11 = this.mImageTint;
        if (r11 == null) goto L14;
        AppCompatDrawableManager.tintDrawable(r10, r11, this.mView.getDrawableState());
        return;
    L14:
        TintInfo r12 = this.mInternalImageTint;
        if (r12 == null) goto L20;
        AppCompatDrawableManager.tintDrawable(r10, r12, this.mView.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (applyFrameworkTintUsingColorFilter(r10) == false) goto L11;
    }

    ColorStateList getSupportImageTintList() {
        TintInfo r10 = this.mImageTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintList;
    }

    PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r10 = this.mImageTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintMode;
    }

    boolean hasOverlappingRendering() {
        Drawable r10 = this.mView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        if ((r10 instanceof RippleDrawable) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void loadFromAttributes(AttributeSet r10, int r11) {
        Context r12 = this.mView.getContext();
        int[] r13 = R.styleable.AppCompatImageView;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r12, r10, r13, r11, 0);
        ImageView r15 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14.getWrappedTypeArray(), r11, 0);
        Drawable r16 = this.mView.getDrawable();     // Catch: Throwable -> L20
        if (r16 != null) goto L10;
        int r17 = r14.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);     // Catch: Throwable -> L20
        if (r17 == (-1)) goto L10;
        r16 = AppCompatResources.getDrawable(this.mView.getContext(), r17);     // Catch: Throwable -> L20
        if (r16 == null) goto L10;
        this.mView.setImageDrawable(r16);     // Catch: Throwable -> L20
    L10:
        if (r16 == null) goto L12;
        DrawableUtils.fixDrawable(r16);     // Catch: Throwable -> L20
    L12:
        int r18 = R.styleable.AppCompatImageView_tint;     // Catch: Throwable -> L20
        if (r14.hasValue(r18) == false) goto L15;
        ImageViewCompat.setImageTintList(this.mView, r14.getColorStateList(r18));     // Catch: Throwable -> L20
    L15:
        int r19 = R.styleable.AppCompatImageView_tintMode;     // Catch: Throwable -> L20
        if (r14.hasValue(r19) == false) goto L18;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(r19, -1), null));     // Catch: Throwable -> L20
    L18:
        r14.recycle();
        return;
    L20:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    void obtainLevelFromDrawable(@NonNull Drawable r10) {
        this.mLevel = r10.getLevel();
    }

    public void setImageResource(int r10) {
        if (r10 == 0) goto L7;
        Drawable r11 = AppCompatResources.getDrawable(this.mView.getContext(), r10);
        if (r11 == null) goto L6;
        DrawableUtils.fixDrawable(r11);
    L6:
        this.mView.setImageDrawable(r11);
    L8:
        applySupportImageTint();
        return;
    L7:
        this.mView.setImageDrawable(null);
        goto L8
    }

    void setInternalImageTint(ColorStateList r10) {
        if (r10 != null) goto L4;
        this.mInternalImageTint = null;
    L8:
        applySupportImageTint();
        return;
    L4:
        if (this.mInternalImageTint != null) goto L6;
        this.mInternalImageTint = new TintInfo();
    L6:
        TintInfo r11 = this.mInternalImageTint;
        r11.mTintList = r10;
        r11.mHasTintList = true;
        goto L8
    }

    void setSupportImageTintList(ColorStateList r10) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r11 = this.mImageTint;
        r11.mTintList = r10;
        r11.mHasTintList = true;
        applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff.Mode r10) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r11 = this.mImageTint;
        r11.mTintMode = r10;
        r11.mHasTintMode = true;
        applySupportImageTint();
    }
}
