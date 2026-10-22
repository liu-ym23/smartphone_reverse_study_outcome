package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tn extends SSettingKey<Boolean> {
    public static final tn a = null;

    static {
        a = new tn();
    }

    public tn() {
        Boolean r1 = Boolean.FALSE;
        super("ttlive_disable_annie_im_usage_release", "关闭annie 的release for im", r1, r1);
    }
}
