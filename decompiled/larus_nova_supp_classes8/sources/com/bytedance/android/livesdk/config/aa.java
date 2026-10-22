package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class aa extends SSettingKey<Boolean> {
    public static final aa a = null;

    static {
        a = new aa();
    }

    public aa() {
        Boolean r1 = Boolean.FALSE;
        super("live_add_widget_enable", "添加到桌面是否可用", r1, r1);
    }
}
