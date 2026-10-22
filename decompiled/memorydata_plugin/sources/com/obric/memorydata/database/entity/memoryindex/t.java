package com.obric.memorydata.database.entity.memoryindex;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/OrderTrainMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t implements f {

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public t() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r33) {
        Intrinsics.checkNotNullParameter(r33, "rawEntity");
        String r0 = r33.getKeyword5();
        if (r0 != null) goto L54;
        List r22 = null;
    L13:
        Long r1 = r33.getStartDate();
        if (r1 == null) goto L16;
        String r12 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L17:
        Long r2 = r33.getStartTime();
        if (r2 == null) goto L20;
        String r15 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue());
    L21:
        Long r3 = r33.getEndDate();
        if (r3 == null) goto L24;
        String r18 = com.obric.memorydata.utils.r.h(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
    L25:
        Long r4 = r33.getEndTime();
        if (r4 == null) goto L28;
        String r16 = com.obric.memorydata.utils.r.g(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
    L29:
        String r13 = r33.getKeyword1();
        String r14 = r33.getKeyword2();
        String r19 = r33.getKeyword3();
        String r20 = r33.getKeyword4();
        String r17 = r33.getKey3();
        String r21 = r33.getKey1();
        String r5 = r33.getKey2();
        if (r5 != null) goto L52;
        List r23 = null;
    L40:
        long r7 = r33.getCreateTime();
        int r11 = r33.getProductType();
        long r9 = r33.getModifyTime();
        String r6 = r33.getEntityId();
        String r8 = r33.getSourceLinkType();
        String r10 = r33.getSourceLink();
        FileEntity r24 = com.obric.memorydata.personalcontext.util.f.c(r33.getScreenshot());
        String r25 = r33.getSourceText();
        String r26 = r33.getSourcePackageName();
        String r27 = r33.getSourceAppName();
        String r28 = r33.getLogId();
        String r29 = r33.getUuid();
        String r30 = r33.getSourceQuery();
        String r31 = r33.getDetail();
        int r32 = r33.getDetailStatus();
        String r34 = r33.getPackageName();
        if (r12 == null) goto L50;
        if (r15 == null) goto L56;
        if (r16 == null) goto L57;
        if (r13 == null) goto L58;
        if (r14 == null) goto L59;
        if (r17 == null) goto L60;
        OrderTrainMemoryEntity r35 = new OrderTrainMemoryEntity(r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        r35.setSourceLinkType(r8);
        r35.setSourceLink(r10);
        r35.setScreenshot(r24);
        r35.setSourceText(r25);
        r35.setSourcePackageName(r26);
        r35.setSourceAppName(r27);
        r35.setLogId(r28);
        r35.setUuid(r29);
        r35.setSourceQuery(r30);
        r35.setDetail(r31);
        r35.setDetailStatus(r32);
        r35.set_packageName(r34);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r35, MemoryEntity.class, "com.obric.memorydata.plugin");
    L60:
        return null;
    L59:
        return null;
    L58:
        return null;
    L57:
        return null;
    L56:
        return null;
    L50:
        return null;
    L52:
        List r36 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r5, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L33 JsonSyntaxException -> L35
    L38:
        r23 = r36;
        goto L40
    L35:
        e = e;
        IRunLog r37 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r38 = new StringBuilder();
    L37:
        IRunLog.a.b(r37, "GsonExt", r38.append("toListObj error : ").append(e).toString(), null, 4, null);
        r36 = null;
    L33:
        e = e;
        r37 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r38 = new StringBuilder();
        goto L37
    L28:
        r16 = null;
        goto L29
    L24:
        r18 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L16:
        r12 = null;
        goto L17
    L54:
        List r39 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r0, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L11:
        r22 = r39;
        goto L13
    L8:
        e = e;
        IRunLog r40 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r41 = new StringBuilder();
    L10:
        IRunLog.a.b(r40, "GsonExt", r41.append("toListObj error : ").append(e).toString(), null, 4, null);
        r39 = null;
    L6:
        e = e;
        r40 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r41 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, OrderTrainMemoryEntity.class) == false) goto L5;
        OrderTrainMemoryEntity r0 = (OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r58, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L37;
        List<String> r1 = r0.getPassengerName();
        if (r1 == null) goto L10;
        String r39 = r1.toString();
    L11:
        String r2 = r0.getDepartureDate();
        if (r2 == null) goto L14;
        Long r20 = Long.valueOf(com.obric.memorydata.utils.r.d(r2));
    L15:
        String r4 = r0.getDepartureTime();
        if (r4 == null) goto L18;
        Long r21 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getDepartureDate(), r4));
    L19:
        String r5 = r0.getArrivalDate();
        if (r5 == null) goto L22;
        Long r22 = Long.valueOf(com.obric.memorydata.utils.r.d(r5));
    L23:
        String r6 = r0.getArrivalTime();
        if (r6 == null) goto L26;
        Long r23 = Long.valueOf(com.obric.memorydata.utils.r.b(r0.getArrivalDate(), r6));
    L27:
        String r35 = r0.getDeparturePlace();
        String r36 = r0.getDestination();
        String r37 = r0.getDepartureStation();
        String r38 = r0.getArrivalStation();
        String r32 = r0.getTrainNumber();
        String r30 = r0.getTicketGate();
        List<String> r7 = r0.getSeatNumber();
        if (r7 == null) goto L30;
        String r31 = r7.toString();
    L31:
        long r8 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r9 = r0.getScreenshot();
        if (r9 == null) goto L34;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.memorydata.plugin"));
    L34:
        String r10 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r10, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, r20, r21, r22, r23, r24, r25, r3, null, null, null, r30, r31, r32, null, null, r35, r36, r37, r38, r39, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -2095316687, 2063, null);
    L30:
        r31 = null;
        goto L31
    L26:
        r23 = null;
        goto L27
    L22:
        r22 = null;
        goto L23
    L18:
        r21 = null;
        goto L19
    L14:
        r20 = null;
        goto L15
    L10:
        r39 = null;
        goto L11
    L37:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity");
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
    public MemoryEntity c(MemoryEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        if (ZeusTransformUtils.instanceOf(r8, OrderTrainMemoryEntity.class) == false) goto L5;
        OrderTrainMemoryEntity r9 = (OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r9 == null) goto L27;
        String r0 = r9.getDepartureDate();
        if (r0 == null) goto L10;
        Long r1 = Long.valueOf(com.obric.memorydata.utils.r.d(r0));
    L11:
        String r2 = r9.getTrainNumber();
        String r3 = r9.getDepartureTime();
        if (r3 == null) goto L14;
        Long r4 = Long.valueOf(com.obric.memorydata.utils.r.b(r9.getDepartureDate(), r3));
    L15:
        String r10 = r9.getDepartureStation();
        if (r1 == null) goto L18;
        if (r2 == null) goto L18;
    L21:
        RawMemoryEntity r11 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((startDate = ? AND key3 = ?) OR (startDate = ? AND startTime = ? AND keyword3 = ?))", new String[]{"10002", r1.toString(), r2.toString(), r1.toString(), String.valueOf(r4), String.valueOf(r10)});
        if (r11 != null) goto L24;
    L25:
        return null;
    L24:
        return a(r11);
    L18:
        if (r1 == null) goto L25;
        if (r4 == null) goto L25;
        if (r10 == null) goto L25;
    L14:
        r4 = null;
        goto L15
    L10:
        r1 = null;
        goto L11
    L27:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity");
    L5:
        r9 = null;
        goto L6
    }
}
