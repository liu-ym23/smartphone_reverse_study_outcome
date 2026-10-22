package com.ss.android.lark.forwardv3.utils;

import android.content.DialogInterface;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.forwardv3.ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ForwardDialogContentLifecycleOwner a;
    public final /* synthetic */ qib.a b;

    public i(ForwardDialogContentLifecycleOwner r1, ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        ForwardDialogContentLifecycleOwner r4 = this.a;
        if (r4 == null) goto L7;
        Lifecycle.State r0 = r4.a.getCurrentState();
        Lifecycle.State r1 = Lifecycle.State.DESTROYED;
        if (r0 == r1) goto L7;
        r4.a.setCurrentState(r1);
    L7:
        this.b.onDismissForward();
    }
}
