package com.obric.aikernel.api.security;

/* JADX INFO: loaded from: classes2.dex */
public final enum TlsBootstrapState extends Enum<TlsBootstrapState> {
    private static final /* synthetic */ TlsBootstrapState[] $VALUES = null;
    public static final TlsBootstrapState CIRCUIT_OPEN = null;
    public static final TlsBootstrapState IDLE = null;
    public static final TlsBootstrapState NOT_REQUIRED = null;
    public static final TlsBootstrapState READY = null;
    public static final TlsBootstrapState WAITING_CERT = null;
    public static final TlsBootstrapState WAITING_NETWORK = null;

    private static final /* synthetic */ TlsBootstrapState[] $values() {
        return new TlsBootstrapState[]{NOT_REQUIRED, IDLE, WAITING_NETWORK, WAITING_CERT, CIRCUIT_OPEN, READY};
    }

    static {
        NOT_REQUIRED = new TlsBootstrapState("NOT_REQUIRED", 0);
        IDLE = new TlsBootstrapState("IDLE", 1);
        WAITING_NETWORK = new TlsBootstrapState("WAITING_NETWORK", 2);
        WAITING_CERT = new TlsBootstrapState("WAITING_CERT", 3);
        CIRCUIT_OPEN = new TlsBootstrapState("CIRCUIT_OPEN", 4);
        READY = new TlsBootstrapState("READY", 5);
        $VALUES = $values();
    }

    private TlsBootstrapState(String r10, int r11) {
        super(r10, r11);
    }

    public static TlsBootstrapState valueOf(String r10) {
        return (TlsBootstrapState) Enum.valueOf(TlsBootstrapState.class, r10);
    }

    public static TlsBootstrapState[] values() {
        return (TlsBootstrapState[]) $VALUES.clone();
    }
}
