package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u001f\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildOuter;", "Lcom/obric/memorydata/memory/api/MemoryBuildOuterApi;", "<init>", "()V", "trackAppEntityIndex", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "generateMethod", "", "batched", "", "trackMemoryDelete", "ids", "", "deleteMethod", "trackProcessedSemanticMemory", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/ProcessedSemanticMemoryParams;", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildOuter implements MemoryBuildOuterApi {
    public static final MemoryBuildOuter INSTANCE = null;
    private final /* synthetic */ MemoryBuildOuterApi $$delegate_0;

    static {
        INSTANCE = new MemoryBuildOuter();
    }

    private MemoryBuildOuter() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryBuildOuterApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (MemoryBuildOuterApi) ZeusTransformUtils.preCheckCast(r0, MemoryBuildOuterApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackAppEntityIndex(AppEntity r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        Intrinsics.checkNotNullParameter(r3, "generateMethod");
        this.$$delegate_0.trackAppEntityIndex(r2, r3, r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackMemoryDelete(List<String> r3, String r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "ids");
        Intrinsics.checkNotNullParameter(r4, "deleteMethod");
        this.$$delegate_0.trackMemoryDelete(r5, r4);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackProcessedSemanticMemory(c r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        this.$$delegate_0.trackProcessedSemanticMemory(r2);
    }
}
