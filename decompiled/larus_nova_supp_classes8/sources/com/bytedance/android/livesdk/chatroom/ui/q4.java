package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q4 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AbsInteractionFragment a;

    public q4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        com.bytedance.android.livesdk.f.d().f();
        DataCenter r4 = this.a.W;
        if (r4 == null) goto L6;
        r4.put("cmd_start_count_authorization", Boolean.TRUE);
        return;
    }
}
