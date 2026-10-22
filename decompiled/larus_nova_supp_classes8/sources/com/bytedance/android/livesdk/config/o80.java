package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o80 extends SSettingKey<Boolean> {
    public static final o80 a = null;

    static {
        a = new o80();
    }

    public o80() {
        Boolean r1 = Boolean.FALSE;
        super("live_message_manager_dispatch_priority_chat", "MessageManager支持优先分发Chat消息", r1, r1);
    }
}
