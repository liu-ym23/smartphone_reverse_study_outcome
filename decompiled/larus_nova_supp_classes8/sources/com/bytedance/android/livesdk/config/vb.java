package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vb extends SSettingKey<Boolean> {
    public static final vb a = null;

    static {
        a = new vb();
    }

    public vb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_fix_time_setting_loading", "修复预告时间选择弹窗loading不消失", r1, r1);
    }
}
