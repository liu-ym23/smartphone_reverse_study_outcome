package com.obric.memorydata.memory.review.provider.b;

import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/automemorypro/DaoMemoryReviewRuleTitleStore;", "Lcom/obric/memorydata/memory/review/provider/automemorypro/MemoryReviewRuleTitleStore;", "memoryRuleDao", "Lcom/obric/memorydata/database/dao/MemoryRuleDao;", "<init>", "(Lcom/obric/memorydata/database/dao/MemoryRuleDao;)V", "queryRuleTitleMap", "", "", "", "ruleIds", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryRuleDao f10438a;

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(MemoryRuleDao r3) {
        MemoryRuleDao r4 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r3, MemoryRuleDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "memoryRuleDao");
        this.f10438a = r4;
    }

    public /* synthetic */ b(MemoryRuleDao r2, int r3, DefaultConstructorMarker r4) {
        MemoryRuleDao r5 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao();
    L5:
        this(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.memory.review.provider.b.c
    public Map<Long, String> a(Collection<Long> r9) {
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "ruleIds");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L3:
        boolean r3 = true;
        if (r12.hasNext() == false) goto L11;
        Object r2 = r12.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L11:
        List<Long> r13 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == true) goto L14;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10438a.queryByIds(r13), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r8.iterator();
    L17:
        if (r15.hasNext() == false) goto L21;
        Object r1 = r15.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r1, MemoryRuleEntity.class, "com.obric.memorydata.plugin")).getTitle(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r14.add(r1);
        goto L17
    L21:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map<Long, String> r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L23:
        if (r18.hasNext() == false) goto L25;
        MemoryRuleEntity r4 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r18.next(), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        Pair r5 = TuplesKt.to(Long.valueOf(r4.getId()), r4.getTitle());
        r17.put(r5.getFirst(), r5.getSecond());
        goto L23
    L25:
        return r17;
    L14:
        return MapsKt.emptyMap();
    }
}
