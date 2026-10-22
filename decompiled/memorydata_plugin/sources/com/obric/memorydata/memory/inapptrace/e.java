package com.obric.memorydata.memory.inapptrace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007J<\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J+\u0010\u0017\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceObservationMatcher;", "", "<init>", "()V", "matches", "", "traceStartTimestamp", "", "traceEndTimestamp", "screenshotTimestamp", "maxLookbackMs", "maxLookaheadMs", "matchingScreenshotTimestamps", "", "screenshotTimestamps", "canDeleteTrace", "activeAssociationCount", "", "retentionStartedAt", "now", "retentionMs", "shouldWaitForLateDelivery", "deliveryGraceMs", "retryAfterForLateDelivery", "(Ljava/util/List;JJ)Ljava/lang/Long;", "lateLookupDelay", "lookupAfterMs", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10167a = null;

    static {
        f10167a = new e();
    }

    private e() {
    }

    private static final boolean a(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final long b(long r0, long r2, long r4) {
        return (r4 + r0) - r2;
    }

    private static final boolean b(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean b(long r11, long r13, long r15, long r17, long r19) {
        return f10167a.a(r11, r13, r19, r15, r17);
    }

    /* JADX INFO: renamed from: lambda$DTzOGpKw_jM0n-A-dekt2n27vk4, reason: not valid java name */
    public static /* synthetic */ long m706lambda$DTzOGpKw_jM0nAdekt2n27vk4(long r0, long r2, long r4) {
        return b(r0, r2, r4);
    }

    public static /* synthetic */ boolean lambda$OqaWZXkJKnh0SiUI4zr6OVjWWCo(long r0, long r2, long r4, long r6, long r8) {
        return b(r0, r2, r4, r6, r8);
    }

    /* JADX INFO: renamed from: lambda$UCoi3OTHKSFnS3fO-LW0QlJusbY, reason: not valid java name */
    public static /* synthetic */ boolean m707lambda$UCoi3OTHKSFnS3fOLW0QlJusbY(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$zgJ2TGNwE-lM9XTv3bPP0FQYnl8, reason: not valid java name */
    public static /* synthetic */ boolean m708lambda$zgJ2TGNwElM9XTv3bPP0FQYnl8(long r0) {
        return b(r0);
    }

    public final long a(long r3, long r5, long r7) {
        if (r3 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r7 <= 0) goto L9;
        return RangesKt.coerceAtLeast((r3 + r7) - r5, 0);
    }

    public final Long a(List<Long> r4, final long r5, final long r7) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "screenshotTimestamps");
        if (r7 > 0) goto L7;
        return null;
    L7:
        return (Long) ZeusTransformUtils.preCheckCast(SequencesKt.maxOrNull(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$e$UCoi3OTHKSFnS3fOLW0QlJusbY.INSTANCE), new $$Lambda$e$DTzOGpKw_jM0nAdekt2n27vk4(r7, r5)), $$Lambda$e$zgJ2TGNwElM9XTv3bPP0FQYnl8.INSTANCE)), Long.class, "com.obric.memorydata.plugin");
    }

    public final List<Long> a(final long r12, final long r14, List<Long> r16, final long r17, final long r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "screenshotTimestamps");
        return SequencesKt.toList(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$e$OqaWZXkJKnh0SiUI4zr6OVjWWCo(r12, r14, r17, r19)))));
    }

    public final boolean a(int r3, long r4, long r6, long r8) {
        if (r3 <= 0) goto L5;
        return false;
    L5:
        if (r4 > 0) goto L7;
        return false;
    L7:
        if (r8 > 0) goto L10;
        return false;
    L10:
        if ((r6 - r4) < r8) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean a(long r4, long r6, long r8, long r10, long r12) {
        if (r4 > 0) goto L5;
        return false;
    L5:
        if (r6 >= r4) goto L8;
        return false;
    L8:
        if (r8 > 0) goto L10;
        return false;
    L10:
        if (r10 > 0) goto L13;
        return false;
    L13:
        if (r6 > (r8 - r10)) goto L15;
        return false;
    L15:
        if (r4 > (r8 + r12)) goto L21;
        return true;
    L21:
        return false;
    }
}
