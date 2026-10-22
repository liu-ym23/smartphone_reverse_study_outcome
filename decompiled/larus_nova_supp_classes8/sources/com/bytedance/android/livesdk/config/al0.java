package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class al0 extends SSettingKey<Boolean> {
    public static final al0 a = null;

    static {
        a = new al0();
    }

    public al0() {
        Boolean r1 = Boolean.FALSE;
        super("live_proto_decoders_read_setting_opt", "getProtoDecoder读取setting优化", r1, r1);
    }
}
