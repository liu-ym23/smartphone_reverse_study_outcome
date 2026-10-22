package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b20 extends SSettingKey<List<? extends String>> {
    public static final b20 a = null;

    static {
        a = new b20();
    }

    public b20() {
        super("live_inner_tablive_card_source_config", "直播内流引导卡片入口配置", new ArrayList(), new ArrayList());
    }
}
