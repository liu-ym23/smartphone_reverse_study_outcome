package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public interface v1 extends CoroutineContext.Element {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f10723e = null;

    public static final class a {
        public static /* synthetic */ void a(v1 r10, CancellationException r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L6;
            r11 = null;
        L6:
            r10.c(r11);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(v1 r10, R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r12) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(r10, r11, r12);
        }

        public static <E extends CoroutineContext.Element> E c(v1 r10, CoroutineContext.Key<E> r11) {
            return (E) CoroutineContext.Element.DefaultImpls.get(r10, r11);
        }

        public static /* synthetic */ b1 d(v1 r10, boolean r11, boolean r12, Function1 r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 1) == 0) goto L7;
            r11 = false;
        L7:
            if ((r14 & 2) == 0) goto L10;
            r12 = true;
        L10:
            return r10.o(r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(v1 r10, CoroutineContext.Key<?> r11) {
            return CoroutineContext.Element.DefaultImpls.minusKey(r10, r11);
        }

        public static CoroutineContext f(v1 r10, CoroutineContext r11) {
            return CoroutineContext.Element.DefaultImpls.plus(r10, r11);
        }
    }

    public static final class b implements CoroutineContext.Key<v1> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ b f10724c = null;

        static {
            f10724c = new b();
        }

        private b() {
        }
    }

    static {
        f10723e = b.f10724c;
    }

    b1 A(Function1<? super Throwable, Unit> r10);

    boolean a();

    t a0(v r10);

    void c(CancellationException r10);

    v1 getParent();

    boolean isActive();

    boolean isCancelled();

    Object l(Continuation<? super Unit> r10);

    b1 o(boolean r10, boolean r11, Function1<? super Throwable, Unit> r12);

    CancellationException p();

    boolean start();
}
