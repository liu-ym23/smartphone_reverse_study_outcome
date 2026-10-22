package com.obric.memorydata.personalcontext.collector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/FileEntityTimeUtils;", "", "<init>", "()V", "resolveCreateTime", "", "dateAddedSeconds", "dateModifiedSeconds", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12066a = null;

    static {
        f12066a = new e();
    }

    private e() {
    }

    public final long a(long r6, long r8) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Long[]{Long.valueOf(r6), Long.valueOf(r8)}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r5.iterator();
    L3:
        long r1 = 0;
        if (r9.hasNext() == false) goto L11;
        Object r0 = r9.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L3;
        r7.add(r0);
        goto L3
    L8:
        r2 = false;
        goto L9
    L11:
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r1 = r10.longValue();
    L15:
        return r1 * 1000;
    }
}
