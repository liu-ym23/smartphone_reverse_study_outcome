package com.obric.memorydata;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.memory.api.MemoryBuildOuterApi;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/MemoryBuildOuter;", "Lcom/obric/memorydata/memory/api/MemoryBuildOuterApi;", "<init>", "()V", "getInst", "trackMemoryDelete", "", "ids", "", "", "deleteMethod", "trackProcessedSemanticMemory", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/ProcessedSemanticMemoryParams;", "trackAppEntityIndex", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "generateMethod", "batched", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildOuter implements MemoryBuildOuterApi {
    public static final MemoryBuildOuter INSTANCE = null;

    static {
        INSTANCE = new MemoryBuildOuter();
    }

    private MemoryBuildOuter() {
    }

    @JvmStatic
    public static final MemoryBuildOuter getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackAppEntityIndex(AppEntity r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        Intrinsics.checkNotNullParameter(r2, "generateMethod");
        MemoryEventTracker.f10515a.a(r1, r2, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackMemoryDelete(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "ids");
        Intrinsics.checkNotNullParameter(r3, "deleteMethod");
        MemoryEventTracker.f10515a.a(r1, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildOuterApi
    public void trackProcessedSemanticMemory(com.obric.memorydata.memory.api.c r1) {
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        MemoryEventTracker.f10515a.a(r1);
    }
}
