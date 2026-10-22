package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.message.model.kj;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveEndRemindWidget a;
    public final /* synthetic */ int b;

    public v1(LiveEndRemindWidget r1, int r2, kj r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (13 != this.b) goto L5;
        LiveEndRemindWidget r4 = this.a;
        int r0 = LiveEndRemindWidget.d;
        r4.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight2_popup_click", null);
    L5:
        r2.dismiss();
        LiveEndRemindWidget.xq(this.a);
    }
}
