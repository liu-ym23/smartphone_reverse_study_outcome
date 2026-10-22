package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f5 extends SSettingKey<Boolean> {
    public static final f5 a = null;

    static {
        a = new f5();
    }

    public f5() {
        Boolean r1 = Boolean.FALSE;
        super("format_ai_message_skip_wait", "公屏AI回复消息跳过等待队列", r1, r1);
    }
}
