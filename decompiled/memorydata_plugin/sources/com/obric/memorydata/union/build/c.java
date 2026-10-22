package com.obric.memorydata.union.build;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/union/build/EpisodicTimeRangeResolver;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/union/build/EpisodicTimeRange;", "existingStartTimestamp", "", "existingEndTimestamp", "currentStartTimestamp", "currentEndTimestamp", "fallbackTimestamp", "mergeExistingRange", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JZ)Lcom/obric/memorydata/union/build/EpisodicTimeRange;", "takeIfPositive", "(Ljava/lang/Long;)Ljava/lang/Long;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13070a = null;

    static {
        f13070a = new c();
    }

    private c() {
    }

    private final Long a(Long r5) {
        if (r5 == null) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r5;
    L7:
        r0 = false;
    L11:
        return null;
    }

    public final b a(Long r5, Long r6, Long r7, Long r8, long r9, boolean r11) {
        Long r10 = a(r5);
        Long r12 = a(r6);
        Long r13 = a(r7);
        Long r4 = a(r8);
        if (r13 == null) goto L5;
        r9 = r13.longValue();
    L7:
        if (r4 == null) goto L9;
        long r0 = r4.longValue();
    L12:
        if (r11 == false) goto L14;
        Long r14 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new Long[]{r10, r13}), Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L18;
        r9 = r14.longValue();
    L18:
        Long r15 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new Long[]{r12, r4}), Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L22;
        r0 = r15.longValue();
    L22:
        return new b(r9, Math.max(r9, r0));
    L14:
        return new b(r9, r0);
    L9:
        if (r12 == null) goto L11;
        r0 = r12.longValue();
        goto L12
    L11:
        r0 = r9;
        goto L12
    L5:
        if (r10 == null) goto L7;
        r9 = r10.longValue();
        goto L7
    }
}
