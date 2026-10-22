package com.obric.memorydata.personalcontext.search.global;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/ReactAgentResourcePool;", "", "<init>", "()V", "TAG", "", "MAX_CONCURRENT", "", "agentPackages", "", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "activeCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "waitingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlinx/coroutines/CompletableDeferred;", "packageStatus", "", "", "packageLock", "acquireAgentPackage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseAgentPackage", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getAvailablePackage", "getActiveCount", "getWaitingCount", "hasAvailableResource", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12336b = null;
    private static final kotlinx.coroutines.sync.d c = null;
    private static final AtomicInteger d = null;
    private static final ConcurrentLinkedQueue<w<String>> e = null;
    private static final Map<String, Boolean> f = null;
    private static final Object g = null;

    static {
        f12335a = new i();
        List<String> r0 = CollectionsKt.listOf(new String[]{"memory_react_agent", "memory_react_agent_second", "memory_react_agent_third"});
        f12336b = r0;
        c = kotlinx.coroutines.sync.f.a(3, 0, 2, null);
        d = new AtomicInteger(0);
        e = new ConcurrentLinkedQueue();
        Map<String, Boolean> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"), false);
        goto L4
    L6:
        f = r1;
        g = new Object();
    }

    private i() {
    }

    private final String a() {
        Object r5 = g;
        monitor-enter(r5);
        Iterator<String> r0 = f12336b.iterator();     // Catch: Throwable -> L14
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Map<String, Boolean> r2 = f;     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r2.get(r1), false) == false) goto L6;
        r2.put(r1, true);     // Catch: Throwable -> L14
        monitor-exit(r5);
        return r1;
    L13:
        throw new IllegalStateException("No available agent package found");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final Object a(Continuation<? super String> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ReactAgentResourcePool$acquireAgentPackage$1.class) == false) goto L7;
        ReactAgentResourcePool$acquireAgentPackage$1 r0 = (ReactAgentResourcePool$acquireAgentPackage$1) ZeusTransformUtils.preCheckCast(r9, ReactAgentResourcePool$acquireAgentPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        i this = (i) ZeusTransformUtils.preCheckCast(r0.L$0, i.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L22:
        String r7 = this.a();     // Catch: Exception -> L19
        AtomicInteger r11 = d;     // Catch: Exception -> L19
        r11.incrementAndGet();     // Catch: Exception -> L19
        RunLog.INSTANCE.debug("ReactAgentResourcePool", "Acquired agent package: " + r7 + ", active count: " + r11.get());     // Catch: Exception -> L19
        return r7;
    L19:
        e = move-exception;
        c.c();
        RunLog.INSTANCE.error("ReactAgentResourcePool", "Failed to acquire agent package, released semaphore permit", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        throw e;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        RunLog.INSTANCE.debug("ReactAgentResourcePool", "Requesting agent package, active count: " + d.get());
        kotlinx.coroutines.sync.d r12 = c;
        r0.L$0 = this;
        r0.label = 1;
        if (r12.a(r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new ReactAgentResourcePool$acquireAgentPackage$1(this, r9);
        goto L8
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object r4 = g;
        monitor-enter(r4);
        f.put(r5, false);     // Catch: Throwable -> L8
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r4);
        AtomicInteger r6 = d;
        r6.decrementAndGet();
        c.c();
        RunLog.INSTANCE.debug("ReactAgentResourcePool", "Released agent package: " + r5 + ", active count: " + r6.get());
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
