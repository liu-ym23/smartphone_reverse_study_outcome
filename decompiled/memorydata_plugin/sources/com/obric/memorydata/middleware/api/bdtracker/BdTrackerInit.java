package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/BdTrackerInit;", "Lcom/obric/memorydata/middleware/api/bdtracker/IBdTrackerInit;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BdTrackerInit implements IBdTrackerInit {
    private final /* synthetic */ IBdTrackerInit $$delegate_0;

    public BdTrackerInit() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IBdTrackerInit.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IBdTrackerInit) ZeusTransformUtils.preCheckCast(r0, IBdTrackerInit.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IBdTrackerInit
    public void init() {
        this.$$delegate_0.init();
    }
}
