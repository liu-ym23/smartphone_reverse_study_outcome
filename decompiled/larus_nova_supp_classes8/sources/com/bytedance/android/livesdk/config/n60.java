package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n60 extends SSettingKey<Boolean> {
    public static final n60 a = null;

    static {
        a = new n60();
    }

    public n60() {
        Boolean r1 = Boolean.TRUE;
        super("ttlive_link_guest_clean_optimize", "嘉宾连线场景支持清屏优化", r1, r1);
    }
}
