package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/InfoAnniversaryMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i implements f {
    public i() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r22) {
        Intrinsics.checkNotNullParameter(r22, "rawEntity");
        String r8 = r22.getKey1();
        String r9 = r22.getKey2();
        long r3 = r22.getCreateTime();
        int r7 = r22.getProductType();
        long r5 = r22.getModifyTime();
        String r2 = r22.getEntityId();
        String r0 = r22.getSourceLinkType();
        String r10 = r22.getSourceLink();
        FileEntity r11 = com.obric.memorydata.personalcontext.util.f.c(r22.getScreenshot());
        String r12 = r22.getSourceText();
        String r13 = r22.getSourcePackageName();
        String r14 = r22.getSourceAppName();
        String r15 = r22.getLogId();
        String r16 = r22.getUuid();
        String r17 = r22.getSourceQuery();
        String r18 = r22.getDetail();
        int r19 = r22.getDetailStatus();
        String r1 = r22.getPackageName();
        if (r8 == null) goto L8;
        if (r9 == null) goto L10;
        InfoAnniversaryMemoryEntity r110 = new InfoAnniversaryMemoryEntity(r2, r3, r5, r7, r8, r9);
        r110.setSourceLinkType(r0);
        r110.setSourceLink(r10);
        r110.setScreenshot(r11);
        r110.setSourceText(r12);
        r110.setSourcePackageName(r13);
        r110.setSourceAppName(r14);
        r110.setLogId(r15);
        r110.setUuid(r16);
        r110.setSourceQuery(r17);
        r110.setDetail(r18);
        r110.setDetailStatus(r19);
        r110.set_packageName(r1);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r110, MemoryEntity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, InfoAnniversaryMemoryEntity.class) == false) goto L5;
        InfoAnniversaryMemoryEntity r0 = (InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r58, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L13;
        String r30 = r0.getAnniversaryType();
        String r31 = r0.getAnniversaryDate();
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
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, null, null, r24, r25, r3, null, null, null, r30, r31, null, null, null, null, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -6522575, 2063, null);
    L13:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity");
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
    public MemoryEntity c(MemoryEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        if (ZeusTransformUtils.instanceOf(r5, InfoAnniversaryMemoryEntity.class) == false) goto L5;
        InfoAnniversaryMemoryEntity r6 = (InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r5, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L15;
        String r7 = r6.getAnniversaryType();
        if (r7 == null) goto L13;
        RawMemoryEntity r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((key1 = ?))", new String[]{"10103", r7.toString()});
        if (r8 == null) goto L13;
        return a(r8);
    L13:
        return null;
    L15:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity");
    L5:
        r6 = null;
        goto L6
    }
}
