package com.obric.oui.bouncelayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0000\u0018\u0000 Z2\u00020\u0001:\u0002Z[Bÿ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0011\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000eH\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0002J\b\u00105\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\b\u00107\u001a\u00020\u0012H\u0002J\u0012\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\bH\u0002J \u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J \u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J \u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020A2\u0006\u00102\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0002J\u000e\u0010B\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,J\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010E\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010F\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010G\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u0010\u0010H\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u0010I\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\fH\u0002J\u0010\u0010L\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002J\b\u0010M\u001a\u00020\u0012H\u0002J\b\u0010N\u001a\u00020\u0012H\u0002J\u0006\u0010O\u001a\u00020\u0012J\u0010\u0010P\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J\b\u0010Q\u001a\u00020\u000eH\u0002J\b\u0010R\u001a\u00020\u0006H\u0002J\u000e\u0010S\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u0010\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\fH\u0002J\u0018\u0010V\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate;", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "edgeEffectsInstalledProvider", "Lkotlin/Function0;", "", "bounceTopProvider", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceBottomProvider", "stopBounceIfNeeded", "getBounceTranslation", "", "getScrollRangeY", "", "getScrollY", "scrollByY", "Lkotlin/Function1;", "", "consumeScrollDeltaYWithParent", "Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate$ContentScrollResult;", "shouldHandleBoundaryWithParentProvider", "canScrollVerticallyProvider", "canRouteFlingVerticallyProvider", "flingY", "postInvalidateOnAnimation", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "bounceStoppedForTouch", "manualBounceActiveEdge", "manualBounceActivePointerId", "manualBounceDownY", "manualBounceDragging", "manualBounceLastHandledEventTime", "", "manualBounceLastY", "manualBounceNestedYOffset", "manualBounceTouchActive", "manualBounceVelocityTracker", "Landroid/view/VelocityTracker;", "maximumFlingVelocity", "minimumFlingVelocity", "touchSlop", "addManualBounceMovement", "event", "Landroid/view/MotionEvent;", "canRouteFlingVertically", "direction", "consumeScrollDeltaY", "scrollDeltaY", "finishCurrentBounceBeforeOppositeHandoff", "releaseEdge", "finishManualBounceGesture", "velocityY", "getManualBounceContentVelocityY", "handleManualBouncePointerUp", "initOrResetManualBounceVelocityTracker", "isBounceEffectActive", "effect", "logManualContentScroll", "oppositeEdge", "unconsumed", "logManualDirectReverse", "edge", "logManualReleaseDecision", "action", "", "onDown", "onInterceptEnd", "onPointerDown", "onPointerUp", "onTouchEnd", "onTouchMove", "pullBottomOrScrollContent", "pullEdgeForUnconsumedScrollDelta", "pullManualBounce", "deltaY", "pullTopOrScrollContent", "recycleManualBounceVelocityTracker", "releaseManualBounce", "releaseStoppedBounceIfNeeded", "resolveEdgeForUnconsumedScrollDelta", "resolveManualBounceReleaseEdge", "shouldHandleManualBounce", "shouldInterceptMove", "shouldStartManualBounce", "totalDeltaY", "startContentFling", "tryStartManualBounceFromMove", "updateManualBounceActivePointer", "pointerIndex", "Companion", "ContentScrollResult", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f13372a = null;
    private int A;
    private VelocityTracker B;
    private boolean C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13373b;
    private final Function0<Boolean> c;
    private final Function0<e> d;
    private final Function0<e> e;
    private final Function0<Boolean> f;
    private final Function0<Float> g;
    private final Function0<Integer> h;
    private final Function0<Integer> i;
    private final Function1<Integer, Unit> j;
    private final Function1<Integer, b> k;
    private final Function0<Boolean> l;
    private final Function1<Integer, Boolean> m;
    private final Function1<Integer, Boolean> n;
    private final Function1<Integer, Unit> o;
    private final Function0<Unit> p;
    private final int q;
    private final int r;
    private final int s;
    private boolean t;
    private boolean u;
    private float v;
    private float w;
    private int x;
    private int y;
    private long z;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate$Companion;", "", "()V", "INVALID_POINTER_ID", "", "MANUAL_BOUNCE_BOTTOM", "MANUAL_BOUNCE_NONE", "MANUAL_BOUNCE_TOP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate$ContentScrollResult;", "", "unconsumedY", "", "offsetInWindowY", "(II)V", "getOffsetInWindowY", "()I", "getUnconsumedY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13375b;

        public b(int r1, int r2) {
            this.f13374a = r1;
            this.f13375b = r2;
        }

        public /* synthetic */ b(int r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = 0;
        L5:
            this(r1, r2);
        }

        public final int a() {
            return this.f13374a;
        }

        public final int b() {
            return this.f13375b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f13374a == r6.f13374a) goto L12;
            return false;
        L12:
            if (this.f13375b == r6.f13375b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f13374a) * 31) + Integer.hashCode(this.f13375b);
        }

        public String toString() {
            return "ContentScrollResult(unconsumedY=" + this.f13374a + ", offsetInWindowY=" + this.f13375b + ')';
        }
    }

    static {
        f13372a = new a(null);
    }

    public j(View r17, Function0<Boolean> r18, Function0<e> r19, Function0<e> r20, Function0<Boolean> r21, Function0<Float> r22, Function0<Integer> r23, Function0<Integer> r24, Function1<? super Integer, Unit> r25, Function1<? super Integer, b> r26, Function0<Boolean> r27, Function1<? super Integer, Boolean> r28, Function1<? super Integer, Boolean> r29, Function1<? super Integer, Unit> r30, Function0<Unit> r31) {
        Function0<Boolean> r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Function0<e> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Function0<e> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Function0<Float> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        Function0<Integer> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        Function0<Integer> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r24, Function0.class, "com.obric.memorydata.plugin");
        Function1<Integer, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Function1<Integer, b> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
        Function1<Integer, Boolean> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Function1<Integer, Boolean> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Function1<Integer, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r31, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r2, "edgeEffectsInstalledProvider");
        Intrinsics.checkNotNullParameter(r4, "bounceTopProvider");
        Intrinsics.checkNotNullParameter(r5, "bounceBottomProvider");
        Intrinsics.checkNotNullParameter(r6, "stopBounceIfNeeded");
        Intrinsics.checkNotNullParameter(r7, "getBounceTranslation");
        Intrinsics.checkNotNullParameter(r8, "getScrollRangeY");
        Intrinsics.checkNotNullParameter(r9, "getScrollY");
        Intrinsics.checkNotNullParameter(r10, "scrollByY");
        Intrinsics.checkNotNullParameter(r13, "canScrollVerticallyProvider");
        Intrinsics.checkNotNullParameter(r15, "flingY");
        Intrinsics.checkNotNullParameter(r16, "postInvalidateOnAnimation");
        this.f13373b = r17;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r16;
        this.q = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        this.r = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledMinimumFlingVelocity();
        this.s = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledMaximumFlingVelocity();
        this.y = -1;
        this.z = -1;
    }

    public /* synthetic */ j(View r17, Function0 r18, Function0 r19, Function0 r20, Function0 r21, Function0 r22, Function0 r23, Function0 r24, Function1 r25, Function1 r26, Function0 r27, Function1 r28, Function1 r29, Function1 r30, Function0 r31, int r32, DefaultConstructorMarker r33) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r24, Function0.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r31, Function0.class, "com.obric.memorydata.plugin");
        if ((r32 & 512) == 0) goto L5;
        Function1 r15 = null;
    L7:
        if ((r32 & 1024) == 0) goto L10;
        r11 = null;
    L10:
        if ((r32 & 4096) == 0) goto L12;
        r13 = null;
    L12:
        this(r17, r1, r3, r4, r5, r6, r7, r8, r9, r15, r11, r12, r13, r14, r2);
        return;
    L5:
        r15 = r10;
        goto L7
    }

    private final int a(int r6) {
        b r0 = e(r6);
        int r1 = r0.a();
        a(1, r6, r1);
        if (r1 <= 0) goto L11;
        if (this.f13373b.getHeight() <= 0) goto L11;
        this.x = 2;
        b(1, r6, r1);
        e r7 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        r7.c(r1 / this.f13373b.getHeight());
    L14:
        return r0.b();
    L11:
        if (a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L14;
        this.x = 0;
        goto L14
    }

    private final void a(int r6, int r7) {
        int r1 = 1;
        if (r7 == 0) goto L41;
        if (r6 != 1) goto L11;
        if (r7 >= 0) goto L11;
        a("absorbCurrentTop", r6, r7);
        e r5 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L52;
        r5.onAbsorb(r7);
        return;
    L52:
        return;
    L11:
        if (r6 != 2) goto L19;
        if (r7 <= 0) goto L19;
        a("absorbCurrentBottom", r6, r7);
        e r8 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L53;
        r8.onAbsorb(r7);
        return;
    L53:
        return;
    L19:
        if (r7 <= 0) goto L21;
        int r4 = 1;
    L23:
        if (f(r4) == false) goto L29;
        if (r7 > 0) goto L27;
        r1 = -1;
    L27:
        g(r6);
        a("routedFling", r6, r7);
        b(r7, r1);
        return;
    L29:
        if (r7 <= 0) goto L35;
        g(r6);
        a("absorbBottomAtEdge", r6, r7);
        e r9 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L54;
        r9.onAbsorb(r7);
        return;
    L54:
        return;
    L35:
        if (r7 >= 0) goto L41;
        g(r6);
        a("absorbTopAtEdge", r6, r7);
        e r10 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L55;
        r10.onAbsorb(r7);
        return;
    L55:
        return;
    L21:
        r4 = -1;
    L41:
        if (r6 == 1) goto L47;
        if (r6 != 2) goto L56;
        a("releaseBottom", r6, r7);
        e r11 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L57;
    L50:
        r11.onRelease();
        return;
    L57:
        return;
    L56:
        return;
    L47:
        a("releaseTop", r6, r7);
        r11 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L50;
    }

    private final void a(int r3, int r4, int r5) {
        d r0 = d.f13362a;
        if (d.a() == false) goto L6;
        d.a(this.f13373b, "bounceDragContentScroll", "oppositeEdge=" + r3 + " scrollDeltaY=" + r4 + " consumed=" + (r4 - r5) + " unconsumed=" + r5);
        return;
    }

    private final void a(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.y = r3.getPointerId(r2);
        this.w = r3.getY(r2);
        return;
    }

    private final void a(String r4, int r5, int r6) {
        d r0 = d.f13362a;
        if (d.a() == false) goto L6;
        d.a(this.f13373b, "manualBounceReleaseDecision", "action=" + r4 + " releaseEdge=" + r5 + " velocityY=" + r6 + " scrollY=" + ((Number) ZeusTransformUtils.preCheckCast(this.i.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() + " range=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() + " translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    }

    private final boolean a(float r6) {
        if (Math.abs(r6) > this.q) goto L6;
        return false;
    L6:
        if (a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin")) == false) goto L8;
    L19:
        return true;
    L8:
        if (a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L19;
        Function1<Integer, Boolean> r5 = this.m;
        if (r6 <= 0.0f) goto L16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(-1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L18;
        return false;
    L18:
        return true;
    L16:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L18;
        return false;
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

    private final int b(float r9) {
        int r1 = 0;
        if (this.f13373b.getHeight() > 0) goto L5;
        return 0;
    L5:
        float r0 = r9 / this.f13373b.getHeight();
        boolean r2 = a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin"));
        boolean r3 = a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin"));
        boolean r6 = true;
        if (r2 == false) goto L17;
        this.x = 1;
        e r10 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L10;
        float r11 = 0.0f;
    L11:
        float r4 = r0 - r11;
        if (r4 >= 0.0f) goto L15;
        r1 = a(MathKt.roundToInt((-r4) * this.f13373b.getHeight()));
    L34:
        this.f13373b.invalidate();
        return r1;
    L15:
        if (a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L34;
    L16:
        this.x = 0;
        goto L34
    L10:
        r11 = r10.onPullDistance(r0, 0.5f);
        goto L11
    L17:
        if (r3 == false) goto L29;
        this.x = 2;
        float r12 = -r0;
        e r5 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L21;
        float r7 = 0.0f;
    L22:
        float r13 = r12 - r7;
        if (r13 >= 0.0f) goto L26;
        r1 = b(MathKt.roundToInt(r13 * this.f13373b.getHeight()));
        goto L34
    L26:
        if (a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L34;
    L21:
        r7 = r5.onPullDistance(r12, 0.5f);
        goto L22
    L29:
        if (r9 == 0.0f) goto L32;
        r6 = false;
    L32:
        if (r6 == true) goto L34;
        r1 = c(MathKt.roundToInt(-r9));
        goto L34
    }

    private final int b(int r6) {
        b r0 = e(r6);
        int r1 = r0.a();
        a(0, r6, r1);
        if (r1 >= 0) goto L11;
        if (this.f13373b.getHeight() <= 0) goto L11;
        this.x = 1;
        b(0, r6, r1);
        e r7 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        r7.c((-r1) / this.f13373b.getHeight());
    L14:
        return r0.b();
    L11:
        if (a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L14;
        this.x = 0;
        goto L14
    }

    private final void b(int r4, int r5) {
        d r0 = d.f13362a;
        if (d.a() == false) goto L5;
        d.a(this.f13373b, "bounceDragContentFling", "velocityY=" + r4 + " direction=" + r5);
    L5:
        this.o.invoke(Integer.valueOf(r4));
        this.p.invoke();
    }

    private final void b(int r3, int r4, int r5) {
        d r0 = d.f13362a;
        if (d.a() == false) goto L6;
        d.a(this.f13373b, "bounceDragDirectReverse", "edge=" + r3 + " scrollDeltaY=" + r4 + " unconsumed=" + r5);
        return;
    }

    private final int c(int r7) {
        if (r7 != 0) goto L5;
    L26:
        return 0;
    L5:
        if (this.f13373b.getHeight() <= 0) goto L26;
        b r1 = e(r7);
        int r2 = r1.a();
        a(d(r2), r7, r2);
        if (r2 < 0) goto L10;
    L16:
        if (r2 > 0) goto L18;
    L23:
        this.x = 0;
    L25:
        return r1.b();
    L18:
        if (this.f13373b.getHeight() <= 0) goto L23;
        this.x = 2;
        b(1, r7, r2);
        e r8 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        float r0 = r2;
    L15:
        r8.c(r0 / this.f13373b.getHeight());
        goto L25
    L10:
        if (this.f13373b.getHeight() <= 0) goto L16;
        this.x = 1;
        b(0, r7, r2);
        r8 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        r0 = -r2;
        goto L15
    }

    private final void c() {
        VelocityTracker r0 = this.B;
        if (r0 != null) goto L5;
        this.B = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private final int d(int r1) {
        if (r1 < 0) goto L9;
        if (r1 <= 0) goto L8;
        return 1;
    L8:
        return 0;
    L9:
        return 0;
    }

    private final void d() {
        VelocityTracker r0 = this.B;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.B = null;
    }

    private final b e(int r8) {
        Function1<Integer, b> r0 = this.k;
        if (r0 != null) goto L14;
        DefaultConstructorMarker r1 = null;
        int r2 = 2;
        int r3 = 0;
        if (r8 == 0) goto L12;
        if (((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L12;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(this.i.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue();
        this.j.invoke(Integer.valueOf(r8));
        return new b(r8 - (((Number) ZeusTransformUtils.preCheckCast(this.i.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() - r4), r3, r2, r1);
    L12:
        return new b(r8, r3, r2, r1);
    L14:
        return (b) ZeusTransformUtils.preCheckCast(r0.invoke(Integer.valueOf(r8)), b.class, "com.obric.memorydata.plugin");
    }

    private final boolean e() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return false;
    L5:
        if (this.f13373b.getHeight() > 0) goto L8;
        return false;
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L10;
        return true;
    L10:
        Function0<Boolean> r0 = this.l;
        if (r0 != null) goto L14;
    L12:
        boolean r1 = false;
    L16:
        if (r1 == false) goto L19;
        return true;
    L19:
        if (a((e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L23;
        if (a((e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin")) == true) goto L23;
        return false;
    L23:
        return true;
    L14:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L12;
        r1 = true;
        goto L16
    }

    private final void f() {
        this.t = false;
        this.u = false;
        int r1 = g();
        int r2 = h();
        this.y = -1;
        this.z = -1;
        this.C = false;
        d r3 = d.f13362a;
        if (d.a() == false) goto L5;
        d.a(this.f13373b, "manualBounceRelease", "translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue() + " range=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() + " activeEdge=" + this.x + " velocityY=" + r1);
    L5:
        a(r2, r1);
        this.x = 0;
        d();
        this.f13373b.invalidate();
    }

    private final boolean f(int r4) {
        Function1<Integer, Boolean> r0 = this.n;
        if (r0 != null) goto L5;
        Boolean r1 = null;
    L6:
        if (r1 != null) goto L9;
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.m.invoke(Integer.valueOf(r4)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L9:
        return r1.booleanValue();
    L5:
        r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(Integer.valueOf(r4)), Boolean.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private final int g() {
        int r0 = this.y;
        VelocityTracker r1 = this.B;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != (-1)) goto L8;
        return 0;
    L8:
        r1.computeCurrentVelocity(1000, this.s);
        float r2 = r1.getYVelocity(r0);
        if (Math.abs(r2) >= this.r) goto L12;
        return 0;
    L12:
        return MathKt.roundToInt(-r2);
    }

    private final void g(int r3) {
        if (r3 != 1) goto L5;
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
    L13:
        r2.c();
        return;
    L17:
        return;
    L5:
        if (r3 != 2) goto L15;
        r2 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
        return;
    }

    private final void g(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.y) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        a(r1, r4);
        return;
    L16:
        this.y = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    private final int h() {
        int r0 = this.x;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        boolean r3 = a(r1);
        boolean r5 = a(r2);
        if (r3 == false) goto L9;
        if (r5 == true) goto L9;
    L27:
        return 1;
    L9:
        if (r5 == false) goto L13;
        if (r3 == true) goto L13;
        return 2;
    L13:
        if (r1 != null) goto L15;
        float r4 = 0.0f;
    L17:
        if (r4 > 0.0f) goto L27;
        if (r2 != null) goto L21;
        float r6 = 0.0f;
    L23:
        if (r6 < 0.0f) goto L29;
        return 0;
    L29:
        return 2;
    L21:
        r6 = r2.a();
        goto L23
    L15:
        r4 = r1.a();
        goto L17
    }

    private final void h(MotionEvent r3) {
        VelocityTracker r0 = this.B;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.A != 0) goto L9;
        r0.addMovement(r3);
        return;
    L9:
        MotionEvent r4 = MotionEvent.obtain(r3);
        r4.offsetLocation(0.0f, this.A);
        r0.addMovement(r4);
        r4.recycle();
    }

    private final boolean i(MotionEvent r8) {
        if (e() == true) goto L5;
        return false;
    L5:
        int r0 = r8.findPointerIndex(this.y);
        if (r0 >= 0) goto L8;
        return false;
    L8:
        float r1 = r8.getY(r0);
        float r2 = r1 - this.v;
        if (a(r2) == true) goto L11;
        return false;
    L11:
        h(r8);
        this.f.invoke();
        d r3 = d.f13362a;
        if (d.a() == false) goto L14;
        d.a(this.f13373b, "manualBounceStart", "dy=" + r2 + " translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue() + " scrollY=" + ((Number) ZeusTransformUtils.preCheckCast(this.i.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue() + " range=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue());
    L14:
        this.t = true;
        this.u = true;
        this.C = false;
        float r4 = this.v;
        this.w = r4;
        int r5 = b(r1 - r4);
        this.A += r5;
        this.w = r1 - r5;
        this.z = r8.getEventTime();
        ViewParent r7 = this.f13373b.getParent();
        if (r7 == null) goto L18;
        r7.requestDisallowInterceptTouchEvent(true);
    L18:
        return true;
    }

    public final void a() {
        this.t = false;
        this.u = false;
        this.x = 0;
        this.y = -1;
        this.z = -1;
        this.A = 0;
        d();
        b();
    }

    public final void a(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.C = r0;
        this.t = false;
        this.u = false;
        this.x = 0;
        this.y = r5.getPointerId(0);
        float r1 = r5.getY(0);
        this.v = r1;
        this.w = r1;
        this.z = -1;
        this.A = 0;
        c();
        h(r5);
        return;
    L5:
        if (this.C == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void b() {
        if (this.C == true) goto L5;
        return;
    L5:
        int r0 = h();
        if (r0 != 1) goto L8;
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.d.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
    L16:
        r1.onRelease();
    L17:
        this.C = false;
        this.f13373b.invalidate();
        return;
    L8:
        if (r0 != 2) goto L17;
        r1 = (e) ZeusTransformUtils.preCheckCast(this.e.invoke(), e.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L16;
        goto L16
    }

    public final boolean b(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return i(r2);
    }

    public final boolean c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.t == true) goto L6;
        return false;
    L6:
        a(r2.getActionIndex(), r2);
        return true;
    }

    public final boolean d(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.t == true) goto L6;
        return false;
    L6:
        g(r2);
        return true;
    }

    public final boolean e(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.t == false) goto L22;
        if (r5.getEventTime() != this.z) goto L7;
        return true;
    L7:
        int r0 = r5.findPointerIndex(this.y);
        if (r0 >= 0) goto L11;
        f();
        return true;
    L11:
        float r1 = r5.getY(r0);
        float r2 = r1 - this.w;
        if (this.u == true) goto L14;
    L19:
        this.w = r1;
        return true;
    L14:
        if (r2 != 0.0f) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        h(r5);
        int r6 = b(r2);
        this.A += r6;
        r1 = r1 - r6;
        goto L19
    L16:
        r3 = false;
        goto L17
    L22:
        return i(r5);
    }

    public final boolean f(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.t == false) goto L6;
        h(r2);
        f();
        return true;
    L6:
        b();
        d();
        return false;
    }
}
