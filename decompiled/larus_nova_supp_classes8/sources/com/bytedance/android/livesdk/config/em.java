package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.live.model.LiveConvergeInnerUrl;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class em extends SSettingKey<List<? extends LiveConvergeInnerUrl>> {
    public static final em a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/em$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/live/model/LiveConvergeInnerUrl;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends LiveConvergeInnerUrl>> {
        public a() {
        }
    }

    static {
        em r0 = new em();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public em() {
        super("converge_draw_urls", new a().getType(), null);
    }
}
