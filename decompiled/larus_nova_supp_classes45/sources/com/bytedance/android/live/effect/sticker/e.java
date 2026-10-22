package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends j {
    public final String a;

    public final void m() {
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "LiveSmallItemBeautyFragment show error");
        LiveSlardarMonitor.monitorStatus(this.a, 3, r0);
    }

    public e(String r3) {
        this.a = ("ttlive_load_" + r3 + "_list") + "_error";
    }

    public final void l(String r3) {
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r3);
        LiveSlardarMonitor.monitorStatus(this.a, 2, r0);
    }
}
