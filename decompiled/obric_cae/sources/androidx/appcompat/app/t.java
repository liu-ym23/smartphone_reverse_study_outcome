package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.x0;
import j0.h0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class t extends androidx.appcompat.app.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window.Callback f683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<androidx.appcompat.app.a.b> f688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f689h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f690a;

        public a(t r8) {
            this.f690a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t r8 = this.f690a;
            Window.Callback r10 = r8.f683b;
            Menu r11 = r8.p();
            if ((r11 instanceof androidx.appcompat.view.menu.f) == false) goto L5;
            androidx.appcompat.view.menu.f r12 = (androidx.appcompat.view.menu.f) r11;
        L6:
            if (r12 == null) goto L20;
            r12.y();
        L20:
            r11.clear();     // Catch: Throwable -> L16
            if (r10.onCreatePanelMenu(0, r11) == true) goto L11;
        L12:
            r11.clear();     // Catch: Throwable -> L16
        L13:
            if (r12 == null) goto L22;
            r12.x();
            return;
        L22:
            return;
        L11:
            if (r10.onPreparePanel(0, null, r11) == true) goto L13;
        L16:
            th = move-exception;
            if (r12 == null) goto L19;
            r12.x();
        L19:
            throw th;
        L5:
            r12 = null;
            goto L6
        }
    }

    public class b implements Toolbar.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f691a;

        public b(t r8) {
            this.f691a = r8;
        }
    }

    public final class c implements androidx.appcompat.view.menu.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f693b;

        public c(t r8) {
            this.f693b = r8;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
            if (this.f692a == false) goto L5;
            return;
        L5:
            this.f692a = true;
            t r11 = this.f693b;
            r11.f682a.n();
            r11.f683b.onPanelClosed(108, r8);
            this.f692a = false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f r8) {
            this.f693b.f683b.onMenuOpened(108, r8);
            return true;
        }
    }

    public final class d implements androidx.appcompat.view.menu.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f694a;

        public d(t r8) {
            this.f694a = r8;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f r8) {
            t r10 = this.f694a;
            boolean r11 = r10.f682a.e();
            Window.Callback r12 = r10.f683b;
            if (r11 == false) goto L6;
            r12.onPanelClosed(108, r8);
            return;
        L6:
            if (r12.onPreparePanel(0, null, r8) == false) goto L10;
            r12.onMenuOpened(108, r8);
            return;
        }
    }

    public class e implements AppCompatDelegateImpl.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f695a;

        public e(t r8) {
            this.f695a = r8;
        }
    }

    public t(Toolbar r8, CharSequence r10, AppCompatDelegateImpl.h r11) {
        this.f688g = new ArrayList();
        this.f689h = new a(this);
        b r12 = new b(this);
        r8.getClass();
        x0 r13 = new x0(r8, false);
        this.f682a = r13;
        r11.getClass();
        this.f683b = r11;
        r13.f1310l = r11;
        r8.setOnMenuItemClickListener(r12);
        r13.setWindowTitle(r10);
        this.f684c = new e(this);
    }

    @Override // androidx.appcompat.app.a
    public final boolean a() {
        return this.f682a.c();
    }

    @Override // androidx.appcompat.app.a
    public final boolean b() {
        x0 r8 = this.f682a;
        if (r8.h() == false) goto L6;
        r8.collapseActionView();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.app.a
    public final void c(boolean r8) {
        if (r8 != this.f687f) goto L5;
        return;
    L5:
        this.f687f = r8;
        ArrayList<androidx.appcompat.app.a.b> r10 = this.f688g;
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
        return this.f682a.f1300b;
    }

    @Override // androidx.appcompat.app.a
    public final Context e() {
        return this.f682a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public final boolean f() {
        x0 r8 = this.f682a;
        Toolbar r10 = r8.f1299a;
        a r11 = this.f689h;
        r10.removeCallbacks(r11);
        Toolbar r12 = r8.f1299a;
        WeakHashMap<View, h0> r13 = j0.w.f8437a;
        j0.w.d.m(r12, r11);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public final void g() {
    }

    @Override // androidx.appcompat.app.a
    public final void h() {
        this.f682a.f1299a.removeCallbacks(this.f689h);
    }

    @Override // androidx.appcompat.app.a
    public final boolean i(int r8, KeyEvent r10) {
        Menu r11 = p();
        if (r11 == null) goto L13;
        if (r10 == null) goto L6;
        int r12 = r10.getDeviceId();
    L7:
        boolean r13 = true;
        if (KeyCharacterMap.load(r12).getKeyboardType() != 1) goto L11;
        r13 = false;
    L11:
        r11.setQwertyMode(r13);
        return r11.performShortcut(r8, r10, 0);
    L6:
        r12 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.a
    public final boolean j(KeyEvent r8) {
        if (r8.getAction() != 1) goto L5;
        k();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.a
    public final boolean k() {
        return this.f682a.d();
    }

    @Override // androidx.appcompat.app.a
    public final void l(boolean r8) {
    }

    @Override // androidx.appcompat.app.a
    public final void m(boolean r8) {
    }

    @Override // androidx.appcompat.app.a
    public final void n(CharSequence r8) {
        this.f682a.setWindowTitle(r8);
    }

    public final Menu p() {
        boolean r8 = this.f686e;
        x0 r10 = this.f682a;
        if (r8 == true) goto L9;
        c r11 = new c(this);
        d r12 = new d(this);
        Toolbar r13 = r10.f1299a;
        r13.X = r11;
        r13.Y = r12;
        ActionMenuView r14 = r13.f1055a;
        if (r14 == null) goto L7;
        r14.E = r11;
        r14.F = r12;
    L7:
        this.f686e = true;
    L9:
        return r10.f1299a.getMenu();
    }
}
