package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ls extends SSettingKey<Boolean> {
    public static final ls a = null;

    static {
        a = new ls();
    }

    public ls() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_normal_live", "快捷开播接入加号主场景", r4, r4, true);
    }
}
