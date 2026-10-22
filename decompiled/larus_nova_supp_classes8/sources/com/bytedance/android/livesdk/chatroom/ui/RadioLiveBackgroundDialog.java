package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RadioLiveBackgroundDialog extends CommonBottomDialog implements View.OnClickListener {
    public final int getLayoutId() {
        return 2131565613;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = r3.getId();
        if (r4 != 2131383609) goto L5;
        throw null;
    L5:
        if (r4 == 2131383610) goto L24;
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r5.getLooper()) goto L11;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    L24:
        throw null;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        findViewById(2131383609).setOnClickListener(this);
        findViewById(2131383610).setOnClickListener(this);
        findViewById(2131383608).setOnClickListener(this);
    }
}
