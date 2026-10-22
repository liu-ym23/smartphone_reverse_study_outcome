package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0002J\b\u00100\u001a\u00020\bH\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\u0006\u00105\u001a\u00020\u0012J\b\u00106\u001a\u00020$H\u0014J\u0010\u00107\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016J(\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0014J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016JP\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0012H\u0014J\b\u0010H\u001a\u00020$H\u0002J\u0012\u0010I\u001a\u00020$2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020\u0012H\u0002J0\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u001aH\u0002J\u001e\u0010S\u001a\u0004\u0018\u00010\u00142\n\u0010T\u001a\u0006\u0012\u0002\b\u00030U2\u0006\u0010V\u001a\u00020WH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceGestureDelegate", "Lcom/obric/oui/bouncelayout/ScrollBounceGestureDelegate;", "bounceTop", "clickDuringOverScrollDelegate", "Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingBounceAbsorbed", "lastScrollerScrollY", "lastScrollerVelocity", "", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "allowClickDuringOverScroll", "allow", "computeScroll", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "getCurrentFlingVelocity", "getScrollRangeY", "getScrollerOrNull", "Landroid/widget/OverScroller;", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "scroller", "y", "previousY", "rangeY", "velocity", "tryGetField", "clazz", "Ljava/lang/Class;", ActivityLifecycle.NAME, "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OScrollView extends ScrollView implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13355b;
    private Field c;
    private Field d;
    private e e;
    private e f;
    private EdgeEffect g;
    private EdgeEffect h;
    private boolean i;
    private Field j;
    private float k;
    private int l;
    private boolean m;
    private final f n;
    private final g o;
    private final b p;
    private final j q;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13354a = new a(null);
    }

    public OScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OScrollView(Context r25, AttributeSet r26, int r27) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r26, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r3, r27);
        this.n = new f((Function0) ZeusTransformUtils.preCheckCast(new OScrollView$overscrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$overscrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.o = new g((Function0) ZeusTransformUtils.preCheckCast(new OScrollView$translationDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$translationDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.p = new b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$clickDuringOverScrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$clickDuringOverScrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.q = new j((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$3(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$4(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$5(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$6(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$7(this), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$8(this), Function1.class, "com.obric.memorydata.plugin"), null, null, (Function1) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$9(this), Function1.class, "com.obric.memorydata.plugin"), null, (Function1) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$10(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$bounceGestureDelegate$11(this), Function0.class, "com.obric.memorydata.plugin"), 5632, null);
        setOverScrollMode(0);
        e.f13364a.a("Landroid/widget/ScrollView;");
        b();
        c();
    }

    public /* synthetic */ OScrollView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ e a(OScrollView r0) {
        return r0.e;
    }

    private final Field a(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        Log.w("OScrollView", "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(OScrollView r0, float r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(OScrollView r0, int r1) {
        r0.l = r1;
    }

    public static final /* synthetic */ void a(OScrollView r0, boolean r1) {
        r0.m = r1;
    }

    private final boolean a() {
        if (this.i == true) goto L5;
        return false;
    L5:
        e r0 = this.e;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        e r3 = this.f;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        e r7 = this.e;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        e r9 = this.f;
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
        d();
        e r12 = this.e;
        if (r12 == null) goto L51;
        r12.b();
    L51:
        e r13 = this.f;
        if (r13 == null) goto L55;
        r13.b();
    L55:
        invalidate();
        this.k = 0.0f;
        this.l = getScrollY();
        this.m = false;
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

    private final boolean a(OverScroller r7, int r8, int r9, int r10, float r11) {
        boolean r1 = false;
        if (this.m == false) goto L5;
    L44:
        return r1;
    L5:
        if (r11 <= 0.0f) goto L44;
        if (r8 != 0) goto L26;
        if (r9 <= 0) goto L26;
        e r5 = this.e;
        if (r5 != null) goto L14;
    L12:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L26;
        d r12 = d.f13362a;
        if (d.a() == false) goto L20;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r11)));
    L20:
        e r13 = this.e;
        if (r13 == null) goto L25;
        int r14 = (int) r11;
    L24:
        r13.onAbsorb(r14);
    L25:
        r1 = true;
    L42:
        if (r1 == false) goto L44;
        this.m = true;
        r7.abortAnimation();
        this.k = 0.0f;
        invalidate();
        goto L44
    L14:
        if (r5.isFinished() != true) goto L12;
        r6 = true;
    L26:
        if (r8 != r10) goto L42;
        if (r9 >= r10) goto L42;
        e r15 = this.f;
        if (r15 != null) goto L32;
    L30:
        boolean r16 = false;
    L34:
        if (r16 == false) goto L42;
        d r17 = d.f13362a;
        if (d.a() == false) goto L38;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r11)));
    L38:
        r13 = this.f;
        if (r13 == null) goto L25;
        r14 = -((int) r11);
        goto L24
    L32:
        if (r15.isFinished() != true) goto L30;
        r16 = true;
        goto L34
    }

    public static final /* synthetic */ boolean a(OScrollView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static final /* synthetic */ e b(OScrollView r0) {
        return r0.f;
    }

    private final void b() {
        if (this.f13355b == false) goto L5;
        return;
    L5:
        this.f13355b = true;
        Field r1 = a(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = a(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.c = r1;     // Catch: Throwable -> L14
        Field r2 = a(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = a(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.d = r2;     // Catch: Throwable -> L14
        this.j = a(ScrollView.class, "mScroller");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.w("OScrollView", "Failed to reflect edge effect fields", th);
        this.c = null;
        this.d = null;
        this.j = null;
    }

    private final void c() {
        if (this.e == null) goto L5;
        return;
    L5:
        if (this.f != null) goto L36;
        this.n.b();
        Field r1 = this.c;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.d;
        if (r2 != null) goto L33;
        return;
    L33:
        Object r5 = r1.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r5, EdgeEffect.class) == false) goto L18;
        EdgeEffect r6 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r5, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L19:
        this.g = r6;     // Catch: Throwable -> L30
        Object r7 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r7, EdgeEffect.class) == false) goto L22;
        EdgeEffect r8 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r7, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L23:
        this.h = r8;     // Catch: Throwable -> L30
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r9, "context");     // Catch: Throwable -> L30
        e r10 = new e(r9, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0, this.n.a());     // Catch: Throwable -> L30
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r11, "context");     // Catch: Throwable -> L30
        e r12 = new e(r11, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1, this.n.a());     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r1.set(this, r10);     // Catch: Throwable -> L30
        r2.set(this, r12);     // Catch: Throwable -> L30
        this.e = r10;     // Catch: Throwable -> L30
        this.f = r12;     // Catch: Throwable -> L30
        this.i = true;     // Catch: Throwable -> L30
        this.n.c();     // Catch: Throwable -> L30
        this.o.a();     // Catch: Throwable -> L30
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
        Log.w("OScrollView", "Failed to install BounceEdgeEffects, restoring original.", th);
        e();
        this.e = null;
        this.f = null;
        this.i = false;
        return;
    }

    public static final /* synthetic */ boolean c(OScrollView r0) {
        return r0.i;
    }

    private final void d() {
        OverScroller r0 = getScrollerOrNull();     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.abortAnimation();     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    public static final /* synthetic */ boolean d(OScrollView r0) {
        return r0.a();
    }

    public static final /* synthetic */ int e(OScrollView r0) {
        return r0.getScrollRangeY();
    }

    private final void e() {
        Field r0 = this.c;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.g);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.d;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.h);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w("OScrollView", "Failed to restore original edge effects", th);
    }

    private final float getCurrentFlingVelocity() {
        OverScroller r3 = getScrollerOrNull();     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return 1000.0f;
    L6:
        return r3.getCurrVelocity();
    L8:
        th = move-exception;
        Log.w("OScrollView", "Failed to get scroller velocity", th);
        return 1000.0f;
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
        Field r2 = this.j;     // Catch: Throwable -> L11
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

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.i == true) goto L5;
        return;
    L5:
        OverScroller r2 = getScrollerOrNull();
        if (r2 != null) goto L8;
        return;
    L8:
        int r5 = getScrollRangeY();
        if (r5 > 0) goto L11;
        return;
    L11:
        int r0 = getScrollY();
        if (r2.isFinished() == true) goto L21;
        int r4 = this.l;
        this.k = r2.getCurrVelocity();
        d r1 = d.f13362a;
        if (d.a() == false) goto L17;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingFrame", "y=" + r0 + " previousY=" + r4 + " range=" + r5 + " velocity=" + this.k);
    L17:
        if (a(r2, r0, r4, r5, this.k) == false) goto L19;
        return;
    L19:
        this.l = r0;
        return;
    L21:
        float r3 = this.k;
        if (r3 <= 0.0f) goto L58;
        boolean r7 = true;
        if (r0 == 0) goto L26;
    L42:
        if (r0 != r5) goto L58;
        if (this.l >= r5) goto L58;
        e r6 = this.f;
        if (r6 != null) goto L49;
    L47:
        r7 = false;
    L50:
        if (r7 == false) goto L58;
        d r8 = d.f13362a;
        if (d.a() == false) goto L54;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottomFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r3)));
    L54:
        e r9 = this.f;
        if (r9 == null) goto L58;
        int r10 = -((int) r3);
    L41:
        r9.onAbsorb(r10);
        goto L58
    L49:
        if (r6.isFinished() != true) goto L47;
    L26:
        if (this.l <= 0) goto L42;
        e r11 = this.e;
        if (r11 != null) goto L31;
    L29:
        boolean r12 = false;
    L33:
        if (r12 == false) goto L42;
        d r13 = d.f13362a;
        if (d.a() == false) goto L37;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTopFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r3)));
    L37:
        r9 = this.e;
        if (r9 == null) goto L58;
        r10 = (int) r3;
        goto L41
    L31:
        if (r11.isFinished() != true) goto L29;
        r12 = true;
    L58:
        this.k = 0.0f;
        this.l = r0;
        this.m = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e r0 = this.e;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        e r2 = this.f;
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
        Intrinsics.checkNotNullParameter(r6, "ev");
        this.p.a(r6);
        b r0 = this.p;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (Function0) ZeusTransformUtils.preCheckCast(new OScrollView$dispatchTouchEvent$handled$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        this.q.b();
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
        e r0 = this.e;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        e r3 = this.f;
        if (r3 == null) goto L11;
        r1 = r3.a();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.a();
        goto L6
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.e;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        e r1 = this.f;
        if (r1 == null) goto L10;
        r1.c();
    L10:
        e();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.q.a(r5);
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (this.p.b(r5) == false) goto L36;
        return false;
    L36:
        return r1;
    L5:
        if (r0 != 1) goto L7;
    L27:
        this.q.a();
    L29:
        if (this.p.b(r5) == false) goto L32;
        return false;
    L32:
        return super.onInterceptTouchEvent(r5);
    L7:
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L27;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L29;
        if (this.q.d(r5) == false) goto L29;
        return true;
    L19:
        if (this.q.c(r5) == false) goto L29;
        return true;
    L22:
        if (this.p.b(r5) == false) goto L25;
        return false;
    L25:
        if (this.q.b(r5) == false) goto L29;
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.n.b();
        e r5 = this.e;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        e r0 = this.f;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        this.q.a(r4);
    L29:
        return super.onTouchEvent(r4);
    L5:
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L29;
        if (this.q.d(r4) == false) goto L29;
        return true;
    L19:
        if (this.q.c(r4) == false) goto L29;
        return true;
    L22:
        if (this.q.e(r4) == false) goto L29;
        return true;
    L25:
        if (this.q.f(r4) == false) goto L29;
        return true;
    }

    @Override // android.view.View
    public boolean overScrollBy(int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, boolean r15) {
        boolean r16 = super.overScrollBy(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        if (r15 == false) goto L5;
    L57:
        return r16;
    L5:
        if (this.i == false) goto L57;
        if (r12 <= 0) goto L57;
        int r17 = r10 + r8;
        d r18 = d.f13362a;
        if (d.a() == false) goto L10;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "overScrollFlingFrame", "scrollY=" + r10 + " deltaY=" + r8 + " finalScrollY=" + r17 + " range=" + r12);
    L10:
        boolean r19 = false;
        if (r17 > 0) goto L34;
        if (r8 >= 0) goto L34;
        e r1 = this.e;
        if (r1 != null) goto L17;
    L15:
        boolean r2 = false;
    L19:
        if (r2 == false) goto L34;
        float r3 = getCurrentFlingVelocity();
        int r4 = Math.abs(r17);
        if (getHeight() <= 0) goto L26;
        e r5 = this.e;
        if (r5 == null) goto L26;
        r5.onPull(r4 / getHeight(), 0.5f);
    L26:
        d r6 = d.f13362a;
        if (d.a() == false) goto L29;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTop", "velocity=" + r3 + " overscroll=" + r4);
    L29:
        e r20 = this.e;
        if (r20 == null) goto L33;
        r20.onAbsorb((int) r3);
    L33:
        d();
        goto L34
    L17:
        if (r1.isFinished() != true) goto L15;
        r2 = true;
    L34:
        if (r17 < r12) goto L57;
        if (r8 <= 0) goto L57;
        e r21 = this.f;
        if (r21 != null) goto L40;
    L42:
        if (r19 == false) goto L57;
        float r22 = getCurrentFlingVelocity();
        int r23 = r17 - r12;
        if (getHeight() <= 0) goto L49;
        e r110 = this.f;
        if (r110 == null) goto L49;
        r110.onPull(r23 / getHeight(), 0.5f);
    L49:
        d r111 = d.f13362a;
        if (d.a() == false) goto L52;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottom", "velocity=" + r22 + " overscroll=" + r23);
    L52:
        e r24 = this.f;
        if (r24 == null) goto L56;
        r24.onAbsorb(-((int) r22));
    L56:
        d();
        goto L57
    L40:
        if (r21.isFinished() != true) goto L42;
        r19 = true;
        goto L42
    }

    public void setOnBounceTranslationListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.o.a(r4);
    }
}
