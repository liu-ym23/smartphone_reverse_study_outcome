package u;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import j0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ConstraintLayout implements o {
    public static final /* synthetic */ int U = 0;
    public float A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public long G;
    public float H;
    public c I;
    public u.b J;
    public boolean K;
    public ArrayList<u.c> L;
    public ArrayList<u.c> M;
    public CopyOnWriteArrayList<c> N;
    public int O;
    public float P;
    public boolean Q;
    public b R;
    public boolean S;
    public EnumC0168d T;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f12406a;

        public a(d r8) {
            this.f12406a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12406a.R.a();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f12407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f12408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f12411e;

        public b(d r8) {
            this.f12411e = r8;
            this.f12407a = Float.NaN;
            this.f12408b = Float.NaN;
            this.f12409c = -1;
            this.f12410d = -1;
        }

        public final void a() {
            int r8 = this.f12409c;
            d r10 = this.f12411e;
            if (r8 == (-1)) goto L5;
        L6:
            androidx.constraintlayout.widget.d r11 = null;
            if (r8 != (-1)) goto L34;
            int r12 = this.f12410d;
            if (r10.isAttachedToWindow() == false) goto L11;
            int r13 = r10.C;
            if (r13 != r12) goto L18;
        L91:
            r10.setState(EnumC0168d.f12412a);
        L93:
            if (Float.isNaN(this.f12408b) == true) goto L95;
            float r14 = this.f12407a;
            float r15 = this.f12408b;
            if (r10.isAttachedToWindow() == false) goto L102;
            r10.setProgress(r14);
            r10.setState(EnumC0168d.f12413b);
            r10.A = r15;
        L106:
            this.f12407a = Float.NaN;
            this.f12408b = Float.NaN;
            this.f12409c = -1;
            this.f12410d = -1;
            return;
        L102:
            if (r10.R != null) goto L104;
            r10.R = new b(r10);
        L104:
            b r16 = r10.R;
            r16.f12407a = r14;
            r16.f12408b = r15;
            goto L106
        L95:
            if (Float.isNaN(this.f12407a) == false) goto L97;
            return;
        L97:
            r10.setProgress(this.f12407a);
            return;
        L18:
            if (r10.B == r12) goto L91;
            if (r10.D == r12) goto L91;
            r10.D = r12;
            if (r13 != (-1)) goto L26;
            r10.H = 1.0f;
            r10.E = 0.0f;
            r10.F = 0.0f;
            r10.G = r10.getNanoTime();
            r10.getNanoTime();
            throw null;
        L26:
            if (r10.isAttachedToWindow() == false) goto L28;
        L31:
            r10.F = 0.0f;
            goto L91
        L28:
            if (r10.R != null) goto L30;
            r10.R = new b(r10);
        L30:
            b r17 = r10.R;
            r17.f12409c = r13;
            r17.f12410d = r12;
            goto L31
        L11:
            if (r10.R != null) goto L13;
            r10.R = new b(r10);
        L13:
            r10.R.f12410d = r12;
            goto L91
        L34:
            int r18 = this.f12410d;
            if (r18 != (-1)) goto L86;
            r10.getClass();
            r10.setState(EnumC0168d.f12412a);
            r10.C = r8;
            r10.B = -1;
            r10.D = -1;
            v.a r19 = r10.f1353u;
            if (r19 == null) goto L91;
            float r20 = -1;
            int r21 = r19.f12641b;
            SparseArray<v.a.C0177a> r22 = r19.f12643d;
            int r23 = 0;
            if (r21 != r8) goto L67;
            if (r8 != (-1)) goto L42;
            v.a.C0177a r24 = r22.valueAt(0);
        L43:
            v.a.C0177a r25 = r24;
            int r26 = r19.f12642c;
            if (r26 == (-1)) goto L48;
            if (r25.f12646b.get(r26).a(r20, r20) == true) goto L91;
        L48:
            ArrayList<v.a.b> r27 = r25.f12646b;
            if (r23 >= r27.size()) goto L54;
            if (r27.get(r23).a(r20, r20) == true) goto L56;
            r23 = r23 + 1;
        L56:
            if (r19.f12642c == r23) goto L91;
            ArrayList<v.a.b> r28 = r25.f12646b;
            if (r23 == (-1)) goto L62;
            r11 = r28.get(r23).f12654f;
        L62:
            if (r23 == (-1)) goto L65;
            int r29 = r28.get(r23).f12653e;
        L65:
            if (r11 == null) goto L91;
        L84:
            r19.f12642c = r23;
            r11.a(r19.f12640a);
            goto L91
        L54:
            r23 = -1;
            goto L56
        L42:
            r24 = r22.get(r21);
            goto L43
        L67:
            r19.f12641b = r8;
            v.a.C0177a r30 = r22.get(r8);
        L68:
            ArrayList<v.a.b> r31 = r30.f12646b;
            if (r23 >= r31.size()) goto L74;
            if (r31.get(r23).a(r20, r20) == true) goto L75;
            r23 = r23 + 1;
        L75:
            ArrayList<v.a.b> r32 = r30.f12646b;
            if (r23 != (-1)) goto L78;
            r11 = r30.f12648d;
        L79:
            if (r23 == (-1)) goto L82;
            int r33 = r32.get(r23).f12653e;
        L82:
            if (r11 != null) goto L84;
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r8 + ", dim =-1.0, -1.0");
            goto L91
        L78:
            r11 = r32.get(r23).f12654f;
            goto L79
        L74:
            r23 = -1;
            goto L75
        L86:
            if (r10.isAttachedToWindow() == true) goto L91;
            if (r10.R != null) goto L90;
            r10.R = new b(r10);
        L90:
            b r34 = r10.R;
            r34.f12409c = r8;
            r34.f12410d = r18;
            goto L91
        L5:
            if (this.f12410d == (-1)) goto L93;
            goto L6
        }
    }

    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: u.d$d, reason: collision with other inner class name */
    public static final enum EnumC0168d extends Enum<EnumC0168d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0168d f12412a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0168d f12413b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0168d f12414m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ EnumC0168d[] f12415n = null;

        static {
            EnumC0168d r8 = new EnumC0168d("UNDEFINED", 0);
            EnumC0168d r10 = new EnumC0168d("SETUP", 1);
            f12412a = r10;
            EnumC0168d r11 = new EnumC0168d("MOVING", 2);
            f12413b = r11;
            EnumC0168d r12 = new EnumC0168d("FINISHED", 3);
            f12414m = r12;
            f12415n = new EnumC0168d[]{r8, r10, r11, r12};
        }

        public EnumC0168d(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0168d valueOf(String r8) {
            return (EnumC0168d) Enum.valueOf(EnumC0168d.class, r8);
        }

        public static EnumC0168d[] values() {
            return (EnumC0168d[]) f12415n.clone();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r17) {
        if (this.G != (-1)) goto L5;
        this.G = getNanoTime();
    L5:
        float r8 = this.F;
        if (r8 > 0.0f) goto L8;
    L10:
        boolean r10 = true;
        boolean r11 = false;
        if (this.K == false) goto L78;
        float r12 = Math.signum(this.H - r8);
        long r13 = getNanoTime();
        float r14 = (((r13 - this.G) * r12) * 1.0E-9f) / 0.0f;
        float r15 = this.F + r14;
        if (r12 <= 0.0f) goto L18;
        if (r15 < this.H) goto L18;
    L21:
        r15 = this.H;
    L22:
        this.F = r15;
        this.E = r15;
        this.G = r13;
        this.A = r14;
        if (Math.abs(r14) <= 1.0E-5f) goto L25;
        setState(EnumC0168d.f12413b);
    L25:
        if (r12 <= 0.0f) goto L29;
        if (r15 < this.H) goto L29;
    L32:
        r15 = this.H;
    L34:
        if (r15 < 1.0f) goto L36;
    L37:
        setState(EnumC0168d.f12414m);
    L38:
        int r16 = getChildCount();
        this.K = false;
        getNanoTime();
        if (r16 > 0) goto L96;
        if (r12 <= 0.0f) goto L44;
        if (r15 < this.H) goto L44;
    L47:
        boolean r18 = true;
    L50:
        if (this.K == true) goto L53;
        if (r18 == false) goto L53;
        setState(EnumC0168d.f12414m);
    L53:
        boolean r19 = (!r18) | this.K;
        this.K = r19;
        if (r15 > 0.0f) goto L63;
        int r110 = this.B;
        if (r110 == (-1)) goto L63;
        if (this.C == r110) goto L63;
        this.C = r110;
        throw null;
    L63:
        if (r15 < 1.0d) goto L69;
        int r20 = this.C;
        int r111 = this.D;
        if (r20 == r111) goto L69;
        this.C = r111;
        throw null;
    L69:
        if (r19 == true) goto L77;
        if (r12 <= 0.0f) goto L73;
        if (r15 != 1.0f) goto L73;
    L76:
        setState(EnumC0168d.f12414m);
    L73:
        if (r12 >= 0.0f) goto L78;
        if (r15 != 0.0f) goto L78;
    L77:
        invalidate();
    L44:
        if (r12 <= 0.0f) goto L46;
    L48:
        r18 = false;
        goto L50
    L46:
        if (r15 > this.H) goto L48;
    L96:
        getChildAt(0);
        throw null;
    L36:
        if (r15 > 0.0f) goto L38;
    L29:
        if (r12 > 0.0f) goto L34;
        if (r15 > this.H) goto L34;
    L18:
        if (r12 > 0.0f) goto L22;
        if (r15 > this.H) goto L22;
    L78:
        float r21 = this.F;
        if (r21 < 1.0f) goto L84;
        int r22 = this.C;
        int r23 = this.D;
        if (r22 != r23) goto L89;
    L88:
        r10 = false;
    L89:
        this.C = r23;
        r11 = r10;
    L90:
        if (r11 == true) goto L92;
    L94:
        this.E = this.F;
        super.dispatchDraw(r17);
        return;
    L92:
        if (this.Q == true) goto L94;
        requestLayout();
        goto L94
    L84:
        if (r21 > 0.0f) goto L90;
        int r24 = this.C;
        r23 = this.B;
        if (r24 == r23) goto L88;
    L8:
        if (r8 >= 1.0f) goto L10;
        this.C = -1;
        goto L10
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.C;
    }

    public ArrayList<e.a> getDefinedTransitions() {
        return null;
    }

    public u.b getDesignTool() {
        if (this.J != null) goto L6;
        this.J = new u.b();
    L6:
        return this.J;
    }

    public int getEndState() {
        return this.D;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.F;
    }

    public e getScene() {
        return null;
    }

    public int getStartState() {
        return this.B;
    }

    public float getTargetPosition() {
        return this.H;
    }

    public Bundle getTransitionState() {
        if (this.R != null) goto L5;
        this.R = new b(this);
    L5:
        b r8 = this.R;
        d r10 = r8.f12411e;
        r8.f12410d = r10.D;
        r8.f12409c = r10.B;
        r8.f12408b = r10.getVelocity();
        r8.f12407a = r10.getProgress();
        b r11 = this.R;
        r11.getClass();
        Bundle r12 = new Bundle();
        r12.putFloat("motion.progress", r11.f12407a);
        r12.putFloat("motion.velocity", r11.f12408b);
        r12.putInt("motion.StartState", r11.f12409c);
        r12.putInt("motion.EndState", r11.f12410d);
        return r12;
    }

    public long getTransitionTimeMs() {
        return (long) 0.0f;
    }

    public float getVelocity() {
        return this.A;
    }

    @Override // j0.n
    public final void i(View r8, View r10, int r11, int r12) {
        getNanoTime();
    }

    @Override // j0.n
    public final void j(View r8, int r10) {
    }

    @Override // j0.n
    public final void k(View r8, int r10, int r11, int[] r12, int r13) {
    }

    @Override // j0.o
    public final void m(View r8, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        if (r10 != 0) goto L4;
        if (r11 != 0) goto L4;
        return;
    L4:
        r15[0] = r15[0] + r12;
        r15[1] = r15[1] + r13;
    }

    @Override // j0.n
    public final void n(View r8, int r10, int r11, int r12, int r13, int r14) {
    }

    @Override // j0.n
    public final boolean o(View r8, View r10, int r11, int r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r8 = getDisplay();
        if (r8 == null) goto L5;
        r8.getRotation();
    L5:
        b r10 = this.R;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.S == false) goto L10;
        post(new a(this));
        return;
    L10:
        r10.a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        this.Q = true;
        super.onLayout(r8, r10, r11, r12, r13);     // Catch: Throwable -> L6
        this.Q = false;
        return;
    L6:
        th = move-exception;
        this.Q = false;
        throw th;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r8, float r10, float r11, boolean r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r8, float r10, float r11) {
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r8) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        return super.onTouchEvent(r8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View r8) {
        super.onViewAdded(r8);
        if ((r8 instanceof u.c) == false) goto L20;
        u.c r10 = (u.c) r8;
        if (this.N != null) goto L7;
        this.N = new CopyOnWriteArrayList();
    L7:
        this.N.add(r10);
        if (r10.f12402s == false) goto L14;
        if (this.L != null) goto L12;
        this.L = new ArrayList();
    L12:
        this.L.add(r10);
    L14:
        if (r10.f12403t == true) goto L16;
        return;
    L16:
        if (this.M != null) goto L18;
        this.M = new ArrayList();
    L18:
        this.M.add(r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View r8) {
        super.onViewRemoved(r8);
        ArrayList<u.c> r10 = this.L;
        if (r10 == null) goto L5;
        r10.remove(r8);
    L5:
        ArrayList<u.c> r11 = this.M;
        if (r11 == null) goto L9;
        r11.remove(r8);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void p(int r8) {
        this.f1353u = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        int r8 = this.C;
        super.requestLayout();
    }

    public final void s() {
        if (this.I != null) goto L9;
        CopyOnWriteArrayList<c> r8 = this.N;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.P != this.E) goto L11;
        return;
    L11:
        if (this.O == (-1)) goto L21;
        c r10 = this.I;
        if (r10 == null) goto L15;
        r10.b();
    L15:
        CopyOnWriteArrayList<c> r11 = this.N;
        if (r11 == null) goto L21;
        Iterator<c> r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        r12.next().b();
    L21:
        this.O = -1;
        this.P = this.E;
        c r13 = this.I;
        if (r13 == null) goto L24;
        r13.a();
    L24:
        CopyOnWriteArrayList<c> r14 = this.N;
        if (r14 == null) goto L35;
        Iterator<c> r15 = r14.iterator();
    L28:
        if (r15.hasNext() == false) goto L36;
        r15.next().a();
        goto L28
    L36:
        return;
    }

    public void setDebugMode(int r8) {
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r8) {
        this.S = r8;
    }

    public void setInteractionEnabled(boolean r8) {
    }

    public void setInterpolatedProgress(float r8) {
        setProgress(r8);
    }

    public void setOnHide(float r8) {
        ArrayList<u.c> r10 = this.M;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        this.M.get(r12).setProgress(r8);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r8) {
        ArrayList<u.c> r10 = this.L;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        this.L.get(r12).setProgress(r8);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r8) {
        if (r8 >= 0.0f) goto L5;
    L6:
        Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r8 > 0.0f) goto L24;
        if (this.F == 1.0f) goto L18;
    L20:
        this.C = this.B;
        if (this.F != 0.0f) goto L36;
    L22:
        EnumC0168d r10 = EnumC0168d.f12414m;
    L34:
        setState(r10);
        return;
    L36:
        return;
    L18:
        if (this.C != this.D) goto L20;
        setState(EnumC0168d.f12413b);
        goto L20
    L24:
        if (r8 >= 1.0f) goto L26;
        this.C = -1;
        r10 = EnumC0168d.f12413b;
        goto L34
    L26:
        if (this.F == 0.0f) goto L28;
    L30:
        this.C = this.D;
        if (this.F == 1.0f) goto L22;
        return;
    L28:
        if (this.C != this.B) goto L30;
        setState(EnumC0168d.f12413b);
        goto L30
    L10:
        if (this.R != null) goto L12;
        this.R = new b(this);
    L12:
        this.R.f12407a = r8;
        return;
    L5:
        if (r8 <= 1.0f) goto L8;
        goto L6
    }

    public void setScene(e r8) {
        l();
        throw null;
    }

    public void setStartState(int r8) {
        if (isAttachedToWindow() == false) goto L5;
        this.C = r8;
        return;
    L5:
        if (this.R != null) goto L7;
        this.R = new b(this);
    L7:
        b r10 = this.R;
        r10.f12409c = r8;
        r10.f12410d = r8;
    }

    public void setState(EnumC0168d r8) {
        EnumC0168d r10 = EnumC0168d.f12414m;
        if (r8 == r10) goto L5;
    L7:
        EnumC0168d r11 = this.T;
        this.T = r8;
        EnumC0168d r12 = EnumC0168d.f12413b;
        if (r11 != r12) goto L11;
        if (r8 != r12) goto L11;
        s();
    L11:
        int r13 = r11.ordinal();
        if (r13 != 0) goto L14;
    L20:
        if (r8 != r12) goto L22;
        s();
    L22:
        if (r8 != r10) goto L26;
    L19:
        t();
        return;
    L26:
        return;
    L14:
        if (r13 == 1) goto L20;
        if (r13 != 2) goto L27;
        if (r8 == r10) goto L19;
        return;
    L27:
        return;
    L5:
        if (this.C != (-1)) goto L7;
    }

    public void setTransition(int r8) {
    }

    public void setTransitionDuration(int r8) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(c r8) {
        this.I = r8;
    }

    public void setTransitionState(Bundle r8) {
        if (this.R != null) goto L5;
        this.R = new b(this);
    L5:
        b r10 = this.R;
        r10.getClass();
        r10.f12407a = r8.getFloat("motion.progress");
        r10.f12408b = r8.getFloat("motion.velocity");
        r10.f12409c = r8.getInt("motion.StartState");
        r10.f12410d = r8.getInt("motion.EndState");
        if (isAttachedToWindow() == false) goto L9;
        this.R.a();
        return;
    }

    public final void t() {
        if (this.I != null) goto L9;
        CopyOnWriteArrayList<c> r8 = this.N;
        if (r8 == null) goto L11;
        if (r8.isEmpty() == false) goto L9;
    L11:
        if (this.I != null) goto L17;
        CopyOnWriteArrayList<c> r10 = this.N;
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.isEmpty() == false) goto L21;
        return;
    L21:
        throw null;
    L17:
        throw null;
    L9:
        if (this.O != (-1)) goto L11;
        this.O = this.C;
        throw null;
    }

    @Override // android.view.View
    public final String toString() {
        Context r8 = getContext();
        return u.a.a(r8, this.B) + "->" + u.a.a(r8, this.D) + " (pos:" + this.F + " Dpos/Dt:" + this.A;
    }

    public void setTransition(e.a r8) {
        throw null;
    }
}
