package io.reactivex.subscribers;

import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final enum TestSubscriber$EmptySubscriber extends Enum<TestSubscriber$EmptySubscriber> implements g<Object> {
    private static final /* synthetic */ TestSubscriber$EmptySubscriber[] $VALUES = null;
    public static final TestSubscriber$EmptySubscriber INSTANCE = null;

    static {
        TestSubscriber$EmptySubscriber r10 = new TestSubscriber$EmptySubscriber("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new TestSubscriber$EmptySubscriber[]{r10};
    }

    private TestSubscriber$EmptySubscriber(String r10, int r11) {
        super(r10, r11);
    }

    public static TestSubscriber$EmptySubscriber valueOf(String r10) {
        return (TestSubscriber$EmptySubscriber) Enum.valueOf(TestSubscriber$EmptySubscriber.class, r10);
    }

    public static TestSubscriber$EmptySubscriber[] values() {
        return (TestSubscriber$EmptySubscriber[]) $VALUES.clone();
    }

    @Override // tc.c
    public void onComplete() {
    }

    @Override // tc.c
    public void onError(Throwable r10) {
    }

    @Override // tc.c
    public void onNext(Object r10) {
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
    }
}
