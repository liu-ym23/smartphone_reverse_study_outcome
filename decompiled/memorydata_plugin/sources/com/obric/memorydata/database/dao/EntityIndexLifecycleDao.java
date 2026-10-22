package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.bh;
import com.obric.memorydata.database.index.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b#\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H'Jp\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH'J@\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\tH'J@\u0010!\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\tH'J(\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH'J(\u0010#\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH'JB\u0010$\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000bH'J(\u0010'\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH'J(\u0010)\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH'J\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J(\u0010+\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH'J \u0010,\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH'J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006."}, d2 = {"Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "", "queryAll", "", "Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity;", "queryBacklogRows", "Lcom/obric/memorydata/database/index/IndexBacklogDbRow;", ChatMessage.TYPE_QUERY, "rawDbId", "", "entityType", "", "queryByRawDbIds", "rawDbIds", "insertIfAbsent", "entity", "openRound", "expectedPreviousRoundId", "newRoundId", "startedAtMs", "backlogStartedAtMs", "updatedAtMs", "writeFirstStart", "markAlreadyCompleted", "coveragePolicyVersion", "coverageSourceTimestamp", "coverageRequiredCount", "coverageState", "resetCoverageRound", "policyVersion", "sourceTimestamp", "requiredCount", "expectedRoundId", "updateCoverageRequiredCount", "markFirstCompletionStartedIfAbsent", "markFirstCompletionStartedForNewerSource", "recordCoverageSettlement", "success", "deferredFailure", "closeSuccess", "completedAtMs", "closeWithoutCompletion", "invalidateCoverage", "closeTerminalFailure", "invalidateObservation", "delete", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EntityIndexLifecycleDao {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ int recordCoverageSettlement$default(EntityIndexLifecycleDao r12, long r13, int r15, long r16, int r18, long r19, int r21, int r22, int r23, Object r24) {
            EntityIndexLifecycleDao r1 = (EntityIndexLifecycleDao) ZeusTransformUtils.wrapperContextForParams(r12, EntityIndexLifecycleDao.class, "com.obric.memorydata.plugin");
            if (r24 != null) goto L11;
            if ((r23 & 64) == 0) goto L7;
            int r11 = 0;
        L9:
            return r1.recordCoverageSettlement(r13, r15, r16, r18, r19, r21, r11);
        L7:
            r11 = r22;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordCoverageSettlement");
        }
    }

    int closeSuccess(long r1, int r3, long r4, long r6);

    int closeTerminalFailure(long r1, int r3, long r4, long r6);

    int closeWithoutCompletion(long r1, int r3, long r4, long r6);

    int delete(long r1, int r3);

    long insertIfAbsent(bh r1);

    int invalidateCoverage(long r1, int r3);

    int invalidateObservation(long r1, int r3, long r4);

    int markFirstCompletionStartedForNewerSource(long r1, int r3, long r4, long r6);

    int markFirstCompletionStartedIfAbsent(long r1, int r3, long r4, long r6);

    int openRound(long r1, int r3, long r4, long r6, long r8, long r10, long r12, int r14, int r15, int r16, long r17, int r19, int r20);

    bh query(long r1, int r3);

    List<bh> queryAll();

    List<aa> queryBacklogRows();

    List<bh> queryByRawDbIds(List<Long> r1, int r2);

    int recordCoverageSettlement(long r1, int r3, long r4, int r6, long r7, int r9, int r10);

    int resetCoverageRound(long r1, int r3, int r4, long r5, int r7, int r8, long r9);

    int updateCoverageRequiredCount(long r1, int r3, int r4, long r5, int r7, int r8, long r9);
}
