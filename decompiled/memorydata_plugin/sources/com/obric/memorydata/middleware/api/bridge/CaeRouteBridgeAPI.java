package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0096\u0001JC\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/CaeRouteBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ICaeRouteBridgeAPI;", "<init>", "()V", "searchDirection", "Lorg/json/JSONObject;", "oriLat", "", "oriLng", "destLat", "destLng", "inCoordType", "", "outCoordType", "extraInfos", "directionType", "searchDirectionByAddress", "destAddress", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CaeRouteBridgeAPI implements ICaeRouteBridgeAPI {
    public static final CaeRouteBridgeAPI INSTANCE = null;
    private final /* synthetic */ ICaeRouteBridgeAPI $$delegate_0;

    static {
        INSTANCE = new CaeRouteBridgeAPI();
    }

    private CaeRouteBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ICaeRouteBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ICaeRouteBridgeAPI) ZeusTransformUtils.preCheckCast(r0, ICaeRouteBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICaeRouteBridgeAPI
    public JSONObject searchDirection(double r15, double r17, double r19, double r21, String r23, String r24, JSONObject r25, String r26) {
        Intrinsics.checkNotNullParameter(r23, "inCoordType");
        Intrinsics.checkNotNullParameter(r24, "outCoordType");
        Intrinsics.checkNotNullParameter(r26, "directionType");
        return this.$$delegate_0.searchDirection(r15, r17, r19, r21, r23, r24, r25, r26);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICaeRouteBridgeAPI
    public JSONObject searchDirectionByAddress(double r12, double r14, String r16, String r17, String r18, JSONObject r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "destAddress");
        Intrinsics.checkNotNullParameter(r17, "inCoordType");
        Intrinsics.checkNotNullParameter(r18, "outCoordType");
        Intrinsics.checkNotNullParameter(r20, "directionType");
        return this.$$delegate_0.searchDirectionByAddress(r12, r14, r16, r17, r18, r19, r20);
    }
}
