package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uz0 extends SSettingKey<Map<String, ? extends Map<String, ? extends hk1>>> {
    public static final uz0 a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/config/uz0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/config/hk1;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends Map<String, ? extends hk1>>> {
        public a() {
        }
    }

    static {
        a = new uz0();
    }

    public uz0() {
        super("live_xplay_scene_config_new", "Xplay分场景参数配置(New)", MapsKt.emptyMap(), new a().getType(), false, false);
    }
}
