package com.obric.memorydata.database.dao;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.c.f;
import com.obric.memorydata.database.entity.ii;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0005JC\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\rJ\u001e\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0012\u0010#\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010$\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticDeleteLifecycle;", "", "<init>", "()V", "consumerCursorKeys", "", "", "getConsumerCursorKeys", "()Ljava/util/List;", "deleteExpected", "Lcom/obric/memorydata/database/dao/SemanticDeleteResult;", "expectedRows", "", "", InfoRequestQPSOptTraceLogger.REASON, "forceSystemRetraction", "", "deleteByEntityIds", "entityIds", "deleteByRawDbIds", "rawDbIds", "deleteResolved", "rows", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "requested", "", "changeSeq", "(Ljava/util/List;ILjava/lang/String;ZLjava/lang/Long;)Lcom/obric/memorydata/database/dao/SemanticDeleteResult;", "clearAllWithFence", "cleanupConsumedRetractions", "now", "clearDanglingConflicts", "", "deletedIds", "", "validateReason", "USER_DELETE_RETENTION_MS", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticDeleteLifecycle {
    public static final SemanticDeleteLifecycle INSTANCE = null;
    private static final long USER_DELETE_RETENTION_MS = 5184000000L;
    private static final List<String> consumerCursorKeys = null;

    static {
        INSTANCE = new SemanticDeleteLifecycle();
        consumerCursorKeys = CollectionsKt.listOf(new String[]{"cursor:user_insight", "cursor:interest_summary", "cursor:dreaming"});
    }

    private SemanticDeleteLifecycle() {
    }

    public static /* synthetic */ int cleanupConsumedRetractions$default(SemanticDeleteLifecycle r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        return r0.cleanupConsumedRetractions(r1);
    }

    private static final SemanticDeleteResult clearAllWithFence$lambda$12(PersonalMemoryFrameDb r17) {
        int r0 = r17.getSemanticMemoryDao().queryAllCount();
        long r1 = ij.a();
        int r3 = r17.getSemanticMemoryDao().deleteAllRaw();
        r17.getSemanticRetractionDao().deleteAll();
        r17.getMemoryProcessUserInsightDao().deleteAll();
        r17.getUnionSemanticTypeSummaryDao().deleteAll();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(consumerCursorKeys, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        r17.getSemanticStateDao().insertIfAbsent(new ik(r5, 0, null, 6, null));
        boolean r7 = true;
        if (r17.getSemanticStateDao().updateNum(r5, r1) == 1) goto L9;
        r7 = false;
    L9:
        if (r7 == true) goto L4;
        throw new IllegalStateException("Check failed.".toString());
    L13:
        f.f8859a.a();
        return new SemanticDeleteResult(r0, r3, 0, Long.valueOf(r1));
    }

    private final void clearDanglingConflicts(Set<String> r9, long r10) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L27;
        ip r2 = (ip) ZeusTransformUtils.preCheckCast(r1.next(), ip.class, "com.obric.memorydata.plugin");
        GsonUtil r3 = GsonUtil.INSTANCE;
        String r4 = r2.v();
        List r5 = null;
        if (r4 != null) goto L8;
    L16:
        if (r5 != null) goto L18;
        r5 = CollectionsKt.emptyList();
    L18:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r6.iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        Object r13 = r12.next();
        if (r8.contains((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin")) == true) goto L20;
        r7.add(r13);
        goto L20
    L24:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r14.size() == r5.size()) goto L4;
        r2.n(GsonUtil.INSTANCE.toJson(r14));
        r2.b(r10);
        r11.update(r2);
        goto L4
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        r5 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new SemanticDeleteLifecycle$clearDanglingConflicts$lambda$14$$inlined$fromJsonArray$1().getType()), List.class, "com.obric.memorydata.plugin");
        goto L16
    L10:
        r15 = false;
        goto L11
    }

    public static /* synthetic */ SemanticDeleteResult deleteByEntityIds$default(SemanticDeleteLifecycle r1, List r2, String r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.deleteByEntityIds(r6, r3);
    }

    private static final SemanticDeleteResult deleteByEntityIds$lambda$3(PersonalMemoryFrameDb r8, List r9, String r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        return deleteResolved$default(INSTANCE, r8.getSemanticMemoryDao().queryByEntityIds(r11), r11.size(), r10, true, null, 16, null);
    }

    private static final SemanticDeleteResult deleteByRawDbIds$lambda$5(PersonalMemoryFrameDb r8, List r9) {
        List<Long> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        return deleteResolved$default(INSTANCE, r8.getSemanticMemoryDao().queryByIds(r10), r10.size(), null, true, null, 16, null);
    }

    public static /* synthetic */ SemanticDeleteResult deleteExpected$default(SemanticDeleteLifecycle r1, Map r2, String r3, boolean r4, int r5, Object r6) {
        Map<String, Long> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = true;
    L9:
        return r1.deleteExpected(r7, r3, r4);
    }

    private static final SemanticDeleteResult deleteExpected$lambda$1(PersonalMemoryFrameDb r10, List r11, String r12, boolean r13, Map r14) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        List<ip> r3 = r10.getSemanticMemoryDao().queryByEntityIds(r15);
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L5;
    L7:
        Iterator r18 = r17.iterator();
    L9:
        if (r18.hasNext() == false) goto L6;
        ip r0 = (ip) ZeusTransformUtils.preCheckCast(r18.next(), ip.class, "com.obric.memorydata.plugin");
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r16.get(r0.getEntityId()), Long.class, "com.obric.memorydata.plugin");
        long r6 = r0.r();
        if (r5 != null) goto L14;
    L15:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L9;
    L18:
        if (r2 == true) goto L22;
        return deleteResolved$default(INSTANCE, r3, r15.size(), r12, r13, null, 16, null);
    L22:
        throw new SemanticDeleteVersionChangedException();
    L14:
        if (r5.longValue() != r6) goto L15;
        r1 = false;
    L6:
        r2 = false;
        goto L18
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static /* synthetic */ SemanticDeleteResult deleteResolved$default(SemanticDeleteLifecycle r6, List r7, int r8, String r9, boolean r10, Long r11, int r12, Object r13) {
        List<ip> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 2) == 0) goto L5;
        r8 = r1.size();
    L5:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        String r3 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        Long r5 = null;
    L14:
        return r6.deleteResolved(r1, r2, r3, r10, r5);
    L12:
        r5 = r11;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    public static /* synthetic */ SemanticDeleteResult lambda$XMKPw2TeR_KKzPpZKbCDyNrf0m8(PersonalMemoryFrameDb r0) {
        return clearAllWithFence$lambda$12(r0);
    }

    /* JADX INFO: renamed from: lambda$exEvP3pb-RZc32EZoVGnDye9iNQ, reason: not valid java name */
    public static /* synthetic */ SemanticDeleteResult m542lambda$exEvP3pbRZc32EZoVGnDye9iNQ(PersonalMemoryFrameDb r0, List r1, String r2, boolean r3, Map r4) {
        return deleteExpected$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SemanticDeleteResult lambda$vEAEIpzIiHO8OimT5kaxATqHgpY(PersonalMemoryFrameDb r0, List r1) {
        return deleteByRawDbIds$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$x-WNO36tLHTdM_5p3OwqsFrNAEQ, reason: not valid java name */
    public static /* synthetic */ SemanticDeleteResult m543lambda$xWNO36tLHTdM_5p3OwqsFrNAEQ(PersonalMemoryFrameDb r0, List r1, String r2) {
        return deleteByEntityIds$lambda$3(r0, r1, r2);
    }

    private final void validateReason(String r2) {
        SemanticDeletionPolicyKt.semanticRetractionReason(0.0f, r2, false);
    }

    public final int cleanupConsumedRetractions(long r6) {
        PersonalMemoryFrameDb r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        SemanticStateDao r0 = r5.getSemanticStateDao();
        List<String> r1 = consumerCursorKeys;
        if (r0.countKeys(r1) == r1.size()) goto L5;
        return 0;
    L5:
        Long r2 = r0.minNum(r1);
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
        long r7 = r6 - USER_DELETE_RETENTION_MS;
        return r5.getSemanticRetractionDao().deleteConsumed(r3, r7);
    L9:
        return 0;
    }

    public final SemanticDeleteResult clearAllWithFence() {
        final PersonalMemoryFrameDb r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (SemanticDeleteResult) ZeusTransformUtils.preCheckCast(r2.runInTransaction(new $$Lambda$SemanticDeleteLifecycle$XMKPw2TeR_KKzPpZKbCDyNrf0m8(r2)), SemanticDeleteResult.class, "com.obric.memorydata.plugin");
    }

    public final SemanticDeleteResult deleteByEntityIds(List<String> r5, final String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entityIds");
        validateReason(r6);
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r4.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r0 = r9.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r8.add(r0);
        goto L4
    L8:
        final List r10 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r10.isEmpty() == true) goto L11;
        final PersonalMemoryFrameDb r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (SemanticDeleteResult) ZeusTransformUtils.preCheckCast(r11.runInTransaction(new $$Lambda$SemanticDeleteLifecycle$xWNO36tLHTdM_5p3OwqsFrNAEQ(r11, r10, r6)), SemanticDeleteResult.class, "com.obric.memorydata.plugin");
    L11:
        return new SemanticDeleteResult(0, 0, 0, null);
    }

    public final SemanticDeleteResult deleteByRawDbIds(List<Long> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rawDbIds");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L3:
        boolean r2 = false;
        if (r11.hasNext() == false) goto L10;
        Object r1 = r11.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L3;
        r10.add(r1);
        goto L3
    L10:
        final List r12 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r12.isEmpty() == true) goto L13;
        final PersonalMemoryFrameDb r13 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (SemanticDeleteResult) ZeusTransformUtils.preCheckCast(r13.runInTransaction(new $$Lambda$SemanticDeleteLifecycle$vEAEIpzIiHO8OimT5kaxATqHgpY(r13, r12)), SemanticDeleteResult.class, "com.obric.memorydata.plugin");
    L13:
        return new SemanticDeleteResult(0, 0, 0, null);
    }

    public final SemanticDeleteResult deleteExpected(Map<String, Long> r9, final String r10, final boolean r11) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "expectedRows");
        validateReason(r10);
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r0 = r13.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r12.add(r0);
        goto L4
    L8:
        final List r4 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r4.isEmpty() == true) goto L11;
        final PersonalMemoryFrameDb r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (SemanticDeleteResult) ZeusTransformUtils.preCheckCast(r14.runInTransaction(new $$Lambda$SemanticDeleteLifecycle$exEvP3pbRZc32EZoVGnDye9iNQ(r14, r4, r10, r11, r7)), SemanticDeleteResult.class, "com.obric.memorydata.plugin");
    L11:
        return new SemanticDeleteResult(0, 0, 0, null);
    }

    public final SemanticDeleteResult deleteResolved(List<ip> r29, int r30, String r31, boolean r32, Long r33) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rows");
        validateReason(r31);
        if (r3.isEmpty() == true) goto L5;
        PersonalMemoryFrameDb r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        if (r33 == null) goto L9;
        long r7 = r33.longValue();
    L10:
        long r23 = System.currentTimeMillis();
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r15 = 0;
    L12:
        if (r25.hasNext() == false) goto L18;
        ip r9 = (ip) ZeusTransformUtils.preCheckCast(r25.next(), ip.class, "com.obric.memorydata.plugin");
        String r16 = SemanticDeletionPolicyKt.semanticRetractionReason(r9.l(), r31, r32);
        if (r16 == null) goto L12;
        r5.getSemanticRetractionDao().insert(new ii(0, r9.getEntityId(), r9.c(), r9.a(), r9.b(), r16, r23, r7, 1, null));
        r15 = r15 + 1;
        goto L12
    L18:
        int r6 = r15;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        r10.add(((ip) ZeusTransformUtils.preCheckCast(r4.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L20
    L22:
        clearDanglingConflicts((Set) ZeusTransformUtils.preCheckCast(r10, Set.class, "com.obric.memorydata.plugin"), r7);
        SemanticMemoryDao r0 = r5.getSemanticMemoryDao();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r8.iterator();
    L24:
        if (r12.hasNext() == false) goto L26;
        r11.add(((ip) ZeusTransformUtils.preCheckCast(r12.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L24
    L26:
        int r1 = r0.deleteEntityByEntityIdsRaw((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"));
        f r13 = f.f8859a;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r14.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        r17.add(Long.valueOf(((ip) ZeusTransformUtils.preCheckCast(r18.next(), ip.class, "com.obric.memorydata.plugin")).getId()));
        goto L28
    L30:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L32:
        if (r21.hasNext() == false) goto L39;
        Object r22 = r21.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L36;
        boolean r110 = true;
    L37:
        if (r110 == false) goto L32;
        r20.add(r22);
        goto L32
    L36:
        r110 = false;
        goto L37
    L39:
        r13.b((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"));
        return new SemanticDeleteResult(r30, r1, r6, Long.valueOf(r7));
    L9:
        r7 = ij.a();
        goto L10
    L5:
        return new SemanticDeleteResult(r30, 0, 0, null);
    }

    public final List<String> getConsumerCursorKeys() {
        return consumerCursorKeys;
    }
}
