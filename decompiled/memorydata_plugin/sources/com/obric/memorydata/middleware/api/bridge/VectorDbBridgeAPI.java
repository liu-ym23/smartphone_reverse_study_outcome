package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J%\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0096\u0001J/\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0096\u0001J/\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J5\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\u001b\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001JC\u0010%\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0096\u0001¨\u0006'"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/VectorDbBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IVectorDbBridgeAPI;", "<init>", "()V", "cleanTable", "", "table", "", "deleteVectorData", "rowid", "", "getVectorDbSize", "", "insertImageVector", OaidModel.KEY_ID, "uri", "sourcePkg", "insertVector", "vector", "", "insertVectorData", Params.CONTENT, "queryByImageVector", "", "vectorString", "limit", "foregroundCallerPkg", "queryByVector", "queryVector", "vectorDbName", "key", "search", ChatMessage.TYPE_QUERY, "queryType", "extras", "Lorg/json/JSONObject;", "searchAndDecrypt", "searchWithKeys", "keys", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorDbBridgeAPI implements IVectorDbBridgeAPI {
    public static final VectorDbBridgeAPI INSTANCE = null;
    private final /* synthetic */ IVectorDbBridgeAPI $$delegate_0;

    static {
        INSTANCE = new VectorDbBridgeAPI();
    }

    private VectorDbBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IVectorDbBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IVectorDbBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IVectorDbBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean cleanTable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.$$delegate_0.cleanTable(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean deleteVectorData(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.$$delegate_0.deleteVectorData(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public long getVectorDbSize(String r2) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.$$delegate_0.getVectorDbSize(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertImageVector(String r8, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r11, "uri");
        return this.$$delegate_0.insertImageVector(r8, r9, r11, r12);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertVector(String r2, long r3, float[] r5) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.$$delegate_0.insertVector(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertVectorData(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        return this.$$delegate_0.insertVectorData(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> queryByImageVector(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return this.$$delegate_0.queryByImageVector(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> queryByImageVector(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return this.$$delegate_0.queryByImageVector(r2, r3, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> queryByVector(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return this.$$delegate_0.queryByVector(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> queryByVector(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return this.$$delegate_0.queryByVector(r2, r3, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public float[] queryVector(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "vectorDbName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.queryVector(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> search(String r8, String r9, int r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r11, "queryType");
        Intrinsics.checkNotNullParameter(r12, "extras");
        return this.$$delegate_0.search(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public float[] searchAndDecrypt(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.searchAndDecrypt(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<?> searchWithKeys(String r8, String r9, List<Long> r10, int r11, String r12, JSONObject r13) {
        List<Long> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r3, "keys");
        Intrinsics.checkNotNullParameter(r12, "queryType");
        Intrinsics.checkNotNullParameter(r13, "extras");
        return this.$$delegate_0.searchWithKeys(r8, r9, r3, r11, r12, r13);
    }
}
