package by1;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.gift.model.z0;
import com.bytedance.android.scope.o;
import is2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements b, o {
    public a() {
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
        return "webcast_gift_group_show_users";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        return ((a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue()).d();
    }

    public final Class<?> getModelClass() {
        return z0.class;
    }

    public final JSONObject g(Bundle r2, is2.a r3) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "open", true);
        BaseMonitor.add(r4, "biz_data_type", "pb");
        BaseMonitor.add(r4, "source", 2);
        return r4;
    }
}
