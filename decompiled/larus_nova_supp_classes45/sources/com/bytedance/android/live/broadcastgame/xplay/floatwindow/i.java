package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.text.TextUtils;
import com.bytedance.android.livesdk.message.model.mk;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements l {
    public final /* synthetic */ XplayFloatWindowView.ViewHolder a;

    public i(XplayFloatWindowView.ViewHolder r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getMessageMethod();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.hashCode() == 654092662) goto L11;
        return;
    L11:
        if (r0.equals("WebcastRoomStatsMessage") == false) goto L24;
        XplayFloatWindowView.ViewHolder r1 = this.a;
        if (r1 == null) goto L25;
        String r2 = null;
        if ((r4 instanceof mk) == true) goto L17;
        r4 = null;
    L17:
        mk r5 = (mk) r4;
        if (r5 == null) goto L21;
        r2 = r5.getDisplayMiddle();
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L26;
        r1.h.setText(r2);
        return;
    L26:
        return;
    L25:
        return;
    }
}
