package com.bytedance.android.livesdk.coupon.customview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.coupon.UgCouponWidget;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ s a;
    public final /* synthetic */ s.a b;

    public p(s r1, com.bytedance.android.livesdk.coupon.f r2, com.bytedance.android.livesdk.coupon.b.c r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        s r5 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        com.bytedance.android.livesdk.coupon.f r6 = (com.bytedance.android.livesdk.coupon.f) this.b;
        r6.getClass();
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r6.a.schema) == true) goto L34;
        Context r2 = ((Widget) r6.c).context;
        if (r2 == null) goto L35;
        r1.handleSchema(r2, UriProtector.parse(r6.a.schema));
        UgCouponWidget.wq(r6.c, r6.a, "go_and_see");
        return;
    L35:
        return;
    L34:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }
}
