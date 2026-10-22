package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements DialogInterface.OnDismissListener {
    public final /* synthetic */ OPPluginMoreDialog a;

    public q(OPPluginMoreDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.F.k.g(null);
    }
}
