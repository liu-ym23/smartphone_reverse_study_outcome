package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J=\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/InvertedIndexDbBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IInvertedIndexDbBridgeAPI;", "<init>", "()V", "putDocuments", "", "dbName", "", "documentJson", "", "Lorg/json/JSONObject;", "removeDocuments", "search", "", "schemaName", "queryJson", "limit", "targetIds", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvertedIndexDbBridgeAPI implements IInvertedIndexDbBridgeAPI {
    public static final InvertedIndexDbBridgeAPI INSTANCE = null;
    private final /* synthetic */ IInvertedIndexDbBridgeAPI $$delegate_0;

    static {
        INSTANCE = new InvertedIndexDbBridgeAPI();
    }

    private InvertedIndexDbBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IInvertedIndexDbBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IInvertedIndexDbBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IInvertedIndexDbBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public boolean putDocuments(String r3, List<? extends JSONObject> r4) {
        List<? extends JSONObject> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dbName");
        Intrinsics.checkNotNullParameter(r5, "documentJson");
        return this.$$delegate_0.putDocuments(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public boolean removeDocuments(String r3, List<? extends JSONObject> r4) {
        List<? extends JSONObject> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dbName");
        Intrinsics.checkNotNullParameter(r5, "documentJson");
        return this.$$delegate_0.removeDocuments(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public List<Long> search(String r8, String r9, JSONObject r10, long r11, List<Long> r13) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dbName");
        Intrinsics.checkNotNullParameter(r9, "schemaName");
        Intrinsics.checkNotNullParameter(r10, "queryJson");
        Intrinsics.checkNotNullParameter(r6, "targetIds");
        return this.$$delegate_0.search(r8, r9, r10, r11, r6);
    }
}
