package io.reactivex.observers;

import xb.o;

/* JADX INFO: loaded from: classes2.dex */
final enum TestObserver$EmptyObserver extends Enum<TestObserver$EmptyObserver> implements o<Object> {
    private static final /* synthetic */ TestObserver$EmptyObserver[] $VALUES = null;
    public static final TestObserver$EmptyObserver INSTANCE = null;

    static {
        TestObserver$EmptyObserver r10 = new TestObserver$EmptyObserver("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new TestObserver$EmptyObserver[]{r10};
    }

    private TestObserver$EmptyObserver(String r10, int r11) {
        super(r10, r11);
    }

    public static TestObserver$EmptyObserver valueOf(String r10) {
        return (TestObserver$EmptyObserver) Enum.valueOf(TestObserver$EmptyObserver.class, r10);
    }

    public static TestObserver$EmptyObserver[] values() {
        return (TestObserver$EmptyObserver[]) $VALUES.clone();
    }

    @Override // xb.o
    public void onComplete() {
    }

    @Override // xb.o
    public void onError(Throwable r10) {
    }

    @Override // xb.o
    public void onNext(Object r10) {
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
    }
}
