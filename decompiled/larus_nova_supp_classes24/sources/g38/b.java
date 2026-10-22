package g38;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public final String a;
    public final ContinuationInterceptor b;

    public final class a<T> implements Continuation<T> {
        public final Continuation<T> a;
        public final CoroutineContext b;
        public final /* synthetic */ b c;

        public CoroutineContext getContext() {
            return this.b;
        }

        public final void resumeWith(Object r4) {
            String r1 = this.c.a;
            String r2 = qqb.a.d();     // Catch: Throwable -> L9
            qqb.a.f(r1);     // Catch: Throwable -> L7
            this.a.resumeWith(r4);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r2, "traceId");
            qqb.a.g(r2);
            return;
        L7:
            th = th;
        L11:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r2, "traceId");
            qqb.a.g(r2);
            throw th;
        L9:
            th = th;
            r2 = "";
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r2, Continuation<? super T> r3) {
            Intrinsics.checkNotNullParameter(r3, "continuation");
            this.c = r2;
            this.a = r3;
            this.b = r3.getContext();
        }
    }

    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, r1);
    }

    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> r3) {
        Intrinsics.checkNotNullParameter(r3, "continuation");
        ContinuationInterceptor r0 = this.b;
        if (r0 == null) goto L7;
        Continuation<T> r1 = r0.interceptContinuation(new a(this, r3));
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new a(this, r3);
    }

    public final CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, r1);
    }

    public final void releaseInterceptedContinuation(Continuation<?> r1) {
        ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, r1);
    }

    public b(String r2, ContinuationInterceptor r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        super(ContinuationInterceptor.Key);
        this.a = r2;
        this.b = r3;
    }
}
