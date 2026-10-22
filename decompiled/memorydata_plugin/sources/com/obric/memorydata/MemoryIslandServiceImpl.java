package com.obric.memorydata;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.api.MemoryIslandApi;
import com.obric.memorydata.memory.island.obric.IslandSessionUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J4\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J4\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/MemoryIslandServiceImpl;", "Lcom/obric/memorydata/memory/api/MemoryIslandApi;", "<init>", "()V", "getInst", "showMemory", "", OaidModel.KEY_ID, "", "state", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "needEffect", "", "showMemoryList", "entities", "", "oldEntities", "showEffect", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryIslandServiceImpl implements MemoryIslandApi {
    public static final MemoryIslandServiceImpl INSTANCE = null;

    static {
        INSTANCE = new MemoryIslandServiceImpl();
    }

    private MemoryIslandServiceImpl() {
    }

    @JvmStatic
    public static final MemoryIslandServiceImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showEffect() {
        IslandSessionUtils.f10217a.a();
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemory(String r10, int r11, MemoryEntity r12, MemoryEntity r13) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r10, r11, r12, r13, false, null, 48, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemory(String r10, int r11, boolean r12, MemoryEntity r13, MemoryEntity r14) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r10, r11, r13, r14, r12, null, 32, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryIslandApi
    public void showMemoryList(String r11, int r12, List<? extends MemoryEntity> r13, List<? extends MemoryEntity> r14) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, "entities");
        Intrinsics.checkNotNullParameter(r15, "oldEntities");
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r11, r12, (MemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), MemoryEntity.class, "com.obric.memorydata.plugin"), (MemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r15), MemoryEntity.class, "com.obric.memorydata.plugin"), false, null, 48, null);
    }
}
