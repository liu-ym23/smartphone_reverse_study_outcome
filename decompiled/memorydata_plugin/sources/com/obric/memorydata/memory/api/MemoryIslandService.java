package com.obric.memorydata.memory.api;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J-\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J5\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J5\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryIslandService;", "Lcom/obric/memorydata/memory/api/MemoryIslandApi;", "<init>", "()V", "showEffect", "", "showMemory", OaidModel.KEY_ID, "", "state", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "needEffect", "", "showMemoryList", "entities", "", "oldEntities", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryIslandService implements MemoryIslandApi {
    public static final MemoryIslandService INSTANCE = null;
    private final /* synthetic */ MemoryIslandApi $$delegate_0;

    static {
        INSTANCE = new MemoryIslandService();
    }

    private MemoryIslandService() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(MemoryIslandApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (MemoryIslandApi) ZeusTransformUtils.preCheckCast(r0, MemoryIslandApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showEffect() {
        this.$$delegate_0.showEffect();
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemory(String r2, int r3, MemoryEntity r4, MemoryEntity r5) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.$$delegate_0.showMemory(r2, r3, r4, r5);
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemory(String r8, int r9, boolean r10, MemoryEntity r11, MemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r8, OaidModel.KEY_ID);
        this.$$delegate_0.showMemory(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemoryList(String r3, int r4, List<? extends MemoryEntity> r5, List<? extends MemoryEntity> r6) {
        List<? extends MemoryEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<? extends MemoryEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r7, "entities");
        Intrinsics.checkNotNullParameter(r8, "oldEntities");
        this.$$delegate_0.showMemoryList(r3, r4, r7, r8);
    }
}
