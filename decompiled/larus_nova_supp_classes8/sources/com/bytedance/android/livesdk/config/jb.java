package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jb extends SSettingKey<Boolean> {
    public static final jb a = null;

    static {
        a = new jb();
    }

    public jb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_ecom_entry_enable", "开播挂载小黄车开关", r1, r1);
    }
}
