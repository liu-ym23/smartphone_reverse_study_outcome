package com.obric.oui.orecyclerview.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.common.reflect.w f13838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f13839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.lynx.animax.player.b f13840c;
    public final com.lynx.animax.player.b d;
    public final boolean e;
    public final boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13845l;

    public k0() {
        i0 r5 = new i0(this);
        j0 r10 = new j0(this);
        this.f13840c = new com.lynx.animax.player.b(r5);
        this.d = new com.lynx.animax.player.b(r10);
        this.e = true;
        this.f = true;
    }

    public static int B(View r5) {
        return ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13768a.getLayoutPosition();
    }

    public static boolean E(int r5, int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r11 <= 0) goto L7;
        if (r5 == r11) goto L7;
        return false;
    L7:
        if (r12 == Integer.MIN_VALUE) goto L16;
        if (r12 != 0) goto L10;
        return true;
    L10:
        if (r12 == 1073741824) goto L12;
        return false;
    L12:
        if (r13 == r5) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (r13 >= r5) goto L18;
        return false;
    L18:
        return true;
    }

    public static int e(int r5, int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r5);
        int r13 = View.MeasureSpec.getSize(r5);
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 != 1073741824) goto L7;
        return r13;
    L7:
        return Math.max(r10, r11);
    L9:
        return Math.min(r13, Math.max(r10, r11));
    }

    public static int s(int r5, int r10, int r11, int r12, boolean r13) {
        int r14 = Math.max(0, r5 - r11);
        if (r13 == false) goto L11;
        if (r12 < 0) goto L6;
    L5:
        r10 = 1073741824;
    L22:
        return View.MeasureSpec.makeMeasureSpec(r12, r10);
    L6:
        if (r12 != (-1)) goto L10;
        if (r10 == Integer.MIN_VALUE) goto L14;
        if (r10 == 0) goto L10;
        if (r10 != 1073741824) goto L10;
    L14:
        r12 = r14;
    L10:
        r10 = 0;
        r12 = 0;
        goto L22
    L11:
        if (r12 >= 0) goto L5;
        if (r12 == (-1)) goto L14;
        if (r12 != (-2)) goto L10;
        if (r10 == Integer.MIN_VALUE) goto L20;
        if (r10 == 1073741824) goto L20;
        r12 = r14;
        r10 = 0;
    L20:
        r12 = r14;
        r10 = Integer.MIN_VALUE;
        goto L22
    }

    public static void t(View r10, Rect r11) {
        boolean r5 = RecyclerView.f13723x0;
        RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        Rect r13 = r12.f13769b;
        r11.set((r10.getLeft() - r13.left) - ((ViewGroup.MarginLayoutParams) r12).leftMargin, (r10.getTop() - r13.top) - ((ViewGroup.MarginLayoutParams) r12).topMargin, (r10.getRight() + r13.right) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, (r10.getBottom() + r13.bottom) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
    }

    public static int u(View r5) {
        Rect r10 = ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b;
        return (r5.getMeasuredHeight() + r10.top) + r10.bottom;
    }

    public static int v(View r5) {
        Rect r10 = ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b;
        return (r5.getMeasuredWidth() + r10.left) + r10.right;
    }

    public final int A() {
        RecyclerView r5 = this.f13839b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getPaddingTop();
    }

    public final void C(View r10, Rect r11) {
        Rect r5 = ((RecyclerView.LayoutParams) r10.getLayoutParams()).f13769b;
        r11.set(-r5.left, -r5.top, r10.getWidth() + r5.right, r10.getHeight() + r5.bottom);
        if (this.f13839b == null) goto L9;
        Matrix r12 = r10.getMatrix();
        if (r12 == null) goto L9;
        if (r12.isIdentity() == true) goto L9;
        RectF r13 = this.f13839b.f13740k;
        r13.set(r11);
        r12.mapRect(r13);
        r11.set((int) Math.floor(r13.left), (int) Math.floor(r13.top), (int) Math.ceil(r13.right), (int) Math.ceil(r13.bottom));
    L9:
        r11.offset(r10.getLeft(), r10.getTop());
    }

    public boolean D() {
        return false;
    }

    public final void F(View r13) {
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r13.getLayoutParams();
        RecyclerView r10 = this.f13839b;
        r10.getClass();
        RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r13.getLayoutParams();
        boolean r12 = r11.f13770c;
        Rect r14 = r11.f13769b;
        if (r12 == false) goto L16;
        u0 r15 = r10.f13729b0;
        if (r15.f == true) goto L8;
    L12:
        r14.set(0, 0, 0, 0);
        ArrayList r16 = r10.f13747o;
        int r17 = r16.size();
        int r18 = 0;
    L13:
        if (r18 >= r17) goto L15;
        Rect r19 = r10.f13737i;
        r19.set(0, 0, 0, 0);
        ((h0) r16.get(r18)).a(r19, r13, r10, r15);
        r14.left += r19.left;
        r14.top += r19.top;
        r14.right += r19.right;
        r14.bottom += r19.bottom;
        r18 = r18 + 1;
        goto L13
    L15:
        r11.f13770c = false;
        goto L16
    L8:
        if (r11.f13768a.isUpdated() == true) goto L16;
        if (r11.f13768a.isInvalid() == false) goto L12;
    L16:
        int r20 = r14.left + r14.right;
        int r21 = r14.top + r14.bottom;
        int r22 = s(this.f13844k, this.f13842i, (((z() + y()) + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin) + r20, ((ViewGroup.MarginLayoutParams) r5).width, c());
        int r23 = s(this.f13845l, this.f13843j, (((x() + A()) + ((ViewGroup.MarginLayoutParams) r5).topMargin) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin) + r21, ((ViewGroup.MarginLayoutParams) r5).height, d());
        if (r13.isLayoutRequested() == false) goto L19;
    L24:
        r13.measure(r22, r23);
        return;
    L19:
        if (this.e == false) goto L24;
        if (E(r13.getWidth(), r22, ((ViewGroup.MarginLayoutParams) r5).width) == false) goto L24;
        if (E(r13.getHeight(), r23, ((ViewGroup.MarginLayoutParams) r5).height) == false) goto L24;
    }

    public View G(int r5, q0 r10, u0 r11) {
        return null;
    }

    public void H(AccessibilityEvent r5) {
        RecyclerView r10 = this.f13839b;
        q0 r11 = r10.f13728b;
        u0 r12 = r10.f13729b0;
        if (r10 == null) goto L20;
        if (r5 == null) goto L22;
        boolean r13 = true;
        if (r10.canScrollVertically(1) == false) goto L9;
    L16:
        r5.setScrollable(r13);
        a0 r14 = this.f13839b.f13742l;
        if (r14 == null) goto L21;
        r5.setItemCount(r14.getItemCount());
        return;
    L21:
        return;
    L9:
        if (this.f13839b.canScrollVertically(-1) == true) goto L16;
        if (this.f13839b.canScrollHorizontally(-1) == true) goto L16;
        if (this.f13839b.canScrollHorizontally(1) == true) goto L16;
        r13 = false;
        goto L16
    L22:
        return;
    }

    public abstract void I(q0 r5, u0 r10);

    public void J() {
    }

    public void K(Parcelable r5) {
    }

    public Parcelable L() {
        return null;
    }

    public final void M(q0 r5) {
        int r10 = r() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (RecyclerView.F(q(r10)).shouldIgnore() == true) goto L7;
        View r11 = q(r10);
        O(r10);
        r5.g(r11);
    L7:
        r10 = r10 - 1;
        goto L3
    }

    public final void N(q0 r10) {
        int r5 = r10.f13885a.size();
        int r11 = r5 - 1;
    L3:
        ArrayList r12 = r10.f13885a;
        if (r11 < 0) goto L16;
        View r13 = ((x0) r12.get(r11)).itemView;
        x0 r14 = RecyclerView.F(r13);
        if (r14.shouldIgnore() == true) goto L15;
        r14.setIsRecyclable(false);
        if (r14.isTmpDetached() == false) goto L11;
        this.f13839b.removeDetachedView(r13, false);
    L11:
        g0 r15 = this.f13839b.H;
        if (r15 == null) goto L14;
        r15.d(r14);
    L14:
        r14.setIsRecyclable(true);
        x0 r16 = RecyclerView.F(r13);
        r16.mScrapContainer = null;
        r16.mInChangeScrap = false;
        r16.clearReturnedFromScrapFlag();
        r10.h(r16);
    L15:
        r11 = r11 - 1;
        goto L3
    L16:
        r12.clear();
        ArrayList r17 = r10.f13886b;
        if (r17 == null) goto L19;
        r17.clear();
    L19:
        if (r5 <= 0) goto L25;
        this.f13839b.invalidate();
        return;
    }

    public final void O(int r5) {
        if (q(r5) == null) goto L12;
        com.google.common.reflect.w r10 = this.f13838a;
        int r11 = r10.q(r5);
        y r12 = (y) r10.f9377c;
        View r13 = ((RecyclerView) r12.f13929a).getChildAt(r11);
        if (r13 != null) goto L8;
        return;
    L8:
        if (((com.bytedance.crash.upload.l) r10.f9376b).g(r11) == false) goto L10;
        r10.z(r13);
    L10:
        r12.h(r11);
        return;
    }

    public final boolean P(RecyclerView r10, View r11, Rect r12, boolean r13, boolean r14) {
        int r5 = y();
        int r15 = A();
        int r16 = this.f13844k - z();
        int r17 = this.f13845l - x();
        int r18 = (r11.getLeft() + r12.left) - r11.getScrollX();
        int r19 = (r11.getTop() + r12.top) - r11.getScrollY();
        int r110 = r12.width() + r18;
        int r111 = r12.height() + r19;
        int r20 = r18 - r5;
        int r21 = Math.min(0, r20);
        int r22 = r19 - r15;
        int r23 = Math.min(0, r22);
        int r112 = r110 - r16;
        int r24 = Math.max(0, r112);
        int r113 = Math.max(0, r111 - r17);
        if (ViewCompat.getLayoutDirection(this.f13839b) != 1) goto L7;
        if (r24 != 0) goto L11;
        r24 = Math.max(r21, r112);
    L11:
        if (r23 != 0) goto L14;
        r23 = Math.min(r22, r113);
    L14:
        int[] r114 = {r24, r23};
        int r25 = r114[0];
        int r26 = r114[1];
        if (r14 == false) goto L28;
        View r115 = r10.getFocusedChild();
        if (r115 == null) goto L31;
        int r116 = y();
        int r117 = A();
        int r27 = this.f13844k - z();
        int r28 = this.f13845l - x();
        Rect r29 = this.f13839b.f13737i;
        t(r115, r29);
        if ((r29.left - r25) >= r27) goto L31;
        if ((r29.right - r25) <= r116) goto L31;
        if ((r29.top - r26) >= r28) goto L31;
        if ((r29.bottom - r26) > r117) goto L28;
    L31:
        return false;
    L28:
        if (r25 != 0) goto L32;
        if (r26 == 0) goto L31;
    L32:
        if (r13 == false) goto L34;
        r10.scrollBy(r25, r26);
    L35:
        return true;
    L34:
        r10.W(r25, r26, null, Integer.MIN_VALUE, false);
        goto L35
    L7:
        if (r21 != 0) goto L10;
        r21 = Math.min(r20, r24);
    L10:
        r24 = r21;
        goto L11
    }

    public final void Q() {
        RecyclerView r5 = this.f13839b;
        if (r5 == null) goto L6;
        r5.requestLayout();
        return;
    }

    public final void R(q0 r5, int r10, View r11) {
        x0 r12 = RecyclerView.F(r11);
        if (r12.shouldIgnore() == false) goto L9;
        if (RecyclerView.f13724y0 == false) goto L17;
        Log.d("RecyclerView", "ignoring view " + r12);
        return;
    L17:
        return;
    L9:
        if (r12.isInvalid() == true) goto L11;
    L15:
        q(r10);
        this.f13838a.m(r10);
        r5.i(r11);
        this.f13839b.f.t(r12);
        return;
    L11:
        if (r12.isRemoved() == true) goto L15;
        if (this.f13839b.f13742l.hasStableIds() == true) goto L15;
        O(r10);
        r5.h(r12);
    }

    public int S(int r5, q0 r10, u0 r11) {
        return 0;
    }

    public abstract void T(int r5);

    public abstract int U(int r5, q0 r10, u0 r11);

    public final void V(RecyclerView r5) {
        W(View.MeasureSpec.makeMeasureSpec(r5.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r5.getHeight(), BasicMeasure.EXACTLY));
    }

    public final void W(int r5, int r10) {
        this.f13844k = View.MeasureSpec.getSize(r5);
        int r11 = View.MeasureSpec.getMode(r5);
        this.f13842i = r11;
        if (r11 == 0) goto L5;
    L7:
        this.f13845l = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        this.f13843j = r12;
        if (r12 == 0) goto L10;
        return;
    L10:
        if (RecyclerView.A0 == true) goto L14;
        this.f13845l = 0;
        return;
    L14:
        return;
    L5:
        if (RecyclerView.A0 == true) goto L7;
        this.f13844k = 0;
        goto L7
    }

    public final void X(int r10, int r11) {
        int r5 = r();
        if (r5 != 0) goto L6;
        this.f13839b.o(r10, r11);
        return;
    L6:
        int r12 = Integer.MIN_VALUE;
        int r13 = Integer.MAX_VALUE;
        int r14 = 0;
        int r15 = Integer.MIN_VALUE;
        int r16 = Integer.MAX_VALUE;
    L7:
        if (r14 >= r5) goto L21;
        View r17 = q(r14);
        Rect r18 = this.f13839b.f13737i;
        t(r17, r18);
        int r19 = r18.left;
        if (r19 >= r16) goto L11;
        r16 = r19;
    L11:
        int r20 = r18.right;
        if (r20 <= r12) goto L14;
        r12 = r20;
    L14:
        int r21 = r18.top;
        if (r21 >= r13) goto L17;
        r13 = r21;
    L17:
        int r22 = r18.bottom;
        if (r22 <= r15) goto L20;
        r15 = r22;
    L20:
        r14 = r14 + 1;
        goto L7
    L21:
        this.f13839b.f13737i.set(r16, r13, r12, r15);
        Rect r23 = this.f13839b.f13737i;
        int r24 = z() + (y() + r23.width());
        int r25 = x() + (A() + r23.height());
        RecyclerView.f(this.f13839b, e(r10, r24, ViewCompat.getMinimumWidth(this.f13839b)), e(r11, r25, ViewCompat.getMinimumHeight(this.f13839b)));
    }

    public final void Y(RecyclerView r5) {
        if (r5 != null) goto L4;
        this.f13839b = null;
        this.f13838a = null;
        this.f13844k = 0;
        this.f13845l = 0;
    L5:
        this.f13842i = BasicMeasure.EXACTLY;
        this.f13843j = BasicMeasure.EXACTLY;
        return;
    L4:
        this.f13839b = r5;
        this.f13838a = r5.e;
        this.f13844k = r5.getWidth();
        this.f13845l = r5.getHeight();
        goto L5
    }

    public boolean Z() {
        return false;
    }

    public final void a(View r10, int r11, boolean r12) {
        x0 r5 = RecyclerView.F(r10);
        if (r12 == false) goto L5;
    L8:
        SimpleArrayMap r13 = (SimpleArrayMap) this.f13839b.f.f18728b;
        c1 r14 = (c1) r13.get(r5);
        if (r14 != null) goto L11;
        r14 = c1.a();
        r13.put(r5, r14);
    L11:
        r14.f13797a |= 1;
    L12:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        if (r5.wasReturnedFromScrap() == true) goto L40;
        if (r5.isScrap() == true) goto L40;
        if (r10.getParent() != this.f13839b) goto L38;
        int r16 = this.f13838a.u(r10);
        if (r11 != (-1)) goto L22;
        r11 = this.f13838a.o();
    L22:
        if (r16 == (-1)) goto L36;
        if (r16 == r11) goto L45;
        k0 r17 = this.f13839b.f13743m;
        View r18 = r17.q(r16);
        if (r18 == null) goto L35;
        r17.q(r16);
        r17.f13838a.m(r16);
        RecyclerView.LayoutParams r19 = (RecyclerView.LayoutParams) r18.getLayoutParams();
        x0 r20 = RecyclerView.F(r18);
        if (r20.isRemoved() == false) goto L32;
        SimpleArrayMap r21 = (SimpleArrayMap) r17.f13839b.f.f18728b;
        c1 r22 = (c1) r21.get(r20);
        if (r22 != null) goto L31;
        r22 = c1.a();
        r21.put(r20, r22);
    L31:
        r22.f13797a = 1 | r22.f13797a;
    L33:
        r17.f13838a.j(r18, r11, r19, r20.isRemoved());
        goto L45
    L32:
        r17.f13839b.f.t(r20);
        goto L33
    L35:
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r16 + r17.f13839b.toString());
    L45:
        if (r15.d == true) goto L47;
        return;
    L47:
        if (RecyclerView.f13724y0 == false) goto L49;
        Log.d("RecyclerView", "consuming pending invalidate on child " + r15.f13768a);
    L49:
        r5.itemView.invalidate();
        r15.d = false;
        return;
    L36:
        StringBuilder r110 = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
        r110.append(this.f13839b.indexOfChild(r10));
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.n(this.f13839b, r110));
    L38:
        this.f13838a.i(r10, r11, false);
        r15.f13770c = true;
    L40:
        if (r5.isScrap() == false) goto L42;
        r5.unScrap();
    L43:
        this.f13838a.j(r10, r11, r10.getLayoutParams(), false);
        goto L45
    L42:
        r5.clearReturnedFromScrapFlag();
        goto L43
    L5:
        if (r5.isRemoved() == true) goto L8;
        this.f13839b.f.t(r5);
        goto L12
    }

    public boolean a0() {
        return false;
    }

    public void b(String r5) {
        RecyclerView r10 = this.f13839b;
        if (r10 == null) goto L6;
        r10.j(r5);
        return;
    }

    public boolean c() {
        return false;
    }

    public abstract boolean d();

    public void f(int r5, int r10, u0 r11, com.airbnb.lottie.parser.moshi.c r12) {
    }

    public void g(int r5, com.airbnb.lottie.parser.moshi.c r10) {
    }

    public int h(u0 r5) {
        return 0;
    }

    public int i(u0 r5) {
        return 0;
    }

    public int j(u0 r5) {
        return 0;
    }

    public int k(u0 r5) {
        return 0;
    }

    public int l(u0 r5) {
        return 0;
    }

    public int m(u0 r5) {
        return 0;
    }

    public final void n(q0 r5) {
        int r10 = r() - 1;
    L3:
        if (r10 < 0) goto L5;
        R(r5, r10, q(r10));
        r10 = r10 - 1;
        goto L3
    }

    public View o(int r10) {
        int r5 = r();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L17;
        View r12 = q(r11);
        x0 r13 = RecyclerView.F(r12);
        if (r13 == null) goto L16;
        if (r13.getLayoutPosition() != r10) goto L16;
        if (r13.shouldIgnore() == true) goto L16;
        if (this.f13839b.f13729b0.f == true) goto L15;
        if (r13.isRemoved() == true) goto L16;
    L15:
        return r12;
    L16:
        r11 = r11 + 1;
        goto L3
    L17:
        return null;
    }

    public abstract RecyclerView.LayoutParams p();

    public final View q(int r5) {
        com.google.common.reflect.w r10 = this.f13838a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.n(r5);
    }

    public final int r() {
        com.google.common.reflect.w r5 = this.f13838a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.o();
    }

    public final int w() {
        RecyclerView r5 = this.f13839b;
        if (r5 == null) goto L5;
        a0 r10 = r5.getAdapter();
    L6:
        if (r10 != null) goto L10;
        return 0;
    L10:
        return r10.getItemCount();
    L5:
        r10 = null;
        goto L6
    }

    public final int x() {
        RecyclerView r5 = this.f13839b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getPaddingBottom();
    }

    public final int y() {
        RecyclerView r5 = this.f13839b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getPaddingLeft();
    }

    public final int z() {
        RecyclerView r5 = this.f13839b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getPaddingRight();
    }
}
