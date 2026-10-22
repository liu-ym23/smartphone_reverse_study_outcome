package com.obric.memorydata.memory.inapptrace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportBatchPlanner;", "", "<init>", "()V", "MAX_ZIP_COUNT_PER_REQUEST", "", "select", "", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportCandidate;", "candidates", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10173a = null;

    static {
        f10173a = new g();
    }

    private g() {
    }

    public final List<h> a(List<h> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "candidates");
        if (r4.isEmpty() == true) goto L5;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r6.hasNext() == false) goto L30;
        int r1 = ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).b();
    L10:
        if (r6.hasNext() == false) goto L15;
        int r2 = ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).b();
        if (r1 >= r2) goto L10;
        r1 = r2;
        goto L10
    L15:
        if (r1 < 12) goto L18;
        int r7 = 1;
    L28:
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), r7);
    L18:
        if (r1 < 9) goto L21;
        r7 = 2;
        goto L28
    L21:
        if (r1 < 6) goto L24;
        r7 = 5;
        goto L28
    L24:
        if (r1 < 3) goto L26;
        r7 = 10;
        goto L28
    L26:
        r7 = 20;
        goto L28
    L30:
        throw new NoSuchElementException();
    L5:
        return CollectionsKt.emptyList();
    }
}
