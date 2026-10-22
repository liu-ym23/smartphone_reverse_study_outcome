package io.reactivex.internal.subscriptions;

import rt.e;
import zu.c;

/* JADX INFO: loaded from: classes3.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements e {
    public static final EmptySubscription INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptySubscription[] f18161a = null;

    static {
        EmptySubscription r5 = new EmptySubscription("INSTANCE", 0);
        INSTANCE = r5;
        f18161a = new EmptySubscription[]{r5};
    }

    public static void complete(c r5) {
        r5.onSubscribe(INSTANCE);
        r5.onComplete();
    }

    public static void error(Throwable r5, c r10) {
        r10.onSubscribe(INSTANCE);
        r10.onError(r5);
    }

    public static EmptySubscription valueOf(String r5) {
        return (EmptySubscription) Enum.valueOf(EmptySubscription.class, r5);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) f18161a.clone();
    }

    @Override // zu.d
    public void cancel() {
    }

    @Override // rt.h
    public void clear() {
    }

    @Override // rt.h
    public boolean isEmpty() {
        return true;
    }

    @Override // rt.h
    public boolean offer(Object r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // rt.h
    public Object poll() {
        return null;
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.validate(r5);
    }

    @Override // rt.d
    public int requestFusion(int r5) {
        return r5 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object r5, Object r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
