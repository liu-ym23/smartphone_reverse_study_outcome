package com.bytedance.ai.view.popup.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int A;
    public int B;
    public boolean C;
    public int D;
    public com.bytedance.ai.view.popup.anim.a E;
    public boolean F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public WeakReference<V> K;
    public WeakReference<View> L;
    public final ArrayList<b> M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public boolean S;
    public Map<View, Integer> T;
    public final a U;
    public AnimController V;
    public int a;
    public boolean b;
    public final float c;
    public int d;
    public boolean e;
    public int f;
    public boolean g;
    public BottomSheetBehavior<V>.c h;
    public ValueAnimator i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public float o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public WeakReference<View> t;
    public WeakReference<View> u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public final int a;
        public final int b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r10) {
                return new SavedState(r10);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r1, ClassLoader r10) {
                return new SavedState(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10) {
            super(r10);
            this.a = r10.readInt();
            this.b = r10.readInt();
            this.c = r10.readInt();
            boolean r1 = false;
            if (r10.readInt() != 1) goto L5;
            boolean r0 = true;
        L6:
            this.d = r0;
            if (r10.readInt() != 1) goto L9;
            boolean r11 = true;
        L10:
            this.e = r11;
            if (r10.readInt() != 1) goto L13;
            r1 = true;
        L13:
            this.f = r1;
            return;
        L9:
            r11 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        public SavedState(Parcelable r1, BottomSheetBehavior<?> r10) {
            super(r1);
            this.a = r10.D;
            this.b = r10.d;
            this.c = r10.w;
            this.d = r10.b;
            this.e = r10.q;
            this.f = r10.r;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r10) {
            super.writeToParcel(r1, r10);
            r1.writeInt(this.a);
            r1.writeInt(this.b);
            r1.writeInt(this.c);
            r1.writeInt(this.d ? 1 : 0);
            r1.writeInt(this.e ? 1 : 0);
            r1.writeInt(this.f ? 1 : 0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a extends com.bytedance.ai.view.popup.anim.a.c {
        public final /* synthetic */ BottomSheetBehavior a;

        public a(BottomSheetBehavior r1) {
            this.a = r1;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(View r1, float r10);

        public abstract void b(View r1, int r10);
    }

    public class c implements Runnable {
        public final View a;
        public boolean b;
        public int c;
        public final /* synthetic */ BottomSheetBehavior d;

        public final void a() {
            com.bytedance.ai.view.popup.anim.a r0 = this.d.E;
            if (r0 != null) goto L5;
        L28:
            this.d.setStateInternal(this.c);
        L29:
            this.b = false;
            return;
        L5:
            if (r0.a != 2) goto L23;
            boolean r10 = r0.p.computeScrollOffset();
            int r11 = r0.p.getCurrX();
            int r12 = r0.p.getCurrY();
            int r13 = r11 - r0.r.getLeft();
            int r14 = r12 - r0.r.getTop();
            if (r13 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r0.r, r13);
        L9:
            if (r14 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r0.r, r14);
        L11:
            if (r13 != 0) goto L13;
            if (r14 != 0) goto L13;
        L14:
            if (r10 == true) goto L16;
        L20:
            if (r10 == true) goto L23;
            r0.t.post(r0.u);
            goto L23
        L16:
            if (r11 != r0.p.getFinalX()) goto L20;
            if (r12 != r0.p.getFinalY()) goto L20;
            r0.p.abortAnimation();
            r10 = false;
        L13:
            ((a) r0.q).a.dispatchOnSlide(r12);
        L23:
            if (r0.a != 2) goto L25;
            boolean r1 = true;
        L26:
            if (r1 == false) goto L28;
            ViewCompat.postOnAnimation(this.a, this);
            goto L29
        L25:
            r1 = false;
            goto L26
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(BottomSheetBehavior r1, View r10, int r11) {
            this.d = r1;
            this.a = r10;
            this.c = r11;
        }
    }

    public final int a() {
        int r0 = this.w;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.d;
    }

    public final void calculateCollapsedOffset() {
        if (this.e == false) goto L5;
        int r0 = Math.max(this.f, this.J - ((this.I * 9) / 16));
    L7:
        if (this.b == false) goto L9;
        this.p = Math.max(this.J - r0, this.m);
        return;
    L9:
        this.p = this.J - r0;
        return;
    L5:
        r0 = this.d + 0;
        goto L7
    }

    public final int getExpandedOffset() {
        if (this.b == false) goto L6;
        return this.m;
    L6:
        return this.j;
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.h = null;
        this.o = 0.5f;
        this.s = true;
        this.t = null;
        this.u = null;
        this.B = 5;
        this.C = false;
        this.D = 4;
        this.M = new ArrayList();
        this.U = new a(this);
    }

    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.K = null;
        this.E = null;
    }

    public final void dispatchOnSlide(int r10) {
        V r0 = this.K.get();
        int r1 = 0;
        WeakReference<View> r11 = this.t;     // Catch: Exception -> L46
        View r12 = null;
        if (r11 != null) goto L6;
        View r13 = null;
    L7:
        WeakReference<View> r14 = this.u;     // Catch: Exception -> L46
        if (r14 != null) goto L10;
        View r15 = null;
    L11:
        AnimController r16 = this.V;     // Catch: Exception -> L46
        if (r16 == null) goto L48;
        boolean r17 = true;
        if (r16.a == AnimController.AnimProcessType.NONE) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == false) goto L48;
        String r19 = r16.c;     // Catch: Exception -> L46
        if (Intrinsics.areEqual(r19, AnimationStyle.SLIDE.getValue()) == false) goto L21;
    L24:
        boolean r20 = true;
    L25:
        if (r20 == true) goto L48;
        if (r10 > this.p) goto L48;
        r0.getLayoutParams().height = this.J - r10;     // Catch: Exception -> L46
        if (r13 == null) goto L44;
        ViewGroup.LayoutParams r21 = r13.getLayoutParams();     // Catch: Exception -> L46
        int r22 = this.J - r10;     // Catch: Exception -> L46
        int r23 = AppletPopup.R;     // Catch: Exception -> L46
        if (r15 != null) goto L33;
    L42:
        int r24 = 0;
    L43:
        r21.height = r22 - r24;     // Catch: Exception -> L46
        goto L44
    L33:
        if (r15.getVisibility() == 0) goto L36;
        r17 = false;
    L36:
        if (r17 == false) goto L38;
        r12 = r15;
    L38:
        if (r12 == null) goto L42;
        ViewGroup.LayoutParams r25 = r12.getLayoutParams();     // Catch: Exception -> L46
        if (r25 == null) goto L42;
        r24 = r25.height;     // Catch: Exception -> L46
    L44:
        r0.requestLayout();     // Catch: Exception -> L46
        goto L48
    L21:
        if (Intrinsics.areEqual(r19, AnimationStyle.ZOOM.getValue()) == true) goto L24;
        r20 = false;
        goto L25
    L16:
        r18 = false;
    L48:
        if (r0 != null) goto L50;
        return;
    L50:
        if (this.M.isEmpty() == true) goto L66;
        int r26 = this.p;
        if (r10 <= r26) goto L54;
    L57:
        int r27 = this.p;
        float r110 = r27 - r10;
        float r28 = this.J - r27;
    L58:
        float r111 = r110 / r28;
    L60:
        if (r1 >= this.M.size()) goto L67;
        ((b) ListProtector.get(this.M, r1)).a(r0, r111);
        r1 = r1 + 1;
        goto L60
    L67:
        return;
    L54:
        if (r26 == getExpandedOffset()) goto L57;
        int r29 = this.p;
        r110 = r29 - r10;
        r28 = r29 - getExpandedOffset();
        goto L58
    L66:
        return;
    L10:
        r15 = r14.get();     // Catch: Exception -> L46
        goto L11
    L6:
        r13 = r11.get();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.toString();
        goto L48
    }

    public final View findScrollingChild(View r10) {
        if (ViewCompat.isNestedScrollingEnabled(r10) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r11 = (ViewGroup) r10;
        int r0 = r11.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        View r12 = findScrollingChild(r11.getChildAt(r1));
        if (r12 != null) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r12;
    L17:
        return null;
    L13:
        return null;
    }

    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
        super.onAttachedToLayoutParams(r1);
        this.K = null;
        this.E = null;
    }

    public final void setFitToContents(boolean r10) {
        if (this.b != r10) goto L5;
        return;
    L5:
        this.b = r10;
        if (this.K == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.b == true) goto L11;
    L13:
        int r11 = this.D;
    L14:
        setStateInternal(r11);
        return;
    L11:
        if (this.D != 6) goto L13;
        r11 = 3;
        goto L14
    }

    public final void setHideable(boolean r10) {
        if (this.q == r10) goto L10;
        this.q = r10;
        if (r10 == false) goto L7;
        return;
    L7:
        if (this.D != 5) goto L12;
        b(4, true);
        return;
    L12:
        return;
    }

    public final void setPeekHeight(int r10) {
        boolean r0 = false;
        if (r10 != (-1)) goto L8;
        if (this.e == true) goto L13;
        this.e = true;
    L12:
        r0 = true;
    L13:
        if (r0 == true) goto L15;
        return;
    L15:
        if (this.K == null) goto L23;
        calculateCollapsedOffset();
        if (this.D != 4) goto L24;
        V r11 = this.K.get();
        if (r11 == null) goto L25;
        r11.requestLayout();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        if (this.e == false) goto L10;
    L11:
        this.e = false;
        this.d = Math.max(0, r10);
        goto L12
    L10:
        if (this.d == r10) goto L13;
        goto L11
    }

    public final void setStateInternal(int r10) {
        int r0 = this.D;
        if (r0 != r10) goto L5;
        return;
    L5:
        this.B = r0;
        this.D = r10;
        WeakReference<V> r1 = this.K;
        if (r1 != null) goto L8;
        return;
    L8:
        V r11 = r1.get();
        if (r11 != null) goto L11;
        return;
    L11:
        int r12 = 0;
        boolean r13 = true;
        if (r10 != 3) goto L15;
        updateImportantForAccessibility(true);
    L22:
        if (r10 == 2) goto L31;
        if (r10 == 3) goto L28;
        r13 = false;
    L28:
        if (this.g == r13) goto L31;
        this.g = r13;
    L31:
        if (r12 >= this.M.size()) goto L33;
        ((b) ListProtector.get(this.M, r12)).b(r11, r10);
        r12 = r12 + 1;
        goto L31
    L33:
        return;
    L15:
        if (r10 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L22
    L17:
        if (r10 == 5) goto L20;
        if (r10 != 4) goto L22;
        goto L20
    }

    public final void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r0 = this.K;
        if (r0 != null) goto L5;
        return;
    L5:
        CoordinatorLayout r1 = r0.get().getParent();
        if ((r1 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r11 = r1;
        int r12 = r11.getChildCount();
        if (r10 == true) goto L11;
    L14:
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L22;
        View r14 = r11.getChildAt(r13);
        if (r14 == this.K.get()) goto L21;
        if (r10 == false) goto L21;
        Map<View, Integer> r15 = this.T;
        HashMap r16 = (HashMap) r15;
        r16.put(r14, Integer.valueOf(r14.getImportantForAccessibility()));
    L21:
        r13 = r13 + 1;
        goto L15
    L22:
        if (r10 == true) goto L29;
        this.T = null;
        return;
    L29:
        return;
    L11:
        if (this.T != null) goto L13;
        this.T = new HashMap(r12);
        goto L14
    }

    public BottomSheetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.a = 0;
        this.b = true;
        this.h = null;
        this.o = 0.5f;
        this.s = true;
        this.t = null;
        this.u = null;
        this.B = 5;
        this.C = false;
        this.D = 4;
        this.M = new ArrayList();
        this.U = new a(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{2130968990, 2130968991, 2130968993, 2130968994});
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.i = r13;
        r13.setDuration(500);
        this.i.addUpdateListener(new w5.b(this));
        TypedValue r14 = r12.peekValue(2);
        if (r14 == null) goto L7;
        int r15 = r14.data;
        if (r15 != (-1)) goto L7;
        setPeekHeight(r15);
    L8:
        setHideable(r12.getBoolean(1, false));
        setFitToContents(true);
        this.r = false;
        this.s = true;
        this.a = 0;
        this.o = 0.5f;
        if (this.K == null) goto L11;
        this.n = (int) (this.J * (1.0f - 0.5f));
    L11:
        this.j = 0;
        r12.recycle();
        this.c = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r12.getDimensionPixelSize(2, -1));
        goto L8
    }

    public final void b(int r10, boolean r11) {
        if (r10 != this.D) goto L5;
        return;
    L5:
        WeakReference<V> r0 = this.K;
        if (r0 == null) goto L8;
        V r1 = r0.get();
        if (r1 == null) goto L34;
        ViewParent r12 = r1.getParent();
        if (r12 != null) goto L25;
    L29:
        c(r1, r10, r11);
        return;
    L25:
        if (r12.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L29;
        r1.post(new w5.a(this, r1, r10, r11));
        return;
    L34:
        return;
    L8:
        if (r10 != 4) goto L10;
    L17:
        this.D = r10;
        return;
    L10:
        if (r10 == 3) goto L17;
        if (r10 == 6) goto L17;
        if (this.q == true) goto L16;
        return;
    L16:
        if (r10 == 5) goto L17;
    }

    public final Parcelable onSaveInstanceState(CoordinatorLayout r10, V r11) {
        return new SavedState(super.onSaveInstanceState(r10, r11), this);
    }

    public final boolean shouldHide(View r10, float r11) {
        if (this.r == false) goto L8;
        if ((r10.getTop() - this.j) < this.A) goto L8;
        return true;
    L8:
        if (this.B != 3) goto L14;
        if (this.A == 0) goto L14;
        if ((r10.getTop() - this.j) < this.A) goto L14;
    L19:
        return true;
    L14:
        if (this.B != 4) goto L21;
        if (this.z == 0) goto L21;
        if ((r10.getTop() - this.p) >= this.z) goto L19;
    L21:
        if (r10.getTop() >= this.p) goto L24;
        return false;
    L24:
        if (this.e == false) goto L26;
        int r0 = Math.max(this.f, this.J - ((this.I * 9) / 16));
    L28:
        if ((Math.abs((r10.getTop() + (r11 * 0.1f)) - this.p) / r0) > 0.5f) goto L32;
        return false;
    L32:
        return true;
    L26:
        r0 = this.d + 0;
        goto L28
    }

    public final void c(View r10, int r11, boolean r12) {
        if (r11 != 4) goto L6;
        int r0 = this.p;
    L19:
        startSettlingAnimation(r10, r11, r0, !r12);
        return;
    L6:
        if (r11 != 6) goto L12;
        r0 = this.n;
        if (this.b == false) goto L19;
        int r13 = this.m;
        if (r0 > r13) goto L19;
        r0 = r13;
        r11 = 3;
        goto L19
    L12:
        if (r11 != 3) goto L15;
        r0 = getExpandedOffset();
        goto L19
    L15:
        if (this.q == false) goto L22;
        if (r11 != 5) goto L22;
        r0 = this.J;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout r19, V r20, MotionEvent r21) {
        boolean r10 = false;
        int r11 = 0;
        r10 = false;
        r10 = false;
        r10 = false;
        r10 = false;
        r10 = false;
        int r12 = 1;
        if (r20.isShown() == true) goto L5;
    L238:
        this.F = true;
        return false;
    L5:
        if (this.s == false) goto L7;
    L9:
        int r13 = r21.getActionMasked();
        if (r13 != 0) goto L15;
        this.O = -1;
        VelocityTracker r14 = this.N;
        if (r14 == null) goto L15;
        r14.recycle();
        this.N = null;
    L15:
        if (this.N != null) goto L17;
        this.N = VelocityTracker.obtain();
    L17:
        this.N.addMovement(r21);
        if (r13 == 0) goto L104;
        if (r13 == 1) goto L100;
        if (r13 == 2) goto L24;
        if (r13 == 3) goto L100;
    L122:
        if (this.F == true) goto L218;
        com.bytedance.ai.view.popup.anim.a r15 = this.E;
        if (r15 == null) goto L218;
        int r16 = r21.getActionMasked();
        int r17 = r21.getActionIndex();
        if (r16 != 0) goto L129;
        r15.b();
    L129:
        if (r15.l != null) goto L131;
        r15.l = VelocityTracker.obtain();
    L131:
        r15.l.addMovement(r21);
        if (r16 == 0) goto L204;
        if (r16 != 1) goto L135;
    L203:
        int r18 = r13;
        r15.b();
    L213:
        if (r15.a != 1) goto L215;
        boolean r110 = true;
    L216:
        if (r110 == false) goto L219;
        return true;
    L219:
        WeakReference<View> r1 = this.L;
        if (r1 == null) goto L222;
        View r22 = r1.get();
        int r23 = 2;
    L223:
        if (r18 != r23) goto L236;
        if (r22 == null) goto L236;
        if (this.F == true) goto L236;
        if (this.D == 1) goto L236;
        if (r19.isPointInChildBounds(r22, (int) r21.getX(), (int) r21.getY()) == true) goto L236;
        if (this.E == null) goto L236;
        if (Math.abs(this.P - r21.getY()) <= this.E.b) goto L236;
        return true;
    L236:
        return false;
    L222:
        r23 = 2;
        r22 = null;
        goto L223
    L215:
        r110 = false;
        goto L216
    L135:
        if (r16 == 2) goto L154;
        if (r16 == 3) goto L203;
        if (r16 != 5) goto L140;
        int r24 = r21.getPointerId(r17);
        float r25 = r21.getX(r17);
        float r26 = r21.getY(r17);
        r15.n(r25, r26, r24);
        int r111 = r15.a;
        if (r111 != 0) goto L149;
        if ((r15.h[r24] & 0) == 0) goto L202;
        r15.q.getClass();
    L202:
        r18 = r13;
        goto L213
    L149:
        if (r111 != 2) goto L202;
        View r27 = r15.j((int) r25, (int) r26);
        if (r27 != r15.r) goto L202;
        r15.q(r27, r24);
        goto L202
    L140:
        if (r16 != 6) goto L202;
        r15.f(r21.getPointerId(r17));
        goto L202
    L154:
        if (r15.d == null) goto L202;
        if (r15.e == null) goto L202;
        int r28 = r21.getPointerCount();
        int r29 = 0;
    L159:
        if (r29 >= r28) goto L200;
        int r30 = r21.getPointerId(r29);
        if ((r15.k & (r12 << r30)) == 0) goto L163;
        boolean r112 = true;
    L164:
        if (r112 == true) goto L166;
        boolean r113 = false;
    L167:
        if (r113 == true) goto L169;
        r18 = r13;
        int r210 = r28;
    L199:
        r29 = r29 + 1;
        r28 = r210;
        r13 = r18;
        r12 = 1;
        goto L159
    L169:
        float r114 = r21.getX(r29);
        float r115 = r21.getY(r29);
        float r116 = r114 - r15.d[r30];
        float r117 = r115 - r15.e[r30];
        View r118 = r15.j((int) r114, (int) r115);
        if (r118 != null) goto L172;
    L174:
        boolean r119 = false;
    L175:
        if (r119 == false) goto L191;
        r118.getLeft();
        ((a) r15.q).getClass();
        r118.getLeft();
        int r120 = r118.getTop();
        int r121 = ((int) r117) + r120;
        a r31 = (a) r15.q;
        int r32 = r31.a.getExpandedOffset();
        BottomSheetBehavior r33 = r31.a;
        r210 = r28;
        if (r33.q == false) goto L179;
        int r34 = r33.J;
    L180:
        int r35 = MathUtils.clamp(r121, r32, r34);
        r15.q.getClass();
        com.bytedance.ai.view.popup.anim.a.c r36 = r15.q;
        BottomSheetBehavior r37 = ((a) r36).a;
        if (r37.q == false) goto L183;
        int r38 = r37.J;
    L184:
        a r39 = (a) r36;
        com.bytedance.ai.view.popup.anim.a r122 = r39.a.E;
        int r40 = (int) r21.getX();
        r18 = r13;
        int r41 = (int) r21.getY();
        BottomSheetBehavior r42 = r39.a;
        int r43 = r41 - (r42.J - r42.v);
        r122.getClass();
        if ((!com.bytedance.ai.view.popup.anim.a.a(r118, 1, r40, r43)) == false) goto L201;
        if (r38 == 0) goto L201;
        if (r38 <= 0) goto L192;
        if (r35 == r120) goto L201;
    L192:
        r15.m(r116, r117, r30);
        if (r15.a == 1) goto L201;
        if (r119 == false) goto L199;
        if (r15.q(r118, r30) == false) goto L199;
    L201:
        r15.o(r21);
        goto L213
    L183:
        r38 = r37.p;
        goto L184
    L179:
        r34 = r33.p;
        goto L180
    L191:
        r18 = r13;
        r210 = r28;
        goto L192
    L172:
        if (r15.e(r118, r117) == false) goto L174;
        r119 = true;
        goto L175
    L166:
        r113 = true;
        goto L167
    L163:
        r112 = false;
        goto L164
    L200:
        r18 = r13;
        goto L201
    L204:
        r18 = r13;
        float r0 = r21.getX();
        float r44 = r21.getY();
        int r45 = r21.getPointerId(0);
        r15.n(r0, r44, r45);
        View r46 = r15.j((int) r0, (int) r44);
        if (r46 != r15.r) goto L210;
        if (r15.a != 2) goto L210;
        r15.q(r46, r45);
    L210:
        if ((r15.h[r45] & 0) == 0) goto L213;
        r15.q.getClass();
    L218:
        r18 = r13;
        goto L219
    L24:
        if (this.s == false) goto L26;
    L27:
        int r123 = ((int) r21.getY()) - this.P;
        if (r123 >= 0) goto L30;
        boolean r124 = true;
    L31:
        if (r123 != 0) goto L33;
        return false;
    L33:
        if (r124 == false) goto L35;
        int r125 = -1;
    L36:
        g r126 = g.a;
        r126.d("BottomSheetBehavior", "####pull up: " + r124 + " detected. position: " + r125 + " offset: " + r123);
        WeakReference<View> r47 = this.L;
        if (r47 == null) goto L39;
        View r48 = r47.get();
    L41:
        if (this.S == false) goto L47;
        if (r48 == null) goto L47;
        if (r48.canScrollVertically(r125) == false) goto L47;
        r126.d("BottomSheetBehavior", "####ignoreEvents");
        this.F = true;
        return false;
    L47:
        this.F = false;
        if (this.q == false) goto L58;
        if (r124 == true) goto L58;
        if (this.r == false) goto L58;
        if (this.D != 3) goto L58;
        if (r48 == null) goto L58;
        if (r48.canScrollVertically(1) == false) goto L58;
        return true;
    L58:
        int r49 = this.E.b;
        if (r123 < (-r49)) goto L61;
        if (r123 <= r49) goto L81;
        int r50 = ((int) r21.getX()) - this.Q;
        if (Math.abs(r50) <= this.E.b) goto L70;
        if (r50 <= 0) goto L69;
        r11 = 1;
        goto L70
    L69:
        r11 = -1;
    L70:
        if (r124 == false) goto L72;
        int r51 = (int) r21.getY();
        int r52 = this.J - this.v;
    L73:
        int r53 = r51 - r52;
        com.bytedance.ai.view.popup.anim.a r54 = this.E;
        int r55 = (int) r21.getX();
        r54.getClass();
        boolean r56 = com.bytedance.ai.view.popup.anim.a.a(r20, r11, r55, r53);
        r126.d("BottomSheetBehavior", "#####process scroll. canScroll:  " + r56);
        if (this.v < this.d) goto L80;
        if ((a() - this.d) <= 1) goto L80;
        if (r56 == true) goto L80;
        return true;
    L80:
        return !r56;
    L72:
        r51 = this.J - this.v;
        r52 = (int) r21.getY();
        goto L73
    L81:
        WeakReference<View> r57 = this.L;
        if (r57 == null) goto L84;
        View r58 = r57.get();
    L85:
        if (r58 == null) goto L122;
        if (r19.isPointInChildBounds(r58, (int) r21.getX(), (int) r21.getY()) == false) goto L122;
        boolean r59 = r58.canScrollVertically(-1);
        boolean r60 = r58.canScrollVertically(1);
        if (r124 == false) goto L94;
        if (r123 >= 0) goto L98;
        if (r59 == true) goto L98;
        if (r60 == false) goto L98;
    L97:
        r10 = true;
    L98:
        r126.d("BottomSheetBehavior", "####check state 2. result: " + r10 + " canScrollUp: " + r59 + " canScrollDown: " + r60);
        return r10;
    L94:
        if (r123 <= 0) goto L98;
        if (r59 == false) goto L98;
        if (r60 == true) goto L98;
    L84:
        r58 = null;
        goto L85
    L61:
        if (this.D == 3) goto L249;
        return true;
    L249:
        return false;
    L39:
        r48 = null;
        goto L41
    L35:
        r125 = 1;
        goto L36
    L30:
        r124 = false;
        goto L31
    L26:
        if (this.q == false) goto L122;
    L100:
        this.R = false;
        this.O = -1;
        if (this.F == false) goto L122;
        this.F = false;
        return false;
    L104:
        this.Q = (int) r21.getX();
        this.P = (int) r21.getY();
        this.v = r20.getHeight();
        if (this.D == 2) goto L115;
        WeakReference<View> r61 = this.L;
        if (r61 == null) goto L109;
        View r62 = r61.get();
    L110:
        if (r62 == null) goto L115;
        if (r19.isPointInChildBounds(r62, this.Q, this.P) == false) goto L115;
        this.O = r21.getPointerId(r21.getActionIndex());
        this.R = true;
        goto L115
    L109:
        r62 = null;
    L115:
        if (this.O == (-1)) goto L117;
    L119:
        boolean r63 = false;
    L120:
        this.F = r63;
        goto L122
    L117:
        if (r19.isPointInChildBounds(r20, this.Q, this.P) == true) goto L119;
        r63 = true;
        goto L120
    L7:
        if (this.q == true) goto L9;
        goto L9
    }

    public final boolean onLayoutChild(CoordinatorLayout r10, V r11, int r12) {
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L8;
        r11.setFitsSystemWindows(true);
    L8:
        if (this.K != null) goto L13;
        this.f = r10.getResources().getDimensionPixelSize(2131165793);
        this.K = new WeakReference(r11);
        if (ViewCompat.getImportantForAccessibility(r11) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r11, 1);
    L13:
        if (this.E != null) goto L15;
        this.E = new com.bytedance.ai.view.popup.anim.a(r10.getContext(), r10, this.U);
    L15:
        int r0 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.I = r10.getWidth();
        this.J = r10.getHeight();
        if (a() <= 0) goto L22;
        int r13 = this.J - a();
        this.j = r13;
        int r14 = this.l;
        if (r14 != 0) goto L21;
        r14 = this.k;
    L21:
        this.j = Math.max(r14, r13);
    L23:
        this.m = Math.max(0, this.J - r11.getHeight());
        this.n = (int) (this.J * (1.0f - this.o));
        calculateCollapsedOffset();
        if (this.C == true) goto L43;
        int r15 = this.D;
        if (r15 != 3) goto L29;
        ViewCompat.offsetTopAndBottom(r11, getExpandedOffset() - r11.getTop());
        goto L43
    L29:
        if (r15 != 6) goto L32;
        ViewCompat.offsetTopAndBottom(r11, this.n);
        goto L43
    L32:
        if (this.q == false) goto L37;
        if (r15 != 5) goto L37;
        ViewCompat.offsetTopAndBottom(r11, this.J);
    L37:
        if (r15 != 4) goto L39;
        ViewCompat.offsetTopAndBottom(r11, this.p - r11.getTop());
        goto L43
    L39:
        if (r15 != 1) goto L41;
    L42:
        ViewCompat.offsetTopAndBottom(r11, r0 - r11.getTop());
        goto L43
    L41:
        if (r15 == 2) goto L42;
    L43:
        this.C = false;
        this.L = new WeakReference(findScrollingChild(r11));
        return true;
    L22:
        this.j = this.J;
        goto L23
    }

    public final void onRestoreInstanceState(CoordinatorLayout r10, V r11, Parcelable r12) {
        SavedState r13 = (SavedState) r12;
        super.onRestoreInstanceState(r10, r11, r13.getSuperState());
        int r14 = this.a;
        if (r14 != 0) goto L6;
    L22:
        int r15 = r13.a;
        if (r15 == 1) goto L27;
        if (r15 == 2) goto L27;
        this.D = r15;
        return;
    L27:
        this.D = 4;
        return;
    L6:
        if (r14 != (-1)) goto L8;
    L9:
        this.d = r13.b;
    L10:
        if (r14 != (-1)) goto L12;
    L13:
        this.b = r13.d;
    L14:
        if (r14 != (-1)) goto L16;
    L17:
        this.q = r13.e;
    L18:
        if (r14 != (-1)) goto L20;
    L21:
        this.r = r13.f;
        goto L22
    L20:
        if ((r14 & 8) != 8) goto L22;
    L16:
        if ((r14 & 4) != 4) goto L18;
    L12:
        if ((r14 & 2) != 2) goto L14;
    L8:
        if ((r14 & 1) != 1) goto L10;
        goto L9
    }

    public boolean onTouchEvent(CoordinatorLayout r13, V r14, MotionEvent r15) {
        int r0 = 0;
        if (r14.isShown() == true) goto L5;
        return false;
    L5:
        int r16 = r15.getActionMasked();
        if (this.D != 1) goto L9;
        if (r16 != 0) goto L9;
        return true;
    L9:
        com.bytedance.ai.view.popup.anim.a r1 = this.E;
        if (r1 != null) goto L137;
    L121:
        if (r16 != 0) goto L126;
        this.O = -1;
        VelocityTracker r10 = this.N;
        if (r10 == null) goto L126;
        r10.recycle();
        this.N = null;
    L126:
        if (this.N != null) goto L128;
        this.N = VelocityTracker.obtain();
    L128:
        this.N.addMovement(r15);
        if (r16 != 2) goto L136;
        if (this.F == true) goto L136;
        float r17 = Math.abs(this.P - r15.getY());
        com.bytedance.ai.view.popup.anim.a r11 = this.E;
        if (r17 <= r11.b) goto L136;
        r11.c(r14, r15.getPointerId(r15.getActionIndex()));
    L136:
        return !this.F;
    L137:
        int r12 = r15.getActionMasked();     // Catch: IllegalArgumentException -> L119
        int r18 = r15.getActionIndex();     // Catch: IllegalArgumentException -> L119
        if (r12 != 0) goto L15;
        r1.b();     // Catch: IllegalArgumentException -> L119
    L15:
        if (r1.l != null) goto L17;
        r1.l = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L119
    L17:
        r1.l.addMovement(r15);     // Catch: IllegalArgumentException -> L119
        if (r12 == 0) goto L115;
        if (r12 == 1) goto L112;
        if (r12 == 2) goto L71;
        if (r12 == 3) goto L67;
        if (r12 != 5) goto L26;
        int r19 = r15.getPointerId(r18);     // Catch: IllegalArgumentException -> L119
        float r20 = r15.getX(r18);     // Catch: IllegalArgumentException -> L119
        float r21 = r15.getY(r18);     // Catch: IllegalArgumentException -> L119
        r1.n(r20, r21, r19);     // Catch: IllegalArgumentException -> L119
        if (r1.a != 0) goto L52;
        r1.q(r1.j((int) r20, (int) r21), r19);     // Catch: IllegalArgumentException -> L119
        if ((0 & r1.h[r19]) == 0) goto L121;
        r1.q.getClass();     // Catch: IllegalArgumentException -> L119
        goto L121
    L52:
        int r22 = (int) r20;     // Catch: IllegalArgumentException -> L119
        int r23 = (int) r21;     // Catch: IllegalArgumentException -> L119
        View r24 = r1.r;     // Catch: IllegalArgumentException -> L119
        if (r24 != null) goto L56;
    L64:
        if (r0 == 0) goto L121;
        r1.q(r1.r, r19);     // Catch: IllegalArgumentException -> L119
        goto L121
    L56:
        if (r22 < r24.getLeft()) goto L64;
        if (r22 >= r24.getRight()) goto L64;
        if (r23 < r24.getTop()) goto L64;
        if (r23 >= r24.getBottom()) goto L64;
        r0 = 1;
        goto L64
    L26:
        if (r12 != 6) goto L121;
        int r25 = r15.getPointerId(r18);     // Catch: IllegalArgumentException -> L119
        if (r1.a == 1) goto L31;
    L46:
        r1.f(r25);     // Catch: IllegalArgumentException -> L119
        goto L121
    L31:
        if (r25 != r1.c) goto L46;
        int r26 = r15.getPointerCount();     // Catch: IllegalArgumentException -> L119
    L33:
        if (r0 >= r26) goto L43;
        int r27 = r15.getPointerId(r0);     // Catch: IllegalArgumentException -> L119
        if (r27 == r1.c) goto L42;
        View r28 = r1.j((int) r15.getX(r0), (int) r15.getY(r0));     // Catch: IllegalArgumentException -> L119
        View r29 = r1.r;     // Catch: IllegalArgumentException -> L119
        if (r28 != r29) goto L42;
        if (r1.q(r29, r27) == false) goto L42;
        int r30 = r1.c;     // Catch: IllegalArgumentException -> L119
    L44:
        if (r30 != (-1)) goto L46;
        r1.l();     // Catch: IllegalArgumentException -> L119
    L42:
        r0 = r0 + 1;     // Catch: IllegalArgumentException -> L119
        goto L33
    L43:
        r30 = -1;
        goto L44
    L67:
        if (r1.a != 1) goto L69;
        r1.h(0.0f, 0.0f);     // Catch: IllegalArgumentException -> L119
    L69:
        r1.b();     // Catch: IllegalArgumentException -> L119
        goto L121
    L71:
        if (r1.a != 1) goto L86;
        int r31 = r1.c;     // Catch: IllegalArgumentException -> L119
        if ((r1.k & (1 << r31)) == 0) goto L75;
        boolean r32 = true;
    L76:
        if (r32 == false) goto L79;
        r0 = 1;
    L79:
        if (r0 == 0) goto L121;
        int r33 = r15.findPointerIndex(r31);     // Catch: IllegalArgumentException -> L119
        float r34 = r15.getX(r33);     // Catch: IllegalArgumentException -> L119
        float r35 = r15.getY(r33);     // Catch: IllegalArgumentException -> L119
        float[] r36 = r1.f;     // Catch: IllegalArgumentException -> L119
        if (r36 == null) goto L121;
        float[] r37 = r1.g;     // Catch: IllegalArgumentException -> L119
        if (r37 == null) goto L121;
        int r38 = r1.c;     // Catch: IllegalArgumentException -> L119
        int r39 = (int) (r34 - r36[r38]);     // Catch: IllegalArgumentException -> L119
        int r40 = (int) (r35 - r37[r38]);     // Catch: IllegalArgumentException -> L119
        r1.i(r1.r.getLeft() + r39, r1.r.getTop() + r40, r39, r40);     // Catch: IllegalArgumentException -> L119
        r1.o(r15);     // Catch: IllegalArgumentException -> L119
        goto L121
    L75:
        r32 = false;
        goto L76
    L86:
        int r41 = r15.getPointerCount();     // Catch: IllegalArgumentException -> L119
        int r42 = 0;
    L87:
        if (r42 >= r41) goto L110;
        int r43 = r15.getPointerId(r42);     // Catch: IllegalArgumentException -> L119
        if ((r1.k & (1 << r43)) == 0) goto L91;
        boolean r44 = true;
    L92:
        if (r44 == true) goto L94;
        boolean r45 = false;
    L95:
        if (r45 == false) goto L109;
        float r46 = r15.getX(r42);     // Catch: IllegalArgumentException -> L119
        float r47 = r15.getY(r42);     // Catch: IllegalArgumentException -> L119
        float[] r110 = r1.d;     // Catch: IllegalArgumentException -> L119
        if (r110 == null) goto L109;
        float[] r111 = r1.e;     // Catch: IllegalArgumentException -> L119
        if (r111 == null) goto L109;
        float r112 = r46 - r110[r43];     // Catch: IllegalArgumentException -> L119
        float r113 = r47 - r111[r43];     // Catch: IllegalArgumentException -> L119
        r1.m(r112, r113, r43);     // Catch: IllegalArgumentException -> L119
        if (r1.a == 1) goto L110;
        View r48 = r1.j((int) r46, (int) r47);     // Catch: IllegalArgumentException -> L119
        if (r1.e(r48, r113) == false) goto L109;
        if (r1.q(r48, r43) == true) goto L110;
    L109:
        r42 = r42 + 1;     // Catch: IllegalArgumentException -> L119
        goto L87
    L94:
        r45 = true;
        goto L95
    L91:
        r44 = false;
    L110:
        r1.o(r15);     // Catch: IllegalArgumentException -> L119
        goto L121
    L112:
        if (r1.a != 1) goto L114;
        r1.l();     // Catch: IllegalArgumentException -> L119
    L114:
        r1.b();     // Catch: IllegalArgumentException -> L119
        goto L121
    L115:
        float r49 = r15.getX();     // Catch: IllegalArgumentException -> L119
        float r50 = r15.getY();     // Catch: IllegalArgumentException -> L119
        int r51 = r15.getPointerId(0);     // Catch: IllegalArgumentException -> L119
        View r52 = r1.j((int) r49, (int) r50);     // Catch: IllegalArgumentException -> L119
        r1.n(r49, r50, r51);     // Catch: IllegalArgumentException -> L119
        r1.q(r52, r51);     // Catch: IllegalArgumentException -> L119
        if ((0 & r1.h[r51]) == 0) goto L121;
        r1.q.getClass();     // Catch: IllegalArgumentException -> L119
    L119:
        e = move-exception;
        e.printStackTrace();
        goto L121
    }

    public final void onStopNestedScroll(CoordinatorLayout r10, V r11, View r12, int r13) {
        int r0 = 3;
        if (r11.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r14 = this.L;
        if (r14 != null) goto L9;
        return;
    L9:
        if (r12 == r14.get()) goto L11;
        return;
    L11:
        if (this.H == true) goto L14;
        return;
    L14:
        if (this.D != 1) goto L21;
        if (this.s == false) goto L21;
        if (this.B != 4) goto L21;
        return;
    L21:
        if (this.G <= 0) goto L27;
        if (this.b == false) goto L25;
        int r15 = this.m;
    L52:
        startSettlingAnimation(r11, r0, r15, false);
        this.H = false;
        return;
    L25:
        r15 = this.j;
        goto L52
    L27:
        if (this.q == false) goto L36;
        VelocityTracker r16 = this.N;
        if (r16 != null) goto L31;
        float r17 = 0.0f;
    L33:
        if (shouldHide(r11, r17) == false) goto L36;
        r15 = this.J;
        r0 = 5;
        goto L52
    L31:
        r16.computeCurrentVelocity(IServerListener.WHAT_BYTELINK_SINK_ERROR, this.c);
        r17 = this.N.getYVelocity(this.O);
    L36:
        if (this.G != 0) goto L48;
        int r18 = r11.getTop();
        if (this.b == false) goto L44;
        if (Math.abs(r18 - this.m) >= Math.abs(r18 - this.p)) goto L42;
        r15 = this.m;
        goto L52
    L42:
        r15 = this.p;
    L51:
        r0 = 4;
        goto L52
    L44:
        if (Math.abs(r18 - this.j) >= Math.abs(r18 - this.p)) goto L46;
        r15 = this.j;
        goto L52
    L46:
        r15 = this.p;
        goto L51
    L48:
        if (this.b == false) goto L50;
        r15 = this.p;
        goto L51
    L50:
        r15 = this.p;
        goto L51
    }

    public final void startSettlingAnimation(View r10, int r11, int r12, boolean r13) {
        boolean r0 = false;
        if (r13 == false) goto L9;
        com.bytedance.ai.view.popup.anim.a r14 = this.E;
        int r1 = r10.getLeft();
        if (r14.s == false) goto L8;
        boolean r15 = r14.k(r1, r12, (int) r14.l.getXVelocity(r14.c), (int) r14.l.getYVelocity(r14.c));
    L16:
        if (r15 == false) goto L33;
        setStateInternal(2);
        if (r11 == 2) goto L27;
        if (r11 != 3) goto L24;
        r0 = true;
    L24:
        if (this.g == r0) goto L27;
        this.g = r0;
    L27:
        if (this.h != null) goto L29;
        this.h = new c(this, r10, r11);
    L29:
        BottomSheetBehavior<V>.c r16 = this.h;
        if (r16.b == true) goto L32;
        r16.c = r11;
        ViewCompat.postOnAnimation(r10, r16);
        this.h.b = true;
        return;
    L32:
        r16.c = r11;
        return;
    L33:
        setStateInternal(r11);
        return;
    L8:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    L9:
        com.bytedance.ai.view.popup.anim.a r17 = this.E;
        int r18 = r10.getLeft();
        r17.r = r10;
        r17.c = -1;
        r15 = r17.k(r18, r12, 0, 0);
        if (r15 == true) goto L16;
        if (r17.a != 0) goto L16;
        if (r17.r == null) goto L16;
        r17.r = null;
        goto L16
    }

    public final boolean onNestedPreFling(CoordinatorLayout r10, V r11, View r12, float r13, float r14) {
        WeakReference<View> r0 = this.L;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r12 == r0.get()) goto L7;
        return false;
    L7:
        if (this.D == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == true) goto L10;
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout r1, V r10, View r11, View r12, int r13, int r14) {
        this.G = 0;
        this.H = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r10, V r11, View r12, int r13, int r14, int[] r15, int r16) {
        if (r16 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r17 = this.L;
        if (r17 == null) goto L8;
        View r18 = r17.get();
    L9:
        if (r12 == r18) goto L11;
        return;
    L11:
        int r19 = r11.getTop();
        int r20 = r19 - r14;
        if (r14 > 0) goto L14;
        if (r14 < 0) goto L22;
    L33:
        dispatchOnSlide(r11.getTop());
        this.G = r14;
        this.H = true;
        return;
    L22:
        if (r12.canScrollVertically(-1) == true) goto L33;
        int r21 = this.p;
        if (r20 <= r21) goto L30;
        if (this.q == true) goto L30;
        int r22 = r19 - r21;
        r15[1] = r22;
        ViewCompat.offsetTopAndBottom(r11, -r22);
        setStateInternal(4);
    L30:
        if (this.s == true) goto L32;
        return;
    L32:
        r15[1] = r14;
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L33
    L14:
        if (r20 >= getExpandedOffset()) goto L17;
        int r23 = r19 - getExpandedOffset();
        r15[1] = r23;
        ViewCompat.offsetTopAndBottom(r11, -r23);
        setStateInternal(3);
        goto L33
    L17:
        if (this.s == true) goto L19;
        return;
    L19:
        r15[1] = r14;
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L33
    L8:
        r18 = null;
        goto L9
    }
}
