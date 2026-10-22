package com.obric.memorydata.database.entity.memoryindex;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/CollectContentMemoryEntityTool;", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityTool;", "<init>", "()V", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "toMemoryEntity", "rawEntity", "isMemoryValid", "", "findSameMemoryEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements f {

    /* JADX INFO: renamed from: com.obric.memorydata.database.entity.memoryindex.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0456a extends TypeToken<List<? extends String>> {
        public C0456a() {
        }
    }

    public a() {
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public MemoryEntity a(RawMemoryEntity r27) {
        Intrinsics.checkNotNullParameter(r27, "rawEntity");
        String r11 = r27.getKeyword1();
        String r9 = r27.getKey1();
        String r0 = r27.getKey2();
        if (r0 != null) goto L20;
        List r13 = null;
    L13:
        String r10 = r27.getKey3();
        String r12 = r27.getKey4();
        long r4 = r27.getCreateTime();
        int r8 = r27.getProductType();
        long r6 = r27.getModifyTime();
        String r1 = r27.getEntityId();
        String r2 = r27.getSourceLinkType();
        String r15 = r27.getSourceLink();
        FileEntity r14 = com.obric.memorydata.personalcontext.util.f.c(r27.getScreenshot());
        String r16 = r27.getSourceText();
        String r17 = r27.getSourcePackageName();
        String r18 = r27.getSourceAppName();
        String r19 = r27.getLogId();
        String r110 = r27.getUuid();
        String r111 = r27.getSourceQuery();
        String r112 = r27.getDetail();
        int r113 = r27.getDetailStatus();
        String r3 = r27.getPackageName();
        if (r9 == null) goto L19;
        if (r10 == null) goto L19;
        CollectContentMemoryEntity r5 = new CollectContentMemoryEntity(r1, r4, r6, r8, r9, r10, r11, r12, r13);
        r5.setSourceLinkType(r2);
        r5.setSourceLink(r15);
        r5.setScreenshot(r14);
        r5.setSourceText(r16);
        r5.setSourcePackageName(r17);
        r5.setSourceAppName(r18);
        r5.setLogId(r19);
        r5.setUuid(r110);
        r5.setSourceQuery(r111);
        r5.setDetail(r112);
        r5.setDetailStatus(r113);
        r5.set_packageName(r3);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r5, MemoryEntity.class, "com.obric.memorydata.plugin");
    L19:
        return null;
    L20:
        List r7 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r0, new C0456a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L11:
        r13 = r7;
        goto L13
    L8:
        e = e;
        IRunLog r114 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder();
    L10:
        IRunLog.a.b(r114, "GsonExt", r20.append("toListObj error : ").append(e).toString(), null, 4, null);
        r7 = null;
    L6:
        e = e;
        r114 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r20 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.memoryindex.f
    public RawMemoryEntity a(MemoryEntity r58) {
        Intrinsics.checkNotNullParameter(r58, "entity");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r58, CollectContentMemoryEntity.class) == false) goto L5;
        CollectContentMemoryEntity r0 = (CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r58, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L17;
        String r35 = r0.getAppName();
        String r30 = r0.getTitle();
        List<String> r1 = r0.getTags();
        if (r1 == null) goto L10;
        String r31 = r1.toString();
    L11:
        String r32 = r0.getSummary();
        String r33 = r0.getAppPkgName();
        long r8 = r0.getCreateTime();
        int r16 = r0.getHashCodeValue();
        int r19 = r0.getProductType();
        String r24 = r0.getSourceLinkType();
        String r25 = r0.getSourceLink();
        FileEntity r2 = r0.getScreenshot();
        if (r2 == null) goto L14;
        r3 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.memorydata.plugin"));
    L14:
        String r7 = r0.getId();
        int r18 = r0.getType();
        return new RawMemoryEntity(0, r7, r8, r0.getLastModifiedTime(), 0, 0, r0.get_packageName(), r16, null, r18, r19, null, null, null, null, r24, r25, r3, null, null, null, r30, r31, r32, r33, null, r35, null, null, null, null, null, null, null, null, null, r0.getSourceText(), r0.getSourcePackageName(), r0.getSourceAppName(), r0.getLogId(), r0.getSourceQuery(), r0.getDetail(), r0.getDetailStatus(), null, r0.getUserEdit(), -98797263, 2063, null);
    L10:
        r31 = null;
        goto L11
    L17:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity");
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
        if (ZeusTransformUtils.instanceOf(r11, CollectContentMemoryEntity.class) == false) goto L5;
        CollectContentMemoryEntity r12 = (CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r11, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 == null) goto L25;
        String r0 = r12.getSourceLinkType();
        String r2 = r12.getSourceLink();
        String r3 = r12.getTitle();
        String r13 = r12.getAppPkgName();
        if (Intrinsics.areEqual(r0, MemorySourceLinkType.INTENT) == true) goto L17;
        if (r0 == null) goto L11;
        if (r2 == null) goto L11;
    L13:
        RawMemoryEntity r14 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((sourceLinkType = ? AND sourceLink = ?) OR (key1 = ? AND key4 = ?))", new String[]{"10201", String.valueOf(r0), String.valueOf(r2), r3.toString(), String.valueOf(r13)});
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
        RawMemoryEntity r15 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getSameMemory("memoryType = ? AND ((key1 = ? AND key4 = ?))", new String[]{"10201", r3.toString(), r13.toString()});
        if (r15 == null) goto L23;
        return a(r15);
    L25:
        throw new IllegalArgumentException("entity is not com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity");
    L5:
        r12 = null;
        goto L6
    }
}
