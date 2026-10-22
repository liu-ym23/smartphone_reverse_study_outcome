package com.bytedance.ttnet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum TTWiFiCellSwitcher$NetworkType extends Enum<TTWiFiCellSwitcher$NetworkType> {
    private static final /* synthetic */ TTWiFiCellSwitcher$NetworkType[] $VALUES = null;
    public static final TTWiFiCellSwitcher$NetworkType CELL = null;
    public static final TTWiFiCellSwitcher$NetworkType WIFI = null;
    final int networkType;

    static {
        TTWiFiCellSwitcher$NetworkType r0 = new TTWiFiCellSwitcher$NetworkType("WIFI", 0, 0);
        WIFI = r0;
        TTWiFiCellSwitcher$NetworkType r1 = new TTWiFiCellSwitcher$NetworkType("CELL", 1, 1);
        CELL = r1;
        $VALUES = new TTWiFiCellSwitcher$NetworkType[]{r0, r1};
    }

    public static TTWiFiCellSwitcher$NetworkType[] values() {
        return (TTWiFiCellSwitcher$NetworkType[]) $VALUES.clone();
    }

    public int code() {
        return this.networkType;
    }

    public static TTWiFiCellSwitcher$NetworkType valueOf(String r1) {
        return (TTWiFiCellSwitcher$NetworkType) r27.a.a(TTWiFiCellSwitcher$NetworkType.class, r1);
    }

    private TTWiFiCellSwitcher$NetworkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.networkType = r3;
    }
}
