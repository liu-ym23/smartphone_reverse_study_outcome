package io.reactivex.internal.disposables;

import mt.b;
import mt.b0;
import mt.j;
import mt.u;
import rt.c;

/* JADX INFO: loaded from: classes3.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements c {
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyDisposable[] f17611a = null;

    static {
        EmptyDisposable r5 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r5;
        EmptyDisposable r10 = new EmptyDisposable("NEVER", 1);
        NEVER = r10;
        f17611a = new EmptyDisposable[]{r5, r10};
    }

    public static void complete(u r5) {
        r5.onSubscribe(INSTANCE);
        r5.onComplete();
    }

    public static void error(Throwable r5, u r10) {
        r10.onSubscribe(INSTANCE);
        r10.onError(r5);
    }

    public static EmptyDisposable valueOf(String r5) {
        return (EmptyDisposable) Enum.valueOf(EmptyDisposable.class, r5);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) f17611a.clone();
    }

    @Override // rt.h
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this != INSTANCE) goto L5;
        return true;
    L5:
        return false;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // rt.d
    public int requestFusion(int r5) {
        return r5 & 2;
    }

    public boolean offer(Object r5, Object r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(j r5) {
        r5.onSubscribe(INSTANCE);
        r5.onComplete();
    }

    public static void error(Throwable r5, b r10) {
        r10.onSubscribe(INSTANCE);
        r10.onError(r5);
    }

    public static void complete(b r5) {
        r5.onSubscribe(INSTANCE);
        r5.onComplete();
    }

    public static void error(Throwable r5, b0 r10) {
        r10.onSubscribe(INSTANCE);
        r10.onError(r5);
    }

    public static void error(Throwable r5, j r10) {
        r10.onSubscribe(INSTANCE);
        r10.onError(r5);
    }
}
