package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    @NonNull
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;

    @Nullable
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    @RequiresApi(api = 26)
    class SuperCaller {
        final /* synthetic */ AppCompatEditText this$0;

        SuperCaller(AppCompatEditText r10) {
            this.this$0 = r10;
        }

        @Nullable
        public TextClassifier getTextClassifier() {
            return AppCompatEditText.access$001(this.this$0);
        }

        public void setTextClassifier(TextClassifier r10) {
            AppCompatEditText.access$101(this.this$0, r10);
        }
    }

    public AppCompatEditText(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatEditText(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.editTextStyle);
    }

    public AppCompatEditText(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(TintContextWrapper.wrap(r10), r11, r12);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r13 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r13;
        r13.loadFromAttributes(r11, r12);
        AppCompatTextHelper r14 = new AppCompatTextHelper(this);
        this.mTextHelper = r14;
        r14.loadFromAttributes(r11, r12);
        r14.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper r15 = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = r15;
        r15.loadFromAttributes(r11, r12);
        initEmojiKeyListener(r15);
    }

    static /* synthetic */ TextClassifier access$001(AppCompatEditText r10) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$101(AppCompatEditText r10, TextClassifier r11) {
        super.setTextClassifier(r11);
    }

    @NonNull
    @RequiresApi(26)
    @UiThread
    private SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new SuperCaller(this);
    L6:
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return super.getText();
    L7:
        return super.getEditableText();
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        AppCompatTextClassifierHelper r10 = this.mTextClassifierHelper;
        if (r10 == null) goto L10;
        return r10.getTextClassifier();
    L10:
        return getSuperCaller().getTextClassifier();
    }

    void initEmojiKeyListener(AppCompatEmojiEditTextHelper r10) {
        KeyListener r11 = getKeyListener();
        if (r10.isEmojiCapableKeyListener(r11) == false) goto L9;
        boolean r12 = super.isFocusable();
        boolean r13 = super.isClickable();
        boolean r14 = super.isLongClickable();
        int r15 = super.getInputType();
        KeyListener r16 = r10.getKeyListener(r11);
        if (r16 != r11) goto L7;
        return;
    L7:
        super.setKeyListener(r16);
        super.setRawInputType(r15);
        super.setFocusable(r12);
        super.setClickable(r13);
        super.setLongClickable(r14);
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r11, r10);
        InputConnection r12 = AppCompatHintHelper.onCreateInputConnection(r11, r10, this);
        if (r12 == null) goto L10;
        if (Build.VERSION.SDK_INT > 30) goto L10;
        String[] r13 = ViewCompat.getOnReceiveContentMimeTypes(this);
        if (r13 == null) goto L10;
        EditorInfoCompat.setContentMimeTypes(r10, r13);
        r12 = InputConnectionCompat.createWrapper(this, r12, r10);
    L10:
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(r12, r10);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r10) {
        if (AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent(this, r10) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r10);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat r10) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, r10);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r10) {
        if (AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent(this, r10) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r10);
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
        this.mAppCompatEmojiEditTextHelper.setEnabled(r10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener r10) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(r10));
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
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        AppCompatTextHelper r12 = this.mTextHelper;
        if (r12 == null) goto L6;
        r12.onSetTextAppearance(r10, r11);
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r10) {
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        AppCompatTextClassifierHelper r11 = this.mTextClassifierHelper;
        if (r11 == null) goto L9;
        r11.setTextClassifier(r10);
        return;
    L9:
        getSuperCaller().setTextClassifier(r10);
    }
}
