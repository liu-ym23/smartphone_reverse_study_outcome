package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final enum FlowableInternalHelper$RequestMax extends Enum<FlowableInternalHelper$RequestMax> implements pt.g {
    public static final FlowableInternalHelper$RequestMax INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowableInternalHelper$RequestMax[] f17647a = null;

    static {
        FlowableInternalHelper$RequestMax r5 = new FlowableInternalHelper$RequestMax("INSTANCE", 0);
        INSTANCE = r5;
        f17647a = new FlowableInternalHelper$RequestMax[]{r5};
    }

    public static FlowableInternalHelper$RequestMax valueOf(String r5) {
        return (FlowableInternalHelper$RequestMax) Enum.valueOf(FlowableInternalHelper$RequestMax.class, r5);
    }

    public static FlowableInternalHelper$RequestMax[] values() {
        return (FlowableInternalHelper$RequestMax[]) f17647a.clone();
    }

    @Override // pt.g
    public /* bridge */ /* synthetic */ void accept(Object r5) throws Exception {
        accept((zu.d) r5);
    }

    public void accept(zu.d r5) throws Exception {
        r5.request(Long.MAX_VALUE);
    }
}
