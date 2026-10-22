package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveEndRemindWidget a;

    public y1(LiveEndRemindWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        LiveEndRemindWidget r4 = this.a;
        int r0 = LiveEndRemindWidget.d;
        r4.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight1_popup_click", "continue");
        r2.dismiss();
    }
}
