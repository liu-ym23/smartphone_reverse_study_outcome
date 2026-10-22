package ba;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f3140a;

    public a(SideSheetBehavior<? extends View> r8) {
        this.f3140a = r8;
    }

    @Override // ba.d
    public final int a(ViewGroup.MarginLayoutParams r8) {
        return r8.leftMargin;
    }

    @Override // ba.d
    public final float b(int r8) {
        float r10 = d();
        return (r8 - r10) / (c() - r10);
    }

    @Override // ba.d
    public final int c() {
        SideSheetBehavior<? extends View> r8 = this.f3140a;
        return Math.max(0, r8.f4929n + r8.f4930o);
    }

    @Override // ba.d
    public final int d() {
        SideSheetBehavior<? extends View> r8 = this.f3140a;
        return (-r8.f4927l) - r8.f4930o;
    }

    @Override // ba.d
    public final int e() {
        return this.f3140a.f4930o;
    }

    @Override // ba.d
    public final int f() {
        return -this.f3140a.f4927l;
    }

    @Override // ba.d
    public final <V extends View> int g(V r8) {
        return r8.getRight() + this.f3140a.f4930o;
    }

    @Override // ba.d
    public final int h(CoordinatorLayout r8) {
        return r8.getLeft();
    }

    @Override // ba.d
    public final int i() {
        return 1;
    }

    @Override // ba.d
    public final boolean j(float r8) {
        if (r8 <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ba.d
    public final boolean k(View r8) {
        if (r8.getRight() >= ((c() - d()) / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ba.d
    public final boolean l(float r8, float r10) {
        if (Math.abs(r8) <= Math.abs(r10)) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L11;
        float r12 = Math.abs(r8);
        this.f3140a.getClass();
        if (r12 <= 500) goto L11;
        return true;
    L11:
        return false;
    L5:
        r11 = false;
        goto L6
    }

    @Override // ba.d
    public final boolean m(View r8, float r10) {
        if (Math.abs((r10 * this.f3140a.f4926k) + r8.getLeft()) <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ba.d
    public final void n(ViewGroup.MarginLayoutParams r8, int r10, int r11) {
        if (r10 > this.f3140a.f4928m) goto L6;
        r8.leftMargin = r11;
        return;
    }
}
