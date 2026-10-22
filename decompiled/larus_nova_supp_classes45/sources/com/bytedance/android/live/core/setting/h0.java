package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 extends SSettingKey<Map<String, ? extends com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g>> {
    public static final h0 a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/core/setting/h0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/widgetdescriptor/loadstrategy/g;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g>> {
        public a() {
        }
    }

    static {
        a = new h0();
    }

    public h0() {
        super("live_component_strategy_detail", new a().getType(), null);
    }
}
