package io.reactivex.subscribers;

import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final enum TestSubscriber$EmptySubscriber extends Enum<TestSubscriber$EmptySubscriber> implements g {
    public static final TestSubscriber$EmptySubscriber INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TestSubscriber$EmptySubscriber[] f18206a = null;

    static {
        TestSubscriber$EmptySubscriber r5 = new TestSubscriber$EmptySubscriber("INSTANCE", 0);
        INSTANCE = r5;
        f18206a = new TestSubscriber$EmptySubscriber[]{r5};
    }

    public static TestSubscriber$EmptySubscriber valueOf(String r5) {
        return (TestSubscriber$EmptySubscriber) Enum.valueOf(TestSubscriber$EmptySubscriber.class, r5);
    }

    public static TestSubscriber$EmptySubscriber[] values() {
        return (TestSubscriber$EmptySubscriber[]) f18206a.clone();
    }

    @Override // zu.c
    public void onComplete() {
    }

    @Override // zu.c
    public void onError(Throwable r5) {
    }

    @Override // zu.c
    public void onNext(Object r5) {
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
    }
}
