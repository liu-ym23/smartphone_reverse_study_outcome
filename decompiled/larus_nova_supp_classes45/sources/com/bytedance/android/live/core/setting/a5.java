package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a5 extends SSettingKey<Long> {
    public static final a5 a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.core.setting.SettingKey, com.bytedance.android.live.core.setting.a5] */
    static {
        ?? r0 = new a5();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public a5() {
        super("live_setting_applog_key_event_mask", "拉流端播放器日志使用applog上报事件名", 0L, 0L);
    }
}
