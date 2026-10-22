package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ud extends SSettingKey<Boolean> {
    public static final ud a = null;

    static {
        a = new ud();
    }

    public ud() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_announcement_bugfix_ksong_enable", "预告贴纸与k歌组件不互斥的bugfix端上兜底", r1, r1);
    }
}
