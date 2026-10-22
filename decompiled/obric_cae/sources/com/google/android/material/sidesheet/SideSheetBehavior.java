package com.google.android.material.sidesheet;

import aa.f;
import aa.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import ba.d;
import ba.e;
import com.obric.cae.R;
import com.obric.cae.network.BlockedReason;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import o0.c;

/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f4916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f4917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f4918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f4919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SideSheetBehavior<V>.b f4920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f4924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f4926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<V> f4931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<View> f4932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4933r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VelocityTracker f4934s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4935t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f4936u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f4937v;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f4938m;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            this.f4938m = r8.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f4938m);
        }

        public SavedState(android.view.AbsSavedState r8, SideSheetBehavior r10) {
            super(r8);
            this.f4938m = r10.f4923h;
        }
    }

    public class a extends c.AbstractC0128c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SideSheetBehavior f4939a;

        public a(SideSheetBehavior r8) {
            this.f4939a = r8;
        }

        @Override // o0.c.AbstractC0128c
        public final int a(View r8, int r10) {
            SideSheetBehavior r11 = this.f4939a;
            return t2.b.p(r10, r11.f4916a.f(), r11.f4916a.e());
        }

        @Override // o0.c.AbstractC0128c
        public final int b(View r8, int r10, int r11) {
            return r8.getTop();
        }

        @Override // o0.c.AbstractC0128c
        public final int c(View r8) {
            SideSheetBehavior r10 = this.f4939a;
            return r10.f4927l + r10.f4930o;
        }

        @Override // o0.c.AbstractC0128c
        public final void f(int r8) {
            if (r8 != 1) goto L8;
            SideSheetBehavior r10 = this.f4939a;
            if (r10.f4922g == false) goto L9;
            r10.z(1);
            return;
        L9:
            return;
        }

        @Override // o0.c.AbstractC0128c
        public final void g(View r8, int r10, int r11, int r12, int r13) {
            SideSheetBehavior r14 = this.f4939a;
            WeakReference<View> r15 = r14.f4932q;
            if (r15 == null) goto L5;
            View r16 = r15.get();
        L6:
            if (r16 == null) goto L10;
            ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16.getLayoutParams();
            if (r17 == null) goto L10;
            r14.f4916a.n(r17, r8.getLeft(), r8.getRight());
            r16.setLayoutParams(r17);
        L10:
            LinkedHashSet r18 = r14.f4936u;
            if (r18.isEmpty() == true) goto L16;
            r14.f4916a.b(r10);
            Iterator r19 = r18.iterator();
        L14:
            if (r19.hasNext() == false) goto L18;
            ((ba.c) r19.next()).b();
            goto L14
        L18:
            return;
        L16:
            return;
        L5:
            r16 = null;
            goto L6
        }

        @Override // o0.c.AbstractC0128c
        public final void h(View r8, float r10, float r11) {
            SideSheetBehavior r12 = this.f4939a;
            if (r12.f4916a.j(r10) == false) goto L6;
        L21:
            int r13 = 3;
        L23:
            r12.A(r8, r13, true);
            return;
        L6:
            if (r12.f4916a.m(r8, r10) == false) goto L13;
            if (r12.f4916a.l(r10, r11) == false) goto L10;
        L22:
            r13 = 5;
            goto L23
        L10:
            if (r12.f4916a.k(r8) == false) goto L21;
        L13:
            if (r10 != 0.0f) goto L15;
        L19:
            int r14 = r8.getLeft();
            if (Math.abs(r14 - r12.f4916a.c()) >= Math.abs(r14 - r12.f4916a.d())) goto L22;
        L15:
            if (Math.abs(r10) <= Math.abs(r11)) goto L17;
            boolean r15 = true;
        L18:
            if (r15 == true) goto L22;
        L17:
            r15 = false;
            goto L18
        }

        @Override // o0.c.AbstractC0128c
        public final boolean i(View r8, int r10) {
            SideSheetBehavior r11 = this.f4939a;
            if (r11.f4923h != 1) goto L5;
            return false;
        L5:
            WeakReference<V> r12 = r11.f4931p;
            if (r12 != null) goto L8;
            return false;
        L8:
            if (r12.get() == r8) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.activity.d f4942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SideSheetBehavior f4943d;

        public b(SideSheetBehavior r8) {
            this.f4943d = r8;
            this.f4942c = new androidx.activity.d(this, 15);
        }

        public final void a(int r8) {
            SideSheetBehavior r10 = this.f4943d;
            WeakReference<V> r11 = r10.f4931p;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.get() == null) goto L13;
            this.f4940a = r8;
            if (this.f4941b == true) goto L12;
            V r12 = r10.f4931p.get();
            WeakHashMap<View, h0> r13 = w.f8437a;
            w.d.m(r12, this.f4942c);
            this.f4941b = true;
            return;
        L12:
            return;
        }
    }

    public SideSheetBehavior() {
        this.f4920e = new b(this);
        this.f4922g = true;
        this.f4923h = 5;
        this.f4926k = 0.1f;
        this.f4933r = -1;
        this.f4936u = new LinkedHashSet();
        this.f4937v = new a(this);
    }

    public final void A(View r8, int r10, boolean r11) {
        if (r10 != 3) goto L5;
        int r12 = this.f4916a.c();
    L10:
        c r13 = this.f4924i;
        if (r13 == null) goto L19;
        if (r11 == false) goto L17;
        if (r13.q(r12, r8.getTop()) == false) goto L19;
    L18:
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        z(2);
        this.f4920e.a(r10);
        return;
    L22:
        z(r10);
        return;
    L17:
        if (r13.s(r8, r12, r8.getTop()) == true) goto L18;
    L19:
        r14 = false;
        goto L20
    L5:
        if (r10 != 5) goto L8;
        r12 = this.f4916a.d();
        goto L10
    L8:
        throw new IllegalArgumentException(defpackage.a.d("Invalid state to get outer edge offset: ", r10));
    }

    public final void B() {
        WeakReference<V> r8 = this.f4931p;
        if (r8 != null) goto L5;
        return;
    L5:
        V r10 = r8.get();
        if (r10 != null) goto L8;
        return;
    L8:
        w.k(r10, 262144);
        w.i(r10, 0);
        w.k(r10, BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE);
        w.i(r10, 0);
        final int r11 = 5;
        if (this.f4923h == 5) goto L11;
        w.l(r10, k0.f.a.f8898j, new e(this, r11));
    L11:
        final int r12 = 3;
        if (this.f4923h == 3) goto L15;
        w.l(r10, k0.f.a.f8896h, new e(this, r12));
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void c(CoordinatorLayout.f r8) {
        this.f4931p = null;
        this.f4924i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void f() {
        this.f4931p = null;
        this.f4924i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
        if (r10.isShown() == true) goto L7;
        if (w.c(r10) != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        if (r12 == true) goto L13;
        this.f4925j = true;
        return false;
    L13:
        int r13 = r11.getActionMasked();
        if (r13 != 0) goto L19;
        VelocityTracker r14 = this.f4934s;
        if (r14 == null) goto L19;
        r14.recycle();
        this.f4934s = null;
    L19:
        if (this.f4934s != null) goto L21;
        this.f4934s = VelocityTracker.obtain();
    L21:
        this.f4934s.addMovement(r11);
        if (r13 == 0) goto L31;
        if (r13 == 1) goto L28;
        if (r13 == 3) goto L28;
    L33:
        if (this.f4925j == true) goto L40;
        c r15 = this.f4924i;
        if (r15 == null) goto L40;
        if (r15.r(r11) == false) goto L40;
        return true;
    L40:
        return false;
    L28:
        if (this.f4925j == false) goto L33;
        this.f4925j = false;
        return false;
    L31:
        this.f4935t = (int) r11.getX();
    L7:
        if (this.f4922g == false) goto L9;
        r12 = true;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout r8, V r10, int r11) {
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.d.b(r8) == true) goto L5;
    L7:
        int r13 = 0;
        if (this.f4931p != null) goto L32;
        this.f4931p = new WeakReference(r10);
        new v9.c(r10);
        f r14 = this.f4917b;
        if (r14 == null) goto L15;
        w.d.q(r10, r14);
        f r15 = this.f4917b;
        float r16 = this.f4921f;
        if (r16 != (-1.0f)) goto L14;
        r16 = w.i.i(r10);
    L14:
        r15.j(r16);
    L19:
        if (this.f4923h != 5) goto L21;
        int r17 = 4;
    L23:
        if (r10.getVisibility() == r17) goto L25;
        r10.setVisibility(r17);
    L25:
        B();
        if (w.d.c(r10) != 0) goto L29;
        w.d.s(r10, 1);
    L29:
        if (w.c(r10) != null) goto L32;
        w.n(r10, r10.getResources().getString(R.string.side_sheet_accessibility_pane_title));
        goto L32
    L21:
        r17 = 0;
        goto L23
    L15:
        ColorStateList r18 = this.f4918c;
        if (r18 == null) goto L19;
        w.i.q(r10, r18);
    L32:
        if (Gravity.getAbsoluteGravity(((CoordinatorLayout.f) r10.getLayoutParams()).f1565c, r11) != 3) goto L34;
        int r19 = 1;
    L35:
        d r20 = this.f4916a;
        if (r20 != null) goto L38;
    L39:
        j r21 = this.f4919d;
        if (r19 != 0) goto L51;
        this.f4916a = new ba.b(this);
        if (r21 == null) goto L66;
        CoordinatorLayout.f r22 = y();
        if (r22 != null) goto L46;
    L48:
        boolean r23 = false;
    L49:
        if (r23 == true) goto L66;
        j.a r24 = new j.a(r21);
        r24.f(0.0f);
        r24.d(0.0f);
    L62:
        j r25 = new j(r24);
        f r26 = this.f4917b;
        if (r26 == null) goto L66;
        r26.setShapeAppearanceModel(r25);
        goto L66
    L46:
        if (((ViewGroup.MarginLayoutParams) r22).rightMargin <= 0) goto L48;
        r23 = true;
    L66:
        if (this.f4924i != null) goto L68;
        this.f4924i = new c(r8.getContext(), r8, this.f4937v);
    L68:
        int r27 = this.f4916a.g(r10);
        r8.q(r10, r11);
        this.f4928m = r8.getWidth();
        this.f4929n = this.f4916a.h(r8);
        this.f4927l = r10.getWidth();
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        if (r110 == null) goto L71;
        int r111 = this.f4916a.a(r110);
    L72:
        this.f4930o = r111;
        int r112 = this.f4923h;
        if (r112 != 1) goto L75;
    L81:
        r13 = r27 - this.f4916a.g(r10);
    L82:
        r10.offsetLeftAndRight(r13);
        if (this.f4932q != null) goto L89;
        int r28 = this.f4933r;
        if (r28 == (-1)) goto L89;
        View r29 = r8.findViewById(r28);
        if (r29 == null) goto L89;
        this.f4932q = new WeakReference(r29);
    L89:
        Iterator r30 = this.f4936u.iterator();
    L91:
        if (r30.hasNext() == false) goto L95;
        ba.c r31 = (ba.c) r30.next();
        if ((r31 instanceof ba.f) == false) goto L91;
        ((ba.f) r31).getClass();
        goto L91
    L95:
        return true;
    L75:
        if (r112 == 2) goto L81;
        if (r112 == 3) goto L82;
        if (r112 != 5) goto L80;
        r13 = this.f4916a.d();
        goto L82
    L80:
        throw new IllegalStateException("Unexpected value: " + this.f4923h);
    L71:
        r111 = 0;
        goto L72
    L51:
        if (r19 != 1) goto L97;
        this.f4916a = new ba.a(this);
        if (r21 == null) goto L66;
        CoordinatorLayout.f r32 = y();
        if (r32 != null) goto L57;
    L59:
        boolean r33 = false;
    L60:
        if (r33 == true) goto L66;
        r24 = new j.a(r21);
        r24.e(0.0f);
        r24.c(0.0f);
        goto L62
    L57:
        if (((ViewGroup.MarginLayoutParams) r32).leftMargin <= 0) goto L59;
        r33 = true;
        goto L60
    L97:
        throw new IllegalArgumentException(android.aimedia.a.c("Invalid sheet edge position value: ", r19, ". Must be 0 or 1."));
    L38:
        if (r20.i() == r19) goto L66;
    L34:
        r19 = 0;
        goto L35
    L5:
        if (w.d.b(r10) == true) goto L7;
        r10.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r15 = r8.getPaddingLeft();
        int r16 = ViewGroup.getChildMeasureSpec(r11, (((r8.getPaddingRight() + r15) + r14.leftMargin) + r14.rightMargin) + r12, r14.width);
        int r17 = r8.getPaddingTop();
        r10.measure(r16, ViewGroup.getChildMeasureSpec(r13, (((r8.getPaddingBottom() + r17) + r14.topMargin) + r14.bottomMargin) + 0, r14.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void r(CoordinatorLayout r8, V r10, Parcelable r11) {
        int r12 = ((SavedState) r11).f4938m;
        if (r12 != 1) goto L5;
    L6:
        r12 = 5;
    L7:
        this.f4923h = r12;
        return;
    L5:
        if (r12 != 2) goto L7;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable s(View r8, CoordinatorLayout r10) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r8, V r10, MotionEvent r11) {
        boolean r12 = false;
        if (r10.isShown() == true) goto L5;
        return false;
    L5:
        int r13 = r11.getActionMasked();
        int r14 = this.f4923h;
        if (r14 != 1) goto L9;
        if (r13 != 0) goto L9;
        return true;
    L9:
        c r15 = this.f4924i;
        if (r15 != null) goto L12;
    L15:
        boolean r16 = false;
    L16:
        if (r16 == false) goto L18;
        r15.k(r11);
    L18:
        if (r13 != 0) goto L23;
        VelocityTracker r17 = this.f4934s;
        if (r17 == null) goto L23;
        r17.recycle();
        this.f4934s = null;
    L23:
        if (this.f4934s != null) goto L25;
        this.f4934s = VelocityTracker.obtain();
    L25:
        this.f4934s.addMovement(r11);
        c r18 = this.f4924i;
        if (r18 != null) goto L28;
    L32:
        boolean r19 = false;
    L33:
        if (r19 == false) goto L53;
        if (r13 != 2) goto L53;
        if (this.f4925j == true) goto L53;
        if (r18 != null) goto L40;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == true) goto L48;
    L50:
        if (r12 == false) goto L53;
        this.f4924i.b(r10, r11.getPointerId(r11.getActionIndex()));
        goto L53
    L48:
        if (Math.abs(this.f4935t - r11.getX()) <= this.f4924i.f9589b) goto L50;
        r12 = true;
        goto L50
    L40:
        if (this.f4922g == false) goto L42;
    L43:
        r20 = true;
        goto L45
    L42:
        if (this.f4923h != 1) goto L44;
    L53:
        return !this.f4925j;
    L28:
        if (this.f4922g == false) goto L30;
    L31:
        r19 = true;
        goto L33
    L30:
        if (this.f4923h != 1) goto L32;
    L12:
        if (this.f4922g == true) goto L14;
        if (r14 != 1) goto L15;
    L14:
        r16 = true;
        goto L16
    }

    public final CoordinatorLayout.f y() {
        WeakReference<V> r8 = this.f4931p;
        if (r8 == null) goto L10;
        V r10 = r8.get();
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10.getLayoutParams() instanceof CoordinatorLayout.f) == true) goto L9;
        return null;
    L9:
        return (CoordinatorLayout.f) r10.getLayoutParams();
    L10:
        return null;
    }

    public final void z(int r8) {
        if (this.f4923h != r8) goto L5;
        return;
    L5:
        this.f4923h = r8;
        WeakReference<V> r10 = this.f4931p;
        if (r10 != null) goto L8;
        return;
    L8:
        V r11 = r10.get();
        if (r11 != null) goto L12;
        return;
    L12:
        if (this.f4923h != 5) goto L14;
        int r12 = 4;
    L16:
        if (r11.getVisibility() == r12) goto L18;
        r11.setVisibility(r12);
    L18:
        Iterator r13 = this.f4936u.iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        ((ba.c) r13.next()).a();
        goto L20
    L22:
        B();
        return;
    L14:
        r12 = 0;
        goto L16
    }

    public SideSheetBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f4920e = new b(this);
        this.f4922g = true;
        this.f4923h = 5;
        this.f4926k = 0.1f;
        this.f4933r = -1;
        this.f4936u = new LinkedHashSet();
        this.f4937v = new a(this);
        TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7783x);
        if (r11.hasValue(3) == false) goto L6;
        this.f4918c = x9.c.a(r8, r11, 3);
    L6:
        if (r11.hasValue(6) == false) goto L9;
        this.f4919d = new j(j.b(r8, r10, 0, R.style.Widget_Material3_SideSheet));
    L9:
        if (r11.hasValue(5) == false) goto L20;
        int r12 = r11.getResourceId(5, -1);
        this.f4933r = r12;
        WeakReference<View> r13 = this.f4932q;
        if (r13 == null) goto L13;
        r13.clear();
    L13:
        this.f4932q = null;
        WeakReference<V> r14 = this.f4931p;
        if (r14 == null) goto L20;
        V r15 = r14.get();
        if (r12 == (-1)) goto L20;
        WeakHashMap<View, h0> r16 = w.f8437a;
        if (w.g.c(r15) == false) goto L20;
        r15.requestLayout();
    L20:
        j r17 = this.f4919d;
        if (r17 == null) goto L27;
        f r18 = new f(r17);
        this.f4917b = r18;
        r18.i(r8);
        ColorStateList r19 = this.f4918c;
        if (r19 == null) goto L26;
        this.f4917b.k(r19);
        goto L27
    L26:
        TypedValue r20 = new TypedValue();
        r8.getTheme().resolveAttribute(android.R.attr.colorBackground, r20, true);
        this.f4917b.setTint(r20.data);
    L27:
        this.f4921f = r11.getDimension(2, -1.0f);
        this.f4922g = r11.getBoolean(4, true);
        r11.recycle();
        ViewConfiguration.get(r8).getScaledMaximumFlingVelocity();
    }
}
