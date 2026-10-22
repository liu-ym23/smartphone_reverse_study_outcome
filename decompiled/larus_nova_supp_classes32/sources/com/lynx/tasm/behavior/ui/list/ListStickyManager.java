package com.lynx.tasm.behavior.ui.list;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.g;
import com.lynx.tasm.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ListStickyManager extends RecyclerView.OnScrollListener implements View.OnAttachStateChangeListener {
    public final UIList a;
    public final b b;
    public int c;
    public int d;
    public int e;
    public final c f;
    public final c g;
    public boolean h;

    public class a implements Runnable {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ ListStickyManager b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.q(this.a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ListStickyManager r1, RecyclerView r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b extends FrameLayout {
        public final /* synthetic */ ListStickyManager a;

        public b(ListStickyManager r1, LynxContext r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.view.ViewGroup
        public final void measureChildWithMargins(View r2, int r3, int r4, int r5, int r6) {
            if ((r2 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L6;
            r2.measure(r2.getMeasuredWidth(), r2.getMeasuredHeight());
            return;
        L6:
            super.measureChildWithMargins(r2, r3, r4, r5, r6);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);     // Catch: NullPointerException -> L4
        L6:
            this.a.n();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }
    }

    public static class c {
        public UIComponent a;
        public int b;

        public c() {
            this.a = null;
            this.b = -1;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n() {
        int r1 = 0;
        if (this.f.b == (-1)) goto L49;
        RecyclerView r0 = (RecyclerView) this.a.getView();
        if (r0 == null) goto L49;
        if (r0.getChildCount() <= 1) goto L49;
        View r3 = r0.getChildAt(0);
        View r5 = r0.getChildAt(r0.getChildCount() - 1);
        if (r3 == null) goto L49;
        if (r5 == null) goto L49;
        RecyclerView.ViewHolder r4 = r0.getChildViewHolder(r3);
        RecyclerView.ViewHolder r2 = r0.getChildViewHolder(r5);
        if (r4 == null) goto L49;
        if (r2 == null) goto L49;
        int r6 = r4.getAdapterPosition();
        int r7 = r2.getAdapterPosition();
        if (r6 < 0) goto L49;
        if (r7 < 0) goto L49;
        UIListAdapter r8 = this.a.c;
        int r9 = this.f.b + 1;
        if (r8.j == null) goto L31;
        int r10 = 0;
    L26:
        if (r10 >= r8.j.size()) goto L31;
        int r11 = r8.j.getInt(r10);
        if (r11 >= r9) goto L32;
        r10 = r10 + 1;
    L32:
        if (r11 < r6) goto L49;
        if (r11 > r7) goto L49;
        if (r11 == (-1)) goto L49;
        if (this.h == false) goto L40;
    L42:
        ListViewHolder r12 = (ListViewHolder) this.a.V().findViewHolderForAdapterPosition(r11);
        if (r12 == null) goto L45;
        int r13 = Math.min(0, ((RecyclerView.ViewHolder) r12).itemView.getTop() - ((com.lynx.tasm.behavior.ui.view.a) this.f.a.getView()).getBottom());
    L46:
        ((com.lynx.tasm.behavior.ui.view.a) this.f.a.getView()).setTranslationY(r13);
        if ((((com.lynx.tasm.behavior.ui.view.a) this.f.a.getView()).getBottom() + r13) >= 0) goto L49;
        j(this.f);
        goto L49
    L45:
        r13 = 0;
        goto L46
    L40:
        if (this.a.c.j.contains(Integer.valueOf(r11)) == true) goto L42;
    L31:
        r11 = -1;
    L49:
        int r14 = this.g.b;
        if (r14 == (-1)) goto L70;
        int r15 = this.a.c.B2(r14 - 1);
        if (r15 != (-1)) goto L56;
        return;
    L56:
        if (this.h == false) goto L58;
    L60:
        RecyclerView r16 = this.a.V();
        ListViewHolder r17 = (ListViewHolder) r16.findViewHolderForAdapterPosition(r15);
        if (r17 == null) goto L63;
        r1 = Math.max(0, ((RecyclerView.ViewHolder) r17).itemView.getBottom() - ((com.lynx.tasm.behavior.ui.view.a) this.g.a.getView()).getTop());
    L63:
        ((com.lynx.tasm.behavior.ui.view.a) this.g.a.getView()).setTranslationY(r1);
        if ((((com.lynx.tasm.behavior.ui.view.a) this.g.a.getView()).getTop() + r1) <= r16.getHeight()) goto L69;
        j(this.g);
        return;
    L69:
        return;
    L58:
        if (this.a.c.k.contains(Integer.valueOf(r15)) == true) goto L60;
        return;
    }

    public ListStickyManager(UIList r3) {
        this.d = 0;
        this.h = true;
        this.a = r3;
        this.b = new b(this, r3.getLynxContext());
        this.c = -1;
        this.e = -1;
        this.f = new c();
        this.g = new c();
        r3.V().addOnScrollListener(this);
        r3.V().addOnAttachStateChangeListener(this);
    }

    public static void o(View r2) {
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r0).removeView(r2);
    L5:
        ViewGroup r1 = (ViewGroup) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    public final void j(c r3) {
        int r0 = UIList.L0;
        if (r3 == null) goto L10;
        UIComponent r1 = r3.a;
        if (r1 == null) goto L10;
        if (r1.getView() == 0) goto L10;
        ((com.lynx.tasm.behavior.ui.view.a) r3.a.getView()).setTranslationY(0.0f);
    L10:
        ListViewHolder r2 = (ListViewHolder) this.a.V().findViewHolderForAdapterPosition(r3.b);
        o(r3.a.getView());
        if (r2 == null) goto L13;
        r2.U3(r3.a);
        r3.b = -1;
        r3.a = null;
        return;
    L13:
        UIList r4 = this.a;
        if (r4.c.d == false) goto L16;
        r4.N(r3.a);
        return;
    L16:
        UIComponent r5 = r3.a;
        g r6 = r4.a;
        l r7 = (l) r6;
        r7.g(r4.getSign(), r5.getSign());
    }

    public final void k(c r10) {
        int r0 = r10.b;
        if (r0 == (-1)) goto L16;
        UIListAdapter r1 = this.a.c;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r0 >= r1.getItemCount()) goto L18;
        UIList r2 = this.a;
        UIListAdapter r3 = r2.c;
        if (r3.d == true) goto L11;
        UIComponent r4 = r10.a;
        int r6 = r10.b;
        long r7 = r3.z2();
        g r11 = r2.a;
        l r5 = (l) r11;
        r5.i(r2.getSign(), r4.getSign(), r6, r7);
        return;
    L11:
        if (r2.W() == false) goto L13;
        UIList r8 = this.a;
        int r12 = r10.b;
        long r9 = r8.c.z2();
        g r13 = r8.a;
        l r14 = (l) r13;
        r14.d(r8.getSign(), r12, r9);
        return;
    L13:
        UIList r15 = this.a;
        r15.M(r10.b, r15.c.z2(), this.a.c.x);
        return;
    L18:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r6) {
        if (this.b.indexOfChild(r6) < 0) goto L5;
        return;
    L5:
        b r0 = this.b;
        r0.getClass();
        ViewGroup r1 = (ViewGroup) r6.getParent();
        if (r1 != null) goto L8;
        LLog.e("ListStickyManager", "addRecyclerView failed, parent is null.");
        return;
    L8:
        int r2 = r1.indexOfChild(r6);
        r1.removeViewAt(r2);
        r0.addView(r6, new FrameLayout.LayoutParams(-1, -1));
        r1.addView(r0, r2);
    }

    public final void q(RecyclerView r10, int r11) {
        if (r11 <= 0) goto L11;
        c r12 = this.g;
        if (r12.b == (-1)) goto L19;
        ListViewHolder r3 = (ListViewHolder) this.a.V().findViewHolderForAdapterPosition(r12.b);
        if (r3 == null) goto L19;
        p(r12, r3, false, false);
    L19:
        int r13 = 0;
        int r4 = -1;
        int r5 = -1;
    L21:
        if (r13 >= r10.getChildCount()) goto L33;
        View r6 = r10.getChildAt(r13);
        if (r6.getTop() > this.d) goto L28;
        if (r6.getBottom() <= this.d) goto L28;
        r4 = ((ListViewHolder) r10.getChildViewHolder(r6)).getAdapterPosition();
    L28:
        if (r6.getTop() >= (r10.getHeight() - this.d)) goto L32;
        if (r6.getBottom() < (r10.getHeight() - this.d)) goto L32;
        r5 = ((ListViewHolder) r10.getChildViewHolder(r6)).getAdapterPosition();
    L32:
        r13 = r13 + 1;
        goto L21
    L33:
        UIListAdapter r14 = this.a.c;
        if (r14 != null) goto L37;
    L68:
        m(this.f, this.c, true);
        m(this.g, this.e, false);
        n();
        return;
    L37:
        if (this.h == false) goto L39;
        int r15 = r14.B2(r4);
    L41:
        if (this.h == false) goto L43;
        int r7 = r14.A2(r5);
    L45:
        if (r14.j.contains(Integer.valueOf(r15)) == true) goto L47;
        this.c = -1;
    L51:
        if (r14.k.contains(Integer.valueOf(r7)) == true) goto L53;
        this.e = -1;
    L56:
        c r16 = this.f;
        int r17 = r16.b;
        if (r17 == (-1)) goto L62;
        int r8 = this.c;
        if (r8 == (-1)) goto L62;
        if (r17 == r8) goto L62;
        j(r16);
    L62:
        c r18 = this.g;
        int r19 = r18.b;
        if (r19 == (-1)) goto L68;
        int r9 = this.e;
        if (r9 == (-1)) goto L68;
        if (r19 == r9) goto L68;
        j(r18);
        goto L68
    L53:
        if (this.e == r7) goto L56;
        this.e = r7;
        int r110 = UIList.L0;
        goto L56
    L47:
        if (this.c == r15) goto L51;
        this.c = r15;
        int r111 = UIList.L0;
        goto L51
    L43:
        r7 = r14.C2(r5);
        goto L45
    L39:
        r15 = r14.D2(r4);
        goto L41
    L11:
        if (r11 >= 0) goto L19;
        c r112 = this.f;
        if (r112.b == (-1)) goto L19;
        ListViewHolder r20 = (ListViewHolder) this.a.V().findViewHolderForAdapterPosition(r112.b);
        if (r20 == null) goto L19;
        p(r112, r20, true, false);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View] */
    public final void l(c r4, boolean r5, boolean r6) {
        if (r4.b != (-1)) goto L5;
        return;
    L5:
        ListViewHolder r0 = (ListViewHolder) this.a.V().findViewHolderForAdapterPosition(r4.b);
        if (r0 != null) goto L9;
        o(r4.a.getView());
        r4.b = -1;
        r4.a = null;
        return;
    L9:
        p(r4, r0, r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View] */
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
    public final void m(c r8, int r9, boolean r10) {
        if (r9 != (-1)) goto L5;
        return;
    L5:
        if (r9 == r8.b) goto L47;
        RecyclerView r0 = this.a.V();
        ListViewHolder r1 = (ListViewHolder) r0.findViewHolderForAdapterPosition(r9);
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L13;
        r1 = (ListViewHolder) r0.getAdapter().createViewHolder(r0, r0.getAdapter().getItemViewType(r9));
        UIListAdapter r4 = this.a.c;
        if (r4.d == false) goto L12;
        r4.y2(r1, r9);
    L27:
        if (r2 == false) goto L45;
        UIComponent r5 = r1.a.b;
        if (r5 == null) goto L46;
        r1.T3();
        if (r10 == false) goto L33;
        int r6 = 48;
    L34:
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2, r6);
        if (r10 == false) goto L37;
        int r11 = this.d;
    L38:
        r7.topMargin = r11;
        if (r10 == true) goto L42;
        r3 = this.d;
    L42:
        r7.bottomMargin = r3;
        o(r5.getView());
        this.b.addView(r5.getView(), r7);
        r8.a = r5;
        r8.b = r9;
        int r12 = UIList.L0;
        return;
    L37:
        r11 = 0;
        goto L38
    L33:
        r6 = 80;
        goto L34
    L46:
        return;
    L45:
        return;
    L12:
        r4.bindViewHolder(r1, r9);
        goto L27
    L13:
        if (r10 == true) goto L15;
    L17:
        boolean r13 = false;
    L18:
        if (r10 == false) goto L20;
    L22:
        boolean r14 = false;
    L23:
        if (r13 == true) goto L27;
        if (r14 == true) goto L27;
        r2 = false;
        goto L27
    L20:
        if (r1.a.getBottom() <= (this.b.getHeight() - this.d)) goto L22;
        r14 = true;
        goto L23
    L15:
        if (r1.a.getTop() >= this.d) goto L17;
        r13 = true;
        goto L18
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        if (r3 != 0) goto L4;
        r1.post(new a(this, r1));
        return;
    L4:
        q(r1, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v7, types: [android.view.View] */
    public final void p(c r5, ListViewHolder r6, boolean r7, boolean r8) {
        if (r5.b != (-1)) goto L5;
        return;
    L5:
        int r0 = r6.a.getTop();
        ?? r2 = r5.a.getView();
        if (r2 != 0) goto L8;
        return;
    L8:
        if (r7 == true) goto L10;
    L11:
        if (r7 == false) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == true) goto L18;
        if (r8 == true) goto L18;
        return;
    L18:
        int r10 = UIList.L0;
        UIComponent r11 = r5.a;
        if (r11 != null) goto L21;
    L24:
        o(r5.a.getView());
        UIComponent r12 = r6.a.b;
        if (r12 == null) goto L30;
        UIList r13 = this.a;
        if (r13.c.d == false) goto L29;
        r13.N(r12);
    L29:
        r6.T3();
    L30:
        r6.U3(r5.a);
        r5.b = -1;
        r5.a = null;
        return;
    L21:
        if (r11.getView() == 0) goto L24;
        ((com.lynx.tasm.behavior.ui.view.a) r5.a.getView()).setTranslationY(0.0f);
        goto L24
    L13:
        if (r0 >= r2.getTop()) goto L15;
    L14:
        r9 = true;
        goto L16
    L10:
        if (r0 > r2.getTop()) goto L14;
        goto L11
    }
}
