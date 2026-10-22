package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/InAppRuleBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IInAppRuleBridgeAPI;", "<init>", "()V", "applyDelta", "", Ext.KEY_REQUEST, "getSnapshot", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppRuleBridgeAPI implements IInAppRuleBridgeAPI {
    public static final InAppRuleBridgeAPI INSTANCE = null;
    private final /* synthetic */ IInAppRuleBridgeAPI $$delegate_0;

    static {
        INSTANCE = new InAppRuleBridgeAPI();
    }

    private InAppRuleBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IInAppRuleBridgeAPI.class));
        if (r0 == null) goto L7;
        this.$$delegate_0 = (IInAppRuleBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IInAppRuleBridgeAPI.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI
    public String applyDelta(String r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return this.$$delegate_0.applyDelta(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI
    public String getSnapshot(String r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return this.$$delegate_0.getSnapshot(r2);
    }
}
