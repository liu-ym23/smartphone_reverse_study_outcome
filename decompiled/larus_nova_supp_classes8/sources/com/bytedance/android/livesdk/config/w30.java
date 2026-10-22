package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w30 extends SSettingKey<Boolean> {
    public static final w30 a = null;

    static {
        a = new w30();
    }

    public w30() {
        Boolean r4 = Boolean.FALSE;
        super("live_jsb_storage_async", "storage jsb 使用异步读取", r4, r4, true);
    }
}
