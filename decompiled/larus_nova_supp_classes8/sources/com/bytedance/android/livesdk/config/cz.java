package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cz extends SSettingKey<Integer> {
    public static final cz a = null;

    static {
        a = new cz();
    }

    public cz() {
        super(LiveInitSettingKeys.LIVE_GIFT_PANEL_STYLE, "礼物面板样式", 2, 2, new String[]{"0:- 线上对照", "1:- 仅tab上移", "2:- 仅tab上移+上下划", "3:- tab上移+上下划 + 下划时隐藏tab栏", "4:- 仅上下划", "5:- 上下划+ 下划时隐藏原下方tab栏"});
    }
}
