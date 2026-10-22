package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bh extends SSettingKey<Boolean> {
    public static final bh a = null;

    static {
        a = new bh();
    }

    public bh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_end_fragment_use_new_commit_mode", "关播页启动模式变更", r1, r1);
    }
}
