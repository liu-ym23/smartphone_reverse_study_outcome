package io.reactivex.internal.subscriptions;

import bc.d;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements d<Object> {
    private static final /* synthetic */ EmptySubscription[] $VALUES = null;
    public static final EmptySubscription INSTANCE = null;

    static {
        EmptySubscription r10 = new EmptySubscription("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new EmptySubscription[]{r10};
    }

    private EmptySubscription(String r10, int r11) {
        super(r10, r11);
    }

    public static void complete(c<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, c<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static EmptySubscription valueOf(String r10) {
        return (EmptySubscription) Enum.valueOf(EmptySubscription.class, r10);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) $VALUES.clone();
    }

    @Override // tc.d
    public void cancel() {
    }

    @Override // bc.f
    public void clear() {
    }

    @Override // bc.f
    public boolean isEmpty() {
        return true;
    }

    @Override // bc.f
    public boolean offer(Object r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object r10, Object r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // bc.f
    public Object poll() {
        return null;
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.validate(r10);
    }

    @Override // bc.c
    public int requestFusion(int r10) {
        return r10 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
