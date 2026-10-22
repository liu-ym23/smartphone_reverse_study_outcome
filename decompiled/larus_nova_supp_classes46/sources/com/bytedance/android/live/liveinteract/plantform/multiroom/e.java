package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(DataCenter r1) {
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        return (a) r1.get("data_mic_seat_data_service");
    }

    public static ih0.b b(DataCenter r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (ih0.b) r1.get("data_multi_link_dynamic_widget_service");
    }

    public static com.bytedance.android.live.liveinteract.bgComponent.platform.a c(DataCenter r1) {
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        return (com.bytedance.android.live.liveinteract.bgComponent.platform.a) r1.get("data_multi_link_theme_bg_service");
    }

    public static l d(DataCenter r1) {
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        return (l) r1.get("data_multi_link_ui_service");
    }

    public static void e(DataCenter r1, ih0.b r2, WidgetManager r3) {
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        r1.put("data_multi_link_dynamic_widget_service", r2);
        if (r3 == null) goto L6;
        r1.put("data_multi_link_dynamic_widget_manager", r3);
        return;
    }
}
