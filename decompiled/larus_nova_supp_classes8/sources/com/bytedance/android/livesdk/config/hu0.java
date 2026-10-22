package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hu0 extends SSettingKey<Boolean> {
    public static final hu0 a = null;

    static {
        a = new hu0();
    }

    public hu0() {
        Boolean r4 = Boolean.TRUE;
        super("live_tab_sync_data_change_fix_config", "直播tab内外不同流change回调fix", r4, r4, true);
    }
}
