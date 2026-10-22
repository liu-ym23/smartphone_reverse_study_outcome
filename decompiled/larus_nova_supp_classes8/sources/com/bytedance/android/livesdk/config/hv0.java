package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hv0 extends SSettingKey<Integer> {
    public static final hv0 a = null;

    static {
        a = new hv0();
    }

    public hv0() {
        super("live_trace_decode_error_max_count", "消息Trace解析失败上报数量限制", 15, 15);
    }
}
