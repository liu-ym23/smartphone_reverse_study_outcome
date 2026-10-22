package com.obric.memorydata.middleware.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IDatabaseKeyMigration__ServiceProxy implements IServiceProxy<IDatabaseKeyMigration> {
    public IDatabaseKeyMigration__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.IDatabaseKeyMigration", "com.obric.memorydata.middleware.database.DatabaseKeyMigration");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IDatabaseKeyMigration newInstance() {
        return com.obric.memorydata.middleware.database.DatabaseKeyMigration.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IDatabaseKeyMigration newInstance() {
        return newInstance();
    }
}
