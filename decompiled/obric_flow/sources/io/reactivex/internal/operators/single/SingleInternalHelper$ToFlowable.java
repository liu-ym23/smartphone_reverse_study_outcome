package io.reactivex.internal.operators.single;

import mt.c0;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final enum SingleInternalHelper$ToFlowable extends Enum<SingleInternalHelper$ToFlowable> implements o {
    public static final SingleInternalHelper$ToFlowable INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleInternalHelper$ToFlowable[] f18105a = null;

    static {
        SingleInternalHelper$ToFlowable r5 = new SingleInternalHelper$ToFlowable("INSTANCE", 0);
        INSTANCE = r5;
        f18105a = new SingleInternalHelper$ToFlowable[]{r5};
    }

    public static SingleInternalHelper$ToFlowable valueOf(String r5) {
        return (SingleInternalHelper$ToFlowable) Enum.valueOf(SingleInternalHelper$ToFlowable.class, r5);
    }

    public static SingleInternalHelper$ToFlowable[] values() {
        return (SingleInternalHelper$ToFlowable[]) f18105a.clone();
    }

    @Override // pt.o
    public /* bridge */ /* synthetic */ Object apply(Object r5) throws Exception {
        return apply((c0) r5);
    }

    public zu.b apply(c0 r5) {
        return new b(r5);
    }
}
