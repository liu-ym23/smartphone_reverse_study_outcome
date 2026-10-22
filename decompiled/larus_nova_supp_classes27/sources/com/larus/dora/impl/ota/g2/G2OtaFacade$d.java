package com.larus.dora.impl.ota.g2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class G2OtaFacade$d {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[InstallPhase.values().length];
        r0[InstallPhase.CHECKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L25:
        r0[InstallPhase.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L39:
        r0[InstallPhase.ENABLING_WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L29:
        r0[InstallPhase.DECLARING_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L31:
        r0[InstallPhase.CONNECTING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L23:
        r0[InstallPhase.TRANSFERRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
    L33:
        r0[InstallPhase.CANCELLING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
    L35:
        r0[InstallPhase.DEVICE_OWNED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
    L27:
        r0[InstallPhase.AWAITING_RECONNECT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
    L12:
        $EnumSwitchMapping$0 = r0;
    }
}
