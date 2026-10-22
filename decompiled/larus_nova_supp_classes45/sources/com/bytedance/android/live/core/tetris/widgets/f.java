package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final /* synthetic */ int c = 0;
    public List<? extends e80.a> a;
    public final Widget b;

    public static final class a {
    }

    static {
    }

    public f(Widget r1) {
        this.b = r1;
    }

    public static void a(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put(NewBroadcastMonitor.STAGE.LIFECYCLE, r4);
        r0.put("error_type", "data_center_is_null");
        JSONObject r5 = new JSONObject();
        JSONObject r1 = new JSONObject();
        LiveTracingMonitor.f("ttlive_widget_error", LiveTracingMonitor.EventModule.INTERACTION_OPT, r0, r1, r5);
    }
}
