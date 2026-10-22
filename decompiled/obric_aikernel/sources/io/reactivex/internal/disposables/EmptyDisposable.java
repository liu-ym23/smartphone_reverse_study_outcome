package io.reactivex.internal.disposables;

import bc.b;
import xb.j;
import xb.o;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements b<Object> {
    private static final /* synthetic */ EmptyDisposable[] $VALUES = null;
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    static {
        EmptyDisposable r10 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r10;
        EmptyDisposable r11 = new EmptyDisposable("NEVER", 1);
        NEVER = r11;
        $VALUES = new EmptyDisposable[]{r10, r11};
    }

    private EmptyDisposable(String r10, int r11) {
        super(r10, r11);
    }

    public static void complete(xb.b r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void complete(j<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void complete(o<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, xb.b r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static void error(Throwable r10, j<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static void error(Throwable r10, o<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static void error(Throwable r10, r<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static EmptyDisposable valueOf(String r10) {
        return (EmptyDisposable) Enum.valueOf(EmptyDisposable.class, r10);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) $VALUES.clone();
    }

    @Override // bc.f
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

    @Override // bc.c
    public int requestFusion(int r10) {
        return r10 & 2;
    }
}
