package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5129b;
    private ImmersionBar c;
    private Activity d;
    private Window e;
    private View f;
    private View g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;

    c(ImmersionBar r3, Activity r4, Window r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.c = r3;
        this.d = ZeusTransformUtils.wrapperContext2Activity(r6, "com.obric.memorydata.plugin");
        this.e = r5;
        View r7 = r5.getDecorView();
        this.f = r7;
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r7.findViewById(R.id.content), FrameLayout.class, "com.obric.memorydata.plugin");
        View r9 = r8.getChildAt(0);
        this.h = r9;
        if (r9 != null) goto L5;
    L10:
        View r10 = this.h;
        View r11 = r8;
        if (r10 == null) goto L13;
        r11 = r10;
    L13:
        this.g = r11;
        a r12 = new a(this.d);
        this.f5128a = r12.b();
        this.f5129b = r12.c();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r9, DrawerLayout.class) == false) goto L7;
        this.h = ((DrawerLayout) ZeusTransformUtils.preCheckCast(this.h, DrawerLayout.class, "com.obric.memorydata.plugin")).getChildAt(0);
    L7:
        View r13 = this.h;
        if (r13 == null) goto L10;
        this.i = r13.getPaddingLeft();
        this.j = this.h.getPaddingTop();
        this.k = this.h.getPaddingRight();
        this.l = this.h.getPaddingBottom();
        goto L10
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.n == true) goto L7;
        return;
    L7:
        if (this.h == null) goto L9;
        View r0 = this.g;
        int r1 = this.i;
        int r2 = this.j;
        int r3 = this.k;
        int r4 = this.l;
    L10:
        r0.setPadding(r1, r2, r3, r4);
        return;
    L9:
        r0 = this.g;
        r1 = this.c.getPaddingLeft();
        r2 = this.c.getPaddingTop();
        r3 = this.c.getPaddingRight();
        r4 = this.c.getPaddingBottom();
        goto L10
    }

    void a(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        this.e.setSoftInputMode(r3);
        if (this.n == true) goto L9;
        this.f.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.n = true;
        return;
    L9:
        return;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.n == false) goto L9;
        this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.n = false;
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImmersionBar r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBarParams() != null) goto L7;
        return;
    L7:
        if (this.c.getBarParams().C == false) goto L42;
        int r1 = ImmersionBar.getNavigationBarHeight(this.d);
        Rect r2 = new Rect();
        this.f.getWindowVisibleDisplayFrame(r2);
        int r3 = this.g.getHeight() - r2.bottom;
        if (r3 == this.m) goto L43;
        this.m = r3;
        boolean r4 = true;
        int r5 = 0;
        if (ImmersionBar.checkFitsSystemWindows(this.e.getDecorView().findViewById(R.id.content)) == false) goto L13;
        r3 = r3 - r1;
        if (r3 > r1) goto L33;
        r4 = false;
    L33:
        if (r3 < 0) goto L37;
        r5 = r3;
    L37:
        if (this.c.getBarParams().I == null) goto L44;
        this.c.getBarParams().I.a(r4, r5);
        return;
    L44:
        return;
    L13:
        if (this.h != null) goto L15;
        int r6 = this.c.getPaddingBottom();
        r3 = r3 - r1;
        if (r3 <= r1) goto L27;
        r6 = r3 + r1;
    L28:
        this.g.setPadding(this.c.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), r6);
        goto L33
    L27:
        r4 = false;
        goto L28
    L15:
        if (this.c.getBarParams().B == false) goto L18;
        r3 = r3 + (this.f5129b + this.f5128a);
    L18:
        if (this.c.getBarParams().x == false) goto L20;
        r3 = r3 + this.f5128a;
    L20:
        if (r3 <= r1) goto L22;
        int r7 = this.l + r3;
    L23:
        this.g.setPadding(this.i, this.j, this.k, r7);
        goto L33
    L22:
        r7 = 0;
        r4 = false;
        goto L23
    L43:
        return;
    }
}
