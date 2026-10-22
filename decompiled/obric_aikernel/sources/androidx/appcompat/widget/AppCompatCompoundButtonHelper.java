package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private PorterDuff.Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;

    @NonNull
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(@NonNull CompoundButton r10) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r10;
    }

    void applyButtonTint() {
        Drawable r10 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasButtonTint == false) goto L7;
    L8:
        Drawable r11 = DrawableCompat.wrap(r10).mutate();
        if (this.mHasButtonTint == false) goto L12;
        DrawableCompat.setTintList(r11, this.mButtonTintList);
    L12:
        if (this.mHasButtonTintMode == false) goto L15;
        DrawableCompat.setTintMode(r11, this.mButtonTintMode);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(this.mView.getDrawableState());
    L17:
        this.mView.setButtonDrawable(r11);
        return;
    L7:
        if (this.mHasButtonTintMode == true) goto L8;
    }

    int getCompoundPaddingLeft(int r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L8;
        Drawable r11 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r11 != null) goto L7;
        return r10;
    L7:
        return r10 + r11.getIntrinsicWidth();
    L8:
        return r10;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r12 = this.mView.getContext();
        int[] r13 = R.styleable.CompoundButton;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r12, r10, r13, r11, 0);
        CompoundButton r15 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14.getWrappedTypeArray(), r11, 0);
        int r16 = R.styleable.CompoundButton_buttonCompat;     // Catch: Throwable -> L24
        if (r14.hasValue(r16) == false) goto L9;
        int r17 = r14.getResourceId(r16, 0);     // Catch: Throwable -> L24
        if (r17 == 0) goto L9;
        CompoundButton r18 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r18.setButtonDrawable(AppCompatResources.getDrawable(r18.getContext(), r17));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r19 = true;
    L10:
        if (r19 == true) goto L16;
        int r110 = R.styleable.CompoundButton_android_button;     // Catch: Throwable -> L24
        if (r14.hasValue(r110) == false) goto L16;
        int r111 = r14.getResourceId(r110, 0);     // Catch: Throwable -> L24
        if (r111 == 0) goto L16;
        CompoundButton r112 = this.mView;     // Catch: Throwable -> L24
        r112.setButtonDrawable(AppCompatResources.getDrawable(r112.getContext(), r111));     // Catch: Throwable -> L24
    L16:
        int r113 = R.styleable.CompoundButton_buttonTint;     // Catch: Throwable -> L24
        if (r14.hasValue(r113) == false) goto L19;
        CompoundButtonCompat.setButtonTintList(this.mView, r14.getColorStateList(r113));     // Catch: Throwable -> L24
    L19:
        int r114 = R.styleable.CompoundButton_buttonTintMode;     // Catch: Throwable -> L24
        if (r14.hasValue(r114) == false) goto L22;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(r114, -1), null));     // Catch: Throwable -> L24
    L22:
        r14.recycle();
        return;
    L9:
        r19 = false;
    L24:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList r10) {
        this.mButtonTintList = r10;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(@Nullable PorterDuff.Mode r10) {
        this.mButtonTintMode = r10;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
