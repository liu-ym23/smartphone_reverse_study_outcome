package kotlin.coroutines;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
public interface Continuation<T> {
    CoroutineContext getContext();

    void resumeWith(Object r10);
}
