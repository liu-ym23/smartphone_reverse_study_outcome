package io.reactivex.parallel;

import pt.c;

/* JADX INFO: loaded from: classes3.dex */
public final enum ParallelFailureHandling extends Enum<ParallelFailureHandling> implements c {
    public static final ParallelFailureHandling ERROR = null;
    public static final ParallelFailureHandling RETRY = null;
    public static final ParallelFailureHandling SKIP = null;
    public static final ParallelFailureHandling STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParallelFailureHandling[] f18186a = null;

    static {
        ParallelFailureHandling r5 = new ParallelFailureHandling("STOP", 0);
        STOP = r5;
        ParallelFailureHandling r10 = new ParallelFailureHandling("ERROR", 1);
        ERROR = r10;
        ParallelFailureHandling r11 = new ParallelFailureHandling("SKIP", 2);
        SKIP = r11;
        ParallelFailureHandling r12 = new ParallelFailureHandling("RETRY", 3);
        RETRY = r12;
        f18186a = new ParallelFailureHandling[]{r5, r10, r11, r12};
    }

    public static ParallelFailureHandling valueOf(String r5) {
        return (ParallelFailureHandling) Enum.valueOf(ParallelFailureHandling.class, r5);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) f18186a.clone();
    }

    public ParallelFailureHandling apply(Long r5, Throwable r10) {
        return this;
    }

    @Override // pt.c
    public /* bridge */ /* synthetic */ Object apply(Object r5, Object r10) throws Exception {
        return apply((Long) r5, (Throwable) r10);
    }
}
