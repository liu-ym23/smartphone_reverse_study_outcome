package com.ttnet.org.chromium.net.impl;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum CronetFrontierClient$TransportMode extends Enum<CronetFrontierClient$TransportMode> {
    private static final /* synthetic */ CronetFrontierClient$TransportMode[] $VALUES = null;
    public static final CronetFrontierClient$TransportMode HTTP2 = null;
    public static final CronetFrontierClient$TransportMode QUIC = null;
    public static final CronetFrontierClient$TransportMode SPDY = null;
    public static final CronetFrontierClient$TransportMode TLS = null;
    public static final CronetFrontierClient$TransportMode UNKNOWN = null;
    final int mode;

    static {
        CronetFrontierClient$TransportMode r0 = new CronetFrontierClient$TransportMode("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        CronetFrontierClient$TransportMode r1 = new CronetFrontierClient$TransportMode("QUIC", 1, 0);
        QUIC = r1;
        CronetFrontierClient$TransportMode r2 = new CronetFrontierClient$TransportMode("TLS", 2, 1);
        TLS = r2;
        CronetFrontierClient$TransportMode r5 = new CronetFrontierClient$TransportMode("HTTP2", 3, 2);
        HTTP2 = r5;
        CronetFrontierClient$TransportMode r7 = new CronetFrontierClient$TransportMode("SPDY", 4, 3);
        SPDY = r7;
        $VALUES = new CronetFrontierClient$TransportMode[]{r0, r1, r2, r5, r7};
    }

    public static CronetFrontierClient$TransportMode[] values() {
        return (CronetFrontierClient$TransportMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.mode;
    }

    public static CronetFrontierClient$TransportMode valueOf(String r1) {
        return (CronetFrontierClient$TransportMode) a.a(CronetFrontierClient$TransportMode.class, r1);
    }

    private CronetFrontierClient$TransportMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mode = r3;
    }
}
