package com.obric.oui.panel;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
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
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.lynx.tasm.ui.image.f0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public boolean A;
    public HashMap B;
    public boolean C;
    public boolean D;
    public final int E;
    public final b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13955c;
    public int d;
    public boolean e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f13961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j f13964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13966r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WeakReference f13968u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference f13969v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f13970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f13971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13972y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13973z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13974a;

        static {
            CREATOR = new d();
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.f13974a = r5.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.f13974a);
        }

        public SavedState(Parcelable r5, int r10) {
            super(r5);
            this.f13974a = r10;
        }
    }

    public BottomSheetBehavior() {
        this.f13953a = true;
        this.f13954b = -1;
        this.f13960l = true;
        this.f13961m = false;
        this.f13962n = 4;
        this.f13963o = 4;
        this.f13970w = new ArrayList();
        this.C = true;
        this.D = true;
        this.E = 600;
        this.F = new b(this);
        new c(this);
    }

    public final int a() {
        if (this.f13953a == true) goto L7;
        return 0;
    L7:
        return this.f13956h;
    }

    public final void b(int r5, View r10) {
        if (r5 != 4) goto L6;
        int r11 = this.f13958j;
    L19:
        j r12 = this.f13964p;
        int r13 = r10.getLeft();
        r12.f14024r = r10;
        r12.f14013c = -1;
        boolean r14 = r12.f(r13, r11, 0, 0);
        if (r14 == false) goto L22;
    L26:
        if (r14 == false) goto L28;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new a(this, r10, r5, 1));
        return;
    L28:
        setStateInternal(r5);
        return;
    L22:
        if (r12.f14011a != 0) goto L26;
        if (r12.f14024r == null) goto L26;
        r12.f14024r = null;
        goto L26
    L6:
        if (r5 != 6) goto L12;
        r11 = this.f13957i;
        if (this.f13953a == false) goto L19;
        int r15 = this.f13956h;
        if (r11 > r15) goto L19;
        r5 = 3;
        r11 = r15;
        goto L19
    L12:
        if (r5 != 3) goto L15;
        r11 = a();
        goto L19
    L15:
        if (this.f13959k == false) goto L31;
        if (r5 != 5) goto L31;
        r11 = this.f13967t;
    L31:
        throw new IllegalArgumentException(j0.g(r5, "Illegal state argument: "));
    }

    public void calculateCollapsedOffset() {
        if (this.f13953a == false) goto L5;
        this.f13958j = Math.max(this.f13967t - this.g, this.f13956h);
        return;
    L5:
        this.f13958j = this.f13967t - this.g;
    }

    public final void dispatchOnSlide(int r10) {
        View r5 = (View) this.f13968u.get();
        if (r5 == null) goto L14;
        ArrayList r11 = this.f13970w;
        if (r11.isEmpty() == true) goto L17;
        int r12 = 0;
        if (r10 <= this.f13958j) goto L12;
    L9:
        if (r12 >= r11.size()) goto L18;
        g r13 = (g) r11.get(r12);
        int r14 = this.f13958j;
        r13.a(r5, (r14 - r10) / (this.f13967t - r14));
        r12 = r12 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r12 >= r11.size()) goto L19;
        g r15 = (g) r11.get(r12);
        int r16 = this.f13958j;
        r15.a(r5, (r16 - r10) / (r16 - a()));
        r12 = r12 + 1;
        goto L12
    L19:
        return;
    L17:
        return;
    }

    public final View findScrollingChild(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L16;
        View r13 = findScrollingChild(r10.getChildAt(r12));
        if (r13 != null) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        return r13;
    L16:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r18, View r19, MotionEvent r20) {
        boolean r5 = false;
        boolean r10 = true;
        if (r19.isShown() == false) goto L130;
        if (this.f13960l == false) goto L130;
        int r11 = r20.getActionMasked();
        if (r11 != 0) goto L13;
        this.f13972y = -1;
        VelocityTracker r12 = this.f13971x;
        if (r12 == null) goto L13;
        r12.recycle();
        this.f13971x = null;
    L13:
        if (this.f13971x != null) goto L15;
        this.f13971x = VelocityTracker.obtain();
    L15:
        this.f13971x.addMovement(r20);
        if (r11 == 0) goto L24;
        if (r11 == 1) goto L20;
        if (r11 == 3) goto L20;
    L40:
        if (this.f13965q == true) goto L110;
        j r13 = this.f13964p;
        if (r13 == null) goto L110;
        int r14 = r20.getActionMasked();
        int r15 = r20.getActionIndex();
        if (r14 != 0) goto L47;
        r13.a();
    L47:
        if (r13.f14018l != null) goto L49;
        r13.f14018l = VelocityTracker.obtain();
    L49:
        r13.f14018l.addMovement(r20);
        if (r14 == 0) goto L101;
        if (r14 == 1) goto L100;
        if (r14 == 2) goto L68;
        if (r14 == 3) goto L100;
        if (r14 != 5) goto L57;
        int r16 = r20.getPointerId(r15);
        float r17 = r20.getX(r15);
        float r110 = r20.getY(r15);
        r13.i(r17, r110, r16);
        int r111 = r13.f14011a;
        if (r111 != 0) goto L63;
        int r21 = r13.f14014h[r16];
    L108:
        if (r13.f14011a != 1) goto L110;
        return true;
    L63:
        if (r111 != 2) goto L108;
        View r112 = r13.e((int) r17, (int) r110);
        if (r112 != r13.f14024r) goto L108;
        r13.l(r112, r16);
        goto L108
    L57:
        if (r14 != 6) goto L108;
        r13.c(r20.getPointerId(r15));
        goto L108
    L68:
        if (r13.d == null) goto L108;
        if (r13.e == null) goto L108;
        int r22 = r20.getPointerCount();
        int r113 = 0;
    L73:
        if (r113 >= r22) goto L99;
        int r114 = r20.getPointerId(r113);
        if (r13.g(r114) == false) goto L98;
        float r115 = r20.getX(r113);
        float r116 = r20.getY(r113);
        float r117 = r115 - r13.d[r114];
        float r118 = r116 - r13.e[r114];
        View r119 = r13.e((int) r115, (int) r116);
        b r120 = r13.f14023q;
        if (r119 == null) goto L84;
        r120.getClass();
        if (r120.o(r119) <= 0) goto L84;
        if (Math.abs(r118) <= r13.f14012b) goto L84;
        boolean r23 = r10;
    L85:
        if (r23 == false) goto L91;
        r119.getLeft();
        r120.getClass();
        r119.getLeft();
        int r24 = r119.getTop();
        int r25 = (int) r118;
        int r26 = r120.n(r119, r24 + r25, r25);
        int r27 = r120.o(r119);
        if (r27 == 0) goto L99;
        if (r27 <= 0) goto L91;
        if (r26 == r24) goto L99;
    L91:
        Math.abs(r117);
        Math.abs(r118);
        int r28 = r13.f14014h[r114];
        Math.abs(r118);
        Math.abs(r117);
        int r29 = r13.f14014h[r114];
        Math.abs(r117);
        Math.abs(r118);
        int r30 = r13.f14014h[r114];
        Math.abs(r118);
        Math.abs(r117);
        int r31 = r13.f14014h[r114];
        if (r13.f14011a == 1) goto L99;
        if (r23 == false) goto L98;
        if (r13.l(r119, r114) == false) goto L98;
    L84:
        r23 = r5;
    L98:
        r113 = r113 + 1;
        r5 = false;
        r10 = true;
    L99:
        r13.j(r20);
    L100:
        r13.a();
        goto L108
    L101:
        float r32 = r20.getX();
        float r33 = r20.getY();
        int r34 = r20.getPointerId(0);
        r13.i(r32, r33, r34);
        View r35 = r13.e((int) r32, (int) r33);
        if (r35 == r13.f14024r) goto L104;
    L106:
        int r36 = r13.f14014h[r34];
        goto L108
    L104:
        if (r13.f14011a != 2) goto L106;
        r13.l(r35, r34);
    L110:
        WeakReference r37 = this.f13969v;
        if (r37 == null) goto L113;
        View r38 = (View) r37.get();
        int r39 = 2;
    L114:
        if (r11 != r39) goto L128;
        if (r38 == null) goto L128;
        if (this.f13965q == true) goto L128;
        if (this.f13962n == 1) goto L128;
        if (r18.isPointInChildBounds(r38, (int) r20.getX(), (int) r20.getY()) == true) goto L128;
        if (this.f13964p == null) goto L128;
        if (Math.abs(this.f13973z - r20.getY()) <= this.f13964p.f14012b) goto L128;
        return true;
    L128:
        return false;
    L113:
        r39 = 2;
        r38 = null;
    L20:
        this.A = false;
        this.f13972y = -1;
        if (this.f13965q == false) goto L40;
        this.f13965q = false;
        return false;
    L24:
        int r40 = (int) r20.getX();
        this.f13973z = (int) r20.getY();
        WeakReference r121 = this.f13969v;
        if (r121 == null) goto L27;
        View r122 = (View) r121.get();
    L28:
        if (r122 == null) goto L33;
        if (r18.isPointInChildBounds(r122, r40, this.f13973z) == false) goto L33;
        this.f13972y = r20.getPointerId(r20.getActionIndex());
        this.A = true;
    L33:
        if (this.f13972y == (-1)) goto L35;
    L37:
        boolean r41 = false;
    L38:
        this.f13965q = r41;
        goto L40
    L35:
        if (r18.isPointInChildBounds(r19, r40, this.f13973z) == true) goto L37;
        r41 = true;
        goto L38
    L27:
        r122 = null;
    L130:
        this.f13965q = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        if (this.C == true) goto L5;
    L9:
        int r5 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.f13967t = r10.getHeight();
        if (this.e == true) goto L12;
        this.g = this.d;
    L25:
        if (this.f13954b <= 0) goto L29;
        int r13 = r11.getHeight();
        int r14 = this.f13954b;
        if (r13 <= r14) goto L29;
        this.f13956h = Math.max(0, this.f13967t - r14);
    L30:
        this.f13957i = this.f13967t / 2;
        calculateCollapsedOffset();
        int r15 = this.f13962n;
        if (r15 != 3) goto L34;
        ViewCompat.offsetTopAndBottom(r11, a());
    L48:
        if (this.f13964p != null) goto L50;
        j r16 = new j(r10.getContext(), r10, this.F);
        this.f13964p = r16;
        r16.f14026u = this.E;
    L50:
        this.f13968u = new WeakReference(r11);
        this.f13969v = new WeakReference(findScrollingChild(r11));
        return true;
    L34:
        if (r15 != 6) goto L37;
        ViewCompat.offsetTopAndBottom(r11, this.f13957i);
        goto L48
    L37:
        if (this.f13959k == false) goto L42;
        if (r15 != 5) goto L42;
        ViewCompat.offsetTopAndBottom(r11, this.f13967t);
    L42:
        if (r15 != 4) goto L44;
        ViewCompat.offsetTopAndBottom(r11, this.f13958j);
        goto L48
    L44:
        if (r15 == 1) goto L46;
        if (r15 != 2) goto L48;
    L46:
        ViewCompat.offsetTopAndBottom(r11, r5 - r11.getTop());
    L29:
        this.f13956h = Math.max(0, this.f13967t - r11.getHeight());
        goto L30
    L12:
        if (this.f != 0) goto L14;
        this.f = r10.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r17 = r10.getContext().getResources().getConfiguration().fontScale;
        f0.r("check fontScale:" + r17);
        if (this.D == false) goto L17;
        double r18 = 0.6d;
    L18:
        double r19 = this.f;
        int r20 = this.f13954b;
        if (r20 <= 0) goto L21;
        double r21 = r20;
    L22:
        this.g = (int) Math.max(r19, r21);
        goto L25
    L21:
        r21 = ((double) r17) * (((double) this.f13967t) * r18);
        goto L22
    L17:
        r18 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r5, View r10, View r11, float r12, float r13) {
        if (r11 == this.f13969v.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f13962n == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r5, r10, r11, r12, r13) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r5, View r10, View r11, int r12, int r13, int[] r14, int r15) {
        if (r15 != 1) goto L6;
        return;
    L6:
        if (r11 == ((View) this.f13969v.get())) goto L8;
        return;
    L8:
        int r16 = r10.getTop();
        int r17 = r16 - r13;
        if (r13 > 0) goto L11;
        if (r13 < 0) goto L19;
    L30:
        dispatchOnSlide(r10.getTop());
        this.f13966r = r13;
        this.s = true;
        return;
    L19:
        if (r11.canScrollVertically(-1) == true) goto L30;
        int r18 = this.f13958j;
        if (r17 <= r18) goto L27;
        if (this.f13959k == true) goto L27;
        int r19 = r16 - r18;
        r14[1] = r19;
        ViewCompat.offsetTopAndBottom(r10, -r19);
        setStateInternal(4);
    L27:
        if (this.f13960l == true) goto L29;
        return;
    L29:
        r14[1] = r13;
        ViewCompat.offsetTopAndBottom(r10, -r13);
        setStateInternal(1);
        goto L30
    L11:
        if (r17 >= a()) goto L14;
        int r20 = r16 - a();
        r14[1] = r20;
        ViewCompat.offsetTopAndBottom(r10, -r20);
        setStateInternal(3);
        goto L30
    L14:
        if (this.f13960l == true) goto L16;
        return;
    L16:
        r14[1] = r13;
        ViewCompat.offsetTopAndBottom(r10, -r13);
        setStateInternal(1);
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r5, View r10, Parcelable r11) {
        SavedState r12 = (SavedState) r11;
        super.onRestoreInstanceState(r5, r10, r12.getSuperState());
        int r13 = r12.f13974a;
        if (r13 != 1) goto L5;
    L8:
        this.f13962n = 4;
        return;
    L5:
        if (r13 == 2) goto L8;
        this.f13962n = r13;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r5, View r10) {
        return new SavedState(super.onSaveInstanceState(r5, r10), this.f13962n);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r5, View r10, View r11, View r12, int r13, int r14) {
        this.f13966r = 0;
        this.s = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r5, View r10, View r11, int r12) {
        int r13 = 3;
        if (r10.getTop() != a()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r11 == this.f13969v.get()) goto L9;
        return;
    L9:
        if (this.s == true) goto L12;
        return;
    L12:
        if (this.f13966r <= 0) goto L15;
        int r14 = a();
    L44:
        this.f13963o = r13;
        j r15 = this.f13964p;
        int r16 = r10.getLeft();
        r15.f14024r = r10;
        r15.f14013c = -1;
        boolean r17 = r15.f(r16, r14, 0, 0);
        if (r17 == false) goto L47;
    L51:
        if (r17 == false) goto L53;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new a(this, r10, r13, 1));
    L54:
        this.s = false;
        return;
    L53:
        setStateInternal(r13);
        goto L54
    L47:
        if (r15.f14011a != 0) goto L51;
        if (r15.f14024r == null) goto L51;
        r15.f14024r = null;
        goto L51
    L15:
        if (this.f13959k == false) goto L24;
        VelocityTracker r18 = this.f13971x;
        if (r18 != null) goto L19;
        float r19 = 0.0f;
    L21:
        if (shouldHide(r10, r19) == false) goto L24;
        r14 = this.f13967t;
        r13 = 5;
        goto L44
    L19:
        r18.computeCurrentVelocity(1000, this.f13955c);
        r19 = this.f13971x.getYVelocity(this.f13972y);
    L24:
        if (this.f13966r != 0) goto L42;
        int r20 = r10.getTop();
        if (this.f13953a == true) goto L28;
        int r21 = this.f13957i;
        if (r20 >= r21) goto L39;
        if (r20 >= Math.abs(r20 - this.f13958j)) goto L36;
        r14 = 0;
        goto L44
    L36:
        r14 = this.f13957i;
    L37:
        r13 = 6;
        goto L44
    L39:
        if (Math.abs(r20 - r21) >= Math.abs(r20 - this.f13958j)) goto L41;
        r14 = this.f13957i;
        goto L37
    L41:
        r14 = this.f13958j;
    L43:
        r13 = 4;
        goto L44
    L28:
        if (Math.abs(r20 - this.f13956h) >= Math.abs(r20 - this.f13958j)) goto L30;
        r14 = this.f13956h;
        goto L44
    L30:
        r14 = this.f13958j;
        goto L43
    L42:
        r14 = this.f13958j;
        goto L43
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r22, View r23, MotionEvent r24) {
        int r5 = 0;
        if (r23.isShown() == true) goto L5;
        return false;
    L5:
        int r10 = r24.getActionMasked();
        if (this.f13962n != 1) goto L10;
        if (r10 != 0) goto L10;
        return true;
    L10:
        if (r10 != 0) goto L15;
        this.f13972y = -1;
        VelocityTracker r11 = this.f13971x;
        if (r11 == null) goto L15;
        r11.recycle();
        this.f13971x = null;
    L15:
        if (this.f13971x != null) goto L17;
        this.f13971x = VelocityTracker.obtain();
    L17:
        this.f13971x.addMovement(r24);
        j r12 = this.f13964p;
        if (r12 == null) goto L122;
        int r13 = r24.getActionMasked();
        int r14 = r24.getActionIndex();
        if (r13 != 0) goto L23;
        r12.a();
    L23:
        if (r12.f14018l != null) goto L25;
        r12.f14018l = VelocityTracker.obtain();
    L25:
        r12.f14018l.addMovement(r24);
        if (r13 == 0) goto L121;
        if (r13 == 1) goto L118;
        b r15 = r12.f14023q;
        if (r13 == 2) goto L80;
        if (r13 == 3) goto L74;
        if (r13 != 5) goto L35;
        int r16 = r24.getPointerId(r14);
        float r17 = r24.getX(r14);
        float r18 = r24.getY(r14);
        r12.i(r17, r18, r16);
        if (r12.f14011a != 0) goto L59;
        r12.l(r12.e((int) r17, (int) r18), r16);
        int r19 = r12.f14014h[r16];
        goto L122
    L59:
        int r20 = (int) r17;
        int r21 = (int) r18;
        View r110 = r12.f14024r;
        if (r110 != null) goto L63;
    L71:
        if (r5 == 0) goto L122;
        r12.l(r12.f14024r, r16);
        goto L122
    L63:
        if (r20 < r110.getLeft()) goto L71;
        if (r20 >= r110.getRight()) goto L71;
        if (r21 < r110.getTop()) goto L71;
        if (r21 >= r110.getBottom()) goto L71;
        r5 = 1;
        goto L71
    L35:
        if (r13 != 6) goto L122;
        int r25 = r24.getPointerId(r14);
        if (r12.f14011a == 1) goto L40;
    L55:
        r12.c(r25);
        goto L122
    L40:
        if (r25 != r12.f14013c) goto L55;
        int r26 = r24.getPointerCount();
    L42:
        if (r5 >= r26) goto L52;
        int r111 = r24.getPointerId(r5);
        if (r111 == r12.f14013c) goto L51;
        View r112 = r12.e((int) r24.getX(r5), (int) r24.getY(r5));
        View r113 = r12.f14024r;
        if (r112 != r113) goto L51;
        if (r12.l(r113, r111) == false) goto L51;
        int r27 = r12.f14013c;
    L53:
        if (r27 != (-1)) goto L55;
        r12.h();
    L51:
        r5 = r5 + 1;
        goto L42
    L52:
        r27 = -1;
        goto L53
    L74:
        if (r12.f14011a != 1) goto L78;
        r12.s = true;
        r15.q(r12.f14024r, 0.0f, 0.0f);
        r12.s = false;
        if (r12.f14011a != 1) goto L78;
        r12.k(0);
    L78:
        r12.a();
        goto L122
    L80:
        if (r12.f14011a == 1) goto L82;
        int r28 = r24.getPointerCount();
        int r29 = 0;
    L96:
        if (r29 >= r28) goto L116;
        int r30 = r24.getPointerId(r29);
        if (r12.g(r30) == false) goto L115;
        float r114 = r24.getX(r29);
        float r115 = r24.getY(r29);
        float r116 = r114 - r12.d[r30];
        float r117 = r115 - r12.e[r30];
        Math.abs(r116);
        Math.abs(r117);
        int r118 = r12.f14014h[r30];
        Math.abs(r117);
        Math.abs(r116);
        int r119 = r12.f14014h[r30];
        Math.abs(r116);
        Math.abs(r117);
        int r120 = r12.f14014h[r30];
        Math.abs(r117);
        Math.abs(r116);
        int r121 = r12.f14014h[r30];
        if (r12.f14011a == 1) goto L116;
        View r122 = r12.e((int) r114, (int) r115);
        if (r122 != null) goto L106;
    L105:
        boolean r123 = false;
    L111:
        if (r123 == false) goto L115;
        if (r12.l(r122, r30) == false) goto L115;
    L106:
        r15.getClass();
        if (r15.o(r122) <= 0) goto L105;
        if (Math.abs(r117) <= r12.f14012b) goto L105;
        r123 = true;
    L115:
        r29 = r29 + 1;
    L116:
        r12.j(r24);
        goto L122
    L82:
        if (r12.g(r12.f14013c) == false) goto L122;
        int r31 = r24.findPointerIndex(r12.f14013c);
        float r32 = r24.getX(r31);
        float r33 = r24.getY(r31);
        float[] r34 = r12.f;
        int r35 = r12.f14013c;
        int r36 = (int) (r32 - r34[r35]);
        int r37 = (int) (r33 - r12.g[r35]);
        int r38 = r12.f14024r.getLeft() + r36;
        int r39 = r12.f14024r.getTop() + r37;
        int r124 = r12.f14024r.getLeft();
        int r125 = r12.f14024r.getTop();
        if (r36 == 0) goto L87;
        View r40 = r12.f14024r;
        r15.getClass();
        r38 = r40.getLeft();
        ViewCompat.offsetLeftAndRight(r12.f14024r, r38 - r124);
    L87:
        int r126 = r38;
        if (r37 == 0) goto L90;
        r39 = r15.n(r12.f14024r, r39, r37);
        ViewCompat.offsetTopAndBottom(r12.f14024r, r39 - r125);
    L90:
        int r127 = r39;
        if (r36 != 0) goto L93;
        if (r37 != 0) goto L93;
    L94:
        r12.j(r24);
    L93:
        r12.f14023q.p(r12.f14024r, r126, r127, r126 - r124, r127 - r125);
        goto L94
    L118:
        if (r12.f14011a != 1) goto L120;
        r12.h();
    L120:
        r12.a();
        goto L122
    L121:
        float r41 = r24.getX();
        float r42 = r24.getY();
        int r43 = r24.getPointerId(0);
        View r44 = r12.e((int) r41, (int) r42);
        r12.i(r41, r42, r43);
        r12.l(r44, r43);
        int r45 = r12.f14014h[r43];
    L122:
        if (r10 != 2) goto L129;
        if (this.f13965q == true) goto L129;
        float r46 = Math.abs(this.f13973z - r24.getY());
        j r47 = this.f13964p;
        if (r46 <= r47.f14012b) goto L129;
        r47.b(r23, r24.getPointerId(r24.getActionIndex()));
    L129:
        return !this.f13965q;
    }

    public final void setPeekHeight(int r5) {
        if (r5 != (-1)) goto L8;
        if (this.e == true) goto L20;
        this.e = true;
    L13:
        if (this.f13962n != 4) goto L22;
        WeakReference r10 = this.f13968u;
        if (r10 == null) goto L23;
        View r11 = (View) r10.get();
        if (r11 == null) goto L24;
        r11.requestLayout();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L8:
        if (this.e == false) goto L10;
    L11:
        this.e = false;
        this.d = Math.max(0, r5);
        this.f13958j = this.f13967t - r5;
        goto L13
    L10:
        if (this.d != r5) goto L11;
    }

    public final void setState(int r5) {
        if (r5 != this.f13962n) goto L5;
        return;
    L5:
        WeakReference r10 = this.f13968u;
        if (r10 == null) goto L8;
        View r11 = (View) r10.get();
        if (r11 != null) goto L22;
        return;
    L22:
        ViewParent r12 = r11.getParent();
        if (r12 != null) goto L25;
    L29:
        b(r5, r11);
        return;
    L25:
        if (r12.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r11) == false) goto L29;
        r11.post(new a(this, r11, r5, 0));
        return;
    L8:
        if (r5 != 4) goto L10;
    L17:
        this.f13962n = r5;
        return;
    L10:
        if (r5 == 3) goto L17;
        if (r5 == 6) goto L17;
        if (this.f13959k == true) goto L16;
        return;
    L16:
        if (r5 == 5) goto L17;
    }

    public final void setStateInternal(int r5) {
        if (this.f13962n != r5) goto L5;
        return;
    L5:
        this.f13962n = r5;
        int r10 = 0;
        if (r5 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        View r11 = (View) this.f13968u.get();
    L17:
        ArrayList r12 = this.f13970w;
        if (r10 >= r12.size()) goto L20;
        ((g) r12.get(r10)).b(r11, r5);
        r10 = r10 + 1;
        goto L17
    L20:
        return;
    L8:
        if (r5 == 3) goto L15;
        if (r5 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r5 != 4) goto L16;
        goto L14
    }

    public final boolean shouldHide(View r5, float r10) {
        if (this.f13961m == false) goto L6;
        return true;
    L6:
        if (r10 != 0.0f) goto L12;
        int r11 = this.f13967t - a();
        if (r5.getTop() <= (a() + (r11 / 2))) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (this.f13963o != 4) goto L21;
        if (this.d <= (com.lynx.tasm.utils.a.w(r5.getContext()) / 2)) goto L21;
        if (r10 <= (this.f13955c * 0.08f)) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((Math.abs(((r10 * 0.1f) + r5.getTop()) - this.f13958j) / this.d) <= 0.5f) goto L24;
        return true;
    L24:
        return false;
    }

    public final void updateImportantForAccessibility(boolean r10) {
        WeakReference r5 = this.f13968u;
        if (r5 != null) goto L5;
        return;
    L5:
        ViewParent r11 = ((View) r5.get()).getParent();
        if ((r11 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r12 = (CoordinatorLayout) r11;
        int r13 = r12.getChildCount();
        if (r10 == true) goto L11;
    L14:
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L27;
        View r15 = r12.getChildAt(r14);
        if (r15 == this.f13968u.get()) goto L26;
        if (r10 == true) goto L25;
        HashMap r16 = this.B;
        if (r16 == null) goto L26;
        if (r16.containsKey(r15) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r15, ((Integer) this.B.get(r15)).intValue());
        goto L26
    L25:
        this.B.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r15, 4);
    L26:
        r14 = r14 + 1;
        goto L15
    L27:
        if (r10 == true) goto L36;
        this.B = null;
        return;
    L36:
        return;
    L11:
        if (this.B != null) goto L13;
        this.B = new HashMap(r13);
        goto L14
    }

    public BottomSheetBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13953a = true;
        this.f13954b = -1;
        this.f13960l = true;
        this.f13961m = false;
        this.f13962n = 4;
        this.f13963o = 4;
        this.f13970w = new ArrayList();
        this.C = true;
        this.D = true;
        this.E = 600;
        this.F = new b(this);
        new c(this);
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.BottomSheetBehavior_Layout);
        TypedValue r12 = r11.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r12 == null) goto L7;
        int r13 = r12.data;
        if (r13 != (-1)) goto L7;
        setPeekHeight(r13);
    L8:
        this.f13959k = r11.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        boolean r14 = r11.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f13953a == r14) goto L21;
        this.f13953a = r14;
        if (this.f13968u == null) goto L15;
        calculateCollapsedOffset();
    L15:
        if (this.f13953a == true) goto L17;
    L19:
        int r15 = this.f13962n;
    L20:
        setStateInternal(r15);
        goto L21
    L17:
        if (this.f13962n != 6) goto L19;
        r15 = 3;
    L21:
        this.f13961m = r11.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        r11.recycle();
        this.f13955c = ViewConfiguration.get(r5).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r11.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        goto L8
    }
}
