package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.InnerDrawPreloadDisableConfig;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i10 extends SSettingKey<List<? extends InnerDrawPreloadDisableConfig>> {
    public static final i10 a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/i10$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/model/InnerDrawPreloadDisableConfig;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends InnerDrawPreloadDisableConfig>> {
        public a() {
        }
    }

    static {
        a = new i10();
    }

    public i10() {
        super("live_inner_draw_preload_disable_list", new a().getType(), InnerDrawPreloadDisableConfig.Companion.defaultDisableList());
    }
}
