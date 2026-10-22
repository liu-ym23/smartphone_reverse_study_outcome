package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
    public class SuperCaller {
        final /* synthetic */ AppCompatEditText this$0;

        public SuperCaller(AppCompatEditText r5) {
            this.this$0 = r5;
        }

        @Nullable
        public TextClassifier getTextClassifier() {
            return AppCompatEditText.access$001(this.this$0);
        }

        public void setTextClassifier(TextClassifier r5) {
            AppCompatEditText.access$101(this.this$0, r5);
        }
    }

    public AppCompatEditText(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ TextClassifier access$001(AppCompatEditText r5) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void access$101(AppCompatEditText r5, TextClassifier r10) {
        super.setTextClassifier(r10);
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

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return getSuperCaller().getTextClassifier();
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
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r5) {
        InputConnection r10 = super.onCreateInputConnection(r5);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r10, r5);
        InputConnection r11 = AppCompatHintHelper.onCreateInputConnection(r10, r5, this);
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(r11, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r5) {
        if (AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent(this, r5) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r5);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat r5) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, r5);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r5) {
        if (AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent(this, r5) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r5);
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r5) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r5));
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

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r5) {
        getSuperCaller().setTextClassifier(r5);
    }

    public AppCompatEditText(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        return super.getText();
    }

    public AppCompatEditText(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(TintContextWrapper.wrap(r5), r10, r11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r12 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r12;
        r12.loadFromAttributes(r10, r11);
        AppCompatTextHelper r13 = new AppCompatTextHelper(this);
        this.mTextHelper = r13;
        r13.loadFromAttributes(r10, r11);
        r13.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper r14 = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = r14;
        r14.loadFromAttributes(r10, r11);
        initEmojiKeyListener(r14);
    }
}
