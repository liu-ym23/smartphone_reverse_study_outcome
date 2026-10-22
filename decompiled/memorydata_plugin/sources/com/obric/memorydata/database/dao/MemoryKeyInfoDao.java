package com.obric.memorydata.database.dao;

import android.database.sqlite.SQLiteConstraintException;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.manager.w;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH'J\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H'J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H'J\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H'J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J*\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u0006H'J&\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u00190\b2\u0006\u0010\u000e\u001a\u00020\u0006J&\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u00190\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u001f\u001a\u00020\u00062\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060!0\u0019H\u0017J,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0017J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0016\u0010%\u001a\u00020&2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J8\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH\u0002J\u001e\u0010,\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\tH%J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0002H%J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203H%J\u001f\u00104\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H'¢\u0006\u0002\u00105J\u0018\u00106\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H'J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u0016\u0010:\u001a\u00020&2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J$\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u001e\u0010<\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u0010\u0010=\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u0006H'¨\u0006>"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryKeyInfoDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryKeyInfoEntity;", "<init>", "()V", "getTableName", "", "observeAddresses", "Lkotlinx/coroutines/flow/Flow;", "", "observePhones", "observeUrls", "observeIdentifiers", "observeAddressBySourceId", "sourceId", "observePhoneBySourceId", "observeUrlBySourceId", "observeIdentifierBySourceId", "queryByKeyTypes", "keyTypes", "queryBySourceIdAndKeyTypes", "observeBySourceIdAndKeyTypes", "queryAllKeysBySourceId", "observeAllKeysBySourceIdFlow", "observeKeyValueMapBySourceId", "", "observeFullKeyValueMapBySourceId", "batchUpsert", "", "entities", "batchUpsertManual", "sourceEntityId", "keyValueMap", "", "key", EventBody.KEY_VALUE, "batchInsert", "batchUpdateOptimized", "", "executeUpsertCore", "mapResultToOriginalOrder", "originalEntities", "distinctEntities", "distinctIds", "buildBatchUpdateSql", "queryBySourceIdAndKeyPairs", "insertOrReplaceAll", "insertSingle", "entity", "executeRawQuery", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "queryIdBySourceIdAndKey", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "isExistsBySourceIdAndKey", "", "batchQueryByKeys", "keys", "batchDeleteByKeys", "batchQueryBySourceIdAndKeys", "batchDeleteBySourceIdAndKeys", "batchDeleteBySourceId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MemoryKeyInfoDao implements BaseDao<MemoryKeyInfoEntity> {
    public MemoryKeyInfoDao() {
    }

    private final String buildBatchUpdateSql(String r11, List<MemoryKeyInfoEntity> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        String r13 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$MemoryKeyInfoDao$W0pifo29KQZfTvltyt6ZlQyca7s.INSTANCE, 30, null);
        String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("','", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$MemoryKeyInfoDao$rTBQlQVyf49v78mE0hXUXd0ZZCE.INSTANCE, 30, null);
        return StringsKt.trimIndent("\n            UPDATE MemoryKeyInfoEntity \n            SET value = CASE " + r13 + " END \n            WHERE sourceEntityId = '" + MemoryKeyInfoEntityDaoKt.access$escapeSql(r11) + "' AND `key` IN ('" + r14 + "')\n        ");
    }

    private static final CharSequence buildBatchUpdateSql$lambda$23(MemoryKeyInfoEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        return (CharSequence) ZeusTransformUtils.preCheckCast("WHEN `key` = '" + MemoryKeyInfoEntityDaoKt.access$escapeSql(r3.getKey()) + "' THEN '" + MemoryKeyInfoEntityDaoKt.access$escapeSql(w.a(r3.getValue())) + '\'', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence buildBatchUpdateSql$lambda$24(MemoryKeyInfoEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(MemoryKeyInfoEntityDaoKt.access$escapeSql(r2.getKey()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final List<Long> executeUpsertCore(List<MemoryKeyInfoEntity> r10) {
        List<MemoryKeyInfoEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L33;
        return CollectionsKt.emptyList();
    L33:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        MemoryKeyInfoDao r9 = (MemoryKeyInfoDao) ZeusTransformUtils.preCheckCast(this, MemoryKeyInfoDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r9.insertOrReplaceAll(r11);     // Catch: Throwable -> L21
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9.queryBySourceIdAndKeyPairs(r11), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L21
    L9:
        if (r13.hasNext() == false) goto L11;
        MemoryKeyInfoEntity r6 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r13.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Pair r7 = TuplesKt.to(TuplesKt.to(r6.getSourceEntityId(), r6.getKey()), Long.valueOf(r6.getId()));     // Catch: Throwable -> L21
        r5.put(r7.getFirst(), r7.getSecond());     // Catch: Throwable -> L21
        goto L9
    L11:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L21
    L13:
        if (r15.hasNext() == false) goto L19;
        MemoryKeyInfoEntity r16 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r15.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Long r17 = (Long) ZeusTransformUtils.preCheckCast(r5.get(TuplesKt.to(r16.getSourceEntityId(), r16.getKey())), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r17 == null) goto L17;
        long r18 = r17.longValue();     // Catch: Throwable -> L21
    L18:
        r8.add(Long.valueOf(r18));     // Catch: Throwable -> L21
        goto L13
    L17:
        r18 = -1;
        goto L18
    L19:
        Object r19 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L23:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L32;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "[executeUpsertCore] 失败: " + r20.getMessage(), r20);
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r21.iterator();
    L28:
        if (r22.hasNext() == false) goto L30;
        MemoryKeyInfoEntity r0 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r22.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        r110.add(-1L);
        goto L28
    L30:
        r19 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
    L21:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public static /* synthetic */ CharSequence lambda$W0pifo29KQZfTvltyt6ZlQyca7s(MemoryKeyInfoEntity r0) {
        return buildBatchUpdateSql$lambda$23(r0);
    }

    public static /* synthetic */ CharSequence lambda$rTBQlQVyf49v78mE0hXUXd0ZZCE(MemoryKeyInfoEntity r0) {
        return buildBatchUpdateSql$lambda$24(r0);
    }

    private final List<Long> mapResultToOriginalOrder(List<MemoryKeyInfoEntity> r7, List<MemoryKeyInfoEntity> r8, List<Long> r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r14.next(), Pair.class, "com.obric.memorydata.plugin");
        MemoryKeyInfoEntity r2 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r1.component1(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Pair r4 = TuplesKt.to(TuplesKt.to(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2.getSourceEntityId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r2.getKey()), Long.valueOf(r3));
        r13.put(r4.getFirst(), r4.getSecond());
        goto L4
    L6:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L15;
        MemoryKeyInfoEntity r18 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r17.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        Long r19 = (Long) ZeusTransformUtils.preCheckCast(r13.get(TuplesKt.to(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18.getSourceEntityId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r18.getKey())), Long.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L12;
        long r5 = r19.longValue();
    L13:
        r16.add(Long.valueOf(r5));
        goto L8
    L12:
        r5 = -1;
        goto L13
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    }

    private final List<MemoryKeyInfoEntity> queryBySourceIdAndKeyPairs(List<MemoryKeyInfoEntity> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r2 = r10.next();
        String r3 = ((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r2, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).getSourceEntityId();
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L4
    L9:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r7.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.add(((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r13.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).getKey());
        goto L14
    L16:
        CollectionsKt.addAll(r11, (Iterable) ZeusTransformUtils.preCheckCast(batchQueryBySourceIdAndKeys(r6, (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L11
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    }

    public abstract int batchDeleteByKeys(List<String> r1);

    public abstract int batchDeleteBySourceId(String r1);

    public abstract int batchDeleteBySourceIdAndKeys(String r1, List<String> r2);

    public List<Long> batchInsert(List<MemoryKeyInfoEntity> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entities");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L23;
        MemoryKeyInfoEntity r2 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r11.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        MemoryKeyInfoDao r4 = (MemoryKeyInfoDao) ZeusTransformUtils.preCheckCast(this, MemoryKeyInfoDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r2.isValid() == false) goto L14;
        Long r5 = r4.queryIdBySourceIdAndKey(r2.getSourceEntityId(), r2.getKey());     // Catch: Throwable -> L15
        if (r5 == null) goto L11;
        long r6 = r5.longValue();     // Catch: Throwable -> L15
    L12:
        Object r7 = Result.m1421constructorimpl(Long.valueOf(r6));     // Catch: Throwable -> L15
    L17:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r7);
        if (r12 == null) goto L21;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "[batchInsert] key=" + r2.getKey() + " 失败: " + r12.getMessage(), r12);
        r7 = -1L;
    L21:
        r0.add(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue()));
        goto L4
    L11:
        r6 = r4.insertSingle(r2);     // Catch: Throwable -> L15
        goto L12
    L14:
        throw new IllegalArgumentException("核心字段无效".toString());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public abstract List<MemoryKeyInfoEntity> batchQueryByKeys(List<String> r1);

    public abstract List<MemoryKeyInfoEntity> batchQueryBySourceIdAndKeys(String r1, List<String> r2);

    public int batchUpdateOptimized(List<MemoryKeyInfoEntity> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entities");
        if (r9.isEmpty() == false) goto L5;
        return 0;
    L5:
        String r0 = ((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r9), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).getSourceEntityId();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L8;
    L10:
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r4.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).getSourceEntityId(), r0) == true) goto L12;
        r5 = false;
    L16:
        if (r5 == false) goto L38;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r7 = r11.next();
        if (((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r7, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).isValid() == false) goto L19;
        r6.add(r7);
        goto L19
    L23:
        List<MemoryKeyInfoEntity> r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L26;
        return 0;
    L26:
        String r13 = buildBatchUpdateSql(r0, r12);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L29
        Object r15 = Result.m1421constructorimpl(Integer.valueOf(((MemoryKeyInfoDao) ZeusTransformUtils.preCheckCast(this, MemoryKeyInfoDao.class, "com.obric.memorydata.plugin")).executeRawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r13), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L29
    L31:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L36;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "[batchUpdateOptimized] sourceId=" + r0 + " 失败: " + r16.getMessage(), r16);
        r15 = 0;
    L36:
        return ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue();
    L29:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    L38:
        throw new IllegalArgumentException("批量更新仅支持同一个 sourceEntityId".toString());
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    public List<Long> batchUpsert(List<MemoryKeyInfoEntity> r5) {
        List<MemoryKeyInfoEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entities");
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "batch upsert failed, entities: " + q.f13259a.b(r6.toString()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L4:
        if (r6.isEmpty() == true) goto L6;
        List<MemoryKeyInfoEntity> r0 = MemoryKeyInfoEntityDaoKt.access$normalizeAndDistinct(r6);     // Catch: SQLiteConstraintException -> L9
        return mapResultToOriginalOrder(r6, r0, executeUpsertCore(r0));
    L6:
        return CollectionsKt.emptyList();
    }

    public List<Long> batchUpsertManual(String r12, String r13, Collection<String> r14) {
        Collection r15 = (Collection) ZeusTransformUtils.wrapperContextForParams(r14, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r13, "key");
        Intrinsics.checkNotNullParameter(r15, EventBody.KEY_VALUE);
        List<MemoryKeyInfoEntity> r1 = MemoryKeyInfoEntity.Companion.a(r12, MapsKt.mapOf(TuplesKt.to(r13, r15)));     // Catch: SQLiteConstraintException -> L9
        RunLog.INSTANCE.debug("MemoryKeyInfoDao", "[batchUpsertManual] entities=" + r1);     // Catch: SQLiteConstraintException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryKeyInfoDao", "[batchUpsertManual] batchDeleteBySourceId=" + r12 + ", delete count=" + batchDeleteBySourceIdAndKeys(r12, CollectionsKt.listOf(r13)), false, 4, null);     // Catch: SQLiteConstraintException -> L9
        if (r1.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    L8:
        return insertOrReplaceAll(r1);
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "doesn't exist sourceEntityId: " + r12 + ", key: " + q.f13259a.b(r13) + ", value: " + q.f13259a.b(r15.toString()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    }

    public List<Long> batchUpsertManual(String r11, Map<String, ? extends Collection<String>> r12) {
        Map<String, ? extends Collection<String>> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r13, "keyValueMap");
        List<MemoryKeyInfoEntity> r14 = MemoryKeyInfoEntity.Companion.a(r11, r13);     // Catch: SQLiteConstraintException -> L9
        RunLog.INSTANCE.debug("MemoryKeyInfoDao", "[batchUpsertManual] entities=" + r14);     // Catch: SQLiteConstraintException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryKeyInfoDao", "[batchUpsertManual] batchDeleteBySourceId=" + r11 + ", delete count=" + batchDeleteBySourceId(r11), false, 4, null);     // Catch: SQLiteConstraintException -> L9
        if (r14.isEmpty() == false) goto L13;
        return CollectionsKt.emptyList();
    L13:
        return insertOrReplaceAll(r14);
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryKeyInfoDao", "doesn't exist sourceEntityId: " + r11, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return BaseDao.DefaultImpls.deleteAll(this);
    }

    public abstract int executeRawQuery(SupportSQLiteQuery r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return "MemoryKeyInfoEntity";
    }

    public abstract List<Long> insertOrReplaceAll(List<MemoryKeyInfoEntity> r1);

    public abstract long insertSingle(MemoryKeyInfoEntity r1);

    public abstract boolean isExistsBySourceIdAndKey(String r1, String r2);

    public abstract i<MemoryKeyInfoEntity> observeAddressBySourceId(String r1);

    public abstract i<List<MemoryKeyInfoEntity>> observeAddresses();

    public abstract i<List<MemoryKeyInfoEntity>> observeAllKeysBySourceIdFlow(String r1);

    public abstract i<List<MemoryKeyInfoEntity>> observeBySourceIdAndKeyTypes(String r1, List<String> r2);

    public final i<Map<String, List<String>>> observeFullKeyValueMapBySourceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceId");
        final i<List<MemoryKeyInfoEntity>> r1 = observeAllKeysBySourceIdFlow(r2);
        return (i) ZeusTransformUtils.preCheckCast(new MemoryKeyInfoDao$observeFullKeyValueMapBySourceId$$inlined$map$1(r1), i.class, "com.obric.memorydata.plugin");
    }

    public abstract i<MemoryKeyInfoEntity> observeIdentifierBySourceId(String r1);

    public abstract i<List<MemoryKeyInfoEntity>> observeIdentifiers();

    public final i<Map<String, List<String>>> observeKeyValueMapBySourceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceId");
        final i<List<MemoryKeyInfoEntity>> r1 = observeAllKeysBySourceIdFlow(r2);
        return (i) ZeusTransformUtils.preCheckCast(new MemoryKeyInfoDao$observeKeyValueMapBySourceId$$inlined$map$1(r1), i.class, "com.obric.memorydata.plugin");
    }

    public abstract i<MemoryKeyInfoEntity> observePhoneBySourceId(String r1);

    public abstract i<List<MemoryKeyInfoEntity>> observePhones();

    public abstract i<MemoryKeyInfoEntity> observeUrlBySourceId(String r1);

    public abstract i<List<MemoryKeyInfoEntity>> observeUrls();

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryKeyInfoEntity> queryAll() {
        return BaseDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return BaseDao.DefaultImpls.queryAllCount(this);
    }

    public abstract List<MemoryKeyInfoEntity> queryAllKeysBySourceId(String r1);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryKeyInfoEntity queryById(long r1) {
        return (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById(this, r1), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryKeyInfoEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryKeyInfoEntity> queryByIds(List<Long> r3) {
        return BaseDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public abstract List<MemoryKeyInfoEntity> queryByKeyTypes(List<String> r1);

    public abstract List<MemoryKeyInfoEntity> queryBySourceIdAndKeyTypes(String r1, List<String> r2);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryKeyInfoEntity queryByUUID(String r2) {
        return (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID(this, r2), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryKeyInfoEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    public abstract Long queryIdBySourceIdAndKey(String r1, String r2);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryKeyInfoEntity queryOne() {
        return (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne(this), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryKeyInfoEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryKeyInfoEntity> queryWithLimitAndOffset(int r1, int r2) {
        return BaseDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }
}
