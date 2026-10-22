package com.obric.memorydata.personalcontext.search.bridge.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\bJ\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\tJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/ParallelTaskManager;", "", "<init>", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "deferredManager", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/Deferred;", "", "isDestroyed", "", "generateId", "saveDeferred", "", OaidModel.KEY_ID, "deferred", "awaitDeferred", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f12282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Long, ar<List<Long>>> f12283b;
    private boolean c;

    public b() {
        this.f12282a = new AtomicLong(1);
        this.f12283b = new ConcurrentHashMap();
    }

    public final long a() {
        if (this.c == false) goto L7;
        return 0;
    L7:
        return this.f12282a.getAndIncrement();
    }

    public final Object a(long r3, Continuation<? super List<Long>> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (this.c == true) goto L5;
        ar r2 = (ar) ZeusTransformUtils.preCheckCast(this.f12283b.remove(Boxing.boxLong(r3)), ar.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        return r2.a(r6);
    L11:
        throw new IllegalArgumentException("deferred not found");
    L5:
        return CollectionsKt.emptyList();
    }

    public final void a(long r3, ar<? extends List<Long>> r5) {
        ar r6 = (ar) ZeusTransformUtils.wrapperContextForParams(r5, ar.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "deferred");
        if (this.c == false) goto L5;
        return;
    L5:
        Long r4 = Long.valueOf(r3);
        ((Map) ZeusTransformUtils.preCheckCast(this.f12283b, Map.class, "com.obric.memorydata.plugin")).put(r4, r6);
    }

    public final void b() {
        this.c = true;
        this.f12283b.clear();
    }
}
