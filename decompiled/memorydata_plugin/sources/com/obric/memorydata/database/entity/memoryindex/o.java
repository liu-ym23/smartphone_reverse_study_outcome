package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/OrderCommonMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o implements f {
    public o() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r27) {
        Intrinsics.checkNotNullParameter(r27, "rawEntity");
        String r8 = r27.getKeyword1();
        String r9 = r27.getKey1();
        Long r0 = r27.getStartDate();
        if (r0 == null) goto L5;
        String r10 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        Long r1 = r27.getStartTime();
        if (r1 == null) goto L9;
        String r11 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L10:
        long r3 = r27.getCreateTime();
        int r7 = r27.getProductType();
        long r5 = r27.getModifyTime();
        String r2 = r27.getEntityId();
        String r13 = r27.getSourceLinkType();
        String r14 = r27.getSourceLink();
        FileEntity r15 = com.obric.memorydata.personalcontext.util.f.c(r27.getScreenshot());
        String r4 = r27.getSourceText();
        String r12 = r27.getSourcePackageName();
        String r16 = r27.getSourceAppName();
        String r17 = r27.getLogId();
        String r18 = r27.getUuid();
        String r19 = r27.getSourceQuery();
        String r110 = r27.getDetail();
        int r111 = r27.getDetailStatus();
        String r6 = r27.getPackageName();
        if (r8 != null) goto L14;
        return null;
    L14:
        OrderCommonMemoryEntity r112 = new OrderCommonMemoryEntity(r2, r3, r5, r7, r8, r9, r10, r11);
        r112.setSourceLinkType(r13);
        r112.setSourceLink(r14);
        r112.setScreenshot(r15);
        r112.setSourceText(r4);
        r112.setSourcePackageName(r12);
        r112.setSourceAppName(r16);
        r112.setLogId(r17);
        r112.setUuid(r18);
        r112.setSourceQuery(r19);
        r112.setDetail(r110);
        r112.setDetailStatus(r111);
        r112.set_packageName(r6);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r112, MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, OrderCommonMemoryEntity.class) == false) goto L5;
        OrderCommonMemoryEntity r0 = (OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r58, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L21;
        String r35 = r0.getOrderName();
        String r30 = r0.getOrderDesc();
        String r1 = r0.getOrderCreateDate();
        if (r1 == null) goto L10;
        Long r20 = Long.valueOf(com.obric.memorydata.utils.r.d(r1));
    L11:
        String r2 = r0.getOrderCreateTime();
        if (r2 == null) goto L14;
        Long r21 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getOrderCreateDate(), r2));
    L15:
        long r8 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r4 = r0.getScreenshot();
        if (r4 == null) goto L18;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin"));
    L18:
        String r7 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, r20, r21, null, null, r24, r25, r3, null, null, null, r30, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -69443279, 2063, null);
    L14:
        r21 = null;
        goto L15
    L10:
        r20 = null;
        goto L11
    L21:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r6, OrderCommonMemoryEntity.class) == false) goto L5;
        OrderCommonMemoryEntity r7 = (OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L19;
        String r0 = r7.getOrderName();
        String r2 = r7.getOrderCreateTime();
        if (r2 == null) goto L10;
        Long r8 = Long.valueOf(com.obric.memorydata.utils.r.b(r7.getOrderCreateDate(), r2));
    L11:
        if (r0 == null) goto L17;
        if (r8 == null) goto L17;
        RawMemoryEntity r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((keyword1 = ? AND startTime = ?))", new String[]{"10005", r0.toString(), r8.toString()});
        if (r9 == null) goto L17;
        return a(r9);
    L17:
        return null;
    L10:
        r8 = null;
        goto L11
    L19:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity");
    L5:
        r7 = null;
        goto L6
    }
}
