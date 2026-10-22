package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.xa1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g2 {
    public static final boolean a(Room r11, DataCenter r12) {
        Integer r0 = xa1.a.getValue();
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 1, do preload without check");
        return true;
    L10:
        if (r0 != null) goto L13;
    L53:
        return false;
    L13:
        if (r0.intValue() != 2) goto L53;
        int r1 = 7;
        if (r11 == null) goto L20;
        Map r5 = r11.getLinkMap();
        if (r5 == null) goto L20;
        if (r5.containsKey(String.valueOf(1)) != true) goto L20;
    L25:
        if (r12 == null) goto L52;
        h2 r13 = (h2) r12.get("DATA_MULTI_REVENUE_PRELOAD_INFO", null);
        if (r13 == null) goto L52;
        if (r11.getRoomId() == r13.a) goto L33;
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 2, refuse preload for invalid roomID,  preload: " + r13.a + " current: " + r11.getRoomId());
        return false;
    L33:
        Map r6 = r11.getLinkMap();
        if (r6 == null) goto L50;
        long r7 = r13.c;
        if (r7 != 2) goto L39;
        r1 = 1;
    L42:
        Long r2 = (Long) r6.get(String.valueOf(r1));
        if (r2 == null) goto L50;
        long r4 = r2.longValue();
        if (r4 == r13.b) goto L48;
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 2, refuse preload for invalid channelID: " + r4 + ", preloadInfo: " + r13);
        return false;
    L48:
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 2, and preload for " + r13);
        return true;
    L39:
        if (r7 == 6) goto L42;
        r1 = 0;
    L50:
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 2, refuse preload for linkMap not contains sei version linkmap: " + r11.getLinkMap() + ", preloadInfo: " + r13 + ' ');
        return false;
    L52:
        ALogger.e("MultiLinkPreloadWidget", "preloadSetting = 2, refuse preload for null preloadInfo");
    L20:
        if (r11 == null) goto L53;
        Map r8 = r11.getLinkMap();
        if (r8 == null) goto L53;
        if (r8.containsKey(String.valueOf(7)) != true) goto L53;
        goto L25
    }
}
