package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s7 extends SSettingKey<List<? extends com.bytedance.android.livesdk.config.setting.c>> {
    public static final s7 a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/s7$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/config/setting/c;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends com.bytedance.android.livesdk.config.setting.c>> {
        public a() {
        }
    }

    static {
        s7 r0 = new s7();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s7() {
        super("ies_stop_excute_schemes", "", new ArrayList(), new a().getType(), false, false);
    }
}
