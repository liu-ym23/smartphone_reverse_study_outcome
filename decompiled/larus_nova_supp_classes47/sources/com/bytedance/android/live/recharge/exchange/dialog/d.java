package com.bytedance.android.live.recharge.exchange.dialog;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements DialogInterface.OnDismissListener {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.a = null;
    }
}
