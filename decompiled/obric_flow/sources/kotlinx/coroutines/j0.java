package kotlinx.coroutines;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18965a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f18966b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.g f18967c = null;
    public static final g8.g d = null;
    public static final g8.g e = null;
    public static final g8.g f = null;
    public static final g8.g g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g8.g f18968h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v0 f18969i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v0 f18970j = null;

    static {
        f18965a = new g8.g("RESUME_TOKEN", 10);
        int r5 = 10;
        f18966b = new g8.g("REMOVED_TASK", r5);
        f18967c = new g8.g("CLOSED_EMPTY", r5);
        int r10 = 10;
        d = new g8.g("COMPLETING_ALREADY", r10);
        e = new g8.g("COMPLETING_WAITING_CHILDREN", r10);
        f = new g8.g("COMPLETING_RETRY", r10);
        g = new g8.g("TOO_LATE_TO_CANCEL", r10);
        f18968h = new g8.g("SEALED", r10);
        f18969i = new v0(false);
        f18970j = new v0(true);
    }

    public static s a() {
        return new s(null);
    }

    public static z1 b() {
        return new z1(null);
    }

    public static final Object c(Collection r5, ContinuationImpl r10) {
        if (r5.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return new e((m0[]) r5.toArray(new m0[0])).a(r10);
    }

    public static final long d(long r5) {
        if (r5 > 0) goto L6;
        return 0;
    L6:
        if (r5 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return 1000000 * r5;
    }

    public static final void e(CoroutineContext r5) {
        Job r10 = (Job) r5.get(Job.Key);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isActive() == false) goto L8;
        return;
    L8:
        throw r10.getCancellationException();
    }

    public static final String f(Object r5) {
        return Integer.toHexString(System.identityHashCode(r5));
    }

    public static final Job g(CoroutineContext r5) {
        Job r10 = (Job) r5.get(Job.Key);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r5).toString());
    }

    public static final l h(Continuation r10) {
        if ((r10 instanceof kotlinx.coroutines.internal.e) == false) goto L5;
        kotlinx.coroutines.internal.e r5 = (kotlinx.coroutines.internal.e) r10;
        r5.getClass();
    L7:
        AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.internal.e.f18931h;
        Object r12 = r11.get(r5);
        g8.g r13 = kotlinx.coroutines.internal.f.f18933b;
        l r14 = null;
        if (r12 == null) goto L9;
        if ((r12 instanceof l) == true) goto L13;
        if (r12 == r13) goto L7;
        if ((r12 instanceof Throwable) == true) goto L7;
        throw new IllegalStateException(("Inconsistent state " + r12).toString());
    L13:
        if (r11.compareAndSet(r5, r12, r13) == true) goto L14;
        if (r11.get(r5) == r12) goto L13;
    L14:
        l r15 = (l) r12;
    L15:
        if (r15 == null) goto L26;
        AtomicReferenceFieldUpdater r16 = l.g;
        Object r17 = r16.get(r15);
        if ((r17 instanceof u) == true) goto L19;
    L21:
        l.f.set(r15, 536870911);
        r16.set(r15, b.f18769a);
        r14 = r15;
    L22:
        if (r14 == null) goto L26;
        return r14;
    L19:
        if (((u) r17).d == null) goto L21;
        r15.r();
    L26:
        return new l(2, r10);
    L9:
        r11.set(r5, r13);
        r15 = null;
        goto L15
    L5:
        return new l(1, r10);
    }

    public static t0 i(Job r5, m1 r10) {
        if ((r5 instanceof r1) == false) goto L6;
        return ((r1) r5).L(true, r10);
    L6:
        return r5.invokeOnCompletion(r10.i(), true, new JobKt__JobKt$invokeOnCompletion$1(r10));
    }

    public static final String j(Continuation r5) {
        if ((r5 instanceof kotlinx.coroutines.internal.e) == false) goto L16;
        return ((kotlinx.coroutines.internal.e) r5).toString();
    L16:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        Object r11 = Result.m124constructorimpl(r5 + '@' + f(r5));     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r11) == null) goto L15;
        r11 = r5.getClass().getName() + '@' + f(r5);
    L15:
        return (String) r11;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final Object k(Object r5) {
        if ((r5 instanceof h1) == false) goto L5;
        h1 r10 = (h1) r5;
    L6:
        if (r10 == null) goto L12;
        g1 r11 = r10.f18922a;
        if (r11 != null) goto L11;
        return r5;
    L11:
        return r11;
    L12:
        return r5;
    L5:
        r10 = null;
        goto L6
    }
}
