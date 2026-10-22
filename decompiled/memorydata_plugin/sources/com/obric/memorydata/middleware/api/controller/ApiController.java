package com.obric.memorydata.middleware.api.controller;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J!\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/controller/ApiController;", "Lcom/obric/memorydata/middleware/api/controller/IApiController;", "<init>", "()V", "enable", "", "", "isEnable", "log", "api", "", "input", "", "output", "needLog", "setLogger", "logger", "Lcom/obric/memorydata/middleware/api/controller/ApiLogger;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ApiController implements IApiController {
    public static final ApiController INSTANCE = null;
    private final /* synthetic */ IApiController $$delegate_0;

    static {
        INSTANCE = new ApiController();
    }

    private ApiController() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IApiController.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IApiController) ZeusTransformUtils.preCheckCast(r0, IApiController.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void enable(boolean r1) {
        this.$$delegate_0.enable(r1);
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public boolean isEnable() {
        return this.$$delegate_0.isEnable();
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void log(String r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "api");
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "output");
        this.$$delegate_0.log(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public boolean needLog() {
        return this.$$delegate_0.needLog();
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void setLogger(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "logger");
        this.$$delegate_0.setLogger(r4);
    }
}
