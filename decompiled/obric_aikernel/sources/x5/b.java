package x5;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f13561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @IdRes
    private int f13563c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a r10) {
        this.f13562b = false;
        this.f13563c = 0;
        this.f13561a = (View) r10;
    }

    private void a() {
        ViewParent r10 = this.f13561a.getParent();
        if ((r10 instanceof CoordinatorLayout) == false) goto L6;
        ((CoordinatorLayout) r10).dispatchDependentViewsChanged(this.f13561a);
        return;
    }

    @IdRes
    public int b() {
        return this.f13563c;
    }

    public boolean c() {
        return this.f13562b;
    }

    public void d(@NonNull Bundle r10) {
        this.f13562b = r10.getBoolean("expanded", false);
        this.f13563c = r10.getInt("expandedComponentIdHint", 0);
        if (this.f13562b == false) goto L6;
        a();
        return;
    }

    @NonNull
    public Bundle e() {
        Bundle r10 = new Bundle();
        r10.putBoolean("expanded", this.f13562b);
        r10.putInt("expandedComponentIdHint", this.f13563c);
        return r10;
    }

    public boolean f(boolean r10) {
        if (this.f13562b == r10) goto L6;
        this.f13562b = r10;
        a();
        return true;
    L6:
        return false;
    }

    public void g(@IdRes int r10) {
        this.f13563c = r10;
    }
}
