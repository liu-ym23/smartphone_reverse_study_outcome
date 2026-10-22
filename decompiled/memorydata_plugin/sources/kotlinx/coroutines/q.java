package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a0\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086H¢\u0006\u0002\u0010\n\u001a0\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0007H\u0080H¢\u0006\u0002\u0010\n\u001a\u0018\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a \u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¨\u0006\u0012"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "handler", "Lkotlinx/coroutines/CancelHandler;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class q {
    public static final <T> o<T> a(Continuation<? super T> r2) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.internal.l.class) == false) goto L5;
        o<T> r0 = ((kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin")).e();
        if (r0 == null) goto L16;
        if (r0.f() == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L16;
        return r0;
    L16:
        return new o(r3, 2);
    L5:
        return new o(r3, 1);
    }

    public static final void a(n<?> r2, bc r3) {
        a((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new bd((bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin")), m.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> void a(n<? super T> r2, m r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, o.class) == false) goto L7;
        ((o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L7:
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}
