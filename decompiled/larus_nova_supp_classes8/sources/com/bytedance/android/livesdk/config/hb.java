package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.XplayAnchorCustomServerMergeConfig;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hb extends SSettingKey<Map<String, ? extends XplayAnchorCustomServerMergeConfig>> {
    public static final hb a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/config/hb$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends XplayAnchorCustomServerMergeConfig>> {
        public a() {
        }
    }

    static {
        a = new hb();
    }

    public hb() {
        super("live_anchor_custom_server_merge_stream", new a().getType(), MapsKt.emptyMap());
    }
}
