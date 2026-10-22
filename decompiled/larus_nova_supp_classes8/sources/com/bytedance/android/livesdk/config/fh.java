package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fh extends SSettingKey<Boolean> {
    public static final fh a = null;

    static {
        a = new fh();
    }

    public fh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_key_node_callback_scope_service_dispatch", "Scope下的核心链路核心节点分发", r1, r1);
    }
}
