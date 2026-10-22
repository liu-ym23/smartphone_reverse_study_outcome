package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.obric.cae.R;
import j0.w;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j.a f878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h.d f879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f881l;

    public class a implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f882a;

        public a(i r8) {
            this.f882a = r8;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.f882a.d();
        }
    }

    public static class b {
        public static void a(Display r8, Point r10) {
            r8.getRealSize(r10);
        }
    }

    public i(int r8, int r10, Context r11, View r12, f r13, boolean r14) {
        this.f876g = 8388611;
        this.f881l = new a(this);
        this.f870a = r11;
        this.f871b = r13;
        this.f875f = r12;
        this.f872c = r14;
        this.f873d = r8;
        this.f874e = r10;
    }

    public final void a() {
        if (c() == false) goto L6;
        this.f879j.dismiss();
        return;
    }

    public final h.d b() {
        if (this.f879j != null) goto L13;
        Context r8 = this.f870a;
        Display r10 = ((WindowManager) r8.getSystemService("window")).getDefaultDisplay();
        Point r11 = new Point();
        b.a(r10, r11);
        if (Math.min(r11.x, r11.y) < r8.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        h.d r13 = new androidx.appcompat.view.menu.b(this.f870a, this.f875f, this.f873d, this.f874e, this.f872c);
    L11:
        r13.i(this.f871b);
        r13.p(this.f881l);
        r13.k(this.f875f);
        r13.b(this.f878i);
        r13.m(this.f877h);
        r13.n(this.f876g);
        this.f879j = r13;
        goto L13
    L10:
        Context r14 = this.f870a;
        f r15 = this.f871b;
        View r16 = this.f875f;
        r13 = new l(this.f873d, this.f874e, r14, r16, r15, this.f872c);
        goto L11
    L7:
        r12 = false;
    L13:
        return this.f879j;
    }

    public final boolean c() {
        h.d r8 = this.f879j;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isShowing() == false) goto L7;
        return true;
    }

    public void d() {
        this.f879j = null;
        PopupWindow.OnDismissListener r8 = this.f880k;
        if (r8 == null) goto L6;
        r8.onDismiss();
        return;
    }

    public final void e(j.a r8) {
        this.f878i = r8;
        h.d r10 = this.f879j;
        if (r10 == null) goto L6;
        r10.b(r8);
        return;
    }

    public final void f(int r8, int r10, boolean r11, boolean r12) {
        h.d r13 = b();
        r13.q(r12);
        if (r11 == true) goto L5;
    L8:
        r13.show();
        return;
    L5:
        if ((j0.d.a(this.f876g, w.f(this.f875f)) & 7) != 5) goto L7;
        r8 = r8 - this.f875f.getWidth();
    L7:
        r13.o(r8);
        r13.r(r10);
        int r14 = (int) ((this.f870a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
        r13.l(new Rect(r8 - r14, r10 - r14, r8 + r14, r10 + r14));
        goto L8
    }

    public i(Context r8, f r10, View r11, boolean r12) {
        this(R.attr.actionOverflowMenuStyle, 0, r8, r11, r10, r12);
    }
}
