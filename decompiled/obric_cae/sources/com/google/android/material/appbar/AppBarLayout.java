package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import j0.h0;
import j0.l;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k0.f;

/* JADX INFO: loaded from: classes.dex */
public final class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4278b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4286t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4287u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference<View> f4288v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f4289w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f4290x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f4291y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Behavior f4292z;

    public static class BaseBehavior<T extends AppBarLayout> extends i9.a<T> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4293j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4294k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ValueAnimator f4295l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SavedState f4296m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public WeakReference<View> f4297n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f4298o;

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public boolean f4299m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public boolean f4300n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public int f4301o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public float f4302p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public boolean f4303q;

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
                this.f4299m = r12;
                if (r8.readByte() == 0) goto L9;
                boolean r13 = true;
            L10:
                this.f4300n = r13;
                this.f4301o = r8.readInt();
                this.f4302p = r8.readFloat();
                if (r8.readByte() != 0) goto L14;
                r11 = false;
            L14:
                this.f4303q = r11;
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
                r8.writeByte(this.f4299m ? 1 : 0);
                r8.writeByte(this.f4300n ? 1 : 0);
                r8.writeInt(this.f4301o);
                r8.writeFloat(this.f4302p);
                r8.writeByte(this.f4303q ? 1 : 0);
            }
        }

        public class a extends j0.a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ BaseBehavior f4304d;

            public a(BaseBehavior r8) {
                this.f4304d = r8;
            }

            @Override // j0.a
            public final void d(View r8, f r10) {
                AccessibilityNodeInfo r11 = r10.f8890a;
                this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
                r10.j(this.f4304d.f4298o);
                r10.f(ScrollView.class.getName());
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }

        @Override // i9.a
        public final boolean C(View r8) {
            AppBarLayout r10 = (AppBarLayout) r8;
            WeakReference<View> r11 = this.f4297n;
            if (r11 == null) goto L12;
            View r12 = r11.get();
            if (r12 != null) goto L7;
        L11:
            return false;
        L7:
            if (r12.isShown() == false) goto L11;
            if (r12.canScrollVertically(-1) == true) goto L11;
        L12:
            return true;
        }

        @Override // i9.a
        public final int D(View r8) {
            AppBarLayout r10 = (AppBarLayout) r8;
            int r11 = -r10.getDownNestedScrollRange();
            return r10.getTopInset() + r11;
        }

        @Override // i9.a
        public final int E(View r8) {
            return ((AppBarLayout) r8).getTotalScrollRange();
        }

        @Override // i9.a
        public final void F(View r8, CoordinatorLayout r10) {
            AppBarLayout r11 = (AppBarLayout) r8;
            M(r10, r11);
            if (r11.f4286t == false) goto L6;
            r11.e(r11.f(J(r10)));
            return;
        }

        @Override // i9.a
        public final int G(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            AppBarLayout r14 = (AppBarLayout) r10;
            int r15 = z();
            int r16 = 0;
            if (r12 == 0) goto L49;
            if (r15 < r12) goto L49;
            if (r15 > r13) goto L49;
            int r17 = t2.b.p(r11, r12, r13);
            if (r15 != r17) goto L9;
        L50:
            N(r8, r14);
            return r16;
        L9:
            if (r14.f4281o == false) goto L29;
            int r18 = Math.abs(r17);
            int r19 = r14.getChildCount();
            int r110 = 0;
        L11:
            if (r110 >= r19) goto L29;
            View r20 = r14.getChildAt(r110);
            c r21 = (c) r20.getLayoutParams();
            Interpolator r22 = r21.c();
            if (r18 < r20.getTop()) goto L28;
            if (r18 > r20.getBottom()) goto L28;
            if (r22 == null) goto L29;
            int r111 = r21.b();
            if ((r111 & 1) == 0) goto L22;
            int r112 = ((r20.getHeight() + ((LinearLayout.LayoutParams) r21).topMargin) + ((LinearLayout.LayoutParams) r21).bottomMargin) + 0;
            if ((r111 & 2) == 0) goto L24;
            r112 = r112 - w.g(r20);
        L24:
            if (w.e(r20) == false) goto L26;
            r112 = r112 - r14.getTopInset();
        L26:
            if (r112 <= 0) goto L29;
            float r113 = r112;
            int r114 = Math.round(r22.getInterpolation((r18 - r20.getTop()) / r113) * r113);
            int r115 = (r20.getTop() + r114) * Integer.signum(r17);
        L30:
            boolean r116 = B(r115);
            int r117 = r15 - r17;
            this.f4293j = r17 - r115;
            if (r116 == true) goto L33;
        L40:
            if (r116 == false) goto L42;
        L44:
            r14.d(y());
            if (r17 >= r15) goto L47;
            int r23 = -1;
        L48:
            O(r8, r14, r17, r23, false);
            r16 = r117;
            goto L50
        L47:
            r23 = 1;
            goto L48
        L42:
            if (r14.b() == false) goto L44;
            r8.c(r14);
        L33:
            if (r16 >= r14.getChildCount()) goto L40;
            c r24 = (c) r14.getChildAt(r16).getLayoutParams();
            b r25 = r24.a();
            if (r25 == null) goto L39;
            if ((r24.b() & 1) == 0) goto L39;
            r25.a(r14, r14.getChildAt(r16), y());
        L39:
            r16 = r16 + 1;
            goto L33
        L22:
            r112 = 0;
        L28:
            r110 = r110 + 1;
        L29:
            r115 = r17;
        L49:
            this.f4293j = 0;
            goto L50
        }

        public final void I(CoordinatorLayout r8, AppBarLayout r10, int r11) {
            int r12 = Math.abs(z() - r11);
            float r13 = Math.abs(0.0f);
            float r14 = r12;
            if (r13 <= 0.0f) goto L5;
            int r15 = Math.round((r14 / r13) * 1000.0f) * 3;
        L6:
            int r16 = z();
            if (r16 != r11) goto L13;
            ValueAnimator r17 = this.f4295l;
            if (r17 != null) goto L11;
            return;
        L11:
            if (r17.isRunning() == false) goto L20;
            this.f4295l.cancel();
            return;
        L20:
            return;
        L13:
            ValueAnimator r18 = this.f4295l;
            if (r18 != null) goto L16;
            ValueAnimator r19 = new ValueAnimator();
            this.f4295l = r19;
            r19.setInterpolator(h9.a.f7947e);
            this.f4295l.addUpdateListener(new com.google.android.material.appbar.a(this, r8, r10));
        L17:
            this.f4295l.setDuration(Math.min(r15, 600));
            this.f4295l.setIntValues(new int[]{r16, r11});
            this.f4295l.start();
            return;
        L16:
            r18.cancel();
            goto L17
        L5:
            r15 = (int) (((r14 / r10.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        public final View J(CoordinatorLayout r8) {
            int r10 = r8.getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L13;
            View r12 = r8.getChildAt(r11);
            if ((r12 instanceof l) == true) goto L12;
            if ((r12 instanceof AbsListView) == true) goto L12;
            if ((r12 instanceof ScrollView) == true) goto L12;
            r11 = r11 + 1;
        L12:
            return r12;
        L13:
            return null;
        }

        public final void K(CoordinatorLayout r10, AppBarLayout r11, View r12, int r13, int[] r14) {
            if (r13 == 0) goto L10;
            if (r13 >= 0) goto L5;
            int r8 = -r11.getTotalScrollRange();
            int r15 = r11.getDownNestedPreScrollRange() + r8;
        L6:
            int r16 = r8;
            int r17 = r15;
            if (r16 == r17) goto L10;
            r14[1] = G(r10, r11, z() - r13, r16, r17);
            goto L10
        L5:
            r8 = -r11.getUpNestedPreScrollRange();
            r15 = 0;
        L10:
            if (r11.f4286t == false) goto L13;
            r11.e(r11.f(r12));
            return;
        }

        public final SavedState L(Parcelable r8, T r10) {
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
            r8 = AbsSavedState.f1730b;
        L10:
            SavedState r17 = new SavedState(r8);
            if (r11 != 0) goto L13;
            boolean r18 = true;
        L14:
            r17.f4300n = r18;
            if (r18 == false) goto L17;
        L19:
            boolean r19 = false;
        L20:
            r17.f4299m = r19;
            r17.f4301o = r14;
            WeakHashMap<View, h0> r20 = w.f8437a;
            if (r16 != (r10.getTopInset() + w.d.d(r15))) goto L23;
            r13 = true;
        L23:
            r17.f4303q = r13;
            r17.f4302p = r16 / r15.getHeight();
            return r17;
        L17:
            if ((-r11) < r10.getTotalScrollRange()) goto L19;
            r19 = true;
            goto L20
        L13:
            r18 = false;
        L25:
            r14 = r14 + 1;
            goto L3
        L26:
            return null;
        }

        public final void M(CoordinatorLayout r14, T r15) {
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
            c r19 = (c) r16.getLayoutParams();
            if ((r19.f4307a & 32) != 32) goto L8;
            boolean r110 = true;
        L9:
            if (r110 == false) goto L11;
            r17 = r17 - ((LinearLayout.LayoutParams) r19).topMargin;
            r18 = r18 + ((LinearLayout.LayoutParams) r19).bottomMargin;
        L11:
            int r20 = -r10;
            if (r17 > r20) goto L15;
            if (r18 < r20) goto L15;
        L17:
            if (r12 < 0) goto L57;
            View r21 = r15.getChildAt(r12);
            c r22 = (c) r21.getLayoutParams();
            int r23 = r22.f4307a;
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
            r24 = r24 + ((LinearLayout.LayoutParams) r22).topMargin;
            r111 = r111 - ((LinearLayout.LayoutParams) r22).bottomMargin;
        L49:
            if (r10 >= ((r111 + r24) / 2)) goto L51;
            r24 = r111;
        L51:
            I(r14, r15, t2.b.p(r24 + r8, -r15.getTotalScrollRange(), 0));
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

        public final void N(CoordinatorLayout r11, T r12) {
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
            if (((c) r12.getChildAt(r17).getLayoutParams()).f4307a != 0) goto L20;
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
            w.l(r11, f.a.f8894f, new com.google.android.material.appbar.c(r12, false));
            r8 = true;
        L35:
            if (z() != 0) goto L37;
        L42:
            r18 = r8;
        L43:
            this.f4298o = r18;
            return;
        L37:
            if (r15.canScrollVertically(-1) == false) goto L41;
            int r21 = -r12.getDownNestedPreScrollRange();
            if (r21 == 0) goto L42;
            w.l(r11, f.a.f8895g, new com.google.android.material.appbar.b(this, r11, r12, r15, r21));
            goto L43
        L41:
            w.l(r11, f.a.f8895g, new com.google.android.material.appbar.c(r12, true));
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

        public final void O(CoordinatorLayout r8, T r10, int r11, int r12, boolean r13) {
            int r14 = Math.abs(r11);
            int r15 = r10.getChildCount();
            boolean r16 = false;
            int r17 = 0;
        L4:
            if (r17 >= r15) goto L11;
            View r18 = r10.getChildAt(r17);
            if (r14 < r18.getTop()) goto L10;
            if (r14 > r18.getBottom()) goto L10;
        L13:
            if (r18 == null) goto L28;
            int r19 = ((c) r18.getLayoutParams()).f4307a;
            if ((r19 & 1) == 0) goto L28;
            WeakHashMap<View, h0> r20 = w.f8437a;
            int r21 = w.d.d(r18);
            if (r12 <= 0) goto L24;
            if ((r19 & 12) == 0) goto L24;
            if ((-r11) < ((r18.getBottom() - r21) - r10.getTopInset())) goto L28;
        L27:
            boolean r110 = true;
        L30:
            if (r10.f4286t == false) goto L32;
            r110 = r10.f(J(r8));
        L32:
            boolean r22 = r10.e(r110);
            if (r13 == true) goto L48;
            if (r22 == false) goto L63;
            ArrayList<View> r23 = r8.f1545b.f13359b.getOrDefault(r10, null);
            ArrayList r24 = r8.f1547n;
            r24.clear();
            if (r23 == null) goto L38;
            r24.addAll(r23);
        L38:
            int r25 = r24.size();
            int r111 = 0;
        L39:
            if (r111 >= r25) goto L46;
            CoordinatorLayout.c r112 = ((CoordinatorLayout.f) ((View) r24.get(r111)).getLayoutParams()).f1563a;
            if ((r112 instanceof ScrollingViewBehavior) == true) goto L43;
            r111 = r111 + 1;
            goto L39
        L43:
            if (((ScrollingViewBehavior) r112).f8295f == 0) goto L46;
            r16 = true;
        L46:
            if (r16 == true) goto L48;
            return;
        L63:
            return;
        L48:
            if (r10.getBackground() == null) goto L51;
            r10.getBackground().jumpToCurrentState();
        L51:
            if (r10.getForeground() == null) goto L54;
            r10.getForeground().jumpToCurrentState();
        L54:
            if (r10.getStateListAnimator() == null) goto L65;
            r10.getStateListAnimator().jumpToCurrentState();
            return;
        L65:
            return;
        L24:
            if ((r19 & 2) == 0) goto L28;
            if ((-r11) >= ((r18.getBottom() - r21) - r10.getTopInset())) goto L27;
        L28:
            r110 = false;
        L10:
            r17 = r17 + 1;
            goto L4
        L11:
            r18 = null;
            goto L13
        }

        @Override // i9.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout r8, View r10, int r11) {
            AppBarLayout r12 = (AppBarLayout) r10;
            super.h(r8, r12, r11);
            int r13 = r12.getPendingAction();
            SavedState r14 = this.f4296m;
            if (r14 != null) goto L5;
        L17:
            if (r13 != 0) goto L19;
        L33:
            r12.f4282p = 0;
            this.f4296m = null;
            B(t2.b.p(y(), -r12.getTotalScrollRange(), 0));
            O(r8, r12, y(), 0, true);
            r12.d(y());
            N(r8, r12);
            return true;
        L19:
            if ((r13 & 4) == 0) goto L21;
            boolean r15 = true;
        L23:
            if ((r13 & 2) == 0) goto L29;
            int r16 = -r12.getUpNestedPreScrollRange();
            if (r15 == false) goto L27;
            I(r8, r12, r16);
        L27:
            H(r8, r12, r16);
            goto L33
        L29:
            if ((r13 & 1) == 0) goto L33;
            if (r15 == false) goto L32;
            I(r8, r12, 0);
        L32:
            H(r8, r12, 0);
            goto L33
        L21:
            r15 = false;
            goto L23
        L5:
            if ((r13 & 8) != 0) goto L17;
            if (r14.f4299m == false) goto L10;
            r16 = -r12.getTotalScrollRange();
            goto L27
        L10:
            if (r14.f4300n == true) goto L32;
            View r17 = r12.getChildAt(r14.f4301o);
            int r18 = -r17.getBottom();
            if (this.f4296m.f4303q == false) goto L15;
            WeakHashMap<View, h0> r19 = w.f8437a;
            int r20 = (r12.getTopInset() + w.d.d(r17)) + r18;
        L16:
            H(r8, r12, r20);
            goto L33
        L15:
            r20 = Math.round(r17.getHeight() * this.f4296m.f4302p) + r18;
            goto L16
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
            AppBarLayout r14 = (AppBarLayout) r10;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) r14.getLayoutParams())).height != (-2)) goto L6;
            r8.r(r14, r11, r12, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        L6:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ void l(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            K(r8, (AppBarLayout) r10, r11, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void p(CoordinatorLayout r8, View r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
            AppBarLayout r18 = (AppBarLayout) r10;
            if (r15 >= 0) goto L5;
            int r19 = -r18.getDownNestedScrollRange();
            r17[1] = G(r8, r18, z() - r15, r19, 0);
        L5:
            if (r15 != 0) goto L8;
            N(r8, r18);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void r(CoordinatorLayout r8, View r10, Parcelable r11) {
            AppBarLayout r12 = (AppBarLayout) r10;
            if ((r11 instanceof SavedState) == false) goto L5;
            SavedState r13 = this.f4296m;
            this.f4296m = (SavedState) r11;
            return;
        L5:
            this.f4296m = null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final Parcelable s(View r8, CoordinatorLayout r10) {
            android.view.AbsSavedState r11 = View.BaseSavedState.EMPTY_STATE;
            SavedState r12 = L(r11, (AppBarLayout) r8);
            if (r12 != null) goto L6;
            return r11;
        L6:
            return r12;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean u(CoordinatorLayout r8, View r10, View r11, View r12, int r13, int r14) {
            AppBarLayout r15 = (AppBarLayout) r10;
            int r16 = r13 & 2;
            boolean r17 = false;
            if (r16 != 0) goto L5;
        L17:
            if (r17 == false) goto L21;
            ValueAnimator r18 = this.f4295l;
            if (r18 == null) goto L21;
            r18.cancel();
        L21:
            this.f4297n = null;
            this.f4294k = r14;
            return r17;
        L5:
            if (r15.f4286t == false) goto L7;
        L16:
            r17 = true;
            goto L17
        L7:
            if (r15.getTotalScrollRange() == 0) goto L9;
            boolean r19 = true;
        L10:
            if (r19 == true) goto L12;
        L14:
            boolean r20 = false;
        L15:
            if (r20 == false) goto L17;
        L12:
            if ((r8.getHeight() - r11.getHeight()) > r15.getHeight()) goto L14;
            r20 = true;
            goto L15
        L9:
            r19 = false;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void w(CoordinatorLayout r8, View r10, View r11, int r12) {
            AppBarLayout r13 = (AppBarLayout) r10;
            if (this.f4294k != 0) goto L5;
        L6:
            M(r8, r13);
            if (r13.f4286t == false) goto L9;
            r13.e(r13.f(r11));
        L9:
            this.f4297n = new WeakReference(r11);
            return;
        L5:
            if (r12 != 1) goto L9;
            goto L6
        }

        @Override // i9.c
        public final int z() {
            return y() + this.f4293j;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }
    }

    public static class ScrollingViewBehavior extends i9.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context r8, AttributeSet r10) {
            super(r8, r10);
            TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7781v);
            this.f8295f = r11.getDimensionPixelSize(0, 0);
            r11.recycle();
        }

        @Override // i9.b
        public final View C(ArrayList r8) {
            int r10 = r8.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            View r12 = (View) r8.get(r11);
            if ((r12 instanceof AppBarLayout) == true) goto L12;
            r11 = r11 + 1;
            goto L3
        L12:
            return (AppBarLayout) r12;
        L8:
            return null;
        }

        @Override // i9.b
        public final float D(View r8) {
            if ((r8 instanceof AppBarLayout) == false) goto L16;
            AppBarLayout r10 = (AppBarLayout) r8;
            int r11 = r10.getTotalScrollRange();
            int r12 = r10.getDownNestedPreScrollRange();
            CoordinatorLayout.c r13 = ((CoordinatorLayout.f) r10.getLayoutParams()).f1563a;
            if ((r13 instanceof BaseBehavior) == false) goto L7;
            int r14 = ((BaseBehavior) r13).z();
        L8:
            if (r12 != 0) goto L10;
        L12:
            int r15 = r11 - r12;
            if (r15 == 0) goto L16;
            return (r14 / r15) + 1.0f;
        L10:
            if ((r11 + r14) > r12) goto L12;
            return 0.0f;
        L7:
            r14 = 0;
        L16:
            return 0.0f;
        }

        @Override // i9.b
        public final int E(View r8) {
            if ((r8 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r8).getTotalScrollRange();
        L7:
            return r8.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean b(CoordinatorLayout r8, View r10, View r11) {
            return r11 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean d(CoordinatorLayout r8, View r10, View r11) {
            CoordinatorLayout.c r12 = ((CoordinatorLayout.f) r11.getLayoutParams()).f1563a;
            if ((r12 instanceof BaseBehavior) == false) goto L10;
            int r13 = ((r11.getBottom() - r10.getTop()) + ((BaseBehavior) r12).f4293j) + this.f8294e;
            if (this.f8295f != 0) goto L7;
            int r14 = 0;
        L8:
            int r15 = r13 - r14;
            WeakHashMap<View, h0> r16 = w.f8437a;
            r10.offsetTopAndBottom(r15);
            goto L10
        L7:
            float r17 = D(r11);
            int r18 = this.f8295f;
            r14 = t2.b.p((int) (r17 * r18), 0, r18);
        L10:
            if ((r11 instanceof AppBarLayout) == false) goto L14;
            AppBarLayout r19 = (AppBarLayout) r11;
            if (r19.f4286t == false) goto L14;
            r19.e(r19.f(r10));
        L14:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void e(CoordinatorLayout r8, View r10, View r11) {
            if ((r11 instanceof AppBarLayout) == false) goto L6;
            w.k(r8, f.a.f8894f.a());
            w.i(r8, 0);
            w.k(r8, f.a.f8895g.a());
            w.i(r8, 0);
            w.m(r8, null);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean q(CoordinatorLayout r8, View r10, Rect r11, boolean r12) {
            ArrayList r13 = r8.e(r10);
            int r14 = r13.size();
            int r15 = 0;
            int r16 = 0;
        L3:
            if (r16 >= r14) goto L8;
            View r17 = (View) r13.get(r16);
            if ((r17 instanceof AppBarLayout) == true) goto L6;
            r16 = r16 + 1;
            goto L3
        L6:
            AppBarLayout r18 = (AppBarLayout) r17;
        L9:
            if (r18 == null) goto L17;
            Rect r19 = new Rect(r11);
            r19.offset(r10.getLeft(), r10.getTop());
            int r20 = r8.getWidth();
            int r21 = r8.getHeight();
            Rect r22 = this.f8292c;
            r22.set(0, 0, r20, r21);
            if (r22.contains(r19) == true) goto L17;
            if ((!r12) == false) goto L15;
            r15 = 4;
        L15:
            r18.f4282p = (2 | r15) | 8;
            r18.requestLayout();
            return true;
        L17:
            return false;
        L8:
            r18 = null;
            goto L9
        }
    }

    public static abstract class a {
    }

    public static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f4305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f4306b;

        public b() {
            this.f4305a = new Rect();
            this.f4306b = new Rect();
        }

        public final void a(AppBarLayout r8, View r10, float r11) {
            Rect r12 = this.f4305a;
            r10.getDrawingRect(r12);
            r8.offsetDescendantRectToMyCoords(r10, r12);
            r12.offset(0, -r8.getTopInset());
            float r13 = r12.top - Math.abs(r11);
            if (r13 > 0.0f) goto L5;
            float r14 = 1.0f - t2.b.o(Math.abs(r13 / r12.height()), 0.0f, 1.0f);
            float r15 = (-r13) - ((r12.height() * 0.3f) * (1.0f - (r14 * r14)));
            r10.setTranslationY(r15);
            Rect r16 = this.f4306b;
            r10.getDrawingRect(r16);
            r16.offset(0, (int) (-r15));
            WeakHashMap<View, h0> r17 = w.f8437a;
            w.f.c(r10, r16);
            return;
        L5:
            WeakHashMap<View, h0> r18 = w.f8437a;
            w.f.c(r10, null);
            r10.setTranslationY(0.0f);
        }
    }

    public static class c extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f4308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f4309c;

        public c() {
            super(-1, -2);
            this.f4307a = 1;
        }

        public final b a() {
            return this.f4308b;
        }

        public final int b() {
            return this.f4307a;
        }

        public final Interpolator c() {
            return this.f4309c;
        }

        public c(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f4307a = 1;
            TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7760a);
            this.f4307a = r11.getInt(1, 0);
            if (r11.getInt(0, 0) == 1) goto L5;
            b r12 = null;
        L6:
            this.f4308b = r12;
            if (r11.hasValue(2) == false) goto L9;
            this.f4309c = AnimationUtils.loadInterpolator(r8, r11.getResourceId(2, 0));
        L9:
            r11.recycle();
            return;
        L5:
            r12 = new b();
            goto L6
        }

        public c(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f4307a = 1;
        }

        public c(ViewGroup.MarginLayoutParams r8) {
            super(r8);
            this.f4307a = 1;
        }

        public c(LinearLayout.LayoutParams r8) {
            super(r8);
            this.f4307a = 1;
        }
    }

    public static c a(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return new c((LinearLayout.LayoutParams) r8);
    L7:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new c((ViewGroup.MarginLayoutParams) r8);
    L11:
        return new c(r8);
    }

    public final boolean b() {
        return this.f4281o;
    }

    public final void c() {
        Behavior r8 = this.f4292z;
        if (r8 != null) goto L5;
    L10:
        BaseBehavior.SavedState r10 = null;
    L11:
        this.f4278b = -1;
        this.f4279m = -1;
        this.f4280n = -1;
        if (r10 == null) goto L18;
        Behavior r11 = this.f4292z;
        if (r11.f4296m != null) goto L19;
        r11.f4296m = r10;
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (this.f4278b == (-1)) goto L10;
        if (this.f4282p != 0) goto L10;
        r10 = r8.L(AbsSavedState.f1730b, this);
        goto L11
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof c;
    }

    public final void d(int r8) {
        this.f4277a = r8;
        if (willNotDraw() == true) goto L6;
        WeakHashMap<View, h0> r10 = w.f8437a;
        w.d.k(this);
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        if (this.f4291y != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L11;
        int r11 = r8.save();
        r8.translate(0.0f, -this.f4277a);
        this.f4291y.draw(r8);
        r8.restoreToCount(r11);
        return;
    L11:
        return;
    L5:
        if (getTopInset() <= 0) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r8 = getDrawableState();
        Drawable r10 = this.f4291y;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == true) goto L7;
        return;
    L7:
        if (r10.setState(r8) == false) goto L12;
        invalidateDrawable(r10);
        return;
    }

    public final boolean e(boolean r8) {
        if ((!this.f4283q) == true) goto L5;
    L14:
        return false;
    L5:
        if (this.f4285s == r8) goto L14;
        this.f4285s = r8;
        refreshDrawableState();
        if ((getBackground() instanceof aa.f) == true) goto L9;
        return true;
    L9:
        if (this.f4286t == false) goto L17;
        ValueAnimator r10 = this.f4289w;
        if (r10 == null) goto L13;
        r10.cancel();
    L13:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f4289w = r11;
        r11.setDuration(0);
        this.f4289w.setInterpolator(null);
        this.f4289w.start();
        return true;
    L17:
        return true;
    }

    public final boolean f(View r8) {
        View r10 = null;
        if (this.f4288v != null) goto L15;
        int r11 = this.f4287u;
        if (r11 == (-1)) goto L15;
        if (r8 == null) goto L8;
        View r12 = r8.findViewById(r11);
    L9:
        if (r12 == null) goto L11;
    L13:
        if (r12 == null) goto L15;
        this.f4288v = new WeakReference(r12);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r12 = ((ViewGroup) getParent()).findViewById(this.f4287u);
        goto L13
    L8:
        r12 = null;
    L15:
        WeakReference<View> r13 = this.f4288v;
        if (r13 == null) goto L18;
        r10 = r13.get();
    L18:
        if (r10 == null) goto L21;
        r8 = r10;
    L21:
        if (r8 != null) goto L23;
    L27:
        return false;
    L23:
        if (r8.canScrollVertically(-1) == false) goto L25;
    L26:
        return true;
    L25:
        if (r8.getScrollY() <= 0) goto L27;
        goto L26
    }

    public final boolean g() {
        if (getChildCount() <= 0) goto L10;
        View r8 = getChildAt(0);
        if (r8.getVisibility() == 8) goto L11;
        WeakHashMap<View, h0> r10 = w.f8437a;
        if (w.d.b(r8) == true) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new c(getContext(), r8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior r8 = new Behavior();
        this.f4292z = r8;
        return r8;
    }

    public int getDownNestedPreScrollRange() {
        int r8 = this.f4279m;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = getChildCount() - 1;
        int r11 = 0;
    L6:
        if (r10 < 0) goto L28;
        View r12 = getChildAt(r10);
        if (r12.getVisibility() == 8) goto L27;
        c r13 = (c) r12.getLayoutParams();
        int r14 = r12.getMeasuredHeight();
        int r15 = r13.f4307a;
        if ((r15 & 5) != 5) goto L25;
        int r16 = ((LinearLayout.LayoutParams) r13).topMargin + ((LinearLayout.LayoutParams) r13).bottomMargin;
        if ((r15 & 8) == 0) goto L17;
        WeakHashMap<View, h0> r17 = w.f8437a;
        int r18 = w.d.d(r12);
    L15:
        int r19 = r18 + r16;
    L20:
        if (r10 != 0) goto L24;
        WeakHashMap<View, h0> r20 = w.f8437a;
        if (w.d.b(r12) == false) goto L24;
        r19 = Math.min(r19, r14 - getTopInset());
    L24:
        r11 = r11 + r19;
        goto L27
    L17:
        if ((r15 & 2) == 0) goto L19;
        WeakHashMap<View, h0> r21 = w.f8437a;
        r18 = r14 - w.d.d(r12);
        goto L15
    L19:
        r19 = r16 + r14;
        goto L20
    L25:
        if (r11 > 0) goto L28;
    L27:
        r10 = r10 - 1;
    L28:
        int r22 = Math.max(0, r11);
        this.f4279m = r22;
        return r22;
    }

    public int getDownNestedScrollRange() {
        int r8 = this.f4280n;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r10) goto L16;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L15;
        c r14 = (c) r13.getLayoutParams();
        int r15 = (((LinearLayout.LayoutParams) r14).topMargin + ((LinearLayout.LayoutParams) r14).bottomMargin) + r13.getMeasuredHeight();
        int r16 = r14.f4307a;
        if ((r16 & 1) == 0) goto L16;
        r12 = r12 + r15;
        if ((r16 & 2) == 0) goto L15;
        WeakHashMap<View, h0> r17 = w.f8437a;
        r12 = r12 - w.d.d(r13);
    L15:
        r11 = r11 + 1;
    L16:
        int r18 = Math.max(0, r12);
        this.f4280n = r18;
        return r18;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f4287u;
    }

    public aa.f getMaterialShapeBackground() {
        Drawable r8 = getBackground();
        if ((r8 instanceof aa.f) == true) goto L7;
        return null;
    L7:
        return (aa.f) r8;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r8 = getTopInset();
        WeakHashMap<View, h0> r10 = w.f8437a;
        int r11 = w.d.d(this);
        if (r11 != 0) goto L5;
        int r12 = getChildCount();
        if (r12 < 1) goto L9;
        r11 = w.d.d(getChildAt(r12 - 1));
    L10:
        if (r11 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r11 = 0;
    L5:
        return (r11 * 2) + r8;
    }

    public int getPendingAction() {
        return this.f4282p;
    }

    public Drawable getStatusBarForeground() {
        return this.f4291y;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int r8 = this.f4278b;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r10) goto L21;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L20;
        c r14 = (c) r13.getLayoutParams();
        int r15 = r13.getMeasuredHeight();
        int r16 = r14.f4307a;
        if ((r16 & 1) == 0) goto L21;
        int r17 = ((r15 + ((LinearLayout.LayoutParams) r14).topMargin) + ((LinearLayout.LayoutParams) r14).bottomMargin) + r12;
        if (r11 != 0) goto L17;
        WeakHashMap<View, h0> r18 = w.f8437a;
        if (w.d.b(r13) == false) goto L17;
        r17 = r17 - getTopInset();
    L17:
        r12 = r17;
        if ((r16 & 2) == 0) goto L20;
        WeakHashMap<View, h0> r19 = w.f8437a;
        r12 = r12 - w.d.d(r13);
    L20:
        r11 = r11 + 1;
    L21:
        int r20 = Math.max(0, r12);
        this.f4278b = r20;
        return r20;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r8 = getBackground();
        if ((r8 instanceof aa.f) == false) goto L6;
        defpackage.c.i0(this, (aa.f) r8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        if (this.f4290x != null) goto L5;
        this.f4290x = new int[4];
    L5:
        int[] r10 = this.f4290x;
        int[] r11 = super.onCreateDrawableState(r8 + r10.length);
        boolean r12 = this.f4284r;
        if (r12 == false) goto L8;
        int r13 = R.attr.state_liftable;
    L9:
        r10[0] = r13;
        if (r12 == true) goto L12;
    L14:
        int r14 = -2130970148;
    L15:
        r10[1] = r14;
        if (r12 == false) goto L18;
        int r15 = R.attr.state_collapsible;
    L19:
        r10[2] = r15;
        if (r12 == true) goto L22;
    L24:
        int r16 = -2130970142;
    L25:
        r10[3] = r16;
        return LinearLayout.mergeDrawableStates(r11, r10);
    L22:
        if (this.f4285s == false) goto L24;
        r16 = R.attr.state_collapsed;
        goto L25
    L18:
        r15 = -2130970143;
        goto L19
    L12:
        if (this.f4285s == false) goto L14;
        r14 = R.attr.state_lifted;
        goto L15
    L8:
        r13 = -2130970147;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> r8 = this.f4288v;
        if (r8 == null) goto L5;
        r8.clear();
    L5:
        this.f4288v = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        WeakHashMap<View, h0> r14 = w.f8437a;
        boolean r15 = true;
        if (w.d.b(this) == true) goto L5;
    L9:
        c();
        this.f4281o = false;
        int r16 = getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L15;
        if (((c) getChildAt(r17).getLayoutParams()).f4309c != null) goto L13;
        r17 = r17 + 1;
        goto L10
    L13:
        this.f4281o = true;
    L15:
        Drawable r18 = this.f4291y;
        if (r18 == null) goto L19;
        r18.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.f4283q == false) goto L21;
        return;
    L21:
        if (this.f4286t == true) goto L38;
        int r19 = getChildCount();
        int r20 = 0;
    L23:
        if (r20 >= r19) goto L33;
        int r21 = ((c) getChildAt(r20).getLayoutParams()).f4307a;
        if ((r21 & 1) == 1) goto L27;
    L29:
        boolean r22 = false;
    L30:
        if (r22 == true) goto L31;
        r20 = r20 + 1;
        goto L23
    L31:
        boolean r23 = true;
    L34:
        if (r23 == true) goto L38;
        r15 = false;
        goto L38
    L27:
        if ((r21 & 10) == 0) goto L29;
        r22 = true;
        goto L30
    L33:
        r23 = false;
    L38:
        if (this.f4284r == r15) goto L47;
        this.f4284r = r15;
        refreshDrawableState();
        return;
    L47:
        return;
    L5:
        if (g() == false) goto L9;
        int r24 = getTopInset();
        int r25 = getChildCount() - 1;
    L7:
        if (r25 < 0) goto L9;
        getChildAt(r25).offsetTopAndBottom(r24);
        r25 = r25 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        if (r11 == 1073741824) goto L15;
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.d.b(this) == false) goto L15;
        if (g() == false) goto L15;
        int r13 = getMeasuredHeight();
        if (r11 == Integer.MIN_VALUE) goto L13;
        if (r11 != 0) goto L14;
        r13 = r13 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r13);
        goto L15
    L13:
        int r14 = getMeasuredHeight();
        r13 = t2.b.p(getTopInset() + r14, 0, View.MeasureSpec.getSize(r10));
    L15:
        c();
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        Drawable r10 = getBackground();
        if ((r10 instanceof aa.f) == false) goto L6;
        ((aa.f) r10).j(r8);
        return;
    }

    public void setExpanded(boolean r8) {
        WeakHashMap<View, h0> r10 = w.f8437a;
        boolean r11 = w.g.c(this);
        if (r8 == false) goto L5;
        int r12 = 1;
    L6:
        if (r11 == false) goto L8;
        int r13 = 4;
    L9:
        this.f4282p = (r12 | r13) | 8;
        requestLayout();
        return;
    L8:
        r13 = 0;
        goto L9
    L5:
        r12 = 2;
        goto L6
    }

    public void setLiftOnScroll(boolean r8) {
        this.f4286t = r8;
    }

    public void setLiftOnScrollTargetView(View r8) {
        this.f4287u = -1;
        if (r8 != null) goto L8;
        WeakReference<View> r10 = this.f4288v;
        if (r10 == null) goto L7;
        r10.clear();
    L7:
        this.f4288v = null;
        return;
    L8:
        this.f4288v = new WeakReference(r8);
    }

    public void setLiftOnScrollTargetViewId(int r8) {
        this.f4287u = r8;
        WeakReference<View> r10 = this.f4288v;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        this.f4288v = null;
    }

    public void setLiftableOverrideEnabled(boolean r8) {
        this.f4283q = r8;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r8) {
        if (r8 != 1) goto L7;
        super.setOrientation(r8);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable r8) {
        Drawable r10 = this.f4291y;
        if (r10 == r8) goto L32;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r8 == null) goto L9;
        r11 = r8.mutate();
    L9:
        this.f4291y = r11;
        if ((r11 instanceof aa.f) == false) goto L12;
        int r12 = ((aa.f) r11).E;
    L15:
        Drawable r13 = this.f4291y;
        boolean r14 = false;
        if (r13 == null) goto L26;
        if (r13.isStateful() == false) goto L20;
        this.f4291y.setState(getDrawableState());
    L20:
        Drawable r15 = this.f4291y;
        WeakHashMap<View, h0> r16 = w.f8437a;
        b0.a.c.b(r15, w.e.d(this));
        Drawable r17 = this.f4291y;
        if (getVisibility() != 0) goto L23;
        boolean r18 = true;
    L24:
        r17.setVisible(r18, false);
        this.f4291y.setCallback(this);
        goto L26
    L23:
        r18 = false;
    L26:
        if (this.f4291y != null) goto L28;
    L30:
        setWillNotDraw(!r14);
        WeakHashMap<View, h0> r19 = w.f8437a;
        w.d.k(this);
        return;
    L28:
        if (getTopInset() <= 0) goto L30;
        r14 = true;
        goto L30
    L12:
        ColorStateList r20 = r9.a.a(r11);
        if (r20 == null) goto L15;
        r20.getDefaultColor();
        goto L15
    }

    public void setStatusBarForegroundColor(int r8) {
        setStatusBarForeground(new ColorDrawable(r8));
    }

    public void setStatusBarForegroundResource(int r8) {
        setStatusBarForeground(d.a.a(getContext(), r8));
    }

    @Deprecated
    public void setTargetElevation(float r12) {
        int r8 = getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator r10 = new StateListAnimator();
        long r11 = r8;
        r10.addState(new int[]{android.R.attr.state_enabled, R.attr.state_liftable, -2130970148}, ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(r11));
        r10.addState(new int[]{android.R.attr.state_enabled}, ObjectAnimator.ofFloat(this, "elevation", new float[]{r12}).setDuration(r11));
        r10.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(0));
        setStateListAnimator(r10);
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        super.setVisibility(r8);
        if (r8 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.f4291y;
        if (r11 == null) goto L10;
        r11.setVisible(r10, false);
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        if (super.verifyDrawable(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (r8 == this.f4291y) goto L8;
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return a(r8);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new c(getContext(), r8);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return a(r8);
    }
}
