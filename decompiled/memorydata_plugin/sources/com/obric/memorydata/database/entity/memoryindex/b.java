package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/CollectStoreMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements f {
    public b() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r26) {
        Intrinsics.checkNotNullParameter(r26, "rawEntity");
        String r9 = r26.getKeyword1();
        String r13 = r26.getKeyword2();
        String r8 = r26.getKey1();
        String r11 = r26.getKey2();
        String r12 = r26.getKey3();
        String r10 = r26.getKey4();
        long r3 = r26.getCreateTime();
        int r7 = r26.getProductType();
        long r5 = r26.getModifyTime();
        String r2 = r26.getEntityId();
        String r0 = r26.getSourceLinkType();
        String r14 = r26.getSourceLink();
        FileEntity r15 = com.obric.memorydata.personalcontext.util.f.c(r26.getScreenshot());
        String r16 = r26.getSourceText();
        String r17 = r26.getSourcePackageName();
        String r18 = r26.getSourceAppName();
        String r19 = r26.getLogId();
        String r110 = r26.getUuid();
        String r111 = r26.getSourceQuery();
        String r112 = r26.getDetail();
        int r113 = r26.getDetailStatus();
        String r1 = r26.getPackageName();
        if (r8 != null) goto L6;
        return null;
    L6:
        CollectStoreMemoryEntity r114 = new CollectStoreMemoryEntity(r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
        r114.setSourceLinkType(r0);
        r114.setSourceLink(r14);
        r114.setScreenshot(r15);
        r114.setSourceText(r16);
        r114.setSourcePackageName(r17);
        r114.setSourceAppName(r18);
        r114.setLogId(r19);
        r114.setUuid(r110);
        r114.setSourceQuery(r111);
        r114.setDetail(r112);
        r114.setDetailStatus(r113);
        r114.set_packageName(r1);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r114, MemoryEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, CollectStoreMemoryEntity.class) == false) goto L5;
        CollectStoreMemoryEntity r0 = (CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r58, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L13;
        String r35 = r0.getAppName();
        String r36 = r0.getCity();
        String r30 = r0.getStoreName();
        String r31 = r0.getAddress();
        String r32 = r0.getStoreType();
        String r33 = r0.getAppPkgName();
        long r8 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r1 = r0.getScreenshot();
        if (r1 == null) goto L10;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin"));
    L10:
        String r7 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, null, null, r24, r25, r3, null, null, null, r30, r31, r32, r33, null, r35, r36, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -233014991, 2063, null);
    L13:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public boolean b(MemoryEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        return true;
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity c(MemoryEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "entity");
        if (ZeusTransformUtils.instanceOf(r11, CollectStoreMemoryEntity.class) == false) goto L5;
        CollectStoreMemoryEntity r12 = (CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r11, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 == null) goto L25;
        String r0 = r12.getSourceLinkType();
        String r2 = r12.getSourceLink();
        String r3 = r12.getStoreName();
        String r13 = r12.getAppPkgName();
        if (Intrinsics.areEqual(r0, MemorySourceLinkType.INTENT) == true) goto L17;
        if (r0 == null) goto L11;
        if (r2 == null) goto L11;
    L13:
        RawMemoryEntity r14 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((sourceLinkType = ? AND sourceLink = ?) OR (key1 = ? AND key4 = ?))", new String[]{"10202", String.valueOf(r0), String.valueOf(r2), r3.toString(), String.valueOf(r13)});
        if (r14 != null) goto L16;
    L23:
        return null;
    L16:
        return a(r14);
    L11:
        if (r3 == null) goto L17;
        if (r13 != null) goto L13;
    L17:
        if (r3 == null) goto L23;
        if (r13 == null) goto L23;
        RawMemoryEntity r15 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((key1 = ? AND key4 = ?))", new String[]{"10202", r3.toString(), r13.toString()});
        if (r15 == null) goto L23;
        return a(r15);
    L25:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
    L5:
        r12 = null;
        goto L6
    }
}
