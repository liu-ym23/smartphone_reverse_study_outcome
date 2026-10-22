package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final enum HandshakeType extends Enum<HandshakeType> {
    private static final /* synthetic */ HandshakeType[] $VALUES = null;
    public static final HandshakeType HANDSHAKE_FULL = null;
    public static final HandshakeType HANDSHAKE_RESUME = null;
    public static final HandshakeType HANDSHAKE_UNKNOWN = null;

    static {
        HandshakeType r0 = new HandshakeType("HANDSHAKE_UNKNOWN", 0);
        HANDSHAKE_UNKNOWN = r0;
        HandshakeType r1 = new HandshakeType("HANDSHAKE_RESUME", 1);
        HANDSHAKE_RESUME = r1;
        HandshakeType r3 = new HandshakeType("HANDSHAKE_FULL", 2);
        HANDSHAKE_FULL = r3;
        $VALUES = new HandshakeType[]{r0, r1, r3};
    }

    private HandshakeType(String r1, int r2) {
        super(r1, r2);
    }

    public static HandshakeType valueOf(String r2) {
        return (HandshakeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HandshakeType.class, r2), HandshakeType.class, "com.obric.memorydata.plugin");
    }

    public static HandshakeType[] values() {
        return (HandshakeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HandshakeType[].class, "com.obric.memorydata.plugin");
    }
}
