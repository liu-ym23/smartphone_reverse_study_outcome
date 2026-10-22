package com.obric.assistant.privacy.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u extends Dialog {
    public TextView a;
    public TextView b;
    public TextView c;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        cancel();
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public u(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        requestWindowFeature(1);
        setContentView(2131564052);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setBackgroundDrawableResource(2131244584);
        r4.setLayout(-1, -2);
        r4.setGravity(17);
        r4.setWindowAnimations(2131954465);
    L5:
        setCanceledOnTouchOutside(false);
        this.b = (TextView) findViewById(2131390018);
        this.a = (TextView) findViewById(2131364619);
        this.c = (TextView) findViewById(2131390019);
        TextView r5 = this.a;
        if (r5 == null) goto L8;
        r5.setText(getContext().getResources().getString(2131912604));
    L8:
        TextView r6 = this.c;
        if (r6 == null) goto L11;
        r6.setText(getContext().getResources().getString(2131914180));
    L11:
        e1.d(this.b, new s(this));
        TextView r7 = this.a;
        if (r7 == null) goto L15;
        e1.b(r7, new t(this));
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r4) {
        super.onWindowFocusChanged(r4);
        Window r0 = getWindow();
        if (r4 == false) goto L16;
        if (r0 == null) goto L17;
        View r5 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        if (r5.getHeight() != 0) goto L13;
    L14:
        r5.requestLayout();
        return;
    L13:
        if (r5.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }
}
