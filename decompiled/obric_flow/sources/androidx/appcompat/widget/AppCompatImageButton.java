package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mHasLevel;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageButton(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 == null) goto L5;
        r5.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L9;
        r10.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r5 = this.mImageHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportImageTintList();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r5 = this.mImageHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportImageTintMode();
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
    public void setBackgroundDrawable(@Nullable Drawable r5) {
        super.setBackgroundDrawable(r5);
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.onSetBackgroundDrawable(r5);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r5) {
        super.setBackgroundResource(r5);
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.onSetBackgroundResource(r5);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r5) {
        super.setImageBitmap(r5);
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L6;
        r10.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r5) {
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L8;
        if (r5 == null) goto L8;
        if (this.mHasLevel == true) goto L8;
        r10.obtainLevelFromDrawable(r5);
    L8:
        super.setImageDrawable(r5);
        AppCompatImageHelper r11 = this.mImageHelper;
        if (r11 == null) goto L14;
        r11.applySupportImageTint();
        if (this.mHasLevel == true) goto L15;
        this.mImageHelper.applyImageLevel();
        return;
    L15:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r5) {
        super.setImageLevel(r5);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r5) {
        this.mImageHelper.setImageResource(r5);
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri r5) {
        super.setImageURI(r5);
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L6;
        r10.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r5) {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.setSupportBackgroundTintList(r5);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.setSupportBackgroundTintMode(r5);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList r5) {
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L6;
        r10.setSupportImageTintList(r5);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r5) {
        AppCompatImageHelper r10 = this.mImageHelper;
        if (r10 == null) goto L6;
        r10.setSupportImageTintMode(r5);
        return;
    }

    public AppCompatImageButton(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(TintContextWrapper.wrap(r5), r10, r11);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r12 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r12;
        r12.loadFromAttributes(r10, r11);
        AppCompatImageHelper r13 = new AppCompatImageHelper(this);
        this.mImageHelper = r13;
        r13.loadFromAttributes(r10, r11);
    }
}
