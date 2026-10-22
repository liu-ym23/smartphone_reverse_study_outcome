package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.OverScroller;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020(H\u0016J\u0012\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\u0012\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u00108\u001a\u00020\u000fJ\b\u00109\u001a\u00020(H\u0014J\u0010\u0010:\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H\u0016J(\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0014J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H\u0016J\b\u0010A\u001a\u00020(H\u0002J\u0014\u0010B\u001a\u00020(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020(H\u0002J\u0012\u0010H\u001a\u00020(2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020\u000fH\u0002J\u0018\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020\u001cH\u0002J\u001e\u0010O\u001a\u0004\u0018\u00010\u00152\n\u0010P\u001a\u0006\u0012\u0002\b\u00030Q2\u0006\u0010R\u001a\u00020SH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/oui/bouncelayout/OGridView;", "Landroid/widget/GridView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceGestureDelegate", "Lcom/obric/oui/bouncelayout/AbsListBounceGestureDelegate;", "bounceStoppedForTouch", "", "bounceTop", "clickDuringOverScrollDelegate", "Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "edgeEffectsInstalled", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingRunnableField", "flingRunnableScrollerField", "lastScrollDirection", "lastScrollerVelocity", "", "lastVerticalScrollOffset", "originalBottomEffect", "", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchModeField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "allowClickDuringOverScroll", "", "allow", "computeScroll", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "getOverScrollerOrNull", "Landroid/widget/OverScroller;", "initEdgeEffectReflection", "installBounceEdgeEffects", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "releaseStoppedBounceIfNeeded", "removeCurrentFlingRunnable", "flingRunnable", "Ljava/lang/Runnable;", "resetAbsListViewTouchMode", "resolveStoppedBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "scroller", "velocity", "tryGetField", "clazz", "Ljava/lang/Class;", ActivityLifecycle.NAME, "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OGridView extends GridView implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f13347b;
    private e c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private boolean h;
    private Object i;
    private Object j;
    private Field k;
    private Field l;
    private Field m;
    private Field n;
    private final f o;
    private final g p;
    private final b q;
    private final com.obric.oui.bouncelayout.a r;
    private Field s;
    private Field t;
    private boolean u;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/bouncelayout/OGridView$Companion;", "", "()V", "STOPPED_BOUNCE_NONE", "", "TAG", "", "TOUCH_MODE_REST", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13346a = new a(null);
    }

    public OGridView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OGridView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OGridView(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13);
        this.o = new f((Function0) ZeusTransformUtils.preCheckCast(new OGridView$overscrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$overscrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.p = new g((Function0) ZeusTransformUtils.preCheckCast(new OGridView$translationDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$translationDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.q = new b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$clickDuringOverScrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$clickDuringOverScrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.r = new com.obric.oui.bouncelayout.a((AbsListView) ZeusTransformUtils.preCheckCast(this, AbsListView.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$3(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$4(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$5(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$bounceGestureDelegate$6(this), Function0.class, "com.obric.memorydata.plugin"));
        setOverScrollMode(0);
        e.f13364a.a("Landroid/widget/AbsListView;");
        e();
        f();
    }

    public /* synthetic */ OGridView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = R.attr.gridViewStyle;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ e a(OGridView r0) {
        return r0.f13347b;
    }

    private final Field a(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        Log.w("OGridView", "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.memorydata.plugin");
    }

    private final void a() {
        Field r0 = this.n;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setInt(this, -1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    static /* synthetic */ void a(OGridView r2, Runnable r3, int r4, Object r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L7;
        r6 = null;
    L7:
        r2.a(r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCurrentFlingRunnable");
    }

    private final void a(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        r5 = null;
        Field r0 = this.l;     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        Object r1 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Runnable.class) == false) goto L14;
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        goto L14
    L8:
        r1 = r0.get(this);     // Catch: Throwable -> L13
    L13:
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.memorydata.plugin");
    L14:
        if (r5 == null) goto L19;
        removeCallbacks(r5);
        return;
    }

    private final boolean a(OverScroller r9, float r10) {
        if (r10 > 0.0f) goto L5;
        return false;
    L5:
        boolean r1 = !canScrollList(-1);
        boolean r4 = !canScrollList(1);
        if (this.f >= 0) goto L25;
        if (r1 == false) goto L25;
        e r2 = this.f13347b;
        if (r2 != null) goto L12;
    L10:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L25;
        d r5 = d.f13362a;
        if (d.a() == false) goto L18;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L18:
        e r6 = this.f13347b;
        if (r6 == null) goto L23;
        int r11 = (int) r10;
    L22:
        r6.onAbsorb(r11);
    L23:
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        r9.abortAnimation();
        a(this, null, 1, null);
        this.e = 0.0f;
        this.f = 0;
        invalidate();
    L44:
        return r12;
    L12:
        if (r2.isFinished() != true) goto L10;
        r3 = true;
    L25:
        if (this.f <= 0) goto L41;
        if (r4 == false) goto L41;
        e r7 = this.c;
        if (r7 != null) goto L31;
    L29:
        boolean r8 = false;
    L33:
        if (r8 == false) goto L41;
        d r13 = d.f13362a;
        if (d.a() == false) goto L37;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L37:
        r6 = this.c;
        if (r6 == null) goto L23;
        r11 = -((int) r10);
        goto L22
    L31:
        if (r7.isFinished() != true) goto L29;
        r8 = true;
    L41:
        r12 = false;
        goto L42
    }

    public static final /* synthetic */ boolean a(OGridView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
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

    public static final /* synthetic */ e b(OGridView r0) {
        return r0.c;
    }

    private final boolean b() {
        if (this.d == true) goto L5;
        return false;
    L5:
        OverScroller r1 = getOverScrollerOrNull();
        e r3 = this.f13347b;
        if (r3 != null) goto L8;
        float r4 = 0.0f;
    L10:
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L25;
        e r6 = this.c;
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L19:
        if (r7 != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L25;
        boolean r9 = false;
    L26:
        e r10 = this.f13347b;
        if (r10 != null) goto L30;
    L28:
        boolean r11 = false;
    L32:
        if (r11 == true) goto L42;
        e r12 = this.c;
        if (r12 != null) goto L37;
    L35:
        boolean r13 = false;
    L39:
        if (r13 == true) goto L42;
        boolean r14 = false;
    L43:
        if (r9 == true) goto L48;
        if (r14 == true) goto L48;
        this.e = 0.0f;
        this.f = 0;
        this.g = computeVerticalScrollOffset();
        return false;
    L48:
        if (r1 != null) goto L51;
    L49:
        boolean r15 = false;
    L53:
        if (r15 == false) goto L57;
        if (r1 == null) goto L57;
        r1.abortAnimation();
    L57:
        Runnable r2 = null;
        Field r16 = this.l;     // Catch: Throwable -> L66
        if (r16 != null) goto L61;
        Object r17 = null;
    L63:
        if (ZeusTransformUtils.instanceOf(r17, Runnable.class) == false) goto L67;
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(r17, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
    L67:
        a(r2);
        e r0 = this.f13347b;
        if (r0 == null) goto L71;
        r0.b();
    L71:
        e r18 = this.c;
        if (r18 == null) goto L75;
        r18.b();
    L75:
        invalidate();
        this.e = 0.0f;
        this.f = 0;
        this.g = computeVerticalScrollOffset();
        return true;
    L61:
        r17 = r16.get(this);     // Catch: Throwable -> L66
    L66:
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.memorydata.plugin");
        goto L67
    L51:
        if (r1.isFinished() == true) goto L49;
        r15 = true;
        goto L53
    L37:
        if (r12.isFinished() == true) goto L35;
        r13 = true;
    L42:
        r14 = true;
        goto L43
    L30:
        if (r10.isFinished() == true) goto L28;
        r11 = true;
        goto L32
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = r6.a();
    L25:
        r9 = true;
        goto L26
    L12:
        r5 = false;
        goto L13
    L8:
        r4 = r3.a();
        goto L10
    }

    private final void c() {
        if (this.h == true) goto L5;
        return;
    L5:
        int r0 = d();
        if (r0 != 0) goto L8;
        e r1 = this.f13347b;
        if (r1 == null) goto L17;
    L16:
        r1.onRelease();
    L17:
        this.h = false;
        invalidate();
        return;
    L8:
        if (r0 != 1) goto L17;
        r1 = this.c;
        if (r1 != null) goto L16;
        goto L16
    }

    public static final /* synthetic */ boolean c(OGridView r0) {
        return r0.d;
    }

    private final int d() {
        boolean r0 = a(this.f13347b);
        boolean r1 = a(this.c);
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
    L25:
        return 0;
    L6:
        if (r1 == false) goto L9;
        if (r0 == true) goto L9;
        return 1;
    L9:
        e r2 = this.f13347b;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L25;
        e r4 = this.c;
        if (r4 != null) goto L19;
        float r5 = 0.0f;
    L21:
        if (r5 < 0.0f) goto L27;
        return -1;
    L27:
        return 1;
    L19:
        r5 = r4.a();
        goto L21
    L12:
        r3 = r2.a();
        goto L14
    }

    public static final /* synthetic */ boolean d(OGridView r0) {
        return r0.b();
    }

    private final void e() {
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        Field r3 = a(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L21
        if (r3 != null) goto L9;
        r3 = a(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L21
    L9:
        this.s = r3;     // Catch: Throwable -> L21
        Field r4 = a(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L21
        if (r4 != null) goto L12;
        r4 = a(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L21
    L12:
        this.t = r4;     // Catch: Throwable -> L21
        this.k = a(AbsListView.class, "mScroller");     // Catch: Throwable -> L21
        Field r5 = a(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L21
        this.l = r5;     // Catch: Throwable -> L21
        if (r5 != null) goto L15;
    L14:
        Field r0 = null;
    L19:
        this.m = r0;     // Catch: Throwable -> L21
        this.n = a(AbsListView.class, "mTouchMode");     // Catch: Throwable -> L21
        return;
    L15:
        Class<?> r6 = r5.getType();     // Catch: Throwable -> L21
        if (r6 == null) goto L14;
        r0 = a(r6, "mScroller");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Log.w("OGridView", "Failed to reflect edge effect fields", th);
        this.s = null;
        this.t = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    public static final /* synthetic */ void e(OGridView r0) {
        r0.a();
    }

    private final void f() {
        Field r2 = this.s;
        Field r3 = this.t;
        if (r2 == null) goto L24;
        if (r3 == null) goto L25;
    L19:
        th = move-exception;
        Log.w("OGridView", "Failed to install BounceEdgeEffects, restoring original.", th);
        g();
        return;
    L7:
        if (this.i != null) goto L10;
        this.i = r2.get(this);     // Catch: Throwable -> L19
    L10:
        if (this.j != null) goto L12;
        this.j = r3.get(this);     // Catch: Throwable -> L19
    L12:
        this.o.b();     // Catch: Throwable -> L19
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r5, "context");     // Catch: Throwable -> L19
        e r4 = new e(r5, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0, this.o.a());     // Catch: Throwable -> L19
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r6, "context");     // Catch: Throwable -> L19
        e r7 = new e(r6, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1, this.o.a());     // Catch: Throwable -> L19
        if (getWidth() > 0) goto L15;
    L17:
        r2.set(this, r4);     // Catch: Throwable -> L19
        r3.set(this, r7);     // Catch: Throwable -> L19
        this.f13347b = r4;     // Catch: Throwable -> L19
        this.c = r7;     // Catch: Throwable -> L19
        this.o.c();     // Catch: Throwable -> L19
        this.p.a();     // Catch: Throwable -> L19
        this.d = true;     // Catch: Throwable -> L19
        return;
    L15:
        if (getHeight() <= 0) goto L17;
        r4.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        r7.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        goto L17
    L25:
        return;
    }

    private final void g() {
        Field r0 = this.s;
        Field r1 = this.t;
        if (r0 != null) goto L29;
    L7:
        if (r1 == null) goto L19;
        Object r2 = this.j;     // Catch: Throwable -> L12
        if (r2 == null) goto L19;
        r1.set(this, r2);     // Catch: Throwable -> L12
    L12:
        e r3 = this.f13347b;
        if (r3 == null) goto L16;
        r3.c();
    L16:
        e r4 = this.c;
        if (r4 == null) goto L27;
    L26:
        r4.c();
    L27:
        this.f13347b = null;
        this.c = null;
        this.d = false;
        return;
    L19:
        e r5 = this.f13347b;
        if (r5 == null) goto L23;
        r5.c();
    L23:
        r4 = this.c;
        if (r4 != null) goto L26;
    L29:
        Object r6 = this.i;     // Catch: Throwable -> L12
        if (r6 == null) goto L7;
        r0.set(this, r6);     // Catch: Throwable -> L12
        goto L7
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r2 = this.k;     // Catch: Throwable -> L32
        if (r2 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L11;
        OverScroller r4 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L12:
        if (r4 == null) goto L38;
        return r4;
    L11:
        r4 = null;
        goto L12
    L6:
        r3 = r2.get(this);     // Catch: Throwable -> L32
    L38:
        Field r5 = this.l;     // Catch: Throwable -> L33
        if (r5 == null) goto L19;
        Object r6 = r5.get(this);     // Catch: Throwable -> L33
    L20:
        if (r6 != null) goto L36;
        return null;
    L36:
        Field r7 = this.m;     // Catch: Throwable -> L30
        if (r7 != null) goto L25;
        Object r8 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, OverScroller.class) == false) goto L40;
        return (OverScroller) ZeusTransformUtils.preCheckCast(r8, OverScroller.class, "com.obric.memorydata.plugin");
    L40:
        return null;
    L25:
        r8 = r7.get(r6);     // Catch: Throwable -> L30
    L31:
        return (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.memorydata.plugin");
    L19:
        r6 = null;
        goto L20
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.d == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r0 = computeVerticalScrollOffset();
        OverScroller r1 = getOverScrollerOrNull();
        if (r1 != null) goto L11;
    L22:
        float r2 = this.e;
        if (r2 <= 0.0f) goto L38;
        boolean r3 = !canScrollList(-1);
        boolean r4 = true ^ canScrollList(1);
        int r5 = this.f;
        if (r5 >= 0) goto L32;
        if (r3 == false) goto L32;
        e r6 = this.f13347b;
        if (r6 == null) goto L38;
        int r7 = (int) r2;
    L31:
        r6.onAbsorb(r7);
    L32:
        if (r5 <= 0) goto L38;
        if (r4 == false) goto L38;
        r6 = this.c;
        if (r6 == null) goto L38;
        r7 = -((int) r2);
    L38:
        this.e = 0.0f;
        this.f = 0;
        this.g = r0;
        return;
    L11:
        if (r1.isFinished() == true) goto L22;
        this.e = r1.getCurrVelocity();
        int r8 = r0 - this.g;
        if (r8 <= 0) goto L15;
        this.f = 1;
    L17:
        d r9 = d.f13362a;
        if (d.a() == false) goto L20;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingFrame", "offset=" + r0 + " delta=" + r8 + " velocity=" + this.e + " direction=" + this.f);
    L20:
        this.g = r0;
        a(r1, this.e);
        return;
    L15:
        if (r8 >= 0) goto L17;
        this.f = -1;
        goto L17
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e r0 = this.f13347b;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        e r2 = this.c;
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
        this.q.a(r6);
        b r0 = this.q;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (Function0) ZeusTransformUtils.preCheckCast(new OGridView$dispatchTouchEvent$handled$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        c();
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
        e r0 = this.f13347b;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        e r3 = this.c;
        if (r3 == null) goto L11;
        r1 = r3.a();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.a();
        goto L6
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.f13347b;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        e r1 = this.c;
        if (r1 == null) goto L11;
        r1.c();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r2 = true;
        if (r0 == 0) goto L31;
        if (r0 != 1) goto L6;
    L27:
        this.r.a();
        c();
    L29:
        return super.onInterceptTouchEvent(r5);
    L6:
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L27;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L29;
        if (this.r.d(r5) == false) goto L29;
        return true;
    L18:
        if (this.r.c(r5) == false) goto L29;
        return true;
    L21:
        if (this.q.b(r5) == false) goto L24;
        return false;
    L24:
        if (this.r.b(r5) == false) goto L29;
        this.h = false;
        return true;
    L31:
        if (b() == false) goto L33;
    L36:
        this.h = r2;
        this.r.a(r5);
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (this.q.b(r5) == false) goto L39;
        return false;
    L39:
        return r1;
    L33:
        if (this.h == true) goto L36;
        r2 = false;
        goto L36
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.o.b();
        e r5 = this.f13347b;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        e r0 = this.c;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L38;
        if (this.r.d(r5) == false) goto L38;
        return true;
    L38:
        return super.onTouchEvent(r5);
    L18:
        if (this.r.c(r5) == false) goto L38;
        return true;
    L21:
        if (this.r.f(r5) == false) goto L38;
        this.h = false;
        return true;
    L25:
        if (this.r.g(r5) == false) goto L28;
        this.h = false;
        return true;
    L28:
        c();
        goto L38
    L30:
        if (b() == false) goto L32;
    L33:
        r1 = true;
    L34:
        this.h = r1;
        if (this.r.e(r5) == false) goto L38;
        return true;
    L32:
        if (this.h == false) goto L34;
        goto L33
    }

    public void setOnBounceTranslationListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.p.a(r4);
    }
}
