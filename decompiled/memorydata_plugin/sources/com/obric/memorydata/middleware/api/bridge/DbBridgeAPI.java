package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/DbBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IDbBridgeAPI;", "<init>", "()V", "initInvertedIndexDatabase", "", "dbSchemaJson", "Lorg/json/JSONObject;", "initSqlDatabase", "initVectorDatabase", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DbBridgeAPI implements IDbBridgeAPI {
    public static final DbBridgeAPI INSTANCE = null;
    private final /* synthetic */ IDbBridgeAPI $$delegate_0;

    static {
        INSTANCE = new DbBridgeAPI();
    }

    private DbBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IDbBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IDbBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IDbBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initInvertedIndexDatabase(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "dbSchemaJson");
        this.$$delegate_0.initInvertedIndexDatabase(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initSqlDatabase(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "dbSchemaJson");
        this.$$delegate_0.initSqlDatabase(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initVectorDatabase(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "dbSchemaJson");
        this.$$delegate_0.initVectorDatabase(r2);
    }
}
