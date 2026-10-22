package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jc extends SSettingKey<Boolean> {
    public static final jc a = null;

    static {
        a = new jc();
    }

    public jc() {
        super("enable_live_anchor_setting", "抖音直播是否展示主播通知设置入口", Boolean.FALSE, Boolean.TRUE);
    }
}
