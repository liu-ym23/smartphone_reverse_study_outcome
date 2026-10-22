package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/OrderHotelMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q implements f {
    public q() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r29) {
        Intrinsics.checkNotNullParameter(r29, "rawEntity");
        String r9 = r29.getKeyword1();
        String r14 = r29.getKeyword2();
        String r11 = r29.getKeyword3();
        Long r0 = r29.getStartDate();
        if (r0 == null) goto L5;
        String r8 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        Long r1 = r29.getStartTime();
        if (r1 == null) goto L9;
        String r12 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L10:
        Long r2 = r29.getEndDate();
        if (r2 == null) goto L13;
        String r10 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue());
    L14:
        Long r3 = r29.getEndTime();
        if (r3 == null) goto L17;
        String r13 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
    L18:
        long r4 = r29.getCreateTime();
        int r7 = r29.getProductType();
        long r5 = r29.getModifyTime();
        String r6 = r29.getEntityId();
        String r15 = r29.getSourceLinkType();
        String r16 = r29.getSourceLink();
        FileEntity r17 = com.obric.memorydata.personalcontext.util.f.c(r29.getScreenshot());
        String r18 = r29.getSourceText();
        String r19 = r29.getSourcePackageName();
        String r110 = r29.getSourceAppName();
        String r111 = r29.getLogId();
        String r112 = r29.getUuid();
        String r113 = r29.getSourceQuery();
        String r114 = r29.getDetail();
        int r115 = r29.getDetailStatus();
        String r20 = r29.getPackageName();
        if (r8 == null) goto L24;
        if (r9 == null) goto L24;
        OrderHotelMemoryEntity r21 = new OrderHotelMemoryEntity(r6, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14);
        r21.setSourceLinkType(r15);
        r21.setSourceLink(r16);
        r21.setScreenshot(r17);
        r21.setSourceText(r18);
        r21.setSourcePackageName(r19);
        r21.setSourceAppName(r110);
        r21.setLogId(r111);
        r21.setUuid(r112);
        r21.setSourceQuery(r113);
        r21.setDetail(r114);
        r21.setDetailStatus(r115);
        r21.set_packageName(r20);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r21, MemoryEntity.class, "com.obric.memorydata.plugin");
    L24:
        return null;
    L17:
        r13 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, OrderHotelMemoryEntity.class) == false) goto L5;
        OrderHotelMemoryEntity r0 = (OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r58, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L29;
        String r35 = r0.getHotelName();
        String r36 = r0.getCity();
        String r37 = r0.getHotelAddress();
        String r1 = r0.getCheckInDate();
        if (r1 == null) goto L10;
        Long r20 = Long.valueOf(com.obric.memorydata.utils.r.d(r1));
    L11:
        String r2 = r0.getCheckInTime();
        if (r2 == null) goto L14;
        Long r21 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getCheckInDate(), r2));
    L15:
        String r4 = r0.getCheckOutDate();
        if (r4 == null) goto L18;
        Long r22 = Long.valueOf(com.obric.memorydata.utils.r.d(r4));
    L19:
        String r5 = r0.getCheckOutTime();
        if (r5 == null) goto L22;
        Long r23 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getCheckOutDate(), r5));
    L23:
        long r8 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r6 = r0.getScreenshot();
        if (r6 == null) goto L26;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r6, AppEntity.class, "com.obric.memorydata.plugin"));
    L26:
        String r7 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, r20, r21, r22, r23, r24, r25, r3, null, null, null, null, null, null, null, null, r35, r36, r37, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -470023887, 2063, null);
    L22:
        r23 = null;
        goto L23
    L18:
        r22 = null;
        goto L19
    L14:
        r21 = null;
        goto L15
    L10:
        r20 = null;
        goto L11
    L29:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r6, OrderHotelMemoryEntity.class) == false) goto L5;
        OrderHotelMemoryEntity r7 = (OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L20;
        String r0 = r7.getCheckInDate();
        if (r0 == null) goto L10;
        Long r1 = Long.valueOf(com.obric.memorydata.utils.r.d(r0));
    L11:
        String r8 = r7.getHotelName();
        if (r1 == null) goto L18;
        if (r8 == null) goto L18;
        RawMemoryEntity r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((startDate = ? AND keyword1 = ?))", new String[]{"10004", r1.toString(), r8.toString()});
        if (r9 == null) goto L18;
        return a(r9);
    L18:
        return null;
    L10:
        r1 = null;
        goto L11
    L20:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
    L5:
        r7 = null;
        goto L6
    }
}
