package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/PlaygroundAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IPlaygroundAPI;", "<init>", "()V", "dispatchIntent", "Lcom/obric/memorydata/middleware/api/bridge/Response;", "payload", "", "getSkillList", "loadSkill", "skillId", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlaygroundAPI implements IPlaygroundAPI {
    public static final PlaygroundAPI INSTANCE = null;
    private final /* synthetic */ IPlaygroundAPI $$delegate_0;

    static {
        INSTANCE = new PlaygroundAPI();
    }

    private PlaygroundAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IPlaygroundAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IPlaygroundAPI) ZeusTransformUtils.preCheckCast(r0, IPlaygroundAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response dispatchIntent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.dispatchIntent(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response getSkillList() {
        return this.$$delegate_0.getSkillList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response loadSkill(String r2) {
        Intrinsics.checkNotNullParameter(r2, "skillId");
        return this.$$delegate_0.loadSkill(r2);
    }
}
