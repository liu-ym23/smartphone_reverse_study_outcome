package com.ss.android.lark.feed.shared.page.binder2;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements FeedListAdapter.e {
    public final /* synthetic */ FeedCommonViewHolder a;

    public h(FeedCommonViewHolder r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter.e
    public final void a() {
        UDDialog r0 = this.a.E;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }
}
