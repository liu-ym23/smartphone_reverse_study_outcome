package com.obric.memorydata.migration.sdk;

import com.obric.memorydata.database.index.EntityIndexEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationPostRestore;", "", "<init>", "()V", "enqueueIndexPendingForEntity", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f11987a = null;

    static {
        f11987a = new x();
    }

    private x() {
    }

    public final boolean a(com.obric.memorydata.database.entity.d r6) {
        Intrinsics.checkNotNullParameter(r6, "entity");
        EntityIndexEngine r5 = com.obric.memorydata.database.index.s.a();
        Set<String> r0 = r5.getAllColumns(r6);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.getKeywordColumnMap(r6).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        r0.add("insert_keyword_task");
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.getContentTimeColumns(r6).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        r0.add("insert_content_time_task");
    L9:
        return r6.insertPendingColumns(r0);
    }
}
