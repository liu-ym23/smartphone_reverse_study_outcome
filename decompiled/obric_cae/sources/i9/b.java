package i9;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.search.SearchBar;
import j0.h0;
import j0.m0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends c<View> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f8293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8295f;

    public b() {
        this.f8292c = new Rect();
        this.f8293d = new Rect();
        this.f8294e = 0;
    }

    @Override // i9.c
    public final void A(CoordinatorLayout r16, View r17, int r18) {
        View r8 = C(r16.e(r17));
        int r10 = 0;
        if (r8 == null) goto L19;
        CoordinatorLayout.f r11 = (CoordinatorLayout.f) r17.getLayoutParams();
        int r12 = r16.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        int r13 = r8.getBottom() + ((ViewGroup.MarginLayoutParams) r11).topMargin;
        int r14 = (r16.getWidth() - r16.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        int r15 = ((r8.getBottom() + r16.getHeight()) - r16.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        Rect r19 = this.f8292c;
        r19.set(r12, r13, r14, r15);
        m0 r20 = r16.getLastWindowInsets();
        if (r20 == null) goto L11;
        WeakHashMap<View, h0> r21 = w.f8437a;
        if (w.d.b(r16) == false) goto L11;
        if (w.d.b(r17) == true) goto L11;
        r19.left = r20.c() + r19.left;
        r19.right -= r20.d();
    L11:
        Rect r22 = this.f8293d;
        int r23 = r11.f1565c;
        if (r23 != 0) goto L14;
        r23 = 8388659;
    L14:
        j0.d.a.b(r23, r17.getMeasuredWidth(), r17.getMeasuredHeight(), r19, r22, r18);
        if (this.f8295f == 0) goto L18;
        float r24 = D(r8);
        int r25 = this.f8295f;
        r10 = t2.b.p((int) (r24 * r25), 0, r25);
    L18:
        r17.layout(r22.left, r22.top - r10, r22.right, r22.bottom - r10);
        r10 = r22.top - r8.getBottom();
    L20:
        this.f8294e = r10;
        return;
    L19:
        r16.q(r17, r18);
        goto L20
    }

    public abstract View C(ArrayList r8);

    public float D(View r8) {
        return 1.0f;
    }

    public int E(View r8) {
        return r8.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean i(CoordinatorLayout r8, View r10, int r11, int r12, int r13) {
        int r14 = r10.getLayoutParams().height;
        if (r14 != (-1)) goto L5;
    L6:
        View r15 = C(r8.e(r10));
        if (r15 == null) goto L27;
        int r16 = View.MeasureSpec.getSize(r13);
        if (r16 <= 0) goto L15;
        WeakHashMap<View, h0> r17 = w.f8437a;
        if (w.d.b(r15) == false) goto L16;
        m0 r18 = r8.getLastWindowInsets();
        if (r18 == null) goto L16;
        r16 = r16 + (r18.b() + r18.e());
    L16:
        int r19 = E(r15) + r16;
        int r110 = r15.getMeasuredHeight();
        if ((this instanceof SearchBar.ScrollingViewBehavior) == false) goto L19;
        r10.setTranslationY(-r110);
    L20:
        if (r14 != (-1)) goto L22;
        int r20 = 1073741824;
    L23:
        r8.r(r10, r11, r12, View.MeasureSpec.makeMeasureSpec(r19, r20));
        return true;
    L22:
        r20 = Integer.MIN_VALUE;
        goto L23
    L19:
        r10.setTranslationY(0.0f);
        r19 = r19 - r110;
        goto L20
    L15:
        r16 = r8.getHeight();
        goto L16
    L27:
        return false;
    L5:
        if (r14 == (-2)) goto L6;
        return false;
    }

    public b(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f8292c = new Rect();
        this.f8293d = new Rect();
        this.f8294e = 0;
    }
}
