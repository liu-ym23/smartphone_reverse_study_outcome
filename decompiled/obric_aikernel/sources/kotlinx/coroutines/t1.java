package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
final class t1 extends w1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10718k = null;

    @Volatile
    private volatile int _invoked;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function1<Throwable, Unit> f10719j;

    static {
        f10718k = AtomicIntegerFieldUpdater.newUpdater(t1.class, "_invoked");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t1(Function1<? super Throwable, Unit> r10) {
        this.f10719j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        if (f10718k.compareAndSet(this, 0, 1) == false) goto L6;
        this.f10719j.invoke(r10);
        return;
    }
}
