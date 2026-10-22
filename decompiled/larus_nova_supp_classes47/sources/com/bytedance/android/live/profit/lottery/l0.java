package com.bytedance.android.live.profit.lottery;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 implements is2.b, com.bytedance.android.scope.o {
    public l0() {
    }

    public final /* synthetic */ boolean a() {
        return false;
    }

    public final /* synthetic */ boolean c() {
        return false;
    }

    public final void d() {
    }

    public final /* synthetic */ boolean f() {
        return false;
    }

    public final String getPath() {
        return "webcast_lottery_melon_lottery_info";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        return ((a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue()).f();
    }

    public final Class<?> getModelClass() {
        return f.class;
    }

    public final JSONObject g(Bundle r2, is2.a r3) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "open", true);
        BaseMonitor.add(r4, "biz_data_type", 2);
        return r4;
    }
}
