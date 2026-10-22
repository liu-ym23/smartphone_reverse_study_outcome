package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildService;", "Lcom/obric/memorydata/memory/api/MemoryBuildApi;", "<init>", "()V", "hasMemorySource", "", "productType", "", "insertProactiveEpisodicRelevantData", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveEpisodicRelevantDataParams;", "insertProactiveSemanticRelevantData", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveSemanticRelevantDataParams;", "resolveProactiveSourceLinkBySession", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$SourceLinkInfo;", ObricMemoryConstants.KEY_SESSION_ID, "", "trackNewProactiveMemory", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildService implements MemoryBuildApi {
    public static final MemoryBuildService INSTANCE = null;
    private final /* synthetic */ MemoryBuildApi $$delegate_0;

    static {
        INSTANCE = new MemoryBuildService();
    }

    private MemoryBuildService() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryBuildApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (MemoryBuildApi) ZeusTransformUtils.preCheckCast(r0, MemoryBuildApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public boolean hasMemorySource(int r1) {
        return this.$$delegate_0.hasMemorySource(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void insertProactiveEpisodicRelevantData(MemoryBuildApi.a r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        this.$$delegate_0.insertProactiveEpisodicRelevantData(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void insertProactiveSemanticRelevantData(MemoryBuildApi.b r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        this.$$delegate_0.insertProactiveSemanticRelevantData(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public MemoryBuildApi.c resolveProactiveSourceLinkBySession(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        return this.$$delegate_0.resolveProactiveSourceLinkBySession(r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void trackNewProactiveMemory(MemoryBuildApi.d r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        this.$$delegate_0.trackNewProactiveMemory(r2);
    }
}
