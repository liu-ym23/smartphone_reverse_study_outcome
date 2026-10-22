package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ac extends SSettingKey<List<? extends String>> {
    public static final ac a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/ac$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    static {
        a = new ac();
    }

    public ac() {
        super("live_anchor_id_enter_room_entrance_list", new a().getType(), null);
    }
}
