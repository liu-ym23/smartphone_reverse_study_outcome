package com.obric.memorydata.personalcontext.storage;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.memorydata.database.entity.hl;
import com.obric.memorydata.database.entity.hz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\tH\u0016J&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0002¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ScheduleEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "indexWithDeltaTime", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "jsonObject", "Lcom/google/gson/JsonObject;", "isSupportBulkDelete", "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "readRawRruleCompat", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z extends a {
    public z() {
    }

    private final String a(ScheduleEntity r10) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
        Method[] r2 = r10.getClass().getMethods();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r2, "getMethods(...)");     // Catch: Throwable -> L28
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        int r4 = r3.length;     // Catch: Throwable -> L28
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L17;
        Object r6 = r3[r5];     // Catch: Throwable -> L28
        Method r7 = (Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        boolean r8 = true;
        if (Intrinsics.areEqual(r7.getName(), "getRawRrule") == false) goto L13;
        Class<?>[] r9 = r7.getParameterTypes();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r9, "getParameterTypes(...)");     // Catch: Throwable -> L28
        if (((Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
    L14:
        if (r8 == true) goto L18;
        r5 = r5 + 1;     // Catch: Throwable -> L28
    L18:
        Method r12 = (Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r12 == null) goto L21;
        Object r13 = r12.invoke(r10, new Object[0]);     // Catch: Throwable -> L28
    L23:
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L25;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
    L26:
        Object r15 = Result.m1421constructorimpl(r14);     // Catch: Throwable -> L28
    L31:
        if (Result.m1427isFailureimpl(r15) == true) goto L35;
        r0 = r15;
    L35:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L25:
        r14 = null;
        goto L26
    L21:
        r13 = null;
        goto L23
    L10:
        r11 = false;
    L13:
        r8 = false;
        goto L14
    L17:
        r6 = null;
    L28:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    private static final boolean a(z r43, ScheduleEntity r44, JsonObject r45) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(r43, a.class, "com.obric.memorydata.plugin");
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(r44, AppEntity.class, "com.obric.memorydata.plugin");
        String r9 = r44.getId();
        long r10 = r44.getCreateTime();
        long r12 = r44.getLastModifiedTime();
        int r14 = r44.getType();
        String r17 = r44.get_packageName();
        int r18 = r44.getHashCodeValue();
        String r20 = r44.getName();
        String r21 = r44.getAddress();
        if (r44.getAttendees() != null) goto L5;
        String r22 = null;
    L10:
        String r23 = r44.getRepeatDescription();
        boolean r24 = r44.getAllDay();
        String r25 = r44.getNote();
        Boolean r26 = r44.getCompleted();
        boolean r27 = r44.isFavorite();
        String r28 = r44.getReminderDesc();
        Long r6 = r44.getStartTimestamp();
        if (r6 == null) goto L13;
        long r30 = r6.longValue();
    L14:
        Long r7 = r44.getEndTimestamp();
        if (r7 == null) goto L17;
        long r32 = r7.longValue();
    L18:
        JsonElement r8 = r45.get("startDateTimestamp");
        if (ZeusTransformUtils.instanceOf(r8, JsonPrimitive.class) == false) goto L21;
        JsonPrimitive r11 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r8, JsonPrimitive.class, "com.obric.memorydata.plugin");
    L22:
        if (r11 == null) goto L24;
        long r34 = r11.getAsLong();
    L25:
        JsonElement r13 = r45.get("endDateTimestamp");
        if (ZeusTransformUtils.instanceOf(r13, JsonPrimitive.class) == false) goto L28;
        JsonPrimitive r15 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r13, JsonPrimitive.class, "com.obric.memorydata.plugin");
    L29:
        if (r15 == null) goto L31;
        long r36 = r15.getAsLong();
    L32:
        JsonElement r16 = r45.get("deltaDay");
        if (ZeusTransformUtils.instanceOf(r16, JsonPrimitive.class) == false) goto L35;
        JsonPrimitive r19 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r16, JsonPrimitive.class, "com.obric.memorydata.plugin");
    L37:
        if (r19 == null) goto L39;
        int r29 = r19.getAsInt();
    L40:
        Integer r38 = Integer.valueOf(r29);
        JsonElement r31 = r45.get("deltaMonth");
        if (ZeusTransformUtils.instanceOf(r31, JsonPrimitive.class) == false) goto L43;
        JsonPrimitive r33 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r31, JsonPrimitive.class, "com.obric.memorydata.plugin");
    L44:
        if (r33 == null) goto L46;
        int r35 = r33.getAsInt();
    L47:
        Integer r39 = Integer.valueOf(r35);
        JsonElement r0 = r45.get("deltaYear");
        if (ZeusTransformUtils.instanceOf(r0, JsonPrimitive.class) == false) goto L50;
        JsonPrimitive r2 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r0, JsonPrimitive.class, "com.obric.memorydata.plugin");
    L51:
        if (r2 == null) goto L53;
        int r3 = r2.getAsInt();
    L54:
        hz r42 = new hz(r30, r32, r34, r36, r38, r39, Integer.valueOf(r3));
        return com.obric.memorydata.database.a.C0451a.a(a.a(r1, r4, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hl(0, r9, r10, r12, r14, 0, r17, r18, null, r20, r21, r22, r23, r24, r25, r26, r27, r28, null, null, null, null, null, null, r44.getIcsId(), r44.getRecurrenceId(), r43.a(r44), r42, r44.getCalendarType(), 16515361, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), null, 4, null), false, 1, null);
    L53:
        r3 = 0;
        goto L54
    L50:
        r2 = null;
        goto L51
    L46:
        r35 = 0;
        goto L47
    L43:
        r33 = null;
        goto L44
    L39:
        r29 = 0;
        goto L40
    L35:
        r19 = null;
        goto L37
    L31:
        r36 = 0;
        goto L32
    L28:
        r15 = null;
        goto L29
    L24:
        r34 = 0;
        goto L25
    L21:
        r11 = null;
        goto L22
    L17:
        r32 = 0;
        goto L18
    L13:
        r30 = 0;
        goto L14
    L5:
        List<ContactEntity> r37 = r44.getAttendees();
        Intrinsics.checkNotNull(r37);
        Iterable r40 = (Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin");
        Collection r41 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r46 = r40.iterator();
    L7:
        if (r46.hasNext() == false) goto L9;
        r41.add(((ContactEntity) ZeusTransformUtils.preCheckCast(r46.next(), ContactEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L7
    L9:
        r22 = ((List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.memorydata.plugin")).toString();
        goto L10
    }

    public static /* synthetic */ boolean lambda$ITO3WA3PS_G9Its6OpYDFSbdMzA(z r0, ScheduleEntity r1, JsonObject r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r41, boolean r42) {
        Intrinsics.checkNotNullParameter(r41, "appEntity");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r41, ScheduleEntity.class) == false) goto L23;
        String r6 = r41.getId();
        long r7 = r41.getCreateTime();
        long r9 = r41.getLastModifiedTime();
        int r11 = r41.getType();
        String r14 = r41.get_packageName();
        int r15 = r41.getHashCodeValue();
        String r17 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getName();
        String r18 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getAddress();
        if (((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getAttendees() != null) goto L7;
    L6:
        String r19 = r2;
        String r20 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getRepeatDescription();
        boolean r21 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getAllDay();
        String r22 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getNote();
        Boolean r23 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getCompleted();
        boolean r24 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).isFavorite();
        String r25 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getReminderDesc();
        Long r3 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getStartTimestamp();
        if (r3 == null) goto L15;
        long r27 = r3.longValue();
    L16:
        Long r4 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getEndTimestamp();
        if (r4 == null) goto L19;
        long r29 = r4.longValue();
    L20:
        hz r1 = new hz(r27, r29, 0, 0, null, null, null, 124, null);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hl(0, r6, r7, r9, r11, 0, r14, r15, null, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, null, null, null, null, null, ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getIcsId(), ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getRecurrenceId(), a((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")), r1, ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getCalendarType(), 16515361, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L19:
        r29 = 0;
        goto L20
    L15:
        r27 = 0;
        goto L16
    L7:
        List<ContactEntity> r5 = ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r41, ScheduleEntity.class, "com.obric.memorydata.plugin")).getAttendees();
        Intrinsics.checkNotNull(r5);
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r8.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r10.add(((ContactEntity) ZeusTransformUtils.preCheckCast(r12.next(), ContactEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L9
    L11:
        r2 = ((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")).toString();
        goto L6
    L23:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return false;
    }

    public final boolean a(final ScheduleEntity r2, final JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.d.a(new $$Lambda$z$ITO3WA3PS_G9Its6OpYDFSbdMzA(this, r2, r3)), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }
}
