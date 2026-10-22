package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rq extends SSettingKey<Boolean> {
    public static final rq a = null;

    static {
        a = new rq();
    }

    public rq() {
        super("live_enable_anchor_save_draft", Boolean.TRUE, "录屏主播端存草稿入口展示开关");
    }
}
