package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DiscreteScrollLayoutManager extends RecyclerView.LayoutManager {
    public DiscreteScrollItemTransformer A;
    public final com.ss.android.lark.discretescrollview.a B;
    public final Point a;
    public final Point b;
    public final Point c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public final SparseArray<View> m;
    public DSVOrientation.a n;
    public boolean o;
    public final Context p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public boolean v;
    public int w;
    public int x;
    public DSVScrollConfig y;
    public final c z;

    public class a extends LinearSmoothScroller {
        public final /* synthetic */ DiscreteScrollLayoutManager a;

        public final int calculateTimeForScrolling(int r2) {
            return (int) (Math.max(0.01f, Math.min(Math.abs(r2), this.a.g) / this.a.g) * this.a.q);
        }

        public final PointF computeScrollVectorForPosition(int r4) {
            DiscreteScrollLayoutManager r0 = this.a;
            float r1 = r0.n.e(r0.j);
            DiscreteScrollLayoutManager r2 = this.a;
            return new PointF(r1, r2.n.c(r2.j));
        }

        public a(DiscreteScrollLayoutManager r1, Context r2) {
            this.a = r1;
            super(r2);
        }

        public final int calculateDxToMakeVisible(View r1, int r2) {
            DiscreteScrollLayoutManager r3 = this.a;
            return r3.n.e(-r3.j);
        }

        public final int calculateDyToMakeVisible(View r1, int r2) {
            DiscreteScrollLayoutManager r3 = this.a;
            return r3.n.c(-r3.j);
        }
    }

    public interface b {
        int g0();
    }

    public interface c {
    }

    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final boolean canScrollHorizontally() {
        return this.n.i();
    }

    public final boolean canScrollVertically() {
        return this.n.l();
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        int r1 = this.l;
        if (r1 == (-1)) goto L5;
        this.k = r1;
    L5:
        r0.putInt("extra_position", this.k);
        return r0;
    }

    public final void p() {
        if (this.A == null) goto L8;
        int r0 = this.g * this.s;
        int r1 = 0;
    L6:
        if (r1 >= this.B.a()) goto L10;
        View r2 = this.B.a.getChildAt(r1);
        this.A.transformItem(r2, Math.min(Math.max(-1.0f, this.n.d(this.b, getDecoratedLeft(r2) + (r2.getWidth() * 0.5f), getDecoratedTop(r2) + (r2.getHeight() * 0.5f)) / r0), 1.0f));
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }

    public final void u() {
        a r0 = new a(this, this.p);
        r0.setTargetPosition(this.k);
        this.B.a.startSmoothScroll(r0);
    }

    public final int computeHorizontalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    public final int computeHorizontalScrollOffset(RecyclerView.State r3) {
        int r4 = computeScrollExtent(r3);
        return (this.k * r4) + ((int) ((this.i / this.g) * r4));
    }

    public final int computeHorizontalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    public final int computeScrollExtent(RecyclerView.State r2) {
        if (getItemCount() != 0) goto L7;
        return 0;
    L7:
        return (int) (computeScrollRange(r2) / getItemCount());
    }

    public final int computeScrollRange(RecyclerView.State r2) {
        if (r2.getItemCount() != 0) goto L7;
        return 0;
    L7:
        return this.g * (r2.getItemCount() - 1);
    }

    public final int computeVerticalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    public final int computeVerticalScrollOffset(RecyclerView.State r3) {
        int r4 = computeScrollExtent(r3);
        return (this.k * r4) + ((int) ((this.i / this.g) * r4));
    }

    public final int computeVerticalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r3);
        if (this.B.a() <= 0) goto L6;
        r3.setFromIndex(getPosition(this.B.a.getChildAt(0)));
        com.ss.android.lark.discretescrollview.a r0 = this.B;
        r3.setToIndex(getPosition(r0.a.getChildAt(r0.a() - 1)));
        return;
    }

    public final void onItemsChanged(RecyclerView r3) {
        this.k = Math.min(Math.max(0, this.k), this.B.b() - 1);
        this.t = true;
    }

    public final void onLayoutCompleted(RecyclerView.State r2) {
        if (this.o == false) goto L6;
        DiscreteScrollView.access$000(((DiscreteScrollView.d) this.z).a);
        this.o = false;
        return;
    L6:
        if (this.t == false) goto L10;
        DiscreteScrollView.access$000(((DiscreteScrollView.d) this.z).a);
        this.t = false;
        return;
    }

    public final void onRestoreInstanceState(Parcelable r2) {
        this.k = ((Bundle) r2).getInt("extra_position");
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [android.view.ViewGroup, com.ss.android.lark.discretescrollview.DiscreteScrollView] */
    public final void onScrollStateChanged(int r9) {
        int r0 = this.h;
        if (r0 != 0) goto L11;
        if (r0 == r9) goto L11;
        DiscreteScrollView.d r1 = (DiscreteScrollView.d) this.z;
        ?? r2 = r1.a;
        r2.removeCallbacks(DiscreteScrollView.access$300(r2));
        if (DiscreteScrollView.access$400(r1.a).isEmpty() == true) goto L11;
        int r3 = DiscreteScrollView.access$500(r1.a).k;
        RecyclerView.ViewHolder r4 = r1.a.getViewHolder(r3);
        if (r4 == null) goto L11;
        DiscreteScrollView.access$600(r1.a, r4, r3);
    L11:
        boolean r5 = false;
        if (r9 != 0) goto L40;
        int r6 = this.l;
        if (r6 == (-1)) goto L16;
        this.k = r6;
        this.l = -1;
        this.i = 0;
    L16:
        Direction r7 = Direction.fromDelta(this.i);
        if (Math.abs(this.i) != this.g) goto L20;
        this.k += r7.applyTo(1);
        this.i = 0;
    L20:
        if (Math.abs(this.i) < (this.g * 0.6f)) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L25;
        this.j = Direction.fromDelta(this.i).applyTo(this.g - Math.abs(this.i));
    L27:
        if (this.j != 0) goto L29;
        r5 = true;
    L30:
        if (r5 == false) goto L39;
        DiscreteScrollView.d r10 = (DiscreteScrollView.d) this.z;
        if (DiscreteScrollView.access$700(r10.a).isEmpty() == true) goto L34;
    L36:
        int r11 = DiscreteScrollView.access$500(r10.a).k;
        RecyclerView.ViewHolder r12 = r10.a.getViewHolder(r11);
        if (r12 == null) goto L54;
        DiscreteScrollView.access$800(r10.a, r12, r11);
        DiscreteScrollView.access$900(r10.a, r12, r11);
    L54:
        this.h = r9;
        return;
    L34:
        if (DiscreteScrollView.access$400(r10.a).isEmpty() == false) goto L36;
    L39:
        return;
    L29:
        u();
        goto L30
    L25:
        this.j = -this.i;
        goto L27
    L22:
        r8 = false;
        goto L23
    L40:
        if (r9 != 1) goto L54;
        int r13 = Math.abs(this.i);
        int r14 = this.g;
        if (r13 <= r14) goto L44;
        boolean r15 = true;
    L45:
        if (r15 == false) goto L48;
        int r16 = this.i;
        int r17 = r16 / r14;
        this.k += r17;
        this.i = r16 - (r17 * r14);
    L48:
        if (Math.abs(this.i) < (this.g * 0.6f)) goto L50;
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
        this.k += Direction.fromDelta(this.i).applyTo(1);
        this.i = -Direction.fromDelta(this.i).applyTo(this.g - Math.abs(this.i));
    L53:
        this.l = -1;
        this.j = 0;
        goto L54
    L50:
        r18 = false;
        goto L51
    L44:
        r15 = false;
        goto L45
    }

    public final void q(RecyclerView.Recycler r11) {
        this.m.clear();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.B.a()) goto L6;
        View r2 = this.B.a.getChildAt(r1);
        this.m.put(this.B.a.getPosition(r2), r2);
        r1 = r1 + 1;
        goto L4
    L6:
        int r3 = 0;
    L8:
        if (r3 >= this.m.size()) goto L10;
        com.ss.android.lark.discretescrollview.a r4 = this.B;
        View r5 = this.m.valueAt(r3);
        r4.a.detachView(r5);
        r3 = r3 + 1;
        goto L8
    L10:
        this.n.j(this.b, this.i, this.c);
        int r6 = this.n.a(this.B.a.getWidth(), this.B.a.getHeight());
        Point r7 = this.c;
        if (this.n.g(r7, this.d, this.e, r6, this.f) == false) goto L13;
        r(r11, this.k, this.c);
    L13:
        s(r11, Direction.START, r6);
        s(r11, Direction.END, r6);
    L15:
        if (r0 >= this.m.size()) goto L17;
        View r8 = this.m.valueAt(r0);
        this.B.getClass();
        r11.recycleView(r8);
        r0 = r0 + 1;
        goto L15
    L17:
        this.m.clear();
    }

    public final void scrollToPosition(int r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        this.k = r2;
        this.B.a.requestLayout();
    }

    public final void v(int r4) {
        int r0 = this.k;
        if (r0 != r4) goto L5;
        return;
    L5:
        this.j = -this.i;
        this.j += Direction.fromDelta(r4 - r0).applyTo(Math.abs(r4 - this.k) * this.g);
        this.l = r4;
        u();
    }

    public final void onAdapterChanged(RecyclerView.Adapter r2, RecyclerView.Adapter r3) {
        this.l = -1;
        this.j = 0;
        this.i = 0;
        if ((r3 instanceof b) == false) goto L5;
        this.k = ((b) r3).g0();
    L6:
        this.B.a.removeAllViews();
        return;
    L5:
        this.k = 0;
        goto L6
    }

    public final void onLayoutChildren(RecyclerView.Recycler r6, RecyclerView.State r7) {
        if (r7.getItemCount() != 0) goto L6;
        this.B.a.removeAndRecycleAllViews(r6);
        this.l = -1;
        this.k = -1;
        this.j = 0;
        this.i = 0;
        return;
    L6:
        int r0 = this.k;
        if (r0 != (-1)) goto L9;
    L10:
        this.k = 0;
    L11:
        boolean r3 = true;
        if (this.B.a.getWidth() == this.w) goto L14;
        boolean r1 = true;
    L16:
        if (this.B.a.getHeight() == this.x) goto L18;
        boolean r2 = true;
    L20:
        if (r7.isMeasuring() == true) goto L24;
        if (r1 == true) goto L23;
        if (r2 == false) goto L24;
    L23:
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
        this.w = this.B.a.getWidth();
        this.x = this.B.a.getHeight();
        this.B.a.removeAllViews();
    L27:
        this.b.set(this.B.a.getWidth() / 2, this.B.a.getHeight() / 2);
        if (this.o == false) goto L30;
    L36:
        this.B.a.detachAndScrapAttachedViews(r6);
        q(r6);
        p();
        return;
    L30:
        if (this.B.a() == 0) goto L33;
        r3 = false;
    L33:
        this.o = r3;
        if (r3 == false) goto L36;
        com.ss.android.lark.discretescrollview.a r9 = this.B;
        r9.getClass();
        View r4 = r6.getViewForPosition(0);
        r9.a.addView(r4);
        r9.a.measureChildWithMargins(r4, 0, 0);
        com.ss.android.lark.discretescrollview.a r10 = this.B;
        r10.getClass();
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        int r11 = (r10.a.getDecoratedMeasuredWidth(r4) + r5.leftMargin) + r5.rightMargin;
        com.ss.android.lark.discretescrollview.a r12 = this.B;
        r12.getClass();
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        int r14 = (r12.a.getDecoratedMeasuredHeight(r4) + r13.topMargin) + r13.bottomMargin;
        this.d = r11 / 2;
        this.e = r14 / 2;
        int r15 = this.n.k(r11, r14);
        this.g = r15;
        this.f = r15 * this.r;
        this.B.a.detachAndScrapView(r4, r6);
    L24:
        r8 = false;
        goto L25
    L18:
        r2 = false;
        goto L20
    L14:
        r1 = false;
        goto L16
    L9:
        if (r0 < r7.getItemCount()) goto L11;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int t(int r11, RecyclerView.Recycler r12) {
        if (this.B.a() != 0) goto L5;
        return 0;
    L5:
        Direction r0 = Direction.fromDelta(r11);
        int r2 = this.j;
        if (r2 == 0) goto L9;
        int r3 = Math.abs(r2);
    L50:
        if (r3 > 0) goto L52;
        return 0;
    L52:
        int r13 = r0.applyTo(Math.min(r3, Math.abs(r11)));
        this.i += r13;
        int r1 = this.j;
        if (r1 == 0) goto L55;
        this.j = r1 - r13;
    L55:
        this.n.f(-r13, this.B);
        if (this.n.m(this) == false) goto L59;
        q(r12);
    L59:
        if (this.l == (-1)) goto L61;
        int r14 = Math.abs(this.i + this.j);
    L62:
        float r5 = -Math.min(Math.max(-1.0f, this.i / r14), 1.0f);
        DiscreteScrollView.d r15 = (DiscreteScrollView.d) this.z;
        if (DiscreteScrollView.access$400(r15.a).isEmpty() == true) goto L75;
        int r6 = r15.a.getCurrentItem();
        DiscreteScrollLayoutManager r4 = DiscreteScrollView.access$500(r15.a);
        int r7 = r4.i;
        if (r7 != 0) goto L68;
        int r8 = r4.k;
    L72:
        int r9 = r8;
    L73:
        if (r6 == r9) goto L75;
        DiscreteScrollView r10 = r15.a;
        DiscreteScrollView.access$1000(r10, r5, r6, r9, r10.getViewHolder(r6), r15.a.getViewHolder(r9));
        goto L75
    L68:
        int r16 = r4.l;
        if (r16 == (-1)) goto L71;
        r9 = r16;
        goto L73
    L71:
        r8 = r4.k + Direction.fromDelta(r7).applyTo(1);
    L75:
        p();
        return r13;
    L61:
        r14 = this.g;
        goto L62
    L9:
        if (this.h != 1) goto L14;
        if (this.y.isScrollBlocked(r0) == false) goto L14;
        r3 = r0.reverse().applyTo(this.i);
    L14:
        if (r0.applyTo(this.i) <= 0) goto L16;
        boolean r17 = true;
    L18:
        if (r0 != Direction.START) goto L29;
        if (this.k != 0) goto L29;
        int r18 = this.i;
        if (r18 != 0) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == true) goto L37;
        r3 = Math.abs(r18);
    L43:
        DiscreteScrollView.d r20 = (DiscreteScrollView.d) this.z;
        if (DiscreteScrollView.access$200(r20.a) == false) goto L50;
        RecyclerView r21 = r20.a;
        if (r19 == false) goto L48;
        int r22 = 0;
    L49:
        r21.setOverScrollMode(r22);
        goto L50
    L48:
        r22 = 2;
    L37:
        r3 = 0;
        goto L43
    L24:
        r19 = false;
    L29:
        if (r0 == Direction.END) goto L31;
    L39:
        if (r17 == false) goto L41;
        r3 = this.g - Math.abs(this.i);
    L42:
        r19 = false;
        goto L43
    L41:
        r3 = this.g + Math.abs(this.i);
        goto L42
    L31:
        if (this.k != (this.B.b() - 1)) goto L39;
        int r23 = this.i;
        if (r23 != 0) goto L35;
        r19 = true;
    L36:
        if (r19 == true) goto L37;
        r3 = Math.abs(r23);
        goto L43
    L35:
        r19 = false;
        goto L36
    L16:
        r17 = false;
        goto L18
    }

    public DiscreteScrollLayoutManager(Context r2, DiscreteScrollView.d r3, DSVOrientation r4) {
        this.y = DSVScrollConfig.ENABLED;
        this.p = r2;
        this.q = 300;
        this.l = -1;
        this.k = -1;
        this.u = 2100;
        this.v = false;
        this.b = new Point();
        this.c = new Point();
        this.a = new Point();
        this.m = new SparseArray();
        this.z = r3;
        this.n = r4.createHelper();
        this.B = new com.ss.android.lark.discretescrollview.a(this);
        this.s = 1;
    }

    public final void onItemsAdded(RecyclerView r2, int r3, int r4) {
        int r5 = this.k;
        if (r5 != (-1)) goto L5;
        r5 = 0;
    L8:
        if (this.k == r5) goto L11;
        this.k = r5;
        this.t = true;
        return;
    L11:
        return;
    L5:
        if (r5 < r3) goto L8;
        r5 = Math.min(r5 + r4, this.B.b() - 1);
        goto L8
    }

    public final void onItemsRemoved(RecyclerView r3, int r4, int r5) {
        int r6 = this.k;
        if (this.B.b() != 0) goto L5;
        r6 = -1;
    L12:
        if (this.k == r6) goto L15;
        this.k = r6;
        this.t = true;
        return;
    L15:
        return;
    L5:
        int r0 = this.k;
        if (r0 < r4) goto L12;
        if (r0 >= (r4 + r5)) goto L10;
        this.k = -1;
    L10:
        r6 = Math.max(0, this.k - r5);
        goto L12
    }

    public final void r(RecyclerView.Recycler r8, int r9, Point r10) {
        if (r9 >= 0) goto L4;
        return;
    L4:
        View r0 = this.m.get(r9);
        if (r0 != null) goto L7;
        com.ss.android.lark.discretescrollview.a r1 = this.B;
        r1.getClass();
        View r2 = r8.getViewForPosition(r9);
        r1.a.addView(r2);
        r1.a.measureChildWithMargins(r2, 0, 0);
        com.ss.android.lark.discretescrollview.a r11 = this.B;
        int r12 = r10.x;
        int r3 = this.d;
        int r13 = r10.y;
        int r4 = this.e;
        int r6 = r13 + r4;
        RecyclerView.LayoutManager r5 = r11.a;
        r5.layoutDecoratedWithMargins(r2, r12 - r3, r13 - r4, r12 + r3, r6);
        return;
    L7:
        this.B.a.attachView(r0);
        this.m.remove(r9);
    }

    public final void s(RecyclerView.Recycler r17, Direction r18, int r19) {
        int r3 = r18.applyTo(1);
        int r4 = this.l;
        if (r4 != (-1)) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Point r6 = this.a;
        Point r7 = this.c;
        r6.set(r7.x, r7.y);
        int r8 = this.k;
    L10:
        r8 = r8 + r3;
        if (r8 >= 0) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L25;
        if (r8 != this.l) goto L20;
        r5 = true;
    L20:
        this.n.b(r18, this.g, this.a);
        Point r11 = this.a;
        if (this.n.g(r11, this.d, this.e, r19, this.f) == true) goto L22;
        if (r5 == false) goto L10;
        return;
    L22:
        r(r17, r8, this.a);
        goto L10
    L25:
        return;
    L13:
        if (r8 >= this.B.b()) goto L15;
        r9 = true;
        goto L16
    L5:
        if (r18.sameAs(r4 - this.k) == false) goto L8;
        r5 = false;
        goto L9
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return t(r1, r2);
    }

    public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return t(r1, r2);
    }

    public final void smoothScrollToPosition(RecyclerView r4, RecyclerView.State r5, int r6) {
        if (this.k != r6) goto L5;
        return;
    L5:
        if (this.l != (-1)) goto L19;
        if (r6 < 0) goto L16;
        if (r6 >= r5.getItemCount()) goto L16;
        if (this.k != (-1)) goto L13;
        this.k = r6;
        return;
    L13:
        v(r6);
        return;
    L16:
        throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[]{Integer.valueOf(r6), Integer.valueOf(r5.getItemCount())}));
    }
}
