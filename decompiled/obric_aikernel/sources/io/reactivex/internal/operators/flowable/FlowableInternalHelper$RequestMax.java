package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
public final enum FlowableInternalHelper$RequestMax extends Enum<FlowableInternalHelper$RequestMax> implements zb.g<tc.d> {
    private static final /* synthetic */ FlowableInternalHelper$RequestMax[] $VALUES = null;
    public static final FlowableInternalHelper$RequestMax INSTANCE = null;

    static {
        FlowableInternalHelper$RequestMax r10 = new FlowableInternalHelper$RequestMax("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new FlowableInternalHelper$RequestMax[]{r10};
    }

    private FlowableInternalHelper$RequestMax(String r10, int r11) {
        super(r10, r11);
    }

    public static FlowableInternalHelper$RequestMax valueOf(String r10) {
        return (FlowableInternalHelper$RequestMax) Enum.valueOf(FlowableInternalHelper$RequestMax.class, r10);
    }

    public static FlowableInternalHelper$RequestMax[] values() {
        return (FlowableInternalHelper$RequestMax[]) $VALUES.clone();
    }

    @Override // zb.g
    public /* bridge */ /* synthetic */ void accept(tc.d r10) {
        accept2(r10);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(tc.d r10) {
        r10.request(Long.MAX_VALUE);
    }
}
