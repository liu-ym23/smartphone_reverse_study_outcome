package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestSettingDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BaseDynamicEmojiDialog a;

    public c(BaseDynamicEmojiDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        int r8 = ChatRoomGuestSettingDialog.f;
        ChatRoomGuestSettingDialog.a.a();
        Context r1 = this.a.getContext();
        BaseDynamicEmojiDialog r0 = this.a;
        ChatRoomGuestSettingDialog r9 = new ChatRoomGuestSettingDialog(r1, r0.D, r0.E, r0.u, 1);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r9);
    L7:
        ?? r10 = this.a;
        Handler r2 = DialogLancet.resolveDialogHandler(r10);
        if (r2 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r3 == null) goto L21;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r2.getLooper()) goto L12;
        r2.post(DialogLancet.createDismissRunnable(r10));
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L6:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L7
    }
}
