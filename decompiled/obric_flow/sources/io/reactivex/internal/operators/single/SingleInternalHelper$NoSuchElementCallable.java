package io.reactivex.internal.operators.single;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final enum SingleInternalHelper$NoSuchElementCallable extends Enum<SingleInternalHelper$NoSuchElementCallable> implements Callable<NoSuchElementException> {
    public static final SingleInternalHelper$NoSuchElementCallable INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleInternalHelper$NoSuchElementCallable[] f18104a = null;

    static {
        SingleInternalHelper$NoSuchElementCallable r5 = new SingleInternalHelper$NoSuchElementCallable("INSTANCE", 0);
        INSTANCE = r5;
        f18104a = new SingleInternalHelper$NoSuchElementCallable[]{r5};
    }

    public static SingleInternalHelper$NoSuchElementCallable valueOf(String r5) {
        return (SingleInternalHelper$NoSuchElementCallable) Enum.valueOf(SingleInternalHelper$NoSuchElementCallable.class, r5);
    }

    public static SingleInternalHelper$NoSuchElementCallable[] values() {
        return (SingleInternalHelper$NoSuchElementCallable[]) f18104a.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ NoSuchElementException call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public NoSuchElementException call2() throws Exception {
        return new NoSuchElementException();
    }
}
