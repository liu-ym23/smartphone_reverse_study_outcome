package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
final class b implements Future<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.disposables.b f17126a;

    b(io.reactivex.disposables.b r3) {
        this.f17126a = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r1) {
        this.f17126a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long r1, TimeUnit r3) {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
