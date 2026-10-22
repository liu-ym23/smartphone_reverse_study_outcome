package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u000eH&J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H&J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H&J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0005H&J$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH&J \u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0005H&J\b\u0010#\u001a\u00020$H&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IEntitySearchBridgeApi;", "Lcom/bytedance/news/common/service/manager/IService;", "invokeSearchMethod", "", "searchTaskId", "", "methodName", TrackerImpl.PARAMS, "", "", "clearParamsData", "", "runParallelTask", "methods", "", "awaitParallelTaskResult", "parallelTaskId", "notifySortedSearchResult", "resultListJson", "paginationResultParams", "getResultData", "resultId", "getDataLength", "dataId", "intersection", "firstDataId", "secondDataId", "extractData", "field", "addFieldPrefix", "taskId", "prefixMap", "union", "getEmbeddingTypeForQuery", "getAssistantSearchSwitchStatus", "isPartialPhotoAccess", "", "getPartialAccessPhotoEntityIds", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEntitySearchBridgeApi extends IService {
    void addFieldPrefix(String r1, Map<String, String> r2);

    List<Long> awaitParallelTaskResult(String r1, long r2);

    void clearParamsData(String r1);

    long extractData(String r1, long r2, String r4);

    String getAssistantSearchSwitchStatus();

    long getDataLength(String r1, long r2);

    String getEmbeddingTypeForQuery();

    List<Long> getPartialAccessPhotoEntityIds();

    String getResultData(String r1, long r2);

    long intersection(String r1, long r2, long r4);

    long invokeSearchMethod(String r1, String r2, Map<String, ? extends Object> r3);

    boolean isPartialPhotoAccess();

    void notifySortedSearchResult(String r1, String r2, String r3);

    long runParallelTask(String r1, List<? extends Map<String, ? extends Object>> r2);

    long union(String r1, long r2, long r4);
}
