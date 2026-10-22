package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
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
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0012\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010/\u001a\u00020\u000eJ\b\u00100\u001a\u00020\u001fH\u0014J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J(\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0014J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016JP\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u000eH\u0014J\b\u0010B\u001a\u00020\u001fH\u0002J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\u0012\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020\u000eH\u0002J\u001e\u0010I\u001a\u0004\u0018\u00010\u00132\n\u0010J\u001a\u0006\u0012\u0002\b\u00030K2\u0006\u0010L\u001a\u00020MH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceLeft", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceRight", "bounceStoppedForTouch", "", "clickDuringOverScrollDelegate", "Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "edgeEffectsInstalled", "edgeFieldLeft", "Ljava/lang/reflect/Field;", "edgeFieldRight", "edgeFieldsResolved", "originalLeftEffect", "Landroid/widget/EdgeEffect;", "originalRightEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "allowClickDuringOverScroll", "allow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "", "getCurrentFlingVelocity", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "releaseStoppedBounceIfNeeded", "resolveStoppedBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryGetField", "clazz", "Ljava/lang/Class;", ActivityLifecycle.NAME, "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OHorizontalScrollView extends HorizontalScrollView implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13349b;
    private Field c;
    private Field d;
    private e e;
    private e f;
    private EdgeEffect g;
    private EdgeEffect h;
    private boolean i;
    private Field j;
    private boolean k;
    private final f l;
    private final g m;
    private final b n;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView$Companion;", "", "()V", "BOUNCE_EDGE_NONE", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13348a = new a(null);
    }

    public OHorizontalScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OHorizontalScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OHorizontalScrollView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r6);
        this.l = new f((Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$overscrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$overscrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.m = new g((Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$translationDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$translationDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.n = new b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$clickDuringOverScrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$clickDuringOverScrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        setOverScrollMode(0);
        e.f13364a.a("Landroid/widget/HorizontalScrollView;");
        d();
        f();
    }

    public /* synthetic */ OHorizontalScrollView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ e a(OHorizontalScrollView r0) {
        return r0.e;
    }

    private final Field a(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L5:
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.memorydata.plugin");
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
        Field r12 = this.j;
        OverScroller r13 = null;
        if (r12 != null) goto L50;
        Object r14 = null;
    L52:
        if (ZeusTransformUtils.instanceOf(r14, OverScroller.class) == false) goto L54;
        r13 = (OverScroller) ZeusTransformUtils.preCheckCast(r14, OverScroller.class, "com.obric.memorydata.plugin");
    L54:
        if (r13 == null) goto L57;
        r13.abortAnimation();
    L57:
        e r15 = this.e;
        if (r15 == null) goto L61;
        r15.b();
    L61:
        e r16 = this.f;
        if (r16 == null) goto L65;
        r16.b();
    L65:
        invalidate();
        return true;
    L50:
        r14 = r12.get(this);
        goto L52
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

    public static final /* synthetic */ boolean a(OHorizontalScrollView r0, MotionEvent r1) {
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

    public static final /* synthetic */ e b(OHorizontalScrollView r0) {
        return r0.f;
    }

    private final void b() {
        if (this.k == true) goto L5;
        return;
    L5:
        int r0 = c();
        if (r0 != 2) goto L8;
        e r1 = this.e;
        if (r1 == null) goto L17;
    L16:
        r1.onRelease();
    L17:
        this.k = false;
        invalidate();
        return;
    L8:
        if (r0 != 3) goto L17;
        r1 = this.f;
        if (r1 != null) goto L16;
        goto L16
    }

    private final int c() {
        boolean r0 = a(this.e);
        boolean r1 = a(this.f);
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
    L25:
        return 2;
    L6:
        if (r1 == false) goto L9;
        if (r0 == true) goto L9;
        return 3;
    L9:
        e r2 = this.e;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L25;
        e r4 = this.f;
        if (r4 != null) goto L19;
        float r5 = 0.0f;
    L21:
        if (r5 < 0.0f) goto L27;
        return -1;
    L27:
        return 3;
    L19:
        r5 = r4.a();
        goto L21
    L12:
        r3 = r2.a();
        goto L14
    }

    private final void d() {
        if (this.f13349b == false) goto L5;
        return;
    L5:
        this.f13349b = true;
        Field r1 = a(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = a(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = a(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L18
    L11:
        this.c = r1;     // Catch: Throwable -> L18
        Field r2 = a(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = a(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = a(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L18
    L16:
        this.d = r2;     // Catch: Throwable -> L18
        this.j = a(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to reflect fields", th);
        this.c = null;
        this.d = null;
        this.j = null;
    }

    private final void e() {
        Field r0 = this.j;     // Catch: Throwable -> L13
        OverScroller r1 = null;
        if (r0 != null) goto L5;
        Object r2 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, OverScroller.class) == false) goto L9;
        r1 = (OverScroller) ZeusTransformUtils.preCheckCast(r2, OverScroller.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L9:
        if (r1 == null) goto L16;
        r1.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r2 = r0.get(this);     // Catch: Throwable -> L13
    }

    private final void f() {
        if (this.e == null) goto L5;
        return;
    L5:
        if (this.f != null) goto L36;
        this.l.b();
        Field r1 = this.c;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.d;
        if (r2 != null) goto L33;
        return;
    L33:
        Object r4 = r1.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r4, EdgeEffect.class) == false) goto L18;
        EdgeEffect r5 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r4, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L19:
        this.g = r5;     // Catch: Throwable -> L30
        Object r6 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r6, EdgeEffect.class) == false) goto L22;
        EdgeEffect r7 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r6, EdgeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L23:
        this.h = r7;     // Catch: Throwable -> L30
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r8, "context");     // Catch: Throwable -> L30
        e r9 = new e(r8, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2, this.l.a());     // Catch: Throwable -> L30
        r9.a(true);     // Catch: Throwable -> L30
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r10, "context");     // Catch: Throwable -> L30
        e r11 = new e(r10, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 3, this.l.a());     // Catch: Throwable -> L30
        r11.a(true);     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r1.set(this, r9);     // Catch: Throwable -> L30
        r2.set(this, r11);     // Catch: Throwable -> L30
        this.e = r9;     // Catch: Throwable -> L30
        this.f = r11;     // Catch: Throwable -> L30
        this.i = true;     // Catch: Throwable -> L30
        this.l.c();     // Catch: Throwable -> L30
        this.m.a();     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r9.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r11.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L22:
        r7 = null;
        goto L23
    L18:
        r5 = null;
    L30:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to install BounceEdgeEffects, restoring original.", th);
        g();
        this.e = null;
        this.f = null;
        this.i = false;
        return;
    }

    private final void g() {
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
        Log.w("OHorizontalScrollView", "Failed to restore original edge effects", th);
    }

    private final float getCurrentFlingVelocity() {
        Field r1 = this.j;     // Catch: Throwable -> L14
        OverScroller r2 = null;
        if (r1 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L10;
        r2 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L10:
        if (r2 != null) goto L12;
        return 1000.0f;
    L12:
        return r2.getCurrVelocity();
    L6:
        r3 = r1.get(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.i == true) goto L8;
        super.dispatchDraw(r4);
        return;
    L8:
        e r0 = this.e;
        if (r0 != null) goto L11;
        float r1 = 0.0f;
    L12:
        e r2 = this.f;
        if (r2 != null) goto L15;
        float r3 = 0.0f;
    L16:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        int r7 = r4.save();
        r4.translate(r5, 0.0f);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L22:
        super.dispatchDraw(r4);
        return;
    L19:
        r6 = false;
        goto L20
    L15:
        r3 = r2.a();
        goto L16
    L11:
        r1 = r0.a();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        this.n.a(r6);
        b r0 = this.n;
        Boolean r1 = r0.a(r6, -r0.b(), 0.0f, (Function0) ZeusTransformUtils.preCheckCast(new OHorizontalScrollView$dispatchTouchEvent$handled$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        b();
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

    @Override // android.view.ViewGroup, android.view.View
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
        g();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (r3.getActionMasked() != 0) goto L16;
        if (a() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        this.k = r0;
        boolean r1 = super.onInterceptTouchEvent(r3);
        if (this.n.b(r3) == false) goto L14;
        return false;
    L14:
        return r1;
    L7:
        if (this.k == true) goto L10;
        r0 = false;
        goto L11
    L16:
        if (this.n.b(r3) == false) goto L19;
        return false;
    L19:
        return super.onInterceptTouchEvent(r3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.l.b();
        e r5 = this.e;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        e r0 = this.f;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        int r0 = r3.getActionMasked();
        boolean r1 = true;
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
    L8:
        e r2 = this.e;
        if (r2 == null) goto L12;
        r2.b(0.0f);
    L12:
        e r4 = this.f;
        if (r4 == null) goto L16;
        r4.b(0.0f);
    L16:
        b();
    L25:
        return super.onTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L18:
        if (a() == false) goto L20;
    L23:
        this.k = r1;
        goto L25
    L20:
        if (this.k == true) goto L23;
        r1 = false;
        goto L23
    }

    @Override // android.view.View
    public boolean overScrollBy(int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, boolean r15) {
        if (r15 == true) goto L4;
    L13:
        boolean r16 = super.overScrollBy(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        if (r15 == false) goto L16;
    L64:
        return r16;
    L16:
        if (this.i == false) goto L64;
        if (r11 <= 0) goto L64;
        int r17 = r9 + r7;
        d r18 = d.f13362a;
        if (d.a() == false) goto L21;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "overScrollFlingFrame", "scrollX=" + r9 + " deltaX=" + r7 + " finalScrollX=" + r17 + " range=" + r11);
    L21:
        boolean r19 = false;
        if (r17 > 0) goto L43;
        if (r7 >= 0) goto L43;
        e r1 = this.e;
        if (r1 != null) goto L28;
    L26:
        boolean r2 = false;
    L30:
        if (r2 == false) goto L43;
        float r3 = getCurrentFlingVelocity();
        int r4 = Math.abs(r17);
        e r5 = this.e;
        if (r5 == null) goto L35;
        r5.onPull(r4 / getWidth(), 0.5f);
    L35:
        d r6 = d.f13362a;
        if (d.a() == false) goto L38;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbLeft", "velocity=" + r3 + " overscroll=" + r4);
    L38:
        e r20 = this.e;
        if (r20 == null) goto L42;
        r20.onAbsorb((int) r3);
    L42:
        e();
        goto L43
    L28:
        if (r1.isFinished() != true) goto L26;
        r2 = true;
    L43:
        if (r17 < r11) goto L64;
        if (r7 <= 0) goto L64;
        e r21 = this.f;
        if (r21 != null) goto L49;
    L51:
        if (r19 == false) goto L64;
        float r22 = getCurrentFlingVelocity();
        int r110 = r17 - r11;
        e r111 = this.f;
        if (r111 == null) goto L56;
        r111.onPull(r110 / getWidth(), 0.5f);
    L56:
        d r112 = d.f13362a;
        if (d.a() == false) goto L59;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbRight", "velocity=" + r22 + " overscroll=" + r110);
    L59:
        e r23 = this.f;
        if (r23 == null) goto L63;
        r23.onAbsorb(-((int) r22));
    L63:
        e();
        goto L64
    L49:
        if (r21.isFinished() != true) goto L51;
        r19 = true;
        goto L51
    L4:
        if (this.i == false) goto L13;
        float r0 = r7;
        e r24 = this.e;
        if (r24 == null) goto L9;
        r24.b(r0);
    L9:
        e r25 = this.f;
        if (r25 == null) goto L13;
        r25.b(r0);
        goto L13
    }

    public void setOnBounceTranslationListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.m.a(r4);
    }
}
