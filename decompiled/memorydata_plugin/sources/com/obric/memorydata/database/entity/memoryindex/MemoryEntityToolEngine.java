package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/MemoryEntityToolEngine;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityToolEngine;", "<init>", "()V", "memoryEntityToolMap", "", "", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "toMemoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "rawEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "toRawMemoryEntity", "memoryEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryEntityToolEngine implements g {
    private final Map<Integer, f> memoryEntityToolMap;

    public MemoryEntityToolEngine() {
        this.memoryEntityToolMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_COMMON), new j()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT), new a()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), new i()), TuplesKt.to(10002, new t()), TuplesKt.to(10004, new q()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_EVENT_TODO), new e()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), new c()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), new h()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), new d()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), new k()), TuplesKt.to(10005, new o()), TuplesKt.to(10006, new s()), TuplesKt.to(10001, new p()), TuplesKt.to(10003, new r()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), new l()), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_COLLECT_STORE), new b())});
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.g
    public MemoryEntity findSameMemoryEntity(MemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.memoryEntityToolMap.get(Integer.valueOf(r3.getType())), f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c(r3);
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.g
    public boolean isMemoryValid(MemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.memoryEntityToolMap.get(Integer.valueOf(r3.getType())), f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.b(r3);
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.g
    public MemoryEntity toMemoryEntity(RawMemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "rawEntity");
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.memoryEntityToolMap.get(Integer.valueOf(r3.getMemoryType())), f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3);
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.g
    public RawMemoryEntity toRawMemoryEntity(MemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.memoryEntityToolMap.get(Integer.valueOf(r3.getType())), f.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        RawMemoryEntity r4 = r2.a(r3);
        if (r4 == null) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("toRawMemoryEntity error! unknown entity type: " + r3.getType());
    }
}
