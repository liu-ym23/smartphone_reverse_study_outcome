package com.obric.memorydata.memory.llm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemorySafetyRemovalEvents;", "", "<init>", "()V", "mutableEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/obric/memorydata/memory/llm/MemorySafetyRemovalEvents$MemoryKey;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "notifyRemoved", "", "memories", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MemoryKey", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ad<Set<a>> f10284b = null;
    private static final ai<Set<a>> c = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemorySafetyRemovalEvents$MemoryKey;", "", "entityId", "", "entityType", "", "<init>", "(Ljava/lang/String;I)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10286b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            this.f10285a = r2;
            this.f10286b = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10285a, r6.f10285a) == true) goto L12;
            return false;
        L12:
            if (this.f10286b == r6.f10286b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10285a.hashCode() * 31) + Integer.hashCode(this.f10286b);
        }

        public String toString() {
            return "MemoryKey(entityId=" + this.f10285a + ", entityType=" + this.f10286b + ')';
        }
    }

    static {
        f10283a = new f();
        ad<Set<a>> r0 = ak.a(0, 0, null, 7, null);
        f10284b = r0;
        c = kotlinx.coroutines.flow.k.a(r0);
    }

    private f() {
    }

    public final Object a(Set<a> r2, Continuation<? super Unit> r3) {
        Set<a> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        Object r5 = f10284b.emit(r1, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r5;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final ai<Set<a>> a() {
        return c;
    }
}
