package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vd extends SSettingKey<Boolean> {
    public static final vd a = null;

    static {
        a = new vd();
    }

    public vd() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_broadcast_announcement", "是否开启主播公告功能", r1, r1);
    }
}
