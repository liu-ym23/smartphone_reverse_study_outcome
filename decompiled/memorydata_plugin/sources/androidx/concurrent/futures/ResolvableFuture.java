package androidx.concurrent.futures;

import com.google.common.util.concurrent.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(V r1) {
        return super.set(r1);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable r1) {
        return super.setException(r1);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setFuture(l<? extends V> r3) {
        return super.setFuture((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin"));
    }
}
