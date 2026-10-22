package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.SlideUpTipABV2Config;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pg1 extends SSettingKey<Map<String, ? extends SlideUpTipABV2Config>> {
    public static final pg1 a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/config/pg1$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdkapi/model/SlideUpTipABV2Config;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends SlideUpTipABV2Config>> {
        public a() {
        }
    }

    static {
        pg1 r0 = new pg1();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public pg1() {
        super("live_room_slide_up_tip_configs", new a().getType(), new LinkedHashMap());
    }
}
