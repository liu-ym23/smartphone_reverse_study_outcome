package io.reactivex.internal.util;

import xb.j;
import xb.o;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements xb.g<Object>, o<Object>, j<Object>, r<Object>, xb.b, tc.d, io.reactivex.disposables.b {
    private static final /* synthetic */ EmptyComponent[] $VALUES = null;
    public static final EmptyComponent INSTANCE = null;

    static {
        EmptyComponent r10 = new EmptyComponent("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new EmptyComponent[]{r10};
    }

    private EmptyComponent(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> o<T> asObserver() {
        return INSTANCE;
    }

    public static <T> tc.c<T> asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String r10) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, r10);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) $VALUES.clone();
    }

    @Override // tc.d
    public void cancel() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }

    @Override // tc.c
    public void onComplete() {
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        r10.dispose();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        r10.cancel();
    }

    @Override // xb.j
    public void onSuccess(Object r10) {
    }

    @Override // tc.d
    public void request(long r10) {
    }
}
