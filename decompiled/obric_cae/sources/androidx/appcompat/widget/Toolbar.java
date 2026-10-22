package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public int A;
    public int B;
    public int C;
    public n0 D;
    public int E;
    public int F;
    public final int G;
    public CharSequence H;
    public CharSequence I;
    public ColorStateList J;
    public ColorStateList K;
    public boolean L;
    public boolean M;
    public final ArrayList<View> N;
    public final ArrayList<View> O;
    public final int[] P;
    public final j0.i Q;
    public ArrayList<MenuItem> R;
    public h S;
    public final a T;
    public x0 U;
    public ActionMenuPresenter V;
    public f W;
    public androidx.appcompat.view.menu.j.a X;
    public androidx.appcompat.view.menu.f.a Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f1055a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public OnBackInvokedCallback f1056a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f1057b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public OnBackInvokedDispatcher f1058b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1059c0;
    public final b d0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y f1060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f1061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppCompatImageView f1062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Drawable f1063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CharSequence f1064q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m f1065r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f1066s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Context f1067t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1068u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1069v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1070w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1071x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1072y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1073z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1074m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1075n;

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
            this.f1074m = r8.readInt();
            if (r8.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.f1075n = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f1074m);
            r8.writeInt(this.f1075n ? 1 : 0);
        }
    }

    public class a implements ActionMenuView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f1076a;

        public a(Toolbar r8) {
            this.f1076a = r8;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f1077a;

        public b(Toolbar r8) {
            this.f1077a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuView r8 = this.f1077a.f1055a;
            if (r8 == null) goto L8;
            ActionMenuPresenter r10 = r8.D;
            if (r10 == null) goto L9;
            r10.l();
            return;
        L9:
            return;
        }
    }

    public class c implements androidx.appcompat.view.menu.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f1078a;

        public c(Toolbar r8) {
            this.f1078a = r8;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
            androidx.appcompat.view.menu.f.a r11 = this.f1078a.Y;
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11.a(r8, r10) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f r8) {
            Toolbar r10 = this.f1078a;
            ActionMenuPresenter r11 = r10.f1055a.D;
            if (r11 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r12 == true) goto L13;
            Iterator<j0.k> r13 = r10.Q.f8390b.iterator();
        L11:
            if (r13.hasNext() == false) goto L13;
            r13.next().getClass();
        L13:
            androidx.appcompat.view.menu.f.a r14 = r10.Y;
            if (r14 == null) goto L18;
            r14.b(r8);
            return;
        L18:
            return;
        L5:
            if (r11.k() == false) goto L7;
            r12 = true;
            goto L8
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f1079a;

        public d(Toolbar r8) {
            this.f1079a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            f r10 = this.f1079a.W;
            if (r10 != null) goto L5;
            androidx.appcompat.view.menu.h r11 = null;
        L6:
            if (r11 == null) goto L9;
            r11.collapseActionView();
            return;
        L9:
            return;
        L5:
            r11 = r10.f1081b;
            goto L6
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View r8) {
            return r8.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable r8) {
            Objects.requireNonNull(r8);
            return new androidx.appcompat.app.m(r8, 1);
        }

        public static void c(Object r8, Object r10) {
            ((OnBackInvokedDispatcher) r8).registerOnBackInvokedCallback(TimeUtils.NANOSECONDS_PER_MILLISECOND, (OnBackInvokedCallback) r10);
        }

        public static void d(Object r8, Object r10) {
            ((OnBackInvokedDispatcher) r8).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r10);
        }
    }

    public class f implements androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.f f1080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f1081b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Toolbar f1082m;

        public f(Toolbar r8) {
            this.f1082m = r8;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean c(androidx.appcompat.view.menu.h r8) {
            Toolbar r10 = this.f1082m;
            KeyEvent.Callback r11 = r10.f1066s;
            if ((r11 instanceof g.c) == false) goto L5;
            ((g.c) r11).onActionViewCollapsed();
        L5:
            r10.removeView(r10.f1066s);
            r10.removeView(r10.f1065r);
            r10.f1066s = null;
            ArrayList<View> r12 = r10.O;
            int r13 = r12.size();
        L6:
            r13 = r13 - 1;
            if (r13 < 0) goto L9;
            r10.addView(r12.get(r13));
            goto L6
        L9:
            r12.clear();
            this.f1081b = null;
            r10.requestLayout();
            r8.C = false;
            r8.f856n.q(false);
            r10.s();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void d() {
            if (this.f1081b == null) goto L17;
            androidx.appcompat.view.menu.f r8 = this.f1080a;
            boolean r10 = false;
            if (r8 == null) goto L12;
            int r11 = r8.size();
            int r12 = 0;
        L7:
            if (r12 >= r11) goto L12;
            if (this.f1080a.getItem(r12) == this.f1081b) goto L10;
            r12 = r12 + 1;
            goto L7
        L10:
            r10 = true;
        L12:
            if (r10 == true) goto L18;
            c(this.f1081b);
            return;
        L18:
            return;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean e(androidx.appcompat.view.menu.m r8) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean f(androidx.appcompat.view.menu.h r8) {
            Toolbar r10 = this.f1082m;
            r10.c();
            ViewParent r11 = r10.f1065r.getParent();
            if (r11 != r10) goto L5;
        L8:
            View r12 = r8.getActionView();
            r10.f1066s = r12;
            this.f1081b = r8;
            ViewParent r13 = r12.getParent();
            if (r13 != r10) goto L11;
        L14:
            int r14 = r10.getChildCount();
        L15:
            r14 = r14 - 1;
            if (r14 < 0) goto L22;
            View r15 = r10.getChildAt(r14);
            if (((g) r15.getLayoutParams()).f1083b == 2) goto L15;
            if (r15 == r10.f1055a) goto L15;
            r10.removeViewAt(r14);
            r10.O.add(r15);
            goto L15
        L22:
            r10.requestLayout();
            r8.C = true;
            r8.f856n.q(false);
            KeyEvent.Callback r16 = r10.f1066s;
            if ((r16 instanceof g.c) == false) goto L25;
            ((g.c) r16).onActionViewExpanded();
        L25:
            r10.s();
            return true;
        L11:
            if ((r13 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r13).removeView(r10.f1066s);
        L13:
            g r17 = new g();
            r17.f638a = (r10.f1071x & BWDLInnerConstant.LINK_RECOVERY) | 8388611;
            r17.f1083b = 2;
            r10.f1066s.setLayoutParams(r17);
            r10.addView(r10.f1066s);
            goto L14
        L5:
            if ((r11 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r11).removeView(r10.f1065r);
        L7:
            r10.addView(r10.f1065r);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean g() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void h(Context r8, androidx.appcompat.view.menu.f r10) {
            androidx.appcompat.view.menu.f r11 = this.f1080a;
            if (r11 == null) goto L7;
            androidx.appcompat.view.menu.h r12 = this.f1081b;
            if (r12 == null) goto L7;
            r11.e(r12);
        L7:
            this.f1080a = r10;
        }
    }

    public static class g extends androidx.appcompat.app.a.C0004a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1083b;

        public g() {
            this.f1083b = 0;
            this.f638a = 8388627;
        }

        public g(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f1083b = 0;
        }

        public g(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f1083b = 0;
        }

        public g(ViewGroup.MarginLayoutParams r8) {
            super(r8);
            this.f1083b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r8.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r8.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r8.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r8.bottomMargin;
        }

        public g(androidx.appcompat.app.a.C0004a r8) {
            super(r8);
            this.f1083b = 0;
        }

        public g(g r8) {
            super(r8);
            this.f1083b = 0;
            this.f1083b = r8.f1083b;
        }
    }

    public interface h {
    }

    public Toolbar(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    public static g g(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof g) == false) goto L7;
        return new g((g) r8);
    L7:
        if ((r8 instanceof androidx.appcompat.app.a.C0004a) == false) goto L11;
        return new g((androidx.appcompat.app.a.C0004a) r8);
    L11:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new g((ViewGroup.MarginLayoutParams) r8);
    L15:
        return new g(r8);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r8 = new ArrayList();
        Menu r10 = getMenu();
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        r8.add(r10.getItem(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        return r8;
    }

    private MenuInflater getMenuInflater() {
        return new g.g(getContext());
    }

    public static int i(View r8) {
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r11 = j0.f.c(r10);
        return j0.f.b(r10) + r11;
    }

    public static int j(View r8) {
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        return r10.topMargin + r10.bottomMargin;
    }

    public final void a(int r10, ArrayList r11) {
        WeakHashMap<View, j0.h0> r8 = j0.w.f8437a;
        int r12 = 0;
        if (j0.w.e.d(this) != 1) goto L5;
        boolean r13 = true;
    L6:
        int r14 = getChildCount();
        int r15 = Gravity.getAbsoluteGravity(r10, j0.w.e.d(this));
        r11.clear();
        if (r13 == false) goto L24;
        int r16 = r14 - 1;
    L9:
        if (r16 < 0) goto L39;
        View r17 = getChildAt(r16);
        g r18 = (g) r17.getLayoutParams();
        if (r18.f1083b != 0) goto L23;
        if (r(r17) == false) goto L23;
        int r19 = r18.f638a;
        WeakHashMap<View, j0.h0> r20 = j0.w.f8437a;
        int r21 = j0.w.e.d(this);
        int r22 = Gravity.getAbsoluteGravity(r19, r21) & 7;
        if (r22 == 1) goto L21;
        if (r22 == 3) goto L21;
        if (r22 == 5) goto L21;
        if (r21 != 1) goto L20;
        r22 = 5;
        goto L21
    L20:
        r22 = 3;
    L21:
        if (r22 != r15) goto L23;
        r11.add(r17);
    L23:
        r16 = r16 - 1;
        goto L9
    L39:
        return;
    L24:
        if (r12 >= r14) goto L50;
        View r23 = getChildAt(r12);
        g r24 = (g) r23.getLayoutParams();
        if (r24.f1083b != 0) goto L38;
        if (r(r23) == false) goto L38;
        int r25 = r24.f638a;
        WeakHashMap<View, j0.h0> r26 = j0.w.f8437a;
        int r27 = j0.w.e.d(this);
        int r28 = Gravity.getAbsoluteGravity(r25, r27) & 7;
        if (r28 == 1) goto L36;
        if (r28 == 3) goto L36;
        if (r28 == 5) goto L36;
        if (r27 != 1) goto L35;
        r28 = 5;
        goto L36
    L35:
        r28 = 3;
    L36:
        if (r28 != r15) goto L38;
        r11.add(r23);
    L38:
        r12 = r12 + 1;
        goto L24
    L50:
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void b(View r8, boolean r10) {
        ViewGroup.LayoutParams r11 = r8.getLayoutParams();
        if (r11 != null) goto L6;
        g r12 = new g();
    L9:
        r12.f1083b = 1;
        if (r10 == true) goto L12;
    L14:
        addView(r8, r12);
        return;
    L12:
        if (this.f1066s == null) goto L14;
        r8.setLayoutParams(r12);
        this.O.add(r8);
        return;
    L6:
        if (checkLayoutParams(r11) == true) goto L8;
        r12 = g(r11);
        goto L9
    L8:
        r12 = (g) r11;
        goto L9
    }

    public final void c() {
        if (this.f1065r != null) goto L6;
        m r8 = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.f1065r = r8;
        r8.setImageDrawable(this.f1063p);
        this.f1065r.setContentDescription(this.f1064q);
        g r10 = new g();
        r10.f638a = (this.f1071x & BWDLInnerConstant.LINK_RECOVERY) | 8388611;
        r10.f1083b = 2;
        this.f1065r.setLayoutParams(r10);
        this.f1065r.setOnClickListener(new d(this));
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        if (super.checkLayoutParams(r8) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r8 instanceof g) == false) goto L7;
        return true;
    }

    public final void d() {
        e();
        ActionMenuView r8 = this.f1055a;
        if (r8.f955z != null) goto L9;
        androidx.appcompat.view.menu.f r10 = (androidx.appcompat.view.menu.f) r8.getMenu();
        if (this.W != null) goto L7;
        this.W = new f(this);
    L7:
        this.f1055a.setExpandedActionViewsExclusive(true);
        r10.c(this.W, this.f1067t);
        s();
        return;
    }

    public final void e() {
        if (this.f1055a != null) goto L6;
        ActionMenuView r8 = new ActionMenuView(getContext(), null);
        this.f1055a = r8;
        r8.setPopupTheme(this.f1068u);
        this.f1055a.setOnMenuItemClickListener(this.T);
        ActionMenuView r10 = this.f1055a;
        androidx.appcompat.view.menu.j.a r11 = this.X;
        c r12 = new c(this);
        r10.E = r11;
        r10.F = r12;
        g r13 = new g();
        r13.f638a = (this.f1071x & BWDLInnerConstant.LINK_RECOVERY) | 8388613;
        this.f1055a.setLayoutParams(r13);
        b(this.f1055a, false);
        return;
    }

    public final void f() {
        if (this.f1061n != null) goto L6;
        this.f1061n = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        g r8 = new g();
        r8.f638a = (this.f1071x & BWDLInnerConstant.LINK_RECOVERY) | 8388611;
        this.f1061n.setLayoutParams(r8);
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new g(getContext(), r8);
    }

    public CharSequence getCollapseContentDescription() {
        m r8 = this.f1065r;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getContentDescription();
    }

    public Drawable getCollapseIcon() {
        m r8 = this.f1065r;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getDrawable();
    }

    public int getContentInsetEnd() {
        n0 r8 = this.D;
        if (r8 != null) goto L5;
        return 0;
    L5:
        if (r8.f1228g == false) goto L11;
        return r8.f1222a;
    L11:
        return r8.f1223b;
    }

    public int getContentInsetEndWithActions() {
        int r8 = this.F;
        if (r8 == Integer.MIN_VALUE) goto L6;
        return r8;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        n0 r8 = this.D;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1222a;
    }

    public int getContentInsetRight() {
        n0 r8 = this.D;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1223b;
    }

    public int getContentInsetStart() {
        n0 r8 = this.D;
        if (r8 != null) goto L5;
        return 0;
    L5:
        if (r8.f1228g == false) goto L11;
        return r8.f1223b;
    L11:
        return r8.f1222a;
    }

    public int getContentInsetStartWithNavigation() {
        int r8 = this.E;
        if (r8 == Integer.MIN_VALUE) goto L6;
        return r8;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r8 = this.f1055a;
        if (r8 == null) goto L9;
        androidx.appcompat.view.menu.f r10 = r8.f955z;
        if (r10 == null) goto L9;
        if (r10.hasVisibleItems() == false) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.F, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r11 = false;
        goto L10
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap<View, j0.h0> r8 = j0.w.f8437a;
        if (j0.w.e.d(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap<View, j0.h0> r8 = j0.w.f8437a;
        if (j0.w.e.d(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.E, 0));
    L6:
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView r8 = this.f1062o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getDrawable();
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView r8 = this.f1062o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getContentDescription();
    }

    public Menu getMenu() {
        d();
        return this.f1055a.getMenu();
    }

    public View getNavButtonView() {
        return this.f1061n;
    }

    public CharSequence getNavigationContentDescription() {
        m r8 = this.f1061n;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        m r8 = this.f1061n;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getDrawable();
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.V;
    }

    public Drawable getOverflowIcon() {
        d();
        return this.f1055a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1067t;
    }

    public int getPopupTheme() {
        return this.f1068u;
    }

    public CharSequence getSubtitle() {
        return this.I;
    }

    public final TextView getSubtitleTextView() {
        return this.f1060m;
    }

    public CharSequence getTitle() {
        return this.H;
    }

    public int getTitleMarginBottom() {
        return this.C;
    }

    public int getTitleMarginEnd() {
        return this.A;
    }

    public int getTitleMarginStart() {
        return this.f1073z;
    }

    public int getTitleMarginTop() {
        return this.B;
    }

    public final TextView getTitleTextView() {
        return this.f1057b;
    }

    public c0 getWrapper() {
        if (this.U != null) goto L6;
        this.U = new x0(this, true);
    L6:
        return this.U;
    }

    public final int h(View r8, int r10) {
        g r11 = (g) r8.getLayoutParams();
        int r12 = r8.getMeasuredHeight();
        if (r10 <= 0) goto L5;
        int r13 = (r12 - r10) / 2;
    L6:
        int r14 = r11.f638a & BWDLInnerConstant.LINK_RECOVERY;
        if (r14 == 16) goto L11;
        if (r14 == 48) goto L11;
        if (r14 == 80) goto L11;
        r14 = this.G & BWDLInnerConstant.LINK_RECOVERY;
    L11:
        if (r14 == 48) goto L24;
        if (r14 == 80) goto L22;
        int r15 = getPaddingTop();
        int r16 = getPaddingBottom();
        int r17 = getHeight();
        int r18 = (((r17 - r15) - r16) - r12) / 2;
        int r19 = ((ViewGroup.MarginLayoutParams) r11).topMargin;
        if (r18 >= r19) goto L16;
        r18 = r19;
    L20:
        return r15 + r18;
    L16:
        int r20 = (((r17 - r16) - r12) - r18) - r15;
        int r21 = ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        if (r20 >= r21) goto L20;
        r18 = Math.max(0, r18 - (r21 - r20));
        goto L20
    L22:
        return (((getHeight() - getPaddingBottom()) - r12) - ((ViewGroup.MarginLayoutParams) r11).bottomMargin) - r13;
    L24:
        return getPaddingTop() - r13;
    L5:
        r13 = 0;
        goto L6
    }

    public void k(int r8) {
        getMenuInflater().inflate(r8, getMenu());
    }

    public final void l() {
        Iterator<MenuItem> r8 = this.R.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        MenuItem r10 = r8.next();
        getMenu().removeItem(r10.getItemId());
        goto L4
    L6:
        getMenu();
        ArrayList<MenuItem> r11 = getCurrentMenuItems();
        getMenuInflater();
        Iterator<j0.k> r12 = this.Q.f8390b.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r12.next().a();
        goto L8
    L10:
        ArrayList<MenuItem> r13 = getCurrentMenuItems();
        r13.removeAll(r11);
        this.R = r13;
    }

    public final boolean m(View r8) {
        if (r8.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.O.contains(r8) == true) goto L8;
        return false;
    }

    public final int n(View r8, int r10, int r11, int[] r12) {
        g r13 = (g) r8.getLayoutParams();
        int r14 = ((ViewGroup.MarginLayoutParams) r13).leftMargin - r12[0];
        int r15 = Math.max(0, r14) + r10;
        r12[0] = Math.max(0, -r14);
        int r16 = h(r8, r11);
        int r17 = r8.getMeasuredWidth();
        r8.layout(r15, r16, r15 + r17, r8.getMeasuredHeight() + r16);
        return (r17 + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r15;
    }

    public final int o(View r8, int r10, int r11, int[] r12) {
        g r13 = (g) r8.getLayoutParams();
        int r14 = ((ViewGroup.MarginLayoutParams) r13).rightMargin - r12[1];
        int r15 = r10 - Math.max(0, r14);
        r12[1] = Math.max(0, -r14);
        int r16 = h(r8, r11);
        int r17 = r8.getMeasuredWidth();
        r8.layout(r15 - r17, r16, r15, r8.getMeasuredHeight() + r16);
        return r15 - (r17 + ((ViewGroup.MarginLayoutParams) r13).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.d0);
        s();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 9) goto L6;
        this.M = false;
    L6:
        if (this.M == true) goto L12;
        boolean r11 = super.onHoverEvent(r8);
        if (r10 != 9) goto L12;
        if (r11 == true) goto L12;
        this.M = true;
    L12:
        if (r10 != 10) goto L14;
    L15:
        this.M = false;
    L16:
        return true;
    L14:
        if (r10 != 3) goto L16;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        WeakHashMap<View, j0.h0> r8 = j0.w.f8437a;
        if (j0.w.e.d(this) != 1) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getWidth();
        int r12 = getHeight();
        int r13 = getPaddingLeft();
        int r14 = getPaddingRight();
        int r15 = getPaddingTop();
        int r16 = getPaddingBottom();
        int r17 = r11 - r14;
        int[] r18 = this.P;
        r18[1] = 0;
        r18[0] = 0;
        int r19 = j0.w.d.d(this);
        if (r19 < 0) goto L9;
        int r110 = Math.min(r19, r24 - r22);
    L11:
        if (r(this.f1061n) == false) goto L16;
        m r111 = this.f1061n;
        if (r10 == false) goto L15;
        int r112 = o(r111, r17, r110, r18);
        int r113 = r13;
    L19:
        if (r(this.f1065r) == false) goto L25;
        m r114 = this.f1065r;
        if (r10 == false) goto L23;
        r112 = o(r114, r112, r110, r18);
        goto L25
    L23:
        r113 = n(r114, r113, r110, r18);
    L25:
        if (r(this.f1055a) == false) goto L30;
        ActionMenuView r115 = this.f1055a;
        if (r10 == false) goto L29;
        r113 = n(r115, r113, r110, r18);
        goto L30
    L29:
        r112 = o(r115, r112, r110, r18);
    L30:
        int r116 = getCurrentContentInsetLeft();
        int r117 = getCurrentContentInsetRight();
        r18[0] = Math.max(0, r116 - r113);
        r18[1] = Math.max(0, r117 - (r17 - r112));
        int r25 = Math.max(r113, r116);
        int r118 = Math.min(r112, r17 - r117);
        if (r(this.f1066s) == false) goto L37;
        View r119 = this.f1066s;
        if (r10 == false) goto L35;
        r118 = o(r119, r118, r110, r18);
        goto L37
    L35:
        r25 = n(r119, r25, r110, r18);
    L37:
        if (r(this.f1062o) == false) goto L42;
        AppCompatImageView r120 = this.f1062o;
        if (r10 == false) goto L41;
        r118 = o(r120, r118, r110, r18);
        goto L42
    L41:
        r25 = n(r120, r25, r110, r18);
    L42:
        boolean r121 = r(this.f1057b);
        boolean r122 = r(this.f1060m);
        if (r121 == false) goto L45;
        g r123 = (g) this.f1057b.getLayoutParams();
        int r26 = ((this.f1057b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r123).topMargin) + ((ViewGroup.MarginLayoutParams) r123).bottomMargin) + 0;
    L46:
        if (r122 == false) goto L49;
        g r27 = (g) this.f1060m.getLayoutParams();
        r26 = r26 + ((this.f1060m.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r27).topMargin) + ((ViewGroup.MarginLayoutParams) r27).bottomMargin);
    L49:
        if (r121 == true) goto L53;
        if (r122 == true) goto L53;
        int r124 = r13;
        r110 = r110;
    L106:
        ArrayList<View> r28 = this.N;
        a(3, r28);
        int r29 = r28.size();
        int r30 = r25;
        int r31 = 0;
    L107:
        if (r31 >= r29) goto L109;
        r30 = n(r28.get(r31), r30, r110, r18);
        r31 = r31 + 1;
        goto L107
    L109:
        int r125 = r110;
        a(5, r28);
        int r32 = r28.size();
        int r33 = 0;
    L110:
        if (r33 >= r32) goto L112;
        r118 = o(r28.get(r33), r118, r125, r18);
        r33 = r33 + 1;
        goto L110
    L112:
        a(1, r28);
        int r34 = r18[0];
        int r35 = r18[1];
        int r36 = r28.size();
        int r37 = r34;
        int r38 = 0;
        int r39 = 0;
    L113:
        if (r38 >= r36) goto L115;
        View r40 = r28.get(r38);
        g r41 = (g) r40.getLayoutParams();
        int r126 = ((ViewGroup.MarginLayoutParams) r41).leftMargin - r37;
        int r42 = ((ViewGroup.MarginLayoutParams) r41).rightMargin - r35;
        int r43 = Math.max(0, r126);
        int r127 = Math.max(0, r42);
        int r128 = Math.max(0, -r126);
        int r44 = Math.max(0, -r42);
        r39 = r39 + ((r40.getMeasuredWidth() + r43) + r127);
        r38 = r38 + 1;
        r35 = r44;
        r37 = r128;
        goto L113
    L115:
        int r45 = 0;
        int r46 = ((((r11 - r124) - r14) / 2) + r124) - (r39 / 2);
        int r47 = r39 + r46;
        if (r46 < r30) goto L121;
        if (r47 <= r118) goto L120;
        r30 = r46 - (r47 - r118);
        goto L121
    L120:
        r30 = r46;
    L121:
        int r48 = r28.size();
    L122:
        if (r45 >= r48) goto L124;
        r30 = n(r28.get(r45), r30, r125, r18);
        r45 = r45 + 1;
        goto L122
    L124:
        r28.clear();
        return;
    L53:
        if (r121 == false) goto L55;
        y r49 = this.f1057b;
    L56:
        if (r122 == false) goto L58;
        y r50 = this.f1060m;
    L59:
        g r51 = (g) r49.getLayoutParams();
        g r52 = (g) r50.getLayoutParams();
        if (r121 == true) goto L62;
    L63:
        if (r122 == true) goto L65;
    L67:
        boolean r129 = false;
    L68:
        int r130 = this.G & BWDLInnerConstant.LINK_RECOVERY;
        r124 = r13;
        if (r130 != 48) goto L71;
        int r53 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r51).topMargin) + this.B;
    L81:
        if (r10 == false) goto L94;
        if (r129 == false) goto L84;
        int r54 = this.f1073z;
    L85:
        int r55 = r54 - r18[1];
        r118 = r118 - Math.max(0, r55);
        r18[1] = Math.max(0, -r55);
        if (r121 == false) goto L88;
        g r56 = (g) this.f1057b.getLayoutParams();
        int r57 = r118 - this.f1057b.getMeasuredWidth();
        int r58 = this.f1057b.getMeasuredHeight() + r53;
        this.f1057b.layout(r57, r53, r118, r58);
        int r59 = r57 - this.A;
        r53 = r58 + ((ViewGroup.MarginLayoutParams) r56).bottomMargin;
    L89:
        if (r122 == false) goto L91;
        int r60 = r53 + ((ViewGroup.MarginLayoutParams) ((g) this.f1060m.getLayoutParams())).topMargin;
        this.f1060m.layout(r118 - this.f1060m.getMeasuredWidth(), r60, r118, this.f1060m.getMeasuredHeight() + r60);
        int r61 = r118 - this.A;
    L92:
        if (r129 == false) goto L106;
        r118 = Math.min(r59, r61);
        goto L106
    L91:
        r61 = r118;
        goto L92
    L88:
        r59 = r118;
        goto L89
    L84:
        r54 = 0;
        goto L85
    L94:
        if (r129 == false) goto L96;
        int r62 = this.f1073z;
    L97:
        int r63 = r62 - r18[0];
        r25 = r25 + Math.max(0, r63);
        r18[0] = Math.max(0, -r63);
        if (r121 == false) goto L100;
        g r64 = (g) this.f1057b.getLayoutParams();
        int r65 = this.f1057b.getMeasuredWidth() + r25;
        int r66 = this.f1057b.getMeasuredHeight() + r53;
        this.f1057b.layout(r25, r53, r65, r66);
        int r67 = r65 + this.A;
        r53 = r66 + ((ViewGroup.MarginLayoutParams) r64).bottomMargin;
    L101:
        if (r122 == false) goto L103;
        int r68 = r53 + ((ViewGroup.MarginLayoutParams) ((g) this.f1060m.getLayoutParams())).topMargin;
        int r69 = this.f1060m.getMeasuredWidth() + r25;
        this.f1060m.layout(r25, r68, r69, this.f1060m.getMeasuredHeight() + r68);
        int r70 = r69 + this.A;
    L104:
        if (r129 == false) goto L106;
        r25 = Math.max(r67, r70);
        goto L106
    L103:
        r70 = r25;
        goto L104
    L100:
        r67 = r25;
        goto L101
    L96:
        r62 = 0;
        goto L97
    L71:
        if (r130 == 80) goto L79;
        int r71 = (((r12 - r15) - r16) - r26) / 2;
        int r131 = ((ViewGroup.MarginLayoutParams) r51).topMargin + this.B;
        if (r71 >= r131) goto L75;
        r71 = r131;
    L78:
        r53 = r15 + r71;
        goto L81
    L75:
        int r72 = (((r12 - r16) - r26) - r71) - r15;
        int r73 = ((ViewGroup.MarginLayoutParams) r51).bottomMargin;
        int r74 = this.C;
        if (r72 >= (r73 + r74)) goto L78;
        r71 = Math.max(0, r71 - ((((ViewGroup.MarginLayoutParams) r52).bottomMargin + r74) - r72));
        goto L78
    L79:
        r53 = (((r12 - r16) - ((ViewGroup.MarginLayoutParams) r52).bottomMargin) - this.C) - r26;
        goto L81
    L65:
        if (this.f1060m.getMeasuredWidth() <= 0) goto L67;
    L66:
        r129 = true;
        goto L68
    L62:
        if (this.f1057b.getMeasuredWidth() > 0) goto L66;
    L58:
        r50 = this.f1057b;
        goto L59
    L55:
        r49 = this.f1060m;
        goto L56
    L45:
        r26 = 0;
        goto L46
    L15:
        r113 = n(r111, r13, r110, r18);
    L17:
        r112 = r17;
        goto L19
    L16:
        r113 = r13;
        goto L17
    L9:
        r110 = 0;
        goto L11
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        boolean r8 = b1.a(this);
        int r10 = !r8 ? 1 : 0;
        int r11 = 0;
        if (r(this.f1061n) == false) goto L5;
        q(this.f1061n, r17, 0, r18, this.f1072y);
        int r12 = i(this.f1061n) + this.f1061n.getMeasuredWidth();
        int r13 = Math.max(0, j(this.f1061n) + this.f1061n.getMeasuredHeight());
        int r14 = View.combineMeasuredStates(0, this.f1061n.getMeasuredState());
    L7:
        if (r(this.f1065r) == false) goto L9;
        q(this.f1065r, r17, 0, r18, this.f1072y);
        r12 = i(this.f1065r) + this.f1065r.getMeasuredWidth();
        r13 = Math.max(r13, j(this.f1065r) + this.f1065r.getMeasuredHeight());
        r14 = View.combineMeasuredStates(r14, this.f1065r.getMeasuredState());
    L9:
        int r15 = getCurrentContentInsetStart();
        int r16 = Math.max(r15, r12) + 0;
        int r19 = Math.max(0, r15 - r12);
        int[] r110 = this.P;
        r110[r8 ? 1 : 0] = r19;
        if (r(this.f1055a) == false) goto L12;
        q(this.f1055a, r17, r16, r18, this.f1072y);
        int r20 = i(this.f1055a) + this.f1055a.getMeasuredWidth();
        r13 = Math.max(r13, j(this.f1055a) + this.f1055a.getMeasuredHeight());
        r14 = View.combineMeasuredStates(r14, this.f1055a.getMeasuredState());
    L13:
        int r21 = getCurrentContentInsetEnd();
        int r111 = r16 + Math.max(r21, r20);
        r110[r10] = Math.max(0, r21 - r20);
        if (r(this.f1066s) == false) goto L17;
        r111 = r111 + p(this.f1066s, r17, r111, r18, 0, r110);
        r13 = Math.max(r13, j(this.f1066s) + this.f1066s.getMeasuredHeight());
        r14 = View.combineMeasuredStates(r14, this.f1066s.getMeasuredState());
    L17:
        if (r(this.f1062o) == false) goto L19;
        r111 = r111 + p(this.f1062o, r17, r111, r18, 0, r110);
        r13 = Math.max(r13, j(this.f1062o) + this.f1062o.getMeasuredHeight());
        r14 = View.combineMeasuredStates(r14, this.f1062o.getMeasuredState());
    L19:
        int r22 = getChildCount();
        int r112 = 0;
    L20:
        if (r112 >= r22) goto L28;
        View r113 = getChildAt(r112);
        if (((g) r113.getLayoutParams()).f1083b != 0) goto L27;
        if (r(r113) == false) goto L27;
        r111 = r111 + p(r113, r17, r111, r18, 0, r110);
        r13 = Math.max(r13, j(r113) + r113.getMeasuredHeight());
        r14 = View.combineMeasuredStates(r14, r113.getMeasuredState());
    L27:
        r112 = r112 + 1;
        goto L20
    L28:
        int r23 = this.B + this.C;
        int r114 = this.f1073z + this.A;
        if (r(this.f1057b) == false) goto L31;
        p(this.f1057b, r17, r111 + r114, r18, r23, r110);
        int r24 = i(this.f1057b) + this.f1057b.getMeasuredWidth();
        int r115 = j(this.f1057b) + this.f1057b.getMeasuredHeight();
        int r25 = View.combineMeasuredStates(r14, this.f1057b.getMeasuredState());
        int r116 = r24;
    L33:
        if (r(this.f1060m) == false) goto L36;
        r116 = Math.max(r116, p(this.f1060m, r17, r111 + r114, r18, r115 + r23, r110));
        r115 = r115 + (j(this.f1060m) + this.f1060m.getMeasuredHeight());
        r25 = View.combineMeasuredStates(r25, this.f1060m.getMeasuredState());
    L36:
        int r26 = Math.max(r13, r115);
        int r27 = getPaddingRight() + getPaddingLeft();
        int r28 = (getPaddingBottom() + getPaddingTop()) + r26;
        int r29 = View.resolveSizeAndState(Math.max(r27 + (r111 + r116), getSuggestedMinimumWidth()), r17, (-16777216) & r25);
        int r30 = View.resolveSizeAndState(Math.max(r28, getSuggestedMinimumHeight()), r18, r25 << 16);
        if (this.Z == false) goto L47;
        int r31 = getChildCount();
        int r32 = 0;
    L40:
        if (r32 >= r31) goto L49;
        View r33 = getChildAt(r32);
        if (r(r33) == false) goto L48;
        if (r33.getMeasuredWidth() <= 0) goto L48;
        if (r33.getMeasuredHeight() > 0) goto L47;
    L48:
        r32 = r32 + 1;
        goto L40
    L49:
        boolean r34 = true;
    L50:
        if (r34 == true) goto L53;
        r11 = r30;
    L53:
        setMeasuredDimension(r29, r11);
        return;
    L47:
        r34 = false;
        goto L50
    L31:
        r115 = 0;
        r25 = r14;
        r116 = 0;
        goto L33
    L12:
        r20 = 0;
        goto L13
    L5:
        r12 = 0;
        r13 = 0;
        r14 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        ActionMenuView r11 = this.f1055a;
        if (r11 == null) goto L9;
        androidx.appcompat.view.menu.f r12 = r11.f955z;
    L10:
        int r13 = r10.f1074m;
        if (r13 == 0) goto L19;
        if (this.W == null) goto L19;
        if (r12 == null) goto L19;
        MenuItem r14 = r12.findItem(r13);
        if (r14 == null) goto L19;
        r14.expandActionView();
    L19:
        if (r10.f1075n == false) goto L22;
        b r15 = this.d0;
        removeCallbacks(r15);
        post(r15);
        return;
    L22:
        return;
    L9:
        r12 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r8) {
        super.onRtlPropertiesChanged(r8);
        if (this.D != null) goto L5;
        this.D = new n0();
    L5:
        n0 r10 = this.D;
        boolean r11 = true;
        if (r8 == 1) goto L10;
        r11 = false;
    L10:
        if (r11 == r10.f1228g) goto L34;
        r10.f1228g = r11;
        if (r10.f1229h == true) goto L15;
        r10.f1222a = r10.f1226e;
    L31:
        int r12 = r10.f1227f;
    L32:
        r10.f1223b = r12;
        return;
    L15:
        if (r11 == false) goto L23;
        int r13 = r10.f1225d;
        if (r13 != Integer.MIN_VALUE) goto L20;
        r13 = r10.f1226e;
    L20:
        r10.f1222a = r13;
        r12 = r10.f1224c;
        if (r12 == Integer.MIN_VALUE) goto L31;
    L23:
        int r14 = r10.f1224c;
        if (r14 != Integer.MIN_VALUE) goto L27;
        r14 = r10.f1226e;
    L27:
        r10.f1222a = r14;
        r12 = r10.f1225d;
        if (r12 == Integer.MIN_VALUE) goto L31;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        f r10 = this.W;
        if (r10 == null) goto L7;
        androidx.appcompat.view.menu.h r11 = r10.f1081b;
        if (r11 == null) goto L7;
        r8.f1074m = r11.f843a;
    L7:
        ActionMenuView r12 = this.f1055a;
        boolean r13 = false;
        if (r12 == null) goto L17;
        ActionMenuPresenter r14 = r12.D;
        if (r14 != null) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L17;
        r13 = true;
        goto L17
    L12:
        if (r14.k() == false) goto L14;
        r15 = true;
    L17:
        r8.f1075n = r13;
        return r8;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 0) goto L6;
        this.L = false;
    L6:
        if (this.L == true) goto L11;
        boolean r11 = super.onTouchEvent(r8);
        if (r10 != 0) goto L11;
        if (r11 == true) goto L11;
        this.L = true;
    L11:
        if (r10 != 1) goto L13;
    L14:
        this.L = false;
    L15:
        return true;
    L13:
        if (r10 != 3) goto L15;
        goto L14
    }

    public final int p(View r8, int r10, int r11, int r12, int r13, int[] r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r16 = r15.leftMargin - r14[0];
        int r17 = r15.rightMargin - r14[1];
        int r18 = Math.max(0, r16);
        int r19 = Math.max(0, r17) + r18;
        r14[0] = Math.max(0, -r16);
        r14[1] = Math.max(0, -r17);
        int r110 = getPaddingLeft();
        int r20 = ViewGroup.getChildMeasureSpec(r10, ((getPaddingRight() + r110) + r19) + r11, r15.width);
        int r111 = getPaddingTop();
        r8.measure(r20, ViewGroup.getChildMeasureSpec(r12, (((getPaddingBottom() + r111) + r15.topMargin) + r15.bottomMargin) + r13, r15.height));
        return r8.getMeasuredWidth() + r19;
    }

    public final void q(View r8, int r10, int r11, int r12, int r13) {
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r15 = getPaddingLeft();
        int r16 = ViewGroup.getChildMeasureSpec(r10, (((getPaddingRight() + r15) + r14.leftMargin) + r14.rightMargin) + r11, r14.width);
        int r17 = getPaddingTop();
        int r18 = ViewGroup.getChildMeasureSpec(r12, (((getPaddingBottom() + r17) + r14.topMargin) + r14.bottomMargin) + 0, r14.height);
        int r19 = View.MeasureSpec.getMode(r18);
        if (r19 == 1073741824) goto L8;
        if (r13 < 0) goto L8;
        if (r19 == 0) goto L7;
        r13 = Math.min(View.MeasureSpec.getSize(r18), r13);
    L7:
        r18 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
    L8:
        r8.measure(r16, r18);
    }

    public final boolean r(View r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getParent() != this) goto L8;
        if (r8.getVisibility() == 8) goto L8;
        return true;
    }

    final void s() {
        if (Build.VERSION.SDK_INT < 33) goto L30;
        OnBackInvokedDispatcher r8 = e.a(this);
        f r10 = this.W;
        int r11 = 1;
        boolean r12 = false;
        if (r10 != null) goto L7;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L17;
        if (r8 == null) goto L17;
        WeakHashMap<View, j0.h0> r14 = j0.w.f8437a;
        if (j0.w.g.b(this) == false) goto L17;
        if (this.f1059c0 == false) goto L17;
        r12 = true;
    L17:
        if (r12 == true) goto L19;
    L24:
        if (r12 == true) goto L31;
        OnBackInvokedDispatcher r15 = this.f1058b0;
        if (r15 == null) goto L32;
        e.d(r15, this.f1056a0);
        r8 = null;
    L28:
        this.f1058b0 = r8;
        return;
    L32:
        return;
    L31:
        return;
    L19:
        if (this.f1058b0 != null) goto L24;
        if (this.f1056a0 != null) goto L23;
        this.f1056a0 = e.b(new androidx.activity.j(this, r11));
    L23:
        e.c(r8, this.f1056a0);
        goto L28
    L7:
        if (r10.f1081b == null) goto L9;
        r13 = true;
        goto L10
    }

    public void setBackInvokedCallbackEnabled(boolean r8) {
        if (this.f1059c0 == r8) goto L6;
        this.f1059c0 = r8;
        s();
        return;
    }

    public void setCollapseContentDescription(int r8) {
        if (r8 == 0) goto L4;
        CharSequence r10 = getContext().getText(r8);
    L5:
        setCollapseContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setCollapseIcon(int r8) {
        setCollapseIcon(d.a.a(getContext(), r8));
    }

    public void setCollapsible(boolean r8) {
        this.Z = r8;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r8) {
        if (r8 >= 0) goto L5;
        r8 = Integer.MIN_VALUE;
    L5:
        if (r8 == this.F) goto L10;
        this.F = r8;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r8) {
        if (r8 >= 0) goto L5;
        r8 = Integer.MIN_VALUE;
    L5:
        if (r8 == this.E) goto L10;
        this.E = r8;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setLogo(int r8) {
        setLogo(d.a.a(getContext(), r8));
    }

    public void setLogoDescription(int r8) {
        setLogoDescription(getContext().getText(r8));
    }

    public void setNavigationContentDescription(int r8) {
        if (r8 == 0) goto L4;
        CharSequence r10 = getContext().getText(r8);
    L5:
        setNavigationContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setNavigationIcon(int r8) {
        setNavigationIcon(d.a.a(getContext(), r8));
    }

    public void setNavigationOnClickListener(View.OnClickListener r8) {
        f();
        this.f1061n.setOnClickListener(r8);
    }

    public void setOnMenuItemClickListener(h r8) {
        this.S = r8;
    }

    public void setOverflowIcon(Drawable r8) {
        d();
        this.f1055a.setOverflowIcon(r8);
    }

    public void setPopupTheme(int r8) {
        if (this.f1068u == r8) goto L9;
        this.f1068u = r8;
        if (r8 != 0) goto L7;
        this.f1067t = getContext();
        return;
    L7:
        this.f1067t = new ContextThemeWrapper(getContext(), r8);
        return;
    }

    public void setSubtitle(int r8) {
        setSubtitle(getContext().getText(r8));
    }

    public void setSubtitleTextColor(int r8) {
        setSubtitleTextColor(ColorStateList.valueOf(r8));
    }

    public void setTitle(int r8) {
        setTitle(getContext().getText(r8));
    }

    public void setTitleMarginBottom(int r8) {
        this.C = r8;
        requestLayout();
    }

    public void setTitleMarginEnd(int r8) {
        this.A = r8;
        requestLayout();
    }

    public void setTitleMarginStart(int r8) {
        this.f1073z = r8;
        requestLayout();
    }

    public void setTitleMarginTop(int r8) {
        this.B = r8;
        requestLayout();
    }

    public void setTitleTextColor(int r8) {
        setTitleTextColor(ColorStateList.valueOf(r8));
    }

    public Toolbar(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, R.attr.toolbarStyle);
        this.G = 8388627;
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = new int[2];
        this.Q = new j0.i(new androidx.activity.d(this, 2));
        this.R = new ArrayList();
        this.T = new a(this);
        this.d0 = new b(this);
        Context r8 = getContext();
        int[] r10 = c.a.f3239y;
        v0 r14 = v0.m(r8, r12, r10, R.attr.toolbarStyle);
        TypedArray r15 = r14.f1275b;
        WeakHashMap<View, j0.h0> r16 = j0.w.f8437a;
        j0.w.m.c(this, r11, r10, r12, r15, R.attr.toolbarStyle, 0);
        this.f1069v = r14.i(28, 0);
        this.f1070w = r14.i(19, 0);
        TypedArray r17 = r14.f1275b;
        this.G = r17.getInteger(0, 8388627);
        this.f1071x = r17.getInteger(2, 48);
        int r18 = r14.c(22, 0);
        if (r14.l(27) == false) goto L5;
        r18 = r14.c(27, r18);
    L5:
        this.C = r18;
        this.B = r18;
        this.A = r18;
        this.f1073z = r18;
        int r19 = r14.c(25, -1);
        if (r19 < 0) goto L8;
        this.f1073z = r19;
    L8:
        int r110 = r14.c(24, -1);
        if (r110 < 0) goto L11;
        this.A = r110;
    L11:
        int r111 = r14.c(26, -1);
        if (r111 < 0) goto L14;
        this.B = r111;
    L14:
        int r112 = r14.c(23, -1);
        if (r112 < 0) goto L17;
        this.C = r112;
    L17:
        this.f1072y = r14.d(13, -1);
        int r113 = r14.c(9, Integer.MIN_VALUE);
        int r20 = r14.c(5, Integer.MIN_VALUE);
        int r21 = r14.d(7, 0);
        int r22 = r14.d(8, 0);
        if (this.D != null) goto L20;
        this.D = new n0();
    L20:
        n0 r23 = this.D;
        r23.f1229h = false;
        if (r21 == Integer.MIN_VALUE) goto L23;
        r23.f1226e = r21;
        r23.f1222a = r21;
    L23:
        if (r22 == Integer.MIN_VALUE) goto L25;
        r23.f1227f = r22;
        r23.f1223b = r22;
    L25:
        if (r113 != Integer.MIN_VALUE) goto L27;
        if (r20 != Integer.MIN_VALUE) goto L27;
    L28:
        this.E = r14.c(10, Integer.MIN_VALUE);
        this.F = r14.c(6, Integer.MIN_VALUE);
        this.f1063p = r14.e(4);
        this.f1064q = r14.k(3);
        CharSequence r114 = r14.k(21);
        if (TextUtils.isEmpty(r114) == true) goto L31;
        setTitle(r114);
    L31:
        CharSequence r115 = r14.k(18);
        if (TextUtils.isEmpty(r115) == true) goto L34;
        setSubtitle(r115);
    L34:
        this.f1067t = getContext();
        setPopupTheme(r14.i(17, 0));
        Drawable r116 = r14.e(16);
        if (r116 == null) goto L37;
        setNavigationIcon(r116);
    L37:
        CharSequence r117 = r14.k(15);
        if (TextUtils.isEmpty(r117) == true) goto L40;
        setNavigationContentDescription(r117);
    L40:
        Drawable r118 = r14.e(11);
        if (r118 == null) goto L43;
        setLogo(r118);
    L43:
        CharSequence r119 = r14.k(12);
        if (TextUtils.isEmpty(r119) == true) goto L47;
        setLogoDescription(r119);
    L47:
        if (r14.l(29) == false) goto L50;
        setTitleTextColor(r14.b(29));
    L50:
        if (r14.l(20) == false) goto L53;
        setSubtitleTextColor(r14.b(20));
    L53:
        if (r14.l(14) == false) goto L55;
        k(r14.i(14, 0));
    L55:
        r14.n();
        return;
    L27:
        r23.a(r113, r20);
        goto L28
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return g(r8);
    }

    public void setCollapseContentDescription(CharSequence r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        c();
    L5:
        m r10 = this.f1065r;
        if (r10 == null) goto L9;
        r10.setContentDescription(r8);
        return;
    }

    public void setCollapseIcon(Drawable r8) {
        if (r8 == null) goto L4;
        c();
        this.f1065r.setImageDrawable(r8);
        return;
    L4:
        m r10 = this.f1065r;
        if (r10 == null) goto L9;
        r10.setImageDrawable(this.f1063p);
        return;
    }

    public void setLogo(Drawable r8) {
        if (r8 != null) goto L4;
        AppCompatImageView r10 = this.f1062o;
        if (r10 != null) goto L12;
    L14:
        AppCompatImageView r11 = this.f1062o;
        if (r11 == null) goto L18;
        r11.setImageDrawable(r8);
        return;
    L18:
        return;
    L12:
        if (m(r10) == false) goto L14;
        removeView(this.f1062o);
        this.O.remove(this.f1062o);
        goto L14
    L4:
        if (this.f1062o != null) goto L7;
        this.f1062o = new AppCompatImageView(getContext(), null);
    L7:
        if (m(this.f1062o) == true) goto L14;
        b(this.f1062o, true);
        goto L14
    }

    public void setLogoDescription(CharSequence r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L7:
        AppCompatImageView r10 = this.f1062o;
        if (r10 == null) goto L11;
        r10.setContentDescription(r8);
        return;
    L11:
        return;
    L5:
        if (this.f1062o != null) goto L7;
        this.f1062o = new AppCompatImageView(getContext(), null);
        goto L7
    }

    public void setNavigationContentDescription(CharSequence r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        f();
    L5:
        m r10 = this.f1061n;
        if (r10 == null) goto L9;
        r10.setContentDescription(r8);
        y0.a(this.f1061n, r8);
        return;
    }

    public void setNavigationIcon(Drawable r8) {
        if (r8 == null) goto L6;
        f();
        if (m(this.f1061n) == true) goto L11;
        b(this.f1061n, true);
    L11:
        m r10 = this.f1061n;
        if (r10 == null) goto L15;
        r10.setImageDrawable(r8);
        return;
    L15:
        return;
    L6:
        m r11 = this.f1061n;
        if (r11 == null) goto L11;
        if (m(r11) == false) goto L11;
        removeView(this.f1061n);
        this.O.remove(this.f1061n);
        goto L11
    }

    public void setSubtitle(CharSequence r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        y r10 = this.f1060m;
        if (r10 != null) goto L18;
    L20:
        y r11 = this.f1060m;
        if (r11 == null) goto L23;
        r11.setText(r8);
    L23:
        this.I = r8;
        return;
    L18:
        if (m(r10) == false) goto L20;
        removeView(this.f1060m);
        this.O.remove(this.f1060m);
        goto L20
    L5:
        if (this.f1060m != null) goto L13;
        Context r12 = getContext();
        y r13 = new y(r12, null);
        this.f1060m = r13;
        r13.setSingleLine();
        this.f1060m.setEllipsize(TextUtils.TruncateAt.END);
        int r14 = this.f1070w;
        if (r14 == 0) goto L9;
        this.f1060m.setTextAppearance(r12, r14);
    L9:
        ColorStateList r15 = this.K;
        if (r15 == null) goto L13;
        this.f1060m.setTextColor(r15);
    L13:
        if (m(this.f1060m) == true) goto L20;
        b(this.f1060m, true);
        goto L20
    }

    public void setSubtitleTextColor(ColorStateList r8) {
        this.K = r8;
        y r10 = this.f1060m;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    }

    public void setTitle(CharSequence r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        y r10 = this.f1057b;
        if (r10 != null) goto L18;
    L20:
        y r11 = this.f1057b;
        if (r11 == null) goto L23;
        r11.setText(r8);
    L23:
        this.H = r8;
        return;
    L18:
        if (m(r10) == false) goto L20;
        removeView(this.f1057b);
        this.O.remove(this.f1057b);
        goto L20
    L5:
        if (this.f1057b != null) goto L13;
        Context r12 = getContext();
        y r13 = new y(r12, null);
        this.f1057b = r13;
        r13.setSingleLine();
        this.f1057b.setEllipsize(TextUtils.TruncateAt.END);
        int r14 = this.f1069v;
        if (r14 == 0) goto L9;
        this.f1057b.setTextAppearance(r12, r14);
    L9:
        ColorStateList r15 = this.J;
        if (r15 == null) goto L13;
        this.f1057b.setTextColor(r15);
    L13:
        if (m(this.f1057b) == true) goto L20;
        b(this.f1057b, true);
        goto L20
    }

    public void setTitleTextColor(ColorStateList r8) {
        this.J = r8;
        y r10 = this.f1057b;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    }
}
