package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import mt.b0;
import mt.g;
import mt.j;
import mt.u;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements g, u, j, b0, mt.b, zu.d, Disposable {
    public static final EmptyComponent INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyComponent[] f18164a = null;

    static {
        EmptyComponent r5 = new EmptyComponent("INSTANCE", 0);
        INSTANCE = r5;
        f18164a = new EmptyComponent[]{r5};
    }

    public static <T> u asObserver() {
        return INSTANCE;
    }

    public static <T> zu.c asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String r5) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, r5);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) f18164a.clone();
    }

    @Override // zu.d
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // zu.c
    public void onComplete() {
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        f.k(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        r5.dispose();
    }

    @Override // mt.j
    public void onSuccess(Object r5) {
    }

    @Override // zu.d
    public void request(long r5) {
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        r5.cancel();
    }
}
