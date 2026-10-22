package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xc extends SSettingKey<Boolean> {
    public static final xc a = null;

    static {
        a = new xc();
    }

    public xc() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_show_enable", "是否启用主播节目单", r1, r1);
    }
}
