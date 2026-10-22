package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J#\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/ExperimentBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IExperimentBridgeAPI;", "<init>", "()V", "getBooleanValue", "", "key", "", "defaultValue", "scope", "getDoubleValue", "", "getIntValue", "", "getJsonObjectValue", "getLongValue", "", "getStringValue", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExperimentBridgeAPI implements IExperimentBridgeAPI {
    public static final ExperimentBridgeAPI INSTANCE = null;
    private final /* synthetic */ IExperimentBridgeAPI $$delegate_0;

    static {
        INSTANCE = new ExperimentBridgeAPI();
    }

    private ExperimentBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IExperimentBridgeAPI.class));
        if (r0 == null) goto L7;
        this.$$delegate_0 = (IExperimentBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IExperimentBridgeAPI.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public boolean getBooleanValue(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getBooleanValue(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public double getDoubleValue(String r2, double r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getDoubleValue(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public int getIntValue(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getIntValue(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public String getJsonObjectValue(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return this.$$delegate_0.getJsonObjectValue(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public long getLongValue(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getLongValue(r2, r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public String getStringValue(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return this.$$delegate_0.getStringValue(r2, r3, r4);
    }
}
