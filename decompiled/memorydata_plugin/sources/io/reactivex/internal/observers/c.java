package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T> implements x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f16721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final x<? super T> f16722b;

    public c(AtomicReference<io.reactivex.disposables.b> r3, x<? super T> r4) {
        x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
        this.f16721a = r3;
        this.f16722b = r5;
    }

    @Override // io.reactivex.x
    public void onError(Throwable r1) {
        this.f16722b.onError(r1);
    }

    @Override // io.reactivex.x
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        DisposableHelper.replace(this.f16721a, r4);
    }

    @Override // io.reactivex.x
    public void onSuccess(T r1) {
        this.f16722b.onSuccess(r1);
    }
}
