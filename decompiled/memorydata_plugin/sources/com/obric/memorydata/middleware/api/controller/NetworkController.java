package com.obric.memorydata.middleware.api.controller;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\u0007H\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/controller/NetworkController;", "Lcom/obric/memorydata/middleware/api/controller/INetworkController;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "isNetWindowOpen", "", "isNetworkPolicySatisfied", "isScreenOn", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkController implements INetworkController {
    public static final NetworkController INSTANCE = null;
    private final /* synthetic */ INetworkController $$delegate_0;

    static {
        INSTANCE = new NetworkController();
    }

    private NetworkController() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(INetworkController.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (INetworkController) ZeusTransformUtils.preCheckCast(r0, INetworkController.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isNetWindowOpen() {
        return this.$$delegate_0.isNetWindowOpen();
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isNetworkPolicySatisfied() {
        return this.$$delegate_0.isNetworkPolicySatisfied();
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isScreenOn() {
        return this.$$delegate_0.isScreenOn();
    }
}
