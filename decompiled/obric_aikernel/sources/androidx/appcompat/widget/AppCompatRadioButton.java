package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatRadioButton(Context r10) {
        this(r10, null);
    }

    public AppCompatRadioButton(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context r10, @Nullable AttributeSet r11, int r12) {
        super(TintContextWrapper.wrap(r10), r11, r12);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatCompoundButtonHelper r13 = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = r13;
        r13.loadFromAttributes(r11, r12);
        AppCompatBackgroundHelper r14 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r14;
        r14.loadFromAttributes(r11, r12);
        AppCompatTextHelper r15 = new AppCompatTextHelper(this);
        this.mTextHelper = r15;
        r15.loadFromAttributes(r11, r12);
        getEmojiTextViewHelper().loadFromAttributes(r11, r12);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L5;
        r10.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r11 = this.mTextHelper;
        if (r11 == null) goto L9;
        r11.applyCompoundDrawablesTints();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r10 = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper r11 = this.mCompoundButtonHelper;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11.getCompoundPaddingLeft(r10);
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

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper r10 = this.mCompoundButtonHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportButtonTintList();
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper r10 = this.mCompoundButtonHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportButtonTintMode();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().setAllCaps(r10);
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int r10) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), r10));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r10) {
        super.setButtonDrawable(r10);
        AppCompatCompoundButtonHelper r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.onSetButtonDrawable();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        AppCompatTextHelper r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        AppCompatTextHelper r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.onSetCompoundDrawables();
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        getEmojiTextViewHelper().setEnabled(r10);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r10) {
        super.setFilters(getEmojiTextViewHelper().getFilters(r10));
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

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@Nullable ColorStateList r10) {
        AppCompatCompoundButtonHelper r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.setSupportButtonTintList(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode r10) {
        AppCompatCompoundButtonHelper r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.setSupportButtonTintMode(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r10) {
        this.mTextHelper.setCompoundDrawableTintList(r10);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTextHelper.setCompoundDrawableTintMode(r10);
        this.mTextHelper.applyCompoundDrawablesTints();
    }
}
