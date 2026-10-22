package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
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
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import com.google.android.material.tooltip.TooltipDrawable;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f4069a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4070b = "BaseSlider";
    private int A;
    private int B;
    private int C;
    private float D;
    private MotionEvent E;
    private c F;
    private boolean G;
    private float H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ArrayList<Float> f4071J;
    private int K;
    private int L;
    private float M;
    private float[] N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private ColorStateList T;
    private ColorStateList U;
    private ColorStateList V;
    private ColorStateList W;
    private ColorStateList aa;
    private final MaterialShapeDrawable ab;
    private Drawable ac;
    private List<Drawable> ad;
    private float ae;
    private int af;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private final AccessibilityHelper i;
    private final AccessibilityManager j;
    private BaseSlider<S, L, T>.a k;
    private final b l;
    private final List<TooltipDrawable> m;
    private final List<L> n;
    private final List<T> o;
    private boolean p;
    private ValueAnimator q;
    private ValueAnimator r;
    private final int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        AccessibilityHelper(BaseSlider<?, ?, ?> r2) {
            super(r2);
            this.virtualViewBounds = new Rect();
            this.slider = r2;
        }

        private String startOrEndDescription(int r4) {
            if (r4 != (this.slider.getValues().size() - 1)) goto L7;
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.slider.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int r5 = R.string.material_slider_range_end;
            String r0 = "material_slider_range_end";
        L6:
            return r3.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r0));
        L7:
            if (r4 != 0) goto L9;
            r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.slider.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            r5 = R.string.material_slider_range_start;
            r0 = "material_slider_range_start";
            goto L6
        L9:
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.slider.getValues().size()) goto L9;
            this.slider.a(r0, this.virtualViewBounds);
            if (this.virtualViewBounds.contains((int) r5, (int) r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            int r0 = 0;
        L4:
            if (r0 >= this.slider.getValues().size()) goto L6;
            r4.add(Integer.valueOf(r0));
            r0 = r0 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r5, int r6, Bundle r7) {
            if (this.slider.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r6 == 4096) goto L20;
            if (r6 == 8192) goto L20;
            if (r6 == 16908349) goto L11;
            return false;
        L11:
            if (r7 != null) goto L13;
        L19:
            return false;
        L13:
            if (r7.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) == false) goto L19;
            float r8 = r7.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
            if (BaseSlider.a(this.slider, r5, r8) == false) goto L19;
        L17:
            BaseSlider.c(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r5);
            return true;
        L20:
            float r9 = BaseSlider.a(this.slider, 20);
            if (r6 != 8192) goto L24;
            r9 = -r9;
        L24:
            if (this.slider.c() == false) goto L26;
            r9 = -r9;
        L26:
            float r10 = MathUtils.clamp(((Float) ZeusTransformUtils.preCheckCast(this.slider.getValues().get(r5), Float.class, "com.obric.memorydata.plugin")).floatValue() + r9, this.slider.getValueFrom(), this.slider.getValueTo());
            if (BaseSlider.a(this.slider, r5, r10) == true) goto L17;
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r7, AccessibilityNodeInfoCompat r8) {
            r8.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> r0 = this.slider.getValues();
            float r1 = ((Float) ZeusTransformUtils.preCheckCast(r0.get(r7), Float.class, "com.obric.memorydata.plugin")).floatValue();
            float r2 = this.slider.getValueFrom();
            float r3 = this.slider.getValueTo();
            if (this.slider.isEnabled() == true) goto L5;
        L10:
            r8.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, r2, r3, r1));
            r8.setClassName(SeekBar.class.getName());
            StringBuilder r4 = new StringBuilder();
            if (this.slider.getContentDescription() == null) goto L14;
            r4.append(this.slider.getContentDescription()).append(",");
        L14:
            if (r0.size() <= 1) goto L16;
            r4.append(startOrEndDescription(r7));
            r4.append(BaseSlider.a(this.slider, r1));
        L16:
            r8.setContentDescription(r4.toString());
            this.slider.a(r7, this.virtualViewBounds);
            r8.setBoundsInParent(this.virtualViewBounds);
            return;
        L5:
            if (r1 <= r2) goto L8;
            r8.addAction(8192);
        L8:
            if (r1 >= r3) goto L10;
            r8.addAction(4096);
            goto L10
        }
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        static {
            CREATOR = new AnonymousClass1();
        }

        private SliderState(Parcel r3) {
            super(r3);
            this.valueFrom = r3.readFloat();
            this.valueTo = r3.readFloat();
            ArrayList<Float> r0 = new ArrayList();
            this.values = r0;
            r3.readList(r0, Float.class.getClassLoader());
            this.stepSize = r3.readFloat();
            this.hasFocus = r3.createBooleanArray()[0];
        }

        /* synthetic */ SliderState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SliderState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeFloat(this.valueFrom);
            r2.writeFloat(this.valueTo);
            r2.writeList(this.values);
            r2.writeFloat(this.stepSize);
            r2.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseSlider f4077b;

        private a(BaseSlider r1) {
            this.f4077b = r1;
            this.f4076a = -1;
        }

        /* synthetic */ a(BaseSlider r1, AnonymousClass1 r2) {
            this(r1);
        }

        void a(int r1) {
            this.f4076a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.b(this.f4077b).sendEventForVirtualView(this.f4076a, 4);
        }
    }

    private interface b {
        TooltipDrawable a();
    }

    static {
        f4069a = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Slider, "style", "Widget_MaterialComponents_Slider");
    }

    public BaseSlider(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public BaseSlider(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.sliderStyle, "attr", "sliderStyle"));
    }

    public BaseSlider(Context r7, AttributeSet r8, final int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        final AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r10, r11, r9, f4069a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, r9);
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = false;
        this.G = false;
        this.f4071J = new ArrayList();
        this.K = -1;
        this.L = -1;
        this.M = 0.0f;
        this.O = true;
        this.R = false;
        MaterialShapeDrawable r2 = new MaterialShapeDrawable();
        this.ab = r2;
        this.ad = Collections.emptyList();
        this.af = 0;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Paint r3 = new Paint();
        this.c = r3;
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeCap(Paint.Cap.ROUND);
        Paint r4 = new Paint();
        this.d = r4;
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeCap(Paint.Cap.ROUND);
        Paint r5 = new Paint(1);
        this.e = r5;
        r5.setStyle(Paint.Style.FILL);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r6 = new Paint(1);
        this.f = r6;
        r6.setStyle(Paint.Style.FILL);
        Paint r13 = new Paint();
        this.g = r13;
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.ROUND);
        Paint r14 = new Paint();
        this.h = r14;
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeCap(Paint.Cap.ROUND);
        a(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"));
        this.l = new AnonymousClass1(this, r11, r9);
        a(r12, r11, r9);
        setFocusable(true);
        setClickable(true);
        r2.setShadowCompatibilityMode(2);
        this.s = ViewConfiguration.get(r12).getScaledTouchSlop();
        AccessibilityHelper r15 = new AccessibilityHelper(this);
        this.i = r15;
        ViewCompat.setAccessibilityDelegate(this, r15);
        this.j = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
    }

    private static float a(ValueAnimator r2, float r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r2.isRunning() == false) goto L8;
        float r4 = ((Float) ZeusTransformUtils.preCheckCast(r2.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.cancel();
        return r4;
    L8:
        return r3;
    }

    static /* synthetic */ float a(BaseSlider r0, int r1) {
        return r0.f(r1);
    }

    private int a(ColorStateList r2) {
        return r2.getColorForState(getDrawableState(), r2.getDefaultColor());
    }

    private static int a(float[] r0, float r1) {
        return Math.round(r1 * ((r0.length / 2) - 1));
    }

    private ValueAnimator a(boolean r5) {
        float r0 = 0.0f;
        if (r5 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r5 == false) goto L8;
        ValueAnimator r3 = this.r;
    L9:
        float r4 = a(r3, r2);
        if (r5 == false) goto L12;
        r0 = 1.0f;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r4, r0});
        if (r5 == false) goto L15;
        long r6 = 83;
    L16:
        r1.setDuration(r6);
        if (r5 == false) goto L19;
        TimeInterpolator r7 = com.google.android.material.a.a.e;
    L20:
        r1.setInterpolator(r7);
        r1.addUpdateListener(new AnonymousClass2(this));
        return r1;
    L19:
        r7 = com.google.android.material.a.a.c;
        goto L20
    L15:
        r6 = 117;
        goto L16
    L8:
        r3 = this.q;
        goto L9
    L5:
        r2 = 1.0f;
        goto L6
    }

    private Drawable a(Drawable r1) {
        Drawable r2 = r1.mutate().getConstantState().newDrawable();
        b(r2);
        return r2;
    }

    static /* synthetic */ TooltipDrawable a(Context r2, TypedArray r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private Boolean a(int r4, KeyEvent r5) {
        if (r4 == 61) goto L26;
        if (r4 != 66) goto L7;
    L23:
        this.K = this.L;
        postInvalidate();
        return true;
    L7:
        if (r4 != 81) goto L9;
    L21:
        c(1);
        return true;
    L9:
        if (r4 != 69) goto L11;
        c(-1);
        return true;
    L11:
        if (r4 == 70) goto L21;
        switch(r4) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        d(1);
        return true;
    L17:
        d(-1);
        return true;
    L26:
        if (r5.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(c(1));
    L30:
        if (r5.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(c(-1));
    L34:
        return false;
    }

    static /* synthetic */ String a(BaseSlider r0, float r1) {
        return r0.h(r1);
    }

    static /* synthetic */ List a(BaseSlider r0) {
        return r0.m;
    }

    private void a(int r2) {
        this.P = Math.max(r2 - (this.y * 2), 0);
        n();
    }

    private void a(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        TypedArray r13 = k.a(r12, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Slider, r11, f4069a, new int[0]);
        this.H = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_valueFrom, "styleable", "Slider_android_valueFrom"), 0.0f);
        this.I = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_valueTo, "styleable", "Slider_android_valueTo"), 1.0f);
        setValues(new Float[]{Float.valueOf(this.H)});
        this.M = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_stepSize, "styleable", "Slider_android_stepSize"), 0.0f);
        String r4 = "Slider_trackColor";
        boolean r3 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_trackColor, "styleable", "Slider_trackColor"));
        if (r3 == false) goto L5;
        int r5 = ZeusTransformUtils.mapRes(R.styleable.Slider_trackColor, "styleable", "Slider_trackColor");
    L6:
        if (r3 == false) goto L8;
        int r6 = R.styleable.Slider_trackColor;
    L9:
        int r7 = ZeusTransformUtils.mapRes(r6, "styleable", r4);
        ColorStateList r8 = com.google.android.material.resources.c.a(r12, r13, r5);
        if (r8 != null) goto L13;
        r8 = AppCompatResources.getColorStateList(r12, ZeusTransformUtils.mapRes(R.color.material_slider_inactive_track_color, TypedValues.Custom.S_COLOR, "material_slider_inactive_track_color"));
    L13:
        setTrackInactiveTintList(r8);
        ColorStateList r14 = com.google.android.material.resources.c.a(r12, r13, r7);
        if (r14 != null) goto L17;
        r14 = AppCompatResources.getColorStateList(r12, ZeusTransformUtils.mapRes(R.color.material_slider_active_track_color, TypedValues.Custom.S_COLOR, "material_slider_active_track_color"));
    L17:
        setTrackActiveTintList(r14);
        this.ab.setFillColor(com.google.android.material.resources.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_thumbColor, "styleable", "Slider_thumbColor")));
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeColor, "styleable", "Slider_thumbStrokeColor")) == false) goto L20;
        setThumbStrokeColor(com.google.android.material.resources.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeColor, "styleable", "Slider_thumbStrokeColor")));
    L20:
        setThumbStrokeWidth(r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeWidth, "styleable", "Slider_thumbStrokeWidth"), 0.0f));
        ColorStateList r15 = com.google.android.material.resources.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_haloColor, "styleable", "Slider_haloColor"));
        if (r15 != null) goto L24;
        r15 = AppCompatResources.getColorStateList(r12, ZeusTransformUtils.mapRes(R.color.material_slider_halo_color, TypedValues.Custom.S_COLOR, "material_slider_halo_color"));
    L24:
        setHaloTintList(r15);
        this.O = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Slider_tickVisible, "styleable", "Slider_tickVisible"), true);
        String r16 = "Slider_tickColor";
        boolean r17 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_tickColor, "styleable", "Slider_tickColor"));
        if (r17 == false) goto L27;
        int r18 = ZeusTransformUtils.mapRes(R.styleable.Slider_tickColor, "styleable", "Slider_tickColor");
    L28:
        if (r17 == false) goto L30;
        int r19 = R.styleable.Slider_tickColor;
    L31:
        int r20 = ZeusTransformUtils.mapRes(r19, "styleable", r16);
        ColorStateList r21 = com.google.android.material.resources.c.a(r12, r13, r18);
        if (r21 != null) goto L35;
        r21 = AppCompatResources.getColorStateList(r12, ZeusTransformUtils.mapRes(R.color.material_slider_inactive_tick_marks_color, TypedValues.Custom.S_COLOR, "material_slider_inactive_tick_marks_color"));
    L35:
        setTickInactiveTintList(r21);
        ColorStateList r22 = com.google.android.material.resources.c.a(r12, r13, r20);
        if (r22 != null) goto L39;
        r22 = AppCompatResources.getColorStateList(r12, ZeusTransformUtils.mapRes(R.color.material_slider_active_tick_marks_color, TypedValues.Custom.S_COLOR, "material_slider_active_tick_marks_color"));
    L39:
        setTickActiveTintList(r22);
        setThumbRadius(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbRadius, "styleable", "Slider_thumbRadius"), 0));
        setHaloRadius(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_haloRadius, "styleable", "Slider_haloRadius"), 0));
        setThumbElevation(r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbElevation, "styleable", "Slider_thumbElevation"), 0.0f));
        setTrackHeight(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_trackHeight, "styleable", "Slider_trackHeight"), 0));
        setLabelBehavior(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.Slider_labelBehavior, "styleable", "Slider_labelBehavior"), 0));
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Slider_android_enabled, "styleable", "Slider_android_enabled"), true) == true) goto L42;
        setEnabled(false);
    L42:
        r13.recycle();
        return;
    L30:
        r19 = R.styleable.Slider_tickColorActive;
        r16 = "Slider_tickColorActive";
        goto L31
    L27:
        r18 = ZeusTransformUtils.mapRes(R.styleable.Slider_tickColorInactive, "styleable", "Slider_tickColorInactive");
        goto L28
    L8:
        r6 = R.styleable.Slider_trackColorActive;
        r4 = "Slider_trackColorActive";
        goto L9
    L5:
        r5 = ZeusTransformUtils.mapRes(R.styleable.Slider_trackColorInactive, "styleable", "Slider_trackColorInactive");
        goto L6
    }

    private void a(Resources r4) {
        this.v = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_widget_height, "dimen", "mtrl_slider_widget_height"));
        int r0 = r4.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_track_side_padding, "dimen", "mtrl_slider_track_side_padding"));
        this.t = r0;
        this.y = r0;
        this.u = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_thumb_radius, "dimen", "mtrl_slider_thumb_radius"));
        this.z = r4.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_track_top, "dimen", "mtrl_slider_track_top"));
        this.C = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_label_padding, "dimen", "mtrl_slider_label_padding"));
    }

    private void a(Canvas r6) {
        if (this.O == true) goto L5;
        return;
    L5:
        if (this.M <= 0.0f) goto L10;
        float[] r0 = getActiveRange();
        int r1 = a(this.N, r0[0]);
        int r2 = a(this.N, r0[1]);
        int r3 = r1 * 2;
        r6.drawPoints(this.N, 0, r3, this.g);
        int r4 = r2 * 2;
        r6.drawPoints(this.N, r3, r4 - r3, this.h);
        float[] r5 = this.N;
        r6.drawPoints(r5, r4, r5.length - r4, this.g);
        return;
    }

    private void a(Canvas r12, int r13, int r14) {
        float[] r0 = getActiveRange();
        int r1 = this.y;
        float r4 = r13;
        float r6 = r1 + (r0[1] * r4);
        if (r6 >= (r1 + r13)) goto L5;
        float r9 = r14;
        r12.drawLine(r6, r9, r1 + r13, r9, this.c);
    L5:
        int r15 = this.y;
        float r5 = r15 + (r0[0] * r4);
        if (r5 <= r15) goto L9;
        float r7 = r14;
        r12.drawLine(r15, r7, r5, r7, this.c);
        return;
    }

    private void a(Canvas r2, int r3, int r4, float r5, Drawable r6) {
        r2.save();
        r2.translate((this.y + ((int) (c(r5) * r3))) - (r6.getBounds().width() / 2.0f), r4 - (r6.getBounds().height() / 2.0f));
        r6.draw(r2);
        r2.restore();
    }

    private void a(TooltipDrawable r1) {
        r1.setRelativeToView(r.f(this));
    }

    private void a(TooltipDrawable r4, float r5) {
        r4.setText(h(r5));
        int r0 = (this.y + ((int) (c(r5) * this.P))) - (r4.getIntrinsicWidth() / 2);
        int r6 = p() - (this.C + this.A);
        r4.setBounds(r0, r6 - r4.getIntrinsicHeight(), r4.getIntrinsicWidth() + r0, r6);
        Rect r7 = new Rect(r4.getBounds());
        d.a(r.f(this), this, r7);
        r4.setBounds(r7);
        r.g(this).a(r4);
    }

    private boolean a(float r2) {
        return b(r2 - this.H);
    }

    private boolean a(int r5, float r6) {
        this.L = r5;
        if (Math.abs(r6 - ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r5), Float.class, "com.obric.memorydata.plugin")).floatValue()) >= 1.0E-4d) goto L6;
        return false;
    L6:
        this.f4071J.set(r5, Float.valueOf(b(r5, r6)));
        b(r5);
        return true;
    }

    static /* synthetic */ boolean a(BaseSlider r0, int r1, float r2) {
        return r0.a(r1, r2);
    }

    private float b(int r5, float r6) {
        float r0 = getMinSeparation();
        if (this.af != 0) goto L6;
        r0 = f(r0);
    L6:
        if (c() == false) goto L8;
        r0 = -r0;
    L8:
        int r1 = r5 + 1;
        if (r1 < this.f4071J.size()) goto L11;
        float r2 = this.I;
    L12:
        int r7 = r5 - 1;
        if (r7 >= 0) goto L15;
        float r4 = this.H;
    L17:
        return MathUtils.clamp(r6, r4, r2);
    L15:
        r4 = ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r7), Float.class, "com.obric.memorydata.plugin")).floatValue() + r0;
        goto L17
    L11:
        r2 = ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r1), Float.class, "com.obric.memorydata.plugin")).floatValue() - r0;
        goto L12
    }

    static /* synthetic */ AccessibilityHelper b(BaseSlider r0) {
        return r0.i;
    }

    private static TooltipDrawable b(Context r4, TypedArray r5) {
        return TooltipDrawable.createFromAttributes((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), null, 0, r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.Slider_labelStyle, "styleable", "Slider_labelStyle"), ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Tooltip, "style", "Widget_MaterialComponents_Tooltip")));
    }

    private void b(int r6) {
        Iterator<L> r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.a) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.a.class, "com.obric.memorydata.plugin")).a(this, ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r6), Float.class, "com.obric.memorydata.plugin")).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r1 = this.j;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEnabled() == false) goto L14;
        h(r6);
        return;
    }

    private void b(Canvas r11, int r12, int r13) {
        float[] r0 = getActiveRange();
        int r1 = this.y;
        float r14 = r12;
        float r8 = r13;
        r11.drawLine(r1 + (r0[0] * r14), r8, r1 + (r0[1] * r14), r8, this.d);
    }

    private void b(Drawable r5) {
        int r4 = this.A * 2;
        int r0 = r5.getIntrinsicWidth();
        int r1 = r5.getIntrinsicHeight();
        if (r0 != (-1)) goto L6;
        if (r1 != (-1)) goto L6;
        r5.setBounds(0, 0, r4, r4);
        return;
    L6:
        float r6 = r4 / Math.max(r0, r1);
        r5.setBounds(0, 0, (int) (r0 * r6), (int) (r1 * r6));
    }

    private void b(TooltipDrawable r2) {
        q r0 = r.g(this);
        if (r0 == null) goto L6;
        r0.b(r2);
        r2.detachView(r.f(this));
        return;
    }

    private boolean b(float r3) {
        double r2 = new BigDecimal(Float.toString(r3)).divide(new BigDecimal(Float.toString(this.M)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r2) - r2) >= 1.0E-4d) goto L5;
        return true;
    L5:
        return false;
    }

    private float c(float r3) {
        float r0 = this.H;
        float r4 = (r3 - r0) / (this.I - r0);
        if (c() == true) goto L5;
        return r4;
    L5:
        return 1.0f - r4;
    }

    private void c(Canvas r11, int r12, int r13) {
        int r0 = 0;
    L4:
        if (r0 >= this.f4071J.size()) goto L16;
        float r8 = ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r0), Float.class, "com.obric.memorydata.plugin")).floatValue();
        Drawable r9 = this.ac;
        if (r9 == null) goto L9;
    L7:
        a(r11, r12, r13, r8, r9);
        r0 = r0 + 1;
        goto L4
    L9:
        if (r0 >= this.ad.size()) goto L12;
        r9 = (Drawable) ZeusTransformUtils.preCheckCast(this.ad.get(r0), Drawable.class, "com.obric.memorydata.plugin");
        goto L7
    L12:
        if (isEnabled() == true) goto L14;
        r11.drawCircle(this.y + (c(r8) * r12), r13, this.A, this.e);
    L14:
        r9 = this.ab;
        goto L7
    }

    static /* synthetic */ void c(BaseSlider r0) {
        r0.o();
    }

    private boolean c(int r12) {
        int r0 = this.L;
        int r13 = (int) MathUtils.clamp(((long) r0) + ((long) r12), 0, this.f4071J.size() - 1);
        this.L = r13;
        if (r13 != r0) goto L7;
        return false;
    L7:
        if (this.K == (-1)) goto L9;
        this.K = r13;
    L9:
        o();
        postInvalidate();
        return true;
    }

    private double d(float r3) {
        float r0 = this.M;
        if (r0 <= 0.0f) goto L7;
        int r2 = (int) ((this.I - this.H) / r0);
        return ((double) Math.round(r3 * r2)) / ((double) r2);
    L7:
        return r3;
    }

    private void d() {
        int r0 = Math.max(this.A - this.u, 0);
        this.y = this.t + r0;
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        a(getWidth());
        return;
    }

    private void d(Canvas r9, int r10, int r11) {
        if (q() == false) goto L9;
        int r12 = (int) (this.y + (c(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(this.L), Float.class, "com.obric.memorydata.plugin")).floatValue()) * r10));
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        int r0 = this.B;
        r9.clipRect(r12 - r0, r11 - r0, r12 + r0, r0 + r11, Region.Op.UNION);
    L7:
        r9.drawCircle(r12, r11, this.B, this.f);
        return;
    }

    private boolean d(int r2) {
        if (c() == false) goto L9;
        if (r2 != Integer.MIN_VALUE) goto L7;
        r2 = Integer.MAX_VALUE;
        goto L9
    L7:
        r2 = -r2;
    L9:
        return c(r2);
    }

    private Float e(int r3) {
        if (this.R == false) goto L5;
        float r0 = f(20);
    L7:
        if (r3 == 21) goto L28;
        if (r3 == 22) goto L23;
        if (r3 == 69) goto L21;
        if (r3 == 70) goto L19;
        if (r3 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r0);
    L21:
        return Float.valueOf(-r0);
    L23:
        if (c() == false) goto L26;
        r0 = -r0;
    L26:
        return Float.valueOf(r0);
    L28:
        if (c() == true) goto L32;
        r0 = -r0;
    L32:
        return Float.valueOf(r0);
    L5:
        r0 = z();
        goto L7
    }

    private void e() {
        if (this.H >= this.I) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.valueOf(this.H), Float.valueOf(this.I)}));
    }

    private boolean e(float r2) {
        return a(this.K, r2);
    }

    private float f(float r3) {
        if (r3 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r4 = (r3 - this.y) / this.P;
        float r0 = this.H;
        return (r4 * (r0 - this.I)) + r0;
    }

    private float f(int r3) {
        float r0 = z();
        float r1 = (this.I - this.H) / r0;
        float r2 = r3;
        if (r1 > r2) goto L6;
        return r0;
    L6:
        return Math.round(r1 / r2) * r0;
    }

    private void f() {
        if (this.I <= this.H) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[]{Float.valueOf(this.I), Float.valueOf(this.H)}));
    }

    private float g(float r2) {
        return (c(r2) * this.P) + this.y;
    }

    private void g() {
        if (this.M > 0.0f) goto L5;
        return;
    L5:
        if (a(this.I) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.valueOf(this.M), Float.valueOf(this.H), Float.valueOf(this.I)}));
    }

    private void g(int r4) {
        if (r4 != 1) goto L5;
        c(Integer.MAX_VALUE);
        return;
    L5:
        if (r4 != 2) goto L7;
        c(Integer.MIN_VALUE);
        return;
    L7:
        if (r4 != 17) goto L9;
        d(Integer.MAX_VALUE);
        return;
    L9:
        if (r4 != 66) goto L19;
        d(Integer.MIN_VALUE);
        return;
    }

    private float[] getActiveRange() {
        float r0 = ((Float) ZeusTransformUtils.preCheckCast(Collections.max(getValues()), Float.class, "com.obric.memorydata.plugin")).floatValue();
        float r1 = ((Float) ZeusTransformUtils.preCheckCast(Collections.min(getValues()), Float.class, "com.obric.memorydata.plugin")).floatValue();
        if (this.f4071J.size() != 1) goto L5;
        r1 = this.H;
    L5:
        float r2 = c(r1);
        float r3 = c(r0);
        if (c() == false) goto L9;
        return new float[]{r3, r2};
    L9:
        return new float[]{r2, r3};
    }

    private float getValueOfTouchPosition() {
        double r0 = d(this.ae);
        if (c() == false) goto L5;
        r0 = 1.0d - r0;
    L5:
        float r2 = this.I;
        float r4 = this.H;
        return (float) ((r0 * ((double) (r2 - r4))) + ((double) r4));
    }

    private float getValueOfTouchPositionAbsolute() {
        float r0 = this.ae;
        if (c() == false) goto L5;
        r0 = 1.0f - r0;
    L5:
        float r1 = this.I;
        float r2 = this.H;
        return (r0 * (r1 - r2)) + r2;
    }

    private String h(float r3) {
        if (a() == false) goto L7;
        return this.F.a(r3);
    L7:
        if (((int) r3) != r3) goto L9;
        String r2 = "%.0f";
    L11:
        return String.format(r2, new Object[]{Float.valueOf(r3)});
    L9:
        r2 = "%.2f";
        goto L11
    }

    private void h() {
        Iterator<Float> r0 = this.f4071J.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(r0.next(), Float.class, "com.obric.memorydata.plugin");
        if (r1.floatValue() < this.H) goto L17;
        if (r1.floatValue() > this.I) goto L17;
        if (this.M <= 0.0f) goto L4;
        if (a(r1.floatValue()) == true) goto L4;
        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{r1, Float.valueOf(this.H), Float.valueOf(this.M), Float.valueOf(this.M)}));
    L17:
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{r1, Float.valueOf(this.H), Float.valueOf(this.I)}));
    }

    private void h(int r3) {
        BaseSlider<S, L, T>.a r0 = this.k;
        if (r0 != null) goto L5;
        this.k = new a(this, null);
    L6:
        this.k.a(r3);
        postDelayed(this.k, 200);
        return;
    L5:
        removeCallbacks(r0);
        goto L6
    }

    private void i() {
        float r0 = getMinSeparation();
        if (r0 < 0.0f) goto L21;
        float r2 = this.M;
        if (r2 > 0.0f) goto L7;
        return;
    L7:
        if (r0 > 0.0f) goto L9;
        return;
    L9:
        if (this.af != 1) goto L18;
        if (r0 < r2) goto L16;
        if (b(r0) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.valueOf(r0), Float.valueOf(this.M), Float.valueOf(this.M)}));
    L18:
        throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", new Object[]{Float.valueOf(r0), Float.valueOf(this.M)}));
    L21:
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", new Object[]{Float.valueOf(r0)}));
    }

    private void j() {
        float r0 = this.M;
        if (r0 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r0) == r0) goto L8;
        Log.w(f4070b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"stepSize", Float.valueOf(r0)}));
    L8:
        float r1 = this.H;
        if (((int) r1) == r1) goto L11;
        Log.w(f4070b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"valueFrom", Float.valueOf(r1)}));
    L11:
        float r8 = this.I;
        if (((int) r8) == r8) goto L15;
        Log.w(f4070b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"valueTo", Float.valueOf(r8)}));
        return;
    }

    private void k() {
        if (this.S == false) goto L6;
        e();
        f();
        g();
        h();
        i();
        j();
        this.S = false;
        return;
    }

    private void l() {
        if (this.m.size() <= this.f4071J.size()) goto L12;
        List<TooltipDrawable> r0 = this.m.subList(this.f4071J.size(), this.m.size());
        Iterator<TooltipDrawable> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        TooltipDrawable r3 = (TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        b(r3);
        goto L6
    L10:
        r0.clear();
    L12:
        if (this.m.size() >= this.f4071J.size()) goto L16;
        TooltipDrawable r2 = this.l.a();
        this.m.add(r2);
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        a(r2);
        goto L12
    L16:
        int r4 = 1;
        if (this.m.size() != 1) goto L19;
        r4 = 0;
    L19:
        Iterator<TooltipDrawable> r5 = this.m.iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        ((TooltipDrawable) ZeusTransformUtils.preCheckCast(r5.next(), TooltipDrawable.class, "com.obric.memorydata.plugin")).setStrokeWidth(r4);
        goto L21
    }

    private boolean m() {
        if (this.w != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private void n() {
        if (this.M > 0.0f) goto L5;
        return;
    L5:
        k();
        int r0 = Math.min((int) (((this.I - this.H) / this.M) + 1.0f), (this.P / (this.x * 2)) + 1);
        float[] r1 = this.N;
        if (r1 != null) goto L8;
    L9:
        this.N = new float[r0 * 2];
    L10:
        float r2 = this.P / (r0 - 1);
        int r3 = 0;
    L12:
        if (r3 >= (r0 * 2)) goto L14;
        float[] r4 = this.N;
        r4[r3] = this.y + ((r3 / 2) * r2);
        r4[r3 + 1] = p();
        r3 = r3 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r1.length == (r0 * 2)) goto L10;
        goto L9
    }

    private void o() {
        if (q() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r0 = getBackground();
        if (ZeusTransformUtils.instanceOf(r0, RippleDrawable.class) == false) goto L12;
        int r1 = (int) ((c(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(this.L), Float.class, "com.obric.memorydata.plugin")).floatValue()) * this.P) + this.y);
        int r2 = p();
        int r5 = this.B;
        DrawableCompat.setHotspotBounds(r0, r1 - r5, r2 - r5, r1 + r5, r2 + r5);
        return;
    L12:
        return;
    }

    private int p() {
        int r0 = this.z;
        int r2 = 0;
        if (this.w != 1) goto L5;
    L6:
        r2 = ((TooltipDrawable) ZeusTransformUtils.preCheckCast(this.m.get(0), TooltipDrawable.class, "com.obric.memorydata.plugin")).getIntrinsicHeight();
    L8:
        return r0 + r2;
    L5:
        if (m() == false) goto L8;
        goto L6
    }

    private boolean q() {
        if (this.Q == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        if (ZeusTransformUtils.instanceOf(getBackground(), RippleDrawable.class) == false) goto L10;
        return false;
    }

    private boolean r() {
        return e(getValueOfTouchPosition());
    }

    private void s() {
        if (this.p == false) goto L6;
        this.p = false;
        ValueAnimator r0 = a(false);
        this.r = r0;
        this.q = null;
        r0.addListener(new AnonymousClass3(this));
        this.r.start();
        return;
    }

    private void setValuesInternal(ArrayList<Float> r3) {
        if (r3.isEmpty() == true) goto L12;
        Collections.sort(r3);
        if (this.f4071J.size() == r3.size()) goto L7;
    L9:
        this.f4071J = r3;
        this.S = true;
        this.L = 0;
        o();
        l();
        w();
        postInvalidate();
        return;
    L7:
        if (this.f4071J.equals(r3) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void t() {
        if (this.w != 2) goto L6;
        return;
    L6:
        if (this.p == true) goto L8;
        this.p = true;
        ValueAnimator r0 = a(true);
        this.q = r0;
        this.r = null;
        r0.start();
    L8:
        Iterator<TooltipDrawable> r1 = this.m.iterator();
        int r4 = 0;
    L10:
        if (r4 >= this.f4071J.size()) goto L19;
        if (r1.hasNext() == false) goto L19;
        if (r4 == this.L) goto L17;
        a((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.memorydata.plugin"), ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r4), Float.class, "com.obric.memorydata.plugin")).floatValue());
    L17:
        r4 = r4 + 1;
    L19:
        if (r1.hasNext() == false) goto L23;
        a((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.memorydata.plugin"), ((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(this.L), Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L23:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.m.size()), Integer.valueOf(this.f4071J.size())}));
    }

    private void u() {
        this.c.setStrokeWidth(this.x);
        this.d.setStrokeWidth(this.x);
        this.g.setStrokeWidth(this.x / 2.0f);
        this.h.setStrokeWidth(this.x / 2.0f);
    }

    private boolean v() {
        ViewParent r4 = getParent();
    L3:
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L15;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r0.canScrollVertically(1) == false) goto L8;
    L9:
        r1 = true;
    L10:
        if (r1 == false) goto L14;
        if (r0.shouldDelayChildPressedState() == false) goto L14;
        return true;
    L14:
        r4 = r4.getParent();
        goto L3
    L8:
        if (r0.canScrollVertically(-1) == false) goto L10;
    L15:
        return false;
    }

    private void w() {
        Iterator<L> r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.google.android.material.slider.a r1 = (com.google.android.material.slider.a) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.a.class, "com.obric.memorydata.plugin");
        Iterator<Float> r2 = this.f4071J.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r1.a(this, ((Float) ZeusTransformUtils.preCheckCast(r2.next(), Float.class, "com.obric.memorydata.plugin")).floatValue(), false);
        goto L7
    }

    private void x() {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.b) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.b.class, "com.obric.memorydata.plugin")).a(this);
        goto L4
    }

    private void y() {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.b) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.b.class, "com.obric.memorydata.plugin")).b(this);
        goto L4
    }

    private float z() {
        float r1 = this.M;
        if (r1 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r1;
    }

    void a(int r4, Rect r5) {
        int r0 = this.y + ((int) (c(((Float) ZeusTransformUtils.preCheckCast(getValues().get(r4), Float.class, "com.obric.memorydata.plugin")).floatValue()) * this.P));
        int r6 = p();
        int r3 = this.A;
        r5.set(r0 - r3, r6 - r3, r0 + r3, r6 + r3);
    }

    public boolean a() {
        if (this.F == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.K == (-1)) goto L5;
        return true;
    L5:
        float r0 = getValueOfTouchPositionAbsolute();
        float r3 = g(r0);
        this.K = 0;
        float r5 = Math.abs(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(0), Float.class, "com.obric.memorydata.plugin")).floatValue() - r0);
        int r6 = 1;
    L7:
        if (r6 >= this.f4071J.size()) goto L34;
        float r8 = Math.abs(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r6), Float.class, "com.obric.memorydata.plugin")).floatValue() - r0);
        float r9 = g(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(r6), Float.class, "com.obric.memorydata.plugin")).floatValue());
        if (Float.compare(r8, r5) > 1) goto L34;
        if (c() == false) goto L17;
        if ((r9 - r3) > 0.0f) goto L18;
    L19:
        boolean r10 = false;
    L21:
        if (Float.compare(r8, r5) >= 0) goto L24;
    L22:
        this.K = r6;
        r5 = r8;
    L32:
        r6 = r6 + 1;
        goto L7
    L24:
        if (Float.compare(r8, r5) != 0) goto L32;
        if (Math.abs(r9 - r3) < this.s) goto L27;
        if (r10 == false) goto L32;
    L27:
        this.K = -1;
        return false;
    L18:
        r10 = true;
        goto L21
    L17:
        if ((r9 - r3) >= 0.0f) goto L19;
    L34:
        if (this.K == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    final boolean c() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent r2) {
        if (this.i.dispatchHoverEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.c.setColor(a(this.aa));
        this.d.setColor(a(this.W));
        this.g.setColor(a(this.V));
        this.h.setColor(a(this.U));
        Iterator<TooltipDrawable> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        TooltipDrawable r1 = (TooltipDrawable) ZeusTransformUtils.preCheckCast(r0.next(), TooltipDrawable.class, "com.obric.memorydata.plugin");
        if (r1.isStateful() == false) goto L4;
        r1.setState(getDrawableState());
        goto L4
    L9:
        if (this.ab.isStateful() == false) goto L11;
        this.ab.setState(getDrawableState());
    L11:
        this.f.setColor(a(this.T));
        this.f.setAlpha(63);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.i.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.K;
    }

    public int getFocusedThumbIndex() {
        return this.L;
    }

    public int getHaloRadius() {
        return this.B;
    }

    public ColorStateList getHaloTintList() {
        return this.T;
    }

    public int getLabelBehavior() {
        return this.w;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.M;
    }

    public float getThumbElevation() {
        return this.ab.getElevation();
    }

    public int getThumbRadius() {
        return this.A;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.ab.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.ab.getStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return this.ab.getFillColor();
    }

    public ColorStateList getTickActiveTintList() {
        return this.U;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.V;
    }

    public ColorStateList getTickTintList() {
        if (this.V.equals(this.U) == false) goto L7;
        return this.U;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.W;
    }

    public int getTrackHeight() {
        return this.x;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.aa;
    }

    public int getTrackSidePadding() {
        return this.y;
    }

    public ColorStateList getTrackTintList() {
        if (this.aa.equals(this.W) == false) goto L7;
        return this.W;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.P;
    }

    public float getValueFrom() {
        return this.H;
    }

    public float getValueTo() {
        return this.I;
    }

    List<Float> getValues() {
        return new ArrayList(this.f4071J);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((TooltipDrawable) ZeusTransformUtils.preCheckCast(r0.next(), TooltipDrawable.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.a r0 = this.k;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        this.p = false;
        Iterator<TooltipDrawable> r1 = this.m.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        b((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (this.S == false) goto L5;
        k();
        n();
    L5:
        super.onDraw(r5);
        int r0 = p();
        a(r5, this.P, r0);
        if (((Float) ZeusTransformUtils.preCheckCast(Collections.max(getValues()), Float.class, "com.obric.memorydata.plugin")).floatValue() <= this.H) goto L8;
        b(r5, this.P, r0);
    L8:
        a(r5);
        if (this.G == true) goto L15;
        if (isFocused() == true) goto L15;
        if (m() == true) goto L15;
    L21:
        s();
    L22:
        c(r5, this.P, r0);
        return;
    L15:
        if (isEnabled() == false) goto L21;
        d(r5, this.P, r0);
        if (this.K == (-1)) goto L19;
    L20:
        t();
        goto L22
    L19:
        if (m() == false) goto L21;
        goto L20
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        this.K = -1;
        this.i.clearKeyboardFocusForVirtualView(this.L);
        return;
    L5:
        g(r2);
        this.i.requestKeyboardFocusForVirtualView(this.L);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r6, KeyEvent r7) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r6, r7);
    L7:
        if (this.f4071J.size() != 1) goto L10;
        this.K = 0;
    L10:
        if (this.K != (-1)) goto L16;
        Boolean r0 = a(r6, r7);
        if (r0 == null) goto L15;
        return r0.booleanValue();
    L15:
        return super.onKeyDown(r6, r7);
    L16:
        this.R |= r7.isLongPress();
        Float r1 = e(r6);
        if (r1 == null) goto L23;
        if (e(((Float) ZeusTransformUtils.preCheckCast(this.f4071J.get(this.K), Float.class, "com.obric.memorydata.plugin")).floatValue() + r1.floatValue()) == false) goto L21;
        o();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r6 != 23) goto L25;
    L39:
        this.K = -1;
        postInvalidate();
        return true;
    L25:
        if (r6 == 61) goto L31;
        if (r6 == 66) goto L39;
        return super.onKeyDown(r6, r7);
    L31:
        if (r7.hasNoModifiers() == false) goto L35;
        return c(1);
    L35:
        if (r7.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return c(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        this.R = false;
        return super.onKeyUp(r2, r3);
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        int r6 = this.v;
        int r1 = 0;
        if (this.w != 1) goto L5;
    L6:
        r1 = ((TooltipDrawable) ZeusTransformUtils.preCheckCast(this.m.get(0), TooltipDrawable.class, "com.obric.memorydata.plugin")).getIntrinsicHeight();
    L7:
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec(r6 + r1, 1073741824));
        return;
    L5:
        if (m() == false) goto L7;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SliderState r4 = (SliderState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"), SliderState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r4.getSuperState());
        this.H = r4.valueFrom;
        this.I = r4.valueTo;
        setValuesInternal(r4.values);
        this.M = r4.stepSize;
        if (r4.hasFocus == false) goto L6;
        requestFocus();
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState r1 = new SliderState(super.onSaveInstanceState());
        r1.valueFrom = this.H;
        r1.valueTo = this.I;
        r1.values = new ArrayList(this.f4071J);
        r1.stepSize = this.M;
        r1.hasFocus = hasFocus();
        return r1;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        a(r1);
        o();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r0 = r6.getX();
        float r2 = (r0 - this.y) / this.P;
        this.ae = r2;
        float r3 = Math.max(0.0f, r2);
        this.ae = r3;
        this.ae = Math.min(1.0f, r3);
        int r4 = r6.getActionMasked();
        if (r4 == 0) goto L38;
        if (r4 != 1) goto L9;
        this.G = false;
        MotionEvent r1 = this.E;
        if (r1 == null) goto L35;
        if (r1.getActionMasked() != 0) goto L35;
        if (Math.abs(this.E.getX() - r6.getX()) > this.s) goto L35;
        if (Math.abs(this.E.getY() - r6.getY()) > this.s) goto L35;
        if (b() == false) goto L35;
        x();
    L35:
        if (this.K == (-1)) goto L37;
        r();
        this.K = -1;
        y();
    L37:
        invalidate();
    L45:
        setPressed(this.G);
        this.E = MotionEvent.obtain(r6);
        return true;
    L9:
        if (r4 != 2) goto L45;
        if (this.G == true) goto L20;
        if (v() == true) goto L16;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        x();
        goto L20
    L16:
        if (Math.abs(r0 - this.D) >= this.s) goto L18;
        return false;
    L20:
        if (b() == false) goto L45;
        this.G = true;
        r();
        o();
        goto L37
    L38:
        this.D = r0;
        if (v() == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (b() == false) goto L45;
        requestFocus();
        this.G = true;
        r();
        o();
        invalidate();
        x();
        goto L45
    }

    public void setActiveThumbIndex(int r1) {
        this.K = r1;
    }

    void setCustomThumbDrawable(int r2) {
        setCustomThumbDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(r2));
    }

    void setCustomThumbDrawable(Drawable r1) {
        this.ac = a(r1);
        this.ad.clear();
        postInvalidate();
    }

    void setCustomThumbDrawablesForValues(int... r5) {
        Drawable[] r0 = new Drawable[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0[r1] = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        setCustomThumbDrawablesForValues(r0);
    }

    void setCustomThumbDrawablesForValues(Drawable... r5) {
        this.ac = null;
        this.ad = new ArrayList();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Drawable r2 = r5[r1];
        this.ad.add(a(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        setLayerType(r3, null);
        return;
    L5:
        r3 = 2;
        goto L6
    }

    public void setFocusedThumbIndex(int r2) {
        if (r2 < 0) goto L8;
        if (r2 >= this.f4071J.size()) goto L8;
        this.L = r2;
        this.i.requestKeyboardFocusForVirtualView(r2);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(int r3) {
        if (r3 != this.B) goto L5;
        return;
    L5:
        this.B = r3;
        Drawable r4 = getBackground();
        if (q() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, RippleDrawable.class) == false) goto L11;
        com.google.android.material.d.a.a((RippleDrawable) ZeusTransformUtils.preCheckCast(r4, RippleDrawable.class, "com.obric.memorydata.plugin"), this.B);
    }

    public void setHaloRadiusResource(int r2) {
        setHaloRadius(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
    }

    public void setHaloTintList(ColorStateList r3) {
        if (r3.equals(this.T) == false) goto L5;
        return;
    L5:
        this.T = r3;
        Drawable r0 = getBackground();
        if (q() == false) goto L8;
    L11:
        this.f.setColor(a(r3));
        this.f.setAlpha(63);
        invalidate();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, RippleDrawable.class) == false) goto L11;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(r0, RippleDrawable.class, "com.obric.memorydata.plugin")).setColor(r3);
    }

    public void setLabelBehavior(int r2) {
        if (this.w == r2) goto L6;
        this.w = r2;
        requestLayout();
        return;
    }

    public void setLabelFormatter(c r3) {
        this.F = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public void setSeparationUnit(int r1) {
        this.af = r1;
        this.S = true;
        postInvalidate();
    }

    public void setStepSize(float r5) {
        if (r5 < 0.0f) goto L9;
        if (this.M == r5) goto L10;
        this.M = r5;
        this.S = true;
        postInvalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.valueOf(r5), Float.valueOf(this.H), Float.valueOf(this.I)}));
    }

    public void setThumbElevation(float r1) {
        this.ab.setElevation(r1);
    }

    public void setThumbElevationResource(int r2) {
        setThumbElevation(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(r2));
    }

    public void setThumbRadius(int r4) {
        if (r4 != this.A) goto L5;
        return;
    L5:
        this.A = r4;
        d();
        this.ab.setShapeAppearanceModel(l.a().a(0, this.A).a());
        MaterialShapeDrawable r5 = this.ab;
        int r0 = this.A;
        r5.setBounds(0, 0, r0 * 2, r0 * 2);
        Drawable r6 = this.ac;
        if (r6 == null) goto L8;
        b(r6);
    L8:
        Iterator<Drawable> r7 = this.ad.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        b((Drawable) ZeusTransformUtils.preCheckCast(r7.next(), Drawable.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        postInvalidate();
    }

    public void setThumbRadiusResource(int r2) {
        setThumbRadius(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
    }

    public void setThumbStrokeColor(ColorStateList r2) {
        this.ab.setStrokeColor(r2);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int r4) {
        if (r4 == 0) goto L5;
        setThumbStrokeColor(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
        return;
    }

    public void setThumbStrokeWidth(float r2) {
        this.ab.setStrokeWidth(r2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int r2) {
        if (r2 == 0) goto L5;
        setThumbStrokeWidth(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(r2));
        return;
    }

    public void setThumbTintList(ColorStateList r2) {
        if (r2.equals(this.ab.getFillColor()) == false) goto L5;
        return;
    L5:
        this.ab.setFillColor(r2);
        invalidate();
    }

    public void setTickActiveTintList(ColorStateList r2) {
        if (r2.equals(this.U) == false) goto L5;
        return;
    L5:
        this.U = r2;
        this.h.setColor(a(r2));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList r2) {
        if (r2.equals(this.V) == false) goto L5;
        return;
    L5:
        this.V = r2;
        this.g.setColor(a(r2));
        invalidate();
    }

    public void setTickTintList(ColorStateList r1) {
        setTickInactiveTintList(r1);
        setTickActiveTintList(r1);
    }

    public void setTickVisible(boolean r2) {
        if (this.O == r2) goto L6;
        this.O = r2;
        postInvalidate();
        return;
    }

    public void setTrackActiveTintList(ColorStateList r2) {
        if (r2.equals(this.W) == false) goto L5;
        return;
    L5:
        this.W = r2;
        this.d.setColor(a(r2));
        invalidate();
    }

    public void setTrackHeight(int r2) {
        if (this.x == r2) goto L6;
        this.x = r2;
        u();
        postInvalidate();
        return;
    }

    public void setTrackInactiveTintList(ColorStateList r2) {
        if (r2.equals(this.aa) == false) goto L5;
        return;
    L5:
        this.aa = r2;
        this.c.setColor(a(r2));
        invalidate();
    }

    public void setTrackTintList(ColorStateList r1) {
        setTrackInactiveTintList(r1);
        setTrackActiveTintList(r1);
    }

    public void setValueFrom(float r1) {
        this.H = r1;
        this.S = true;
        postInvalidate();
    }

    public void setValueTo(float r1) {
        this.I = r1;
        this.S = true;
        postInvalidate();
    }

    void setValues(List<Float> r3) {
        setValuesInternal(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")));
    }

    void setValues(Float... r2) {
        ArrayList<Float> r0 = new ArrayList();
        Collections.addAll(r0, r2);
        setValuesInternal(r0);
    }
}
