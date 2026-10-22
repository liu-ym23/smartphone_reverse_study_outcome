package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q2<T> implements Observer {
    public final /* synthetic */ p2 a;

    public q2(p2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        ALogger.w("ClearScreenWaterTetris", "called link state observer from ToolbarClearScreenBehavior. state: " + r4);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.intValue() != 2) goto L9;
        this.a.getClass();
        return;
    }
}
