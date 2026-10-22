package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j2 implements DialogInterface.OnDismissListener {
    public static final j2 a = null;

    static {
        a = new j2();
    }

    public j2() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        ALogger.d("VSScheduleCloseWidget", "dismiss shadow dialog, start to PlayNext or goNextFeed");
        List<i2.a> r3 = i2.a;
    }
}
