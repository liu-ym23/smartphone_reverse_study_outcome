package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.IdRes;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.obric.oui.constraintlayout.helper.widget.MotionEffect;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean F0;
    public final HashMap A;
    public boolean A0;
    public long B;
    public final RectF B0;
    public float C;
    public View C0;
    public float D;
    public Matrix D0;
    public float E;
    public final ArrayList E0;
    public long F;
    public float G;
    public boolean H;
    public boolean I;
    public z J;
    public int K;
    public v L;
    public boolean M;
    public final jr.b N;
    public final u O;
    public a P;
    public int Q;
    public int R;
    public boolean S;
    public float T;
    public float U;
    public long V;
    public float W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f12663a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public ArrayList f12664b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ArrayList f12665c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ArrayList f12666d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public CopyOnWriteArrayList f12667e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f12668f0;
    public long g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f12669h0;
    public int i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f12670j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f12671k0;
    public int l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f12672m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f12673n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f12674o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f12675p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d0 f12676q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f12677q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r f12678r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f12679r0;
    public Interpolator s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final gr.e f12680s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f12681t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f12682t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12683u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public y f12684u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12685v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public a2.b f12686v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12687w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final Rect f12688w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12689x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f12690x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12691y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public TransitionState f12692y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12693z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final w f12694z0;

    public static final enum TransitionState extends Enum<TransitionState> {
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f12695a = null;

        static {
            TransitionState r5 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r5;
            TransitionState r10 = new TransitionState("SETUP", 1);
            SETUP = r10;
            TransitionState r11 = new TransitionState("MOVING", 2);
            MOVING = r11;
            TransitionState r12 = new TransitionState("FINISHED", 3);
            FINISHED = r12;
            f12695a = new TransitionState[]{r5, r10, r11, r12};
        }

        public static TransitionState valueOf(String r5) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r5);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f12695a.clone();
        }
    }

    public MotionLayout(Context r5) {
        super(r5);
        this.s = null;
        this.f12681t = 0.0f;
        this.f12683u = -1;
        this.f12685v = -1;
        this.f12687w = -1;
        this.f12689x = 0;
        this.f12691y = 0;
        this.f12693z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new jr.b();
        this.O = new u(this);
        this.S = false;
        this.f12663a0 = false;
        this.f12664b0 = null;
        this.f12665c0 = null;
        this.f12666d0 = null;
        this.f12667e0 = null;
        this.f12668f0 = 0;
        this.g0 = -1;
        this.f12669h0 = 0.0f;
        this.i0 = 0;
        this.f12670j0 = 0.0f;
        this.f12671k0 = false;
        this.f12680s0 = new gr.e(1);
        this.f12682t0 = false;
        this.f12686v0 = null;
        new HashMap();
        this.f12688w0 = new Rect();
        this.f12690x0 = false;
        this.f12692y0 = TransitionState.UNDEFINED;
        this.f12694z0 = new w(this);
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList();
        D(null);
    }

    public static Rect u(MotionLayout r5, hr.f r10) {
        r5.getClass();
        int r11 = r10.t();
        Rect r12 = r5.f12688w0;
        r12.top = r11;
        r12.left = r10.s();
        r12.right = r10.r() + r12.left;
        r12.bottom = r10.l() + r12.top;
        return r12;
    }

    public final void A(int r5, float r10, float r11, float r12, float[] r13) {
        View r14 = e(r5);
        q r15 = (q) this.A.get(r14);
        if (r15 == null) goto L5;
        r15.d(r10, r11, r12, r13);
        r14.getY();
        return;
    L5:
        if (r14 != null) goto L7;
        String r16 = ai.j0.g(r5, "");
    L8:
        Log.w("MotionLayout", "WARNING could not find view id " + r16);
        return;
    L7:
        r16 = r14.getContext().getResources().getResourceName(r5);
        goto L8
    }

    public final c0 B(int r5) {
        Iterator r10 = this.f12676q.d.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        c0 r11 = (c0) r10.next();
        if (r11.f12716a != r5) goto L4;
        return r11;
    L8:
        return null;
    }

    public final boolean C(float r10, float r11, View r12, MotionEvent r13) {
        if ((r12 instanceof ViewGroup) == false) goto L10;
        ViewGroup r5 = (ViewGroup) r12;
        int r14 = r5.getChildCount() - 1;
    L5:
        if (r14 < 0) goto L10;
        View r15 = r5.getChildAt(r14);
        if (C((r15.getLeft() + r10) - r12.getScrollX(), (r15.getTop() + r11) - r12.getScrollY(), r15, r13) == true) goto L8;
        r14 = r14 - 1;
        goto L5
    L8:
        boolean r16 = true;
    L11:
        if (r16 == true) goto L26;
        float r17 = (r12.getRight() + r10) - r12.getLeft();
        float r18 = (r12.getBottom() + r11) - r12.getTop();
        RectF r19 = this.B0;
        r19.set(r10, r11, r17, r18);
        if (r13.getAction() == 0) goto L15;
    L16:
        float r20 = -r10;
        float r21 = -r11;
        Matrix r22 = r12.getMatrix();
        if (r22.isIdentity() == false) goto L19;
        r13.offsetLocation(r20, r21);
        boolean r23 = r12.onTouchEvent(r13);
        r13.offsetLocation(-r20, -r21);
    L23:
        if (r23 == false) goto L26;
        return true;
    L19:
        MotionEvent r110 = MotionEvent.obtain(r13);
        r110.offsetLocation(r20, r21);
        if (this.D0 != null) goto L22;
        this.D0 = new Matrix();
    L22:
        r22.invert(this.D0);
        r110.transform(this.D0);
        r23 = r12.onTouchEvent(r110);
        r110.recycle();
        goto L23
    L15:
        if (r19.contains(r13.getX(), r13.getY()) == true) goto L16;
    L26:
        return r16;
    L10:
        r16 = false;
        goto L11
    }

    public final void D(AttributeSet r13) {
        F0 = isInEditMode();
        int r5 = -1;
        int r10 = 0;
        if (r13 == null) goto L37;
        TypedArray r14 = getContext().obtainStyledAttributes(r13, R$styleable.MotionLayout);
        int r11 = r14.getIndexCount();
        int r12 = 0;
        boolean r15 = true;
    L5:
        if (r12 >= r11) goto L31;
        int r16 = r14.getIndex(r12);
        if (r16 != R$styleable.MotionLayout_layoutDescription) goto L10;
        this.f12676q = new d0(getContext(), this, r14.getResourceId(r16, -1));
    L30:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r16 != R$styleable.MotionLayout_currentState) goto L13;
        this.f12685v = r14.getResourceId(r16, -1);
        goto L30
    L13:
        if (r16 != R$styleable.MotionLayout_motionProgress) goto L16;
        this.G = r14.getFloat(r16, 0.0f);
        this.I = true;
        goto L30
    L16:
        if (r16 != R$styleable.MotionLayout_applyMotionScene) goto L19;
        r15 = r14.getBoolean(r16, r15);
        goto L30
    L19:
        if (r16 != R$styleable.MotionLayout_showPaths) goto L28;
        if (this.K != 0) goto L30;
        if (r14.getBoolean(r16, false) == false) goto L25;
        int r17 = 2;
    L26:
        this.K = r17;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L28:
        if (r16 != R$styleable.MotionLayout_motionDebug) goto L30;
        this.K = r14.getInt(r16, 0);
        goto L30
    L31:
        r14.recycle();
        if (this.f12676q != null) goto L34;
        Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
    L34:
        if (r15 == true) goto L37;
        this.f12676q = null;
    L37:
        if (this.K == 0) goto L87;
        d0 r18 = this.f12676q;
        if (r18 != null) goto L41;
        Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        goto L87
    L41:
        int r19 = r18.h();
        d0 r20 = this.f12676q;
        com.obric.oui.constraintlayout.widget.d r21 = r20.b(r20.h());
        String r110 = ym.k.g(getContext(), r19);
        int r22 = getChildCount();
        int r23 = 0;
    L43:
        if (r23 >= r22) goto L51;
        View r24 = getChildAt(r23);
        int r25 = r24.getId();
        if (r25 != (-1)) goto L48;
        StringBuilder r26 = ai.j0.x("CHECK: ", r110, " ALL VIEWS SHOULD HAVE ID's ");
        r26.append(r24.getClass().getName());
        r26.append(" does not!");
        Log.w("MotionLayout", r26.toString());
    L48:
        if (r21.i(r25) != null) goto L50;
        StringBuilder r27 = ai.j0.x("CHECK: ", r110, " NO CONSTRAINTS for ");
        r27.append(ym.k.h(r24));
        Log.w("MotionLayout", r27.toString());
    L50:
        r23 = r23 + 1;
        goto L43
    L51:
        Integer[] r28 = (Integer[]) r21.g.keySet().toArray(new Integer[0]);
        int r29 = r28.length;
        int[] r30 = new int[r29];
        int r31 = 0;
    L52:
        if (r31 >= r29) goto L54;
        r30[r31] = r28[r31].intValue();
        r31 = r31 + 1;
    L54:
        if (r10 >= r29) goto L65;
        int r32 = r30[r10];
        String r33 = ym.k.g(getContext(), r32);
        if (findViewById(r30[r10]) != null) goto L59;
        Log.w("MotionLayout", "CHECK: " + r110 + " NO View matches id " + r33);
    L59:
        if (r21.h(r32).e.d != (-1)) goto L62;
        Log.w("MotionLayout", ai.j0.l("CHECK: ", r110, "(", r33, ") no LAYOUT_HEIGHT"));
    L62:
        if (r21.h(r32).e.f19719c != (-1)) goto L64;
        Log.w("MotionLayout", ai.j0.l("CHECK: ", r110, "(", r33, ") no LAYOUT_HEIGHT"));
    L64:
        r10 = r10 + 1;
        goto L54
    L65:
        SparseIntArray r111 = new SparseIntArray();
        SparseIntArray r34 = new SparseIntArray();
        Iterator r35 = this.f12676q.d.iterator();
    L67:
        if (r35.hasNext() == false) goto L87;
        c0 r36 = (c0) r35.next();
        if (r36 != this.f12676q.f12733c) goto L72;
        Log.v("MotionLayout", "CHECK: CURRENT");
    L72:
        if (r36.d != r36.f12718c) goto L74;
        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
    L74:
        int r37 = r36.d;
        int r38 = r36.f12718c;
        String r39 = ym.k.g(getContext(), r37);
        String r40 = ym.k.g(getContext(), r38);
        if (r111.get(r37) != r38) goto L78;
        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + r39 + "->" + r40);
    L78:
        if (r34.get(r38) != r37) goto L80;
        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + r39 + "->" + r40);
    L80:
        r111.put(r37, r38);
        r34.put(r38, r37);
        if (this.f12676q.b(r37) != null) goto L84;
        Log.e("MotionLayout", " no such constraintSetStart " + r39);
    L84:
        if (this.f12676q.b(r38) != null) goto L67;
        Log.e("MotionLayout", " no such constraintSetEnd " + r39);
    L87:
        if (this.f12685v != (-1)) goto L117;
        d0 r112 = this.f12676q;
        if (r112 == null) goto L118;
        this.f12685v = r112.h();
        this.f12683u = this.f12676q.h();
        c0 r113 = this.f12676q.f12733c;
        if (r113 == null) goto L94;
        r5 = r113.f12718c;
    L94:
        this.f12687w = r5;
        return;
    L118:
        return;
    }

    public final void E() {
        d0 r5 = this.f12676q;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.a(this.f12685v, this) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r10 = this.f12685v;
        if (r10 == (-1)) goto L48;
        d0 r11 = this.f12676q;
        ArrayList r12 = r11.d;
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L20;
        c0 r14 = (c0) r13.next();
        if (r14.f12724m.size() <= 0) goto L13;
        Iterator r15 = r14.f12724m.iterator();
    L18:
        if (r15.hasNext() == false) goto L13;
        ((b0) r15.next()).b(this);
        goto L18
    L20:
        ArrayList r16 = r11.f;
        Iterator r17 = r16.iterator();
    L22:
        if (r17.hasNext() == false) goto L29;
        c0 r18 = (c0) r17.next();
        if (r18.f12724m.size() <= 0) goto L22;
        Iterator r19 = r18.f12724m.iterator();
    L27:
        if (r19.hasNext() == false) goto L22;
        ((b0) r19.next()).b(this);
        goto L27
    L29:
        Iterator r20 = r12.iterator();
    L31:
        if (r20.hasNext() == false) goto L38;
        c0 r21 = (c0) r20.next();
        if (r21.f12724m.size() <= 0) goto L31;
        Iterator r22 = r21.f12724m.iterator();
    L36:
        if (r22.hasNext() == false) goto L31;
        ((b0) r22.next()).a(this, r10, r21);
        goto L36
    L38:
        Iterator r23 = r16.iterator();
    L40:
        if (r23.hasNext() == false) goto L48;
        c0 r24 = (c0) r23.next();
        if (r24.f12724m.size() <= 0) goto L40;
        Iterator r25 = r24.f12724m.iterator();
    L45:
        if (r25.hasNext() == false) goto L40;
        ((b0) r25.next()).a(this, r10, r24);
    L48:
        if (this.f12676q.o() == false) goto L83;
        c0 r26 = this.f12676q.f12733c;
        if (r26 == null) goto L84;
        g0 r27 = r26.f12723l;
        if (r27 == null) goto L85;
        int r28 = r27.d;
        if (r28 == (-1)) goto L58;
        MotionLayout r29 = r27.f12786r;
        View r30 = r29.findViewById(r28);
        if (r30 != null) goto L60;
        Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + ym.k.g(r29.getContext(), r27.d));
    L60:
        if ((r30 instanceof NestedScrollView) == false) goto L86;
        NestedScrollView r31 = (NestedScrollView) r30;
        r31.setOnTouchListener(new e0(0));
        r31.setOnScrollChangeListener(new f0());
        return;
    L86:
        return;
    L58:
        r30 = null;
        goto L60
    L85:
        return;
    L84:
        return;
    }

    public final void F() {
        if (this.J != null) goto L9;
        CopyOnWriteArrayList r5 = this.f12667e0;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return;
    L9:
        ArrayList r10 = this.E0;
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        Integer r12 = (Integer) r11.next();
        z r13 = this.J;
        if (r13 == null) goto L15;
        r13.a(r12.intValue());
    L15:
        CopyOnWriteArrayList r14 = this.f12667e0;
        if (r14 == null) goto L11;
        Iterator r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L11;
        ((z) r15.next()).a(r12.intValue());
        goto L19
    L21:
        r10.clear();
    }

    public final void G() {
        this.f12694z0.f();
        invalidate();
    }

    public final void H(int r10, int r11, int r12) {
        setState(TransitionState.SETUP);
        this.f12685v = r10;
        this.f12683u = -1;
        this.f12687w = -1;
        com.bytedance.crash.upload.t r13 = this.f12996k;
        if (r13 == null) goto L52;
        float r5 = -1;
        int r14 = r13.f4160b;
        SparseArray r15 = (SparseArray) r13.e;
        int r16 = 0;
        ConstraintLayout r17 = (ConstraintLayout) r13.d;
        if (r14 != r10) goto L34;
        if (r10 != (-1)) goto L8;
        lr.d r18 = (lr.d) r15.valueAt(0);
    L9:
        int r19 = r13.f4161c;
        if (r19 == (-1)) goto L14;
        if (((lr.e) r18.f19701b.get(r19)).a(r5, r5) == false) goto L14;
        return;
    L14:
        ArrayList r20 = r18.f19701b;
        if (r16 >= r20.size()) goto L20;
        if (((lr.e) r20.get(r16)).a(r5, r5) == true) goto L22;
        r16 = r16 + 1;
    L22:
        if (r13.f4161c == r16) goto L66;
        ArrayList r21 = r18.f19701b;
        if (r16 != (-1)) goto L27;
        com.obric.oui.constraintlayout.widget.d r22 = null;
    L28:
        if (r16 == (-1)) goto L31;
        int r23 = ((lr.e) r21.get(r16)).e;
    L31:
        if (r22 == null) goto L67;
        r13.f4161c = r16;
        r22.b(r17);
        return;
    L67:
        return;
    L27:
        r22 = ((lr.e) r21.get(r16)).f;
        goto L28
    L66:
        return;
    L20:
        r16 = -1;
        goto L22
    L8:
        r18 = (lr.d) r15.get(r14);
        goto L9
    L34:
        r13.f4160b = r10;
        lr.d r24 = (lr.d) r15.get(r10);
    L35:
        ArrayList r25 = r24.f19701b;
        if (r16 >= r25.size()) goto L41;
        if (((lr.e) r25.get(r16)).a(r5, r5) == true) goto L42;
        r16 = r16 + 1;
    L42:
        ArrayList r26 = r24.f19701b;
        if (r16 != (-1)) goto L45;
        com.obric.oui.constraintlayout.widget.d r27 = r24.d;
    L46:
        if (r16 == (-1)) goto L49;
        int r28 = ((lr.e) r26.get(r16)).e;
    L49:
        if (r27 != null) goto L51;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r10 + ", dim =-1.0, -1.0");
        return;
    L51:
        r13.f4161c = r16;
        r27.b(r17);
        return;
    L45:
        r27 = ((lr.e) r26.get(r16)).f;
        goto L46
    L41:
        r16 = -1;
        goto L42
    L52:
        d0 r29 = this.f12676q;
        if (r29 == null) goto L64;
        r29.b(r10).b(this);
        return;
    }

    public final void I(int r5, int r10) {
        if (isAttachedToWindow() == false) goto L5;
        d0 r11 = this.f12676q;
        if (r11 == null) goto L13;
        this.f12683u = r5;
        this.f12687w = r10;
        r11.n(r5, r10);
        com.obric.oui.constraintlayout.widget.d r12 = this.f12676q.b(r5);
        com.obric.oui.constraintlayout.widget.d r13 = this.f12676q.b(r10);
        this.f12694z0.e(r12, r13);
        G();
        this.E = 0.0f;
        v(0.0f);
        return;
    L13:
        return;
    L5:
        if (this.f12684u0 != null) goto L7;
        this.f12684u0 = new y(this);
    L7:
        y r14 = this.f12684u0;
        r14.f12917c = r5;
        r14.d = r10;
    }

    public final void J(int r16, float r17, float r18) {
        float r10 = r17;
        if (this.f12676q != null) goto L6;
        return;
    L6:
        if (this.E != r10) goto L8;
        return;
    L8:
        this.M = true;
        this.B = getNanoTime();
        float r5 = this.f12676q.c() / 1000.0f;
        this.C = r5;
        this.G = r10;
        this.I = true;
        jr.b r11 = this.N;
        if (r16 == 0) goto L35;
        if (r16 == 1) goto L35;
        if (r16 == 2) goto L35;
        u r13 = this.O;
        if (r16 != 4) goto L15;
        float r12 = this.E;
        float r14 = this.f12676q.g();
        r13.f12897a = r18;
        r13.f12898b = r12;
        r13.f12899c = r14;
        this.f12678r = r13;
    L87:
        this.H = false;
        this.B = getNanoTime();
        invalidate();
        return;
    L15:
        if (r16 == 5) goto L19;
        if (r16 == 6) goto L35;
        if (r16 == 7) goto L35;
    L19:
        float r15 = this.E;
        float r19 = this.f12676q.g();
        if (r18 <= 0.0f) goto L24;
        float r20 = r18 / r19;
        if ((((r18 * r20) - (((r19 * r20) * r20) / 2.0f)) + r15) > 1.0f) goto L26;
    L27:
        float r21 = this.E;
        float r22 = this.C;
        float r23 = this.f12676q.g();
        c0 r24 = this.f12676q.f12733c;
        if (r24 == null) goto L32;
        g0 r25 = r24.f12723l;
        if (r25 == null) goto L32;
        float r26 = r25.s;
    L33:
        this.N.b(r21, r17, r18, r22, r23, r26);
        this.f12681t = 0.0f;
        int r27 = this.f12685v;
        this.G = r10;
        this.f12685v = r27;
        this.f12678r = r11;
    L32:
        r26 = 0.0f;
    L26:
        float r28 = this.E;
        float r29 = this.f12676q.g();
        r13.f12897a = r18;
        r13.f12898b = r28;
        r13.f12899c = r29;
        this.f12678r = r13;
        goto L87
    L24:
        float r30 = (-r18) / r19;
        if ((((((r19 * r30) * r30) / 2.0f) + (r18 * r30)) + r15) >= 0.0f) goto L27;
    L35:
        if (r16 == 1) goto L41;
        if (r16 == 7) goto L41;
        if (r16 == 2) goto L40;
        if (r16 == 6) goto L40;
    L42:
        d0 r31 = this.f12676q;
        c0 r32 = r31.f12733c;
        if (r32 == null) goto L47;
        g0 r33 = r32.f12723l;
        if (r33 == null) goto L47;
        int r34 = r33.D;
    L48:
        if (r34 != 0) goto L56;
        float r35 = this.E;
        float r36 = r31.g();
        c0 r37 = this.f12676q.f12733c;
        if (r37 == null) goto L54;
        g0 r38 = r37.f12723l;
        if (r38 == null) goto L54;
        float r39 = r38.s;
    L55:
        this.N.b(r35, r10, r18, r5, r36, r39);
    L86:
        int r40 = this.f12685v;
        this.G = r10;
        this.f12685v = r40;
        this.f12678r = r11;
    L54:
        r39 = 0.0f;
        goto L55
    L56:
        float r41 = this.E;
        if (r32 == null) goto L61;
        g0 r42 = r32.f12723l;
        if (r42 == null) goto L61;
        float r43 = r42.f12793z;
    L62:
        if (r32 == null) goto L66;
        g0 r44 = r32.f12723l;
        if (r44 == null) goto L66;
        float r45 = r44.A;
    L67:
        if (r32 == null) goto L71;
        g0 r46 = r32.f12723l;
        if (r46 == null) goto L71;
        float r47 = r46.f12792y;
    L72:
        if (r32 == null) goto L76;
        g0 r48 = r32.f12723l;
        if (r48 == null) goto L76;
        float r49 = r48.B;
    L77:
        if (r32 == null) goto L81;
        g0 r50 = r32.f12723l;
        if (r50 == null) goto L81;
        int r51 = r50.C;
    L83:
        if (r11.f18432b != null) goto L85;
        gr.j r52 = new gr.j();
        r52.f17155a = 0.5d;
        r52.f17159i = 0;
        r11.f18432b = r52;
    L85:
        gr.j r53 = r11.f18432b;
        r11.f18433c = r53;
        r53.f17157c = r10;
        r53.f17155a = r47;
        r53.e = r41;
        r53.f17156b = r45;
        r53.g = r43;
        r53.f17158h = r49;
        r53.f17159i = r51;
        r53.d = 0.0f;
    L81:
        r51 = 0;
    L76:
        r49 = 0.0f;
    L71:
        r47 = 0.0f;
    L66:
        r45 = 0.0f;
    L61:
        r43 = 0.0f;
    L47:
        r34 = 0;
    L40:
        r10 = 1.0f;
    L41:
        r10 = 0.0f;
        goto L42
    }

    public final void K(int r5, com.obric.oui.constraintlayout.widget.d r10) {
        d0 r11 = this.f12676q;
        if (r11 == null) goto L5;
        r11.g.put(r5, r10);
    L5:
        com.obric.oui.constraintlayout.widget.d r12 = this.f12676q.b(this.f12683u);
        com.obric.oui.constraintlayout.widget.d r13 = this.f12676q.b(this.f12687w);
        this.f12694z0.e(r12, r13);
        G();
        if (this.f12685v != r5) goto L9;
        r10.b(this);
        return;
    }

    public final void L(int r11, View... r12) {
        d0 r10 = this.f12676q;
        if (r10 == null) goto L34;
        ug.d r13 = r10.f12743q;
        r13.getClass();
        ArrayList r14 = new ArrayList();
        Iterator r15 = ((ArrayList) r13.f22358c).iterator();
        i0 r5 = null;
    L5:
        boolean r16 = r15.hasNext();
        String r17 = (String) r13.e;
        if (r16 == false) goto L32;
        i0 r18 = (i0) r15.next();
        if (r18.f12806a != r11) goto L5;
        int r19 = r12.length;
        int r20 = 0;
    L10:
        if (r20 >= r19) goto L16;
        View r21 = r12[r20];
        if (r18.b(r21) == false) goto L14;
        r14.add(r21);
    L14:
        r20 = r20 + 1;
        goto L10
    L16:
        if (r14.isEmpty() == true) goto L31;
        View[] r22 = (View[]) r14.toArray(new View[0]);
        MotionLayout r23 = (MotionLayout) r13.f22357b;
        int r24 = r23.getCurrentState();
        if (r18.e != 2) goto L20;
        r18.a(r13, (MotionLayout) r13.f22357b, r24, null, r22);
    L30:
        r14.clear();
        goto L31
    L20:
        if (r24 != (-1)) goto L22;
        Log.w(r17, "No support for ViewTransition within transition yet. Currently: " + r23.toString());
        goto L30
    L22:
        d0 r25 = r23.f12676q;
        if (r25 != null) goto L25;
        com.obric.oui.constraintlayout.widget.d r26 = null;
    L26:
        if (r26 == null) goto L30;
        r18.a(r13, (MotionLayout) r13.f22357b, r24, r26, r22);
        goto L30
    L25:
        r26 = r25.b(r24);
    L31:
        r5 = r18;
        goto L5
    L32:
        if (r5 != null) goto L44;
        Log.e(r17, " Could not find ViewTransition");
        return;
    L44:
        return;
    L34:
        Log.e("MotionLayout", " no motionScene");
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r35) {
        Canvas r5 = r35;
        ArrayList r10 = this.f12666d0;
        if (r10 == null) goto L8;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((MotionHelper) r11.next()).getClass();
    L8:
        int r12 = 0;
        x(false);
        d0 r13 = this.f12676q;
        if (r13 == null) goto L22;
        ug.d r14 = r13.f12743q;
        if (r14 == null) goto L22;
        ArrayList r15 = (ArrayList) r14.f;
        if (r15 == null) goto L22;
        Iterator r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        ((h0) r16.next()).a();
        goto L17
    L19:
        ArrayList r17 = (ArrayList) r14.f;
        ArrayList r18 = (ArrayList) r14.g;
        r17.removeAll(r18);
        r18.clear();
        if (((ArrayList) r14.f).isEmpty() == false) goto L22;
        r14.f = null;
    L22:
        super.dispatchDraw(r35);
        if (this.f12676q != null) goto L25;
        return;
    L25:
        int r19 = 1;
        if ((this.K & 1) != 1) goto L41;
        if (isInEditMode() == true) goto L41;
        this.f12668f0++;
        long r20 = getNanoTime();
        long r110 = this.g0;
        if (r110 == (-1)) goto L34;
        long r111 = r20 - r110;
        if (r111 <= 200000000) goto L35;
        this.f12669h0 = ((int) ((this.f12668f0 / (r111 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.f12668f0 = 0;
        this.g0 = r20;
    L35:
        Paint r21 = new Paint();
        r21.setTextSize(42.0f);
        float r22 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        StringBuilder r23 = ai.j0.u(this.f12669h0 + " fps " + ym.k.i(this.f12683u, this) + " -> ");
        r23.append(ym.k.i(this.f12687w, this));
        r23.append(" (progress: ");
        r23.append(r22);
        r23.append(" ) state=");
        int r24 = this.f12685v;
        if (r24 != (-1)) goto L38;
        String r25 = "undefined";
    L39:
        r23.append(r25);
        String r26 = r23.toString();
        r21.setColor(ViewCompat.MEASURED_STATE_MASK);
        r5.drawText(r26, 11.0f, getHeight() - 29, r21);
        r21.setColor(-7864184);
        r5.drawText(r26, 10.0f, getHeight() - 30, r21);
        goto L41
    L38:
        r25 = ym.k.i(r24, this);
        goto L39
    L34:
        this.g0 = r20;
    L41:
        if (this.K > 1) goto L43;
    L187:
        ArrayList r27 = this.f12666d0;
        if (r27 == null) goto L193;
        Iterator r28 = r27.iterator();
    L191:
        if (r28.hasNext() == false) goto L222;
        ((MotionHelper) r28.next()).getClass();
        goto L191
    L222:
        return;
    L193:
        return;
    L43:
        if (this.L != null) goto L45;
        this.L = new v(this);
    L45:
        v r29 = this.L;
        HashMap r30 = this.A;
        int r31 = this.f12676q.c();
        int r112 = this.K;
        r29.getClass();
        if (r30 == null) goto L187;
        if (r30.size() == 0) goto L187;
        r35.save();
        MotionLayout r113 = r29.f12909n;
        boolean r114 = r113.isInEditMode();
        Paint r115 = r29.e;
        if (r114 == false) goto L53;
    L55:
        Iterator r32 = r30.values().iterator();
    L57:
        if (r32.hasNext() == false) goto L186;
        q r33 = (q) r32.next();
        int r34 = r33.f.f12698b;
        ArrayList r116 = r33.f12888u;
        Iterator r117 = r116.iterator();
    L60:
        if (r117.hasNext() == false) goto L62;
        r34 = Math.max(r34, ((a0) r117.next()).f12698b);
        goto L60
    L62:
        int r36 = Math.max(r34, r33.g.f12698b);
        if (r112 <= 0) goto L66;
        if (r36 != 0) goto L66;
        r36 = r19;
    L66:
        if (r36 == 0) goto L57;
        float[] r118 = r29.f12902c;
        if (r118 == null) goto L81;
        double[] r119 = r33.f12878j[r12].A();
        int[] r120 = r29.f12901b;
        if (r120 == null) goto L76;
        Iterator r121 = r116.iterator();
        int r122 = r12;
    L74:
        if (r121.hasNext() == false) goto L76;
        r120[r122] = ((a0) r121.next()).f12707o;
        r122 = r122 + 1;
    L76:
        int r37 = r12;
        int r123 = r37;
    L78:
        if (r37 >= r119.length) goto L80;
        v r210 = r29;
        r33.f12878j[r12].w(r119[r37], r33.f12884p);
        r33.f.c(r119[r37], r33.f12883o, r33.f12884p, r118, r123);
        r123 = r123 + 2;
        r37 = r37 + 1;
        r29 = r210;
        r32 = r32;
        r12 = 0;
        goto L78
    L80:
        Iterator r211 = r32;
        int r38 = r123 / 2;
    L82:
        r29.f12906k = r38;
        if (r36 < 1) goto L184;
        int r39 = r31 / 16;
        float[] r40 = r29.f12900a;
        if (r40 != null) goto L87;
    L88:
        r29.f12900a = new float[r39 * 2];
        r29.d = new Path();
    L89:
        int r41 = r29.f12908m;
        float r42 = r41;
        r5.translate(r42, r42);
        r115.setColor(1996488704);
        Paint r43 = r29.f12904i;
        r43.setColor(1996488704);
        Paint r124 = r29.f;
        r124.setColor(1996488704);
        Paint r125 = r29.g;
        r125.setColor(1996488704);
        float[] r44 = r29.f12900a;
        int r212 = r31;
        float r126 = 1.0f / (r39 - 1);
        HashMap r45 = r33.f12892y;
        int r213 = r112;
        if (r45 != null) goto L92;
        jr.l r46 = null;
    L93:
        HashMap r47 = r33.f12892y;
        if (r47 != null) goto L96;
        jr.l r48 = null;
    L97:
        HashMap r127 = r33.f12893z;
        if (r127 != null) goto L100;
        jr.g r128 = null;
    L101:
        HashMap r129 = r33.f12893z;
        if (r129 != null) goto L104;
        jr.g r49 = null;
    L105:
        int r130 = 0;
    L106:
        a0 r50 = r33.f;
        float r131 = Float.NaN;
        Paint r214 = r124;
        if (r130 >= r39) goto L156;
        float r132 = r130 * r126;
        int r310 = r39;
        float r51 = r33.f12882n;
        if (r51 == 1.0f) goto L118;
        float r311 = r126;
        float r133 = r33.f12881m;
        if (r132 >= r133) goto L113;
        r132 = 0.0f;
    L113:
        jr.l r312 = r48;
        if (r132 <= r133) goto L120;
        if (r132 >= 1.0d) goto L120;
        r132 = Math.min((r132 - r133) * r51, 1.0f);
    L120:
        double r52 = r132;
        gr.e r53 = r50.f12697a;
        Iterator r134 = r116.iterator();
        float r135 = 0.0f;
    L122:
        if (r134.hasNext() == false) goto L132;
        a0 r54 = (a0) r134.next();
        double r136 = r52;
        gr.e r55 = r54.f12697a;
        if (r55 == null) goto L131;
        float r56 = r54.f12699c;
        if (r56 >= r132) goto L129;
        r53 = r55;
        r135 = r56;
        goto L131
    L129:
        if (Float.isNaN(r131) == false) goto L131;
        r131 = r54.f12699c;
    L131:
        r52 = r136;
        goto L122
    L132:
        double r137 = r52;
        if (r53 != null) goto L135;
        double r57 = r137;
    L140:
        r33.f12878j[0].w(r57, r33.f12884p);
        gr.b r58 = r33.f12879k;
        if (r58 == null) goto L145;
        double[] r59 = r33.f12884p;
        if (r59.length <= 0) goto L145;
        r58.w(r57, r59);
    L145:
        int r138 = r130 * 2;
        ArrayList r313 = r116;
        r33.f.c(r57, r33.f12883o, r33.f12884p, r44, r138);
        if (r128 == null) goto L148;
        r44[r138] = r128.a(r132) + r44[r138];
    L150:
        if (r49 == null) goto L153;
        int r139 = r138 + 1;
        r44[r139] = r49.a(r132) + r44[r139];
    L152:
        jr.l r60 = r312;
    L155:
        r130 = r130 + 1;
        r48 = r60;
        r124 = r214;
        r39 = r310;
        r126 = r311;
        r116 = r313;
        goto L106
    L153:
        if (r312 == null) goto L152;
        int r140 = r138 + 1;
        r60 = r312;
        r44[r140] = r60.a(r132) + r44[r140];
        goto L155
    L148:
        if (r46 == null) goto L150;
        r44[r138] = r46.a(r132) + r44[r138];
        goto L150
    L135:
        if (Float.isNaN(r131) == false) goto L137;
        float r141 = 1.0f;
    L138:
        float r142 = r141 - r135;
        r57 = (((float) r53.a((r132 - r135) / r142)) * r142) + r135;
        goto L140
    L137:
        r141 = r131;
        goto L138
    L118:
        r312 = r48;
        r311 = r126;
        goto L120
    L156:
        r29.a(r35, r36, r29.f12906k, r33);
        r115.setColor(-21965);
        r214.setColor(-2067046);
        r43.setColor(-2067046);
        r125.setColor(-13391360);
        float r61 = -r41;
        r35.translate(r61, r61);
        r29.a(r35, r36, r29.f12906k, r33);
        if (r36 != 5) goto L182;
        r29.d.reset();
        int r62 = 0;
    L160:
        if (r62 > 50) goto L181;
        r33.f12878j[0].w(r33.b(r62 / 50, null), r33.f12884p);
        int[] r63 = r33.f12883o;
        double[] r64 = r33.f12884p;
        float r143 = r50.e;
        float r144 = r50.f;
        float r145 = r50.g;
        float r146 = r50.f12700h;
        float r147 = r145;
        float r148 = r144;
        float r149 = r143;
        int r150 = 0;
    L163:
        if (r150 >= r63.length) goto L178;
        float r65 = (float) r64[r150];
        int r66 = r63[r150];
        if (r66 != 1) goto L167;
        r149 = r65;
    L176:
        r150 = r150 + 1;
        goto L163
    L167:
        if (r66 == 2) goto L174;
        if (r66 != 3) goto L170;
        r147 = r65;
        goto L176
    L170:
        if (r66 != 4) goto L176;
        r146 = r65;
        goto L176
    L174:
        r148 = r65;
        goto L176
    L178:
        if (r50.f12705m == null) goto L180;
        double r67 = 0.0f;
        double r68 = r149;
        double r151 = r148;
        float r69 = (float) (((Math.sin(r151) * r68) + r67) - ((double) (r147 / 2.0f)));
        r148 = (float) ((r67 - (Math.cos(r151) * r68)) - ((double) (r146 / 2.0f)));
        r149 = r69;
    L180:
        float r152 = r147 + r149;
        float r153 = r146 + r148;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float r154 = r149 + 0.0f;
        float r155 = r148 + 0.0f;
        float r156 = r152 + 0.0f;
        float r157 = r153 + 0.0f;
        float[] r70 = r29.f12905j;
        r70[0] = r154;
        r70[1] = r155;
        r70[2] = r156;
        r70[3] = r155;
        r70[4] = r156;
        r70[5] = r157;
        r70[6] = r154;
        r70[7] = r157;
        r29.d.moveTo(r154, r155);
        r29.d.lineTo(r70[2], r70[3]);
        r29.d.lineTo(r70[4], r70[5]);
        r29.d.lineTo(r70[6], r70[7]);
        r29.d.close();
        r62 = r62 + 1;
        goto L160
    L181:
        int r71 = 0;
        int r72 = 1;
        r115.setColor(1140850688);
        Canvas r73 = r35;
        r73.translate(2.0f, 2.0f);
        r73.drawPath(r29.d, r115);
        r73.translate(-2.0f, -2.0f);
        r115.setColor(SupportMenu.CATEGORY_MASK);
        r73.drawPath(r29.d, r115);
    L185:
        r5 = r73;
        r12 = r71;
        r19 = r72;
        r31 = r212;
        r32 = r211;
        r112 = r213;
        goto L57
    L182:
        r73 = r35;
        r71 = 0;
        r72 = 1;
        goto L185
    L104:
        r49 = (jr.g) r129.get("translationY");
        goto L105
    L100:
        r128 = (jr.g) r127.get("translationX");
        goto L101
    L96:
        r48 = (jr.l) r47.get("translationY");
        goto L97
    L92:
        r46 = (jr.l) r45.get("translationX");
        goto L93
    L87:
        if (r40.length == (r39 * 2)) goto L89;
    L184:
        r73 = r5;
        r72 = 1;
        r212 = r31;
        r213 = r112;
        r71 = 0;
        goto L185
    L81:
        r211 = r32;
        r38 = 0;
        goto L82
    L186:
        r35.restore();
        goto L187
    L53:
        if ((r112 & 1) != 2) goto L55;
        String r158 = r113.getContext().getResources().getResourceName(r113.f12687w) + ":" + r113.getProgress();
        r5.drawText(r158, 10.0f, r113.getHeight() - 30, r29.f12903h);
        r5.drawText(r158, 11.0f, r113.getHeight() - 29, r115);
        goto L55
    }

    @IdRes
    public int[] getConstraintSetIds() {
        d0 r5 = this.f12676q;
        if (r5 != null) goto L6;
        return null;
    L6:
        SparseArray r10 = r5.g;
        int r11 = r10.size();
        int[] r12 = new int[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12[r13] = r10.keyAt(r13);
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    }

    public int getCurrentState() {
        return this.f12685v;
    }

    public ArrayList<c0> getDefinedTransitions() {
        d0 r5 = this.f12676q;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.d;
    }

    public a getDesignTool() {
        if (this.P != null) goto L6;
        this.P = new a();
    L6:
        return this.P;
    }

    public int getEndState() {
        return this.f12687w;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.E;
    }

    public d0 getScene() {
        return this.f12676q;
    }

    public int getStartState() {
        return this.f12683u;
    }

    public float getTargetPosition() {
        return this.G;
    }

    public Bundle getTransitionState() {
        if (this.f12684u0 != null) goto L5;
        this.f12684u0 = new y(this);
    L5:
        y r5 = this.f12684u0;
        MotionLayout r10 = r5.e;
        r5.d = r10.f12687w;
        r5.f12917c = r10.f12683u;
        r5.f12916b = r10.getVelocity();
        r5.f12915a = r10.getProgress();
        y r11 = this.f12684u0;
        r11.getClass();
        Bundle r12 = new Bundle();
        r12.putFloat("motion.progress", r11.f12915a);
        r12.putFloat("motion.velocity", r11.f12916b);
        r12.putInt("motion.StartState", r11.f12917c);
        r12.putInt("motion.EndState", r11.d);
        return r12;
    }

    public long getTransitionTimeMs() {
        d0 r5 = this.f12676q;
        if (r5 == null) goto L6;
        this.C = r5.c() / 1000.0f;
    L6:
        return (long) (this.C * 1000.0f);
    }

    public float getVelocity() {
        return this.f12681t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r5 = getDisplay();
        if (r5 == null) goto L5;
        r5.getRotation();
    L5:
        d0 r10 = this.f12676q;
        if (r10 == null) goto L30;
        int r11 = this.f12685v;
        if (r11 == (-1)) goto L30;
        com.obric.oui.constraintlayout.widget.d r12 = r10.b(r11);
        d0 r13 = this.f12676q;
        int r14 = 0;
    L10:
        SparseArray r15 = r13.g;
        if (r14 >= r15.size()) goto L21;
        int r16 = r15.keyAt(r14);
        SparseIntArray r17 = r13.f12735i;
        int r18 = r17.get(r16);
        int r19 = r17.size();
    L13:
        if (r18 <= 0) goto L20;
        if (r18 == r16) goto L18;
        int r20 = r19 - 1;
        if (r19 < 0) goto L18;
        r18 = r17.get(r18);
        r19 = r20;
    L18:
        Log.e(MotionScene.TAG, "Cannot be derived from yourself");
        goto L21
    L20:
        r13.m(r16, this);
        r14 = r14 + 1;
    L21:
        ArrayList r21 = this.f12666d0;
        if (r21 == null) goto L27;
        Iterator r22 = r21.iterator();
    L25:
        if (r22.hasNext() == false) goto L27;
        ((MotionHelper) r22.next()).getClass();
    L27:
        if (r12 == null) goto L29;
        r12.b(this);
    L29:
        this.f12683u = this.f12685v;
    L30:
        E();
        y r23 = this.f12684u0;
        if (r23 != null) goto L33;
        d0 r24 = this.f12676q;
        if (r24 == null) goto L51;
        c0 r25 = r24.f12733c;
        if (r25 != null) goto L41;
        return;
    L41:
        if (r25.f12725n != 4) goto L53;
        v(1.0f);
        this.f12686v0 = null;
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L53:
        return;
    L51:
        return;
    L33:
        if (this.f12690x0 == false) goto L35;
        post(new s(1, this));
        return;
    L35:
        r23.a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r21) {
        d0 r5 = this.f12676q;
        if (r5 != null) goto L5;
    L6:
        return false;
    L5:
        if (this.f12693z == false) goto L6;
        ug.d r10 = r5.f12743q;
        if (r10 == null) goto L75;
        MotionLayout r11 = (MotionLayout) r10.f22357b;
        int r12 = r11.getCurrentState();
        if (r12 == (-1)) goto L75;
        HashSet r13 = (HashSet) r10.d;
        ArrayList r14 = (ArrayList) r10.f22358c;
        if (r13 != null) goto L23;
        r10.d = new HashSet();
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        i0 r16 = (i0) r15.next();
        int r17 = r11.getChildCount();
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L16;
        View r19 = r11.getChildAt(r18);
        if (r16.c(r19) == false) goto L22;
        r19.getId();
        ((HashSet) r10.d).add(r19);
    L22:
        r18 = r18 + 1;
    L23:
        float r110 = r21.getX();
        float r111 = r21.getY();
        Rect r112 = new Rect();
        int r113 = r21.getAction();
        ArrayList r20 = (ArrayList) r10.f;
        int r22 = 2;
        if (r20 != null) goto L26;
    L43:
        if (r113 == 0) goto L46;
        if (r113 != 1) goto L75;
    L46:
        d0 r23 = r11.f12676q;
        if (r23 != null) goto L49;
        com.obric.oui.constraintlayout.widget.d r24 = null;
    L50:
        Iterator r25 = r14.iterator();
    L52:
        if (r25.hasNext() == false) goto L75;
        i0 r26 = (i0) r25.next();
        int r27 = r26.f12807b;
        if (r27 != 1) goto L57;
        if (r113 != 0) goto L74;
    L63:
        Iterator r114 = ((HashSet) r10.d).iterator();
    L65:
        if (r114.hasNext() == false) goto L74;
        View r28 = (View) r114.next();
        if (r26.c(r28) == false) goto L65;
        r28.getHitRect(r112);
        if (r112.contains((int) r110, (int) r111) == false) goto L73;
        View[] r115 = {r28};
        r26.a(r10, (MotionLayout) r10.f22357b, r12, r24, r115);
    L73:
        r26 = r26;
        r22 = r22;
    L74:
        r22 = r22;
        goto L52
    L57:
        if (r27 != r22) goto L61;
        if (r113 != 1) goto L74;
    L61:
        if (r27 != 3) goto L74;
        if (r113 != 0) goto L74;
    L49:
        r24 = r23.b(r12);
        goto L50
    L26:
        if (r20.isEmpty() == true) goto L43;
        Iterator r29 = ((ArrayList) r10.f).iterator();
    L29:
        if (r29.hasNext() == false) goto L43;
        h0 r30 = (h0) r29.next();
        if (r113 == 1) goto L40;
        if (r113 == 2) goto L34;
        r30.getClass();
        goto L29
    L34:
        View r31 = r30.f12798c.f12874b;
        Rect r32 = r30.f12803l;
        r31.getHitRect(r32);
        if (r32.contains((int) r110, (int) r111) == true) goto L29;
        if (r30.f12799h == true) goto L29;
        r30.b();
        goto L29
    L40:
        if (r30.f12799h == true) goto L29;
        r30.b();
    L75:
        c0 r33 = this.f12676q.f12733c;
        if (r33 != null) goto L78;
    L104:
        return false;
    L78:
        if (r33.f12726o == true) goto L104;
        g0 r34 = r33.f12723l;
        if (r34 == null) goto L104;
        if (r21.getAction() != 0) goto L89;
        RectF r35 = r34.b(this, new RectF());
        if (r35 == null) goto L89;
        if (r35.contains(r21.getX(), r21.getY()) == true) goto L89;
        return false;
    L89:
        int r36 = r34.e;
        if (r36 == (-1)) goto L104;
        View r37 = this.C0;
        if (r37 != null) goto L94;
    L95:
        this.C0 = findViewById(r36);
    L96:
        View r38 = this.C0;
        if (r38 == null) goto L104;
        RectF r39 = this.B0;
        r39.set(r38.getLeft(), this.C0.getTop(), this.C0.getRight(), this.C0.getBottom());
        if (r39.contains(r21.getX(), r21.getY()) == false) goto L104;
        if (C(this.C0.getLeft(), this.C0.getTop(), this.C0, r21) == true) goto L104;
        return onTouchEvent(r21);
    L94:
        if (r37.getId() == r36) goto L96;
        goto L95
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        this.f12682t0 = true;
    L8:
        th = move-exception;
        this.f12682t0 = false;
        throw th;
    L4:
        if (this.f12676q != null) goto L10;
        super.onLayout(r5, r10, r11, r12, r13);     // Catch: Throwable -> L8
        this.f12682t0 = false;
        return;
    L10:
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        if (this.Q == r14) goto L14;
    L15:
        G();     // Catch: Throwable -> L8
        x(true);     // Catch: Throwable -> L8
    L16:
        this.Q = r14;     // Catch: Throwable -> L8
        this.R = r15;     // Catch: Throwable -> L8
        this.f12682t0 = false;
        return;
    L14:
        if (this.R == r15) goto L16;
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r18, int r19) {
        if (this.f12676q != null) goto L6;
        super.onMeasure(r18, r19);
        return;
    L6:
        boolean r5 = true;
        int r10 = 0;
        if (this.f12689x == r18) goto L9;
    L12:
        boolean r11 = true;
    L14:
        if (this.A0 == false) goto L17;
        this.A0 = false;
        E();
        F();
        r11 = true;
    L17:
        if (this.f12993h == false) goto L19;
        r11 = true;
    L19:
        this.f12689x = r18;
        this.f12691y = r19;
        int r12 = this.f12676q.h();
        c0 r13 = this.f12676q.f12733c;
        if (r13 != null) goto L22;
        int r14 = -1;
    L23:
        hr.g r15 = this.f12992c;
        w r16 = this.f12694z0;
        if (r11 == true) goto L30;
        if (r12 != r16.e) goto L30;
        if (r14 != r16.f) goto L30;
    L32:
        if (r11 == false) goto L34;
        super.onMeasure(r18, r19);
    L34:
        boolean r17 = true;
    L36:
        if (this.f12671k0 == true) goto L38;
        if (r17 == true) goto L38;
    L47:
        float r20 = Math.signum(this.G - this.E);
        long r21 = getNanoTime();
        r r22 = this.f12678r;
        if ((r22 instanceof jr.b) == true) goto L50;
        float r23 = (((r21 - this.F) * r20) * 1.0E-9f) / this.C;
    L51:
        float r110 = this.E + r23;
        if (this.H == false) goto L55;
        r110 = this.G;
    L55:
        if (r20 <= 0.0f) goto L59;
        if (r110 < this.G) goto L59;
    L62:
        r110 = this.G;
    L64:
        if (r22 == null) goto L70;
        if (r5 == true) goto L70;
        if (this.M == false) goto L69;
        r110 = r22.getInterpolation((r21 - this.B) * 1.0E-9f);
        goto L70
    L69:
        r110 = r22.getInterpolation(r110);
    L70:
        if (r20 <= 0.0f) goto L74;
        if (r110 < this.G) goto L74;
    L77:
        r110 = this.G;
    L78:
        this.f12679r0 = r110;
        int r24 = getChildCount();
        long r25 = getNanoTime();
        Interpolator r26 = this.s;
        if (r26 == null) goto L82;
        r110 = r26.getInterpolation(r110);
    L82:
        if (r10 >= r24) goto L88;
        View r111 = getChildAt(r10);
        q r112 = (q) this.A.get(r111);
        if (r112 == null) goto L86;
        r112.f(r110, r25, r111, this.f12680s0);
    L86:
        r10 = r10 + 1;
        goto L82
    L88:
        if (this.f12671k0 == false) goto L95;
        requestLayout();
        return;
    L95:
        return;
    L74:
        if (r20 > 0.0f) goto L78;
        if (r110 > this.G) goto L78;
    L59:
        if (r20 <= 0.0f) goto L61;
    L63:
        r5 = false;
        goto L64
    L61:
        if (r110 > this.G) goto L63;
    L50:
        r23 = 0.0f;
    L38:
        int r27 = getPaddingBottom() + getPaddingTop();
        int r28 = r15.r() + (getPaddingRight() + getPaddingLeft());
        int r29 = r15.l() + r27;
        int r30 = this.f12675p0;
        if (r30 == Integer.MIN_VALUE) goto L41;
        if (r30 == 0) goto L41;
    L42:
        int r31 = this.f12677q0;
        if (r31 == Integer.MIN_VALUE) goto L45;
        if (r31 == 0) goto L45;
    L46:
        setMeasuredDimension(r28, r29);
    L45:
        int r32 = this.f12672m0;
        r29 = (int) ((this.f12679r0 * (this.f12674o0 - r32)) + r32);
        requestLayout();
    L41:
        int r33 = this.l0;
        r28 = (int) ((this.f12679r0 * (this.f12673n0 - r33)) + r33);
        requestLayout();
    L30:
        if (this.f12683u == (-1)) goto L32;
        super.onMeasure(r18, r19);
        r16.e(this.f12676q.b(r12), this.f12676q.b(r14));
        r16.f();
        r16.e = r12;
        r16.f = r14;
        r17 = false;
        goto L36
    L22:
        r14 = r13.f12718c;
        goto L23
    L9:
        if (this.f12691y != r19) goto L12;
        r11 = false;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r20, int r21, int r22, int[] r23, int r24) {
        d0 r5 = this.f12676q;
        if (r5 != null) goto L5;
        return;
    L5:
        c0 r10 = r5.f12733c;
        if (r10 == null) goto L95;
        boolean r11 = r10.f12726o;
        if (r11 == true) goto L97;
        int r12 = -1;
        if (r11 == true) goto L19;
        g0 r13 = r10.f12723l;
        if (r13 == null) goto L19;
        int r14 = r13.e;
        if (r14 == (-1)) goto L19;
        if (r20.getId() == r14) goto L19;
        return;
    L19:
        c0 r15 = r5.f12733c;
        if (r15 == null) goto L24;
        g0 r16 = r15.f12723l;
        if (r16 == null) goto L24;
        boolean r17 = r16.f12788u;
    L26:
        if (r17 == false) goto L39;
        g0 r18 = r10.f12723l;
        if (r18 != null) goto L30;
    L32:
        float r19 = this.D;
        if (r19 == 1.0f) goto L37;
        if (r19 != 0.0f) goto L39;
    L37:
        if (r20.canScrollVertically(r12) == false) goto L39;
        return;
    L30:
        if ((r18.f12790w & 4) == 0) goto L32;
        r12 = r22;
    L39:
        g0 r25 = r10.f12723l;
        if (r25 != null) goto L42;
    L68:
        float r26 = this.D;
        long r27 = getNanoTime();
        float r28 = r21;
        this.T = r28;
        float r29 = r22;
        this.U = r29;
        this.W = (float) ((r27 - this.V) * 1.0E-9d);
        this.V = r27;
        c0 r30 = r5.f12733c;
        if (r30 == null) goto L86;
        g0 r31 = r30.f12723l;
        if (r31 == null) goto L86;
        MotionLayout r32 = r31.f12786r;
        float r33 = r32.getProgress();
        if (r31.f12781m == true) goto L75;
        r31.f12781m = true;
        r32.setProgress(r33);
    L75:
        r31.f12786r.A(r31.d, r33, r31.f12776h, r31.g, r31.f12782n);
        float r110 = r31.f12779k;
        float[] r111 = r31.f12782n;
        if (Math.abs((r31.f12780l * r111[1]) + (r110 * r111[0])) >= 0.01d) goto L78;
        r111[0] = 0.01f;
        r111[1] = 0.01f;
    L78:
        float r112 = r31.f12779k;
        if (r112 == 0.0f) goto L81;
        float r34 = (r28 * r112) / r111[0];
    L82:
        float r35 = Math.max(Math.min(r33 + r34, 1.0f), 0.0f);
        if (r35 == r32.getProgress()) goto L86;
        r32.setProgress(r35);
        goto L86
    L81:
        r34 = (r29 * r31.f12780l) / r111[1];
    L86:
        if (r26 == this.D) goto L88;
        r23[0] = r21;
        ?? r36 = 1;
        r23[1] = r22;
    L89:
        x(false);
        if (r23[0] == 0) goto L92;
    L93:
        this.S = r36;
        return;
    L92:
        if (r23[r36] != 0) goto L93;
        return;
    L88:
        r36 = 1;
        goto L89
    L42:
        if ((r25.f12790w & 1) == 0) goto L68;
        float r37 = r21;
        float r38 = r22;
        c0 r113 = r5.f12733c;
        if (r113 == null) goto L57;
        g0 r114 = r113.f12723l;
        if (r114 == null) goto L57;
        float r115 = r114.f12786r.getProgress();
        r114.f12786r.A(r114.d, r115, r114.f12776h, r114.g, r114.f12782n);
        float r39 = r114.f12779k;
        float[] r116 = r114.f12782n;
        if (r39 == 0.0f) goto L54;
        if (r116[0] != 0.0f) goto L52;
        r116[0] = 1.0E-7f;
    L52:
        float r40 = (r37 * r39) / r116[0];
    L58:
        float r41 = this.E;
        if (r41 > 0.0f) goto L63;
        if (r40 >= 0.0f) goto L63;
    L66:
        r20.setNestedScrollingEnabled(false);
        r20.post(new s(0, r20));
        return;
    L63:
        if (r41 < 1.0f) goto L68;
        if (r40 <= 0.0f) goto L68;
    L54:
        if (r116[1] != 0.0f) goto L56;
        r116[1] = 1.0E-7f;
    L56:
        r40 = (r38 * r114.f12780l) / r116[1];
    L57:
        r40 = 0.0f;
    L24:
        r17 = false;
        goto L26
    L97:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        this.V = getNanoTime();
        this.W = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r5) {
        d0 r10 = this.f12676q;
        if (r10 == null) goto L10;
        boolean r11 = p();
        r10.f12742p = r11;
        c0 r12 = r10.f12733c;
        if (r12 == null) goto L11;
        g0 r13 = r12.f12723l;
        if (r13 == null) goto L12;
        r13.c(r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        d0 r13 = this.f12676q;
        if (r13 == null) goto L13;
        c0 r14 = r13.f12733c;
        if (r14 == null) goto L15;
        g0 r15 = r14.f12723l;
        if (r15 != null) goto L9;
        return false;
    L9:
        if ((r15.f12790w & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    L13:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r11, int r12) {
        d0 r13 = this.f12676q;
        if (r13 == null) goto L30;
        float r14 = this.W;
        float r5 = 0.0f;
        if (r14 == 0.0f) goto L36;
        float r10 = this.T / r14;
        float r15 = this.U / r14;
        c0 r16 = r13.f12733c;
        if (r16 == null) goto L31;
        g0 r17 = r16.f12723l;
        if (r17 == null) goto L32;
        r17.f12781m = false;
        MotionLayout r18 = r17.f12786r;
        float r19 = r18.getProgress();
        r17.f12786r.A(r17.d, r19, r17.f12776h, r17.g, r17.f12782n);
        float r20 = r17.f12779k;
        float[] r21 = r17.f12782n;
        float r110 = r21[0];
        float r22 = r17.f12780l;
        float r23 = r21[1];
        if (r20 == 0.0f) goto L14;
        float r24 = (r10 * r20) / r110;
    L16:
        if (Float.isNaN(r24) == true) goto L19;
        r19 = r19 + (r24 / 3.0f);
    L19:
        if (r19 != 0.0f) goto L21;
        return;
    L21:
        if (r19 == 1.0f) goto L34;
        int r111 = r17.f12775c;
        if (r111 != 3) goto L25;
        return;
    L25:
        if (r19 < 0.5d) goto L28;
        r5 = 1.0f;
    L28:
        r18.J(r111, r5, r24);
        return;
    L34:
        return;
    L14:
        r24 = (r15 * r22) / r23;
        goto L16
    L32:
        return;
    L31:
        return;
    L36:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r34) {
        MotionLayout r5 = this;
        d0 r10 = r5.f12676q;
        if (r10 == null) goto L382;
        if (r5.f12693z == false) goto L382;
        if (r10.o() == false) goto L382;
        d0 r11 = r5.f12676q;
        c0 r12 = r11.f12733c;
        if (r12 != null) goto L11;
    L14:
        int r13 = getCurrentState();
        RectF r14 = new RectF();
        x r15 = r11.f12741o;
        MotionLayout r16 = r11.f12731a;
        if (r15 != null) goto L17;
        r16.getClass();
        x r17 = x.f12913b;
        r17.f12914a = VelocityTracker.obtain();
        r11.f12741o = r17;
    L17:
        VelocityTracker r18 = r11.f12741o.f12914a;
        if (r18 == null) goto L21;
        r18.addMovement(r34);
    L21:
        if (r13 == (-1)) goto L111;
        int r19 = r34.getAction();
        if (r19 == 0) goto L96;
        if (r19 != 2) goto L111;
        if (r11.f12739m == true) goto L111;
        float r110 = r34.getRawY() - r11.s;
        float r111 = r34.getRawX() - r11.f12744r;
        if (r111 == 0.0d) goto L32;
    L33:
        MotionEvent r112 = r11.f12738l;
        if (r112 == null) goto L375;
        if (r13 == (-1)) goto L87;
        al.a r113 = r11.f12732b;
        if (r113 == null) goto L42;
        int r114 = r113.d(r13);
        if (r114 == (-1)) goto L42;
    L43:
        ArrayList r20 = new ArrayList();
        Iterator r115 = r11.d.iterator();
    L45:
        if (r115.hasNext() == false) goto L52;
        c0 r21 = (c0) r115.next();
        if (r21.d != r114) goto L49;
    L50:
        r20.add(r21);
        goto L45
    L49:
        if (r21.f12718c != r114) goto L45;
    L52:
        RectF r22 = new RectF();
        Iterator r23 = r20.iterator();
        float r24 = 0.0f;
        c0 r116 = null;
    L54:
        if (r23.hasNext() == false) goto L86;
        c0 r117 = (c0) r23.next();
        if (r117.f12726o == true) goto L57;
        g0 r25 = r117.f12723l;
        if (r25 == null) goto L83;
        r25.c(r11.f12742p);
        RectF r26 = r117.f12723l.b(r16, r22);
        if (r26 == null) goto L65;
        Iterator r118 = r23;
        if (r26.contains(r112.getX(), r112.getY()) == false) goto L70;
    L66:
        RectF r27 = r117.f12723l.a(r16, r22);
        if (r27 == null) goto L71;
        if (r27.contains(r112.getX(), r112.getY()) == false) goto L70;
    L71:
        g0 r28 = r117.f12723l;
        float r119 = (r28.f12780l * r110) + (r28.f12779k * r111);
        if (r28.f12778j == false) goto L76;
        float r29 = r112.getX();
        r117.f12723l.getClass();
        float r30 = r29 - 0.5f;
        float r120 = r112.getY();
        r117.f12723l.getClass();
        float r121 = r120 - 0.5f;
        r119 = ((float) (Math.atan2(r110 + r121, r111 + r30) - Math.atan2(r30, r121))) * 10.0f;
    L76:
        if (r117.f12718c != r13) goto L79;
        float r31 = -1.0f;
    L78:
        float r122 = r119 * r31;
        if (r122 <= r24) goto L84;
        r24 = r122;
        r116 = r117;
    L85:
        r23 = r118;
        r22 = r22;
        r110 = r110;
        r111 = r111;
        r14 = r14;
    L84:
        r116 = r116;
        goto L85
    L79:
        r31 = 1.1f;
    L70:
        r23 = r118;
        goto L54
    L65:
        r118 = r23;
        goto L66
    L83:
        r14 = r14;
        r118 = r23;
        r22 = r22;
        r116 = r116;
        r110 = r110;
        r111 = r111;
        goto L84
    L57:
        r118 = r23;
        goto L70
    L86:
        RectF r210 = r14;
    L88:
        if (r116 == null) goto L111;
        r5.setTransition(r116);
        RectF r32 = r11.f12733c.f12723l.b(r16, r210);
        if (r32 != null) goto L92;
    L94:
        boolean r33 = false;
    L95:
        r11.f12740n = r33;
        g0 r35 = r11.f12733c.f12723l;
        float r36 = r11.f12744r;
        float r37 = r11.s;
        r35.f12784p = r36;
        r35.f12785q = r37;
        r35.f12781m = false;
        goto L111
    L92:
        if (r32.contains(r11.f12738l.getX(), r11.f12738l.getY()) == true) goto L94;
        r33 = true;
    L42:
        r114 = r13;
        goto L43
    L87:
        r210 = r14;
        r116 = r11.f12733c;
    L375:
        c0 r38 = r5.f12676q.f12733c;
        if ((r38.f12729r & 4) != 0) goto L378;
        return true;
    L378:
        return r38.f12723l.f12781m;
    L32:
        if (r110 == 0.0d) goto L375;
    L96:
        r11.f12744r = r34.getRawX();
        r11.s = r34.getRawY();
        r11.f12738l = r34;
        r11.f12739m = false;
        g0 r39 = r11.f12733c.f12723l;
        if (r39 == null) goto L375;
        RectF r40 = r39.a(r16, r14);
        if (r40 != null) goto L101;
    L103:
        RectF r41 = r11.f12733c.f12723l.b(r16, r14);
        if (r41 != null) goto L106;
    L108:
        r11.f12740n = false;
    L109:
        g0 r42 = r11.f12733c.f12723l;
        float r43 = r11.f12744r;
        float r44 = r11.s;
        r42.f12784p = r43;
        r42.f12785q = r44;
        goto L375
    L106:
        if (r41.contains(r11.f12738l.getX(), r11.f12738l.getY()) == true) goto L108;
        r11.f12740n = true;
        goto L109
    L101:
        if (r40.contains(r11.f12738l.getX(), r11.f12738l.getY()) == true) goto L103;
        r11.f12738l = null;
        r11.f12739m = true;
    L111:
        if (r11.f12739m == true) goto L375;
        c0 r45 = r11.f12733c;
        if (r45 == null) goto L362;
        g0 r46 = r45.f12723l;
        if (r46 == null) goto L362;
        if (r11.f12740n == true) goto L362;
        x r47 = r11.f12741o;
        boolean r48 = r46.f12778j;
        float[] r49 = r46.f12782n;
        MotionLayout r123 = r46.f12786r;
        if (r48 == false) goto L242;
        VelocityTracker r50 = r47.f12914a;
        if (r50 == null) goto L124;
        r50.addMovement(r34);
    L124:
        int r51 = r34.getAction();
        if (r51 == 0) goto L241;
        int[] r52 = r46.f12783o;
        if (r51 != 1) goto L129;
        r11 = r11;
        r46.f12781m = false;
        VelocityTracker r53 = r47.f12914a;
        if (r53 == null) goto L185;
        r53.computeCurrentVelocity(16);
    L185:
        VelocityTracker r54 = r47.f12914a;
        if (r54 == null) goto L188;
        float r55 = r54.getXVelocity();
    L189:
        VelocityTracker r56 = r47.f12914a;
        if (r56 == null) goto L192;
        float r57 = r56.getYVelocity();
    L193:
        float r58 = r123.getProgress();
        float r59 = r123.getWidth() / 2.0f;
        float r60 = r123.getHeight() / 2.0f;
        int r124 = r46.f12777i;
        if (r124 == (-1)) goto L197;
        View r61 = r123.findViewById(r124);
        r123.getLocationOnScreen(r52);
        float r62 = r52[0] + ((r61.getRight() + r61.getLeft()) / 2.0f);
        float r63 = r52[1];
        int r125 = r61.getTop();
        int r64 = r61.getBottom();
    L196:
        float r65 = r63 + ((r64 + r125) / 2.0f);
        r59 = r62;
        r60 = r65;
    L200:
        float r66 = r34.getRawX() - r59;
        float r67 = r34.getRawY() - r60;
        double r126 = Math.toDegrees(Math.atan2(r67, r66));
        int r68 = r46.d;
        if (r68 == (-1)) goto L203;
        r46.f12786r.A(r68, r58, r46.f12776h, r46.g, r46.f12782n);
        r49[1] = (float) Math.toDegrees(r49[1]);
    L204:
        float r69 = ((float) (Math.toDegrees(Math.atan2(r57 + r67, r55 + r66)) - r126)) * 62.5f;
        if (Float.isNaN(r69) == true) goto L208;
        float r127 = (((r69 * 3.0f) * r46.f12789v) / r49[1]) + r58;
    L210:
        if (r127 == 0.0f) goto L237;
        if (r127 == 1.0f) goto L237;
        int r70 = r46.f12775c;
        if (r70 == 3) goto L237;
        float r71 = (r69 * r46.f12789v) / r49[1];
        if (r127 >= 0.5d) goto L219;
        float r72 = 0.0f;
    L220:
        if (r70 != 6) goto L226;
        if ((r58 + r71) >= 0.0f) goto L224;
        r71 = Math.abs(r71);
    L224:
        r72 = 1.0f;
    L226:
        if (r46.f12775c == 7) goto L228;
    L231:
        r123.J(r46.f12775c, r72, r71 * 3.0f);
        if (0.0f < r58) goto L234;
    L235:
        r123.setState(TransitionState.FINISHED);
    L363:
        d0 r73 = r11;
        r73.f12744r = r34.getRawX();
        r73.s = r34.getRawY();
        if (r34.getAction() != 1) goto L374;
        x r74 = r73.f12741o;
        if (r74 == null) goto L374;
        VelocityTracker r75 = r74.f12914a;
        if (r75 == null) goto L370;
        r75.recycle();
        x r76 = null;
        r74.f12914a = null;
    L371:
        r73.f12741o = r76;
        r5 = this;
        int r77 = r5.f12685v;
        if (r77 == (-1)) goto L375;
        r73.a(r77, r5);
        goto L375
    L370:
        r76 = null;
    L374:
        r5 = this;
        goto L375
    L234:
        if (1.0f > r58) goto L363;
    L228:
        if ((r58 + r71) <= 1.0f) goto L230;
        r71 = -Math.abs(r71);
    L230:
        r72 = 0.0f;
        goto L231
    L219:
        r72 = 1.0f;
    L237:
        if (0.0f < r127) goto L239;
    L240:
        r123.setState(TransitionState.FINISHED);
        goto L363
    L239:
        if (1.0f > r127) goto L363;
    L208:
        r127 = r58;
        goto L210
    L203:
        r49[1] = 360.0f;
        goto L204
    L197:
        int r128 = r46.d;
        if (r128 == (-1)) goto L200;
        View r78 = r123.findViewById(((q) r123.A.get(r123.findViewById(r128))).f.f12703k);
        r123.getLocationOnScreen(r52);
        r62 = r52[0] + ((r78.getRight() + r78.getLeft()) / 2.0f);
        r63 = r52[1];
        r125 = r78.getTop();
        r64 = r78.getBottom();
        goto L196
    L192:
        r57 = 0.0f;
        goto L193
    L188:
        r55 = 0.0f;
        goto L189
    L129:
        if (r51 != 2) goto L362;
        r34.getRawY();
        r34.getRawX();
        float r79 = r123.getWidth() / 2.0f;
        float r80 = r123.getHeight() / 2.0f;
        int r129 = r46.f12777i;
        if (r129 == (-1)) goto L134;
        View r81 = r123.findViewById(r129);
        r123.getLocationOnScreen(r52);
        float r82 = r52[0] + ((r81.getRight() + r81.getLeft()) / 2.0f);
        r80 = ((r81.getBottom() + r81.getTop()) / 2.0f) + r52[1];
        r79 = r82;
    L140:
        float r83 = r34.getRawX() - r79;
        float r130 = r34.getRawY() - r80;
        double r131 = Math.atan2(r34.getRawY() - r80, r34.getRawX() - r79);
        float r84 = (float) (((r131 - Math.atan2(r46.f12785q - r80, r46.f12784p - r79)) * 180.0d) / 3.141592653589793d);
        if (r84 <= 330.0f) goto L144;
        r84 = r84 - 360.0f;
    L147:
        if (Math.abs(r84) <= 0.01d) goto L149;
    L150:
        float r85 = r123.getProgress();
        if (r46.f12781m == true) goto L153;
        r46.f12781m = true;
        MotionLayout r132 = r123;
        r132.setProgress(r85);
    L154:
        int r133 = r46.d;
        if (r133 == (-1)) goto L157;
        r46.f12786r.A(r133, r85, r46.f12776h, r46.g, r46.f12782n);
        char r86 = 1;
        r49[1] = (float) Math.toDegrees(r49[1]);
    L158:
        float r87 = Math.max(Math.min(((r84 * r46.f12789v) / r49[r86]) + r85, 1.0f), 0.0f);
        float r88 = r132.getProgress();
        if (r87 != r88) goto L161;
        r132.f12681t = 0.0f;
    L181:
        r46.f12784p = r34.getRawX();
        r46.f12785q = r34.getRawY();
        goto L363
    L161:
        if (r88 != 0.0f) goto L163;
    L164:
        if (r88 != 0.0f) goto L166;
        boolean r89 = true;
    L167:
        r132.w(r89);
    L168:
        r132.setProgress(r87);
        VelocityTracker r90 = r47.f12914a;
        if (r90 == null) goto L171;
        r90.computeCurrentVelocity(1000);
    L171:
        VelocityTracker r91 = r47.f12914a;
        if (r91 == null) goto L174;
        float r92 = r91.getXVelocity();
    L175:
        VelocityTracker r93 = r47.f12914a;
        if (r93 == null) goto L178;
        float r94 = r93.getYVelocity();
    L179:
        double r95 = r94;
        double r96 = r92;
        r132.f12681t = (float) Math.toDegrees((float) ((Math.sin(Math.atan2(r95, r96) - r131) * Math.hypot(r95, r96)) / Math.hypot(r83, r130)));
        goto L181
    L178:
        r94 = 0.0f;
        goto L179
    L174:
        r92 = 0.0f;
        goto L175
    L166:
        r89 = false;
        goto L167
    L163:
        if (r88 != 1.0f) goto L168;
    L157:
        r86 = 1;
        r49[1] = 360.0f;
        goto L158
    L153:
        r132 = r123;
        goto L154
    L149:
        if (r46.f12781m == false) goto L362;
    L144:
        if (r84 >= (-330.0f)) goto L147;
        r84 = r84 + 360.0f;
        goto L147
    L134:
        int r134 = r46.d;
        if (r134 == (-1)) goto L140;
        View r135 = r123.findViewById(((q) r123.A.get(r123.findViewById(r134))).f.f12703k);
        if (r135 != null) goto L139;
        Log.e("TouchResponse", "could not find view to animate to");
        goto L140
    L139:
        r123.getLocationOnScreen(r52);
        r79 = r52[0] + ((r135.getRight() + r135.getLeft()) / 2.0f);
        r80 = ((r135.getBottom() + r135.getTop()) / 2.0f) + r52[1];
        goto L140
    L241:
        r11 = r11;
        r46.f12784p = r34.getRawX();
        r46.f12785q = r34.getRawY();
        r46.f12781m = false;
        goto L363
    L242:
        r11 = r11;
        VelocityTracker r97 = r47.f12914a;
        if (r97 == null) goto L245;
        r97.addMovement(r34);
    L245:
        int r98 = r34.getAction();
        if (r98 != 0) goto L248;
        r46.f12784p = r34.getRawX();
        r46.f12785q = r34.getRawY();
        r46.f12781m = false;
        goto L363
    L248:
        if (r98 != 1) goto L250;
        r46.f12781m = false;
        VelocityTracker r99 = r47.f12914a;
        if (r99 == null) goto L308;
        r99.computeCurrentVelocity(1000);
    L308:
        VelocityTracker r100 = r47.f12914a;
        if (r100 == null) goto L311;
        float r101 = r100.getXVelocity();
    L312:
        VelocityTracker r102 = r47.f12914a;
        if (r102 == null) goto L315;
        float r103 = r102.getYVelocity();
    L316:
        float r104 = r123.getProgress();
        int r105 = r46.d;
        if (r105 == (-1)) goto L319;
        r46.f12786r.A(r105, r104, r46.f12776h, r46.g, r46.f12782n);
        char r106 = 0;
        char r107 = 1;
    L320:
        float r108 = r46.f12779k;
        float r109 = r49[r106];
        float r136 = r49[r107];
        if (r108 == 0.0f) goto L323;
        float r137 = r101 / r109;
    L325:
        if (Float.isNaN(r137) == true) goto L328;
        float r138 = (r137 / 3.0f) + r104;
    L330:
        if (r138 == 0.0f) goto L357;
        if (r138 == 1.0f) goto L357;
        int r139 = r46.f12775c;
        if (r139 == 3) goto L357;
        if (r138 >= 0.5d) goto L339;
        float r140 = 0.0f;
    L340:
        if (r139 != 6) goto L346;
        if ((r104 + r137) >= 0.0f) goto L344;
        r137 = Math.abs(r137);
    L344:
        r140 = 1.0f;
    L346:
        if (r46.f12775c == 7) goto L348;
    L351:
        r123.J(r46.f12775c, r140, r137);
        if (0.0f < r104) goto L354;
    L355:
        r123.setState(TransitionState.FINISHED);
        goto L363
    L354:
        if (1.0f > r104) goto L363;
    L348:
        if ((r104 + r137) <= 1.0f) goto L350;
        r137 = -Math.abs(r137);
    L350:
        r140 = 0.0f;
        goto L351
    L339:
        r140 = 1.0f;
    L357:
        if (0.0f < r138) goto L359;
    L360:
        r123.setState(TransitionState.FINISHED);
        goto L363
    L359:
        if (1.0f > r138) goto L363;
    L328:
        r138 = r104;
        goto L330
    L323:
        r137 = r103 / r136;
        goto L325
    L319:
        float r141 = Math.min(r123.getWidth(), r123.getHeight());
        r107 = 1;
        r49[1] = r46.f12780l * r141;
        r106 = 0;
        r49[0] = r141 * r46.f12779k;
        goto L320
    L315:
        r103 = 0.0f;
        goto L316
    L311:
        r101 = 0.0f;
        goto L312
    L250:
        if (r98 != 2) goto L363;
        float r142 = r34.getRawY() - r46.f12785q;
        float r143 = r34.getRawX() - r46.f12784p;
        if (Math.abs((r46.f12780l * r142) + (r46.f12779k * r143)) <= r46.f12791x) goto L255;
    L256:
        float r144 = r123.getProgress();
        if (r46.f12781m == true) goto L259;
        r46.f12781m = true;
        r123.setProgress(r144);
    L259:
        int r145 = r46.d;
        if (r145 == (-1)) goto L262;
        r46.f12786r.A(r145, r144, r46.f12776h, r46.g, r46.f12782n);
        char r146 = 0;
        char r147 = 1;
    L264:
        if (Math.abs(((r46.f12780l * r49[r147]) + (r46.f12779k * r49[r146])) * r46.f12789v) >= 0.01d) goto L266;
        char r148 = 0;
        r49[0] = 0.01f;
        r49[r147] = 0.01f;
    L268:
        if (r46.f12779k == 0.0f) goto L270;
        float r149 = r143 / r49[r148];
    L271:
        float r150 = Math.max(Math.min(r144 + r149, 1.0f), 0.0f);
        if (r46.f12775c != 6) goto L275;
        r150 = Math.max(r150, 0.01f);
    L275:
        if (r46.f12775c != 7) goto L277;
        r150 = Math.min(r150, 0.99f);
    L277:
        float r151 = r123.getProgress();
        if (r150 != r151) goto L280;
        r123.f12681t = 0.0f;
    L304:
        r46.f12784p = r34.getRawX();
        r46.f12785q = r34.getRawY();
        goto L363
    L280:
        if (r151 != 0.0f) goto L282;
    L283:
        if (r151 != 0.0f) goto L285;
        boolean r152 = true;
    L286:
        r123.w(r152);
    L287:
        r123.setProgress(r150);
        VelocityTracker r153 = r47.f12914a;
        if (r153 == null) goto L290;
        r153.computeCurrentVelocity(1000);
    L290:
        VelocityTracker r154 = r47.f12914a;
        if (r154 == null) goto L293;
        float r155 = r154.getXVelocity();
    L294:
        VelocityTracker r156 = r47.f12914a;
        if (r156 == null) goto L297;
        float r157 = r156.getYVelocity();
    L299:
        if (r46.f12779k == 0.0f) goto L301;
        float r158 = r155 / r49[0];
    L302:
        r123.f12681t = r158;
        goto L304
    L301:
        r158 = r157 / r49[1];
        goto L302
    L297:
        r157 = 0.0f;
        goto L299
    L293:
        r155 = 0.0f;
        goto L294
    L285:
        r152 = false;
        goto L286
    L282:
        if (r151 != 1.0f) goto L287;
    L270:
        r149 = r142 / r49[r147];
        goto L271
    L266:
        r148 = 0;
        goto L268
    L262:
        float r159 = Math.min(r123.getWidth(), r123.getHeight());
        r147 = 1;
        r49[1] = r46.f12780l * r159;
        r146 = 0;
        r49[0] = r159 * r46.f12779k;
        goto L264
    L255:
        if (r46.f12781m == false) goto L363;
    L362:
        r11 = r11;
        goto L363
    L11:
        if (r12.f12726o == false) goto L14;
        return super.onTouchEvent(r34);
    L382:
        return super.onTouchEvent(r34);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View r5) {
        super.onViewAdded(r5);
        if ((r5 instanceof MotionHelper) == false) goto L26;
        MotionHelper r10 = (MotionHelper) r5;
        if (this.f12667e0 != null) goto L7;
        this.f12667e0 = new CopyOnWriteArrayList();
    L7:
        this.f12667e0.add(r10);
        if (r10.f12659j == false) goto L14;
        if (this.f12664b0 != null) goto L12;
        this.f12664b0 = new ArrayList();
    L12:
        this.f12664b0.add(r10);
    L14:
        if (r10.f12660k == false) goto L20;
        if (this.f12665c0 != null) goto L18;
        this.f12665c0 = new ArrayList();
    L18:
        this.f12665c0.add(r10);
    L20:
        if ((r10 instanceof MotionEffect) == true) goto L22;
        return;
    L22:
        if (this.f12666d0 != null) goto L24;
        this.f12666d0 = new ArrayList();
    L24:
        this.f12666d0.add(r10);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        ArrayList r10 = this.f12664b0;
        if (r10 == null) goto L5;
        r10.remove(r5);
    L5:
        ArrayList r11 = this.f12665c0;
        if (r11 == null) goto L9;
        r11.remove(r5);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public final void q(int r5) {
        this.f12996k = null;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f12671k0 == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.f12685v != (-1)) goto L19;
        d0 r5 = this.f12676q;
        if (r5 == null) goto L19;
        c0 r10 = r5.f12733c;
        if (r10 == null) goto L19;
        int r11 = r10.f12728q;
        if (r11 != 0) goto L14;
        return;
    L14:
        if (r11 != 2) goto L19;
        int r12 = getChildCount();
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L18;
        View r14 = getChildAt(r13);
        ((q) this.A.get(r14)).d = true;
        r13 = r13 + 1;
        goto L16
    }

    public void setDebugMode(int r5) {
        this.K = r5;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r5) {
        this.f12690x0 = r5;
    }

    public void setInteractionEnabled(boolean r5) {
        this.f12693z = r5;
    }

    public void setInterpolatedProgress(float r5) {
        if (this.f12676q == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r10 = this.f12676q.e();
        if (r10 == null) goto L8;
        setProgress(r10.getInterpolation(r5));
        return;
    L8:
        setProgress(r5);
    }

    public void setOnHide(float r5) {
        ArrayList r10 = this.f12665c0;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((MotionHelper) this.f12665c0.get(r12)).setProgress(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r5) {
        ArrayList r10 = this.f12664b0;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((MotionHelper) this.f12664b0.get(r12)).setProgress(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r10) {
        if (r10 >= 0.0f) goto L5;
    L6:
        Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r10 > 0.0f) goto L24;
        if (this.E == 1.0f) goto L18;
    L20:
        this.f12685v = this.f12683u;
        if (this.E != 0.0f) goto L35;
        setState(TransitionState.FINISHED);
    L35:
        if (this.f12676q != null) goto L37;
        return;
    L37:
        this.H = true;
        this.G = r10;
        this.D = r10;
        this.F = -1;
        this.B = -1;
        this.f12678r = null;
        this.I = true;
        invalidate();
        return;
    L18:
        if (this.f12685v != this.f12687w) goto L20;
        setState(TransitionState.MOVING);
        goto L20
    L24:
        if (r10 >= 1.0f) goto L26;
        this.f12685v = -1;
        setState(TransitionState.MOVING);
        goto L35
    L26:
        if (this.E == 0.0f) goto L28;
    L30:
        this.f12685v = this.f12687w;
        if (this.E != 1.0f) goto L35;
        setState(TransitionState.FINISHED);
        goto L35
    L28:
        if (this.f12685v != this.f12683u) goto L30;
        setState(TransitionState.MOVING);
        goto L30
    L10:
        if (this.f12684u0 != null) goto L12;
        this.f12684u0 = new y(this);
    L12:
        this.f12684u0.f12915a = r10;
        return;
    L5:
        if (r10 <= 1.0f) goto L8;
        goto L6
    }

    public void setScene(d0 r5) {
        this.f12676q = r5;
        boolean r10 = p();
        r5.f12742p = r10;
        c0 r11 = r5.f12733c;
        if (r11 == null) goto L7;
        g0 r12 = r11.f12723l;
        if (r12 == null) goto L7;
        r12.c(r10);
    L7:
        G();
    }

    public void setStartState(int r5) {
        if (isAttachedToWindow() == false) goto L5;
        this.f12685v = r5;
        return;
    L5:
        if (this.f12684u0 != null) goto L7;
        this.f12684u0 = new y(this);
    L7:
        y r10 = this.f12684u0;
        r10.f12917c = r5;
        r10.d = r5;
    }

    public void setState(TransitionState r5) {
        TransitionState r10 = TransitionState.FINISHED;
        if (r5 == r10) goto L5;
    L7:
        TransitionState r11 = this.f12692y0;
        this.f12692y0 = r5;
        TransitionState r12 = TransitionState.MOVING;
        if (r11 != r12) goto L11;
        if (r5 != r12) goto L11;
        y();
    L11:
        int r13 = t.f12896a[r11.ordinal()];
        if (r13 != 1) goto L14;
    L20:
        if (r5 != r12) goto L22;
        y();
    L22:
        if (r5 != r10) goto L27;
        z();
        return;
    L27:
        return;
    L14:
        if (r13 == 2) goto L20;
        if (r13 != 3) goto L28;
        if (r5 != r10) goto L25;
        z();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.f12685v != (-1)) goto L7;
    }

    public void setTransition(int r10) {
        if (this.f12676q == null) goto L38;
        c0 r11 = B(r10);
        this.f12683u = r11.d;
        this.f12687w = r11.f12718c;
        if (isAttachedToWindow() == false) goto L7;
        int r5 = this.f12685v;
        if (r5 != this.f12683u) goto L15;
        float r12 = 0.0f;
    L18:
        d0 r13 = this.f12676q;
        r13.f12733c = r11;
        g0 r14 = r11.f12723l;
        if (r14 == null) goto L21;
        r14.c(r13.f12742p);
    L21:
        this.f12694z0.e(this.f12676q.b(this.f12683u), this.f12676q.b(this.f12687w));
        G();
        if (this.E == r12) goto L30;
        if (r12 != 0.0f) goto L27;
        w(true);
        this.f12676q.b(this.f12683u).b(this);
        goto L30
    L27:
        if (r12 != 1.0f) goto L30;
        w(false);
        this.f12676q.b(this.f12687w).b(this);
    L30:
        if (Float.isNaN(r12) == false) goto L32;
        float r15 = 0.0f;
    L33:
        this.E = r15;
        if (Float.isNaN(r12) == false) goto L36;
        Log.v("MotionLayout", ym.k.f() + " transitionToStart ");
        v(0.0f);
        return;
    L36:
        setProgress(r12);
        return;
    L32:
        r15 = r12;
        goto L33
    L15:
        if (r5 != this.f12687w) goto L17;
        r12 = 1.0f;
        goto L18
    L17:
        r12 = Float.NaN;
        goto L18
    L7:
        if (this.f12684u0 != null) goto L9;
        this.f12684u0 = new y(this);
    L9:
        y r16 = this.f12684u0;
        r16.f12917c = this.f12683u;
        r16.d = this.f12687w;
        return;
    }

    public void setTransitionDuration(int r5) {
        d0 r10 = this.f12676q;
        if (r10 != null) goto L6;
        Log.e("MotionLayout", "MotionScene not defined");
        return;
    L6:
        c0 r11 = r10.f12733c;
        if (r11 == null) goto L9;
        r11.f12719h = Math.max(r5, 8);
        return;
    L9:
        r10.f12736j = r5;
    }

    public void setTransitionListener(z r5) {
        this.J = r5;
    }

    public void setTransitionState(Bundle r5) {
        if (this.f12684u0 != null) goto L5;
        this.f12684u0 = new y(this);
    L5:
        y r10 = this.f12684u0;
        r10.getClass();
        r10.f12915a = r5.getFloat("motion.progress");
        r10.f12916b = r5.getFloat("motion.velocity");
        r10.f12917c = r5.getInt("motion.StartState");
        r10.d = r5.getInt("motion.EndState");
        if (isAttachedToWindow() == false) goto L9;
        this.f12684u0.a();
        return;
    }

    @Override // android.view.View
    public final String toString() {
        Context r5 = getContext();
        return ym.k.g(r5, this.f12683u) + "->" + ym.k.g(r5, this.f12687w) + " (pos:" + this.E + " Dpos/Dt:" + this.f12681t;
    }

    public final void v(float r5) {
        d0 r10 = this.f12676q;
        if (r10 != null) goto L5;
        return;
    L5:
        float r11 = this.E;
        float r12 = this.D;
        if (r11 != r12) goto L8;
    L10:
        float r13 = this.E;
        if (r13 != r5) goto L13;
        return;
    L13:
        this.M = false;
        this.G = r5;
        this.C = r10.c() / 1000.0f;
        setProgress(this.G);
        this.f12678r = null;
        this.s = this.f12676q.e();
        this.H = false;
        this.B = getNanoTime();
        this.I = true;
        this.D = r13;
        this.E = r13;
        invalidate();
        return;
    L8:
        if (this.H == false) goto L10;
        this.E = r12;
        goto L10
    }

    public final void w(boolean r10) {
        int r5 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L19;
        q r12 = (q) this.A.get(getChildAt(r11));
        if (r12 == null) goto L18;
        if ("button".equals(ym.k.h(r12.f12874b)) == false) goto L18;
        if (r12.A == null) goto L18;
        int r13 = 0;
    L11:
        n[] r14 = r12.A;
        if (r13 >= r14.length) goto L18;
        n r15 = r14[r13];
        if (r10 == false) goto L16;
        float r16 = -100.0f;
    L17:
        r15.h(r16, r12.f12874b);
        r13 = r13 + 1;
        goto L11
    L16:
        r16 = 100.0f;
    L18:
        r11 = r11 + 1;
        goto L3
    }

    public final void x(boolean r21) {
        if (this.F != (-1)) goto L5;
        this.F = getNanoTime();
    L5:
        float r5 = this.E;
        if (r5 > 0.0f) goto L8;
    L10:
        boolean r10 = true;
        boolean r11 = false;
        if (this.f12663a0 == false) goto L13;
    L17:
        float r12 = Math.signum(this.G - r5);
        long r13 = getNanoTime();
        r r14 = this.f12678r;
        if (r14 != null) goto L20;
        float r15 = (((r13 - this.F) * r12) * 1.0E-9f) / this.C;
    L21:
        float r16 = this.E + r15;
        if (this.H == false) goto L25;
        r16 = this.G;
    L25:
        if (r12 <= 0.0f) goto L29;
        if (r16 < this.G) goto L29;
    L32:
        r16 = this.G;
        this.I = false;
        boolean r17 = true;
    L34:
        this.E = r16;
        this.D = r16;
        this.F = r13;
        if (r14 == null) goto L69;
        if (r17 == true) goto L69;
        if (this.M == false) goto L63;
        float r18 = r14.getInterpolation((r13 - this.B) * 1.0E-9f);
        r r19 = this.f12678r;
        jr.b r110 = this.N;
        if (r19 == r110) goto L42;
        char r111 = 0;
    L46:
        this.E = r18;
        this.F = r13;
        r r20 = this.f12678r;
        if (r20 == null) goto L62;
        float r22 = r20.a();
        this.f12681t = r22;
        if ((Math.abs(r22) * this.C) > 1.0E-5f) goto L53;
        if (r111 != 2) goto L53;
        this.I = false;
    L53:
        if (r22 <= 0.0f) goto L58;
        if (r18 < 1.0f) goto L58;
        this.E = 1.0f;
        this.I = false;
        r18 = 1.0f;
    L58:
        if (r22 >= 0.0f) goto L62;
        if (r18 > 0.0f) goto L62;
        this.E = 0.0f;
        this.I = false;
        r16 = 0.0f;
    L71:
        if (Math.abs(this.f12681t) <= 1.0E-5f) goto L73;
        setState(TransitionState.MOVING);
    L73:
        if (r111 == 1) goto L87;
        if (r12 <= 0.0f) goto L78;
        if (r16 < this.G) goto L78;
    L81:
        r16 = this.G;
        this.I = false;
    L83:
        if (r16 < 1.0f) goto L85;
    L86:
        this.I = false;
        setState(TransitionState.FINISHED);
        goto L87
    L85:
        if (r16 > 0.0f) goto L87;
    L78:
        if (r12 > 0.0f) goto L83;
        if (r16 > this.G) goto L83;
    L87:
        int r23 = getChildCount();
        this.f12663a0 = false;
        long r24 = getNanoTime();
        this.f12679r0 = r16;
        Interpolator r112 = this.s;
        if (r112 != null) goto L90;
        float r113 = r16;
    L91:
        Interpolator r114 = this.s;
        if (r114 == null) goto L94;
        float r115 = r114.getInterpolation((r12 / this.C) + r16);
        this.f12681t = r115;
        this.f12681t = r115 - this.s.getInterpolation(r16);
    L94:
        int r116 = 0;
    L95:
        if (r116 >= r23) goto L100;
        View r117 = getChildAt(r116);
        q r118 = (q) this.A.get(r117);
        if (r118 == null) goto L99;
        this.f12663a0 = r118.f(r113, r24, r117, this.f12680s0) | this.f12663a0;
    L99:
        r116 = r116 + 1;
        goto L95
    L100:
        if (r12 <= 0.0f) goto L104;
        if (r16 < this.G) goto L104;
    L107:
        boolean r25 = true;
    L110:
        if (this.f12663a0 == true) goto L116;
        if (this.I == true) goto L116;
        if (r25 == false) goto L116;
        setState(TransitionState.FINISHED);
    L116:
        if (this.f12671k0 == false) goto L118;
        requestLayout();
    L118:
        this.f12663a0 = (!r25) | this.f12663a0;
        if (r16 > 0.0f) goto L125;
        int r26 = this.f12683u;
        if (r26 == (-1)) goto L125;
        if (this.f12685v == r26) goto L125;
        this.f12685v = r26;
        this.f12676q.b(r26).a(this);
        setState(TransitionState.FINISHED);
        r11 = true;
    L127:
        if (r16 < 1.0d) goto L132;
        int r27 = this.f12685v;
        int r28 = this.f12687w;
        if (r27 == r28) goto L132;
        this.f12685v = r28;
        this.f12676q.b(r28).a(this);
        setState(TransitionState.FINISHED);
        r11 = true;
    L132:
        if (this.f12663a0 == false) goto L134;
    L144:
        invalidate();
    L146:
        if (this.f12663a0 == false) goto L148;
    L157:
        float r29 = this.E;
        if (r29 < 1.0f) goto L166;
        int r30 = this.f12685v;
        int r31 = this.f12687w;
        if (r30 != r31) goto L163;
        r10 = r11;
    L163:
        this.f12685v = r31;
    L164:
        r11 = r10;
    L172:
        this.A0 |= r11;
        if (r11 == true) goto L175;
    L177:
        this.D = this.E;
        return;
    L175:
        if (this.f12682t0 == true) goto L177;
        requestLayout();
        goto L177
    L166:
        if (r29 > 0.0f) goto L172;
        int r32 = this.f12685v;
        int r33 = this.f12683u;
        if (r32 != r33) goto L171;
        r10 = r11;
    L171:
        this.f12685v = r33;
        goto L164
    L148:
        if (this.I == true) goto L157;
        if (r12 <= 0.0f) goto L153;
        if (r16 != 1.0f) goto L153;
    L156:
        E();
    L153:
        if (r12 >= 0.0f) goto L157;
        if (r16 != 0.0f) goto L157;
    L134:
        if (this.I == true) goto L144;
        if (r12 <= 0.0f) goto L140;
        if (r16 != 1.0f) goto L140;
    L143:
        setState(TransitionState.FINISHED);
    L140:
        if (r12 >= 0.0f) goto L146;
        if (r16 != 0.0f) goto L146;
    L125:
        r11 = false;
    L104:
        if (r12 <= 0.0f) goto L106;
    L108:
        r25 = false;
        goto L110
    L106:
        if (r16 > this.G) goto L108;
    L90:
        r113 = r112.getInterpolation(r16);
    L62:
        r16 = r18;
        goto L71
    L42:
        if (r110.f18433c.b() == false) goto L44;
        r111 = 2;
        goto L46
    L44:
        r111 = 1;
        goto L46
    L63:
        float r34 = r14.getInterpolation(r16);
        r r35 = this.f12678r;
        if (r35 == null) goto L66;
        this.f12681t = r35.a();
    L67:
        r16 = r34;
    L68:
        r111 = 0;
        goto L71
    L66:
        this.f12681t = ((r35.getInterpolation(r16 + r15) - r34) * r12) / r15;
    L69:
        this.f12681t = r15;
    L29:
        if (r12 <= 0.0f) goto L31;
    L33:
        r17 = false;
        goto L34
    L31:
        if (r16 > this.G) goto L33;
    L20:
        r15 = 0.0f;
        goto L21
    L13:
        if (this.I == false) goto L157;
        if (r21 == true) goto L17;
        if (this.G == r5) goto L157;
    L8:
        if (r5 >= 1.0f) goto L10;
        this.f12685v = -1;
        goto L10
    }

    public final void y() {
        if (this.J != null) goto L9;
        CopyOnWriteArrayList r5 = this.f12667e0;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f12670j0 != this.D) goto L11;
        return;
    L11:
        if (this.i0 == (-1)) goto L18;
        CopyOnWriteArrayList r10 = this.f12667e0;
        if (r10 == null) goto L18;
        Iterator r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        ((z) r11.next()).getClass();
    L18:
        this.i0 = -1;
        this.f12670j0 = this.D;
        CopyOnWriteArrayList r12 = this.f12667e0;
        if (r12 == null) goto L29;
        Iterator r13 = r12.iterator();
    L22:
        if (r13.hasNext() == false) goto L30;
        ((z) r13.next()).getClass();
        goto L22
    L30:
        return;
    }

    public final void z() {
        if (this.J != null) goto L9;
        CopyOnWriteArrayList r5 = this.f12667e0;
        if (r5 != null) goto L7;
    L18:
        F();
        a2.b r10 = this.f12686v0;
        if (r10 == null) goto L22;
        r10.run();
        this.f12686v0 = null;
        return;
    L22:
        return;
    L7:
        if (r5.isEmpty() == true) goto L18;
    L9:
        if (this.i0 != (-1)) goto L18;
        this.i0 = this.f12685v;
        ArrayList r11 = this.E0;
        if (r11.isEmpty() == true) goto L13;
        int r12 = ((Integer) androidx.constraintlayout.motion.widget.a.h(r11, 1)).intValue();
    L14:
        int r13 = this.f12685v;
        if (r12 == r13) goto L18;
        if (r13 == (-1)) goto L18;
        r11.add(Integer.valueOf(r13));
        goto L18
    L13:
        r12 = -1;
        goto L14
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        if (this.S == true) goto L6;
        if (r10 != 0) goto L6;
        if (r11 != 0) goto L6;
    L7:
        this.S = false;
        return;
    L6:
        r15[0] = r15[0] + r12;
        r15[1] = r15[1] + r13;
        goto L7
    }

    public void setTransition(c0 r5) {
        d0 r10 = this.f12676q;
        r10.f12733c = r5;
        if (r5 == null) goto L7;
        g0 r11 = r5.f12723l;
        if (r11 == null) goto L7;
        r11.c(r10.f12742p);
    L7:
        setState(TransitionState.SETUP);
        int r12 = this.f12685v;
        c0 r13 = this.f12676q.f12733c;
        int r14 = -1;
        if (r13 != null) goto L10;
        int r15 = -1;
    L11:
        if (r12 != r15) goto L13;
        this.E = 1.0f;
        this.D = 1.0f;
        this.G = 1.0f;
    L15:
        if ((r5.f12729r & 1) == 0) goto L17;
        long r16 = -1;
    L18:
        this.F = r16;
        int r17 = this.f12676q.h();
        d0 r18 = this.f12676q;
        c0 r19 = r18.f12733c;
        if (r19 == null) goto L23;
        r14 = r19.f12718c;
    L23:
        if (r17 == this.f12683u) goto L25;
    L27:
        this.f12683u = r17;
        this.f12687w = r14;
        r18.n(r17, r14);
        com.obric.oui.constraintlayout.widget.d r20 = this.f12676q.b(this.f12683u);
        com.obric.oui.constraintlayout.widget.d r21 = this.f12676q.b(this.f12687w);
        w r22 = this.f12694z0;
        r22.e(r20, r21);
        int r23 = this.f12683u;
        int r24 = this.f12687w;
        r22.e = r23;
        r22.f = r24;
        r22.f();
        G();
        return;
    L25:
        if (r14 != this.f12687w) goto L27;
        return;
    L17:
        r16 = getNanoTime();
        goto L18
    L13:
        this.E = 0.0f;
        this.D = 0.0f;
        this.G = 0.0f;
        goto L15
    L10:
        r15 = r13.f12718c;
        goto L11
    }

    public MotionLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.s = null;
        this.f12681t = 0.0f;
        this.f12683u = -1;
        this.f12685v = -1;
        this.f12687w = -1;
        this.f12689x = 0;
        this.f12691y = 0;
        this.f12693z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new jr.b();
        this.O = new u(this);
        this.S = false;
        this.f12663a0 = false;
        this.f12664b0 = null;
        this.f12665c0 = null;
        this.f12666d0 = null;
        this.f12667e0 = null;
        this.f12668f0 = 0;
        this.g0 = -1;
        this.f12669h0 = 0.0f;
        this.i0 = 0;
        this.f12670j0 = 0.0f;
        this.f12671k0 = false;
        this.f12680s0 = new gr.e(1);
        this.f12682t0 = false;
        this.f12686v0 = null;
        new HashMap();
        this.f12688w0 = new Rect();
        this.f12690x0 = false;
        this.f12692y0 = TransitionState.UNDEFINED;
        this.f12694z0 = new w(this);
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList();
        D(r10);
    }

    public MotionLayout(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.s = null;
        this.f12681t = 0.0f;
        this.f12683u = -1;
        this.f12685v = -1;
        this.f12687w = -1;
        this.f12689x = 0;
        this.f12691y = 0;
        this.f12693z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new jr.b();
        this.O = new u(this);
        this.S = false;
        this.f12663a0 = false;
        this.f12664b0 = null;
        this.f12665c0 = null;
        this.f12666d0 = null;
        this.f12667e0 = null;
        this.f12668f0 = 0;
        this.g0 = -1;
        this.f12669h0 = 0.0f;
        this.i0 = 0;
        this.f12670j0 = 0.0f;
        this.f12671k0 = false;
        this.f12680s0 = new gr.e(1);
        this.f12682t0 = false;
        this.f12686v0 = null;
        new HashMap();
        this.f12688w0 = new Rect();
        this.f12690x0 = false;
        this.f12692y0 = TransitionState.UNDEFINED;
        this.f12694z0 = new w(this);
        this.A0 = false;
        this.B0 = new RectF();
        this.C0 = null;
        this.D0 = null;
        this.E0 = new ArrayList();
        D(r10);
    }
}
