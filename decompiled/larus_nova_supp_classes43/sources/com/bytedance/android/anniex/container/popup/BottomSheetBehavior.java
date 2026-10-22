package com.bytedance.android.anniex.container.popup;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.customview.widget.ViewDragHelper;
import com.byted.cast.sink.api.IServerListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\n\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/BottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public static final /* synthetic */ int F = 0;
    public int A;
    public boolean B;
    public boolean C;
    public Map<View, Integer> D;
    public final BottomSheetBehavior$dragCallback$1 E;
    public boolean g;
    public final float h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public ViewDragHelper q;
    public boolean r;
    public int s;
    public boolean t;
    public int u;
    public WeakReference<V> v;
    public WeakReference<View> w;
    public WeakReference<ViewParent> x;
    public VelocityTracker y;
    public int z;

    public static final class a {
    }

    public final class b implements Runnable {
        public final View a;
        public final int b;
        public final /* synthetic */ BottomSheetBehavior<V> c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r0 = this.c.q;     // Catch: Throwable -> L12
            if (r0 == null) goto L10;
            boolean r1 = true;
            if (r0.continueSettling(true) == true) goto L8;
            r1 = false;
        L8:
            if (r1 == false) goto L10;
            ViewCompat.postOnAnimation(this.a, this);     // Catch: Throwable -> L12
        L17:
            return;
        L10:
            this.c.setStateInternal(this.b);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public b(BottomSheetBehavior r10, View r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "view");
            this.c = r10;
            this.a = r11;
            this.b = r12;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BottomSheetBehavior<V> a;
        public final /* synthetic */ V b;
        public final /* synthetic */ int c;

        public c(BottomSheetBehavior<V> r1, V r10, int r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.startSettlingAnimation(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean b() {
        if (this.e.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.e.b() == false) goto L7;
        return true;
    }

    public final int getExpandedOffset() {
        if (this.g == true) goto L7;
        return 0;
    L7:
        return this.m;
    }

    public final void dispatchOnSlide(int r10) {
        WeakReference<V> r0 = this.v;
        Intrinsics.checkNotNull(r0);
        V r1 = r0.get();
        if (r1 == null) goto L11;
        SheetBaseBehavior.b r11 = this.b;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r10 <= this.o) goto L9;
        Intrinsics.checkNotNull(r11);
        int r12 = this.o;
        r11.b(r1, (r12 - r10) / (this.u - r12));
        return;
    L9:
        Intrinsics.checkNotNull(r11);
        int r13 = this.o;
        r11.b(r1, (r13 - r10) / (r13 - getExpandedOffset()));
        return;
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior
    public final void setPeekHeight(int r10) {
        boolean r1 = true;
        if (r10 != (-1)) goto L8;
        if (this.j == true) goto L12;
        this.j = true;
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        if (this.p != 4) goto L25;
        WeakReference<V> r11 = this.v;
        if (r11 == null) goto L20;
        V r12 = r11.get();
    L21:
        if (r12 == null) goto L26;
        r12.requestLayout();
        return;
    L26:
        return;
    L20:
        r12 = null;
        goto L21
    L25:
        return;
    L12:
        r1 = false;
        goto L14
    L8:
        if (this.j == false) goto L10;
    L13:
        this.j = false;
        this.i = Math.max(0, r10);
        this.o = this.u - r10;
        goto L14
    L10:
        if (this.i == r10) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior
    public final void setState(int r10) {
        if (r10 == this.p) goto L28;
        WeakReference<V> r0 = this.v;
        if (r0 == null) goto L7;
        V r1 = r0.get();
        if (r1 == null) goto L32;
        ViewParent r11 = r1.getParent();
        if (r11 != null) goto L22;
    L26:
        startSettlingAnimation(r1, r10);
        return;
    L22:
        if (r11.isLayoutRequested() == false) goto L26;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L26;
        r1.post(new c(this, r1, r10));
        return;
    L32:
        return;
    L7:
        if (r10 != 4) goto L9;
    L16:
        this.p = r10;
        return;
    L9:
        if (r10 == 3) goto L16;
        if (r10 == 6) goto L16;
        if (this.a == true) goto L15;
        return;
    L15:
        if (r10 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r10) {
        if (this.p == r10) goto L21;
        this.p = r10;
        if (r10 != 6) goto L7;
    L14:
        updateImportantForAccessibility(true);
    L15:
        WeakReference<V> r0 = this.v;
        Intrinsics.checkNotNull(r0);
        V r1 = r0.get();
        if (r1 == null) goto L22;
        SheetBaseBehavior.b r11 = this.b;
        if (r11 == null) goto L23;
        Intrinsics.checkNotNull(r11);
        r11.a(r1, r10);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (r10 == 3) goto L14;
        if (r10 != 4) goto L11;
    L13:
        updateImportantForAccessibility(false);
        goto L15
    L11:
        if (r10 == 5) goto L13;
    }

    public final void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        V r1 = r0.get();
    L8:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.View");
        CoordinatorLayout r11 = r1.getParent();
        if ((r11 instanceof CoordinatorLayout) == false) goto L41;
        CoordinatorLayout r12 = r11;
        int r13 = r12.getChildCount();
        if (r10 == true) goto L13;
    L16:
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L31;
        View r15 = r12.getChildAt(r14);
        WeakReference<V> r16 = this.v;
        if (r16 == null) goto L21;
        V r17 = r16.get();
    L22:
        if (r15 == r17) goto L30;
        if (r10 == true) goto L29;
        Map<View, Integer> r18 = this.D;
        if (r18 == null) goto L30;
        Intrinsics.checkNotNull(r18);
        if (r18.containsKey(r15) == false) goto L30;
        Map<View, Integer> r19 = this.D;
        Intrinsics.checkNotNull(r19);
        Integer r20 = r19.get(r15);
        Intrinsics.checkNotNull(r20);
        ViewCompat.setImportantForAccessibility(r15, r20.intValue());
        goto L30
    L29:
        Map<View, Integer> r21 = this.D;
        Intrinsics.checkNotNull(r21);
        r21.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r15, 4);
    L30:
        r14 = r14 + 1;
        goto L17
    L21:
        r17 = null;
        goto L22
    L31:
        if (r10 == true) goto L42;
        this.D = null;
        return;
    L42:
        return;
    L13:
        if (this.D == null) goto L15;
        return;
    L15:
        this.D = new HashMap(r13);
        goto L16
    L41:
        return;
    L7:
        r1 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.anniex.container.popup.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.g = true;
        this.p = 4;
        this.E = new BottomSheetBehavior$dragCallback$1(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{2130968990, 2130968991, 2130968993, 2130968994});
        TypedValue r13 = r12.peekValue(2);
        if (r13 == null) goto L7;
        int r14 = r13.data;
        if (r14 != (-1)) goto L7;
        setPeekHeight(r14);
    L8:
        this.a = r12.getBoolean(1, false);
        if (this.g == true) goto L20;
        this.g = true;
        if (this.v == null) goto L14;
        this.o = Math.max(this.u - this.l, this.m);
    L14:
        if (this.g == true) goto L16;
    L18:
        int r0 = this.p;
    L19:
        setStateInternal(r0);
        goto L20
    L16:
        if (this.p != 6) goto L18;
        r0 = 3;
    L20:
        this.c = r12.getBoolean(3, false);
        r12.recycle();
        this.h = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r12.getDimensionPixelSize(2, -1));
        goto L8
    }

    public final Parcelable onSaveInstanceState(CoordinatorLayout r10, V r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Parcelable r12 = super.onSaveInstanceState(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new SavedState(r12, this.p);
    }

    public final boolean shouldHide(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "child");
        if (this.c == false) goto L14;
        float r12 = r11 * 0.1f;
        if (r12 <= 500) goto L8;
        return true;
    L8:
        if (r12 >= (-30)) goto L11;
        return false;
    L11:
        if (((this.u - (r10.getTop() + r12)) / r10.getHeight()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r10.getTop() < this.o) goto L15;
        if ((Math.abs((r10.getTop() + (r11 * 0.1f)) - this.o) / this.i) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "child");
        boolean r1 = true;
        if (r11 != 4) goto L6;
        int r0 = this.o;
    L22:
        ViewDragHelper r12 = this.q;
        if (r12 != null) goto L25;
    L27:
        r1 = false;
    L28:
        if (r1 == false) goto L30;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new b(this, r10, r11));
        return;
    L30:
        setStateInternal(r11);
        return;
    L25:
        if (r12.smoothSlideViewTo(r10, r10.getLeft(), r0) != true) goto L27;
    L6:
        if (r11 != 6) goto L12;
        r0 = this.n;
        if (this.g == false) goto L22;
        int r13 = this.m;
        if (r0 > r13) goto L22;
        r0 = r13;
        r11 = 3;
        goto L22
    L12:
        if (r11 != 3) goto L15;
        r0 = getExpandedOffset();
        goto L22
    L15:
        if (this.a == true) goto L17;
    L19:
        boolean r14 = false;
    L20:
        if (r14 == false) goto L33;
        r0 = this.u;
        goto L22
    L33:
        throw new IllegalArgumentException(("Illegal state argument: " + r11).toString());
    L17:
        if (r11 != 5) goto L19;
        r14 = true;
        goto L20
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r11.isShown() == true) goto L5;
    L142:
        this.r = true;
        return false;
    L5:
        if (this.d.a(r12) == false) goto L8;
    L12:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L35;
        if (this.e.e() == true) goto L19;
    L32:
        boolean r1 = true;
    L33:
        if (r1 == true) goto L142;
    L19:
        if (this.e.a() == false) goto L32;
        if (this.p != 4) goto L27;
        if (this.e.c() == false) goto L27;
    L31:
        r1 = false;
    L27:
        if (this.p != 3) goto L32;
        if (this.e.d() == true) goto L31;
    L35:
        if (this.e.f(r12) == true) goto L142;
        int r13 = r12.getActionMasked();
        View r14 = null;
        if (r13 != 0) goto L43;
        this.z = -1;
        VelocityTracker r15 = this.y;
        if (r15 == null) goto L43;
        Intrinsics.checkNotNull(r15);
        r15.recycle();
        this.y = null;
    L43:
        if (this.y != null) goto L45;
        this.y = VelocityTracker.obtain();
    L45:
        VelocityTracker r16 = this.y;
        Intrinsics.checkNotNull(r16);
        r16.addMovement(r12);
        if (r13 == 0) goto L65;
        if (r13 == 1) goto L56;
        if (r13 == 2) goto L52;
        if (r13 == 3) goto L56;
    L89:
        if (this.r == true) goto L99;
        ViewDragHelper r17 = this.q;
        if (r17 == null) goto L99;
        if (r17.shouldInterceptTouchEvent(r12) != true) goto L95;
        boolean r18 = true;
    L96:
        if (r18 == false) goto L99;
    L115:
        return true;
    L95:
        r18 = false;
    L99:
        if (b() == true) goto L116;
        WeakReference<View> r19 = this.w;
        if (r19 == null) goto L103;
        Intrinsics.checkNotNull(r19);
        r14 = r19.get();
    L103:
        if (r13 != 2) goto L153;
        if (r14 != null) goto L106;
        return false;
    L106:
        if (this.r == false) goto L108;
        return false;
    L108:
        if (this.p != 1) goto L110;
        return false;
    L110:
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == false) goto L112;
        return false;
    L112:
        if (this.q == null) goto L158;
        float r110 = Math.abs(this.A - r12.getY());
        ViewDragHelper r111 = this.q;
        Intrinsics.checkNotNull(r111);
        if (r110 > r111.getTouchSlop()) goto L115;
        return false;
    L158:
        return false;
    L153:
        return false;
    L116:
        WeakReference<View> r112 = this.w;
        if (r112 == null) goto L119;
        Intrinsics.checkNotNull(r112);
        View r113 = r112.get();
    L120:
        WeakReference<ViewParent> r20 = this.x;
        if (r20 == null) goto L125;
        Intrinsics.checkNotNull(r20);
        ViewParent r21 = r20.get();
        if ((r21 instanceof ViewGroup) == false) goto L125;
        r14 = (ViewGroup) r21;
    L125:
        if (r13 == 2) goto L127;
        return false;
    L127:
        if (this.r == true) goto L145;
        float r22 = Math.abs(this.A - r12.getY());
        ViewDragHelper r23 = this.q;
        Intrinsics.checkNotNull(r23);
        if (r22 > r23.getTouchSlop()) goto L131;
        return false;
    L131:
        if (this.p != 1) goto L133;
        return false;
    L133:
        if (this.q == null) goto L148;
        if (r113 != null) goto L136;
        return false;
    L136:
        if (r10.isPointInChildBounds(r113, (int) r12.getX(), (int) r12.getY()) == true) goto L150;
        if (r14 != null) goto L139;
        return false;
    L139:
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == true) goto L152;
        return true;
    L152:
        return false;
    L150:
        return false;
    L148:
        return false;
    L145:
        return false;
    L119:
        r113 = null;
        goto L120
    L52:
        if (this.e.e() == false) goto L89;
        if (this.e.a() == false) goto L89;
        this.r = false;
    L56:
        this.B = false;
        this.C = false;
        this.z = -1;
        if (this.r == false) goto L61;
        this.r = false;
        return false;
    L61:
        if (this.e.e() == false) goto L89;
        if (this.e.a() == false) goto L89;
        this.r = false;
        goto L89
    L65:
        int r24 = (int) r12.getX();
        this.A = (int) r12.getY();
        WeakReference<View> r25 = this.w;
        if (r25 == null) goto L68;
        Intrinsics.checkNotNull(r25);
        View r26 = r25.get();
    L69:
        if (r26 != null) goto L71;
    L73:
        WeakReference<ViewParent> r27 = this.x;
        if (r27 == null) goto L76;
        Intrinsics.checkNotNull(r27);
        Object r28 = (ViewParent) r27.get();
    L77:
        if (r28 == null) goto L82;
        if (r10.isPointInChildBounds((View) r28, r24, this.A) == false) goto L82;
        this.z = r12.getPointerId(r12.getActionIndex());
        this.C = true;
    L82:
        if (this.z == (-1)) goto L84;
    L86:
        boolean r114 = false;
    L87:
        this.r = r114;
        goto L89
    L84:
        if (r10.isPointInChildBounds(r11, r24, this.A) == true) goto L86;
        r114 = true;
        goto L87
    L76:
        r28 = null;
        goto L77
    L71:
        if (r10.isPointInChildBounds(r26, r24, this.A) == false) goto L73;
        this.z = r12.getPointerId(r12.getActionIndex());
        this.B = true;
        goto L73
    L68:
        r26 = null;
        goto L69
    L8:
        if (this.d.disableDragDown() == false) goto L10;
    L13:
        r0 = true;
        goto L15
    L10:
        if (this.d.shouldInterceptSlide((int) r12.getY()) == true) goto L12;
        goto L12
    }

    public final boolean onLayoutChild(CoordinatorLayout r10, V r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L5;
    L7:
        int r0 = r11.getTop();
        r10.onLayoutChild(r11, r12);     // Catch: Exception -> L10
    L13:
        this.u = r10.getHeight();
        if (this.j == true) goto L16;
        this.l = this.i;
    L20:
        int r13 = Math.max(0, this.u - r11.getHeight());
        this.m = r13;
        int r14 = this.u;
        this.n = r14 / 2;
        if (this.g == false) goto L23;
        this.o = Math.max(r14 - this.l, r13);
    L24:
        int r15 = this.p;
        if (r15 != 3) goto L28;
        ViewCompat.offsetTopAndBottom(r11, getExpandedOffset());
    L42:
        if (this.q != null) goto L44;
        this.q = ViewDragHelper.create(r10, this.E);
    L44:
        this.v = new WeakReference(r11);
        this.w = new WeakReference(findScrollingChild(r11));
        if (b() == false) goto L60;
        WeakReference<View> r16 = this.w;
        Intrinsics.checkNotNull(r16);
        View r17 = r16.get();
        ViewParent r18 = null;
        if (r17 == null) goto L49;
        ViewParent r1 = r17.getParent();
    L50:
        View r19 = r17;
    L51:
        if (r1 == null) goto L59;
        Intrinsics.checkNotNull(r19);
        Intrinsics.checkNotNull(r17);
        if (ViewParentCompat.onStartNestedScroll(r1, r19, r17, 2) == true) goto L54;
        if ((r1 instanceof View) == false) goto L58;
        r19 = (View) r1;
    L58:
        r1 = r1.getParent();
        goto L51
    L54:
        r18 = r1;
    L59:
        this.x = new WeakReference(r18);
        goto L60
    L49:
        r1 = null;
    L60:
        return true;
    L28:
        if (r15 != 6) goto L31;
        ViewCompat.offsetTopAndBottom(r11, this.n);
        goto L42
    L31:
        if (this.a == false) goto L36;
        if (r15 != 5) goto L36;
        ViewCompat.offsetTopAndBottom(r11, this.u);
    L36:
        if (r15 != 4) goto L38;
        ViewCompat.offsetTopAndBottom(r11, this.o);
        goto L42
    L38:
        if (r15 == 1) goto L40;
        if (r15 != 2) goto L42;
    L40:
        ViewCompat.offsetTopAndBottom(r11, r0 - r11.getTop());
        goto L42
    L23:
        this.o = r14 - this.l;
        goto L24
    L16:
        if (this.k != 0) goto L18;
        this.k = r10.getResources().getDimensionPixelSize(2131165793);
    L18:
        this.l = Math.max(this.k, this.u - ((r10.getWidth() * 9) / 16));
    L62:
        a((ViewGroup) r10.findViewById(2131362991));     // Catch: Exception -> L61
    L12:
        com.bytedance.android.anniex.assemble.a.h();
        goto L13
    L5:
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L7;
        r11.setFitsSystemWindows(true);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(CoordinatorLayout r10, V r11, Parcelable r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "state");
        SavedState r13 = (SavedState) r12;
        if (r13.getSuperState() == null) goto L5;
        Parcelable r0 = r13.getSuperState();
        Intrinsics.checkNotNull(r0);
        super.onRestoreInstanceState(r10, r11, r0);
    L5:
        int r14 = r13.a;
        if (r14 != 1) goto L8;
    L10:
        this.p = 4;
        return;
    L8:
        if (r14 == 2) goto L10;
        this.p = r14;
    }

    public final boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r11.isShown() == false) goto L31;
        int r13 = r12.getActionMasked();
        if (this.p != 1) goto L9;
        if (r13 != 0) goto L9;
        return true;
    L9:
        ViewDragHelper r0 = this.q;
        if (r0 == null) goto L12;
        r0.processTouchEvent(r12);
    L12:
        if (r13 != 0) goto L17;
        this.z = -1;
        VelocityTracker r1 = this.y;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNull(r1);
        r1.recycle();
        this.y = null;
    L17:
        if (this.y != null) goto L19;
        this.y = VelocityTracker.obtain();
    L19:
        VelocityTracker r14 = this.y;
        Intrinsics.checkNotNull(r14);
        r14.addMovement(r12);
        ViewDragHelper r15 = this.q;
        if (r15 == null) goto L29;
        if (r13 != 2) goto L29;
        if (this.r == true) goto L29;
        if (Math.abs(this.A - r12.getY()) <= r15.getTouchSlop()) goto L29;
        r15.captureChildView(r11, r12.getPointerId(r12.getActionIndex()));
    L29:
        if (this.r == true) goto L31;
        return true;
    L31:
        return false;
    }

    public final void onStopNestedScroll(CoordinatorLayout r10, V r11, View r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        if (r11.getTop() == getExpandedOffset()) goto L5;
        WeakReference<View> r14 = this.w;
        Intrinsics.checkNotNull(r14);
        if (r12 == r14.get()) goto L13;
        return;
    L13:
        if (this.t == true) goto L15;
        return;
    L15:
        if (this.s <= 30) goto L19;
        int r15 = getExpandedOffset();
    L17:
        byte r16 = (byte) 3;
    L51:
        if (r16 != 5) goto L54;
        setStateInternal(r16);
        return;
    L54:
        ViewDragHelper r17 = this.q;
        if (r17 == null) goto L59;
        boolean r18 = r17.smoothSlideViewTo(r11, r11.getLeft(), r15);
        boolean r19 = true;
        if (r18 != true) goto L59;
    L60:
        if (r19 == false) goto L62;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r11, new b(this, r11, r16));
    L63:
        this.t = false;
        return;
    L62:
        setStateInternal(r16);
    L59:
        r19 = false;
        goto L60
    L19:
        if (this.a == false) goto L28;
        VelocityTracker r20 = this.y;
        if (r20 != null) goto L23;
        float r21 = 0.0f;
    L25:
        if (shouldHide(r11, r21) == false) goto L28;
        r15 = this.u;
        r16 = (byte) 5;
        goto L51
    L23:
        Intrinsics.checkNotNull(r20);
        r20.computeCurrentVelocity(IServerListener.WHAT_BYTELINK_SINK_ERROR, this.h);
        VelocityTracker r22 = this.y;
        Intrinsics.checkNotNull(r22);
        r21 = r22.getYVelocity(this.z);
    L28:
        if (this.c == false) goto L31;
        r15 = getExpandedOffset();
        goto L17
    L31:
        if (this.s != 0) goto L49;
        int r23 = r11.getTop();
        if (this.g == true) goto L35;
        int r24 = this.n;
        if (r23 >= r24) goto L45;
        if (r23 >= Math.abs(r23 - this.o)) goto L43;
        r16 = (byte) 3;
        r15 = 0;
        goto L51
    L43:
        r15 = this.n;
    L47:
        r16 = (byte) 6;
        goto L51
    L45:
        if (Math.abs(r23 - r24) >= Math.abs(r23 - this.o)) goto L48;
        r15 = this.n;
        goto L47
    L48:
        r15 = this.o;
    L50:
        r16 = (byte) 4;
        goto L51
    L35:
        if (Math.abs(r23 - this.m) >= Math.abs(r23 - this.o)) goto L37;
        r15 = this.m;
        goto L17
    L37:
        r15 = this.o;
        goto L50
    L49:
        r15 = this.o;
        goto L50
    L5:
        if (b() == true) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (this.t == false) goto L65;
        setStateInternal(3);
        return;
    }

    public final boolean onNestedPreFling(CoordinatorLayout r10, V r11, View r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        WeakReference<View> r0 = this.w;
        Intrinsics.checkNotNull(r0);
        if (r12 == r0.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.p == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == false) goto L9;
        goto L8
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, V r10, View r11, View r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "directTargetChild");
        Intrinsics.checkNotNullParameter(r12, "target");
        this.s = 0;
        this.t = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r10, V r11, View r12, int r13, int r14, int[] r15, int r16) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r15, "consumed");
        if (r16 == 1) goto L32;
        WeakReference<View> r17 = this.w;
        Intrinsics.checkNotNull(r17);
        if (r12 != r17.get()) goto L33;
        int r18 = r11.getTop();
        int r19 = r18 - r14;
        if (r14 > 0) goto L9;
        if (r14 < 0) goto L14;
    L23:
        dispatchOnSlide(r11.getTop());
        this.s = r14;
        this.t = true;
        if (b() == true) goto L26;
        return;
    L26:
        if (this.p != 3) goto L35;
        if (r14 < 0) goto L29;
        return;
    L29:
        if (r15[1] != 0) goto L37;
        this.t = false;
        return;
    L37:
        return;
    L35:
        return;
    L14:
        if (r12.canScrollVertically(-1) == true) goto L23;
        if (this.d.disableDragDown() == true) goto L23;
        int r20 = this.o;
        if (r19 > r20) goto L20;
    L22:
        r15[1] = r14;
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L23
    L20:
        if (this.a == true) goto L22;
        int r21 = r18 - r20;
        r15[1] = r21;
        ViewCompat.offsetTopAndBottom(r11, -r21);
        setStateInternal(4);
        goto L23
    L9:
        if (r19 >= getExpandedOffset()) goto L11;
        int r22 = r18 - getExpandedOffset();
        r15[1] = r22;
        ViewCompat.offsetTopAndBottom(r11, -r22);
        setStateInternal(3);
        goto L23
    L11:
        r15[1] = r14;
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L23
    L33:
        return;
    }
}
