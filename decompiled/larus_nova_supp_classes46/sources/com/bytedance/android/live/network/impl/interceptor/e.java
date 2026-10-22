package com.bytedance.android.live.network.impl.interceptor;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements DialogInterface.OnClickListener {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_calm_period_popup_click", null, new Object[]{am2.x.class, Room.class});
        r4.dismiss();
    }
}
