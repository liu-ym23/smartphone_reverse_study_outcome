package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public interface j extends Continuation {
    g8.g c(Object r5, Function3 r10);

    boolean cancel(Throwable r5);

    void e(Object r5, Function1 r10);

    boolean isActive();

    void k(Object r5, Function3 r10);

    void s(Object r5);
}
