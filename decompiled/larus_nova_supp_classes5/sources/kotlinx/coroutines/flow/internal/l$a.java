package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l$a {
    public static /* synthetic */ Flow a(l r1, CoroutineDispatcher r2, int r3, BufferOverflow r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = -3;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = BufferOverflow.SUSPEND;
    L12:
        return r1.a(r2, r3, r4);
    }
}
