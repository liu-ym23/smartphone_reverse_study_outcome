package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096\u0001J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0096\u0001J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0097\u0001J'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0097\u0001J5\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0013H\u0096\u0001J?\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0096\u0001J)\u0010\u001b\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0096\u0001J!\u0010\u001f\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\bH\u0096\u0001J\t\u0010!\u001a\u00020\u0019H\u0096\u0001JC\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0096\u0001J{\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\t\u001a\u00020\n2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0006\u0010%\u001a\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0096\u0001J\u00ad\u0001\u0010+\u001a2\u0012\u0004\u0012\u00020,\u0012(\u0012&\u0012\u0004\u0012\u00020\b\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00130\u00070\u00130\u00132\u0006\u0010\t\u001a\u00020\n2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00132\u0006\u0010%\u001a\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010-\u001a\u00020\u0019H\u0096\u0001JN\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0\u00130\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010%\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0002\u00102J\\\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0\u00130\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010%\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0002\u00105J!\u00106\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u00107\u001a\u00020\bH\u0097\u0001J\u0019\u00108\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0019H\u0096\u0001¨\u0006;"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/AppEntityIndexBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IAppEntityIndexBridgeAPI;", "<init>", "()V", "deleteIndex", "", "entityIds", "", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "deleteMetaFullContentKeyword", "rawDbIdList", "", "executeIndexTask", "pendingIdList", "indexPackageName", "executeIndexTaskByDbType", "", "pendingIdsByDbType", "getFeature", "", "featureName", "indexEntity", "", "entityDataJson", "insertCopilotText", "rawDbId", "columnName", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "insertMetaFullContentKeyword", "fullContent", "isSlowEntityIndexModelReady", "queryByKeywordIndex", "columns", "keyword", "limit", "targetIds", "queryByKeywordIndexForMultiKeywords", "keywordToColumns", "keywordToSynonymColumns", "keywordToHomonymColumns", "queryMatchedColumns", "Lcom/obric/memorydata/middleware/api/bridge/MatchType;", "isFullMatch", "queryMetaInfoFullContentByKeyword", "", "matchTypes", "keywords", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "queryMetaInfoFullContentByKeywordWithKeys", "keys", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "trackEntityIndex", "type", "trackEntityIndexV2", "trackSlowEntityIndexMatchCondition", "isChargingAndScreenOff", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppEntityIndexBridgeAPI implements IAppEntityIndexBridgeAPI {
    public static final AppEntityIndexBridgeAPI INSTANCE = null;
    private final /* synthetic */ IAppEntityIndexBridgeAPI $$delegate_0;

    static {
        INSTANCE = new AppEntityIndexBridgeAPI();
    }

    private AppEntityIndexBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAppEntityIndexBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAppEntityIndexBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IAppEntityIndexBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void deleteIndex(List<String> r3, int r4, String r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entityIds");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.deleteIndex(r6, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void deleteMetaFullContentKeyword(int r3, List<Long> r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rawDbIdList");
        this.$$delegate_0.deleteMetaFullContentKeyword(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "executeIndexTaskByDbType()", imports = {}))
    public List<Long> executeIndexTask(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pendingIdList");
        return this.$$delegate_0.executeIndexTask(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "executeIndexTaskByDbType()", imports = {}))
    public List<Long> executeIndexTask(List<Long> r3, String r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pendingIdList");
        return this.$$delegate_0.executeIndexTask(r5, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r3) {
        Map<String, ? extends List<Long>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pendingIdsByDbType");
        return this.$$delegate_0.executeIndexTaskByDbType(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r3, String r4) {
        Map<String, ? extends List<Long>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pendingIdsByDbType");
        return this.$$delegate_0.executeIndexTaskByDbType(r5, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeature(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean indexEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityDataJson");
        return this.$$delegate_0.indexEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean insertCopilotText(int r8, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "columnName");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return this.$$delegate_0.insertCopilotText(r8, r9, r11, r12);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean insertMetaFullContentKeyword(int r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "fullContent");
        return this.$$delegate_0.insertMetaFullContentKeyword(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean isSlowEntityIndexModelReady() {
        return this.$$delegate_0.isSlowEntityIndexModelReady();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> queryByKeywordIndex(int r10, List<String> r11, String r12, long r13, List<Long> r15) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "columns");
        Intrinsics.checkNotNullParameter(r12, "keyword");
        Intrinsics.checkNotNullParameter(r8, "targetIds");
        return this.$$delegate_0.queryByKeywordIndex(r10, r4, r12, r13, r8);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> queryByKeywordIndexForMultiKeywords(int r11, Map<String, ? extends List<String>> r12, Map<String, ? extends List<String>> r13, Map<String, ? extends List<String>> r14, long r15, List<Long> r17) {
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        List<Long> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r5, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r6, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r9, "targetIds");
        return this.$$delegate_0.queryByKeywordIndexForMultiKeywords(r11, r4, r5, r6, r15, r9);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<MatchType, Map<String, List<Map<Long, List<String>>>>> queryMatchedColumns(int r12, Map<String, ? extends List<String>> r13, Map<String, ? extends List<String>> r14, Map<String, ? extends List<String>> r15, long r16, List<Long> r18, boolean r19) {
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        List<Long> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r5, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r6, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r9, "targetIds");
        return this.$$delegate_0.queryMatchedColumns(r12, r4, r5, r6, r16, r9, r19);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Map<Long, Double>> queryMetaInfoFullContentByKeyword(Integer r9, List<Integer> r10, List<String> r11, long r12) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "matchTypes");
        Intrinsics.checkNotNullParameter(r5, "keywords");
        return this.$$delegate_0.queryMetaInfoFullContentByKeyword(r9, r4, r5, r12);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Map<Long, Double>> queryMetaInfoFullContentByKeywordWithKeys(Integer r10, List<Integer> r11, List<String> r12, List<Long> r13, long r14) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "matchTypes");
        Intrinsics.checkNotNullParameter(r5, "keywords");
        Intrinsics.checkNotNullParameter(r6, "keys");
        return this.$$delegate_0.queryMetaInfoFullContentByKeywordWithKeys(r10, r4, r5, r6, r14);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    @Deprecated(message = "not used")
    public void trackEntityIndex(long r2, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.$$delegate_0.trackEntityIndex(r2, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void trackEntityIndexV2(long r1, int r3) {
        this.$$delegate_0.trackEntityIndexV2(r1, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void trackSlowEntityIndexMatchCondition(boolean r1) {
        this.$$delegate_0.trackSlowEntityIndexMatchCondition(r1);
    }
}
