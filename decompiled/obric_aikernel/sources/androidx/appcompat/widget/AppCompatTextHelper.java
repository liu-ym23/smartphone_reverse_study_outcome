package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.core.view.inputmethod.EditorInfoCompat;
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
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Drawable[] getCompoundDrawablesRelative(TextView r10) {
            return r10.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setTextLocale(TextView r10, Locale r11) {
            r10.setTextLocale(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String r10) {
            return Locale.forLanguageTag(r10);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList forLanguageTags(String r10) {
            return LocaleList.forLanguageTags(r10);
        }

        @DoNotInline
        static void setTextLocales(TextView r10, LocaleList r11) {
            r10.setTextLocales(r11);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView r10) {
            return r10.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r10, int r11, int r12, int r13, int r14) {
            r10.setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r10, int[] r11, int r12) {
            r10.setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
        }

        @DoNotInline
        static boolean setFontVariationSettings(TextView r10, String r11) {
            return r10.setFontVariationSettings(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Typeface create(Typeface r10, int r11, boolean r12) {
            return Typeface.create(r10, r11, r12);
        }
    }

    AppCompatTextHelper(@NonNull TextView r10) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r10;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r10);
    }

    private void applyCompoundDrawableTint(Drawable r10, TintInfo r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r10, r11, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private static TintInfo createTintInfo(Context r10, AppCompatDrawableManager r11, int r12) {
        ColorStateList r13 = r11.getTintList(r10, r12);
        if (r13 == null) goto L6;
        TintInfo r14 = new TintInfo();
        r14.mHasTintList = true;
        r14.mTintList = r13;
        return r14;
    L6:
        return null;
    }

    private void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14, Drawable r15) {
        int r16 = Build.VERSION.SDK_INT;
        if (r16 < 17) goto L20;
        if (r14 != null) goto L6;
        if (r15 == null) goto L20;
    L6:
        Drawable[] r17 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView r18 = this.mView;
        if (r14 != null) goto L10;
        r14 = r17[0];
    L10:
        if (r11 != null) goto L13;
        r11 = r17[1];
    L13:
        if (r15 != null) goto L16;
        r15 = r17[2];
    L16:
        if (r13 != null) goto L19;
        r13 = r17[3];
    L19:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r18, r14, r11, r15, r13);
        return;
    L20:
        if (r10 != null) goto L24;
        if (r11 != null) goto L24;
        if (r12 != null) goto L24;
        if (r13 != null) goto L24;
        return;
    L24:
        if (r16 < 17) goto L39;
        Drawable[] r19 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        if (r19[0] == null) goto L28;
    L29:
        TextView r20 = this.mView;
        Drawable r21 = r19[0];
        if (r11 != null) goto L33;
        r11 = r19[1];
    L33:
        Drawable r22 = r19[2];
        if (r13 != null) goto L37;
        r13 = r19[3];
    L37:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r20, r21, r11, r22, r13);
        return;
    L28:
        if (r19[2] != null) goto L29;
    L39:
        Drawable[] r110 = this.mView.getCompoundDrawables();
        TextView r23 = this.mView;
        if (r10 != null) goto L43;
        r10 = r110[0];
    L43:
        if (r11 != null) goto L46;
        r11 = r110[1];
    L46:
        if (r12 != null) goto L49;
        r12 = r110[2];
    L49:
        if (r13 != null) goto L52;
        r13 = r110[3];
    L52:
        r23.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
    }

    private void setCompoundTints() {
        TintInfo r10 = this.mDrawableTint;
        this.mDrawableLeftTint = r10;
        this.mDrawableTopTint = r10;
        this.mDrawableRightTint = r10;
        this.mDrawableBottomTint = r10;
        this.mDrawableStartTint = r10;
        this.mDrawableEndTint = r10;
    }

    private void setTextSizeInternal(int r10, float r11) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r10, r11);
    }

    private void updateTypefaceAndStyle(Context r11, TintTypedArray r12) {
        this.mStyle = r12.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int r10 = Build.VERSION.SDK_INT;
        boolean r13 = false;
        if (r10 < 28) goto L7;
        int r14 = r12.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
        this.mFontWeight = r14;
        if (r14 == (-1)) goto L7;
        this.mStyle = (this.mStyle & 2) | 0;
    L7:
        int r15 = R.styleable.TextAppearance_android_fontFamily;
        if (r12.hasValue(r15) == false) goto L10;
    L25:
        this.mFontTypeface = null;
        int r16 = R.styleable.TextAppearance_fontFamily;
        if (r12.hasValue(r16) == false) goto L28;
        r15 = r16;
    L28:
        final int r17 = this.mFontWeight;
        final int r18 = this.mStyle;
        if (r11.isRestricted() == true) goto L48;
        final WeakReference r19 = new WeakReference(this.mView);
        Typeface r110 = r12.getFont(r15, this.mStyle, new AnonymousClass1(this, r17, r18, r19));     // Catch: Throwable -> L62
        if (r110 == null) goto L43;
        if (r10 >= 28) goto L35;
    L41:
        this.mFontTypeface = r110;     // Catch: Throwable -> L62
        goto L43
    L35:
        if (this.mFontWeight == (-1)) goto L41;
        Typeface r111 = Typeface.create(r110, 0);     // Catch: Throwable -> L62
        int r20 = this.mFontWeight;     // Catch: Throwable -> L62
        if ((this.mStyle & 2) == 0) goto L39;
        boolean r21 = true;
    L40:
        r110 = Api28Impl.create(r111, r20, r21);     // Catch: Throwable -> L62
        goto L41
    L39:
        r21 = false;
    L43:
        if (this.mFontTypeface != null) goto L45;
        boolean r112 = true;
    L46:
        this.mAsyncFontPending = r112;     // Catch: Throwable -> L62
        goto L48
    L45:
        r112 = false;
    L48:
        if (this.mFontTypeface != null) goto L67;
        String r113 = r12.getString(r15);
        if (r113 != null) goto L52;
        return;
    L52:
        if (Build.VERSION.SDK_INT >= 28) goto L54;
    L59:
        Typeface r114 = Typeface.create(r113, this.mStyle);
    L60:
        this.mFontTypeface = r114;
        return;
    L54:
        if (this.mFontWeight == (-1)) goto L59;
        Typeface r115 = Typeface.create(r113, 0);
        int r116 = this.mFontWeight;
        if ((this.mStyle & 2) == 0) goto L58;
        r13 = true;
    L58:
        r114 = Api28Impl.create(r115, r116, r13);
        goto L60
    L67:
        return;
    L10:
        if (r12.hasValue(R.styleable.TextAppearance_fontFamily) == true) goto L25;
        int r117 = R.styleable.TextAppearance_android_typeface;
        if (r12.hasValue(r117) == false) goto L65;
        this.mAsyncFontPending = false;
        int r118 = r12.getInt(r117, 1);
        if (r118 == 1) goto L22;
        if (r118 != 2) goto L18;
        Typeface r119 = Typeface.SERIF;
    L23:
        this.mFontTypeface = r119;
        return;
    L18:
        if (r118 != 3) goto L66;
        r119 = Typeface.MONOSPACE;
        goto L23
    L66:
        return;
    L22:
        r119 = Typeface.SANS_SERIF;
        goto L23
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r10 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r10[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r10[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r10[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r10[3], this.mDrawableBottomTint);
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L14;
        return;
    L14:
        if (this.mDrawableStartTint == null) goto L16;
    L17:
        Drawable[] r11 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        applyCompoundDrawableTint(r11[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r11[2], this.mDrawableEndTint);
        return;
    L16:
        if (this.mDrawableEndTint != null) goto L17;
        return;
    L5:
        if (this.mDrawableTopTint != null) goto L10;
        if (this.mDrawableRightTint != null) goto L10;
        if (this.mDrawableBottomTint == null) goto L12;
        goto L10
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @Nullable
    ColorStateList getCompoundDrawableTintList() {
        TintInfo r10 = this.mDrawableTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintList;
    }

    @Nullable
    PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r10 = this.mDrawableTint;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mTintMode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    @SuppressLint({"NewApi"})
    void loadFromAttributes(@Nullable AttributeSet r24, int r25) {
        Context r10 = this.mView.getContext();
        AppCompatDrawableManager r11 = AppCompatDrawableManager.get();
        int[] r12 = R.styleable.AppCompatTextHelper;
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r24, r12, r25, 0);
        TextView r14 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r14, r14.getContext(), r12, r24, r13.getWrappedTypeArray(), r25, 0);
        int r15 = r13.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int r16 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (r13.hasValue(r16) == false) goto L5;
        this.mDrawableLeftTint = createTintInfo(r10, r11, r13.getResourceId(r16, 0));
    L5:
        int r17 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (r13.hasValue(r17) == false) goto L8;
        this.mDrawableTopTint = createTintInfo(r10, r11, r13.getResourceId(r17, 0));
    L8:
        int r18 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (r13.hasValue(r18) == false) goto L11;
        this.mDrawableRightTint = createTintInfo(r10, r11, r13.getResourceId(r18, 0));
    L11:
        int r19 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (r13.hasValue(r19) == false) goto L14;
        this.mDrawableBottomTint = createTintInfo(r10, r11, r13.getResourceId(r19, 0));
    L14:
        int r20 = Build.VERSION.SDK_INT;
        if (r20 < 17) goto L22;
        int r21 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (r13.hasValue(r21) == false) goto L19;
        this.mDrawableStartTint = createTintInfo(r10, r11, r13.getResourceId(r21, 0));
    L19:
        int r22 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (r13.hasValue(r22) == false) goto L22;
        this.mDrawableEndTint = createTintInfo(r10, r11, r13.getResourceId(r22, 0));
    L22:
        r13.recycle();
        boolean r23 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (r15 == (-1)) goto L55;
        TintTypedArray r26 = TintTypedArray.obtainStyledAttributes(r10, r15, R.styleable.TextAppearance);
        if (r23 == true) goto L29;
        int r27 = R.styleable.TextAppearance_textAllCaps;
        if (r26.hasValue(r27) == false) goto L29;
        boolean r28 = r26.getBoolean(r27, false);
        boolean r110 = true;
    L30:
        updateTypefaceAndStyle(r10, r26);
        if (r20 >= 23) goto L43;
        int r29 = R.styleable.TextAppearance_android_textColor;
        if (r26.hasValue(r29) == false) goto L35;
        ColorStateList r30 = r26.getColorStateList(r29);
    L36:
        int r111 = R.styleable.TextAppearance_android_textColorHint;
        if (r26.hasValue(r111) == false) goto L39;
        ColorStateList r112 = r26.getColorStateList(r111);
    L40:
        int r113 = R.styleable.TextAppearance_android_textColorLink;
        if (r26.hasValue(r113) == false) goto L44;
        ColorStateList r114 = r26.getColorStateList(r113);
    L45:
        int r31 = R.styleable.TextAppearance_textLocale;
        if (r26.hasValue(r31) == false) goto L48;
        String r32 = r26.getString(r31);
    L49:
        if (r20 < 26) goto L53;
        int r33 = R.styleable.TextAppearance_fontVariationSettings;
        if (r26.hasValue(r33) == false) goto L53;
        String r34 = r26.getString(r33);
    L54:
        r26.recycle();
    L56:
        TintTypedArray r35 = TintTypedArray.obtainStyledAttributes(r10, r24, R.styleable.TextAppearance, r25, 0);
        if (r23 == true) goto L61;
        int r115 = R.styleable.TextAppearance_textAllCaps;
        if (r35.hasValue(r115) == false) goto L61;
        r28 = r35.getBoolean(r115, false);
        int r36 = 23;
        r110 = true;
    L62:
        if (r20 >= r36) goto L72;
        int r37 = R.styleable.TextAppearance_android_textColor;
        if (r35.hasValue(r37) == false) goto L66;
        r30 = r35.getColorStateList(r37);
    L66:
        int r38 = R.styleable.TextAppearance_android_textColorHint;
        if (r35.hasValue(r38) == false) goto L69;
        r112 = r35.getColorStateList(r38);
    L69:
        int r39 = R.styleable.TextAppearance_android_textColorLink;
        if (r35.hasValue(r39) == false) goto L72;
        r114 = r35.getColorStateList(r39);
    L72:
        int r40 = R.styleable.TextAppearance_textLocale;
        if (r35.hasValue(r40) == false) goto L76;
        r32 = r35.getString(r40);
    L76:
        if (r20 < 26) goto L80;
        int r41 = R.styleable.TextAppearance_fontVariationSettings;
        if (r35.hasValue(r41) == false) goto L80;
        String r42 = r35.getString(r41);
    L82:
        if (r20 < 28) goto L88;
        int r116 = R.styleable.TextAppearance_android_textSize;
        if (r35.hasValue(r116) == false) goto L88;
        AppCompatDrawableManager r117 = r11;
        if (r35.getDimensionPixelSize(r116, -1) != 0) goto L89;
        this.mView.setTextSize(0, 0.0f);
    L89:
        updateTypefaceAndStyle(r10, r35);
        r35.recycle();
        if (r30 == null) goto L92;
        this.mView.setTextColor(r30);
    L92:
        if (r112 == null) goto L94;
        this.mView.setHintTextColor(r112);
    L94:
        if (r114 == null) goto L96;
        this.mView.setLinkTextColor(r114);
    L96:
        if (r23 == true) goto L99;
        if (r110 == false) goto L99;
        setAllCaps(r28);
    L99:
        Typeface r43 = this.mFontTypeface;
        if (r43 != null) goto L102;
    L105:
        if (r42 == null) goto L107;
        Api26Impl.setFontVariationSettings(this.mView, r42);
    L107:
        if (r32 != null) goto L109;
    L114:
        this.mAutoSizeTextHelper.loadFromAttributes(r24, r25);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L117;
    L124:
        TintTypedArray r44 = TintTypedArray.obtainStyledAttributes(r10, r24, R.styleable.AppCompatTextView);
        int r45 = r44.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        AppCompatDrawableManager r46 = r117;
        if (r45 == (-1)) goto L127;
        Drawable r47 = r46.getDrawable(r10, r45);
    L128:
        int r48 = r44.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (r48 == (-1)) goto L131;
        Drawable r49 = r46.getDrawable(r10, r48);
    L132:
        int r50 = r44.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (r50 == (-1)) goto L135;
        Drawable r51 = r46.getDrawable(r10, r50);
    L136:
        int r52 = r44.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (r52 == (-1)) goto L139;
        Drawable r53 = r46.getDrawable(r10, r52);
    L140:
        int r54 = r44.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (r54 == (-1)) goto L143;
        Drawable r55 = r46.getDrawable(r10, r54);
    L144:
        int r56 = r44.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (r56 == (-1)) goto L147;
        Drawable r118 = r46.getDrawable(r10, r56);
    L148:
        setCompoundDrawables(r47, r49, r51, r53, r55, r118);
        int r57 = R.styleable.AppCompatTextView_drawableTint;
        if (r44.hasValue(r57) == false) goto L151;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r44.getColorStateList(r57));
    L151:
        int r58 = R.styleable.AppCompatTextView_drawableTintMode;
        if (r44.hasValue(r58) == false) goto L154;
        int r59 = -1;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r44.getInt(r58, -1), null));
    L155:
        int r60 = r44.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, r59);
        int r61 = r44.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, r59);
        int r62 = r44.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, r59);
        r44.recycle();
        if (r60 == r59) goto L158;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r60);
    L158:
        if (r61 == r59) goto L160;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r61);
    L160:
        if (r62 == r59) goto L163;
        TextViewCompat.setLineHeight(this.mView, r62);
        return;
    L163:
        return;
    L154:
        r59 = -1;
        goto L155
    L147:
        r118 = null;
        goto L148
    L143:
        r55 = null;
        goto L144
    L139:
        r53 = null;
        goto L140
    L135:
        r51 = null;
        goto L136
    L131:
        r49 = null;
        goto L132
    L127:
        r47 = null;
        goto L128
    L117:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L124;
        int[] r63 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r63.length <= 0) goto L124;
        if (Api26Impl.getAutoSizeStepGranularity(this.mView) == (-1.0f)) goto L123;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L124
    L123:
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, r63, 0);
        goto L124
    L109:
        if (r20 < 24) goto L112;
        Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(r32));
        goto L114
    L112:
        if (r20 < 21) goto L114;
        Api17Impl.setTextLocale(this.mView, Api21Impl.forLanguageTag(r32.split(",")[0]));
        goto L114
    L102:
        if (this.mFontWeight != (-1)) goto L104;
        this.mView.setTypeface(r43, this.mStyle);
        goto L105
    L104:
        this.mView.setTypeface(r43);
    L88:
        r117 = r11;
    L80:
        r42 = r34;
    L61:
        r36 = 23;
    L53:
        r34 = null;
        goto L54
    L48:
        r32 = null;
    L44:
        r114 = null;
        goto L45
    L39:
        r112 = null;
        goto L40
    L35:
        r30 = null;
        goto L36
    L43:
        r30 = null;
        r112 = null;
    L29:
        r28 = false;
        r110 = false;
        goto L30
    L55:
        r28 = false;
        r110 = false;
        r34 = null;
        r30 = null;
        r32 = null;
        r112 = null;
        r114 = null;
        goto L56
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> r10, final Typeface r11) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r11;
        final TextView r12 = r10.get();
        if (r12 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r12) == false) goto L9;
        final int r13 = this.mStyle;
        r12.post(new AnonymousClass2(this, r12, r11, r13));
        return;
    L9:
        r12.setTypeface(r11, this.mStyle);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context r10, int r11) {
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r10, r11, R.styleable.TextAppearance);
        int r13 = R.styleable.TextAppearance_textAllCaps;
        if (r12.hasValue(r13) == false) goto L5;
        setAllCaps(r12.getBoolean(r13, false));
    L5:
        int r14 = Build.VERSION.SDK_INT;
        if (r14 >= 23) goto L22;
        int r15 = R.styleable.TextAppearance_android_textColor;
        if (r12.hasValue(r15) == false) goto L12;
        ColorStateList r16 = r12.getColorStateList(r15);
        if (r16 == null) goto L12;
        this.mView.setTextColor(r16);
    L12:
        int r17 = R.styleable.TextAppearance_android_textColorLink;
        if (r12.hasValue(r17) == false) goto L17;
        ColorStateList r18 = r12.getColorStateList(r17);
        if (r18 == null) goto L17;
        this.mView.setLinkTextColor(r18);
    L17:
        int r19 = R.styleable.TextAppearance_android_textColorHint;
        if (r12.hasValue(r19) == false) goto L22;
        ColorStateList r20 = r12.getColorStateList(r19);
        if (r20 == null) goto L22;
        this.mView.setHintTextColor(r20);
    L22:
        int r21 = R.styleable.TextAppearance_android_textSize;
        if (r12.hasValue(r21) == true) goto L25;
    L27:
        updateTypefaceAndStyle(r10, r12);
        if (r14 < 26) goto L34;
        int r22 = R.styleable.TextAppearance_fontVariationSettings;
        if (r12.hasValue(r22) == false) goto L34;
        String r23 = r12.getString(r22);
        if (r23 == null) goto L34;
        Api26Impl.setFontVariationSettings(this.mView, r23);
    L34:
        r12.recycle();
        Typeface r24 = this.mFontTypeface;
        if (r24 == null) goto L38;
        this.mView.setTypeface(r24, this.mStyle);
        return;
    L38:
        return;
    L25:
        if (r12.getDimensionPixelSize(r21, -1) != 0) goto L27;
        this.mView.setTextSize(0, 0.0f);
        goto L27
    }

    void populateSurroundingTextIfNeeded(@NonNull TextView r10, @Nullable InputConnection r11, @NonNull EditorInfo r12) {
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        if (r11 == null) goto L8;
        EditorInfoCompat.setInitialSurroundingText(r12, r10.getText());
        return;
    L8:
        return;
    }

    void setAllCaps(boolean r10) {
        this.mView.setAllCaps(r10);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
    }

    void setAutoSizeTextTypeWithDefaults(int r10) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r10);
    }

    void setCompoundDrawableTintList(@Nullable ColorStateList r10) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r11 = this.mDrawableTint;
        r11.mTintList = r10;
        if (r10 == null) goto L8;
        boolean r12 = true;
    L9:
        r11.mHasTintList = r12;
        setCompoundTints();
        return;
    L8:
        r12 = false;
        goto L9
    }

    void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r11 = this.mDrawableTint;
        r11.mTintMode = r10;
        if (r10 == null) goto L8;
        boolean r12 = true;
    L9:
        r11.mHasTintMode = r12;
        setCompoundTints();
        return;
    L8:
        r12 = false;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setTextSize(int r10, float r11) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r10, r11);
        return;
    }
}
