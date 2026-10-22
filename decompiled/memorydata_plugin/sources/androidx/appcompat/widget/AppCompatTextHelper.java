package androidx.appcompat.widget;

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
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
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
    private final TextView mView;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static void setTextLocale(TextView r0, Locale r1) {
            r0.setTextLocale(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Locale forLanguageTag(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList forLanguageTags(String r0) {
            return LocaleList.forLanguageTags(r0);
        }

        static void setTextLocales(TextView r0, LocaleList r1) {
            r0.setTextLocales(r1);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }

        static boolean setFontVariationSettings(TextView r0, String r1) {
            return r0.setFontVariationSettings(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface create(Typeface r0, int r1, boolean r2) {
            return Typeface.create(r0, r1, r2);
        }
    }

    AppCompatTextHelper(TextView r2) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r2;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r2);
    }

    private void applyCompoundDrawableTint(Drawable r1, TintInfo r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r1, r2, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private static TintInfo createTintInfo(Context r2, AppCompatDrawableManager r3, int r4) {
        ColorStateList r5 = r3.getTintList((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4);
        if (r5 == null) goto L6;
        TintInfo r6 = new TintInfo();
        r6.mHasTintList = true;
        r6.mTintList = r5;
        return r6;
    L6:
        return null;
    }

    private void setCompoundDrawables(Drawable r7, Drawable r8, Drawable r9, Drawable r10, Drawable r11, Drawable r12) {
        if (Build.VERSION.SDK_INT < 17) goto L20;
        if (r11 != null) goto L6;
        if (r12 == null) goto L20;
    L6:
        Drawable[] r13 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView r6 = this.mView;
        if (r11 != null) goto L10;
        r11 = r13[0];
    L10:
        if (r8 != null) goto L13;
        r8 = r13[1];
    L13:
        if (r12 != null) goto L16;
        r12 = r13[2];
    L16:
        if (r10 != null) goto L19;
        r10 = r13[3];
    L19:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r6, r11, r8, r12, r10);
        return;
    L20:
        if (r7 != null) goto L25;
        if (r8 != null) goto L25;
        if (r9 != null) goto L25;
        if (r10 != null) goto L25;
        return;
    L25:
        if (Build.VERSION.SDK_INT < 17) goto L40;
        Drawable[] r14 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        if (r14[0] == null) goto L29;
    L30:
        TextView r15 = this.mView;
        Drawable r16 = r14[0];
        if (r8 != null) goto L34;
        r8 = r14[1];
    L34:
        Drawable r17 = r14[2];
        if (r10 != null) goto L38;
        r10 = r14[3];
    L38:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r15, r16, r8, r17, r10);
        return;
    L29:
        if (r14[2] != null) goto L30;
    L40:
        Drawable[] r18 = this.mView.getCompoundDrawables();
        TextView r19 = this.mView;
        if (r7 != null) goto L44;
        r7 = r18[0];
    L44:
        if (r8 != null) goto L47;
        r8 = r18[1];
    L47:
        if (r9 != null) goto L50;
        r9 = r18[2];
    L50:
        if (r10 != null) goto L53;
        r10 = r18[3];
    L53:
        r19.setCompoundDrawablesWithIntrinsicBounds(r7, r8, r9, r10);
    }

    private void setCompoundTints() {
        TintInfo r0 = this.mDrawableTint;
        this.mDrawableLeftTint = r0;
        this.mDrawableTopTint = r0;
        this.mDrawableRightTint = r0;
        this.mDrawableBottomTint = r0;
        this.mDrawableStartTint = r0;
        this.mDrawableEndTint = r0;
    }

    private void setTextSizeInternal(int r1, float r2) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r1, r2);
    }

    private void updateTypefaceAndStyle(Context r10, TintTypedArray r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        this.mStyle = r11.getInt(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), this.mStyle);
        boolean r5 = false;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        int r0 = r11.getInt(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textFontWeight, "styleable", "TextAppearance_android_textFontWeight"), -1);
        this.mFontWeight = r0;
        if (r0 == (-1)) goto L8;
        this.mStyle = (this.mStyle & 2) | 0;
    L8:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_fontFamily, "styleable", "TextAppearance_android_fontFamily")) == false) goto L10;
    L25:
        this.mFontTypeface = null;
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily")) == false) goto L28;
        int r1 = ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily");
    L29:
        final int r2 = this.mFontWeight;
        final int r6 = this.mStyle;
        if (r12.isRestricted() == true) goto L50;
        final WeakReference r13 = new WeakReference(this.mView);
        Typeface r14 = r11.getFont(r1, this.mStyle, new AnonymousClass1(this, r2, r6, r13));     // Catch: Throwable -> L64
        if (r14 == null) goto L45;
        if (Build.VERSION.SDK_INT >= 28) goto L37;
    L43:
        this.mFontTypeface = r14;     // Catch: Throwable -> L64
        goto L45
    L37:
        if (this.mFontWeight == (-1)) goto L43;
        Typeface r15 = Typeface.create(r14, 0);     // Catch: Throwable -> L64
        int r3 = this.mFontWeight;     // Catch: Throwable -> L64
        if ((this.mStyle & 2) == 0) goto L41;
        boolean r7 = true;
    L42:
        r14 = Api28Impl.create(r15, r3, r7);     // Catch: Throwable -> L64
        goto L43
    L41:
        r7 = false;
    L45:
        if (this.mFontTypeface != null) goto L47;
        boolean r16 = true;
    L48:
        this.mAsyncFontPending = r16;     // Catch: Throwable -> L64
        goto L50
    L47:
        r16 = false;
    L50:
        if (this.mFontTypeface != null) goto L69;
        String r17 = r11.getString(r1);
        if (r17 != null) goto L54;
        return;
    L54:
        if (Build.VERSION.SDK_INT >= 28) goto L56;
    L61:
        Typeface r18 = Typeface.create(r17, this.mStyle);
    L62:
        this.mFontTypeface = r18;
        return;
    L56:
        if (this.mFontWeight == (-1)) goto L61;
        Typeface r19 = Typeface.create(r17, 0);
        int r110 = this.mFontWeight;
        if ((this.mStyle & 2) == 0) goto L60;
        r5 = true;
    L60:
        r18 = Api28Impl.create(r19, r110, r5);
        goto L62
    L69:
        return;
    L28:
        r1 = ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_fontFamily, "styleable", "TextAppearance_android_fontFamily");
        goto L29
    L10:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily")) == true) goto L25;
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface")) == false) goto L67;
        this.mAsyncFontPending = false;
        int r111 = r11.getInt(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), 1);
        if (r111 == 1) goto L22;
        if (r111 != 2) goto L18;
        Typeface r112 = Typeface.SERIF;
    L23:
        this.mFontTypeface = r112;
        return;
    L18:
        if (r111 != 3) goto L68;
        r112 = Typeface.MONOSPACE;
        goto L23
    L68:
        return;
    L22:
        r112 = Typeface.SANS_SERIF;
        goto L23
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r0 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r0[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r0[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r0[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r0[3], this.mDrawableBottomTint);
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L14;
        return;
    L14:
        if (this.mDrawableStartTint == null) goto L16;
    L17:
        Drawable[] r1 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        applyCompoundDrawableTint(r1[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r1[2], this.mDrawableEndTint);
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

    ColorStateList getCompoundDrawableTintList() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(AttributeSet r24, int r25) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r24, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        AppCompatDrawableManager r11 = AppCompatDrawableManager.get();
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r9, R.styleable.AppCompatTextHelper, r25, 0);
        TextView r0 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r0, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.AppCompatTextHelper, r9, r13.getWrappedTypeArray(), r25, 0);
        int r1 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_textAppearance, "styleable", "AppCompatTextHelper_android_textAppearance"), -1);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableLeft, "styleable", "AppCompatTextHelper_android_drawableLeft")) == false) goto L6;
        this.mDrawableLeftTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableLeft, "styleable", "AppCompatTextHelper_android_drawableLeft"), 0));
    L6:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableTop, "styleable", "AppCompatTextHelper_android_drawableTop")) == false) goto L9;
        this.mDrawableTopTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableTop, "styleable", "AppCompatTextHelper_android_drawableTop"), 0));
    L9:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableRight, "styleable", "AppCompatTextHelper_android_drawableRight")) == false) goto L12;
        this.mDrawableRightTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableRight, "styleable", "AppCompatTextHelper_android_drawableRight"), 0));
    L12:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableBottom, "styleable", "AppCompatTextHelper_android_drawableBottom")) == false) goto L15;
        this.mDrawableBottomTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableBottom, "styleable", "AppCompatTextHelper_android_drawableBottom"), 0));
    L15:
        if (Build.VERSION.SDK_INT >= 17) goto L17;
    L22:
        r13.recycle();
        boolean r2 = ZeusTransformUtils.instanceOf(this.mView.getTransformationMethod(), PasswordTransformationMethod.class);
        if (r1 == (-1)) goto L56;
        TintTypedArray r3 = TintTypedArray.obtainStyledAttributes(r10, r1, R.styleable.TextAppearance);
        if (r2 == false) goto L27;
    L29:
        boolean r12 = false;
        boolean r15 = false;
    L30:
        updateTypefaceAndStyle(r10, r3);
        boolean r16 = r12;
        boolean r17 = r15;
        if (Build.VERSION.SDK_INT < 23) goto L33;
        ColorStateList r18 = null;
        ColorStateList r19 = null;
        ColorStateList r110 = null;
    L46:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale")) == false) goto L48;
        String r20 = r3.getString(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale"));
    L49:
        ColorStateList r21 = r18;
        if (Build.VERSION.SDK_INT >= 26) goto L52;
    L54:
        String r14 = null;
    L55:
        r3.recycle();
        ColorStateList r111 = r21;
        ColorStateList r22 = r110;
        String r112 = r14;
        ColorStateList r113 = r22;
    L57:
        ColorStateList r23 = r113;
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r10, r9, R.styleable.TextAppearance, r25, 0);
        if (r2 == false) goto L60;
    L62:
        boolean r5 = r17;
    L63:
        ColorStateList r26 = r111;
        if (Build.VERSION.SDK_INT < 23) goto L66;
        ColorStateList r114 = r26;
        ColorStateList r6 = r19;
        ColorStateList r115 = r23;
    L79:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale")) == false) goto L81;
        r20 = r4.getString(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale"));
    L81:
        String r7 = r20;
        if (Build.VERSION.SDK_INT >= 26) goto L84;
    L86:
        String r8 = r112;
    L88:
        if (Build.VERSION.SDK_INT < 28) goto L95;
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize")) == false) goto L95;
        if (r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), -1) != 0) goto L95;
        this.mView.setTextSize(0, 0.0f);
    L95:
        updateTypefaceAndStyle(r10, r4);
        r4.recycle();
        if (r115 == null) goto L98;
        this.mView.setTextColor(r115);
    L98:
        if (r6 == null) goto L100;
        this.mView.setHintTextColor(r6);
    L100:
        if (r114 == null) goto L102;
        this.mView.setLinkTextColor(r114);
    L102:
        if (r2 == true) goto L105;
        if (r16 == false) goto L105;
        setAllCaps(r5);
    L105:
        Typeface r27 = this.mFontTypeface;
        if (r27 != null) goto L108;
    L111:
        if (r8 == null) goto L113;
        Api26Impl.setFontVariationSettings(this.mView, r8);
    L113:
        if (r7 != null) goto L115;
    L120:
        this.mAutoSizeTextHelper.loadFromAttributes(r9, r25);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L123;
    L130:
        TintTypedArray r28 = TintTypedArray.obtainStyledAttributes(r10, r9, R.styleable.AppCompatTextView);
        int r29 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableLeftCompat, "styleable", "AppCompatTextView_drawableLeftCompat"), -1);
        if (r29 == (-1)) goto L133;
        Drawable r30 = r11.getDrawable(r10, r29);
    L134:
        int r31 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTopCompat, "styleable", "AppCompatTextView_drawableTopCompat"), -1);
        if (r31 == (-1)) goto L137;
        Drawable r32 = r11.getDrawable(r10, r31);
    L138:
        int r33 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableRightCompat, "styleable", "AppCompatTextView_drawableRightCompat"), -1);
        if (r33 == (-1)) goto L141;
        Drawable r34 = r11.getDrawable(r10, r33);
    L142:
        int r35 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableBottomCompat, "styleable", "AppCompatTextView_drawableBottomCompat"), -1);
        if (r35 == (-1)) goto L145;
        Drawable r36 = r11.getDrawable(r10, r35);
    L146:
        int r37 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableStartCompat, "styleable", "AppCompatTextView_drawableStartCompat"), -1);
        if (r37 == (-1)) goto L149;
        Drawable r38 = r11.getDrawable(r10, r37);
    L150:
        int r39 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableEndCompat, "styleable", "AppCompatTextView_drawableEndCompat"), -1);
        if (r39 == (-1)) goto L153;
        Drawable r116 = r11.getDrawable(r10, r39);
    L154:
        setCompoundDrawables(r30, r32, r34, r36, r38, r116);
        if (r28.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTint, "styleable", "AppCompatTextView_drawableTint")) == false) goto L158;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r28.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTint, "styleable", "AppCompatTextView_drawableTint")));
    L158:
        if (r28.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTintMode, "styleable", "AppCompatTextView_drawableTintMode")) == false) goto L160;
        int r40 = -1;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r28.getInt(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTintMode, "styleable", "AppCompatTextView_drawableTintMode"), -1), null));
    L161:
        int r41 = r28.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_firstBaselineToTopHeight, "styleable", "AppCompatTextView_firstBaselineToTopHeight"), r40);
        int r42 = r28.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, "styleable", "AppCompatTextView_lastBaselineToBottomHeight"), r40);
        int r43 = r28.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_lineHeight, "styleable", "AppCompatTextView_lineHeight"), r40);
        r28.recycle();
        if (r41 == r40) goto L164;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r41);
    L164:
        if (r42 == r40) goto L166;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r42);
    L166:
        if (r43 == r40) goto L169;
        TextViewCompat.setLineHeight(this.mView, r43);
        return;
    L169:
        return;
    L160:
        r40 = -1;
        goto L161
    L153:
        r116 = null;
        goto L154
    L149:
        r38 = null;
        goto L150
    L145:
        r36 = null;
        goto L146
    L141:
        r34 = null;
        goto L142
    L137:
        r32 = null;
        goto L138
    L133:
        r30 = null;
        goto L134
    L123:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L130;
        int[] r44 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r44.length <= 0) goto L130;
        if (Api26Impl.getAutoSizeStepGranularity(this.mView) == (-1.0f)) goto L129;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L130
    L129:
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, r44, 0);
        goto L130
    L115:
        if (Build.VERSION.SDK_INT < 24) goto L118;
        Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(r7));
        goto L120
    L118:
        if (Build.VERSION.SDK_INT < 21) goto L120;
        Api17Impl.setTextLocale(this.mView, Api21Impl.forLanguageTag(r7.split(",")[0]));
        goto L120
    L108:
        if (this.mFontWeight != (-1)) goto L110;
        this.mView.setTypeface(r27, this.mStyle);
        goto L111
    L110:
        this.mView.setTypeface(r27);
        goto L111
    L84:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L86;
        r8 = r4.getString(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        goto L88
    L66:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L68;
        r115 = r4.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
    L70:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L73;
        r19 = r4.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
    L73:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L75;
        r114 = r4.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
    L76:
        r6 = r19;
        goto L79
    L75:
        r114 = r26;
        goto L76
    L68:
        r115 = r23;
        goto L70
    L60:
        if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L62;
        r5 = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false);
        r16 = true;
        goto L63
    L52:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L54;
        r14 = r3.getString(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        goto L55
    L48:
        r20 = null;
        goto L49
    L33:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L35;
        ColorStateList r117 = r3.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
    L37:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L39;
        ColorStateList r118 = r3.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
    L41:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L43;
        r110 = r117;
        r19 = r118;
        r18 = r3.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
        goto L46
    L43:
        r110 = r117;
        r19 = r118;
        r18 = null;
        goto L46
    L39:
        r118 = null;
        goto L41
    L35:
        r117 = null;
        goto L37
    L27:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L29;
        r15 = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false);
        r12 = true;
        goto L30
    L56:
        r113 = null;
        r111 = null;
        r16 = false;
        r17 = false;
        r19 = null;
        r112 = null;
        r20 = null;
        goto L57
    L17:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableStart, "styleable", "AppCompatTextHelper_android_drawableStart")) == false) goto L20;
        this.mDrawableStartTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableStart, "styleable", "AppCompatTextHelper_android_drawableStart"), 0));
    L20:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableEnd, "styleable", "AppCompatTextHelper_android_drawableEnd")) == false) goto L22;
        this.mDrawableEndTint = createTintInfo(r10, r11, r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableEnd, "styleable", "AppCompatTextHelper_android_drawableEnd"), 0));
        goto L22
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> r3, final Typeface r4) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r4;
        final TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r3.get(), TextView.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L9;
        final int r0 = this.mStyle;
        r5.post(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        r5.setTypeface(r4, this.mStyle);
        return;
    }

    void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        TintTypedArray r8 = TintTypedArray.obtainStyledAttributes(r7, r6, R.styleable.TextAppearance);
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L6;
        setAllCaps(r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false));
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L23;
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L13;
        ColorStateList r0 = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
        if (r0 == null) goto L13;
        this.mView.setTextColor(r0);
    L13:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L18;
        ColorStateList r1 = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
        if (r1 == null) goto L18;
        this.mView.setLinkTextColor(r1);
    L18:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L23;
        ColorStateList r2 = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
        if (r2 == null) goto L23;
        this.mView.setHintTextColor(r2);
    L23:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize")) == true) goto L25;
    L27:
        updateTypefaceAndStyle(r7, r8);
        if (Build.VERSION.SDK_INT >= 26) goto L30;
    L34:
        r8.recycle();
        Typeface r9 = this.mFontTypeface;
        if (r9 == null) goto L38;
        this.mView.setTypeface(r9, this.mStyle);
        return;
    L38:
        return;
    L30:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L34;
        String r10 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        if (r10 == null) goto L34;
        Api26Impl.setFontVariationSettings(this.mView, r10);
        goto L34
    L25:
        if (r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), -1) != 0) goto L27;
        this.mView.setTextSize(0, 0.0f);
        goto L27
    }

    void populateSurroundingTextIfNeeded(TextView r2, InputConnection r3, EditorInfo r4) {
        InputConnection r1 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        if (r1 == null) goto L8;
        EditorInfoCompat.setInitialSurroundingText(r4, r2.getText());
        return;
    L8:
        return;
    }

    void setAllCaps(boolean r1) {
        this.mView.setAllCaps(r1);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int r1, int r2, int r3, int r4) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] r1, int r2) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    void setAutoSizeTextTypeWithDefaults(int r1) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r1);
    }

    void setCompoundDrawableTintList(ColorStateList r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        this.mDrawableTint.mTintList = r2;
        TintInfo r0 = this.mDrawableTint;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintList = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    void setCompoundDrawableTintMode(PorterDuff.Mode r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        this.mDrawableTint.mTintMode = r2;
        TintInfo r0 = this.mDrawableTint;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintMode = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    void setTextSize(int r2, float r3) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r2, r3);
        return;
    }
}
