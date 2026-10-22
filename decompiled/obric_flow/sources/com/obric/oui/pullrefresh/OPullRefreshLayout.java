package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.google.common.reflect.w;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$styleable;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0019\u001a\u00020\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J-\u0010\u001f\u001a\u00020\r2\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r0!¢\u0006\u0004\b\u001f\u0010#J\u0015\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u0016J\u0015\u0010)\u001a\u00020\r2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b)\u0010,J\u0015\u0010-\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b-\u0010\u0016J\u0015\u0010.\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u0016J\u0015\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\r2\u0006\u00105\u001a\u00020\"H\u0002¢\u0006\u0004\b6\u00107R\"\u0010=\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u00102R\u0011\u0010@\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "dragDamping", "", "setDragDamping", "(F)V", "triggerRate", "setTriggerRate", "headerInsetStartDp", "setHeaderInsetStartDp", "headerInsetStartPx", "setHeaderInsetStartPx", "(I)V", "Lcom/obric/oui/pullrefresh/e;", "listener", "setOnRefreshListener", "(Lcom/obric/oui/pullrefresh/e;)V", "Lkotlin/Function1;", "block", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/obric/oui/pullrefresh/f;", "setOnStateChangeListener", "(Lcom/obric/oui/pullrefresh/f;)V", "Lkotlin/Function3;", "Lcom/obric/oui/pullrefresh/RefreshState;", "(Lkotlin/jvm/functions/Function3;)V", "Lbs/b;", "header", "setRefreshHeader", "(Lbs/b;)V", "color", "setDefaultHeaderTextColor", "Landroid/content/res/ColorStateList;", "colors", "(Landroid/content/res/ColorStateList;)V", "setDefaultHeaderIconColor", "setDefaultHeaderProgressBackgroundColor", "", "enabled", "setNestedScrollEnabledWhileAnimatingOffset", "(Z)V", "getNestedScrollAxes", "()I", "newState", "setState", "(Lcom/obric/oui/pullrefresh/RefreshState;)V", "C", "Z", "getRefreshEnable", "()Z", "setRefreshEnable", "refreshEnable", "getState", "()Lcom/obric/oui/pullrefresh/RefreshState;", "state", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPullRefreshLayout extends ViewGroup implements NestedScrollingParent3 {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public float B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f14223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bs.b f14224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14225c;
    public View d;
    public View e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RefreshState f14228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f14229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f14230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public jp.d f14231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f14233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f14234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14236r;
    public final int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14238u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f14239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14240w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14241x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14242y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14243z;

    @JvmOverloads
    public OPullRefreshLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static final /* synthetic */ void a(OPullRefreshLayout r5, RefreshState r10) {
        r5.setState(r10);
    }

    private final void setState(RefreshState r5) {
        RefreshState r10 = this.f14228j;
        if (r10 != r5) goto L5;
        return;
    L5:
        this.f14228j = r5;
        bs.b r11 = this.f14224b;
        if (r11 == null) goto L9;
        r11.c(this, r10, r5);
    L9:
        f r12 = this.f14230l;
        if (r12 == null) goto L14;
        ((d) r12).f14248a.invoke(this, r10, r5);
        return;
    }

    public final void b(int r11, final Function0 r12) {
        int r5 = this.g;
        if (r5 != r11) goto L8;
        if (r12 == null) goto L30;
        r12.invoke();
        return;
    L30:
        return;
    L8:
        int r10 = Math.abs(r5 - r11);
        if (ViewCompat.isLaidOut(this) == true) goto L11;
    L21:
        jp.d r13 = this.f14231m;
        if (r13 == null) goto L25;
        int r14 = jp.d.d;
        r13.a(false);
    L25:
        i(r11);
        if (r12 == null) goto L31;
        r12.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r10 <= 2) goto L21;
        jp.d r15 = this.f14231m;
        if (r15 == null) goto L19;
        int r16 = jp.d.d;
        r15.a(false);
    L19:
        float r17 = this.g;
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
        Intrinsics.checkNotNullParameter(r18, "spec");
        hp.a r19 = new hp.a(r18, Float.valueOf(r17), Float.valueOf(r11), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        Function3<String, Object, Object, Unit> r110 = new OPullRefreshLayout$animateOffsetTo$1(this);
        Intrinsics.checkNotNullParameter(r110, "callback");
        Function2<Boolean, Throwable, Unit> r20 = new OPullRefreshLayout$animateOffsetTo$2(this, r12);
        Intrinsics.checkNotNullParameter(r20, "callback");
        this.f14231m = new w(r19, r110, r20).x();
        this.f14237t = true;
        j(true);
    }

    public final void c() {
        float r5 = this.g;
        View r10 = this.f14225c;
        if (r10 != null) goto L6;
    L9:
        View r11 = this.d;
        if (r11 != null) goto L13;
        return;
    L13:
        if (r11.getTranslationY() == r5) goto L18;
        r11.setTranslationY(r5);
        return;
    L18:
        return;
    L6:
        if (r10.getTranslationY() == r5) goto L9;
        r10.setTranslationY(r5);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof ViewGroup.MarginLayoutParams;
    }

    public final boolean d() {
        View r5 = this.e;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.canScrollVertically(-1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final int e(float r10, int r11) {
        int r5 = this.f;
        if (r5 <= 0) goto L5;
        float r12 = r5 * 2.0f;
    L6:
        float r13 = r11;
        float r14 = RangesKt.coerceIn(this.f14226h, 0.01f, 1.0f);
        float r15 = Math.max(1.0f, r12);
        float r16 = (1.0f - (1.0f / (((r14 * r13) / r15) + 1.0f))) * r15;
        float r17 = RangesKt.coerceAtLeast(r13 + r10, 0.0f);
        float r18 = RangesKt.coerceIn(this.f14226h, 0.01f, 1.0f);
        float r19 = Math.max(1.0f, r12);
        float r20 = (((1.0f - (1.0f / (((r17 * r18) / r19) + 1.0f))) * r19) - r16) + this.B;
        int r21 = (int) r20;
        this.B = r20 - r21;
        return r21;
    L5:
        r12 = RangesKt.coerceAtLeast(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    public final void f() {
        if (this.d == null) goto L5;
        return;
    L5:
        int r5 = getChildCount();
        int r10 = 0;
    L6:
        if (r10 >= r5) goto L14;
        int r11 = r10 + 1;
        View r12 = getChildAt(r10);
        if (r12 != this.f14225c) goto L9;
        r10 = r11;
        goto L6
    L9:
        this.d = r12;
        return;
    }

    public final View g(View r5) {
        if (r5 != null) goto L5;
    L24:
        return null;
    L5:
        if (r5 == this.f14225c) goto L24;
        if ((r5 instanceof ScrollView) == false) goto L10;
    L23:
        return r5;
    L10:
        if ((r5 instanceof AbsListView) == true) goto L23;
        if ((r5 instanceof NestedScrollingChild) == true) goto L23;
        if ((r5 instanceof ViewGroup) == false) goto L22;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L17:
        if (r12 >= r11) goto L22;
        int r13 = r12 + 1;
        View r14 = g(r10.getChildAt(r12));
        if (r14 != null) goto L20;
        r12 = r13;
        goto L17
    L20:
        return r14;
    L22:
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new ViewGroup.MarginLayoutParams(r5);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f14223a.getNestedScrollAxes();
    }

    public final boolean getRefreshEnable() {
        return this.C;
    }

    public final RefreshState getState() {
        return this.f14228j;
    }

    public final void h() {
        int r5 = this.f;
        if (r5 > 0) goto L5;
        return;
    L5:
        int r10 = 0;
        if (this.g < ((int) (r5 * this.f14227i))) goto L23;
        RefreshState r11 = this.f14228j;
        if (r11 != RefreshState.RELEASE_TO_REFRESH) goto L10;
    L11:
        if (r5 > 0) goto L19;
        View r12 = this.f14225c;
        if (r12 == null) goto L16;
        r10 = r12.getMeasuredHeight();
    L16:
        this.f = r10;
        if (r10 > 0) goto L19;
        return;
    L19:
        setState(RefreshState.REFRESHING);
        b(this.f, null);
        e r13 = this.f14229k;
        if (r13 == null) goto L27;
        ((c) r13).f14247a.invoke(this);
        return;
    L27:
        return;
    L10:
        if (r11 == RefreshState.PULL_TO_REFRESH) goto L11;
    L23:
        b(0, new OPullRefreshLayout$finishSpinner$1(this));
    }

    public final void i(int r10) {
        int r11 = Math.max(0, r10);
        if (r11 != this.g) goto L5;
        return;
    L5:
        this.g = r11;
        c();
        int r12 = this.f;
        if (r12 <= 0) goto L15;
        float r13 = RangesKt.coerceIn(this.g / r12, 0.0f, 1.0f);
        int r5 = this.g;
        int r14 = this.f;
        long r15 = SystemClock.uptimeMillis();
        if ((r15 - this.f14239v) >= 16) goto L11;
        if (r5 == 0) goto L11;
        if (r5 != r14) goto L15;
    L11:
        this.f14239v = r15;
        bs.b r16 = this.f14224b;
        if (r16 == null) goto L15;
        r16.b(this, r13);
    L15:
        RefreshState r17 = this.f14228j;
        RefreshState r18 = RefreshState.REFRESHING;
        if (r17 == r18) goto L18;
    L26:
        if (r17 != r18) goto L28;
    L44:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (r17 == RefreshState.FINISH) goto L44;
        int r19 = (int) (this.f * this.f14227i);
        int r20 = this.g;
        if (r20 > 0) goto L33;
        RefreshState r110 = RefreshState.IDLE;
    L43:
        setState(r110);
        goto L44
    L33:
        if (r20 >= r19) goto L36;
        this.A = false;
        r110 = RefreshState.PULL_TO_REFRESH;
        goto L43
    L36:
        if (this.A == true) goto L42;
        this.A = true;
        performHapticFeedback(4);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        ps.a.c("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
    L42:
        r110 = RefreshState.RELEASE_TO_REFRESH;
        goto L43
    L18:
        if (this.g != 0) goto L26;
        if (r17 != r18) goto L21;
    L23:
        setState(RefreshState.FINISH);
        postDelayed(new a(this), 200);
    L24:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        if (r17 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        goto L23
    }

    public final void j(boolean r5) {
        View r10 = this.f14225c;
        View r11 = this.d;
        int r12 = 0;
        if (r5 == false) goto L23;
        if (this.f14243z == true) goto L15;
        this.f14243z = true;
        this.f14240w = getLayerType();
        if (r10 != null) goto L9;
        int r13 = 0;
    L10:
        this.f14241x = r13;
        if (r11 == null) goto L14;
        r12 = r11.getLayerType();
    L14:
        this.f14242y = r12;
        goto L15
    L9:
        r13 = r10.getLayerType();
    L15:
        setLayerType(2, null);
        if (r10 == null) goto L19;
        r10.setLayerType(2, null);
    L19:
        if (r11 == null) goto L34;
        r11.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.f14243z == false) goto L33;
        this.f14243z = false;
        setLayerType(this.f14240w, null);
        if (r10 == null) goto L28;
        r10.setLayerType(this.f14241x, null);
    L28:
        if (r11 == null) goto L35;
        r11.setLayerType(this.f14242y, null);
        return;
    L35:
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        f();
        this.e = g(this.d);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        boolean r5 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.C == false) goto L57;
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L10;
        this.f14232n = false;
        this.f14233o = r10.getY();
        this.f14234p = r10.getX();
        this.f14235q = this.f14233o;
    L56:
        return this.f14232n;
    L10:
        if (r11 != 1) goto L12;
    L53:
        this.f14232n = false;
        goto L56
    L12:
        if (r11 == 2) goto L17;
        if (r11 == 3) goto L53;
    L17:
        if (this.f14232n == true) goto L56;
        float r12 = r10.getY() - this.f14233o;
        float r13 = r10.getX() - this.f14234p;
        float r14 = Math.abs(r12);
        float r15 = Math.abs(r13);
        if (r14 <= this.s) goto L56;
        if (r14 <= r15) goto L56;
        if (this.e != null) goto L25;
    L28:
        boolean r16 = true;
    L30:
        if (r12 <= 0.0f) goto L32;
        boolean r17 = true;
    L34:
        if (r12 < 0.0f) goto L36;
    L38:
        boolean r18 = false;
    L40:
        if ((this.e instanceof NestedScrollingChild) == true) goto L42;
    L44:
        if (r17 == false) goto L47;
        if (r5 == true) goto L47;
        if (r16 == false) goto L47;
    L49:
        this.f14232n = true;
        this.f14235q = r10.getY();
        ViewParent r19 = getParent();
        if (r19 == null) goto L56;
        r19.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r18 == false) goto L56;
        if (r5 == true) goto L56;
    L42:
        if ((this.d instanceof CoordinatorLayout) == true) goto L44;
        r5 = true;
        goto L44
    L36:
        if (this.g <= 0) goto L38;
        r18 = true;
        goto L40
    L32:
        r17 = false;
        goto L34
    L25:
        if (d() == false) goto L28;
        r16 = false;
        goto L30
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        f();
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        if (r15 == 0) goto L24;
        if (r16 == 0) goto L25;
        int r17 = getPaddingLeft();
        int r18 = getPaddingTop();
        int r19 = r15 - getPaddingRight();
        int r20 = r16 - getPaddingBottom();
        View r110 = this.f14225c;
        if (r110 == null) goto L12;
        ViewGroup.LayoutParams r5 = r110.getLayoutParams();
        if (r5 == null) goto L23;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r5;
        int r22 = r110.getMeasuredHeight();
        int r23 = r21.leftMargin + r17;
        int r24 = ((r18 - r22) + this.f14236r) + r21.topMargin;
        r110.layout(r23, r24, r110.getMeasuredWidth() + r23, r22 + r24);
        goto L12
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        View r111 = this.d;
        if (r111 == null) goto L18;
        ViewGroup.LayoutParams r25 = r111.getLayoutParams();
        if (r25 == null) goto L21;
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        r111.layout(r17 + r26.leftMargin, r18 + r26.topMargin, r19 - r26.rightMargin, r20 - r26.bottomMargin);
        goto L18
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        c();
        return;
    L25:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        f();
        int r11 = getMeasuredWidth();
        int r12 = getMeasuredHeight();
        if (r11 == 0) goto L19;
        if (r12 == 0) goto L21;
        int r13 = View.MeasureSpec.makeMeasureSpec((r11 - getPaddingLeft()) - getPaddingRight(), BasicMeasure.EXACTLY);
        int r14 = View.MeasureSpec.makeMeasureSpec((r12 - getPaddingTop()) - getPaddingBottom(), BasicMeasure.EXACTLY);
        View r15 = this.d;
        if (r15 == null) goto L10;
        r15.measure(r13, r14);
    L10:
        View r16 = this.f14225c;
        if (r16 == null) goto L20;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L18;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        int r19 = getPaddingLeft();
        int r20 = ViewGroup.getChildMeasureSpec(r5, ((getPaddingRight() + r19) + r18.leftMargin) + r18.rightMargin, r18.width);
        int r21 = getPaddingTop();
        r16.measure(r20, ViewGroup.getChildMeasureSpec(r10, ((getPaddingBottom() + r21) + r18.topMargin) + r18.bottomMargin, r18.height));
        this.f = r16.getMeasuredHeight();
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "target");
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r5, int r10, int r11, int[] r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r12, "consumed");
        if (r13 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f14238u == true) goto L14;
        if (this.f14237t == false) goto L14;
        return;
    L14:
        if (r11 <= 0) goto L18;
        int r14 = this.g;
        if (r14 <= 0) goto L18;
        int r15 = Math.min(r11, r14);
        i(this.g - r15);
        r12[1] = r15;
    L18:
        if (r11 < 0) goto L20;
        return;
    L20:
        if (d() == false) goto L22;
        return;
    L22:
        if (this.f14228j == RefreshState.REFRESHING) goto L29;
        int r16 = e(Math.abs(r11), this.g);
        if (r16 <= 0) goto L30;
        i(this.g + r16);
        r12[1] = r11;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "target");
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r10, "target");
        this.f14223a.onNestedScrollAccepted(r5, r10, r11, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.C == false) goto L9;
        if ((r11 & 2) == 0) goto L9;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "target");
        this.f14223a.onStopNestedScroll(r5, r10);
        if (r10 == 0) goto L5;
        return;
    L5:
        if (this.f14228j == RefreshState.REFRESHING) goto L9;
        h();
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (isEnabled() == false) goto L63;
        if (this.C == false) goto L63;
        int r5 = r10.getActionMasked();
        if (r5 == 0) goto L60;
        if (r5 == 1) goto L53;
        if (r5 != 2) goto L13;
        float r11 = r10.getY();
        float r12 = r11 - this.f14235q;
        this.f14235q = r11;
        if (this.f14232n == true) goto L32;
        float r13 = r11 - this.f14233o;
        float r14 = r10.getX() - this.f14234p;
        float r15 = Math.abs(r13);
        float r16 = Math.abs(r14);
        if (r15 <= this.s) goto L32;
        if (r15 <= r16) goto L32;
        if (r13 <= 0.0f) goto L32;
        if (this.e != null) goto L26;
    L27:
        this.f14232n = true;
        this.f14235q = r11;
        ViewParent r17 = getParent();
        if (r17 == null) goto L32;
        r17.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (d() == false) goto L27;
    L32:
        if (this.f14232n == true) goto L34;
    L59:
        return super.onTouchEvent(r10);
    L34:
        if (r12 < 0.0f) goto L36;
    L38:
        if (r12 >= 0.0f) goto L48;
        int r18 = Math.min((int) Math.abs(r12), this.g);
        if (r18 <= 0) goto L42;
        i(this.g - r18);
    L42:
        this.B = 0.0f;
        if (((int) Math.abs(r12)) <= r18) goto L46;
        this.f14232n = false;
        return false;
    L46:
        return true;
    L48:
        if (this.f14228j != RefreshState.REFRESHING) goto L50;
        return true;
    L50:
        int r19 = this.g;
        i(e(r12, r19) + r19);
        return true;
    L36:
        if (this.g > 0) goto L38;
        return false;
    L13:
        if (r5 != 3) goto L59;
    L53:
        if (this.f14232n == false) goto L59;
        this.f14232n = false;
        if (this.f14228j == RefreshState.REFRESHING) goto L57;
        h();
    L57:
        return true;
    L60:
        this.f14232n = false;
        this.f14233o = r10.getY();
        this.f14234p = r10.getX();
        this.f14235q = this.f14233o;
        return true;
    L63:
        return super.onTouchEvent(r10);
    }

    public final void setDefaultHeaderIconColor(int r5) {
        bs.b r10 = this.f14224b;
        if ((r10 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) r10;
    L6:
        if (r11 == null) goto L10;
        r11.setIconColor(r5);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r5) {
        bs.b r10 = this.f14224b;
        if ((r10 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) r10;
    L6:
        if (r11 == null) goto L10;
        r11.setProgressBackgroundColor(r5);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(int r5) {
        bs.b r10 = this.f14224b;
        if ((r10 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) r10;
    L6:
        if (r11 == null) goto L10;
        r11.setTextColor(r5);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setDragDamping(float r5) {
        this.f14226h = r5;
    }

    public final void setHeaderInsetStartDp(float r5) {
        this.f14236r = com.lynx.tasm.utils.a.A(r5, this);
    }

    public final void setHeaderInsetStartPx(int r5) {
        this.f14236r = r5;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r5) {
        this.f14238u = r5;
    }

    public final void setOnRefreshListener(e r5) {
        this.f14229k = r5;
    }

    public final void setOnStateChangeListener(f r5) {
        this.f14230l = r5;
    }

    public final void setRefreshEnable(boolean r5) {
        this.C = r5;
    }

    public final void setRefreshHeader(bs.b r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        View r10 = this.f14225c;
        if (r10 == null) goto L6;
        removeView(r10);
    L6:
        this.f14224b = r5;
        View r11 = r5.getView();
        this.f14225c = r11;
        addView(r11, 0);
        requestLayout();
    }

    public final void setTriggerRate(float r5) {
        this.f14227i = r5;
    }

    @JvmOverloads
    public OPullRefreshLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new ViewGroup.MarginLayoutParams(getContext(), r5);
    }

    public final void setDefaultHeaderTextColor(ColorStateList r5) {
        Intrinsics.checkNotNullParameter(r5, "colors");
        bs.b r10 = this.f14224b;
        if ((r10 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) r10;
    L6:
        if (r11 == null) goto L10;
        r11.setTextColor(r5);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setOnRefreshListener(Function1<? super OPullRefreshLayout, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.f14229k = new c(r5);
    }

    public final void setOnStateChangeListener(Function3<? super OPullRefreshLayout, ? super RefreshState, ? super RefreshState, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.f14230l = new d(r5);
    }

    public /* synthetic */ OPullRefreshLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r15, "consumed");
        if (r14 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f14238u == false) goto L11;
    L13:
        if (r13 < 0) goto L15;
        return;
    L15:
        if (d() == false) goto L17;
        return;
    L17:
        if (this.f14228j == RefreshState.REFRESHING) goto L26;
        int r16 = e(Math.abs(r13), this.g);
        if (r16 <= 0) goto L25;
        i(this.g + r16);
        r15[1] = r15[1] + r13;
        return;
    L25:
        return;
    L26:
        return;
    L11:
        if (this.f14237t == false) goto L13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OPullRefreshLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f14223a = new NestedScrollingParentHelper(this);
        this.f14226h = 0.8f;
        this.f14227i = 1.0f;
        this.f14228j = RefreshState.IDLE;
        this.s = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.f14238u = true;
        this.C = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        ODefaultRefreshHeader r5 = null;
        if (r11 == null) goto L25;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OPullRefreshLayout, r12, 0);
        this.f14226h = RangesKt.coerceIn(r13.getFloat(R$styleable.OPullRefreshLayout_o_pr_dragDamping, 0.8f), 0.2f, 1.0f);
        this.f14227i = RangesKt.coerceAtLeast(r13.getFloat(R$styleable.OPullRefreshLayout_o_pr_triggerRate, 1.0f), 0.5f);
        this.f14236r = r13.getDimensionPixelOffset(R$styleable.OPullRefreshLayout_o_pr_headerInsetStart, 0);
        this.C = r13.getBoolean(R$styleable.OPullRefreshLayout_o_pr_refreshEnable, true);
        String r14 = r13.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextPull);
        String r15 = r13.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRelease);
        String r16 = r13.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing);
        String r17 = r13.getString(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextSuccess);
        if (r13.hasValue(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor) == false) goto L7;
        Integer r18 = Integer.valueOf(r13.getColor(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, 0));
    L9:
        if (r13.hasValue(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor) == false) goto L11;
        Integer r19 = Integer.valueOf(r13.getColor(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, 0));
    L13:
        if (r13.hasValue(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor) == false) goto L15;
        Integer r20 = Integer.valueOf(r13.getColor(R$styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, 0));
    L16:
        int r21 = r13.getResourceId(R$styleable.OPullRefreshLayout_o_pr_headerView, 0);
        r13.recycle();
        if (r21 == 0) goto L27;
        View r110 = View.inflate(r10, r21, null);
        if ((r110 instanceof bs.b) == false) goto L21;
        bs.b r22 = (bs.b) r110;
    L22:
        if (r22 == null) goto L24;
        setRefreshHeader(r22);
        goto L27
    L24:
        setRefreshHeader(new b(r110));
        goto L27
    L21:
        r22 = null;
    L27:
        if (this.f14224b != null) goto L29;
        setRefreshHeader(new ODefaultRefreshHeader(r10, null));
    L29:
        bs.b r111 = this.f14224b;
        if ((r111 instanceof ODefaultRefreshHeader) == false) goto L32;
        r5 = (ODefaultRefreshHeader) r111;
    L32:
        if (r5 == null) goto L53;
        if (r14 == null) goto L36;
        r5.e = r14;
    L36:
        if (r15 == null) goto L38;
        r5.f = r15;
    L38:
        if (r16 == null) goto L40;
        r5.g = r16;
    L40:
        if (r17 == null) goto L43;
        r5.f14252h = r17;
    L43:
        if (r5.f14251c.getVisibility() != 0) goto L46;
        String r112 = r5.g;
    L52:
        r5.d.setText(r112);
        goto L53
    L46:
        if (r5.f14250b.getVisibility() != 0) goto L49;
        r112 = r5.f14252h;
        goto L52
    L49:
        if (r5.f14253i == false) goto L51;
        r112 = r5.f;
        goto L52
    L51:
        r112 = r5.e;
    L53:
        if (r18 == null) goto L56;
        setDefaultHeaderTextColor(r18.intValue());
    L56:
        if (r20 == null) goto L59;
        setDefaultHeaderProgressBackgroundColor(r20.intValue());
    L59:
        if (r19 == null) goto L63;
        setDefaultHeaderIconColor(r19.intValue());
        return;
    L63:
        return;
    L15:
        r20 = null;
        goto L16
    L11:
        r19 = null;
        goto L13
    L7:
        r18 = null;
        goto L9
    L25:
        r14 = null;
        r15 = null;
        r16 = null;
        r17 = null;
        r18 = null;
        r19 = null;
        r20 = null;
        goto L27
    }
}
