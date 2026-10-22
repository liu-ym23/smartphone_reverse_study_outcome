package kotlinx.coroutines.debug.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.ak;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", AILabCheckPermissionTask.KEY_SOURCE, "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "coroutineId", "", "getCoroutineId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dispatcher", "", "getDispatcher", "()Ljava/lang/String;", "lastObservedStackTrace", "", "Ljava/lang/StackTraceElement;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedThreadName", "getLastObservedThreadName", "lastObservedThreadState", "getLastObservedThreadState", ActivityLifecycle.NAME, "getName", "sequenceNumber", "getSequenceNumber", "()J", "state", "getState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(d r6, CoroutineContext r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
        aj r0 = (aj) ZeusTransformUtils.preCheckCast(r8.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(aj.f17208a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), aj.class, "com.obric.memorydata.plugin");
        String r2 = null;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.a());
    L6:
        this.coroutineId = r1;
        ContinuationInterceptor r3 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r8.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ContinuationInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        String r4 = r3.toString();
    L10:
        this.dispatcher = r4;
        ak r9 = (ak) ZeusTransformUtils.preCheckCast(r8.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ak.f17210a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ak.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        String r10 = r9.a();
    L14:
        this.name = r10;
        this.state = r6.c();
        Thread r11 = r6.lastObservedThread;
        if (r11 == null) goto L19;
        Thread.State r12 = r11.getState();
        if (r12 == null) goto L19;
        String r13 = r12.toString();
    L20:
        this.lastObservedThreadState = r13;
        Thread r14 = r6.lastObservedThread;
        if (r14 == null) goto L23;
        r2 = r14.getName();
    L23:
        this.lastObservedThreadName = r2;
        this.lastObservedStackTrace = r6.e();
        this.sequenceNumber = r6.f17325a;
        return;
    L19:
        r13 = null;
        goto L20
    L13:
        r10 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
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
