package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ra0 extends SSettingKey<Boolean> {
    public static final ra0 a = null;

    static {
        a = new ra0();
    }

    public ra0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_anchor_sei_load_backup_enable", "多人主播连线场景sei兜底加载", r1, r1);
    }
}
