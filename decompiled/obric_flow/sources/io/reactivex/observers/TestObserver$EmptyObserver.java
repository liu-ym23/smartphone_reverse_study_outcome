package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final enum TestObserver$EmptyObserver extends Enum<TestObserver$EmptyObserver> implements u {
    public static final TestObserver$EmptyObserver INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TestObserver$EmptyObserver[] f18175a = null;

    static {
        TestObserver$EmptyObserver r5 = new TestObserver$EmptyObserver("INSTANCE", 0);
        INSTANCE = r5;
        f18175a = new TestObserver$EmptyObserver[]{r5};
    }

    public static TestObserver$EmptyObserver valueOf(String r5) {
        return (TestObserver$EmptyObserver) Enum.valueOf(TestObserver$EmptyObserver.class, r5);
    }

    public static TestObserver$EmptyObserver[] values() {
        return (TestObserver$EmptyObserver[]) f18175a.clone();
    }

    @Override // mt.u
    public void onComplete() {
    }

    @Override // mt.u
    public void onError(Throwable r5) {
    }

    @Override // mt.u
    public void onNext(Object r5) {
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
    }
}
