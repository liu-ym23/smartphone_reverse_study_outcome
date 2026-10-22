package io.reactivex.internal.operators.maybe;

import mt.k;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements o {
    public static final MaybeToPublisher INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaybeToPublisher[] f17676a = null;

    static {
        MaybeToPublisher r5 = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = r5;
        f17676a = new MaybeToPublisher[]{r5};
    }

    public static <T> o instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String r5) {
        return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, r5);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) f17676a.clone();
    }

    @Override // pt.o
    public /* bridge */ /* synthetic */ Object apply(Object r5) throws Exception {
        return apply((k) r5);
    }

    public zu.b apply(k r5) throws Exception {
        return new d(r5);
    }
}
