package com.obric.memorydata.middleware.api;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/BuildTypeFlavor;", "Lcom/obric/memorydata/middleware/api/IBuildTypeFlavor;", "<init>", "()V", "checkPrivacyData", "", LocationMonitorConst.TAG, "", "message", CommonConsts.APM_INNER_EVENT_COST_INIT, "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BuildTypeFlavor implements IBuildTypeFlavor {
    public static final BuildTypeFlavor INSTANCE = null;
    private final /* synthetic */ IBuildTypeFlavor $$delegate_0;

    static {
        INSTANCE = new BuildTypeFlavor();
    }

    private BuildTypeFlavor() {
        IBuildTypeFlavor r0 = (IBuildTypeFlavor) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IBuildTypeFlavor.class)), IBuildTypeFlavor.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IBuildTypeFlavor) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), IBuildTypeFlavor.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.middleware.api.IBuildTypeFlavor
    public void checkPrivacyData(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.$$delegate_0.checkPrivacyData(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.IBuildTypeFlavor
    public void init() {
        this.$$delegate_0.init();
    }
}
