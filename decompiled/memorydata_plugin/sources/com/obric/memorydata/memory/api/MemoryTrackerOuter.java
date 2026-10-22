package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryTrackerOuter;", "Lcom/obric/memorydata/memory/api/MemoryTrackerOuterApi;", "<init>", "()V", "batchUploadOnce", "", "trackScreenMemorySwitch", "enabled", "", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTrackerOuter implements MemoryTrackerOuterApi {
    public static final MemoryTrackerOuter INSTANCE = null;
    private final /* synthetic */ MemoryTrackerOuterApi $$delegate_0;

    static {
        INSTANCE = new MemoryTrackerOuter();
    }

    private MemoryTrackerOuter() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryTrackerOuterApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (MemoryTrackerOuterApi) ZeusTransformUtils.preCheckCast(r0, MemoryTrackerOuterApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.MemoryTrackerOuterApi
    public void batchUploadOnce() {
        this.$$delegate_0.batchUploadOnce();
    }

    @Override // com.obric.memorydata.memory.api.MemoryTrackerOuterApi
    public void trackScreenMemorySwitch(boolean r1) {
        this.$$delegate_0.trackScreenMemorySwitch(r1);
    }
}
