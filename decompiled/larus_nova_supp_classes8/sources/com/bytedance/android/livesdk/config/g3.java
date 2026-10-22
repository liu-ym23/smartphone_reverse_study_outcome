package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g3 extends SSettingKey<Boolean> {
    public static final g3 a = null;

    static {
        a = new g3();
    }

    public g3() {
        Boolean r1 = Boolean.FALSE;
        super(LiveInitSettingKeys.ENABLE_ASSET_DOWNLOAD_INFO_LOG, "启用 记录特效下载顺序，用于礼物下载顺序、限速优化 测试验证", r1, r1);
    }
}
