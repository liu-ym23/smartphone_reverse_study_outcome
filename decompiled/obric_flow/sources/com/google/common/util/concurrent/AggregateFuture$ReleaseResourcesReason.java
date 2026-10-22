package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final enum AggregateFuture$ReleaseResourcesReason extends Enum<AggregateFuture$ReleaseResourcesReason> {
    public static final AggregateFuture$ReleaseResourcesReason ALL_INPUT_FUTURES_PROCESSED = null;
    public static final AggregateFuture$ReleaseResourcesReason OUTPUT_FUTURE_DONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AggregateFuture$ReleaseResourcesReason[] f9381a = null;

    static {
        AggregateFuture$ReleaseResourcesReason r5 = new AggregateFuture$ReleaseResourcesReason("OUTPUT_FUTURE_DONE", 0);
        OUTPUT_FUTURE_DONE = r5;
        AggregateFuture$ReleaseResourcesReason r10 = new AggregateFuture$ReleaseResourcesReason("ALL_INPUT_FUTURES_PROCESSED", 1);
        ALL_INPUT_FUTURES_PROCESSED = r10;
        f9381a = new AggregateFuture$ReleaseResourcesReason[]{r5, r10};
    }

    public static AggregateFuture$ReleaseResourcesReason valueOf(String r5) {
        return (AggregateFuture$ReleaseResourcesReason) Enum.valueOf(AggregateFuture$ReleaseResourcesReason.class, r5);
    }

    public static AggregateFuture$ReleaseResourcesReason[] values() {
        return (AggregateFuture$ReleaseResourcesReason[]) f9381a.clone();
    }
}
