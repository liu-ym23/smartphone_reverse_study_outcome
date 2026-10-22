package com.obric.memorydata.middleware.api.aikernel;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/aikernel/PapayaAPI;", "Lcom/obric/memorydata/middleware/api/aikernel/IPapayaAPI;", "<init>", "()V", "getPythonThreadTrace", "", "isInit", "", "setInitState", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PapayaAPI implements IPapayaAPI {
    public static final PapayaAPI INSTANCE = null;
    private final /* synthetic */ IPapayaAPI $$delegate_0;

    static {
        INSTANCE = new PapayaAPI();
    }

    private PapayaAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IPapayaAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IPapayaAPI) ZeusTransformUtils.preCheckCast(r0, IPapayaAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public String getPythonThreadTrace() {
        return this.$$delegate_0.getPythonThreadTrace();
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public boolean isInit() {
        return this.$$delegate_0.isInit();
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public void setInitState(boolean r1) {
        this.$$delegate_0.setInitState(r1);
    }
}
