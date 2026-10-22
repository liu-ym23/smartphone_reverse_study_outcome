package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J4\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\tH&J>\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&JB\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&Jz\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J®\u0001\u0010\u0016\u001a2\u0012\u0004\u0012\u00020\u0017\u0012(\u0012&\u0012\u0004\u0012\u00020\u0007\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t0\u00030\t0\t2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0019H&JM\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\t0\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u001eJ[\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\t0\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0002\u0010!J(\u0010\"\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H&J \u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0007H'J\u0018\u0010)\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0007H&J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0019H&J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0007H&J&\u00101\u001a\u00020'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0007H&J \u00104\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0007H&J\u001e\u00106\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u00108\u001a\u00020\u0019H&¨\u00069"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IAppEntityIndexBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "executeIndexTask", "", "", "pendingIdList", "indexPackageName", "", "executeIndexTaskByDbType", "", "pendingIdsByDbType", "queryByKeywordIndex", "entityType", "", "columns", "keyword", "limit", "targetIds", "queryByKeywordIndexForMultiKeywords", "keywordToColumns", "keywordToSynonymColumns", "keywordToHomonymColumns", "queryMatchedColumns", "Lcom/obric/memorydata/middleware/api/bridge/MatchType;", "isFullMatch", "", "queryMetaInfoFullContentByKeyword", "", "matchTypes", "keywords", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "queryMetaInfoFullContentByKeywordWithKeys", "keys", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "insertCopilotText", "rawDbId", "columnName", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "trackEntityIndex", "", "type", "trackEntityIndexV2", "getFeature", "", "featureName", "trackSlowEntityIndexMatchCondition", "isChargingAndScreenOff", "indexEntity", "entityDataJson", "deleteIndex", "entityIds", ObricMemoryConstants.KEY_PACKAGE_NAME, "insertMetaFullContentKeyword", "fullContent", "deleteMetaFullContentKeyword", "rawDbIdList", "isSlowEntityIndexModelReady", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppEntityIndexBridgeAPI extends IService {
    void deleteIndex(List<String> r1, int r2, String r3);

    void deleteMetaFullContentKeyword(int r1, List<Long> r2);

    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "executeIndexTaskByDbType()", imports = {}))
    List<Long> executeIndexTask(List<Long> r1);

    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "executeIndexTaskByDbType()", imports = {}))
    List<Long> executeIndexTask(List<Long> r1, String r2);

    Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r1);

    Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r1, String r2);

    Object getFeature(String r1);

    boolean indexEntity(String r1);

    boolean insertCopilotText(int r1, long r2, String r4, String r5);

    boolean insertMetaFullContentKeyword(int r1, long r2, String r4);

    boolean isSlowEntityIndexModelReady();

    List<Long> queryByKeywordIndex(int r1, List<String> r2, String r3, long r4, List<Long> r6);

    List<Long> queryByKeywordIndexForMultiKeywords(int r1, Map<String, ? extends List<String>> r2, Map<String, ? extends List<String>> r3, Map<String, ? extends List<String>> r4, long r5, List<Long> r7);

    Map<MatchType, Map<String, List<Map<Long, List<String>>>>> queryMatchedColumns(int r1, Map<String, ? extends List<String>> r2, Map<String, ? extends List<String>> r3, Map<String, ? extends List<String>> r4, long r5, List<Long> r7, boolean r8);

    List<Map<Long, Double>> queryMetaInfoFullContentByKeyword(Integer r1, List<Integer> r2, List<String> r3, long r4);

    List<Map<Long, Double>> queryMetaInfoFullContentByKeywordWithKeys(Integer r1, List<Integer> r2, List<String> r3, List<Long> r4, long r5);

    @Deprecated(message = "not used")
    void trackEntityIndex(long r1, int r3, String r4);

    void trackEntityIndexV2(long r1, int r3);

    void trackSlowEntityIndexMatchCondition(boolean r1);
}
