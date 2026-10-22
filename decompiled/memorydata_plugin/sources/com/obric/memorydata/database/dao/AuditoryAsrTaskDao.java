package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001d\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH'J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000b\u001a\u00020\bH'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH'J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH'J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH'J:\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0003H'J8\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0003H'J@\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0003H'J \u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0003H'J8\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0003H'J0\u0010%\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0003H'J8\u0010'\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH'J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH'¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/dao/AuditoryAsrTaskDao;", "", "insert", "", "task", "Lcom/obric/memorydata/database/entity/AuditoryAsrTaskEntity;", "queryByTaskId", "taskId", "", "deleteByTaskId", "", "accountScope", "deleteByAccount", "queryTaskIdsByAccount", "", "queryAllTaskIds", "queryExpiredTerminal", "cutoffMs", "limit", "queryUnreportedTerminal", "transition", "expectedStatus", "targetStatus", "tosKey", "updatedAt", "markRetry", "retryCount", "errorCode", "finish", "terminalStatus", "evidenceState", "terminalAt", "finishActiveByAccount", "updateRequestIds", "submitLogId", "resultLogId", "requestLogIds", "markPipelineTerminal", "expectedRequestLogIds", "finishDone", "observationId", "rawObservationIds", "countActiveByAccount", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AuditoryAsrTaskDao {
    int countActiveByAccount(String r1);

    int deleteByAccount(String r1);

    int deleteByTaskId(String r1, String r2);

    int finish(String r1, String r2, String r3, String r4, String r5, String r6, long r7);

    int finishActiveByAccount(String r1, String r2, long r3);

    int finishDone(String r1, String r2, long r3, String r5, String r6, String r7);

    long insert(AuditoryAsrTaskEntity r1);

    int markPipelineTerminal(String r1, String r2, String r3, String r4, long r5);

    int markRetry(String r1, String r2, String r3, int r4, String r5, long r6);

    List<String> queryAllTaskIds();

    AuditoryAsrTaskEntity queryByTaskId(String r1);

    List<AuditoryAsrTaskEntity> queryExpiredTerminal(long r1, int r3);

    List<String> queryTaskIdsByAccount(String r1);

    List<AuditoryAsrTaskEntity> queryUnreportedTerminal(String r1, int r2);

    int transition(String r1, String r2, String r3, String r4, String r5, long r6);

    int updateRequestIds(String r1, String r2, String r3, String r4, String r5, long r6);
}
