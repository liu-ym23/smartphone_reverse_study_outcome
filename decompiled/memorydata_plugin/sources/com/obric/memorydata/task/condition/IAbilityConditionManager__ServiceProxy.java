package com.obric.memorydata.task.condition;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.ability.condition.AbilityConditionManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAbilityConditionManager__ServiceProxy implements IServiceProxy<IAbilityConditionManager> {
    public IAbilityConditionManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.task.condition.IAbilityConditionManager", "com.obric.memorydata.ability.condition.AbilityConditionManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAbilityConditionManager newInstance() {
        return AbilityConditionManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAbilityConditionManager newInstance() {
        return newInstance();
    }
}
