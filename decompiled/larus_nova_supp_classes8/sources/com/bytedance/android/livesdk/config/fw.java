package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fw extends SSettingKey<Boolean> {
    public static final fw a = null;

    static {
        a = new fw();
    }

    public fw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_asr_plugin_load", "修复加载asr插件的so的时候的crash", r1, r1);
    }
}
