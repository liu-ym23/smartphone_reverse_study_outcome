package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dc extends SSettingKey<Boolean> {
    public static final dc a = null;

    static {
        a = new dc();
    }

    public dc() {
        Boolean r4 = Boolean.TRUE;
        super("live_anchor_more_dialog_cancelable_enable", "更多面板组件挂载校验过程中不允许关闭面板", r4, r4, true);
    }
}
