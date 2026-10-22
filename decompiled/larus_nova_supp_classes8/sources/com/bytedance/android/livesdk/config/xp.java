package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xp extends SettingKey<Map<String, ? extends String>> {
    public static final xp a = null;

    static {
        a = new xp();
    }

    public xp() {
        super("live_playmode_item_type_map", "互动面板动态玩法名称与ID映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
