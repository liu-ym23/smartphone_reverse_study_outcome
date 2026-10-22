package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zs extends SettingKey<Boolean> {
    public static final zs a = null;

    static {
        a = new zs();
    }

    public zs() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_server_merge_stream", "个播场景小玩法是否启用服务端合流", r4, r4, true);
    }
}
