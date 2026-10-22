package com.bytedance.apm.agent.instrumentation.transaction;

/* JADX INFO: loaded from: classes.dex */
final enum TxState$State extends Enum<TxState$State> {
    private static final /* synthetic */ TxState$State[] $VALUES = null;
    public static final TxState$State COMPLETE = null;
    public static final TxState$State READY = null;
    public static final TxState$State SENT = null;

    static {
        TxState$State r10 = new TxState$State("READY", 0);
        READY = r10;
        TxState$State r11 = new TxState$State("SENT", 1);
        SENT = r11;
        TxState$State r12 = new TxState$State("COMPLETE", 2);
        COMPLETE = r12;
        $VALUES = new TxState$State[]{r10, r11, r12};
    }

    private TxState$State(String r10, int r11) {
        super(r10, r11);
    }

    public static TxState$State valueOf(String r10) {
        return (TxState$State) Enum.valueOf(TxState$State.class, r10);
    }

    public static TxState$State[] values() {
        return (TxState$State[]) $VALUES.clone();
    }
}
