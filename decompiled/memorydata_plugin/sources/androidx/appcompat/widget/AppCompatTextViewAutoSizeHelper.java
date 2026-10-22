package androidx.appcompat.widget;

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
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;
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
    private final TextView mTextView;

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence r8, Layout.Alignment r9, int r10, TextView r11, TextPaint r12) {
            return new StaticLayout((CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin"), r12, r10, r9, r11.getLineSpacingMultiplier(), r11.getLineSpacingExtra(), r11.getIncludeFontPadding());
        }

        static int getMaxLines(TextView r0) {
            return r0.getMaxLines();
        }
    }

    private static final class Api18Impl {
        private Api18Impl() {
        }

        static boolean isInLayout(View r0) {
            return r0.isInLayout();
        }
    }

    private static final class Api23Impl {
        private Api23Impl() {
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence r2, Layout.Alignment r3, int r4, int r5, TextView r6, TextPaint r7, Impl r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            StaticLayout.Builder r10 = StaticLayout.Builder.obtain(r9, 0, r9.length(), r7, r4);
            StaticLayout.Builder r11 = r10.setAlignment(r3).setLineSpacing(r6.getLineSpacingExtra(), r6.getLineSpacingMultiplier()).setIncludePad(r6.getIncludeFontPadding()).setBreakStrategy(r6.getBreakStrategy()).setHyphenationFrequency(r6.getHyphenationFrequency());
            if (r5 != (-1)) goto L5;
            r5 = Integer.MAX_VALUE;
        L5:
            r11.setMaxLines(r5);
            r8.computeAndSetTextDirection(r10, r6);     // Catch: ClassCastException -> L8
        L10:
            return r10.build();
        L8:
            Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            goto L10
        }
    }

    private static class Impl {
        Impl() {
        }

        void computeAndSetTextDirection(StaticLayout.Builder r1, TextView r2) {
        }

        boolean isHorizontallyScrollable(TextView r2) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r2, "getHorizontallyScrolling", false), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }
    }

    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder r2, TextView r3) {
            r2.setTextDirection((TextDirectionHeuristic) ZeusTransformUtils.preCheckCast(AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r3, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR), TextDirectionHeuristic.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder r1, TextView r2) {
            r1.setTextDirection(r2.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean isHorizontallyScrollable(TextView r1) {
            return r1.isHorizontallyScrollable();
        }
    }

    static {
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    AppCompatTextViewAutoSizeHelper(TextView r3) {
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = r3;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Impl r4 = new Impl29();
    L5:
        this.mImpl = r4;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        r4 = new Impl23();
        goto L5
    L9:
        r4 = new Impl();
        goto L5
    }

    private static <T> T accessAndReturnWithDefault(Object r2, String r3, T r4) {
        Field r0 = getTextViewField(r3);     // Catch: IllegalAccessException -> L7
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (T) r0.get(r2);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r3 + " member", e);
        return r4;
    }

    private int[] cleanupAutoSizePresetSizes(int[] r6) {
        int r5 = r6.length;
        if (r5 != 0) goto L5;
        return r6;
    L5:
        Arrays.sort(r6);
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L14;
        int r3 = r6[r2];
        if (r3 <= 0) goto L12;
        if (Collections.binarySearch(r0, Integer.valueOf(r3)) >= 0) goto L12;
        r0.add(Integer.valueOf(r3));
    L12:
        r2 = r2 + 1;
        goto L6
    L14:
        if (r5 != r0.size()) goto L16;
        return r6;
    L16:
        int r7 = r0.size();
        int[] r8 = new int[r7];
    L17:
        if (r1 >= r7) goto L19;
        r8[r1] = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r1), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r1 = r1 + 1;
        goto L17
    L19:
        return r8;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence r11, Layout.Alignment r12, int r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        float r7 = ((Float) ZeusTransformUtils.preCheckCast(accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f)), Float.class, "com.obric.memorydata.plugin")).floatValue();
        float r8 = ((Float) ZeusTransformUtils.preCheckCast(accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f)), Float.class, "com.obric.memorydata.plugin")).floatValue();
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(accessAndReturnWithDefault(this.mTextView, "mIncludePad", true), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return new StaticLayout(r3, this.mTempTextPaint, r13, r12, r7, r8, r9);
    }

    private int findLargestTextSizeWhichFits(RectF r6) {
        int r0 = this.mAutoSizeTextSizesInPx.length;
        if (r0 == 0) goto L14;
        int r1 = 0;
        int r2 = 1;
        int r3 = r0 - 1;
    L5:
        int r4 = r2;
        int r5 = r1;
        r1 = r4;
    L6:
        if (r1 > r3) goto L12;
        int r7 = (r1 + r3) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[r7], r6) == true) goto L9;
        r5 = r7 - 1;
        r3 = r5;
        goto L6
    L9:
        r2 = r7 + 1;
        goto L5
    L12:
        return this.mAutoSizeTextSizesInPx[r5];
    L14:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Field getTextViewField(String r3) {
        Field r0 = (Field) ZeusTransformUtils.preCheckCast(sTextViewFieldByNameCache.get(r3), Field.class, "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L8
        if (r0 != null) goto L7;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L8
        if (r0 == null) goto L7;
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        sTextViewFieldByNameCache.put(r3, r0);     // Catch: NoSuchFieldException -> L8
    L7:
        return r0;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to access TextView#" + r3 + " member", e);
        return null;
    }

    private static Method getTextViewMethod(String r3) {
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(sTextViewMethodByNameCache.get(r3), Method.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        if (r0 != null) goto L7;
        r0 = TextView.class.getDeclaredMethod(r3, new Class[0]);     // Catch: Exception -> L8
        if (r0 == null) goto L7;
        r0.setAccessible(true);     // Catch: Exception -> L8
        sTextViewMethodByNameCache.put(r3, r0);     // Catch: Exception -> L8
    L7:
        return r0;
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve TextView#" + r3 + "() method", e);
        return null;
    }

    static <T> T invokeAndReturnWithDefault(Object r4, String r5, T r6) {
    L15:
        return (T) getTextViewMethod(r5).invoke(r4, new Object[0]);
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to invoke TextView#" + r5 + "() method", e);     // Catch: Throwable -> L5
        return r6;
    L5:
        th = move-exception;
        throw th;
    }

    private void setRawTextSize(float r4) {
        if (r4 == this.mTextView.getPaint().getTextSize()) goto L24;
        this.mTextView.getPaint().setTextSize(r4);
        if (Build.VERSION.SDK_INT < 18) goto L7;
        boolean r5 = Api18Impl.isInLayout(this.mTextView);
    L9:
        if (this.mTextView.getLayout() == null) goto L25;
        this.mNeedsAutoSizeText = false;
        Method r0 = getTextViewMethod("nullLayouts");     // Catch: Exception -> L15
        if (r0 == null) goto L17;
        r0.invoke(this.mTextView, new Object[0]);     // Catch: Exception -> L15
    L17:
        if (r5 == true) goto L19;
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
        r5 = false;
        goto L9
    }

    private boolean setupAutoSizeText() {
        int r1 = 0;
        if (supportsAutoSizeText() == true) goto L5;
    L15:
        this.mNeedsAutoSizeText = false;
    L17:
        return this.mNeedsAutoSizeText;
    L5:
        if (this.mAutoSizeTextType != 1) goto L15;
        if (this.mHasPresetAutoSizeValues == true) goto L9;
    L10:
        int r0 = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
        int[] r3 = new int[r0];
    L11:
        if (r1 >= r0) goto L13;
        r3[r1] = Math.round(this.mAutoSizeMinTextSizeInPx + (r1 * this.mAutoSizeStepGranularityInPx));
        r1 = r1 + 1;
        goto L11
    L13:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r3);
    L14:
        this.mNeedsAutoSizeText = true;
        goto L17
    L9:
        if (this.mAutoSizeTextSizesInPx.length != 0) goto L14;
        goto L10
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray r5) {
        int r0 = r5.length();
        int[] r1 = new int[r0];
        if (r0 <= 0) goto L10;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r1[r2] = r5.getDimensionPixelSize(r2, -1);
        r2 = r2 + 1;
        goto L5
    L7:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r1);
        setupAutoSizeUniformPresetSizesConfiguration();
        return;
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] r0 = this.mAutoSizeTextSizesInPx;
        int r1 = r0.length;
        if (r1 <= 0) goto L5;
        boolean r4 = true;
    L6:
        this.mHasPresetAutoSizeValues = r4;
        if (r4 == false) goto L9;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r0[0];
        this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
        this.mAutoSizeStepGranularityInPx = -1.0f;
    L9:
        return r4;
    L5:
        r4 = false;
        goto L6
    }

    private boolean suggestedSizeFitsInSpace(int r6, RectF r7) {
        CharSequence r0 = this.mTextView.getText();
        TransformationMethod r1 = this.mTextView.getTransformationMethod();
        if (r1 == null) goto L8;
        CharSequence r2 = r1.getTransformation(r0, this.mTextView);
        if (r2 == null) goto L8;
        r0 = r2;
    L8:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        int r3 = Api16Impl.getMaxLines(this.mTextView);
    L11:
        initTempTextPaint(r6);
        StaticLayout r5 = createLayout(r0, (Layout.Alignment) ZeusTransformUtils.preCheckCast(invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Layout.Alignment.class, "com.obric.memorydata.plugin"), Math.round(r7.right), r3);
        if (r3 == (-1)) goto L19;
        if (r5.getLineCount() <= r3) goto L16;
    L17:
        return false;
    L16:
        if (r5.getLineEnd(r5.getLineCount() - 1) != r0.length()) goto L17;
    L19:
        if (r5.getHeight() <= r7.bottom) goto L21;
        return false;
    L21:
        return true;
    L10:
        r3 = -1;
        goto L11
    }

    private boolean supportsAutoSizeText() {
        return !ZeusTransformUtils.instanceOf(this.mTextView, AppCompatEditText.class);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float r4, float r5, float r6) {
        if (r4 <= 0.0f) goto L15;
        if (r5 <= r4) goto L13;
        if (r6 <= 0.0f) goto L11;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r4;
        this.mAutoSizeMaxTextSizeInPx = r5;
        this.mAutoSizeStepGranularityInPx = r6;
        this.mHasPresetAutoSizeValues = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r6 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r5 + "px) is less or equal to minimum auto-size text size (" + r4 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r4 + "px) is less or equal to (0px)");
    }

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
        int r0 = 1048576;
    L16:
        int r1 = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
        if (r0 <= 0) goto L35;
        if (r1 <= 0) goto L37;
        RectF r2 = TEMP_RECTF;
        monitor-enter(r2);
        r2.setEmpty();     // Catch: Throwable -> L27
        r2.right = r0;     // Catch: Throwable -> L27
        r2.bottom = r1;     // Catch: Throwable -> L27
        float r3 = findLargestTextSizeWhichFits(r2);     // Catch: Throwable -> L27
        if (r3 == this.mTextView.getTextSize()) goto L25;
        setTextSizeInternal(0, r3);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L37:
        return;
    L35:
        return;
    L15:
        r0 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
        goto L16
    }

    StaticLayout createLayout(CharSequence r8, Layout.Alignment r9, int r10, int r11) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.createStaticLayoutForMeasuring(r0, r9, r10, r11, this.mTextView, this.mTempTextPaint, this.mImpl);
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L11;
        return Api16Impl.createStaticLayoutForMeasuring(r0, r9, r10, this.mTextView, this.mTempTextPaint);
    L11:
        return createStaticLayoutForMeasuringPre16(r0, r9, r10);
    }

    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    void initTempTextPaint(int r3) {
        TextPaint r0 = this.mTempTextPaint;
        if (r0 != null) goto L5;
        this.mTempTextPaint = new TextPaint();
    L6:
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(r3);
        return;
    L5:
        r0.reset();
        goto L6
    }

    boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoSizeTextType == 0) goto L7;
        return true;
    }

    void loadFromAttributes(AttributeSet r11, int r12) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r13 = this.mContext.obtainStyledAttributes(r5, R.styleable.AppCompatTextView, r12, 0);
        TextView r2 = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(r2, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.AppCompatTextView, r5, r13, r12, 0);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeTextType, "styleable", "AppCompatTextView_autoSizeTextType")) == false) goto L6;
        this.mAutoSizeTextType = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeTextType, "styleable", "AppCompatTextView_autoSizeTextType"), 0);
    L6:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeStepGranularity, "styleable", "AppCompatTextView_autoSizeStepGranularity")) == false) goto L8;
        float r14 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeStepGranularity, "styleable", "AppCompatTextView_autoSizeStepGranularity"), -1.0f);
    L10:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMinTextSize, "styleable", "AppCompatTextView_autoSizeMinTextSize")) == false) goto L12;
        float r3 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMinTextSize, "styleable", "AppCompatTextView_autoSizeMinTextSize"), -1.0f);
    L14:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMaxTextSize, "styleable", "AppCompatTextView_autoSizeMaxTextSize")) == false) goto L16;
        float r4 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMaxTextSize, "styleable", "AppCompatTextView_autoSizeMaxTextSize"), -1.0f);
    L18:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizePresetSizes, "styleable", "AppCompatTextView_autoSizePresetSizes")) == false) goto L22;
        int r0 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizePresetSizes, "styleable", "AppCompatTextView_autoSizePresetSizes"), 0);
        if (r0 <= 0) goto L22;
        TypedArray r1 = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").obtainTypedArray(r0);
        setupAutoSizeUniformPresetSizes(r1);
        r1.recycle();
    L22:
        r13.recycle();
        if (supportsAutoSizeText() == true) goto L25;
        this.mAutoSizeTextType = 0;
        return;
    L25:
        if (this.mAutoSizeTextType == 1) goto L27;
        return;
    L27:
        if (this.mHasPresetAutoSizeValues == true) goto L38;
        DisplayMetrics r15 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r3 != (-1.0f)) goto L32;
        r3 = TypedValue.applyDimension(2, 12.0f, r15);
    L32:
        if (r4 != (-1.0f)) goto L35;
        r4 = TypedValue.applyDimension(2, 112.0f, r15);
    L35:
        if (r14 != (-1.0f)) goto L37;
        r14 = 1.0f;
    L37:
        validateAndSetAutoSizeTextTypeUniformConfiguration(r3, r4, r14);
    L38:
        setupAutoSizeText();
        return;
    L16:
        r4 = -1.0f;
        goto L18
    L12:
        r3 = -1.0f;
        goto L14
    L8:
        r14 = -1.0f;
        goto L10
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int r3, int r4, int r5, int r6) {
        if (supportsAutoSizeText() == false) goto L8;
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r6, r3, r0), TypedValue.applyDimension(r6, r4, r0), TypedValue.applyDimension(r6, r5, r0));
        if (setupAutoSizeText() == false) goto L9;
        autoSizeText();
        return;
    L9:
        return;
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] r6, int r7) {
        if (supportsAutoSizeText() == false) goto L23;
        int r0 = r6.length;
        int r1 = 0;
        if (r0 <= 0) goto L17;
        int[] r2 = new int[r0];
        if (r7 != 0) goto L9;
        r2 = Arrays.copyOf(r6, r0);
    L12:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r2);
        if (setupAutoSizeUniformPresetSizesConfiguration() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r6));
    L19:
        if (setupAutoSizeText() == false) goto L24;
        autoSizeText();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r3 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDisplayMetrics();
    L10:
        if (r1 >= r0) goto L12;
        r2[r1] = Math.round(TypedValue.applyDimension(r7, r6[r1], r3));
        r1 = r1 + 1;
        goto L10
    L17:
        this.mHasPresetAutoSizeValues = false;
        goto L19
    }

    void setAutoSizeTextTypeWithDefaults(int r4) {
        if (supportsAutoSizeText() == false) goto L14;
        if (r4 != 0) goto L6;
        clearAutoSizeConfiguration();
        return;
    L6:
        if (r4 != 1) goto L11;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, r5), TypedValue.applyDimension(2, 112.0f, r5), 1.0f);
        if (setupAutoSizeText() == false) goto L15;
        autoSizeText();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("Unknown auto-size text type: " + r4);
    }

    void setTextSizeInternal(int r3, float r4) {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        Resources r1 = Resources.getSystem();
    L6:
        setRawTextSize(TypedValue.applyDimension(r3, r4, r1.getDisplayMetrics()));
        return;
    L5:
        r1 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin");
        goto L6
    }
}
