package com.obric.memorydata.memory.contextsync;

import com.bytedance.obric.memory.model.BatchSyncOMemoryRequest;
import com.bytedance.obric.memory.model.OMemorySemanticSyncItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0000¨\u0006\u000f"}, d2 = {"toBatchResult", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchResult;", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchItem;", "status", "", "buildOMemoryBatchRequest", "Lcom/bytedance/obric/memory/model/BatchSyncOMemoryRequest;", "requestId", "", "items", "", "full", "", "toSdkItem", "Lcom/bytedance/obric/memory/model/OMemorySemanticSyncItem;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class j {
    public static final BatchSyncOMemoryRequest a(String r3, List<a> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        Intrinsics.checkNotNullParameter(r6, "items");
        BatchSyncOMemoryRequest r0 = new BatchSyncOMemoryRequest();
        r0.requestId = r3;
        if (r5 == false) goto L5;
        r0.syncMode = "FULL";
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        r8.add(a((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")));
        goto L7
    L9:
        r0.semanticItems = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        return r0;
    }

    public static final OMemorySemanticSyncItem a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        OMemorySemanticSyncItem r0 = new OMemorySemanticSyncItem();
        r0.uuid = r4.a();
        r0.operation = r4.b();
        if (r0.operation == 2) goto L10;
        Long r1 = r4.d();
        if (r1 == null) goto L7;
        r0.sourceCreateTime = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
    L7:
        r0.sourceEntityId = r4.e();
        r0.sourceUpdateTime = r4.c();
        r0.content = r4.f();
        r0.productType = r4.g();
        r0.semanticType = r4.h();
        r0.tagPath = r4.i();
        Boolean r5 = r4.j();
        if (r5 == null) goto L10;
        r0.userEdit = r5.booleanValue();
    L10:
        return r0;
    }

    public static final b a(a r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new b(r7.a(), r7.b(), r7.k(), r8);
    }
}
