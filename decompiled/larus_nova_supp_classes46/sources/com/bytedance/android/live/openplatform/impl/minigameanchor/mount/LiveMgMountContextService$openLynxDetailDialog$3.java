package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveMgMountContextService$openLynxDetailDialog$3 extends b7.a {
    public final /* synthetic */ LiveMgMountContextService a;
    public final /* synthetic */ x0 b;
    public final /* synthetic */ Context c;

    public final void onLoadStart(View r3, boolean r4) {
        super.onLoadStart(r3, r4);
        x0 r5 = this.b;
        if (r5 == null) goto L21;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r5);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r7 == null) goto L18;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r6.getLooper()) goto L9;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L21:
        LiveMgMountContextService r8 = this.a;
        if (r8.e == false) goto L24;
        return;
    L24:
        int r9 = MiniGameLiveJsBridgeUtils.a;
        r8.autoDispose(MiniGameLiveJsBridgeUtils.a("live_launch_mg", new LiveMgMountContextService$openLynxDetailDialog$3$onLoadStart$1(this)));
        this.a.e = true;
    }

    public LiveMgMountContextService$openLynxDetailDialog$3(LiveMgMountContextService r1, x0 r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
