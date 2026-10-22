package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class ca {
    public static final Object a(bx r2, Continuation<? super Unit> r3) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final bc a(bx r2, bc r3) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin"));
    }

    public static final bc a(bx r2, boolean r3, boolean r4, bt r5) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"), r3, r4, (bt) ZeusTransformUtils.wrapperContextForParams(r5, bt.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ bc a(bx r8, boolean r9, boolean r10, bt r11, int r12, Object r13) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r8, bx.class, "com.obric.memorydata.plugin"), r9, r10, (bt) ZeusTransformUtils.wrapperContextForParams(r11, bt.class, "com.obric.memorydata.plugin"), r12, r13);
    }

    public static final z a(bx r2) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ z a(bx r2, int r3, Object r4) {
        return cc.a((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static final void a(CoroutineContext r2) {
        cc.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public static final void a(CoroutineContext r2, CancellationException r3) {
        cc.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void a(CoroutineContext r2, CancellationException r3, int r4, Object r5) {
        cc.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    public static final void a(n<?> r2, Future<?> r3) {
        cb.a((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin"));
    }

    public static final bx b(CoroutineContext r2) {
        return cc.b((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public static final void b(CoroutineContext r2, CancellationException r3) {
        cc.b((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void b(CoroutineContext r2, CancellationException r3, int r4, Object r5) {
        cc.b((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    public static final void b(bx r2) {
        cc.b((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin"));
    }
}
