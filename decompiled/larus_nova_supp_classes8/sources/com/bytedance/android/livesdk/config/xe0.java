package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xe0 extends SSettingKey<Boolean> {
    public static final xe0 a = null;

    static {
        a = new xe0();
    }

    public xe0() {
        Boolean r1 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PAD_BACKUP_DISABLE_OPT, "兜底关掉直播pad优化的开关，默认关着的，打开了就回滚", r1, r1);
    }
}
