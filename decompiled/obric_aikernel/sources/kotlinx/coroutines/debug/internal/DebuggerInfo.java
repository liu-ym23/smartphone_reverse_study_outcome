package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(DebugCoroutineInfoImpl r10, CoroutineContext r11) {
        j0 r12 = (j0) r11.get(j0.f10599g);
        String r13 = null;
        if (r12 == null) goto L5;
        Long r14 = Long.valueOf(r12.c0());
    L6:
        this.coroutineId = r14;
        ContinuationInterceptor r15 = (ContinuationInterceptor) r11.get(ContinuationInterceptor.Key);
        if (r15 == null) goto L9;
        String r16 = r15.toString();
    L10:
        this.dispatcher = r16;
        k0 r17 = (k0) r11.get(k0.f10604g);
        if (r17 == null) goto L13;
        String r18 = r17.c0();
    L14:
        this.name = r18;
        this.state = r10.g();
        Thread r19 = r10.lastObservedThread;
        if (r19 == null) goto L19;
        Thread.State r20 = r19.getState();
        if (r20 == null) goto L19;
        String r21 = r20.toString();
    L20:
        this.lastObservedThreadState = r21;
        Thread r22 = r10.lastObservedThread;
        if (r22 == null) goto L23;
        r13 = r22.getName();
    L23:
        this.lastObservedThreadName = r13;
        this.lastObservedStackTrace = r10.h();
        this.sequenceNumber = r10.f10359b;
        return;
    L19:
        r21 = null;
        goto L20
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }
}
