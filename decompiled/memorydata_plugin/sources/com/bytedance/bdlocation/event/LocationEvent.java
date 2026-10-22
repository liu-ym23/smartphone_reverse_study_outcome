package com.bytedance.bdlocation.event;

import com.bytedance.bdlocation.client.BDLocationConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationEvent {
    private static IEventManager sEventManager;

    public LocationEvent() {
    }

    private static void onEventV3(String r1) {
        onEventV3(r1, null);
    }

    private static void onEventV3(String r1, JSONObject r2) {
        if (sEventManager != null) goto L5;
        sEventManager = BDLocationConfig.getEventManager();
    L5:
        IEventManager r0 = sEventManager;
        if (r0 == null) goto L9;
        r0.onEventV3(r1, r2);
        return;
    }

    public static void onRequestPermission() {
        onEventV3(LocationEventConst.EVENT_WHEN_IN_USE);
    }
}
