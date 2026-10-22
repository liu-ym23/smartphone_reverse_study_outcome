package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iw extends SSettingKey<Boolean> {
    public static final iw a = null;

    static {
        a = new iw();
    }

    public iw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_detail_info_npe", "修复直播间内部crash", r1, r1);
    }
}
