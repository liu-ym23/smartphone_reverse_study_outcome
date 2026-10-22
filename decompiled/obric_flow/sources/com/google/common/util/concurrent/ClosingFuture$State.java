package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final enum ClosingFuture$State extends Enum<ClosingFuture$State> {
    public static final ClosingFuture$State CLOSED = null;
    public static final ClosingFuture$State CLOSING = null;
    public static final ClosingFuture$State OPEN = null;
    public static final ClosingFuture$State SUBSUMED = null;
    public static final ClosingFuture$State WILL_CLOSE = null;
    public static final ClosingFuture$State WILL_CREATE_VALUE_AND_CLOSER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClosingFuture$State[] f9386a = null;

    static {
        ClosingFuture$State r5 = new ClosingFuture$State("OPEN", 0);
        OPEN = r5;
        ClosingFuture$State r10 = new ClosingFuture$State("SUBSUMED", 1);
        SUBSUMED = r10;
        ClosingFuture$State r11 = new ClosingFuture$State("WILL_CLOSE", 2);
        WILL_CLOSE = r11;
        ClosingFuture$State r12 = new ClosingFuture$State("CLOSING", 3);
        CLOSING = r12;
        ClosingFuture$State r13 = new ClosingFuture$State("CLOSED", 4);
        CLOSED = r13;
        ClosingFuture$State r14 = new ClosingFuture$State("WILL_CREATE_VALUE_AND_CLOSER", 5);
        WILL_CREATE_VALUE_AND_CLOSER = r14;
        f9386a = new ClosingFuture$State[]{r5, r10, r11, r12, r13, r14};
    }

    public static ClosingFuture$State valueOf(String r5) {
        return (ClosingFuture$State) Enum.valueOf(ClosingFuture$State.class, r5);
    }

    public static ClosingFuture$State[] values() {
        return (ClosingFuture$State[]) f9386a.clone();
    }
}
