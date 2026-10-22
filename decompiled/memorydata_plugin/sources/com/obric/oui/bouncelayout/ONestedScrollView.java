package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0015H\u0016J\b\u0010,\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\bH\u0002J\u0012\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0010\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\bH\u0002J\n\u00108\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010:\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0002J\b\u0010;\u001a\u00020)H\u0002J\b\u0010<\u001a\u00020)H\u0002J\u0006\u0010=\u001a\u00020\u0015J\b\u0010>\u001a\u00020)H\u0014J\u0010\u0010?\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0016J(\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0014J\u0010\u0010E\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0016J\b\u0010F\u001a\u00020)H\u0002J\u0012\u0010G\u001a\u00020)2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020\u0015H\u0002J(\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0012H\u0002J\u001e\u0010P\u001a\u0004\u0018\u00010\u00172\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030R2\u0006\u0010S\u001a\u00020TH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceGestureDelegate", "Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate;", "bounceTop", "clickDuringOverScrollDelegate", "Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "downX", "", "downY", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingBounceAbsorbed", "isHorizontalGesture", "Ljava/lang/Boolean;", "lastScrollerScrollY", "lastScrollerVelocity", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchSlop", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "allowClickDuringOverScroll", "allow", "computeScroll", "consumeManualScrollDeltaY", "Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate$ContentScrollResult;", "scrollDeltaY", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getBounceTranslation", "getScrollRangeY", "getScrollerOrNull", "Landroid/widget/OverScroller;", "handleDispatchTouchEvent", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "y", "previousY", "rangeY", "velocity", "tryGetField", "clazz", "Ljava/lang/Class;", ActivityLifecycle.NAME, "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ONestedScrollView extends NestedScrollView implements h {
    public static final a Companion = null;
    public static final String TAG = "ONestedScrollView";
    private e bounceBottom;
    private final j bounceGestureDelegate;
    private e bounceTop;
    private final b clickDuringOverScrollDelegate;
    private float downX;
    private float downY;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private boolean flingBounceAbsorbed;
    private Boolean isHorizontalGesture;
    private int lastScrollerScrollY;
    private float lastScrollerVelocity;
    private EdgeEffect originalBottomEffect;
    private EdgeEffect originalTopEffect;
    private final f overscrollDelegate;
    private Field scrollerField;
    private final int touchSlop;
    private final g translationDelegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ONestedScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ONestedScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ONestedScrollView(Context r23, AttributeSet r24, int r25) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r24, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r3, r25);
        this.touchSlop = ViewConfiguration.get(r1).getScaledTouchSlop();
        this.overscrollDelegate = new f((Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$overscrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$overscrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.translationDelegate = new g((Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$translationDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$translationDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.clickDuringOverScrollDelegate = new b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$clickDuringOverScrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$clickDuringOverScrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.bounceGestureDelegate = new j((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$3(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$4(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$5(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$6(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$7(this), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$8(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$9(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$10(this), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$11(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$12(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$13(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$bounceGestureDelegate$14(this), Function0.class, "com.obric.memorydata.plugin"));
        setOverScrollMode(0);
        e.f13364a.a("Landroidx/core/widget/NestedScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }

    public /* synthetic */ ONestedScrollView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void abortCurrentFling() {
        OverScroller r0 = getScrollerOrNull();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.abortAnimation();     // Catch: Throwable -> L8
    L6:
        stopNestedScroll(1);     // Catch: Throwable -> L8
        return;
    }

    public static final /* synthetic */ j.b access$consumeManualScrollDeltaY(ONestedScrollView r0, int r1) {
        return r0.consumeManualScrollDeltaY(r1);
    }

    public static final /* synthetic */ e access$getBounceBottom$p(ONestedScrollView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ e access$getBounceTop$p(ONestedScrollView r0) {
        return r0.bounceTop;
    }

    public static final /* synthetic */ boolean access$getEdgeEffectsInstalled$p(ONestedScrollView r0) {
        return r0.edgeEffectsInstalled;
    }

    public static final /* synthetic */ int access$getScrollRangeY(ONestedScrollView r0) {
        return r0.getScrollRangeY();
    }

    public static final /* synthetic */ boolean access$handleDispatchTouchEvent(ONestedScrollView r0, MotionEvent r1) {
        return r0.handleDispatchTouchEvent(r1);
    }

    public static final /* synthetic */ void access$setFlingBounceAbsorbed$p(ONestedScrollView r0, boolean r1) {
        r0.flingBounceAbsorbed = r1;
    }

    public static final /* synthetic */ void access$setLastScrollerScrollY$p(ONestedScrollView r0, int r1) {
        r0.lastScrollerScrollY = r1;
    }

    public static final /* synthetic */ void access$setLastScrollerVelocity$p(ONestedScrollView r0, float r1) {
        r0.lastScrollerVelocity = r1;
    }

    public static final /* synthetic */ boolean access$stopBounceIfNeeded(ONestedScrollView r0) {
        return r0.stopBounceIfNeeded();
    }

    private final j.b consumeManualScrollDeltaY(int r18) {
        if (r18 == 0) goto L5;
        startNestedScroll(2, 0);
        int[] r10 = new int[2];
        int[] r11 = new int[2];
        dispatchNestedPreScroll(0, r18, r10, r11, 0);
        int r0 = r18 - r10[1];
        int r1 = getScrollY();
        if (r0 == 0) goto L9;
        scrollBy(0, r0);
    L9:
        int r13 = getScrollY() - r1;
        int r14 = r0 - r13;
        int[] r15 = new int[2];
        int[] r7 = new int[2];
        dispatchNestedScroll(0, r13, 0, r14, r15, 0, r7);
        int r16 = r14 - r7[1];
        d r2 = d.f13362a;
        if (d.a() == false) goto L13;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "manualNestedScroll", "scrollDeltaY=" + r18 + " parentConsumedY=" + r10[1] + " selfConsumedY=" + r13 + " parentPostConsumedY=" + r7[1] + " unconsumedY=" + r16 + " offsetInWindowY=" + (r11[1] + r15[1]));
    L13:
        return new j.b(r16, r11[1] + r15[1]);
    L5:
        return new j.b(0, 0, 2, null);
    }

    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
    }

    private final OverScroller getScrollerOrNull() {
        Field r2 = this.scrollerField;     // Catch: Throwable -> L11
        if (r2 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L15;
        return (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    L6:
        r3 = r2.get(this);     // Catch: Throwable -> L11
    L12:
        return (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.memorydata.plugin");
    }

    private final boolean handleDispatchTouchEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L20;
        boolean r2 = true;
        if (r0 != 1) goto L7;
    L21:
        this.isHorizontalGesture = null;
    L23:
        return super.dispatchTouchEvent(r6);
    L7:
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L21;
    L12:
        if (this.isHorizontalGesture != null) goto L23;
        float r1 = Math.abs(r6.getX() - this.downX);
        float r3 = Math.abs(r6.getY() - this.downY);
        if (Math.max(r1, r3) <= this.touchSlop) goto L23;
        if (r1 > r3) goto L19;
        r2 = false;
    L19:
        this.isHorizontalGesture = Boolean.valueOf(r2);
        goto L23
    L20:
        this.downX = r6.getX();
        this.downY = r6.getY();
        goto L21
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r1 = tryGetField(NestedScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = tryGetField(NestedScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.edgeFieldTop = r1;     // Catch: Throwable -> L14
        Field r2 = tryGetField(NestedScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = tryGetField(NestedScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.edgeFieldBottom = r2;     // Catch: Throwable -> L14
        this.scrollerField = tryGetField(NestedScrollView.class, "mScroller");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L36;
        Field r1 = this.edgeFieldTop;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldBottom;
        if (r2 != null) goto L33;
        return;
    L33:
        Object r5 = r1.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r5, EdgeEffect.class) == false) goto L18;
        EdgeEffect r6 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r5, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L19:
        Object r7 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r7, EdgeEffect.class) == false) goto L22;
        EdgeEffect r8 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r7, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L23:
        this.originalTopEffect = r6;     // Catch: Throwable -> L30
        this.originalBottomEffect = r8;     // Catch: Throwable -> L30
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r9, "context");     // Catch: Throwable -> L30
        e r10 = new e(r9, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r11, "context");     // Catch: Throwable -> L30
        e r12 = new e(r11, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r1.set(this, r10);     // Catch: Throwable -> L30
        r2.set(this, r12);     // Catch: Throwable -> L30
        this.bounceTop = r10;     // Catch: Throwable -> L30
        this.bounceBottom = r12;     // Catch: Throwable -> L30
        this.overscrollDelegate.c();     // Catch: Throwable -> L30
        this.translationDelegate.a();     // Catch: Throwable -> L30
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r10.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r12.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L22:
        r8 = null;
        goto L23
    L18:
        r6 = null;
    L30:
        th = move-exception;
        Log.w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldTop;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.originalTopEffect);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.edgeFieldBottom;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.originalBottomEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w(TAG, "Failed to restore original edge effects", th);
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        e r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        e r3 = this.bounceBottom;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        e r7 = this.bounceTop;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        e r9 = this.bounceBottom;
        if (r9 != null) goto L37;
    L35:
        boolean r10 = false;
    L39:
        if (r10 == true) goto L42;
        boolean r11 = false;
    L43:
        if (r6 == true) goto L47;
        if (r11 == true) goto L47;
        return false;
    L47:
        abortCurrentFling();
        e r12 = this.bounceTop;
        if (r12 == null) goto L51;
        r12.b();
    L51:
        e r13 = this.bounceBottom;
        if (r13 == null) goto L55;
        r13.b();
    L55:
        invalidate();
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollerScrollY = getScrollY();
        this.flingBounceAbsorbed = false;
        return true;
    L37:
        if (r9.isFinished() == true) goto L35;
        r10 = true;
    L42:
        r11 = true;
        goto L43
    L30:
        if (r7.isFinished() == true) goto L28;
        r8 = true;
        goto L32
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = r3.a();
    L25:
        r6 = true;
        goto L26
    L12:
        r2 = false;
        goto L13
    L8:
        r1 = r0.a();
        goto L10
    }

    private final boolean tryAbsorbRunningFlingAtEdge(int r7, int r8, int r9, float r10) {
        boolean r1 = false;
        if (this.flingBounceAbsorbed == false) goto L5;
    L44:
        return r1;
    L5:
        if (r10 <= 0.0f) goto L44;
        if (r7 != 0) goto L26;
        if (r8 <= 0) goto L26;
        e r5 = this.bounceTop;
        if (r5 != null) goto L14;
    L12:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L26;
        d r11 = d.f13362a;
        if (d.a() == false) goto L20;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L20:
        e r12 = this.bounceTop;
        if (r12 == null) goto L25;
        int r13 = (int) r10;
    L24:
        r12.onAbsorb(r13);
    L25:
        r1 = true;
    L42:
        if (r1 == false) goto L44;
        this.flingBounceAbsorbed = true;
        abortCurrentFling();
        this.lastScrollerVelocity = 0.0f;
        invalidate();
        goto L44
    L14:
        if (r5.isFinished() != true) goto L12;
        r6 = true;
    L26:
        if (r7 != r9) goto L42;
        if (r8 >= r9) goto L42;
        e r14 = this.bounceBottom;
        if (r14 != null) goto L32;
    L30:
        boolean r15 = false;
    L34:
        if (r15 == false) goto L42;
        d r16 = d.f13362a;
        if (d.a() == false) goto L38;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L38:
        r12 = this.bounceBottom;
        if (r12 == null) goto L25;
        r13 = -((int) r10);
        goto L24
    L32:
        if (r14.isFinished() != true) goto L30;
        r15 = true;
        goto L34
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.memorydata.plugin");
    }

    public void allowClickDuringOverScroll(boolean r1) {
        this.clickDuringOverScrollDelegate.a(r1);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        boolean r0 = true;
        boolean r1 = hasNestedScrollingParent(1);
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r2 = getScrollerOrNull();
        if (r2 != null) goto L8;
        return;
    L8:
        int r3 = getScrollRangeY();
        if (r3 > 0) goto L11;
        return;
    L11:
        int r4 = getScrollY();
        if (r2.isFinished() == true) goto L22;
        int r5 = this.lastScrollerScrollY;
        this.lastScrollerVelocity = r2.getCurrVelocity();
        d r6 = d.f13362a;
        if (d.a() == false) goto L16;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingFrame", "y=" + r4 + " previousY=" + r5 + " range=" + r3 + " velocity=" + this.lastScrollerVelocity);
    L16:
        if (r1 == false) goto L18;
    L20:
        this.lastScrollerScrollY = r4;
        return;
    L18:
        if (tryAbsorbRunningFlingAtEdge(r4, r5, r3, this.lastScrollerVelocity) == false) goto L20;
        return;
    L22:
        float r7 = this.lastScrollerVelocity;
        if (r7 <= 0.0f) goto L60;
        if (r1 == true) goto L60;
        if (r4 == 0) goto L28;
    L44:
        if (r4 != r3) goto L60;
        if (this.lastScrollerScrollY >= r3) goto L60;
        e r8 = this.bounceBottom;
        if (r8 != null) goto L51;
    L49:
        r0 = false;
    L52:
        if (r0 == false) goto L60;
        d r9 = d.f13362a;
        if (d.a() == false) goto L56;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottomFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r7)));
    L56:
        e r10 = this.bounceBottom;
        if (r10 == null) goto L60;
        int r11 = -((int) r7);
    L43:
        r10.onAbsorb(r11);
        goto L60
    L51:
        if (r8.isFinished() != true) goto L49;
    L28:
        if (this.lastScrollerScrollY <= 0) goto L44;
        e r12 = this.bounceTop;
        if (r12 != null) goto L33;
    L31:
        boolean r13 = false;
    L35:
        if (r13 == false) goto L44;
        d r14 = d.f13362a;
        if (d.a() == false) goto L39;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTopFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r7)));
    L39:
        r10 = this.bounceTop;
        if (r10 == null) goto L60;
        r11 = (int) r7;
        goto L43
    L33:
        if (r12.isFinished() != true) goto L31;
        r13 = true;
    L60:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollerScrollY = r4;
        this.flingBounceAbsorbed = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e r0 = this.bounceTop;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        e r2 = this.bounceBottom;
        if (r2 != null) goto L11;
        float r3 = 0.0f;
    L12:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L18:
        super.dispatchDraw(r4);
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = r2.a();
        goto L12
    L7:
        r1 = r0.a();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        this.clickDuringOverScrollDelegate.a(r6);
        b r0 = this.clickDuringOverScrollDelegate;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (Function0) ZeusTransformUtils.preCheckCast(new ONestedScrollView$dispatchTouchEvent$handled$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = handleDispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        this.bounceGestureDelegate.b();
    L11:
        return r2;
    L9:
        if (r6.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    @Override // com.obric.oui.bouncelayout.h
    public float getBounceTranslation() {
        e r0 = this.bounceTop;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        e r3 = this.bounceBottom;
        if (r3 == null) goto L11;
        r1 = r3.a();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.a();
        goto L6
    }

    public final boolean isOverScrolling() {
        e r0 = this.bounceTop;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        e r2 = this.bounceTop;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        e r4 = this.bounceBottom;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        e r6 = this.bounceBottom;
        Intrinsics.checkNotNull(r6);
        if (r6.isFinished() == true) goto L23;
    L22:
        boolean r7 = true;
    L24:
        if (r3 == true) goto L29;
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L18:
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L7:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        e r1 = this.bounceBottom;
        if (r1 == null) goto L10;
        r1.c();
    L10:
        restoreOriginalEdgeEffects();
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.bounceGestureDelegate.a(r5);
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (this.clickDuringOverScrollDelegate.b(r5) == false) goto L41;
        return false;
    L41:
        return r1;
    L5:
        if (r0 != 1) goto L7;
    L30:
        this.bounceGestureDelegate.a();
    L32:
        if (this.clickDuringOverScrollDelegate.b(r5) == false) goto L34;
        return false;
    L34:
        boolean r6 = super.onInterceptTouchEvent(r5);
        if (r6 == false) goto L37;
        this.isHorizontalGesture = false;
    L37:
        return r6;
    L7:
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L30;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L32;
        if (this.bounceGestureDelegate.d(r5) == false) goto L32;
        return true;
    L19:
        if (this.bounceGestureDelegate.c(r5) == false) goto L32;
        return true;
    L22:
        if (Intrinsics.areEqual(this.isHorizontalGesture, true) == false) goto L25;
        return false;
    L25:
        if (this.clickDuringOverScrollDelegate.b(r5) == false) goto L28;
        return false;
    L28:
        if (this.bounceGestureDelegate.b(r5) == false) goto L32;
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.b();
        e r5 = this.bounceTop;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        e r0 = this.bounceBottom;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        this.bounceGestureDelegate.a(r4);
    L30:
        return super.onTouchEvent(r4);
    L5:
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L30;
        if (this.bounceGestureDelegate.d(r4) == false) goto L30;
        return true;
    L19:
        if (this.bounceGestureDelegate.c(r4) == false) goto L30;
        return true;
    L22:
        if (this.bounceGestureDelegate.e(r4) == false) goto L30;
        return true;
    L25:
        if (this.bounceGestureDelegate.f(r4) == false) goto L30;
        stopNestedScroll(0);
        return true;
    }

    public void setOnBounceTranslationListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.translationDelegate.a(r4);
    }
}
