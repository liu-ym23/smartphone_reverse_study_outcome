package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestApplyDialog;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ChatRoomGuestSettingDialog a;

    public b(ChatRoomGuestSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.e != 2) goto L9;
        InteractAudienceGuestApplyDialog r5 = new InteractAudienceGuestApplyDialog(this.a.getContext(), this.a.b);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r5);
    L10:
        CommonBottomDialog r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L13;
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
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r1 == null) goto L24;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r0.getLooper()) goto L15;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L8:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L10
    L9:
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r7 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        r7.e(this.a.getContext());
        r7.f(this.a.b);
        r7.g(this.a.c);
        String r2 = this.a.d;
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        r7.d = r2;
        r7.a().a();
        goto L10
    }
}
