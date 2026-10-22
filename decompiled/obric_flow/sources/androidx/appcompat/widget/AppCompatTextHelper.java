package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;

    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight;
    private int mStyle;

    @NonNull
    private final TextView mView;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static Drawable[] getCompoundDrawablesRelative(TextView r5) {
            return r5.getCompoundDrawablesRelative();
        }

        @DoNotInline
        public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r5, Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
            r5.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void setTextLocale(TextView r5, Locale r10) {
            r5.setTextLocale(r10);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Locale forLanguageTag(String r5) {
            return Locale.forLanguageTag(r5);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList forLanguageTags(String r5) {
            return LocaleList.forLanguageTags(r5);
        }

        @DoNotInline
        public static void setTextLocales(TextView r5, LocaleList r10) {
            r5.setTextLocales(r10);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static int getAutoSizeStepGranularity(TextView r5) {
            return r5.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r5, int r10, int r11, int r12, int r13) {
            r5.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r5, int[] r10, int r11) {
            r5.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        }

        @DoNotInline
        public static boolean setFontVariationSettings(TextView r5, String r10) {
            return r5.setFontVariationSettings(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Typeface create(Typeface r5, int r10, boolean r11) {
            return Typeface.create(r5, r10, r11);
        }
    }

    public AppCompatTextHelper(@NonNull TextView r5) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r5;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r5);
    }

    private void applyCompoundDrawableTint(Drawable r5, TintInfo r10) {
        if (r5 == null) goto L6;
        if (r10 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r5, r10, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private static TintInfo createTintInfo(Context r5, AppCompatDrawableManager r10, int r11) {
        ColorStateList r12 = r10.getTintList(r5, r11);
        if (r12 == null) goto L6;
        TintInfo r13 = new TintInfo();
        r13.mHasTintList = true;
        r13.mTintList = r12;
        return r13;
    L6:
        return null;
    }

    private void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14, Drawable r15) {
        if (r14 != null) goto L39;
        if (r15 != null) goto L39;
        if (r10 != null) goto L10;
        if (r11 != null) goto L10;
        if (r12 != null) goto L10;
        if (r13 != null) goto L10;
        return;
    L10:
        Drawable[] r16 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        Drawable r17 = r16[0];
        if (r17 == null) goto L13;
    L29:
        TextView r5 = this.mView;
        if (r11 != null) goto L33;
        r11 = r16[1];
    L33:
        Drawable r18 = r16[2];
        if (r13 != null) goto L37;
        r13 = r16[3];
    L37:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r17, r11, r18, r13);
        return;
    L13:
        if (r16[2] != null) goto L29;
        Drawable[] r19 = this.mView.getCompoundDrawables();
        TextView r20 = this.mView;
        if (r10 != null) goto L19;
        r10 = r19[0];
    L19:
        if (r11 != null) goto L22;
        r11 = r19[1];
    L22:
        if (r12 != null) goto L25;
        r12 = r19[2];
    L25:
        if (r13 != null) goto L28;
        r13 = r19[3];
    L28:
        r20.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L39:
        Drawable[] r21 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView r22 = this.mView;
        if (r14 != null) goto L43;
        r14 = r21[0];
    L43:
        if (r11 != null) goto L46;
        r11 = r21[1];
    L46:
        if (r15 != null) goto L49;
        r15 = r21[2];
    L49:
        if (r13 != null) goto L52;
        r13 = r21[3];
    L52:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r22, r14, r11, r15, r13);
    }

    private void setCompoundTints() {
        TintInfo r5 = this.mDrawableTint;
        this.mDrawableLeftTint = r5;
        this.mDrawableTopTint = r5;
        this.mDrawableRightTint = r5;
        this.mDrawableBottomTint = r5;
        this.mDrawableStartTint = r5;
        this.mDrawableEndTint = r5;
    }

    private void setTextSizeInternal(int r5, float r10) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r5, r10);
    }

    private void updateTypefaceAndStyle(Context r10, TintTypedArray r11) {
        this.mStyle = r11.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int r5 = r11.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
        this.mFontWeight = r5;
        if (r5 == (-1)) goto L5;
        this.mStyle &= 2;
    L5:
        boolean r12 = true;
        if (r11.hasValue(R.styleable.TextAppearance_android_fontFamily) == false) goto L8;
    L22:
        this.mFontTypeface = null;
        if (r11.hasValue(R.styleable.TextAppearance_fontFamily) == false) goto L25;
        int r13 = R.styleable.TextAppearance_fontFamily;
    L26:
        final int r14 = this.mFontWeight;
        final int r15 = this.mStyle;
        if (r10.isRestricted() == true) goto L45;
        final WeakReference r16 = new WeakReference(this.mView);
        Typeface r17 = r11.getFont(r13, this.mStyle, new AnonymousClass1(this, r14, r15, r16));     // Catch: Throwable -> L57
        if (r17 == null) goto L40;
        if (this.mFontWeight == (-1)) goto L38;
        Typeface r18 = Typeface.create(r17, 0);     // Catch: Throwable -> L57
        int r19 = this.mFontWeight;     // Catch: Throwable -> L57
        if ((this.mStyle & 2) == 0) goto L36;
        boolean r20 = true;
    L37:
        this.mFontTypeface = Api28Impl.create(r18, r19, r20);     // Catch: Throwable -> L57
        goto L40
    L36:
        r20 = false;
        goto L37
    L38:
        this.mFontTypeface = r17;     // Catch: Throwable -> L57
    L40:
        if (this.mFontTypeface != null) goto L42;
        boolean r21 = true;
    L43:
        this.mAsyncFontPending = r21;     // Catch: Throwable -> L57
        goto L45
    L42:
        r21 = false;
    L45:
        if (this.mFontTypeface != null) goto L64;
        String r22 = r11.getString(r13);
        if (r22 != null) goto L49;
        return;
    L49:
        if (this.mFontWeight == (-1)) goto L55;
        Typeface r23 = Typeface.create(r22, 0);
        int r110 = this.mFontWeight;
        if ((this.mStyle & 2) != 0) goto L54;
        r12 = false;
    L54:
        this.mFontTypeface = Api28Impl.create(r23, r110, r12);
        return;
    L55:
        this.mFontTypeface = Typeface.create(r22, this.mStyle);
        return;
    L64:
        return;
    L25:
        r13 = R.styleable.TextAppearance_android_fontFamily;
        goto L26
    L8:
        if (r11.hasValue(R.styleable.TextAppearance_fontFamily) == true) goto L22;
        if (r11.hasValue(R.styleable.TextAppearance_android_typeface) == false) goto L60;
        this.mAsyncFontPending = false;
        int r24 = r11.getInt(R.styleable.TextAppearance_android_typeface, 1);
        if (r24 == 1) goto L20;
        if (r24 != 2) goto L16;
        this.mFontTypeface = Typeface.SERIF;
        return;
    L16:
        if (r24 != 3) goto L63;
        this.mFontTypeface = Typeface.MONOSPACE;
        return;
    L63:
        return;
    L20:
        this.mFontTypeface = Typeface.SANS_SERIF;
        return;
    }

    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r5 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r5[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r5[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r5[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r5[3], this.mDrawableBottomTint);
    L12:
        if (this.mDrawableStartTint == null) goto L14;
    L15:
        Drawable[] r10 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        applyCompoundDrawableTint(r10[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r10[2], this.mDrawableEndTint);
        return;
    L14:
        if (this.mDrawableEndTint != null) goto L15;
        return;
    L5:
        if (this.mDrawableTopTint != null) goto L10;
        if (this.mDrawableRightTint != null) goto L10;
        if (this.mDrawableBottomTint == null) goto L12;
        goto L10
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @Nullable
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo r5 = this.mDrawableTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintList;
    }

    @Nullable
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r5 = this.mDrawableTint;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mTintMode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    @SuppressLint({"NewApi"})
    public void loadFromAttributes(@Nullable AttributeSet r17, int r18) {
        Context r10 = this.mView.getContext();
        AppCompatDrawableManager r11 = AppCompatDrawableManager.get();
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.AppCompatTextHelper, r18, 0);
        TextView r5 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r5, r5.getContext(), R.styleable.AppCompatTextHelper, r17, r13.getWrappedTypeArray(), r18, 0);
        int r12 = r13.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft) == false) goto L6;
        this.mDrawableLeftTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    L6:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop) == false) goto L9;
        this.mDrawableTopTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    L9:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight) == false) goto L12;
        this.mDrawableRightTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    L12:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom) == false) goto L15;
        this.mDrawableBottomTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    L15:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart) == false) goto L18;
        this.mDrawableStartTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
    L18:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd) == false) goto L20;
        this.mDrawableEndTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    L20:
        r13.recycle();
        boolean r14 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean r15 = true;
        if (r12 == (-1)) goto L37;
        TintTypedArray r16 = TintTypedArray.obtainStyledAttributes(r10, r12, R.styleable.TextAppearance);
        if (r14 == false) goto L25;
    L27:
        boolean r19 = false;
        boolean r20 = false;
    L28:
        updateTypefaceAndStyle(r10, r16);
        if (r16.hasValue(R.styleable.TextAppearance_textLocale) == false) goto L31;
        String r21 = r16.getString(R.styleable.TextAppearance_textLocale);
    L33:
        if (r16.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L35;
        String r22 = r16.getString(R.styleable.TextAppearance_fontVariationSettings);
    L36:
        r16.recycle();
    L38:
        TintTypedArray r23 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.TextAppearance, r18, 0);
        if (r14 == false) goto L41;
    L43:
        r15 = r20;
    L45:
        if (r23.hasValue(R.styleable.TextAppearance_textLocale) == false) goto L48;
        r21 = r23.getString(R.styleable.TextAppearance_textLocale);
    L48:
        if (r23.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L51;
        r22 = r23.getString(R.styleable.TextAppearance_fontVariationSettings);
    L51:
        if (r23.hasValue(R.styleable.TextAppearance_android_textSize) == true) goto L53;
    L55:
        updateTypefaceAndStyle(r10, r23);
        r23.recycle();
        if (r14 == true) goto L59;
        if (r15 == false) goto L59;
        setAllCaps(r19);
    L59:
        Typeface r24 = this.mFontTypeface;
        if (r24 != null) goto L62;
    L65:
        if (r22 == null) goto L67;
        Api26Impl.setFontVariationSettings(this.mView, r22);
    L67:
        if (r21 == null) goto L69;
        Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(r21));
    L69:
        this.mAutoSizeTextHelper.loadFromAttributes(r17, r18);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L72;
    L79:
        TintTypedArray r25 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.AppCompatTextView);
        int r26 = r25.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (r26 == (-1)) goto L82;
        Drawable r27 = r11.getDrawable(r10, r26);
    L83:
        int r28 = r25.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (r28 == (-1)) goto L86;
        Drawable r29 = r11.getDrawable(r10, r28);
    L87:
        int r30 = r25.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (r30 == (-1)) goto L90;
        Drawable r31 = r11.getDrawable(r10, r30);
    L91:
        int r32 = r25.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (r32 == (-1)) goto L94;
        Drawable r33 = r11.getDrawable(r10, r32);
    L95:
        int r34 = r25.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (r34 == (-1)) goto L98;
        Drawable r35 = r11.getDrawable(r10, r34);
    L99:
        int r36 = r25.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (r36 == (-1)) goto L102;
        Drawable r37 = r11.getDrawable(r10, r36);
    L103:
        setCompoundDrawables(r27, r29, r31, r33, r35, r37);
        if (r25.hasValue(R.styleable.AppCompatTextView_drawableTint) == false) goto L107;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r25.getColorStateList(R.styleable.AppCompatTextView_drawableTint));
    L107:
        if (r25.hasValue(R.styleable.AppCompatTextView_drawableTintMode) == false) goto L109;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r25.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null));
    L109:
        int r38 = r25.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int r39 = r25.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int r40 = r25.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        r25.recycle();
        if (r38 == (-1)) goto L112;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r38);
    L112:
        if (r39 == (-1)) goto L114;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r39);
    L114:
        if (r40 == (-1)) goto L117;
        TextViewCompat.setLineHeight(this.mView, r40);
        return;
    L117:
        return;
    L102:
        r37 = null;
        goto L103
    L98:
        r35 = null;
        goto L99
    L94:
        r33 = null;
        goto L95
    L90:
        r31 = null;
        goto L91
    L86:
        r29 = null;
        goto L87
    L82:
        r27 = null;
        goto L83
    L72:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L79;
        int[] r41 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r41.length <= 0) goto L79;
        if (Api26Impl.getAutoSizeStepGranularity(this.mView) == (-1.0f)) goto L78;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L79
    L78:
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, r41, 0);
        goto L79
    L62:
        if (this.mFontWeight != (-1)) goto L64;
        this.mView.setTypeface(r24, this.mStyle);
        goto L65
    L64:
        this.mView.setTypeface(r24);
        goto L65
    L53:
        if (r23.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) != 0) goto L55;
        this.mView.setTextSize(0, 0.0f);
        goto L55
    L41:
        if (r23.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L43;
        r19 = r23.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        goto L45
    L35:
        r22 = null;
        goto L36
    L31:
        r21 = null;
        goto L33
    L25:
        if (r16.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L27;
        r19 = r16.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        r20 = true;
        goto L28
    L37:
        r19 = false;
        r20 = false;
        r21 = null;
        r22 = null;
        goto L38
    }

    public void onAsyncTypefaceReceived(WeakReference<TextView> r5, final Typeface r10) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r10;
        final TextView r11 = r5.get();
        if (r11 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r11) == false) goto L9;
        final int r12 = this.mStyle;
        r11.post(new AnonymousClass2(this, r11, r10, r12));
        return;
    L9:
        r11.setTypeface(r10, this.mStyle);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    public void onSetTextAppearance(Context r5, int r10) {
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, R.styleable.TextAppearance);
        if (r11.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L6;
        setAllCaps(r11.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    L6:
        if (r11.hasValue(R.styleable.TextAppearance_android_textSize) == true) goto L8;
    L10:
        updateTypefaceAndStyle(r5, r11);
        if (r11.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L15;
        String r12 = r11.getString(R.styleable.TextAppearance_fontVariationSettings);
        if (r12 == null) goto L15;
        Api26Impl.setFontVariationSettings(this.mView, r12);
    L15:
        r11.recycle();
        Typeface r13 = this.mFontTypeface;
        if (r13 == null) goto L19;
        this.mView.setTypeface(r13, this.mStyle);
        return;
    L19:
        return;
    L8:
        if (r11.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) != 0) goto L10;
        this.mView.setTextSize(0, 0.0f);
        goto L10
    }

    public void populateSurroundingTextIfNeeded(@NonNull TextView r5, @Nullable InputConnection r10, @NonNull EditorInfo r11) {
    }

    public void setAllCaps(boolean r5) {
        this.mView.setAllCaps(r5);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int r5, int r10, int r11, int r12) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r5, r10, r11, r12);
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r5, int r10) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r5, r10);
    }

    public void setAutoSizeTextTypeWithDefaults(int r5) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r5);
    }

    public void setCompoundDrawableTintList(@Nullable ColorStateList r5) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r10 = this.mDrawableTint;
        r10.mTintList = r5;
        if (r5 == null) goto L8;
        boolean r11 = true;
    L9:
        r10.mHasTintList = r11;
        setCompoundTints();
        return;
    L8:
        r11 = false;
        goto L9
    }

    public void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r10 = this.mDrawableTint;
        r10.mTintMode = r5;
        if (r5 == null) goto L8;
        boolean r11 = true;
    L9:
        r10.mHasTintMode = r11;
        setCompoundTints();
        return;
    L8:
        r11 = false;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int r5, float r10) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r5, r10);
        return;
    }
}
