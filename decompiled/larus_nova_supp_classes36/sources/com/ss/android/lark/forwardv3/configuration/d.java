package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements oib.c {
    public final /* synthetic */ ForwardConfirmDialogConfig a;

    @Override // oib.c
    public final void onCancelButtonClick() {
        RemoteOnForwardConfirmDialogListener r0 = this.a.g;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onCancelButtonClick();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onCancelButtonClick confirmDialogListener error: " + e, e);
    }

    @Override // oib.c
    public final void onDismissForward() {
        RemoteOnForwardConfirmDialogListener r0 = this.a.g;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onDismissForward();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onDismissForward confirmDialogListener error: " + e, e);
    }

    public d(ForwardConfirmDialogConfig r1) {
        this.a = r1;
    }

    @Override // oib.c
    public final void onConfirmButtonClick(String r2, String r3) {
        RemoteOnForwardConfirmDialogListener r0 = this.a.g;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onConfirmButtonClick(r2, r3);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onConfirmButtonClick confirmDialogListener error: " + e, e);
    }
}
