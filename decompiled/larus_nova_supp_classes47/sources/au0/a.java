package au0;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.profit.dress.i;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements is2.b, o {
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
        return "/webcast/dress/list/";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        return ((a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue()).c();
    }

    public final Class<?> getModelClass() {
        return b.class;
    }

    public final JSONObject g(Bundle r2, is2.a r3) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "open", true);
        BaseMonitor.add(r4, "biz_data_type", 1);
        iz0.a r5 = i.a;
        BaseMonitor.add(r4, Constants.Keys.VERSION, i.c);
        return r4;
    }
}
