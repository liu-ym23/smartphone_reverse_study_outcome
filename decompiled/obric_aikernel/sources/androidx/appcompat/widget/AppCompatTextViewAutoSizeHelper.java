package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = null;
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;

    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;

    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache;
    private float mAutoSizeMaxTextSizeInPx;
    private float mAutoSizeMinTextSizeInPx;
    private float mAutoSizeStepGranularityInPx;
    private int[] mAutoSizeTextSizesInPx;
    private int mAutoSizeTextType;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText;
    private TextPaint mTempTextPaint;

    @NonNull
    private final TextView mTextView;

    @RequiresApi(16)
    private static final class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, @NonNull TextView r13, @NonNull TextPaint r14) {
            return new StaticLayout(r10, r14, r12, r11, r13.getLineSpacingMultiplier(), r13.getLineSpacingExtra(), r13.getIncludeFontPadding());
        }

        @DoNotInline
        static int getMaxLines(@NonNull TextView r10) {
            return r10.getMaxLines();
        }
    }

    @RequiresApi(18)
    private static final class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static boolean isInLayout(@NonNull View r10) {
            return r10.isInLayout();
        }
    }

    @RequiresApi(23)
    private static final class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        @DoNotInline
        static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, int r13, @NonNull TextView r14, @NonNull TextPaint r15, @NonNull Impl r16) {
            StaticLayout.Builder r17 = StaticLayout.Builder.obtain(r10, 0, r10.length(), r15, r12);
            StaticLayout.Builder r18 = r17.setAlignment(r11).setLineSpacing(r14.getLineSpacingExtra(), r14.getLineSpacingMultiplier()).setIncludePad(r14.getIncludeFontPadding()).setBreakStrategy(r14.getBreakStrategy()).setHyphenationFrequency(r14.getHyphenationFrequency());
            if (r13 != (-1)) goto L5;
            r13 = Integer.MAX_VALUE;
        L5:
            r18.setMaxLines(r13);
            r16.computeAndSetTextDirection(r17, r14);     // Catch: ClassCastException -> L8
        L10:
            return r17.build();
        L8:
            Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            goto L10
        }
    }

    private static class Impl {
        Impl() {
        }

        void computeAndSetTextDirection(StaticLayout.Builder r10, TextView r11) {
        }

        boolean isHorizontallyScrollable(TextView r10) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r10, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder r10, TextView r11) {
            r10.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r11, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder r10, TextView r11) {
            r10.setTextDirection(r11.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean isHorizontallyScrollable(TextView r10) {
            return r10.isHorizontallyScrollable();
        }
    }

    static {
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    AppCompatTextViewAutoSizeHelper(@NonNull TextView r10) {
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = r10;
        this.mContext = r10.getContext();
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 29) goto L7;
        Impl r12 = new Impl29();
    L5:
        this.mImpl = r12;
        return;
    L7:
        if (r11 < 23) goto L9;
        r12 = new Impl23();
        goto L5
    L9:
        r12 = new Impl();
        goto L5
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object r10, @NonNull String r11, @NonNull T r12) {
        Field r13 = getTextViewField(r11);     // Catch: IllegalAccessException -> L7
        if (r13 != null) goto L5;
        return r12;
    L5:
        return (T) r13.get(r10);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r11 + " member", e);
        return r12;
    }

    private int[] cleanupAutoSizePresetSizes(int[] r10) {
        int r11 = r10.length;
        if (r11 != 0) goto L5;
        return r10;
    L5:
        Arrays.sort(r10);
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L14;
        int r15 = r10[r14];
        if (r15 <= 0) goto L12;
        if (Collections.binarySearch(r12, Integer.valueOf(r15)) >= 0) goto L12;
        r12.add(Integer.valueOf(r15));
    L12:
        r14 = r14 + 1;
        goto L6
    L14:
        if (r11 != r12.size()) goto L16;
        return r10;
    L16:
        int r16 = r12.size();
        int[] r17 = new int[r16];
    L17:
        if (r13 >= r16) goto L19;
        r17[r13] = ((Integer) r12.get(r13)).intValue();
        r13 = r13 + 1;
        goto L17
    L19:
        return r17;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence r10, Layout.Alignment r11, int r12) {
        float r13 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue();
        float r14 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue();
        boolean r15 = ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue();
        return new StaticLayout(r10, this.mTempTextPaint, r12, r11, r13, r14, r15);
    }

    private int findLargestTextSizeWhichFits(RectF r10) {
        int r11 = this.mAutoSizeTextSizesInPx.length;
        if (r11 == 0) goto L14;
        int r12 = 0;
        int r13 = 1;
        int r14 = r11 - 1;
    L5:
        int r15 = r13;
        int r16 = r12;
        r12 = r15;
    L6:
        if (r12 > r14) goto L12;
        int r17 = (r12 + r14) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[r17], r10) == true) goto L9;
        r16 = r17 - 1;
        r14 = r16;
        goto L6
    L9:
        r13 = r17 + 1;
        goto L5
    L12:
        return this.mAutoSizeTextSizesInPx[r16];
    L14:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Field getTextViewField(@NonNull String r10) {
        Field r11 = sTextViewFieldByNameCache.get(r10);     // Catch: NoSuchFieldException -> L8
        if (r11 != null) goto L7;
        r11 = TextView.class.getDeclaredField(r10);     // Catch: NoSuchFieldException -> L8
        if (r11 == null) goto L7;
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        sTextViewFieldByNameCache.put(r10, r11);     // Catch: NoSuchFieldException -> L8
    L7:
        return r11;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r10 + " member", e);
        return null;
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String r10) {
        Method r11 = sTextViewMethodByNameCache.get(r10);     // Catch: Exception -> L8
        if (r11 != null) goto L7;
        r11 = TextView.class.getDeclaredMethod(r10, new Class[0]);     // Catch: Exception -> L8
        if (r11 == null) goto L7;
        r11.setAccessible(true);     // Catch: Exception -> L8
        sTextViewMethodByNameCache.put(r10, r11);     // Catch: Exception -> L8
    L7:
        return r11;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve TextView#" + r10 + "() method", e);
        return null;
    }

    static <T> T invokeAndReturnWithDefault(@NonNull Object r10, @NonNull String r11, @NonNull T r12) {
    L13:
        return (T) getTextViewMethod(r11).invoke(r10, new Object[0]);
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#" + r11 + "() method", e);     // Catch: Throwable -> L4
        return r12;
    L4:
        th = move-exception;
        throw th;
    }

    private void setRawTextSize(float r10) {
        if (r10 == this.mTextView.getPaint().getTextSize()) goto L24;
        this.mTextView.getPaint().setTextSize(r10);
        if (Build.VERSION.SDK_INT < 18) goto L7;
        boolean r11 = Api18Impl.isInLayout(this.mTextView);
    L9:
        if (this.mTextView.getLayout() == null) goto L25;
        this.mNeedsAutoSizeText = false;
        Method r12 = getTextViewMethod("nullLayouts");     // Catch: Exception -> L15
        if (r12 == null) goto L17;
        r12.invoke(this.mTextView, new Object[0]);     // Catch: Exception -> L15
    L17:
        if (r11 == true) goto L19;
        this.mTextView.requestLayout();
    L20:
        this.mTextView.invalidate();
        return;
    L19:
        this.mTextView.forceLayout();
    L15:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e);
        goto L17
    L25:
        return;
    L7:
        r11 = false;
        goto L9
    }

    private boolean setupAutoSizeText() {
        int r10 = 0;
        if (supportsAutoSizeText() == true) goto L5;
    L15:
        this.mNeedsAutoSizeText = false;
    L17:
        return this.mNeedsAutoSizeText;
    L5:
        if (this.mAutoSizeTextType != 1) goto L15;
        if (this.mHasPresetAutoSizeValues == true) goto L9;
    L10:
        int r11 = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
        int[] r12 = new int[r11];
    L11:
        if (r10 >= r11) goto L13;
        r12[r10] = Math.round(this.mAutoSizeMinTextSizeInPx + (r10 * this.mAutoSizeStepGranularityInPx));
        r10 = r10 + 1;
        goto L11
    L13:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r12);
    L14:
        this.mNeedsAutoSizeText = true;
        goto L17
    L9:
        if (this.mAutoSizeTextSizesInPx.length != 0) goto L14;
        goto L10
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray r10) {
        int r11 = r10.length();
        int[] r12 = new int[r11];
        if (r11 <= 0) goto L10;
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L7;
        r12[r13] = r10.getDimensionPixelSize(r13, -1);
        r13 = r13 + 1;
        goto L5
    L7:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r12);
        setupAutoSizeUniformPresetSizesConfiguration();
        return;
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] r10 = this.mAutoSizeTextSizesInPx;
        int r11 = r10.length;
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        this.mHasPresetAutoSizeValues = r12;
        if (r12 == false) goto L9;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r10[0];
        this.mAutoSizeMaxTextSizeInPx = r10[r11 - 1];
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    L9:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    private boolean suggestedSizeFitsInSpace(int r10, RectF r11) {
        CharSequence r12 = this.mTextView.getText();
        TransformationMethod r13 = this.mTextView.getTransformationMethod();
        if (r13 == null) goto L8;
        CharSequence r14 = r13.getTransformation(r12, this.mTextView);
        if (r14 == null) goto L8;
        r12 = r14;
    L8:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        int r15 = Api16Impl.getMaxLines(this.mTextView);
    L11:
        initTempTextPaint(r10);
        StaticLayout r16 = createLayout(r12, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(r11.right), r15);
        if (r15 == (-1)) goto L19;
        if (r16.getLineCount() <= r15) goto L16;
    L17:
        return false;
    L16:
        if (r16.getLineEnd(r16.getLineCount() - 1) != r12.length()) goto L17;
    L19:
        if (r16.getHeight() <= r11.bottom) goto L21;
        return false;
    L21:
        return true;
    L10:
        r15 = -1;
        goto L11
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float r10, float r11, float r12) {
        if (r10 <= 0.0f) goto L15;
        if (r11 <= r10) goto L13;
        if (r12 <= 0.0f) goto L11;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r10;
        this.mAutoSizeMaxTextSizeInPx = r11;
        this.mAutoSizeStepGranularityInPx = r12;
        this.mHasPresetAutoSizeValues = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r12 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r11 + "px) is less or equal to minimum auto-size text size (" + r10 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r10 + "px) is less or equal to (0px)");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void autoSizeText() {
        if (isAutoSizeEnabled() == true) goto L6;
        return;
    L6:
        if (this.mNeedsAutoSizeText == true) goto L8;
    L31:
        this.mNeedsAutoSizeText = true;
        return;
    L8:
        if (this.mTextView.getMeasuredHeight() > 0) goto L10;
        return;
    L10:
        if (this.mTextView.getMeasuredWidth() > 0) goto L13;
        return;
    L13:
        if (this.mImpl.isHorizontallyScrollable(this.mTextView) == false) goto L15;
        int r10 = 1048576;
    L16:
        int r11 = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
        if (r10 <= 0) goto L35;
        if (r11 <= 0) goto L37;
        RectF r12 = TEMP_RECTF;
        monitor-enter(r12);
        r12.setEmpty();     // Catch: Throwable -> L27
        r12.right = r10;     // Catch: Throwable -> L27
        r12.bottom = r11;     // Catch: Throwable -> L27
        float r13 = findLargestTextSizeWhichFits(r12);     // Catch: Throwable -> L27
        if (r13 == this.mTextView.getTextSize()) goto L25;
        setTextSizeInternal(0, r13);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r12);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L37:
        return;
    L35:
        return;
    L15:
        r10 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
        goto L16
    }

    @NonNull
    @VisibleForTesting
    StaticLayout createLayout(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, int r13) {
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 23) goto L7;
        return Api23Impl.createStaticLayoutForMeasuring(r10, r11, r12, r13, this.mTextView, this.mTempTextPaint, this.mImpl);
    L7:
        if (r14 < 16) goto L11;
        return Api16Impl.createStaticLayoutForMeasuring(r10, r11, r12, this.mTextView, this.mTempTextPaint);
    L11:
        return createStaticLayoutForMeasuringPre16(r10, r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    void initTempTextPaint(int r10) {
        TextPaint r11 = this.mTempTextPaint;
        if (r11 != null) goto L5;
        this.mTempTextPaint = new TextPaint();
    L6:
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(r10);
        return;
    L5:
        r11.reset();
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoSizeTextType == 0) goto L7;
        return true;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r12 = this.mContext;
        int[] r13 = R.styleable.AppCompatTextView;
        TypedArray r14 = r12.obtainStyledAttributes(r10, r13, r11, 0);
        TextView r15 = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14, r11, 0);
        int r16 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (r14.hasValue(r16) == false) goto L5;
        this.mAutoSizeTextType = r14.getInt(r16, 0);
    L5:
        int r17 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        if (r14.hasValue(r17) == false) goto L8;
        float r18 = r14.getDimension(r17, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L9:
        int r19 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        if (r14.hasValue(r19) == false) goto L12;
        float r110 = r14.getDimension(r19, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L13:
        int r20 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (r14.hasValue(r20) == false) goto L16;
        float r21 = r14.getDimension(r20, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L17:
        int r22 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (r14.hasValue(r22) == false) goto L22;
        int r23 = r14.getResourceId(r22, 0);
        if (r23 <= 0) goto L22;
        TypedArray r24 = r14.getResources().obtainTypedArray(r23);
        setupAutoSizeUniformPresetSizes(r24);
        r24.recycle();
    L22:
        r14.recycle();
        if (supportsAutoSizeText() == true) goto L25;
        this.mAutoSizeTextType = 0;
        return;
    L25:
        if (this.mAutoSizeTextType == 1) goto L27;
        return;
    L27:
        if (this.mHasPresetAutoSizeValues == true) goto L38;
        DisplayMetrics r25 = this.mContext.getResources().getDisplayMetrics();
        if (r110 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L32;
        r110 = TypedValue.applyDimension(2, 12.0f, r25);
    L32:
        if (r21 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L35;
        r21 = TypedValue.applyDimension(2, 112.0f, r25);
    L35:
        if (r18 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L37;
        r18 = 1.0f;
    L37:
        validateAndSetAutoSizeTextTypeUniformConfiguration(r110, r21, r18);
    L38:
        setupAutoSizeText();
        return;
    L16:
        r21 = -1.0f;
        goto L17
    L12:
        r110 = -1.0f;
        goto L13
    L8:
        r18 = -1.0f;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) {
        if (supportsAutoSizeText() == false) goto L8;
        DisplayMetrics r14 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r13, r10, r14), TypedValue.applyDimension(r13, r11, r14), TypedValue.applyDimension(r13, r12, r14));
        if (setupAutoSizeText() == false) goto L9;
        autoSizeText();
        return;
    L9:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11) {
        if (supportsAutoSizeText() == false) goto L23;
        int r12 = r10.length;
        int r13 = 0;
        if (r12 <= 0) goto L17;
        int[] r14 = new int[r12];
        if (r11 != 0) goto L9;
        r14 = Arrays.copyOf(r10, r12);
    L12:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r14);
        if (setupAutoSizeUniformPresetSizesConfiguration() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r10));
    L19:
        if (setupAutoSizeText() == false) goto L24;
        autoSizeText();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r15 = this.mContext.getResources().getDisplayMetrics();
    L10:
        if (r13 >= r12) goto L12;
        r14[r13] = Math.round(TypedValue.applyDimension(r11, r10[r13], r15));
        r13 = r13 + 1;
        goto L10
    L17:
        this.mHasPresetAutoSizeValues = false;
        goto L19
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setAutoSizeTextTypeWithDefaults(int r10) {
        if (supportsAutoSizeText() == false) goto L14;
        if (r10 != 0) goto L6;
        clearAutoSizeConfiguration();
        return;
    L6:
        if (r10 != 1) goto L11;
        DisplayMetrics r11 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, r11), TypedValue.applyDimension(2, 112.0f, r11), 1.0f);
        if (setupAutoSizeText() == false) goto L15;
        autoSizeText();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("Unknown auto-size text type: " + r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setTextSizeInternal(int r10, float r11) {
        Context r12 = this.mContext;
        if (r12 != null) goto L5;
        Resources r13 = Resources.getSystem();
    L6:
        setRawTextSize(TypedValue.applyDimension(r10, r11, r13.getDisplayMetrics()));
        return;
    L5:
        r13 = r12.getResources();
        goto L6
    }
}
