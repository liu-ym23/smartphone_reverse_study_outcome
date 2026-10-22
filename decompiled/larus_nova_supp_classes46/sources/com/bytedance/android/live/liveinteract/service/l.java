package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ DataCenter a;

    public l(DataCenter r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        r2.dismiss();
        DataCenter r4 = this.a;
        if (r4 == null) goto L5;
        r4.put("data_room_video_talk_log_over_for_over_path", "chat_close_icon");
    L5:
        rj0.k.m2.getClass();
        rj0.k r5 = rj0.k.a.a();
        if (r5 == null) goto L9;
        rj0.k.b.a(r5);
        return;
    }
}
