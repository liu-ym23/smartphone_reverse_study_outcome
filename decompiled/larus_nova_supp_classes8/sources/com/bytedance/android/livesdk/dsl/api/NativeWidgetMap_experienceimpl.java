package com.bytedance.android.livesdk.dsl.api;

import com.bytedance.android.live.draggablecomponent.DraggableComponentServiceWidget;
import com.bytedance.android.live.room.discovery.AnchorPerfMonitorWidget;
import com.bytedance.android.live.room.discovery.LiveAnchorTogetherWidget;
import com.bytedance.android.live.room.discovery.LiveHashtagWidget;
import com.bytedance.android.live.room.discovery.LiveHotSpotWidget;
import com.bytedance.android.live.room.discovery.LiveSceneWidget;
import com.bytedance.android.live.room.discovery.NetSpeedMonitorWidget;
import com.bytedance.android.live.room.discovery.TopLeftActivityBannerWidget;
import com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceWidget;
import com.bytedance.android.live.room.discovery.drawer.VSRoomLandscapeLiveDrawerEntranceWidget;
import com.bytedance.android.live.room.discovery.drawer.template.LiveDrawerEntranceCommonWidget;
import com.bytedance.android.live.room.discovery.inspector.OfficialInspectorWidget;
import com.bytedance.android.live.tetris.ExpPushServiceWidget;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeWidgetMap_experienceimpl {
    public NativeWidgetMap_experienceimpl() {
    }

    public static Map<String, Class> collectWidgetClassMap() {
        HashMap r0 = new HashMap();
        r0.put("DraggableComponentServiceWidget", DraggableComponentServiceWidget.class);
        r0.put("AnchorPerfMonitorWidget", AnchorPerfMonitorWidget.class);
        r0.put("LiveAnchorTogetherWidget", LiveAnchorTogetherWidget.class);
        r0.put("LiveHashtagWidget", LiveHashtagWidget.class);
        r0.put("LiveHotSpotWidget", LiveHotSpotWidget.class);
        r0.put("LiveSceneWidget", LiveSceneWidget.class);
        r0.put("NetSpeedMonitorWidget", NetSpeedMonitorWidget.class);
        r0.put("TopLeftActivityBannerWidget", TopLeftActivityBannerWidget.class);
        r0.put("NewLiveDrawerEntranceWidget", NewLiveDrawerEntranceWidget.class);
        r0.put("VSRoomLandscapeLiveDrawerEntranceWidget", VSRoomLandscapeLiveDrawerEntranceWidget.class);
        r0.put("LiveDrawerEntranceCommonWidget", LiveDrawerEntranceCommonWidget.class);
        r0.put("OfficialInspectorWidget", OfficialInspectorWidget.class);
        r0.put("ExpPushServiceWidget", ExpPushServiceWidget.class);
        return r0;
    }
}
