package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.p;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b extends h.d implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public j.a H;
    public ViewTreeObserver I;
    public PopupWindow.OnDismissListener J;
    public boolean K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f775b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f778o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f779p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f780q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f781r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f782s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f783t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0005b f784u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f785v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f786w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f787x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f788y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f789z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f790a;

        public a(b r8) {
            this.f790a = r8;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b r8 = this.f790a;
            if (r8.isShowing() == false) goto L20;
            ArrayList r10 = r8.f782s;
            if (r10.size() > 0) goto L7;
            return;
        L7:
            if (((d) r10.get(0)).f793a.I == true) goto L22;
            View r11 = r8.f789z;
            if (r11 != null) goto L11;
        L17:
            r8.dismiss();
            return;
        L11:
            if (r11.isShown() == false) goto L17;
            Iterator r12 = r10.iterator();
        L15:
            if (r12.hasNext() == false) goto L23;
            ((d) r12.next()).f793a.show();
            goto L15
        L23:
            return;
        L22:
            return;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0005b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f791a;

        public ViewOnAttachStateChangeListenerC0005b(b r8) {
            this.f791a = r8;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
            b r10 = this.f791a;
            ViewTreeObserver r11 = r10.I;
            if (r11 != null) goto L5;
        L8:
            r8.removeOnAttachStateChangeListener(this);
            return;
        L5:
            if (r11.isAlive() == true) goto L7;
            r10.I = r8.getViewTreeObserver();
        L7:
            r10.I.removeGlobalOnLayoutListener(r10.f783t);
            goto L8
        }
    }

    public class c implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f792a;

        public c(b r8) {
            this.f792a = r8;
        }

        @Override // androidx.appcompat.widget.j0
        public final void a(f r8, h r10) {
            b r11 = this.f792a;
            d r12 = null;
            r11.f780q.removeCallbacksAndMessages(null);
            ArrayList r13 = r11.f782s;
            int r14 = r13.size();
            int r15 = 0;
        L4:
            if (r15 >= r14) goto L9;
            if (r8 == ((d) r13.get(r15)).f794b) goto L10;
            r15 = r15 + 1;
        L10:
            if (r15 != (-1)) goto L12;
            return;
        L12:
            int r16 = r15 + 1;
            if (r16 >= r13.size()) goto L15;
            r12 = (d) r13.get(r16);
        L15:
            r11.f780q.postAtTime(new androidx.appcompat.view.menu.c(this, r12, r10, r8), r8, SystemClock.uptimeMillis() + 200);
            return;
        L9:
            r15 = -1;
            goto L10
        }

        @Override // androidx.appcompat.widget.j0
        public final void c(f r8, MenuItem r10) {
            this.f792a.f780q.removeCallbacksAndMessages(r8);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f795c;

        public d(k0 r8, f r10, int r11) {
            this.f793a = r8;
            this.f794b = r10;
            this.f795c = r11;
        }
    }

    public b(Context r8, View r10, int r11, int r12, boolean r13) {
        this.f781r = new ArrayList();
        this.f782s = new ArrayList();
        this.f783t = new a(this);
        this.f784u = new ViewOnAttachStateChangeListenerC0005b(this);
        this.f785v = new c(this);
        int r14 = 0;
        this.f786w = 0;
        this.f787x = 0;
        this.f775b = r8;
        this.f788y = r10;
        this.f777n = r11;
        this.f778o = r12;
        this.f779p = r13;
        this.F = false;
        WeakHashMap<View, h0> r15 = w.f8437a;
        if (w.e.d(r10) == 1) goto L6;
        r14 = 1;
    L6:
        this.A = r14;
        Resources r16 = r8.getResources();
        this.f776m = Math.max(r16.getDisplayMetrics().widthPixels / 2, r16.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f780q = new Handler();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f r8, boolean r10) {
        ArrayList r11 = this.f782s;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r8 == ((d) r11.get(r13)).f794b) goto L9;
        r13 = r13 + 1;
    L9:
        if (r13 >= 0) goto L11;
        return;
    L11:
        int r14 = r13 + 1;
        if (r14 >= r11.size()) goto L14;
        ((d) r11.get(r14)).f794b.d(false);
    L14:
        d r15 = (d) r11.remove(r13);
        r15.f794b.t(this);
        boolean r16 = this.K;
        k0 r17 = r15.f793a;
        if (r16 == false) goto L17;
        k0.a.b(r17.J, null);
        r17.J.setAnimationStyle(0);
    L17:
        r17.dismiss();
        int r18 = r11.size();
        if (r18 <= 0) goto L20;
        int r19 = ((d) r11.get(r18 - 1)).f795c;
    L24:
        this.A = r19;
        if (r18 != 0) goto L36;
        dismiss();
        j.a r20 = this.H;
        if (r20 == null) goto L29;
        r20.a(r8, true);
    L29:
        ViewTreeObserver r21 = this.I;
        if (r21 != null) goto L32;
    L35:
        this.f789z.removeOnAttachStateChangeListener(this.f784u);
        this.J.onDismiss();
        return;
    L32:
        if (r21.isAlive() == false) goto L34;
        this.I.removeGlobalOnLayoutListener(this.f783t);
    L34:
        this.I = null;
        goto L35
    L36:
        if (r10 == false) goto L42;
        ((d) r11.get(0)).f794b.d(false);
        return;
    L42:
        return;
    L20:
        View r22 = this.f788y;
        WeakHashMap<View, h0> r23 = w.f8437a;
        if (w.e.d(r22) != 1) goto L23;
        r19 = 0;
        goto L24
    L23:
        r19 = 1;
        goto L24
    L8:
        r13 = -1;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b(j.a r8) {
        this.H = r8;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d() {
        Iterator r8 = this.f782s.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        ListAdapter r10 = ((d) r8.next()).f793a.f1172m.getAdapter();
        if ((r10 instanceof HeaderViewListAdapter) == false) goto L8;
        r10 = ((HeaderViewListAdapter) r10).getWrappedAdapter();
    L8:
        ((e) r10).notifyDataSetChanged();
        goto L4
    }

    @Override // h.f
    public final void dismiss() {
        ArrayList r8 = this.f782s;
        int r10 = r8.size();
        if (r10 <= 0) goto L10;
        d[] r11 = (d[]) r8.toArray(new d[r10]);
    L5:
        r10 = r10 - 1;
        if (r10 < 0) goto L16;
        d r12 = r11[r10];
        if (r12.f793a.isShowing() == false) goto L5;
        r12.f793a.dismiss();
        goto L5
    L16:
        return;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean e(m r8) {
        Iterator r10 = this.f782s.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        d r11 = (d) r10.next();
        if (r8 != r11.f794b) goto L4;
        r11.f793a.f1172m.requestFocus();
        return true;
    L10:
        if (r8.hasVisibleItems() == false) goto L15;
        i(r8);
        j.a r12 = this.H;
        if (r12 == null) goto L14;
        r12.b(r8);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean g() {
        return false;
    }

    @Override // h.f
    public final e0 getListView() {
        ArrayList r8 = this.f782s;
        if (r8.isEmpty() == false) goto L6;
        return null;
    L6:
        return ((d) r8.get(r8.size() - 1)).f793a.f1172m;
    }

    @Override // h.d
    public final void i(f r8) {
        r8.c(this, this.f775b);
        if (isShowing() == false) goto L5;
        t(r8);
        return;
    L5:
        this.f781r.add(r8);
    }

    @Override // h.f
    public final boolean isShowing() {
        ArrayList r8 = this.f782s;
        if (r8.size() > 0) goto L5;
        return false;
    L5:
        if (((d) r8.get(0)).f793a.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // h.d
    public final void k(View r8) {
        if (this.f788y == r8) goto L6;
        this.f788y = r8;
        int r10 = this.f786w;
        WeakHashMap<View, h0> r11 = w.f8437a;
        this.f787x = Gravity.getAbsoluteGravity(r10, w.e.d(r8));
        return;
    }

    @Override // h.d
    public final void m(boolean r8) {
        this.F = r8;
    }

    @Override // h.d
    public final void n(int r8) {
        if (this.f786w == r8) goto L6;
        this.f786w = r8;
        View r10 = this.f788y;
        WeakHashMap<View, h0> r11 = w.f8437a;
        this.f787x = Gravity.getAbsoluteGravity(r8, w.e.d(r10));
        return;
    }

    @Override // h.d
    public final void o(int r8) {
        this.B = true;
        this.D = r8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ArrayList r8 = this.f782s;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        d r12 = (d) r8.get(r11);
        if (r12.f793a.isShowing() == false) goto L9;
        r11 = r11 + 1;
    L9:
        if (r12 == null) goto L14;
        r12.f794b.d(false);
        return;
    L14:
        return;
    L8:
        r12 = null;
        goto L9
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
        this.J = r8;
    }

    @Override // h.d
    public final void q(boolean r8) {
        this.G = r8;
    }

    @Override // h.d
    public final void r(int r8) {
        this.C = true;
        this.E = r8;
    }

    @Override // h.f
    public final void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        ArrayList r8 = this.f781r;
        Iterator r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        t((f) r10.next());
        goto L7
    L9:
        r8.clear();
        View r11 = this.f788y;
        this.f789z = r11;
        if (r11 != null) goto L12;
        return;
    L12:
        if (this.I != null) goto L14;
        boolean r12 = true;
    L15:
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        this.I = r13;
        if (r12 == false) goto L18;
        r13.addOnGlobalLayoutListener(this.f783t);
    L18:
        this.f789z.addOnAttachStateChangeListener(this.f784u);
        return;
    L14:
        r12 = false;
        goto L15
    }

    public final void t(f r18) {
        Context r8 = this.f775b;
        LayoutInflater r10 = LayoutInflater.from(r8);
        e r11 = new e(r18, r10, this.f779p, R.layout.abc_cascading_menu_item_layout);
        if (isShowing() == true) goto L8;
        if (this.F == false) goto L8;
        r11.f810m = true;
    L10:
        int r12 = h.d.j(r11, r8, this.f776m);
        k0 r13 = new k0(r8, this.f777n, this.f778o);
        r13.K = this.f785v;
        r13.f1185z = this;
        p r14 = r13.J;
        r14.setOnDismissListener(this);
        r13.f1184y = this.f788y;
        r13.f1181v = this.f787x;
        r13.I = true;
        r14.setFocusable(true);
        r14.setInputMethodMode(2);
        r13.setAdapter(r11);
        r13.i(r12);
        r13.f1181v = this.f787x;
        ArrayList r15 = this.f782s;
        if (r15.size() <= 0) goto L43;
        d r16 = (d) r15.get(r15.size() - 1);
        f r17 = r16.f794b;
        int r19 = r17.size();
        int r110 = 0;
    L13:
        if (r110 >= r19) goto L20;
        MenuItem r111 = r17.getItem(r110);
        if (r111.hasSubMenu() == false) goto L19;
        if (r18 != r111.getSubMenu()) goto L19;
    L21:
        if (r111 != null) goto L23;
    L22:
        View r20 = null;
    L44:
        if (r20 == null) goto L71;
        k0.b.a(r14, false);
        k0.a.a(r14, null);
        e0 r21 = ((d) r15.get(r15.size() - 1)).f793a.f1172m;
        int[] r22 = new int[2];
        r21.getLocationOnScreen(r22);
        Rect r112 = new Rect();
        this.f789z.getWindowVisibleDisplayFrame(r112);
        if (this.A != 1) goto L51;
        if (((r21.getWidth() + r22[0]) + r12) > r112.right) goto L54;
    L52:
        int r23 = 1;
    L55:
        if (r23 != 1) goto L57;
        boolean r24 = true;
    L58:
        this.A = r23;
        r13.f1184y = r20;
        if ((this.f787x & 5) != 5) goto L64;
        int r25 = 0;
        if (r24 == true) goto L67;
        r12 = r20.getWidth();
    L68:
        int r26 = 0 - r12;
    L69:
        r13.f1175p = r26;
        r13.f1180u = true;
        r13.f1179t = true;
        r13.setVerticalOffset(r25);
    L81:
        r15.add(new d(r13, r18, this.A));
        r13.show();
        e0 r27 = r13.f1172m;
        r27.setOnKeyListener(this);
        if (r16 == null) goto L84;
        return;
    L84:
        if (this.G == true) goto L86;
        return;
    L86:
        if (r18.f827m == null) goto L97;
        FrameLayout r28 = (FrameLayout) r10.inflate(R.layout.abc_popup_menu_header_item_layout, r27, false);
        TextView r29 = (TextView) r28.findViewById(android.R.id.title);
        r28.setEnabled(false);
        r29.setText(r18.f827m);
        r27.addHeaderView(r28, null, false);
        r13.show();
        return;
    L97:
        return;
    L67:
        r26 = r12 + r25;
        goto L69
    L64:
        r25 = 0;
        if (r24 == false) goto L68;
        r12 = r20.getWidth();
        goto L67
    L57:
        r24 = false;
    L54:
        r23 = 0;
        goto L55
    L51:
        if ((r22[0] - r12) >= 0) goto L54;
    L71:
        if (this.B == false) goto L74;
        r13.f1175p = this.D;
    L74:
        if (this.C == false) goto L76;
        r13.setVerticalOffset(this.E);
    L76:
        Rect r30 = this.f7861a;
        if (r30 == null) goto L79;
        Rect r31 = new Rect(r30);
    L80:
        r13.H = r31;
        goto L81
    L79:
        r31 = null;
        goto L80
    L23:
        e0 r32 = r16.f793a.f1172m;
        ListAdapter r113 = r32.getAdapter();
        if ((r113 instanceof HeaderViewListAdapter) == false) goto L26;
        HeaderViewListAdapter r114 = (HeaderViewListAdapter) r113;
        int r115 = r114.getHeadersCount();
        e r116 = (e) r114.getWrappedAdapter();
    L27:
        int r117 = r116.getCount();
        int r33 = 0;
    L29:
        if (r33 >= r117) goto L34;
        if (r111 == r116.c(r33)) goto L35;
        r33 = r33 + 1;
    L35:
        if (r33 == (-1)) goto L22;
        int r34 = (r33 + r115) - r32.getFirstVisiblePosition();
        if (r34 < 0) goto L22;
        if (r34 >= r32.getChildCount()) goto L22;
        r20 = r32.getChildAt(r34);
        goto L44
    L34:
        r33 = -1;
        goto L35
    L26:
        r116 = (e) r113;
        r115 = 0;
    L19:
        r110 = r110 + 1;
        goto L13
    L20:
        r111 = null;
        goto L21
    L43:
        r20 = null;
        r16 = null;
    L8:
        if (isShowing() == false) goto L10;
        r11.f810m = h.d.s(r18);
        goto L10
    }
}
