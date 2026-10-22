package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kg1 extends SSettingKey<Map<String, ? extends String>> {
    public static final kg1 a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/kg1$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    static {
        a = new kg1();
    }

    public kg1() {
        super("schema_entry", new a().getType(), new LinkedHashMap());
    }
}
