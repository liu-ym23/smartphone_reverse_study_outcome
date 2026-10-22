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
public final class m0 extends Dialog {
    public m0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(v19.f.d(r2));
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        requestWindowFeature(1);
        setContentView(2131561766);
        Window r7 = getWindow();
        if (r7 == null) goto L5;
        WindowManager.LayoutParams r0 = r7.getAttributes();
    L6:
        if (r0 == null) goto L9;
        r0.width = -1;
        r0.height = -1;
        r0.gravity = 17;
    L9:
        if (r7 == null) goto L17;
        View r1 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L15;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L15:
        if (r1 == null) goto L17;
        r1.setPadding(0, 0, 0, 0);
    L17:
        if (r7 == null) goto L19;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        if (r7 == null) goto L21;
        r7.addFlags(Integer.MIN_VALUE);
    L21:
        if (r7 == null) goto L23;
        r7.setStatusBarColor(0);
    L23:
        if (r7 == null) goto L25;
        r7.setNavigationBarColor(0);
    L25:
        com.larus.utils.e1.q(findViewById(2131373867));
        com.larus.utils.e1.q(findViewById(2131379051));
        findViewById(2131368934).setBackgroundColor(0);
        if (r7 == null) goto L29;
        r7.setDimAmount(0.0f);
        return;
    L29:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
