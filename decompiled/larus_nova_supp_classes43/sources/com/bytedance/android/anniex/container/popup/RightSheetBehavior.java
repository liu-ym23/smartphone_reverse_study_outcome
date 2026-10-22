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
import androidx.customview.widget.ViewDragHelper;
import com.byted.cast.sink.api.IServerListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/RightSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class RightSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public Map<View, Integer> A;
    public final RightSheetBehavior$dragCallback$1 B;
    public boolean g;
    public final float h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public ViewDragHelper p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;
    public WeakReference<V> u;
    public WeakReference<View> v;
    public VelocityTracker w;
    public int x;
    public int y;
    public boolean z;

    public final class a implements Runnable {
        public final View a;
        public final int b;
        public final /* synthetic */ RightSheetBehavior<V> c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r0 = this.c.p;     // Catch: Throwable -> L12
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

        public a(RightSheetBehavior r10, View r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "view");
            this.c = r10;
            this.a = r11;
            this.b = r12;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RightSheetBehavior<V> a;
        public final /* synthetic */ V b;
        public final /* synthetic */ int c;

        public b(RightSheetBehavior<V> r1, V r10, int r11) {
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

    public final int getExpandedOffset() {
        if (this.g == true) goto L7;
        return 0;
    L7:
        return this.l;
    }

    public final void dispatchOnSlide(int r10) {
        WeakReference<V> r0 = this.u;
        Intrinsics.checkNotNull(r0);
        V r1 = r0.get();
        if (r1 == null) goto L11;
        SheetBaseBehavior.b r11 = this.b;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r10 <= this.n) goto L9;
        Intrinsics.checkNotNull(r11);
        int r12 = this.n;
        r11.b(r1, (r12 - r10) / (this.t - r12));
        return;
    L9:
        Intrinsics.checkNotNull(r11);
        int r13 = this.n;
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
        if (this.o != 4) goto L25;
        WeakReference<V> r11 = this.u;
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
        this.n = this.t - r10;
        goto L14
    L10:
        if (this.i == r10) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior
    public final void setState(int r10) {
        if (r10 == this.o) goto L28;
        WeakReference<V> r0 = this.u;
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
        r1.post(new b(this, r1, r10));
        return;
    L32:
        return;
    L7:
        if (r10 != 4) goto L9;
    L16:
        this.o = r10;
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
        if (this.o == r10) goto L21;
        this.o = r10;
        if (r10 != 6) goto L7;
    L14:
        updateImportantForAccessibility(true);
    L15:
        WeakReference<V> r0 = this.u;
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
        WeakReference<V> r0 = this.u;
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
        WeakReference<V> r16 = this.u;
        if (r16 == null) goto L21;
        V r17 = r16.get();
    L22:
        if (r15 == r17) goto L30;
        if (r10 == true) goto L29;
        Map<View, Integer> r18 = this.A;
        if (r18 == null) goto L30;
        Intrinsics.checkNotNull(r18);
        if (r18.containsKey(r15) == false) goto L30;
        Map<View, Integer> r19 = this.A;
        Intrinsics.checkNotNull(r19);
        Integer r20 = r19.get(r15);
        Intrinsics.checkNotNull(r20);
        ViewCompat.setImportantForAccessibility(r15, r20.intValue());
        goto L30
    L29:
        Map<View, Integer> r21 = this.A;
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
        this.A = null;
        return;
    L42:
        return;
    L13:
        if (this.A == null) goto L15;
        return;
    L15:
        this.A = new HashMap(r13);
        goto L16
    L41:
        return;
    L7:
        r1 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.anniex.container.popup.RightSheetBehavior$dragCallback$1] */
    public RightSheetBehavior(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.g = true;
        this.o = 4;
        this.B = new RightSheetBehavior$dragCallback$1(this);
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
        if (this.u == null) goto L14;
        this.n = Math.max(this.t - this.k, this.l);
    L14:
        if (this.g == true) goto L16;
    L18:
        int r0 = this.o;
    L19:
        setStateInternal(r0);
        goto L20
    L16:
        if (this.o != 6) goto L18;
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
        return new SavedState(r12, this.o);
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
        if (((this.t - (r10.getLeft() + r12)) / r10.getWidth()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r10.getLeft() < this.n) goto L15;
        if ((Math.abs((r10.getLeft() + (r11 * 0.1f)) - this.n) / this.i) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "child");
        boolean r1 = true;
        if (r11 != 4) goto L6;
        int r0 = this.n;
    L22:
        ViewDragHelper r12 = this.p;
        if (r12 != null) goto L25;
    L27:
        r1 = false;
    L28:
        if (r1 == false) goto L30;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new a(this, r10, r11));
        return;
    L30:
        setStateInternal(r11);
        return;
    L25:
        if (r12.smoothSlideViewTo(r10, r0, r10.getTop()) != true) goto L27;
    L6:
        if (r11 != 6) goto L12;
        r0 = this.m;
        if (this.g == false) goto L22;
        int r13 = this.l;
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
        r0 = this.t;
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
    L101:
        this.q = true;
    L102:
        return false;
    L5:
        if (this.d.disableDragDown() == false) goto L7;
    L10:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
    L32:
        int r1 = r12.getActionMasked();
        View r13 = null;
        if (r1 != 0) goto L38;
        this.x = -1;
        VelocityTracker r14 = this.w;
        if (r14 == null) goto L38;
        Intrinsics.checkNotNull(r14);
        r14.recycle();
        this.w = null;
    L38:
        if (this.w != null) goto L40;
        this.w = VelocityTracker.obtain();
    L40:
        VelocityTracker r15 = this.w;
        Intrinsics.checkNotNull(r15);
        r15.addMovement(r12);
        if (r1 == 0) goto L60;
        if (r1 == 1) goto L51;
        if (r1 == 2) goto L47;
        if (r1 == 3) goto L51;
    L76:
        if (this.q == true) goto L85;
        ViewDragHelper r16 = this.p;
        if (r16 == null) goto L85;
        if (r16.shouldInterceptTouchEvent(r12) != true) goto L82;
        boolean r17 = true;
    L83:
        if (r17 == false) goto L85;
        return true;
    L82:
        r17 = false;
    L85:
        WeakReference<View> r18 = this.v;
        if (r18 == null) goto L88;
        Intrinsics.checkNotNull(r18);
        r13 = r18.get();
    L88:
        if (r1 != 2) goto L102;
        if (r13 == null) goto L102;
        if (this.q == true) goto L102;
        if (this.o == 1) goto L102;
        if (r10.isPointInChildBounds(r13, (int) r12.getX(), (int) r12.getY()) == true) goto L102;
        if (this.p == null) goto L102;
        float r19 = Math.abs(this.y - r12.getX());
        ViewDragHelper r110 = this.p;
        Intrinsics.checkNotNull(r110);
        if (r19 <= r110.getTouchSlop()) goto L102;
        return true;
    L47:
        if (this.e.e() == false) goto L76;
        if (this.e.a() == false) goto L76;
        this.q = false;
    L51:
        this.z = false;
        this.x = -1;
        if (this.q == false) goto L56;
        this.q = false;
        return false;
    L56:
        if (this.e.e() == false) goto L76;
        if (this.e.a() == false) goto L76;
        this.q = false;
        goto L76
    L60:
        this.y = (int) r12.getX();
        int r20 = (int) r12.getY();
        WeakReference<View> r21 = this.v;
        if (r21 == null) goto L63;
        Intrinsics.checkNotNull(r21);
        View r22 = r21.get();
    L64:
        if (r22 == null) goto L69;
        if (r10.isPointInChildBounds(r22, this.y, r20) == false) goto L69;
        this.x = r12.getPointerId(r12.getActionIndex());
        this.z = true;
    L69:
        if (this.x == (-1)) goto L71;
    L73:
        boolean r111 = false;
    L74:
        this.q = r111;
        goto L76
    L71:
        if (r10.isPointInChildBounds(r11, this.y, r20) == true) goto L73;
        r111 = true;
        goto L74
    L63:
        r22 = null;
        goto L64
    L14:
        if (this.e.e() == true) goto L16;
    L29:
        boolean r23 = true;
    L30:
        if (r23 == false) goto L32;
    L16:
        if (this.e.a() == false) goto L29;
        if (this.o != 4) goto L24;
        if (this.e.c() == false) goto L24;
    L28:
        r23 = false;
    L24:
        if (this.o != 3) goto L29;
        if (this.e.d() == true) goto L28;
    L7:
        if (this.d.shouldInterceptSlide((int) r12.getY()) == false) goto L10;
        r0 = false;
        goto L12
    }

    public final boolean onLayoutChild(CoordinatorLayout r10, V r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L5;
    L7:
        r11.getLeft();
        r10.onLayoutChild(r11, r12);     // Catch: Exception -> L10
    L13:
        int r13 = r10.getWidth();
        this.t = r13;
        if (this.j == false) goto L16;
        this.k = (r13 * 9) / 16;
    L17:
        int r14 = RangesKt.coerceAtLeast(0, r13 - r11.getWidth());
        this.l = r14;
        int r0 = this.t;
        this.m = r0 / 2;
        if (this.g == false) goto L20;
        this.n = Math.max(r0 - this.k, r14);
    L22:
        if (this.p != null) goto L24;
        this.p = ViewDragHelper.create(r10, this.B);
    L24:
        this.u = new WeakReference(r11);
        this.v = new WeakReference(findScrollingChild(r11));
        return true;
    L20:
        this.n = r0 - this.k;
        goto L22
    L16:
        this.k = this.i;
    L27:
        a((ViewGroup) r10.findViewById(2131362991));     // Catch: Exception -> L26
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
        this.o = 4;
        return;
    L8:
        if (r14 == 2) goto L10;
        this.o = r14;
    }

    public final boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r11.isShown() == false) goto L31;
        int r13 = r12.getActionMasked();
        if (this.o != 1) goto L9;
        if (r13 != 0) goto L9;
        return true;
    L9:
        ViewDragHelper r0 = this.p;
        if (r0 == null) goto L12;
        r0.processTouchEvent(r12);
    L12:
        if (r13 != 0) goto L17;
        this.x = -1;
        VelocityTracker r1 = this.w;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNull(r1);
        r1.recycle();
        this.w = null;
    L17:
        if (this.w != null) goto L19;
        this.w = VelocityTracker.obtain();
    L19:
        VelocityTracker r14 = this.w;
        Intrinsics.checkNotNull(r14);
        r14.addMovement(r12);
        ViewDragHelper r15 = this.p;
        if (r15 == null) goto L29;
        if (r13 != 2) goto L29;
        if (this.q == true) goto L29;
        if (Math.abs(this.y - r12.getX()) <= r15.getTouchSlop()) goto L29;
        r15.captureChildView(r11, r12.getPointerId(r12.getActionIndex()));
    L29:
        if (this.q == true) goto L31;
        return true;
    L31:
        return false;
    }

    public final void onStopNestedScroll(CoordinatorLayout r10, V r11, View r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        if (r11.getLeft() != getExpandedOffset()) goto L5;
        setStateInternal(3);
        return;
    L5:
        WeakReference<View> r14 = this.v;
        Intrinsics.checkNotNull(r14);
        if (r12 == r14.get()) goto L8;
        return;
    L8:
        if (this.s == true) goto L10;
        return;
    L10:
        if (this.r <= 30) goto L14;
        int r15 = getExpandedOffset();
    L12:
        byte r16 = (byte) 3;
    L46:
        if (r16 != 5) goto L49;
        setStateInternal(r16);
        return;
    L49:
        ViewDragHelper r17 = this.p;
        if (r17 == null) goto L54;
        boolean r18 = r17.smoothSlideViewTo(r11, r15, r11.getTop());
        boolean r19 = true;
        if (r18 != true) goto L54;
    L55:
        if (r19 == false) goto L57;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r11, new a(this, r11, r16));
    L58:
        this.s = false;
        return;
    L57:
        setStateInternal(r16);
    L54:
        r19 = false;
        goto L55
    L14:
        if (this.a == false) goto L23;
        VelocityTracker r20 = this.w;
        if (r20 != null) goto L18;
        float r21 = 0.0f;
    L20:
        if (shouldHide(r11, r21) == false) goto L23;
        r15 = this.t;
        r16 = (byte) 5;
        goto L46
    L18:
        Intrinsics.checkNotNull(r20);
        r20.computeCurrentVelocity(IServerListener.WHAT_BYTELINK_SINK_ERROR, this.h);
        VelocityTracker r22 = this.w;
        Intrinsics.checkNotNull(r22);
        r21 = r22.getYVelocity(this.x);
    L23:
        if (this.c == false) goto L26;
        r15 = getExpandedOffset();
        goto L12
    L26:
        if (this.r != 0) goto L44;
        int r23 = r11.getTop();
        if (this.g == true) goto L30;
        int r24 = this.m;
        if (r23 >= r24) goto L40;
        if (r23 >= Math.abs(r23 - this.n)) goto L38;
        r16 = (byte) 3;
        r15 = 0;
        goto L46
    L38:
        r15 = this.m;
    L42:
        r16 = (byte) 6;
        goto L46
    L40:
        if (Math.abs(r23 - r24) >= Math.abs(r23 - this.n)) goto L43;
        r15 = this.m;
        goto L42
    L43:
        r15 = this.n;
    L45:
        r16 = (byte) 4;
        goto L46
    L30:
        if (Math.abs(r23 - this.l) >= Math.abs(r23 - this.n)) goto L32;
        r15 = this.l;
        goto L12
    L32:
        r15 = this.n;
        goto L45
    L44:
        r15 = this.n;
        goto L45
    }

    public final boolean onNestedPreFling(CoordinatorLayout r10, V r11, View r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        WeakReference<View> r0 = this.v;
        Intrinsics.checkNotNull(r0);
        if (r12 == r0.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.o == 3) goto L7;
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
        this.r = 0;
        this.s = false;
        if ((r13 & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r10, V r11, View r12, int r13, int r14, int[] r15, int r16) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r15, "consumed");
        if (r16 == 1) goto L25;
        WeakReference<View> r17 = this.v;
        Intrinsics.checkNotNull(r17);
        if (r12 != r17.get()) goto L26;
        int r18 = r11.getLeft();
        int r19 = r18 - r13;
        if (r13 > 0) goto L9;
        if (r13 < 0) goto L14;
    L23:
        dispatchOnSlide(r11.getLeft());
        this.r = r13;
        this.s = true;
        return;
    L14:
        if (r12.canScrollHorizontally(-1) == true) goto L23;
        if (this.d.disableDragDown() == true) goto L23;
        int r20 = this.n;
        if (r19 > r20) goto L20;
    L22:
        r15[0] = r13;
        ViewCompat.offsetLeftAndRight(r11, -r13);
        setStateInternal(1);
        goto L23
    L20:
        if (this.a == true) goto L22;
        int r21 = r18 - r20;
        r15[0] = r21;
        ViewCompat.offsetLeftAndRight(r11, -r21);
        setStateInternal(4);
        goto L23
    L9:
        if (r19 >= getExpandedOffset()) goto L11;
        int r22 = r18 - getExpandedOffset();
        r15[0] = r22;
        ViewCompat.offsetLeftAndRight(r11, -r22);
        setStateInternal(3);
        goto L23
    L11:
        r15[0] = r13;
        ViewCompat.offsetLeftAndRight(r11, -r13);
        setStateInternal(1);
        goto L23
    L26:
        return;
    }
}
