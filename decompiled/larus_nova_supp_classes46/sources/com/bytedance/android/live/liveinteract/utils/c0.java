package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ IBanUser c;

    public c0(o5 r1, Context r2, IBanUser r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = this.c.getUrl();
        if (r5 == null) goto L25;
        u30.b r6 = jc1.k.n(IBaseBrowserService.class).buildFullScreenWebPage(this.b, r5);
        Resources r0 = this.b.getResources();
        if (r0 == null) goto L7;
        String r1 = r0.getString(2131915260);
    L8:
        u30.a r7 = r6.setTitle(r1);
        r7.b = true;
        r7.b();
        o5 r8 = this.a;
        Handler r2 = DialogLancet.resolveDialogHandler(r8);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r8);
        return;
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(r8));
        return;
    L7:
        r1 = null;
        goto L8
    }
}
