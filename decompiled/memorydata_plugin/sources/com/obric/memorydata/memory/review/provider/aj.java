package com.obric.memorydata.memory.review.provider;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewProviderRegistry;", "", "<init>", "()V", "providers", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewDataProvider;", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "submitFeedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewSubmitResult;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj f10414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<MemoryReviewModule, z> f10415b = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f10414a = new aj();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new n[]{new com.obric.memorydata.memory.review.provider.e.a(null, null, null, 7, null), new com.obric.memorydata.memory.review.provider.a.a(null, null, 3, null), new com.obric.memorydata.memory.review.provider.b.a(null, null, null, null, 15, null), new com.obric.memorydata.memory.review.provider.c.a(null, null, 3, null), new com.obric.memorydata.memory.review.provider.d.a(null, null, 3, null)}), Iterable.class, "com.obric.memorydata.plugin");
        Map<MemoryReviewModule, z> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin")).a(), r3);
        goto L4
    L6:
        f10415b = r1;
    }

    private aj() {
    }

    public final com.obric.memorydata.memory.review.model.f a(com.obric.memorydata.memory.review.model.g r9) {
        Intrinsics.checkNotNullParameter(r9, Ext.KEY_REQUEST);
        z r8 = (z) ZeusTransformUtils.preCheckCast(f10415b.get(r9.a()), z.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L7;
        com.obric.memorydata.memory.review.model.f r10 = r8.a(r9);
        if (r10 == null) goto L7;
        return r10;
    L7:
        return com.obric.memorydata.memory.review.model.f.a.a(com.obric.memorydata.memory.review.model.f.f10389a, r9.a(), 0, 0, 6, null);
    }

    public final com.obric.memorydata.memory.review.model.j a(com.obric.memorydata.memory.review.model.c r14) {
        Intrinsics.checkNotNullParameter(r14, "feedback");
        com.obric.memorydata.memory.review.model.c r13 = com.obric.memorydata.memory.review.model.c.a(r14, com.obric.memorydata.memory.review.model.i.f10395a.b(r14.b(), r14.a()), null, null, null, null, null, null, null, 254, null);
        z r0 = (z) ZeusTransformUtils.preCheckCast(f10415b.get(r14.b()), z.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        com.obric.memorydata.memory.review.model.j r15 = r0.a(r13);
        if (r15 == null) goto L7;
        return r15;
    L7:
        return new com.obric.memorydata.memory.review.model.j(false, "review provider not found: " + r14.b().getKey());
    }
}
