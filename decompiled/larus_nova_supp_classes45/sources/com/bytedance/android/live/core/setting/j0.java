package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdk.config.l21;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 extends SSettingKey<l21> {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    public j0() {
        super("live_descriptor_load_config", "组件加载策略配置", new l21(), new l21(), true);
    }
}
