package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/InfoDocumentsMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements f {
    public k() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r23) {
        Intrinsics.checkNotNullParameter(r23, "rawEntity");
        String r10 = r23.getKey1();
        String r8 = r23.getKey2();
        String r9 = r23.getKey3();
        long r3 = r23.getCreateTime();
        int r7 = r23.getProductType();
        long r5 = r23.getModifyTime();
        String r2 = r23.getEntityId();
        String r0 = r23.getSourceLinkType();
        String r11 = r23.getSourceLink();
        FileEntity r12 = com.obric.memorydata.personalcontext.util.f.c(r23.getScreenshot());
        String r13 = r23.getSourceText();
        String r14 = r23.getSourcePackageName();
        String r15 = r23.getSourceAppName();
        String r16 = r23.getLogId();
        String r17 = r23.getUuid();
        String r18 = r23.getSourceQuery();
        String r19 = r23.getDetail();
        int r110 = r23.getDetailStatus();
        String r1 = r23.getPackageName();
        if (r8 == null) goto L8;
        if (r9 == null) goto L10;
        InfoDocumentsMemoryEntity r111 = new InfoDocumentsMemoryEntity(r2, r3, r5, r7, r8, r9, r10);
        r111.setSourceLinkType(r0);
        r111.setSourceLink(r11);
        r111.setScreenshot(r12);
        r111.setSourceText(r13);
        r111.setSourcePackageName(r14);
        r111.setSourceAppName(r15);
        r111.setLogId(r16);
        r111.setUuid(r17);
        r111.setSourceQuery(r18);
        r111.setDetail(r19);
        r111.setDetailStatus(r110);
        r111.set_packageName(r1);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r111, MemoryEntity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, InfoDocumentsMemoryEntity.class) == false) goto L5;
        InfoDocumentsMemoryEntity r0 = (InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r58, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L13;
        String r30 = r0.getPerson();
        String r31 = r0.getIdType();
        String r32 = r0.getIdNumber();
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
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, null, null, r24, r25, r3, null, null, null, r30, r31, r32, null, null, null, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -14911183, 2063, null);
    L13:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r6, InfoDocumentsMemoryEntity.class) == false) goto L5;
        InfoDocumentsMemoryEntity r7 = (InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L16;
        String r0 = r7.getIdType();
        String r8 = r7.getPerson();
        if (r0 == null) goto L14;
        if (r8 == null) goto L14;
        RawMemoryEntity r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((key2 = ? AND key1 = ?))", new String[]{"10101", r0.toString(), r8.toString()});
        if (r9 == null) goto L14;
        return a(r9);
    L14:
        return null;
    L16:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity");
    L5:
        r7 = null;
        goto L6
    }
}
