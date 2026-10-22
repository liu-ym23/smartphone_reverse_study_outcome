package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xv extends SSettingKey<z21> {
    public static final xv a = null;

    static {
        xv r0 = new xv();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public xv() {
        super("live_finished_auto_page_config", "关播页自动切换", new z21(), new z21());
    }
}
