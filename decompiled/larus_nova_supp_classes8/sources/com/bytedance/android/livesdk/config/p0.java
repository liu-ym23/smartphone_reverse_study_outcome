package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.BroadcastRecordTipConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0 extends SSettingKey<BroadcastRecordTipConfig> {
    public static final p0 a = null;

    static {
        a = new p0();
    }

    public p0() {
        super("broadcast_record_tip_config", "主播侧录屏引导配置", new BroadcastRecordTipConfig(), new BroadcastRecordTipConfig());
    }
}
