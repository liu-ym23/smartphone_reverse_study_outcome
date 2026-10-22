package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.obric.oui.titlebar.OUnitedTitleBar;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import k0.f;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f6659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SavedState f6660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference<View> f6661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6662o;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean C(View r8) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
            return L();
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int E(View r8) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
            int r11 = -r10.getDownNestedScrollRange();
            return r10.getTopInset() + r11;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int F(View r8) {
            return ((OUnitedTitleBar) r8).getTotalScrollRange();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void G(View r8, CoordinatorLayout r10) {
            R(r10, (OUnitedTitleBar) r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ int I(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            return Q(r8, (OUnitedTitleBar) r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, vc.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ boolean h(CoordinatorLayout r8, View r10, int r11) {
            M(r8, (OUnitedTitleBar) r10, r11);
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) r14.getLayoutParams())).height != (-2)) goto L6;
            r8.r(r14, r11, r12, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        L6:
            return false;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ void l(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            N(r8, (OUnitedTitleBar) r10, r13, r14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void o(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int r14, int r15, int r16) {
            OUnitedTitleBar r17 = (OUnitedTitleBar) r10;
            if (r15 >= 0) goto L5;
            H(r8, r17, r15, -r17.getDownNestedScrollRange(), 0);
        L5:
            if (r15 != 0) goto L8;
            S(r8, r17);
            return;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void r(CoordinatorLayout r8, View r10, Parcelable r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            if ((r11 instanceof SavedState) == false) goto L5;
            this.f6660m = (SavedState) r11;
            return;
        L5:
            this.f6660m = null;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ Parcelable s(View r8, CoordinatorLayout r10) {
            return O((OUnitedTitleBar) r8);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ boolean u(CoordinatorLayout r8, View r10, View r11, View r12, int r13, int r14) {
            return P(r8, (OUnitedTitleBar) r10, r11, r13, r14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void w(CoordinatorLayout r8, View r10, View r11, int r12) {
            OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
            if (this.f6658k != 0) goto L5;
        L6:
            R(r8, r13);
        L7:
            this.f6661n = new WeakReference(r11);
            return;
        L5:
            if (r12 != 1) goto L7;
            goto L6
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f6663m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6664n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6665o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f6666p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f6667q;

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
            boolean r11 = true;
            if (r8.readByte() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.f6663m = r12;
            if (r8.readByte() == 0) goto L9;
            boolean r13 = true;
        L10:
            this.f6664n = r13;
            this.f6665o = r8.readInt();
            this.f6666p = r8.readFloat();
            if (r8.readByte() != 0) goto L14;
            r11 = false;
        L14:
            this.f6667q = r11;
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
            r8.writeByte(this.f6663m ? 1 : 0);
            r8.writeByte(this.f6664n ? 1 : 0);
            r8.writeInt(this.f6665o);
            r8.writeFloat(this.f6666p);
            r8.writeByte(this.f6667q ? 1 : 0);
        }
    }

    public class a extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f6668d;

        public a(BaseBehavior r8) {
            this.f6668d = r8;
        }

        @Override // j0.a
        public final void d(View r8, f r10) {
            AccessibilityNodeInfo r11 = r10.f8890a;
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
            r10.j(this.f6668d.f6662o);
            r10.f(ScrollView.class.getName());
        }
    }

    public static abstract class b {
    }

    public static class c extends b {
        public final void a(OUnitedTitleBar r8, View r10, float r11) {
            throw null;
        }
    }

    public static class d extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6669a;

        public d(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f6669a = 1;
            TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7760a);
            this.f6669a = r11.getInt(1, 0);
            if (r11.hasValue(2) == false) goto L5;
            AnimationUtils.loadInterpolator(r8, r11.getResourceId(2, 0));
        L5:
            r11.recycle();
        }

        public final c a() {
            return null;
        }

        public final int b() {
            return this.f6669a;
        }

        public d(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f6669a = 1;
        }
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    public static void T(OUnitedTitleBar r8, int r10, int r11, boolean r12) {
        int r13 = Math.abs(r10);
        int r14 = r8.getChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L10;
        View r16 = r8.getChildAt(r15);
        if (r13 < r16.getTop()) goto L9;
        if (r13 > r16.getBottom()) goto L9;
    L11:
        if (r16 == null) goto L22;
        int r17 = ((d) r16.getLayoutParams()).f6669a;
        if ((r17 & 1) == 0) goto L22;
        WeakHashMap<View, h0> r18 = w.f8437a;
        w.d.d(r16);
        if (r11 <= 0) goto L20;
        if ((r17 & 12) == 0) goto L20;
    L21:
        r16.getBottom();
        r8.getTopInset();
    L20:
        if ((r17 & 2) != 0) goto L21;
    L22:
        if (r12 == true) goto L25;
        return;
    L25:
        if (r8.getBackground() == null) goto L28;
        r8.getBackground().jumpToCurrentState();
    L28:
        if (r8.getForeground() == null) goto L31;
        r8.getForeground().jumpToCurrentState();
    L31:
        if (r8.getStateListAnimator() == null) goto L38;
        r8.getStateListAnimator().jumpToCurrentState();
        return;
    L38:
        return;
    L9:
        r15 = r15 + 1;
        goto L3
    L10:
        r16 = null;
        goto L11
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean C(View r8) {
        OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
        return L();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int E(View r8) {
        OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
        int r11 = -r10.getDownNestedScrollRange();
        return r10.getTopInset() + r11;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int F(View r8) {
        return ((OUnitedTitleBar) r8).getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public void G(View r8, CoordinatorLayout r10) {
        R(r10, (OUnitedTitleBar) r8);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int I(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
        return Q(r8, (OUnitedTitleBar) r10, r11, r12, r13);
    }

    public final void K(CoordinatorLayout r8, OUnitedTitleBar r10, int r11) {
        int r12 = Math.abs(z() - r11);
        float r13 = Math.abs(0.0f);
        float r14 = r12;
        if (r13 <= 0.0f) goto L5;
        int r15 = Math.round((r14 / r13) * 1000.0f) * 3;
    L6:
        int r16 = z();
        if (r16 != r11) goto L13;
        ValueAnimator r17 = this.f6659l;
        if (r17 != null) goto L11;
        return;
    L11:
        if (r17.isRunning() == false) goto L20;
        this.f6659l.cancel();
        return;
    L20:
        return;
    L13:
        ValueAnimator r18 = this.f6659l;
        if (r18 != null) goto L16;
        ValueAnimator r19 = new ValueAnimator();
        this.f6659l = r19;
        r19.setInterpolator(h9.a.f7947e);
        this.f6659l.addUpdateListener(new vc.a(this, r8, r10));
    L17:
        this.f6659l.setDuration(Math.min(r15, 600));
        this.f6659l.setIntValues(new int[]{r16, r11});
        this.f6659l.start();
        return;
    L16:
        r18.cancel();
        goto L17
    L5:
        r15 = (int) (((r14 / r10.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    public final boolean L() {
        WeakReference<View> r8 = this.f6661n;
        if (r8 == null) goto L12;
        View r10 = r8.get();
        if (r10 != null) goto L7;
    L11:
        return false;
    L7:
        if (r10.isShown() == false) goto L11;
        if (r10.canScrollVertically(-1) == true) goto L11;
    L12:
        return true;
    }

    public final boolean M(CoordinatorLayout r8, T r10, int r11) {
        super.h(r8, r10, r11);
        int r12 = r10.getPendingAction();
        SavedState r13 = this.f6660m;
        if (r13 != null) goto L5;
    L17:
        if (r12 != 0) goto L19;
    L33:
        r10.f6644u = 0;
        this.f6660m = null;
        B(t2.b.p(y(), -r10.getTotalScrollRange(), 0));
        T(r10, y(), 0, true);
        y();
        S(r8, r10);
        return true;
    L19:
        if ((r12 & 4) == 0) goto L21;
        boolean r14 = true;
    L23:
        if ((r12 & 1) == 0) goto L29;
        int r15 = -r10.getUpNestedPreScrollRange();
        if (r14 == false) goto L27;
        K(r8, r10, r15);
    L27:
        J(r8, r10, r15);
        goto L33
    L29:
        if ((r12 & 16) == 0) goto L33;
        if (r14 == false) goto L32;
        K(r8, r10, 0);
    L32:
        J(r8, r10, 0);
        goto L33
    L21:
        r14 = false;
        goto L23
    L5:
        if ((r12 & 8) != 0) goto L17;
        if (r13.f6663m == false) goto L10;
        r15 = -r10.getTotalScrollRange();
        goto L27
    L10:
        if (r13.f6664n == true) goto L32;
        View r16 = r10.getChildAt(r13.f6665o);
        int r17 = -r16.getBottom();
        if (this.f6660m.f6667q == false) goto L15;
        WeakHashMap<View, h0> r18 = w.f8437a;
        int r19 = (r10.getTopInset() + w.d.d(r16)) + r17;
    L16:
        J(r8, r10, r19);
        goto L33
    L15:
        r19 = Math.round(r16.getHeight() * this.f6660m.f6666p) + r17;
        goto L16
    }

    public final void N(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int[] r13) {
        if (r12 == 0) goto L9;
        if (r12 >= 0) goto L5;
        int r8 = -r11.getTotalScrollRange();
        int r14 = r11.getDownNestedPreScrollRange() + r8;
    L6:
        int r15 = r8;
        int r16 = r14;
        if (r15 == r16) goto L9;
        r13[1] = H(r10, r11, r12, r15, r16);
        goto L9
    L5:
        r8 = -r11.getUpNestedPreScrollRange();
        r14 = 0;
    L9:
        r11.getClass();
    }

    public final Parcelable O(OUnitedTitleBar r10) {
        android.view.AbsSavedState r8 = View.BaseSavedState.EMPTY_STATE;
        int r11 = y();
        int r12 = r10.getChildCount();
        boolean r13 = false;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L26;
        View r15 = r10.getChildAt(r14);
        int r16 = r15.getBottom() + r11;
        if ((r15.getTop() + r11) > 0) goto L25;
        if (r16 < 0) goto L25;
        if (r8 != null) goto L10;
        Parcelable r17 = AbsSavedState.f1730b;
    L11:
        SavedState r18 = new SavedState(r17);
        if (r11 != 0) goto L14;
        boolean r19 = true;
    L15:
        r18.f6664n = r19;
        if (r19 == false) goto L18;
    L20:
        boolean r20 = false;
    L21:
        r18.f6663m = r20;
        r18.f6665o = r14;
        WeakHashMap<View, h0> r21 = w.f8437a;
        if (r16 != (r10.getTopInset() + w.d.d(r15))) goto L24;
        r13 = true;
    L24:
        r18.f6667q = r13;
        r18.f6666p = r16 / r15.getHeight();
    L27:
        if (r18 != null) goto L30;
        return r8;
    L30:
        return r18;
    L18:
        if ((-r11) < r10.getTotalScrollRange()) goto L20;
        r20 = true;
        goto L21
    L14:
        r19 = false;
        goto L15
    L10:
        r17 = r8;
    L25:
        r14 = r14 + 1;
        goto L3
    L26:
        r18 = null;
        goto L27
    }

    public final boolean P(CoordinatorLayout r8, OUnitedTitleBar r10, View r11, int r12, int r13) {
        boolean r14 = false;
        if ((r12 & 2) != 0) goto L5;
    L15:
        if (r14 == false) goto L19;
        ValueAnimator r15 = this.f6659l;
        if (r15 == null) goto L19;
        r15.cancel();
    L19:
        this.f6661n = null;
        this.f6658k = r13;
        return r14;
    L5:
        if (r10.getTotalScrollRange() == 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L10;
    L12:
        boolean r17 = false;
    L13:
        if (r17 == false) goto L15;
        r14 = true;
        goto L15
    L10:
        if ((r8.getHeight() - r11.getHeight()) > r10.getHeight()) goto L12;
        r17 = true;
        goto L13
    L7:
        r16 = false;
        goto L8
    }

    public final int Q(CoordinatorLayout r8, T r10, int r11, int r12, int r13) {
        int r14 = z();
        int r15 = 0;
        if (r12 == 0) goto L23;
        if (r14 < r12) goto L23;
        if (r14 > r13) goto L23;
        int r16 = t2.b.p(r11, r12, r13);
        if (r14 == r16) goto L24;
        r10.getClass();
        boolean r17 = B(r16);
        int r18 = r14 - r16;
        this.f6657j = r16 - r16;
        int r19 = 1;
        if (r17 == false) goto L19;
        int r110 = 0;
    L12:
        if (r110 >= r10.getChildCount()) goto L19;
        d r20 = (d) r10.getChildAt(r110).getLayoutParams();
        c r21 = r20.a();
        if (r21 == null) goto L18;
        if ((r20.b() & 1) == 0) goto L18;
        r21.a(r10, r10.getChildAt(r110), y());
    L18:
        r110 = r110 + 1;
    L19:
        y();
        if (r16 >= r14) goto L22;
        r19 = -1;
    L22:
        T(r10, r16, r19, false);
        r15 = r18;
    L24:
        S(r8, r10);
        return r15;
    L23:
        this.f6657j = 0;
        goto L24
    }

    public final void R(CoordinatorLayout r14, T r15) {
        int r8 = r15.getPaddingTop() + r15.getTopInset();
        int r10 = z() - r8;
        int r11 = r15.getChildCount();
        int r12 = 0;
    L3:
        boolean r13 = true;
        if (r12 >= r11) goto L16;
        View r16 = r15.getChildAt(r12);
        int r17 = r16.getTop();
        int r18 = r16.getBottom();
        d r19 = (d) r16.getLayoutParams();
        if ((r19.f6669a & 32) != 32) goto L8;
        boolean r110 = true;
    L9:
        if (r110 == false) goto L11;
        r17 = r17 - ((FrameLayout.LayoutParams) r19).topMargin;
        r18 = r18 + ((FrameLayout.LayoutParams) r19).bottomMargin;
    L11:
        int r20 = -r10;
        if (r17 > r20) goto L15;
        if (r18 < r20) goto L15;
    L17:
        if (r12 < 0) goto L57;
        View r21 = r15.getChildAt(r12);
        d r22 = (d) r21.getLayoutParams();
        int r23 = r22.f6669a;
        if ((r23 & 17) != 17) goto L58;
        int r24 = -r21.getTop();
        int r111 = -r21.getBottom();
        if (r12 != 0) goto L28;
        WeakHashMap<View, h0> r25 = w.f8437a;
        if (w.d.b(r15) == false) goto L28;
        if (w.d.b(r21) == false) goto L28;
        r24 = r24 - r15.getTopInset();
    L28:
        if ((r23 & 2) != 2) goto L30;
        boolean r26 = true;
    L31:
        if (r26 == false) goto L34;
        WeakHashMap<View, h0> r27 = w.f8437a;
        r111 = r111 + w.d.d(r21);
    L43:
        if ((r23 & 32) == 32) goto L46;
        r13 = false;
    L46:
        if (r13 == false) goto L49;
        r24 = r24 + ((FrameLayout.LayoutParams) r22).topMargin;
        r111 = r111 - ((FrameLayout.LayoutParams) r22).bottomMargin;
    L49:
        if (r10 >= ((r111 + r24) / 2)) goto L51;
        r24 = r111;
    L51:
        K(r14, r15, t2.b.p(r24 + r8, -r15.getTotalScrollRange(), 0));
        return;
    L34:
        if ((r23 & 5) != 5) goto L36;
        boolean r28 = true;
    L37:
        if (r28 == false) goto L43;
        WeakHashMap<View, h0> r29 = w.f8437a;
        int r30 = w.d.d(r21) + r111;
        if (r10 >= r30) goto L41;
        r24 = r30;
        goto L43
    L41:
        r111 = r30;
        goto L43
    L36:
        r28 = false;
        goto L37
    L30:
        r26 = false;
        goto L31
    L58:
        return;
    L57:
        return;
    L15:
        r12 = r12 + 1;
        goto L3
    L8:
        r110 = false;
        goto L9
    L16:
        r12 = -1;
        goto L17
    }

    public final void S(CoordinatorLayout r11, T r12) {
        w.k(r11, f.a.f8894f.a());
        boolean r8 = false;
        w.i(r11, 0);
        w.k(r11, f.a.f8895g.a());
        w.i(r11, 0);
        if (r12.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        int r10 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L11;
        View r14 = r11.getChildAt(r13);
        if ((((CoordinatorLayout.f) r14.getLayoutParams()).f1563a instanceof ScrollingViewBehavior) == true) goto L12;
        r13 = r13 + 1;
    L12:
        View r15 = r14;
        if (r15 != null) goto L15;
        return;
    L15:
        int r16 = r12.getChildCount();
        int r17 = 0;
    L16:
        boolean r18 = true;
        if (r17 >= r16) goto L22;
        if (((d) r12.getChildAt(r17).getLayoutParams()).f6669a != 0) goto L20;
        r17 = r17 + 1;
        goto L16
    L20:
        boolean r19 = true;
    L23:
        if (r19 == true) goto L26;
        return;
    L26:
        if (w.m.a(r11) == null) goto L28;
        boolean r20 = true;
    L29:
        if (r20 == true) goto L32;
        w.m(r11, new a(this));
    L32:
        if (z() == (-r12.getTotalScrollRange())) goto L35;
        w.l(r11, f.a.f8894f, new vc.c(r12, false));
        r8 = true;
    L35:
        if (z() != 0) goto L37;
    L42:
        r18 = r8;
    L43:
        this.f6662o = r18;
        return;
    L37:
        if (r15.canScrollVertically(-1) == false) goto L41;
        int r21 = -r12.getDownNestedPreScrollRange();
        if (r21 == 0) goto L42;
        w.l(r11, f.a.f8895g, new vc.b(this, r11, r12, r15, r21));
        goto L43
    L41:
        w.l(r11, f.a.f8895g, new vc.c(r12, true));
        goto L43
    L28:
        r20 = false;
        goto L29
    L22:
        r19 = false;
        goto L23
    L11:
        r14 = null;
        goto L12
    }

    @Override // vc.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout r8, View r10, int r11) {
        M(r8, (OUnitedTitleBar) r10, r11);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
        OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) r14.getLayoutParams())).height != (-2)) goto L6;
        r8.r(r14, r11, r12, View.MeasureSpec.makeMeasureSpec(0, 0));
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public /* bridge */ /* synthetic */ void l(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int[] r14, int r15) {
        N(r8, (OUnitedTitleBar) r10, r13, r14);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void o(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int r14, int r15, int r16) {
        OUnitedTitleBar r17 = (OUnitedTitleBar) r10;
        if (r15 >= 0) goto L5;
        H(r8, r17, r15, -r17.getDownNestedScrollRange(), 0);
    L5:
        if (r15 != 0) goto L8;
        S(r8, r17);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout r8, View r10, Parcelable r11) {
        OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
        if ((r11 instanceof SavedState) == false) goto L5;
        this.f6660m = (SavedState) r11;
        return;
    L5:
        this.f6660m = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public /* bridge */ /* synthetic */ Parcelable s(View r8, CoordinatorLayout r10) {
        return O((OUnitedTitleBar) r8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public /* bridge */ /* synthetic */ boolean u(CoordinatorLayout r8, View r10, View r11, View r12, int r13, int r14) {
        return P(r8, (OUnitedTitleBar) r10, r11, r13, r14);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout r8, View r10, View r11, int r12) {
        OUnitedTitleBar r13 = (OUnitedTitleBar) r10;
        if (this.f6658k != 0) goto L5;
    L6:
        R(r8, r13);
    L7:
        this.f6661n = new WeakReference(r11);
        return;
    L5:
        if (r12 != 1) goto L7;
        goto L6
    }

    @Override // vc.d
    public final int z() {
        return y() + this.f6657j;
    }
}
