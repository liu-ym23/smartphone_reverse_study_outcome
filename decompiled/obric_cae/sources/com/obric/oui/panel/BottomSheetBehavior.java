package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public boolean A;
    public HashMap B;
    public final boolean C;
    public final boolean D;
    public final int E;
    public final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.obric.oui.panel.b f6382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WeakReference<V> f6387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference<View> f6388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<c> f6389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f6390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6392z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f6393m;

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
            this.f6393m = r8.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f6393m);
        }

        public SavedState(android.view.AbsSavedState r8, int r10) {
            super(r8);
            this.f6393m = r10;
        }
    }

    public class a extends com.obric.oui.panel.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f6394a;

        public a(BottomSheetBehavior r8) {
            this.f6394a = r8;
        }

        @Override // com.obric.oui.panel.b.c
        public final int a(View r8, int r10, int r11) {
            return r8.getLeft();
        }

        @Override // com.obric.oui.panel.b.c
        public final int b(View r8, int r10, int r11) {
            BottomSheetBehavior r12 = this.f6394a;
            int r13 = r12.C();
            if (r12.f6377k == false) goto L5;
            int r14 = r12.f6386t;
        L7:
            return t2.b.p(r10, r13, r14);
        L5:
            r14 = r12.f6376j;
            goto L7
        }

        @Override // com.obric.oui.panel.b.c
        public final int c(View r8) {
            BottomSheetBehavior r10 = this.f6394a;
            if (r10.f6377k == false) goto L7;
            return r10.f6386t;
        L7:
            return r10.f6376j;
        }

        @Override // com.obric.oui.panel.b.c
        public final void d(int r8) {
            if (r8 != 1) goto L8;
            BottomSheetBehavior r10 = this.f6394a;
            if (r10.f6378l == false) goto L9;
            r10.E(1);
            return;
        L9:
            return;
        }

        @Override // com.obric.oui.panel.b.c
        public final void e(View r8, int r10, int r11, int r12, int r13) {
            this.f6394a.A(r11);
        }

        @Override // com.obric.oui.panel.b.c
        public final void f(View r8, float r10, float r11) {
            BottomSheetBehavior r12 = this.f6394a;
            int[] r13 = BottomSheetBehavior.y(r12, r8, r10, r11);
            int r14 = r13[0];
            int r15 = r13[1];
            r12.f6381o = r15;
            com.obric.oui.panel.b r16 = r12.f6382p;
            int r17 = r8.getLeft();
            if (r16.f6422s == false) goto L10;
            if (r16.h(r17, r14, (int) r16.f6415l.getXVelocity(r16.f6406c), (int) r16.f6415l.getYVelocity(r16.f6406c)) == false) goto L7;
            r12.E(2);
            e r18 = new e(r12, r8, r15);
            WeakHashMap<View, h0> r19 = w.f8437a;
            w.d.m(r8, r18);
            return;
        L7:
            r12.E(r15);
            return;
        L10:
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }

        @Override // com.obric.oui.panel.b.c
        public final boolean g(View r8, int r10) {
            BottomSheetBehavior r11 = this.f6394a;
            int r12 = r11.f6380n;
            if (r12 != 1) goto L6;
            return false;
        L6:
            if (r11.A == false) goto L9;
            return false;
        L9:
            if (r12 == 3) goto L11;
        L17:
            WeakReference<V> r13 = r11.f6387u;
            if (r13 != null) goto L20;
            return false;
        L20:
            if (r13.get() == r8) goto L22;
            return false;
        L22:
            return true;
        L11:
            if (r11.f6391y != r10) goto L17;
            View r14 = r11.f6388v.get();
            if (r14 == null) goto L17;
            if (r14.canScrollVertically(-1) == false) goto L17;
            return false;
        }
    }

    public class b extends com.obric.oui.panel.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f6395a;

        public b(BottomSheetBehavior r8) {
            this.f6395a = r8;
        }

        @Override // com.obric.oui.panel.b.c
        public final int a(View r8, int r10, int r11) {
            this.f6395a.F.getClass();
            return r8.getLeft();
        }

        @Override // com.obric.oui.panel.b.c
        public final int b(View r8, int r10, int r11) {
            return this.f6395a.F.b(r8, r10, r11);
        }

        @Override // com.obric.oui.panel.b.c
        public final int c(View r8) {
            return this.f6395a.F.c(r8);
        }

        @Override // com.obric.oui.panel.b.c
        public final void d(int r8) {
            this.f6395a.F.d(r8);
        }

        @Override // com.obric.oui.panel.b.c
        public final void e(View r8, int r10, int r11, int r12, int r13) {
            this.f6395a.F.e(r8, r10, r11, r12, r13);
        }

        @Override // com.obric.oui.panel.b.c
        public final void f(View r8, float r10, float r11) {
            BottomSheetBehavior r12 = this.f6395a;
            int[] r13 = BottomSheetBehavior.y(r12, r8, r10, r11);
            int r14 = r13[0];
            r12.f6381o = r13[1];
            r12.getClass();
            r8.getLeft();
            throw null;
        }

        @Override // com.obric.oui.panel.b.c
        public final boolean g(View r8, int r10) {
            return this.f6395a.F.g(r8, r10);
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a();

        public abstract void b();
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f6396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6397b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f6398m;

        public d(BottomSheetBehavior r8, View r10, int r11) {
            this.f6398m = r8;
            this.f6396a = r10;
            this.f6397b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior r8 = this.f6398m;
            r8.getClass();
            r8.E(this.f6397b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f6399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6400b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f6401m;

        public e(BottomSheetBehavior r8, View r10, int r11) {
            this.f6401m = r8;
            this.f6399a = r10;
            this.f6400b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior r8 = this.f6401m;
            com.obric.oui.panel.b r10 = r8.f6382p;
            if (r10 == null) goto L27;
            boolean r11 = false;
            if (r10.f6404a != 2) goto L23;
            OverScroller r12 = r10.f6419p;
            boolean r13 = r12.computeScrollOffset();
            int r14 = r12.getCurrX();
            int r15 = r12.getCurrY();
            int r16 = r14 - r10.f6421r.getLeft();
            int r17 = r15 - r10.f6421r.getTop();
            if (r16 == 0) goto L9;
            View r18 = r10.f6421r;
            WeakHashMap<View, h0> r19 = w.f8437a;
            r18.offsetLeftAndRight(r16);
        L9:
            if (r17 == 0) goto L11;
            View r20 = r10.f6421r;
            WeakHashMap<View, h0> r21 = w.f8437a;
            r20.offsetTopAndBottom(r17);
        L11:
            if (r16 != 0) goto L13;
            if (r17 != 0) goto L13;
        L14:
            if (r13 == true) goto L16;
        L20:
            if (r13 == true) goto L23;
            r10.f6423t.post(r10.f6425v);
            goto L23
        L16:
            if (r14 != r12.getFinalX()) goto L20;
            if (r15 != r12.getFinalY()) goto L20;
            r12.abortAnimation();
            r13 = false;
        L13:
            r10.f6420q.e(r10.f6421r, r14, r15, r16, r17);
        L23:
            if (r10.f6404a != 2) goto L25;
            r11 = true;
        L25:
            if (r11 == false) goto L27;
            WeakHashMap<View, h0> r22 = w.f8437a;
            w.d.m(this.f6399a, this);
            return;
        L27:
            r8.E(this.f6400b);
        }
    }

    public BottomSheetBehavior() {
        this.f6367a = true;
        this.f6368b = -1;
        this.f6378l = true;
        this.f6379m = false;
        this.f6380n = 4;
        this.f6381o = 4;
        this.f6389w = new ArrayList();
        this.C = true;
        this.D = true;
        this.E = 600;
        this.F = new a(this);
        new b(this);
    }

    public static int[] y(BottomSheetBehavior r8, View r10, float r11, float r12) {
        int r13 = 6;
        int r14 = 3;
        if (r12 >= 0.0f) goto L13;
        r8.getClass();
        if (Math.abs(r12) <= 1500.0f) goto L13;
        if (r8.f6367a == false) goto L9;
        int r15 = r8.f6374h;
    L44:
        return new int[]{r15, r14};
    L9:
        int r16 = r10.getTop();
        r15 = r8.f6375i;
        if (r16 > r15) goto L42;
    L36:
        r15 = 0;
    L37:
        r13 = 3;
    L42:
        r14 = r13;
    L13:
        if (r8.f6377k == false) goto L22;
        if (r8.F(r10, r12) == false) goto L22;
        if (r10.getTop() <= r8.f6376j) goto L19;
    L20:
        r15 = r8.f6386t;
        r14 = 5;
        goto L44
    L19:
        if (Math.abs(r11) < Math.abs(r12)) goto L20;
    L22:
        if (r12 != 0.0f) goto L24;
    L27:
        int r17 = r10.getTop();
        if (r8.f6367a == true) goto L30;
        int r18 = r8.f6375i;
        if (r17 >= r18) goto L39;
        if (r17 < Math.abs(r17 - r8.f6376j)) goto L36;
    L40:
        r15 = r8.f6375i;
        goto L42
    L39:
        if (Math.abs(r17 - r18) < Math.abs(r17 - r8.f6376j)) goto L40;
    L41:
        r15 = r8.f6376j;
        r13 = 4;
        goto L42
    L30:
        if (Math.abs(r17 - r8.f6374h) >= Math.abs(r17 - r8.f6376j)) goto L41;
        r15 = r8.f6374h;
        goto L37
    L24:
        if (Math.abs(r11) > Math.abs(r12)) goto L27;
        r15 = r8.f6376j;
        r14 = 4;
        goto L44
    }

    public final void A(int r8) {
        if (this.f6387u.get() == null) goto L14;
        ArrayList<c> r10 = this.f6389w;
        if (r10.isEmpty() == true) goto L17;
        int r11 = 0;
        if (r8 <= this.f6376j) goto L12;
    L9:
        if (r11 >= r10.size()) goto L18;
        r10.get(r11).a();
        r11 = r11 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r11 >= r10.size()) goto L19;
        r10.get(r11).a();
        r11 = r11 + 1;
        goto L12
    L19:
        return;
    L17:
        return;
    }

    public final View B(View r8) {
        if (r8 != null) goto L5;
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
        View r14 = B(r11.getChildAt(r13));
        if (r14 != null) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return r14;
    L16:
        return null;
    }

    public final int C() {
        if (this.f6367a == true) goto L7;
        return 0;
    L7:
        return this.f6374h;
    }

    public final void D(int r8) {
        boolean r10 = true;
        if (r8 != (-1)) goto L8;
        if (this.f6371e == true) goto L12;
        this.f6371e = true;
    L14:
        if (r10 == true) goto L16;
        return;
    L16:
        if (this.f6380n != 4) goto L24;
        WeakReference<V> r11 = this.f6387u;
        if (r11 == null) goto L25;
        V r12 = r11.get();
        if (r12 == null) goto L26;
        r12.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r10 = false;
        goto L14
    L8:
        if (this.f6371e == false) goto L10;
    L13:
        this.f6371e = false;
        this.f6370d = Math.max(0, r8);
        this.f6376j = this.f6386t - r8;
        goto L14
    L10:
        if (this.f6370d == r8) goto L12;
        goto L12
    }

    public final void E(int r8) {
        if (this.f6380n != r8) goto L5;
        return;
    L5:
        this.f6380n = r8;
        int r10 = 0;
        if (r8 != 6) goto L8;
    L15:
        G(true);
    L16:
        V r11 = this.f6387u.get();
    L17:
        ArrayList<c> r12 = this.f6389w;
        if (r10 >= r12.size()) goto L20;
        r12.get(r10).b();
        r10 = r10 + 1;
        goto L17
    L20:
        return;
    L8:
        if (r8 == 3) goto L15;
        if (r8 != 5) goto L13;
    L14:
        G(false);
        goto L16
    L13:
        if (r8 != 4) goto L16;
        goto L14
    }

    public final boolean F(View r8, float r10) {
        if (this.f6379m == false) goto L6;
        return true;
    L6:
        if (r10 != 0.0f) goto L12;
        int r11 = this.f6386t - C();
        if (r8.getTop() <= (C() + (r11 / 2))) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (this.f6381o != 4) goto L21;
        if (this.f6370d <= (l6.a.Q(r8.getContext()) / 2)) goto L21;
        if (r10 <= (this.f6369c * 0.08f)) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((Math.abs(((r10 * 0.1f) + r8.getTop()) - this.f6376j) / this.f6370d) <= 0.5f) goto L24;
        return true;
    L24:
        return false;
    }

    public final void G(boolean r8) {
        WeakReference<V> r10 = this.f6387u;
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
        if (r14 >= r13) goto L28;
        View r15 = r12.getChildAt(r14);
        if (r15 == this.f6387u.get()) goto L27;
        HashMap r16 = this.B;
        if (r8 == true) goto L25;
        if (r16 == null) goto L27;
        if (r16.containsKey(r15) == false) goto L27;
        int r17 = ((Integer) this.B.get(r15)).intValue();
        WeakHashMap<View, h0> r18 = w.f8437a;
    L26:
        w.d.s(r15, r17);
        goto L27
    L25:
        r16.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
        WeakHashMap<View, h0> r19 = w.f8437a;
        r17 = 4;
    L27:
        r14 = r14 + 1;
        goto L15
    L28:
        if (r8 == true) goto L36;
        this.B = null;
        return;
    L36:
        return;
    L11:
        if (this.B != null) goto L13;
        this.B = new HashMap(r13);
        goto L14
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout r18, V r19, MotionEvent r20) {
        boolean r8 = false;
        boolean r10 = true;
        if (r19.isShown() == true) goto L5;
    L135:
        this.f6383q = true;
        return false;
    L5:
        if (this.f6378l == false) goto L135;
        int r11 = r20.getActionMasked();
        if (r11 != 0) goto L13;
        this.f6391y = -1;
        VelocityTracker r12 = this.f6390x;
        if (r12 == null) goto L13;
        r12.recycle();
        this.f6390x = null;
    L13:
        if (this.f6390x != null) goto L15;
        this.f6390x = VelocityTracker.obtain();
    L15:
        this.f6390x.addMovement(r20);
        if (r11 == 0) goto L24;
        if (r11 == 1) goto L20;
        if (r11 == 3) goto L20;
    L40:
        if (this.f6383q == true) goto L115;
        com.obric.oui.panel.b r13 = this.f6382p;
        if (r13 == null) goto L115;
        int r14 = r20.getActionMasked();
        int r15 = r20.getActionIndex();
        if (r14 != 0) goto L47;
        r13.a();
    L47:
        if (r13.f6415l != null) goto L49;
        r13.f6415l = VelocityTracker.obtain();
    L49:
        r13.f6415l.addMovement(r20);
        com.obric.oui.panel.b.c r16 = r13.f6420q;
        if (r14 == 0) goto L101;
        if (r14 == 1) goto L100;
        if (r14 == 2) goto L70;
        if (r14 == 3) goto L100;
        if (r14 != 5) goto L57;
        int r17 = r20.getPointerId(r15);
        float r110 = r20.getX(r15);
        float r111 = r20.getY(r15);
        r13.l(r110, r111, r17);
        int r112 = r13.f6404a;
        if (r112 == 0) goto L63;
        if (r112 != 2) goto L110;
        View r113 = r13.g((int) r110, (int) r111);
        if (r113 != r13.f6421r) goto L110;
        r13.o(r113, r17);
    L110:
        if (r13.f6404a != 1) goto L112;
        boolean r114 = true;
    L113:
        if (r114 == false) goto L115;
        return true;
    L112:
        r114 = false;
        goto L113
    L63:
        if ((r13.f6411h[r17] & 0) == 0) goto L110;
    L108:
        r16.getClass();
        goto L110
    L57:
        if (r14 != 6) goto L110;
        r13.e(r20.getPointerId(r15));
        goto L110
    L70:
        if (r13.f6407d == null) goto L110;
        if (r13.f6408e == null) goto L110;
        int r21 = r20.getPointerCount();
        int r115 = 0;
    L75:
        if (r115 >= r21) goto L99;
        int r116 = r20.getPointerId(r115);
        if (r13.i(r116) == false) goto L98;
        float r117 = r20.getX(r115);
        float r118 = r20.getY(r115);
        float r119 = r117 - r13.f6407d[r116];
        float r22 = r118 - r13.f6408e[r116];
        View r120 = r13.g((int) r117, (int) r118);
        if (r120 != null) goto L82;
    L84:
        boolean r121 = r8;
    L85:
        if (r121 == false) goto L91;
        int r23 = (int) r119;
        r16.a(r120, r120.getLeft() + r23, r23);
        int r24 = r120.getTop();
        int r25 = (int) r22;
        int r26 = r16.b(r120, r24 + r25, r25);
        int r27 = r16.c(r120);
        if (r27 == 0) goto L99;
        if (r27 <= 0) goto L91;
        if (r26 == r24) goto L99;
    L91:
        r13.k(r119, r22, r116);
        if (r13.f6404a == 1) goto L99;
        if (r121 == false) goto L98;
        if (r13.o(r120, r116) == false) goto L98;
    L82:
        if (r13.d(r120, r22) == false) goto L84;
        r121 = r10;
    L98:
        r115 = r115 + 1;
        r8 = false;
        r10 = true;
    L99:
        r13.m(r20);
    L100:
        r13.a();
        goto L110
    L101:
        float r28 = r20.getX();
        float r29 = r20.getY();
        int r30 = r20.getPointerId(0);
        r13.l(r28, r29, r30);
        View r31 = r13.g((int) r28, (int) r29);
        if (r31 != r13.f6421r) goto L107;
        if (r13.f6404a != 2) goto L107;
        r13.o(r31, r30);
    L107:
        if ((r13.f6411h[r30] & 0) == 0) goto L110;
    L115:
        WeakReference<View> r32 = this.f6388v;
        if (r32 == null) goto L118;
        View r33 = r32.get();
        int r34 = 2;
    L119:
        if (r11 != r34) goto L133;
        if (r33 == null) goto L133;
        if (this.f6383q == true) goto L133;
        if (this.f6380n == 1) goto L133;
        if (r18.l(r33, (int) r20.getX(), (int) r20.getY()) == true) goto L133;
        if (this.f6382p == null) goto L133;
        if (Math.abs(this.f6392z - r20.getY()) <= this.f6382p.f6405b) goto L133;
        return true;
    L133:
        return false;
    L118:
        r34 = 2;
        r33 = null;
    L20:
        this.A = false;
        this.f6391y = -1;
        if (this.f6383q == false) goto L40;
        this.f6383q = false;
        return false;
    L24:
        int r35 = (int) r20.getX();
        this.f6392z = (int) r20.getY();
        WeakReference<View> r122 = this.f6388v;
        if (r122 == null) goto L27;
        View r123 = r122.get();
    L28:
        if (r123 == null) goto L33;
        if (r18.l(r123, r35, this.f6392z) == false) goto L33;
        this.f6391y = r20.getPointerId(r20.getActionIndex());
        this.A = true;
    L33:
        if (this.f6391y == (-1)) goto L35;
    L37:
        boolean r36 = false;
    L38:
        this.f6383q = r36;
        goto L40
    L35:
        if (r18.l(r19, r35, this.f6392z) == true) goto L37;
        r36 = true;
        goto L38
    L27:
        r123 = null;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout r10, V r11, int r12) {
        if (this.C == false) goto L9;
        WeakHashMap<View, h0> r8 = w.f8437a;
        if (w.d.b(r10) == false) goto L9;
        if (w.d.b(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
    L9:
        int r13 = r11.getTop();
        r10.q(r11, r12);
        this.f6386t = r10.getHeight();
        boolean r14 = this.f6371e;
        int r15 = this.f6368b;
        if (r14 == true) goto L12;
        int r16 = this.f6370d;
    L28:
        this.f6373g = r16;
        if (r15 > 0) goto L31;
    L33:
        int r17 = Math.max(0, this.f6386t - r11.getHeight());
    L34:
        this.f6374h = r17;
        this.f6375i = this.f6386t / 2;
        z();
        int r18 = this.f6380n;
        if (r18 != 3) goto L38;
        int r19 = C();
    L48:
        WeakHashMap<View, h0> r20 = w.f8437a;
        r11.offsetTopAndBottom(r19);
    L53:
        if (this.f6382p != null) goto L55;
        com.obric.oui.panel.b r110 = new com.obric.oui.panel.b(r10.getContext(), r10, this.F);
        this.f6382p = r110;
        r110.f6424u = this.E;
    L55:
        this.f6387u = new WeakReference(r11);
        this.f6388v = new WeakReference(B(r11));
        return true;
    L38:
        if (r18 != 6) goto L41;
        r19 = this.f6375i;
        goto L48
    L41:
        if (this.f6377k == false) goto L46;
        if (r18 != 5) goto L46;
        r19 = this.f6386t;
    L46:
        if (r18 != 4) goto L49;
        r19 = this.f6376j;
        goto L48
    L49:
        if (r18 == 1) goto L51;
        if (r18 != 2) goto L53;
    L51:
        int r21 = r13 - r11.getTop();
        WeakHashMap<View, h0> r111 = w.f8437a;
        r11.offsetTopAndBottom(r21);
        goto L53
    L31:
        if (r11.getHeight() <= r15) goto L33;
        r17 = Math.max(0, this.f6386t - r15);
        goto L34
    L12:
        if (this.f6372f != 0) goto L14;
        this.f6372f = r10.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r112 = r10.getContext().getResources().getConfiguration().fontScale;
        String r22 = "check fontScale:" + r112;
        if (r22 != null) goto L18;
        r22 = "null";
    L18:
        Log.d("debugging", r22);
        if (this.D == false) goto L21;
        double r23 = 0.6d;
    L22:
        double r24 = this.f6372f;
        if (r15 <= 0) goto L25;
        double r25 = r15;
    L26:
        r16 = (int) Math.max(r24, r25);
        goto L28
    L25:
        r25 = ((double) r112) * (((double) this.f6386t) * r23);
        goto L26
    L21:
        r23 = 1.0d;
        goto L22
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean k(CoordinatorLayout r8, View r10, View r11, float r12) {
        if (r11 == this.f6388v.get()) goto L5;
    L8:
        return false;
    L5:
        if (this.f6380n == 3) goto L8;
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void l(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int[] r14, int r15) {
        if (r15 != 1) goto L6;
        return;
    L6:
        if (r11 == this.f6388v.get()) goto L8;
        return;
    L8:
        int r16 = r10.getTop();
        int r17 = r16 - r13;
        boolean r18 = this.f6378l;
        if (r13 > 0) goto L11;
        if (r13 < 0) goto L19;
    L31:
        A(r10.getTop());
        this.f6384r = r13;
        this.f6385s = true;
        return;
    L19:
        if (r11.canScrollVertically(-1) == true) goto L31;
        int r19 = this.f6376j;
        if (r17 > r19) goto L23;
    L27:
        if (r18 == true) goto L29;
        return;
    L29:
        r14[1] = r13;
    L16:
        int r20 = -r13;
        WeakHashMap<View, h0> r21 = w.f8437a;
        r10.offsetTopAndBottom(r20);
        E(1);
        goto L31
    L23:
        if (this.f6377k == true) goto L27;
        int r22 = r16 - r19;
        r14[1] = r22;
        int r23 = -r22;
        WeakHashMap<View, h0> r24 = w.f8437a;
        r10.offsetTopAndBottom(r23);
        int r25 = 4;
    L26:
        E(r25);
        goto L31
    L11:
        if (r17 >= C()) goto L13;
        int r26 = r16 - C();
        r14[1] = r26;
        int r27 = -r26;
        WeakHashMap<View, h0> r28 = w.f8437a;
        r10.offsetTopAndBottom(r27);
        r25 = 3;
        goto L26
    L13:
        if (r18 == true) goto L15;
        return;
    L15:
        r14[1] = r13;
        goto L16
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void r(CoordinatorLayout r8, V r10, Parcelable r11) {
        int r12 = ((SavedState) r11).f6393m;
        if (r12 != 1) goto L5;
    L8:
        this.f6380n = 4;
        return;
    L5:
        if (r12 == 2) goto L8;
        this.f6380n = r12;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable s(View r8, CoordinatorLayout r10) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this.f6380n);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean u(CoordinatorLayout r8, V r10, View r11, View r12, int r13, int r14) {
        this.f6384r = 0;
        this.f6385s = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void w(CoordinatorLayout r8, V r10, View r11, int r12) {
        int r13 = 3;
        if (r10.getTop() != C()) goto L7;
        E(3);
        return;
    L7:
        if (r11 == this.f6388v.get()) goto L9;
        return;
    L9:
        if (this.f6385s == true) goto L12;
        return;
    L12:
        if (this.f6384r <= 0) goto L15;
        int r14 = C();
    L39:
        this.f6381o = r13;
        com.obric.oui.panel.b r15 = this.f6382p;
        int r16 = r10.getLeft();
        r15.f6421r = r10;
        r15.f6406c = -1;
        boolean r17 = r15.h(r16, r14, 0, 0);
        if (r17 == false) goto L42;
    L46:
        if (r17 == false) goto L48;
        E(2);
        e r18 = new e(this, r10, r13);
        WeakHashMap<View, h0> r19 = w.f8437a;
        w.d.m(r10, r18);
    L49:
        this.f6385s = false;
        return;
    L48:
        E(r13);
        goto L49
    L42:
        if (r15.f6404a != 0) goto L46;
        if (r15.f6421r == null) goto L46;
        r15.f6421r = null;
        goto L46
    L15:
        if (this.f6377k == false) goto L24;
        VelocityTracker r20 = this.f6390x;
        if (r20 != null) goto L19;
        float r21 = 0.0f;
    L21:
        if (F(r10, r21) == false) goto L24;
        r14 = this.f6386t;
        r13 = 5;
        goto L39
    L19:
        r20.computeCurrentVelocity(1000, this.f6369c);
        r21 = this.f6390x.getYVelocity(this.f6391y);
    L24:
        if (this.f6384r != 0) goto L38;
        int r22 = r10.getTop();
        if (this.f6367a == true) goto L28;
        int r23 = this.f6375i;
        if (r22 >= r23) goto L36;
        if (r22 >= Math.abs(r22 - this.f6376j)) goto L37;
        r14 = 0;
    L37:
        r14 = this.f6375i;
        r13 = 6;
        goto L39
    L36:
        if (Math.abs(r22 - r23) >= Math.abs(r22 - this.f6376j)) goto L38;
    L28:
        if (Math.abs(r22 - this.f6374h) >= Math.abs(r22 - this.f6376j)) goto L38;
        r14 = this.f6374h;
    L38:
        r14 = this.f6376j;
        r13 = 4;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout r23, V r24, MotionEvent r25) {
        int r8 = 0;
        if (r24.isShown() == true) goto L5;
        return false;
    L5:
        int r10 = r25.getActionMasked();
        if (this.f6380n != 1) goto L10;
        if (r10 != 0) goto L10;
        return true;
    L10:
        if (r10 != 0) goto L15;
        this.f6391y = -1;
        VelocityTracker r11 = this.f6390x;
        if (r11 == null) goto L15;
        r11.recycle();
        this.f6390x = null;
    L15:
        if (this.f6390x != null) goto L17;
        this.f6390x = VelocityTracker.obtain();
    L17:
        this.f6390x.addMovement(r25);
        com.obric.oui.panel.b r12 = this.f6382p;
        if (r12 == null) goto L116;
        int r13 = r25.getActionMasked();
        int r14 = r25.getActionIndex();
        if (r13 != 0) goto L23;
        r12.a();
    L23:
        if (r12.f6415l != null) goto L25;
        r12.f6415l = VelocityTracker.obtain();
    L25:
        r12.f6415l.addMovement(r25);
        com.obric.oui.panel.b.c r15 = r12.f6420q;
        if (r13 == 0) goto L113;
        if (r13 == 1) goto L110;
        if (r13 == 2) goto L80;
        if (r13 == 3) goto L75;
        if (r13 != 5) goto L34;
        int r16 = r25.getPointerId(r14);
        float r17 = r25.getX(r14);
        float r18 = r25.getY(r14);
        r12.l(r17, r18, r16);
        int r19 = (int) r17;
        int r20 = (int) r18;
        if (r12.f6404a != 0) goto L60;
        r12.o(r12.g(r19, r20), r16);
        if ((0 & r12.f6411h[r16]) == 0) goto L116;
    L115:
        r15.getClass();
        goto L116
    L60:
        View r110 = r12.f6421r;
        if (r110 != null) goto L64;
    L72:
        if (r8 == 0) goto L116;
        r12.o(r12.f6421r, r16);
        goto L116
    L64:
        if (r19 < r110.getLeft()) goto L72;
        if (r19 >= r110.getRight()) goto L72;
        if (r20 < r110.getTop()) goto L72;
        if (r20 >= r110.getBottom()) goto L72;
        r8 = 1;
        goto L72
    L34:
        if (r13 != 6) goto L116;
        int r21 = r25.getPointerId(r14);
        if (r12.f6404a == 1) goto L39;
    L54:
        r12.e(r21);
        goto L116
    L39:
        if (r21 != r12.f6406c) goto L54;
        int r22 = r25.getPointerCount();
    L41:
        if (r8 >= r22) goto L51;
        int r111 = r25.getPointerId(r8);
        if (r111 == r12.f6406c) goto L50;
        View r112 = r12.g((int) r25.getX(r8), (int) r25.getY(r8));
        View r113 = r12.f6421r;
        if (r112 != r113) goto L50;
        if (r12.o(r113, r111) == false) goto L50;
        int r26 = r12.f6406c;
    L52:
        if (r26 != (-1)) goto L54;
        r12.j();
    L50:
        r8 = r8 + 1;
        goto L41
    L51:
        r26 = -1;
        goto L52
    L75:
        if (r12.f6404a != 1) goto L112;
        r12.f6422s = true;
        r15.f(r12.f6421r, 0.0f, 0.0f);
        r12.f6422s = false;
        if (r12.f6404a != 1) goto L112;
        r12.n(0);
    L112:
        r12.a();
        goto L116
    L80:
        if (r12.f6404a == 1) goto L82;
        int r27 = r25.getPointerCount();
    L95:
        if (r8 >= r27) goto L108;
        int r28 = r25.getPointerId(r8);
        if (r12.i(r28) == false) goto L107;
        float r29 = r25.getX(r8);
        float r114 = r25.getY(r8);
        float r115 = r29 - r12.f6407d[r28];
        float r116 = r114 - r12.f6408e[r28];
        r12.k(r115, r116, r28);
        if (r12.f6404a == 1) goto L108;
        View r30 = r12.g((int) r29, (int) r114);
        if (r12.d(r30, r116) == false) goto L107;
        if (r12.o(r30, r28) == true) goto L108;
    L107:
        r8 = r8 + 1;
    L108:
        r12.m(r25);
        goto L116
    L82:
        if (r12.i(r12.f6406c) == false) goto L116;
        int r31 = r25.findPointerIndex(r12.f6406c);
        float r32 = r25.getX(r31);
        float r33 = r25.getY(r31);
        float[] r34 = r12.f6409f;
        int r35 = r12.f6406c;
        int r36 = (int) (r32 - r34[r35]);
        int r37 = (int) (r33 - r12.f6410g[r35]);
        int r38 = r12.f6421r.getLeft() + r36;
        int r39 = r12.f6421r.getTop() + r37;
        int r117 = r12.f6421r.getLeft();
        int r118 = r12.f6421r.getTop();
        if (r36 == 0) goto L87;
        r38 = r15.a(r12.f6421r, r38, r36);
        WeakHashMap<View, h0> r119 = w.f8437a;
        r12.f6421r.offsetLeftAndRight(r38 - r117);
    L87:
        int r120 = r38;
        if (r37 == 0) goto L90;
        r39 = r15.b(r12.f6421r, r39, r37);
        WeakHashMap<View, h0> r121 = w.f8437a;
        r12.f6421r.offsetTopAndBottom(r39 - r118);
    L90:
        int r122 = r39;
        if (r36 != 0) goto L93;
        if (r37 == 0) goto L108;
    L93:
        r12.f6420q.e(r12.f6421r, r120, r122, r120 - r117, r122 - r118);
        goto L108
    L110:
        if (r12.f6404a != 1) goto L112;
        r12.j();
        goto L112
    L113:
        float r40 = r25.getX();
        float r41 = r25.getY();
        int r42 = r25.getPointerId(0);
        View r123 = r12.g((int) r40, (int) r41);
        r12.l(r40, r41, r42);
        r12.o(r123, r42);
        if ((0 & r12.f6411h[r42]) != 0) goto L115;
    L116:
        if (r10 != 2) goto L123;
        if (this.f6383q == true) goto L123;
        float r43 = Math.abs(this.f6392z - r25.getY());
        com.obric.oui.panel.b r44 = this.f6382p;
        if (r43 <= r44.f6405b) goto L123;
        r44.b(r24, r25.getPointerId(r25.getActionIndex()));
    L123:
        return !this.f6383q;
    }

    public void z() {
        if (this.f6367a == false) goto L5;
        int r8 = Math.max(this.f6386t - this.f6373g, this.f6374h);
    L6:
        this.f6376j = r8;
        return;
    L5:
        r8 = this.f6386t - this.f6373g;
        goto L6
    }

    public BottomSheetBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f6367a = true;
        this.f6368b = -1;
        this.f6378l = true;
        this.f6379m = false;
        this.f6380n = 4;
        this.f6381o = 4;
        this.f6389w = new ArrayList();
        this.C = true;
        this.D = true;
        this.E = 600;
        this.F = new a(this);
        new b(this);
        TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7761b);
        TypedValue r12 = r11.peekValue(9);
        if (r12 == null) goto L7;
        int r13 = r12.data;
        if (r13 != (-1)) goto L7;
        D(r13);
    L8:
        this.f6377k = r11.getBoolean(8, false);
        boolean r14 = r11.getBoolean(6, true);
        if (this.f6367a == r14) goto L21;
        this.f6367a = r14;
        if (this.f6387u == null) goto L15;
        z();
    L15:
        if (this.f6367a == true) goto L17;
    L19:
        int r15 = this.f6380n;
    L20:
        E(r15);
        goto L21
    L17:
        if (this.f6380n != 6) goto L19;
        r15 = 3;
    L21:
        this.f6379m = r11.getBoolean(12, false);
        r11.recycle();
        this.f6369c = ViewConfiguration.get(r8).getScaledMaximumFlingVelocity();
        return;
    L7:
        D(r11.getDimensionPixelSize(9, -1));
        goto L8
    }
}
