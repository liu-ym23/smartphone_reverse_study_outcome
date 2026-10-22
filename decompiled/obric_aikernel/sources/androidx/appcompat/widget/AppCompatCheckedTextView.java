package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    @NonNull
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCheckedTextViewHelper mCheckedHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatCheckedTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatCheckedTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(TintContextWrapper.wrap(r10), r11, r12);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatTextHelper r13 = new AppCompatTextHelper(this);
        this.mTextHelper = r13;
        r13.loadFromAttributes(r11, r12);
        r13.applyCompoundDrawablesTints();
        AppCompatBackgroundHelper r14 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r14;
        r14.loadFromAttributes(r11, r12);
        AppCompatCheckedTextViewHelper r15 = new AppCompatCheckedTextViewHelper(this);
        this.mCheckedHelper = r15;
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

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 == null) goto L5;
        r10.applyCompoundDrawablesTints();
    L5:
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L8;
        r11.applySupportBackgroundTint();
    L8:
        AppCompatCheckedTextViewHelper r12 = this.mCheckedHelper;
        if (r12 == null) goto L12;
        r12.applyCheckMarkTint();
        return;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper r10 = this.mCheckedHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportCheckMarkTintList();
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper r10 = this.mCheckedHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportCheckMarkTintMode();
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

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r10) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r10), r10, this);
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int r10) {
        setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), r10));
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable r10) {
        super.setCheckMarkDrawable(r10);
        AppCompatCheckedTextViewHelper r11 = this.mCheckedHelper;
        if (r11 == null) goto L6;
        r11.onSetCheckMarkDrawable();
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        getEmojiTextViewHelper().setEnabled(r10);
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

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList r10) {
        AppCompatCheckedTextViewHelper r11 = this.mCheckedHelper;
        if (r11 == null) goto L6;
        r11.setSupportCheckMarkTintList(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode r10) {
        AppCompatCheckedTextViewHelper r11 = this.mCheckedHelper;
        if (r11 == null) goto L6;
        r11.setSupportCheckMarkTintMode(r10);
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

    @Override // android.widget.TextView
    public void setTextAppearance(@NonNull Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        AppCompatTextHelper r12 = this.mTextHelper;
        if (r12 == null) goto L6;
        r12.onSetTextAppearance(r10, r11);
        return;
    }
}
