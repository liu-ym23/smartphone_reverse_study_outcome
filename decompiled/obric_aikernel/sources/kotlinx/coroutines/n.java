package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface n<T> extends Continuation<T> {

    public static final class a {
        public static /* synthetic */ boolean a(n r10, Throwable r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L7;
            r11 = null;
        L7:
            return r10.z(r11);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    void N(Object r10);

    boolean a();

    void h(Function1<? super Throwable, Unit> r10);

    boolean isActive();

    Object j(Throwable r10);

    Object k(T r10, Object r11, Function1<? super Throwable, Unit> r12);

    void m(CoroutineDispatcher r10, Throwable r11);

    void q(CoroutineDispatcher r10, T r11);

    void y(T r10, Function1<? super Throwable, Unit> r11);

    boolean z(Throwable r10);
}
