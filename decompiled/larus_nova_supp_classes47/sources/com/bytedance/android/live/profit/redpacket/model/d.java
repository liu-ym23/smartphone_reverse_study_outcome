package com.bytedance.android.live.profit.redpacket.model;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.scope.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements is2.b, o {
    public d() {
    }

    public final /* synthetic */ boolean a() {
        return false;
    }

    public final boolean c() {
        return true;
    }

    public final void d() {
    }

    public final /* synthetic */ boolean f() {
        return false;
    }

    public final String getPath() {
        return "webcast_luckybox_box_list";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        if (((a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue()).g() == true) goto L5;
    L7:
        return false;
    L5:
        if (b0.b().b0() != 0) goto L7;
        return true;
    }

    public final Class<?> getModelClass() {
        return b.class;
    }

    public final JSONObject g(Bundle r2, is2.a r3) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "open", true);
        BaseMonitor.add(r4, "biz_data_type", 2);
        return r4;
    }
}
