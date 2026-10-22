package com.larksuite.component.aurora;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u00106\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J,\u00108\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00109\u001a\u00020:J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\u0010\u0010=\u001a\u0002072\b\b\u0001\u0010>\u001a\u00020\u0012J\u0010\u0010?\u001a\u0002072\b\b\u0001\u0010@\u001a\u00020\u0012J\u0010\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u000207H\u0014JZ\u0010E\u001a\u000207*\u00020\u00192\u0006\u0010B\u001a\u00020C2!\u0010F\u001a\u001d\u0012\u0013\u0012\u00110H¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002070G2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\n0GH\u0002J'\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010\n2\u0006\u0010>\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010PJ\"\u0010Q\u001a\u0002072\u0006\u0010K\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010>\u001a\u00020\u0012H\u0002J*\u0010T\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0010\u0010/\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b4\u0010,¨\u0006W"}, d2 = {"Lcom/larksuite/component/aurora/AuroraView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "delegate", "Lcom/larksuite/component/aurora/AuroraDelegate;", "createDelegate", "blurRadius", "", "getBlurRadius$aurora_release", "()F", "setBlurRadius$aurora_release", "(F)V", "standardCanvasWidth", "mainBlob", "Lcom/larksuite/component/aurora/AuroraView$AuroraBlob;", "subBlob", "reflectionBlob", "normalMainFraction", "normalSubFraction", "normalReflectionFraction", "slideMainOffsetX", "slideSubOffsetX", "slideReflectionOffsetX", "normalMainRadiusOffsetX", "normalMainRadiusOffsetY", "normalSubRadiusOffsetX", "normalSubRadiusOffsetY", "normalReflectionOffsetX", "normalReflectionOffsetY", "slideFraction", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "normalAnimator$delegate", "Lkotlin/Lazy;", "targetMainBlob", "targetSubBlob", "targetReflectionBlob", "blobFraction", "blobAnimator", "getBlobAnimator", "blobAnimator$delegate", "setBlobs", "", "animateBlobs", "duration", "", "startNormalAnimate", "pauseNormalAnimate", "setSlideFraction", "fraction", "setBlurRadius", "radius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "draw", "boundModifier", "Lkotlin/Function1;", "Landroid/graphics/RectF;", "Lkotlin/ParameterName;", "name", "bound", "colorModifier", "color", "interpolateColors", "targetColor", "(ILjava/lang/Integer;F)I", "interpolateBound", "targetBound", "Landroid/graphics/Rect;", "applyAttrs", "AuroraBlob", "Companion", "aurora_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AuroraView extends View {
    public final AuroraDelegate a;
    public float b;
    public final float c;
    public a d;
    public a e;
    public a f;
    public float g;
    public float h;
    public float i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public float s;
    public final Lazy t;
    public a u;
    public a v;
    public a w;
    public float x;
    public final Lazy y;

    public static final class a {
        public final int a;
        public final float b;
        public final Rect c;

        /* JADX INFO: renamed from: com.larksuite.component.aurora.AuroraView$a$a, reason: collision with other inner class name */
        public static final class C0009a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "AuroraBlob(color=" + this.a + ", alpha=" + this.b + ", bound=" + this.c + ')';
        }

        public final int a() {
            return UDColorUtils.getAlphaColor(this.a, this.b);
        }

        public a(int r2, float r3, Rect r4) {
            Intrinsics.checkNotNullParameter(r4, "bound");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }

        public a(int r2, float r3, int r4, int r5, int r6, int r7) {
            this(r2, r3, new Rect(r4, r5, r6 + r4, r7 + r5));
        }
    }

    public static final class b {
    }

    static {
    }

    private final ValueAnimator getBlobAnimator() {
        return (ValueAnimator) this.y.getValue();
    }

    private final ValueAnimator getNormalAnimator() {
        return (ValueAnimator) this.t.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getNormalAnimator().isRunning() == false) goto L6;
        getNormalAnimator().cancel();
        return;
    }

    public final float getBlurRadius$aurora_release() {
        return this.b;
    }

    public AuroraView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        a r0 = this.d;
        if (r0 == null) goto L5;
        final Function1<RectF, Unit> r1 = new AnonymousClass1(this);
        Function1<Integer, Integer> r2 = new AnonymousClass2(this);
        this.a.b(r6, r0, new AuroraView$draw$1(r1, this), r2);
    L5:
        a r3 = this.e;
        if (r3 == null) goto L8;
        final Function1<RectF, Unit> r4 = new AnonymousClass3(this);
        Function1<Integer, Integer> r5 = new AnonymousClass4(this);
        this.a.b(r6, r3, new AuroraView$draw$1(r4, this), r5);
    L8:
        a r7 = this.f;
        if (r7 == null) goto L12;
        final Function1<RectF, Unit> r8 = new AnonymousClass5(this);
        Function1<Integer, Integer> r9 = new AnonymousClass6(this);
        this.a.b(r6, r7, new AuroraView$draw$1(r8, this), r9);
        return;
    }

    public final void setBlurRadius(float r2) {
        if (r2 >= 0.0f) goto L5;
        return;
    L5:
        this.b = r2;
        this.a.f();
    }

    public final void setBlurRadius$aurora_release(float r1) {
        this.b = r1;
    }

    public final void setSlideFraction(float r1) {
        this.s = r1;
        invalidate();
    }

    public AuroraView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public AuroraView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15, 0);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 31) goto L6;
        AuroraDelegate r2 = new c(this);
    L9:
        this.a = r2;
        this.b = d.b(getContext(), 80);
        this.c = d.b(getContext(), 375);
        this.h = (float) Math.sin(0.6283185307179586d);
        this.j = (int) d.b(getContext(), 48);
        this.k = (int) d.b(getContext(), 16);
        this.l = (int) d.b(getContext(), 24);
        this.m = (int) d.b(getContext(), 14);
        this.n = (int) d.b(getContext(), 14);
        this.o = (int) d.b(getContext(), 25);
        this.p = (int) d.b(getContext(), 25);
        this.q = (int) d.b(getContext(), 25);
        this.r = (int) d.b(getContext(), 20);
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.t = LazyKt.lazy(r3, new AuroraView$normalAnimator$2(this));
        this.y = LazyKt.lazy(r3, new AuroraView$blobAnimator$2(this));
        r2.e();
        TypedArray r16 = r13.obtainStyledAttributes(r14, new int[]{2130969026, 2130972669, 2130972670, 2130972671, 2130972672, 2130972673, 2130972674, 2130973741, 2130973742, 2130973743, 2130973744, 2130973745, 2130973746, 2130974318, 2130974319, 2130974320, 2130974321, 2130974322, 2130974323}, r15, 0);
        int r17 = r16.getDimensionPixelSize(0, -1);
        if (r17 < 0) goto L12;
        setBlurRadius(r17);
    L12:
        int r6 = r16.getColor(6, 0);
        float r7 = r16.getFloat(1, 0.0f);
        int r8 = r16.getDimensionPixelSize(3, 0);
        int r9 = r16.getDimensionPixelSize(4, 0);
        int r10 = r16.getDimensionPixelSize(5, 0);
        int r11 = r16.getDimensionPixelSize(2, 0);
        a r19 = null;
        if (r6 == 0) goto L15;
        a r4 = new a(r6, r7, r8, r9, r10, r11);
    L16:
        int r12 = r16.getColor(18, 0);
        float r20 = r16.getFloat(13, 0.0f);
        int r21 = r16.getDimensionPixelSize(15, 0);
        int r22 = r16.getDimensionPixelSize(16, 0);
        int r110 = r16.getDimensionPixelSize(17, 0);
        int r111 = r16.getDimensionPixelSize(14, 0);
        if (r12 == 0) goto L19;
        a r5 = new a(r12, r20, r21, r22, r110, r111);
    L20:
        int r23 = r16.getColor(12, 0);
        float r24 = r16.getFloat(7, 0.0f);
        int r25 = r16.getDimensionPixelSize(9, 0);
        int r26 = r16.getDimensionPixelSize(10, 0);
        int r27 = r16.getDimensionPixelSize(11, 0);
        int r112 = r16.getDimensionPixelSize(8, 0);
        if (r23 == 0) goto L23;
        r19 = new a(r23, r24, r25, r26, r27, r112);
    L23:
        r16.recycle();
        if (r4 != null) goto L29;
        if (r5 != null) goto L29;
        if (r19 != null) goto L29;
        return;
    L29:
        if (r4 == null) goto L31;
        Intrinsics.checkNotNullParameter(r4, "mainBlob");
        this.d = r4;
        this.e = r5;
        this.f = r19;
        invalidate();
        return;
    L31:
        a r113 = new a(0, 0.0f, 0, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r113, "mainBlob");
        this.d = r113;
        this.e = r5;
        this.f = r19;
        invalidate();
        return;
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    L6:
        if (r1 < 28) goto L8;
        r2 = new com.larksuite.component.aurora.b(this);
        goto L9
    L8:
        r2 = new com.larksuite.component.aurora.a(this);
        goto L9
    }

    public static final void a(AuroraView r6, RectF r7, Rect r8, float r9) {
        r6.getClass();
        if (r8 == null) goto L7;
        float r10 = r8.left;
        float r0 = r7.left;
        float r1 = r8.top;
        float r2 = r7.top;
        float r3 = r8.right;
        float r4 = r7.right;
        float r11 = r8.bottom;
        float r5 = r7.bottom;
        r7.left = r0 + ((r10 - r0) * r9);
        r7.top = r2 + ((r1 - r2) * r9);
        r7.right = r4 + ((r3 - r4) * r9);
        r7.bottom = r5 + ((r11 - r5) * r9);
        return;
    }

    public static final int b(AuroraView r4, int r5, Integer r6, float r7) {
        r4.getClass();
        if (r6 == null) goto L7;
        float r0 = 1 - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6.intValue()) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6.intValue()) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6.intValue()) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6.intValue()) * r7)));
    L7:
        return r5;
    }
}
