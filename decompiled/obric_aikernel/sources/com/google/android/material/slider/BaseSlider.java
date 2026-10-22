package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q5.j;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final String f3713j0 = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    static final int f3714k0 = 0;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private MotionEvent H;
    private com.google.android.material.slider.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f3715J;
    private float K;
    private float L;
    private ArrayList<Float> M;
    private int N;
    private int O;
    private float P;
    private float[] Q;
    private boolean R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;

    @NonNull
    private ColorStateList W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @NonNull
    private ColorStateList f3716a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @NonNull
    private ColorStateList f3717b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Paint f3718c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @NonNull
    private ColorStateList f3719c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @NonNull
    private ColorStateList f3720d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f3721e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    private Drawable f3722f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final Paint f3723g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @NonNull
    private List<Drawable> f3724g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final Paint f3725h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f3726h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final Paint f3727i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f3728i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final Paint f3729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private final Paint f3730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private final AccessibilityHelper f3731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AccessibilityManager f3732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BaseSlider<S, L, T>.d f3733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    private final e f3734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    private final List<TooltipDrawable> f3735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    private final List<L> f3736q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    private final List<T> f3737r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3738s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ValueAnimator f3739t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ValueAnimator f3740u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f3741v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3742w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3743x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f3744y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3745z;

    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        AccessibilityHelper(BaseSlider<?, ?, ?> r10) {
            super(r10);
            this.virtualViewBounds = new Rect();
            this.slider = r10;
        }

        @NonNull
        private String startOrEndDescription(int r10) {
            if (r10 != (this.slider.getValues().size() - 1)) goto L7;
            Context r11 = this.slider.getContext();
            int r12 = j.material_slider_range_end;
        L6:
            return r11.getString(r12);
        L7:
            if (r10 != 0) goto L9;
            r11 = this.slider.getContext();
            r12 = j.material_slider_range_start;
            goto L6
        L9:
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.slider.getValues().size()) goto L9;
            this.slider.h0(r12, this.virtualViewBounds);
            if (this.virtualViewBounds.contains((int) r10, (int) r11) == true) goto L7;
            r12 = r12 + 1;
            goto L4
        L7:
            return r12;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.slider.getValues().size()) goto L6;
            r10.add(Integer.valueOf(r11));
            r11 = r11 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int r10, int r11, Bundle r12) {
            if (this.slider.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r11 == 4096) goto L20;
            if (r11 == 8192) goto L20;
            if (r11 == 16908349) goto L11;
            return false;
        L11:
            if (r12 != null) goto L13;
        L19:
            return false;
        L13:
            if (r12.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) == false) goto L19;
            float r13 = r12.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
            if (BaseSlider.e(this.slider, r10, r13) == false) goto L19;
        L17:
            BaseSlider.f(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r10);
            return true;
        L20:
            float r14 = BaseSlider.g(this.slider, 20);
            if (r11 != 8192) goto L24;
            r14 = -r14;
        L24:
            if (this.slider.J() == false) goto L26;
            r14 = -r14;
        L26:
            float r15 = MathUtils.clamp(this.slider.getValues().get(r10).floatValue() + r14, this.slider.getValueFrom(), this.slider.getValueTo());
            if (BaseSlider.e(this.slider, r10, r15) == true) goto L17;
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r10, AccessibilityNodeInfoCompat r11) {
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> r12 = this.slider.getValues();
            float r13 = r12.get(r10).floatValue();
            float r14 = this.slider.getValueFrom();
            float r15 = this.slider.getValueTo();
            if (this.slider.isEnabled() == true) goto L5;
        L10:
            r11.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, r14, r15, r13));
            r11.setClassName(SeekBar.class.getName());
            StringBuilder r16 = new StringBuilder();
            if (this.slider.getContentDescription() == null) goto L14;
            r16.append(this.slider.getContentDescription());
            r16.append(",");
        L14:
            if (r12.size() <= 1) goto L16;
            r16.append(startOrEndDescription(r10));
            r16.append(BaseSlider.d(this.slider, r13));
        L16:
            r11.setContentDescription(r16.toString());
            this.slider.h0(r10, this.virtualViewBounds);
            r11.setBoundsInParent(this.virtualViewBounds);
            return;
        L5:
            if (r13 <= r14) goto L8;
            r11.addAction(8192);
        L8:
            if (r13 >= r15) goto L10;
            r11.addAction(4096);
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

        class a implements Parcelable.Creator<SliderState> {
            a() {
            }

            @NonNull
            public SliderState a(@NonNull Parcel r10) {
                return new SliderState(r10, null);
            }

            @NonNull
            public SliderState[] b(int r10) {
                return new SliderState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ SliderState createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ SliderState[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        private SliderState(@NonNull Parcel r10) {
            super(r10);
            this.valueFrom = r10.readFloat();
            this.valueTo = r10.readFloat();
            ArrayList<Float> r11 = new ArrayList();
            this.values = r11;
            r10.readList(r11, Float.class.getClassLoader());
            this.stepSize = r10.readFloat();
            this.hasFocus = r10.createBooleanArray()[0];
        }

        /* synthetic */ SliderState(Parcel r10, a r11) {
            this(r10);
        }

        SliderState(Parcelable r10) {
            super(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeFloat(this.valueFrom);
            r10.writeFloat(this.valueTo);
            r10.writeList(this.values);
            r10.writeFloat(this.stepSize);
            r10.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AttributeSet f3746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseSlider f3748c;

        a(BaseSlider r10, AttributeSet r11, int r12) {
            this.f3748c = r10;
            this.f3746a = r11;
            this.f3747b = r12;
        }

        @Override // com.google.android.material.slider.BaseSlider.e
        public TooltipDrawable a() {
            TypedArray r10 = k.h(this.f3748c.getContext(), this.f3746a, l.Slider, this.f3747b, BaseSlider.f3714k0, new int[0]);
            TooltipDrawable r11 = BaseSlider.a(this.f3748c.getContext(), r10);
            r10.recycle();
            return r11;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseSlider f3749c;

        b(BaseSlider r10) {
            this.f3749c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            Iterator r12 = BaseSlider.b(this.f3749c).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((TooltipDrawable) r12.next()).setRevealFraction(r11);
            goto L4
        L6:
            ViewCompat.postInvalidateOnAnimation(this.f3749c);
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseSlider f3750c;

        c(BaseSlider r10) {
            this.f3750c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            Iterator r11 = BaseSlider.b(this.f3750c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            TooltipDrawable r12 = (TooltipDrawable) r11.next();
            ViewUtils.f(this.f3750c).remove(r12);
            goto L4
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3751c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseSlider f3752g;

        private d(BaseSlider r10) {
            this.f3752g = r10;
            this.f3751c = -1;
        }

        /* synthetic */ d(BaseSlider r10, a r11) {
            this(r10);
        }

        void a(int r10) {
            this.f3751c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.c(this.f3752g).sendEventForVirtualView(this.f3751c, 4);
        }
    }

    private interface e {
        TooltipDrawable a();
    }

    static {
        f3713j0 = BaseSlider.class.getSimpleName();
        f3714k0 = q5.k.Widget_MaterialComponents_Slider;
    }

    public BaseSlider(@NonNull Context r10) {
        this(r10, null);
    }

    public BaseSlider(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.sliderStyle);
    }

    public BaseSlider(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(b6.a.c(r10, r11, r12, f3714k0), r11, r12);
        this.f3735p = new ArrayList();
        this.f3736q = new ArrayList();
        this.f3737r = new ArrayList();
        this.f3738s = false;
        this.f3715J = false;
        this.M = new ArrayList();
        this.N = -1;
        this.O = -1;
        this.P = 0.0f;
        this.R = true;
        this.U = false;
        MaterialShapeDrawable r13 = new MaterialShapeDrawable();
        this.f3721e0 = r13;
        this.f3724g0 = Collections.emptyList();
        this.f3728i0 = 0;
        Context r14 = getContext();
        Paint r15 = new Paint();
        this.f3718c = r15;
        r15.setStyle(Paint.Style.STROKE);
        r15.setStrokeCap(Paint.Cap.ROUND);
        Paint r16 = new Paint();
        this.f3723g = r16;
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeCap(Paint.Cap.ROUND);
        Paint r17 = new Paint(1);
        this.f3725h = r17;
        r17.setStyle(Paint.Style.FILL);
        r17.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r18 = new Paint(1);
        this.f3727i = r18;
        r18.setStyle(Paint.Style.FILL);
        Paint r19 = new Paint();
        this.f3729j = r19;
        r19.setStyle(Paint.Style.STROKE);
        r19.setStrokeCap(Paint.Cap.ROUND);
        Paint r20 = new Paint();
        this.f3730k = r20;
        r20.setStyle(Paint.Style.STROKE);
        r20.setStrokeCap(Paint.Cap.ROUND);
        K(r14.getResources());
        this.f3734o = new a(this, r11, r12);
        Y(r14, r11, r12);
        setFocusable(true);
        setClickable(true);
        r13.setShadowCompatibilityMode(2);
        this.f3741v = ViewConfiguration.get(r14).getScaledTouchSlop();
        AccessibilityHelper r21 = new AccessibilityHelper(this);
        this.f3731l = r21;
        ViewCompat.setAccessibilityDelegate(this, r21);
        this.f3732m = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private String A(float r10) {
        if (E() == false) goto L7;
        return this.I.a(r10);
    L7:
        if (((int) r10) != r10) goto L9;
        String r11 = "%.0f";
    L11:
        return String.format(r11, new Object[]{Float.valueOf(r10)});
    L9:
        r11 = "%.2f";
        goto L11
    }

    private static float B(ValueAnimator r10, float r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r10.isRunning() == false) goto L8;
        float r12 = ((Float) r10.getAnimatedValue()).floatValue();
        r10.cancel();
        return r12;
    L8:
        return r11;
    }

    private float C(int r10, float r11) {
        float r12 = getMinSeparation();
        if (this.f3728i0 != 0) goto L6;
        r12 = q(r12);
    L6:
        if (J() == false) goto L8;
        r12 = -r12;
    L8:
        int r13 = r10 + 1;
        if (r13 < this.M.size()) goto L11;
        float r14 = this.L;
    L12:
        int r15 = r10 - 1;
        if (r15 >= 0) goto L15;
        float r16 = this.K;
    L17:
        return MathUtils.clamp(r11, r16, r14);
    L15:
        r16 = this.M.get(r15).floatValue() + r12;
        goto L17
    L11:
        r14 = this.M.get(r13).floatValue() - r12;
        goto L12
    }

    @ColorInt
    private int D(@NonNull ColorStateList r10) {
        return r10.getColorForState(getDrawableState(), r10.getDefaultColor());
    }

    private Drawable F(Drawable r10) {
        Drawable r11 = r10.mutate().getConstantState().newDrawable();
        h(r11);
        return r11;
    }

    private void G() {
        this.f3718c.setStrokeWidth(this.A);
        this.f3723g.setStrokeWidth(this.A);
        this.f3729j.setStrokeWidth(this.A / 2.0f);
        this.f3730k.setStrokeWidth(this.A / 2.0f);
    }

    private boolean H() {
        ViewParent r10 = getParent();
    L3:
        boolean r11 = false;
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r12 = (ViewGroup) r10;
        if (r12.canScrollVertically(1) == false) goto L8;
    L9:
        r11 = true;
    L10:
        if (r11 == false) goto L14;
        if (r12.shouldDelayChildPressedState() == false) goto L14;
        return true;
    L14:
        r10 = r10.getParent();
        goto L3
    L8:
        if (r12.canScrollVertically(-1) == false) goto L10;
    L15:
        return false;
    }

    private boolean I(float r10) {
        double r11 = new BigDecimal(Float.toString(r10)).divide(new BigDecimal(Float.toString(this.P)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r11) - r11) >= 1.0E-4d) goto L5;
        return true;
    L5:
        return false;
    }

    private void K(@NonNull Resources r10) {
        this.f3744y = r10.getDimensionPixelSize(q5.d.mtrl_slider_widget_height);
        int r11 = r10.getDimensionPixelOffset(q5.d.mtrl_slider_track_side_padding);
        this.f3742w = r11;
        this.B = r11;
        this.f3743x = r10.getDimensionPixelSize(q5.d.mtrl_slider_thumb_radius);
        this.C = r10.getDimensionPixelOffset(q5.d.mtrl_slider_track_top);
        this.F = r10.getDimensionPixelSize(q5.d.mtrl_slider_label_padding);
    }

    private void L() {
        if (this.P > 0.0f) goto L5;
        return;
    L5:
        k0();
        int r10 = Math.min((int) (((this.L - this.K) / this.P) + 1.0f), (this.S / (this.A * 2)) + 1);
        float[] r11 = this.Q;
        if (r11 != null) goto L8;
    L9:
        this.Q = new float[r10 * 2];
    L10:
        float r12 = this.S / (r10 - 1);
        int r13 = 0;
    L12:
        if (r13 >= (r10 * 2)) goto L14;
        float[] r14 = this.Q;
        r14[r13] = this.B + ((r13 / 2) * r12);
        r14[r13 + 1] = m();
        r13 = r13 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r11.length == (r10 * 2)) goto L10;
        goto L9
    }

    private void M(@NonNull Canvas r10, int r11, int r12) {
        if (c0() == false) goto L9;
        int r13 = (int) (this.B + (R(this.M.get(this.O).floatValue()) * r11));
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        int r14 = this.E;
        r10.clipRect(r13 - r14, r12 - r14, r13 + r14, r14 + r12, Region.Op.UNION);
    L7:
        r10.drawCircle(r13, r12, this.E, this.f3727i);
        return;
    }

    private void N(@NonNull Canvas r10) {
        if (this.R == true) goto L5;
        return;
    L5:
        if (this.P <= 0.0f) goto L10;
        float[] r11 = getActiveRange();
        int r12 = X(this.Q, r11[0]);
        int r13 = X(this.Q, r11[1]);
        int r14 = r12 * 2;
        r10.drawPoints(this.Q, 0, r14, this.f3729j);
        int r15 = r13 * 2;
        r10.drawPoints(this.Q, r14, r15 - r14, this.f3730k);
        float[] r16 = this.Q;
        r10.drawPoints(r16, r15, r16.length - r15, this.f3729j);
        return;
    }

    private void O() {
        int r10 = Math.max(this.D - this.f3743x, 0);
        this.B = this.f3742w + r10;
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        j0(getWidth());
        return;
    }

    private boolean P(int r12) {
        int r10 = this.O;
        int r13 = (int) MathUtils.clamp(((long) r10) + ((long) r12), 0, this.M.size() - 1);
        this.O = r13;
        if (r13 != r10) goto L7;
        return false;
    L7:
        if (this.N == (-1)) goto L9;
        this.N = r13;
    L9:
        i0();
        postInvalidate();
        return true;
    }

    private boolean Q(int r10) {
        if (J() == false) goto L9;
        if (r10 != Integer.MIN_VALUE) goto L7;
        r10 = Integer.MAX_VALUE;
        goto L9
    L7:
        r10 = -r10;
    L9:
        return P(r10);
    }

    private float R(float r10) {
        float r11 = this.K;
        float r12 = (r10 - r11) / (this.L - r11);
        if (J() == true) goto L5;
        return r12;
    L5:
        return 1.0f - r12;
    }

    private Boolean S(int r10, @NonNull KeyEvent r11) {
        if (r10 == 61) goto L26;
        if (r10 != 66) goto L7;
    L23:
        this.N = this.O;
        postInvalidate();
        return Boolean.TRUE;
    L7:
        if (r10 != 81) goto L9;
    L21:
        P(1);
        return Boolean.TRUE;
    L9:
        if (r10 != 69) goto L11;
        P(-1);
        return Boolean.TRUE;
    L11:
        if (r10 == 70) goto L21;
        switch(r10) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        Q(1);
        return Boolean.TRUE;
    L17:
        Q(-1);
        return Boolean.TRUE;
    L26:
        if (r11.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(P(1));
    L30:
        if (r11.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(P(-1));
    L34:
        return Boolean.FALSE;
    }

    private void T() {
        Iterator<T> r10 = this.f3737r.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().a(this);
        goto L4
    }

    private void U() {
        Iterator<T> r10 = this.f3737r.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().b(this);
        goto L4
    }

    @NonNull
    private static TooltipDrawable V(@NonNull Context r10, @NonNull TypedArray r11) {
        return TooltipDrawable.createFromAttributes(r10, null, 0, r11.getResourceId(l.Slider_labelStyle, q5.k.Widget_MaterialComponents_Tooltip));
    }

    private static int X(float[] r10, float r11) {
        return Math.round(r11 * ((r10.length / 2) - 1));
    }

    private void Y(Context r10, AttributeSet r11, int r12) {
        TypedArray r13 = k.h(r10, r11, l.Slider, r12, f3714k0, new int[0]);
        this.K = r13.getFloat(l.Slider_android_valueFrom, 0.0f);
        this.L = r13.getFloat(l.Slider_android_valueTo, 1.0f);
        setValues(new Float[]{Float.valueOf(this.K)});
        this.P = r13.getFloat(l.Slider_android_stepSize, 0.0f);
        int r14 = l.Slider_trackColor;
        boolean r15 = r13.hasValue(r14);
        if (r15 == false) goto L5;
        int r16 = r14;
    L6:
        if (r15 == true) goto L9;
        r14 = l.Slider_trackColorActive;
    L9:
        ColorStateList r17 = com.google.android.material.resources.c.a(r10, r13, r16);
        if (r17 != null) goto L13;
        r17 = AppCompatResources.getColorStateList(r10, q5.c.material_slider_inactive_track_color);
    L13:
        setTrackInactiveTintList(r17);
        ColorStateList r18 = com.google.android.material.resources.c.a(r10, r13, r14);
        if (r18 != null) goto L17;
        r18 = AppCompatResources.getColorStateList(r10, q5.c.material_slider_active_track_color);
    L17:
        setTrackActiveTintList(r18);
        this.f3721e0.setFillColor(com.google.android.material.resources.c.a(r10, r13, l.Slider_thumbColor));
        int r19 = l.Slider_thumbStrokeColor;
        if (r13.hasValue(r19) == false) goto L20;
        setThumbStrokeColor(com.google.android.material.resources.c.a(r10, r13, r19));
    L20:
        setThumbStrokeWidth(r13.getDimension(l.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList r20 = com.google.android.material.resources.c.a(r10, r13, l.Slider_haloColor);
        if (r20 != null) goto L24;
        r20 = AppCompatResources.getColorStateList(r10, q5.c.material_slider_halo_color);
    L24:
        setHaloTintList(r20);
        this.R = r13.getBoolean(l.Slider_tickVisible, true);
        int r21 = l.Slider_tickColor;
        boolean r22 = r13.hasValue(r21);
        if (r22 == false) goto L27;
        int r23 = r21;
    L28:
        if (r22 == true) goto L31;
        r21 = l.Slider_tickColorActive;
    L31:
        ColorStateList r24 = com.google.android.material.resources.c.a(r10, r13, r23);
        if (r24 != null) goto L35;
        r24 = AppCompatResources.getColorStateList(r10, q5.c.material_slider_inactive_tick_marks_color);
    L35:
        setTickInactiveTintList(r24);
        ColorStateList r25 = com.google.android.material.resources.c.a(r10, r13, r21);
        if (r25 != null) goto L39;
        r25 = AppCompatResources.getColorStateList(r10, q5.c.material_slider_active_tick_marks_color);
    L39:
        setTickActiveTintList(r25);
        setThumbRadius(r13.getDimensionPixelSize(l.Slider_thumbRadius, 0));
        setHaloRadius(r13.getDimensionPixelSize(l.Slider_haloRadius, 0));
        setThumbElevation(r13.getDimension(l.Slider_thumbElevation, 0.0f));
        setTrackHeight(r13.getDimensionPixelSize(l.Slider_trackHeight, 0));
        setLabelBehavior(r13.getInt(l.Slider_labelBehavior, 0));
        if (r13.getBoolean(l.Slider_android_enabled, true) == true) goto L42;
        setEnabled(false);
    L42:
        r13.recycle();
        return;
    L27:
        r23 = l.Slider_tickColorInactive;
        goto L28
    L5:
        r16 = l.Slider_trackColorInactive;
        goto L6
    }

    private void Z(int r10) {
        BaseSlider<S, L, T>.d r11 = this.f3733n;
        if (r11 != null) goto L5;
        this.f3733n = new d(this, null);
    L6:
        this.f3733n.a(r10);
        postDelayed(this.f3733n, 200);
        return;
    L5:
        removeCallbacks(r11);
        goto L6
    }

    static /* synthetic */ TooltipDrawable a(Context r10, TypedArray r11) {
        return V(r10, r11);
    }

    private void a0(TooltipDrawable r10, float r11) {
        r10.setText(A(r11));
        int r12 = (this.B + ((int) (R(r11) * this.S))) - (r10.getIntrinsicWidth() / 2);
        int r13 = m() - (this.F + this.D);
        r10.setBounds(r12, r13 - r10.getIntrinsicHeight(), r10.getIntrinsicWidth() + r12, r13);
        Rect r14 = new Rect(r10.getBounds());
        com.google.android.material.internal.d.c(ViewUtils.e(this), this, r14);
        r10.setBounds(r14);
        ViewUtils.f(this).add(r10);
    }

    static /* synthetic */ List b(BaseSlider r10) {
        return r10.f3735p;
    }

    private boolean b0() {
        if (this.f3745z != 3) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ AccessibilityHelper c(BaseSlider r10) {
        return r10.f3731l;
    }

    private boolean c0() {
        if (this.T == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        if ((getBackground() instanceof RippleDrawable) == false) goto L10;
        return false;
    }

    static /* synthetic */ String d(BaseSlider r10, float r11) {
        return r10.A(r11);
    }

    private boolean d0(float r10) {
        return f0(this.N, r10);
    }

    static /* synthetic */ boolean e(BaseSlider r10, int r11, float r12) {
        return r10.f0(r11, r12);
    }

    private double e0(float r10) {
        float r11 = this.P;
        if (r11 <= 0.0f) goto L7;
        int r12 = (int) ((this.L - this.K) / r11);
        return ((double) Math.round(r10 * r12)) / ((double) r12);
    L7:
        return r10;
    }

    static /* synthetic */ void f(BaseSlider r10) {
        r10.i0();
    }

    private boolean f0(int r10, float r11) {
        this.O = r10;
        if (Math.abs(r11 - this.M.get(r10).floatValue()) >= 1.0E-4d) goto L6;
        return false;
    L6:
        this.M.set(r10, Float.valueOf(C(r10, r11)));
        r(r10);
        return true;
    }

    static /* synthetic */ float g(BaseSlider r10, int r11) {
        return r10.l(r11);
    }

    private boolean g0() {
        return d0(getValueOfTouchPosition());
    }

    private float[] getActiveRange() {
        float r10 = ((Float) Collections.max(getValues())).floatValue();
        float r11 = ((Float) Collections.min(getValues())).floatValue();
        if (this.M.size() != 1) goto L5;
        r11 = this.K;
    L5:
        float r12 = R(r11);
        float r13 = R(r10);
        if (J() == false) goto L9;
        return new float[]{r13, r12};
    L9:
        return new float[]{r12, r13};
    }

    private float getValueOfTouchPosition() {
        double r10 = e0(this.f3726h0);
        if (J() == false) goto L5;
        r10 = 1.0d - r10;
    L5:
        float r11 = this.L;
        float r12 = this.K;
        return (float) ((r10 * ((double) (r11 - r12))) + ((double) r12));
    }

    private float getValueOfTouchPositionAbsolute() {
        float r10 = this.f3726h0;
        if (J() == false) goto L5;
        r10 = 1.0f - r10;
    L5:
        float r11 = this.L;
        float r12 = this.K;
        return (r10 * (r11 - r12)) + r12;
    }

    private void h(Drawable r10) {
        int r11 = this.D * 2;
        int r12 = r10.getIntrinsicWidth();
        int r13 = r10.getIntrinsicHeight();
        if (r12 != (-1)) goto L6;
        if (r13 != (-1)) goto L6;
        r10.setBounds(0, 0, r11, r11);
        return;
    L6:
        float r14 = r11 / Math.max(r12, r13);
        r10.setBounds(0, 0, (int) (r12 * r14), (int) (r13 * r14));
    }

    private void i(TooltipDrawable r10) {
        r10.setRelativeToView(ViewUtils.e(this));
    }

    private void i0() {
        if (c0() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r10 = getBackground();
        if ((r10 instanceof RippleDrawable) == false) goto L12;
        int r11 = (int) ((R(this.M.get(this.O).floatValue()) * this.S) + this.B);
        int r12 = m();
        int r13 = this.E;
        DrawableCompat.setHotspotBounds(r10, r11 - r13, r12 - r13, r11 + r13, r12 + r13);
        return;
    L12:
        return;
    }

    private Float j(int r10) {
        if (this.U == false) goto L5;
        float r11 = l(20);
    L7:
        if (r10 == 21) goto L28;
        if (r10 == 22) goto L23;
        if (r10 == 69) goto L21;
        if (r10 == 70) goto L19;
        if (r10 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r11);
    L21:
        return Float.valueOf(-r11);
    L23:
        if (J() == false) goto L26;
        r11 = -r11;
    L26:
        return Float.valueOf(r11);
    L28:
        if (J() == true) goto L32;
        r11 = -r11;
    L32:
        return Float.valueOf(r11);
    L5:
        r11 = k();
        goto L7
    }

    private void j0(int r10) {
        this.S = Math.max(r10 - (this.B * 2), 0);
        L();
    }

    private float k() {
        float r10 = this.P;
        if (r10 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r10;
    }

    private void k0() {
        if (this.V == false) goto L6;
        n0();
        o0();
        m0();
        p0();
        l0();
        s0();
        this.V = false;
        return;
    }

    private float l(int r10) {
        float r11 = k();
        float r12 = (this.L - this.K) / r11;
        float r13 = r10;
        if (r12 > r13) goto L6;
        return r11;
    L6:
        return Math.round(r12 / r13) * r11;
    }

    private void l0() {
        float r10 = getMinSeparation();
        if (r10 < 0.0f) goto L21;
        float r11 = this.P;
        if (r11 > 0.0f) goto L7;
        return;
    L7:
        if (r10 > 0.0f) goto L9;
        return;
    L9:
        if (this.f3728i0 != 1) goto L18;
        if (r10 < r11) goto L16;
        if (I(r10) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.valueOf(r10), Float.valueOf(this.P), Float.valueOf(this.P)}));
    L18:
        throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", new Object[]{Float.valueOf(r10), Float.valueOf(this.P)}));
    L21:
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", new Object[]{Float.valueOf(r10)}));
    }

    private int m() {
        int r10 = this.C;
        int r11 = 0;
        if (this.f3745z != 1) goto L5;
    L6:
        r11 = this.f3735p.get(0).getIntrinsicHeight();
    L8:
        return r10 + r11;
    L5:
        if (b0() == false) goto L8;
        goto L6
    }

    private void m0() {
        if (this.P > 0.0f) goto L5;
        return;
    L5:
        if (q0(this.L) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.valueOf(this.P), Float.valueOf(this.K), Float.valueOf(this.L)}));
    }

    private ValueAnimator n(boolean r10) {
        float r11 = 0.0f;
        if (r10 == false) goto L5;
        float r12 = 0.0f;
    L6:
        if (r10 == false) goto L8;
        ValueAnimator r13 = this.f3740u;
    L9:
        float r14 = B(r13, r12);
        if (r10 == false) goto L12;
        r11 = 1.0f;
    L12:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r14, r11});
        if (r10 == false) goto L15;
        long r16 = 83;
    L16:
        r15.setDuration(r16);
        if (r10 == false) goto L19;
        TimeInterpolator r17 = r5.a.f12677e;
    L20:
        r15.setInterpolator(r17);
        r15.addUpdateListener(new b(this));
        return r15;
    L19:
        r17 = r5.a.f12675c;
        goto L20
    L15:
        r16 = 117;
        goto L16
    L8:
        r13 = this.f3739t;
        goto L9
    L5:
        r12 = 1.0f;
        goto L6
    }

    private void n0() {
        if (this.K >= this.L) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.valueOf(this.K), Float.valueOf(this.L)}));
    }

    private void o() {
        if (this.f3735p.size() <= this.M.size()) goto L12;
        List<TooltipDrawable> r10 = this.f3735p.subList(this.M.size(), this.f3735p.size());
        Iterator<TooltipDrawable> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        TooltipDrawable r12 = r11.next();
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        p(r12);
        goto L6
    L10:
        r10.clear();
    L12:
        if (this.f3735p.size() >= this.M.size()) goto L16;
        TooltipDrawable r13 = this.f3734o.a();
        this.f3735p.add(r13);
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        i(r13);
        goto L12
    L16:
        int r14 = 1;
        if (this.f3735p.size() != 1) goto L19;
        r14 = 0;
    L19:
        Iterator<TooltipDrawable> r15 = this.f3735p.iterator();
    L21:
        if (r15.hasNext() == false) goto L23;
        r15.next().setStrokeWidth(r14);
        goto L21
    }

    private void o0() {
        if (this.L <= this.K) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[]{Float.valueOf(this.L), Float.valueOf(this.K)}));
    }

    private void p(TooltipDrawable r10) {
        p r11 = ViewUtils.f(this);
        if (r11 == null) goto L6;
        r11.remove(r10);
        r10.detachView(ViewUtils.e(this));
        return;
    }

    private void p0() {
        Iterator<Float> r10 = this.M.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        Float r11 = r10.next();
        if (r11.floatValue() < this.K) goto L17;
        if (r11.floatValue() > this.L) goto L17;
        if (this.P <= 0.0f) goto L4;
        if (q0(r11.floatValue()) == true) goto L4;
        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{r11, Float.valueOf(this.K), Float.valueOf(this.P), Float.valueOf(this.P)}));
    L17:
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{r11, Float.valueOf(this.K), Float.valueOf(this.L)}));
    }

    private float q(float r10) {
        if (r10 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r11 = (r10 - this.B) / this.S;
        float r12 = this.K;
        return (r11 * (r12 - this.L)) + r12;
    }

    private boolean q0(float r10) {
        return I(r10 - this.K);
    }

    private void r(int r10) {
        Iterator<L> r11 = this.f3736q.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().a(this, this.M.get(r10).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r12 = this.f3732m;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEnabled() == false) goto L14;
        Z(r10);
        return;
    }

    private float r0(float r10) {
        return (R(r10) * this.S) + this.B;
    }

    private void s() {
        Iterator<L> r10 = this.f3736q.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        L r11 = r10.next();
        Iterator<Float> r12 = this.M.iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        r11.a(this, r12.next().floatValue(), false);
        goto L7
    }

    private void s0() {
        float r10 = this.P;
        if (r10 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r10) == r10) goto L8;
        Log.w(f3713j0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"stepSize", Float.valueOf(r10)}));
    L8:
        float r11 = this.K;
        if (((int) r11) == r11) goto L11;
        Log.w(f3713j0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"valueFrom", Float.valueOf(r11)}));
    L11:
        float r12 = this.L;
        if (((int) r12) == r12) goto L15;
        Log.w(f3713j0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[]{"valueTo", Float.valueOf(r12)}));
        return;
    }

    private void setValuesInternal(@NonNull ArrayList<Float> r10) {
        if (r10.isEmpty() == true) goto L12;
        Collections.sort(r10);
        if (this.M.size() == r10.size()) goto L7;
    L9:
        this.M = r10;
        this.V = true;
        this.O = 0;
        i0();
        o();
        s();
        postInvalidate();
        return;
    L7:
        if (this.M.equals(r10) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void t(@NonNull Canvas r11, int r12, int r13) {
        float[] r10 = getActiveRange();
        int r14 = this.B;
        float r15 = r12;
        float r16 = r13;
        r11.drawLine(r14 + (r10[0] * r15), r16, r14 + (r10[1] * r15), r16, this.f3723g);
    }

    private void u(@NonNull Canvas r12, int r13, int r14) {
        float[] r10 = getActiveRange();
        int r11 = this.B;
        float r15 = r13;
        float r16 = r11 + (r10[1] * r15);
        if (r16 >= (r11 + r13)) goto L5;
        float r17 = r14;
        r12.drawLine(r16, r17, r11 + r13, r17, this.f3718c);
    L5:
        int r18 = this.B;
        float r19 = r18 + (r10[0] * r15);
        if (r19 <= r18) goto L9;
        float r20 = r14;
        r12.drawLine(r18, r20, r19, r20, this.f3718c);
        return;
    }

    private void v(@NonNull Canvas r10, int r11, int r12, float r13, @NonNull Drawable r14) {
        r10.save();
        r10.translate((this.B + ((int) (R(r13) * r11))) - (r14.getBounds().width() / 2.0f), r12 - (r14.getBounds().height() / 2.0f));
        r14.draw(r10);
        r10.restore();
    }

    private void w(@NonNull Canvas r10, int r11, int r12) {
        int r13 = 0;
    L4:
        if (r13 >= this.M.size()) goto L16;
        float r14 = this.M.get(r13).floatValue();
        Drawable r15 = this.f3722f0;
        if (r15 == null) goto L9;
    L7:
        v(r10, r11, r12, r14, r15);
        r13 = r13 + 1;
        goto L4
    L9:
        if (r13 >= this.f3724g0.size()) goto L12;
        r15 = this.f3724g0.get(r13);
        goto L7
    L12:
        if (isEnabled() == true) goto L14;
        r10.drawCircle(this.B + (R(r14) * r11), r12, this.D, this.f3725h);
    L14:
        r15 = this.f3721e0;
        goto L7
    }

    private void x() {
        if (this.f3745z != 2) goto L6;
        return;
    L6:
        if (this.f3738s == true) goto L8;
        this.f3738s = true;
        ValueAnimator r10 = n(true);
        this.f3739t = r10;
        this.f3740u = null;
        r10.start();
    L8:
        Iterator<TooltipDrawable> r11 = this.f3735p.iterator();
        int r12 = 0;
    L10:
        if (r12 >= this.M.size()) goto L19;
        if (r11.hasNext() == false) goto L19;
        if (r12 == this.O) goto L17;
        a0(r11.next(), this.M.get(r12).floatValue());
    L17:
        r12 = r12 + 1;
    L19:
        if (r11.hasNext() == false) goto L23;
        a0(r11.next(), this.M.get(this.O).floatValue());
        return;
    L23:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.f3735p.size()), Integer.valueOf(this.M.size())}));
    }

    private void y() {
        if (this.f3738s == false) goto L6;
        this.f3738s = false;
        ValueAnimator r10 = n(false);
        this.f3740u = r10;
        this.f3739t = null;
        r10.addListener(new c(this));
        this.f3740u.start();
        return;
    }

    private void z(int r10) {
        if (r10 != 1) goto L5;
        P(Integer.MAX_VALUE);
        return;
    L5:
        if (r10 != 2) goto L7;
        P(Integer.MIN_VALUE);
        return;
    L7:
        if (r10 != 17) goto L9;
        Q(Integer.MAX_VALUE);
        return;
    L9:
        if (r10 != 66) goto L19;
        Q(Integer.MIN_VALUE);
        return;
    }

    public boolean E() {
        if (this.I == null) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean J() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    protected boolean W() {
        if (this.N == (-1)) goto L5;
        return true;
    L5:
        float r10 = getValueOfTouchPositionAbsolute();
        float r11 = r0(r10);
        this.N = 0;
        float r12 = Math.abs(this.M.get(0).floatValue() - r10);
        int r13 = 1;
    L7:
        if (r13 >= this.M.size()) goto L34;
        float r14 = Math.abs(this.M.get(r13).floatValue() - r10);
        float r15 = r0(this.M.get(r13).floatValue());
        if (Float.compare(r14, r12) > 1) goto L34;
        if (J() == false) goto L17;
        if ((r15 - r11) > 0.0f) goto L18;
    L19:
        boolean r16 = false;
    L21:
        if (Float.compare(r14, r12) >= 0) goto L24;
    L22:
        this.N = r13;
        r12 = r14;
    L32:
        r13 = r13 + 1;
        goto L7
    L24:
        if (Float.compare(r14, r12) != 0) goto L32;
        if (Math.abs(r15 - r11) < this.f3741v) goto L27;
        if (r16 == false) goto L32;
    L27:
        this.N = -1;
        return false;
    L18:
        r16 = true;
        goto L21
    L17:
        if ((r15 - r11) >= 0.0f) goto L19;
    L34:
        if (this.N == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (this.f3731l.dispatchHoverEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent r10) {
        return super.dispatchKeyEvent(r10);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3718c.setColor(D(this.f3720d0));
        this.f3723g.setColor(D(this.f3719c0));
        this.f3729j.setColor(D(this.f3717b0));
        this.f3730k.setColor(D(this.f3716a0));
        Iterator<TooltipDrawable> r10 = this.f3735p.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        TooltipDrawable r11 = r10.next();
        if (r11.isStateful() == false) goto L4;
        r11.setState(getDrawableState());
        goto L4
    L9:
        if (this.f3721e0.isStateful() == false) goto L11;
        this.f3721e0.setState(getDrawableState());
    L11:
        this.f3727i.setColor(D(this.W));
        this.f3727i.setAlpha(63);
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.f3731l.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.N;
    }

    public int getFocusedThumbIndex() {
        return this.O;
    }

    @Dimension
    public int getHaloRadius() {
        return this.E;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.W;
    }

    public int getLabelBehavior() {
        return this.f3745z;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.P;
    }

    public float getThumbElevation() {
        return this.f3721e0.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.D;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f3721e0.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.f3721e0.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.f3721e0.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.f3716a0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.f3717b0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.f3717b0.equals(this.f3716a0) == false) goto L7;
        return this.f3716a0;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.f3719c0;
    }

    @Dimension
    public int getTrackHeight() {
        return this.A;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f3720d0;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.B;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f3720d0.equals(this.f3719c0) == false) goto L7;
        return this.f3719c0;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.S;
    }

    public float getValueFrom() {
        return this.K;
    }

    public float getValueTo() {
        return this.L;
    }

    @NonNull
    List<Float> getValues() {
        return new ArrayList(this.M);
    }

    void h0(int r10, Rect r11) {
        int r12 = this.B + ((int) (R(getValues().get(r10).floatValue()) * this.S));
        int r13 = m();
        int r14 = this.D;
        r11.set(r12 - r14, r13 - r14, r12 + r14, r13 + r14);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r10 = this.f3735p.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        i(r10.next());
        goto L4
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d r10 = this.f3733n;
        if (r10 == null) goto L5;
        removeCallbacks(r10);
    L5:
        this.f3738s = false;
        Iterator<TooltipDrawable> r11 = this.f3735p.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        p(r11.next());
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas r10) {
        if (this.V == false) goto L5;
        k0();
        L();
    L5:
        super.onDraw(r10);
        int r11 = m();
        u(r10, this.S, r11);
        if (((Float) Collections.max(getValues())).floatValue() <= this.K) goto L8;
        t(r10, this.S, r11);
    L8:
        N(r10);
        if (this.f3715J == true) goto L15;
        if (isFocused() == true) goto L15;
        if (b0() == true) goto L15;
    L21:
        y();
    L22:
        w(r10, this.S, r11);
        return;
    L15:
        if (isEnabled() == false) goto L21;
        M(r10, this.S, r11);
        if (this.N == (-1)) goto L19;
    L20:
        x();
        goto L22
    L19:
        if (b0() == false) goto L21;
        goto L20
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean r10, int r11, @Nullable Rect r12) {
        super.onFocusChanged(r10, r11, r12);
        if (r10 == true) goto L5;
        this.N = -1;
        this.f3731l.clearKeyboardFocusForVirtualView(this.O);
        return;
    L5:
        z(r11);
        this.f3731l.requestKeyboardFocusForVirtualView(this.O);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, @NonNull KeyEvent r11) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r10, r11);
    L7:
        if (this.M.size() != 1) goto L10;
        this.N = 0;
    L10:
        if (this.N != (-1)) goto L16;
        Boolean r12 = S(r10, r11);
        if (r12 == null) goto L15;
        return r12.booleanValue();
    L15:
        return super.onKeyDown(r10, r11);
    L16:
        this.U |= r11.isLongPress();
        Float r13 = j(r10);
        if (r13 == null) goto L23;
        if (d0(this.M.get(this.N).floatValue() + r13.floatValue()) == false) goto L21;
        i0();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r10 != 23) goto L25;
    L39:
        this.N = -1;
        postInvalidate();
        return true;
    L25:
        if (r10 == 61) goto L31;
        if (r10 == 66) goto L39;
        return super.onKeyDown(r10, r11);
    L31:
        if (r11.hasNoModifiers() == false) goto L35;
        return P(1);
    L35:
        if (r11.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return P(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, @NonNull KeyEvent r11) {
        this.U = false;
        return super.onKeyUp(r10, r11);
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = this.f3744y;
        int r13 = 0;
        if (this.f3745z != 1) goto L5;
    L6:
        r13 = this.f3735p.get(0).getIntrinsicHeight();
    L7:
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(r12 + r13, 1073741824));
        return;
    L5:
        if (b0() == false) goto L7;
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        SliderState r11 = (SliderState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.K = r11.valueFrom;
        this.L = r11.valueTo;
        setValuesInternal(r11.values);
        this.P = r11.stepSize;
        if (r11.hasFocus == false) goto L6;
        requestFocus();
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState r10 = new SliderState(super.onSaveInstanceState());
        r10.valueFrom = this.K;
        r10.valueTo = this.L;
        r10.values = new ArrayList(this.M);
        r10.stepSize = this.P;
        r10.hasFocus = hasFocus();
        return r10;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        j0(r10);
        i0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r11 = r10.getX();
        float r12 = (r11 - this.B) / this.S;
        this.f3726h0 = r12;
        float r13 = Math.max(0.0f, r12);
        this.f3726h0 = r13;
        this.f3726h0 = Math.min(1.0f, r13);
        int r14 = r10.getActionMasked();
        if (r14 == 0) goto L38;
        if (r14 != 1) goto L9;
        this.f3715J = false;
        MotionEvent r15 = this.H;
        if (r15 == null) goto L35;
        if (r15.getActionMasked() != 0) goto L35;
        if (Math.abs(this.H.getX() - r10.getX()) > this.f3741v) goto L35;
        if (Math.abs(this.H.getY() - r10.getY()) > this.f3741v) goto L35;
        if (W() == false) goto L35;
        T();
    L35:
        if (this.N == (-1)) goto L37;
        g0();
        this.N = -1;
        U();
    L37:
        invalidate();
    L45:
        setPressed(this.f3715J);
        this.H = MotionEvent.obtain(r10);
        return true;
    L9:
        if (r14 != 2) goto L45;
        if (this.f3715J == true) goto L20;
        if (H() == true) goto L16;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        T();
        goto L20
    L16:
        if (Math.abs(r11 - this.G) >= this.f3741v) goto L18;
        return false;
    L20:
        if (W() == false) goto L45;
        this.f3715J = true;
        g0();
        i0();
        goto L37
    L38:
        this.G = r11;
        if (H() == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (W() == false) goto L45;
        requestFocus();
        this.f3715J = true;
        g0();
        i0();
        invalidate();
        T();
        goto L45
    }

    protected void setActiveThumbIndex(int r10) {
        this.N = r10;
    }

    void setCustomThumbDrawable(@DrawableRes int r10) {
        setCustomThumbDrawable(getResources().getDrawable(r10));
    }

    void setCustomThumbDrawable(@NonNull Drawable r10) {
        this.f3722f0 = F(r10);
        this.f3724g0.clear();
        postInvalidate();
    }

    void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... r10) {
        Drawable[] r11 = new Drawable[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = getResources().getDrawable(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        setCustomThumbDrawablesForValues(r11);
    }

    void setCustomThumbDrawablesForValues(@NonNull Drawable... r10) {
        this.f3722f0 = null;
        this.f3724g0 = new ArrayList();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Drawable r13 = r10[r12];
        this.f3724g0.add(F(r13));
        r12 = r12 + 1;
        goto L3
    L5:
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        int r11 = 0;
    L6:
        setLayerType(r11, null);
        return;
    L5:
        r11 = 2;
        goto L6
    }

    public void setFocusedThumbIndex(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= this.M.size()) goto L8;
        this.O = r10;
        this.f3731l.requestKeyboardFocusForVirtualView(r10);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int r10) {
        if (r10 != this.E) goto L5;
        return;
    L5:
        this.E = r10;
        Drawable r11 = getBackground();
        if (c0() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if ((r11 instanceof RippleDrawable) == false) goto L11;
        v5.a.b((RippleDrawable) r11, this.E);
    }

    public void setHaloRadiusResource(@DimenRes int r10) {
        setHaloRadius(getResources().getDimensionPixelSize(r10));
    }

    public void setHaloTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.W) == false) goto L5;
        return;
    L5:
        this.W = r10;
        Drawable r11 = getBackground();
        if (c0() == false) goto L8;
    L11:
        this.f3727i.setColor(D(r10));
        this.f3727i.setAlpha(63);
        invalidate();
        return;
    L8:
        if ((r11 instanceof RippleDrawable) == false) goto L11;
        ((RippleDrawable) r11).setColor(r10);
    }

    public void setLabelBehavior(int r10) {
        if (this.f3745z == r10) goto L6;
        this.f3745z = r10;
        requestLayout();
        return;
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.c r10) {
        this.I = r10;
    }

    protected void setSeparationUnit(int r10) {
        this.f3728i0 = r10;
        this.V = true;
        postInvalidate();
    }

    public void setStepSize(float r10) {
        if (r10 < 0.0f) goto L9;
        if (this.P == r10) goto L10;
        this.P = r10;
        this.V = true;
        postInvalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.valueOf(r10), Float.valueOf(this.K), Float.valueOf(this.L)}));
    }

    public void setThumbElevation(float r10) {
        this.f3721e0.setElevation(r10);
    }

    public void setThumbElevationResource(@DimenRes int r10) {
        setThumbElevation(getResources().getDimension(r10));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int r10) {
        if (r10 != this.D) goto L5;
        return;
    L5:
        this.D = r10;
        O();
        this.f3721e0.setShapeAppearanceModel(com.google.android.material.shape.l.a().q(0, this.D).m());
        MaterialShapeDrawable r11 = this.f3721e0;
        int r12 = this.D;
        r11.setBounds(0, 0, r12 * 2, r12 * 2);
        Drawable r13 = this.f3722f0;
        if (r13 == null) goto L8;
        h(r13);
    L8:
        Iterator<Drawable> r14 = this.f3724g0.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        h(r14.next());
        goto L10
    L12:
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int r10) {
        setThumbRadius(getResources().getDimensionPixelSize(r10));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList r10) {
        this.f3721e0.setStrokeColor(r10);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int r10) {
        if (r10 == 0) goto L5;
        setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), r10));
        return;
    }

    public void setThumbStrokeWidth(float r10) {
        this.f3721e0.setStrokeWidth(r10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int r10) {
        if (r10 == 0) goto L5;
        setThumbStrokeWidth(getResources().getDimension(r10));
        return;
    }

    public void setThumbTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.f3721e0.getFillColor()) == false) goto L5;
        return;
    L5:
        this.f3721e0.setFillColor(r10);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.f3716a0) == false) goto L5;
        return;
    L5:
        this.f3716a0 = r10;
        this.f3730k.setColor(D(r10));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.f3717b0) == false) goto L5;
        return;
    L5:
        this.f3717b0 = r10;
        this.f3729j.setColor(D(r10));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList r10) {
        setTickInactiveTintList(r10);
        setTickActiveTintList(r10);
    }

    public void setTickVisible(boolean r10) {
        if (this.R == r10) goto L6;
        this.R = r10;
        postInvalidate();
        return;
    }

    public void setTrackActiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.f3719c0) == false) goto L5;
        return;
    L5:
        this.f3719c0 = r10;
        this.f3723g.setColor(D(r10));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int r10) {
        if (this.A == r10) goto L6;
        this.A = r10;
        G();
        postInvalidate();
        return;
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.f3720d0) == false) goto L5;
        return;
    L5:
        this.f3720d0 = r10;
        this.f3718c.setColor(D(r10));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList r10) {
        setTrackInactiveTintList(r10);
        setTrackActiveTintList(r10);
    }

    public void setValueFrom(float r10) {
        this.K = r10;
        this.V = true;
        postInvalidate();
    }

    public void setValueTo(float r10) {
        this.L = r10;
        this.V = true;
        postInvalidate();
    }

    void setValues(@NonNull List<Float> r10) {
        setValuesInternal(new ArrayList(r10));
    }

    void setValues(@NonNull Float... r10) {
        ArrayList<Float> r11 = new ArrayList();
        Collections.addAll(r11, r10);
        setValuesInternal(r11);
    }
}
