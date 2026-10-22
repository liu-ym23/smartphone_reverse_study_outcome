package i1;

import android.graphics.Rect;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import j0.m0;
import j0.q;
import j0.w;

/* JADX INFO: loaded from: classes.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f8086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPager f8087b;

    public b(ViewPager r8) {
        this.f8087b = r8;
        this.f8086a = new Rect();
    }

    @Override // j0.q
    public final m0 a(View r8, m0 r10) {
        m0 r11 = w.j(r8, r10);
        if (r11.f8409a.m() == false) goto L5;
        return r11;
    L5:
        int r12 = r11.c();
        Rect r13 = this.f8086a;
        r13.left = r12;
        r13.top = r11.e();
        r13.right = r11.d();
        r13.bottom = r11.b();
        ViewPager r14 = this.f8087b;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L8;
        m0 r17 = w.b(r14.getChildAt(r16), r11);
        r13.left = Math.min(r17.c(), r13.left);
        r13.top = Math.min(r17.e(), r13.top);
        r13.right = Math.min(r17.d(), r13.right);
        r13.bottom = Math.min(r17.b(), r13.bottom);
        r16 = r16 + 1;
        goto L6
    L8:
        int r18 = r13.left;
        int r19 = r13.top;
        int r20 = r13.right;
        int r21 = r13.bottom;
        m0.b r22 = new m0.b(r11);
        a0.b r23 = a0.b.b(r18, r19, r20, r21);
        r22.f8414a.d(r23);
        return r22.a();
    }
}
