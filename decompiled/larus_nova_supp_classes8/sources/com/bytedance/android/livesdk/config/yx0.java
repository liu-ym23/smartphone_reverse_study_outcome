package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yx0 extends SSettingKey<Boolean> {
    public static final yx0 a = null;

    static {
        a = new yx0();
    }

    public yx0() {
        Boolean r1 = Boolean.TRUE;
        super("vs_match_share_reload_in_sp", "看点预览页面重建状态数据是否弃用sp存储", r1, r1);
    }
}
