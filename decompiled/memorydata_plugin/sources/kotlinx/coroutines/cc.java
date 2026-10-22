package kotlinx.coroutines;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u001e\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0012\u0010\u0014\u001a\u00020\r*\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0005H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0005\u001a(\u0010\u001b\u001a\u00020\u0018*\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001b\u0010 \u001a\u00020\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\b!\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, d2 = {"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handle", "ensureActive", "invokeOnCompletion", "onCancelling", "invokeImmediately", "handler", "Lkotlinx/coroutines/InternalCompletionHandler;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
final /* synthetic */ class cc {
    public static final Object a(bx r2, Continuation<? super Unit> r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        bx.a.a(r4, null, 1, null);
        Object r6 = r4.a_(r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static final bc a(bx r8, bc r9) {
        return ca.a((bx) ZeusTransformUtils.wrapperContextForParams(r8, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(new be((bc) ZeusTransformUtils.wrapperContextForParams(r9, bc.class, "com.obric.memorydata.plugin")), bt.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final bc a(bx r2, boolean r3, boolean r4, bt r5) {
        bx r6 = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
        bt r7 = (bt) ZeusTransformUtils.wrapperContextForParams(r5, bt.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ce.class) == false) goto L6;
        return ((ce) ZeusTransformUtils.preCheckCast(r6, ce.class, "com.obric.memorydata.plugin")).a(r3, r4, r7);
    L6:
        return r6.a(r3, r4, (Function1) ZeusTransformUtils.preCheckCast(new JobKt__JobKt$invokeOnCompletion$1(r7), Function1.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ bc a(bx r1, boolean r2, boolean r3, bt r4, int r5, Object r6) {
        bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r1, bx.class, "com.obric.memorydata.plugin");
        bt r8 = (bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return ca.a(r7, r2, r3, r8);
    }

    public static final z a(bx r2) {
        return (z) ZeusTransformUtils.preCheckCast(new bz((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin")), z.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ z a(bx r1, int r2, Object r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r1, bx.class, "com.obric.memorydata.plugin");
        if ((r2 & 1) == 0) goto L6;
        r4 = null;
    L6:
        return ca.a(r4);
    }

    public static final void a(CoroutineContext r3) {
        bx r4 = (bx) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        ca.b(r4);
        return;
    }

    public static final void a(CoroutineContext r3, CancellationException r4) {
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r5.a(r4);
        return;
    }

    public static /* synthetic */ void a(CoroutineContext r1, CancellationException r2, int r3, Object r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r1, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        ca.a(r5, r2);
    }

    public static final bx b(CoroutineContext r3) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(r4.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r4).toString());
    }

    public static final void b(CoroutineContext r3, CancellationException r4) {
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        Sequence<bx> r6 = r5.m();
        if (r6 == null) goto L12;
        Iterator<bx> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        ((bx) ZeusTransformUtils.preCheckCast(r7.next(), bx.class, "com.obric.memorydata.plugin")).a(r4);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public static /* synthetic */ void b(CoroutineContext r1, CancellationException r2, int r3, Object r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r1, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        ca.b(r5, r2);
    }

    public static final void b(bx r2) {
        bx r3 = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
        if (r3.a() == false) goto L6;
        return;
    L6:
        throw r3.t_();
    }
}
