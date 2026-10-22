package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bu extends SSettingKey<Boolean> {
    public static final bu a = null;

    static {
        a = new bu();
    }

    public bu() {
        Boolean r1 = Boolean.FALSE;
        super("live_end_recommend_stream_delay", "LiveEndRecommendWidget中麦序房预览流拉流延迟到直播tab引导卡获取到显影状态", r1, r1);
    }
}
