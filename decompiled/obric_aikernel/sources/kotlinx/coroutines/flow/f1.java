package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface f1<T> extends j1<T>, d<T> {
    void b();

    boolean c(T r10);

    p1<Integer> d();

    Object emit(T r10, Continuation<? super Unit> r11);
}
