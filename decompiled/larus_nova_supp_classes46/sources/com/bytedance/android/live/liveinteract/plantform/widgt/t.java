package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.os.Handler;
import android.os.Looper;
import android.widget.RadioButton;
import com.bytedance.android.live.core.setting.b6;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements lm3.c.a {
    public final /* synthetic */ RadioButton b;

    public t(RadioButton r1) {
        this.b = r1;
    }

    public final void onAction(lm3.d r4) {
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.a;
        Boolean r1 = Boolean.valueOf(!this.b.isChecked());
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        xs2.b.a().post(new h1(58));
        Handler r2 = DialogLancet.resolveDialogHandler(r4);
        if (r2 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r4);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r2.getLooper()) goto L7;
        r2.post(DialogLancet.createDismissRunnable(r4));
    }
}
