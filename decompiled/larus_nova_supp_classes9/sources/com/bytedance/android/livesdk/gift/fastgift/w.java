package com.bytedance.android.livesdk.gift.fastgift;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.RecommendFastGiftConfirmView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ RecommendFastGiftConfirmView b;

    public w(FastGiftViewV3 r1, RecommendFastGiftConfirmView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        a.g("cancel", this.b.getIsChecked());
        Dialog r5 = this.a.m;
        if (r5 == null) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r5));
        return;
    }
}
