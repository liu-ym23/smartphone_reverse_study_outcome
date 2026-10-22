package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sg extends SSettingKey<Boolean> {
    public static final sg a = null;

    static {
        a = new sg();
    }

    public sg() {
        Boolean r1 = Boolean.TRUE;
        super("live_bottom_card_skip_visible_check", "底部卡片是否跳过可见性检查", r1, r1);
    }
}
