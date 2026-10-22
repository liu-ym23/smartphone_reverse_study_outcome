package com.obric.memorydata.datastorage.dataaging.strategy.c;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/handler/EpisodicMemoryAgingDeleteHandler;", "Lcom/obric/memorydata/datastorage/dataaging/strategy/handler/AgingDeleteHandler;", "<init>", "()V", "TAG", "", "delete", "", "primaryKeys", "", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9708a = null;

    static {
        f9708a = new b();
    }

    private b() {
    }

    @Override // com.obric.memorydata.datastorage.dataaging.strategy.c.a
    public void delete(List<Long> r13) {
        List<Long> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "primaryKeys");
        List<T> r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByIds(r12);
        int r1 = r12.size() - r14.size();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r5 = r4.next();
        String r6 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getPackageName();
        Object r7 = r3.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r3.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L4
    L9:
        Iterator r8 = r3.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin");
        IEntityManager r15 = (IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        r17.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r18.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L14
    L16:
        r1 = r1 + IEntityManager.a.a(r15, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), -306, r10, null, 8, null).size();
        goto L11
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EpisodicMemoryAgingDelete", "delete candidates=" + r12.size() + ", resolved=" + r14.size() + ", deleted=" + r1, false, 4, null);
    }
}
