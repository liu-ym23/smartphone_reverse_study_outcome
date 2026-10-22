package com.obric.memorydata.memory.b;

import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.u;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/automemorypro/AutoMemoryProDeleteHelper;", "", "<init>", "()V", "deleteByRuleId", "", "ruleId", "", "deleteByIds", "ids", "", "deleteRefs", "refs", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProDeleteRef;", "DELETE_QUERY_CHUNK_SIZE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10079a = null;

    static {
        f10079a = new b();
    }

    private b() {
    }

    private final int a(List<u> r35) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        u r3 = (u) ZeusTransformUtils.preCheckCast(r2.next(), u.class, "com.obric.memorydata.plugin");
        new AutoMemoryProEntity(r3.a(), r3.b(), 0, 0, NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED, r3.c(), 0, null, 0, 0, null, null, null, null, null, 0, null, null, null, null, null, 2097100, null).delete();
        goto L4
    L7:
        return r0.size();
    }

    public final int a(long r2) {
        return a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryDeleteRefsByRuleId(r2));
    }

    public final int a(Collection<Long> r8) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "ids");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L3:
        int r2 = 0;
        if (r11.hasNext() == false) goto L10;
        Object r1 = r11.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        r2 = 1;
    L8:
        if (r2 == 0) goto L3;
        r10.add(r1);
        goto L3
    L10:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        List<Long> r13 = (List) ZeusTransformUtils.preCheckCast(r12.next(), List.class, "com.obric.memorydata.plugin");
        r2 = r2 + f10079a.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryDeleteRefsByIds(r13));
        goto L12
    L14:
        return r2;
    }
}
