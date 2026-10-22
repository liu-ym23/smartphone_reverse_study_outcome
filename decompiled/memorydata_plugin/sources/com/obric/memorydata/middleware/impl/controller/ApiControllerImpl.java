package com.obric.memorydata.middleware.impl.controller;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.controller.IApiController;
import com.obric.memorydata.middleware.api.controller.a;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/controller/ApiControllerImpl;", "Lcom/obric/memorydata/middleware/api/controller/IApiController;", "<init>", "()V", "TAG", "", "logger", "Lcom/obric/memorydata/middleware/api/controller/ApiLogger;", "getInst", "isEnable", "", "enable", "", "needLog", "log", "api", "input", "", "output", "setLogger", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ApiControllerImpl implements IApiController {
    public static final ApiControllerImpl INSTANCE = null;
    private static final String TAG = "GlobalControllerImpl";
    private static volatile a logger;

    static {
        INSTANCE = new ApiControllerImpl();
    }

    private ApiControllerImpl() {
    }

    @JvmStatic
    public static final ApiControllerImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ void lambda$PE5wbyyNIr6klnURmnTOrVHi4hs(a r0, String r1, Object r2, Object r3) {
        log$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    private static final void log$lambda$2$lambda$1(a r2, String r3, Object r4, Object r5) {
        ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a(r3, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void enable(boolean r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_api_controller_on", r5);
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public boolean isEnable() {
        boolean r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_api_controller_on", true);
        if (r7 == true) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "API disable!", null, 4, null);
    L5:
        return r7;
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void log(final String r3, final Object r4, final Object r5) {
        Intrinsics.checkNotNullParameter(r3, "api");
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "output");
        final a r2 = logger;
        if (r2 == null) goto L6;
        GlobalHandlerUtil.Companion.getInstance().sendMsg(new $$Lambda$ApiControllerImpl$PE5wbyyNIr6klnURmnTOrVHi4hs(r2, r3, r4, r5));
        return;
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public boolean needLog() {
        if (logger == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.controller.IApiController
    public void setLogger(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "logger");
        logger = r1;
    }
}
