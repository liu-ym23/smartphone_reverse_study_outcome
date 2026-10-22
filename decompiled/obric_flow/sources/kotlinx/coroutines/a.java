package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends r1 implements Continuation, CoroutineScope {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f18767c;

    public a(CoroutineContext r5, boolean r10) {
        super(r10);
        K((Job) r5.get(Job.Key));
        this.f18767c = r5.plus(this);
    }

    @Override // kotlinx.coroutines.r1
    public final void J(CompletionHandlerException r5) {
        c0.a(r5, this.f18767c);
    }

    @Override // kotlinx.coroutines.r1
    public final void S(Object r5) {
        if ((r5 instanceof v) == false) goto L9;
        v r10 = (v) r5;
        Throwable r11 = r10.f19025a;
        r10.getClass();
        if (v.f19024b.get(r10) == 0) goto L7;
        boolean r12 = true;
    L8:
        b0(r12, r11);
        return;
    L7:
        r12 = false;
        goto L8
    L9:
        c0(r5);
    }

    public void b0(boolean r5, Throwable r10) {
    }

    public void c0(Object r5) {
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f18767c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f18767c;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r5) {
        Throwable r10 = Result.m127exceptionOrNullimpl(r5);
        if (r10 == null) goto L6;
        r5 = new v(false, r10);
    L6:
        Object r11 = O(r5);
        if (r11 != j0.e) goto L9;
        return;
    L9:
        u(r11);
    }

    @Override // kotlinx.coroutines.r1
    public final String z() {
        return getClass().getSimpleName().concat(" was cancelled");
    }
}
