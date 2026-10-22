package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.AnimatorSet;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.RecommendFastGiftConfirmView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ RecommendFastGiftConfirmView b;

    public x(FastGiftViewV3 r1, RecommendFastGiftConfirmView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        boolean r5 = this.b.getIsChecked();
        a.g("confirm", r5);
        AnimatorSet r0 = this.a.u;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        AnimatorSet r1 = this.a.u;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        FastGiftViewV3 r2 = this.a;
        r2.u = null;
        r2.A.updateRecommendConfirmRecord(r5);
        this.a.A.sendGift(Boolean.TRUE);
        Dialog r6 = this.a.m;
        if (r6 == null) goto L27;
        Handler r3 = DialogLancet.resolveDialogHandler(r6);
        if (r3 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r7 == null) goto L24;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r3.getLooper()) goto L15;
        r3.post(DialogLancet.createDismissRunnable(r6));
        return;
    }
}
