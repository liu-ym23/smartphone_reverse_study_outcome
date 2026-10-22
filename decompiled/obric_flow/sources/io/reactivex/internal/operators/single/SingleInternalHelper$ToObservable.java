package io.reactivex.internal.operators.single;

import mt.c0;
import mt.n;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final enum SingleInternalHelper$ToObservable extends Enum<SingleInternalHelper$ToObservable> implements o {
    public static final SingleInternalHelper$ToObservable INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleInternalHelper$ToObservable[] f18106a = null;

    static {
        SingleInternalHelper$ToObservable r5 = new SingleInternalHelper$ToObservable("INSTANCE", 0);
        INSTANCE = r5;
        f18106a = new SingleInternalHelper$ToObservable[]{r5};
    }

    public static SingleInternalHelper$ToObservable valueOf(String r5) {
        return (SingleInternalHelper$ToObservable) Enum.valueOf(SingleInternalHelper$ToObservable.class, r5);
    }

    public static SingleInternalHelper$ToObservable[] values() {
        return (SingleInternalHelper$ToObservable[]) f18106a.clone();
    }

    @Override // pt.o
    public /* bridge */ /* synthetic */ Object apply(Object r5) throws Exception {
        return apply((c0) r5);
    }

    public n apply(c0 r5) {
        return new c(r5);
    }
}
