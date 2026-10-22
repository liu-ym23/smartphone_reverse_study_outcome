package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0004a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f638a;

        public C0004a() {
            super(-2, -2);
            this.f638a = 8388627;
        }

        public C0004a(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f638a = 0;
            TypedArray r11 = r8.obtainStyledAttributes(r10, c.a.f3216b);
            this.f638a = r11.getInt(0, 0);
            r11.recycle();
        }

        public C0004a(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f638a = 0;
        }

        public C0004a(C0004a r8) {
            super(r8);
            this.f638a = 0;
            this.f638a = r8.f638a;
        }
    }

    public interface b {
        void a();
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract void c(boolean r8);

    public abstract int d();

    public abstract Context e();

    public boolean f() {
        return false;
    }

    public abstract void g();

    public void h() {
    }

    public abstract boolean i(int r8, KeyEvent r10);

    public boolean j(KeyEvent r8) {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract void l(boolean r8);

    public abstract void m(boolean r8);

    public abstract void n(CharSequence r8);

    public g.b o(AppCompatDelegateImpl.e r8) {
        return null;
    }
}
