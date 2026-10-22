package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ GiftMessageService a;

    public q1(GiftMessageService r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        GiftMessageService r3 = this.a;
        r3.p = 1;
        r3.a();
    }
}
