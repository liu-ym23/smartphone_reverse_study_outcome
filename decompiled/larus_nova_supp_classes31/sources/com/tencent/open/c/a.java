package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class a extends RelativeLayout {
    private static final String a = null;
    private Rect b;
    private boolean c;
    private InterfaceC0052a d;

    /* JADX INFO: renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0052a {
        void a();

        void a(int r1);
    }

    static {
        a = a.class.getName();
    }

    public a(Context r2) {
        super(r2);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    public static View INVOKEVIRTUAL_com_tencent_open_c_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public void a(InterfaceC0052a r1) {
        this.d = r1;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r6);
        Activity r1 = (Activity) getContext();
        INVOKEVIRTUAL_com_tencent_open_c_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getWindowVisibleDisplayFrame(this.b);
        int r2 = this.b.top;
        int r3 = (r1.getWindowManager().getDefaultDisplay().getHeight() - r2) - r0;
        InterfaceC0052a r4 = this.d;
        if (r4 == null) goto L9;
        if (r0 == 0) goto L9;
        if (r3 <= 100) goto L8;
        r4.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
        goto L9
    L8:
        r4.a();
    L9:
        super.onMeasure(r5, r6);
    }
}
