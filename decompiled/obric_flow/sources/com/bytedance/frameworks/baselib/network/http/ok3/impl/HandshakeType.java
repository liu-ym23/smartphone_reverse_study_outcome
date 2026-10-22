package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes2.dex */
final enum HandshakeType extends Enum<HandshakeType> {
    public static final HandshakeType HANDSHAKE_FULL = null;
    public static final HandshakeType HANDSHAKE_RESUME = null;
    public static final HandshakeType HANDSHAKE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HandshakeType[] f4677a = null;

    static {
        HandshakeType r5 = new HandshakeType("HANDSHAKE_UNKNOWN", 0);
        HANDSHAKE_UNKNOWN = r5;
        HandshakeType r10 = new HandshakeType("HANDSHAKE_RESUME", 1);
        HANDSHAKE_RESUME = r10;
        HandshakeType r11 = new HandshakeType("HANDSHAKE_FULL", 2);
        HANDSHAKE_FULL = r11;
        f4677a = new HandshakeType[]{r5, r10, r11};
    }

    public static HandshakeType valueOf(String r5) {
        return (HandshakeType) Enum.valueOf(HandshakeType.class, r5);
    }

    public static HandshakeType[] values() {
        return (HandshakeType[]) f4677a.clone();
    }
}
