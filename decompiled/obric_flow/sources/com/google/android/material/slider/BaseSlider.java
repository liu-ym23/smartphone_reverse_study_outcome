package com.google.android.material.slider;

import ai.j0;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 117;
    static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = 0;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = 0;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = 0;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = 0;

    @Dimension(unit = 0)
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final float THUMB_WIDTH_PRESSED_RATIO = 0.5f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @NonNull
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final List<L> changeListeners;

    @NonNull
    private final RectF cornerRect;

    @Nullable
    private Drawable customThumbDrawable;

    @NonNull
    private List<Drawable> customThumbDrawablesForValues;

    @NonNull
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private int defaultThumbTrackGapSize;
    private int defaultThumbWidth;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackHeight;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;
    private int labelStyle;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTickSpacing;

    @Px
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetHeight;

    @NonNull
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @NonNull
    private final Paint stopIndicatorPaint;
    private int thumbHeight;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbTrackGapSize;
    private int thumbWidth;
    private int tickActiveRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackInsideCornerSize;

    @NonNull
    private final Path trackPath;

    @NonNull
    private final RectF trackRect;
    private int trackSidePadding;
    private int trackStopIndicatorSize;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection = null;

        static {
            int[] r5 = new int[FullCornerDirection.values().length];
            $SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection = r5;
            r5[FullCornerDirection.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection[FullCornerDirection.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection[FullCornerDirection.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection[FullCornerDirection.BOTH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class AccessibilityEventSender implements Runnable {
        final /* synthetic */ BaseSlider this$0;
        int virtualViewId;

        private AccessibilityEventSender(BaseSlider r5) {
            this.this$0 = r5;
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$200(this.this$0).sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int r5) {
            this.virtualViewId = r5;
        }

        public /* synthetic */ AccessibilityEventSender(BaseSlider r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> r5) {
            super(r5);
            this.virtualViewBounds = new Rect();
            this.slider = r5;
        }

        @NonNull
        private String startOrEndDescription(int r5) {
            if (r5 == (this.slider.getValues().size() - 1)) goto L5;
            if (r5 == 0) goto L8;
            return "";
        L8:
            return this.slider.getContext().getString(R.string.material_slider_range_start);
        L5:
            return this.slider.getContext().getString(R.string.material_slider_range_end);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r5, float r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.slider.getValues().size()) goto L9;
            this.slider.updateBoundsForVirtualViewId(r11, this.virtualViewBounds);
            if (this.virtualViewBounds.contains((int) r5, (int) r10) == true) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return r11;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> r5) {
            int r10 = 0;
        L4:
            if (r10 >= this.slider.getValues().size()) goto L6;
            r5.add(Integer.valueOf(r10));
            r10 = r10 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r5, int r10, Bundle r11) {
            if (this.slider.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r10 == 4096) goto L20;
            if (r10 == 8192) goto L20;
            if (r10 == 16908349) goto L11;
            return false;
        L11:
            if (r11 != null) goto L13;
        L19:
            return false;
        L13:
            if (r11.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) == false) goto L19;
            float r12 = r11.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
            if (BaseSlider.access$500(this.slider, r5, r12) == false) goto L19;
            BaseSlider.access$600(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r5);
            return true;
        L20:
            float r13 = BaseSlider.access$700(this.slider, 20);
            if (r10 != 8192) goto L24;
            r13 = -r13;
        L24:
            if (this.slider.isRtl() == false) goto L26;
            r13 = -r13;
        L26:
            float r14 = MathUtils.clamp(this.slider.getValues().get(r5).floatValue() + r13, this.slider.getValueFrom(), this.slider.getValueTo());
            if (BaseSlider.access$500(this.slider, r5, r14) == false) goto L30;
            BaseSlider.access$600(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r5);
            return true;
        L30:
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r10, AccessibilityNodeInfoCompat r11) {
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> r5 = this.slider.getValues();
            float r12 = r5.get(r10).floatValue();
            float r13 = this.slider.getValueFrom();
            float r14 = this.slider.getValueTo();
            if (this.slider.isEnabled() == true) goto L5;
        L10:
            r11.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, r13, r14, r12));
            r11.setClassName(SeekBar.class.getName());
            StringBuilder r15 = new StringBuilder();
            if (this.slider.getContentDescription() == null) goto L13;
            r15.append(this.slider.getContentDescription());
            r15.append(",");
        L13:
            String r16 = BaseSlider.access$400(this.slider, r12);
            String r17 = this.slider.getContext().getString(R.string.material_slider_value);
            if (r5.size() <= 1) goto L16;
            r17 = startOrEndDescription(r10);
        L16:
            Locale r18 = Locale.US;
            r15.append(r17 + ", " + r16);
            r11.setContentDescription(r15.toString());
            this.slider.updateBoundsForVirtualViewId(r10, this.virtualViewBounds);
            r11.setBoundsInParent(this.virtualViewBounds);
            return;
        L5:
            if (r12 <= r13) goto L8;
            r11.addAction(8192);
        L8:
            if (r12 >= r14) goto L10;
            r11.addAction(4096);
            goto L10
        }
    }

    public static final enum FullCornerDirection extends Enum<FullCornerDirection> {
        private static final /* synthetic */ FullCornerDirection[] $VALUES = null;
        public static final FullCornerDirection BOTH = null;
        public static final FullCornerDirection LEFT = null;
        public static final FullCornerDirection NONE = null;
        public static final FullCornerDirection RIGHT = null;

        static {
            FullCornerDirection r5 = new FullCornerDirection("BOTH", 0);
            BOTH = r5;
            FullCornerDirection r10 = new FullCornerDirection("LEFT", 1);
            LEFT = r10;
            FullCornerDirection r11 = new FullCornerDirection("RIGHT", 2);
            RIGHT = r11;
            FullCornerDirection r12 = new FullCornerDirection("NONE", 3);
            NONE = r12;
            $VALUES = new FullCornerDirection[]{r5, r10, r11, r12};
        }

        private FullCornerDirection(String r5, int r10) {
            super(r5, r10);
        }

        public static FullCornerDirection valueOf(String r5) {
            return (FullCornerDirection) Enum.valueOf(FullCornerDirection.class, r5);
        }

        public static FullCornerDirection[] values() {
            return (FullCornerDirection[]) $VALUES.clone();
        }
    }

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        static {
            CREATOR = new AnonymousClass1();
        }

        public /* synthetic */ SliderState(Parcel r5, AnonymousClass1 r10) {
            this(r5);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeFloat(this.valueFrom);
            r5.writeFloat(this.valueTo);
            r5.writeList(this.values);
            r5.writeFloat(this.stepSize);
            r5.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable r5) {
            super(r5);
        }

        private SliderState(@NonNull Parcel r5) {
            super(r5);
            this.valueFrom = r5.readFloat();
            this.valueTo = r5.readFloat();
            ArrayList<Float> r10 = new ArrayList();
            this.values = r10;
            r5.readList(r10, Float.class.getClassLoader());
            this.stepSize = r5.readFloat();
            this.hasFocus = r5.createBooleanArray()[0];
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
        LABEL_ANIMATION_ENTER_DURATION_ATTR = R.attr.motionDurationMedium4;
        LABEL_ANIMATION_EXIT_DURATION_ATTR = R.attr.motionDurationShort3;
        LABEL_ANIMATION_ENTER_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
        LABEL_ANIMATION_EXIT_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    }

    public BaseSlider(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(BaseSlider r5) {
        r5.updateLabels();
    }

    public static /* synthetic */ List access$000(BaseSlider r5) {
        return r5.labels;
    }

    public static /* synthetic */ AccessibilityHelper access$200(BaseSlider r5) {
        return r5.accessibilityHelper;
    }

    public static /* synthetic */ String access$400(BaseSlider r5, float r10) {
        return r5.formatValue(r10);
    }

    public static /* synthetic */ boolean access$500(BaseSlider r5, int r10, float r11) {
        return r5.snapThumbToValue(r10, r11);
    }

    public static /* synthetic */ void access$600(BaseSlider r5) {
        r5.updateHaloHotspot();
    }

    public static /* synthetic */ float access$700(BaseSlider r5, int r10) {
        return r5.calculateStepIncrement(r10);
    }

    private void adjustCustomThumbDrawableBounds(Drawable r5) {
        int r10 = r5.getIntrinsicWidth();
        int r11 = r5.getIntrinsicHeight();
        if (r10 != (-1)) goto L6;
        if (r11 != (-1)) goto L6;
        r5.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        return;
    L6:
        float r12 = Math.max(this.thumbWidth, this.thumbHeight) / Math.max(r10, r11);
        r5.setBounds(0, 0, (int) (r10 * r12), (int) (r11 * r12));
    }

    private void attachLabelToContentView(TooltipDrawable r5) {
        r5.setRelativeToView(ViewUtils.getContentView(this));
    }

    @Nullable
    private Float calculateIncrementForKey(int r5) {
        if (this.isLongPress == false) goto L5;
        float r10 = calculateStepIncrement(20);
    L7:
        if (r5 == 21) goto L28;
        if (r5 == 22) goto L23;
        if (r5 == 69) goto L21;
        if (r5 == 70) goto L19;
        if (r5 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r10);
    L21:
        return Float.valueOf(-r10);
    L23:
        if (isRtl() == false) goto L26;
        r10 = -r10;
    L26:
        return Float.valueOf(r10);
    L28:
        if (isRtl() == true) goto L32;
        r10 = -r10;
    L32:
        return Float.valueOf(r10);
    L5:
        r10 = calculateStepIncrement();
        goto L7
    }

    private float calculateStepIncrement() {
        float r5 = this.stepSize;
        if (r5 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r5;
    }

    private int calculateTrackCenter() {
        int r5 = this.widgetHeight / 2;
        int r10 = 0;
        if (this.labelBehavior != 1) goto L5;
    L6:
        r10 = this.labels.get(0).getIntrinsicHeight();
    L8:
        return r5 + r10;
    L5:
        if (shouldAlwaysShowLabel() == false) goto L8;
        goto L6
    }

    private ValueAnimator createLabelAnimator(boolean r5) {
        float r10 = 1.0f;
        if (r5 == false) goto L5;
        float r11 = 0.0f;
    L6:
        if (r5 == false) goto L8;
        ValueAnimator r12 = this.labelsOutAnimator;
    L9:
        float r13 = getAnimatorCurrentValueOrDefault(r12, r11);
        if (r5 == true) goto L13;
        r10 = 0.0f;
    L13:
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{r13, r10});
        if (r5 == false) goto L16;
        int r15 = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_ENTER_DURATION_ATTR, 83);
        TimeInterpolator r16 = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
    L17:
        r14.setDuration(r15);
        r14.setInterpolator(r16);
        r14.addUpdateListener(new AnonymousClass1(this));
        return r14;
    L16:
        r15 = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_EXIT_DURATION_ATTR, 117);
        r16 = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        goto L17
    L8:
        r12 = this.labelsInAnimator;
        goto L9
    L5:
        r11 = 1.0f;
        goto L6
    }

    private void createLabelPool() {
        if (this.labels.size() <= this.values.size()) goto L11;
        List<TooltipDrawable> r5 = this.labels.subList(this.values.size(), this.labels.size());
        Iterator<TooltipDrawable> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        TooltipDrawable r11 = r10.next();
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        detachLabelFromContentView(r11);
        goto L6
    L10:
        r5.clear();
    L11:
        int r12 = 0;
        if (this.labels.size() >= this.values.size()) goto L17;
        TooltipDrawable r13 = TooltipDrawable.createFromAttributes(getContext(), null, 0, this.labelStyle);
        this.labels.add(r13);
        if (ViewCompat.isAttachedToWindow(this) == false) goto L11;
        attachLabelToContentView(r13);
        goto L11
    L17:
        if (this.labels.size() == 1) goto L20;
        r12 = 1;
    L20:
        Iterator<TooltipDrawable> r14 = this.labels.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        r14.next().setStrokeWidth(r12);
        goto L22
    }

    private void detachLabelFromContentView(TooltipDrawable r5) {
        ViewOverlayImpl r10 = ViewUtils.getContentViewOverlay(this);
        if (r10 == null) goto L6;
        r10.remove(r5);
        r5.detachView(ViewUtils.getContentView(this));
        return;
    }

    private float dimenToValue(float r5) {
        if (r5 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r10 = (r5 - this.trackSidePadding) / this.trackWidth;
        float r11 = this.valueFrom;
        return j0.b(r11, this.valueTo, r10, r11);
    }

    private void dispatchOnChangedFromUser(int r5) {
        Iterator<L> r10 = this.changeListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onValueChange(this, this.values.get(r5).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r11 = this.accessibilityManager;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isEnabled() == false) goto L14;
        scheduleAccessibilityEventSender(r5);
        return;
    }

    private void dispatchOnChangedProgrammatically() {
        Iterator<L> r5 = this.changeListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        L r10 = r5.next();
        Iterator<Float> r11 = this.values.iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        r10.onValueChange(this, r11.next().floatValue(), false);
        goto L7
    }

    private void drawActiveTrack(@NonNull Canvas r12, int r13, int r14) {
        float[] r5 = getActiveRange();
        int r10 = this.trackSidePadding;
        float r15 = r13;
        float r11 = (r5[1] * r15) + r10;
        int r16 = 0;
        float r17 = (r5[0] * r15) + r10;
        if (hasGapBetweenThumbAndTrack() == false) goto L36;
        FullCornerDirection r18 = FullCornerDirection.NONE;
        if (this.values.size() != 1) goto L11;
        if (isRtl() == false) goto L9;
        r18 = FullCornerDirection.RIGHT;
        goto L11
    L9:
        r18 = FullCornerDirection.LEFT;
    L11:
        if (r16 >= this.values.size()) goto L42;
        if (this.values.size() <= 1) goto L20;
        if (r16 <= 0) goto L16;
        r17 = valueToX(this.values.get(r16 - 1).floatValue());
    L16:
        float r19 = valueToX(this.values.get(r16).floatValue());
        if (isRtl() == false) goto L19;
        r11 = r17;
        r17 = r19;
        goto L20
    L19:
        r11 = r19;
    L20:
        int r20 = AnonymousClass3.$SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection[r18.ordinal()];
        if (r20 != 1) goto L23;
        int r21 = this.thumbTrackGapSize;
        r17 = r17 + r21;
    L29:
        r11 = r11 - r21;
    L32:
        if (r17 >= r11) goto L35;
        RectF r22 = this.trackRect;
        float r23 = r14;
        int r24 = this.trackHeight;
        r22.set(r17, r23 - (r24 / 2.0f), r11, (r24 / 2.0f) + r23);
        updateTrack(r12, this.activeTrackPaint, this.trackRect, r18);
    L35:
        r16 = r16 + 1;
        goto L11
    L23:
        if (r20 != 2) goto L25;
        r17 = r17 - (this.trackHeight / 2.0f);
        r21 = this.thumbTrackGapSize;
        goto L29
    L25:
        if (r20 != 3) goto L32;
        r17 = r17 + this.thumbTrackGapSize;
        r11 = (this.trackHeight / 2.0f) + r11;
        goto L32
    L42:
        return;
    L36:
        this.activeTrackPaint.setStyle(Paint.Style.STROKE);
        this.activeTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        float r25 = r14;
        r12.drawLine(r17, r25, r11, r25, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@NonNull Canvas r12, int r13, int r14) {
        float[] r5 = getActiveRange();
        int r10 = this.trackSidePadding;
        float r11 = r13;
        float r15 = (r5[1] * r11) + r10;
        if (r15 < (r10 + r13)) goto L5;
    L8:
        int r16 = this.trackSidePadding;
        float r17 = (r5[0] * r11) + r16;
        if (r17 > r16) goto L11;
        return;
    L11:
        if (hasGapBetweenThumbAndTrack() == false) goto L13;
        RectF r18 = this.trackRect;
        float r19 = this.trackSidePadding;
        int r20 = this.trackHeight;
        float r110 = r14;
        r18.set(r19 - (r20 / 2.0f), r110 - (r20 / 2.0f), r17 - this.thumbTrackGapSize, (r20 / 2.0f) + r110);
        updateTrack(r12, this.inactiveTrackPaint, this.trackRect, FullCornerDirection.LEFT);
        return;
    L13:
        this.inactiveTrackPaint.setStyle(Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        float r21 = r14;
        r12.drawLine(this.trackSidePadding, r21, r17, r21, this.inactiveTrackPaint);
        return;
    L5:
        if (hasGapBetweenThumbAndTrack() == false) goto L7;
        RectF r22 = this.trackRect;
        float r23 = r15 + this.thumbTrackGapSize;
        float r24 = r14;
        int r25 = this.trackHeight;
        r22.set(r23, r24 - (r25 / 2.0f), (r25 / 2.0f) + (this.trackSidePadding + r13), (r25 / 2.0f) + r24);
        updateTrack(r12, this.inactiveTrackPaint, this.trackRect, FullCornerDirection.RIGHT);
        goto L8
    L7:
        this.inactiveTrackPaint.setStyle(Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        float r26 = r14;
        r12.drawLine(r15, r26, this.trackSidePadding + r13, r26, this.inactiveTrackPaint);
        goto L8
    }

    private void drawThumbDrawable(@NonNull Canvas r5, int r10, int r11, float r12, @NonNull Drawable r13) {
        r5.save();
        r5.translate((this.trackSidePadding + ((int) (normalizeValue(r12) * r10))) - (r13.getBounds().width() / 2.0f), r11 - (r13.getBounds().height() / 2.0f));
        r13.draw(r5);
        r5.restore();
    }

    private void drawThumbs(@NonNull Canvas r10, int r11, int r12) {
        int r5 = 0;
    L4:
        if (r5 >= this.values.size()) goto L16;
        float r13 = this.values.get(r5).floatValue();
        Drawable r14 = this.customThumbDrawable;
        if (r14 == null) goto L9;
        drawThumbDrawable(r10, r11, r12, r13, r14);
    L15:
        r5 = r5 + 1;
        goto L4
    L9:
        if (r5 >= this.customThumbDrawablesForValues.size()) goto L12;
        drawThumbDrawable(r10, r11, r12, r13, this.customThumbDrawablesForValues.get(r5));
        goto L15
    L12:
        if (isEnabled() == true) goto L14;
        r10.drawCircle((normalizeValue(r13) * r11) + this.trackSidePadding, r12, getThumbRadius(), this.thumbPaint);
    L14:
        drawThumbDrawable(r10, r11, r12, r13, this.defaultThumbDrawable);
        goto L15
    }

    private void ensureLabelsAdded() {
        if (this.labelsAreAnimatedIn == true) goto L5;
        this.labelsAreAnimatedIn = true;
        ValueAnimator r5 = createLabelAnimator(true);
        this.labelsInAnimator = r5;
        this.labelsOutAnimator = null;
        r5.start();
    L5:
        Iterator<TooltipDrawable> r10 = this.labels.iterator();
        int r11 = 0;
    L7:
        if (r11 >= this.values.size()) goto L16;
        if (r10.hasNext() == false) goto L16;
        if (r11 == this.focusedThumbIdx) goto L14;
        setValueForLabel(r10.next(), this.values.get(r11).floatValue());
    L14:
        r11 = r11 + 1;
    L16:
        if (r10.hasNext() == false) goto L20;
        setValueForLabel(r10.next(), this.values.get(this.focusedThumbIdx).floatValue());
        return;
    L20:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn == false) goto L6;
        this.labelsAreAnimatedIn = false;
        ValueAnimator r5 = createLabelAnimator(false);
        this.labelsOutAnimator = r5;
        this.labelsInAnimator = null;
        r5.addListener(new AnonymousClass2(this));
        this.labelsOutAnimator.start();
        return;
    }

    private void focusThumbOnFocusGained(int r5) {
        if (r5 != 1) goto L5;
        moveFocus(Integer.MAX_VALUE);
        return;
    L5:
        if (r5 != 2) goto L7;
        moveFocus(Integer.MIN_VALUE);
        return;
    L7:
        if (r5 != 17) goto L9;
        moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        return;
    L9:
        if (r5 != 66) goto L19;
        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        return;
    }

    private String formatValue(float r5) {
        if (hasLabelFormatter() == false) goto L7;
        return this.formatter.getFormattedValue(r5);
    L7:
        if (((int) r5) != r5) goto L9;
        String r10 = "%.0f";
    L11:
        return String.format(r10, new Object[]{Float.valueOf(r5)});
    L9:
        r10 = "%.2f";
        goto L11
    }

    private float[] getActiveRange() {
        float r5 = this.values.get(0).floatValue();
        float r10 = ((Float) androidx.constraintlayout.motion.widget.a.h(this.values, 1)).floatValue();
        if (this.values.size() != 1) goto L5;
        r5 = this.valueFrom;
    L5:
        float r11 = normalizeValue(r5);
        float r12 = normalizeValue(r10);
        if (isRtl() == false) goto L9;
        return new float[]{r12, r11};
    L9:
        return new float[]{r11, r12};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator r5, float r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r5.isRunning() == false) goto L8;
        float r11 = ((Float) r5.getAnimatedValue()).floatValue();
        r5.cancel();
        return r11;
    L8:
        return r10;
    }

    private float getClampedValue(int r5, float r10) {
        float r11 = getMinSeparation();
        if (this.separationUnit != 0) goto L6;
        r11 = dimenToValue(r11);
    L6:
        if (isRtl() == false) goto L8;
        r11 = -r11;
    L8:
        int r12 = r5 + 1;
        if (r12 < this.values.size()) goto L11;
        float r13 = this.valueTo;
    L12:
        int r14 = r5 - 1;
        if (r14 >= 0) goto L15;
        float r15 = this.valueFrom;
    L17:
        return MathUtils.clamp(r10, r15, r13);
    L15:
        r15 = this.values.get(r14).floatValue() + r11;
        goto L17
    L11:
        r13 = this.values.get(r12).floatValue() - r11;
        goto L12
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList r5) {
        return r5.getColorForState(getDrawableState(), r5.getDefaultColor());
    }

    private float[] getCornerRadii(float r5, float r10) {
        return new float[]{r5, r5, r10, r10, r10, r10, r5, r5};
    }

    private float getValueOfTouchPosition() {
        double r5 = snapPosition(this.touchPosition);
        if (isRtl() == false) goto L5;
        r5 = 1.0d - r5;
    L5:
        float r10 = this.valueTo;
        float r11 = this.valueFrom;
        return (float) ((r5 * ((double) (r10 - r11))) + ((double) r11));
    }

    private float getValueOfTouchPositionAbsolute() {
        float r5 = this.touchPosition;
        if (isRtl() == false) goto L5;
        r5 = 1.0f - r5;
    L5:
        float r10 = this.valueTo;
        float r11 = this.valueFrom;
        return j0.b(r10, r11, r5, r11);
    }

    private boolean hasGapBetweenThumbAndTrack() {
        if (this.thumbTrackGapSize <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private Drawable initializeCustomThumbDrawable(Drawable r5) {
        Drawable r10 = r5.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(r10);
        return r10;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent r5 = getParent();
    L4:
        if ((r5 instanceof ViewGroup) == false) goto L13;
        ViewGroup r10 = (ViewGroup) r5;
        if (r10.canScrollVertically(1) == true) goto L10;
        if (r10.canScrollVertically(-1) == true) goto L10;
    L12:
        r5 = r5.getParent();
    L10:
        if (r10.shouldDelayChildPressedState() == false) goto L12;
        return true;
    L13:
        return false;
    }

    private static boolean isMouseEvent(MotionEvent r5) {
        if (r5.getToolType(0) != 3) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isMultipleOfStepSize(double r5) {
        double r10 = new BigDecimal(Double.toString(r5)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r10) - r10) >= THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isPotentialVerticalScroll(MotionEvent r5) {
        if (isMouseEvent(r5) == false) goto L5;
    L7:
        return false;
    L5:
        if (isInVerticalScrollingContainer() == false) goto L7;
        return true;
    }

    private boolean isSliderVisibleOnScreen() {
        Rect r5 = new Rect();
        ViewUtils.getContentView(this).getHitRect(r5);
        return getLocalVisibleRect(r5);
    }

    private void loadResources(@NonNull Resources r5) {
        this.minWidgetHeight = r5.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int r10 = r5.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = r10;
        this.trackSidePadding = r10;
        this.defaultThumbRadius = r5.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackHeight = r5.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.defaultTickActiveRadius = r5.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.defaultTickInactiveRadius = r5.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.minTickSpacing = r5.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.labelPadding = r5.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        validateConfigurationIfDirty();
        int r5 = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / this.minTickSpacing) + 1);
        float[] r10 = this.ticksCoordinates;
        if (r10 != null) goto L8;
    L9:
        this.ticksCoordinates = new float[r5 * 2];
    L10:
        float r11 = this.trackWidth / (r5 - 1);
        int r12 = 0;
    L12:
        if (r12 >= (r5 * 2)) goto L14;
        float[] r13 = this.ticksCoordinates;
        r13[r12] = ((r12 / 2.0f) * r11) + this.trackSidePadding;
        r13[r12 + 1] = calculateTrackCenter();
        r12 = r12 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r10.length == (r5 * 2)) goto L10;
        goto L9
    }

    private void maybeDrawCompatHalo(@NonNull Canvas r5, int r10, int r11) {
        if (shouldDrawCompatHalo() == false) goto L6;
        r5.drawCircle((int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * r10) + this.trackSidePadding), r11, this.haloRadius, this.haloPaint);
        return;
    }

    private void maybeDrawStopIndicator(@NonNull Canvas r5, int r10) {
        if (this.trackStopIndicatorSize > 0) goto L6;
        return;
    L6:
        if (this.values.size() < 1) goto L11;
        float r11 = ((Float) androidx.constraintlayout.motion.widget.a.h(this.values, 1)).floatValue();
        float r12 = this.valueTo;
        if (r11 >= r12) goto L11;
        r5.drawPoint(valueToX(r12), r10, this.stopIndicatorPaint);
    L11:
        if (this.values.size() <= 1) goto L16;
        float r13 = this.values.get(0).floatValue();
        float r14 = this.valueFrom;
        if (r13 <= r14) goto L17;
        r5.drawPoint(valueToX(r14), r10, this.stopIndicatorPaint);
        return;
    L17:
        return;
    }

    private void maybeDrawTicks(@NonNull Canvas r10) {
        if (this.tickVisible == true) goto L5;
        return;
    L5:
        if (this.stepSize <= 0.0f) goto L18;
        float[] r5 = getActiveRange();
        int r11 = (int) Math.ceil(((this.ticksCoordinates.length / 2.0f) - 1.0f) * r5[0]);
        int r12 = (int) Math.floor(((this.ticksCoordinates.length / 2.0f) - 1.0f) * r5[1]);
        if (r11 <= 0) goto L10;
        r10.drawPoints(this.ticksCoordinates, 0, r11 * 2, this.inactiveTicksPaint);
    L10:
        if (r11 > r12) goto L12;
        r10.drawPoints(this.ticksCoordinates, r11 * 2, ((r12 - r11) + 1) * 2, this.activeTicksPaint);
    L12:
        int r13 = (r12 + 1) * 2;
        float[] r14 = this.ticksCoordinates;
        if (r13 >= r14.length) goto L17;
        r10.drawPoints(r14, r13, r14.length - r13, this.inactiveTicksPaint);
        return;
    L17:
        return;
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int r5 = Math.max((this.thumbWidth / 2) - this.defaultThumbRadius, 0);
        int r10 = Math.max((this.trackHeight - this.defaultTrackHeight) / 2, 0);
        int r11 = Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0);
        int r12 = Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0);
        int r13 = this.minTrackSidePadding;
        int r14 = Math.max(Math.max(r5, r10), Math.max(r11, r12)) + r13;
        if (this.trackSidePadding != r14) goto L5;
        return false;
    L5:
        this.trackSidePadding = r14;
        if (ViewCompat.isLaidOut(this) == false) goto L10;
        updateTrackWidth(getWidth());
        return true;
    L10:
        return true;
    }

    private boolean maybeIncreaseWidgetHeight() {
        int r5 = getPaddingTop();
        int r10 = getPaddingBottom() + r5;
        int r11 = this.trackHeight + r10;
        int r12 = this.thumbHeight;
        int r13 = getPaddingTop() + r12;
        int r14 = getPaddingBottom() + r13;
        int r15 = Math.max(this.minWidgetHeight, Math.max(r11, r14));
        if (r15 != this.widgetHeight) goto L6;
        return false;
    L6:
        this.widgetHeight = r15;
        return true;
    }

    private boolean moveFocus(int r12) {
        int r5 = this.focusedThumbIdx;
        int r13 = (int) MathUtils.clamp(((long) r5) + ((long) r12), 0, this.values.size() - 1);
        this.focusedThumbIdx = r13;
        if (r13 != r5) goto L7;
        return false;
    L7:
        if (this.activeThumbIdx == (-1)) goto L9;
        this.activeThumbIdx = r13;
    L9:
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int r5) {
        if (isRtl() == false) goto L9;
        if (r5 != Integer.MIN_VALUE) goto L7;
        r5 = Integer.MAX_VALUE;
        goto L9
    L7:
        r5 = -r5;
    L9:
        return moveFocus(r5);
    }

    private float normalizeValue(float r5) {
        float r10 = this.valueFrom;
        float r11 = (r5 - r10) / (this.valueTo - r10);
        if (isRtl() == true) goto L5;
        return r11;
    L5:
        return 1.0f - r11;
    }

    @Nullable
    private Boolean onKeyDownNoActiveThumb(int r5, @NonNull KeyEvent r10) {
        if (r5 == 61) goto L26;
        if (r5 != 66) goto L7;
    L23:
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    L7:
        if (r5 != 81) goto L9;
    L21:
        moveFocus(1);
        return Boolean.TRUE;
    L9:
        if (r5 != 69) goto L11;
        moveFocus(-1);
        return Boolean.TRUE;
    L11:
        if (r5 == 70) goto L21;
        switch(r5) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        moveFocusInAbsoluteDirection(1);
        return Boolean.TRUE;
    L17:
        moveFocusInAbsoluteDirection(-1);
        return Boolean.TRUE;
    L26:
        if (r10.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(moveFocus(1));
    L30:
        if (r10.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(moveFocus(-1));
    L34:
        return Boolean.FALSE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> r5 = this.touchListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onStartTrackingTouch(this);
        goto L4
    }

    private void onStopTrackingTouch() {
        Iterator<T> r5 = this.touchListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onStopTrackingTouch(this);
        goto L4
    }

    private void positionLabel(TooltipDrawable r5, float r10) {
        int r11 = (this.trackSidePadding + ((int) (normalizeValue(r10) * this.trackWidth))) - (r5.getIntrinsicWidth() / 2);
        int r12 = calculateTrackCenter() - ((this.thumbHeight / 2) + this.labelPadding);
        r5.setBounds(r11, r12 - r5.getIntrinsicHeight(), r5.getIntrinsicWidth() + r11, r12);
        Rect r13 = new Rect(r5.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, r13);
        r5.setBounds(r13);
    }

    private void processAttributes(Context r10, AttributeSet r11, int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.Slider, r12, DEF_STYLE_RES, new int[0]);
        this.labelStyle = r13.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = r13.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = r13.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(new Float[]{Float.valueOf(this.valueFrom)});
        this.stepSize = r13.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.minTouchTargetSize = (int) Math.ceil(r13.getDimension(R.styleable.Slider_minTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        boolean r14 = r13.hasValue(R.styleable.Slider_trackColor);
        if (r14 == false) goto L5;
        int r5 = R.styleable.Slider_trackColor;
    L6:
        if (r14 == false) goto L8;
        int r15 = R.styleable.Slider_trackColor;
    L9:
        ColorStateList r16 = MaterialResources.getColorStateList(r10, r13, r5);
        if (r16 != null) goto L13;
        r16 = AppCompatResources.getColorStateList(r10, R.color.material_slider_inactive_track_color);
    L13:
        setTrackInactiveTintList(r16);
        ColorStateList r17 = MaterialResources.getColorStateList(r10, r13, r15);
        if (r17 != null) goto L17;
        r17 = AppCompatResources.getColorStateList(r10, R.color.material_slider_active_track_color);
    L17:
        setTrackActiveTintList(r17);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(r10, r13, R.styleable.Slider_thumbColor));
        if (r13.hasValue(R.styleable.Slider_thumbStrokeColor) == false) goto L20;
        setThumbStrokeColor(MaterialResources.getColorStateList(r10, r13, R.styleable.Slider_thumbStrokeColor));
    L20:
        setThumbStrokeWidth(r13.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList r18 = MaterialResources.getColorStateList(r10, r13, R.styleable.Slider_haloColor);
        if (r18 != null) goto L24;
        r18 = AppCompatResources.getColorStateList(r10, R.color.material_slider_halo_color);
    L24:
        setHaloTintList(r18);
        this.tickVisible = r13.getBoolean(R.styleable.Slider_tickVisible, true);
        boolean r19 = r13.hasValue(R.styleable.Slider_tickColor);
        if (r19 == false) goto L27;
        int r20 = R.styleable.Slider_tickColor;
    L28:
        if (r19 == false) goto L30;
        int r110 = R.styleable.Slider_tickColor;
    L31:
        ColorStateList r21 = MaterialResources.getColorStateList(r10, r13, r20);
        if (r21 != null) goto L35;
        r21 = AppCompatResources.getColorStateList(r10, R.color.material_slider_inactive_tick_marks_color);
    L35:
        setTickInactiveTintList(r21);
        ColorStateList r111 = MaterialResources.getColorStateList(r10, r13, r110);
        if (r111 != null) goto L39;
        r111 = AppCompatResources.getColorStateList(r10, R.color.material_slider_active_tick_marks_color);
    L39:
        setTickActiveTintList(r111);
        setThumbTrackGapSize(r13.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(r13.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackInsideCornerSize(r13.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        int r22 = r13.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0) * 2;
        int r112 = r13.getDimensionPixelSize(R.styleable.Slider_thumbWidth, r22);
        int r23 = r13.getDimensionPixelSize(R.styleable.Slider_thumbHeight, r22);
        setThumbWidth(r112);
        setThumbHeight(r23);
        setHaloRadius(r13.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(r13.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(r13.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(r13.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.trackStopIndicatorSize / 2));
        setTickInactiveRadius(r13.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.trackStopIndicatorSize / 2));
        setLabelBehavior(r13.getInt(R.styleable.Slider_labelBehavior, 0));
        if (r13.getBoolean(R.styleable.Slider_android_enabled, true) == true) goto L42;
        setEnabled(false);
    L42:
        r13.recycle();
        return;
    L30:
        r110 = R.styleable.Slider_tickColorActive;
        goto L31
    L27:
        r20 = R.styleable.Slider_tickColorInactive;
        goto L28
    L8:
        r15 = R.styleable.Slider_trackColorActive;
        goto L9
    L5:
        r5 = R.styleable.Slider_trackColorInactive;
        goto L6
    }

    private void scheduleAccessibilityEventSender(int r5) {
        BaseSlider<S, L, T>.AccessibilityEventSender r10 = this.accessibilityEventSender;
        if (r10 != null) goto L5;
        this.accessibilityEventSender = new AccessibilityEventSender(this, null);
    L6:
        this.accessibilityEventSender.setVirtualViewId(r5);
        postDelayed(this.accessibilityEventSender, 200);
        return;
    L5:
        removeCallbacks(r10);
        goto L6
    }

    private void setValueForLabel(TooltipDrawable r5, float r10) {
        r5.setText(formatValue(r10));
        positionLabel(r5, r10);
        ViewUtils.getContentViewOverlay(this).add(r5);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> r5) {
        if (r5.isEmpty() == true) goto L12;
        Collections.sort(r5);
        if (this.values.size() == r5.size()) goto L7;
    L9:
        this.values = r5;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgrammatically();
        postInvalidate();
        return;
    L7:
        if (this.values.equals(r5) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldAlwaysShowLabel() {
        if (this.labelBehavior != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean shouldDrawCompatHalo() {
        if (this.forceDrawCompatHalo == false) goto L5;
    L8:
        return true;
    L5:
        if ((getBackground() instanceof RippleDrawable) == false) goto L8;
        return false;
    }

    private boolean snapActiveThumbToValue(float r5) {
        return snapThumbToValue(this.activeThumbIdx, r5);
    }

    private double snapPosition(float r5) {
        float r10 = this.stepSize;
        if (r10 <= 0.0f) goto L7;
        int r11 = (int) ((this.valueTo - this.valueFrom) / r10);
        return ((double) Math.round(r5 * r11)) / ((double) r11);
    L7:
        return r5;
    }

    private boolean snapThumbToValue(int r5, float r10) {
        this.focusedThumbIdx = r5;
        if (Math.abs(r10 - this.values.get(r5).floatValue()) >= THRESHOLD) goto L6;
        return false;
    L6:
        this.values.set(r5, Float.valueOf(getClampedValue(r5, r10)));
        dispatchOnChangedFromUser(r5);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void updateHaloHotspot() {
        if (shouldDrawCompatHalo() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r5 = getBackground();
        if ((r5 instanceof RippleDrawable) == false) goto L12;
        int r10 = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
        int r11 = calculateTrackCenter();
        int r12 = this.haloRadius;
        DrawableCompat.setHotspotBounds(r5, r10 - r12, r11 - r12, r10 + r12, r11 + r12);
        return;
    L12:
        return;
    }

    private void updateLabels() {
        int r5 = this.labelBehavior;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L20;
        if (r5 != 2) goto L9;
        ensureLabelsRemoved();
        return;
    L9:
        if (r5 != 3) goto L17;
        if (isEnabled() == true) goto L13;
    L15:
        ensureLabelsRemoved();
        return;
    L13:
        if (isSliderVisibleOnScreen() == false) goto L15;
        ensureLabelsAdded();
        return;
    L17:
        throw new IllegalArgumentException("Unexpected labelBehavior: " + this.labelBehavior);
    L20:
        if (this.activeThumbIdx != (-1)) goto L22;
    L24:
        ensureLabelsRemoved();
        return;
    L22:
        if (isEnabled() == false) goto L24;
        ensureLabelsAdded();
    }

    private void updateTrack(Canvas r10, Paint r11, RectF r12, FullCornerDirection r13) {
        int r5 = this.trackHeight;
        float r14 = r5 / 2.0f;
        float r15 = r5 / 2.0f;
        int[] r16 = AnonymousClass3.$SwitchMap$com$google$android$material$slider$BaseSlider$FullCornerDirection;
        int r17 = r16[r13.ordinal()];
        if (r17 == 1) goto L10;
        if (r17 == 2) goto L8;
        if (r17 != 3) goto L11;
        r14 = this.trackInsideCornerSize;
    L11:
        r11.setStyle(Paint.Style.FILL);
        r11.setStrokeCap(Paint.Cap.BUTT);
        r11.setAntiAlias(true);
        this.trackPath.reset();
        if (r12.width() < (r14 + r15)) goto L14;
        this.trackPath.addRoundRect(r12, getCornerRadii(r14, r15), Path.Direction.CW);
        r10.drawPath(this.trackPath, r11);
        return;
    L14:
        float r18 = Math.min(r14, r15);
        float r19 = Math.max(r14, r15);
        r10.save();
        this.trackPath.addRoundRect(r12, r18, r18, Path.Direction.CW);
        r10.clipPath(this.trackPath);
        int r110 = r16[r13.ordinal()];
        if (r110 == 2) goto L19;
        if (r110 == 3) goto L18;
        this.cornerRect.set(r12.centerX() - r19, r12.top, r12.centerX() + r19, r12.bottom);
    L20:
        r10.drawRoundRect(this.cornerRect, r19, r19, r11);
        r10.restore();
        return;
    L18:
        RectF r111 = this.cornerRect;
        float r20 = r12.right;
        r111.set(r20 - (2.0f * r19), r12.top, r20, r12.bottom);
        goto L20
    L19:
        RectF r112 = this.cornerRect;
        float r21 = r12.left;
        r112.set(r21, r12.top, (2.0f * r19) + r21, r12.bottom);
        goto L20
    L8:
        int r22 = this.trackInsideCornerSize;
    L9:
        r15 = r22;
        goto L11
    L10:
        r22 = this.trackInsideCornerSize;
        r14 = r22;
        goto L9
    }

    private void updateTrackWidth(int r5) {
        this.trackWidth = Math.max(r5 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void updateWidgetLayout() {
        boolean r5 = maybeIncreaseWidgetHeight();
        boolean r10 = maybeIncreaseTrackSidePadding();
        if (r5 == false) goto L5;
        requestLayout();
        return;
    L5:
        if (r10 == false) goto L9;
        postInvalidate();
        return;
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig == false) goto L6;
        validateValueFrom();
        validateValueTo();
        validateStepSize();
        validateValues();
        validateMinSeparation();
        warnAboutFloatingPointError();
        this.dirtyConfig = false;
        return;
    }

    private void validateMinSeparation() {
        float r5 = getMinSeparation();
        if (r5 < 0.0f) goto L21;
        float r10 = this.stepSize;
        if (r10 > 0.0f) goto L7;
        return;
    L7:
        if (r5 > 0.0f) goto L9;
        return;
    L9:
        if (this.separationUnit != 1) goto L18;
        if (r5 >= r10) goto L13;
    L15:
        float r11 = this.stepSize;
        float r12 = this.stepSize;
        StringBuilder r13 = new StringBuilder("minSeparation(");
        r13.append(r5);
        r13.append(") must be greater or equal and a multiple of stepSize(");
        r13.append(r11);
        r13.append(") when using stepSize(");
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.r(r13, r12, ")"));
    L13:
        if (isMultipleOfStepSize(r5) == false) goto L15;
        return;
    L18:
        throw new IllegalStateException("minSeparation(" + r5 + ") cannot be set as a dimension when using stepSize(" + this.stepSize + ")");
    L21:
        throw new IllegalStateException("minSeparation(" + r5 + ") must be greater or equal to 0");
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        if (valueLandsOnTick(this.valueTo) == true) goto L10;
        float r5 = this.stepSize;
        float r10 = this.valueFrom;
        float r11 = this.valueTo;
        StringBuilder r12 = new StringBuilder("The stepSize(");
        r12.append(r5);
        r12.append(") must be 0, or a factor of the valueFrom(");
        r12.append(r10);
        r12.append(")-valueTo(");
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.r(r12, r11, ") range"));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) goto L6;
        return;
    L6:
        throw new IllegalStateException("valueFrom(" + this.valueFrom + ") must be smaller than valueTo(" + this.valueTo + ")");
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) goto L6;
        return;
    L6:
        throw new IllegalStateException("valueTo(" + this.valueTo + ") must be greater than valueFrom(" + this.valueFrom + ")");
    }

    private void validateValues() {
        Iterator<Float> r5 = this.values.iterator();
    L4:
        if (r5.hasNext() == false) goto L18;
        Float r10 = r5.next();
        if (r10.floatValue() < this.valueFrom) goto L16;
        if (r10.floatValue() > this.valueTo) goto L16;
        if (this.stepSize <= 0.0f) goto L4;
        if (valueLandsOnTick(r10.floatValue()) == true) goto L4;
        throw new IllegalStateException("Value(" + r10 + ") must be equal to valueFrom(" + this.valueFrom + ") plus a multiple of stepSize(" + this.stepSize + ") when using stepSize(" + this.stepSize + ")");
    L16:
        float r11 = this.valueFrom;
        float r12 = this.valueTo;
        StringBuilder r13 = new StringBuilder("Slider value(");
        r13.append(r10);
        r13.append(") must be greater or equal to valueFrom(");
        r13.append(r11);
        r13.append("), and lower or equal to valueTo(");
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.r(r13, r12, ")"));
    }

    private boolean valueLandsOnTick(float r5) {
        return isMultipleOfStepSize(new BigDecimal(Float.toString(r5)).subtract(new BigDecimal(Float.toString(this.valueFrom)), MathContext.DECIMAL64).doubleValue());
    }

    private float valueToX(float r5) {
        return (normalizeValue(r5) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float r5 = this.stepSize;
        if (r5 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r5) == r5) goto L8;
        Log.w(TAG, "Floating point value used for stepSize(" + r5 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
    L8:
        float r10 = this.valueFrom;
        if (((int) r10) == r10) goto L11;
        Log.w(TAG, "Floating point value used for valueFrom(" + r10 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
    L11:
        float r11 = this.valueTo;
        if (((int) r11) == r11) goto L15;
        Log.w(TAG, "Floating point value used for valueTo(" + r11 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
        return;
    }

    public void addOnChangeListener(@NonNull L r5) {
        this.changeListeners.add(r5);
    }

    public void addOnSliderTouchListener(@NonNull T r5) {
        this.touchListeners.add(r5);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r5) {
        if (this.accessibilityHelper.dispatchHoverEvent(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r5) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent r5) {
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        this.stopIndicatorPaint.setColor(getColorForState(this.trackColorActive));
        Iterator<TooltipDrawable> r5 = this.labels.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        TooltipDrawable r10 = r5.next();
        if (r10.isStateful() == false) goto L4;
        r10.setState(getDrawableState());
        goto L4
    L9:
        if (this.defaultThumbDrawable.isStateful() == false) goto L11;
        this.defaultThumbDrawable.setState(getDrawableState());
    L11:
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean r5) {
        this.forceDrawCompatHalo = r5;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Px
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    @Px
    public int getThumbHeight() {
        return this.thumbHeight;
    }

    @Px
    public int getThumbRadius() {
        return this.thumbWidth / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public int getThumbTrackGapSize() {
        return this.thumbTrackGapSize;
    }

    @Px
    public int getThumbWidth() {
        return this.thumbWidth;
    }

    @Px
    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive) == false) goto L7;
        return this.tickColorActive;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Px
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackInsideCornerSize() {
        return this.trackInsideCornerSize;
    }

    @Px
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackStopIndicatorSize() {
        return this.trackStopIndicatorSize;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive) == false) goto L7;
        return this.trackColorActive;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Px
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        Iterator<TooltipDrawable> r5 = this.labels.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        attachLabelToContentView(r5.next());
        goto L4
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender r5 = this.accessibilityEventSender;
        if (r5 == null) goto L5;
        removeCallbacks(r5);
    L5:
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> r10 = this.labels.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        detachLabelFromContentView(r10.next());
        goto L7
    L9:
        getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r10) {
        if (this.dirtyConfig == false) goto L5;
        validateConfigurationIfDirty();
        maybeCalculateTicksCoordinates();
    L5:
        super.onDraw(r10);
        int r5 = calculateTrackCenter();
        float r11 = this.values.get(0).floatValue();
        float r12 = ((Float) androidx.constraintlayout.motion.widget.a.h(this.values, 1)).floatValue();
        if (r12 >= this.valueTo) goto L8;
    L11:
        drawInactiveTrack(r10, this.trackWidth, r5);
    L13:
        if (r12 <= this.valueFrom) goto L15;
        drawActiveTrack(r10, this.trackWidth, r5);
    L15:
        maybeDrawTicks(r10);
        maybeDrawStopIndicator(r10, r5);
        if (this.thumbIsPressed == true) goto L20;
        if (isFocused() == true) goto L20;
    L22:
        updateLabels();
        drawThumbs(r10, this.trackWidth, r5);
        return;
    L20:
        if (isEnabled() == false) goto L22;
        maybeDrawCompatHalo(r10, this.trackWidth, r5);
        goto L22
    L8:
        if (this.values.size() <= 1) goto L13;
        if (r11 <= this.valueFrom) goto L13;
        goto L11
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r5, int r10, @Nullable Rect r11) {
        super.onFocusChanged(r5, r10, r11);
        if (r5 == true) goto L5;
        this.activeThumbIdx = -1;
        this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        return;
    L5:
        focusThumbOnFocusGained(r10);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, @NonNull KeyEvent r11) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r10, r11);
    L7:
        if (this.values.size() != 1) goto L10;
        this.activeThumbIdx = 0;
    L10:
        if (this.activeThumbIdx != (-1)) goto L16;
        Boolean r5 = onKeyDownNoActiveThumb(r10, r11);
        if (r5 == null) goto L15;
        return r5.booleanValue();
    L15:
        return super.onKeyDown(r10, r11);
    L16:
        this.isLongPress |= r11.isLongPress();
        Float r12 = calculateIncrementForKey(r10);
        if (r12 == null) goto L23;
        if (snapActiveThumbToValue(r12.floatValue() + this.values.get(this.activeThumbIdx).floatValue()) == false) goto L21;
        updateHaloHotspot();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r10 != 23) goto L25;
    L39:
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    L25:
        if (r10 == 61) goto L31;
        if (r10 == 66) goto L39;
        return super.onKeyDown(r10, r11);
    L31:
        if (r11.hasNoModifiers() == false) goto L35;
        return moveFocus(1);
    L35:
        if (r11.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return moveFocus(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r5, @NonNull KeyEvent r10) {
        this.isLongPress = false;
        return super.onKeyUp(r5, r10);
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = this.widgetHeight;
        int r12 = 0;
        if (this.labelBehavior != 1) goto L5;
    L6:
        r12 = this.labels.get(0).getIntrinsicHeight();
    L7:
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(r11 + r12, BasicMeasure.EXACTLY));
        return;
    L5:
        if (shouldAlwaysShowLabel() == false) goto L7;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        SliderState r10 = (SliderState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.valueFrom = r10.valueFrom;
        this.valueTo = r10.valueTo;
        setValuesInternal(r10.values);
        this.stepSize = r10.stepSize;
        if (r10.hasFocus == false) goto L6;
        requestFocus();
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState r5 = new SliderState(super.onSaveInstanceState());
        r5.valueFrom = this.valueFrom;
        r5.valueTo = this.valueTo;
        r5.values = new ArrayList(this.values);
        r5.stepSize = this.stepSize;
        r5.hasFocus = hasFocus();
        return r5;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        updateTrackWidth(r5);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r5 = r10.getX();
        float r11 = (r5 - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = r11;
        float r12 = Math.max(0.0f, r11);
        this.touchPosition = r12;
        this.touchPosition = Math.min(1.0f, r12);
        int r13 = r10.getActionMasked();
        if (r13 == 0) goto L46;
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L13;
        if (r13 == 3) goto L24;
    L56:
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(r10);
        return true;
    L13:
        if (this.thumbIsPressed == true) goto L21;
        if (isPotentialVerticalScroll(r10) == true) goto L17;
    L19:
        getParent().requestDisallowInterceptTouchEvent(true);
        onStartTrackingTouch();
        goto L21
    L17:
        if (Math.abs(r5 - this.touchDownX) >= this.scaledTouchSlop) goto L19;
        return false;
    L21:
        if (pickActiveThumb() == false) goto L56;
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
    L24:
        this.thumbIsPressed = false;
        MotionEvent r14 = this.lastEvent;
        if (r14 == null) goto L36;
        if (r14.getActionMasked() != 0) goto L36;
        if (Math.abs(this.lastEvent.getX() - r10.getX()) > this.scaledTouchSlop) goto L36;
        if (Math.abs(this.lastEvent.getY() - r10.getY()) > this.scaledTouchSlop) goto L36;
        if (pickActiveThumb() == false) goto L36;
        onStartTrackingTouch();
    L36:
        if (this.activeThumbIdx == (-1)) goto L45;
        snapTouchPosition();
        updateHaloHotspot();
        if (hasGapBetweenThumbAndTrack() == false) goto L44;
        int r15 = this.defaultThumbWidth;
        if (r15 == (-1)) goto L44;
        if (this.defaultThumbTrackGapSize == (-1)) goto L44;
        setThumbWidth(r15);
        setThumbTrackGapSize(this.defaultThumbTrackGapSize);
    L44:
        this.activeThumbIdx = -1;
        onStopTrackingTouch();
    L45:
        invalidate();
        goto L56
    L46:
        this.touchDownX = r5;
        if (isPotentialVerticalScroll(r10) == true) goto L56;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (pickActiveThumb() == false) goto L56;
        requestFocus();
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        if (hasGapBetweenThumbAndTrack() == false) goto L55;
        int r16 = this.thumbWidth;
        this.defaultThumbWidth = r16;
        this.defaultThumbTrackGapSize = this.thumbTrackGapSize;
        int r17 = Math.round(r16 * 0.5f);
        int r18 = this.thumbWidth - r17;
        setThumbWidth(r17);
        setThumbTrackGapSize(this.thumbTrackGapSize - (r18 / 2));
    L55:
        invalidate();
        onStartTrackingTouch();
        goto L56
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View r5, int r10) {
        super.onVisibilityChanged(r5, r10);
        if (r10 == 0) goto L11;
        ViewOverlayImpl r11 = ViewUtils.getContentViewOverlay(this);
        if (r11 != null) goto L7;
        return;
    L7:
        Iterator<TooltipDrawable> r12 = this.labels.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        r11.remove(r12.next());
        goto L9
    L13:
        return;
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx == (-1)) goto L5;
        return true;
    L5:
        float r5 = getValueOfTouchPositionAbsolute();
        float r10 = valueToX(r5);
        this.activeThumbIdx = 0;
        float r11 = Math.abs(this.values.get(0).floatValue() - r5);
        int r12 = 1;
    L7:
        if (r12 >= this.values.size()) goto L34;
        float r13 = Math.abs(this.values.get(r12).floatValue() - r5);
        float r14 = valueToX(this.values.get(r12).floatValue());
        if (Float.compare(r13, r11) > 0) goto L34;
        if (isRtl() == false) goto L18;
        if ((r14 - r10) <= 0.0f) goto L16;
    L15:
        boolean r15 = true;
    L21:
        if (Float.compare(r13, r11) >= 0) goto L24;
        this.activeThumbIdx = r12;
    L31:
        r11 = r13;
    L32:
        r12 = r12 + 1;
        goto L7
    L24:
        if (Float.compare(r13, r11) != 0) goto L32;
        if (Math.abs(r14 - r10) < this.scaledTouchSlop) goto L27;
        if (r15 == false) goto L32;
        this.activeThumbIdx = r12;
        goto L31
    L27:
        this.activeThumbIdx = -1;
        return false;
    L16:
        r15 = false;
        goto L21
    L18:
        if ((r14 - r10) >= 0.0f) goto L16;
    L34:
        if (this.activeThumbIdx == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    public void removeOnChangeListener(@NonNull L r5) {
        this.changeListeners.remove(r5);
    }

    public void removeOnSliderTouchListener(@NonNull T r5) {
        this.touchListeners.remove(r5);
    }

    public void setActiveThumbIndex(int r5) {
        this.activeThumbIdx = r5;
    }

    public void setCustomThumbDrawable(@DrawableRes int r5) {
        setCustomThumbDrawable(getResources().getDrawable(r5));
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... r5) {
        Drawable[] r10 = new Drawable[r5.length];
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10[r11] = getResources().getDrawable(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        setCustomThumbDrawablesForValues(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == false) goto L5;
        int r10 = 0;
    L6:
        setLayerType(r10, null);
        return;
    L5:
        r10 = 2;
        goto L6
    }

    public void setFocusedThumbIndex(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= this.values.size()) goto L8;
        this.focusedThumbIdx = r5;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(r5);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Px int r5) {
        if (r5 != this.haloRadius) goto L5;
        return;
    L5:
        this.haloRadius = r5;
        Drawable r10 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if ((r10 instanceof RippleDrawable) == false) goto L11;
        DrawableUtils.setRippleDrawableRadius((RippleDrawable) r10, this.haloRadius);
    }

    public void setHaloRadiusResource(@DimenRes int r5) {
        setHaloRadius(getResources().getDimensionPixelSize(r5));
    }

    public void setHaloTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.haloColor) == false) goto L5;
        return;
    L5:
        this.haloColor = r5;
        Drawable r10 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        this.haloPaint.setColor(getColorForState(r5));
        this.haloPaint.setAlpha(63);
        invalidate();
        return;
    L8:
        if ((r10 instanceof RippleDrawable) == false) goto L11;
        ((RippleDrawable) r10).setColor(r5);
    }

    public void setLabelBehavior(int r5) {
        if (this.labelBehavior == r5) goto L6;
        this.labelBehavior = r5;
        requestLayout();
        return;
    }

    public void setLabelFormatter(@Nullable LabelFormatter r5) {
        this.formatter = r5;
    }

    public void setSeparationUnit(int r5) {
        this.separationUnit = r5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float r5) {
        if (r5 >= 0.0f) goto L5;
        float r10 = this.valueFrom;
        float r11 = this.valueTo;
        StringBuilder r12 = new StringBuilder("The stepSize(");
        r12.append(r5);
        r12.append(") must be 0, or a factor of the valueFrom(");
        r12.append(r10);
        r12.append(")-valueTo(");
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.r(r12, r11, ") range"));
    L5:
        if (this.stepSize == r5) goto L10;
        this.stepSize = r5;
        this.dirtyConfig = true;
        postInvalidate();
        return;
    }

    public void setThumbElevation(float r5) {
        this.defaultThumbDrawable.setElevation(r5);
    }

    public void setThumbElevationResource(@DimenRes int r5) {
        setThumbElevation(getResources().getDimension(r5));
    }

    public void setThumbHeight(@IntRange(from = 0) @Px int r5) {
        if (r5 != this.thumbHeight) goto L5;
        return;
    L5:
        this.thumbHeight = r5;
        this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, r5);
        Drawable r10 = this.customThumbDrawable;
        if (r10 == null) goto L8;
        adjustCustomThumbDrawableBounds(r10);
    L8:
        Iterator<Drawable> r11 = this.customThumbDrawablesForValues.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        adjustCustomThumbDrawableBounds(r11.next());
        goto L10
    L12:
        updateWidgetLayout();
    }

    public void setThumbHeightResource(@DimenRes int r5) {
        setThumbHeight(getResources().getDimensionPixelSize(r5));
    }

    public void setThumbRadius(@IntRange(from = 0) @Px int r5) {
        int r10 = r5 * 2;
        setThumbWidth(r10);
        setThumbHeight(r10);
    }

    public void setThumbRadiusResource(@DimenRes int r5) {
        setThumbRadius(getResources().getDimensionPixelSize(r5));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList r5) {
        this.defaultThumbDrawable.setStrokeColor(r5);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int r5) {
        if (r5 == 0) goto L5;
        setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), r5));
        return;
    }

    public void setThumbStrokeWidth(float r5) {
        this.defaultThumbDrawable.setStrokeWidth(r5);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int r5) {
        if (r5 == 0) goto L5;
        setThumbStrokeWidth(getResources().getDimension(r5));
        return;
    }

    public void setThumbTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.defaultThumbDrawable.getFillColor()) == false) goto L5;
        return;
    L5:
        this.defaultThumbDrawable.setFillColor(r5);
        invalidate();
    }

    public void setThumbTrackGapSize(@Px int r5) {
        if (this.thumbTrackGapSize != r5) goto L5;
        return;
    L5:
        this.thumbTrackGapSize = r5;
        invalidate();
    }

    public void setThumbWidth(@IntRange(from = 0) @Px int r5) {
        if (r5 != this.thumbWidth) goto L5;
        return;
    L5:
        this.thumbWidth = r5;
        this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbWidth / 2.0f).build());
        this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        Drawable r10 = this.customThumbDrawable;
        if (r10 == null) goto L8;
        adjustCustomThumbDrawableBounds(r10);
    L8:
        Iterator<Drawable> r11 = this.customThumbDrawablesForValues.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        adjustCustomThumbDrawableBounds(r11.next());
        goto L10
    L12:
        updateWidgetLayout();
    }

    public void setThumbWidthResource(@DimenRes int r5) {
        setThumbWidth(getResources().getDimensionPixelSize(r5));
    }

    public void setTickActiveRadius(@IntRange(from = 0) @Px int r5) {
        if (this.tickActiveRadius == r5) goto L6;
        this.tickActiveRadius = r5;
        this.activeTicksPaint.setStrokeWidth(r5 * 2);
        updateWidgetLayout();
        return;
    }

    public void setTickActiveTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.tickColorActive) == false) goto L5;
        return;
    L5:
        this.tickColorActive = r5;
        this.activeTicksPaint.setColor(getColorForState(r5));
        invalidate();
    }

    public void setTickInactiveRadius(@IntRange(from = 0) @Px int r5) {
        if (this.tickInactiveRadius == r5) goto L6;
        this.tickInactiveRadius = r5;
        this.inactiveTicksPaint.setStrokeWidth(r5 * 2);
        updateWidgetLayout();
        return;
    }

    public void setTickInactiveTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.tickColorInactive) == false) goto L5;
        return;
    L5:
        this.tickColorInactive = r5;
        this.inactiveTicksPaint.setColor(getColorForState(r5));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList r5) {
        setTickInactiveTintList(r5);
        setTickActiveTintList(r5);
    }

    public void setTickVisible(boolean r5) {
        if (this.tickVisible == r5) goto L6;
        this.tickVisible = r5;
        postInvalidate();
        return;
    }

    public void setTrackActiveTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.trackColorActive) == false) goto L5;
        return;
    L5:
        this.trackColorActive = r5;
        this.activeTrackPaint.setColor(getColorForState(r5));
        this.stopIndicatorPaint.setColor(getColorForState(this.trackColorActive));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Px int r5) {
        if (this.trackHeight == r5) goto L6;
        this.trackHeight = r5;
        invalidateTrack();
        updateWidgetLayout();
        return;
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList r5) {
        if (r5.equals(this.trackColorInactive) == false) goto L5;
        return;
    L5:
        this.trackColorInactive = r5;
        this.inactiveTrackPaint.setColor(getColorForState(r5));
        invalidate();
    }

    public void setTrackInsideCornerSize(@Px int r5) {
        if (this.trackInsideCornerSize != r5) goto L5;
        return;
    L5:
        this.trackInsideCornerSize = r5;
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int r5) {
        if (this.trackStopIndicatorSize != r5) goto L5;
        return;
    L5:
        this.trackStopIndicatorSize = r5;
        this.stopIndicatorPaint.setStrokeWidth(r5);
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList r5) {
        setTrackInactiveTintList(r5);
        setTrackActiveTintList(r5);
    }

    public void setValueFrom(float r5) {
        this.valueFrom = r5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float r5) {
        this.valueTo = r5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... r5) {
        ArrayList<Float> r10 = new ArrayList();
        Collections.addAll(r10, r5);
        setValuesInternal(r10);
    }

    public void updateBoundsForVirtualViewId(int r5, Rect r10) {
        int r11 = this.trackSidePadding + ((int) (normalizeValue(getValues().get(r5).floatValue()) * this.trackWidth));
        int r12 = calculateTrackCenter();
        int r13 = Math.max(this.thumbWidth / 2, this.minTouchTargetSize / 2);
        int r14 = Math.max(this.thumbHeight / 2, this.minTouchTargetSize / 2);
        r10.set(r11 - r13, r12 - r14, r11 + r13, r12 + r14);
    }

    public BaseSlider(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.sliderStyle);
    }

    private float calculateStepIncrement(int r5) {
        float r10 = calculateStepIncrement();
        float r11 = (this.valueTo - this.valueFrom) / r10;
        float r12 = r5;
        if (r11 > r12) goto L6;
        return r10;
    L6:
        return Math.round(r11 / r12) * r10;
    }

    public void setCustomThumbDrawable(@NonNull Drawable r5) {
        this.customThumbDrawable = initializeCustomThumbDrawable(r5);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    public BaseSlider(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, DEF_STYLE_RES), r11, r12);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.defaultThumbWidth = -1;
        this.defaultThumbTrackGapSize = -1;
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        this.trackPath = new Path();
        this.trackRect = new RectF();
        this.cornerRect = new RectF();
        MaterialShapeDrawable r5 = new MaterialShapeDrawable();
        this.defaultThumbDrawable = r5;
        this.customThumbDrawablesForValues = Collections.emptyList();
        this.separationUnit = 0;
        this.onScrollChangedListener = new a(this);
        Context r13 = getContext();
        this.inactiveTrackPaint = new Paint();
        this.activeTrackPaint = new Paint();
        Paint r14 = new Paint(1);
        this.thumbPaint = r14;
        Paint.Style r15 = Paint.Style.FILL;
        r14.setStyle(r15);
        r14.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r16 = new Paint(1);
        this.haloPaint = r16;
        r16.setStyle(r15);
        Paint r17 = new Paint();
        this.inactiveTicksPaint = r17;
        Paint.Style r18 = Paint.Style.STROKE;
        r17.setStyle(r18);
        Paint.Cap r19 = Paint.Cap.ROUND;
        r17.setStrokeCap(r19);
        Paint r20 = new Paint();
        this.activeTicksPaint = r20;
        r20.setStyle(r18);
        r20.setStrokeCap(r19);
        Paint r21 = new Paint();
        this.stopIndicatorPaint = r21;
        r21.setStyle(r15);
        r21.setStrokeCap(r19);
        loadResources(r13.getResources());
        processAttributes(r13, r11, r12);
        setFocusable(true);
        setClickable(true);
        r5.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(r13).getScaledTouchSlop();
        AccessibilityHelper r22 = new AccessibilityHelper(this);
        this.accessibilityHelper = r22;
        ViewCompat.setAccessibilityDelegate(this, r22);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> r5) {
        setValuesInternal(new ArrayList(r5));
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... r5) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Drawable r12 = r5[r11];
        this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(r12));
        r11 = r11 + 1;
        goto L3
    L5:
        postInvalidate();
    }
}
