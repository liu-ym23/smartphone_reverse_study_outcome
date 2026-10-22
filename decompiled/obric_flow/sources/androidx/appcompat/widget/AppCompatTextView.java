package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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

    public interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int r5, int r10, int r11, int r12);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] r5, int r10);

        void setAutoSizeTextTypeWithDefaults(int r5);

        void setFirstBaselineToTopHeight(@Px int r5);

        void setLastBaselineToBottomHeight(@Px int r5);

        void setTextClassifier(@Nullable TextClassifier r5);
    }

    @RequiresApi(api = 26)
    public class SuperCallerApi26 implements SuperCaller {
        final /* synthetic */ AppCompatTextView this$0;

        public SuperCallerApi26(AppCompatTextView r5) {
            this.this$0 = r5;
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
        public void setAutoSizeTextTypeUniformWithConfiguration(int r5, int r10, int r11, int r12) {
            AppCompatTextView.access$601(this.this$0, r5, r10, r11, r12);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r5, int r10) {
            AppCompatTextView.access$701(this.this$0, r5, r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeWithDefaults(int r5) {
            AppCompatTextView.access$801(this.this$0, r5);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(int r5) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(int r5) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setTextClassifier(@Nullable TextClassifier r5) {
            AppCompatTextView.access$901(this.this$0, r5);
        }
    }

    @RequiresApi(api = 28)
    public class SuperCallerApi28 extends SuperCallerApi26 {
        final /* synthetic */ AppCompatTextView this$0;

        public SuperCallerApi28(AppCompatTextView r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(@Px int r5) {
            AppCompatTextView.access$1001(this.this$0, r5);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(@Px int r5) {
            AppCompatTextView.access$1101(this.this$0, r5);
        }
    }

    public AppCompatTextView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int access$001(AppCompatTextView r5) {
        return super.getAutoSizeMaxTextSize();
    }

    public static /* synthetic */ void access$1001(AppCompatTextView r5, int r10) {
        super.setFirstBaselineToTopHeight(r10);
    }

    public static /* synthetic */ int access$101(AppCompatTextView r5) {
        return super.getAutoSizeMinTextSize();
    }

    public static /* synthetic */ void access$1101(AppCompatTextView r5, int r10) {
        super.setLastBaselineToBottomHeight(r10);
    }

    public static /* synthetic */ int access$201(AppCompatTextView r5) {
        return super.getAutoSizeStepGranularity();
    }

    public static /* synthetic */ int[] access$301(AppCompatTextView r5) {
        return super.getAutoSizeTextAvailableSizes();
    }

    public static /* synthetic */ int access$401(AppCompatTextView r5) {
        return super.getAutoSizeTextType();
    }

    public static /* synthetic */ TextClassifier access$501(AppCompatTextView r5) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void access$601(AppCompatTextView r5, int r10, int r11, int r12, int r13) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$701(AppCompatTextView r5, int[] r10, int r11) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
    }

    public static /* synthetic */ void access$801(AppCompatTextView r5, int r10) {
        super.setAutoSizeTextTypeWithDefaults(r10);
    }

    public static /* synthetic */ void access$901(AppCompatTextView r5, TextClassifier r10) {
        super.setTextClassifier(r10);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> r5 = this.mPrecomputedTextFuture;
        if (r5 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        TextViewCompat.setPrecomputedText(this, r5.get());     // Catch: Throwable -> L7
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

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L9;
        return -1;
    L9:
        return r5.getAutoSizeMaxTextSize();
    L5:
        return getSuperCaller().getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L9;
        return -1;
    L9:
        return r5.getAutoSizeMinTextSize();
    L5:
        return getSuperCaller().getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L9;
        return -1;
    L9:
        return r5.getAutoSizeStepGranularity();
    L5:
        return getSuperCaller().getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 == null) goto L11;
        return r5.getAutoSizeTextAvailableSizes();
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
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L11;
        return 0;
    L11:
        return r5.getAutoSizeTextType();
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
    public SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new SuperCallerApi28(this);
    L6:
        return this.mSuperCaller;
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

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
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
    public InputConnection onCreateInputConnection(EditorInfo r5) {
        InputConnection r10 = super.onCreateInputConnection(r5);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r10, r5);
        return AppCompatHintHelper.onCreateInputConnection(r10, r5, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 == null) goto L6;
        r5.onLayout(r10, r11, r12, r13, r14);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r5, int r10) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r5, r10);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        super.onTextChanged(r5, r10, r11, r12);
        AppCompatTextHelper r13 = this.mTextHelper;
        if (r13 != null) goto L5;
        return;
    L5:
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L7;
        return;
    L7:
        if (r13.isAutoSizeEnabled() == false) goto L12;
        this.mTextHelper.autoSizeText();
        return;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r5) {
        super.setAllCaps(r5);
        getEmojiTextViewHelper().setAllCaps(r5);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r5, int r10, int r11, int r12) throws IllegalArgumentException {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(r5, r10, r11, r12);
        return;
    L5:
        AppCompatTextHelper r13 = this.mTextHelper;
        if (r13 == null) goto L10;
        r13.setAutoSizeTextTypeUniformWithConfiguration(r5, r10, r11, r12);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r5, int r10) throws IllegalArgumentException {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(r5, r10);
        return;
    L5:
        AppCompatTextHelper r11 = this.mTextHelper;
        if (r11 == null) goto L10;
        r11.setAutoSizeTextTypeUniformWithPresetSizes(r5, r10);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeWithDefaults(r5);
        return;
    L5:
        AppCompatTextHelper r10 = this.mTextHelper;
        if (r10 == null) goto L10;
        r10.setAutoSizeTextTypeWithDefaults(r5);
        return;
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
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r10, r11, r12);
        AppCompatTextHelper r13 = this.mTextHelper;
        if (r13 == null) goto L6;
        r13.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        super.setCompoundDrawablesWithIntrinsicBounds(r5, r10, r11, r12);
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
        getEmojiTextViewHelper().setEnabled(r5);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r5) {
        super.setFilters(getEmojiTextViewHelper().getFilters(r5));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int r5) {
        getSuperCaller().setFirstBaselineToTopHeight(r5);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int r5) {
        getSuperCaller().setLastBaselineToBottomHeight(r5);
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int r5) {
        TextViewCompat.setLineHeight(this, r5);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat r5) {
        TextViewCompat.setPrecomputedText(this, r5);
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

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> r5) {
        this.mPrecomputedTextFuture = r5;
        if (r5 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params r5) {
        TextViewCompat.setTextMetricsParams(this, r5);
    }

    @Override // android.widget.TextView
    public void setTextSize(int r5, float r10) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setTextSize(r5, r10);
        return;
    L5:
        AppCompatTextHelper r11 = this.mTextHelper;
        if (r11 == null) goto L10;
        r11.setTextSize(r5, r10);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r5, int r10) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        if (r5 == null) goto L8;
        if (r10 <= 0) goto L8;
        Typeface r11 = TypefaceCompat.create(getContext(), r5, r10);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r11 == null) goto L19;
        r5 = r11;
    L19:
        super.setTypeface(r5, r10);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    L8:
        r11 = null;
        goto L9
    }

    public AppCompatTextView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.textViewStyle);
    }

    public AppCompatTextView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(TintContextWrapper.wrap(r5), r10, r11);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r12 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r12;
        r12.loadFromAttributes(r10, r11);
        AppCompatTextHelper r13 = new AppCompatTextHelper(this);
        this.mTextHelper = r13;
        r13.loadFromAttributes(r10, r11);
        r13.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().loadFromAttributes(r10, r11);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r5, int r10, int r11, int r12) {
        Context r13 = getContext();
        Drawable r14 = null;
        if (r5 == 0) goto L5;
        Drawable r15 = AppCompatResources.getDrawable(r13, r5);
    L6:
        if (r10 == 0) goto L8;
        Drawable r16 = AppCompatResources.getDrawable(r13, r10);
    L9:
        if (r11 == 0) goto L11;
        Drawable r17 = AppCompatResources.getDrawable(r13, r11);
    L12:
        if (r12 == 0) goto L14;
        r14 = AppCompatResources.getDrawable(r13, r12);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r15, r16, r17, r14);
        AppCompatTextHelper r18 = this.mTextHelper;
        if (r18 == null) goto L18;
        r18.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r17 = null;
        goto L12
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r5, int r10, int r11, int r12) {
        Context r13 = getContext();
        Drawable r14 = null;
        if (r5 == 0) goto L5;
        Drawable r15 = AppCompatResources.getDrawable(r13, r5);
    L6:
        if (r10 == 0) goto L8;
        Drawable r16 = AppCompatResources.getDrawable(r13, r10);
    L9:
        if (r11 == 0) goto L11;
        Drawable r17 = AppCompatResources.getDrawable(r13, r11);
    L12:
        if (r12 == 0) goto L14;
        r14 = AppCompatResources.getDrawable(r13, r12);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r15, r16, r17, r14);
        AppCompatTextHelper r18 = this.mTextHelper;
        if (r18 == null) goto L18;
        r18.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r17 = null;
        goto L12
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }
}
