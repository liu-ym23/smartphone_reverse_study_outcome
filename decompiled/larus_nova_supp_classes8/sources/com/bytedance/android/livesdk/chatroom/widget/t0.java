package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0 implements View.OnClickListener {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L5;
        r6.getMediaReviewStatus().setValue(4);
    L5:
        com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
        HashMap r0 = new HashMap();
        r0.put("live_type", "media");
        Unit r1 = Unit.INSTANCE;
        r7.sendLog("livesdk_verifylive_action", r0, new Object[0]);
    }
}
