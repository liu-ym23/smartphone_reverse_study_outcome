package com.larus.dora.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0 implements DialogInterface.OnDismissListener {
    public a0() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        DoraPreWakeUpTask.o = null;
    }
}
