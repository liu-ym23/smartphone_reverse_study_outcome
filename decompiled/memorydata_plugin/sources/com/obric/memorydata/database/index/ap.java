package com.obric.memorydata.database.index;

import com.obric.memorydata.database.entity.bh;
import com.obric.memorydata.database.entity.cd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a(\u0010\u0007\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a*\u0010\r\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002\"\u000e\u0010\u0010\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"shouldResetFirstCompletionForNewSource", "", "existing", "Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity;", "evidence", "Lcom/obric/memorydata/database/index/StartEvidence;", "shouldCorrectUnfinishedFirstCompletionForNewSource", "promoteExistingReindexToNewSourceIfNeeded", "pending", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "firstCompletionSourceStartedAt", "", "promoteCoverageOnlyReindexToNewSourceIfNeeded", "sourceTimestamp", "nowMs", "FRESH_SOURCE_FIRST_COMPLETION_WINDOW_MS", "initialCoverageState", "", "requiredCount", "hasDeferredTask", "FIRST_COMPLETION_ONLY_POLICY_VERSION", "coverageRoundInitialization", "Lcom/obric/memorydata/database/index/CoverageRoundInitialization;", "entityType", "roundIdentity", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "Lcom/obric/memorydata/database/index/DatabaseExecutionHandle;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ap {
    public static final int a(int r0, boolean r1) {
        if (r0 != 0) goto L5;
        if (r1 == true) goto L5;
        return 2;
    L5:
        return 1;
    }

    private static final long a(bh r1, cd r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return a(r2, r1);
    }

    public static final long a(cd r8, bh r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        aq r1 = aq.f9375a;
        long r2 = r8.d();
        if (r9 == null) goto L5;
        long r10 = r9.c();
    L7:
        return r1.a(r2, r10, System.currentTimeMillis());
    L5:
        r10 = 0;
        goto L7
    }

    public static final /* synthetic */ ai.c a(l r0) {
        return b(r0);
    }

    public static final bc a(bh r4, bc r5, long r6, long r8) {
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "evidence");
        if (r4 != null) goto L5;
        return r7;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, bc.a.class) == true) goto L8;
        return r7;
    L8:
        if (r6 > 0) goto L10;
        return r7;
    L10:
        if (r6 <= r8) goto L13;
        return r7;
    L13:
        if ((r8 - r6) <= 600000) goto L16;
        return r7;
    L16:
        if (a(r4, (bc) ZeusTransformUtils.preCheckCast(new bc.c(r6), bc.class, "com.obric.memorydata.plugin")) == true) goto L18;
        return r7;
    L18:
        return (bc) ZeusTransformUtils.preCheckCast(new bc.c(r6), bc.class, "com.obric.memorydata.plugin");
    }

    public static final bc a(final bh r4, bc r5, List<cd> r6) {
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "evidence");
        Intrinsics.checkNotNullParameter(r8, "pending");
        if (r4 != null) goto L5;
        return r7;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, bc.a.class) == false) goto L16;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(SequencesKt.minOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$ap$OoNHUIRpZDkSxUZxWMtJEMAdE(r4)), $$Lambda$ap$n62DcmxcS0pvC0BOxkWlhR0IfX8.INSTANCE)), Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L14;
        long r2 = r9.longValue();
        if (a(r4, (bc) ZeusTransformUtils.preCheckCast(new bc.c(r2), bc.class, "com.obric.memorydata.plugin")) == true) goto L12;
        return r7;
    L12:
        return (bc) ZeusTransformUtils.preCheckCast(new bc.c(r2), bc.class, "com.obric.memorydata.plugin");
    L14:
        return r7;
    L16:
        return r7;
    }

    public static final k a(int r21, List<cd> r22, bc r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        bc r3 = (bc) ZeusTransformUtils.wrapperContextForParams(r23, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "pending");
        Intrinsics.checkNotNullParameter(r3, "evidence");
        if (ZeusTransformUtils.instanceOf(r3, bc.b.class) == true) goto L5;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r6.next(), cd.class, "com.obric.memorydata.plugin")).d()));
        goto L8
    L10:
        LinkedHashSet r7 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r5, LinkedHashSet.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        if (r7.size() != 1) goto L60;
        if (((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.single((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L60;
        if (IndexDashboardCoverageV1Policy.f9304a.a(r21) == true) goto L23;
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.single((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r0.iterator();
    L19:
        if (r10.hasNext() == false) goto L22;
        cd r11 = (cd) ZeusTransformUtils.preCheckCast(r10.next(), cd.class, "com.obric.memorydata.plugin");
        r2.add(TuplesKt.to(r11.h(), r11.i()));
        goto L19
    L22:
        return new k(-1, r9, CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size(), 0, 8, null);
    L23:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        cd r15 = (cd) ZeusTransformUtils.preCheckCast(r14.next(), cd.class, "com.obric.memorydata.plugin");
        r13.add(TuplesKt.to(r15, IndexDashboardCoverageV1Policy.f9304a.a(r21, r15.h(), r15.i())));
        goto L25
    L27:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L30;
    L32:
        Iterator r18 = r17.iterator();
    L34:
        if (r18.hasNext() == false) goto L31;
        if (((Pair) ZeusTransformUtils.preCheckCast(r18.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond() != IndexDashboardCoverageV1Policy.PendingClassification.UNKNOWN) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == false) goto L34;
        boolean r20 = true;
    L41:
        if (r20 == true) goto L43;
        int r110 = SequencesKt.count(SequencesKt.distinct(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$ap$gzkZmdSBib2zshuh11TmaG3wo.INSTANCE), $$Lambda$ap$03h3LckHu7rcxnxQ5Pf_Hq7VYDY.INSTANCE)));
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Collection.class) == true) goto L47;
    L49:
        Iterator r25 = r24.iterator();
    L51:
        if (r25.hasNext() == false) goto L48;
        if (((Pair) ZeusTransformUtils.preCheckCast(r25.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond() != IndexDashboardCoverageV1Policy.PendingClassification.DEFERRED) goto L55;
        boolean r26 = true;
    L56:
        if (r26 == false) goto L51;
    L58:
        return new k(1, ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.single((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue(), r110, a(r110, r8));
    L55:
        r26 = false;
    L48:
        r8 = false;
        goto L58
    L47:
        if (((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L49;
    L43:
        return new k(0, 0, 0, 0, 15, null);
    L38:
        r19 = false;
    L31:
        r20 = false;
        goto L41
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
    L60:
        return new k(0, 0, 0, 0, 15, null);
    L5:
        return new k(0, 0, 0, 0, 15, null);
    }

    private static final boolean a(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(bh r6, bc r7) {
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r7, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "existing");
        Intrinsics.checkNotNullParameter(r8, "evidence");
        if (ZeusTransformUtils.instanceOf(r8, bc.c.class) == false) goto L5;
        bc.c r9 = (bc.c) ZeusTransformUtils.preCheckCast(r8, bc.c.class, "com.obric.memorydata.plugin");
    L7:
        if (r9 == null) goto L21;
        long r1 = r9.a();
        if (r1 > 0) goto L11;
        return false;
    L11:
        if (r6.e() == false) goto L23;
        long r10 = r6.c();
        if (1 <= r10) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == true) goto L20;
        return false;
    L20:
        return true;
    L15:
        if (r10 >= r1) goto L17;
        r11 = true;
        goto L18
    L23:
        return false;
    L21:
        return false;
    L5:
        r9 = null;
        goto L7
    }

    private static final boolean a(Pair r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        if (r1.getSecond() != IndexDashboardCoverageV1Policy.PendingClassification.REQUIRED) goto L5;
        return true;
    L5:
        return false;
    }

    private static final ai.c b(l r8) {
        return new ai.c(r8.a(), r8.c(), r8.b(), r8.d());
    }

    private static final Pair b(Pair r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return TuplesKt.to(((cd) ZeusTransformUtils.preCheckCast(r3.getFirst(), cd.class, "com.obric.memorydata.plugin")).h(), ((cd) ZeusTransformUtils.preCheckCast(r3.getFirst(), cd.class, "com.obric.memorydata.plugin")).i());
    }

    public static final boolean b(bh r6, bc r7) {
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r7, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "existing");
        Intrinsics.checkNotNullParameter(r8, "evidence");
        if (ZeusTransformUtils.instanceOf(r8, bc.c.class) == false) goto L5;
        bc.c r9 = (bc.c) ZeusTransformUtils.preCheckCast(r8, bc.c.class, "com.obric.memorydata.plugin");
    L7:
        if (r9 == null) goto L21;
        long r1 = r9.a();
        if (r1 > 0) goto L11;
        return false;
    L11:
        if (r6.e() == true) goto L23;
        long r10 = r6.c();
        if (1 <= r10) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == true) goto L20;
        return false;
    L20:
        return true;
    L15:
        if (r10 >= r1) goto L17;
        r11 = true;
        goto L18
    L23:
        return false;
    L21:
        return false;
    L5:
        r9 = null;
        goto L7
    }

    public static /* synthetic */ Pair lambda$03h3LckHu7rcxnxQ5Pf_Hq7VYDY(Pair r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$OoNHUIRpZDkSxU-ZxWMtJEMAd-E, reason: not valid java name */
    public static /* synthetic */ long m565lambda$OoNHUIRpZDkSxUZxWMtJEMAdE(bh r0, cd r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gzkZmdSBib2-zsh-uh11TmaG3wo, reason: not valid java name */
    public static /* synthetic */ boolean m566lambda$gzkZmdSBib2zshuh11TmaG3wo(Pair r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$n62DcmxcS0pvC0BOxkWlhR0IfX8(long r0) {
        return a(r0);
    }
}
