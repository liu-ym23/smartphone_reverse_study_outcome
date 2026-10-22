package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveTbArchOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p81 extends SettingKey<LiveTbArchOptConfig> {
    public static final p81 a = null;

    static {
        a = new p81();
    }

    public p81() {
        super("live_tb_arch_opt", "toolbar架构优化", new LiveTbArchOptConfig(), new LiveTbArchOptConfig(), true);
    }
}
