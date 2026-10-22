package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ long b;

    public k(m r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
        Intrinsics.checkNotNullParameter(r14, "response");
        com.bytedance.android.livesdk.common.b r0 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
    L17:
        m r2 = this.a;
        r2.o = false;
        TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
        long r4 = r2.s;
        long r5 = this.b;
        String r15 = r14.logId;
        r3.getClass();
        TalkRoomBusinessFullLinkMonitor.E0(r4, r5, r15);
        com.bytedance.android.live.liveinteract.plantform.utils.x.N(true, this.a.s, System.currentTimeMillis() - this.b, null);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r6 == null) goto L16;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L17
    }
}
