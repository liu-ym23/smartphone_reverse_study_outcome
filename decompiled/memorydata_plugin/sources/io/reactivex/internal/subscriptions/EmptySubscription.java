package io.reactivex.internal.subscriptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.d;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements d<Object> {
    private static final /* synthetic */ EmptySubscription[] $VALUES = null;
    public static final EmptySubscription INSTANCE = null;

    static {
        EmptySubscription r0 = new EmptySubscription("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new EmptySubscription[]{r0};
    }

    private EmptySubscription(String r1, int r2) {
        super(r1, r2);
    }

    public static void complete(c<?> r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        r3.onSubscribe(INSTANCE);
        r3.onComplete();
    }

    public static void error(Throwable r2, c<?> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        r4.onSubscribe(INSTANCE);
        r4.onError(r2);
    }

    public static EmptySubscription valueOf(String r2) {
        return (EmptySubscription) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptySubscription.class, r2), EmptySubscription.class, "com.obric.memorydata.plugin");
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptySubscription[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.a.d
    public void cancel() {
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(Object r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object r1, Object r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.a.f
    public Object poll() {
        return null;
    }

    @Override // org.a.d
    public void request(long r1) {
        SubscriptionHelper.validate(r1);
    }

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int r1) {
        return r1 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
