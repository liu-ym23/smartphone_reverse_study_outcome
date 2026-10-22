package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/EventScheduleMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements f {
    public d() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r28) {
        Intrinsics.checkNotNullParameter(r28, "rawEntity");
        String r8 = r28.getKeyword1();
        Long r0 = r28.getStartDate();
        if (r0 == null) goto L5;
        String r9 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        Long r1 = r28.getStartTime();
        if (r1 == null) goto L9;
        String r10 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L10:
        Long r2 = r28.getEndTime();
        if (r2 == null) goto L13;
        String r11 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue());
    L14:
        String r12 = r28.getKey1();
        Long r3 = r28.getEndDate();
        if (r3 == null) goto L17;
        String r13 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
    L18:
        long r4 = r28.getCreateTime();
        int r7 = r28.getProductType();
        long r5 = r28.getModifyTime();
        String r6 = r28.getEntityId();
        String r15 = r28.getSourceLinkType();
        String r14 = r28.getSourceLink();
        FileEntity r16 = com.obric.memorydata.personalcontext.util.f.c(r28.getScreenshot());
        String r17 = r28.getSourceText();
        String r18 = r28.getSourcePackageName();
        String r19 = r28.getSourceAppName();
        String r110 = r28.getLogId();
        String r111 = r28.getUuid();
        String r112 = r28.getSourceQuery();
        String r113 = r28.getDetail();
        int r114 = r28.getDetailStatus();
        String r20 = r28.getPackageName();
        if (r8 == null) goto L25;
        if (r9 == null) goto L25;
        if (r10 == null) goto L25;
        EventScheduleMemoryEntity r21 = new EventScheduleMemoryEntity(r6, r4, r5, r7, r8, r9, r10, r11, r12, r13);
        r21.setSourceLinkType(r15);
        r21.setSourceLink(r14);
        r21.setScreenshot(r16);
        r21.setSourceText(r17);
        r21.setSourcePackageName(r18);
        r21.setSourceAppName(r19);
        r21.setLogId(r110);
        r21.setUuid(r111);
        r21.setSourceQuery(r112);
        r21.setDetail(r113);
        r21.setDetailStatus(r114);
        r21.set_packageName(r20);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r21, MemoryEntity.class, "com.obric.memorydata.plugin");
    L25:
        return null;
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, EventScheduleMemoryEntity.class) == false) goto L5;
        EventScheduleMemoryEntity r0 = (EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r58, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L41;
        String r35 = r0.getScheduleNme();
        String r1 = r0.getDate();
        if (r1 == null) goto L10;
        Long r20 = Long.valueOf(com.obric.memorydata.utils.r.d(r1));
    L11:
        String r2 = r0.getStartTime();
        if (r2 == null) goto L14;
        Long r21 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getDate(), r2));
    L15:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.getEndDate(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L26;
        String r6 = r0.getEndTime();
        if (r6 == null) goto L30;
        String r7 = r0.getDate();
    L29:
        Long r23 = Long.valueOf(com.obric.memorydata.utils.r.b(r7, r6));
    L31:
        String r30 = r0.getAddress();
        String r8 = r0.getEndDate();
        if (r8 == null) goto L34;
        Long r22 = Long.valueOf(com.obric.memorydata.utils.r.d(r8));
    L35:
        long r9 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r10 = r0.getScreenshot();
        if (r10 == null) goto L38;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r10, AppEntity.class, "com.obric.memorydata.plugin"));
    L38:
        String r11 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r11, r9, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, r20, r21, r22, r23, r24, r25, r3, null, null, null, r30, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -69467855, 2063, null);
    L34:
        r22 = null;
    L30:
        r23 = null;
        goto L31
    L26:
        r6 = r0.getEndTime();
        if (r6 == null) goto L30;
        r7 = r0.getEndDate();
        goto L29
    L18:
        if (r4.length() == 0) goto L21;
        r5 = false;
        goto L22
    L14:
        r21 = null;
        goto L15
    L10:
        r20 = null;
        goto L11
    L41:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r6, EventScheduleMemoryEntity.class) == false) goto L5;
        EventScheduleMemoryEntity r7 = (EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r6, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L19;
        String r0 = r7.getScheduleNme();
        String r8 = r7.getDate();
        if (r8 == null) goto L10;
        Long r9 = Long.valueOf(com.obric.memorydata.utils.r.d(r8));
    L11:
        if (r0 == null) goto L17;
        if (r9 == null) goto L17;
        RawMemoryEntity r10 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((keyword1 = ? AND startDate = ?))", new String[]{"10301", r0.toString(), r9.toString()});
        if (r10 == null) goto L17;
        return a(r10);
    L17:
        return null;
    L10:
        r9 = null;
        goto L11
    L19:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity");
    L5:
        r7 = null;
        goto L6
    }
}
