package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private static final int[] TINT_ATTRS = null;

    @NonNull
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    static {
        TINT_ATTRS = new int[]{R.attr.popupBackground};
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 == null) goto L5;
        r5.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 == null) goto L9;
        r10.applyCompoundDrawablesTints();
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

    public void initEmojiKeyListener(AppCompatEmojiEditTextHelper r10) {
        KeyListener r5 = getKeyListener();
        if (r10.isEmojiCapableKeyListener(r5) == false) goto L9;
        boolean r11 = super.isFocusable();
        boolean r12 = super.isClickable();
        boolean r13 = super.isLongClickable();
        int r14 = super.getInputType();
        KeyListener r15 = r10.getKeyListener(r5);
        if (r15 != r5) goto L7;
        return;
    L7:
        super.setKeyListener(r15);
        super.setRawInputType(r14);
        super.setFocusable(r11);
        super.setClickable(r12);
        super.setLongClickable(r13);
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r5) {
        InputConnection r10 = AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r5), r5, this);
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(r10, r5);
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

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        super.setCompoundDrawables(r5, r10, r11, r12);
        AppCompatTextHelper r13 = this.mTextHelper;
        if (r13 == null) goto L6;
        r13.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        super.setCompoundDrawablesRelative(r5, r10, r11, r12);
        AppCompatTextHelper r13 = this.mTextHelper;
        if (r13 == null) goto L6;
        r13.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int r5) {
        setDropDownBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r5) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(r5);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener r5) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(r5));
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

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r5) {
        this.mTextHelper.setCompoundDrawableTintList(r5);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r5) {
        this.mTextHelper.setCompoundDrawableTintMode(r5);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r5, int r10) {
        super.setTextAppearance(r5, r10);
        AppCompatTextHelper r11 = this.mTextHelper;
        if (r11 == null) goto L6;
        r11.onSetTextAppearance(r5, r10);
        return;
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(TintContextWrapper.wrap(r5), r10, r11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(getContext(), r10, TINT_ATTRS, r11, 0);
        if (r12.hasValue(0) == false) goto L5;
        setDropDownBackgroundDrawable(r12.getDrawable(0));
    L5:
        r12.recycle();
        AppCompatBackgroundHelper r13 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r13;
        r13.loadFromAttributes(r10, r11);
        AppCompatTextHelper r14 = new AppCompatTextHelper(this);
        this.mTextHelper = r14;
        r14.loadFromAttributes(r10, r11);
        r14.applyCompoundDrawablesTints();
        AppCompatEmojiEditTextHelper r15 = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = r15;
        r15.loadFromAttributes(r10, r11);
        initEmojiKeyListener(r15);
    }
}
