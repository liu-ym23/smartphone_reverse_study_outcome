package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.p;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l extends h.d implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f883b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k0 f890s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f891t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f892u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PopupWindow.OnDismissListener f893v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f894w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f895x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j.a f896y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewTreeObserver f897z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f898a;

        public a(l r8) {
            this.f898a = r8;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            l r8 = this.f898a;
            if (r8.isShowing() == true) goto L5;
            return;
        L5:
            if (r8.f890s.I == true) goto L15;
            View r10 = r8.f895x;
            if (r10 != null) goto L9;
        L12:
            r8.dismiss();
            return;
        L9:
            if (r10.isShown() == false) goto L12;
            r8.f890s.show();
            return;
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f899a;

        public b(l r8) {
            this.f899a = r8;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
            l r10 = this.f899a;
            ViewTreeObserver r11 = r10.f897z;
            if (r11 != null) goto L5;
        L8:
            r8.removeOnAttachStateChangeListener(this);
            return;
        L5:
            if (r11.isAlive() == true) goto L7;
            r10.f897z = r8.getViewTreeObserver();
        L7:
            r10.f897z.removeGlobalOnLayoutListener(r10.f891t);
            goto L8
        }
    }

    public l(int r8, int r10, Context r11, View r12, f r13, boolean r14) {
        this.f891t = new a(this);
        this.f892u = new b(this);
        this.D = 0;
        this.f883b = r11;
        this.f884m = r13;
        this.f886o = r14;
        this.f885n = new e(r13, LayoutInflater.from(r11), r14, R.layout.abc_popup_menu_item_layout);
        this.f888q = r8;
        this.f889r = r10;
        Resources r15 = r11.getResources();
        this.f887p = Math.max(r15.getDisplayMetrics().widthPixels / 2, r15.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f894w = r12;
        this.f890s = new k0(r11, r8, r10);
        r13.c(this, r11);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f r8, boolean r10) {
        if (r8 == this.f884m) goto L5;
        return;
    L5:
        dismiss();
        j.a r11 = this.f896y;
        if (r11 == null) goto L9;
        r11.a(r8, r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b(j.a r8) {
        this.f896y = r8;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d() {
        this.B = false;
        e r8 = this.f885n;
        if (r8 == null) goto L6;
        r8.notifyDataSetChanged();
        return;
    }

    @Override // h.f
    public final void dismiss() {
        if (isShowing() == false) goto L6;
        this.f890s.dismiss();
        return;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean e(m r10) {
        if (r10.hasVisibleItems() == false) goto L23;
        i r8 = new i(this.f888q, this.f889r, this.f883b, this.f895x, r10, this.f886o);
        r8.e(this.f896y);
        boolean r11 = h.d.s(r10);
        r8.f877h = r11;
        h.d r12 = r8.f879j;
        if (r12 == null) goto L7;
        r12.m(r11);
    L7:
        r8.f880k = this.f893v;
        this.f893v = null;
        this.f884m.d(false);
        k0 r13 = this.f890s;
        int r14 = r13.f1175p;
        int r15 = r13.getVerticalOffset();
        int r16 = this.D;
        View r17 = this.f894w;
        WeakHashMap<View, h0> r18 = w.f8437a;
        if ((Gravity.getAbsoluteGravity(r16, w.e.d(r17)) & 7) != 5) goto L11;
        r14 = r14 + this.f894w.getWidth();
    L11:
        if (r8.c() == false) goto L14;
    L17:
        boolean r19 = true;
    L18:
        if (r19 == false) goto L23;
        j.a r20 = this.f896y;
        if (r20 == null) goto L22;
        r20.b(r10);
    L22:
        return true;
    L14:
        if (r8.f875f != null) goto L16;
        r19 = false;
        goto L18
    L16:
        r8.f(r14, r15, true, true);
    L23:
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean g() {
        return false;
    }

    @Override // h.f
    public final e0 getListView() {
        return this.f890s.f1172m;
    }

    @Override // h.d
    public final void i(f r8) {
    }

    @Override // h.f
    public final boolean isShowing() {
        if (this.A == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f890s.isShowing() == false) goto L7;
        return true;
    }

    @Override // h.d
    public final void k(View r8) {
        this.f894w = r8;
    }

    @Override // h.d
    public final void m(boolean r8) {
        this.f885n.f810m = r8;
    }

    @Override // h.d
    public final void n(int r8) {
        this.D = r8;
    }

    @Override // h.d
    public final void o(int r8) {
        this.f890s.f1175p = r8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.A = true;
        this.f884m.d(true);
        ViewTreeObserver r8 = this.f897z;
        if (r8 != null) goto L5;
    L8:
        this.f895x.removeOnAttachStateChangeListener(this.f892u);
        PopupWindow.OnDismissListener r10 = this.f893v;
        if (r10 == null) goto L12;
        r10.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r8.isAlive() == true) goto L7;
        this.f897z = this.f895x.getViewTreeObserver();
    L7:
        this.f897z.removeGlobalOnLayoutListener(this.f891t);
        this.f897z = null;
        goto L8
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r8, int r10, KeyEvent r11) {
        if (r11.getAction() == 1) goto L5;
        return false;
    L5:
        if (r10 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    @Override // h.d
    public final void p(PopupWindow.OnDismissListener r8) {
        this.f893v = r8;
    }

    @Override // h.d
    public final void q(boolean r8) {
        this.E = r8;
    }

    @Override // h.d
    public final void r(int r8) {
        this.f890s.setVerticalOffset(r8);
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
    @Override // h.f
    public final void show() {
        boolean r8 = true;
        if (isShowing() == false) goto L6;
    L34:
        if (r8 == false) goto L37;
        return;
    L37:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    L6:
        if (this.A == true) goto L33;
        View r10 = this.f894w;
        if (r10 == null) goto L33;
        this.f895x = r10;
        k0 r11 = this.f890s;
        r11.J.setOnDismissListener(this);
        r11.f1185z = this;
        r11.I = true;
        p r12 = r11.J;
        r12.setFocusable(true);
        View r13 = this.f895x;
        if (this.f897z != null) goto L13;
        boolean r14 = true;
    L14:
        ViewTreeObserver r15 = r13.getViewTreeObserver();
        this.f897z = r15;
        if (r14 == false) goto L17;
        r15.addOnGlobalLayoutListener(this.f891t);
    L17:
        r13.addOnAttachStateChangeListener(this.f892u);
        r11.f1184y = r13;
        r11.f1181v = this.D;
        boolean r16 = this.B;
        Context r17 = this.f883b;
        e r18 = this.f885n;
        if (r16 == true) goto L20;
        this.C = h.d.j(r18, r17, this.f887p);
        this.B = true;
    L20:
        r11.i(this.C);
        r12.setInputMethodMode(2);
        Rect r19 = this.f7861a;
        if (r19 == null) goto L23;
        Rect r20 = new Rect(r19);
    L24:
        r11.H = r20;
        r11.show();
        e0 r21 = r11.f1172m;
        r21.setOnKeyListener(this);
        if (this.E == false) goto L32;
        f r22 = this.f884m;
        if (r22.f827m == null) goto L32;
        FrameLayout r23 = (FrameLayout) LayoutInflater.from(r17).inflate(R.layout.abc_popup_menu_header_item_layout, r21, false);
        TextView r24 = (TextView) r23.findViewById(android.R.id.title);
        if (r24 == null) goto L31;
        r24.setText(r22.f827m);
    L31:
        r23.setEnabled(false);
        r21.addHeaderView(r23, null, false);
    L32:
        r11.setAdapter(r18);
        r11.show();
        goto L34
    L23:
        r20 = null;
        goto L24
    L13:
        r14 = false;
    L33:
        r8 = false;
        goto L34
    }
}
