package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 extends Dialog {
    public final float a;
    public final boolean b;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        requestWindowFeature(1);
        if (this.b == false) goto L5;
        setContentView(2131561767);
    L6:
        Window r7 = getWindow();
        if (r7 == null) goto L9;
        WindowManager.LayoutParams r0 = r7.getAttributes();
    L10:
        if (r0 == null) goto L13;
        r0.width = -1;
        r0.height = -1;
        r0.gravity = 17;
    L13:
        if (r7 == null) goto L21;
        View r1 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L19:
        if (r1 == null) goto L21;
        r1.setPadding(0, 0, 0, 0);
    L21:
        if (r7 == null) goto L23;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L23:
        if (r7 == null) goto L25;
        r7.addFlags(Integer.MIN_VALUE);
    L25:
        if (r7 == null) goto L27;
        r7.setStatusBarColor(0);
    L27:
        if (r7 == null) goto L29;
        r7.setNavigationBarColor(0);
    L29:
        if (r7 == null) goto L32;
        r7.setDimAmount(this.a);
        return;
    L32:
        return;
    L9:
        r0 = null;
        goto L10
    L5:
        setContentView(2131561766);
        goto L6
    }

    public l0(Context r2, float r3, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0.2f;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(v19.f.d(r2));
        this.a = r3;
        this.b = r4;
        setCancelable(false);
    }
}
