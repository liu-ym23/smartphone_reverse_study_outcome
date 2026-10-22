package androidx.appcompat.app;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c0;
import j0.f0;
import j0.h0;
import j0.j0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class w extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    public static final DecelerateInterpolator A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AccelerateInterpolator f706z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c0 f711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActionBarContextView f712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g.b.a f717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<androidx.appcompat.app.a.b> f719m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g.h f726t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f728v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f729w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f730x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f731y;

    public class a extends t2.b {
        public final /* synthetic */ w H;

        public a(w r8) {
            this.H = r8;
        }

        @Override // j0.i0
        public final void d() {
            w r8 = this.H;
            if (r8.f722p == false) goto L7;
            View r10 = r8.f713g;
            if (r10 == null) goto L7;
            r10.setTranslationY(0.0f);
            r8.f710d.setTranslationY(0.0f);
        L7:
            r8.f710d.setVisibility(8);
            r8.f710d.setTransitioning(false);
            r8.f726t = null;
            g.b.a r11 = r8.f717k;
            if (r11 == null) goto L10;
            r11.b(r8.f716j);
            r8.f716j = null;
            r8.f717k = null;
        L10:
            ActionBarOverlayLayout r12 = r8.f709c;
            if (r12 == null) goto L14;
            WeakHashMap<View, h0> r13 = j0.w.f8437a;
            j0.w.h.c(r12);
            return;
        }
    }

    public class b extends t2.b {
        public final /* synthetic */ w H;

        public b(w r8) {
            this.H = r8;
        }

        @Override // j0.i0
        public final void d() {
            w r8 = this.H;
            r8.f726t = null;
            r8.f710d.requestLayout();
        }
    }

    public class c implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f732a;

        public c(w r8) {
            this.f732a = r8;
        }
    }

    public class d extends g.b implements androidx.appcompat.view.menu.f.a {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Context f733m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final androidx.appcompat.view.menu.f f734n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public g.b.a f735o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public WeakReference<View> f736p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ w f737q;

        public d(w r8, Context r10, AppCompatDelegateImpl.e r11) {
            this.f737q = r8;
            this.f733m = r10;
            this.f735o = r11;
            androidx.appcompat.view.menu.f r12 = new androidx.appcompat.view.menu.f(r10);
            r12.f826l = 1;
            this.f734n = r12;
            r12.f819e = this;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
            g.b.a r11 = this.f735o;
            if (r11 != null) goto L5;
            return false;
        L5:
            return r11.a(this, r10);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f r8) {
            if (this.f735o != null) goto L5;
            return;
        L5:
            i();
            ActionMenuPresenter r10 = this.f737q.f712f.f1091n;
            if (r10 == null) goto L9;
            r10.l();
            return;
        }

        @Override // g.b
        public final void c() {
            w r8 = this.f737q;
            if (r8.f715i == this) goto L6;
            return;
        L6:
            if ((!r8.f723q) == true) goto L8;
            r8.f716j = this;
            r8.f717k = this.f735o;
        L9:
            this.f735o = null;
            r8.p(false);
            ActionBarContextView r10 = r8.f712f;
            if (r10.f912u != null) goto L12;
            r10.h();
        L12:
            r8.f709c.setHideOnContentScrollEnabled(r8.f728v);
            r8.f715i = null;
            return;
        L8:
            this.f735o.b(this);
            goto L9
        }

        @Override // g.b
        public final View d() {
            WeakReference<View> r8 = this.f736p;
            if (r8 != null) goto L7;
            return null;
        L7:
            return r8.get();
        }

        @Override // g.b
        public final androidx.appcompat.view.menu.f e() {
            return this.f734n;
        }

        @Override // g.b
        public final MenuInflater f() {
            return new g.g(this.f733m);
        }

        @Override // g.b
        public final CharSequence g() {
            return this.f737q.f712f.getSubtitle();
        }

        @Override // g.b
        public final CharSequence h() {
            return this.f737q.f712f.getTitle();
        }

        @Override // g.b
        public final void i() {
            if (this.f737q.f715i == this) goto L5;
            return;
        L5:
            androidx.appcompat.view.menu.f r8 = this.f734n;
            r8.y();
            this.f735o.d(this, r8);     // Catch: Throwable -> L9
            r8.x();
            return;
        L9:
            th = move-exception;
            r8.x();
            throw th;
        }

        @Override // g.b
        public final boolean j() {
            return this.f737q.f712f.C;
        }

        @Override // g.b
        public final void k(View r8) {
            this.f737q.f712f.setCustomView(r8);
            this.f736p = new WeakReference(r8);
        }

        @Override // g.b
        public final void l(int r8) {
            m(this.f737q.f707a.getResources().getString(r8));
        }

        @Override // g.b
        public final void m(CharSequence r8) {
            this.f737q.f712f.setSubtitle(r8);
        }

        @Override // g.b
        public final void n(int r8) {
            o(this.f737q.f707a.getResources().getString(r8));
        }

        @Override // g.b
        public final void o(CharSequence r8) {
            this.f737q.f712f.setTitle(r8);
        }

        @Override // g.b
        public final void p(boolean r8) {
            this.f7436b = r8;
            this.f737q.f712f.setTitleOptional(r8);
        }
    }

    static {
        f706z = new AccelerateInterpolator();
        A = new DecelerateInterpolator();
    }

    public w(Activity r8, boolean r10) {
        new ArrayList();
        this.f719m = new ArrayList();
        this.f721o = 0;
        this.f722p = true;
        this.f725s = true;
        this.f729w = new a(this);
        this.f730x = new b(this);
        this.f731y = new c(this);
        View r11 = r8.getWindow().getDecorView();
        q(r11);
        if (r10 == true) goto L6;
        this.f713g = r11.findViewById(R.id.content);
        return;
    }

    @Override // androidx.appcompat.app.a
    public final boolean b() {
        c0 r8 = this.f711e;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.h() == false) goto L10;
        this.f711e.collapseActionView();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.a
    public final void c(boolean r8) {
        if (r8 != this.f718l) goto L5;
        return;
    L5:
        this.f718l = r8;
        ArrayList<androidx.appcompat.app.a.b> r10 = this.f719m;
        int r11 = r10.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r10.get(r12).a();
        r12 = r12 + 1;
        goto L6
    }

    @Override // androidx.appcompat.app.a
    public final int d() {
        return this.f711e.s();
    }

    @Override // androidx.appcompat.app.a
    public final Context e() {
        if (this.f708b != null) goto L9;
        TypedValue r8 = new TypedValue();
        this.f707a.getTheme().resolveAttribute(com.obric.cae.R.attr.actionBarWidgetTheme, r8, true);
        int r10 = r8.resourceId;
        if (r10 == 0) goto L7;
        this.f708b = new ContextThemeWrapper(this.f707a, r10);
        goto L9
    L7:
        this.f708b = this.f707a;
    L9:
        return this.f708b;
    }

    @Override // androidx.appcompat.app.a
    public final void g() {
        r(this.f707a.getResources().getBoolean(com.obric.cae.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.a
    public final boolean i(int r8, KeyEvent r10) {
        d r11 = this.f715i;
        if (r11 != null) goto L5;
        return false;
    L5:
        androidx.appcompat.view.menu.f r12 = r11.f734n;
        if (r12 == null) goto L16;
        if (r10 == null) goto L9;
        int r13 = r10.getDeviceId();
    L10:
        boolean r14 = true;
        if (KeyCharacterMap.load(r13).getKeyboardType() != 1) goto L14;
        r14 = false;
    L14:
        r12.setQwertyMode(r14);
        return r12.performShortcut(r8, r10, 0);
    L9:
        r13 = -1;
        goto L10
    L16:
        return false;
    }

    @Override // androidx.appcompat.app.a
    public final void l(boolean r8) {
        if (this.f714h == false) goto L5;
        return;
    L5:
        if (r8 == false) goto L7;
        int r10 = 4;
    L8:
        int r11 = this.f711e.s();
        this.f714h = true;
        this.f711e.i((r10 & 4) | (r11 & (-5)));
        return;
    L7:
        r10 = 0;
        goto L8
    }

    @Override // androidx.appcompat.app.a
    public final void m(boolean r8) {
        this.f727u = r8;
        if (r8 == true) goto L8;
        g.h r10 = this.f726t;
        if (r10 == null) goto L9;
        r10.a();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.a
    public final void n(CharSequence r8) {
        this.f711e.setWindowTitle(r8);
    }

    @Override // androidx.appcompat.app.a
    public final g.b o(AppCompatDelegateImpl.e r8) {
        d r10 = this.f715i;
        if (r10 == null) goto L5;
        r10.c();
    L5:
        this.f709c.setHideOnContentScrollEnabled(false);
        this.f712f.h();
        d r11 = new d(this, this.f712f.getContext(), r8);
        androidx.appcompat.view.menu.f r12 = r11.f734n;
        r12.y();
        boolean r13 = r11.f735o.c(r11, r12);     // Catch: Throwable -> L13
        r12.x();
        if (r13 == false) goto L11;
        this.f715i = r11;
        r11.i();
        this.f712f.f(r11);
        p(true);
        return r11;
    L11:
        return null;
    L13:
        th = move-exception;
        r12.x();
        throw th;
    }

    public final void p(boolean r10) {
        if (r10 == false) goto L11;
        if (this.f724r == true) goto L16;
        this.f724r = true;
        ActionBarOverlayLayout r8 = this.f709c;
        if (r8 == null) goto L9;
        r8.setShowingForActionMode(true);
    L9:
        s(false);
    L16:
        ActionBarContainer r11 = this.f710d;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        if (j0.w.g.c(r11) == true) goto L19;
        if (r10 == false) goto L32;
        this.f711e.r(4);
        this.f712f.setVisibility(0);
        return;
    L32:
        this.f711e.r(0);
        this.f712f.setVisibility(8);
        return;
    L19:
        if (r10 == false) goto L21;
        h0 r13 = this.f711e.k(4, 100);
        h0 r14 = this.f712f.e(0, 200);
    L22:
        g.h r15 = new g.h();
        ArrayList<h0> r16 = r15.f7490a;
        r16.add(r13);
        View r17 = r13.f8388a.get();
        if (r17 == null) goto L25;
        long r18 = r17.animate().getDuration();
    L26:
        View r19 = r14.f8388a.get();
        if (r19 == null) goto L29;
        r19.animate().setStartDelay(r18);
    L29:
        r16.add(r14);
        r15.b();
        return;
    L25:
        r18 = 0;
        goto L26
    L21:
        h0 r110 = this.f711e.k(0, 200);
        r13 = this.f712f.e(8, 100);
        r14 = r110;
        goto L22
    L11:
        if (this.f724r == false) goto L16;
        this.f724r = false;
        ActionBarOverlayLayout r20 = this.f709c;
        if (r20 == null) goto L15;
        r20.setShowingForActionMode(false);
    L15:
        s(false);
        goto L16
    }

    public final void q(View r8) {
        ActionBarOverlayLayout r10 = (ActionBarOverlayLayout) r8.findViewById(com.obric.cae.R.id.decor_content_parent);
        this.f709c = r10;
        if (r10 == null) goto L5;
        r10.setActionBarVisibilityCallback(this);
    L5:
        KeyEvent.Callback r11 = r8.findViewById(com.obric.cae.R.id.action_bar);
        if ((r11 instanceof c0) == false) goto L9;
        c0 r12 = (c0) r11;
    L11:
        this.f711e = r12;
        this.f712f = (ActionBarContextView) r8.findViewById(com.obric.cae.R.id.action_context_bar);
        ActionBarContainer r13 = (ActionBarContainer) r8.findViewById(com.obric.cae.R.id.action_bar_container);
        this.f710d = r13;
        c0 r14 = this.f711e;
        if (r14 == null) goto L39;
        if (this.f712f == null) goto L39;
        if (r13 == null) goto L39;
        this.f707a = r14.getContext();
        if ((this.f711e.s() & 4) == 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L22;
        this.f714h = true;
    L22:
        Context r16 = this.f707a;
        if (r16.getApplicationInfo().targetSdkVersion < 14) goto L26;
    L26:
        this.f711e.o();
        r(r16.getResources().getBoolean(com.obric.cae.R.bool.abc_action_bar_embed_tabs));
        TypedArray r17 = this.f707a.obtainStyledAttributes(null, c.a.f3215a, com.obric.cae.R.attr.actionBarStyle, 0);
        if (r17.getBoolean(14, false) == false) goto L33;
        ActionBarOverlayLayout r18 = this.f709c;
        if (r18.f926r == false) goto L32;
        this.f728v = true;
        r18.setHideOnContentScrollEnabled(true);
        goto L33
    L32:
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    L33:
        int r19 = r17.getDimensionPixelSize(12, 0);
        if (r19 == 0) goto L36;
        ActionBarContainer r20 = this.f710d;
        WeakHashMap<View, h0> r21 = j0.w.f8437a;
        j0.w.i.s(r20, r19);
    L36:
        r17.recycle();
        return;
    L19:
        r15 = false;
    L39:
        throw new IllegalStateException(w.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
    L9:
        if ((r11 instanceof Toolbar) == false) goto L41;
        r12 = ((Toolbar) r11).getWrapper();
        goto L11
    L41:
        if (r11 == null) goto L43;
        String r22 = r11.getClass().getSimpleName();
    L45:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r22));
    L43:
        r22 = "null";
        goto L45
    }

    public final void r(boolean r8) {
        this.f720n = r8;
        if (r8 == true) goto L5;
        this.f711e.p();
        this.f710d.setTabContainer(null);
    L6:
        boolean r10 = true;
        if (this.f711e.j() != 2) goto L9;
        boolean r11 = true;
    L10:
        c0 r12 = this.f711e;
        if (this.f720n == true) goto L14;
        if (r11 == false) goto L14;
        boolean r13 = true;
    L15:
        r12.m(r13);
        ActionBarOverlayLayout r14 = this.f709c;
        if (this.f720n == true) goto L19;
        if (r11 == false) goto L19;
    L20:
        r14.setHasNonEmbeddedTabs(r10);
        return;
    L19:
        r10 = false;
    L14:
        r13 = false;
        goto L15
    L9:
        r11 = false;
        goto L10
    L5:
        this.f710d.setTabContainer(null);
        this.f711e.p();
        goto L6
    }

    public final void s(boolean r12) {
        boolean r8 = this.f723q;
        if (this.f724r == false) goto L5;
    L4:
        boolean r10 = true;
    L7:
        ValueAnimator.AnimatorUpdateListener r11 = null;
        View r13 = this.f713g;
        final c r14 = this.f731y;
        if (r10 == false) goto L53;
        if (this.f725s == true) goto L89;
        this.f725s = true;
        g.h r15 = this.f726t;
        if (r15 == null) goto L14;
        r15.a();
    L14:
        this.f710d.setVisibility(0);
        int r16 = this.f721o;
        b r17 = this.f730x;
        if (r16 == 0) goto L17;
    L44:
        this.f710d.setAlpha(1.0f);
        this.f710d.setTranslationY(0.0f);
        if (this.f722p == false) goto L48;
        if (r13 == null) goto L48;
        r13.setTranslationY(0.0f);
    L48:
        r17.d();
    L49:
        ActionBarOverlayLayout r18 = this.f709c;
        if (r18 == null) goto L90;
        WeakHashMap<View, h0> r19 = j0.w.f8437a;
        j0.w.h.c(r18);
        return;
    L90:
        return;
    L17:
        if (this.f727u == true) goto L19;
        if (r12 == false) goto L44;
    L19:
        this.f710d.setTranslationY(0.0f);
        float r20 = -this.f710d.getHeight();
        if (r12 == false) goto L22;
        int[] r110 = {0, 0};
        this.f710d.getLocationInWindow(r110);
        r20 = r20 - r110[1];
    L22:
        this.f710d.setTranslationY(r20);
        g.h r111 = new g.h();
        h0 r21 = j0.w.a(this.f710d);
        r21.e(0.0f);
        final View r22 = r21.f8388a.get();
        if (r22 == null) goto L27;
        if (r14 == null) goto L26;
        r11 = new f0(r14, r22);
    L26:
        h0.a.a(r22.animate(), r11);
    L27:
        boolean r23 = r111.f7494e;
        ArrayList<h0> r24 = r111.f7490a;
        if (r23 == true) goto L31;
        r24.add(r21);
    L31:
        if (this.f722p == false) goto L36;
        if (r13 == null) goto L36;
        r13.setTranslationY(r20);
        h0 r25 = j0.w.a(r13);
        r25.e(0.0f);
        if (r111.f7494e == true) goto L36;
        r24.add(r25);
    L36:
        DecelerateInterpolator r26 = A;
        boolean r27 = r111.f7494e;
        if (r27 == true) goto L39;
        r111.f7492c = r26;
    L39:
        if (r27 == true) goto L41;
        r111.f7491b = 250;
    L41:
        if (r27 == true) goto L43;
        r111.f7493d = r17;
    L43:
        this.f726t = r111;
        r111.b();
        goto L49
    L89:
        return;
    L53:
        if (this.f725s == false) goto L92;
        this.f725s = false;
        g.h r28 = this.f726t;
        if (r28 == null) goto L57;
        r28.a();
    L57:
        int r29 = this.f721o;
        a r30 = this.f729w;
        if (r29 == 0) goto L60;
    L87:
        r30.d();
        return;
    L60:
        if (this.f727u == true) goto L62;
        if (r12 == false) goto L87;
    L62:
        this.f710d.setAlpha(1.0f);
        this.f710d.setTransitioning(true);
        g.h r31 = new g.h();
        float r32 = -this.f710d.getHeight();
        if (r12 == false) goto L65;
        int[] r112 = {0, 0};
        this.f710d.getLocationInWindow(r112);
        r32 = r32 - r112[1];
    L65:
        h0 r113 = j0.w.a(this.f710d);
        r113.e(r32);
        final View r33 = r113.f8388a.get();
        if (r33 == null) goto L70;
        if (r14 == null) goto L69;
        r11 = new f0(r14, r33);
    L69:
        h0.a.a(r33.animate(), r11);
    L70:
        boolean r34 = r31.f7494e;
        ArrayList<h0> r35 = r31.f7490a;
        if (r34 == true) goto L74;
        r35.add(r113);
    L74:
        if (this.f722p == false) goto L79;
        if (r13 == null) goto L79;
        h0 r114 = j0.w.a(r13);
        r114.e(r32);
        if (r31.f7494e == true) goto L79;
        r35.add(r114);
    L79:
        AccelerateInterpolator r115 = f706z;
        boolean r36 = r31.f7494e;
        if (r36 == true) goto L82;
        r31.f7492c = r115;
    L82:
        if (r36 == true) goto L84;
        r31.f7491b = 250;
    L84:
        if (r36 == true) goto L86;
        r31.f7493d = r30;
    L86:
        this.f726t = r31;
        r31.b();
        return;
    L92:
        return;
    L5:
        if (r8 == false) goto L4;
        r10 = false;
        goto L7
    }

    public w(Dialog r8) {
        new ArrayList();
        this.f719m = new ArrayList();
        this.f721o = 0;
        this.f722p = true;
        this.f725s = true;
        this.f729w = new a(this);
        this.f730x = new b(this);
        this.f731y = new c(this);
        q(r8.getWindow().getDecorView());
    }
}
