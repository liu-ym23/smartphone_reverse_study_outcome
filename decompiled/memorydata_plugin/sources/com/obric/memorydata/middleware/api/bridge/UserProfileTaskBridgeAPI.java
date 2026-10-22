package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/UserProfileTaskBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IUserProfileTaskBridgeAPI;", "<init>", "()V", "checkIsWorkingDay", "", "ts", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileTaskBridgeAPI implements IUserProfileTaskBridgeAPI {
    public static final UserProfileTaskBridgeAPI INSTANCE = null;
    private final /* synthetic */ IUserProfileTaskBridgeAPI $$delegate_0;

    static {
        INSTANCE = new UserProfileTaskBridgeAPI();
    }

    private UserProfileTaskBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IUserProfileTaskBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IUserProfileTaskBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IUserProfileTaskBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUserProfileTaskBridgeAPI
    public boolean checkIsWorkingDay(long r1) {
        return this.$$delegate_0.checkIsWorkingDay(r1);
    }
}
