package ba;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f3141a;

    public b(SideSheetBehavior<? extends View> r8) {
        this.f3141a = r8;
    }

    @Override // ba.d
    public final int a(ViewGroup.MarginLayoutParams r8) {
        return r8.rightMargin;
    }

    @Override // ba.d
    public final float b(int r8) {
        float r10 = this.f3141a.f4928m;
        return (r10 - r8) / (r10 - c());
    }

    @Override // ba.d
    public final int c() {
        SideSheetBehavior<? extends View> r8 = this.f3141a;
        return Math.max(0, (r8.f4928m - r8.f4927l) - r8.f4930o);
    }

    @Override // ba.d
    public final int d() {
        return this.f3141a.f4928m;
    }

    @Override // ba.d
    public final int e() {
        return this.f3141a.f4928m;
    }

    @Override // ba.d
    public final int f() {
        return c();
    }

    @Override // ba.d
    public final <V extends View> int g(V r8) {
        return r8.getLeft() - this.f3141a.f4930o;
    }

    @Override // ba.d
    public final int h(CoordinatorLayout r8) {
        return r8.getRight();
    }

    @Override // ba.d
    public final int i() {
        return 0;
    }

    @Override // ba.d
    public final boolean j(float r8) {
        if (r8 >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ba.d
    public final boolean k(View r8) {
        int r10 = r8.getLeft();
        int r11 = this.f3141a.f4928m;
        if (r10 <= ((c() + r11) / 2)) goto L5;
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
        this.f3141a.getClass();
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
        if (Math.abs((r10 * this.f3141a.f4926k) + r8.getRight()) <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ba.d
    public final void n(ViewGroup.MarginLayoutParams r8, int r10, int r11) {
        int r12 = this.f3141a.f4928m;
        if (r10 > r12) goto L6;
        r8.rightMargin = r12 - r10;
        return;
    }
}
