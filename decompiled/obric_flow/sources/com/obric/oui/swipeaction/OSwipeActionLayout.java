package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0014\u0010+\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0015R\u0014\u0010-\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0015R\u0014\u0010/\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0015R\u0014\u00101\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0015R\u0014\u00103\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u0014\u00105\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\rR\u0014\u00107\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0015¨\u00068"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "I", "getDirection", "()I", "setDirection", "(I)V", "direction", "", "b", "Z", "getSwipeEnabled", "()Z", "setSwipeEnabled", "(Z)V", "swipeEnabled", "c", "getContinuousSwipe", "setContinuousSwipe", "continuousSwipe", "value", "o", "setRightViewPadding", "rightViewPadding", "Lcom/obric/oui/swipeaction/a;", "actionsListener", "Lcom/obric/oui/swipeaction/a;", "getActionsListener", "()Lcom/obric/oui/swipeaction/a;", "setActionsListener", "(Lcom/obric/oui/swipeaction/a;)V", "getPreviousPosition", "previousPosition", "getRightViewOpened", "rightViewOpened", "getLeftViewOpened", "leftViewOpened", "getRightOpenFinished", "rightOpenFinished", "getLeftOpenFinished", "leftOpenFinished", "getLViewWidth", "lViewWidth", "getRViewWidth", "rViewWidth", "getRightViewEmpty", "rightViewEmpty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeActionLayout extends FrameLayout {
    public View A;
    public final int B;
    public View C;
    public View D;
    public final int E;
    public final b F;
    public final OSwipeActionLayout$dragHelperCallback$1 G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14568c;
    public final double d;
    public boolean e;
    public final boolean f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f14572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f14573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f14574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14579r;
    public ViewDragHelper s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GestureDetectorCompat f14580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f14585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f14586z;

    @JvmOverloads
    public OSwipeActionLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static /* synthetic */ void a(OSwipeActionLayout r5) {
        m114setupPost$lambda2(r5);
    }

    public static final int b(OSwipeActionLayout r5, int r10, int r11) {
        boolean r12 = r5.f;
        if (r12 == false) goto L5;
    L8:
        if (r12 == false) goto L10;
    L13:
        boolean r13 = r5.e;
        if (r13 == true) goto L17;
        if (r10 <= 0) goto L17;
        return RangesKt.coerceAtMost(r10, r5.getLViewWidth());
    L17:
        if (r13 == true) goto L20;
        if (r10 >= 0) goto L20;
        return RangesKt.coerceAtLeast(r10, -r5.getRViewWidth());
    L20:
        if (r10 >= 0) goto L23;
        return RangesKt.coerceAtLeast(r10, r5.f14577p - r5.f14582v);
    L23:
        return RangesKt.coerceAtMost(r10, r5.f14582v - r5.f14576o);
    L10:
        if (r5.f14584x == false) goto L13;
        if (r11 <= 0) goto L13;
        return RangesKt.coerceAtMost(r10, 0);
    L5:
        if (r5.f14583w == false) goto L8;
        if (r11 >= 0) goto L8;
        return RangesKt.coerceAtLeast(r10, 0);
    }

    public static final int c(OSwipeActionLayout r5, int r10) {
        boolean r11 = r5.f14568c;
        boolean r12 = r5.f;
        if (r11 == false) goto L15;
        if (r5.getRightViewEmpty() == false) goto L15;
        if (r12 == false) goto L11;
        int r13 = r5.f14582v;
        if (r10 <= r13) goto L33;
        return 0;
    L33:
        return RangesKt.coerceAtLeast(r10, -r13);
    L11:
        if (r10 <= 0) goto L34;
        return 0;
    L34:
        return RangesKt.coerceAtLeast(r10, -r5.f14582v);
    L15:
        if (r5.e == false) goto L24;
        if (r12 == false) goto L21;
        int r14 = r5.f14582v;
        if (r10 <= r14) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtLeast(r10, r5.f14577p - r14);
    L21:
        if (r10 <= 0) goto L36;
        return 0;
    L36:
        return RangesKt.coerceAtLeast(r10, r5.f14577p - r5.f14582v);
    L24:
        if (r12 == true) goto L26;
        if (r10 <= 0) goto L32;
        return 0;
    L32:
        return RangesKt.coerceAtLeast(r10, -r5.getRViewWidth());
    L26:
        if (r10 <= r5.f14582v) goto L37;
        return 0;
    L37:
        return RangesKt.coerceAtLeast(r10, -r5.getRViewWidth());
    }

    public static final int d(OSwipeActionLayout r5, int r10) {
        boolean r11 = r5.f14568c;
        boolean r12 = r5.f;
        if (r11 == false) goto L15;
        if (r5.getRightViewEmpty() == false) goto L15;
        if (r12 == false) goto L11;
        int r13 = r5.f14582v;
        int r14 = -r13;
        if (r10 >= r14) goto L34;
        return r14;
    L34:
        return RangesKt.coerceAtMost(r10, r13);
    L11:
        if (r10 >= 0) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtMost(r10, r5.f14582v);
    L15:
        if (r5.e == false) goto L25;
        if (r12 == false) goto L22;
        int r15 = r5.f14582v;
        int r16 = -r15;
        if (r10 < r16) goto L41;
        int r17 = RangesKt.coerceAtMost(r10, r15 - r5.f14576o);
    L36:
        return r17;
    L41:
        return r16;
    L22:
        if (r10 >= 0) goto L37;
        return 0;
    L37:
        return RangesKt.coerceAtMost(r10, r5.f14582v - r5.f14576o);
    L25:
        if (r12 == false) goto L30;
        int r18 = -r5.f14582v;
        if (r10 < r18) goto L38;
        r17 = RangesKt.coerceAtMost(r10, r5.getLViewWidth());
        goto L36
    L38:
        return r18;
    L30:
        if (r10 >= 0) goto L33;
        return 0;
    L33:
        return RangesKt.coerceAtMost(r10, r5.getLViewWidth());
    }

    public static final int e(OSwipeActionLayout r10, float r11) {
        double r5 = r10.d;
        if (r11 < 0.0f) goto L14;
        int r12 = r10.f14581u;
        if (r12 > 0) goto L8;
    L9:
        if (r12 <= 0) goto L14;
        if (Math.abs(r12) <= (r10.getLViewWidth() / 2)) goto L14;
    L41:
        return r10.getLViewWidth();
    L8:
        if (r11 > r5) goto L41;
    L14:
        if (r11 > 0.0f) goto L24;
        int r13 = r10.f14581u;
        if (r13 < 0) goto L19;
    L20:
        if (r13 >= 0) goto L24;
        if (Math.abs(r13) <= (r10.getRViewWidth() / 2)) goto L24;
    L42:
        return -r10.getRViewWidth();
    L19:
        if (r11 < (-r5)) goto L42;
    L24:
        int r14 = r10.f14581u;
        if (r14 >= 0) goto L27;
    L28:
        if (r14 <= 0) goto L30;
    L31:
        if (r14 >= 0) goto L33;
    L34:
        int r15 = r10.f14581u;
        if (r15 <= 0) goto L37;
    L39:
        return -1;
    L37:
        if (Math.abs(r15) >= (r10.getRViewWidth() / 2)) goto L39;
    L38:
        return 0;
    L33:
        if (Math.abs(r14) < (r10.getLViewWidth() / 2)) goto L38;
    L30:
        if (r11 > r5) goto L38;
    L27:
        if (r11 < (-r5)) goto L38;
        goto L28
    }

    public static final int f(OSwipeActionLayout r10, float r11) {
        boolean r5 = r10.f14568c;
        double r12 = r10.d;
        if (r5 == false) goto L23;
        boolean r13 = r10.getRightViewEmpty();
        int r14 = r10.B;
        if (r13 == false) goto L14;
        int r15 = r10.f14581u;
        if (r15 >= 0) goto L11;
        if (Math.abs(r15) <= (r10.f14582v / 2)) goto L11;
    L12:
        int r16 = r10.f14582v;
    L39:
        return (-r16) + r14;
    L11:
        if (r11 < (-r12)) goto L12;
        return 0;
    L14:
        if (r11 < (-r12)) goto L16;
    L17:
        int r17 = r10.f14581u;
        if (r17 >= 0) goto L23;
        if (Math.abs(r17) <= (r10.f14582v / 2)) goto L23;
    L21:
        r16 = r10.f14582v;
        goto L39
    L16:
        if (Math.abs(r10.f14581u) > r10.getRViewWidth()) goto L21;
    L23:
        double r18 = r11;
        if (r18 <= r12) goto L27;
        return 0;
    L27:
        if (r18 < (-r12)) goto L40;
        int r19 = r10.f14581u;
        if (r19 < 0) goto L32;
    L34:
        int r110 = r10.f14581u;
        if (r110 >= 0) goto L41;
        Math.abs(r110);
        int r20 = r10.getRViewWidth() / 2;
        return 0;
    L41:
        return 0;
    L32:
        if (Math.abs(r19) <= (r10.getRViewWidth() / 2)) goto L34;
    L40:
        return -r10.getRViewWidth();
    }

    public static final int g(OSwipeActionLayout r10, float r11) {
        boolean r5 = r10.f14568c;
        double r12 = r10.d;
        if (r5 == false) goto L23;
        boolean r13 = r10.getRightViewEmpty();
        int r14 = r10.E;
        if (r13 == false) goto L14;
        int r15 = r10.f14581u;
        if (r15 <= 0) goto L11;
        if (Math.abs(r15) <= (r10.f14582v / 2)) goto L11;
    L12:
        int r16 = r10.f14582v;
    L39:
        return r16 - r14;
    L11:
        if (r11 > r12) goto L12;
        return 0;
    L14:
        if (r11 > r12) goto L16;
    L17:
        int r17 = r10.f14581u;
        if (r17 <= 0) goto L23;
        if (Math.abs(r17) <= (r10.f14582v / 2)) goto L23;
    L21:
        r16 = r10.f14582v;
        goto L39
    L16:
        if (Math.abs(r10.f14581u) > r10.getLViewWidth()) goto L21;
    L23:
        double r18 = r11;
        if (r18 > r12) goto L40;
        if (r18 < (-r12)) goto L42;
        int r19 = r10.f14581u;
        if (r19 > 0) goto L32;
    L34:
        int r20 = r10.f14581u;
        if (r20 <= 0) goto L41;
        Math.abs(r20);
        int r21 = r10.getLViewWidth() / 2;
        return 0;
    L41:
        return 0;
    L32:
        if (Math.abs(r19) <= (r10.getLViewWidth() / 2)) goto L34;
    L42:
        return 0;
    L40:
        return r10.getLViewWidth();
    }

    private final int getLViewWidth() {
        return this.f14573l;
    }

    private final boolean getLeftOpenFinished() {
        if (this.f14581u != (this.f14582v - this.E)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.C != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f14581u != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.f14583w == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.f14584x == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getRViewWidth() {
        return this.f14570i;
    }

    private final boolean getRightOpenFinished() {
        if (this.f14581u != ((-this.f14582v) + this.B)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.f14586z != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.f14586z != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f14581u != (-getRViewWidth())) goto L7;
        return true;
    }

    public static final /* synthetic */ int h(OSwipeActionLayout r5) {
        return r5.getPreviousPosition();
    }

    public static final void i(OSwipeActionLayout r5) {
        if (r5.f14581u != 0) goto L14;
        r5.f14583w = false;
        r5.f14584x = false;
        View r10 = r5.f14586z;
        if (r10 == null) goto L8;
        r10.layout(0, r10.getTop(), r10.getWidth(), r10.getBottom());
    L8:
        View r11 = r5.C;
        if (r11 == null) goto L12;
        r11.layout(0, r11.getTop(), r11.getWidth(), r11.getBottom());
    L12:
        r5.f14575n = 0;
        return;
    L14:
        if (r5.getLeftOpenFinished() == false) goto L16;
    L23:
        r5.f14583w = true;
        r5.f14584x = false;
        return;
    L16:
        if (r5.getLeftViewOpened() == true) goto L23;
        if (r5.getRightOpenFinished() == false) goto L21;
    L22:
        r5.f14583w = false;
        r5.f14584x = true;
        return;
    L21:
        if (r5.getRightViewOpened() == true) goto L22;
    }

    public static View j(MotionEvent r5, ViewGroup r10) {
        Intrinsics.checkNotNull(r10);
        if (r10.onInterceptTouchEvent(r5) == false) goto L5;
        return r10;
    L5:
        int r11 = r10.getChildCount();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L12;
        int r13 = r12 + 1;
        View r14 = r10.getChildAt(r12);
        if ((r14 instanceof ViewGroup) == true) goto L11;
        r12 = r13;
        goto L6
    L11:
        return j(r5, (ViewGroup) r14);
    L12:
        return null;
    }

    private final void setRightViewPadding(int r5) {
        this.f14576o = r5;
        if (this.f14568c == false) goto L8;
        if (this.f14566a == 3) goto L8;
        this.e = true;
    L8:
        if (this.f14566a != 3) goto L11;
        setRightViewPadding(0);
        this.f14577p = 0;
        return;
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m114setupPost$lambda2(OSwipeActionLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r10 = r5.f14566a;
        if (r10 != 1) goto L5;
        View r11 = r5.f14586z;
        Intrinsics.checkNotNull(r11);
        r11.setX(r5.f14582v);
        return;
    L5:
        if (r10 != 2) goto L7;
        View r12 = r5.C;
        Intrinsics.checkNotNull(r12);
        View r13 = r5.C;
        Intrinsics.checkNotNull(r13);
        r12.setX(-r13.getWidth());
        return;
    L7:
        if (r10 != 3) goto L15;
        View r14 = r5.f14586z;
        Intrinsics.checkNotNull(r14);
        r14.setX(r5.f14582v);
        View r15 = r5.C;
        Intrinsics.checkNotNull(r15);
        View r16 = r5.C;
        Intrinsics.checkNotNull(r16);
        r15.setX(-r16.getWidth());
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r5 = this.s;
        Intrinsics.checkNotNull(r5);
        if (r5.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final a getActionsListener() {
        return null;
    }

    public final boolean getContinuousSwipe() {
        return this.f14568c;
    }

    public final int getDirection() {
        return this.f14566a;
    }

    public final boolean getSwipeEnabled() {
        return this.f14567b;
    }

    public final boolean k(MotionEvent r5) {
        int[] r10 = new int[2];
        View r11 = this.f14585y;
        Intrinsics.checkNotNull(r11);
        r11.getLocationOnScreen(r10);
        int r12 = r10[1];
        View r13 = this.f14585y;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getMeasuredHeight() + r12;
        int r15 = r10[1];
        int r16 = (int) r5.getRawY();
        if ((r15 + 1) > r16) goto L7;
        if (r16 >= r14) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        int r5 = this.f14574m;
        if (r5 == 0) goto L5;
        this.f14585y = findViewById(r5);
    L5:
        int r10 = this.f14571j;
        if (r10 == 0) goto L8;
        this.C = findViewById(r10);
    L8:
        int r11 = this.g;
        if (r11 == 0) goto L11;
        this.f14586z = findViewById(r11);
    L11:
        int r12 = this.f14569h;
        if (r12 == 0) goto L14;
        this.A = findViewById(r12);
    L14:
        int r13 = this.f14572k;
        if (r13 == 0) goto L18;
        this.D = findViewById(r13);
    L18:
        if (this.f14585y == null) goto L61;
        int r14 = this.f14566a;
        if (r14 != 1) goto L27;
        if (this.f14586z != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r14 == 2) goto L29;
    L33:
        if (r14 == 1) goto L35;
    L41:
        if (r14 != 2) goto L50;
        if (this.f14568c == true) goto L50;
        if (this.C != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r14 == 3) goto L52;
    L58:
        this.s = ViewDragHelper.create(this, 1.0f, this.G);
        this.f14580t = new GestureDetectorCompat(getContext(), this.F);
        post(new com.obric.oui.lisitem.a(this, 3));
        super.onFinishInflate();
        return;
    L52:
        if (this.f14586z == null) goto L57;
        if (this.C != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.f14568c == true) goto L41;
        if (this.f14586z != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.C != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.f14578q == false) goto L18;
        View r5 = this.f14585y;
        if ((r5 instanceof ViewGroup) == false) goto L18;
        View r11 = j(r10, (ViewGroup) r5);
        Point r12 = new Point((int) r10.getX(), (int) r10.getY());
        if (r11 == null) goto L18;
        if (r12.y < r11.getTop()) goto L18;
        if (r12.y >= r11.getBottom()) goto L18;
        if (r12.x < r11.getLeft()) goto L18;
        if (r12.y >= r11.getRight()) goto L18;
        return false;
    L18:
        if (k(r10) == false) goto L23;
        ViewDragHelper r13 = this.s;
        Intrinsics.checkNotNull(r13);
        if (r13.shouldInterceptTouchEvent(r10) == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        this.f14582v = r5;
        super.onSizeChanged(r5, r10, r11, r12);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (k(r5) == true) goto L10;
        int r10 = this.f14579r;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        return super.onTouchEvent(r5);
    L10:
        GestureDetectorCompat r11 = this.f14580t;
        Intrinsics.checkNotNull(r11);
        r11.onTouchEvent(r5);
        ViewDragHelper r12 = this.s;
        Intrinsics.checkNotNull(r12);
        r12.processTouchEvent(r5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r5) {
        super.requestDisallowInterceptTouchEvent(r5);
        this.f14578q = r5;
    }

    public final void setActionsListener(a r5) {
    }

    public final void setContinuousSwipe(boolean r5) {
        this.f14568c = r5;
    }

    public final void setDirection(int r5) {
        this.f14566a = r5;
    }

    public final void setSwipeEnabled(boolean r5) {
        this.f14567b = r5;
    }

    @JvmOverloads
    public OSwipeActionLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSwipeActionLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.obric.oui.swipeaction.OSwipeActionLayout$dragHelperCallback$1] */
    @JvmOverloads
    public OSwipeActionLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14566a = 1;
        this.f14578q = true;
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.OSwipeActionLayout);
        this.f14566a = 1;
        this.f14567b = r12.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_swipeEnabled, true);
        this.f14568c = r12.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_continuousSwipe, true);
        this.d = r12.getInt(R$styleable.OSwipeActionLayout_oui_sal_autoMovingSensitivity, 1000);
        this.e = r12.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_dragAfterOpened, false);
        this.f = r12.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_freeDrag, true);
        this.g = r12.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_rightItem, 0);
        this.f14569h = r12.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_rightItem_bg, 0);
        this.f14570i = (int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, 0.0f);
        this.B = (int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, 0.0f);
        this.f14571j = r12.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_leftItem, 0);
        this.f14572k = r12.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_leftItem_bg, 0);
        this.f14573l = (int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, 0.0f);
        this.E = (int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, 0.0f);
        this.f14574m = r12.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_draggedItem, 0);
        setRightViewPadding((int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightViewPadding, 0.0f));
        this.f14577p = (int) r12.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftViewPadding, 0.0f);
        if (this.f14568c == false) goto L8;
        if (this.f14566a == 3) goto L8;
        this.e = true;
    L8:
        if (this.f14566a != 3) goto L10;
        setRightViewPadding(0);
        this.f14577p = 0;
    L10:
        r12.recycle();
        this.F = new b(this, 0);
        this.G = new OSwipeActionLayout$dragHelperCallback$1(this);
    }
}
