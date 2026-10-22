package com.obric.oui.bouncelayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.AbsListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b(\b\u0000\u0018\u0000 N2\u00020\u0001:\u0001NBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0002J\u001f\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\u0012\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u00102\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\u0006\u00103\u001a\u00020\u000bJ\u000e\u00104\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u000e\u00105\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u000e\u00106\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u000e\u00107\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u000e\u00108\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u0010\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u000eH\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0011H\u0002J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\b\u0010A\u001a\u00020\u000bH\u0002J\b\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020\u000bH\u0002J\b\u0010D\u001a\u00020\u0011H\u0002J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\u0018\u0010G\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0011H\u0002J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010J\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/bouncelayout/AbsListBounceGestureDelegate;", "", TypedValues.AttributesType.S_TARGET, "Landroid/widget/AbsListView;", "edgeEffectsInstalledProvider", "Lkotlin/Function0;", "", "bounceTopProvider", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceBottomProvider", "stopBounceIfNeeded", "", "resetAbsListViewTouchMode", "getBounceTranslation", "", "(Landroid/widget/AbsListView;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bounceDragActivePointerId", "", "bounceDragDownY", "bounceDragLastHandledEventTime", "", "bounceDragLastY", "bounceDragTouchActive", "bounceDragVelocityTracker", "Landroid/view/VelocityTracker;", "emptyAreaBounceDragging", "emptyAreaBounceTouchActive", "emptyAreaDownY", "emptyAreaLastY", "maximumFlingVelocity", "minimumFlingVelocity", "touchSlop", "addBounceDragMovement", "event", "Landroid/view/MotionEvent;", "consumeScrollDeltaY", "scrollDeltaY", "findActualScrollDeltaY", "oldPositions", "", "oldTops", "([I[I)Ljava/lang/Integer;", "finishBounceDragGesture", "releaseEdge", "velocityY", "getBounceDragContentVelocityY", "handleBounceDragPointerUp", "initOrResetBounceDragVelocityTracker", "isBounceEffectActive", "effect", "onDown", "onInterceptEnd", "onPointerDown", "onPointerUp", "onTouchDown", "onTouchEnd", "onTouchMove", "pullActiveOrOppositeBounce", "deltaDistance", "pullBounceDrag", "deltaY", "pullEdgeForExhaustedContentDelta", "unconsumed", "pullEdgeForUnconsumedScrollDelta", "pullEmptyAreaBounce", "recycleBounceDragVelocityTracker", "releaseBounceDrag", "releaseEmptyAreaBounce", "resolveBounceDragReleaseEdge", "resolveEdgeForUnconsumedScrollDelta", "resolveScrollStepLimit", "scrollContentThenPullOppositeBounce", "oppositeEdge", "shouldHandleEmptyAreaBounce", "shouldInterceptMove", "shouldStartBounceDragFromMove", "updateBounceDragActivePointer", "pointerIndex", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0731a f13356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbsListView f13357b;
    private final Function0<Boolean> c;
    private final Function0<e> d;
    private final Function0<e> e;
    private final Function0<Unit> f;
    private final Function0<Unit> g;
    private final Function0<Float> h;
    private final int i;
    private final int j;
    private final int k;
    private boolean l;
    private boolean m;
    private float n;
    private float o;
    private boolean p;
    private int q;
    private float r;
    private float s;
    private VelocityTracker t;
    private long u;

    /* JADX INFO: renamed from: com.obric.oui.bouncelayout.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/bouncelayout/AbsListBounceGestureDelegate$Companion;", "", "()V", "BOUNCE_DRAG_NO_EDGE", "", "INVALID_POINTER_ID", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0731a {
        private C0731a() {
        }

        public /* synthetic */ C0731a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13356a = new C0731a(null);
    }

    public a(AbsListView r3, Function0<Boolean> r4, Function0<e> r5, Function0<e> r6, Function0<Unit> r7, Function0<Unit> r8, Function0<Float> r9) {
        Function0<Boolean> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<e> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<e> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function0<Float> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r10, "edgeEffectsInstalledProvider");
        Intrinsics.checkNotNullParameter(r11, "bounceTopProvider");
        Intrinsics.checkNotNullParameter(r12, "bounceBottomProvider");
        Intrinsics.checkNotNullParameter(r13, "stopBounceIfNeeded");
        Intrinsics.checkNotNullParameter(r14, "resetAbsListViewTouchMode");
        Intrinsics.checkNotNullParameter(r15, "getBounceTranslation");
        this.f13357b = r3;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        this.j = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledMinimumFlingVelocity();
        this.k = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledMaximumFlingVelocity();
        this.q = -1;
        this.u = -1;
    }

    private final Integer a(int[] r5, int[] r6) {
        int r0 = this.f13357b.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        int r3 = ArraysKt.indexOf(r5, this.f13357b.getFirstVisiblePosition() + r1);
        if (r3 >= 0) goto L7;
        r1 = r2;
        goto L3
    L7:
        return Integer.valueOf(r6[r3] - this.f13357b.getChildAt(r1).getTop());
    L9:
        return null;
    }

    private final void a(float r3) {
        if (this.f13357b.getHeight() > 0) goto L6;
        return;
    L6:
        if (c(r3 / this.f13357b.getHeight()) == false) goto L8;
    L13:
        this.f13357b.invalidate();
        return;
    L8:
        if (r3 <= 0.0f) goto L11;
    L9:
        a(MathKt.roundToInt(-r3));
        goto L13
    L11:
        if (r3 >= 0.0f) goto L13;
        goto L13
    }

    private final void a(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        if (this.f13357b.getHeight() <= 0) goto L12;
        int r0 = d(r5);
        d r1 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragContentScroll", "oppositeEdge=" + c(r0) + " scrollDeltaY=" + r5 + " consumed=" + (r5 - r0) + " unconsumed=" + r0);
    L9:
        b(r0);
        return;
    }

    private final void a(int r8, int r9) {
        if (r8 != 0) goto L4;
        return;
    L4:
        if (this.f13357b.getHeight() <= 0) goto L32;
        int r0 = d(r8);
        d r1 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragContentScroll", "oppositeEdge=" + r9 + " scrollDeltaY=" + r8 + " consumed=" + (r8 - r0) + " unconsumed=" + r0);
    L9:
        if (r0 != 0) goto L11;
        return;
    L11:
        d r2 = d.f13362a;
        if (d.a() == false) goto L14;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragDirectReverse", "edge=" + r9 + " scrollDeltaY=" + r8 + " unconsumed=" + r0);
    L14:
        if (r9 != 0) goto L22;
        if (r0 >= 0) goto L22;
        e r10 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L33;
        float r11 = -r0;
    L20:
        r10.c(r11 / this.f13357b.getHeight());
        return;
    L33:
        return;
    L22:
        if (r9 != 1) goto L30;
        if (r0 <= 0) goto L31;
        r10 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L34;
        r11 = r0;
        goto L20
    L34:
        return;
    L31:
        return;
    L30:
        return;
    }

    private final void a(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.q = r3.getPointerId(r2);
        this.s = r3.getY(r2);
        return;
    }

    private final boolean a(e r4) {
        if (r4 == null) goto L18;
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        if (r4.a() != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        return true;
    L15:
        if (r4.isFinished() == true) goto L18;
        return true;
    L12:
        r2 = false;
        goto L13
    L7:
        r1 = false;
    L18:
        return false;
    }

    private final void b() {
        VelocityTracker r0 = this.t;
        if (r0 != null) goto L5;
        this.t = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private final void b(float r3) {
        if (this.f13357b.getHeight() > 0) goto L6;
        return;
    L6:
        if (c(r3 / this.f13357b.getHeight()) == false) goto L8;
    L13:
        this.f13357b.invalidate();
        return;
    L8:
        if (r3 <= 0.0f) goto L11;
    L9:
        a(MathKt.roundToInt(-r3));
        goto L13
    L11:
        if (r3 >= 0.0f) goto L13;
        goto L13
    }

    private final void b(int r6) {
        if (r6 < 0) goto L5;
    L14:
        if (r6 > 0) goto L16;
        return;
    L16:
        if (this.f13357b.getHeight() <= 0) goto L24;
        d r2 = d.f13362a;
        if (d.a() == false) goto L20;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragDirectReverse", Intrinsics.stringPlus("edge=1 unconsumed=", Integer.valueOf(r6)));
    L20:
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L25;
    L13:
        r0.c(r6 / this.f13357b.getHeight());
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (this.f13357b.getHeight() <= 0) goto L14;
        d r3 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragDirectReverse", Intrinsics.stringPlus("edge=0 unconsumed=", Integer.valueOf(r6)));
    L9:
        r0 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L26;
        r6 = -r6;
        goto L13
    }

    private final boolean b(int r10, int r11) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r11 == 0) goto L57;
        if (r10 != 0) goto L10;
        if (r11 >= 0) goto L10;
        if (r0 == null) goto L9;
        r0.onAbsorb(r11);
    L9:
        return false;
    L10:
        if (r10 != 1) goto L17;
        if (r11 <= 0) goto L17;
        if (r1 == null) goto L15;
        r1.onAbsorb(r11);
    L15:
        return false;
    L17:
        if (r11 <= 0) goto L27;
        if (this.f13357b.canScrollList(1) == false) goto L27;
        d r12 = d.f13362a;
        if (d.a() == false) goto L24;
        View r13 = (View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("velocityY=").append(r11);
        String r3 = " direction=1";
    L23:
        d.a(r13, "bounceDragContentFling", r2.append(r3).toString());
    L24:
        this.f13357b.fling(r11);
        return true;
    L27:
        if (r11 < 0) goto L29;
    L33:
        if (r10 != 1) goto L39;
        if (r11 >= 0) goto L39;
        if (r1 == null) goto L38;
        r1.onRelease();
    L38:
        return false;
    L39:
        if (r10 != 0) goto L45;
        if (r11 <= 0) goto L45;
        if (r0 == null) goto L44;
        r0.onRelease();
    L44:
        return false;
    L45:
        if (r10 != (-1)) goto L51;
        if (r11 <= 0) goto L51;
        if (r1 == null) goto L50;
        r1.onAbsorb(r11);
    L50:
        return false;
    L51:
        if (r10 != (-1)) goto L57;
        if (r11 >= 0) goto L57;
        if (r0 == null) goto L56;
        r0.onAbsorb(r11);
    L56:
        return false;
    L29:
        if (this.f13357b.canScrollList(-1) == false) goto L33;
        d r14 = d.f13362a;
        if (d.a() == false) goto L24;
        r13 = (View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder().append("velocityY=").append(r11);
        r3 = " direction=-1";
    L57:
        if (r10 == 0) goto L63;
        if (r10 != 1) goto L66;
        if (r1 == null) goto L66;
        r1.onRelease();
    L66:
        return false;
    L63:
        if (r0 == null) goto L66;
        r0.onRelease();
        goto L66
    }

    private final int c(int r1) {
        if (r1 >= 0) goto L4;
        return 0;
    L4:
        if (r1 <= 0) goto L6;
        return 1;
    L6:
        return -1;
    }

    private final void c() {
        VelocityTracker r0 = this.t;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.t = null;
    }

    private final boolean c(float r8) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        boolean r2 = a(r0);
        boolean r3 = a(r1);
        if (r2 == false) goto L11;
        if (r0 != null) goto L6;
        float r4 = 0.0f;
    L7:
        float r9 = r8 - r4;
        if (r9 >= 0.0f) goto L19;
        a(MathKt.roundToInt((-r9) * this.f13357b.getHeight()), 1);
    L19:
        return true;
    L6:
        r4 = r0.onPullDistance(r8, 0.5f);
        goto L7
    L11:
        if (r3 == false) goto L20;
        float r10 = -r8;
        if (r1 != null) goto L15;
        float r5 = 0.0f;
    L16:
        float r11 = r10 - r5;
        if (r11 >= 0.0f) goto L19;
        a(MathKt.roundToInt(r11 * this.f13357b.getHeight()), 0);
        goto L19
    L15:
        r5 = r1.onPullDistance(r10, 0.5f);
        goto L16
    L20:
        return false;
    }

    private final int d() {
        int r0 = RangesKt.coerceAtLeast(((this.f13357b.getHeight() - this.f13357b.getListPaddingTop()) - this.f13357b.getListPaddingBottom()) - 1, 1);
        int r2 = this.f13357b.getChildCount();
        int r4 = 0;
        int r5 = Integer.MAX_VALUE;
    L3:
        if (r4 >= r2) goto L9;
        int r6 = r4 + 1;
        int r7 = this.f13357b.getChildAt(r4).getHeight();
        if (r7 <= 0) goto L8;
        if (r7 >= r5) goto L8;
        r5 = r7;
    L8:
        r4 = r6;
        goto L3
    L9:
        if (r5 != Integer.MAX_VALUE) goto L12;
        return r0;
    L12:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5 / 2, 1), r0);
    }

    private final int d(int r10) {
        if (r10 != 0) goto L4;
    L35:
        return r10;
    L4:
        if (this.f13357b.getChildCount() == 0) goto L35;
        if (this.f13357b.canScrollList(r10) == false) goto L35;
        int r0 = d();
        int r2 = 0;
    L9:
        if (r10 == 0) goto L35;
        if (this.f13357b.canScrollList(r10) == false) goto L35;
        if (r10 <= 0) goto L14;
        int r3 = RangesKt.coerceAtMost(r10, r0);
    L15:
        int r4 = this.f13357b.getChildCount();
        int[] r5 = new int[r4];
        int r6 = 0;
    L16:
        if (r6 >= r4) goto L18;
        r5[r6] = this.f13357b.getFirstVisiblePosition() + r6;
        r6 = r6 + 1;
        goto L16
    L18:
        int[] r7 = new int[r4];
        int r8 = 0;
    L19:
        if (r8 >= r4) goto L21;
        r7[r8] = this.f13357b.getChildAt(r8).getTop();
        r8 = r8 + 1;
        goto L19
    L21:
        this.f13357b.scrollListBy(r3);
        Integer r9 = a(r5, r7);
        if (r9 == null) goto L23;
        r2 = r2 + 1;
        int r11 = r9.intValue();
        if (r3 <= 0) goto L29;
        int r12 = RangesKt.coerceIn(r11, 0, r3);
    L30:
        if (r12 == 0) goto L35;
        r10 = r10 - r12;
        if (r2 <= ((this.f13357b.getCount() + this.f13357b.getChildCount()) + 1)) goto L9;
        return 0;
    L29:
        r12 = RangesKt.coerceIn(r11, r3, 0);
        goto L30
    L23:
        d r1 = d.f13362a;
        if (d.a() == false) goto L35;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragScrollMeasureMiss", "step=" + r3 + " remaining=" + r10 + " childCountBefore=" + r4 + " childCountAfter=" + this.f13357b.getChildCount());
        goto L35
    L14:
        r3 = RangesKt.coerceAtLeast(r10, -r0);
        goto L15
    }

    private final void e() {
        this.p = false;
        int r0 = f();
        int r1 = g();
        this.q = -1;
        this.u = -1;
        d r2 = d.f13362a;
        if (d.a() == false) goto L6;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragRelease", "translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue() + " velocityY=" + r0);
    L6:
        if (b(r1, r0) == true) goto L8;
        this.g.invoke();
    L8:
        c();
        this.f13357b.invalidate();
    }

    private final int f() {
        int r0 = this.q;
        VelocityTracker r1 = this.t;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != (-1)) goto L8;
        return 0;
    L8:
        r1.computeCurrentVelocity(1000, this.k);
        float r2 = r1.getYVelocity(r0);
        if (Math.abs(r2) >= this.j) goto L12;
        return 0;
    L12:
        return MathKt.roundToInt(-r2);
    }

    private final int g() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        boolean r2 = a(r0);
        boolean r5 = a(r1);
        if (r2 == false) goto L6;
        if (r5 == true) goto L6;
    L24:
        return 0;
    L6:
        if (r5 == false) goto L10;
        if (r2 == true) goto L10;
        return 1;
    L10:
        if (r0 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L24;
        if (r1 != null) goto L18;
        float r4 = 0.0f;
    L20:
        if (r4 < 0.0f) goto L26;
        return -1;
    L26:
        return 1;
    L18:
        r4 = r1.a();
        goto L20
    L12:
        r3 = r0.a();
        goto L14
    }

    private final void h() {
        this.l = false;
        this.m = false;
        d r0 = d.f13362a;
        if (d.a() == false) goto L5;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "emptyAreaRelease", Intrinsics.stringPlus("translation=", this.h.invoke()));
    L5:
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.onRelease();
    L9:
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        r2.onRelease();
    L13:
        this.f13357b.invalidate();
    }

    private final boolean h(MotionEvent r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return false;
    L5:
        if (this.f13357b.getHeight() > 0) goto L8;
        return false;
    L8:
        if (this.f13357b.pointToPosition((int) r4.getX(), (int) r4.getY()) != (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean i(MotionEvent r7) {
        boolean r1 = false;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L25:
        return r1;
    L5:
        if (this.f13357b.getHeight() <= 0) goto L25;
        if (a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin")) == false) goto L10;
    L12:
        int r0 = r7.findPointerIndex(this.q);
        if (r0 >= 0) goto L15;
        return false;
    L15:
        float r3 = r7.getY(r0) - this.r;
        if (Math.abs(r3) > this.i) goto L18;
        return false;
    L18:
        this.f.invoke();
        k(r7);
        r1 = true;
        this.p = true;
        this.s = this.r;
        a(r7.getY(r0) - this.s);
        this.s = r7.getY(r0);
        this.u = r7.getEventTime();
        ViewParent r8 = this.f13357b.getParent();
        if (r8 == null) goto L22;
        r8.requestDisallowInterceptTouchEvent(true);
    L22:
        d r9 = d.f13362a;
        if (d.a() == false) goto L25;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f13357b, View.class, "com.obric.memorydata.plugin"), "bounceDragStart", "dy=" + r3 + " translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L25
    L10:
        if (a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L12;
        return false;
    }

    private final void j(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.q) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        a(r1, r4);
        return;
    L16:
        this.q = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    private final void k(MotionEvent r1) {
        VelocityTracker r0 = this.t;
        if (r0 == null) goto L7;
        r0.addMovement(r1);
        return;
    }

    public final void a() {
        this.p = false;
        this.q = -1;
        this.u = -1;
        c();
    }

    public final void a(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.l = false;
        this.m = false;
        this.p = false;
        this.q = r3.getPointerId(0);
        float r0 = r3.getY(0);
        this.r = r0;
        this.s = r0;
        this.u = -1;
        b();
        k(r3);
    }

    public final boolean b(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return i(r2);
    }

    public final boolean c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.p == true) goto L6;
        return false;
    L6:
        a(r2.getActionIndex(), r2);
        return true;
    }

    public final boolean d(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.p == true) goto L6;
        return false;
    L6:
        j(r2);
        return true;
    }

    public final boolean e(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (h(r3) == false) goto L6;
        this.l = true;
        this.m = false;
        this.n = r3.getY();
        this.o = r3.getY();
        return true;
    L6:
        a(r3);
        return false;
    }

    public final boolean f(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        boolean r2 = false;
        if (this.p == false) goto L19;
        if (r9.getEventTime() != this.u) goto L7;
        return true;
    L7:
        int r0 = r9.findPointerIndex(this.q);
        if (r0 >= 0) goto L11;
        e();
        return true;
    L11:
        float r1 = r9.getY(r0);
        float r4 = r1 - this.s;
        if (r4 != 0.0f) goto L14;
        r2 = true;
    L14:
        if (r2 == true) goto L16;
        k(r9);
        a(r4);
    L16:
        this.s = r1;
        return true;
    L19:
        if (i(r9) == false) goto L22;
        return true;
    L22:
        if (this.l == false) goto L37;
        float r10 = r9.getY();
        float r3 = r10 - this.n;
        float r5 = r10 - this.o;
        if (this.m == true) goto L29;
        if (Math.abs(r3) <= this.i) goto L29;
        this.m = true;
    L29:
        if (this.m == true) goto L31;
    L35:
        this.o = r10;
        return true;
    L31:
        if (r5 != 0.0f) goto L33;
        r2 = true;
    L33:
        if (r2 == true) goto L35;
        b(r5);
        goto L35
    L37:
        return false;
    }

    public final boolean g(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.p == false) goto L7;
        k(r3);
        e();
        return true;
    L7:
        if (this.l == false) goto L10;
        h();
        return true;
    L10:
        return false;
    }
}
