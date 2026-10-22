package i9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f8296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8297b;

    public c() {
        this.f8297b = 0;
    }

    public void A(CoordinatorLayout r8, V r10, int r11) {
        r8.q(r10, r11);
    }

    public final boolean B(int r8) {
        d r10 = this.f8296a;
        if (r10 != null) goto L5;
        this.f8297b = r8;
        return false;
    L5:
        if (r10.f8301d == r8) goto L10;
        r10.f8301d = r8;
        r10.a();
        return true;
    L10:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout r8, V r10, int r11) {
        A(r8, r10, r11);
        if (this.f8296a != null) goto L5;
        this.f8296a = new d(r10);
    L5:
        d r12 = this.f8296a;
        View r13 = r12.f8298a;
        r12.f8299b = r13.getTop();
        r12.f8300c = r13.getLeft();
        this.f8296a.a();
        int r14 = this.f8297b;
        if (r14 == 0) goto L13;
        d r15 = this.f8296a;
        if (r15.f8301d == r14) goto L10;
        r15.f8301d = r14;
        r15.a();
    L10:
        this.f8297b = 0;
        return true;
    L13:
        return true;
    }

    public final int y() {
        d r8 = this.f8296a;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f8301d;
    }

    public int z() {
        return y();
    }

    public c(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f8297b = 0;
    }
}
