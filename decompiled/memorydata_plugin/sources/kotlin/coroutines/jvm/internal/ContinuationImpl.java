package kotlin.coroutines.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl(Continuation<Object> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        CoroutineContext r0 = r4.getContext();
    L6:
        this(r4, r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public ContinuationImpl(Continuation<Object> r3, CoroutineContext r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        super(r5);
        this._context = r6;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext r0 = this._context;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> r0 = this.intercepted;
        if (r0 != null) goto L10;
        ContinuationInterceptor r1 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ContinuationInterceptor.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        r0 = r1.interceptContinuation((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L8;
    L9:
        this.intercepted = r0;
    L8:
        r0 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
    L10:
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        Continuation<?> r0 = this.intercepted;
        if (r0 == null) goto L6;
        if (r0 == this) goto L6;
        CoroutineContext.Element r2 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2);
        ((ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r2, ContinuationInterceptor.class, "com.obric.memorydata.plugin")).releaseInterceptedContinuation(r0);
    L6:
        this.intercepted = (Continuation) ZeusTransformUtils.preCheckCast(CompletedContinuation.INSTANCE, Continuation.class, "com.obric.memorydata.plugin");
    }
}
