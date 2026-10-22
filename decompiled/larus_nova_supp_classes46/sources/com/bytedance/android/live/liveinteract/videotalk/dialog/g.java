package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ long b;

    public g(n r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.a r10 = (com.bytedance.android.live.network.response.a) r9;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        ILinkPlayerInfoBridge r1 = this.a.C;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getUserPosition());
    L6:
        Intrinsics.checkNotNull(r2);
        long r3 = r2.intValue();
        long r5 = this.b;
        String r7 = r10.logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.w0(r3, "", r5, r7);
        f2.b(2131919000, 0);
        com.bytedance.android.livesdk.common.b r11 = this.a;
        Handler r4 = DialogLancet.resolveDialogHandler(r11);
        if (r4 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r11);
        r11.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r11);
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r11);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r4.getLooper()) goto L11;
        r4.post(DialogLancet.createDismissRunnable(r11));
        return;
    L5:
        r2 = null;
        goto L6
    }
}
