package com.bytedance.android.live.liveinteract.plantform.utils;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static void a(Context r3, int r4) {
        boolean r5 = ((AudioManager) r3.getSystemService("audio")).isWiredHeadsetOn();
        HashMap r0 = new HashMap();
        Room r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r1 == null) goto L5;
        r0.put("room_id", r1.getIdStr());
    L5:
        LiveSlardarMonitor.monitorStatus("ttlive_linkmic_wireheadset_state", (r4 * 10) + (r5 ? 1 : 0), r0);
    }
}
