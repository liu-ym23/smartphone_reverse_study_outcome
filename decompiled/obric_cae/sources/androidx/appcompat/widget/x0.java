package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f1299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o0 f1301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f1302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f1309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Window.Callback f1310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f1312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1313o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f1314p;

    public class a extends t2.b {
        public boolean H;
        public final /* synthetic */ int I;
        public final /* synthetic */ x0 J;

        public a(x0 r8, int r10) {
            this.J = r8;
            this.I = r10;
            this.H = false;
        }

        @Override // t2.b, j0.i0
        public final void a(View r8) {
            this.H = true;
        }

        @Override // t2.b, j0.i0
        public final void c() {
            this.J.f1299a.setVisibility(0);
        }

        @Override // j0.i0
        public final void d() {
            if (this.H == true) goto L6;
            this.J.f1299a.setVisibility(this.I);
            return;
        }
    }

    public x0(Toolbar r8, boolean r10) {
        this.f1313o = 0;
        this.f1299a = r8;
        this.f1307i = r8.getTitle();
        this.f1308j = r8.getSubtitle();
        if (this.f1307i == null) goto L5;
        boolean r11 = true;
    L6:
        this.f1306h = r11;
        this.f1305g = r8.getNavigationIcon();
        String r12 = null;
        v0 r13 = v0.m(r8.getContext(), null, c.a.f3215a, R.attr.actionBarStyle);
        int r14 = 15;
        this.f1314p = r13.e(15);
        if (r10 == false) goto L71;
        CharSequence r15 = r13.k(27);
        if (TextUtils.isEmpty(r15) == true) goto L15;
        this.f1306h = true;
        this.f1307i = r15;
        if ((this.f1300b & 8) == 0) goto L15;
        r8.setTitle(r15);
        if (this.f1306h == false) goto L15;
        j0.w.n(r8.getRootView(), r15);
    L15:
        CharSequence r16 = r13.k(25);
        if (TextUtils.isEmpty(r16) == true) goto L20;
        this.f1308j = r16;
        if ((this.f1300b & 8) == 0) goto L20;
        r8.setSubtitle(r16);
    L20:
        Drawable r17 = r13.e(20);
        if (r17 == null) goto L23;
        this.f1304f = r17;
        u();
    L23:
        Drawable r18 = r13.e(17);
        if (r18 == null) goto L27;
        setIcon(r18);
    L27:
        if (this.f1305g != null) goto L34;
        Drawable r19 = this.f1314p;
        if (r19 == null) goto L34;
        this.f1305g = r19;
        if ((this.f1300b & 4) == 0) goto L33;
        r8.setNavigationIcon(r19);
        goto L34
    L33:
        r8.setNavigationIcon(null);
    L34:
        i(r13.h(10, 0));
        int r20 = r13.i(9, 0);
        if (r20 == 0) goto L47;
        View r21 = LayoutInflater.from(r8.getContext()).inflate(r20, r8, false);
        View r22 = this.f1302d;
        if (r22 != null) goto L39;
    L41:
        this.f1302d = r21;
        if (r21 != null) goto L44;
    L46:
        i(this.f1300b | 16);
        goto L47
    L44:
        if ((this.f1300b & 16) == 0) goto L46;
        r8.addView(r21);
        goto L46
    L39:
        if ((this.f1300b & 16) == 0) goto L41;
        r8.removeView(r22);
    L47:
        int r23 = r13.f1275b.getLayoutDimension(13, 0);
        if (r23 <= 0) goto L50;
        ViewGroup.LayoutParams r24 = r8.getLayoutParams();
        r24.height = r23;
        r8.setLayoutParams(r24);
    L50:
        int r25 = r13.c(7, -1);
        int r26 = r13.c(3, -1);
        if (r25 >= 0) goto L53;
        if (r26 >= 0) goto L53;
    L57:
        int r27 = r13.i(28, 0);
        if (r27 == 0) goto L62;
        Context r28 = r8.getContext();
        r8.f1069v = r27;
        y r29 = r8.f1057b;
        if (r29 == null) goto L62;
        r29.setTextAppearance(r28, r27);
    L62:
        int r30 = r13.i(26, 0);
        if (r30 == 0) goto L67;
        Context r31 = r8.getContext();
        r8.f1070w = r30;
        y r32 = r8.f1060m;
        if (r32 == null) goto L67;
        r32.setTextAppearance(r31, r30);
    L67:
        int r33 = r13.i(22, 0);
        if (r33 == 0) goto L75;
        r8.setPopupTheme(r33);
    L75:
        r13.n();
        if (R.string.abc_action_bar_up_description == this.f1313o) goto L90;
        this.f1313o = R.string.abc_action_bar_up_description;
        if (TextUtils.isEmpty(r8.getNavigationContentDescription()) == false) goto L90;
        int r34 = this.f1313o;
        if (r34 == 0) goto L84;
        r12 = getContext().getString(r34);
    L84:
        this.f1309k = r12;
        if ((this.f1300b & 4) == 0) goto L90;
        if (TextUtils.isEmpty(r12) == false) goto L89;
        r8.setNavigationContentDescription(this.f1313o);
        goto L90
    L89:
        r8.setNavigationContentDescription(this.f1309k);
    L90:
        this.f1309k = r8.getNavigationContentDescription();
        r8.setNavigationOnClickListener(new w0(this));
        return;
    L53:
        int r35 = Math.max(r25, 0);
        int r36 = Math.max(r26, 0);
        if (r8.D != null) goto L56;
        r8.D = new n0();
    L56:
        r8.D.a(r35, r36);
        goto L57
    L71:
        if (r8.getNavigationIcon() == null) goto L73;
        this.f1314p = r8.getNavigationIcon();
    L74:
        this.f1300b = r14;
        goto L75
    L73:
        r14 = 11;
        goto L74
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean a() {
        Toolbar r8 = this.f1299a;
        if (r8.getVisibility() != 0) goto L9;
        ActionMenuView r10 = r8.f1055a;
        if (r10 == null) goto L9;
        if (r10.C == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.widget.c0
    public final void b(androidx.appcompat.view.menu.f r8, AppCompatDelegateImpl.d r10) {
        ActionMenuPresenter r11 = this.f1312n;
        Toolbar r12 = this.f1299a;
        if (r11 != null) goto L5;
        this.f1312n = new ActionMenuPresenter(r12.getContext());
    L5:
        ActionMenuPresenter r13 = this.f1312n;
        r13.f771o = r10;
        if (r8 == null) goto L8;
    L10:
        r12.e();
        androidx.appcompat.view.menu.f r14 = r12.f1055a.f955z;
        if (r14 == r8) goto L25;
        if (r14 == null) goto L16;
        r14.t(r12.V);
        r14.t(r12.W);
    L16:
        if (r12.W != null) goto L18;
        r12.W = new Toolbar.f(r12);
    L18:
        r13.A = true;
        if (r8 == null) goto L21;
        r8.c(r13, r12.f1067t);
        r8.c(r12.W, r12.f1067t);
    L22:
        r12.f1055a.setPopupTheme(r12.f1068u);
        r12.f1055a.setPresenter(r13);
        r12.V = r13;
        r12.s();
        return;
    L21:
        r13.h(r12.f1067t, null);
        r12.W.h(r12.f1067t, null);
        r13.d();
        r12.W.d();
        goto L22
    L25:
        return;
    L8:
        if (r12.f1055a != null) goto L10;
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean c() {
        ActionMenuView r8 = this.f1299a.f1055a;
        if (r8 == null) goto L13;
        ActionMenuPresenter r10 = r8.D;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        if (r10.j() == false) goto L9;
        r11 = true;
        goto L10
    L13:
        return false;
    }

    @Override // androidx.appcompat.widget.c0
    public final void collapseActionView() {
        Toolbar.f r8 = this.f1299a.W;
        if (r8 != null) goto L5;
        androidx.appcompat.view.menu.h r10 = null;
    L6:
        if (r10 == null) goto L9;
        r10.collapseActionView();
        return;
    L9:
        return;
    L5:
        r10 = r8.f1081b;
        goto L6
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean d() {
        ActionMenuView r8 = this.f1299a.f1055a;
        if (r8 == null) goto L13;
        ActionMenuPresenter r10 = r8.D;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        if (r10.l() == false) goto L9;
        r11 = true;
        goto L10
    L13:
        return false;
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean e() {
        ActionMenuView r8 = this.f1299a.f1055a;
        if (r8 == null) goto L13;
        ActionMenuPresenter r10 = r8.D;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        if (r10.k() == false) goto L9;
        r11 = true;
        goto L10
    L13:
        return false;
    }

    @Override // androidx.appcompat.widget.c0
    public final void f() {
        this.f1311m = true;
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean g() {
        ActionMenuView r8 = this.f1299a.f1055a;
        if (r8 == null) goto L19;
        ActionMenuPresenter r10 = r8.D;
        if (r10 != null) goto L7;
    L15:
        boolean r11 = false;
    L16:
        if (r11 == true) goto L18;
        return false;
    L18:
        return true;
    L7:
        if (r10.E == null) goto L9;
    L12:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        r11 = true;
        goto L16
    L9:
        if (r10.k() == true) goto L12;
        r12 = false;
        goto L13
    L19:
        return false;
    }

    @Override // androidx.appcompat.widget.c0
    public final Context getContext() {
        return this.f1299a.getContext();
    }

    @Override // androidx.appcompat.widget.c0
    public final CharSequence getTitle() {
        return this.f1299a.getTitle();
    }

    @Override // androidx.appcompat.widget.c0
    public final boolean h() {
        Toolbar.f r8 = this.f1299a.W;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.f1081b == null) goto L7;
        return true;
    }

    @Override // androidx.appcompat.widget.c0
    public final void i(int r8) {
        int r10 = this.f1300b ^ r8;
        this.f1300b = r8;
        if (r10 == 0) goto L41;
        int r11 = r10 & 4;
        CharSequence r12 = null;
        Toolbar r13 = this.f1299a;
        if (r11 == 0) goto L23;
        if ((r8 & 4) == 0) goto L15;
        if ((r8 & 4) == 0) goto L15;
        if (TextUtils.isEmpty(this.f1309k) == false) goto L13;
        r13.setNavigationContentDescription(this.f1313o);
        goto L15
    L13:
        r13.setNavigationContentDescription(this.f1309k);
    L15:
        if ((this.f1300b & 4) == 0) goto L21;
        Drawable r14 = this.f1305g;
        if (r14 != null) goto L20;
        r14 = this.f1314p;
    L20:
        r13.setNavigationIcon(r14);
        goto L23
    L21:
        r13.setNavigationIcon(null);
    L23:
        if ((r10 & 3) == 0) goto L26;
        u();
    L26:
        if ((r10 & 8) == 0) goto L33;
        if ((r8 & 8) == 0) goto L30;
        r13.setTitle(this.f1307i);
        r12 = this.f1308j;
    L31:
        r13.setSubtitle(r12);
        goto L33
    L30:
        r13.setTitle(null);
    L33:
        if ((r10 & 16) == 0) goto L42;
        View r15 = this.f1302d;
        if (r15 != null) goto L37;
        return;
    L37:
        if ((r8 & 16) == 0) goto L39;
        r13.addView(r15);
        return;
    L39:
        r13.removeView(r15);
        return;
    L42:
        return;
    }

    @Override // androidx.appcompat.widget.c0
    public final int j() {
        return 0;
    }

    @Override // androidx.appcompat.widget.c0
    public final j0.h0 k(int r8, long r10) {
        j0.h0 r11 = j0.w.a(this.f1299a);
        if (r8 != 0) goto L5;
        float r12 = 1.0f;
    L6:
        r11.a(r12);
        r11.c(r10);
        r11.d(new a(this, r8));
        return r11;
    L5:
        r12 = 0.0f;
        goto L6
    }

    @Override // androidx.appcompat.widget.c0
    public final void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.c0
    public final void m(boolean r8) {
        this.f1299a.setCollapsible(r8);
    }

    @Override // androidx.appcompat.widget.c0
    public final void n() {
        ActionMenuView r8 = this.f1299a.f1055a;
        if (r8 == null) goto L10;
        ActionMenuPresenter r10 = r8.D;
        if (r10 == null) goto L11;
        r10.j();
        ActionMenuPresenter.a r11 = r10.D;
        if (r11 == null) goto L12;
        r11.a();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.widget.c0
    public final void o() {
    }

    @Override // androidx.appcompat.widget.c0
    public final void p() {
        o0 r8 = this.f1301c;
        if (r8 == null) goto L7;
        ViewParent r10 = r8.getParent();
        Toolbar r11 = this.f1299a;
        if (r10 != r11) goto L7;
        r11.removeView(this.f1301c);
    L7:
        this.f1301c = null;
    }

    @Override // androidx.appcompat.widget.c0
    public final void q(int r8) {
        if (r8 == 0) goto L4;
        Drawable r10 = d.a.a(getContext(), r8);
    L5:
        this.f1304f = r10;
        u();
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.c0
    public final void r(int r8) {
        this.f1299a.setVisibility(r8);
    }

    @Override // androidx.appcompat.widget.c0
    public final int s() {
        return this.f1300b;
    }

    @Override // androidx.appcompat.widget.c0
    public final void setIcon(int r8) {
        if (r8 == 0) goto L4;
        Drawable r10 = d.a.a(getContext(), r8);
    L5:
        setIcon(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.c0
    public final void setWindowCallback(Window.Callback r8) {
        this.f1310l = r8;
    }

    @Override // androidx.appcompat.widget.c0
    public final void setWindowTitle(CharSequence r8) {
        if (this.f1306h == true) goto L10;
        this.f1307i = r8;
        if ((this.f1300b & 8) == 0) goto L11;
        Toolbar r10 = this.f1299a;
        r10.setTitle(r8);
        if (this.f1306h == false) goto L12;
        j0.w.n(r10.getRootView(), r8);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.widget.c0
    public final void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void u() {
        int r8 = this.f1300b;
        if ((r8 & 2) != 0) goto L5;
        Drawable r10 = null;
    L11:
        this.f1299a.setLogo(r10);
        return;
    L5:
        if ((r8 & 1) == 0) goto L9;
        r10 = this.f1304f;
        if (r10 != null) goto L11;
    L9:
        r10 = this.f1303e;
        goto L11
    }

    @Override // androidx.appcompat.widget.c0
    public final void setIcon(Drawable r8) {
        this.f1303e = r8;
        u();
    }
}
