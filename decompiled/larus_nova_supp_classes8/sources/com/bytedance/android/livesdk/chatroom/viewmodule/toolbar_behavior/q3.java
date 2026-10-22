package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;

    public q3(Context r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        puc.a.runApplication(this.a, "com.ss.android.ugc.aweme", null);
        r3.cancel();
    }
}
