package com.bytedance.android.livesdk.dsl.api;

import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsWidget;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.CommonMergeAnchorInfoWidget;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.MediaAnchorInfoWidget;
import com.bytedance.android.live.componentsmarket.impl.components.titledetail.LiveTitleDetailWidget;
import com.bytedance.android.live.componentsmarket.impl.components.userlist.RoomCountWidget;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeWidgetMap_livecomponentsmarketimpl {
    public NativeWidgetMap_livecomponentsmarketimpl() {
    }

    public static Map<String, Class> collectWidgetClassMap() {
        HashMap r0 = new HashMap();
        r0.put("BaseComponentsWidget", BaseComponentsWidget.class);
        r0.put("CommonMergeAnchorInfoWidget", CommonMergeAnchorInfoWidget.class);
        r0.put("MediaAnchorInfoWidget", MediaAnchorInfoWidget.class);
        r0.put("LiveTitleDetailWidget", LiveTitleDetailWidget.class);
        r0.put("RoomCountWidget", RoomCountWidget.class);
        return r0;
    }
}
