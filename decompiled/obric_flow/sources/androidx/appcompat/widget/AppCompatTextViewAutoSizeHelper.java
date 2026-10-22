package androidx.appcompat.widget;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
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
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        public static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, @NonNull TextView r13, @NonNull TextPaint r14) {
            return new StaticLayout(r10, r14, r12, r11, r13.getLineSpacingMultiplier(), r13.getLineSpacingExtra(), r13.getIncludeFontPadding());
        }

        @DoNotInline
        public static int getMaxLines(@NonNull TextView r5) {
            return r5.getMaxLines();
        }
    }

    @RequiresApi(18)
    public static final class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static boolean isInLayout(@NonNull View r5) {
            return r5.isInLayout();
        }
    }

    @RequiresApi(23)
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        @DoNotInline
        public static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence r5, @NonNull Layout.Alignment r10, int r11, int r12, @NonNull TextView r13, @NonNull TextPaint r14, @NonNull Impl r15) {
            StaticLayout.Builder r16 = StaticLayout.Builder.obtain(r5, 0, r5.length(), r14, r11);
            StaticLayout.Builder r17 = r16.setAlignment(r10).setLineSpacing(r13.getLineSpacingExtra(), r13.getLineSpacingMultiplier()).setIncludePad(r13.getIncludeFontPadding()).setBreakStrategy(r13.getBreakStrategy()).setHyphenationFrequency(r13.getHyphenationFrequency());
            if (r12 != (-1)) goto L5;
            r12 = Integer.MAX_VALUE;
        L5:
            r17.setMaxLines(r12);
            r15.computeAndSetTextDirection(r16, r13);     // Catch: ClassCastException -> L8
        L10:
            return r16.build();
        L8:
            Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            goto L10
        }
    }

    public static class Impl {
        public Impl() {
        }

        public void computeAndSetTextDirection(StaticLayout.Builder r5, TextView r10) {
        }

        public boolean isHorizontallyScrollable(TextView r5) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r5, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    @RequiresApi(23)
    public static class Impl23 extends Impl {
        public Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r5, TextView r10) {
            r5.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r10, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl23 {
        public Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r5, TextView r10) {
            r5.setTextDirection(r10.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView r5) {
            return r5.isHorizontallyScrollable();
        }
    }

    static {
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    public AppCompatTextViewAutoSizeHelper(@NonNull TextView r5) {
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = r5;
        this.mContext = r5.getContext();
        this.mImpl = new Impl29();
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object r5, @NonNull String r10, @NonNull T r11) {
        Field r12 = getTextViewField(r10);     // Catch: IllegalAccessException -> L7
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (T) r12.get(r5);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r10 + " member", e);
        return r11;
    }

    private int[] cleanupAutoSizePresetSizes(int[] r10) {
        int r5 = r10.length;
        if (r5 != 0) goto L5;
        return r10;
    L5:
        Arrays.sort(r10);
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r5) goto L14;
        int r14 = r10[r13];
        if (r14 <= 0) goto L12;
        if (Collections.binarySearch(r11, Integer.valueOf(r14)) >= 0) goto L12;
        r11.add(Integer.valueOf(r14));
    L12:
        r13 = r13 + 1;
        goto L6
    L14:
        if (r5 != r11.size()) goto L16;
        return r10;
    L16:
        int r15 = r11.size();
        int[] r16 = new int[r15];
    L17:
        if (r12 >= r15) goto L19;
        r16[r12] = ((Integer) r11.get(r12)).intValue();
        r12 = r12 + 1;
        goto L17
    L19:
        return r16;
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
        int r5 = this.mAutoSizeTextSizesInPx.length;
        if (r5 == 0) goto L13;
        int r11 = 1;
        int r12 = r5 - 1;
        int r13 = 0;
    L5:
        if (r11 > r12) goto L11;
        int r14 = (r11 + r12) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[r14], r10) == true) goto L8;
        r13 = r14 - 1;
        r12 = r13;
        goto L5
    L8:
        int r15 = r14 + 1;
        r13 = r11;
        r11 = r15;
        goto L5
    L11:
        return this.mAutoSizeTextSizesInPx[r13];
    L13:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Field getTextViewField(@NonNull String r5) {
        Field r10 = sTextViewFieldByNameCache.get(r5);     // Catch: NoSuchFieldException -> L8
        if (r10 != null) goto L10;
        r10 = TextView.class.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L8
        if (r10 == null) goto L10;
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        sTextViewFieldByNameCache.put(r5, r10);     // Catch: NoSuchFieldException -> L8
    L10:
        return r10;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r5 + " member", e);
        return null;
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String r5) {
        Method r10 = sTextViewMethodByNameCache.get(r5);     // Catch: Exception -> L9
        if (r10 != null) goto L11;
        r10 = TextView.class.getDeclaredMethod(r5, null);     // Catch: Exception -> L9
        if (r10 == null) goto L11;
        r10.setAccessible(true);     // Catch: Exception -> L9
        sTextViewMethodByNameCache.put(r5, r10);     // Catch: Exception -> L9
    L11:
        return r10;
    L9:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve TextView#" + r5 + "() method", e);
        return null;
    }

    public static <T> T invokeAndReturnWithDefault(@NonNull Object r5, @NonNull String r10, @NonNull T r11) {
    L14:
        return (T) getTextViewMethod(r10).invoke(r5, null);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#" + r10 + "() method", e);
        return r11;
    L5:
        th = move-exception;
        throw th;
    }

    private void setRawTextSize(float r5) {
        if (r5 == this.mTextView.getPaint().getTextSize()) goto L20;
        this.mTextView.getPaint().setTextSize(r5);
        boolean r10 = Api18Impl.isInLayout(this.mTextView);
        if (this.mTextView.getLayout() == null) goto L21;
        this.mNeedsAutoSizeText = false;
        Method r11 = getTextViewMethod("nullLayouts");     // Catch: Exception -> L11
        if (r11 == null) goto L13;
        r11.invoke(this.mTextView, null);     // Catch: Exception -> L11
    L13:
        if (r10 == true) goto L15;
        this.mTextView.requestLayout();
    L16:
        this.mTextView.invalidate();
        return;
    L15:
        this.mTextView.forceLayout();
    L11:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e);
        goto L13
    L21:
        return;
    }

    private boolean setupAutoSizeText() {
        int r5 = 0;
        if (supportsAutoSizeText() == true) goto L5;
    L15:
        this.mNeedsAutoSizeText = false;
    L17:
        return this.mNeedsAutoSizeText;
    L5:
        if (this.mAutoSizeTextType != 1) goto L15;
        if (this.mHasPresetAutoSizeValues == true) goto L9;
    L10:
        int r10 = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
        int[] r11 = new int[r10];
    L11:
        if (r5 >= r10) goto L13;
        r11[r5] = Math.round((r5 * this.mAutoSizeStepGranularityInPx) + this.mAutoSizeMinTextSizeInPx);
        r5 = r5 + 1;
        goto L11
    L13:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r11);
    L14:
        this.mNeedsAutoSizeText = true;
        goto L17
    L9:
        if (this.mAutoSizeTextSizesInPx.length != 0) goto L14;
        goto L10
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray r5) {
        int r10 = r5.length();
        int[] r11 = new int[r10];
        if (r10 <= 0) goto L10;
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L7;
        r11[r12] = r5.getDimensionPixelSize(r12, -1);
        r12 = r12 + 1;
        goto L5
    L7:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r11);
        setupAutoSizeUniformPresetSizesConfiguration();
        return;
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] r5 = this.mAutoSizeTextSizesInPx;
        int r10 = r5.length;
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.mHasPresetAutoSizeValues = r11;
        if (r11 == false) goto L9;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r5[0];
        this.mAutoSizeMaxTextSizeInPx = r5[r10 - 1];
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    L9:
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    private boolean suggestedSizeFitsInSpace(int r5, RectF r10) {
        CharSequence r11 = this.mTextView.getText();
        TransformationMethod r12 = this.mTextView.getTransformationMethod();
        if (r12 == null) goto L7;
        CharSequence r13 = r12.getTransformation(r11, this.mTextView);
        if (r13 == null) goto L7;
        r11 = r13;
    L7:
        int r14 = Api16Impl.getMaxLines(this.mTextView);
        initTempTextPaint(r5);
        StaticLayout r15 = createLayout(r11, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(r10.right), r14);
        if (r14 == (-1)) goto L15;
        if (r15.getLineCount() <= r14) goto L12;
    L13:
        return false;
    L12:
        if (r15.getLineEnd(r15.getLineCount() - 1) != r11.length()) goto L13;
    L15:
        if (r15.getHeight() <= r10.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float r5, float r10, float r11) throws IllegalArgumentException {
        if (r5 <= 0.0f) goto L15;
        if (r10 <= r5) goto L13;
        if (r11 <= 0.0f) goto L11;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r5;
        this.mAutoSizeMaxTextSizeInPx = r10;
        this.mAutoSizeStepGranularityInPx = r11;
        this.mHasPresetAutoSizeValues = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r11 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r10 + "px) is less or equal to minimum auto-size text size (" + r5 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r5 + "px) is less or equal to (0px)");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        if (isAutoSizeEnabled() == true) goto L6;
        return;
    L6:
        if (this.mNeedsAutoSizeText == true) goto L8;
    L32:
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
        int r5 = 1048576;
    L16:
        int r10 = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
        if (r5 <= 0) goto L36;
        if (r10 <= 0) goto L38;
        RectF r11 = TEMP_RECTF;
        monitor-enter(r11);
        r11.setEmpty();     // Catch: Throwable -> L25
        r11.right = r5;     // Catch: Throwable -> L25
        r11.bottom = r10;     // Catch: Throwable -> L25
        float r12 = findLargestTextSizeWhichFits(r11);     // Catch: Throwable -> L25
        if (r12 == this.mTextView.getTextSize()) goto L27;
        setTextSizeInternal(0, r12);     // Catch: Throwable -> L25
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L38:
        return;
    L36:
        return;
    L15:
        r5 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
        goto L16
    }

    @NonNull
    @VisibleForTesting
    public StaticLayout createLayout(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, int r13) {
        return Api23Impl.createStaticLayoutForMeasuring(r10, r11, r12, r13, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    public void initTempTextPaint(int r5) {
        TextPaint r10 = this.mTempTextPaint;
        if (r10 != null) goto L5;
        this.mTempTextPaint = new TextPaint();
    L6:
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(r5);
        return;
    L5:
        r10.reset();
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoSizeTextType == 0) goto L7;
        return true;
    }

    public void loadFromAttributes(@Nullable AttributeSet r11, int r12) {
        TypedArray r5 = this.mContext.obtainStyledAttributes(r11, R.styleable.AppCompatTextView, r12, 0);
        TextView r10 = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(r10, r10.getContext(), R.styleable.AppCompatTextView, r11, r5, r12, 0);
        if (r5.hasValue(R.styleable.AppCompatTextView_autoSizeTextType) == false) goto L6;
        this.mAutoSizeTextType = r5.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    L6:
        if (r5.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) == false) goto L8;
        float r13 = r5.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L10:
        if (r5.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) == false) goto L12;
        float r14 = r5.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L14:
        if (r5.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) == false) goto L16;
        float r15 = r5.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE);
    L18:
        if (r5.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) == false) goto L22;
        int r16 = r5.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
        if (r16 <= 0) goto L22;
        TypedArray r17 = r5.getResources().obtainTypedArray(r16);
        setupAutoSizeUniformPresetSizes(r17);
        r17.recycle();
    L22:
        r5.recycle();
        if (supportsAutoSizeText() == true) goto L25;
        this.mAutoSizeTextType = 0;
        return;
    L25:
        if (this.mAutoSizeTextType == 1) goto L27;
        return;
    L27:
        if (this.mHasPresetAutoSizeValues == true) goto L38;
        DisplayMetrics r18 = this.mContext.getResources().getDisplayMetrics();
        if (r14 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L32;
        r14 = TypedValue.applyDimension(2, 12.0f, r18);
    L32:
        if (r15 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L35;
        r15 = TypedValue.applyDimension(2, 112.0f, r18);
    L35:
        if (r13 != UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) goto L37;
        r13 = 1.0f;
    L37:
        validateAndSetAutoSizeTextTypeUniformConfiguration(r14, r15, r13);
    L38:
        setupAutoSizeText();
        return;
    L16:
        r15 = -1.0f;
        goto L18
    L12:
        r14 = -1.0f;
        goto L14
    L8:
        r13 = -1.0f;
        goto L10
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r5, int r10, int r11, int r12) throws IllegalArgumentException {
        if (supportsAutoSizeText() == false) goto L8;
        DisplayMetrics r13 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r12, r5, r13), TypedValue.applyDimension(r12, r10, r13), TypedValue.applyDimension(r12, r11, r13));
        if (setupAutoSizeText() == false) goto L9;
        autoSizeText();
        return;
    L9:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11) throws IllegalArgumentException {
        if (supportsAutoSizeText() == false) goto L23;
        int r5 = r10.length;
        int r12 = 0;
        if (r5 <= 0) goto L17;
        int[] r13 = new int[r5];
        if (r11 != 0) goto L9;
        r13 = Arrays.copyOf(r10, r5);
    L12:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r13);
        if (setupAutoSizeUniformPresetSizesConfiguration() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r10));
    L19:
        if (setupAutoSizeText() == false) goto L24;
        autoSizeText();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r14 = this.mContext.getResources().getDisplayMetrics();
    L10:
        if (r12 >= r5) goto L12;
        r13[r12] = Math.round(TypedValue.applyDimension(r11, r10[r12], r14));
        r12 = r12 + 1;
        goto L10
    L17:
        this.mHasPresetAutoSizeValues = false;
        goto L19
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r5) {
        if (supportsAutoSizeText() == false) goto L14;
        if (r5 != 0) goto L6;
        clearAutoSizeConfiguration();
        return;
    L6:
        if (r5 != 1) goto L11;
        DisplayMetrics r10 = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, r10), TypedValue.applyDimension(2, 112.0f, r10), 1.0f);
        if (setupAutoSizeText() == false) goto L15;
        autoSizeText();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException(j0.g(r5, "Unknown auto-size text type: "));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSizeInternal(int r5, float r10) {
        Context r11 = this.mContext;
        if (r11 != null) goto L5;
        Resources r12 = Resources.getSystem();
    L6:
        setRawTextSize(TypedValue.applyDimension(r5, r10, r12.getDisplayMetrics()));
        return;
    L5:
        r12 = r11.getResources();
        goto L6
    }
}
