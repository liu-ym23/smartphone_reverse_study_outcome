package com.bytedance.apm.agent.instrumentation.transaction;

/* JADX INFO: loaded from: classes2.dex */
final enum TransactionState$State extends Enum<TransactionState$State> {
    public static final TransactionState$State COMPLETE = null;
    public static final TransactionState$State READY = null;
    public static final TransactionState$State SENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransactionState$State[] f3840a = null;

    static {
        TransactionState$State r5 = new TransactionState$State("READY", 0);
        READY = r5;
        TransactionState$State r10 = new TransactionState$State("SENT", 1);
        SENT = r10;
        TransactionState$State r11 = new TransactionState$State("COMPLETE", 2);
        COMPLETE = r11;
        f3840a = new TransactionState$State[]{r5, r10, r11};
    }

    public static TransactionState$State valueOf(String r5) {
        return (TransactionState$State) Enum.valueOf(TransactionState$State.class, r5);
    }

    public static TransactionState$State[] values() {
        return (TransactionState$State[]) f3840a.clone();
    }
}
