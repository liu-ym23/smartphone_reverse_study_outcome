package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sr extends SSettingKey<Boolean> {
    public static final sr a = null;

    static {
        a = new sr();
    }

    public sr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_follow_status_use_local_db", "关注状态发生错误时是否使用兜底IM数据库", r1, r1);
    }
}
