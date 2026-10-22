package com.larus.dora.obric.onboarding;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0090\u00012\u00020\u0001:\u0004\u0090\u0001\u0091\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ>\u0010@\u001a\u00020526\u0010A\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u001e¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020504J)\u0010F\u001a\u0002052!\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020507J\u0006\u0010H\u001a\u00020\fJ\u0014\u0010I\u001a\u0002052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010K\u001a\u000205J\u0006\u0010L\u001a\u000205J\u0006\u0010M\u001a\u000205J\u000e\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u001eJ\u0006\u0010P\u001a\u000205J\b\u0010Q\u001a\u000205H\u0002J\u0010\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010T\u001a\u0002052\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0016J(\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0014J\u0010\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020_H\u0014J\u0010\u0010`\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010a\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010b\u001a\u0002052\u0006\u0010c\u001a\u00020\"H\u0002J \u0010d\u001a\u0002052\u0006\u0010c\u001a\u00020\"2\u0006\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020\u001eH\u0002J \u0010g\u001a\u0002052\u0006\u0010c\u001a\u00020\"2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u001eH\u0002J\u0018\u0010i\u001a\u0002052\u0006\u0010h\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u001eH\u0002J\b\u0010j\u001a\u000205H\u0002J\u0018\u0010k\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\"2\u0006\u0010l\u001a\u00020\"H\u0002J\b\u0010m\u001a\u000205H\u0002J\b\u0010n\u001a\u000205H\u0002J\u0010\u0010o\u001a\u0002052\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010p\u001a\u000205H\u0002J\b\u0010q\u001a\u00020\u0015H\u0002J\u0010\u0010r\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\fH\u0002J\u0018\u0010s\u001a\u00020+2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0002J \u0010v\u001a\u0002052\u0006\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\"H\u0002J\u0018\u0010z\u001a\u00020\"2\u0006\u0010G\u001a\u00020\f2\u0006\u0010{\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u0002052\u0006\u0010}\u001a\u00020\u0007H\u0002J\b\u0010~\u001a\u000205H\u0002J\b\u0010\u007f\u001a\u000205H\u0002J \u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u000205H\u0002J\u001d\u0010\u0085\u0001\u001a\u0002052\b\b\u0002\u0010D\u001a\u00020\u00072\b\b\u0002\u0010x\u001a\u00020\u0007H\u0002J\r\u0010\u0086\u0001\u001a\u000205*\u00020\u0010H\u0002J\u0012\u0010\u0087\u0001\u001a\u0002052\u0007\u0010\u0088\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0089\u0001\u001a\u000205H\u0014J\t\u0010\u008a\u0001\u001a\u000205H\u0014J\u0016\u0010\u008e\u0001\u001a\u00020\u0007*\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0002R\u0019\u0010\n\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u000205\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000205\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u008b\u0001\u001a\u00020\u0007*\u00020\u00078BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingTopicView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultTopicList", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "topicList", "primaryPrefix", "Landroid/widget/TextView;", "primaryTail", "primaryArrow", "Landroid/widget/ImageView;", "primaryQuery", "Landroid/widget/LinearLayout;", "secondaryText", "tertiaryText", "previewRows", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", "autoScrollEnabled", "", "currentIndex", "isScrolling", "touchDownX", "", "touchDownY", "isUserDragging", "velocityTracker", "Landroid/view/VelocityTracker;", "settleAnimator", "Landroid/animation/ValueAnimator;", "autoScrollAnimator", "dragTransition", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingTopicView$TopicTransition;", "value", "offsetY", "setOffsetY", "(F)V", "lastTrackedEventTime", "", "lastTrackedAction", "onTopicChangedListener", "Lkotlin/Function2;", "", "onPrimaryQueryClickListener", "Lkotlin/Function1;", "touchSlop", "minimumFlingVelocity", "alphaMaskPaint", "Landroid/graphics/Paint;", "alphaMaskStops", "", "alphaMask", "Landroid/graphics/LinearGradient;", "setOnTopicChangedListener", "listener", "Lkotlin/ParameterName;", "name", "index", "animate", "setOnPrimaryQueryClickListener", "query", "getCurrentQueryText", "setTopicList", "topics", "refreshTopics", "startScroll", "stopScroll", "setAutoScrollEnabled", "enabled", "cancelAnimations", "scrollToNext", "scrollBy", "offset", "animateTopics", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "startUserDragIfNeeded", "updateDragPreview", "verticalDelta", "finishUserDrag", "releaseVelocity", "shouldCommitSelection", "settleUserDrag", "selectedOffset", "completeUserDrag", "resetDragPreview", "maxManualQueryOffset", "rowShift", "cancelAutoScrollAnimation", "cancelUserDragSettle", "trackVelocity", "recycleVelocityTracker", "createPrimaryQuery", "measurePrimaryQueryWidth", "prepareTopicTransition", "sourceIndex", "targetIndex", "renderTopicTransition", "transition", "direction", "progress", "calculatePrimaryTailCenterOffset", "targetQueryWidth", "setPrimaryQueryWidth", "width", "resetTopicTransition", "resetPrimaryQuerySize", "createTextView", "gravity", "typeface", "Landroid/graphics/Typeface;", "bindTopics", "bindPreviewTopics", "applyWakeWordGradient", "setVisibility", "visibility", "onAttachedToWindow", "onDetachedFromWindow", "dp", "getDp", "(I)I", "floorMod", "modulus", "Companion", "TopicTransition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGOnboardingTopicView extends FrameLayout {
    public static final Typeface F = null;
    public static final Typeface G = null;
    public final int A;
    public final int B;
    public final Paint C;
    public final float[] D;
    public LinearGradient E;
    public final List<String> a;
    public List<String> b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final LinearLayout i;
    public final CoroutineScope j;
    public Job k;
    public boolean l;
    public int m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;
    public VelocityTracker r;
    public ValueAnimator s;
    public ValueAnimator t;
    public b u;
    public float v;
    public long w;
    public int x;
    public Function2<? super Integer, ? super Boolean, Unit> y;
    public Function1<? super String, Unit> z;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + Float.floatToIntBits(this.e);
        }

        public final String toString() {
            return "TopicTransition(sourceIndex=" + this.a + ", targetIndex=" + this.b + ", initialQueryWidth=" + this.c + ", targetQueryWidth=" + this.d + ", incomingQueryTranslationX=" + this.e + ')';
        }

        public b(int r1, int r2, int r3, int r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public ObricDoraGOnboardingTopicView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricDoraGOnboardingTopicView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void m() {
        this.l = true;
        s();
        e();
        this.m = 0;
        this.n = false;
        d();
        Function2<? super Integer, ? super Boolean, Unit> r0 = this.y;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(this.m), Boolean.FALSE);
    L6:
        if (getVisibility() != 0) goto L9;
        q();
        return;
    }

    public final void o() {
        this.u = null;
        setOffsetY(0.0f);
        p();
        d();
    }

    static {
        F = Typeface.create("sans-serif-medium", 0);
        G = Typeface.create("sans-serif", 0);
    }

    public final void d() {
        this.d.setText((CharSequence) ListProtector.get(this.b, this.m));
        c(this.m, 1);
    }

    public final void e() {
        ValueAnimator r0 = this.t;
        if (r0 == null) goto L5;
        r0.cancel();
        p();
        d();
    L5:
        this.t = null;
        ValueAnimator r1 = this.s;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.s = null;
        this.n = false;
        this.u = null;
        this.d.animate().cancel();
        this.i.animate().cancel();
        p();
        this.i.setAlpha(1.0f);
        setOffsetY(0.0f);
        this.n = false;
    }

    public final String getCurrentQueryText() {
        return this.d.getText().toString();
    }

    public final void l() {
        VelocityTracker r0 = this.r;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.r = null;
        this.w = Long.MIN_VALUE;
        this.x = 3;
    }

    public final void p() {
        this.d.setAlpha(1.0f);
        this.d.setTranslationX(0.0f);
        this.d.setTranslationY(0.0f);
        this.e.setTranslationX(0.0f);
        this.g.setTranslationX(0.0f);
        if (this.f.getLayoutParams().width == (-2)) goto L6;
        LinearLayout r0 = this.f;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.width = -2;
        r0.setLayoutParams(r2);
        return;
    }

    public final void q() {
        if (this.l == true) goto L5;
        return;
    L5:
        Job r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        this.k = BuildersKt.launch$default(this.j, null, null, new ObricDoraGOnboardingTopicView$startScroll$1(this, null), 3, null);
        return;
    L8:
        if (r0.isActive() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void s() {
        Job r0 = this.k;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.k = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        q();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        e();
        l();
    }

    public static final /* synthetic */ void b(ObricDoraGOnboardingTopicView r1) {
        r1.setOffsetY(0.0f);
    }

    private final void setOffsetY(float r2) {
        this.v = r2;
        this.i.setTranslationY(r2);
    }

    private final void setPrimaryQueryWidth(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        if (this.f.getLayoutParams().width == r3) goto L9;
        LinearLayout r0 = this.f;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = r3;
        r0.setLayoutParams(r1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        LinearGradient r0 = this.E;
        if (r0 != null) goto L6;
        super.dispatchDraw(r10);
        return;
    L6:
        int r1 = r10.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r10);
        this.C.setShader(r0);
        r10.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.C);
        this.C.setShader(null);
        r10.restoreToCount(r1);
    }

    public final int i(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int j(String r5) {
        CharSequence r0 = this.d.getText();
        this.d.setText(r5);
        this.f.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i(48), 1073741824));
        int r6 = this.f.getMeasuredWidth();
        this.d.setText(r0);
        return r6;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        t(r4);
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        ValueAnimator r1 = this.s;
        if (r1 == null) goto L22;
        if (r1 == null) goto L21;
        r1.cancel();
    L21:
        this.s = null;
        this.n = false;
        o();
    L22:
        this.o = r4.getX();
        this.p = r4.getY();
        this.q = false;
    L24:
        return super.onInterceptTouchEvent(r4);
    L5:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L15;
    L12:
        if (r(r4) == false) goto L24;
        return true;
    L15:
        if (this.q == true) goto L24;
        l();
        goto L24
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        t(r6);
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L34;
        float r3 = 0.0f;
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L12;
    L40:
        return true;
    L12:
        if (this.q == false) goto L14;
        h(r6.getY() - this.p, 0.0f, false);
    L15:
        this.q = false;
        l();
        ViewParent r7 = getParent();
        if (r7 == null) goto L40;
        r7.requestDisallowInterceptTouchEvent(false);
        goto L40
    L14:
        o();
        q();
        goto L15
    L19:
        if (r(r6) == false) goto L40;
        u(r6.getY() - this.p);
        goto L40
    L22:
        if (this.q == false) goto L30;
        VelocityTracker r1 = this.r;
        if (r1 == null) goto L26;
        r1.computeCurrentVelocity(1000);
    L26:
        float r8 = r6.getY() - this.p;
        VelocityTracker r2 = this.r;
        if (r2 == null) goto L29;
        r3 = r2.getYVelocity();
    L29:
        h(r8, r3, true);
    L31:
        this.q = false;
        l();
        ViewParent r9 = getParent();
        if (r9 == null) goto L40;
        r9.requestDisallowInterceptTouchEvent(false);
        goto L40
    L30:
        q();
        goto L31
    L34:
        ValueAnimator r4 = this.s;
        if (r4 == null) goto L39;
        if (r4 == null) goto L38;
        r4.cancel();
    L38:
        this.s = null;
        this.n = false;
        o();
    L39:
        this.o = r6.getX();
        this.p = r6.getY();
        this.q = false;
        goto L40
    }

    public final boolean r(MotionEvent r3) {
        float r0 = Math.abs(r3.getX() - this.o);
        float r4 = Math.abs(r3.getY() - this.p);
        if (this.q == true) goto L12;
        if (r4 <= this.A) goto L12;
        if (r4 <= r0) goto L12;
        this.q = true;
        s();
        e();
        ViewParent r1 = getParent();
        if (r1 == null) goto L12;
        r1.requestDisallowInterceptTouchEvent(true);
    L12:
        return this.q;
    }

    public final void setAutoScrollEnabled(boolean r1) {
        this.l = r1;
        if (r1 == true) goto L6;
        s();
        return;
    }

    public final void setOnPrimaryQueryClickListener(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.z = r2;
    }

    public final void setOnTopicChangedListener(Function2<? super Integer, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.y = r3;
        r3.invoke(Integer.valueOf(this.m), Boolean.FALSE);
    }

    public final void setTopicList(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "topics");
        List<String> r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        String r1 = StringsKt.trim((String) r5.next()).toString();
        if (r1.length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L15:
        if (r0.isEmpty() == false) goto L17;
        r0 = this.a;
    L17:
        this.b = r0;
        m();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        q();
        return;
    L5:
        s();
    }

    public final void t(MotionEvent r6) {
        if (r6.getActionMasked() != 0) goto L6;
        l();
        this.r = VelocityTracker.obtain();
    L6:
        if (r6.getEventTime() == this.w) goto L8;
    L9:
        VelocityTracker r0 = this.r;
        if (r0 == null) goto L12;
        r0.addMovement(r6);
    L12:
        this.w = r6.getEventTime();
        this.x = r6.getActionMasked();
        return;
    L8:
        if (r6.getActionMasked() != this.x) goto L9;
    }

    public final void u(float r8) {
        if (this.b.isEmpty() == false) goto L5;
        return;
    L5:
        float r0 = i(60);
        int r2 = 2;
        if (Math.abs(r8) < (2 * r0)) goto L8;
        r2 = 4;
    L8:
        float r9 = (-RangesKt.coerceIn(r8, (-r2) * r0, r2 * r0)) / r0;
        boolean r3 = true;
        if (r9 >= 0.0f) goto L11;
        int r1 = -1;
    L12:
        float r10 = Math.abs(r9);
        int r4 = (int) r10;
        float r11 = r10 - r4;
        int r5 = this.m + (r4 * r1);
        int r6 = this.b.size();
        int r7 = ((r5 % r6) + r6) % r6;
        int r12 = this.b.size();
        int r13 = (((r7 + r1) % r12) + r12) % r12;
        b r14 = this.u;
        if (r14 != null) goto L15;
    L24:
        r14 = k(r7, r13);
        this.u = r14;
        c(r7, r1);
    L25:
        setOffsetY(((-r1) * r11) * r0);
        n(r14, r1, r11);
        return;
    L15:
        if (r14.a == r7) goto L17;
    L19:
        r3 = false;
    L20:
        if (r3 == true) goto L23;
        r14 = null;
    L23:
        if (r14 != null) goto L25;
    L17:
        if (r14.b != r13) goto L19;
    L11:
        r1 = 1;
        goto L12
    }

    public final void c(int r5, int r6) {
        TextView r0 = this.g;
        List<String> r1 = this.b;
        int r3 = r1.size();
        r0.setText((CharSequence) ListProtector.get(r1, (((r5 + r6) % r3) + r3) % r3));
        TextView r2 = this.h;
        List<String> r4 = this.b;
        int r7 = r5 + (r6 * 2);
        int r8 = r4.size();
        r2.setText((CharSequence) ListProtector.get(r4, ((r7 % r8) + r8) % r8));
    }

    public final void f(int r2, boolean r3) {
        this.s = null;
        if (r3 == false) goto L8;
        if (r2 == 0) goto L8;
        int r4 = this.m + r2;
        int r5 = this.b.size();
        int r6 = ((r4 % r5) + r5) % r5;
        this.m = r6;
        Function2<? super Integer, ? super Boolean, Unit> r7 = this.y;
        if (r7 == null) goto L8;
        r7.invoke(Integer.valueOf(r6), Boolean.TRUE);
    L8:
        o();
        this.n = false;
        q();
    }

    public final b k(int r12, int r13) {
        this.d.setText((CharSequence) ListProtector.get(this.b, r12));
        Integer r0 = Integer.valueOf(j((String) ListProtector.get(this.b, r12)));
        boolean r2 = true;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r3 = r0.intValue();
    L13:
        int r8 = r3;
        Integer r5 = Integer.valueOf(j((String) ListProtector.get(this.b, r13)));
        if (r5.intValue() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L22;
        int r9 = r5.intValue();
    L23:
        String r7 = (String) ListProtector.get(this.b, r13);
        Integer r10 = Integer.valueOf(this.c.getWidth());
        if (r10.intValue() > 0) goto L27;
        r2 = false;
    L27:
        if (r2 == false) goto L29;
        r4 = r10;
    L29:
        if (r4 == null) goto L31;
        int r11 = r4.intValue();
    L33:
        return new b(r12, r13, r8, r9, (((i(16) + r11) + i(8)) + (this.d.getPaint().measureText(r7) / 2.0f)) - (r9 / 2.0f));
    L31:
        r11 = MathKt.roundToInt(this.c.getPaint().measureText(this.c.getText().toString()));
        goto L33
    L22:
        r9 = r8;
        goto L23
    L16:
        r6 = false;
        goto L17
    L12:
        r3 = this.f.getWidth();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public ObricDoraGOnboardingTopicView(Context r17, AttributeSet r18, int r110) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r110);
        List<String> r2 = CollectionsKt.listOf(new String[]{r17.getString(2131903724), r17.getString(2131903717), r17.getString(2131903718), r17.getString(2131903715), r17.getString(2131903714), r17.getString(2131903722), r17.getString(2131903719), r17.getString(2131903723), r17.getString(2131903720), r17.getString(2131903716), r17.getString(2131903721)});
        this.a = r2;
        this.b = r2;
        Typeface r3 = F;
        final TextView r4 = g(this, 0, r3, 1);
        r4.setText(r17.getString(2131912759));
        r4.post(new z(r4, this));
        this.c = r4;
        TextView r5 = g(this, 0, r3, 1);
        this.d = r5;
        ImageView r10 = new ImageView(r17);
        r10.setImageResource(2131244568);
        this.e = r10;
        LinearLayout r11 = new LinearLayout(getContext());
        r11.setBackground(ContextCompat.getDrawable(r11.getContext(), 2131244570));
        r11.setGravity(16);
        r11.setOrientation(0);
        r11.setPadding(i(16), 0, i(16), 0);
        r11.setOnClickListener(new b0(this));
        r11.addView(r4, new LinearLayout.LayoutParams(-2, -1));
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -1);
        r6.setMarginStart(i(8));
        Unit r9 = Unit.INSTANCE;
        r11.addView(r5, r6);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(i(7), i(12));
        r7.setMarginStart(i(14));
        r7.gravity = 16;
        r11.addView(r10, r7);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-2, i(48)));
        this.f = r11;
        TextView r12 = g(this, 17, null, 2);
        this.g = r12;
        TextView r8 = g(this, 17, null, 2);
        this.h = r8;
        LinearLayout r13 = new LinearLayout(r17);
        r13.setGravity(1);
        r13.setOrientation(1);
        this.i = r13;
        this.j = CoroutineScopeKt.MainScope();
        this.l = true;
        this.w = Long.MIN_VALUE;
        this.x = 3;
        this.A = ViewConfiguration.get(r17).getScaledTouchSlop();
        this.B = MathKt.roundToInt(ViewConfiguration.get(r17).getScaledMinimumFlingVelocity() * 1.5f);
        Paint r14 = new Paint(1);
        r14.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.C = r14;
        this.D = new float[]{getResources().getDimension(2131167363), getResources().getDimension(2131167493), getResources().getDimension(2131166757)};
        setClipChildren(true);
        LinearLayout r15 = new LinearLayout(r17);
        r15.setGravity(1);
        r15.setOrientation(1);
        r15.addView(r11);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.topMargin = i(12);
        r15.addView(r13, r1);
        addView(r15, new FrameLayout.LayoutParams(-1, -2));
        r13.addView(r12, new LinearLayout.LayoutParams(-1, i(48)));
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, i(48));
        r16.topMargin = i(12);
        r13.addView(r8, r16);
        d();
    }

    public final void h(float r8, float r9, boolean r10) {
        if (this.b.isEmpty() == false) goto L6;
        q();
        return;
    L6:
        float r1 = i(60);
        if (Math.abs(r9) < this.B) goto L9;
        float r11 = RangesKt.coerceIn(r9 * 0.08f, -i(120), i(120));
    L11:
        if (r10 == true) goto L13;
        int r12 = 0;
    L18:
        s();
        this.n = true;
        float r4 = (-r12) * i(60);
        float r5 = Math.abs(r4 - r8);
        if (r5 >= 0.5f) goto L21;
        f(r12, r10);
        return;
    L21:
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{r8, r4});
        r13.setDuration((long) ((RangesKt.coerceAtMost(r5 / i(60), 4.0f) * 55.0f) + 160.0f));
        r13.setInterpolator(new AccelerateDecelerateInterpolator());
        r13.addUpdateListener(new c0(this));
        r13.addListener(new e0(r6, this, r12, r10));
        r13.start();
        this.s = r13;
        return;
    L13:
        if (Math.abs(r8) < (2 * r1)) goto L15;
        int r7 = 4;
    L16:
        r12 = RangesKt.coerceIn(MathKt.roundToInt((-(r11 + r8)) / r1), -r7, r7);
        goto L18
    L15:
        r7 = 2;
        goto L16
    L9:
        r11 = 0.0f;
        goto L11
    }

    public final void n(b r4, int r5, float r6) {
        int r0 = r4.d;
        int r1 = r4.c;
        float r2 = (r0 - r1) * r6;
        setPrimaryQueryWidth(r1 + MathKt.roundToInt(r2));
        this.e.setTranslationX(r2);
        this.d.setTranslationY(((-r5) * i(60)) * r6);
        this.d.setAlpha(1.0f - r6);
        this.g.setTranslationX(r4.e * r6);
    }

    public /* synthetic */ ObricDoraGOnboardingTopicView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void a(ObricDoraGOnboardingTopicView r2, b r3, int r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animator");
        Object r0 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
        r2.setOffsetY(((Float) r0).floatValue());
        r2.n(r3, r4, r5.getAnimatedFraction());
    }

    public static TextView g(ObricDoraGOnboardingTopicView r1, int r2, Typeface r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 16;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = G;
    L8:
        r1.getClass();
        TextView r5 = new TextView(r1.getContext());
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setGravity(r2);
        r5.setIncludeFontPadding(false);
        r5.setLineSpacing(0.0f, 1.5f);
        r5.setMaxLines(1);
        r5.setTextSize(2, 16.0f);
        r5.setTextColor(ContextCompat.getColor(r5.getContext(), 2131103973));
        r5.setTypeface(r3);
        return r5;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        if (r9 <= 0) goto L6;
        if (r10 <= 0) goto L6;
        float r4 = r10;
        float[] r13 = this.D;
        LinearGradient r14 = new LinearGradient(0.0f, 0.0f, 0.0f, r4, new int[]{-16777216, -16777216, 1291845632, 520093696, 520093696}, new float[]{0.0f, r13[0] / r4, r13[1] / r4, r13[2] / r4, 1.0f}, Shader.TileMode.CLAMP);
    L7:
        this.E = r14;
        return;
    L6:
        r14 = null;
        goto L7
    }
}
