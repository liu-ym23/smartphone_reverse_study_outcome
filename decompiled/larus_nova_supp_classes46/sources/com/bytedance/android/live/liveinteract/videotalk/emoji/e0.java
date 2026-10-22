package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ VoiceChatDynamicEmojiDialog a;

    public e0(VoiceChatDynamicEmojiDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.VoiceChatDynamicEmojiDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (this.a.findViewById(2131382836).isSelected() == false) goto L7;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r6 = IVoiceChatGuestService.a.a();
        if (r6 == null) goto L10;
        IVoiceChatGuestService.b.a(r6, null, 7);
    L10:
        ?? r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
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
        r0.post(DialogLancet.createDismissRunnable(r7));
        return;
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r8 = IVoiceChatGuestService.a.a();
        if (r8 == null) goto L10;
        r8.checkAndApply(-1, String.valueOf(109), LinkApplyType.NORMAL.getValue(), "from_emoji_panel");
        goto L10
    }
}
