package com.larus.avlink.update;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends Dialog {
    public final i a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;

    public static final class a {
    }

    static {
    }

    public static void a(c r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        boolean r6 = true;
        requestWindowFeature(1);
        setContentView(2131563331);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setLayout(-1, -2);
        r0.setGravity(17);
    L5:
        setCanceledOnTouchOutside(false);
        this.g = (TextView) findViewById(2131390020);
        this.e = (TextView) findViewById(2131390018);
        this.d = (TextView) findViewById(2131364619);
        this.f = (TextView) findViewById(2131390019);
        e1.d(this.e, new com.larus.avlink.update.a(this));
        TextView r1 = this.d;
        if (r1 == null) goto L8;
        e1.d(r1, new b(this));
    L8:
        TextView r2 = this.g;
        if (r2 == null) goto L12;
        r2.setText(getContext().getResources().getString(2131910892));
    L12:
        if (TextUtils.isEmpty(this.a.a) == true) goto L16;
        TextView r3 = this.g;
        if (r3 == null) goto L16;
        r3.setText(this.a.a);
    L16:
        TextView r4 = this.d;
        if (r4 == null) goto L20;
        r4.setText(getContext().getResources().getString(2131910885));
    L20:
        if (TextUtils.isEmpty(this.a.d) == true) goto L24;
        TextView r7 = this.d;
        if (r7 == null) goto L24;
        r7.setText(this.a.d);
    L24:
        TextView r8 = this.e;
        if (r8 == null) goto L28;
        r8.setText(getContext().getResources().getString(2131910890));
    L28:
        if (TextUtils.isEmpty(this.a.c) == true) goto L32;
        TextView r9 = this.e;
        if (r9 == null) goto L32;
        r9.setText(this.a.c);
    L32:
        String r10 = this.a.b;
        if (r10 != null) goto L35;
    L38:
        if (r6 == true) goto L45;
        TextView r11 = this.f;
        if (r11 == null) goto L44;
        r11.setText(r10);
        return;
    L44:
        return;
    L45:
        return;
    L35:
        if (r10.length() == 0) goto L38;
        r6 = false;
        goto L38
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
        Logger.d("CheckUpdateDialog", "relayout");
        return;
    L13:
        if (r5.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public c(Context r2, i r3, e r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, "cxt");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "cancelClick");
        Intrinsics.checkNotNullParameter(r5, "confirmClick");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
