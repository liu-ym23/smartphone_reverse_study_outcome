package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
final class k extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Future<?> f10603c;

    public k(Future<?> r10) {
        this.f10603c = r10;
    }

    @Override // kotlinx.coroutines.m
    public void g(Throwable r10) {
        if (r10 == null) goto L5;
        this.f10603c.cancel(false);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        g(r10);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f10603c + ']';
    }
}
