package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface n<E> {

    public static final class a {
        public static /* synthetic */ boolean a(n r10, Throwable r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L7;
            r11 = null;
        L7:
            return r10.w(r11);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    void B(Function1<? super Throwable, Unit> r10);

    Object E(E r10);

    Object H(E r10, Continuation<? super Unit> r11);

    boolean L();

    kotlinx.coroutines.selects.h<E, n<E>> n();

    boolean w(Throwable r10);
}
