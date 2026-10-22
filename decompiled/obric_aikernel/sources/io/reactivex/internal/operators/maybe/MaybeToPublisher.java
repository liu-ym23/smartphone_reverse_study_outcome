package io.reactivex.internal.operators.maybe;

import xb.k;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements h<k<Object>, tc.b<Object>> {
    private static final /* synthetic */ MaybeToPublisher[] $VALUES = null;
    public static final MaybeToPublisher INSTANCE = null;

    static {
        MaybeToPublisher r10 = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new MaybeToPublisher[]{r10};
    }

    private MaybeToPublisher(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> h<k<T>, tc.b<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String r10) {
        return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, r10);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) $VALUES.clone();
    }

    @Override // zb.h
    public /* bridge */ /* synthetic */ tc.b<Object> apply(k<Object> r10) {
        return apply2(r10);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public tc.b<Object> apply2(k<Object> r10) {
        return new MaybeToFlowable(r10);
    }
}
