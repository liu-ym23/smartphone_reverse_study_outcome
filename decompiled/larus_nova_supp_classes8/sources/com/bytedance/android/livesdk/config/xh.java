package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xh extends SSettingKey<Boolean> {
    public static final xh a = null;

    static {
        a = new xh();
    }

    public xh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_restart_popup_enable", "是否允许popuowindow提醒", r1, r1);
    }
}
