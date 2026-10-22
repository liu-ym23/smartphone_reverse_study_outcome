package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f18956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal f18957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f18958c;

    public w(Integer r5, ThreadLocal r10) {
        this.f18956a = r5;
        this.f18957b = r10;
        this.f18958c = new x(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object r5, Function2 r10) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key r5) {
        if (Intrinsics.areEqual(this.f18958c, r5) == false) goto L5;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    L5:
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this.f18958c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key r5) {
        if (Intrinsics.areEqual(this.f18958c, r5) == true) goto L5;
        return this;
    L5:
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r5) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r5);
    }

    @Override // kotlinx.coroutines.a2
    public final void restoreThreadContext(CoroutineContext r5, Object r10) {
        this.f18957b.set(r10);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f18956a + ", threadLocal = " + this.f18957b + ')';
    }

    @Override // kotlinx.coroutines.a2
    public final Object updateThreadContext(CoroutineContext r5) {
        ThreadLocal r10 = this.f18957b;
        Object r11 = r10.get();
        r10.set(this.f18956a);
        return r11;
    }
}
