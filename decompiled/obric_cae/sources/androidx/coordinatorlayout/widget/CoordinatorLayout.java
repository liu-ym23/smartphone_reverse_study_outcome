package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import j0.h0;
import j0.m0;
import j0.n;
import j0.o;
import j0.p;
import j0.q;
import j0.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements n, o {
    public static final String D = null;
    public static final Class<?>[] E = null;
    public static final ThreadLocal<Map<String, Constructor<c>>> F = null;
    public static final h G = null;
    public static final i0.e H = null;
    public ViewGroup.OnHierarchyChangeListener A;
    public a B;
    public final p C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x.a<View> f1545b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f1546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f1547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f1548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f1549p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1550q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1551r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f1552s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f1553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f1554u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g f1555v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1556w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public m0 f1557x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1558y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f1559z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SparseArray<Parcelable> f1560m;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            int r11 = r8.readInt();
            int[] r12 = new int[r11];
            r8.readIntArray(r12);
            Parcelable[] r13 = r8.readParcelableArray(r10);
            this.f1560m = new SparseArray(r11);
            int r14 = 0;
        L3:
            if (r14 >= r11) goto L5;
            this.f1560m.append(r12[r14], r13[r14]);
            r14 = r14 + 1;
            goto L3
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            SparseArray<Parcelable> r11 = this.f1560m;
            int r12 = 0;
            if (r11 == null) goto L5;
            int r13 = r11.size();
        L6:
            r8.writeInt(r13);
            int[] r14 = new int[r13];
            Parcelable[] r15 = new Parcelable[r13];
        L7:
            if (r12 >= r13) goto L9;
            r14[r12] = this.f1560m.keyAt(r12);
            r15[r12] = this.f1560m.valueAt(r12);
            r12 = r12 + 1;
            goto L7
        L9:
            r8.writeIntArray(r14);
            r8.writeParcelableArray(r15, r10);
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    public class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f1561a;

        public a(CoordinatorLayout r8) {
            this.f1561a = r8;
        }

        @Override // j0.q
        public final m0 a(View r8, m0 r10) {
            CoordinatorLayout r11 = this.f1561a;
            if (i0.b.a(r11.f1557x, r10) == true) goto L28;
            r11.f1557x = r10;
            boolean r12 = true;
            int r13 = 0;
            if (r10.e() <= 0) goto L7;
            boolean r14 = true;
        L8:
            r11.f1558y = r14;
            if (r14 == false) goto L11;
        L13:
            r12 = false;
        L14:
            r11.setWillNotDraw(r12);
            m0.k r15 = r10.f8409a;
            if (r15.m() == true) goto L27;
            int r16 = r11.getChildCount();
        L18:
            if (r13 >= r16) goto L27;
            View r17 = r11.getChildAt(r13);
            WeakHashMap<View, h0> r18 = w.f8437a;
            if (w.d.b(r17) == false) goto L26;
            if (((f) r17.getLayoutParams()).f1563a == null) goto L26;
            if (r15.m() == true) goto L27;
        L26:
            r13 = r13 + 1;
        L27:
            r11.requestLayout();
            goto L28
        L11:
            if (r11.getBackground() != null) goto L13;
        L7:
            r14 = false;
        L28:
            return r10;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context r8, AttributeSet r10) {
        }

        public boolean a(View r8) {
            return false;
        }

        public boolean b(CoordinatorLayout r8, V r10, View r11) {
            return false;
        }

        public void c(f r8) {
        }

        public boolean d(CoordinatorLayout r8, V r10, View r11) {
            return false;
        }

        public void e(CoordinatorLayout r8, V r10, View r11) {
        }

        public void f() {
        }

        public boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
            return false;
        }

        public boolean h(CoordinatorLayout r8, V r10, int r11) {
            return false;
        }

        public boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            return false;
        }

        public void j(CoordinatorLayout r8, View r10, View r11) {
        }

        public boolean k(CoordinatorLayout r8, View r10, View r11, float r12) {
            return false;
        }

        public void l(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int[] r14, int r15) {
            if (r15 != 0) goto L5;
            m(r8, r10, r11, r13, r14);
            return;
        }

        @Deprecated
        public void m(CoordinatorLayout r8, View r10, View r11, int r12, int[] r13) {
        }

        @Deprecated
        public void n(CoordinatorLayout r8, View r10, View r11, int r12) {
        }

        @Deprecated
        public void o(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int r14, int r15, int r16) {
            if (r16 != 0) goto L5;
            n(r8, r10, r11, r15);
            return;
        }

        public void p(CoordinatorLayout r8, V r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
            r17[0] = r17[0] + r14;
            r17[1] = r17[1] + r15;
            o(r8, r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean q(CoordinatorLayout r8, V r10, Rect r11, boolean r12) {
            return false;
        }

        public void r(CoordinatorLayout r8, V r10, Parcelable r11) {
        }

        public Parcelable s(View r8, CoordinatorLayout r10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean t(CoordinatorLayout r8, V r10, View r11, View r12, int r13) {
            return false;
        }

        public boolean u(CoordinatorLayout r8, V r10, View r11, View r12, int r13, int r14) {
            if (r14 == 0) goto L4;
            return false;
        L4:
            return t(r8, r10, r11, r12, r13);
        }

        @Deprecated
        public void v(CoordinatorLayout r8, V r10, View r11) {
        }

        public void w(CoordinatorLayout r8, V r10, View r11, int r12) {
            if (r12 != 0) goto L5;
            v(r8, r10, r11);
            return;
        }

        public boolean x(CoordinatorLayout r8, V r10, MotionEvent r11) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f1562a;

        public e(CoordinatorLayout r8) {
            this.f1562a = r8;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View r8, View r10) {
            ViewGroup.OnHierarchyChangeListener r11 = this.f1562a.A;
            if (r11 == null) goto L6;
            r11.onChildViewAdded(r8, r10);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View r8, View r10) {
            CoordinatorLayout r11 = this.f1562a;
            r11.p(2);
            ViewGroup.OnHierarchyChangeListener r12 = r11.A;
            if (r12 == null) goto L6;
            r12.onChildViewRemoved(r8, r10);
            return;
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f1563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1569g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1570h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1571i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1572j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f1573k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f1574l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1575m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1576n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1577o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1578p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Rect f1579q;

        public f() {
            super(-2, -2);
            this.f1564b = false;
            this.f1565c = 0;
            this.f1566d = 0;
            this.f1567e = -1;
            this.f1568f = -1;
            this.f1569g = 0;
            this.f1570h = 0;
            this.f1579q = new Rect();
        }

        public final boolean a(int r8) {
            if (r8 == 0) goto L10;
            if (r8 == 1) goto L8;
            return false;
        L8:
            return this.f1577o;
        L10:
            return this.f1576n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f1564b = false;
            this.f1565c = 0;
            this.f1566d = 0;
            this.f1567e = -1;
            this.f1568f = -1;
            this.f1569g = 0;
            this.f1570h = 0;
            this.f1579q = new Rect();
            TypedArray r11 = r8.obtainStyledAttributes(r10, w.a.f12950b);
            this.f1565c = r11.getInteger(0, 0);
            this.f1568f = r11.getResourceId(1, -1);
            this.f1566d = r11.getInteger(2, 0);
            this.f1567e = r11.getInteger(6, -1);
            this.f1569g = r11.getInt(5, 0);
            this.f1570h = r11.getInt(4, 0);
            boolean r12 = r11.hasValue(3);
            this.f1564b = r12;
            if (r12 == false) goto L27;
            String r13 = r11.getString(3);
            String r14 = CoordinatorLayout.D;
            if (TextUtils.isEmpty(r13) == false) goto L8;
            c r15 = null;
        L23:
            this.f1563a = r15;
            goto L27
        L8:
            if (r13.startsWith(".") == false) goto L11;
            r13 = r8.getPackageName() + r13;
        L31:
            ThreadLocal<Map<String, Constructor<c>>> r16 = CoordinatorLayout.F;     // Catch: Exception -> L24
            Map<String, Constructor<c>> r17 = r16.get();     // Catch: Exception -> L24
            if (r17 != null) goto L19;
            r17 = new HashMap();     // Catch: Exception -> L24
            r16.set(r17);     // Catch: Exception -> L24
        L19:
            Constructor<c> r18 = r17.get(r13);     // Catch: Exception -> L24
            if (r18 != null) goto L22;
            r18 = Class.forName(r13, false, r8.getClassLoader()).getConstructor(CoordinatorLayout.E);     // Catch: Exception -> L24
            r18.setAccessible(true);     // Catch: Exception -> L24
            r17.put(r13, r18);     // Catch: Exception -> L24
        L22:
            r15 = r18.newInstance(new Object[]{r8, r10});     // Catch: Exception -> L24
        L24:
            e = move-exception;
            throw new RuntimeException(defpackage.b.c("Could not inflate Behavior subclass ", r13), e);
        L11:
            if (r13.indexOf(46) >= 0) goto L31;
            String r19 = CoordinatorLayout.D;
            if (TextUtils.isEmpty(r19) == true) goto L31;
            r13 = r19 + '.' + r13;
        L27:
            r11.recycle();
            c r20 = this.f1563a;
            if (r20 == null) goto L33;
            r20.c(this);
            return;
        }

        public f(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f1564b = false;
            this.f1565c = 0;
            this.f1566d = 0;
            this.f1567e = -1;
            this.f1568f = -1;
            this.f1569g = 0;
            this.f1570h = 0;
            this.f1579q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams r8) {
            super(r8);
            this.f1564b = false;
            this.f1565c = 0;
            this.f1566d = 0;
            this.f1567e = -1;
            this.f1568f = -1;
            this.f1569g = 0;
            this.f1570h = 0;
            this.f1579q = new Rect();
        }

        public f(f r8) {
            super(r8);
            this.f1564b = false;
            this.f1565c = 0;
            this.f1566d = 0;
            this.f1567e = -1;
            this.f1568f = -1;
            this.f1569g = 0;
            this.f1570h = 0;
            this.f1579q = new Rect();
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f1580a;

        public g(CoordinatorLayout r8) {
            this.f1580a = r8;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f1580a.p(0);
            return true;
        }
    }

    public static class h implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View r8, View r10) {
            WeakHashMap<View, h0> r11 = w.f8437a;
            float r12 = w.i.m(r8);
            float r13 = w.i.m(r10);
            if (r12 <= r13) goto L6;
            return -1;
        L6:
            if (r12 >= r13) goto L8;
            return 1;
        L8:
            return 0;
        }
    }

    static {
        Package r8 = CoordinatorLayout.class.getPackage();
        if (r8 == null) goto L5;
        String r10 = r8.getName();
    L6:
        D = r10;
        G = new h();
        E = new Class[]{Context.class, AttributeSet.class};
        F = new ThreadLocal();
        H = new i0.e();
        return;
    L5:
        r10 = null;
        goto L6
    }

    public CoordinatorLayout(Context r10, AttributeSet r11) {
        super(r10, r11, R.attr.coordinatorLayoutStyle);
        this.f1544a = new ArrayList();
        this.f1545b = new x.a();
        this.f1546m = new ArrayList();
        this.f1547n = new ArrayList();
        this.f1548o = new int[2];
        this.f1549p = new int[2];
        this.C = new p();
        int[] r8 = w.a.f12949a;
        int r12 = 0;
        TypedArray r13 = r10.obtainStyledAttributes(r11, r8, R.attr.coordinatorLayoutStyle, 0);
        saveAttributeDataForStyleable(r10, r8, r11, r13, R.attr.coordinatorLayoutStyle, 0);
        int r14 = r13.getResourceId(0, 0);
        if (r14 == 0) goto L7;
        Resources r15 = r10.getResources();
        int[] r16 = r15.getIntArray(r14);
        this.f1552s = r16;
        float r17 = r15.getDisplayMetrics().density;
        int r18 = r16.length;
    L5:
        if (r12 >= r18) goto L7;
        int[] r19 = this.f1552s;
        r19[r12] = (int) (r19[r12] * r17);
        r12 = r12 + 1;
    L7:
        this.f1559z = r13.getDrawable(1);
        r13.recycle();
        x();
        super.setOnHierarchyChangeListener(new e(this));
        WeakHashMap<View, h0> r110 = w.f8437a;
        if (w.d.c(this) != 0) goto L12;
        w.d.s(this, 1);
        return;
    }

    public static Rect a() {
        Rect r8 = (Rect) H.a();
        if (r8 == null) goto L5;
        return r8;
    L5:
        return new Rect();
    }

    public static void f(int r8, Rect r10, Rect r11, f r12, int r13, int r14) {
        int r15 = r12.f1565c;
        if (r15 != 0) goto L5;
        r15 = 17;
    L5:
        int r16 = Gravity.getAbsoluteGravity(r15, r8);
        int r17 = r12.f1566d;
        if ((r17 & 7) != 0) goto L9;
        r17 = r17 | 8388611;
    L9:
        if ((r17 & BWDLInnerConstant.LINK_RECOVERY) != 0) goto L11;
        r17 = r17 | 48;
    L11:
        int r18 = Gravity.getAbsoluteGravity(r17, r8);
        int r19 = r16 & 7;
        int r20 = r16 & BWDLInnerConstant.LINK_RECOVERY;
        int r21 = r18 & 7;
        int r22 = r18 & BWDLInnerConstant.LINK_RECOVERY;
        if (r21 == 1) goto L16;
        if (r21 == 5) goto L15;
        int r23 = r10.left;
    L18:
        if (r22 == 16) goto L22;
        if (r22 == 80) goto L21;
        int r24 = r10.top;
    L23:
        if (r19 == 1) goto L26;
        if (r19 == 5) goto L27;
        r23 = r23 - r13;
    L27:
        if (r20 == 16) goto L30;
        if (r20 == 80) goto L31;
        r24 = r24 - r14;
    L31:
        r11.set(r23, r24, r13 + r23, r14 + r24);
        return;
    L30:
        r24 = r24 - (r14 / 2);
        goto L31
    L26:
        r23 = r23 - (r13 / 2);
        goto L27
    L21:
        r24 = r10.bottom;
        goto L23
    L22:
        r24 = r10.top + (r10.height() / 2);
        goto L23
    L15:
        r23 = r10.right;
        goto L18
    L16:
        r23 = r10.left + (r10.width() / 2);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f h(View r8) {
        f r10 = (f) r8.getLayoutParams();
        if (r10.f1564b == false) goto L5;
    L33:
        return r10;
    L5:
        if ((r8 instanceof b) == false) goto L16;
        c r11 = ((b) r8).getBehavior();
        if (r11 != null) goto L9;
        Log.e("CoordinatorLayout", "Attached behavior class is null");
    L9:
        c r12 = r10.f1563a;
        if (r12 == r11) goto L32;
        if (r12 == null) goto L13;
        r12.f();
    L13:
        r10.f1563a = r11;
        r10.f1564b = true;
        if (r11 == null) goto L32;
        r11.c(r10);
    L32:
        r10.f1564b = true;
        goto L33
    L16:
        Class<?> r13 = r8.getClass();
        d r14 = null;
    L17:
        if (r13 == null) goto L21;
        r14 = (d) r13.getAnnotation(d.class);
        if (r14 != null) goto L21;
        r13 = r13.getSuperclass();
    L21:
        if (r14 == null) goto L32;
        c r15 = r14.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L30
        c r16 = r10.f1563a;     // Catch: Exception -> L30
        if (r16 == r15) goto L32;
        if (r16 == null) goto L26;
        r16.f();     // Catch: Exception -> L30
    L26:
        r10.f1563a = r15;     // Catch: Exception -> L30
        r10.f1564b = true;     // Catch: Exception -> L30
        if (r15 == null) goto L32;
        r15.c(r10);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.e("CoordinatorLayout", "Default behavior class " + r14.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L32
    }

    public static void v(View r8, int r10) {
        f r11 = (f) r8.getLayoutParams();
        int r12 = r11.f1571i;
        if (r12 == r10) goto L6;
        WeakHashMap<View, h0> r13 = w.f8437a;
        r8.offsetLeftAndRight(r10 - r12);
        r11.f1571i = r10;
        return;
    }

    public static void w(View r8, int r10) {
        f r11 = (f) r8.getLayoutParams();
        int r12 = r11.f1572j;
        if (r12 == r10) goto L6;
        WeakHashMap<View, h0> r13 = w.f8437a;
        r8.offsetTopAndBottom(r10 - r12);
        r11.f1572j = r10;
        return;
    }

    public final void b(f r8, Rect r10, int r11, int r12) {
        int r13 = getWidth();
        int r14 = getHeight();
        int r15 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r8).leftMargin, Math.min(r10.left, ((r13 - getPaddingRight()) - r11) - ((ViewGroup.MarginLayoutParams) r8).rightMargin));
        int r16 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r8).topMargin, Math.min(r10.top, ((r14 - getPaddingBottom()) - r12) - ((ViewGroup.MarginLayoutParams) r8).bottomMargin));
        r10.set(r15, r16, r11 + r15, r12 + r16);
    }

    public final void c(View r8) {
        ArrayList<View> r10 = this.f1545b.f13359b.getOrDefault(r8, null);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L17;
        int r11 = 0;
    L8:
        if (r11 >= r10.size()) goto L18;
        View r12 = r10.get(r11);
        c r13 = ((f) r12.getLayoutParams()).f1563a;
        if (r13 == null) goto L12;
        r13.d(this, r12, r8);
    L12:
        r11 = r11 + 1;
        goto L8
    L18:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof f) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r8) == false) goto L7;
        return true;
    }

    public final void d(View r8, Rect r10, boolean r11) {
        if (r8.isLayoutRequested() == false) goto L5;
    L11:
        r10.setEmpty();
        return;
    L5:
        if (r8.getVisibility() == 8) goto L11;
        if (r11 == false) goto L9;
        x.b.a(this, r8, r10);
        return;
    L9:
        r10.set(r8.getLeft(), r8.getTop(), r8.getRight(), r8.getBottom());
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r8, View r10, long r11) {
        c r12 = ((f) r10.getLayoutParams()).f1563a;
        if (r12 == null) goto L6;
        r12.getClass();
    L6:
        return super.drawChild(r8, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r8 = getDrawableState();
        Drawable r10 = this.f1559z;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        if (r11 == false) goto L10;
        invalidate();
        return;
    L10:
        return;
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = false | r10.setState(r8);
        goto L7
    }

    public final ArrayList e(View r8) {
        n.h<View, ArrayList<View>> r10 = this.f1545b.f13359b;
        int r11 = r10.f9401m;
        ArrayList r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        ArrayList<View> r14 = r10.k(r13);
        if (r14 == null) goto L11;
        if (r14.contains(r8) == false) goto L11;
        if (r12 != null) goto L10;
        r12 = new ArrayList();
    L10:
        r12.add(r10.i(r13));
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        ArrayList r15 = this.f1547n;
        r15.clear();
        if (r12 == null) goto L15;
        r15.addAll(r12);
    L15:
        return r15;
    }

    public final int g(int r8) {
        int[] r10 = this.f1552s;
        if (r10 != null) goto L7;
        StringBuilder r11 = new StringBuilder("No keylines defined for ");
        r11.append(this);
        r11.append(" - attempted index lookup ");
        r11.append(r8);
    L5:
        Log.e("CoordinatorLayout", r11.toString());
        return 0;
    L7:
        if (r8 >= 0) goto L9;
    L13:
        r11 = new StringBuilder("Keyline index ");
        r11.append(r8);
        r11.append(" out of range for ");
        r11.append(this);
        goto L5
    L9:
        if (r8 >= r10.length) goto L13;
        return r10[r8];
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new f(getContext(), r8);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return Collections.unmodifiableList(this.f1544a);
    }

    public final m0 getLastWindowInsets() {
        return this.f1557x;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        p r8 = this.C;
        int r10 = r8.f8432a;
        return r8.f8433b | r10;
    }

    public Drawable getStatusBarBackground() {
        return this.f1559z;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        int r8 = super.getSuggestedMinimumHeight();
        int r10 = getPaddingTop();
        return Math.max(r8, getPaddingBottom() + r10);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        int r8 = super.getSuggestedMinimumWidth();
        int r10 = getPaddingLeft();
        return Math.max(r8, getPaddingRight() + r10);
    }

    @Override // j0.n
    public final void i(View r8, View r10, int r11, int r12) {
        p r13 = this.C;
        if (r12 != 1) goto L5;
        r13.f8433b = r11;
    L6:
        this.f1554u = r10;
        int r14 = getChildCount();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        ((f) getChildAt(r15).getLayoutParams()).getClass();
        r15 = r15 + 1;
        goto L7
    L9:
        return;
    L5:
        r13.f8432a = r11;
        goto L6
    }

    @Override // j0.n
    public final void j(View r8, int r10) {
        p r11 = this.C;
        if (r10 != 1) goto L5;
        r11.f8433b = 0;
    L6:
        int r12 = getChildCount();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L21;
        View r14 = getChildAt(r13);
        f r15 = (f) r14.getLayoutParams();
        if (r15.a(r10) == false) goto L20;
        c r16 = r15.f1563a;
        if (r16 == null) goto L14;
        r16.w(this, r14, r8, r10);
    L14:
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L19;
        r15.f1577o = false;
    L19:
        r15.f1578p = false;
        goto L20
    L18:
        r15.f1576n = false;
    L20:
        r13 = r13 + 1;
        goto L7
    L21:
        this.f1554u = null;
        return;
    L5:
        r11.f8432a = 0;
        goto L6
    }

    @Override // j0.n
    public final void k(View r17, int r18, int r19, int[] r20, int r21) {
        int r10 = getChildCount();
        boolean r8 = false;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11 >= r10) goto L23;
        View r14 = getChildAt(r11);
        if (r14.getVisibility() == 8) goto L22;
        f r15 = (f) r14.getLayoutParams();
        if (r15.a(r21) == false) goto L22;
        c r16 = r15.f1563a;
        if (r16 == null) goto L22;
        int[] r22 = this.f1548o;
        r22[0] = 0;
        r22[1] = 0;
        r16.l(this, r14, r17, r18, r19, r22, r21);
        int[] r23 = this.f1548o;
        if (r18 <= 0) goto L16;
        int r24 = Math.max(r12, r23[0]);
    L17:
        r12 = r24;
        if (r19 <= 0) goto L20;
        int r25 = Math.max(r13, r23[1]);
    L21:
        r13 = r25;
        r8 = true;
        goto L22
    L20:
        r25 = Math.min(r13, r23[1]);
        goto L21
    L16:
        r24 = Math.min(r12, r23[0]);
    L22:
        r11 = r11 + 1;
        goto L4
    L23:
        r20[0] = r12;
        r20[1] = r13;
        if (r8 == false) goto L32;
        p(1);
        return;
    }

    public final boolean l(View r8, int r10, int r11) {
        i0.e r12 = H;
        Rect r13 = a();
        x.b.a(this, r8, r13);
        boolean r14 = r13.contains(r10, r11);     // Catch: Throwable -> L6
        r13.setEmpty();
        r12.b(r13);
        return r14;
    L6:
        th = move-exception;
        r13.setEmpty();
        r12.b(r13);
        throw th;
    }

    @Override // j0.o
    public final void m(View r18, int r19, int r20, int r21, int r22, int r23, int[] r24) {
        int r11 = getChildCount();
        boolean r8 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L23;
        View r10 = getChildAt(r13);
        if (r10.getVisibility() == 8) goto L22;
        f r12 = (f) r10.getLayoutParams();
        if (r12.a(r23) == false) goto L22;
        c r16 = r12.f1563a;
        if (r16 == null) goto L22;
        int[] r17 = this.f1548o;
        r17[0] = 0;
        r17[1] = 0;
        r16.p(this, r10, r18, r19, r20, r21, r22, r23, r17);
        int[] r25 = this.f1548o;
        if (r21 <= 0) goto L16;
        int r26 = Math.max(r14, r25[0]);
    L17:
        r14 = r26;
        if (r22 <= 0) goto L20;
        int r27 = Math.max(r15, r25[1]);
    L21:
        r15 = r27;
        r8 = true;
        goto L22
    L20:
        r27 = Math.min(r15, r25[1]);
        goto L21
    L16:
        r26 = Math.min(r14, r25[0]);
    L22:
        r13 = r13 + 1;
        goto L4
    L23:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r8 == false) goto L32;
        p(1);
        return;
    }

    @Override // j0.n
    public final void n(View r10, int r11, int r12, int r13, int r14, int r15) {
        m(r10, r11, r12, r13, r14, 0, this.f1549p);
    }

    @Override // j0.n
    public final boolean o(View r16, View r17, int r18, int r19) {
        int r8 = getChildCount();
        int r10 = 0;
        boolean r11 = false;
    L3:
        if (r10 >= r8) goto L21;
        View r12 = getChildAt(r10);
        if (r12.getVisibility() == 8) goto L20;
        f r13 = (f) r12.getLayoutParams();
        c r14 = r13.f1563a;
        if (r14 == null) goto L15;
        boolean r15 = r14.u(this, r12, r16, r17, r18, r19);
        r11 = r11 | r15;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L20;
        r13.f1577o = r15;
        goto L20
    L14:
        r13.f1576n = r15;
        goto L20
    L15:
        if (r19 == 0) goto L19;
        if (r19 != 1) goto L20;
        r13.f1577o = false;
        goto L20
    L19:
        r13.f1576n = false;
    L20:
        r10 = r10 + 1;
        goto L3
    L21:
        return r11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.f1556w == false) goto L9;
        if (this.f1555v != null) goto L7;
        this.f1555v = new g(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.f1555v);
    L9:
        if (this.f1557x != null) goto L13;
        WeakHashMap<View, h0> r8 = w.f8437a;
        if (w.d.b(this) == false) goto L13;
        w.h.c(this);
    L13:
        this.f1551r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.f1556w == true) goto L5;
    L7:
        View r8 = this.f1554u;
        if (r8 == null) goto L10;
        onStopNestedScroll(r8);
    L10:
        this.f1551r = false;
        return;
    L5:
        if (this.f1555v == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.f1555v);
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (this.f1558y == true) goto L5;
        return;
    L5:
        if (this.f1559z == null) goto L14;
        m0 r10 = this.f1557x;
        if (r10 == null) goto L9;
        int r11 = r10.e();
    L10:
        if (r11 <= 0) goto L15;
        this.f1559z.setBounds(0, 0, getWidth(), r11);
        this.f1559z.draw(r8);
        return;
    L15:
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 0) goto L5;
        u(true);
    L5:
        boolean r11 = s(r8, 0);
        if (r10 != 1) goto L8;
    L9:
        u(true);
    L10:
        return r11;
    L8:
        if (r10 != 3) goto L10;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        WeakHashMap<View, h0> r14 = w.f8437a;
        int r15 = w.e.d(this);
        ArrayList r16 = this.f1544a;
        int r17 = r16.size();
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L13;
        View r19 = (View) r16.get(r18);
        if (r19.getVisibility() == 8) goto L12;
        c r20 = ((f) r19.getLayoutParams()).f1563a;
        if (r20 != null) goto L10;
    L11:
        q(r19, r15);
        goto L12
    L10:
        if (r20.h(this, r19, r15) == false) goto L11;
    L12:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r33, int r34) {
        t();
        int r8 = getChildCount();
        int r10 = 0;
    L4:
        if (r10 >= r8) goto L17;
        View r11 = getChildAt(r10);
        n.h<View, ArrayList<View>> r12 = this.f1545b.f13359b;
        int r13 = r12.f9401m;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L13;
        ArrayList<View> r15 = r12.k(r14);
        if (r15 == null) goto L12;
        if (r15.contains(r11) == false) goto L12;
        boolean r16 = true;
    L14:
        if (r16 == true) goto L15;
        r10 = r10 + 1;
        goto L4
    L15:
        boolean r17 = true;
    L19:
        if (r17 == this.f1556w) goto L34;
        if (r17 == false) goto L29;
        if (this.f1551r == true) goto L24;
    L27:
        this.f1556w = true;
        goto L34
    L24:
        if (this.f1555v != null) goto L26;
        this.f1555v = new g(this);
    L26:
        getViewTreeObserver().addOnPreDrawListener(this.f1555v);
        goto L27
    L29:
        if (this.f1551r == true) goto L31;
    L33:
        this.f1556w = false;
        goto L34
    L31:
        if (this.f1555v == null) goto L33;
        getViewTreeObserver().removeOnPreDrawListener(this.f1555v);
    L34:
        int r18 = getPaddingLeft();
        int r19 = getPaddingTop();
        int r20 = getPaddingRight();
        int r21 = getPaddingBottom();
        WeakHashMap<View, h0> r22 = w.f8437a;
        int r110 = w.e.d(this);
        if (r110 != 1) goto L37;
        boolean r111 = true;
    L38:
        int r112 = View.MeasureSpec.getMode(r33);
        int r113 = View.MeasureSpec.getSize(r33);
        int r114 = View.MeasureSpec.getMode(r34);
        int r115 = View.MeasureSpec.getSize(r34);
        int r116 = r18 + r20;
        int r117 = r19 + r21;
        int r23 = getSuggestedMinimumWidth();
        int r24 = getSuggestedMinimumHeight();
        if (this.f1557x != null) goto L41;
    L43:
        boolean r118 = false;
    L44:
        ArrayList r25 = this.f1544a;
        int r26 = r25.size();
        int r27 = r23;
        int r28 = r24;
        int r29 = 0;
        int r30 = 0;
    L45:
        if (r30 >= r26) goto L85;
        View r119 = (View) r25.get(r30);
        int r210 = r29;
        if (r119.getVisibility() != 8) goto L49;
        int r211 = r26;
        ArrayList r212 = r25;
        int r213 = r18;
        int r214 = r20;
        int r215 = r110;
        r29 = r210;
        boolean r216 = false;
        int r217 = r30;
    L84:
        r30 = r217 + 1;
        r18 = r213;
        r20 = r214;
        r110 = r215;
        r26 = r211;
        r25 = r212;
        goto L45
    L49:
        f r31 = (f) r119.getLayoutParams();
        int r32 = r31.f1567e;
        if (r32 < 0) goto L69;
        if (r112 == 0) goto L69;
        int r35 = g(r32);
        int r218 = r30;
        int r36 = r31.f1565c;
        if (r36 != 0) goto L55;
        r36 = 8388661;
    L55:
        int r37 = Gravity.getAbsoluteGravity(r36, r110) & 7;
        int r219 = r28;
        if (r37 != 3) goto L59;
        if (r111 == true) goto L59;
    L61:
        int r220 = Math.max(0, (r113 - r20) - r35);
    L71:
        if (r118 == true) goto L73;
    L75:
        int r221 = r33;
        int r222 = r34;
    L76:
        c r38 = r31.f1563a;
        if (r38 == null) goto L81;
        r217 = r218;
        r213 = r18;
        r216 = false;
        int r39 = r210;
        int r310 = r219;
        r214 = r20;
        int r40 = r310;
        r215 = r110;
        int r120 = r27;
        r211 = r26;
        r212 = r25;
        if (r38.i(this, r119, r221, r220, r222) == false) goto L82;
    L83:
        int r41 = Math.max(r120, ((r119.getMeasuredWidth() + r116) + ((ViewGroup.MarginLayoutParams) r31).leftMargin) + ((ViewGroup.MarginLayoutParams) r31).rightMargin);
        int r42 = Math.max(r40, ((r119.getMeasuredHeight() + r117) + ((ViewGroup.MarginLayoutParams) r31).topMargin) + ((ViewGroup.MarginLayoutParams) r31).bottomMargin);
        r27 = r41;
        r29 = View.combineMeasuredStates(r39, r119.getMeasuredState());
        r28 = r42;
    L82:
        measureChildWithMargins(r119, r221, r220, r222, 0);
        goto L83
    L81:
        r211 = r26;
        r212 = r25;
        r215 = r110;
        r216 = false;
        r120 = r27;
        int r311 = r218;
        r213 = r18;
        r39 = r210;
        r217 = r311;
        int r312 = r219;
        r214 = r20;
        r40 = r312;
        goto L82
    L73:
        if (w.d.b(r119) == true) goto L75;
        int r43 = this.f1557x.d() + this.f1557x.c();
        int r44 = this.f1557x.b() + this.f1557x.e();
        r221 = View.MeasureSpec.makeMeasureSpec(r113 - r43, r112);
        r222 = View.MeasureSpec.makeMeasureSpec(r115 - r44, r114);
    L59:
        if (r37 != 5) goto L62;
        if (r111 == true) goto L61;
    L62:
        if (r37 != 5) goto L65;
        if (r111 == true) goto L65;
    L67:
        r220 = Math.max(0, r35 - r18);
    L65:
        if (r37 != 3) goto L70;
        if (r111 == true) goto L67;
    L70:
        r220 = 0;
    L69:
        r218 = r30;
        r219 = r28;
        goto L70
    L85:
        int r45 = r29;
        setMeasuredDimension(View.resolveSizeAndState(r27, r33, (-16777216) & r45), View.resolveSizeAndState(r28, r34, r45 << 16));
        return;
    L41:
        if (w.d.b(this) == false) goto L43;
        r118 = true;
        goto L44
    L37:
        r111 = false;
    L12:
        r14 = r14 + 1;
        goto L6
    L13:
        r16 = false;
        goto L14
    L17:
        r17 = false;
        goto L19
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r8, float r10, float r11, boolean r12) {
        int r13 = getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L14;
        View r15 = getChildAt(r14);
        if (r15.getVisibility() == 8) goto L13;
        f r16 = (f) r15.getLayoutParams();
        if (r16.a(0) == false) goto L13;
        c r17 = r16.f1563a;
        if (r17 == null) goto L13;
        r17.j(this, r15, r8);
    L13:
        r14 = r14 + 1;
        goto L3
    L14:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r8, float r10, float r11) {
        int r12 = getChildCount();
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 >= r12) goto L14;
        View r15 = getChildAt(r13);
        if (r15.getVisibility() == 8) goto L13;
        f r16 = (f) r15.getLayoutParams();
        if (r16.a(0) == false) goto L13;
        c r17 = r16.f1563a;
        if (r17 == null) goto L13;
        r14 = r14 | r17.k(this, r15, r8, r11);
    L13:
        r13 = r13 + 1;
        goto L3
    L14:
        return r14;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r8, int r10, int r11, int[] r12) {
        k(r8, r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r10, int r11, int r12, int r13) {
        n(r8, r10, r11, r12, r13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r8, View r10, int r11) {
        i(r8, r10, r11, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        SparseArray<Parcelable> r11 = r10.f1560m;
        int r12 = getChildCount();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L15;
        View r14 = getChildAt(r13);
        int r15 = r14.getId();
        c r16 = h(r14).f1563a;
        if (r15 == (-1)) goto L14;
        if (r16 == null) goto L14;
        Parcelable r17 = r11.get(r15);
        if (r17 == null) goto L14;
        r16.r(this, r14, r17);
    L14:
        r13 = r13 + 1;
        goto L7
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r10 = new SparseArray();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        View r13 = getChildAt(r12);
        int r14 = r13.getId();
        c r15 = ((f) r13.getLayoutParams()).f1563a;
        if (r14 == (-1)) goto L10;
        if (r15 == null) goto L10;
        Parcelable r16 = r15.s(r13, this);
        if (r16 == null) goto L10;
        r10.append(r14, r16);
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        r8.f1560m = r10;
        return r8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r8, View r10, int r11) {
        return o(r8, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r8) {
        j(r8, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r18) {
        int r8 = r18.getActionMasked();
        if (this.f1553t != null) goto L7;
        boolean r10 = s(r18, 1);
        if (r10 == true) goto L8;
    L11:
        boolean r11 = false;
    L12:
        MotionEvent r12 = null;
        if (this.f1553t != null) goto L15;
        r11 = r11 | super.onTouchEvent(r18);
    L17:
        if (r12 == null) goto L19;
        r12.recycle();
    L19:
        if (r8 != 1) goto L21;
    L22:
        u(false);
    L23:
        return r11;
    L21:
        if (r8 != 3) goto L23;
    L15:
        if (r10 == false) goto L17;
        long r13 = SystemClock.uptimeMillis();
        r12 = MotionEvent.obtain(r13, r13, 3, 0.0f, 0.0f, 0);
        super.onTouchEvent(r12);
    L8:
        c r14 = ((f) this.f1553t.getLayoutParams()).f1563a;
        if (r14 == null) goto L11;
        r11 = r14.x(this, this.f1553t, r18);
        goto L12
    L7:
        r10 = false;
        goto L8
    }

    public final void p(int r26) {
        WeakHashMap<View, h0> r8 = w.f8437a;
        int r10 = w.e.d(this);
        ArrayList r11 = this.f1544a;
        int r12 = r11.size();
        Rect r13 = a();
        Rect r14 = a();
        Rect r15 = a();
        int r16 = r26;
        int r17 = 0;
    L3:
        i0.e r18 = H;
        if (r17 >= r12) goto L133;
        View r19 = (View) r11.get(r17);
        f r20 = (f) r19.getLayoutParams();
        if (r16 == 0) goto L8;
    L10:
        int r21 = 0;
    L11:
        if (r21 >= r17) goto L35;
        if (r20.f1574l != ((View) r11.get(r21))) goto L33;
        f r22 = (f) r19.getLayoutParams();
        if (r22.f1573k == null) goto L33;
        Rect r23 = a();
        Rect r110 = a();
        Rect r24 = a();
        x.b.a(this, r22.f1573k, r23);
        d(r19, r110, false);
        int r25 = r19.getMeasuredWidth();
        int r111 = r19.getMeasuredHeight();
        View r112 = r19;
        i0.e r113 = r18;
        f(r10, r23, r24, r22, r25, r111);
        if (r24.left == r110.left) goto L19;
    L22:
        boolean r27 = true;
    L23:
        b(r16, r24, r25, r111);
        int r28 = r24.left - r110.left;
        int r29 = r24.top - r110.top;
        if (r28 == 0) goto L26;
        WeakHashMap<View, h0> r30 = w.f8437a;
        r112.offsetLeftAndRight(r28);
    L26:
        if (r29 == 0) goto L28;
        WeakHashMap<View, h0> r31 = w.f8437a;
        r112.offsetTopAndBottom(r29);
    L28:
        if (r27 == false) goto L32;
        c r32 = r16.f1563a;
        if (r32 == null) goto L32;
        r32.d(this, r112, r22.f1573k);
    L32:
        r23.setEmpty();
        r113.b(r23);
        r110.setEmpty();
        r113.b(r110);
        r24.setEmpty();
        r113.b(r24);
    L34:
        r21 = r21 + 1;
        r18 = r113;
        r19 = r112;
        r11 = r11;
        r12 = r12;
        r17 = r17;
        r20 = r20;
        r15 = r15;
        goto L11
    L19:
        if (r24.top != r110.top) goto L22;
        r27 = false;
    L33:
        r112 = r19;
        r113 = r18;
        goto L34
    L35:
        f r210 = r20;
        ArrayList r114 = r11;
        int r115 = r12;
        Rect r211 = r15;
        int r212 = r17;
        View r116 = r19;
        i0.e r117 = r18;
        d(r116, r14, true);
        if (r210.f1569g == 0) goto L52;
        if (r14.isEmpty() == true) goto L52;
        int r33 = Gravity.getAbsoluteGravity(r210.f1569g, r10);
        int r34 = r33 & BWDLInnerConstant.LINK_RECOVERY;
        if (r34 == 48) goto L44;
        if (r34 != 80) goto L45;
        r13.bottom = Math.max(r13.bottom, getHeight() - r14.top);
    L45:
        int r35 = r33 & 7;
        if (r35 == 3) goto L50;
        if (r35 != 5) goto L52;
        r13.right = Math.max(r13.right, getWidth() - r14.left);
        goto L52
    L50:
        r13.left = Math.max(r13.left, r14.right);
        goto L52
    L44:
        r13.top = Math.max(r13.top, r14.bottom);
    L52:
        if (r210.f1570h == 0) goto L104;
        if (r116.getVisibility() != 0) goto L104;
        WeakHashMap<View, h0> r36 = w.f8437a;
        if (w.g.c(r116) == false) goto L104;
        if (r116.getWidth() <= 0) goto L104;
        if (r116.getHeight() <= 0) goto L104;
        f r37 = (f) r116.getLayoutParams();
        c r38 = r37.f1563a;
        Rect r39 = a();
        Rect r118 = a();
        r118.set(r116.getLeft(), r116.getTop(), r116.getRight(), r116.getBottom());
        if (r38 != null) goto L66;
    L72:
        r39.set(r118);
    L73:
        r118.setEmpty();
        r117.b(r118);
        if (r39.isEmpty() == false) goto L76;
    L75:
        r39.setEmpty();
        r117.b(r39);
        goto L104
    L76:
        int r40 = Gravity.getAbsoluteGravity(r37.f1570h, r10);
        if ((r40 & 48) != 48) goto L81;
        int r41 = (r39.top - ((ViewGroup.MarginLayoutParams) r37).topMargin) - r37.f1572j;
        int r42 = r13.top;
        if (r41 >= r42) goto L81;
        w(r116, r42 - r41);
        boolean r43 = true;
    L83:
        if ((r40 & 80) != 80) goto L87;
        int r44 = ((getHeight() - r39.bottom) - ((ViewGroup.MarginLayoutParams) r37).bottomMargin) + r37.f1572j;
        int r45 = r13.bottom;
        if (r44 >= r45) goto L87;
        w(r116, r44 - r45);
        r43 = true;
    L87:
        if (r43 == true) goto L90;
        w(r116, 0);
    L90:
        if ((r40 & 3) != 3) goto L94;
        int r46 = (r39.left - ((ViewGroup.MarginLayoutParams) r37).leftMargin) - r37.f1571i;
        int r47 = r13.left;
        if (r46 >= r47) goto L94;
        v(r116, r47 - r46);
        boolean r48 = true;
    L96:
        if ((r40 & 5) != 5) goto L100;
        int r49 = ((getWidth() - r39.right) - ((ViewGroup.MarginLayoutParams) r37).rightMargin) + r37.f1571i;
        int r50 = r13.right;
        if (r49 >= r50) goto L100;
        v(r116, r49 - r50);
        boolean r51 = true;
    L101:
        if (r51 == true) goto L75;
        v(r116, 0);
    L100:
        r51 = r48;
    L94:
        r48 = false;
    L81:
        r43 = false;
        goto L83
    L66:
        if (r38.a(r116) == false) goto L72;
        if (r118.contains(r39) == true) goto L73;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r39.toShortString() + " | Bounds:" + r118.toShortString());
    L104:
        if (r26 == 2) goto L110;
        Rect r52 = r211;
        r52.set(((f) r116.getLayoutParams()).f1579q);
        if (r52.equals(r14) == false) goto L109;
        ArrayList r53 = r114;
        int r54 = r115;
    L131:
        r16 = r26;
    L132:
        r17 = r212 + 1;
        r15 = r52;
        r12 = r54;
        r11 = r53;
        goto L3
    L109:
        ((f) r116.getLayoutParams()).f1579q.set(r14);
    L111:
        int r55 = r212 + 1;
        r54 = r115;
    L112:
        r53 = r114;
        if (r55 >= r54) goto L131;
        View r56 = (View) r53.get(r55);
        f r57 = (f) r56.getLayoutParams();
        c r119 = r57.f1563a;
        if (r119 == null) goto L130;
        if (r119.b(this, r56, r116) == false) goto L130;
        if (r26 != 0) goto L123;
        if (r57.f1578p == false) goto L123;
        r57.f1578p = false;
    L123:
        if (r26 == 2) goto L125;
        boolean r58 = r119.d(this, r56, r116);
    L127:
        if (r26 != 1) goto L130;
        r57.f1578p = r58;
        goto L130
    L125:
        r119.e(this, r56, r116);
        r58 = true;
    L130:
        r55 = r55 + 1;
        r114 = r53;
        goto L112
    L110:
        r52 = r211;
        goto L111
    L8:
        if (r19.getVisibility() != 8) goto L10;
        r53 = r11;
        r54 = r12;
        r52 = r15;
        r212 = r17;
        goto L132
    L133:
        Rect r59 = r15;
        r13.setEmpty();
        r18.b(r13);
        r14.setEmpty();
        r18.b(r14);
        r59.setEmpty();
        r18.b(r59);
    }

    public final void q(View r13, int r14) {
        f r8 = (f) r13.getLayoutParams();
        View r10 = r8.f1573k;
        int r11 = 0;
        if (r10 == null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L56;
        i0.e r15 = H;
        if (r10 == null) goto L17;
        Rect r16 = a();
        Rect r17 = a();
        x.b.a(this, r10, r16);     // Catch: Throwable -> L14
        f r18 = (f) r13.getLayoutParams();     // Catch: Throwable -> L14
        int r19 = r13.getMeasuredWidth();     // Catch: Throwable -> L14
        int r110 = r13.getMeasuredHeight();     // Catch: Throwable -> L14
        f(r14, r16, r17, r18, r19, r110);     // Catch: Throwable -> L14
        b(r18, r17, r19, r110);     // Catch: Throwable -> L14
        r13.layout(r17.left, r17.top, r17.right, r17.bottom);     // Catch: Throwable -> L14
        r16.setEmpty();
        r15.b(r16);
        r17.setEmpty();
        r15.b(r17);
        return;
    L14:
        th = move-exception;
        r16.setEmpty();
        r15.b(r16);
        r17.setEmpty();
        r15.b(r17);
        throw th;
    L17:
        int r20 = r8.f1567e;
        if (r20 < 0) goto L40;
        f r21 = (f) r13.getLayoutParams();
        int r22 = r21.f1565c;
        if (r22 != 0) goto L22;
        r22 = 8388661;
    L22:
        int r23 = Gravity.getAbsoluteGravity(r22, r14);
        int r24 = r23 & 7;
        int r25 = r23 & BWDLInnerConstant.LINK_RECOVERY;
        int r26 = getWidth();
        int r27 = getHeight();
        int r28 = r13.getMeasuredWidth();
        int r29 = r13.getMeasuredHeight();
        if (r14 != 1) goto L25;
        r20 = r26 - r20;
    L25:
        int r111 = g(r20) - r28;
        if (r24 != 1) goto L28;
        r111 = r111 + (r28 / 2);
    L33:
        if (r25 != 16) goto L35;
        r11 = 0 + (r29 / 2);
    L39:
        int r112 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r21).leftMargin, Math.min(r111, ((r26 - getPaddingRight()) - r28) - ((ViewGroup.MarginLayoutParams) r21).rightMargin));
        int r113 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r21).topMargin, Math.min(r11, ((r27 - getPaddingBottom()) - r29) - ((ViewGroup.MarginLayoutParams) r21).bottomMargin));
        r13.layout(r112, r113, r28 + r112, r29 + r113);
        return;
    L35:
        if (r25 != 80) goto L39;
        r11 = r29 + 0;
        goto L39
    L28:
        if (r24 != 5) goto L33;
        r111 = r111 + r28;
        goto L33
    L40:
        f r30 = (f) r13.getLayoutParams();
        Rect r31 = a();
        r31.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r30).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r30).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r30).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r30).bottomMargin);
        if (this.f1557x == null) goto L47;
        WeakHashMap<View, h0> r32 = w.f8437a;
        if (w.d.b(this) == false) goto L47;
        if (w.d.b(r13) == true) goto L47;
        r31.left = this.f1557x.c() + r31.left;
        r31.top = this.f1557x.e() + r31.top;
        r31.right -= this.f1557x.d();
        r31.bottom -= this.f1557x.b();
    L47:
        Rect r114 = a();
        int r33 = r30.f1565c;
        if ((r33 & 7) != 0) goto L51;
        r33 = r33 | 8388611;
    L51:
        if ((r33 & BWDLInnerConstant.LINK_RECOVERY) != 0) goto L53;
        r33 = r33 | 48;
    L53:
        j0.d.a.b(r33, r13.getMeasuredWidth(), r13.getMeasuredHeight(), r31, r114, r14);
        r13.layout(r114.left, r114.top, r114.right, r114.bottom);
        r31.setEmpty();
        r15.b(r31);
        r114.setEmpty();
        r15.b(r114);
        return;
    L56:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    L5:
        if (r8.f1568f == (-1)) goto L7;
        r12 = true;
        goto L8
    }

    public final void r(View r8, int r10, int r11, int r12) {
        measureChildWithMargins(r8, r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View r8, Rect r10, boolean r11) {
        c r12 = ((f) r8.getLayoutParams()).f1563a;
        if (r12 == null) goto L9;
        if (r12.q(this, r8, r10, r11) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r8, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r8) {
        super.requestDisallowInterceptTouchEvent(r8);
        if (r8 == true) goto L5;
        return;
    L5:
        if (this.f1550q == true) goto L9;
        u(false);
        this.f1550q = true;
        return;
    }

    public final boolean s(MotionEvent r24, int r25) {
        int r8 = r24.getActionMasked();
        ArrayList r10 = this.f1546m;
        r10.clear();
        boolean r11 = isChildrenDrawingOrderEnabled();
        int r12 = getChildCount();
        int r13 = r12 - 1;
    L3:
        if (r13 < 0) goto L8;
        if (r11 == false) goto L6;
        int r14 = getChildDrawingOrder(r12, r13);
    L7:
        r10.add(getChildAt(r14));
        r13 = r13 - 1;
        goto L3
    L6:
        r14 = r13;
        goto L7
    L8:
        h r15 = G;
        if (r15 == null) goto L11;
        Collections.sort(r10, r15);
    L11:
        int r16 = r10.size();
        MotionEvent r17 = null;
        int r18 = 0;
        boolean r19 = false;
        boolean r110 = false;
    L12:
        if (r18 >= r16) goto L49;
        View r111 = (View) r10.get(r18);
        f r112 = (f) r111.getLayoutParams();
        c r113 = r112.f1563a;
        if (r19 == true) goto L16;
        if (r110 == true) goto L16;
    L25:
        if (r19 == true) goto L35;
        if (r113 == null) goto L35;
        if (r25 == 0) goto L31;
        if (r25 != 1) goto L32;
        r19 = r113.x(this, r111, r24);
    L32:
        if (r19 == false) goto L35;
        this.f1553t = r111;
        goto L35
    L31:
        r19 = r113.g(this, r111, r24);
    L35:
        if (r112.f1563a != null) goto L37;
        r112.f1575m = false;
    L37:
        boolean r114 = r112.f1575m;
        if (r114 == false) goto L40;
        boolean r115 = true;
    L41:
        if (r115 == false) goto L44;
        if (r114 == true) goto L44;
        r110 = true;
    L45:
        if (r115 == false) goto L48;
        if (r110 == false) goto L49;
    L48:
        r18 = r18 + 1;
    L44:
        r110 = false;
        goto L45
    L40:
        r115 = r114 | false;
        r112.f1575m = r115;
    L16:
        if (r8 == 0) goto L25;
        if (r113 == null) goto L48;
        if (r17 != null) goto L20;
        long r116 = SystemClock.uptimeMillis();
        r17 = MotionEvent.obtain(r116, r116, 3, 0.0f, 0.0f, 0);
    L20:
        if (r25 == 0) goto L24;
        if (r25 != 1) goto L48;
        r113.x(this, r111, r17);
        goto L48
    L24:
        r113.g(this, r111, r17);
    L49:
        r10.clear();
        return r19;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r8) {
        super.setFitsSystemWindows(r8);
        x();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r8) {
        this.A = r8;
    }

    public void setStatusBarBackground(Drawable r8) {
        Drawable r10 = this.f1559z;
        if (r10 == r8) goto L21;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r8 == null) goto L9;
        r11 = r8.mutate();
    L9:
        this.f1559z = r11;
        if (r11 != null) goto L12;
    L19:
        WeakHashMap<View, h0> r12 = w.f8437a;
        w.d.k(this);
        return;
    L12:
        if (r11.isStateful() == false) goto L14;
        this.f1559z.setState(getDrawableState());
    L14:
        Drawable r13 = this.f1559z;
        WeakHashMap<View, h0> r14 = w.f8437a;
        b0.a.c.b(r13, w.e.d(this));
        Drawable r15 = this.f1559z;
        if (getVisibility() != 0) goto L17;
        boolean r16 = true;
    L18:
        r15.setVisible(r16, false);
        this.f1559z.setCallback(this);
        goto L19
    L17:
        r16 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(int r8) {
        setStatusBarBackground(new ColorDrawable(r8));
    }

    public void setStatusBarBackgroundResource(int r8) {
        if (r8 == 0) goto L4;
        Context r10 = getContext();
        Object r11 = androidx.core.content.a.f1674a;
        Drawable r12 = androidx.core.content.a.b.b(r10, r8);
    L5:
        setStatusBarBackground(r12);
        return;
    L4:
        r12 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        super.setVisibility(r8);
        if (r8 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.f1559z;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isVisible() == r10) goto L13;
        this.f1559z.setVisible(r10, false);
        return;
    L13:
        return;
    L5:
        r10 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v2 android.view.View
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final void t() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v2 android.view.View
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.t():void");
    }

    public final void u(boolean r14) {
        int r8 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L12;
        View r11 = getChildAt(r10);
        c r12 = ((f) r11.getLayoutParams()).f1563a;
        if (r12 == null) goto L11;
        long r13 = SystemClock.uptimeMillis();
        MotionEvent r15 = MotionEvent.obtain(r13, r13, 3, 0.0f, 0.0f, 0);
        if (r14 == false) goto L9;
        r12.g(this, r11, r15);
    L10:
        r15.recycle();
        goto L11
    L9:
        r12.x(this, r11, r15);
    L11:
        r10 = r10 + 1;
        goto L3
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r8) goto L15;
        ((f) getChildAt(r16).getLayoutParams()).f1575m = false;
        r16 = r16 + 1;
        goto L13
    L15:
        this.f1553t = null;
        this.f1550q = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        if (super.verifyDrawable(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (r8 == this.f1559z) goto L8;
        return false;
    }

    public final void x() {
        WeakHashMap<View, h0> r8 = w.f8437a;
        if (w.d.b(this) == true) goto L5;
        w.i.u(this, null);
        return;
    L5:
        if (this.B != null) goto L7;
        this.B = new a(this);
    L7:
        w.i.u(this, this.B);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof f) == false) goto L6;
        return new f((f) r8);
    L6:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new f((ViewGroup.MarginLayoutParams) r8);
    L9:
        return new f(r8);
    }
}
