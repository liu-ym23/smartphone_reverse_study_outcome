package com.obric.memorydata.memory.f;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.bn;
import com.obric.memorydata.database.entity.cq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bridge.AppEntityIndexBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.VectorDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.sdk.d;
import com.obric.memorydata.utils.h;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/task/AfterRawMemoryTranslateTask;", "", "<init>", "()V", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "CHUNK_SIZE", "", "TAG", "", "runIfNeeded", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10123b = null;

    static {
        f10122a = new a();
        f10123b = new AtomicBoolean(false);
    }

    private a() {
    }

    private static final Unit a(IStore r48) {
        String r1 = ", episodics=";
        String r2 = ", cost=";
        String r4 = "finish, cost=";
        String r6 = "ms";
        IStore r8 = (IStore) ZeusTransformUtils.wrapperContextForParams(r48, IStore.class, "com.obric.memorydata.plugin");
        long r10 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", CommonConsts.APM_INNER_EVENT_COST_START, false, 4, null);
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L148 Exception -> L153
        List<Long> r12 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao().queryRawDbIdsByEntityType(NetError.ERR_INVALID_REDIRECT);     // Catch: Throwable -> L148 Exception -> L153
        String r16 = "step2 page=";
        long r17 = r10;
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", "step1 query remain -303 metaFullContent copilot rawDbIds size=" + r12.size());     // Catch: Throwable -> L143 Exception -> L145
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L143 Exception -> L145
        int r11 = 0;
    L6:
        if (r3.hasNext() == false) goto L21;
        final List r14 = (List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19 Throwable -> L143
        r11 = r11 + 1;     // Catch: Exception -> L19 Throwable -> L143
        Iterator r19 = r3;
        String r18 = r4;
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", "step1 delete batch=" + r11 + " size=" + r14.size());     // Catch: Exception -> L16 Throwable -> L137
        d.a(new $$Lambda$a$w4t6eIeQ1t24GczZ2Rl7U4mbTwk(r14));     // Catch: Exception -> L16 Throwable -> L137
        r3 = r19;
        r4 = r18;
    L14:
        th = move-exception;
        Throwable r5 = th;
    L139:
        String r7 = "after_raw_memory_translate_task";
        String r9 = "ms";
    L140:
        String r15 = r18;
    L162:
        r8.save(r7, false);
        f10123b.set(false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", r15 + (System.currentTimeMillis() - r17) + r9, false, 4, null);
        throw r5;
    L16:
        e = move-exception;
        Exception r20 = e;
        String r35 = "after_raw_memory_translate_task";
        String r28 = "ms";
    L18:
        r18 = r18;
    L169:
        RunLog.INSTANCE.error("AfterRawMemoryTranslateTask", "AfterRawMemoryTranslateTask error", (Throwable) ZeusTransformUtils.preCheckCast(r20, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L160
        r8.save(r35, false);
        f10123b.set(false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", r18 + (System.currentTimeMillis() - r17) + r28, false, 4, null);
    L159:
        return Unit.INSTANCE;
    L160:
        th = move-exception;
        r15 = r18;
        r9 = r28;
        r7 = r35;
        r5 = th;
    L137:
        th = move-exception;
        r5 = th;
        goto L139
    L19:
        e = move-exception;
        r20 = e;
        r18 = r4;
        r35 = "after_raw_memory_translate_task";
        r28 = "ms";
        goto L169
    L21:
        r18 = r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", "step1 finish, deleteType=-303, rawDbIds=" + r12.size() + ", batches=" + r11 + ", cost=" + (System.currentTimeMillis() - r13) + "ms", false, 4, null);     // Catch: Throwable -> L137 Exception -> L141
        long r21 = System.currentTimeMillis();     // Catch: Throwable -> L137 Exception -> L141
        String r110 = "after_raw_memory_translate_task";
        r8 = r8;
        long r22 = 0;
        int r23 = 0;
        int r24 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
    L180:
        String r25 = r6;
        String r26 = r2;
        int r27 = r24;
        List<EpisodicMemoryEntity> r29 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByProductTypeAfterId(1003, r22, 500);     // Catch: Throwable -> L129 Exception -> L131
        if (r29.isEmpty() == true) goto L171;
        r15 = r18;
        r8 = r8;
        r6 = r25;
        String r47 = r110;
        String r117 = r1;
        r7 = r47;
        r111 = r111 + 1;
        int r118 = r112 + r29.size();     // Catch: Throwable -> L125 Exception -> L127
        r2 = r26;
        int r210 = r23;
        long r30 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r29), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId();     // Catch: Throwable -> L125 Exception -> L127
        r112 = r118;
        Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        int r211 = r114;
        int r212 = r115;
        Map r120 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r119, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        Iterator r121 = r119.iterator();     // Catch: Throwable -> L125 Exception -> L127
    L39:
        if (r121.hasNext() == false) goto L41;
        Iterator r213 = r121;
        EpisodicMemoryEntity r122 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r121.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        Pair r123 = TuplesKt.to(r122.getEntityId(), Long.valueOf(r122.getId()));     // Catch: Throwable -> L125 Exception -> L127
        r120.put(r123.getFirst(), r123.getSecond());     // Catch: Throwable -> L125 Exception -> L127
        r121 = r213;
        goto L39
    L41:
        Iterable r124 = (Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        int r214 = r116;
        Collection r125 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        Iterator r126 = r124.iterator();     // Catch: Throwable -> L125 Exception -> L127
    L43:
        if (r126.hasNext() == false) goto L45;
        r125.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r126.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());     // Catch: Throwable -> L125 Exception -> L127
        r126 = r126;
        goto L43
    L45:
        List<String> r127 = (List) ZeusTransformUtils.preCheckCast(r125, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125 Exception -> L127
        r28 = r6;
        String r31 = r16;
        r18 = r15;
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", r31 + r111 + " episodics=" + r29.size() + " lastEpisodicId=" + r30 + " entityIds=" + r127.size());     // Catch: Throwable -> L116 Exception -> L118
        List<RawMemoryEntity> r32 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityIds(r127);     // Catch: Throwable -> L116 Exception -> L118
        r113 = r113 + r32.size();     // Catch: Throwable -> L116 Exception -> L118
        LinkedHashMap r33 = new LinkedHashMap(r32.size());     // Catch: Throwable -> L116 Exception -> L118
        Iterator r128 = ((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L116 Exception -> L118
    L51:
        if (r128.hasNext() == false) goto L56;
        RawMemoryEntity r129 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r128.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        long r34 = r30;
        Long r36 = (Long) ZeusTransformUtils.preCheckCast(r120.get(r129.getEntityId()), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        if (r36 == null) goto L55;
        ((Map) ZeusTransformUtils.preCheckCast(r33, Map.class, "com.obric.memorydata.plugin")).put(Long.valueOf(r129.getId()), Long.valueOf(r36.longValue()));     // Catch: Throwable -> L116 Exception -> L118
    L55:
        r30 = r34;
        goto L51
    L56:
        r22 = r30;
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", r31 + r111 + " rawEntities=" + r32.size() + " rawIdToShortId=" + r33.size());     // Catch: Throwable -> L116 Exception -> L118
        if (r33.isEmpty() == false) goto L60;
        r23 = r210;
        r114 = r211;
        r115 = r212;
        r116 = r214;
        r24 = r27;
        r16 = r31;
    L59:
        r6 = r28;
        r110 = r7;
        r1 = r117;
        goto L180
    L60:
        Set r37 = r33.keySet();     // Catch: Throwable -> L116 Exception -> L118
        Intrinsics.checkNotNullExpressionValue(r37, "<get-keys>(...)");     // Catch: Throwable -> L116 Exception -> L118
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L116 Exception -> L118
        r23 = r210;
        r114 = r211;
        r115 = r212;
        r116 = r214;
        int r39 = 0;
    L62:
        if (r38.hasNext() == false) goto L115;
        Iterator r215 = r38;
        List<Long> r40 = (List) ZeusTransformUtils.preCheckCast(r38.next(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        int r41 = r39 + 1;     // Catch: Throwable -> L116 Exception -> L118
        int r216 = r23;
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryEntityTextVectorCopilotDao().queryByRawDbIds(r40), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        int r217 = r113;
        Collection r130 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        Iterator r43 = r42.iterator();     // Catch: Throwable -> L116 Exception -> L118
    L65:
        int r310 = r115;
        int r311 = r116;
        if (r43.hasNext() == false) goto L79;
        Object r131 = r43.next();     // Catch: Throwable -> L116 Exception -> L118
        Iterator r312 = r43;
        cq r44 = (cq) ZeusTransformUtils.preCheckCast(r131, cq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        r35 = r7;
        if (Intrinsics.areEqual(r44.c(), MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L72;
    L75:
        boolean r45 = true;
    L76:
        if (r45 == false) goto L78;
        r130.add(r131);     // Catch: Throwable -> L111 Exception -> L113
    L78:
        r115 = r310;
        r116 = r311;
        r43 = r312;
        r7 = r35;
        goto L65
    L72:
        if (Intrinsics.areEqual(r44.c(), "fullContent") == true) goto L75;
        r45 = false;
        goto L76
    L113:
        e = e;
    L155:
        r20 = e;
    L111:
        th = move-exception;
        r5 = th;
        r15 = r18;
        r9 = r28;
        r7 = r35;
        goto L162
    L79:
        String r313 = r7;
        List r46 = (List) ZeusTransformUtils.preCheckCast(r130, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L111 Exception -> L113
        r114 = r114 + r46.size();     // Catch: Throwable -> L111 Exception -> L113
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", r31 + r111 + " rawIdChunk=" + r41 + " rawIds=" + r40.size() + " candidates=" + r46.size());     // Catch: Throwable -> L111 Exception -> L113
        ArrayList r49 = new ArrayList(r46.size());     // Catch: Throwable -> L111 Exception -> L113
        Iterator r50 = ((Iterable) ZeusTransformUtils.preCheckCast(r46, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L111 Exception -> L113
        r23 = r216;
    L82:
        if (r50.hasNext() == false) goto L101;
        Iterator r314 = r50;
        cq r51 = (cq) ZeusTransformUtils.preCheckCast(r50.next(), cq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L111 Exception -> L113
        LinkedHashMap r315 = r33;
        Long r52 = (Long) ZeusTransformUtils.preCheckCast(r33.get(Long.valueOf(r51.b())), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L111 Exception -> L113
        if (r52 == null) goto L99;
        long r410 = r52.longValue();     // Catch: Throwable -> L111 Exception -> L113
        if (Intrinsics.areEqual(r51.c(), MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L88;
        String r411 = Params.CONTENT;
    L89:
        int r316 = r41;
        long r53 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryTextVectorCopilotDao().insert(new bn(0, r410, r411, r51.d(), 1, null));     // Catch: Throwable -> L111 Exception -> L113
        r310 = r310 + 1;     // Catch: Throwable -> L111 Exception -> L113
        String r412 = r31;
        float[] r54 = VectorDbBridgeAPI.INSTANCE.searchAndDecrypt("MemoryEntityTextVectorCopilot", String.valueOf(r51.a()));     // Catch: Throwable -> L111 Exception -> L113
        if (r54 != null) goto L92;
    L98:
        r23 = r23 + 1;     // Catch: Throwable -> L111 Exception -> L113
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryTextVectorCopilotDao().deleteById(r53);     // Catch: Throwable -> L111 Exception -> L113
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", "step2 vector missing, oldTable=MemoryEntityTextVectorCopilot, oldId=" + r51.a() + ", rawDbId=" + r51.b() + ", rawDbColumn=" + r51.c(), null, 4, null);     // Catch: Throwable -> L111 Exception -> L113
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L111 Exception -> L113
    L100:
        r50 = r314;
        r33 = r315;
        r41 = r316;
        r31 = r412;
        goto L82
    L92:
        if (r54.length != 0) goto L94;
        boolean r132 = true;
    L96:
        if ((!r132) == false) goto L98;
        VectorDbBridgeAPI.INSTANCE.insertVector("ShortMemoryTextVectorCopilot", r53, r54);     // Catch: Throwable -> L111 Exception -> L113
        r311 = r311 + 1;     // Catch: Throwable -> L111 Exception -> L113
        Boolean.valueOf(r49.add(Long.valueOf(r51.a())));     // Catch: Throwable -> L111 Exception -> L113
        goto L100
    L94:
        r132 = false;
        goto L96
    L88:
        r411 = "fullContent";
        goto L89
    L99:
        r316 = r41;
        r412 = r31;
        goto L100
    L101:
        LinkedHashMap r317 = r33;
        int r318 = r41;
        String r413 = r31;
        Iterator r56 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r49, Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L111 Exception -> L113
    L103:
        if (r56.hasNext() == false) goto L110;
        List<Long> r57 = (List) ZeusTransformUtils.preCheckCast(r56.next(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L111 Exception -> L113
        Iterator r58 = ((Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L111 Exception -> L113
    L106:
        if (r58.hasNext() == false) goto L108;
        PersonalContextAPI.INSTANCE.deleteVectorCopilotItem("MemoryEntityTextVectorCopilot", ((Number) ZeusTransformUtils.preCheckCast(r58.next(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L111 Exception -> L113
        goto L106
    L108:
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryEntityTextVectorCopilotDao().deleteByIds(r57);     // Catch: Throwable -> L111 Exception -> L113
        r27 = r27 + r57.size();     // Catch: Throwable -> L111 Exception -> L113
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", "step2 delete old vectors size=" + r57.size());     // Catch: Throwable -> L111 Exception -> L113
        goto L103
    L110:
        r38 = r215;
        r113 = r217;
        r115 = r310;
        r116 = r311;
        r7 = r313;
        r33 = r317;
        r39 = r318;
        r31 = r413;
        goto L62
    L115:
        r16 = r31;
        r24 = r27;
    L118:
        e = e;
        r35 = r7;
    L116:
        th = move-exception;
        r5 = th;
        r15 = r18;
    L122:
        r9 = r28;
        goto L162
    L123:
        e = e;
        r35 = r7;
        r18 = r15;
    L120:
        th = move-exception;
        r5 = th;
    L127:
        e = e;
        r35 = r7;
        r18 = r15;
    L147:
        r28 = r6;
    L125:
        th = move-exception;
        r5 = th;
    L151:
        r9 = r6;
        goto L162
    L171:
        RunLog.INSTANCE.debug("AfterRawMemoryTranslateTask", "step2 episodicPage finish, pages=" + r111 + r1 + r112);     // Catch: Exception -> L34 Throwable -> L129
        r6 = r25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", "step2 finish, episodicPages=" + r111 + r1 + r112 + ", raws=" + r113 + ", candidates=" + r114 + ", newCopilots=" + r115 + ", vectorsInserted=" + r116 + ", vectorsMissing=" + r23 + ", oldVectorsDeleted=" + r27 + r26 + (System.currentTimeMillis() - r21) + r6, false, 4, null);     // Catch: Exception -> L32 Throwable -> L133
        r8.save(r110, false);
        f10123b.set(false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AfterRawMemoryTranslateTask", r18 + (System.currentTimeMillis() - r17) + r6, false, 4, null);
        goto L159
    L32:
        e = move-exception;
        r8 = r8;
        r20 = e;
        r28 = r6;
        r35 = r110;
        goto L18
    L34:
        e = move-exception;
        r8 = r8;
        r20 = e;
        r35 = r110;
        r18 = r18;
        r28 = r25;
    L131:
        e = e;
        r35 = r110;
        r18 = r18;
        r8 = r8;
        r28 = r25;
    L129:
        th = move-exception;
        r8 = r8;
        r5 = th;
        r7 = r110;
        r15 = r18;
        r9 = r25;
    L133:
        th = move-exception;
        r8 = r8;
        r5 = th;
        r9 = r6;
        r7 = r110;
    L135:
        e = e;
        r28 = r6;
        r35 = r110;
        r18 = r18;
        r8 = r8;
        goto L155
    L141:
        e = e;
        r35 = "after_raw_memory_translate_task";
        r28 = "ms";
        r18 = r18;
    L145:
        e = e;
        r18 = r4;
        r35 = "after_raw_memory_translate_task";
    L143:
        th = th;
    L150:
        r5 = th;
        r15 = r4;
        r7 = "after_raw_memory_translate_task";
        goto L151
    L153:
        e = e;
        r18 = "finish, cost=";
        r35 = "after_raw_memory_translate_task";
        r28 = "ms";
        r17 = r10;
    L148:
        th = th;
        r17 = r10;
        goto L150
    }

    private static final Unit a(List r2) {
        List<Long> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        AppEntityIndexBridgeAPI.INSTANCE.deleteMetaFullContentKeyword(NetError.ERR_INVALID_REDIRECT, r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$EF5bxR8326YkYLnriaTpEpwgV2c(IStore r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$w4t6eIeQ1t24GczZ2Rl7U4mbTwk(List r0) {
        return a(r0);
    }

    public final void a() {
        final IStore r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r4.getBoolean("after_raw_memory_translate_task", false) == true) goto L6;
        return;
    L6:
        if (f10123b.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        h.a(new $$Lambda$a$EF5bxR8326YkYLnriaTpEpwgV2c(r4));
    }
}
