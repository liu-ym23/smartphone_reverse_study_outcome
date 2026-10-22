package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0096\u0001J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J!\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fH\u0096\u0001J!\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0096\u0001J-\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\tH\u0096\u0001J\t\u0010 \u001a\u00020!H\u0096\u0001J!\u0010\"\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0096\u0001J+\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0018\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\t0\u000bH\u0096\u0001J!\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0096\u0001¨\u0006("}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/EntitySearchBridgeApi;", "Lcom/obric/memorydata/middleware/api/bridge/IEntitySearchBridgeApi;", "<init>", "()V", "addFieldPrefix", "", "taskId", "", "prefixMap", "", "awaitParallelTaskResult", "", "", "searchTaskId", "parallelTaskId", "clearParamsData", "extractData", "dataId", "field", "getAssistantSearchSwitchStatus", "getDataLength", "getEmbeddingTypeForQuery", "getPartialAccessPhotoEntityIds", "getResultData", "resultId", "intersection", "firstDataId", "secondDataId", "invokeSearchMethod", "methodName", TrackerImpl.PARAMS, "", "isPartialPhotoAccess", "", "notifySortedSearchResult", "resultListJson", "paginationResultParams", "runParallelTask", "methods", "union", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchBridgeApi implements IEntitySearchBridgeApi {
    public static final EntitySearchBridgeApi INSTANCE = null;
    private final /* synthetic */ IEntitySearchBridgeApi $$delegate_0;

    static {
        INSTANCE = new EntitySearchBridgeApi();
    }

    private EntitySearchBridgeApi() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEntitySearchBridgeApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IEntitySearchBridgeApi) ZeusTransformUtils.preCheckCast(r0, IEntitySearchBridgeApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void addFieldPrefix(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r5, "prefixMap");
        this.$$delegate_0.addFieldPrefix(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public List<Long> awaitParallelTaskResult(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        return this.$$delegate_0.awaitParallelTaskResult(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void clearParamsData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        this.$$delegate_0.clearParamsData(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long extractData(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        Intrinsics.checkNotNullParameter(r5, "field");
        return this.$$delegate_0.extractData(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getAssistantSearchSwitchStatus() {
        return this.$$delegate_0.getAssistantSearchSwitchStatus();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long getDataLength(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        return this.$$delegate_0.getDataLength(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getEmbeddingTypeForQuery() {
        return this.$$delegate_0.getEmbeddingTypeForQuery();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public List<Long> getPartialAccessPhotoEntityIds() {
        return this.$$delegate_0.getPartialAccessPhotoEntityIds();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getResultData(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        return this.$$delegate_0.getResultData(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long intersection(String r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "searchTaskId");
        return this.$$delegate_0.intersection(r8, r9, r11);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long invokeSearchMethod(String r3, String r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "searchTaskId");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        return this.$$delegate_0.invokeSearchMethod(r3, r4, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public boolean isPartialPhotoAccess() {
        return this.$$delegate_0.isPartialPhotoAccess();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void notifySortedSearchResult(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        Intrinsics.checkNotNullParameter(r3, "resultListJson");
        Intrinsics.checkNotNullParameter(r4, "paginationResultParams");
        this.$$delegate_0.notifySortedSearchResult(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long runParallelTask(String r3, List<? extends Map<String, ? extends Object>> r4) {
        List<? extends Map<String, ? extends Object>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "searchTaskId");
        Intrinsics.checkNotNullParameter(r5, "methods");
        return this.$$delegate_0.runParallelTask(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long union(String r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "searchTaskId");
        return this.$$delegate_0.union(r8, r9, r11);
    }
}
