package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/LocationSlotProcessBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ILocationSlotProcessBridgeAPI;", "<init>", "()V", "processLocationSlot", "", "", "", "slotValues", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationSlotProcessBridgeAPI implements ILocationSlotProcessBridgeAPI {
    public static final LocationSlotProcessBridgeAPI INSTANCE = null;
    private final /* synthetic */ ILocationSlotProcessBridgeAPI $$delegate_0;

    static {
        INSTANCE = new LocationSlotProcessBridgeAPI();
    }

    private LocationSlotProcessBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ILocationSlotProcessBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ILocationSlotProcessBridgeAPI) ZeusTransformUtils.preCheckCast(r0, ILocationSlotProcessBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILocationSlotProcessBridgeAPI
    public Map<String, List<String>> processLocationSlot(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "slotValues");
        return this.$$delegate_0.processLocationSlot(r4);
    }
}
