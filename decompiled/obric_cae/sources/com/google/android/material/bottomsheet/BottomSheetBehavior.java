package com.google.android.material.bottomsheet;

import aa.f;
import aa.j;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.o;
import com.google.android.material.internal.p;
import com.google.android.material.internal.q;
import com.obric.cae.R;
import com.obric.cae.network.BlockedReason;
import j0.h0;
import j0.l0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public final BottomSheetBehavior<V>.d A;
    public ValueAnimator B;
    public int C;
    public int D;
    public int E;
    public float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public o0.c M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q;
    public int R;
    public int S;
    public int T;
    public WeakReference<V> U;
    public WeakReference<View> V;
    public final ArrayList<c> W;
    public VelocityTracker X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4405a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f4406a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4407b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public HashMap f4408b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4409c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final SparseIntArray f4410c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4411d;
    public final b d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f4416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ColorStateList f4417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f4422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f4423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f4424q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f4425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f4426s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f4427t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f4428u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4429v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4430w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f4431x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f4432y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4433z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f4434m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f4435n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f4436o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f4437p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f4438q;

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
            this.f4434m = r8.readInt();
            this.f4435n = r8.readInt();
            boolean r11 = false;
            if (r8.readInt() != 1) goto L5;
            boolean r12 = true;
        L6:
            this.f4436o = r12;
            if (r8.readInt() != 1) goto L9;
            boolean r13 = true;
        L10:
            this.f4437p = r13;
            if (r8.readInt() != 1) goto L13;
            r11 = true;
        L13:
            this.f4438q = r11;
            return;
        L9:
            r13 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f4434m);
            r8.writeInt(this.f4435n);
            r8.writeInt(this.f4436o ? 1 : 0);
            r8.writeInt(this.f4437p ? 1 : 0);
            r8.writeInt(this.f4438q ? 1 : 0);
        }

        public SavedState(android.view.AbsSavedState r8, BottomSheetBehavior r10) {
            super(r8);
            this.f4434m = r10.L;
            this.f4435n = r10.f4412e;
            this.f4436o = r10.f4407b;
            this.f4437p = r10.I;
            this.f4438q = r10.J;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4440b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f4441m;

        public a(BottomSheetBehavior r8, View r10, int r11) {
            this.f4441m = r8;
            this.f4439a = r10;
            this.f4440b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4441m.N(this.f4439a, this.f4440b, false);
        }
    }

    public class b extends o0.c.AbstractC0128c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f4442a;

        public b(BottomSheetBehavior r8) {
            this.f4442a = r8;
        }

        @Override // o0.c.AbstractC0128c
        public final int a(View r8, int r10) {
            return r8.getLeft();
        }

        @Override // o0.c.AbstractC0128c
        public final int b(View r8, int r10, int r11) {
            return t2.b.p(r10, this.f4442a.E(), d());
        }

        @Override // o0.c.AbstractC0128c
        public final int d() {
            BottomSheetBehavior r8 = this.f4442a;
            if (r8.I == false) goto L7;
            return r8.T;
        L7:
            return r8.G;
        }

        @Override // o0.c.AbstractC0128c
        public final void f(int r8) {
            if (r8 != 1) goto L8;
            BottomSheetBehavior r10 = this.f4442a;
            if (r10.K == false) goto L9;
            r10.L(1);
            return;
        L9:
            return;
        }

        @Override // o0.c.AbstractC0128c
        public final void g(View r8, int r10, int r11, int r12, int r13) {
            this.f4442a.B(r11);
        }

        @Override // o0.c.AbstractC0128c
        public final void h(View r8, float r10, float r11) {
            BottomSheetBehavior r12 = this.f4442a;
            if (r11 >= 0.0f) goto L11;
            if (r12.f4407b == true) goto L50;
            int r13 = r8.getTop();
            System.currentTimeMillis();
            if (r13 <= r12.E) goto L50;
        L53:
            int r14 = 6;
        L55:
            r12.getClass();
            r12.N(r8, r14, true);
            return;
        L50:
            r14 = 3;
            goto L55
        L11:
            if (r12.I == false) goto L31;
            if (r12.M(r8, r11) == false) goto L31;
            if (Math.abs(r10) >= Math.abs(r11)) goto L19;
            if (r11 <= r12.f4411d) goto L19;
        L23:
            r14 = 5;
        L19:
            if (r8.getTop() <= ((r12.E() + r12.T) / 2)) goto L21;
            boolean r15 = true;
        L22:
            if (r15 == true) goto L23;
            if (r12.f4407b == true) goto L50;
            if (Math.abs(r8.getTop() - r12.E()) >= Math.abs(r8.getTop() - r12.E)) goto L53;
        L21:
            r15 = false;
        L31:
            if (r11 != 0.0f) goto L33;
        L41:
            int r16 = r8.getTop();
            if (r12.f4407b == true) goto L44;
            int r17 = r12.E;
            if (r16 >= r17) goto L52;
            if (r16 >= Math.abs(r16 - r12.G)) goto L53;
        L52:
            if (Math.abs(r16 - r17) < Math.abs(r16 - r12.G)) goto L53;
        L54:
            r14 = 4;
            goto L55
        L44:
            if (Math.abs(r16 - r12.D) >= Math.abs(r16 - r12.G)) goto L54;
        L33:
            if (Math.abs(r10) > Math.abs(r11)) goto L41;
            if (r12.f4407b == true) goto L54;
            int r18 = r8.getTop();
            if (Math.abs(r18 - r12.E) >= Math.abs(r18 - r12.G)) goto L54;
            goto L54
        }

        @Override // o0.c.AbstractC0128c
        public final boolean i(View r8, int r10) {
            BottomSheetBehavior r11 = this.f4442a;
            int r12 = r11.L;
            if (r12 != 1) goto L6;
            return false;
        L6:
            if (r11.f4406a0 == false) goto L9;
            return false;
        L9:
            if (r12 == 3) goto L11;
        L20:
            System.currentTimeMillis();
            WeakReference<V> r13 = r11.U;
            if (r13 != null) goto L23;
            return false;
        L23:
            if (r13.get() == r8) goto L25;
            return false;
        L25:
            return true;
        L11:
            if (r11.Y != r10) goto L20;
            WeakReference<View> r14 = r11.V;
            if (r14 == null) goto L15;
            View r15 = r14.get();
        L16:
            if (r15 == null) goto L20;
            if (r15.canScrollVertically(-1) == false) goto L20;
            return false;
        L15:
            r15 = null;
            goto L16
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a();

        public abstract void b();
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f4445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f4446d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f4447a;

            public a(d r8) {
                this.f4447a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d r8 = this.f4447a;
                r8.f4444b = false;
                BottomSheetBehavior r10 = r8.f4446d;
                o0.c r11 = r10.M;
                if (r11 == null) goto L8;
                if (r11.g() == false) goto L8;
                r8.a(r8.f4443a);
                return;
            L8:
                if (r10.L != 2) goto L12;
                r10.L(r8.f4443a);
                return;
            }
        }

        public d(BottomSheetBehavior r8) {
            this.f4446d = r8;
            this.f4445c = new a(this);
        }

        public final void a(int r8) {
            BottomSheetBehavior r10 = this.f4446d;
            WeakReference<V> r11 = r10.U;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.get() == null) goto L13;
            this.f4443a = r8;
            if (this.f4444b == true) goto L12;
            V r12 = r10.U.get();
            WeakHashMap<View, h0> r13 = w.f8437a;
            w.d.m(r12, this.f4445c);
            this.f4444b = true;
            return;
        L12:
            return;
        }
    }

    public BottomSheetBehavior() {
        this.f4405a = 0;
        this.f4407b = true;
        this.f4418k = -1;
        this.f4419l = -1;
        this.A = new d(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.f4410c0 = new SparseIntArray();
        this.d0 = new b(this);
    }

    public final int A() {
        if (this.f4413f == false) goto L8;
        int r8 = Math.min(Math.max(this.f4414g, this.T - ((this.S * 9) / 16)), this.R);
    L6:
        return r8 + this.f4429v;
    L8:
        if (this.f4421n == false) goto L10;
    L15:
        r8 = this.f4412e;
        goto L6
    L10:
        if (this.f4422o == true) goto L15;
        int r10 = this.f4420m;
        if (r10 <= 0) goto L15;
        return Math.max(this.f4412e, r10 + this.f4415h);
    }

    public final void B(int r8) {
        if (this.U.get() == null) goto L16;
        ArrayList<c> r10 = this.W;
        if (r10.isEmpty() == true) goto L18;
        int r11 = this.G;
        if (r8 <= r11) goto L9;
    L12:
        int r12 = 0;
    L14:
        if (r12 >= r10.size()) goto L19;
        r10.get(r12).a();
        r12 = r12 + 1;
        goto L14
    L19:
        return;
    L9:
        if (r11 == E()) goto L12;
        E();
        goto L12
    L18:
        return;
    }

    public final View C(View r8) {
        if (r8.getVisibility() == 0) goto L5;
        return null;
    L5:
        WeakHashMap<View, h0> r10 = w.f8437a;
        if (w.i.p(r8) == false) goto L9;
        return r8;
    L9:
        if ((r8 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r8;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        View r14 = C(r11.getChildAt(r13));
        if (r14 != null) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return r14;
    L16:
        return null;
    }

    public final int D(int r8, int r10, int r11, int r12) {
        int r13 = ViewGroup.getChildMeasureSpec(r8, r10, r12);
        if (r11 != (-1)) goto L5;
        return r13;
    L5:
        int r14 = View.MeasureSpec.getMode(r13);
        int r15 = View.MeasureSpec.getSize(r13);
        if (r14 == 1073741824) goto L13;
        if (r15 == 0) goto L11;
        r11 = Math.min(r15, r11);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r15, r11), 1073741824);
    }

    public final int E() {
        if (this.f4407b == true) goto L11;
        int r8 = this.C;
        if (this.f4425r == false) goto L8;
        int r10 = 0;
    L10:
        return Math.max(r8, r10);
    L8:
        r10 = this.f4430w;
        goto L10
    L11:
        return this.D;
    }

    public final int F(int r8) {
        if (r8 == 3) goto L19;
        if (r8 == 4) goto L17;
        if (r8 == 5) goto L15;
        if (r8 != 6) goto L13;
        return this.E;
    L13:
        throw new IllegalArgumentException(defpackage.a.d("Invalid state to get top offset: ", r8));
    L15:
        return this.T;
    L17:
        return this.G;
    L19:
        return E();
    }

    public final boolean G() {
        WeakReference<V> r8 = this.U;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.get() == null) goto L13;
        int[] r10 = new int[2];
        this.U.get().getLocationOnScreen(r10);
        if (r10[1] == 0) goto L10;
        return false;
    L10:
        return true;
    L13:
        return false;
    }

    public final void H(View r8, k0.f.a r10, int r11) {
        w.l(r8, r10, new k9.c(this, r11));
    }

    public final void I(int r8) {
        if (r8 < 0) goto L6;
        this.C = r8;
        P(this.L, true);
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public final void J(int r8) {
        boolean r10 = false;
        if (r8 != (-1)) goto L8;
        if (this.f4413f == true) goto L13;
        this.f4413f = true;
    L12:
        r10 = true;
    L13:
        if (r10 == false) goto L16;
        R();
        return;
    L16:
        return;
    L8:
        if (this.f4413f == false) goto L10;
    L11:
        this.f4413f = false;
        this.f4412e = Math.max(0, r8);
        goto L12
    L10:
        if (this.f4412e == r8) goto L13;
        goto L11
    }

    public final void K(int r8) {
        boolean r10 = true;
        if (r8 != 1) goto L5;
    L39:
        StringBuilder r11 = new StringBuilder("STATE_");
        if (r8 != 1) goto L42;
        String r12 = "DRAGGING";
    L44:
        throw new IllegalArgumentException(android.aimedia.a.i(r11, r12, " should not be set externally."));
    L42:
        r12 = "SETTLING";
        goto L44
    L5:
        if (r8 == 2) goto L39;
        if (this.I == true) goto L14;
        if (r8 != 5) goto L14;
        Log.w("BottomSheetBehavior", "Cannot set state: " + r8);
        return;
    L14:
        if (r8 == 6) goto L16;
    L20:
        int r13 = r8;
    L21:
        WeakReference<V> r14 = this.U;
        if (r14 != null) goto L24;
    L37:
        L(r8);
        return;
    L24:
        if (r14.get() == null) goto L37;
        V r15 = this.U.get();
        a r16 = new a(this, r15, r13);
        ViewParent r17 = r15.getParent();
        if (r17 != null) goto L29;
    L33:
        r10 = false;
    L34:
        if (r10 == false) goto L36;
        r15.post(r16);
        return;
    L36:
        r16.run();
        return;
    L29:
        if (r17.isLayoutRequested() == false) goto L33;
        WeakHashMap<View, h0> r18 = w.f8437a;
        if (w.g.b(r15) == false) goto L33;
    L16:
        if (this.f4407b == false) goto L20;
        if (F(r8) > this.D) goto L20;
        r13 = 3;
        goto L21
    }

    public final void L(int r8) {
        if (this.L != r8) goto L5;
        return;
    L5:
        this.L = r8;
        WeakReference<V> r10 = this.U;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.get() != null) goto L11;
        return;
    L11:
        int r11 = 0;
        if (r8 != 3) goto L15;
        Q(true);
    L20:
        P(r8, true);
    L21:
        ArrayList<c> r12 = this.W;
        if (r11 >= r12.size()) goto L24;
        r12.get(r11).b();
        r11 = r11 + 1;
        goto L21
    L24:
        O();
        return;
    L15:
        if (r8 != 6) goto L17;
    L19:
        Q(false);
        goto L20
    L17:
        if (r8 == 5) goto L19;
        if (r8 != 4) goto L20;
        goto L19
    }

    public final boolean M(View r8, float r10) {
        if (this.J == false) goto L6;
        return true;
    L6:
        if (r8.getTop() >= this.G) goto L9;
        return false;
    L9:
        if ((Math.abs(((r10 * this.Q) + r8.getTop()) - this.G) / A()) <= 0.5f) goto L12;
        return true;
    L12:
        return false;
    }

    public final void N(View r8, int r10, boolean r11) {
        int r12 = F(r10);
        o0.c r13 = this.M;
        if (r13 == null) goto L11;
        if (r11 == false) goto L9;
        if (r13.q(r8.getLeft(), r12) == false) goto L11;
    L10:
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        L(2);
        P(r10, true);
        this.A.a(r10);
        return;
    L14:
        L(r10);
        return;
    L9:
        if (r13.s(r8, r8.getLeft(), r12) == true) goto L10;
    L11:
        r14 = false;
        goto L12
    }

    public final void O() {
        WeakReference<V> r8 = this.U;
        if (r8 == null) goto L79;
        V r10 = r8.get();
        if (r10 == null) goto L81;
        w.k(r10, 524288);
        w.i(r10, 0);
        w.k(r10, 262144);
        w.i(r10, 0);
        w.k(r10, BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE);
        w.i(r10, 0);
        SparseIntArray r11 = this.f4410c0;
        int r12 = r11.get(0, -1);
        if (r12 == (-1)) goto L10;
        w.k(r10, r12);
        w.i(r10, 0);
        r11.delete(0);
    L10:
        int r13 = 6;
        if (this.f4407b == true) goto L50;
        if (this.L == 6) goto L50;
        String r14 = r10.getResources().getString(R.string.bottomsheet_action_expand_halfway);
        k9.c r15 = new k9.c(this, 6);
        ArrayList r16 = w.d(r10);
        int r17 = 0;
    L16:
        if (r17 >= r16.size()) goto L21;
        if (TextUtils.equals(r14, ((AccessibilityNodeInfo.AccessibilityAction) ((k0.f.a) r16.get(r17)).f8901a).getLabel()) == true) goto L19;
        r17 = r17 + 1;
        goto L16
    L19:
        int r18 = ((k0.f.a) r16.get(r17)).a();
    L37:
        if (r18 == (-1)) goto L48;
        k0.f.a r19 = new k0.f.a(null, r18, r14, r15, null);
        View.AccessibilityDelegate r20 = w.m.a(r10);
        if (r20 != null) goto L42;
        j0.a r21 = null;
    L45:
        if (r21 != null) goto L47;
        r21 = new j0.a();
    L47:
        w.m(r10, r21);
        w.k(r10, r19.a());
        w.d(r10).add(r19);
        w.i(r10, 0);
        goto L48
    L42:
        if ((r20 instanceof j0.a.C0095a) == false) goto L44;
        r21 = ((j0.a.C0095a) r20).f8372a;
        goto L45
    L44:
        r21 = new j0.a(r20);
    L48:
        r11.put(0, r18);
        goto L50
    L21:
        int r22 = 0;
        int r23 = -1;
    L22:
        int[] r24 = w.f8438b;
        if (r22 >= r24.length) goto L36;
        if (r23 != (-1)) goto L36;
        int r25 = r24[r22];
        int r110 = 0;
        boolean r111 = true;
    L27:
        if (r110 >= r16.size()) goto L33;
        if (((k0.f.a) r16.get(r110)).a() == r25) goto L31;
        boolean r112 = true;
    L32:
        r111 = r111 & r112;
        r110 = r110 + 1;
        goto L27
    L31:
        r112 = false;
        goto L32
    L33:
        if (r111 == false) goto L35;
        r23 = r25;
    L35:
        r22 = r22 + 1;
    L36:
        r18 = r23;
    L50:
        if (this.I == true) goto L52;
    L54:
        int r26 = this.L;
        if (r26 == 3) goto L65;
        if (r26 == 4) goto L61;
        if (r26 != 6) goto L82;
        H(r10, k0.f.a.f8897i, 4);
        H(r10, k0.f.a.f8896h, 3);
        return;
    L82:
        return;
    L61:
        if (this.f4407b == false) goto L63;
        r13 = 3;
    L63:
        k0.f.a r27 = k0.f.a.f8896h;
    L68:
        H(r10, r27, r13);
        return;
    L65:
        if (this.f4407b == false) goto L67;
        r13 = 4;
    L67:
        r27 = k0.f.a.f8897i;
        goto L68
    L52:
        if (this.L == 5) goto L54;
        H(r10, k0.f.a.f8898j, 5);
        goto L54
    L81:
        return;
    }

    public final void P(int r8, boolean r10) {
        if (r8 != 2) goto L6;
        return;
    L6:
        if (this.L == 3) goto L8;
    L12:
        boolean r11 = false;
    L14:
        if (this.f4433z != r11) goto L16;
        return;
    L16:
        if (this.f4416i == null) goto L45;
        this.f4433z = r11;
        float r12 = 1.0f;
        if (r10 == false) goto L29;
        ValueAnimator r13 = this.B;
        if (r13 == null) goto L29;
        if (r13.isRunning() == false) goto L25;
        this.B.reverse();
        return;
    L25:
        float r14 = this.f4416i.f139a.f165j;
        if (r11 == false) goto L28;
        r12 = z();
    L28:
        this.B.setFloatValues(new float[]{r14, r12});
        this.B.start();
        return;
    L29:
        ValueAnimator r15 = this.B;
        if (r15 != null) goto L32;
    L34:
        f r16 = this.f4416i;
        if (this.f4433z == false) goto L37;
        r12 = z();
    L37:
        f.b r17 = r16.f139a;
        if (r17.f165j == r12) goto L44;
        r17.f165j = r12;
        r16.f143o = true;
        r16.invalidateSelf();
        return;
    L44:
        return;
    L32:
        if (r15.isRunning() == false) goto L34;
        this.B.cancel();
        goto L34
    L45:
        return;
    L8:
        if (this.f4431x == false) goto L10;
    L11:
        r11 = true;
        goto L14
    L10:
        if (G() == false) goto L12;
        goto L11
    }

    public final void Q(boolean r8) {
        WeakReference<V> r10 = this.U;
        if (r10 != null) goto L5;
        return;
    L5:
        ViewParent r11 = r10.get().getParent();
        if ((r11 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r12 = (CoordinatorLayout) r11;
        int r13 = r12.getChildCount();
        if (r8 == true) goto L11;
    L14:
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L22;
        View r15 = r12.getChildAt(r14);
        if (r15 == this.U.get()) goto L21;
        if (r8 == false) goto L21;
        this.f4408b0.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
    L21:
        r14 = r14 + 1;
        goto L15
    L22:
        if (r8 == true) goto L29;
        this.f4408b0 = null;
        return;
    L29:
        return;
    L11:
        if (this.f4408b0 != null) goto L13;
        this.f4408b0 = new HashMap(r13);
        goto L14
    }

    public final void R() {
        if (this.U == null) goto L10;
        y();
        if (this.L != 4) goto L11;
        V r8 = this.U.get();
        if (r8 == null) goto L12;
        r8.requestLayout();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void c(CoordinatorLayout.f r8) {
        this.U = null;
        this.M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void f() {
        this.U = null;
        this.M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout r10, V r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L68:
        this.N = true;
        return false;
    L5:
        if (this.K == false) goto L68;
        int r8 = r12.getActionMasked();
        View r13 = null;
        if (r8 != 0) goto L13;
        this.Y = -1;
        this.Z = -1;
        VelocityTracker r14 = this.X;
        if (r14 == null) goto L13;
        r14.recycle();
        this.X = null;
    L13:
        if (this.X != null) goto L15;
        this.X = VelocityTracker.obtain();
    L15:
        this.X.addMovement(r12);
        if (r8 == 0) goto L25;
        if (r8 != 1) goto L19;
    L21:
        this.f4406a0 = false;
        this.Y = -1;
        if (this.N == false) goto L43;
        this.N = false;
        return false;
    L43:
        if (this.N == true) goto L49;
        o0.c r15 = this.M;
        if (r15 == null) goto L49;
        if (r15.r(r12) == false) goto L49;
        return true;
    L49:
        WeakReference<View> r16 = this.V;
        if (r16 == null) goto L52;
        r13 = r16.get();
    L52:
        if (r8 != 2) goto L70;
        if (r13 != null) goto L55;
        return false;
    L55:
        if (this.N == false) goto L57;
        return false;
    L57:
        if (this.L != 1) goto L59;
        return false;
    L59:
        if (r10.l(r13, (int) r12.getX(), (int) r12.getY()) == false) goto L61;
        return false;
    L61:
        if (this.M == null) goto L75;
        int r17 = this.Z;
        if (r17 != (-1)) goto L65;
        return false;
    L65:
        if (Math.abs(r17 - r12.getY()) > this.M.f9589b) goto L67;
        return false;
    L67:
        return true;
    L75:
        return false;
    L70:
        return false;
    L19:
        if (r8 == 3) goto L21;
    L25:
        int r18 = (int) r12.getX();
        this.Z = (int) r12.getY();
        if (this.L == 2) goto L36;
        WeakReference<View> r19 = this.V;
        if (r19 == null) goto L30;
        View r20 = r19.get();
    L31:
        if (r20 == null) goto L36;
        if (r10.l(r20, r18, this.Z) == false) goto L36;
        this.Y = r12.getPointerId(r12.getActionIndex());
        this.f4406a0 = true;
        goto L36
    L30:
        r20 = null;
    L36:
        if (this.Y == (-1)) goto L38;
    L40:
        boolean r110 = false;
    L41:
        this.N = r110;
        goto L43
    L38:
        if (r10.l(r11, r18, this.Z) == true) goto L40;
        r110 = true;
        goto L41
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout r10, V r11, int r12) {
        WeakHashMap<View, h0> r8 = w.f8437a;
        if (w.d.b(r10) == true) goto L5;
    L7:
        int r13 = 0;
        if (this.U != null) goto L46;
        this.f4414g = r10.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        if (this.f4421n == false) goto L12;
    L14:
        boolean r14 = false;
    L16:
        if (this.f4422o == false) goto L18;
    L29:
        w.i.u(r11, new o(new k9.b(this, r14), new q.b(w.e.f(r11), r11.getPaddingTop(), w.e.e(r11), r11.getPaddingBottom())));
        if (w.g.b(r11) == false) goto L32;
        w.h.c(r11);
    L33:
        r11.setWindowInsetsAnimationCallback(new l0.c.a(new k9.d(r11)));
        this.U = new WeakReference(r11);
        new v9.a(r11);
        f r15 = this.f4416i;
        if (r15 == null) goto L39;
        w.d.q(r11, r15);
        f r16 = this.f4416i;
        float r17 = this.H;
        if (r17 != (-1.0f)) goto L38;
        r17 = w.i.i(r11);
    L38:
        r16.j(r17);
    L42:
        O();
        if (w.d.c(r11) != 0) goto L46;
        w.d.s(r11, 1);
        goto L46
    L39:
        ColorStateList r18 = this.f4417j;
        if (r18 == null) goto L42;
        w.i.q(r11, r18);
        goto L42
    L32:
        r11.addOnAttachStateChangeListener(new p());
        goto L33
    L18:
        if (this.f4423p == true) goto L29;
        if (this.f4424q == true) goto L29;
        if (this.f4426s == true) goto L29;
        if (this.f4427t == true) goto L29;
        if (this.f4428u == true) goto L29;
        if (r14 == true) goto L29;
    L12:
        if (this.f4413f == true) goto L14;
        r14 = true;
    L46:
        if (this.M != null) goto L48;
        this.M = new o0.c(r10.getContext(), r10, this.d0);
    L48:
        int r19 = r11.getTop();
        r10.q(r11, r12);
        this.S = r10.getWidth();
        this.T = r10.getHeight();
        int r20 = r11.getHeight();
        this.R = r20;
        int r110 = this.T;
        int r21 = r110 - r20;
        int r22 = this.f4430w;
        if (r21 < r22) goto L51;
    L60:
        this.D = Math.max(0, this.T - this.R);
        this.E = (int) ((1.0f - this.F) * this.T);
        y();
        int r23 = this.L;
        if (r23 != 3) goto L64;
        int r24 = E();
    L74:
        r11.offsetTopAndBottom(r24);
    L79:
        P(this.L, false);
        this.V = new WeakReference(C(r11));
    L80:
        ArrayList<c> r25 = this.W;
        if (r13 >= r25.size()) goto L83;
        r25.get(r13).getClass();
        r13 = r13 + 1;
        goto L80
    L83:
        return true;
    L64:
        if (r23 != 6) goto L67;
        r24 = this.E;
        goto L74
    L67:
        if (this.I == false) goto L72;
        if (r23 != 5) goto L72;
        r24 = this.T;
    L72:
        if (r23 != 4) goto L75;
        r24 = this.G;
        goto L74
    L75:
        if (r23 != 1) goto L77;
    L78:
        r11.offsetTopAndBottom(r19 - r11.getTop());
        goto L79
    L77:
        if (r23 != 2) goto L79;
    L51:
        if (this.f4425r == false) goto L55;
        int r26 = this.f4419l;
        if (r26 == (-1)) goto L59;
    L58:
        r110 = Math.min(r110, r26);
    L59:
        this.R = r110;
        goto L60
    L55:
        r110 = r110 - r22;
        r26 = this.f4419l;
        if (r26 != (-1)) goto L58;
    L5:
        if (w.d.b(r11) == true) goto L7;
        r11.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r15 = r8.getPaddingLeft();
        int r16 = D(r11, (((r8.getPaddingRight() + r15) + r14.leftMargin) + r14.rightMargin) + r12, this.f4418k, r14.width);
        int r17 = r8.getPaddingTop();
        r10.measure(r16, D(r13, (((r8.getPaddingBottom() + r17) + r14.topMargin) + r14.bottomMargin) + 0, this.f4419l, r14.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean k(CoordinatorLayout r8, View r10, View r11, float r12) {
        WeakReference<View> r13 = this.V;
        if (r13 != null) goto L5;
    L10:
        return false;
    L5:
        if (r11 != r13.get()) goto L10;
        if (this.L == 3) goto L10;
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void l(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int[] r14, int r15) {
        if (r15 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r16 = this.V;
        if (r16 == null) goto L8;
        View r17 = r16.get();
    L9:
        if (r11 == r17) goto L11;
        return;
    L11:
        int r18 = r10.getTop();
        int r19 = r18 - r13;
        if (r13 > 0) goto L14;
        if (r13 < 0) goto L23;
    L36:
        B(r10.getTop());
        this.O = r13;
        this.P = true;
        return;
    L23:
        if (r11.canScrollVertically(-1) == true) goto L36;
        int r20 = this.G;
        if (r19 <= r20) goto L32;
        if (this.I == true) goto L32;
        int r21 = r18 - r20;
        r14[1] = r21;
        int r22 = -r21;
        WeakHashMap<View, h0> r23 = w.f8437a;
        r10.offsetTopAndBottom(r22);
        int r24 = 4;
    L30:
        L(r24);
    L32:
        if (this.K == true) goto L34;
        return;
    L34:
        r14[1] = r13;
    L20:
        int r25 = -r13;
        WeakHashMap<View, h0> r26 = w.f8437a;
        r10.offsetTopAndBottom(r25);
        L(1);
        goto L36
    L14:
        if (r19 >= E()) goto L17;
        int r27 = r18 - E();
        r14[1] = r27;
        int r28 = -r27;
        WeakHashMap<View, h0> r29 = w.f8437a;
        r10.offsetTopAndBottom(r28);
        r24 = 3;
        goto L30
    L17:
        if (this.K == true) goto L19;
        return;
    L19:
        r14[1] = r13;
        goto L20
    L8:
        r17 = null;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void p(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void r(CoordinatorLayout r8, V r10, Parcelable r11) {
        SavedState r12 = (SavedState) r11;
        int r13 = this.f4405a;
        if (r13 != 0) goto L6;
    L22:
        int r14 = r12.f4434m;
        if (r14 == 1) goto L27;
        if (r14 == 2) goto L27;
        this.L = r14;
        return;
    L27:
        this.L = 4;
        return;
    L6:
        if (r13 != (-1)) goto L8;
    L9:
        this.f4412e = r12.f4435n;
    L10:
        if (r13 != (-1)) goto L12;
    L13:
        this.f4407b = r12.f4436o;
    L14:
        if (r13 != (-1)) goto L16;
    L17:
        this.I = r12.f4437p;
    L18:
        if (r13 != (-1)) goto L20;
    L21:
        this.J = r12.f4438q;
        goto L22
    L20:
        if ((r13 & 8) != 8) goto L22;
    L16:
        if ((r13 & 4) != 4) goto L18;
    L12:
        if ((r13 & 2) != 2) goto L14;
    L8:
        if ((r13 & 1) != 1) goto L10;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable s(View r8, CoordinatorLayout r10) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean u(CoordinatorLayout r8, V r10, View r11, View r12, int r13, int r14) {
        this.O = 0;
        this.P = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void w(CoordinatorLayout r8, V r10, View r11, int r12) {
        int r13 = 3;
        if (r10.getTop() != E()) goto L6;
        L(3);
        return;
    L6:
        WeakReference<View> r14 = this.V;
        if (r14 != null) goto L9;
        return;
    L9:
        if (r11 == r14.get()) goto L11;
        return;
    L11:
        if (this.P == true) goto L14;
        return;
    L14:
        if (this.O <= 0) goto L22;
        if (this.f4407b == false) goto L19;
    L52:
        N(r10, r13, false);
        this.P = false;
        return;
    L19:
        if (r10.getTop() <= this.E) goto L52;
    L50:
        r13 = 6;
        goto L52
    L22:
        if (this.I == false) goto L31;
        VelocityTracker r15 = this.X;
        if (r15 != null) goto L26;
        float r16 = 0.0f;
    L28:
        if (M(r10, r16) == false) goto L31;
        r13 = 5;
        goto L52
    L26:
        r15.computeCurrentVelocity(1000, this.f4409c);
        r16 = this.X.getYVelocity(this.Y);
    L31:
        if (this.O != 0) goto L46;
        int r17 = r10.getTop();
        if (this.f4407b == true) goto L35;
        int r18 = this.E;
        if (r17 >= r18) goto L43;
        if (r17 >= Math.abs(r17 - this.G)) goto L50;
    L43:
        if (Math.abs(r17 - r18) < Math.abs(r17 - this.G)) goto L50;
    L51:
        r13 = 4;
        goto L52
    L35:
        if (Math.abs(r17 - this.D) >= Math.abs(r17 - this.G)) goto L51;
    L46:
        if (this.f4407b == true) goto L51;
        int r19 = r10.getTop();
        if (Math.abs(r19 - this.E) >= Math.abs(r19 - this.G)) goto L51;
        goto L50
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r8, V r10, MotionEvent r11) {
        boolean r12 = false;
        if (r10.isShown() == true) goto L5;
        return false;
    L5:
        int r13 = r11.getActionMasked();
        int r14 = this.L;
        if (r14 != 1) goto L9;
        if (r13 != 0) goto L9;
        return true;
    L9:
        o0.c r15 = this.M;
        if (r15 != null) goto L12;
    L15:
        boolean r16 = false;
    L16:
        if (r16 == false) goto L18;
        r15.k(r11);
    L18:
        if (r13 != 0) goto L23;
        this.Y = -1;
        this.Z = -1;
        VelocityTracker r17 = this.X;
        if (r17 == null) goto L23;
        r17.recycle();
        this.X = null;
    L23:
        if (this.X != null) goto L25;
        this.X = VelocityTracker.obtain();
    L25:
        this.X.addMovement(r11);
        if (this.M != null) goto L28;
    L32:
        if (r12 == false) goto L41;
        if (r13 != 2) goto L41;
        if (this.N == true) goto L41;
        float r18 = Math.abs(this.Z - r11.getY());
        o0.c r19 = this.M;
        if (r18 <= r19.f9589b) goto L41;
        r19.b(r10, r11.getPointerId(r11.getActionIndex()));
    L41:
        return !this.N;
    L28:
        if (this.K == false) goto L30;
    L31:
        r12 = true;
        goto L32
    L30:
        if (this.L != 1) goto L32;
    L12:
        if (this.K == true) goto L14;
        if (r14 != 1) goto L15;
    L14:
        r16 = true;
        goto L16
    }

    public final void y() {
        int r8 = A();
        if (this.f4407b == false) goto L5;
        this.G = Math.max(this.T - r8, this.D);
        return;
    L5:
        this.G = this.T - r8;
    }

    public final float z() {
        float r8 = 0.0f;
        if (this.f4416i == null) goto L29;
        WeakReference<V> r10 = this.U;
        if (r10 == null) goto L29;
        if (r10.get() == null) goto L29;
        V r11 = this.U.get();
        if (G() == false) goto L29;
        WindowInsets r12 = r11.getRootWindowInsets();
        if (r12 == null) goto L29;
        f r13 = this.f4416i;
        float r14 = r13.f139a.f156a.f184e.a(r13.h());
        RoundedCorner r15 = r12.getRoundedCorner(0);
        if (r15 == null) goto L19;
        float r16 = r15.getRadius();
        if (r16 <= 0.0f) goto L19;
        if (r14 <= 0.0f) goto L19;
        float r17 = r16 / r14;
    L20:
        f r18 = this.f4416i;
        float r19 = r18.f139a.f156a.f185f.a(r18.h());
        RoundedCorner r20 = r12.getRoundedCorner(1);
        if (r20 == null) goto L28;
        float r21 = r20.getRadius();
        if (r21 <= 0.0f) goto L28;
        if (r19 <= 0.0f) goto L28;
        r8 = r21 / r19;
    L28:
        return Math.max(r17, r8);
    L19:
        r17 = 0.0f;
    L29:
        return 0.0f;
    }

    public BottomSheetBehavior(Context r13, AttributeSet r14) {
        super(r13, r14);
        this.f4405a = 0;
        this.f4407b = true;
        this.f4418k = -1;
        this.f4419l = -1;
        this.A = new d(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.f4410c0 = new SparseIntArray();
        this.d0 = new b(this);
        this.f4415h = r13.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray r8 = r13.obtainStyledAttributes(r14, g9.a.f7761b);
        int r10 = 3;
        if (r8.hasValue(3) == false) goto L6;
        this.f4417j = x9.c.a(r13, r8, 3);
    L6:
        if (r8.hasValue(21) == false) goto L8;
        this.f4432y = new j(j.b(r13, r14, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal));
    L8:
        j r15 = this.f4432y;
        if (r15 == null) goto L15;
        f r11 = new f(r15);
        this.f4416i = r11;
        r11.i(r13);
        ColorStateList r16 = this.f4417j;
        if (r16 == null) goto L14;
        this.f4416i.k(r16);
        goto L15
    L14:
        TypedValue r17 = new TypedValue();
        r13.getTheme().resolveAttribute(android.R.attr.colorBackground, r17, true);
        this.f4416i.setTint(r17.data);
    L15:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{z(), 1.0f});
        this.B = r12;
        r12.setDuration(500);
        this.B.addUpdateListener(new k9.a(this));
        this.H = r8.getDimension(2, -1.0f);
        if (r8.hasValue(0) == false) goto L19;
        this.f4418k = r8.getDimensionPixelSize(0, -1);
    L19:
        if (r8.hasValue(1) == false) goto L21;
        this.f4419l = r8.getDimensionPixelSize(1, -1);
    L21:
        TypedValue r18 = r8.peekValue(9);
        if (r18 == null) goto L26;
        int r19 = r18.data;
        if (r19 != (-1)) goto L26;
        J(r19);
    L27:
        boolean r110 = r8.getBoolean(8, false);
        if (this.I == r110) goto L35;
        this.I = r110;
        if (r110 == false) goto L32;
    L34:
        O();
        goto L35
    L32:
        if (this.L != 5) goto L34;
        K(4);
    L35:
        this.f4421n = r8.getBoolean(13, false);
        boolean r20 = r8.getBoolean(6, true);
        if (this.f4407b == r20) goto L48;
        this.f4407b = r20;
        if (this.U == null) goto L42;
        y();
    L42:
        if (this.f4407b == true) goto L44;
    L46:
        r10 = this.L;
    L47:
        L(r10);
        P(this.L, true);
        O();
        goto L48
    L44:
        if (this.L != 6) goto L46;
    L48:
        this.J = r8.getBoolean(12, false);
        this.K = r8.getBoolean(4, true);
        this.f4405a = r8.getInt(10, 0);
        float r111 = r8.getFloat(7, 0.5f);
        if (r111 <= 0.0f) goto L64;
        if (r111 >= 1.0f) goto L64;
        this.F = r111;
        if (this.U == null) goto L55;
        this.E = (int) ((1.0f - r111) * this.T);
    L55:
        TypedValue r112 = r8.peekValue(5);
        if (r112 != null) goto L58;
    L60:
        int r113 = r8.getDimensionPixelOffset(5, 0);
    L61:
        I(r113);
        this.f4411d = r8.getInt(11, 500);
        this.f4422o = r8.getBoolean(17, false);
        this.f4423p = r8.getBoolean(18, false);
        this.f4424q = r8.getBoolean(19, false);
        this.f4425r = r8.getBoolean(20, true);
        this.f4426s = r8.getBoolean(14, false);
        this.f4427t = r8.getBoolean(15, false);
        this.f4428u = r8.getBoolean(16, false);
        this.f4431x = r8.getBoolean(23, true);
        r8.recycle();
        this.f4409c = ViewConfiguration.get(r13).getScaledMaximumFlingVelocity();
        return;
    L58:
        if (r112.type != 16) goto L60;
        r113 = r112.data;
    L64:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    L26:
        J(r8.getDimensionPixelSize(9, -1));
        goto L27
    }
}
