package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\t\u0010\u0005\u001a\u00020\u0006X\u0082\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "handler", "Lkotlinx/coroutines/InternalCompletionHandler;", "(Lkotlinx/coroutines/InternalCompletionHandler;)V", "_invoked", "Lkotlinx/atomicfu/AtomicInt;", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class bv extends by {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17249b = null;
    private volatile /* synthetic */ int _invoked$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f17250a;

    static {
        f17249b = AtomicIntegerFieldUpdater.newUpdater(bv.class, "_invoked$volatile");
    }

    public bv(bt r3) {
        this.f17250a = (bt) ZeusTransformUtils.wrapperContextForParams(r3, bt.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater k() {
        return f17249b;
    }

    @Override // kotlinx.coroutines.bt
    public void a(Throwable r4) {
        if (k().compareAndSet(this, 0, 1) == false) goto L6;
        this.f17250a.a(r4);
        return;
    }
}
