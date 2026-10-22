package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final CoroutineContext a(CoroutineContext r10, CoroutineContext r11, final boolean r12) {
        boolean r13 = c(r10);
        boolean r14 = c(r11);
        if (r13 == true) goto L7;
        if (r14 == true) goto L7;
        return r10.plus(r11);
    L7:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = r11;
        EmptyCoroutineContext r16 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r17 = (CoroutineContext) r10.fold(r16, new CoroutineContextKt$foldCopies$folded$1(r15, r12));
        if (r14 == false) goto L11;
        r15.element = ((CoroutineContext) r15.element).fold(r16, CoroutineContextKt$foldCopies$1.INSTANCE);
    L11:
        return r17.plus((CoroutineContext) r15.element);
    }

    public static final String b(CoroutineContext r10) {
        if (n0.c() == true) goto L5;
        return null;
    L5:
        j0 r11 = (j0) r10.get(j0.f10599g);
        if (r11 != null) goto L8;
        return null;
    L8:
        k0 r12 = (k0) r10.get(k0.f10604g);
        if (r12 == null) goto L12;
        String r13 = r12.c0();
        if (r13 == null) goto L12;
    L14:
        return r13 + '#' + r11.c0();
    L12:
        r13 = "coroutine";
        goto L14
    }

    private static final boolean c(CoroutineContext r10) {
        return ((Boolean) r10.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext r10, CoroutineContext r11) {
        if (c(r11) == true) goto L7;
        return r10.plus(r11);
    L7:
        return a(r10, r11, false);
    }

    public static final CoroutineContext e(l0 r10, CoroutineContext r11) {
        CoroutineContext r12 = a(r10.getCoroutineContext(), r11, true);
        if (n0.c() == false) goto L5;
        CoroutineContext r13 = r12.plus(new j0(n0.b().incrementAndGet()));
    L7:
        if (r12 != z0.a()) goto L9;
        return r13;
    L9:
        if (r12.get(ContinuationInterceptor.Key) == null) goto L11;
        return r13;
    L11:
        return r13.plus(z0.a());
    L5:
        r13 = r12;
        goto L7
    }

    public static final a3<?> f(CoroutineStackFrame r10) {
    L3:
        if ((r10 instanceof v0) == true) goto L4;
        r10 = r10.getCallerFrame();
        if (r10 == null) goto L7;
        if ((r10 instanceof a3) == false) goto L3;
        return (a3) r10;
    L7:
        return null;
    L4:
        return null;
    }

    public static final a3<?> g(Continuation<?> r10, CoroutineContext r11, Object r12) {
        if ((r10 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r11.get(b3.f10246c) == null) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
        return null;
    L11:
        a3<?> r14 = f((CoroutineStackFrame) r10);
        if (r14 == null) goto L14;
        r14.k1(r11, r12);
    L14:
        return r14;
    L8:
        r13 = false;
        goto L9
    }
}
