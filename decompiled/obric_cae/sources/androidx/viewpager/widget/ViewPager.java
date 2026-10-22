package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import com.obric.oui.calendar.MaterialCalendarView;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import j0.h0;
import j0.w;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int[] f2729h0 = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final a f2730i0 = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final b f2731j0 = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final k f2732k0 = null;
    public float A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public float N;
    public float O;
    public int P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public EdgeEffect V;
    public EdgeEffect W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2733a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public h f2734a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<e> f2735b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public i f2736b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f2737c0;
    public int d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public ArrayList<View> f2738e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final c f2739f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f2740g0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f2741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f2742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i1.a f2743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Parcelable f2746r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Scroller f2747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2748t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j f2749u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f2751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2754z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2755m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Parcelable f2756n;

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
            if (r10 != null) goto L5;
            r10 = getClass().getClassLoader();
        L5:
            this.f2755m = r8.readInt();
            this.f2756n = r8.readParcelable(r10);
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("FragmentPager.SavedState{");
            r8.append(Integer.toHexString(System.identityHashCode(this)));
            r8.append(" position=");
            return android.aimedia.a.h(r8, this.f2755m, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f2755m);
            r8.writeParcelable(this.f2756n, r10);
        }
    }

    public static class a implements Comparator<e> {
        @Override // java.util.Comparator
        public final int compare(e r8, e r10) {
            return r8.f2759b - r10.f2759b;
        }
    }

    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r8) {
            float r10 = r8 - 1.0f;
            return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f2757a;

        public c(ViewPager r8) {
            this.f2757a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewPager r8 = this.f2757a;
            r8.setScrollState(0);
            r8.o();
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xb.e f2758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2762e;

        public e() {
        }
    }

    public static class f extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2767e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2768f;

        public f() {
            super(-1, -1);
            this.f2765c = 0.0f;
        }

        public f(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f2765c = 0.0f;
            TypedArray r11 = r8.obtainStyledAttributes(r10, ViewPager.f2729h0);
            this.f2764b = r11.getInteger(0, 48);
            r11.recycle();
        }
    }

    public class g extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ViewPager f2769d;

        public g(ViewPager r8) {
            this.f2769d = r8;
        }

        @Override // j0.a
        public final void c(View r8, AccessibilityEvent r10) {
            super.c(r8, r10);
            r10.setClassName(ViewPager.class.getName());
            ViewPager r11 = this.f2769d;
            i1.a r12 = r11.f2743o;
            if (r12 == null) goto L7;
            boolean r13 = true;
            if (r12.a() <= 1) goto L7;
        L8:
            r10.setScrollable(r13);
            if (r10.getEventType() != 4096) goto L14;
            i1.a r14 = r11.f2743o;
            if (r14 == null) goto L15;
            r10.setItemCount(r14.a());
            r10.setFromIndex(r11.f2744p);
            r10.setToIndex(r11.f2744p);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r13 = false;
            goto L8
        }

        @Override // j0.a
        public final void d(View r8, k0.f r10) {
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r10.f8890a);
            r10.f(ViewPager.class.getName());
            ViewPager r11 = this.f2769d;
            i1.a r12 = r11.f2743o;
            if (r12 != null) goto L5;
        L7:
            boolean r13 = false;
        L8:
            r10.j(r13);
            if (r11.canScrollHorizontally(1) == false) goto L12;
            r10.a(4096);
        L12:
            if (r11.canScrollHorizontally(-1) == false) goto L15;
            r10.a(8192);
            return;
        L15:
            return;
        L5:
            if (r12.a() <= 1) goto L7;
            r13 = true;
            goto L8
        }

        @Override // j0.a
        public final boolean g(View r8, int r10, Bundle r11) {
            if (super.g(r8, r10, r11) == false) goto L5;
            return true;
        L5:
            ViewPager r12 = this.f2769d;
            if (r10 == 4096) goto L17;
            if (r10 == 8192) goto L11;
            return false;
        L11:
            if (r12.canScrollHorizontally(-1) == false) goto L15;
            int r13 = r12.f2744p - 1;
        L13:
            r12.setCurrentItem(r13);
            return true;
        L15:
            return false;
        L17:
            if (r12.canScrollHorizontally(1) == false) goto L19;
            r13 = r12.f2744p + 1;
            goto L13
        L19:
            return false;
        }
    }

    public interface h {
        void a();

        void b();

        void c(int r8);
    }

    public interface i {
    }

    public class j extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f2770a;

        public j(ViewPager r8) {
            this.f2770a = r8;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f2770a.e();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f2770a.e();
        }
    }

    public static class k implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View r8, View r10) {
            f r11 = (f) r8.getLayoutParams();
            f r12 = (f) r10.getLayoutParams();
            boolean r13 = r11.f2763a;
            if (r13 == r12.f2763a) goto L8;
            if (r13 == false) goto L6;
            return 1;
        L6:
            return -1;
        L8:
            return r11.f2767e - r12.f2767e;
        }
    }

    static {
        f2729h0 = new int[]{R.attr.layout_gravity};
        f2730i0 = new a();
        f2731j0 = new b();
        f2732k0 = new k();
    }

    public ViewPager(Context r8) {
        super(r8);
        this.f2735b = new ArrayList();
        this.f2741m = new e();
        this.f2742n = new Rect();
        this.f2745q = -1;
        this.f2746r = null;
        this.f2754z = -3.4028235E38f;
        this.A = Float.MAX_VALUE;
        this.F = 1;
        this.P = -1;
        this.X = true;
        this.f2739f0 = new c(this);
        this.f2740g0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r10 = getContext();
        this.f2747s = new Scroller(r10, f2731j0);
        ViewConfiguration r11 = ViewConfiguration.get(r10);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.K = r11.getScaledPagingTouchSlop();
        this.R = (int) (400.0f * r12);
        this.S = r11.getScaledMaximumFlingVelocity();
        this.V = new EdgeEffect(r10);
        this.W = new EdgeEffect(r10);
        this.T = (int) (25.0f * r12);
        this.U = (int) (2.0f * r12);
        this.I = (int) (r12 * 16.0f);
        w.m(this, new g(this));
        if (w.d.c(this) != 0) goto L5;
        w.d.s(this, 1);
    L5:
        w.i.u(this, new i1.b(this));
    }

    public static boolean c(int r10, int r11, int r12, View r13, boolean r14) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r8 = (ViewGroup) r13;
        int r15 = r13.getScrollX();
        int r16 = r13.getScrollY();
        int r17 = r8.getChildCount() - 1;
    L5:
        if (r17 < 0) goto L18;
        View r18 = r8.getChildAt(r17);
        int r19 = r11 + r15;
        if (r19 < r18.getLeft()) goto L17;
        if (r19 >= r18.getRight()) goto L17;
        int r20 = r12 + r16;
        if (r20 < r18.getTop()) goto L17;
        if (r20 >= r18.getBottom()) goto L17;
        if (c(r10, r19 - r18.getLeft(), r20 - r18.getTop(), r18, true) == false) goto L17;
        return true;
    L17:
        r17 = r17 - 1;
    L18:
        if (r14 == true) goto L20;
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r10) == false) goto L22;
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean r8) {
        if (this.D == r8) goto L6;
        this.D = r8;
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final e a(int r8, int r10) {
        e r11 = new e();
        r11.f2759b = r8;
        xb.d r12 = (xb.d) this.f2743o;
        xb.e r13 = r12.c(r8);
        r13.setContentDescription(r12.f13777d.getCalendarContentDescription());
        r13.setAlpha(0.0f);
        r13.m(r12.f13792s);
        r13.o(r12.f13787n);
        r13.h(r12.f13788o);
        r13.i(r12.f13789p);
        Integer r14 = r12.f13779f;
        if (r14 == null) goto L5;
        r13.l(r14.intValue());
    L5:
        Integer r15 = r12.f13780g;
        if (r15 == null) goto L8;
        r13.g(r15.intValue());
    L8:
        Integer r16 = r12.f13781h;
        if (r16 == null) goto L11;
        r13.p(r16.intValue());
    L11:
        r13.n(r12.f13782i);
        r13.f13800q = r12.f13783j;
        r13.q();
        r13.f13801r = r12.f13784k;
        r13.q();
        r13.k(r12.f13786m);
        addView(r13);
        r12.f13776c.add((V) r13);
        r13.j(r12.f13791r);
        r11.f2758a = r13;
        this.f2743o.getClass();
        r11.f2761d = 1.0f;
        ArrayList<e> r17 = this.f2735b;
        if (r10 >= 0) goto L14;
    L17:
        r17.add(r11);
    L18:
        return r11;
    L14:
        if (r10 >= r17.size()) goto L17;
        r17.add(r10, r11);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r8, int r10, int r11) {
        int r12 = r8.size();
        int r13 = getDescendantFocusability();
        if (r13 == 393216) goto L16;
        int r14 = 0;
    L6:
        if (r14 >= getChildCount()) goto L16;
        View r15 = getChildAt(r14);
        if (r15.getVisibility() != 0) goto L14;
        e r16 = g(r15);
        if (r16 == null) goto L14;
        if (r16.f2759b != this.f2744p) goto L14;
        r15.addFocusables(r8, r10, r11);
    L14:
        r14 = r14 + 1;
    L16:
        if (r13 != 262144) goto L20;
        if (r12 == r8.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r11 & 1) == 1) goto L25;
    L29:
        r8.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r8) {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L13;
        View r11 = getChildAt(r10);
        if (r11.getVisibility() != 0) goto L12;
        e r12 = g(r11);
        if (r12 == null) goto L12;
        if (r12.f2759b != this.f2744p) goto L12;
        r11.addTouchables(r8);
    L12:
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        if (checkLayoutParams(r11) == true) goto L5;
        r11 = new f();
    L5:
        f r12 = (f) r11;
        boolean r13 = r12.f2763a;
        if (r8.getClass().getAnnotation(d.class) == null) goto L8;
        boolean r14 = true;
    L9:
        boolean r15 = r13 | r14;
        r12.f2763a = r15;
        if (this.C == false) goto L15;
        if (r15 == true) goto L14;
        r12.f2766d = true;
        addViewInLayout(r8, r10, r11);
        return;
    L14:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L15:
        super.addView(r8, r10, r11);
        return;
    L8:
        r14 = false;
        goto L9
    }

    public final boolean b(int r8) {
        View r10 = findFocus();
        boolean r11 = true;
        boolean r12 = false;
        if (r10 == this) goto L19;
        if (r10 == null) goto L20;
        ViewParent r13 = r10.getParent();
    L8:
        if ((r13 instanceof ViewGroup) == false) goto L12;
        if (r13 == this) goto L10;
        r13 = r13.getParent();
        goto L8
    L10:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L20;
        StringBuilder r15 = new StringBuilder();
        r15.append(r10.getClass().getSimpleName());
        ViewParent r16 = r10.getParent();
    L16:
        if ((r16 instanceof ViewGroup) == false) goto L18;
        r15.append(" => ");
        r15.append(r16.getClass().getSimpleName());
        r16 = r16.getParent();
        goto L16
    L18:
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + r15.toString());
        goto L19
    L12:
        r14 = false;
    L20:
        View r17 = FocusFinder.getInstance().findNextFocus(this, r10, r8);
        if (r17 == null) goto L38;
        if (r17 == r10) goto L38;
        Rect r18 = this.f2742n;
        if (r8 != 17) goto L31;
        int r19 = f(r17, r18).left;
        int r20 = f(r10, r18).left;
        if (r10 == null) goto L36;
        if (r19 < r20) goto L36;
        int r21 = this.f2744p;
        if (r21 > 0) goto L47;
    L48:
        r11 = false;
    L49:
        r12 = r11;
    L50:
        if (r12 == false) goto L52;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r8));
    L52:
        return r12;
    L47:
        t(r21 - 1, true);
    L36:
        boolean r22 = r17.requestFocus();
    L37:
        r12 = r22;
        goto L50
    L31:
        if (r8 != 66) goto L50;
        int r23 = f(r17, r18).left;
        int r24 = f(r10, r18).left;
        if (r10 == null) goto L36;
        if (r23 > r24) goto L36;
        r22 = l();
    L38:
        if (r8 == 17) goto L45;
        if (r8 == 1) goto L45;
        if (r8 != 66) goto L43;
    L44:
        r12 = l();
        goto L50
    L43:
        if (r8 != 2) goto L50;
    L45:
        r21 = this.f2744p;
        if (r21 <= 0) goto L48;
    L19:
        r10 = null;
        goto L20
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r8) {
        if (this.f2743o != null) goto L5;
        return false;
    L5:
        int r10 = getClientWidth();
        int r11 = getScrollX();
        if (r8 < 0) goto L8;
        if (r8 > 0) goto L13;
        return false;
    L13:
        if (r11 < ((int) (r10 * this.A))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r11 > ((int) (r10 * this.f2754z))) goto L10;
        return false;
    L10:
        return true;
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

    @Override // android.view.View
    public final void computeScroll() {
        this.f2748t = true;
        if (this.f2747s.isFinished() == false) goto L5;
    L14:
        d(true);
        return;
    L5:
        if (this.f2747s.computeScrollOffset() == false) goto L14;
        int r8 = getScrollX();
        int r10 = getScrollY();
        int r11 = this.f2747s.getCurrX();
        int r12 = this.f2747s.getCurrY();
        if (r8 != r11) goto L9;
        if (r10 != r12) goto L9;
    L12:
        WeakHashMap<View, h0> r13 = w.f8437a;
        w.d.k(this);
        return;
    L9:
        scrollTo(r11, r12);
        if (m(r11) == true) goto L12;
        this.f2747s.abortAnimation();
        scrollTo(0, r12);
        goto L12
    }

    public final void d(boolean r8) {
        if (this.f2740g0 != 2) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.f2747s.isFinished()) == false) goto L15;
        this.f2747s.abortAnimation();
        int r11 = getScrollX();
        int r12 = getScrollY();
        int r13 = this.f2747s.getCurrX();
        int r14 = this.f2747s.getCurrY();
        if (r11 != r13) goto L12;
        if (r12 == r14) goto L15;
    L12:
        scrollTo(r13, r14);
        if (r13 == r11) goto L15;
        m(r13);
    L15:
        this.E = false;
        int r15 = 0;
    L16:
        ArrayList<e> r16 = this.f2735b;
        if (r15 >= r16.size()) goto L22;
        e r17 = r16.get(r15);
        if (r17.f2760c == false) goto L21;
        r17.f2760c = false;
        r10 = true;
    L21:
        r15 = r15 + 1;
        goto L16
    L22:
        if (r10 == false) goto L31;
        c r18 = this.f2739f0;
        if (r8 == false) goto L26;
        WeakHashMap<View, h0> r19 = w.f8437a;
        w.d.m(this, r18);
        return;
    L26:
        r18.run();
        return;
    L31:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r8) {
        if (super.dispatchKeyEvent(r8) == false) goto L5;
        return true;
    L5:
        if (r8.getAction() != 0) goto L30;
        int r10 = r8.getKeyCode();
        if (r10 == 21) goto L24;
        if (r10 == 22) goto L20;
        if (r10 != 61) goto L30;
        if (r8.hasNoModifiers() == false) goto L17;
        boolean r11 = b(2);
    L31:
        if (r11 == false) goto L34;
        return true;
    L34:
        return false;
    L17:
        if (r8.hasModifiers(1) == false) goto L30;
        r11 = b(1);
        goto L31
    L20:
        if (r8.hasModifiers(2) == false) goto L22;
        r11 = l();
        goto L31
    L22:
        int r12 = 66;
    L29:
        r11 = b(r12);
        goto L31
    L24:
        if (r8.hasModifiers(2) == false) goto L28;
        int r13 = this.f2744p;
        if (r13 <= 0) goto L30;
        t(r13 - 1, true);
        r11 = true;
        goto L31
    L28:
        r12 = 17;
    L30:
        r11 = false;
        goto L31
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r8) {
        if (r8.getEventType() == 4096) goto L5;
        int r10 = getChildCount();
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L19;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 0) goto L18;
        e r13 = g(r12);
        if (r13 == null) goto L18;
        if (r13.f2759b != this.f2744p) goto L18;
        if (r12.dispatchPopulateAccessibilityEvent(r8) == false) goto L18;
        return true;
    L18:
        r11 = r11 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r8);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        int r10 = getOverScrollMode();
        boolean r11 = false;
        if (r10 == 0) goto L13;
        if (r10 != 1) goto L11;
        i1.a r12 = this.f2743o;
        if (r12 == null) goto L11;
        if (r12.a() > 1) goto L13;
    L11:
        this.V.finish();
        this.W.finish();
    L18:
        if (r11 == false) goto L21;
        WeakHashMap<View, h0> r13 = w.f8437a;
        w.d.k(this);
        return;
    L21:
        return;
    L13:
        if (this.V.isFinished() == true) goto L16;
        int r14 = r8.save();
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = getWidth();
        r8.rotate(270.0f);
        r8.translate(getPaddingTop() + (-r15), this.f2754z * r16);
        this.V.setSize(r15, r16);
        r11 = false | this.V.draw(r8);
        r8.restoreToCount(r14);
    L16:
        if (this.W.isFinished() == true) goto L18;
        int r17 = r8.save();
        int r18 = getWidth();
        int r19 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.A + 1.0f)) * r18);
        this.W.setSize(r19, r18);
        r11 = r11 | this.W.draw(r8);
        r8.restoreToCount(r17);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r8 = this.f2751w;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isStateful() == false) goto L9;
        r8.setState(getDrawableState());
        return;
    }

    public final void e() {
        int r8 = this.f2743o.a();
        this.f2733a = r8;
        ArrayList<e> r10 = this.f2735b;
        if (r10.size() < ((this.F * 2) + 1)) goto L5;
    L7:
        boolean r11 = false;
    L8:
        int r12 = this.f2744p;
        int r13 = 0;
        boolean r14 = false;
    L10:
        if (r13 >= r10.size()) goto L38;
        e r15 = r10.get(r13);
        i1.a r16 = this.f2743o;
        xb.e r17 = r15.f2758a;
        xb.d r18 = (xb.d) r16;
        if (r18.k(r17) == true) goto L15;
    L19:
        int r19 = -2;
    L21:
        if (r19 == (-1)) goto L37;
        if (r19 != (-2)) goto L30;
        r10.remove(r13);
        r13 = r13 - 1;
        if (r14 == true) goto L27;
        this.f2743o.getClass();
        r14 = true;
    L27:
        i1.a r20 = this.f2743o;
        xb.e r21 = r15.f2758a;
        ((xb.d) r20).f13776c.remove(r21);
        removeView(r21);
        int r22 = this.f2744p;
        if (r22 != r15.f2759b) goto L36;
        r12 = Math.max(0, Math.min(r22, (-1) + r8));
    L36:
        r11 = true;
        goto L37
    L30:
        int r110 = r15.f2759b;
        if (r110 == r19) goto L37;
        if (r110 != this.f2744p) goto L35;
        r12 = r19;
    L35:
        r15.f2759b = r19;
    L37:
        r13 = r13 + 1;
        goto L10
    L15:
        if (r17.f13799p == null) goto L19;
        r19 = r18.i(r17);
        if (r19 >= 0) goto L21;
    L38:
        if (r14 == false) goto L40;
        this.f2743o.getClass();
    L40:
        Collections.sort(r10, f2730i0);
        if (r11 == false) goto L57;
        int r23 = getChildCount();
        int r24 = 0;
    L43:
        if (r24 >= r23) goto L48;
        f r25 = (f) getChildAt(r24).getLayoutParams();
        if (r25.f2763a == true) goto L47;
        r25.f2765c = 0.0f;
    L47:
        r24 = r24 + 1;
        goto L43
    L48:
        u(r12, 0, false, true);
        requestLayout();
        return;
    L57:
        return;
    L5:
        if (r10.size() >= r8) goto L7;
        r11 = true;
        goto L8
    }

    public final Rect f(View r8, Rect r10) {
        if (r10 != null) goto L4;
        r10 = new Rect();
    L4:
        if (r8 != null) goto L7;
        r10.set(0, 0, 0, 0);
        return r10;
    L7:
        r10.left = r8.getLeft();
        r10.right = r8.getRight();
        r10.top = r8.getTop();
        r10.bottom = r8.getBottom();
        ViewParent r11 = r8.getParent();
    L9:
        if ((r11 instanceof ViewGroup) == false) goto L12;
        if (r11 == this) goto L12;
        ViewGroup r12 = (ViewGroup) r11;
        int r13 = r10.left;
        r10.left = r12.getLeft() + r13;
        int r14 = r10.right;
        r10.right = r12.getRight() + r14;
        int r15 = r10.top;
        r10.top = r12.getTop() + r15;
        int r16 = r10.bottom;
        r10.bottom = r12.getBottom() + r16;
        r11 = r12.getParent();
    L12:
        return r10;
    }

    public final e g(View r8) {
        int r10 = 0;
    L3:
        ArrayList<e> r11 = this.f2735b;
        if (r10 >= r11.size()) goto L12;
        e r12 = r11.get(r10);
        i1.a r13 = this.f2743o;
        xb.e r14 = r12.f2758a;
        ((xb.d) r13).getClass();
        if (r8 != r14) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == true) goto L10;
        r10 = r10 + 1;
        goto L3
    L10:
        return r12;
    L8:
        r15 = false;
        goto L9
    L12:
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new f(getContext(), r8);
    }

    public i1.a getAdapter() {
        return this.f2743o;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r8, int r10) {
        if (this.d0 != 2) goto L6;
        r10 = (r8 - 1) - r10;
    L6:
        return ((f) this.f2738e0.get(r10).getLayoutParams()).f2768f;
    }

    public int getCurrentItem() {
        return this.f2744p;
    }

    public int getOffscreenPageLimit() {
        return this.F;
    }

    public int getPageMargin() {
        return this.f2750v;
    }

    public final e h() {
        int r8 = getClientWidth();
        float r10 = 0.0f;
        if (r8 <= 0) goto L5;
        float r11 = getScrollX() / r8;
    L6:
        if (r8 <= 0) goto L8;
        float r12 = this.f2750v / r8;
    L9:
        int r13 = 0;
        boolean r14 = true;
        e r15 = null;
        int r16 = -1;
        float r17 = 0.0f;
    L10:
        ArrayList<e> r18 = this.f2735b;
        if (r13 >= r18.size()) goto L31;
        e r19 = r18.get(r13);
        if (r14 == true) goto L17;
        int r20 = r16 + 1;
        if (r19.f2759b == r20) goto L17;
        float r21 = (r10 + r17) + r12;
        e r22 = this.f2741m;
        r22.f2762e = r21;
        r22.f2759b = r20;
        this.f2743o.getClass();
        r22.f2761d = 1.0f;
        r13 = r13 - 1;
        e r23 = r22;
    L18:
        r10 = r23.f2762e;
        float r24 = (r23.f2761d + r10) + r12;
        if (r14 == true) goto L25;
        if (r11 >= r10) goto L25;
        return r15;
    L25:
        if (r11 < r24) goto L30;
        if (r13 == (r18.size() - 1)) goto L30;
        int r25 = r23.f2759b;
        float r26 = r23.f2761d;
        r13 = r13 + 1;
        r14 = false;
        e r110 = r23;
        r16 = r25;
        r17 = r26;
        r15 = r110;
    L30:
        return r23;
    L17:
        r23 = r19;
        goto L18
    L31:
        return r15;
    L8:
        r12 = 0.0f;
        goto L9
    L5:
        r11 = 0.0f;
        goto L6
    }

    public final e i(int r8) {
        int r10 = 0;
    L3:
        ArrayList<e> r11 = this.f2735b;
        if (r10 >= r11.size()) goto L9;
        e r12 = r11.get(r10);
        if (r12.f2759b == r8) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return r12;
    L9:
        return null;
    }

    public final void j(float r10, int r11, int r12) {
        int r13 = 0;
        if (this.Z <= 0) goto L25;
        int r14 = getScrollX();
        int r8 = getPaddingLeft();
        int r15 = getPaddingRight();
        int r16 = getWidth();
        int r17 = getChildCount();
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L25;
        View r19 = getChildAt(r18);
        f r20 = (f) r19.getLayoutParams();
        if (r20.f2763a == false) goto L24;
        int r21 = r20.f2764b & 7;
        if (r21 != 1) goto L12;
        int r22 = Math.max((r16 - r19.getMeasuredWidth()) / 2, r8);
    L19:
        int r23 = r22;
        int r24 = r8;
        r8 = r23;
    L20:
        int r25 = (r8 + r14) - r19.getLeft();
        if (r25 == 0) goto L23;
        r19.offsetLeftAndRight(r25);
    L23:
        r8 = r24;
        goto L24
    L12:
        if (r21 != 3) goto L14;
        r24 = r19.getWidth() + r8;
        goto L20
    L14:
        if (r21 == 5) goto L16;
        r24 = r8;
        goto L20
    L16:
        r22 = (r16 - r15) - r19.getMeasuredWidth();
        r15 = r15 + r19.getMeasuredWidth();
    L24:
        r18 = r18 + 1;
    L25:
        h r110 = this.f2734a0;
        if (r110 == null) goto L29;
        r110.b();
    L29:
        if (this.f2736b0 == null) goto L37;
        int r111 = getScrollX();
        int r26 = getChildCount();
    L31:
        if (r13 >= r26) goto L37;
        View r27 = getChildAt(r13);
        if (((f) r27.getLayoutParams()).f2763a == true) goto L36;
        float r28 = (r27.getLeft() - r111) / getClientWidth();
        ((MaterialCalendarView.c) this.f2736b0).getClass();
        r27.setAlpha((float) Math.sqrt(1.0f - Math.abs(r28)));
    L36:
        r13 = r13 + 1;
    L37:
        this.Y = true;
    }

    public final void k(MotionEvent r8) {
        int r10 = r8.getActionIndex();
        if (r8.getPointerId(r10) != this.P) goto L11;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.L = r8.getX(r11);
        this.P = r8.getPointerId(r11);
        VelocityTracker r12 = this.Q;
        if (r12 == null) goto L12;
        r12.clear();
        return;
    L12:
        return;
    L6:
        r11 = 0;
        goto L7
    }

    public final boolean l() {
        i1.a r8 = this.f2743o;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (this.f2744p >= (r8.a() - 1)) goto L10;
        t(this.f2744p + 1, true);
        return true;
    L10:
        return false;
    }

    public final boolean m(int r8) {
        if (this.f2735b.size() == 0) goto L5;
        e r10 = h();
        int r11 = getClientWidth();
        int r12 = this.f2750v;
        int r13 = r11 + r12;
        float r14 = r11;
        int r15 = r10.f2759b;
        float r16 = ((r8 / r14) - r10.f2762e) / (r10.f2761d + (r12 / r14));
        this.Y = false;
        j(r16, r15, (int) (r13 * r16));
        if (this.Y == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.X == false) goto L7;
        return false;
    L7:
        this.Y = false;
        j(0.0f, 0, 0);
        if (this.Y == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean n(float r10) {
        float r8 = this.L - r10;
        this.L = r10;
        float r11 = getScrollX() + r8;
        float r12 = getClientWidth();
        float r13 = this.f2754z * r12;
        float r14 = this.A * r12;
        ArrayList<e> r15 = this.f2735b;
        boolean r16 = false;
        e r17 = r15.get(0);
        e r18 = r15.get(r15.size() - 1);
        if (r17.f2759b == 0) goto L5;
        r13 = r17.f2762e * r12;
        boolean r19 = false;
    L7:
        if (r18.f2759b == (this.f2743o.a() - 1)) goto L9;
        r14 = r18.f2762e * r12;
        boolean r20 = false;
    L11:
        if (r11 >= r13) goto L16;
        if (r19 == false) goto L14;
        this.V.onPull(Math.abs(r13 - r11) / r12);
        r16 = true;
    L14:
        r11 = r13;
    L20:
        int r21 = (int) r11;
        this.L = (r11 - r21) + this.L;
        scrollTo(r21, getScrollY());
        m(r21);
        return r16;
    L16:
        if (r11 <= r14) goto L20;
        if (r20 == false) goto L19;
        this.W.onPull(Math.abs(r11 - r14) / r12);
        r16 = true;
    L19:
        r11 = r14;
        goto L20
    L9:
        r20 = true;
        goto L11
    L5:
        r19 = true;
        goto L7
    }

    public final void o() {
        p(this.f2744p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.X = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2739f0);
        Scroller r8 = this.f2747s;
        if (r8 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r8.isFinished() == true) goto L7;
        this.f2747s.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        super.onDraw(r19);
        if (this.f2750v > 0) goto L5;
        return;
    L5:
        if (this.f2751w == null) goto L32;
        ArrayList<e> r8 = this.f2735b;
        if (r8.size() > 0) goto L9;
        return;
    L9:
        if (this.f2743o == null) goto L34;
        int r10 = getScrollX();
        int r11 = getWidth();
        float r12 = r11;
        float r13 = this.f2750v / r12;
        int r14 = 0;
        e r15 = r8.get(0);
        float r16 = r15.f2762e;
        int r17 = r8.size();
        int r18 = r15.f2759b;
        int r110 = r8.get(r17 - 1).f2759b;
    L11:
        if (r18 >= r110) goto L35;
    L12:
        int r111 = r15.f2759b;
        if (r18 <= r111) goto L16;
        if (r14 >= r17) goto L16;
        r14 = r14 + 1;
        r15 = r8.get(r14);
    L16:
        if (r18 != r111) goto L18;
        float r20 = r15.f2762e;
        float r112 = r15.f2761d;
        float r113 = (r20 + r112) * r12;
        r16 = (r20 + r112) + r13;
    L20:
        if ((this.f2750v + r113) <= r10) goto L24;
        this.f2751w.setBounds(Math.round(r113), this.f2752x, Math.round(this.f2750v + r113), this.f2753y);
        this.f2751w.draw(r19);
    L24:
        if (r113 > (r10 + r11)) goto L36;
        r18 = r18 + 1;
        r8 = r8;
        r13 = r13;
        goto L11
    L36:
        return;
    L18:
        this.f2743o.getClass();
        r113 = (r16 + 1.0f) * r12;
        r16 = (1.0f + r13) + r16;
        goto L20
    L35:
        return;
    L34:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r13) {
        int r8 = r13.getAction() & 255;
        if (r8 != 3) goto L5;
    L74:
        r();
        return false;
    L5:
        if (r8 == 1) goto L74;
        if (r8 == 0) goto L15;
        if (this.G == false) goto L12;
        return true;
    L12:
        if (this.H == false) goto L15;
        return false;
    L15:
        if (r8 == 0) goto L60;
        if (r8 != 2) goto L18;
        int r10 = this.P;
        if (r10 == (-1)) goto L70;
        int r11 = r13.findPointerIndex(r10);
        float r12 = r13.getX(r11);
        float r14 = r12 - this.L;
        float r15 = Math.abs(r14);
        float r16 = r13.getY(r11);
        float r17 = Math.abs(r16 - this.O);
        if (r14 == 0.0f) goto L40;
        float r18 = this.L;
        if (r18 >= this.J) goto L30;
        if (r14 <= 0.0f) goto L30;
    L33:
        boolean r19 = true;
    L35:
        if (r19 == true) goto L40;
        if (c((int) r14, (int) r12, (int) r16, this, false) == false) goto L40;
        this.L = r12;
        this.M = r16;
        this.H = true;
        return false;
    L30:
        if (r18 > (getWidth() - this.J)) goto L32;
    L34:
        r19 = false;
        goto L35
    L32:
        if (r14 >= 0.0f) goto L34;
    L40:
        float r20 = this.K;
        if (r15 <= r20) goto L53;
        if ((r15 * 0.5f) <= r17) goto L53;
        this.G = true;
        ViewParent r21 = getParent();
        if (r21 == null) goto L47;
        r21.requestDisallowInterceptTouchEvent(true);
    L47:
        setScrollState(1);
        float r22 = this.N;
        float r23 = this.K;
        if (r14 <= 0.0f) goto L50;
        float r24 = r22 + r23;
    L51:
        this.L = r24;
        this.M = r16;
        setScrollingCacheEnabled(true);
    L56:
        if (this.G == false) goto L70;
        if (n(r12) == false) goto L70;
        WeakHashMap<View, h0> r25 = w.f8437a;
        w.d.k(this);
        goto L70
    L50:
        r24 = r22 - r23;
    L53:
        if (r17 <= r20) goto L56;
        this.H = true;
    L70:
        if (this.Q != null) goto L72;
        this.Q = VelocityTracker.obtain();
    L72:
        this.Q.addMovement(r13);
        return this.G;
    L18:
        if (r8 != 6) goto L70;
        k(r13);
        goto L70
    L60:
        float r26 = r13.getX();
        this.N = r26;
        this.L = r26;
        float r27 = r13.getY();
        this.O = r27;
        this.M = r27;
        this.P = r13.getPointerId(0);
        this.H = false;
        this.f2748t = true;
        this.f2747s.computeScrollOffset();
        if (this.f2740g0 == 2) goto L63;
    L68:
        d(false);
        this.G = false;
        goto L70
    L63:
        if (Math.abs(this.f2747s.getFinalX() - this.f2747s.getCurrX()) <= this.U) goto L68;
        this.f2747s.abortAnimation();
        this.E = false;
        o();
        this.G = true;
        ViewParent r28 = getParent();
        if (r28 == null) goto L67;
        r28.requestDisallowInterceptTouchEvent(true);
    L67:
        setScrollState(1);
        goto L70
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r8 = getChildCount();
        int r10 = r22 - r20;
        int r11 = r23 - r21;
        int r12 = getPaddingLeft();
        int r13 = getPaddingTop();
        int r14 = getPaddingRight();
        int r15 = getPaddingBottom();
        int r16 = getScrollX();
        int r17 = 0;
        int r18 = 0;
    L4:
        if (r17 >= r8) goto L33;
        View r110 = getChildAt(r17);
        if (r110.getVisibility() == 8) goto L32;
        f r111 = (f) r110.getLayoutParams();
        if (r111.f2763a == false) goto L32;
        int r112 = r111.f2764b;
        int r113 = r112 & 7;
        int r114 = r112 & BWDLInnerConstant.LINK_RECOVERY;
        if (r113 != 1) goto L12;
        int r115 = Math.max((r10 - r110.getMeasuredWidth()) / 2, r12);
    L19:
        int r116 = r115;
        int r117 = r12;
        r12 = r116;
    L21:
        if (r114 != 16) goto L23;
        int r118 = Math.max((r11 - r110.getMeasuredHeight()) / 2, r13);
    L30:
        int r119 = r118;
        int r120 = r13;
        r13 = r119;
    L31:
        int r24 = r12 + r16;
        r110.layout(r24, r13, r110.getMeasuredWidth() + r24, r110.getMeasuredHeight() + r13);
        r18 = r18 + 1;
        r13 = r120;
        r12 = r117;
        goto L32
    L23:
        if (r114 != 48) goto L25;
        r120 = r110.getMeasuredHeight() + r13;
        goto L31
    L25:
        if (r114 == 80) goto L27;
        r120 = r13;
        goto L31
    L27:
        r118 = (r11 - r15) - r110.getMeasuredHeight();
        r15 = r15 + r110.getMeasuredHeight();
        goto L30
    L12:
        if (r113 != 3) goto L14;
        r117 = r110.getMeasuredWidth() + r12;
        goto L21
    L14:
        if (r113 == 5) goto L16;
        r117 = r12;
        goto L21
    L16:
        r115 = (r10 - r14) - r110.getMeasuredWidth();
        r14 = r14 + r110.getMeasuredWidth();
    L32:
        r17 = r17 + 1;
        goto L4
    L33:
        int r25 = (r10 - r12) - r14;
        int r26 = 0;
    L34:
        if (r26 >= r8) goto L46;
        View r27 = getChildAt(r26);
        if (r27.getVisibility() == 8) goto L45;
        f r28 = (f) r27.getLayoutParams();
        if (r28.f2763a == true) goto L45;
        e r121 = g(r27);
        if (r121 == null) goto L45;
        float r122 = r25;
        int r123 = ((int) (r121.f2762e * r122)) + r12;
        if (r28.f2766d == false) goto L44;
        r28.f2766d = false;
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) (r122 * r28.f2765c), 1073741824), View.MeasureSpec.makeMeasureSpec((r11 - r13) - r15, 1073741824));
    L44:
        r27.layout(r123, r13, r27.getMeasuredWidth() + r123, r27.getMeasuredHeight() + r13);
    L45:
        r26 = r26 + 1;
        goto L34
    L46:
        this.f2752x = r13;
        this.f2753y = r11 - r15;
        this.Z = r18;
        if (this.X == false) goto L49;
        boolean r29 = false;
        s(this.f2744p, 0, false, false);
    L50:
        this.X = r29;
        return;
    L49:
        r29 = false;
        goto L50
    }

    @Override // android.view.View
    public final void onMeasure(int r14, int r15) {
        int r8 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r14), ViewGroup.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.J = Math.min(r16 / 10, this.I);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        boolean r12 = true;
        int r13 = 1073741824;
        if (r11 >= r10) goto L49;
        View r19 = getChildAt(r11);
        if (r19.getVisibility() == 8) goto L48;
        f r20 = (f) r19.getLayoutParams();
        if (r20 == null) goto L48;
        if (r20.f2763a == false) goto L48;
        int r21 = r20.f2764b;
        int r22 = r21 & 7;
        int r23 = r21 & BWDLInnerConstant.LINK_RECOVERY;
        if (r23 != 48) goto L14;
    L17:
        boolean r24 = true;
    L19:
        if (r22 != 3) goto L21;
    L24:
        int r25 = Integer.MIN_VALUE;
        if (r24 == false) goto L27;
        int r26 = Integer.MIN_VALUE;
        r25 = 1073741824;
    L30:
        int r110 = ((ViewGroup.LayoutParams) r20).width;
        if (r110 == (-2)) goto L36;
        if (r110 != (-1)) goto L35;
        r110 = r17;
    L35:
        r25 = 1073741824;
    L37:
        int r27 = ((ViewGroup.LayoutParams) r20).height;
        if (r27 == (-2)) goto L42;
        if (r27 != (-1)) goto L43;
        r27 = r18;
    L43:
        r19.measure(View.MeasureSpec.makeMeasureSpec(r110, r25), View.MeasureSpec.makeMeasureSpec(r27, r13));
        if (r24 == false) goto L46;
        r18 = r18 - r19.getMeasuredHeight();
        goto L48
    L46:
        if (r12 == false) goto L48;
        r17 = r17 - r19.getMeasuredWidth();
        goto L48
    L42:
        r27 = r18;
        r13 = r26;
        goto L43
    L36:
        r110 = r17;
        goto L37
    L27:
        if (r12 == false) goto L29;
        r26 = 1073741824;
        goto L30
    L29:
        r26 = Integer.MIN_VALUE;
        goto L30
    L21:
        if (r22 == 5) goto L24;
        r12 = false;
        goto L24
    L14:
        if (r23 == 80) goto L17;
        r24 = false;
    L48:
        r11 = r11 + 1;
        goto L3
    L49:
        View.MeasureSpec.makeMeasureSpec(r17, 1073741824);
        this.B = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.C = true;
        o();
        this.C = false;
        int r111 = getChildCount();
    L50:
        if (r8 >= r111) goto L59;
        View r28 = getChildAt(r8);
        if (r28.getVisibility() == 8) goto L58;
        f r29 = (f) r28.getLayoutParams();
        if (r29 != null) goto L56;
    L57:
        r28.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r29.f2765c), 1073741824), this.B);
        goto L58
    L56:
        if (r29.f2763a == false) goto L57;
    L58:
        r8 = r8 + 1;
        goto L50
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r10, Rect r11) {
        int r8 = getChildCount();
        if ((r10 & 2) == 0) goto L5;
        int r12 = r8;
        int r13 = 0;
        int r14 = 1;
    L6:
        if (r13 == r12) goto L17;
        View r15 = getChildAt(r13);
        if (r15.getVisibility() != 0) goto L16;
        e r16 = g(r15);
        if (r16 == null) goto L16;
        if (r16.f2759b != this.f2744p) goto L16;
        if (r15.requestFocus(r10, r11) == false) goto L16;
        return true;
    L16:
        r13 = r13 + r14;
        goto L6
    L17:
        return false;
    L5:
        r13 = r8 - 1;
        r12 = -1;
        r14 = -1;
        goto L6
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        if (this.f2743o == null) goto L9;
        u(r10.f2755m, 0, false, true);
        return;
    L9:
        this.f2745q = r10.f2755m;
        this.f2746r = r10.f2756n;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f2755m = this.f2744p;
        i1.a r10 = this.f2743o;
        if (r10 == null) goto L5;
        r10.getClass();
        r8.f2756n = null;
    L5:
        return r8;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        if (r8 == r11) goto L6;
        int r13 = this.f2750v;
        q(r8, r11, r13, r13);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        boolean r8 = false;
        if (r10.getAction() == 0) goto L5;
    L7:
        i1.a r11 = this.f2743o;
        if (r11 != null) goto L10;
    L79:
        return false;
    L10:
        if (r11.a() == 0) goto L79;
        if (this.Q != null) goto L15;
        this.Q = VelocityTracker.obtain();
    L15:
        this.Q.addMovement(r10);
        int r12 = r10.getAction() & 255;
        if (r12 != 0) goto L18;
        this.f2747s.abortAnimation();
        this.E = false;
        o();
        float r13 = r10.getX();
        this.N = r13;
        this.L = r13;
        float r14 = r10.getY();
        this.O = r14;
        this.M = r14;
        int r15 = r10.getPointerId(0);
    L75:
        this.P = r15;
    L76:
        if (r8 == false) goto L78;
        WeakHashMap<View, h0> r16 = w.f8437a;
        w.d.k(this);
    L78:
        return true;
    L18:
        if (r12 == 1) goto L56;
        if (r12 == 2) goto L34;
        if (r12 == 3) goto L31;
        if (r12 != 5) goto L26;
        int r17 = r10.getActionIndex();
        this.L = r10.getX(r17);
        r15 = r10.getPointerId(r17);
        goto L75
    L26:
        if (r12 != 6) goto L76;
        k(r10);
        this.L = r10.getX(r10.findPointerIndex(this.P));
        goto L76
    L31:
        if (this.G == false) goto L76;
        s(this.f2744p, 0, true, false);
    L73:
        r8 = r();
        goto L76
    L34:
        if (this.G == true) goto L53;
        int r18 = r10.findPointerIndex(this.P);
        if (r18 == (-1)) goto L73;
        float r19 = r10.getX(r18);
        float r20 = Math.abs(r19 - this.L);
        float r21 = r10.getY(r18);
        float r22 = Math.abs(r21 - this.M);
        if (r20 <= this.K) goto L53;
        if (r20 <= r22) goto L53;
        this.G = true;
        ViewParent r23 = getParent();
        if (r23 == null) goto L45;
        r23.requestDisallowInterceptTouchEvent(true);
    L45:
        float r24 = this.N;
        if ((r19 - r24) <= 0.0f) goto L48;
        float r25 = r24 + this.K;
    L49:
        this.L = r25;
        this.M = r21;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r26 = getParent();
        if (r26 == null) goto L53;
        r26.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r25 = r24 - this.K;
    L53:
        if (this.G == false) goto L76;
        r8 = false | n(r10.getX(r10.findPointerIndex(this.P)));
        goto L76
    L56:
        if (this.G == false) goto L76;
        VelocityTracker r27 = this.Q;
        r27.computeCurrentVelocity(1000, this.S);
        int r28 = (int) r27.getXVelocity(this.P);
        this.E = true;
        int r29 = getClientWidth();
        int r30 = getScrollX();
        e r31 = h();
        float r32 = r29;
        float r33 = this.f2750v / r32;
        int r34 = r31.f2759b;
        float r35 = ((r30 / r32) - r31.f2762e) / (r31.f2761d + r33);
        if (Math.abs((int) (r10.getX(r10.findPointerIndex(this.P)) - this.N)) <= this.T) goto L65;
        if (Math.abs(r28) <= this.R) goto L65;
        if (r28 > 0) goto L69;
        r34 = r34 + 1;
    L69:
        ArrayList<e> r110 = this.f2735b;
        if (r110.size() <= 0) goto L72;
        r34 = Math.max(r110.get(0).f2759b, Math.min(r34, r110.get(r110.size() - 1).f2759b));
    L72:
        u(r34, r28, true, true);
    L65:
        if (r34 < this.f2744p) goto L67;
        float r111 = 0.4f;
    L68:
        r34 = r34 + ((int) (r35 + r111));
        goto L69
    L67:
        r111 = 0.6f;
        goto L68
    L5:
        if (r10.getEdgeFlags() == 0) goto L7;
        return false;
    }

    public final void p(int r15) {
        int r8 = this.f2744p;
        if (r8 == r15) goto L5;
        e r10 = i(r8);
        this.f2744p = r15;
    L7:
        if (this.f2743o != null) goto L11;
        w();
        return;
    L11:
        if (this.E == false) goto L15;
        w();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.f2743o.getClass();
        int r16 = this.F;
        int r11 = 0;
        int r12 = Math.max(0, this.f2744p - r16);
        int r13 = this.f2743o.a();
        int r17 = Math.min(r13 - 1, this.f2744p + r16);
        if (r13 != this.f2733a) goto L205;
    L19:
        ArrayList<e> r14 = this.f2735b;
        if (r11 >= r14.size()) goto L26;
        e r18 = r14.get(r11);
        int r19 = r18.f2759b;
        int r20 = this.f2744p;
        if (r19 >= r20) goto L23;
        r11 = r11 + 1;
        goto L19
    L23:
        if (r19 != r20) goto L26;
    L27:
        if (r18 != null) goto L30;
        if (r13 <= 0) goto L30;
        r18 = a(this.f2744p, r11);
    L30:
        if (r18 == null) goto L162;
        int r21 = r11 - 1;
        if (r21 < 0) goto L34;
        e r22 = r14.get(r21);
    L35:
        int r23 = getClientWidth();
        if (r23 > 0) goto L38;
        float r110 = 0.0f;
    L39:
        int r111 = this.f2744p - 1;
        float r112 = 0.0f;
    L40:
        if (r111 < 0) goto L64;
        if (r112 < r110) goto L53;
        if (r111 >= r12) goto L53;
        if (r22 == null) goto L64;
        if (r111 != r22.f2759b) goto L63;
        if (r22.f2760c == true) goto L63;
        r14.remove(r21);
        i1.a r113 = this.f2743o;
        xb.e r24 = r22.f2758a;
        ((xb.d) r113).f13776c.remove(r24);
        removeView(r24);
        r21 = r21 - 1;
        r11 = r11 - 1;
        if (r21 >= 0) goto L61;
    L62:
        r22 = null;
    L61:
        r22 = r14.get(r21);
    L63:
        r111 = r111 - 1;
    L53:
        if (r22 != null) goto L55;
    L59:
        r112 = r112 + a(r111, r21 + 1).f2761d;
        r11 = r11 + 1;
        if (r21 < 0) goto L62;
    L55:
        if (r111 != r22.f2759b) goto L59;
        r112 = r112 + r22.f2761d;
        r21 = r21 - 1;
        if (r21 < 0) goto L62;
    L64:
        float r25 = r18.f2761d;
        int r26 = r11 + 1;
        if (r25 < 2.0f) goto L67;
    L98:
        int r114 = this.f2743o.a();
        int r27 = getClientWidth();
        if (r27 <= 0) goto L101;
        float r28 = this.f2750v / r27;
    L103:
        if (r10 == null) goto L133;
        int r29 = r10.f2759b;
        int r30 = r18.f2759b;
        if (r29 >= r30) goto L120;
        float r31 = (r10.f2762e + r10.f2761d) + r28;
        int r32 = r29 + 1;
        int r33 = 0;
    L108:
        if (r32 > r18.f2759b) goto L133;
        if (r33 >= r14.size()) goto L133;
    L111:
        e r34 = r14.get(r33);
        if (r32 <= r34.f2759b) goto L117;
        if (r33 >= (r14.size() - 1)) goto L117;
        r33 = r33 + 1;
    L117:
        if (r32 >= r34.f2759b) goto L119;
        this.f2743o.getClass();
        r31 = r31 + (1.0f + r28);
        r32 = r32 + 1;
        goto L117
    L119:
        r34.f2762e = r31;
        r31 = r31 + (r34.f2761d + r28);
        r32 = r32 + 1;
        goto L108
    L120:
        if (r29 <= r30) goto L133;
        int r35 = r14.size() - 1;
        float r36 = r10.f2762e;
    L122:
        r29 = r29 - 1;
        if (r29 < r18.f2759b) goto L133;
        if (r35 < 0) goto L133;
    L125:
        e r37 = r14.get(r35);
        if (r29 >= r37.f2759b) goto L130;
        if (r35 <= 0) goto L130;
        r35 = r35 - 1;
    L130:
        if (r29 <= r37.f2759b) goto L132;
        this.f2743o.getClass();
        r36 = r36 - (1.0f + r28);
        r29 = r29 - 1;
        goto L130
    L132:
        r36 = r36 - (r37.f2761d + r28);
        r37.f2762e = r36;
    L133:
        int r38 = r14.size();
        float r39 = r18.f2762e;
        int r40 = r18.f2759b;
        int r41 = r40 - 1;
        if (r40 != 0) goto L136;
        float r115 = r39;
    L137:
        this.f2754z = r115;
        int r116 = r114 - 1;
        if (r40 != r116) goto L140;
        float r42 = (r18.f2761d + r39) - 1.0f;
    L141:
        this.A = r42;
        int r43 = r11 - 1;
    L142:
        if (r43 < 0) goto L151;
        e r44 = r14.get(r43);
    L144:
        int r117 = r44.f2759b;
        if (r41 <= r117) goto L147;
        r41 = r41 - 1;
        this.f2743o.getClass();
        r39 = r39 - (1.0f + r28);
        goto L144
    L147:
        r39 = r39 - (r44.f2761d + r28);
        r44.f2762e = r39;
        if (r117 != 0) goto L150;
        this.f2754z = r39;
    L150:
        r43 = r43 - 1;
        r41 = r41 - 1;
        goto L142
    L151:
        float r45 = (r18.f2762e + r18.f2761d) + r28;
        int r46 = r18.f2759b;
    L152:
        r46 = r46 + 1;
        if (r26 >= r38) goto L161;
        e r47 = r14.get(r26);
    L155:
        int r48 = r47.f2759b;
        if (r46 >= r48) goto L158;
        r46 = r46 + 1;
        this.f2743o.getClass();
        r45 = r45 + (1.0f + r28);
        goto L155
    L158:
        if (r48 != r116) goto L160;
        this.A = (r47.f2761d + r45) - 1.0f;
    L160:
        r47.f2762e = r45;
        r45 = r45 + (r47.f2761d + r28);
        r26 = r26 + 1;
        goto L152
    L161:
        this.f2743o.getClass();
        goto L162
    L140:
        r42 = Float.MAX_VALUE;
        goto L141
    L136:
        r115 = -3.4028235E38f;
        goto L137
    L101:
        r28 = 0.0f;
        goto L103
    L67:
        if (r26 >= r14.size()) goto L69;
        e r49 = r14.get(r26);
    L70:
        if (r23 > 0) goto L72;
        float r50 = 0.0f;
    L73:
        int r51 = this.f2744p + 1;
        int r118 = r26;
    L74:
        if (r51 >= r13) goto L98;
        if (r25 < r50) goto L87;
        if (r51 <= r17) goto L87;
        if (r49 == null) goto L98;
        if (r51 != r49.f2759b) goto L97;
        if (r49.f2760c == true) goto L97;
        r14.remove(r118);
        i1.a r119 = this.f2743o;
        xb.e r52 = r49.f2758a;
        ((xb.d) r119).f13776c.remove(r52);
        removeView(r52);
        if (r118 < r14.size()) goto L95;
    L96:
        r49 = null;
    L95:
        r49 = r14.get(r118);
    L97:
        r51 = r51 + 1;
    L87:
        if (r49 != null) goto L89;
    L93:
        e r53 = a(r51, r118);
        r118 = r118 + 1;
        r25 = r25 + r53.f2761d;
        if (r118 >= r14.size()) goto L96;
    L89:
        if (r51 != r49.f2759b) goto L93;
        r25 = r25 + r49.f2761d;
        r118 = r118 + 1;
        if (r118 >= r14.size()) goto L96;
    L72:
        r50 = (getPaddingRight() / r23) + 2.0f;
        goto L73
    L69:
        r49 = null;
        goto L70
    L38:
        r110 = (2.0f - r18.f2761d) + (getPaddingLeft() / r23);
        goto L39
    L34:
        r22 = null;
    L162:
        this.f2743o.getClass();
        int r120 = getChildCount();
        int r54 = 0;
    L163:
        if (r54 >= r120) goto L172;
        View r55 = getChildAt(r54);
        f r56 = (f) r55.getLayoutParams();
        r56.f2768f = r54;
        if (r56.f2763a == true) goto L171;
        if (r56.f2765c != 0.0f) goto L171;
        e r57 = g(r55);
        if (r57 == null) goto L171;
        r56.f2765c = r57.f2761d;
        r56.f2767e = r57.f2759b;
    L171:
        r54 = r54 + 1;
        goto L163
    L172:
        w();
        if (hasFocus() == false) goto L199;
        View r121 = findFocus();
        if (r121 == null) goto L184;
    L176:
        Object r58 = r121.getParent();
        if (r58 == this) goto L183;
        if (r58 == null) goto L184;
        if ((r58 instanceof View) == false) goto L184;
        r121 = (View) r58;
        goto L176
    L183:
        e r122 = g(r121);
    L185:
        if (r122 != null) goto L187;
    L188:
        int r123 = 0;
    L190:
        if (r123 >= getChildCount()) goto L256;
        View r59 = getChildAt(r123);
        e r60 = g(r59);
        if (r60 == null) goto L198;
        if (r60.f2759b != this.f2744p) goto L198;
        if (r59.requestFocus(2) == false) goto L198;
        return;
    L198:
        r123 = r123 + 1;
        goto L190
    L256:
        return;
    L187:
        if (r122.f2759b != this.f2744p) goto L188;
        return;
    L184:
        r122 = null;
        goto L185
    L199:
        return;
    L26:
        r18 = null;
        goto L27
    L205:
        String r124 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L202
    L203:
        StringBuilder r61 = new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        defpackage.b.q(r61, this.f2733a, ", found: ", r13, " Pager id: ");
        r61.append(r124);
        r61.append(" Pager class: ");
        r61.append(getClass());
        r61.append(" Problematic adapter: ");
        r61.append(this.f2743o.getClass());
        throw new IllegalStateException(r61.toString());
    L202:
        r124 = Integer.toHexString(getId());
        goto L203
    L5:
        r10 = null;
        goto L7
    }

    public final void q(int r8, int r10, int r11, int r12) {
        if (r10 > 0) goto L4;
    L10:
        e r13 = i(this.f2744p);
        if (r13 == null) goto L13;
        float r14 = Math.min(r13.f2762e, this.A);
    L14:
        int r15 = (int) (r14 * ((r8 - getPaddingLeft()) - getPaddingRight()));
        if (r15 == getScrollX()) goto L19;
        d(false);
    L9:
        scrollTo(r15, getScrollY());
        return;
    L19:
        return;
    L13:
        r14 = 0.0f;
        goto L14
    L4:
        if (this.f2735b.isEmpty() == true) goto L10;
        if (this.f2747s.isFinished() == true) goto L8;
        this.f2747s.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        r15 = (int) ((getScrollX() / (((r10 - getPaddingLeft()) - getPaddingRight()) + r12)) * (((r8 - getPaddingLeft()) - getPaddingRight()) + r11));
        goto L9
    }

    public final boolean r() {
        this.P = -1;
        this.G = false;
        this.H = false;
        VelocityTracker r8 = this.Q;
        if (r8 == null) goto L5;
        r8.recycle();
        this.Q = null;
    L5:
        this.V.onRelease();
        this.W.onRelease();
        if (this.V.isFinished() == false) goto L8;
    L9:
        return true;
    L8:
        if (this.W.isFinished() == true) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r8) {
        if (this.C == false) goto L5;
        removeViewInLayout(r8);
        return;
    L5:
        super.removeView(r8);
    }

    public final void s(int r11, int r12, boolean r13, boolean r14) {
        e r8 = i(r11);
        if (r8 == null) goto L5;
        int r10 = (int) (Math.max(this.f2754z, Math.min(r8.f2762e, this.A)) * getClientWidth());
    L6:
        if (r13 == true) goto L8;
        if (r14 == false) goto L40;
        h r15 = this.f2734a0;
        if (r15 == null) goto L40;
        r15.c(r11);
    L40:
        d(false);
        scrollTo(r10, 0);
        m(r10);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r14 == false) goto L42;
        h r16 = this.f2734a0;
        if (r16 == null) goto L43;
        r16.c(r11);
        return;
    L43:
        return;
    L42:
        return;
    L10:
        Scroller r17 = this.f2747s;
        if (r17 != null) goto L13;
    L15:
        boolean r18 = false;
    L16:
        if (r18 == true) goto L18;
        int r19 = getScrollX();
    L23:
        int r20 = r19;
        int r21 = getScrollY();
        int r22 = r10 - r20;
        int r23 = 0 - r21;
        if (r22 != 0) goto L27;
        if (r23 != 0) goto L27;
        d(false);
        o();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r110 = getClientWidth();
        int r24 = r110 / 2;
        float r111 = r110;
        float r25 = r24;
        float r26 = (((float) Math.sin((Math.min(1.0f, (Math.abs(r22) * 1.0f) / r111) - 0.5f) * 0.47123894f)) * r25) + r25;
        int r112 = Math.abs(r12);
        if (r112 <= 0) goto L30;
        int r113 = Math.round(Math.abs(r26 / r112) * 1000.0f) * 4;
    L31:
        int r27 = Math.min(r113, 600);
        this.f2748t = false;
        this.f2747s.startScroll(r20, r21, r22, r23, r27);
        WeakHashMap<View, h0> r114 = w.f8437a;
        w.d.k(this);
        goto L32
    L30:
        this.f2743o.getClass();
        r113 = (int) (((Math.abs(r22) / ((r111 * 1.0f) + this.f2750v)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f2748t == false) goto L20;
        r19 = this.f2747s.getCurrX();
    L21:
        this.f2747s.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r19 = this.f2747s.getStartX();
        goto L21
    L13:
        if (r17.isFinished() == true) goto L15;
        r18 = true;
        goto L16
    L5:
        r10 = 0;
        goto L6
    }

    public void setAdapter(i1.a r8) {
        i1.a r10 = this.f2743o;
        if (r10 == null) goto L22;
        monitor-enter(r10);
        r10.f8085b = null;     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        this.f2743o.getClass();
        int r11 = 0;
    L8:
        ArrayList<e> r12 = this.f2735b;
        if (r11 >= r12.size()) goto L11;
        e r13 = r12.get(r11);
        i1.a r14 = this.f2743o;
        int r15 = r13.f2759b;
        xb.e r16 = r13.f2758a;
        ((xb.d) r14).f13776c.remove(r16);
        removeView(r16);
        r11 = r11 + 1;
        goto L8
    L11:
        this.f2743o.getClass();
        r12.clear();
        int r17 = 0;
    L13:
        if (r17 >= getChildCount()) goto L18;
        if (((f) getChildAt(r17).getLayoutParams()).f2763a == true) goto L17;
        removeViewAt(r17);
        r17 = r17 - 1;
    L17:
        r17 = r17 + 1;
        goto L13
    L18:
        this.f2744p = 0;
        scrollTo(0, 0);
    L19:
        th = move-exception;
        throw th;
    L22:
        this.f2743o = r8;
        this.f2733a = 0;
        if (r8 != null) goto L25;
        return;
    L25:
        if (this.f2749u != null) goto L27;
        this.f2749u = new j(this);
    L27:
        i1.a r18 = this.f2743o;
        j r19 = this.f2749u;
        monitor-enter(r18);
        r18.f8085b = r19;     // Catch: Throwable -> L37
        monitor-exit(r18);     // Catch: Throwable -> L37
        this.E = false;
        boolean r20 = this.X;
        this.X = true;
        this.f2733a = this.f2743o.a();
        if (this.f2745q < 0) goto L34;
        this.f2743o.getClass();
        u(this.f2745q, 0, false, true);
        this.f2745q = -1;
        this.f2746r = null;
        return;
    L34:
        if (r20 == true) goto L36;
        o();
        return;
    L36:
        requestLayout();
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public void setCurrentItem(int r8) {
        this.E = false;
        u(r8, 0, !this.X, false);
    }

    public void setOffscreenPageLimit(int r8) {
        if (r8 >= 1) goto L6;
        Log.w("ViewPager", "Requested offscreen page limit " + r8 + " too small; defaulting to 1");
        r8 = 1;
    L6:
        if (r8 == this.F) goto L9;
        this.F = r8;
        o();
        return;
    }

    @Deprecated
    public void setOnPageChangeListener(h r8) {
        this.f2734a0 = r8;
    }

    public void setPageMargin(int r8) {
        int r10 = this.f2750v;
        this.f2750v = r8;
        int r11 = getWidth();
        q(r11, r11, r8, r10);
        requestLayout();
    }

    public void setPageMarginDrawable(int r8) {
        Context r10 = getContext();
        Object r11 = androidx.core.content.a.f1674a;
        setPageMarginDrawable(androidx.core.content.a.b.b(r10, r8));
    }

    public void setScrollState(int r8) {
        if (this.f2740g0 != r8) goto L5;
        return;
    L5:
        this.f2740g0 = r8;
        if (this.f2736b0 != null) goto L8;
    L17:
        h r10 = this.f2734a0;
        if (r10 == null) goto L24;
        r10.a();
        return;
    L24:
        return;
    L8:
        if (r8 == 0) goto L10;
        boolean r11 = true;
    L11:
        int r12 = getChildCount();
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L17;
        if (r11 == false) goto L15;
        int r14 = this.f2737c0;
    L16:
        getChildAt(r13).setLayerType(r14, null);
        r13 = r13 + 1;
        goto L12
    L15:
        r14 = 0;
        goto L16
    L10:
        r11 = false;
        goto L11
    }

    public final void t(int r8, boolean r10) {
        this.E = false;
        u(r8, 0, r10, false);
    }

    public final void u(int r8, int r10, boolean r11, boolean r12) {
        i1.a r13 = this.f2743o;
        boolean r14 = false;
        if (r13 != null) goto L5;
    L42:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r13.a() <= 0) goto L42;
        ArrayList<e> r15 = this.f2735b;
        if (r12 == true) goto L16;
        if (this.f2744p != r8) goto L16;
        if (r15.size() == 0) goto L16;
        setScrollingCacheEnabled(false);
        return;
    L16:
        if (r8 >= 0) goto L19;
        r8 = 0;
    L21:
        int r16 = this.F;
        int r17 = this.f2744p;
        if (r8 <= (r17 + r16)) goto L24;
    L25:
        int r18 = 0;
    L27:
        if (r18 >= r15.size()) goto L30;
        r15.get(r18).f2760c = true;
        r18 = r18 + 1;
    L30:
        if (this.f2744p == r8) goto L33;
        r14 = true;
    L33:
        if (this.X == false) goto L40;
        this.f2744p = r8;
        if (r14 == false) goto L39;
        h r19 = this.f2734a0;
        if (r19 == null) goto L39;
        r19.c(r8);
    L39:
        requestLayout();
        return;
    L40:
        p(r8);
        s(r8, r10, r11, r14);
        return;
    L24:
        if (r8 >= (r17 - r16)) goto L30;
    L19:
        if (r8 < this.f2743o.a()) goto L21;
        r8 = this.f2743o.a() - 1;
        goto L21
    }

    public final void v(MaterialCalendarView.c r8) {
        boolean r10 = false;
        if (this.f2736b0 == null) goto L5;
        boolean r11 = true;
    L6:
        if (true == r11) goto L8;
        r10 = true;
    L8:
        this.f2736b0 = r8;
        setChildrenDrawingOrderEnabled(true);
        this.d0 = 1;
        this.f2737c0 = 2;
        if (r10 == false) goto L12;
        o();
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        if (super.verifyDrawable(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (r8 == this.f2751w) goto L8;
        return false;
    }

    public final void w() {
        if (this.d0 == 0) goto L14;
        ArrayList<View> r8 = this.f2738e0;
        if (r8 != null) goto L7;
        this.f2738e0 = new ArrayList();
    L8:
        int r10 = getChildCount();
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L11;
        View r12 = getChildAt(r11);
        this.f2738e0.add(r12);
        r11 = r11 + 1;
        goto L9
    L11:
        Collections.sort(this.f2738e0, f2732k0);
        return;
    L7:
        r8.clear();
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new f();
    }

    public void setPageMarginDrawable(Drawable r8) {
        this.f2751w = r8;
        if (r8 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r8 != null) goto L7;
        boolean r10 = true;
    L8:
        setWillNotDraw(r10);
        invalidate();
        return;
    L7:
        r10 = false;
        goto L8
    }
}
