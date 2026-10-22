package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class id0 extends SSettingKey<Boolean> {
    public static final id0 a = null;

    static {
        a = new id0();
    }

    public id0() {
        Boolean r1 = Boolean.TRUE;
        super("live_notify_widget_statusbar_fix", "沉浸式状态栏对NotifyWidget进行适配", r1, r1);
    }
}
