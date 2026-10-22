package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum PlatformViewDataProtocol extends Enum<PlatformViewDataProtocol> {
    public static final PlatformViewDataProtocol JSON_STRING = null;
    public static final PlatformViewDataProtocol LYNX_MAP = null;
    public static final /* synthetic */ PlatformViewDataProtocol[] a = null;

    static {
        PlatformViewDataProtocol r0 = new PlatformViewDataProtocol("LYNX_MAP", 0);
        LYNX_MAP = r0;
        PlatformViewDataProtocol r1 = new PlatformViewDataProtocol("JSON_STRING", 1);
        JSON_STRING = r1;
        a = new PlatformViewDataProtocol[]{r0, r1};
    }

    public static PlatformViewDataProtocol[] values() {
        return (PlatformViewDataProtocol[]) a.clone();
    }

    public static PlatformViewDataProtocol valueOf(String r1) {
        return (PlatformViewDataProtocol) r27.a.a(PlatformViewDataProtocol.class, r1);
    }

    public PlatformViewDataProtocol(String r1, int r2) {
        super(r1, r2);
    }
}
