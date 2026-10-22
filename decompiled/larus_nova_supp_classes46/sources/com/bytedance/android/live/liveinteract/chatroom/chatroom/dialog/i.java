package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public i(m r1, int r2, int r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        m r0 = this.a;
        int r3 = this.b;
        r0.p = r3;
        TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.c;
        long r4 = this.d;
        String r6 = ((ExtraResponse) r8).logId;
        r1.getClass();
        TalkRoomBusinessFullLinkMonitor.X(r2, r3, r4, r6);
        com.bytedance.android.livesdk.common.b r9 = this.a;
        Handler r5 = DialogLancet.resolveDialogHandler(r9);
        if (r5 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r9);
        r9.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r9);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r7 == null) goto L16;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r9);
        throw th;
    L5:
        if (Looper.myLooper() == r5.getLooper()) goto L7;
        r5.post(DialogLancet.createDismissRunnable(r9));
    }
}
