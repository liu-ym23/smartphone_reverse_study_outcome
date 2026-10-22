package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mHasLevel;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageView(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatImageView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AppCompatImageView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(TintContextWrapper.wrap(r10), r11, r12);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r13 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r13;
        r13.loadFromAttributes(r11, r12);
        AppCompatImageHelper r14 = new AppCompatImageHelper(this);
        this.mImageHelper = r14;
        r14.loadFromAttributes(r11, r12);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L5;
        r10.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L9;
        r11.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportImageTintList();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportImageTintMode();
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.hasOverlappingRendering() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.onSetBackgroundDrawable(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.onSetBackgroundResource(r10);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r10) {
        super.setImageBitmap(r10);
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r10) {
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L8;
        if (r10 == null) goto L8;
        if (this.mHasLevel == true) goto L8;
        r11.obtainLevelFromDrawable(r10);
    L8:
        super.setImageDrawable(r10);
        AppCompatImageHelper r12 = this.mImageHelper;
        if (r12 == null) goto L14;
        r12.applySupportImageTint();
        if (this.mHasLevel == true) goto L15;
        this.mImageHelper.applyImageLevel();
        return;
    L15:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r10) {
        super.setImageLevel(r10);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r10) {
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.setImageResource(r10);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri r10) {
        super.setImageURI(r10);
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.setSupportBackgroundTintList(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.setSupportBackgroundTintMode(r10);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList r10) {
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.setSupportImageTintList(r10);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r10) {
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.setSupportImageTintMode(r10);
        return;
    }
}
