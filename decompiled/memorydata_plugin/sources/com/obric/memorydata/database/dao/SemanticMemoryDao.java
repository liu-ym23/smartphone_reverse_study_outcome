package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.paging.PagingSource;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.c.f;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.model.c;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0016\u0010\u0010\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0016\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'J\b\u0010\u001f\u001a\u00020\fH'J\b\u0010 \u001a\u00020\fH'J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0016J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0#2\u0006\u0010$\u001a\u00020\u0004H'J\u001a\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H'J*\u0010(\u001a\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020*H'J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020-H'J'\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000400H'¢\u0006\u0002\u00101J\u001e\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0004H'J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\t2\u0006\u00106\u001a\u000207H'J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002050\t2\u0006\u0010\u001c\u001a\u00020\u0004H\u0017J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002050-H'J'\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002050-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000400H'¢\u0006\u0002\u00101J\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002050-2\b\u00103\u001a\u0004\u0018\u00010\u0004H'J4\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\t2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010?\u001a\u00020*2\b\b\u0002\u0010@\u001a\u00020*H§@¢\u0006\u0002\u0010AJB\u0010B\u001a\b\u0012\u0004\u0012\u00020=0\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0004002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010?\u001a\u00020*2\b\b\u0002\u0010@\u001a\u00020*H§@¢\u0006\u0002\u0010CJ>\u0010D\u001a\b\u0012\u0004\u0012\u00020=0\t2\b\u00103\u001a\u0004\u0018\u00010\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010?\u001a\u00020*2\b\b\u0002\u0010@\u001a\u00020*H§@¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0#H'J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0#H'J!\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000400H'¢\u0006\u0002\u0010IJ\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u00103\u001a\u0004\u0018\u00010\u0004H'J\u0016\u0010K\u001a\u00020\u000e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\b\u0010L\u001a\u00020\u000eH'J\u0010\u0010M\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004H'J\u0018\u0010N\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H'J\b\u0010O\u001a\u00020\fH'J\u0016\u0010P\u001a\u00020\u000e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\b\u0010Q\u001a\u00020\u000eH'J\u0010\u0010R\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004H'J\b\u0010S\u001a\u00020\fH'J\b\u0010T\u001a\u00020\fH'J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020\u0004H'J \u0010X\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010Y\u001a\u00020\fH'J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010Y\u001a\u00020\fH'J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010Y\u001a\u00020\fH'J\b\u0010\\\u001a\u00020\fH'J\u000e\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\tH'J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020^0\tH'J\u0018\u0010`\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0006H'J\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'J\u001c\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002050-2\u0006\u0010$\u001a\u00020\u0004H\u0016J&\u0010d\u001a\b\u0012\u0004\u0012\u0002050\t2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\f2\u0006\u0010e\u001a\u00020\fH\u0017J\u001e\u0010f\u001a\b\u0012\u0004\u0012\u0002050\t2\u0006\u0010Y\u001a\u00020\f2\u0006\u0010e\u001a\u00020\fH\u0017J\u0010\u0010g\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0004H'J\b\u0010h\u001a\u00020\fH'J)\u0010i\u001a\u00020j2\u0006\u0010$\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\f2\b\u0010e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010kJ2\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\f2\b\u0010e\u001a\u0004\u0018\u00010\f2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020p0oH\u0002J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020\f0#2\u0006\u0010$\u001a\u00020\u0004H'J\u001c\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020-2\u0006\u00106\u001a\u000207H'J\u001c\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002050-2\u0006\u00106\u001a\u000207H'J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u0002050\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'J\u0016\u0010u\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'J\b\u0010v\u001a\u00020\fH'J\u000e\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u0016\u0010x\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016J\u0010\u0010y\u001a\u00020\u000e2\u0006\u0010z\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020\u000eH'¨\u0006}"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "getTableName", "", "insertRaw", "", "entity", "insertAllRaw", "", "entities", "updateRaw", "", "updateAllRaw", "", "deleteRaw", "bulkDeleteRaw", "insert", "insertAll", "bulkInsert", BuildConfig.CHANNEL, "updateAll", "delete", "bulkDelete", "deleteByRawDbIds", "rawDbIds", "deleteAll", "queryByEntityId", "entityId", "queryByEntityIds", "entityIds", "countMigrationTotal", "countMigrationCompleted", ObricMemoryConstants.KEY_PACKAGE_NAME, "getMemoryBySemanticTypeFlow", "Lkotlinx/coroutines/flow/Flow;", "semanticType", "getSameMemory", "tagPath", "keyPhrase", "queryDuplicateCandidate", "entityIdsIsEmpty", "", "getUUIDListByEntityIds", "getInfoAllTypeMemory", "Landroidx/paging/PagingSource;", "getInfoOthersTypeMemory", "excludeTags", "", "([Ljava/lang/String;)Landroidx/paging/PagingSource;", "getInfoSingleTagMemory", "tagType", "queryRawWithRelevant", "Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevantPojo;", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "queryByEntityIdWithRelevantPojo", "getInfoAllTypeMemoryWithRelevantPojo", "getInfoOthersTypeMemoryWithRelevantPojo", "getInfoSingleTagMemoryWithRelevantPojo", "getInfoAllTypeMemoryMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "ids", "withSpecifiedRange", "idsIsEmpty", "(Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoOthersTypeMemoryMetaInfo", "([Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoSingleTagMemoryMetaInfo", "(Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoTypeMemoryCount", "getInfoAllTypeMemoryCount", "getInfoOthersTypeMemoryCount", "([Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getInfoSingleTagMemoryCount", "updateUseForInsight", "resetAllUseForInsight", "resetUseForInsightBySemanticType", "resetUseForInsightBySemanticTypeAndTagPath", "getUnprocessedForInsightCount", "updateUseForPersona", "resetAllUseForPersona", "resetUseForPersonaBySemanticType", "getUnprocessedForPersonaCount", "getTotalCount", "getAllOrderByUserEditAndModifyTime", "exists", "memoryEntityId", "queryFormalList", "limit", "queryPendingConfirmationNewest", "queryPendingConfirmationOldest", "countPendingConfirmation", "queryC3ConflictSnapshots", "Lcom/obric/memorydata/database/dao/SemanticConflictSnapshot;", "queryReviewConflictSnapshots", "requeueConflictKeeper", "changeSeq", "queryEffectiveConflicts", "queryPagedBySemanticType", "queryRangeBySemanticTypeWithRelevant", TypedValues.CycleType.S_WAVE_OFFSET, "queryAllRangeWithRelevant", "countBySemanticTypeSync", "countAllInfoSync", "buildSemanticTypeRangeQuery", "Landroidx/sqlite/db/SimpleSQLiteQuery;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Landroidx/sqlite/db/SimpleSQLiteQuery;", "appendLimitOffset", "baseSql", "args", "", "", "getCountBySemanticType", "queryPagedRaw", "queryPagedRawWithRelevant", "getMemoryWithRelevantByEntityIds", "deleteEntityByEntityIdsRaw", "deleteAllRaw", "queryAllRawDbIds", "deleteByEntityIds", "launchIndexReconciliation", "result", "Lcom/obric/memorydata/database/dao/SemanticDeleteResult;", "resetSequence", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SemanticMemoryDao extends IAppEntityRawDbDao<ip> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        private static String appendLimitOffset(SemanticMemoryDao r2, String r3, Integer r4, Integer r5, List<Object> r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return r3;
        L5:
            r8.add(r4);
            if (r5 != null) goto L8;
        L10:
            StringBuilder r9 = new StringBuilder().append(r3);
            String r10 = " LIMIT ?";
        L12:
            return r9.append(r10).toString();
        L8:
            if (r5.intValue() <= 0) goto L10;
            r8.add(r5);
            r9 = new StringBuilder().append(r3);
            r10 = " LIMIT ? OFFSET ?";
            goto L12
        }

        public static int backfillContentHashIfAbsent(SemanticMemoryDao r8, long r9, long r11, long r13, String r15) {
            SemanticMemoryDao r10 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static SimpleSQLiteQuery buildSemanticTypeRangeQuery(SemanticMemoryDao r12, String r13, Integer r14, Integer r15) {
            SemanticMemoryDao r16 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r12, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "semanticType");
            List<String> r0 = ip.f9231a.a(r13);
            if (r0.isEmpty() == false) goto L6;
            List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r1.add(r13);
            return new SimpleSQLiteQuery(appendLimitOffset(r16, "SELECT * FROM UnionSemanticMemory WHERE semantic_type = ? AND product_type != 1004 AND confidence = 4.0 ORDER BY modifyTime DESC", r14, r15, r1), ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]));
        L6:
            List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r2.add(r13);
            String r17 = StringsKt.replace$default("COALESCE(\n    NULLIF(\n        TRIM(\n            CASE WHEN INSTR(TRIM(tag_path), ',') > 0\n                 THEN SUBSTR(TRIM(tag_path), 1, INSTR(TRIM(tag_path), ',') - 1)\n                 ELSE TRIM(tag_path)\n            END\n        ),\n        ''\n    ),\n    '其他'\n)", "\n", " ", false, 4, null);
            StringBuilder r4 = new StringBuilder("CASE " + r17 + ' ');
            r4.append("WHEN ? THEN 2 ");
            r2.add(IRecommendSettings.ProfileTag.OTHER);
            Iterator<String> r8 = r0.iterator();
        L8:
            if (r8.hasNext() == false) goto L12;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r9, IRecommendSettings.ProfileTag.OTHER) == true) goto L8;
            r4.append("WHEN ? THEN 0 ");
            r2.add(r9);
            goto L8
        L12:
            r4.append("ELSE 1 END");
            StringBuilder r5 = new StringBuilder("CASE " + r17 + ' ');
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r6 = 0;
        L14:
            if (r3.hasNext() == false) goto L19;
            Object r10 = r3.next();
            int r11 = r6 + 1;
            if (r6 >= 0) goto L18;
            CollectionsKt.throwIndexOverflow();
        L18:
            String r18 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
            r5.append("WHEN ? THEN " + r6 + ' ');
            r2.add(r18);
            r6 = r11;
            goto L14
        L19:
            r5.append("ELSE 0 END");
            return new SimpleSQLiteQuery(appendLimitOffset(r16, StringsKt.trimIndent("\n        SELECT * FROM UnionSemanticMemory\n        WHERE semantic_type = ?\n        AND product_type != 1004\n        AND confidence = 4.0\n        ORDER BY\n            " + r4 + " ASC,\n            " + r5 + " ASC,\n            " + r17 + " ASC,\n            modifyTime DESC\n    "), r14, r15, r2), ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]));
        }

        public static void bulkDelete(SemanticMemoryDao r8, List<ip> r9) {
            SemanticMemoryDao r10 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "entities");
            SemanticDeleteLifecycle r2 = SemanticDeleteLifecycle.INSTANCE;
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r13 = r12.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            ip r0 = (ip) ZeusTransformUtils.preCheckCast(r13.next(), ip.class, "com.obric.memorydata.plugin");
            Pair r1 = TuplesKt.to(r0.getEntityId(), Long.valueOf(r0.r()));
            r3.put(r1.getFirst(), r1.getSecond());
            goto L4
        L6:
            launchIndexReconciliation(r10, SemanticDeleteLifecycle.deleteExpected$default(r2, r3, null, false, 6, null));
        }

        public static void bulkInsert(SemanticMemoryDao r2, List<ip> r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<ip> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entities");
            r4.insertAll(r5);
        }

        public static int delete(SemanticMemoryDao r7, ip r8) {
            SemanticMemoryDao r9 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r7, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "entity");
            SemanticDeleteResult r10 = SemanticDeleteLifecycle.deleteExpected$default(SemanticDeleteLifecycle.INSTANCE, MapsKt.mapOf(TuplesKt.to(r8.getEntityId(), Long.valueOf(r8.r()))), null, false, 6, null);
            launchIndexReconciliation(r9, r10);
            return r10.getDeleted();
        }

        public static int deleteAll(SemanticMemoryDao r2) {
            SemanticMemoryDao r3 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            SemanticDeleteResult r0 = SemanticDeleteLifecycle.INSTANCE.clearAllWithFence();
            launchIndexReconciliation(r3, r0);
            return r0.getDeleted();
        }

        public static void deleteByEntityIds(SemanticMemoryDao r3, List<String> r4) {
            SemanticMemoryDao r5 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r3, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            if (r6.isEmpty() == false) goto L5;
            return;
        L5:
            launchIndexReconciliation(r5, SemanticDeleteLifecycle.deleteByEntityIds$default(SemanticDeleteLifecycle.INSTANCE, r6, null, 2, null));
        }

        public static int deleteByRawDbIds(SemanticMemoryDao r2, List<Long> r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            if (r5.isEmpty() == false) goto L6;
            return 0;
        L6:
            SemanticDeleteResult r6 = SemanticDeleteLifecycle.INSTANCE.deleteByRawDbIds(r5);
            launchIndexReconciliation(r4, r6);
            return r6.getDeleted();
        }

        public static int getCountByPackageName(SemanticMemoryDao r2, String r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(SemanticMemoryDao r6, String r7, long r8, long r10) {
            SemanticMemoryDao r9 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(SemanticMemoryDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(SemanticMemoryDao r6, String r7, long r8, long r10) {
            SemanticMemoryDao r9 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static /* synthetic */ Object getInfoAllTypeMemoryMetaInfo$default(SemanticMemoryDao r2, List r3, boolean r4, boolean r5, Continuation r6, int r7, Object r8) {
            SemanticMemoryDao r9 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = r10.isEmpty();
        L8:
            return r9.getInfoAllTypeMemoryMetaInfo(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoAllTypeMemoryMetaInfo");
        }

        public static /* synthetic */ Object getInfoOthersTypeMemoryMetaInfo$default(SemanticMemoryDao r8, String[] r9, List r10, boolean r11, boolean r12, Continuation r13, int r14, Object r15) {
            SemanticMemoryDao r2 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 8) == 0) goto L8;
            r12 = r4.isEmpty();
        L8:
            return r2.getInfoOthersTypeMemoryMetaInfo(r9, r4, r11, r12, r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoOthersTypeMemoryMetaInfo");
        }

        public static /* synthetic */ Object getInfoSingleTagMemoryMetaInfo$default(SemanticMemoryDao r8, String r9, List r10, boolean r11, boolean r12, Continuation r13, int r14, Object r15) {
            SemanticMemoryDao r2 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 8) == 0) goto L8;
            r12 = r4.isEmpty();
        L8:
            return r2.getInfoSingleTagMemoryMetaInfo(r9, r4, r11, r12, r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoSingleTagMemoryMetaInfo");
        }

        public static long getLastModifyTimeByPackageName(SemanticMemoryDao r2, String r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(SemanticMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(SemanticMemoryDao r2) {
            SemanticMemoryDao r3 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            return "UnionSemanticMemory";
        }

        public static long insert(SemanticMemoryDao r4, ip r5) {
            SemanticMemoryDao r6 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r4, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entity");
            long r0 = r6.insertRaw(r5);
            if (r0 <= 0) goto L5;
            r5.setId(r0);
            f.f8859a.a(r5);
        L5:
            return r0;
        }

        public static List<Long> insertAll(SemanticMemoryDao r10, List<ip> r11) {
            SemanticMemoryDao r12 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r10, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<ip> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "entities");
            List<Long> r14 = r12.insertAllRaw(r13);
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r3 = 0;
        L4:
            if (r0.hasNext() == false) goto L16;
            Object r4 = r0.next();
            int r7 = r3 + 1;
            if (r3 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            ip r5 = (ip) ZeusTransformUtils.preCheckCast(r4, ip.class, "com.obric.memorydata.plugin");
            Long r6 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r14, r3), Long.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L11;
            long r8 = r6.longValue();
        L13:
            if (r8 <= 0) goto L15;
            r5.setId(r8);
        L15:
            r3 = r7;
            goto L4
        L11:
            r8 = 0;
            goto L13
        L16:
            f r1 = f.f8859a;
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r15.iterator();
        L18:
            if (r16.hasNext() == false) goto L25;
            Object r17 = r16.next();
            if (((ip) ZeusTransformUtils.preCheckCast(r17, ip.class, "com.obric.memorydata.plugin")).getId() <= 0) goto L22;
            boolean r18 = true;
        L23:
            if (r18 == false) goto L18;
            r9.add(r17);
            goto L18
        L22:
            r18 = false;
            goto L23
        L25:
            r1.a((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"));
            return r14;
        }

        private static void launchIndexReconciliation(SemanticMemoryDao r2, SemanticDeleteResult r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            if (r3.getDeleted() <= 0) goto L6;
            EntityManager.INSTANCE.launchIndexTask();
            return;
        }

        public static List<ip> queryAll(SemanticMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(SemanticMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<ih> queryAllRangeWithRelevant(SemanticMemoryDao r4, int r5, int r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r4, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            return r7.queryRawWithRelevant((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(appendLimitOffset(r7, "SELECT * FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 ORDER BY modifyTime DESC", Integer.valueOf(r5), Integer.valueOf(r6), r0), ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0])), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static ip queryByEntityId(SemanticMemoryDao r5, String r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r5, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            return (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = ? LIMIT 1", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), ip.class, "com.obric.memorydata.plugin");
        }

        public static List<ip> queryByEntityId(SemanticMemoryDao r3, String r4, String r5) {
            SemanticMemoryDao r6 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r3, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "entityId");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE entityId = '" + r4 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<ip> queryByEntityIdList(SemanticMemoryDao r2, List<String> r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<ip> queryByEntityIdListAndPackageName(SemanticMemoryDao r2, List<String> r3, String r4) {
            SemanticMemoryDao r5 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<ih> queryByEntityIdWithRelevantPojo(SemanticMemoryDao r5, String r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r5, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            return r7.queryRawWithRelevant((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = ?", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static ip queryById(SemanticMemoryDao r2, long r3) {
            return (ip) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), ip.class, "com.obric.memorydata.plugin");
        }

        public static List<ip> queryByIdAndTimestamp(SemanticMemoryDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<ip> queryByIds(SemanticMemoryDao r2, List<Long> r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(SemanticMemoryDao r2, String[] r3, String r4, int r5, Long r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<ip> queryByPackageName(SemanticMemoryDao r2, String r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<ip> queryByPackageNameBeforeTimestampWithLimit(SemanticMemoryDao r7, String r8, long r9, int r11, long r12) {
            SemanticMemoryDao r10 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r7, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<ip> queryByPackageNameWithLimit(SemanticMemoryDao r2, String r3, int r4, long r5) {
            SemanticMemoryDao r6 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static ip queryByUUID(SemanticMemoryDao r2, String r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ip) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), ip.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ ip queryDuplicateCandidate$default(SemanticMemoryDao r2, List r3, String r4, boolean r5, int r6, Object r7) {
            SemanticMemoryDao r8 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = r9.isEmpty();
        L8:
            return r8.queryDuplicateCandidate(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryDuplicateCandidate");
        }

        public static ip queryOne(SemanticMemoryDao r2) {
            return (ip) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), ip.class, "com.obric.memorydata.plugin");
        }

        public static PagingSource<Integer, ih> queryPagedBySemanticType(SemanticMemoryDao r2, String r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "semanticType");
            return r4.queryPagedRawWithRelevant((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r4.buildSemanticTypeRangeQuery(r3, null, null), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<ih> queryRangeBySemanticTypeWithRelevant(SemanticMemoryDao r2, String r3, int r4, int r5) {
            SemanticMemoryDao r6 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "semanticType");
            return r6.queryRawWithRelevant((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r6.buildSemanticTypeRangeQuery(r3, Integer.valueOf(r4), Integer.valueOf(r5)), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<ip> queryRecentByPackageName(SemanticMemoryDao r2, String r3, long r4) {
            SemanticMemoryDao r5 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<ip> queryWithLimitAndOffset(SemanticMemoryDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int update(SemanticMemoryDao r2, ip r3) {
            SemanticMemoryDao r4 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entity");
            int r5 = r4.updateRaw(r3);
            if (r5 <= 0) goto L5;
            f.f8859a.a(r3);
        L5:
            return r5;
        }

        public static void updateAll(SemanticMemoryDao r9, List<ip> r10) {
            SemanticMemoryDao r11 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r9, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List<ip> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "entities");
            r11.updateAllRaw(r12);
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r2.add(Long.valueOf(((ip) ZeusTransformUtils.preCheckCast(r1.next(), ip.class, "com.obric.memorydata.plugin")).getId()));
            goto L4
        L6:
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r3.iterator();
        L8:
            if (r5.hasNext() == false) goto L15;
            Object r6 = r5.next();
            if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == false) goto L8;
            r4.add(r6);
            goto L8
        L12:
            r7 = false;
            goto L13
        L15:
            List<Long> r8 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
            if (r8.isEmpty() == false) goto L18;
            return;
        L18:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11.queryByIds(r8), Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L20:
            if (r15.hasNext() == false) goto L22;
            r14.add(Long.valueOf(((ip) ZeusTransformUtils.preCheckCast(r15.next(), ip.class, "com.obric.memorydata.plugin")).getId()));
            goto L20
        L22:
            HashSet r16 = CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            f r17 = f.f8859a;
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r110 = r18.iterator();
        L24:
            if (r110.hasNext() == false) goto L28;
            Object r20 = r110.next();
            if (r16.contains(Long.valueOf(((ip) ZeusTransformUtils.preCheckCast(r20, ip.class, "com.obric.memorydata.plugin")).getId())) == false) goto L24;
            r19.add(r20);
            goto L24
        L28:
            r17.a((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"));
        }

        public static int updatePoisonLabelIfContentHashMatches(SemanticMemoryDao r2, String r3, String r4, int r5, Integer r6) {
            SemanticMemoryDao r7 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    SimpleSQLiteQuery buildSemanticTypeRangeQuery(String r1, Integer r2, Integer r3);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkDelete(List<ip> r1);

    void bulkDeleteRaw(List<ip> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<ip> r1);

    int countAllInfoSync();

    int countBySemanticTypeSync(String r1);

    int countMigrationCompleted();

    int countMigrationTotal();

    int countPendingConfirmation();

    int delete(ip r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    int deleteAllRaw();

    void deleteByEntityIds(List<String> r1);

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    int deleteByRawDbIds(List<Long> r1);

    int deleteEntityByEntityIdsRaw(List<String> r1);

    int deleteRaw(ip r1);

    boolean exists(String r1);

    List<ip> getAllOrderByUserEditAndModifyTime();

    i<Integer> getCountBySemanticType(String r1);

    PagingSource<Integer, ip> getInfoAllTypeMemory();

    i<Integer> getInfoAllTypeMemoryCount();

    Object getInfoAllTypeMemoryMetaInfo(List<String> r1, boolean r2, boolean r3, Continuation<? super List<cu>> r4);

    PagingSource<Integer, ih> getInfoAllTypeMemoryWithRelevantPojo();

    PagingSource<Integer, ip> getInfoOthersTypeMemory(String[] r1);

    i<Integer> getInfoOthersTypeMemoryCount(String[] r1);

    Object getInfoOthersTypeMemoryMetaInfo(String[] r1, List<String> r2, boolean r3, boolean r4, Continuation<? super List<cu>> r5);

    PagingSource<Integer, ih> getInfoOthersTypeMemoryWithRelevantPojo(String[] r1);

    PagingSource<Integer, ip> getInfoSingleTagMemory(String r1);

    i<Integer> getInfoSingleTagMemoryCount(String r1);

    Object getInfoSingleTagMemoryMetaInfo(String r1, List<String> r2, boolean r3, boolean r4, Continuation<? super List<cu>> r5);

    PagingSource<Integer, ih> getInfoSingleTagMemoryWithRelevantPojo(String r1);

    i<Integer> getInfoTypeMemoryCount();

    i<List<ip>> getMemoryBySemanticTypeFlow(String r1);

    List<ih> getMemoryWithRelevantByEntityIds(List<String> r1);

    ip getSameMemory(String r1, String r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    int getTotalCount();

    List<String> getUUIDListByEntityIds(List<String> r1);

    int getUnprocessedForInsightCount();

    int getUnprocessedForPersonaCount();

    long insert(ip r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<ip> r1);

    List<Long> insertAllRaw(List<ip> r1);

    long insertRaw(ip r1);

    List<ih> queryAllRangeWithRelevant(int r1, int r2);

    List<Long> queryAllRawDbIds();

    ip queryByEntityId(String r1);

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    List<ip> queryByEntityId(String r1, String r2);

    List<ih> queryByEntityIdWithRelevantPojo(String r1);

    List<ip> queryByEntityIds(List<String> r1);

    List<SemanticConflictSnapshot> queryC3ConflictSnapshots();

    ip queryDuplicateCandidate(List<String> r1, String r2, boolean r3);

    List<ip> queryEffectiveConflicts(List<String> r1);

    List<ip> queryFormalList(String r1, int r2);

    PagingSource<Integer, ih> queryPagedBySemanticType(String r1);

    PagingSource<Integer, ip> queryPagedRaw(SupportSQLiteQuery r1);

    PagingSource<Integer, ih> queryPagedRawWithRelevant(SupportSQLiteQuery r1);

    List<ip> queryPendingConfirmationNewest(int r1);

    List<ip> queryPendingConfirmationOldest(int r1);

    List<ih> queryRangeBySemanticTypeWithRelevant(String r1, int r2, int r3);

    List<ih> queryRawWithRelevant(SupportSQLiteQuery r1);

    List<SemanticConflictSnapshot> queryReviewConflictSnapshots();

    int requeueConflictKeeper(String r1, long r2);

    void resetAllUseForInsight();

    void resetAllUseForPersona();

    void resetSequence();

    void resetUseForInsightBySemanticType(String r1);

    void resetUseForInsightBySemanticTypeAndTagPath(String r1, String r2);

    void resetUseForPersonaBySemanticType(String r1);

    int update(ip r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void updateAll(List<ip> r1);

    void updateAllRaw(List<ip> r1);

    int updateRaw(ip r1);

    void updateUseForInsight(List<Long> r1);

    void updateUseForPersona(List<Long> r1);
}
