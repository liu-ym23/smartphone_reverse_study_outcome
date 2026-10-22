package com.obric.memorydata.database.entity;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0003\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f*\b\u0012\u0004\u0012\u00020\u00040\f\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00040\f\u001a(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\b\u0012\u0004\u0012\u00020\u00030\f\u001a\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"PRODUCT_TYPE_MEMORY_COMMON_TEXT", "", "toEpisodicMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "toProactiveEpisodicRelevantData", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "toRawMemoryEntity", "episodic", "relevant", "entityId", "toEpisodicMemoryEntities", "", "toProactiveEpisodicRelevantDatas", "toRawMemoryEntities", "episodics", "relevants", "toRawMemoryEntitiesList", "entityIds", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class bi {
    public static final EpisodicMemoryEntity a(RawMemoryEntity r59) {
        Intrinsics.checkNotNullParameter(r59, "<this>");
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), 10005, Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT), Integer.valueOf(EntityType.MEMORY_COLLECT_STORE)}).contains(Integer.valueOf(r59.getMemoryType())) == true) goto L6;
        return null;
    L6:
        String r0 = r59.getDetail();
        String r7 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        int r8 = r59.getMemoryType();
        if (r8 == 10005) goto L31;
        if (r8 == 10401) goto L27;
        if (r8 == 10201) goto L21;
        if (r8 == 10202) goto L15;
    L14:
        String r16 = r0;
        String r15 = r7;
    L40:
        return new EpisodicMemoryEntity(0, r59.getCreateTime(), 0, r15, r16, r59.getContentWithTime(), r59.getFullContent(), "", "", "", 0, null, null, null, r59.getLogId(), null, null, false, 0, 0, null, r59.getEntityId(), r59.getCreateTime(), r59.getModifyTime(), -306, r59.getTimestamp(), r59.getPackageName(), r59.getHashCodeValue(), r59.getUuid(), Boolean.valueOf(r59.getUserEdit()), 1003, null, null, null, null, null, null, null, null, -2147483647, 127, null);
    L15:
        String r1 = r59.getKey1();
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        String r2 = r59.getKey2();
        if (r2 == null) goto L38;
    L37:
        r7 = r2;
    L38:
        r15 = r1;
        r16 = r7;
        goto L40
    L21:
        r1 = r59.getKey1();
        if (r1 != null) goto L24;
        r1 = "";
    L24:
        r2 = r59.getKey3();
        if (r2 != null) goto L37;
    L27:
        String r3 = r59.getKey3();
        if (r3 == null) goto L14;
        r7 = r3;
        goto L14
    L31:
        r1 = r59.getKeyword1();
        if (r1 != null) goto L34;
        r1 = "";
    L34:
        r2 = r59.getKey1();
        if (r2 != null) goto L37;
        goto L37
    }

    public static final RawMemoryEntity a(EpisodicMemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        es r0 = (es) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryByEpisodicId(r3.getEntityId())), es.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r3, r0);
    }

    public static final RawMemoryEntity a(EpisodicMemoryEntity r56, es r57) {
        Intrinsics.checkNotNullParameter(r56, "episodic");
        Intrinsics.checkNotNullParameter(r57, "relevant");
        String r6 = r56.getEntityId();
        long r7 = r56.getCreateTime();
        long r9 = r56.getModifyTime();
        String r14 = r56.getPackageName();
        int r18 = r57.j();
        String r23 = r57.f();
        String r24 = r57.e();
        String r25 = r57.g();
        String r47 = r56.getLogId();
        String r48 = r57.c();
        String r44 = r57.d();
        int r50 = r57.n();
        Boolean r0 = r56.getUserEdit();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        long r12 = r56.getTimestamp();
        int r15 = r56.getHashCodeValue();
        String r16 = r56.getUuid();
        String r51 = r56.getContentWithTime();
        String r28 = r56.getFullContent();
        String r45 = r57.h();
        String r46 = r57.i();
        RawMemoryEntity r2 = new RawMemoryEntity(0, r6, r7, r9, 0, r12, r14, r15, r16, EntityType.MEMORY_COMMON_TEXT, r18, null, null, null, null, r23, r24, r25, null, null, r28, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r44, r45, r46, r47, r48, null, r50, r51, r1, -1290223, 527, null);
        r2.setKey2(r57.m());
        r2.setKey3(r56.getTitle());
        r2.setKey4(r57.l());
        r2.setKey5(r57.k());
        r2.setDetail(r56.getContent());
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static final es b(RawMemoryEntity r34) {
        Intrinsics.checkNotNullParameter(r34, "<this>");
        boolean r4 = false;
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), 10005, Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT), Integer.valueOf(EntityType.MEMORY_COLLECT_STORE)}).contains(Integer.valueOf(r34.getMemoryType())) == true) goto L5;
        return null;
    L5:
        String r0 = r34.getSourcePackageName();
        String r9 = r34.getSourceAppName();
        int r10 = r34.getMemoryType();
        String r11 = "";
        if (r10 == 10005) goto L38;
        if (r10 != 10401) goto L9;
        String r2 = r34.getKey2();
        if (r2 != null) goto L36;
        String r8 = "";
    L37:
        String r25 = r34.getKey4();
        String r24 = r34.getKey5();
        String r26 = r8;
    L12:
        String r22 = r9;
    L44:
        return new es(0, r34.getEntityId(), r34.getSourceQuery(), r34.getSourceText(), r34.getSourceLink(), r34.getSourceLinkType(), r34.getScreenshot(), r0, r22, r34.getProductType(), r24, r25, r26, r34.getDetailStatus(), null, null, null, null, 245761, null);
    L36:
        r8 = r2;
        goto L37
    L9:
        if (r10 == 10201) goto L23;
        if (r10 == 10202) goto L13;
        r24 = null;
        r25 = null;
        r26 = null;
        goto L12
    L13:
        r0 = r34.getKey4();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r34.getKeyword1(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L16;
    L17:
        r4 = true;
    L18:
        if (r4 == true) goto L20;
        r9 = r34.getKeyword1();
    L20:
        String r5 = r34.getKey2();
        if (r5 == null) goto L42;
    L41:
        r11 = r5;
    L42:
        r0 = r0;
        r24 = null;
        r25 = null;
        r22 = r9;
        r26 = r11;
        goto L44
    L16:
        if (r3.length() != 0) goto L18;
    L23:
        r0 = r34.getKey4();
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r34.getKeyword1(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L26;
    L27:
        r4 = true;
    L28:
        if (r4 == true) goto L30;
        r9 = r34.getKeyword1();
    L30:
        r5 = r34.getKey3();
        if (r5 != null) goto L41;
    L26:
        if (r6.length() != 0) goto L28;
    L38:
        r5 = r34.getKey1();
        if (r5 != null) goto L41;
        goto L41
    }
}
