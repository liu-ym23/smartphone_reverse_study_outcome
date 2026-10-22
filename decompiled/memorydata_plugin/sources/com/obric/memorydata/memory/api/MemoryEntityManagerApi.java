package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryEntityManagerApi;", "Lcom/obric/memorydata/memory/api/IMemoryEntityManagerApi;", "<init>", "()V", "index", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryEntity", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryEntityManagerApi implements IMemoryEntityManagerApi {
    public static final MemoryEntityManagerApi INSTANCE = null;
    private final /* synthetic */ IMemoryEntityManagerApi $$delegate_0;

    static {
        INSTANCE = new MemoryEntityManagerApi();
    }

    private MemoryEntityManagerApi() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IMemoryEntityManagerApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IMemoryEntityManagerApi) ZeusTransformUtils.preCheckCast(r0, IMemoryEntityManagerApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.IMemoryEntityManagerApi
    public MemoryEntity index(MemoryEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryEntity");
        return this.$$delegate_0.index(r2);
    }
}
