package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wu extends SSettingKey<Float> {
    public static final wu a = null;

    static {
        a = new wu();
    }

    public wu() {
        Float r0 = Float.valueOf(0.2019f);
        super(LiveInitSettingKeys.LIVE_EQUAL_TALK_ROOM_TOP_MARGIN_RATIO, "平权九宫格上边距的合流比例", r0, r0);
    }
}
