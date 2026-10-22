package com.obric.memorydata.database.entity.memoryindex;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/OrderMovieTicketMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r implements f {

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public r() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r30) {
        Intrinsics.checkNotNullParameter(r30, "rawEntity");
        String r9 = r30.getKeyword1();
        Long r0 = r30.getStartDate();
        if (r0 == null) goto L5;
        String r10 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        Long r1 = r30.getStartTime();
        if (r1 == null) goto L9;
        String r11 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L10:
        Long r2 = r30.getEndTime();
        if (r2 == null) goto L13;
        String r12 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue());
    L14:
        String r13 = r30.getKeyword2();
        String r14 = r30.getKeyword3();
        String r16 = r30.getKey1();
        String r3 = r30.getKey2();
        if (r3 != null) goto L32;
    L23:
        List r4 = null;
    L24:
        long r5 = r30.getCreateTime();
        int r8 = r30.getProductType();
        long r6 = r30.getModifyTime();
        String r7 = r30.getEntityId();
        List r29 = r4;
        String r15 = r30.getSourceLinkType();
        String r17 = r30.getSourceLink();
        FileEntity r18 = com.obric.memorydata.personalcontext.util.f.c(r30.getScreenshot());
        String r19 = r30.getSourceText();
        String r20 = r30.getSourcePackageName();
        String r21 = r30.getSourceAppName();
        String r22 = r30.getLogId();
        String r23 = r30.getUuid();
        String r24 = r30.getSourceQuery();
        String r25 = r30.getDetail();
        int r26 = r30.getDetailStatus();
        String r27 = r30.getPackageName();
        if (r10 == null) goto L31;
        if (r11 == null) goto L31;
        if (r9 == null) goto L31;
        OrderMovieTicketMemoryEntity r28 = new OrderMovieTicketMemoryEntity(r7, r5, r6, r8, r9, r10, r11, r12, r13, r14, r16, r29);
        r28.setSourceLinkType(r15);
        r28.setSourceLink(r17);
        r28.setScreenshot(r18);
        r28.setSourceText(r19);
        r28.setSourcePackageName(r20);
        r28.setSourceAppName(r21);
        r28.setLogId(r22);
        r28.setUuid(r23);
        r28.setSourceQuery(r24);
        r28.setDetail(r25);
        r28.setDetailStatus(r26);
        r28.set_packageName(r27);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r28, MemoryEntity.class, "com.obric.memorydata.plugin");
    L31:
        return null;
    L32:
        r4 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r3, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L18 JsonSyntaxException -> L20
    L20:
        e = e;
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r31 = new StringBuilder();
    L22:
        IRunLog.a.b(r110, "GsonExt", r31.append("toListObj error : ").append(e).toString(), null, 4, null);
    L18:
        e = e;
        r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r31 = new StringBuilder();
        goto L22
    L13:
        r12 = null;
        goto L14
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
        if (ZeusTransformUtils.instanceOf(r58, OrderMovieTicketMemoryEntity.class) == false) goto L5;
        OrderMovieTicketMemoryEntity r0 = (OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r58, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L29;
        String r35 = r0.getMovieName();
        String r1 = r0.getMovieDate();
        if (r1 == null) goto L10;
        Long r20 = Long.valueOf(com.obric.memorydata.utils.r.d(r1));
    L11:
        String r2 = r0.getStartTime();
        if (r2 == null) goto L14;
        Long r21 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getMovieDate(), r2));
    L15:
        String r4 = r0.getEndTime();
        if (r4 == null) goto L18;
        Long r23 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getMovieDate(), r4));
    L19:
        String r36 = r0.getMovieTheaterName();
        String r37 = r0.getMovieTheaterAddress();
        String r30 = r0.getMovieHallNumber();
        List<String> r5 = r0.getSeatNumber();
        if (r5 == null) goto L22;
        String r31 = r5.toString();
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
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, r20, r21, null, r23, r24, r25, r3, null, null, null, r30, r31, null, null, null, r35, r36, r37, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -476307151, 2063, null);
    L22:
        r31 = null;
        goto L23
    L18:
        r23 = null;
        goto L19
    L14:
        r21 = null;
        goto L15
    L10:
        r20 = null;
        goto L11
    L29:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
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
    public MemoryEntity c(MemoryEntity r7) {
        Intrinsics.checkNotNullParameter(r7, "entity");
        if (ZeusTransformUtils.instanceOf(r7, OrderMovieTicketMemoryEntity.class) == false) goto L5;
        OrderMovieTicketMemoryEntity r8 = (OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L25;
        String r0 = r8.getMovieDate();
        if (r0 == null) goto L10;
        Long r1 = Long.valueOf(com.obric.memorydata.utils.r.d(r0));
    L11:
        String r2 = r8.getStartTime();
        if (r2 == null) goto L14;
        Long r3 = Long.valueOf(com.obric.memorydata.utils.r.b(r8.getMovieDate(), r2));
    L15:
        String r9 = r8.getMovieName();
        if (r1 == null) goto L23;
        if (r3 == null) goto L23;
        if (r9 == null) goto L23;
        RawMemoryEntity r10 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((startDate = ? AND startTime = ? AND keyword1 = ?))", new String[]{"10003", r1.toString(), r3.toString(), r9.toString()});
        if (r10 == null) goto L23;
        return a(r10);
    L23:
        return null;
    L14:
        r3 = null;
        goto L15
    L10:
        r1 = null;
        goto L11
    L25:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
    L5:
        r8 = null;
        goto L6
    }
}
