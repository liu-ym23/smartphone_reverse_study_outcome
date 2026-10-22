package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl(Continuation<Object> r10) {
        if (r10 == null) goto L4;
        CoroutineContext r11 = r10.getContext();
    L5:
        this(r10, r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public ContinuationImpl(Continuation<Object> r10, CoroutineContext r11) {
        super(r10);
        this._context = r11;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext r10 = this._context;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> r10 = this.intercepted;
        if (r10 != null) goto L10;
        ContinuationInterceptor r11 = (ContinuationInterceptor) getContext().get(ContinuationInterceptor.Key);
        if (r11 == null) goto L8;
        r10 = r11.interceptContinuation(this);
        if (r10 == null) goto L8;
    L9:
        this.intercepted = r10;
    L8:
        r10 = this;
    L10:
        return r10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        Continuation<?> r10 = this.intercepted;
        if (r10 == null) goto L6;
        if (r10 == this) goto L6;
        CoroutineContext.Element r11 = getContext().get(ContinuationInterceptor.Key);
        Intrinsics.checkNotNull(r11);
        ((ContinuationInterceptor) r11).releaseInterceptedContinuation(r10);
    L6:
        this.intercepted = CompletedContinuation.INSTANCE;
    }
}
