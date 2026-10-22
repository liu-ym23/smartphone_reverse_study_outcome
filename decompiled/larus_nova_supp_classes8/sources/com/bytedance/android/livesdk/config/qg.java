package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qg extends SSettingKey<Boolean> {
    public static final qg a = null;

    static {
        a = new qg();
    }

    public qg() {
        Boolean r1 = Boolean.TRUE;
        super("live_bottom_card_container_enable", "BottomCardPlaceHolderWidget底部卡片容器开关", r1, r1);
    }
}
