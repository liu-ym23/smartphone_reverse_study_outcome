package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lo extends SSettingKey<Boolean> {
    public static final lo a = null;

    static {
        a = new lo();
    }

    public lo() {
        Boolean r4 = Boolean.FALSE;
        super("live_disable_search_slide", "搜索进直播禁止滑动个人", r4, r4, true);
    }
}
