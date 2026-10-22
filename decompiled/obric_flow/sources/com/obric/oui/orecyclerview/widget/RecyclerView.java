package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.os.TraceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import com.obric.oui.orecyclerview.R$attr;
import com.obric.oui.orecyclerview.R$dimen;
import com.obric.oui.orecyclerview.R$styleable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static final boolean A0 = false;
    public static final boolean B0 = false;
    public static final boolean C0 = false;
    public static final Class[] D0 = null;
    public static final x E0 = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static boolean f13723x0 = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static boolean f13724y0 = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int[] f13725z0 = null;
    public final AccessibilityManager A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public com.obric.oui.orecyclerview.base.a F;
    public com.obric.oui.orecyclerview.base.a G;
    public g0 H;
    public int I;
    public int J;
    public ug.e K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public final int R;
    public final float S;
    public final float T;
    public boolean U;
    public final w0 V;
    public o W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f13726a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final com.airbnb.lottie.parser.moshi.c f13727a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f13728b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final u0 f13729b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SavedState f13730c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public n0 f13731c0;
    public final b d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ArrayList f13732d0;
    public final com.google.common.reflect.w e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f13733e0;
    public final ko.r f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f13734f0;
    public boolean g;
    public final y g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f13735h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f13736h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f13737i;
    public RecyclerViewAccessibilityDelegate i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f13738j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final int[] f13739j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f13740k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public NestedScrollingChildHelper f13741k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a0 f13742l;
    public final int[] l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k0 f13743m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final int[] f13744m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f13745n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int[] f13746n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f13747o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final ArrayList f13748o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f13749p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f13750p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l f13751q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final boolean f13752q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13753r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final w f13754r0;
    public boolean s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f13755s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13756t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f13757t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13758u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f13759u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13760v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final y0 f13761v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13762w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final y f13763w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13766z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x0 f13768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f13769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13770c;
        public boolean d;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.f13769b = new Rect();
            this.f13770c = true;
            this.d = false;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.f13769b = new Rect();
            this.f13770c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.f13769b = new Rect();
            this.f13770c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.f13769b = new Rect();
            this.f13770c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams r5) {
            super(r5);
            this.f13769b = new Rect();
            this.f13770c = true;
            this.d = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Parcelable f13771a;

        static {
            CREATOR = new t0();
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r10 != null) goto L6;
            r10 = k0.class.getClassLoader();
        L6:
            this.f13771a = r5.readParcelable(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeParcelable(this.f13771a, 0);
        }
    }

    static {
        f13725z0 = new int[]{R.attr.nestedScrollingEnabled};
        Math.log(0.78d);
        Math.log(0.9d);
        A0 = true;
        B0 = true;
        C0 = true;
        Class r5 = Integer.TYPE;
        D0 = new Class[]{Context.class, AttributeSet.class, r5, r5};
        E0 = new x();
    }

    public RecyclerView(@NonNull Context r5) {
        this(r5, null);
    }

    public static x0 F(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r5.getLayoutParams()).f13768a;
    }

    public static /* synthetic */ void a(RecyclerView r5, View r10, int r11, ViewGroup.LayoutParams r12) {
        r5.attachViewToParent(r10, r11, r12);
    }

    public static /* synthetic */ void b(RecyclerView r5, int r10) {
        r5.detachViewFromParent(r10);
    }

    public static /* synthetic */ boolean c(RecyclerView r5) {
        return r5.awakenScrollBars();
    }

    public static /* synthetic */ void d(RecyclerView r5, View r10, int r11, ViewGroup.LayoutParams r12) {
        r5.attachViewToParent(r10, r11, r12);
    }

    public static /* synthetic */ void e(RecyclerView r5, View r10) {
        r5.detachViewFromParent(r10);
    }

    public static /* synthetic */ void f(RecyclerView r5, int r10, int r11) {
        r5.setMeasuredDimension(r10, r11);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f13741k0 != null) goto L6;
        this.f13741k0 = new NestedScrollingChildHelper(this);
    L6:
        return this.f13741k0;
    }

    public static void k(x0 r5) {
        WeakReference<RecyclerView> r10 = r5.mNestedRecyclerView;
        if (r10 == null) goto L23;
        RecyclerView r11 = r10.get();
    L6:
        if (r11 == null) goto L14;
        if (r11 == r5.itemView) goto L9;
        Object r12 = r11.getParent();
        if ((r12 instanceof View) == true) goto L12;
        r11 = null;
        goto L6
    L12:
        r11 = (View) r12;
        goto L6
    L9:
        return;
    L14:
        r5.mNestedRecyclerView = null;
        return;
    }

    public static void setDebugAssertionsEnabled(boolean r5) {
        f13723x0 = r5;
    }

    public static void setVerboseLoggingEnabled(boolean r5) {
        f13724y0 = r5;
    }

    public static RecyclerView y(View r5) {
        if ((r5 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r5 instanceof RecyclerView) == true) goto L8;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        RecyclerView r13 = y(r10.getChildAt(r12));
        if (r13 != null) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        return r13;
    L15:
        return null;
    L8:
        return (RecyclerView) r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean A(int r19, int r20) {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L7;
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.f13762w == false) goto L9;
        return false;
    L9:
        boolean r10 = r5.c();
        boolean r11 = this.f13743m.d();
        if (r10 == true) goto L12;
    L15:
        int r12 = 0;
    L16:
        if (r11 == true) goto L18;
    L21:
        int r13 = 0;
    L22:
        if (r12 != 0) goto L26;
        if (r13 != 0) goto L26;
        return false;
    L26:
        if (r12 == 0) goto L38;
        com.obric.oui.orecyclerview.base.a r14 = this.F;
        if (r14 == null) goto L38;
        if (r14.d == 0.0f) goto L38;
        r14.b(r12);
        if (this.f13750p0 == false) goto L37;
        com.obric.oui.orecyclerview.base.a r15 = this.F;
        if (r15 == null) goto L38;
        if ((r15.d * r12) >= 0.0f) goto L38;
    L37:
        r12 = 0;
    L38:
        if (r13 == 0) goto L50;
        com.obric.oui.orecyclerview.base.a r16 = this.G;
        if (r16 == null) goto L50;
        if (r16.d == 0.0f) goto L50;
        r16.b(-r13);
        if (this.f13750p0 == false) goto L49;
        com.obric.oui.orecyclerview.base.a r17 = this.G;
        if (r17 == null) goto L50;
        if ((r17.d * r13) >= 0.0f) goto L50;
    L49:
        r13 = 0;
    L50:
        if (r12 != 0) goto L53;
        if (r13 != 0) goto L53;
        return false;
    L53:
        float r18 = r12;
        float r21 = r13;
        if (dispatchNestedPreFling(r18, r21) == false) goto L56;
    L73:
        return false;
    L56:
        if (r10 == true) goto L60;
        if (r11 == true) goto L60;
        boolean r22 = false;
    L61:
        dispatchNestedFling(r18, r21, r22);
        int r23 = r10;
        if (r22 == false) goto L73;
        if (r11 == false) goto L65;
        r23 = (r10 ? 1 : 0) | 2;
    L65:
        startNestedScroll(r23, 1);
        int r24 = this.R;
        int r25 = -r24;
        int r110 = Math.max(r25, Math.min(r12, r24));
        int r111 = Math.max(r25, Math.min(r13, r24));
        w0 r26 = this.V;
        RecyclerView r27 = (RecyclerView) r26.f13928h;
        r27.setScrollState(2);
        r26.f13927c = 0;
        r26.f13926b = 0;
        Interpolator r28 = (Interpolator) r26.g;
        x r29 = E0;
        if (r28 == r29) goto L68;
        r26.g = r29;
        r26.f = new com.obric.oui.orecyclerview.base.f(r27.getContext(), r29);
    L68:
        ((com.obric.oui.orecyclerview.base.f) r26.f).c().fling(0, 0, r110, r111, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (r26.d == false) goto L71;
        r26.e = true;
    L72:
        return true;
    L71:
        r27.removeCallbacks(r26);
        ViewCompat.postOnAnimation(r27, r26);
    L60:
        r22 = true;
        goto L61
    L18:
        if (Math.abs(r20) < this.Q) goto L21;
        r13 = r20;
        goto L22
    L12:
        if (Math.abs(r19) < this.Q) goto L15;
        r12 = r19;
        goto L16
    }

    public final int B(x0 r10) {
        if (r10.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r10.isBound() == false) goto L47;
        b r11 = this.d;
        int r12 = r10.mPosition;
        ArrayList r13 = r11.f13792b;
        int r5 = r13.size();
        int r14 = 0;
    L8:
        if (r14 >= r5) goto L35;
        a r15 = (a) r13.get(r14);
        int r16 = r15.f13785a;
        if (r16 == 1) goto L31;
        if (r16 != 2) goto L14;
        int r17 = r15.f13786b;
        if (r17 > r12) goto L33;
        int r18 = r15.d;
        if ((r17 + r18) > r12) goto L48;
        r12 = r12 - r18;
        goto L33
    L48:
        return -1;
    L33:
        r14 = r14 + 1;
        goto L8
    L14:
        if (r16 != 8) goto L33;
        int r19 = r15.f13786b;
        if (r19 != r12) goto L19;
        r12 = r15.d;
        goto L33
    L19:
        if (r19 >= r12) goto L22;
        r12 = r12 - 1;
    L22:
        if (r15.d > r12) goto L33;
        r12 = r12 + 1;
        goto L33
    L31:
        if (r15.f13786b > r12) goto L33;
        r12 = r12 + r15.d;
        goto L33
    L35:
        return r12;
    L47:
        return -1;
    }

    public final long C(x0 r5) {
        if (this.f13742l.hasStableIds() == false) goto L6;
        return r5.getItemId();
    L6:
        return r5.mPosition;
    }

    public final int D(View r5) {
        x0 r10 = F(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getAbsoluteAdapterPosition();
    }

    public final x0 E(View r5) {
        ViewParent r10 = r5.getParent();
        if (r10 == null) goto L9;
        if (r10 == this) goto L9;
        throw new IllegalArgumentException("View " + r5 + " is not a direct child of " + this);
    L9:
        return F(r5);
    }

    public final boolean G() {
        if (this.f13756t == true) goto L5;
    L10:
        return true;
    L5:
        if (this.B == true) goto L10;
        if (this.d.g() == true) goto L10;
        return false;
    }

    public final boolean H() {
        if (this.D <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void I() {
        int r5 = this.e.s();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5) goto L6;
        ((LayoutParams) this.e.r(r11).getLayoutParams()).f13770c = true;
        r11 = r11 + 1;
        goto L4
    L6:
        ArrayList r12 = this.f13728b.f13887c;
        int r13 = r12.size();
    L7:
        if (r10 >= r13) goto L12;
        LayoutParams r14 = (LayoutParams) ((x0) r12.get(r10)).itemView.getLayoutParams();
        if (r14 == null) goto L11;
        r14.f13770c = true;
    L11:
        r10 = r10 + 1;
        goto L7
    }

    public final void J(int r12, int r13, boolean r14) {
        int r5 = r12 + r13;
        int r10 = this.e.s();
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L21;
        x0 r15 = F(this.e.r(r11));
        if (r15 == null) goto L20;
        if (r15.shouldIgnore() == true) goto L20;
        int r16 = r15.mPosition;
        u0 r17 = this.f13729b0;
        if (r16 >= r5) goto L12;
        if (r16 < r12) goto L20;
        if (f13724y0 == false) goto L19;
        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + r11 + " holder " + r15 + " now REMOVED");
    L19:
        r15.flagRemovedAndOffsetPosition(r12 - 1, -r13, r14);
        r17.e = true;
        goto L20
    L12:
        if (f13724y0 == false) goto L14;
        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + r11 + " holder " + r15 + " now at position " + (r15.mPosition - r13));
    L14:
        r15.offsetPosition(-r13, r14);
        r17.e = true;
    L20:
        r11 = r11 + 1;
        goto L4
    L21:
        q0 r18 = this.f13728b;
        ArrayList r19 = r18.f13887c;
        int r20 = r19.size() - 1;
    L22:
        if (r20 < 0) goto L34;
        x0 r21 = (x0) r19.get(r20);
        if (r21 == null) goto L33;
        int r22 = r21.mPosition;
        if (r22 >= r5) goto L28;
        if (r22 < r12) goto L33;
        r21.addFlags(8);
        r18.f(r20);
        goto L33
    L28:
        if (f13724y0 == false) goto L30;
        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + r20 + " holder " + r21 + " now at position " + (r21.mPosition - r13));
    L30:
        r21.offsetPosition(-r13, r14);
    L33:
        r20 = r20 - 1;
        goto L22
    L34:
        requestLayout();
    }

    public final void K() {
        this.D++;
    }

    public final void L(boolean r10) {
        int r5 = this.D - 1;
        this.D = r5;
        if (r5 < 1) goto L5;
        return;
    L5:
        if (f13723x0 == false) goto L10;
        if (r5 >= 0) goto L10;
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
    L10:
        this.D = 0;
        if (r10 == false) goto L38;
        int r11 = this.f13765y;
        this.f13765y = 0;
        if (r11 == 0) goto L19;
        AccessibilityManager r12 = this.A;
        if (r12 == null) goto L19;
        if (r12.isEnabled() == false) goto L19;
        AccessibilityEvent r13 = AccessibilityEvent.obtain();
        r13.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r13, r11);
        sendAccessibilityEventUnchecked(r13);
    L19:
        ArrayList r14 = this.f13748o0;
        int r15 = r14.size() - 1;
    L20:
        if (r15 < 0) goto L30;
        x0 r16 = (x0) r14.get(r15);
        if (r16.itemView.getParent() != this) goto L29;
        if (r16.shouldIgnore() == true) goto L29;
        int r17 = r16.mPendingAccessibilityState;
        if (r17 == (-1)) goto L29;
        ViewCompat.setImportantForAccessibility(r16.itemView, r17);
        r16.mPendingAccessibilityState = -1;
    L29:
        r15 = r15 - 1;
        goto L20
    L30:
        r14.clear();
        return;
    }

    public final void M(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r5.getPointerId(r10) != this.J) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.J = r5.getPointerId(r11);
        int r12 = (int) (r5.getX(r11) + 0.5f);
        this.N = r12;
        this.L = r12;
        int r13 = (int) (r5.getY(r11) + 0.5f);
        this.O = r13;
        this.M = r13;
        return;
    L6:
        r11 = 0;
        goto L7
    }

    public final void N() {
        if (this.f13736h0 == false) goto L5;
        return;
    L5:
        if (this.f13753r == false) goto L9;
        ViewCompat.postOnAnimation(this, this.f13754r0);
        this.f13736h0 = true;
        return;
    }

    public final void O() {
        boolean r5 = false;
        if (this.B == false) goto L8;
        b r10 = this.d;
        r10.k(r10.f13792b);
        r10.k(r10.f13793c);
        r10.f = 0;
        if (this.C == false) goto L8;
        this.f13743m.getClass();
    L8:
        if (this.H != null) goto L10;
    L12:
        this.d.c();
    L14:
        if (this.f13733e0 == false) goto L16;
    L19:
        boolean r11 = true;
    L21:
        if (this.f13756t == true) goto L23;
    L32:
        boolean r12 = false;
    L33:
        u0 r13 = this.f13729b0;
        r13.f13915i = r12;
        if (r12 == false) goto L43;
        if (r11 == false) goto L43;
        if (this.B == true) goto L43;
        if (this.H == null) goto L43;
        if (this.f13743m.a0() == false) goto L43;
        r5 = true;
    L43:
        r13.f13916j = r5;
        return;
    L23:
        if (this.H == null) goto L32;
        boolean r14 = this.B;
        if (r14 == true) goto L28;
        if (r11 == true) goto L28;
        this.f13743m.getClass();
    L28:
        if (r14 == true) goto L30;
    L31:
        r12 = true;
        goto L33
    L30:
        if (this.f13742l.hasStableIds() == false) goto L32;
    L16:
        if (this.f13734f0 == true) goto L19;
        r11 = false;
        goto L21
    L10:
        if (this.f13743m.a0() == false) goto L12;
        this.d.j();
        goto L14
    }

    public final void P(boolean r10) {
        this.C = r10 | this.C;
        this.B = true;
        int r11 = this.e.s();
        int r5 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L11;
        x0 r13 = F(this.e.r(r12));
        if (r13 == null) goto L10;
        if (r13.shouldIgnore() == true) goto L10;
        r13.addFlags(6);
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        I();
        q0 r14 = this.f13728b;
        ArrayList r15 = r14.f13887c;
        int r16 = r15.size();
    L12:
        if (r5 >= r16) goto L17;
        x0 r17 = (x0) r15.get(r5);
        if (r17 == null) goto L16;
        r17.addFlags(6);
        r17.addChangePayload(null);
    L16:
        r5 = r5 + 1;
        goto L12
    L17:
        a0 r18 = r14.f13888h.f13742l;
        if (r18 != null) goto L20;
    L21:
        r14.e();
        return;
    L20:
        if (r18.hasStableIds() == false) goto L21;
    }

    public final void Q(x0 r5, f0 r10) {
        r5.setFlags(0, 8192);
        boolean r11 = this.f13729b0.g;
        ko.r r12 = this.f;
        if (r11 == true) goto L5;
    L11:
        SimpleArrayMap r13 = (SimpleArrayMap) r12.f18728b;
        c1 r14 = (c1) r13.get(r5);
        if (r14 != null) goto L14;
        r14 = c1.a();
        r13.put(r5, r14);
    L14:
        r14.f13798b = r10;
        r14.f13797a |= 4;
        return;
    L5:
        if (r5.isUpdated() == false) goto L11;
        if (r5.isRemoved() == true) goto L11;
        if (r5.shouldIgnore() == true) goto L11;
        ((LongSparseArray) r12.f18729c).put(C(r5), r5);
        goto L11
    }

    public final void R(View r12, View r13) {
        if (r13 == null) goto L4;
        View r5 = r13;
    L5:
        int r10 = r5.getWidth();
        int r11 = r5.getHeight();
        Rect r14 = this.f13737i;
        r14.set(0, 0, r10, r11);
        ViewGroup.LayoutParams r15 = r5.getLayoutParams();
        if ((r15 instanceof LayoutParams) == false) goto L10;
        LayoutParams r16 = (LayoutParams) r15;
        if (r16.f13770c == true) goto L10;
        int r17 = r14.left;
        Rect r18 = r16.f13769b;
        r14.left = r17 - r18.left;
        r14.right += r18.right;
        r14.top -= r18.top;
        r14.bottom += r18.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, r14);
        offsetRectIntoDescendantCoords(r12, r14);
    L12:
        k0 r19 = this.f13743m;
        boolean r20 = !this.f13756t;
        if (r13 != null) goto L15;
        boolean r110 = true;
    L16:
        r19.P(this, r12, this.f13737i, r20, r110);
        return;
    L15:
        r110 = false;
        goto L16
    L4:
        r5 = r12;
        goto L5
    }

    public final void S() {
        ug.e r5 = this.K;
        if (r5 == null) goto L5;
        r5.g();
    L5:
        stopNestedScroll(0);
        com.obric.oui.orecyclerview.base.a r10 = this.F;
        if (r10 == null) goto L8;
        float r11 = r10.d / r10.f13705i.density;
        r10.f13702b = AnimationUtils.currentAnimationTimeMillis();
        r10.f13703c.a((-r11) / 100.0f, r11);
        r10.g = 2;
        r10.f13704h = false;
        boolean r12 = this.F.f13704h;
    L9:
        com.obric.oui.orecyclerview.base.a r13 = this.G;
        if (r13 == null) goto L12;
        float r14 = r13.d / r13.f13705i.density;
        r13.f13702b = AnimationUtils.currentAnimationTimeMillis();
        r13.f13703c.a((-r14) / 100.0f, r14);
        r13.g = 2;
        r13.f13704h = false;
        r12 = r12 | this.G.f13704h;
    L12:
        if (r12 == false) goto L15;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L15:
        return;
    L8:
        r12 = false;
        goto L9
    }

    public final boolean T(int r18, int r19, MotionEvent r20, int r21) {
        n();
        a0 r5 = this.f13742l;
        int[] r10 = this.f13746n0;
        if (r5 == null) goto L5;
        r10[0] = 0;
        r10[1] = 0;
        U(r18, r19, r10);
        int r11 = r10[0];
        int r12 = r10[1];
        int r13 = r18 - r11;
        int r14 = r19 - r12;
        int r15 = r11;
        int r16 = r12;
    L7:
        if (this.f13747o.isEmpty() == true) goto L9;
        invalidate();
    L9:
        r10[0] = 0;
        r10[1] = 0;
        int r17 = r16;
        dispatchNestedScroll(r15, r16, r13, r14, this.l0, r21, r10);
        int r22 = r10[0];
        int r110 = r13 - r22;
        int r23 = r10[1];
        int r111 = r14 - r23;
        if (r22 != 0) goto L14;
        if (r23 != 0) goto L14;
        boolean r24 = false;
    L15:
        int r25 = this.N;
        int[] r26 = this.l0;
        int r27 = r26[0];
        this.N = r25 - r27;
        int r28 = this.O;
        int r29 = r26[1];
        this.O = r28 - r29;
        int[] r30 = this.f13744m0;
        r30[0] = r30[0] + r27;
        r30[1] = r30[1] + r29;
        if (getOverScrollMode() == 2) goto L40;
        if (r20 == null) goto L40;
        if (MotionEventCompat.isFromSource(r20, 8194) == true) goto L40;
        r20.getX();
        float r31 = r110;
        r20.getY();
        float r32 = r111;
        if (r31 != 0.0f) goto L23;
        boolean r33 = false;
    L29:
        if (r32 != 0.0f) goto L31;
    L35:
        if (r33 == true) goto L38;
        if (r31 != 0.0f) goto L38;
        if (r32 == 0.0f) goto L40;
    L38:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L40
    L31:
        if (this.G != null) goto L34;
        com.obric.oui.orecyclerview.base.a r34 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.G = r34;
        r34.f13701a = getHeight() / r34.f13705i.density;
    L34:
        this.G.c(r32, false, false);
        r33 = true;
        goto L35
    L23:
        if (this.F != null) goto L26;
        com.obric.oui.orecyclerview.base.a r35 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.F = r35;
        r35.f13701a = getWidth() / r35.f13705i.density;
    L26:
        this.F.c(r31, false, false);
        r33 = true;
    L40:
        if (r15 != 0) goto L42;
        if (r17 != 0) goto L42;
    L44:
        if (awakenScrollBars() == true) goto L46;
        invalidate();
    L46:
        if (r24 == true) goto L52;
        if (r15 != 0) goto L53;
        if (r17 == 0) goto L51;
        return true;
    L51:
        return false;
    L53:
        return true;
    L52:
        return true;
    L42:
        s(r15, r17);
    L14:
        r24 = true;
        goto L15
    L5:
        r16 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        goto L7
    }

    public final void U(int r10, int r11, int[] r12) {
        X();
        K();
        TraceCompat.beginSection("RV Scroll");
        u0 r5 = this.f13729b0;
        u(r5);
        q0 r13 = this.f13728b;
        if (r10 == 0) goto L5;
        int r14 = this.f13743m.S(r10, r13, r5);
    L6:
        if (r11 == 0) goto L8;
        int r15 = this.f13743m.U(r11, r13, r5);
    L9:
        TraceCompat.endSection();
        int r16 = this.e.o();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L21;
        View r18 = this.e.n(r17);
        x0 r19 = E(r18);
        if (r19 == null) goto L20;
        x0 r20 = r19.mShadowingHolder;
        if (r20 == null) goto L20;
        View r21 = r20.itemView;
        int r22 = r18.getLeft();
        int r23 = r18.getTop();
        if (r22 == r21.getLeft()) goto L18;
    L19:
        r21.layout(r22, r23, r21.getWidth() + r22, r21.getHeight() + r23);
        goto L20
    L18:
        if (r23 != r21.getTop()) goto L19;
    L20:
        r17 = r17 + 1;
        goto L10
    L21:
        L(true);
        Y(false);
        if (r12 == null) goto L30;
        r12[0] = r14;
        r12[1] = r15;
        return;
    L30:
        return;
    L8:
        r15 = 0;
        goto L9
    L5:
        r14 = 0;
        goto L6
    }

    public final void V(int r5) {
        if (this.f13762w == false) goto L5;
        return;
    L5:
        Z();
        k0 r10 = this.f13743m;
        if (r10 != null) goto L9;
        Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r10.T(r5);
        awakenScrollBars();
    }

    public final void W(int r10, int r11, Interpolator r12, int r13, boolean r14) {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L7;
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.f13762w == false) goto L10;
        return;
    L10:
        if (r5.c() == true) goto L12;
        int r15 = 0;
    L14:
        if (this.f13743m.d() == true) goto L16;
        int r16 = 0;
    L17:
        if (r15 != 0) goto L20;
        if (r16 != 0) goto L20;
        return;
    L20:
        if (r13 == Integer.MIN_VALUE) goto L25;
        if (r13 > 0) goto L25;
        scrollBy(r15, r16);
        return;
    L25:
        if (r14 == false) goto L32;
        if (r15 == 0) goto L28;
        int r17 = 1;
    L29:
        if (r16 == 0) goto L31;
        r17 = r17 | 2;
    L31:
        startNestedScroll(r17, 1);
        goto L32
    L28:
        r17 = 0;
    L32:
        w0 r18 = this.V;
        RecyclerView r19 = (RecyclerView) r18.f13928h;
        if (r13 != Integer.MIN_VALUE) goto L45;
        int r20 = Math.abs(r15);
        int r21 = Math.abs(r16);
        if (r20 <= r21) goto L37;
        boolean r22 = true;
    L38:
        if (r22 == false) goto L40;
        int r110 = r19.getWidth();
    L41:
        if (r22 == true) goto L44;
        r20 = r21;
    L44:
        r13 = Math.min((int) (((r20 / r110) + 1.0f) * 300.0f), 2000);
        goto L45
    L40:
        r110 = r19.getHeight();
        goto L41
    L37:
        r22 = false;
    L45:
        int r111 = r13;
        if (r12 != null) goto L49;
        r12 = E0;
    L49:
        if (((Interpolator) r18.g) == r12) goto L51;
        r18.g = r12;
        r18.f = new com.obric.oui.orecyclerview.base.f(r19.getContext(), r12);
    L51:
        r18.f13927c = 0;
        r18.f13926b = 0;
        r19.setScrollState(2);
        com.obric.oui.orecyclerview.base.f r23 = (com.obric.oui.orecyclerview.base.f) r18.f;
        r23.f = true;
        r23.c().startScroll(0, 0, r15, r16, r111);
        if (r18.d == false) goto L54;
        r18.e = true;
        return;
    L54:
        RecyclerView r24 = (RecyclerView) r18.f13928h;
        r24.removeCallbacks(r18);
        ViewCompat.postOnAnimation(r24, r18);
        return;
    L16:
        r16 = r11;
        goto L17
    L12:
        r15 = r10;
        goto L14
    }

    public final void X() {
        int r5 = this.f13758u + 1;
        this.f13758u = r5;
        if (r5 == 1) goto L5;
        return;
    L5:
        if (this.f13762w == true) goto L9;
        this.f13760v = false;
        return;
    }

    public final void Y(boolean r5) {
        if (this.f13758u >= 1) goto L10;
        if (f13723x0 == true) goto L8;
        this.f13758u = 1;
        goto L10
    L8:
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
    L10:
        if (r5 == true) goto L15;
        if (this.f13762w == true) goto L15;
        this.f13760v = false;
    L15:
        if (this.f13758u != 1) goto L29;
        if (r5 == false) goto L27;
        if (this.f13760v == false) goto L27;
        if (this.f13762w == true) goto L27;
        if (this.f13743m == null) goto L27;
        if (this.f13742l == null) goto L27;
        p();
    L27:
        if (this.f13762w == true) goto L29;
        this.f13760v = false;
    L29:
        this.f13758u--;
    }

    public final void Z() {
        setScrollState(0);
        w0 r5 = this.V;
        ((RecyclerView) r5.f13928h).removeCallbacks(r5);
        com.obric.oui.orecyclerview.base.f r10 = (com.obric.oui.orecyclerview.base.f) r5.f;
        if (r10.f == false) goto L5;
        r10.c().abortAnimation();
        return;
    L5:
        r10.g = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList r5, int r10, int r11) {
        k0 r12 = this.f13743m;
        if (r12 == null) goto L5;
        r12.getClass();
    L5:
        super.addFocusables(r5, r10, r11);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == false) goto L7;
        LayoutParams r10 = (LayoutParams) r5;
        this.f13743m.getClass();
        if (r10 == null) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.c() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.h(this.f13729b0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.c() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.i(this.f13729b0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.c() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.j(this.f13729b0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.d() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.k(this.f13729b0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.d() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.l(this.f13729b0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.d() == true) goto L8;
        return 0;
    L8:
        return this.f13743m.m(this.f13729b0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        r10.save();
        com.obric.oui.orecyclerview.base.a r5 = this.F;
        boolean r11 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r13 = this.G;
        if (r13 != null) goto L11;
    L13:
        r11 = r12;
    L14:
        getBounceTranslation();
        super.dispatchDraw(r10);
        r10.restore();
        if (r11 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L11:
        if (r13.f13704h == true) goto L13;
        r13.a();
        r10.translate(0.0f, this.G.d);
        goto L14
    L5:
        if (r5.f13704h == true) goto L7;
        r5.a();
        r10.translate(this.F.d, 0.0f);
        r12 = true;
        goto L8
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        return getScrollingChildHelper().dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r5, float r10) {
        return getScrollingChildHelper().dispatchNestedPreFling(r5, r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r5, int r10, int[] r11, int[] r12) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r5, r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        onPopulateAccessibilityEvent(r5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray r5) {
        dispatchThawSelfOnly(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray r5) {
        dispatchFreezeSelfOnly(r5);
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        super.draw(r5);
        ArrayList r10 = this.f13747o;
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        ((h0) r10.get(r12)).b(r5);
        r12 = r12 + 1;
        goto L3
    L6:
        if (this.H != null) goto L8;
        return;
    L8:
        if (r10.size() > 0) goto L10;
        return;
    L10:
        if (this.H.f() == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r5, View r10, long r11) {
        return super.drawChild(r5, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View r17, int r18) {
        this.f13743m.getClass();
        boolean r5 = true;
        if (this.f13742l != null) goto L5;
    L11:
        boolean r10 = false;
    L12:
        FocusFinder r11 = FocusFinder.getInstance();
        u0 r12 = this.f13729b0;
        q0 r13 = this.f13728b;
        if (r10 == false) goto L49;
        if (r18 == 2) goto L17;
        if (r18 != 1) goto L49;
    L17:
        if (this.f13743m.d() == false) goto L24;
        if (r18 != 2) goto L20;
        int r14 = 130;
    L22:
        if (r11.findNextFocus(this, r17, r14) != null) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L27;
    L43:
        if (r15 == false) goto L48;
        n();
        if (v(r17) != null) goto L47;
        return null;
    L47:
        X();
        this.f13743m.G(r18, r13, r12);
        Y(false);
    L48:
        View r16 = r11.findNextFocus(this, r17, r18);
    L57:
        if (r16 != null) goto L59;
    L66:
        if (r16 == null) goto L136;
        if (r16 == this) goto L136;
        if (r16 == r17) goto L136;
        if (v(r16) != null) goto L73;
        r5 = false;
    L137:
        if (r5 == false) goto L140;
        return r16;
    L140:
        return super.focusSearch(r17, r18);
    L73:
        if (r17 == null) goto L137;
        if (v(r17) == null) goto L137;
        int r19 = r17.getWidth();
        int r20 = r17.getHeight();
        Rect r21 = this.f13737i;
        r21.set(0, 0, r19, r20);
        int r22 = r16.getWidth();
        int r23 = r16.getHeight();
        Rect r110 = this.f13738j;
        r110.set(0, 0, r22, r23);
        offsetDescendantRectToMyCoords(r17, r21);
        offsetDescendantRectToMyCoords(r16, r110);
        if (ViewCompat.getLayoutDirection(this.f13743m.f13839b) != 1) goto L81;
        int r24 = -1;
    L82:
        int r111 = r21.left;
        int r25 = r110.left;
        if (r111 < r25) goto L87;
        if (r21.right <= r25) goto L87;
    L89:
        int r26 = r21.right;
        int r112 = r110.right;
        if (r26 > r112) goto L92;
        if (r111 >= r112) goto L92;
    L94:
        int r27 = 0;
    L95:
        int r28 = r21.top;
        int r113 = r110.top;
        if (r28 < r113) goto L100;
        if (r21.bottom <= r113) goto L100;
    L102:
        int r29 = r21.bottom;
        int r114 = r110.bottom;
        if (r29 > r114) goto L105;
        if (r28 >= r114) goto L105;
    L107:
        byte r30 = 0;
    L108:
        if (r18 == 1) goto L131;
        if (r18 == 2) goto L126;
        if (r18 == 17) goto L124;
        if (r18 != 33) goto L113;
        if (r30 >= 0) goto L136;
    L113:
        if (r18 != 66) goto L115;
        if (r27 <= 0) goto L136;
    L115:
        if (r18 != 130) goto L118;
        if (r30 <= 0) goto L136;
    L118:
        StringBuilder r31 = new StringBuilder("Invalid direction: ");
        r31.append(r18);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, r31));
    L124:
        if (r27 >= 0) goto L136;
    L126:
        if (r30 > 0) goto L137;
        if (r30 != 0) goto L136;
        if ((r27 * r24) <= 0) goto L136;
    L131:
        if (r30 < 0) goto L137;
        if (r30 != 0) goto L136;
        if ((r27 * r24) >= 0) goto L136;
    L105:
        if (r28 <= r113) goto L107;
        r30 = -1;
    L100:
        if (r21.bottom >= r110.bottom) goto L102;
        r30 = 1;
    L92:
        if (r111 <= r25) goto L94;
        r27 = -1;
    L87:
        if (r21.right >= r110.right) goto L89;
        r27 = 1;
        goto L95
    L81:
        r24 = 1;
    L136:
        r5 = false;
        goto L137
    L59:
        if (r16.hasFocusable() == true) goto L66;
        if (getFocusedChild() == null) goto L63;
        R(r16, null);
        return r17;
    L63:
        return super.focusSearch(r17, r18);
    L27:
        if (this.f13743m.c() == false) goto L43;
        if (ViewCompat.getLayoutDirection(this.f13743m.f13839b) != 1) goto L31;
        boolean r32 = true;
    L32:
        if (r18 != 2) goto L34;
        boolean r115 = true;
    L36:
        if ((r32 ^ r115) == false) goto L38;
        int r33 = 66;
    L40:
        if (r11.findNextFocus(this, r17, r33) != null) goto L42;
        r15 = true;
        goto L43
    L42:
        r15 = false;
        goto L43
    L38:
        r33 = 17;
        goto L40
    L34:
        r115 = false;
        goto L36
    L31:
        r32 = false;
        goto L32
    L20:
        r14 = 33;
    L24:
        r15 = false;
    L49:
        View r34 = r11.findNextFocus(this, r17, r18);
        if (r34 != null) goto L56;
        if (r10 == false) goto L56;
        n();
        if (v(r17) != null) goto L55;
        return null;
    L55:
        X();
        r16 = this.f13743m.G(r18, r13, r12);
        Y(false);
    L56:
        r16 = r34;
        goto L57
    L5:
        if (this.f13743m == null) goto L11;
        if (H() == true) goto L11;
        if (this.f13762w == true) goto L11;
        r10 = true;
        goto L12
    }

    public final void g(x0 r10) {
        View r5 = r10.itemView;
        if (r5.getParent() != this) goto L5;
        boolean r11 = true;
    L6:
        this.f13728b.k(E(r5));
        if (r10.isTmpDetached() == false) goto L9;
        this.e.j(r5, -1, r5.getLayoutParams(), true);
        return;
    L9:
        if (r11 == true) goto L11;
        this.e.i(r5, -1, true);
        return;
    L11:
        com.google.common.reflect.w r12 = this.e;
        int r13 = ((RecyclerView) ((y) r12.f9377c).f13929a).indexOfChild(r5);
        if (r13 < 0) goto L16;
        ((com.bytedance.crash.upload.l) r12.f9376b).i(r13);
        r12.t(r5);
        return;
    L16:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r5);
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        k0 r5 = this.f13743m;
        if (r5 == null) goto L7;
        return r5.p();
    L7:
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        k0 r10 = this.f13743m;
        if (r10 == null) goto L7;
        Context r11 = getContext();
        r10.getClass();
        return new LayoutParams(r11, r5);
    L7:
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    @Nullable
    public a0 getAdapter() {
        return this.f13742l;
    }

    @Override // android.view.View
    public int getBaseline() {
        k0 r5 = this.f13743m;
        if (r5 == null) goto L7;
        r5.getClass();
        return -1;
    L7:
        return super.getBaseline();
    }

    public float getBounceTranslation() {
        com.obric.oui.orecyclerview.base.a r5 = this.G;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        return r5.d;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r5, int r10) {
        return super.getChildDrawingOrder(r5, r10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.g;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.i0;
    }

    @NonNull
    public e0 getEdgeEffectFactory() {
        return null;
    }

    @Nullable
    public g0 getItemAnimator() {
        return this.H;
    }

    public int getItemDecorationCount() {
        return this.f13747o.size();
    }

    @Nullable
    public k0 getLayoutManager() {
        return this.f13743m;
    }

    public int getMaxFlingVelocity() {
        return this.R;
    }

    public int getMinFlingVelocity() {
        return this.Q;
    }

    public long getNanoTime() {
        if (C0 == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    @Nullable
    public m0 getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.U;
    }

    @NonNull
    public p0 getRecycledViewPool() {
        return this.f13728b.b();
    }

    public int getScrollState() {
        return this.I;
    }

    public final void h(h0 r5) {
        k0 r10 = this.f13743m;
        if (r10 == null) goto L5;
        r10.b("Cannot add item decoration during a scroll  or layout");
    L5:
        ArrayList r11 = this.f13747o;
        if (r11.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        r11.add(r5);
        I();
        requestLayout();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public final void i(n0 r5) {
        if (this.f13732d0 != null) goto L5;
        this.f13732d0 = new ArrayList();
    L5:
        this.f13732d0.add(r5);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f13753r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f13762w;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public final void j(String r5) {
        if (H() == false) goto L10;
        if (r5 != null) goto L8;
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(r5);
    L10:
        if (this.E <= 0) goto L13;
        Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder(""))));
        return;
    }

    public final void l() {
        int r5 = this.e.s();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L8;
        x0 r12 = F(this.e.r(r11));
        if (r12.shouldIgnore() == true) goto L7;
        r12.clearOldPosition();
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        q0 r13 = this.f13728b;
        ArrayList r14 = r13.f13887c;
        int r15 = r14.size();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L11;
        ((x0) r14.get(r16)).clearOldPosition();
        r16 = r16 + 1;
        goto L9
    L11:
        ArrayList r17 = r13.f13885a;
        int r18 = r17.size();
        int r19 = 0;
    L12:
        if (r19 >= r18) goto L14;
        ((x0) r17.get(r19)).clearOldPosition();
        r19 = r19 + 1;
        goto L12
    L14:
        ArrayList r20 = r13.f13886b;
        if (r20 == null) goto L19;
        int r21 = r20.size();
    L17:
        if (r10 >= r21) goto L26;
        ((x0) r13.f13886b.get(r10)).clearOldPosition();
        r10 = r10 + 1;
        goto L17
    L26:
        return;
    }

    public final int m(int r5, com.obric.oui.orecyclerview.base.a r10) {
        if (r5 == 0) goto L11;
        if (r10 != null) goto L5;
        return r5;
    L5:
        if (r10.d == 0.0f) goto L13;
        int r11 = (int) r10.c(r5, true, this.f13752q0);
        if (r5 <= 0) goto L10;
        return r5 - r11;
    L10:
        return r5 + r11;
    L13:
        return r5;
    L11:
        return r5;
    }

    public final void n() {
        if (this.f13756t == true) goto L5;
    L34:
        TraceCompat.beginSection("RV FullInvalidate");
        p();
        TraceCompat.endSection();
        return;
    L5:
        if (this.B == true) goto L34;
        if (this.d.g() == true) goto L10;
        return;
    L10:
        b r5 = this.d;
        int r10 = r5.f;
        if ((r10 & 4) == 0) goto L31;
        if ((r10 & 11) != 0) goto L31;
        TraceCompat.beginSection("RV PartialInvalidate");
        X();
        K();
        this.d.j();
        if (this.f13760v == true) goto L29;
        int r11 = this.e.o();
        int r12 = 0;
    L18:
        if (r12 >= r11) goto L28;
        x0 r13 = F(this.e.n(r12));
        if (r13 == null) goto L27;
        if (r13.shouldIgnore() == true) goto L27;
        if (r13.isUpdated() == false) goto L27;
        p();
    L27:
        r12 = r12 + 1;
        goto L18
    L28:
        this.d.b();
    L29:
        Y(true);
        L(true);
        TraceCompat.endSection();
        return;
    L31:
        if (r5.g() == false) goto L42;
        TraceCompat.beginSection("RV FullInvalidate");
        p();
        TraceCompat.endSection();
        return;
    }

    public final void o(int r5, int r10) {
        int r11 = getPaddingLeft();
        int r12 = k0.e(r5, getPaddingRight() + r11, ViewCompat.getMinimumWidth(this));
        int r13 = getPaddingTop();
        setMeasuredDimension(r12, k0.e(r10, getPaddingBottom() + r13, ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = 0;
        boolean r5 = true;
        this.f13753r = true;
        if (this.f13756t == true) goto L5;
    L7:
        r5 = false;
    L8:
        this.f13756t = r5;
        this.f13728b.c();
        k0 r10 = this.f13743m;
        if (r10 == null) goto L11;
        r10.getClass();
    L11:
        this.f13736h0 = false;
        if (C0 == false) goto L32;
        ThreadLocal r11 = o.e;
        o r12 = (o) r11.get();
        this.W = r12;
        if (r12 != null) goto L23;
        o r13 = new o();
        r13.f13870a = new ArrayList();
        r13.d = new ArrayList();
        this.W = r13;
        Display r14 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r14 == null) goto L21;
        float r15 = r14.getRefreshRate();
        if (r15 < 30.0f) goto L21;
    L22:
        o r16 = this.W;
        r16.f13872c = (long) (1.0E9f / r15);
        r11.set(r16);
    L21:
        r15 = 60.0f;
    L23:
        o r17 = this.W;
        r17.getClass();
        boolean r18 = f13723x0;
        ArrayList r19 = r17.f13870a;
        if (r18 == true) goto L26;
    L30:
        r19.add(this);
        return;
    L26:
        if (r19.contains(this) == false) goto L30;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    L32:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0 r5 = this.H;
        if (r5 == null) goto L5;
        r5.e();
    L5:
        Z();
        this.f13753r = false;
        this.f13748o0.clear();
        removeCallbacks(this.f13754r0);
        this.f.getClass();
    L7:
        if (c1.d.acquire() != 0) goto L7;
        int r10 = 0;
    L10:
        q0 r11 = this.f13728b;
        ArrayList r12 = r11.f13887c;
        if (r10 >= r12.size()) goto L13;
        PoolingContainer.callPoolingContainerOnRelease(((x0) r12.get(r10)).itemView);
        r10 = r10 + 1;
        goto L10
    L13:
        r11.d(r11.f13888h.f13742l, false);
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (C0 == false) goto L28;
        o r13 = this.W;
        if (r13 == null) goto L29;
        boolean r14 = r13.f13870a.remove(this);
        if (f13723x0 == false) goto L23;
        if (r14 == true) goto L23;
        throw new IllegalStateException("RecyclerView removal failed!");
    L23:
        this.W = null;
        return;
    L29:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        ArrayList r10 = this.f13747o;
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((h0) r10.get(r12)).getClass();
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r17) {
        if (this.f13743m != null) goto L6;
        return false;
    L6:
        if (this.f13762w == false) goto L9;
        return false;
    L9:
        if (r17.getAction() == 8) goto L11;
    L77:
        return false;
    L11:
        if ((r17.getSource() & 2) == 0) goto L21;
        if (this.f13743m.d() == false) goto L15;
        float r5 = -r17.getAxisValue(9);
    L17:
        if (this.f13743m.c() == false) goto L19;
        float r10 = r17.getAxisValue(10);
    L30:
        if (r5 == 0.0f) goto L32;
    L33:
        int r11 = (int) (r10 * this.S);
        int r12 = (int) (r5 * this.T);
        k0 r13 = this.f13743m;
        if (r13 != null) goto L37;
        Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        goto L77
    L37:
        if (this.f13762w == true) goto L77;
        int[] r14 = this.f13746n0;
        r14[0] = 0;
        r14[1] = 0;
        boolean r15 = r13.c();
        boolean r16 = this.f13743m.d();
        if (r16 == false) goto L42;
        int r18 = (r15 ? 1 : 0) | 2;
    L43:
        r17.getY();
        r17.getX();
        com.obric.oui.orecyclerview.base.a r19 = this.F;
        if (r19 != null) goto L46;
    L48:
        int r20 = 0;
    L49:
        int r110 = r11 - r20;
        com.obric.oui.orecyclerview.base.a r21 = this.G;
        if (r21 != null) goto L52;
    L54:
        int r22 = 0;
    L55:
        int r111 = r12 - r22;
        startNestedScroll(r18, 1);
        if (r15 == false) goto L58;
        int r23 = r110;
    L59:
        if (r16 == false) goto L61;
        int r24 = r111;
    L63:
        if (dispatchNestedPreScroll(r23, r24, this.f13746n0, this.l0, 1) == false) goto L65;
        r110 = r110 - r14[0];
        r111 = r111 - r14[1];
    L65:
        if (r15 == false) goto L67;
        int r25 = r110;
    L68:
        if (r16 == false) goto L70;
        int r26 = r111;
    L71:
        T(r25, r26, r17, 1);
        o r27 = this.W;
        if (r27 == null) goto L76;
        if (r110 != 0) goto L75;
        if (r111 == 0) goto L76;
    L75:
        r27.a(this, r110, r111);
    L76:
        stopNestedScroll(1);
        goto L77
    L70:
        r26 = 0;
        goto L71
    L67:
        r25 = 0;
        goto L68
    L61:
        r24 = 0;
        goto L63
    L58:
        r23 = 0;
        goto L59
    L52:
        if (r21.d == 0.0f) goto L54;
        r22 = (int) r21.c(r12, true, false);
        invalidate();
        goto L55
    L46:
        if (r19.d == 0.0f) goto L48;
        r20 = (int) r19.c(r11, true, false);
        invalidate();
        goto L49
    L42:
        r18 = r15 ? 1 : 0;
        goto L43
    L32:
        if (r10 == 0.0f) goto L77;
    L19:
        r10 = 0.0f;
        goto L30
    L15:
        r5 = 0.0f;
        goto L17
    L21:
        if ((r17.getSource() & 4194304) == 0) goto L28;
        float r28 = r17.getAxisValue(26);
        if (this.f13743m.d() == false) goto L26;
        r5 = -r28;
        goto L19
    L26:
        if (this.f13743m.c() == false) goto L28;
        r10 = r28;
        r5 = 0.0f;
    L28:
        r5 = 0.0f;
        r10 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f13762w == false) goto L5;
        return false;
    L5:
        this.f13751q = null;
        if (w(r10) == false) goto L9;
        S();
        setScrollState(0);
        return true;
    L9:
        k0 r5 = this.f13743m;
        if (r5 != null) goto L12;
        return false;
    L12:
        boolean r11 = r5.c();
        boolean r12 = this.f13743m.d();
        if (this.K != null) goto L15;
        Context r13 = getContext();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r13, "context");
        this.K = new ug.e(6);
    L15:
        this.K.e(r10);
        int r14 = r10.getActionMasked();
        int r15 = r10.getActionIndex();
        if (r14 == 0) goto L49;
        if (r14 == 1) goto L47;
        if (r14 != 2) goto L20;
        int r16 = r10.findPointerIndex(this.J);
        if (r16 >= 0) goto L33;
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.J + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r17 = (int) (r10.getX(r16) + 0.5f);
        int r18 = (int) (r10.getY(r16) + 0.5f);
        if (this.I == 1) goto L71;
        int r19 = r17 - this.L;
        int r20 = r18 - this.M;
        if (r11 == true) goto L38;
    L40:
        boolean r21 = false;
    L41:
        if (r12 == true) goto L43;
    L45:
        if (r21 == false) goto L71;
        setScrollState(1);
        goto L71
    L43:
        if (Math.abs(r20) <= this.P) goto L45;
        this.O = r18;
        r21 = true;
        goto L45
    L38:
        if (Math.abs(r19) <= this.P) goto L40;
        this.N = r17;
        r21 = true;
    L71:
        if (this.I == 1) goto L73;
        return false;
    L73:
        return true;
    L20:
        if (r14 != 3) goto L22;
        S();
        setScrollState(0);
        goto L71
    L22:
        if (r14 != 5) goto L24;
        this.J = r10.getPointerId(r15);
        int r22 = (int) (r10.getX(r15) + 0.5f);
        this.N = r22;
        this.L = r22;
        int r23 = (int) (r10.getY(r15) + 0.5f);
        this.O = r23;
        this.M = r23;
        goto L71
    L24:
        if (r14 != 6) goto L71;
        M(r10);
        goto L71
    L47:
        this.K.g();
        stopNestedScroll(0);
        goto L71
    L49:
        if (this.f13764x == false) goto L51;
        this.f13764x = false;
    L51:
        this.J = r10.getPointerId(0);
        int r24 = (int) (r10.getX() + 0.5f);
        this.N = r24;
        this.L = r24;
        int r25 = (int) (r10.getY() + 0.5f);
        this.O = r25;
        this.M = r25;
        this.f13761v0.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        com.obric.oui.orecyclerview.base.a r26 = this.F;
        if (r26 != null) goto L54;
    L56:
        boolean r27 = false;
    L57:
        com.obric.oui.orecyclerview.base.a r28 = this.G;
        boolean r29 = r27;
        if (r28 == null) goto L62;
        r29 = r27;
        if (r28.d == 0.0f) goto L62;
        r28.c(0.0f, false, false);
        r29 = true;
    L62:
        if (r29 == false) goto L64;
    L65:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L66:
        int[] r30 = this.f13744m0;
        r30[1] = 0;
        r30[0] = 0;
        int r31 = r11;
        if (r12 == false) goto L69;
        r31 = (r11 ? 1 : 0) | 2;
    L69:
        startNestedScroll(r31, 0);
        goto L71
    L64:
        if (this.I != 2) goto L66;
    L54:
        if (r26.d == 0.0f) goto L56;
        r27 = true;
        goto L57
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        TraceCompat.beginSection("RV OnLayout");
        p();
        TraceCompat.endSection();
        this.f13756t = true;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        k0 r5 = this.f13743m;
        if (r5 != null) goto L6;
        o(r10, r11);
        return;
    L6:
        boolean r12 = r5.D();
        boolean r13 = false;
        u0 r14 = this.f13729b0;
        if (r12 == false) goto L26;
        int r15 = View.MeasureSpec.getMode(r10);
        int r16 = View.MeasureSpec.getMode(r11);
        this.f13743m.f13839b.o(r10, r11);
        if (r15 != 1073741824) goto L12;
        if (r16 != 1073741824) goto L12;
        r13 = true;
    L12:
        this.f13755s0 = r13;
        if (r13 == false) goto L15;
        return;
    L15:
        if (this.f13742l != null) goto L18;
        return;
    L18:
        if (r14.f13913c != 1) goto L20;
        q();
    L20:
        this.f13743m.W(r10, r11);
        r14.f13914h = true;
        r();
        this.f13743m.X(r10, r11);
        if (this.f13743m.Z() == false) goto L23;
        this.f13743m.W(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
        r14.f13914h = true;
        r();
        this.f13743m.X(r10, r11);
    L23:
        this.f13757t0 = getMeasuredWidth();
        this.f13759u0 = getMeasuredHeight();
        return;
    L26:
        if (this.s == false) goto L30;
        this.f13743m.f13839b.o(r10, r11);
        return;
    L30:
        if (this.f13766z == false) goto L37;
        X();
        K();
        O();
        L(true);
        if (r14.f13916j == false) goto L34;
        r14.f = true;
    L35:
        this.f13766z = false;
        Y(false);
    L40:
        a0 r17 = this.f13742l;
        if (r17 == null) goto L43;
        r14.d = r17.getItemCount();
    L44:
        X();
        this.f13743m.f13839b.o(r10, r11);
        Y(false);
        r14.f = false;
        return;
    L43:
        r14.d = 0;
        goto L44
    L34:
        this.d.c();
        r14.f = false;
        goto L35
    L37:
        if (r14.f13916j == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r5, Rect r10) {
        if (H() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r5, r10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        this.f13730c = r10;
        super.onRestoreInstanceState(r10.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        SavedState r10 = this.f13730c;
        if (r10 == null) goto L5;
        r5.f13771a = r10.f13771a;
    L9:
        return r5;
    L5:
        k0 r11 = this.f13743m;
        if (r11 == null) goto L8;
        r5.f13771a = r11.L();
        goto L9
    L8:
        r5.f13771a = null;
        goto L9
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 != r11) goto L5;
        if (r10 != r12) goto L5;
        return;
    L5:
        this.G = null;
        this.F = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r21) {
        if (this.f13762w == false) goto L5;
    L166:
        return false;
    L5:
        if (this.f13764x == true) goto L166;
        l r5 = this.f13751q;
        if (r5 != null) goto L14;
        if (r21.getAction() != 0) goto L12;
        boolean r10 = false;
    L58:
        if (r10 == false) goto L61;
        S();
        setScrollState(0);
        return true;
    L61:
        k0 r11 = this.f13743m;
        if (r11 != null) goto L64;
        return false;
    L64:
        boolean r12 = r11.c();
        boolean r13 = this.f13743m.d();
        if (this.K != null) goto L67;
        Context r14 = getContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r14, "context");
        this.K = new ug.e(6);
    L67:
        int r15 = r21.getActionMasked();
        int r16 = r21.getActionIndex();
        int[] r17 = this.f13744m0;
        if (r15 != 0) goto L70;
        r17[1] = 0;
        r17[0] = 0;
    L70:
        MotionEvent r18 = MotionEvent.obtain(r21);
        r18.offsetLocation(r17[0], r17[1]);
        if (r15 != 0) goto L73;
        this.J = r21.getPointerId(0);
        int r19 = (int) (r21.getX() + 0.5f);
        this.N = r19;
        this.L = r19;
        int r20 = (int) (r21.getY() + 0.5f);
        this.O = r20;
        this.M = r20;
        int r110 = r12;
        if (r13 == false) goto L162;
        r110 = (r12 ? 1 : 0) | 2;
    L162:
        startNestedScroll(r110, 0);
    L163:
        this.K.e(r18);
    L164:
        r18.recycle();
        return true;
    L73:
        if (r15 == 1) goto L144;
        if (r15 == 2) goto L84;
        if (r15 != 3) goto L77;
        S();
        setScrollState(0);
        goto L163
    L77:
        if (r15 != 5) goto L79;
        this.J = r21.getPointerId(r16);
        int r22 = (int) (r21.getX(r16) + 0.5f);
        this.N = r22;
        this.L = r22;
        int r23 = (int) (r21.getY(r16) + 0.5f);
        this.O = r23;
        this.M = r23;
        goto L163
    L79:
        if (r15 != 6) goto L163;
        M(r21);
        goto L163
    L84:
        int r24 = r21.findPointerIndex(this.J);
        if (r24 >= 0) goto L88;
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.J + " not found. Did any MotionEvents get skipped?");
        return false;
    L88:
        int r111 = (int) (r21.getX(r24) + 0.5f);
        int r112 = (int) (r21.getY(r24) + 0.5f);
        int r25 = this.N - r111;
        int r26 = this.O - r112;
        if (this.I == 1) goto L106;
        if (r12 == false) goto L96;
        if (r25 <= 0) goto L93;
        r25 = Math.max(0, r25 - this.P);
    L94:
        if (r25 == 0) goto L96;
        boolean r27 = true;
    L97:
        if (r13 == false) goto L103;
        if (r26 <= 0) goto L100;
        r26 = Math.max(0, r26 - this.P);
    L101:
        if (r26 == 0) goto L103;
        r27 = true;
        goto L103
    L100:
        r26 = Math.min(0, r26 + this.P);
    L103:
        if (r27 == false) goto L106;
        setScrollState(1);
        goto L106
    L93:
        r25 = Math.min(0, r25 + this.P);
    L96:
        r27 = false;
    L106:
        if (this.I != 1) goto L163;
        int[] r28 = this.f13746n0;
        r28[0] = 0;
        r28[1] = 0;
        r21.getY();
        com.obric.oui.orecyclerview.base.a r29 = this.F;
        if (r29 != null) goto L110;
    L112:
        int r30 = 0;
    L113:
        int r113 = r25 - r30;
        r21.getX();
        com.obric.oui.orecyclerview.base.a r31 = this.G;
        if (r31 != null) goto L116;
    L118:
        int r32 = 0;
    L119:
        int r114 = r26 - r32;
        if (r12 == false) goto L122;
        int r33 = r113;
    L123:
        if (r13 == false) goto L125;
        int r34 = r114;
    L126:
        boolean r35 = dispatchNestedPreScroll(r33, r34, this.f13746n0, this.l0, 0);
        int[] r36 = this.l0;
        if (r35 == false) goto L129;
        r113 = r113 - r28[0];
        r114 = r114 - r28[1];
        r17[0] = r17[0] + r36[0];
        r17[1] = r17[1] + r36[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L129:
        int r37 = r113;
        int r38 = r114;
        this.N = r111 - r36[0];
        this.O = r112 - r36[1];
        if (r12 == false) goto L132;
        int r39 = r37;
    L133:
        if (r13 == false) goto L135;
        int r40 = r38;
    L137:
        if (T(r39, r40, r21, 0) == false) goto L139;
        getParent().requestDisallowInterceptTouchEvent(true);
    L139:
        o r41 = this.W;
        if (r41 == null) goto L163;
        if (r37 != 0) goto L143;
        if (r38 == 0) goto L163;
    L143:
        r41.a(this, r37, r38);
        goto L163
    L135:
        r40 = 0;
        goto L137
    L132:
        r39 = 0;
        goto L133
    L125:
        r34 = 0;
        goto L126
    L122:
        r33 = 0;
        goto L123
    L116:
        if (r31.d == 0.0f) goto L118;
        r32 = (int) r31.c(r26, true, false);
        invalidate();
        goto L119
    L110:
        if (r29.d == 0.0f) goto L112;
        r30 = (int) r29.c(r25, true, false);
        invalidate();
        goto L113
    L144:
        this.K.e(r18);
        ug.e r42 = this.K;
        ((VelocityTracker) r42.f22361b).computeCurrentVelocity(1000, this.R);
        if (r12 == false) goto L147;
        ug.e r43 = this.K;
        float r44 = -((VelocityTracker) r43.f22361b).getXVelocity(this.J);
    L148:
        if (r13 == false) goto L150;
        ug.e r45 = this.K;
        float r46 = -((VelocityTracker) r45.f22361b).getYVelocity(this.J);
    L151:
        Log.d("RecyclerView", "TouchUp, Velocity: x: " + r44 + ", y: " + r46);
        if (r44 != 0.0f) goto L156;
        if (r46 != 0.0f) goto L156;
    L157:
        Log.d("RecyclerView", "No fling, setting scroll state to idle");
        setScrollState(0);
    L158:
        S();
    L156:
        if (A((int) r44, (int) r46) == true) goto L158;
    L150:
        r46 = 0.0f;
        goto L151
    L147:
        r44 = 0.0f;
        goto L148
    L12:
        r10 = w(r21);
        goto L58
    L14:
        if (r5.f13862v != 0) goto L17;
    L53:
        int r47 = r21.getAction();
        if (r47 == 3) goto L56;
        if (r47 == 1) goto L56;
    L57:
        r10 = true;
    L56:
        this.f13751q = null;
        goto L57
    L17:
        if (r21.getAction() != 0) goto L27;
        boolean r48 = r5.d(r21.getX(), r21.getY());
        boolean r49 = r5.c(r21.getX(), r21.getY());
        if (r48 == true) goto L21;
        if (r49 == false) goto L53;
    L21:
        if (r49 == false) goto L23;
        r5.f13863w = 1;
        r5.f13857p = (int) r21.getX();
    L25:
        r5.f(2);
        goto L53
    L23:
        if (r48 == false) goto L25;
        r5.f13863w = 2;
        r5.f13854m = (int) r21.getY();
        goto L25
    L27:
        if (r21.getAction() != 1) goto L32;
        if (r5.f13862v != 2) goto L32;
        r5.f13854m = 0.0f;
        r5.f13857p = 0.0f;
        r5.f(1);
        r5.f13863w = 0;
    L32:
        if (r21.getAction() != 2) goto L53;
        if (r5.f13862v != 2) goto L53;
        r5.g();
        int r50 = r5.f13863w;
        int r115 = r5.f13847b;
        if (r50 != 1) goto L45;
        float r51 = r21.getX();
        int[] r116 = r5.f13865y;
        r116[0] = r115;
        int r117 = r5.f13858q - r115;
        r116[1] = r117;
        float r52 = Math.max(r115, Math.min(r117, r51));
        if (Math.abs(r5.f13856o - r52) < 2.0f) goto L45;
        int r118 = l.e(r5.f13857p, r52, r116, r5.s.computeHorizontalScrollRange(), r5.s.computeHorizontalScrollOffset(), r5.f13858q);
        if (r118 == 0) goto L43;
        r5.s.scrollBy(r118, 0);
    L43:
        r5.f13857p = r52;
    L45:
        if (r5.f13863w != 2) goto L53;
        float r53 = r21.getY();
        int[] r119 = r5.f13864x;
        r119[0] = r115;
        int r120 = r5.f13859r - r115;
        r119[1] = r120;
        float r54 = Math.max(r115, Math.min(r120, r53));
        if (Math.abs(r5.f13853l - r54) < 2.0f) goto L53;
        int r55 = l.e(r5.f13854m, r54, r119, r5.s.computeVerticalScrollRange(), r5.s.computeVerticalScrollOffset(), r5.f13859r);
        if (r55 == 0) goto L52;
        r5.s.scrollBy(0, r55);
    L52:
        r5.f13854m = r54;
        goto L53
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [int] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
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
    public final void p() {
        if (this.f13742l != null) goto L7;
        Log.w("RecyclerView", "No adapter attached; skipping layout");
        return;
    L7:
        if (this.f13743m != null) goto L10;
        Log.e("RecyclerView", "No layout manager attached; skipping layout");
        return;
    L10:
        u0 r5 = this.f13729b0;
        boolean r10 = false;
        r5.f13914h = false;
        int r11 = 1;
        if (this.f13755s0 == true) goto L13;
    L17:
        boolean r12 = false;
    L18:
        this.f13757t0 = 0;
        this.f13759u0 = 0;
        this.f13755s0 = false;
        if (r5.f13913c != 1) goto L21;
        q();
        this.f13743m.V(this);
        r();
    L34:
        r5.a(4);
        X();
        K();
        r5.f13913c = 1;
        boolean r13 = r5.f13915i;
        q0 r14 = this.f13728b;
        ko.r r15 = this.f;
        if (r13 == false) goto L131;
        int r16 = this.e.o() - 1;
    L37:
        if (r16 < 0) goto L91;
        x0 r17 = F(this.e.n(r16));
        if (r17.shouldIgnore() == true) goto L90;
        long r18 = C(r17);
        this.H.getClass();
        f0 r19 = new f0();
        r19.a(r17);
        x0 r110 = (x0) ((LongSparseArray) r15.f18729c).get(r18);
        if (r110 != null) goto L44;
    L89:
        r15.n(r17, r19);
        goto L90
    L44:
        if (r110.shouldIgnore() == true) goto L89;
        SimpleArrayMap r111 = (SimpleArrayMap) r15.f18728b;
        c1 r20 = (c1) r111.get(r110);
        if (r20 != null) goto L48;
    L50:
        int r21 = 0;
    L51:
        c1 r112 = (c1) r111.get(r17);
        if (r112 != null) goto L54;
    L56:
        int r113 = 0;
    L57:
        if (r21 == 0) goto L60;
        if (r110 != r17) goto L60;
        r15.n(r17, r19);
    L60:
        f0 r22 = r15.s(r110, 4);
        r15.n(r17, r19);
        f0 r114 = r15.s(r17, 8);
        if (r22 != null) goto L79;
        int r23 = this.e.o();
        int r24 = 0;
    L63:
        if (r24 >= r23) goto L78;
        x0 r115 = F(this.e.n(r24));
        if (r115 == r17) goto L77;
        if (C(r115) != r18) goto L77;
        a0 r25 = this.f13742l;
        if (r25 != null) goto L72;
    L75:
        StringBuilder r26 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        r26.append(r115);
        r26.append(" \n View Holder 2:");
        r26.append(r17);
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, r26));
    L72:
        if (r25.hasStableIds() == false) goto L75;
        StringBuilder r27 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
        r27.append(r115);
        r27.append(" \n View Holder 2:");
        r27.append(r17);
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, r27));
    L77:
        r24 = r24 + 1;
        goto L63
    L78:
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r110 + " cannot be found but it is necessary for " + r17 + t());
        goto L90
    L79:
        r110.setIsRecyclable(false);
        if (r21 == 0) goto L82;
        g(r110);
    L82:
        if (r110 == r17) goto L87;
        if (r113 == 0) goto L85;
        g(r17);
    L85:
        r110.mShadowedHolder = r17;
        g(r110);
        r14.k(r110);
        r17.setIsRecyclable(false);
        r17.mShadowingHolder = r110;
    L87:
        if (this.H.a(r110, r17, r22, r114) == false) goto L90;
        N();
        goto L90
    L54:
        if ((r112.f13797a & r11) == 0) goto L56;
        r113 = r11;
        goto L57
    L48:
        if ((r20.f13797a & r11) == 0) goto L50;
        r21 = r11;
    L90:
        r16 = r16 - 1;
        r11 = 1;
        goto L37
    L91:
        SimpleArrayMap r28 = (SimpleArrayMap) r15.f18728b;
        int r29 = r28.size() - 1;
    L92:
        if (r29 < 0) goto L131;
        x0 r116 = (x0) r28.keyAt(r29);
        c1 r30 = (c1) r28.removeAt(r29);
        int r31 = r30.f13797a;
        int r32 = r31 & 3;
        y r117 = this.f13763w0;
        if (r32 != 3) goto L98;
        r117.i(r116);
        ?? r33 = r10;
    L96:
        f0 r34 = null;
    L130:
        r30.f13797a = r33;
        r30.f13798b = r34;
        r30.f13799c = r34;
        c1.d.release(r30);
        r29 = r29 - 1;
        r10 = false;
        goto L92
    L98:
        if ((r31 & 1) == 0) goto L104;
        f0 r35 = r30.f13798b;
        if (r35 != null) goto L102;
        r117.i(r116);
        r33 = r10;
        goto L96
    L102:
        r117.g(r116, r35, r30.f13799c);
        r33 = r10;
        goto L96
    L104:
        if ((r31 & 14) != 14) goto L107;
        r117.f(r116, r30.f13798b, r30.f13799c);
        r33 = r10;
        goto L96
    L107:
        if ((r31 & 12) != 12) goto L124;
        f0 r36 = r30.f13798b;
        f0 r37 = r30.f13799c;
        r117.getClass();
        r116.setIsRecyclable(r10);
        RecyclerView r118 = (RecyclerView) r117.f13929a;
        if (r118.B == true) goto L111;
        i r119 = (i) r118.H;
        r119.getClass();
        int r120 = r36.f13809a;
        int r121 = r37.f13809a;
        if (r120 == r121) goto L116;
    L119:
        boolean r38 = r119.g(r116, r120, r36.f13810b, r121, r37.f13810b);
    L120:
        if (r38 == false) goto L122;
        r118.N();
    L122:
        r33 = 0;
        goto L96
    L116:
        if (r36.f13810b != r37.f13810b) goto L119;
        r119.c(r116);
        r38 = false;
        goto L120
    L111:
        if (r118.H.a(r116, r116, r36, r37) == false) goto L122;
        r118.N();
        goto L122
    L124:
        if ((r31 & 4) == 0) goto L127;
        r34 = null;
        r117.g(r116, r30.f13798b, null);
    L126:
        r33 = 0;
        goto L130
    L127:
        r34 = null;
        if ((r31 & 8) == 0) goto L126;
        r117.f(r116, r30.f13798b, r30.f13799c);
    L131:
        View r39 = null;
        this.f13743m.N(r14);
        r5.f13911a = r5.d;
        int r40 = 0;
        this.B = false;
        this.C = false;
        r5.f13915i = false;
        r5.f13916j = false;
        this.f13743m.getClass();
        ArrayList r41 = r14.f13886b;
        if (r41 == null) goto L134;
        r41.clear();
    L134:
        k0 r42 = this.f13743m;
        if (r42.f13841h == false) goto L137;
        r42.g = 0;
        r42.f13841h = false;
        r14.l();
    L137:
        this.f13743m.J();
        L(true);
        Y(false);
        ((SimpleArrayMap) r15.f18728b).clear();
        ((LongSparseArray) r15.f18729c).clear();
        int[] r43 = this.f13739j0;
        int r44 = r43[0];
        int r45 = r43[1];
        x(r43);
        if (r43[0] == r44) goto L140;
    L143:
        boolean r46 = true;
    L144:
        if (r46 == false) goto L147;
        s(0, 0);
    L147:
        if (this.U == true) goto L149;
    L226:
        r5.f13918l = -1;
        r5.f13917k = -1;
        r5.f13919m = -1;
        return;
    L149:
        if (this.f13742l == null) goto L226;
        if (hasFocus() == false) goto L226;
        if (getDescendantFocusability() == 393216) goto L226;
        if (getDescendantFocusability() != 131072) goto L160;
        if (isFocused() == true) goto L226;
    L160:
        if (isFocused() == true) goto L165;
        if (((ArrayList) this.e.d).contains(getFocusedChild()) == false) goto L226;
    L165:
        if (r5.f13918l != (-1)) goto L167;
    L186:
        x0 r122 = null;
    L187:
        if (r122 == null) goto L195;
        com.google.common.reflect.w r47 = this.e;
        if (((ArrayList) r47.d).contains(r122.itemView) == true) goto L195;
        if (r122.itemView.hasFocusable() == false) goto L195;
        r39 = r122.itemView;
    L217:
        if (r39 == null) goto L226;
        int r48 = r5.f13919m;
        if (r48 == (-1)) goto L225;
        View r49 = r39.findViewById(r48);
        if (r49 == null) goto L225;
        if (r49.isFocusable() == false) goto L225;
        r39 = r49;
    L225:
        r39.requestFocus();
    L195:
        if (this.e.o() <= 0) goto L217;
        int r50 = r5.f13917k;
        if (r50 == (-1)) goto L199;
        r40 = r50;
    L199:
        int r51 = r5.b();
        int r52 = r40;
    L200:
        if (r52 >= r51) goto L208;
        x0 r53 = z(r52);
        if (r53 == null) goto L208;
        if (r53.itemView.hasFocusable() == true) goto L206;
        r52 = r52 + 1;
        goto L200
    L206:
        r39 = r53.itemView;
    L208:
        int r54 = Math.min(r51, r40) - 1;
    L209:
        if (r54 < 0) goto L217;
        x0 r55 = z(r54);
        if (r55 == null) goto L217;
        if (r55.itemView.hasFocusable() == true) goto L215;
        r54 = r54 - 1;
        goto L209
    L215:
        r39 = r55.itemView;
        goto L217
    L167:
        if (this.f13742l.hasStableIds() == false) goto L186;
        long r56 = r5.f13918l;
        a0 r57 = this.f13742l;
        if (r57 == null) goto L186;
        if (r57.hasStableIds() == false) goto L186;
        int r58 = this.e.s();
        int r123 = 0;
        r122 = null;
    L174:
        if (r123 >= r58) goto L187;
        x0 r124 = F(this.e.r(r123));
        if (r124 == null) goto L185;
        if (r124.isRemoved() == true) goto L185;
        if (r124.getItemId() != r56) goto L185;
        com.google.common.reflect.w r125 = this.e;
        if (((ArrayList) r125.d).contains(r124.itemView) == false) goto L184;
        r122 = r124;
        goto L185
    L184:
        r122 = r124;
    L185:
        r123 = r123 + 1;
        goto L174
    L140:
        if (r43[1] != r45) goto L143;
        r46 = false;
        goto L144
    L21:
        b r59 = this.d;
        if (r59.f13793c.isEmpty() == false) goto L24;
    L26:
        if (r12 == false) goto L28;
    L33:
        this.f13743m.V(this);
        r();
        goto L34
    L28:
        if (this.f13743m.f13844k != getWidth()) goto L33;
        if (this.f13743m.f13845l != getHeight()) goto L33;
        this.f13743m.V(this);
        goto L34
    L24:
        if (r59.f13792b.isEmpty() == true) goto L26;
    L13:
        if (this.f13757t0 == getWidth()) goto L15;
    L16:
        r12 = true;
        goto L18
    L15:
        if (this.f13759u0 == getHeight()) goto L17;
        goto L16
    }

    public final void q() {
        u0 r5 = this.f13729b0;
        r5.a(1);
        u(r5);
        r5.f13914h = false;
        X();
        ko.r r10 = this.f;
        ((SimpleArrayMap) r10.f18728b).clear();
        LongSparseArray r11 = (LongSparseArray) r10.f18729c;
        r11.clear();
        K();
        O();
        x0 r12 = null;
        if (this.U == true) goto L5;
    L9:
        View r13 = null;
    L10:
        if (r13 == null) goto L16;
        View r14 = v(r13);
        if (r14 == null) goto L16;
        r12 = E(r14);
    L16:
        long r15 = -1;
        if (r12 != null) goto L20;
        r5.f13918l = -1;
        r5.f13917k = -1;
        r5.f13919m = -1;
    L41:
        if (r5.f13915i == true) goto L43;
    L45:
        boolean r16 = false;
    L46:
        r5.g = r16;
        this.f13734f0 = false;
        this.f13733e0 = false;
        r5.f = r5.f13916j;
        r5.d = this.f13742l.getItemCount();
        x(this.f13739j0);
        boolean r17 = r5.f13915i;
        SimpleArrayMap r18 = (SimpleArrayMap) r10.f18728b;
        if (r17 == false) goto L73;
        int r19 = this.e.o();
        int r20 = 0;
    L49:
        if (r20 >= r19) goto L73;
        x0 r21 = F(this.e.n(r20));
        if (r21.shouldIgnore() == true) goto L71;
        if (r21.isInvalid() == true) goto L55;
    L57:
        g0 r22 = this.H;
        g0.b(r21);
        r21.getUnmodifiedPayloads();
        r22.getClass();
        f0 r23 = new f0();
        r23.a(r21);
        c1 r110 = (c1) r18.get(r21);
        if (r110 != null) goto L60;
        r110 = c1.a();
        r18.put(r21, r110);
    L60:
        r110.f13798b = r23;
        r110.f13797a |= 4;
        if (r5.g == false) goto L71;
        if (r21.isUpdated() == false) goto L71;
        if (r21.isRemoved() == true) goto L71;
        if (r21.shouldIgnore() == true) goto L71;
        if (r21.isInvalid() == true) goto L71;
        r11.put(C(r21), r21);
        goto L71
    L55:
        if (this.f13742l.hasStableIds() == true) goto L57;
    L71:
        r20 = r20 + 1;
    L73:
        if (r5.f13916j == false) goto L109;
        int r24 = this.e.s();
        int r25 = 0;
    L75:
        if (r25 >= r24) goto L89;
        x0 r26 = F(this.e.r(r25));
        if (f13723x0 == false) goto L86;
        if (r26.mPosition != (-1)) goto L86;
        if (r26.isRemoved() == true) goto L86;
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
    L86:
        if (r26.shouldIgnore() == true) goto L88;
        r26.saveOldPosition();
    L88:
        r25 = r25 + 1;
        goto L75
    L89:
        boolean r27 = r5.e;
        r5.e = false;
        this.f13743m.I(this.f13728b, r5);
        r5.e = r27;
        int r28 = 0;
    L91:
        if (r28 >= this.e.o()) goto L108;
        x0 r29 = F(this.e.n(r28));
        if (r29.shouldIgnore() == true) goto L107;
        c1 r30 = (c1) r18.get(r29);
        if (r30 != null) goto L98;
    L100:
        g0.b(r29);
        boolean r31 = r29.hasAnyOfTheFlags(8192);
        g0 r32 = this.H;
        r29.getUnmodifiedPayloads();
        r32.getClass();
        f0 r33 = new f0();
        r33.a(r29);
        if (r31 == false) goto L103;
        Q(r29, r33);
        goto L107
    L103:
        c1 r34 = (c1) r18.get(r29);
        if (r34 != null) goto L106;
        r34 = c1.a();
        r18.put(r29, r34);
    L106:
        r34.f13797a |= 2;
        r34.f13798b = r33;
        goto L107
    L98:
        if ((r30.f13797a & 4) == 0) goto L100;
    L107:
        r28 = r28 + 1;
        goto L91
    L108:
        l();
    L110:
        L(true);
        Y(false);
        r5.f13913c = 2;
        return;
    L109:
        l();
        goto L110
    L43:
        if (this.f13734f0 == false) goto L45;
        r16 = true;
        goto L46
    L20:
        if (this.f13742l.hasStableIds() == false) goto L22;
        r15 = r12.getItemId();
    L22:
        r5.f13918l = r15;
        if (this.B == false) goto L26;
        int r35 = -1;
    L29:
        r5.f13917k = r35;
        View r36 = r12.itemView;
        int r37 = r36.getId();
    L31:
        if (r36.isFocused() == true) goto L39;
        if ((r36 instanceof ViewGroup) == false) goto L39;
        if (r36.hasFocus() == false) goto L39;
        r36 = ((ViewGroup) r36).getFocusedChild();
        if (r36.getId() == (-1)) goto L31;
        r37 = r36.getId();
    L39:
        r5.f13919m = r37;
        goto L41
    L26:
        if (r12.isRemoved() == false) goto L28;
        r35 = r12.mOldPosition;
        goto L29
    L28:
        r35 = r12.getAbsoluteAdapterPosition();
        goto L29
    L5:
        if (hasFocus() == false) goto L9;
        if (this.f13742l == null) goto L9;
        r13 = getFocusedChild();
        goto L10
    }

    public final void r() {
        X();
        K();
        u0 r5 = this.f13729b0;
        r5.a(6);
        this.d.c();
        r5.d = this.f13742l.getItemCount();
        r5.f13912b = 0;
        if (this.f13730c != null) goto L5;
    L10:
        r5.f = false;
        this.f13743m.I(this.f13728b, r5);
        r5.e = false;
        if (r5.f13915i == true) goto L13;
    L15:
        boolean r10 = false;
    L16:
        r5.f13915i = r10;
        r5.f13913c = 4;
        L(true);
        Y(false);
        return;
    L13:
        if (this.H == null) goto L15;
        r10 = true;
        goto L16
    L5:
        if (this.f13742l.canRestoreState() == false) goto L10;
        Parcelable r11 = this.f13730c.f13771a;
        if (r11 == null) goto L9;
        this.f13743m.K(r11);
    L9:
        this.f13730c = null;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View r5, boolean r10) {
        x0 r11 = F(r5);
        if (r11 == null) goto L13;
        if (r11.isTmpDetached() == false) goto L8;
        r11.clearTmpDetachFlag();
    L14:
        r5.clearAnimation();
        x0 r12 = F(r5);
        a0 r13 = this.f13742l;
        if (r13 == null) goto L18;
        if (r12 == null) goto L18;
        r13.onViewDetachedFromWindow(r12);
    L18:
        super.removeDetachedView(r5, r10);
        return;
    L8:
        if (r11.shouldIgnore() == true) goto L14;
        StringBuilder r14 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
        r14.append(r11);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, r14));
    L13:
        if (f13723x0 == false) goto L14;
        StringBuilder r15 = new StringBuilder("No ViewHolder found for child: ");
        r15.append(r5);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, r15));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r5, View r10) {
        this.f13743m.getClass();
        if (H() == true) goto L6;
        if (r10 == null) goto L6;
        R(r5, r10);
    L6:
        super.requestChildFocus(r5, r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        return this.f13743m.P(this, r10, r11, r12, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r5) {
        ArrayList r10 = this.f13749p;
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((l) r10.get(r12)).getClass();
        r12 = r12 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r5);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f13758u == 0) goto L5;
    L7:
        this.f13760v = true;
        return;
    L5:
        if (this.f13762w == true) goto L7;
        super.requestLayout();
    }

    public final void s(int r5, int r10) {
        this.E++;
        int r11 = getScrollX();
        int r12 = getScrollY();
        onScrollChanged(r11, r12, r11 - r5, r12 - r10);
        n0 r13 = this.f13731c0;
        if (r13 == null) goto L5;
        r13.b(this);
    L5:
        ArrayList r14 = this.f13732d0;
        if (r14 == null) goto L10;
        int r15 = r14.size() - 1;
    L8:
        if (r15 < 0) goto L10;
        ((n0) this.f13732d0.get(r15)).b(this);
        r15 = r15 - 1;
    L10:
        this.E--;
    }

    @Override // android.view.View
    public final void scrollBy(int r5, int r10) {
        k0 r11 = this.f13743m;
        if (r11 != null) goto L7;
        Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.f13762w == false) goto L9;
        return;
    L9:
        boolean r12 = r11.c();
        boolean r13 = this.f13743m.d();
        if (r12 == true) goto L13;
        if (r13 == true) goto L13;
        return;
    L13:
        if (r12 == true) goto L16;
        r5 = 0;
    L16:
        if (r13 == true) goto L19;
        r10 = 0;
    L19:
        T(r5, r10, null, 0);
    }

    @Override // android.view.View
    public final void scrollTo(int r5, int r10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent r5) {
        if (H() == false) goto L13;
        int r10 = 0;
        if (r5 == null) goto L7;
        int r11 = AccessibilityEventCompat.getContentChangeTypes(r5);
    L8:
        if (r11 == 0) goto L11;
        r10 = r11;
    L11:
        this.f13765y |= r10;
        return;
    L7:
        r11 = 0;
        goto L8
    L13:
        super.sendAccessibilityEventUnchecked(r5);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate r5) {
        this.i0 = r5;
        ViewCompat.setAccessibilityDelegate(this, r5);
    }

    public void setAdapter(@Nullable a0 r10) {
        setLayoutFrozen(false);
        a0 r5 = this.f13742l;
        s0 r11 = this.f13726a;
        if (r5 == null) goto L5;
        r5.unregisterAdapterDataObserver(r11);
        this.f13742l.onDetachedFromRecyclerView(this);
    L5:
        g0 r12 = this.H;
        if (r12 == null) goto L8;
        r12.e();
    L8:
        k0 r13 = this.f13743m;
        q0 r14 = this.f13728b;
        if (r13 == null) goto L11;
        r13.M(r14);
        this.f13743m.N(r14);
    L11:
        r14.f13885a.clear();
        r14.e();
        b r15 = this.d;
        r15.k(r15.f13792b);
        r15.k(r15.f13793c);
        r15.f = 0;
        a0 r16 = this.f13742l;
        this.f13742l = r10;
        if (r10 == null) goto L14;
        r10.registerAdapterDataObserver(r11);
        r10.onAttachedToRecyclerView(this);
    L14:
        a0 r17 = this.f13742l;
        r14.f13885a.clear();
        r14.e();
        r14.d(r16, true);
        p0 r18 = r14.b();
        if (r16 == null) goto L18;
        r18.f13880b--;
    L18:
        if (r18.f13880b != 0) goto L27;
        int r19 = 0;
    L20:
        SparseArray r20 = r18.f13879a;
        if (r19 >= r20.size()) goto L27;
        o0 r21 = (o0) r20.valueAt(r19);
        Iterator r22 = r21.f13873a.iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        PoolingContainer.callPoolingContainerOnRelease(((x0) r22.next()).itemView);
        goto L24
    L26:
        r21.f13873a.clear();
        r19 = r19 + 1;
    L27:
        if (r17 == null) goto L29;
        r18.f13880b++;
    L29:
        r14.c();
        this.f13729b0.e = true;
        P(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable d0 r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r5) {
        if (r5 == this.g) goto L5;
        this.G = null;
        this.F = null;
    L5:
        this.g = r5;
        super.setClipToPadding(r5);
        if (this.f13756t == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull e0 r5) {
    }

    public void setEnableOverFling(boolean r5) {
        this.f13750p0 = r5;
    }

    public void setHasFixedSize(boolean r5) {
        this.s = r5;
    }

    public void setItemAnimator(@Nullable g0 r5) {
        g0 r10 = this.H;
        if (r10 == null) goto L5;
        r10.e();
        this.H.f13814a = null;
    L5:
        this.H = r5;
        if (r5 == null) goto L9;
        r5.f13814a = this.g0;
        return;
    }

    public void setItemViewCacheSize(int r5) {
        q0 r10 = this.f13728b;
        r10.e = r5;
        r10.l();
    }

    @Deprecated
    public void setLayoutFrozen(boolean r5) {
        suppressLayout(r5);
    }

    public void setLayoutManager(@Nullable k0 r10) {
        if (r10 != this.f13743m) goto L5;
        return;
    L5:
        Z();
        k0 r5 = this.f13743m;
        q0 r11 = this.f13728b;
        if (r5 == null) goto L14;
        g0 r12 = this.H;
        if (r12 == null) goto L10;
        r12.e();
    L10:
        this.f13743m.M(r11);
        this.f13743m.N(r11);
        r11.f13885a.clear();
        r11.e();
        if (this.f13753r == false) goto L13;
        this.f13743m.getClass();
    L13:
        this.f13743m.Y(null);
        this.f13743m = null;
    L15:
        com.google.common.reflect.w r13 = this.e;
        ((com.bytedance.crash.upload.l) r13.f9376b).h();
        ArrayList r14 = (ArrayList) r13.d;
        int r15 = r14.size();
    L16:
        r15 = r15 - 1;
        RecyclerView r16 = (RecyclerView) ((y) r13.f9377c).f13929a;
        if (r15 < 0) goto L22;
        x0 r17 = F((View) r14.get(r15));
        if (r17 == null) goto L21;
        r17.onLeftHiddenState(r16);
    L21:
        r14.remove(r15);
        goto L16
    L22:
        int r18 = r16.getChildCount();
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L29;
        View r20 = r16.getChildAt(r19);
        x0 r21 = F(r20);
        a0 r22 = r16.f13742l;
        if (r22 == null) goto L28;
        if (r21 == null) goto L28;
        r22.onViewDetachedFromWindow(r21);
    L28:
        r20.clearAnimation();
        r19 = r19 + 1;
        goto L23
    L29:
        r16.removeAllViews();
        this.f13743m = r10;
        if (r10 != null) goto L32;
    L38:
        r11.l();
        requestLayout();
        return;
    L32:
        if (r10.f13839b != null) goto L36;
        r10.Y(this);
        if (this.f13753r == false) goto L38;
        this.f13743m.getClass();
        goto L38
    L36:
        StringBuilder r23 = new StringBuilder("LayoutManager ");
        r23.append(r10);
        r23.append(" is already attached to a RecyclerView:");
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r10.f13839b, r23));
    L14:
        r11.f13885a.clear();
        r11.e();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r5) {
        if (r5 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setMinFlingVelocity(int r5) {
        this.Q = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        getScrollingChildHelper().setNestedScrollingEnabled(r5);
    }

    public void setOnBounceTranslationListener(@Nullable l0 r5) {
        getBounceTranslation();
    }

    public void setOnFlingListener(@Nullable m0 r5) {
    }

    @Deprecated
    public void setOnScrollListener(@Nullable n0 r5) {
        this.f13731c0 = r5;
    }

    public void setPreserveFocusAfterLayout(boolean r5) {
        this.U = r5;
    }

    public void setRecycledViewPool(@Nullable p0 r5) {
        q0 r10 = this.f13728b;
        RecyclerView r11 = r10.f13888h;
        r10.d(r11.f13742l, false);
        p0 r12 = r10.g;
        if (r12 == null) goto L5;
        r12.f13880b--;
    L5:
        r10.g = r5;
        if (r5 != null) goto L8;
    L10:
        r10.c();
        return;
    L8:
        if (r11.getAdapter() == null) goto L10;
        r10.g.f13880b++;
        goto L10
    }

    @Deprecated
    public void setRecyclerListener(@Nullable r0 r5) {
    }

    public void setScrollState(int r5) {
        if (r5 != this.I) goto L6;
        return;
    L6:
        if (f13724y0 == false) goto L8;
        StringBuilder r10 = ai.j0.s(r5, "setting scroll state to ", " from ");
        r10.append(this.I);
        Log.d("RecyclerView", r10.toString(), new Exception());
    L8:
        this.I = r5;
        if (r5 == 2) goto L14;
        w0 r11 = this.V;
        ((RecyclerView) r11.f13928h).removeCallbacks(r11);
        com.obric.oui.orecyclerview.base.f r12 = (com.obric.oui.orecyclerview.base.f) r11.f;
        if (r12.f == false) goto L13;
        r12.c().abortAnimation();
        goto L14
    L13:
        r12.g = -1;
    L14:
        n0 r13 = this.f13731c0;
        if (r13 == null) goto L17;
        r13.a(this, r5);
    L17:
        ArrayList r14 = this.f13732d0;
        if (r14 == null) goto L22;
        int r15 = r14.size() - 1;
    L20:
        if (r15 < 0) goto L24;
        ((n0) this.f13732d0.get(r15)).a(this, r5);
        r15 = r15 - 1;
        goto L20
    L24:
        return;
    }

    public void setScrollingTouchSlop(int r5) {
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        if (r5 != 0) goto L5;
    L8:
        this.P = r10.getScaledTouchSlop();
        return;
    L5:
        if (r5 == 1) goto L7;
        Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + r5 + "; using default value");
        goto L8
    L7:
        this.P = r10.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(@Nullable v0 r5) {
        this.f13728b.getClass();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        return getScrollingChildHelper().startNestedScroll(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.f13762w) goto L16;
        j("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.f13762w = false;
        if (this.f13760v == true) goto L9;
    L13:
        this.f13760v = false;
        return;
    L9:
        if (this.f13743m == null) goto L13;
        if (this.f13742l == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r5 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0));
        this.f13762w = true;
        this.f13764x = true;
        Z();
        return;
    }

    public final String t() {
        return " " + super.toString() + ", adapter:" + this.f13742l + ", layout:" + this.f13743m + ", context:" + getContext();
    }

    public final void u(u0 r5) {
        if (getScrollState() != 2) goto L13;
        com.obric.oui.orecyclerview.base.f r10 = (com.obric.oui.orecyclerview.base.f) this.V.f;
        if (r10.f == false) goto L7;
        r10.c().getFinalX();
    L8:
        r10.a();
        r5.getClass();
        if (r10.f == false) goto L11;
        r10.c().getFinalY();
    L12:
        r10.b();
        return;
    L11:
        ((com.obric.oui.orecyclerview.base.c) r10.e.getValue()).a();
        goto L12
    L7:
        ((com.obric.oui.orecyclerview.base.c) r10.d.getValue()).a();
        goto L8
    L13:
        r5.getClass();
    }

    public final View v(View r5) {
        ViewParent r10 = r5.getParent();
    L3:
        if (r10 == null) goto L8;
        if (r10 == this) goto L8;
        if ((r10 instanceof View) == false) goto L8;
        r5 = r10;
        r10 = r5.getParent();
    L8:
        if (r10 == this) goto L15;
        return null;
    L15:
        return r5;
    }

    public final boolean w(MotionEvent r12) {
        int r5 = r12.getAction();
        ArrayList r10 = this.f13749p;
        int r11 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L21;
        l r14 = (l) r10.get(r13);
        int r15 = r14.f13862v;
        if (r15 != 1) goto L15;
        boolean r16 = r14.d(r12.getX(), r12.getY());
        boolean r17 = r14.c(r12.getX(), r12.getY());
        if (r12.getAction() != 0) goto L20;
        if (r16 == true) goto L10;
        if (r17 == false) goto L20;
    L10:
        if (r17 == false) goto L12;
        r14.f13863w = 1;
        r14.f13857p = (int) r12.getX();
    L14:
        r14.f(2);
    L17:
        if (r5 == 3) goto L20;
        this.f13751q = r14;
        return true;
    L12:
        if (r16 == false) goto L14;
        r14.f13863w = 2;
        r14.f13854m = (int) r12.getY();
    L20:
        r13 = r13 + 1;
        goto L3
    L15:
        if (r15 != 2) goto L20;
    L21:
        return false;
    }

    public final void x(int[] r10) {
        int r5 = this.e.o();
        if (r5 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r11 = Integer.MAX_VALUE;
        int r12 = Integer.MIN_VALUE;
        int r13 = 0;
    L7:
        if (r13 >= r5) goto L17;
        x0 r14 = F(this.e.n(r13));
        if (r14.shouldIgnore() == true) goto L16;
        int r15 = r14.getLayoutPosition();
        if (r15 >= r11) goto L14;
        r11 = r15;
    L14:
        if (r15 <= r12) goto L16;
        r12 = r15;
    L16:
        r13 = r13 + 1;
        goto L7
    L17:
        r10[0] = r11;
        r10[1] = r12;
    }

    public final x0 z(int r10) {
        x0 r5 = null;
        if (this.B == false) goto L5;
        return null;
    L5:
        int r11 = this.e.s();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L18;
        x0 r13 = F(this.e.r(r12));
        if (r13 == null) goto L17;
        if (r13.isRemoved() == true) goto L17;
        if (B(r13) != r10) goto L17;
        com.google.common.reflect.w r14 = this.e;
        View r15 = r13.itemView;
        if (((ArrayList) r14.d).contains(r15) == false) goto L16;
        r5 = r13;
        goto L17
    L16:
        return r13;
    L17:
        r12 = r12 + 1;
        goto L6
    L18:
        return r5;
    }

    public RecyclerView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R$attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        return getScrollingChildHelper().hasNestedScrollingParent(r5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r5, int r10) {
        return getScrollingChildHelper().startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        getScrollingChildHelper().stopNestedScroll(r5);
    }

    public RecyclerView(@NonNull Context r20, @Nullable AttributeSet r21, int r22) {
        super(r20, r21, r22);
        this.f13726a = new s0(this);
        this.f13728b = new q0(this);
        this.f = new ko.r(6);
        this.f13735h = new w(this, 0);
        this.f13737i = new Rect();
        this.f13738j = new Rect();
        this.f13740k = new RectF();
        this.f13745n = new ArrayList();
        this.f13747o = new ArrayList();
        this.f13749p = new ArrayList();
        this.f13758u = 0;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        i r5 = new i();
        r5.f13814a = null;
        r5.f13815b = new ArrayList();
        r5.f13816c = 100;
        r5.d = 100;
        r5.e = 500;
        r5.f = 250;
        r5.g = true;
        r5.f13821h = new ArrayList();
        r5.f13822i = new ArrayList();
        r5.f13823j = new ArrayList();
        r5.f13824k = new ArrayList();
        r5.f13825l = new ArrayList();
        r5.f13826m = new ArrayList();
        r5.f13827n = new ArrayList();
        r5.f13828o = new ArrayList();
        r5.f13829p = new ArrayList();
        r5.f13830q = new ArrayList();
        r5.f13831r = new ArrayList();
        this.H = r5;
        this.I = 0;
        this.J = -1;
        this.S = Float.MIN_VALUE;
        this.T = Float.MIN_VALUE;
        this.U = true;
        this.V = new w0(this);
        if (C0 == false) goto L5;
        com.airbnb.lottie.parser.moshi.c r10 = new com.airbnb.lottie.parser.moshi.c();
    L6:
        this.f13727a0 = r10;
        u0 r11 = new u0();
        r11.f13911a = 0;
        r11.f13912b = 0;
        r11.f13913c = 1;
        r11.d = 0;
        r11.e = false;
        r11.f = false;
        r11.g = false;
        r11.f13914h = false;
        r11.f13915i = false;
        r11.f13916j = false;
        this.f13729b0 = r11;
        this.f13733e0 = false;
        this.f13734f0 = false;
        y r12 = new y(this);
        this.g0 = r12;
        this.f13736h0 = false;
        this.f13739j0 = new int[2];
        this.l0 = new int[2];
        this.f13744m0 = new int[2];
        this.f13746n0 = new int[2];
        this.f13748o0 = new ArrayList();
        this.f13750p0 = true;
        this.f13752q0 = true;
        this.f13754r0 = new w(this, 1);
        this.f13757t0 = 0;
        this.f13759u0 = 0;
        this.f13763w0 = new y(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r13 = ViewConfiguration.get(r20);
        this.P = r13.getScaledTouchSlop();
        this.S = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r13, r20);
        this.T = ViewConfigurationCompat.getScaledVerticalScrollFactor(r13, r20);
        this.Q = r13.getScaledMinimumFlingVelocity();
        this.R = r13.getScaledMaximumFlingVelocity();
        float r14 = r20.getResources().getDisplayMetrics().density;
        if (getOverScrollMode() != 2) goto L9;
        boolean r15 = true;
    L10:
        setWillNotDraw(r15);
        this.H.f13814a = r12;
        this.d = new b(new y(this));
        this.e = new com.google.common.reflect.w(new y(this));
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L14;
        ViewCompat.setImportantForAutofill(this, 8);
    L14:
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L16;
        ViewCompat.setImportantForAccessibility(this, 1);
    L16:
        this.A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r16 = r20.obtainStyledAttributes(r21, R$styleable.RecyclerView, r22, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r20, R$styleable.RecyclerView, r21, r16, r22, 0);
        String r17 = r16.getString(R$styleable.RecyclerView_layoutManager);
        if (r16.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L19;
        setDescendantFocusability(262144);
    L19:
        this.g = r16.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        if (r16.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false) == false) goto L30;
        StateListDrawable r18 = (StateListDrawable) r16.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable);
        Drawable r19 = r16.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable);
        StateListDrawable r23 = (StateListDrawable) r16.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
        Drawable r24 = r16.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
        if (r18 == null) goto L28;
        if (r19 == null) goto L28;
        if (r23 == null) goto L28;
        if (r24 == null) goto L28;
        Resources r25 = getContext().getResources();
        new l(this, r18, r19, r23, r24, r25.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), r25.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), r25.getDimensionPixelOffset(R$dimen.fastscroll_margin));
    L28:
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
    L30:
        r16.recycle();
        if (r17 == null) goto L81;
        String r26 = r17.trim();
        if (r26.isEmpty() == true) goto L81;
        if (r26.charAt(0) != '.') goto L39;
        r26 = r20.getPackageName() + r26;
    L37:
        String r27 = r26;
    L45:
        e = move-exception;
        throw new IllegalStateException(r21.getPositionDescription() + ": Class is not a LayoutManager " + r27, e);
    L53:
        e = move-exception;
        throw new IllegalStateException(r21.getPositionDescription() + ": Unable to find LayoutManager " + r27, e);
    L47:
        e = move-exception;
        throw new IllegalStateException(r21.getPositionDescription() + ": Cannot access non-public constructor " + r27, e);
    L49:
        e = move-exception;
        throw new IllegalStateException(r21.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r27, e);
    L51:
        e = move-exception;
        throw new IllegalStateException(r21.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r27, e);
    L43:
        if (isInEditMode() == false) goto L55;
        ClassLoader r28 = getClass().getClassLoader();     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
    L56:
        Class<? extends U> r29 = Class.forName(r27, false, r28).asSubclass(k0.class);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
        Constructor r30 = r29.getConstructor(D0);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L63
        Object[] r31 = new Object[4];     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L63
        r31[0] = r20;     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L63
        boolean r32 = true;
        r31[1] = r21;     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L61
        r31[2] = Integer.valueOf(r22);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L61
        r31[3] = 0;     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L61
    L60:
        Object[] r110 = r31;
        r30.setAccessible(r32);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
        setLayoutManager((k0) r30.newInstance(r110));     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
    L82:
        int[] r33 = f13725z0;
        TypedArray r34 = r20.obtainStyledAttributes(r21, r33, r22, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r20, r33, r21, r34, r22, 0);
        boolean r35 = r34.getBoolean(0, r32);
        r34.recycle();
        setNestedScrollingEnabled(r35);
        PoolingContainer.setPoolingContainer(this, r32);
        Intrinsics.checkNotNullParameter(this, "recyclerView");
        this.f13761v0 = new y0();
        return;
    L61:
        e = e;
    L62:
        NoSuchMethodException r36 = e;
        r31 = null;
        r30 = r29.getConstructor(null);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53 NoSuchMethodException -> L68
    L68:
        e = move-exception;
        e.initCause(r36);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
        throw new IllegalStateException(r21.getPositionDescription() + ": Error creating LayoutManager " + r27, e);     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
    L63:
        e = e;
        r32 = true;
        goto L62
    L55:
        r28 = r20.getClassLoader();     // Catch: ClassCastException -> L45 IllegalAccessException -> L47 InstantiationException -> L49 InvocationTargetException -> L51 ClassNotFoundException -> L53
        goto L56
    L39:
        if (r26.contains(".") == true) goto L37;
        r26 = RecyclerView.class.getPackage().getName() + '.' + r26;
    L81:
        r32 = true;
        goto L82
    L9:
        r15 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, int[] r16) {
        getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        k0 r10 = this.f13743m;
        if (r10 == null) goto L13;
        r10.getClass();
        if ((r5 instanceof LayoutParams) == false) goto L8;
        return new LayoutParams((LayoutParams) r5);
    L8:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L11:
        return new LayoutParams(r5);
    L13:
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
