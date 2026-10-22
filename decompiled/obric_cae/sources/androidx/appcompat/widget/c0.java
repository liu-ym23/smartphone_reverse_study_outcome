package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* JADX INFO: loaded from: classes.dex */
public interface c0 {
    boolean a();

    void b(androidx.appcompat.view.menu.f r8, AppCompatDelegateImpl.d r10);

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int r8);

    int j();

    j0.h0 k(int r8, long r10);

    void l();

    void m(boolean r8);

    void n();

    void o();

    void p();

    void q(int r8);

    void r(int r8);

    int s();

    void setIcon(int r8);

    void setIcon(Drawable r8);

    void setWindowCallback(Window.Callback r8);

    void setWindowTitle(CharSequence r8);

    void t();
}
