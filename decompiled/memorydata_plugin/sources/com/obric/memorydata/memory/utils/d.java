package com.obric.memorydata.memory.utils;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J4\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005J4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005J*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J2\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/utils/MemoryDeleteWithEventTracker;", "", "<init>", "()V", "TAG", "", "BULK_DELETE_CHUNK_SIZE", "", "bulkDelete", "", "entityMetaInfoList", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "deleteMethod", "bulkDeleteWithAppEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityIds", "entityType", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryUuidMap", "", "queryAppEntities", "normalizeEntityType", "trackDeletedMemory", "", "successIds", "uuidMap", "appEntities", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11534a = null;

    static {
        f11534a = new d();
    }

    private d() {
    }

    private final int a(int r1) {
        if (r1 != (-303)) goto L6;
        return -306;
    L6:
        return r1;
    }

    private final Map<String, String> a(List<String> r5, int r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r4 = a(r6);
        if (r4 != (-401)) goto L5;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r7), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L55:
        if (r10.hasNext() == false) goto L68;
        ip r11 = (ip) ZeusTransformUtils.preCheckCast(r10.next(), ip.class, "com.obric.memorydata.plugin");
        String r2 = r11.getUuid();
        if (r2 != null) goto L59;
    L64:
        Pair r12 = null;
    L65:
        if (r12 == null) goto L55;
        r9.add(r12);
        goto L55
    L59:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L62;
        r2 = null;
    L62:
        if (r2 == null) goto L64;
        r12 = TuplesKt.to(r11.getEntityId(), r2);
    L68:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r4 != (-306)) goto L7;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(r7), Iterable.class, "com.obric.memorydata.plugin");
        r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L41:
        if (r14.hasNext() == false) goto L68;
        EpisodicMemoryEntity r15 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r14.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        String r3 = r15.getUuid();
        if (r3 != null) goto L45;
    L50:
        Pair r16 = null;
    L51:
        if (r16 == null) goto L41;
        r9.add(r16);
        goto L41
    L45:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L48;
        r3 = null;
    L48:
        if (r3 == null) goto L50;
        r16 = TuplesKt.to(r15.getEntityId(), r3);
        goto L51
    L7:
        if (r4 != (-303)) goto L9;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityIds(r7), Iterable.class, "com.obric.memorydata.plugin");
        r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L27:
        if (r18.hasNext() == false) goto L68;
        RawMemoryEntity r19 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r18.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        String r20 = r19.getUuid();
        if (r20 != null) goto L31;
    L36:
        Pair r21 = null;
    L37:
        if (r21 == null) goto L27;
        r9.add(r21);
        goto L27
    L31:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L34;
        r20 = null;
    L34:
        if (r20 == null) goto L36;
        r21 = TuplesKt.to(r19.getEntityId(), r20);
        goto L37
    L9:
        if (r4 != 502) goto L89;
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityIds(r7), Iterable.class, "com.obric.memorydata.plugin");
        r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r22.iterator();
    L13:
        if (r23.hasNext() == false) goto L68;
        fj r24 = (fj) ZeusTransformUtils.preCheckCast(r23.next(), fj.class, "com.obric.memorydata.plugin");
        String r25 = r24.getUuid();
        if (r25 != null) goto L17;
    L22:
        Pair r26 = null;
    L23:
        if (r26 == null) goto L13;
        r9.add(r26);
        goto L13
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L20;
        r25 = null;
    L20:
        if (r25 == null) goto L22;
        r26 = TuplesKt.to(r24.getEntityId(), r25);
        goto L23
    L89:
        return MapsKt.emptyMap();
    }

    private final void a(List<? extends AppEntity> r5, String r6) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        String r1 = ((AppEntity) ZeusTransformUtils.preCheckCast(r8.next(), AppEntity.class, "com.obric.memorydata.plugin")).getUuid();
        if (r1 != null) goto L8;
    L10:
        r1 = null;
    L11:
        if (r1 == null) goto L4;
        r7.add(r1);
        goto L4
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
    L13:
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L17;
        RunLog.INSTANCE.debug("MemoryDeleteWithEventTracker", "trackDeletedMemory skipped, no uuid matched");
        return;
    L17:
        MemoryEventTracker.f10515a.a(r9, r6);
    }

    private final void a(List<String> r4, Map<String, String> r5, String r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.get((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        r9.add(r1);
        goto L4
    L8:
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L12;
        RunLog.INSTANCE.debug("MemoryDeleteWithEventTracker", "trackDeletedMemory skipped, no uuid matched");
        return;
    L12:
        MemoryEventTracker.f10515a.a(r11, r6);
    }

    private final List<AppEntity> b(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r2 = a(r4);
        if (r2 != (-401)) goto L5;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L31:
        if (r8.hasNext() == false) goto L36;
        AppEntity r9 = ((ip) ZeusTransformUtils.preCheckCast(r8.next(), ip.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r9 == null) goto L31;
        r7.add(r9);
    L36:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L5:
        if (r2 != (-306)) goto L7;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L36;
        AppEntity r12 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r11.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r12 == null) goto L25;
        r7.add(r12);
        goto L25
    L7:
        if (r2 != (-303)) goto L9;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L19:
        if (r14.hasNext() == false) goto L36;
        AppEntity r15 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r14.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r15 == null) goto L19;
        r7.add(r15);
        goto L19
    L9:
        if (r2 != 502) goto L57;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L36;
        AppEntity r18 = ((fj) ZeusTransformUtils.preCheckCast(r17.next(), fj.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r18 == null) goto L13;
        r7.add(r18);
        goto L13
    L57:
        return CollectionsKt.emptyList();
    }

    public final List<String> a(Collection<cu> r17, String r18) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r17, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "entityMetaInfoList");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (at.a(((cu) ZeusTransformUtils.preCheckCast(r4, cu.class, "com.obric.memorydata.plugin")).b()) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L11;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        cu r10 = (cu) ZeusTransformUtils.preCheckCast(r9, cu.class, "com.obric.memorydata.plugin");
        Pair r11 = TuplesKt.to(Integer.valueOf(r10.getType()), r10.b());
        Object r12 = r7.get(r11);
        if (r12 != null) goto L18;
        r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r7.put(r11, r12);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L14
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDeleteWithEventTracker", "bulkDelete groupedEntityMetaInfo size: " + r7.size(), false, 4, null);
        List<String> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r15.getKey(), Pair.class, "com.obric.memorydata.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(r15.getValue(), List.class, "com.obric.memorydata.plugin");
        int r20 = 0;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        int r23 = r20 + 1;
        if (r20 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDeleteWithEventTracker", "bulkDelete chunk, type: " + ((Number) ZeusTransformUtils.preCheckCast(r16.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() + ", packageName: " + ((String) ZeusTransformUtils.preCheckCast(r16.getSecond(), String.class, "com.obric.memorydata.plugin")) + ", chunkIndex: " + r20 + ", chunkSize: " + r24.size() + ", groupSize: " + r19.size(), false, 4, null);
        d r25 = f11534a;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L30:
        if (r28.hasNext() == false) goto L32;
        r27.add(((cu) ZeusTransformUtils.preCheckCast(r28.next(), cu.class, "com.obric.memorydata.plugin")).a());
        goto L30
    L32:
        List<String> r29 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin");
        int r30 = ((Number) ZeusTransformUtils.preCheckCast(r16.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Object r110 = r16.getSecond();
        Intrinsics.checkNotNull(r110);
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r25.a(r29, r30, (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin"), r18), Collection.class, "com.obric.memorydata.plugin"));
        r20 = r23;
        goto L24
    L34:
        return r13;
    L11:
        return CollectionsKt.emptyList();
    }

    public final List<String> a(List<String> r22, int r23, String r24, String r25) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "entityIds");
        Intrinsics.checkNotNullParameter(r24, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r11.isEmpty() == true) goto L5;
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r13.hasNext() == false) goto L21;
        Object r0 = r13.next();
        int r14 = r1 + 1;
        if (r1 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDeleteWithEventTracker", "bulkDelete entityIds chunk, type: " + r23 + ", packageName: " + r24 + ", chunkIndex: " + r1 + ", chunkSize: " + r2.size() + ", totalSize: " + r11.size(), false, 4, null);
        if (r25 == null) goto L15;
        Map<String, String> r3 = f11534a.a(r2, r23);
    L16:
        Map<String, String> r15 = r3;
        List<String> r4 = IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r2, r23, r24, null, 8, null);
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
        if (r25 == null) goto L20;
        if (r15 == null) goto L20;
        f11534a.a(r4, r15, r25);
    L20:
        r1 = r14;
        goto L8
    L15:
        r3 = null;
        goto L16
    L21:
        return r12;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> b(Collection<cu> r17, String r18) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r17, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "entityMetaInfoList");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (at.a(((cu) ZeusTransformUtils.preCheckCast(r4, cu.class, "com.obric.memorydata.plugin")).b()) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L11;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        cu r10 = (cu) ZeusTransformUtils.preCheckCast(r9, cu.class, "com.obric.memorydata.plugin");
        Pair r11 = TuplesKt.to(Integer.valueOf(r10.getType()), r10.b());
        Object r12 = r7.get(r11);
        if (r12 != null) goto L18;
        r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r7.put(r11, r12);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L14
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDeleteWithEventTracker", "bulkDeleteWithAppEntities groupedEntityMetaInfo size: " + r7.size(), false, 4, null);
        List<AppEntity> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r15.getKey(), Pair.class, "com.obric.memorydata.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(r15.getValue(), List.class, "com.obric.memorydata.plugin");
        int r20 = 0;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        int r23 = r20 + 1;
        if (r20 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDeleteWithEventTracker", "bulkDeleteWithAppEntities chunk, type: " + ((Number) ZeusTransformUtils.preCheckCast(r16.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() + ", packageName: " + ((String) ZeusTransformUtils.preCheckCast(r16.getSecond(), String.class, "com.obric.memorydata.plugin")) + ", chunkIndex: " + r20 + ", chunkSize: " + r24.size() + ", groupSize: " + r19.size(), false, 4, null);
        d r25 = f11534a;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L30:
        if (r28.hasNext() == false) goto L32;
        r27.add(((cu) ZeusTransformUtils.preCheckCast(r28.next(), cu.class, "com.obric.memorydata.plugin")).a());
        goto L30
    L32:
        List<String> r29 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin");
        int r30 = ((Number) ZeusTransformUtils.preCheckCast(r16.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Object r110 = r16.getSecond();
        Intrinsics.checkNotNull(r110);
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r25.b(r29, r30, (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin"), r18), Collection.class, "com.obric.memorydata.plugin"));
        r20 = r23;
        goto L24
    L34:
        return r13;
    L11:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> b(List<String> r10, int r11, String r12, String r13) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r3.isEmpty() == true) goto L5;
        List<AppEntity> r14 = b(r3, r11);
        Set r15 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r3, r11, r12, null, 8, null), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L12;
        Object r0 = r18.next();
        if (r15.contains(((AppEntity) ZeusTransformUtils.preCheckCast(r0, AppEntity.class, "com.obric.memorydata.plugin")).getId()) == false) goto L8;
        r17.add(r0);
        goto L8
    L12:
        List<AppEntity> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L15;
        a(r19, r13);
    L15:
        return r19;
    L5:
        return CollectionsKt.emptyList();
    }
}
