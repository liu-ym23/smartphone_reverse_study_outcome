package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes.dex */
public final class JobListenableFuture<R> implements c6.a<R> {
    private final v1 job;
    private final SettableFuture<R> underlying;

    public JobListenableFuture(v1 r10, SettableFuture<R> r11) {
        Intrinsics.checkNotNullParameter(r10, "job");
        Intrinsics.checkNotNullParameter(r11, "underlying");
        this.job = r10;
        this.underlying = r11;
        r10.A(new AnonymousClass1(this));
    }

    public /* synthetic */ JobListenableFuture(v1 r10, SettableFuture r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(r11, "create()");
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ SettableFuture access$getUnderlying$p(JobListenableFuture r10) {
        return r10.underlying;
    }

    @Override // c6.a
    public void addListener(Runnable r10, Executor r11) {
        this.underlying.addListener(r10, r11);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        return this.underlying.cancel(r10);
    }

    public final void complete(R r10) {
        this.underlying.set(r10);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long r10, TimeUnit r11) {
        return this.underlying.get(r10, r11);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.underlying.isDone();
    }
}
