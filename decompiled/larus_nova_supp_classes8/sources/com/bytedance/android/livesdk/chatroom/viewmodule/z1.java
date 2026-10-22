package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.message.model.kj;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveEndRemindWidget a;

    public z1(LiveEndRemindWidget r1, kj r2) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        LiveEndRemindWidget r4 = this.a;
        int r0 = LiveEndRemindWidget.d;
        r4.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight1_popup_click", "close");
        LiveEndRemindWidget.xq(this.a);
        r2.dismiss();
    }
}
