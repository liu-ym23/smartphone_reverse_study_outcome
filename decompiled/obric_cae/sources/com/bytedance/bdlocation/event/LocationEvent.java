package com.bytedance.bdlocation.event;

import com.bytedance.bdlocation.client.BDLocationConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationEvent {
    private static IEventManager sEventManager;

    public LocationEvent() {
    }

    private static void onEventV3(String r8) {
        onEventV3(r8, null);
    }

    public static void onRequestPermission() {
        onEventV3(LocationEventConst.EVENT_WHEN_IN_USE);
    }

    private static void onEventV3(String r8, JSONObject r10) {
        if (sEventManager != null) goto L5;
        sEventManager = BDLocationConfig.getEventManager();
    L5:
        IEventManager r11 = sEventManager;
        if (r11 == null) goto L9;
        r11.onEventV3(r8, r10);
        return;
    }
}
