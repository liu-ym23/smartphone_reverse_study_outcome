package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hn0 extends SettingKey<Map<Integer, ? extends String>> {
    public static final hn0 a = null;

    static {
        a = new hn0();
    }

    public hn0() {
        super("live_play_mode_map", "营收玩法plyamode映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
