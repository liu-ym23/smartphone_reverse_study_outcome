package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    public b(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.a.s.getUserPosition();
        long r5 = this.b;
        String r7 = ((com.bytedance.android.live.network.response.a) r9).logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.w0(r2, "", r5, r7);
        f2.b(2131919000, 0);
        com.bytedance.android.livesdk.common.b r10 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r10);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r10));
    }
}
