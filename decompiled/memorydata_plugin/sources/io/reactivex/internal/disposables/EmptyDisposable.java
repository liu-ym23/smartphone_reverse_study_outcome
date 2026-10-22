package io.reactivex.internal.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.m;
import io.reactivex.t;
import io.reactivex.x;

/* JADX INFO: loaded from: classes6.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements io.reactivex.internal.a.b<Object> {
    private static final /* synthetic */ EmptyDisposable[] $VALUES = null;
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    static {
        EmptyDisposable r0 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r0;
        EmptyDisposable r1 = new EmptyDisposable("NEVER", 1);
        NEVER = r1;
        $VALUES = new EmptyDisposable[]{r0, r1};
    }

    private EmptyDisposable(String r1, int r2) {
        super(r1, r2);
    }

    public static void complete(io.reactivex.c r2) {
        io.reactivex.c r3 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.c.class, "com.obric.memorydata.plugin");
        r3.onSubscribe(INSTANCE);
        r3.onComplete();
    }

    public static void complete(m<?> r2) {
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
        r3.onSubscribe(INSTANCE);
        r3.onComplete();
    }

    public static void complete(t<?> r2) {
        t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        r3.onSubscribe(INSTANCE);
        r3.onComplete();
    }

    public static void error(Throwable r2, io.reactivex.c r3) {
        io.reactivex.c r4 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.c.class, "com.obric.memorydata.plugin");
        r4.onSubscribe(INSTANCE);
        r4.onError(r2);
    }

    public static void error(Throwable r2, m<?> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        r4.onSubscribe(INSTANCE);
        r4.onError(r2);
    }

    public static void error(Throwable r2, t<?> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        r4.onSubscribe(INSTANCE);
        r4.onError(r2);
    }

    public static void error(Throwable r2, x<?> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        r4.onSubscribe(INSTANCE);
        r4.onError(r2);
    }

    public static EmptyDisposable valueOf(String r2) {
        return (EmptyDisposable) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyDisposable.class, r2), EmptyDisposable.class, "com.obric.memorydata.plugin");
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyDisposable[].class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this != INSTANCE) goto L5;
        return true;
    L5:
        return false;
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

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int r1) {
        return r1 & 2;
    }
}
