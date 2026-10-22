package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jx extends SSettingKey<Boolean> {
    public static final jx a = null;

    static {
        jx r0 = new jx();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public jx() {
        Boolean r4 = Boolean.FALSE;
        super("live_follow_cover_pre_pullstream", "关注天窗首次滑动预拉流优化", r4, r4, new String[]{"true:使用预拉流", "false:不使用预拉流"});
    }
}
