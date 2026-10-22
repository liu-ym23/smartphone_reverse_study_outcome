package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/InfoCommonMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements f {
    public j() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r25) {
        Intrinsics.checkNotNullParameter(r25, "rawEntity");
        String r8 = r25.getKey1();
        String r9 = r25.getKey2();
        String r10 = r25.getKey3();
        String r11 = r25.getKey4();
        String r12 = r25.getKey5();
        long r3 = r25.getCreateTime();
        int r7 = r25.getProductType();
        long r5 = r25.getModifyTime();
        String r2 = r25.getEntityId();
        String r0 = r25.getSourceLinkType();
        String r13 = r25.getSourceLink();
        FileEntity r14 = com.obric.memorydata.personalcontext.util.f.c(r25.getScreenshot());
        String r15 = r25.getSourceText();
        String r16 = r25.getSourcePackageName();
        String r17 = r25.getSourceAppName();
        String r18 = r25.getLogId();
        String r19 = r25.getUuid();
        String r110 = r25.getSourceQuery();
        String r111 = r25.getDetail();
        int r112 = r25.getDetailStatus();
        String r1 = r25.getPackageName();
        if (r8 == null) goto L8;
        if (r9 == null) goto L10;
        InfoCommonMemoryEntity r113 = new InfoCommonMemoryEntity(r2, r3, r5, r7, r8, r9, r10, r11, r12);
        r113.setSourceLinkType(r0);
        r113.setSourceLink(r13);
        r113.setScreenshot(r14);
        r113.setSourceText(r15);
        r113.setSourcePackageName(r16);
        r113.setSourceAppName(r17);
        r113.setLogId(r18);
        r113.setUuid(r19);
        r113.setSourceQuery(r110);
        r113.setDetail(r111);
        r113.setDetailStatus(r112);
        r113.set_packageName(r1);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r113, MemoryEntity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r0 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r58, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L13;
        String r30 = r0.getInfoKey();
        String r31 = r0.getInfoValue();
        String r32 = r0.getObservation();
        String r33 = r0.getRelatedMemoryids();
        String r34 = r0.getTag();
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
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, null, null, r24, r25, r3, null, null, null, r30, r31, r32, r33, r34, null, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -65242831, 2063, null);
    L13:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity");
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
    public MemoryEntity c(MemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "entity");
        if (ZeusTransformUtils.instanceOf(r6, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r7 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L16;
        String r0 = r7.getInfoKey();
        String r8 = r7.getInfoValue();
        if (r0 == null) goto L14;
        if (r8 == null) goto L14;
        RawMemoryEntity r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((key1 = ? AND key2 = ?))", new String[]{"10105", r0.toString(), r8.toString()});
        if (r9 == null) goto L14;
        return a(r9);
    L14:
        return null;
    L16:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity");
    L5:
        r7 = null;
        goto L6
    }
}
