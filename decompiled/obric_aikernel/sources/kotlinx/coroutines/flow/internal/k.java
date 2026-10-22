package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public interface k<T> extends kotlinx.coroutines.flow.c<T> {

    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.c a(k r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, Object r15) {
            if (r15 != null) goto L15;
            if ((r14 & 1) == 0) goto L7;
            r11 = EmptyCoroutineContext.INSTANCE;
        L7:
            if ((r14 & 2) == 0) goto L10;
            r12 = -3;
        L10:
            if ((r14 & 4) == 0) goto L13;
            r13 = BufferOverflow.SUSPEND;
        L13:
            return r10.e(r11, r12, r13);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    kotlinx.coroutines.flow.c<T> e(CoroutineContext r10, int r11, BufferOverflow r12);
}
