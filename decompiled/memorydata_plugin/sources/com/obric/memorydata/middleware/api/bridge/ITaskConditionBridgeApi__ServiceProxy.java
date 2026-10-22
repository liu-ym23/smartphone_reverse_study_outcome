package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.task.condition.TaskConditionBridgeImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ITaskConditionBridgeApi__ServiceProxy implements IServiceProxy<ITaskConditionBridgeApi> {
    public ITaskConditionBridgeApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.ITaskConditionBridgeApi", "com.obric.memorydata.task.condition.TaskConditionBridgeImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ITaskConditionBridgeApi newInstance() {
        return TaskConditionBridgeImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ITaskConditionBridgeApi newInstance() {
        return newInstance();
    }
}
