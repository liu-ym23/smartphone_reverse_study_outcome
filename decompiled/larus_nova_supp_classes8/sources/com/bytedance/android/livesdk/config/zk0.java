package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zk0 extends SSettingKey<Boolean> {
    public static final zk0 a = null;

    static {
        a = new zk0();
    }

    public zk0() {
        Boolean r1 = Boolean.TRUE;
        super("live_proto_decoders_inject_with_service_init", "ProtoDecoderInjectTask 在 TTLiveSDK#initialize 时机执行", r1, r1);
    }
}
