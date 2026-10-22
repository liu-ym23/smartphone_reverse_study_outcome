package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J!\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/LifeLogBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ILifeLogBridgeAPI;", "<init>", "()V", "onLifeLogResult", "", "data", "", "showNotification", "title", Params.CONTENT, "timestamp", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifeLogBridgeAPI implements ILifeLogBridgeAPI {
    public static final LifeLogBridgeAPI INSTANCE = null;
    private final /* synthetic */ ILifeLogBridgeAPI $$delegate_0;

    static {
        INSTANCE = new LifeLogBridgeAPI();
    }

    private LifeLogBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ILifeLogBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ILifeLogBridgeAPI) ZeusTransformUtils.preCheckCast(r0, ILifeLogBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILifeLogBridgeAPI
    public void onLifeLogResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onLifeLogResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILifeLogBridgeAPI
    public void showNotification(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.$$delegate_0.showNotification(r2, r3, r4);
    }
}
