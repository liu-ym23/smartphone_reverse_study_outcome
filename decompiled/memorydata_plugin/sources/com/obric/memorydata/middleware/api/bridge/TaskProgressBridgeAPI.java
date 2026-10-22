package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/TaskProgressBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ITaskProgressBridgeAPI;", "<init>", "()V", "notifyProgress", "", "taskId", "", "payload", "Lorg/json/JSONObject;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskProgressBridgeAPI implements ITaskProgressBridgeAPI {
    public static final TaskProgressBridgeAPI INSTANCE = null;
    private final /* synthetic */ ITaskProgressBridgeAPI $$delegate_0;

    static {
        INSTANCE = new TaskProgressBridgeAPI();
    }

    private TaskProgressBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ITaskProgressBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ITaskProgressBridgeAPI) ZeusTransformUtils.preCheckCast(r0, ITaskProgressBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ITaskProgressBridgeAPI
    public void notifyProgress(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.$$delegate_0.notifyProgress(r2, r3);
    }
}
