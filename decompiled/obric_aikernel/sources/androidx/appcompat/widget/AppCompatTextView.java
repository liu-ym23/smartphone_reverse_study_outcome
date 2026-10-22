package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;

    @NonNull
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;

    @Nullable
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;

    @Nullable
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    private interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] r10, int r11);

        void setAutoSizeTextTypeWithDefaults(int r10);

        void setFirstBaselineToTopHeight(@Px int r10);

        void setLastBaselineToBottomHeight(@Px int r10);

        void setTextClassifier(@Nullable TextClassifier r10);
    }

    @RequiresApi(api = 26)
    class SuperCallerApi26 implements SuperCaller {
        final /* synthetic */ AppCompatTextView this$0;

        SuperCallerApi26(AppCompatTextView r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.access$001(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.access$101(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.access$201(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.access$301(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeTextType() {
            return AppCompatTextView.access$401(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public TextClassifier getTextClassifier() {
            return AppCompatTextView.access$501(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) {
            AppCompatTextView.access$601(this.this$0, r10, r11, r12, r13);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r10, int r11) {
            AppCompatTextView.access$701(this.this$0, r10, r11);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeWithDefaults(int r10) {
            AppCompatTextView.access$801(this.this$0, r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(int r10) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(int r10) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setTextClassifier(@Nullable TextClassifier r10) {
            AppCompatTextView.access$901(this.this$0, r10);
        }
    }

    @RequiresApi(api = 28)
    class SuperCallerApi28 extends SuperCallerApi26 {
        final /* synthetic */ AppCompatTextView this$0;

        SuperCallerApi28(AppCompatTextView r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(@Px int r10) {
            AppCompatTextView.access$1001(this.this$0, r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(@Px int r10) {
            AppCompatTextView.access$1101(this.this$0, r10);
        }
    }

    public AppCompatTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.textViewStyle);
    }

    public AppCompatTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(TintContextWrapper.wrap(r10), r11, r12);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r13 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r13;
        r13.loadFromAttributes(r11, r12);
        AppCompatTextHelper r14 = new AppCompatTextHelper(this);
        this.mTextHelper = r14;
        r14.loadFromAttributes(r11, r12);
        r14.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().loadFromAttributes(r11, r12);
    }

    static /* synthetic */ int access$001(AppCompatTextView r10) {
        return super.getAutoSizeMaxTextSize();
    }

    static /* synthetic */ void access$1001(AppCompatTextView r10, int r11) {
        super.setFirstBaselineToTopHeight(r11);
    }

    static /* synthetic */ int access$101(AppCompatTextView r10) {
        return super.getAutoSizeMinTextSize();
    }

    static /* synthetic */ void access$1101(AppCompatTextView r10, int r11) {
        super.setLastBaselineToBottomHeight(r11);
    }

    static /* synthetic */ int access$201(AppCompatTextView r10) {
        return super.getAutoSizeStepGranularity();
    }

    static /* synthetic */ int[] access$301(AppCompatTextView r10) {
        return super.getAutoSizeTextAvailableSizes();
    }

    static /* synthetic */ int access$401(AppCompatTextView r10) {
        return super.getAutoSizeTextType();
    }

    static /* synthetic */ TextClassifier access$501(AppCompatTextView r10) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$601(AppCompatTextView r10, int r11, int r12, int r13, int r14) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
    }

    static /* synthetic */ void access$701(AppCompatTextView r10, int[] r11, int r12) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
    }

    static /* synthetic */ void access$801(AppCompatTextView r10, int r11) {
        super.setAutoSizeTextTypeWithDefaults(r11);
    }

    static /* synthetic */ void access$901(AppCompatTextView r10, TextClassifier r11) {
        super.setTextClassifier(r11);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> r10 = this.mPrecomputedTextFuture;
        if (r10 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        TextViewCompat.setPrecomputedText(this, r10.get());     // Catch: Throwable -> L7
        return;
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper != null) goto L6;
        this.mEmojiTextViewHelper = new AppCompatEmojiTextHelper(this);
    L6:
        return this.mEmojiTextViewHelper;
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

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.getAutoSizeMaxTextSize();
    L5:
        return getSuperCaller().getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.getAutoSizeMinTextSize();
    L5:
        return getSuperCaller().getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.getAutoSizeStepGranularity();
    L5:
        return getSuperCaller().getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 == null) goto L11;
        return r10.getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    L5:
        return getSuperCaller().getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 != null) goto L11;
        return 0;
    L11:
        return r10.getAutoSizeTextType();
    L5:
        if (getSuperCaller().getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L12;
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L9;
        SuperCaller r11 = new SuperCallerApi28(this);
    L7:
        this.mSuperCaller = r11;
        goto L12
    L9:
        if (r10 < 26) goto L12;
        r11 = new SuperCallerApi26(this);
    L12:
        return this.mSuperCaller;
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

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
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

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r11, r10);
        return AppCompatHintHelper.onCreateInputConnection(r11, r10, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        AppCompatTextHelper r15 = this.mTextHelper;
        if (r15 == null) goto L6;
        r15.onLayout(r10, r11, r12, r13, r14);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        super.onTextChanged(r10, r11, r12, r13);
        AppCompatTextHelper r14 = this.mTextHelper;
        if (r14 != null) goto L5;
    L9:
        boolean r15 = false;
    L10:
        if (r15 == false) goto L13;
        this.mTextHelper.autoSizeText();
        return;
    L13:
        return;
    L5:
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L9;
        if (r14.isAutoSizeEnabled() == false) goto L9;
        r15 = true;
        goto L10
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().setAllCaps(r10);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        return;
    L5:
        AppCompatTextHelper r14 = this.mTextHelper;
        if (r14 == null) goto L10;
        r14.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        return;
    L5:
        AppCompatTextHelper r12 = this.mTextHelper;
        if (r12 == null) goto L10;
        r12.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r10) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeWithDefaults(r10);
        return;
    L5:
        AppCompatTextHelper r11 = this.mTextHelper;
        if (r11 == null) goto L10;
        r11.setAutoSizeTextTypeWithDefaults(r10);
        return;
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
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        Context r14 = getContext();
        Drawable r15 = null;
        if (r10 == 0) goto L5;
        Drawable r16 = AppCompatResources.getDrawable(r14, r10);
    L6:
        if (r11 == 0) goto L8;
        Drawable r17 = AppCompatResources.getDrawable(r14, r11);
    L9:
        if (r12 == 0) goto L11;
        Drawable r18 = AppCompatResources.getDrawable(r14, r12);
    L12:
        if (r13 == 0) goto L14;
        r15 = AppCompatResources.getDrawable(r14, r13);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r16, r17, r18, r15);
        AppCompatTextHelper r19 = this.mTextHelper;
        if (r19 == null) goto L18;
        r19.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r18 = null;
        goto L12
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        AppCompatTextHelper r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        Context r14 = getContext();
        Drawable r15 = null;
        if (r10 == 0) goto L5;
        Drawable r16 = AppCompatResources.getDrawable(r14, r10);
    L6:
        if (r11 == 0) goto L8;
        Drawable r17 = AppCompatResources.getDrawable(r14, r11);
    L9:
        if (r12 == 0) goto L11;
        Drawable r18 = AppCompatResources.getDrawable(r14, r12);
    L12:
        if (r13 == 0) goto L14;
        r15 = AppCompatResources.getDrawable(r14, r13);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r16, r17, r18, r15);
        AppCompatTextHelper r19 = this.mTextHelper;
        if (r19 == null) goto L18;
        r19.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r18 = null;
        goto L12
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
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

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r10) {
        super.setFilters(getEmojiTextViewHelper().getFilters(r10));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().setFirstBaselineToTopHeight(r10);
        return;
    L5:
        TextViewCompat.setFirstBaselineToTopHeight(this, r10);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().setLastBaselineToBottomHeight(r10);
        return;
    L5:
        TextViewCompat.setLastBaselineToBottomHeight(this, r10);
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int r10) {
        TextViewCompat.setLineHeight(this, r10);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat r10) {
        TextViewCompat.setPrecomputedText(this, r10);
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

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> r10) {
        this.mPrecomputedTextFuture = r10;
        if (r10 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params r10) {
        TextViewCompat.setTextMetricsParams(this, r10);
    }

    @Override // android.widget.TextView
    public void setTextSize(int r10, float r11) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setTextSize(r10, r11);
        return;
    L5:
        AppCompatTextHelper r12 = this.mTextHelper;
        if (r12 == null) goto L10;
        r12.setTextSize(r10, r11);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r10, int r11) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        Typeface r12 = null;
        if (r10 == null) goto L9;
        if (r11 <= 0) goto L9;
        r12 = TypefaceCompat.create(getContext(), r10, r11);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r12 == null) goto L19;
        r10 = r12;
    L19:
        super.setTypeface(r10, r11);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    }
}
