package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zf extends SSettingKey<Boolean> {
    public static final zf a = null;

    static {
        a = new zf();
    }

    public zf() {
        Boolean r1 = Boolean.TRUE;
        super("live_background_network_change_cut", "内流直播间后台状态网络切换为移动数据时断流", r1, r1);
    }
}
