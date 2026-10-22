package p6a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.e;
import m6a.f;
import m6a.g;
import m6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b extends RelativeLayout implements g {
    public final View a;
    public n6a.b b;
    public g c;

    public boolean a() {
        g r0 = this.c;
        if (r0 == null) goto L8;
        if (r0 == this) goto L8;
        if (r0.a() == false) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // m6a.g
    public n6a.b getSpinnerStyle() {
        n6a.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        g r1 = this.c;
        if (r1 == null) goto L10;
        if (r1 == this) goto L10;
        return r1.getSpinnerStyle();
    L10:
        View r2 = this.a;
        if (r2 == null) goto L30;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof SmartRefreshLayout.LayoutParams) == false) goto L17;
        n6a.b r4 = ((SmartRefreshLayout.LayoutParams) r3).b;
        this.b = r4;
        if (r4 == null) goto L17;
        return r4;
    L17:
        if (r3 == null) goto L30;
        int r5 = r3.height;
        if (r5 != 0) goto L21;
    L22:
        n6a.b[] r6 = n6a.b.h;
        int r7 = 0;
    L24:
        if (r7 >= 5) goto L30;
        n6a.b r8 = r6[r7];
        if (r8.c == true) goto L27;
        r7 = r7 + 1;
        goto L24
    L27:
        this.b = r8;
        return r8;
    L21:
        if (r5 == (-1)) goto L22;
    L30:
        n6a.b r9 = n6a.b.d;
        this.b = r9;
        return r9;
    }

    @Override // m6a.g
    public View getView() {
        View r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r5) {
        if ((r5 instanceof g) == false) goto L5;
        g r0 = (g) r5;
    L6:
        super(r5.getContext(), null, 0);
        this.a = r5;
        this.c = r0;
        if ((this instanceof o6a.b) == false) goto L14;
        if ((r0 instanceof f) == false) goto L14;
        if (r0.getSpinnerStyle() != n6a.b.g) goto L14;
        r0.getView().setScaleY(-1.0f);
        return;
    L14:
        if ((this instanceof o6a.c) == false) goto L22;
        g r6 = this.c;
        if ((r6 instanceof e) == true) goto L18;
        return;
    L18:
        if (r6.getSpinnerStyle() != n6a.b.g) goto L24;
        r0.getView().setScaleY(-1.0f);
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public boolean c(boolean r3) {
        g r0 = this.c;
        if ((r0 instanceof e) == true) goto L5;
    L7:
        return false;
    L5:
        if (((e) r0).c(r3) == false) goto L7;
        return true;
    }

    public boolean equals(Object r4) {
        if (super.equals(r4) == false) goto L5;
        return true;
    L5:
        if ((r4 instanceof g) == true) goto L7;
        return false;
    L7:
        if (getView() == ((g) r4).getView()) goto L13;
        return false;
    L13:
        return true;
    }

    public void setPrimaryColors(int... r2) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.setPrimaryColors(r2);
        return;
    L8:
        return;
    }

    public int e(SmartRefreshLayout r2, boolean r3) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 != this) goto L6;
        return 0;
    L6:
        return r0.e(r2, r3);
    L7:
        return 0;
    }

    public b(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void d(float r2, int r3, int r4) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.d(r2, r3, r4);
        return;
    L8:
        return;
    }

    public void i(i r3, RefreshState r4, RefreshState r5) {
        g r0 = this.c;
        if (r0 == null) goto L29;
        if (r0 != this) goto L6;
        return;
    L6:
        if ((this instanceof o6a.b) == false) goto L16;
        if ((r0 instanceof f) == false) goto L16;
        if (r4.isFooter == false) goto L13;
        r4 = r4.toHeader();
    L13:
        if (r5.isFooter == false) goto L25;
        r5 = r5.toHeader();
    L25:
        g r1 = this.c;
        if (r1 == null) goto L31;
        r1.i(r3, r4, r5);
        return;
    L31:
        return;
    L16:
        if ((this instanceof o6a.c) == false) goto L25;
        if ((r0 instanceof e) == false) goto L25;
        if (r4.isHeader == false) goto L23;
        r4 = r4.toFooter();
    L23:
        if (r5.isHeader == false) goto L25;
        r5 = r5.toFooter();
        goto L25
    }

    public void j(SmartRefreshLayout.i r2, int r3, int r4) {
        g r0 = this.c;
        if (r0 == null) goto L6;
        if (r0 == this) goto L6;
        r0.j(r2, r3, r4);
        return;
    L6:
        View r5 = this.a;
        if (r5 == null) goto L13;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof SmartRefreshLayout.LayoutParams) == false) goto L14;
        r2.c(this, ((SmartRefreshLayout.LayoutParams) r6).a);
        return;
    L14:
        return;
    }

    public void k(i r2, int r3, int r4) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.k(r2, r3, r4);
        return;
    L8:
        return;
    }

    public void n(i r2, int r3, int r4) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.n(r2, r3, r4);
        return;
    L8:
        return;
    }

    public void b(boolean r7, float r8, int r9, int r10, int r11) {
        g r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.b(r7, r8, r9, r10, r11);
        return;
    L8:
        return;
    }
}
