package j0;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f8373a;

    public interface a {
    }

    public b() {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem r8) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(androidx.appcompat.view.menu.m r8) {
    }

    public boolean g() {
        return false;
    }

    public void h(androidx.appcompat.view.menu.h.a r8) {
        if (this.f8373a == null) goto L5;
        Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    L5:
        this.f8373a = r8;
    }
}
