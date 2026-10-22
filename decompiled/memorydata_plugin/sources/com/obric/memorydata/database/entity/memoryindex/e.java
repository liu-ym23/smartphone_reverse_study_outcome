package com.obric.memorydata.database.entity.memoryindex;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/EventTodoMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements f {
    public e() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r26) {
        Intrinsics.checkNotNullParameter(r26, "rawEntity");
        String r8 = r26.getKeyword1();
        Long r0 = r26.getEndDate();
        if (r0 == null) goto L5;
        String r9 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        Long r1 = r26.getEndTime();
        if (r1 == null) goto L9;
        String r10 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L10:
        long r3 = r26.getCreateTime();
        int r7 = r26.getProductType();
        long r5 = r26.getModifyTime();
        String r2 = r26.getEntityId();
        String r12 = r26.getSourceLinkType();
        String r13 = r26.getSourceLink();
        FileEntity r14 = com.obric.memorydata.personalcontext.util.f.c(r26.getScreenshot());
        String r15 = r26.getSourceText();
        String r4 = r26.getSourcePackageName();
        String r11 = r26.getSourceAppName();
        String r16 = r26.getLogId();
        String r17 = r26.getUuid();
        String r18 = r26.getSourceQuery();
        String r19 = r26.getDetail();
        int r110 = r26.getDetailStatus();
        String r6 = r26.getPackageName();
        if (r8 != null) goto L14;
        return null;
    L14:
        EventTodoMemoryEntity r111 = new EventTodoMemoryEntity(r2, r3, r5, r7, r8, r9, r10);
        r111.setSourceLinkType(r12);
        r111.setSourceLink(r13);
        r111.setScreenshot(r14);
        r111.setSourceText(r15);
        r111.setSourcePackageName(r4);
        r111.setSourceAppName(r11);
        r111.setLogId(r16);
        r111.setUuid(r17);
        r111.setSourceQuery(r18);
        r111.setDetail(r19);
        r111.setDetailStatus(r110);
        r111.set_packageName(r6);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r111, MemoryEntity.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r58, EventTodoMemoryEntity.class) == false) goto L5;
        EventTodoMemoryEntity r0 = (EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r58, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L21;
        String r35 = r0.getContent();
        String r1 = r0.getEndDate();
        if (r1 == null) goto L10;
        Long r22 = Long.valueOf(com.obric.memorydata.utils.r.d(r1));
    L11:
        String r2 = r0.getEndTime();
        if (r2 == null) goto L14;
        Long r23 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getEndDate(), r2));
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
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, r22, r23, r24, r25, r3, null, null, null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -67364559, 2063, null);
    L14:
        r23 = null;
        goto L15
    L10:
        r22 = null;
        goto L11
    L21:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r5, EventTodoMemoryEntity.class) == false) goto L5;
        EventTodoMemoryEntity r6 = (EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L15;
        String r7 = r6.getContent();
        if (r7 == null) goto L13;
        RawMemoryEntity r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((keyword1 = ?))", new String[]{"10302", r7.toString()});
        if (r8 == null) goto L13;
        return a(r8);
    L13:
        return null;
    L15:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity");
    L5:
        r6 = null;
        goto L6
    }
}
