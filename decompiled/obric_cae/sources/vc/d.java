package vc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
public class d<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f12836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12837b;

    public d() {
        this.f12837b = 0;
    }

    public void A(CoordinatorLayout r8, V r10, int r11) {
        r8.q(r10, r11);
    }

    public final boolean B(int r8) {
        e r10 = this.f12836a;
        if (r10 != null) goto L5;
        this.f12837b = r8;
        return false;
    L5:
        if (r10.f12841d == r8) goto L10;
        r10.f12841d = r8;
        r10.a();
        return true;
    L10:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout r8, V r10, int r11) {
        A(r8, r10, r11);
        if (this.f12836a != null) goto L5;
        this.f12836a = new e(r10);
    L5:
        e r12 = this.f12836a;
        View r13 = r12.f12838a;
        r12.f12839b = r13.getTop();
        r12.f12840c = r13.getLeft();
        this.f12836a.a();
        int r14 = this.f12837b;
        if (r14 == 0) goto L13;
        e r15 = this.f12836a;
        if (r15.f12841d == r14) goto L10;
        r15.f12841d = r14;
        r15.a();
    L10:
        this.f12837b = 0;
        return true;
    L13:
        return true;
    }

    public final int y() {
        e r8 = this.f12836a;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f12841d;
    }

    public int z() {
        return y();
    }

    public d(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f12837b = 0;
    }
}
