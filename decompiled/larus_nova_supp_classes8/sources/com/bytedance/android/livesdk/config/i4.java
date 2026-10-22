package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i4 extends SSettingKey<Boolean> {
    public static final i4 a = null;

    static {
        a = new i4();
    }

    public i4() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_ranklist_slide_with_roomids_feed_drawer", "改版一直播间从小时榜跳转时是否支持小时榜上下滑", r1, r1);
    }
}
