package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xd0 extends SSettingKey<Boolean> {
    public static final xd0 a = null;

    static {
        a = new xd0();
    }

    public xd0() {
        Boolean r1 = Boolean.FALSE;
        super("live_open_platform_audience_version_check_switch", "直播开平观众端，审核版本小程序的 schema 校验", r1, r1);
    }
}
