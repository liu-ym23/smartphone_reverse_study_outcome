package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public interface a2 extends CoroutineContext.Element {
    void restoreThreadContext(CoroutineContext r5, Object r10);

    Object updateThreadContext(CoroutineContext r5);
}
