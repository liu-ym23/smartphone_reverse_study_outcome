package com.larksuite.component.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIDialog extends UDDialog {
    public static final /* synthetic */ int c = 0;
    public View a;
    public Activity b;

    /* JADX WARN: Multi-variable type inference failed */
    public void cancel() {
        super/*android.app.Dialog*/.cancel();
        Activity r0 = this.b;
        if (r0 == null) goto L6;
        r0.finish();
        this.b = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.dialog.UDDialog
    public void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Activity r1 = this.b;
        if (r1 == null) goto L26;
        r1.finish();
        this.b = null;
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public LKUIDialog(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.dialog.UDDialog
    public void onCreate(Bundle r3) {
        getWindow().setSoftInputMode(19);
        super.onCreate(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentView(int r3) {
        setContentView(LayoutInflater.from(getContext()).inflate(r3, null));
    }

    public final void setContentView(View r1) {
        this.a = r1;
        super.setContentView(r1);
    }

    public LKUIDialog(Context r1, int r2) {
        super(r1, r2);
    }
}
