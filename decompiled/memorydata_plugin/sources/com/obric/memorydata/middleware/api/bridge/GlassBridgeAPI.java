package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/GlassBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IGlassBridgeAPI;", "<init>", "()V", "isConnected", "", "isConnectedGeneration", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "isWearing", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlassBridgeAPI implements IGlassBridgeAPI {
    public static final GlassBridgeAPI INSTANCE = null;
    private final /* synthetic */ IGlassBridgeAPI $$delegate_0;

    static {
        INSTANCE = new GlassBridgeAPI();
    }

    private GlassBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IGlassBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IGlassBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IGlassBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isConnected() {
        return this.$$delegate_0.isConnected();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isConnectedGeneration(long r1) {
        return this.$$delegate_0.isConnectedGeneration(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isWearing() {
        return this.$$delegate_0.isWearing();
    }
}
