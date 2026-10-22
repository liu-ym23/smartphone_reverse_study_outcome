package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.t;
import io.reactivex.x;

/* JADX INFO: loaded from: classes6.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements io.reactivex.c, io.reactivex.disposables.b, j<Object>, m<Object>, t<Object>, x<Object>, org.a.d {
    private static final /* synthetic */ EmptyComponent[] $VALUES = null;
    public static final EmptyComponent INSTANCE = null;

    static {
        EmptyComponent r0 = new EmptyComponent("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new EmptyComponent[]{r0};
    }

    private EmptyComponent(String r1, int r2) {
        super(r1, r2);
    }

    public static <T> t<T> asObserver() {
        return INSTANCE;
    }

    public static <T> org.a.c<T> asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String r2) {
        return (EmptyComponent) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyComponent.class, r2), EmptyComponent.class, "com.obric.memorydata.plugin");
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyComponent[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.a.d
    public void cancel() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }

    @Override // io.reactivex.c
    public void onComplete() {
    }

    @Override // io.reactivex.c
    public void onError(Throwable r1) {
        io.reactivex.d.a.a(r1);
    }

    @Override // org.a.c
    public void onNext(Object r1) {
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b r2) {
        ((io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(org.a.d r2) {
        ((org.a.d) ZeusTransformUtils.wrapperContextForParams(r2, org.a.d.class, "com.obric.memorydata.plugin")).cancel();
    }

    @Override // io.reactivex.m
    public void onSuccess(Object r1) {
    }

    @Override // org.a.d
    public void request(long r1) {
    }
}
