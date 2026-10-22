package com.obric.memorydata.memory.memoryentity.search;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.entity.search.InAppSearchSimpleData;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.bo;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0012H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/search/MemoryInAppSearchUtils;", "", "<init>", "()V", "ONE_PAGE_LIMIT", "", "TAG", "", "KEY_SEARCH_RESULT_TYPES", "search", "", ChatMessage.TYPE_QUERY, "callback", "Lcom/obric/memorydata/memory/memoryentity/search/IMemorySearchCallback;", "parseSearchResultCategories", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "extraData", "", "parseSearchResultCategoryString", "rawTypes", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10326a = null;

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/memory/memoryentity/search/MemoryInAppSearchUtils$search$2", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "onCompleted", "", "onError", "errorCode", "", DTraitConstant.ERROR, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements IAppSearchCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.memoryentity.search.a f10327a;

        a(com.obric.memorydata.memory.memoryentity.search.a r3) {
            this.f10327a = (com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin");
        }

        private static final Unit a(com.obric.memorydata.memory.memoryentity.search.a r18, List r19) {
            com.obric.memorydata.memory.memoryentity.search.a r0 = (com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "subEntities");
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            Object r6 = r5.next();
            Integer r7 = Integer.valueOf(((InAppSearchSimpleData) ZeusTransformUtils.preCheckCast(r6, InAppSearchSimpleData.class, "com.obric.memorydata.plugin")).getType());
            Object r8 = r4.get(r7);
            if (r8 != null) goto L8;
            r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r4.put(r7, r8);
        L8:
            ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).add(r6);
            goto L4
        L9:
            Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r10 = r4.entrySet().iterator();
        L11:
            if (r10.hasNext() == false) goto L45;
            Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getValue(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L14:
            if (r15.hasNext() == false) goto L16;
            r14.add(((InAppSearchSimpleData) ZeusTransformUtils.preCheckCast(r15.next(), InAppSearchSimpleData.class, "com.obric.memorydata.plugin")).getId());
            goto L14
        L16:
            List<String> r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
            Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            IAppEntityRawDbDao<d> r110 = s.a().getRawDaoByEntityType(r12);
            if (r110 == null) goto L44;
            if (r12 != (-401)) goto L24;
            Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryByMemoryIds(r16), Iterable.class, "com.obric.memorydata.plugin");
            Map r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r21 = r111.iterator();
        L22:
            if (r21.hasNext() == false) goto L24;
            fa r112 = (fa) ZeusTransformUtils.preCheckCast(r21.next(), fa.class, "com.obric.memorydata.plugin");
            Pair r113 = TuplesKt.to(r112.b(), Integer.valueOf(r112.i()));
            r20.put(r113.getFirst(), r113.getSecond());
        L24:
            if (r110 == null) goto L44;
            Collection r22 = r110.queryByEntityIdList(r16);
            if (r22 == null) goto L44;
            Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L29:
            if (r23.hasNext() == false) goto L44;
            d r24 = (d) ZeusTransformUtils.preCheckCast(r23.next(), d.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r24, ip.class) == true) goto L32;
            if (ZeusTransformUtils.instanceOf(r24, EpisodicMemoryEntity.class) == false) goto L43;
            Integer r25 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r24, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getCategory();
            if (r25 != null) goto L40;
        L42:
            Unit r26 = Unit.INSTANCE;
            goto L29
        L40:
            if (r25.intValue() != 0) goto L42;
            r17.put(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r24, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId(), r24);
            goto L42
        L43:
            String r27 = r24.getEntityId();
        L33:
            r17.put(r27, r24);
            goto L29
        L32:
            r27 = ((ip) ZeusTransformUtils.preCheckCast(r24, ip.class, "com.obric.memorydata.plugin")).getEntityId();
        L44:
            r9.put(Integer.valueOf(r12), r17);
            goto L11
        L45:
            List<String> r28 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            List<String> r29 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r32 = r30.iterator();
        L46:
            d r114 = null;
            if (r32.hasNext() == false) goto L52;
            InAppSearchSimpleData r33 = (InAppSearchSimpleData) ZeusTransformUtils.preCheckCast(r32.next(), InAppSearchSimpleData.class, "com.obric.memorydata.plugin");
            Map r115 = (Map) ZeusTransformUtils.preCheckCast(r9.get(Integer.valueOf(r33.getType())), Map.class, "com.obric.memorydata.plugin");
            if (r115 == null) goto L51;
            r114 = (d) ZeusTransformUtils.preCheckCast(r115.get(r33.getId()), d.class, "com.obric.memorydata.plugin");
        L51:
            r31.add(TuplesKt.to(r33, r114));
            goto L46
        L52:
            List r34 = (List) ZeusTransformUtils.preCheckCast(r31, List.class, "com.obric.memorydata.plugin");
            Iterator r35 = r34.iterator();
        L54:
            if (r35.hasNext() == false) goto L66;
            d r36 = (d) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r35.next(), Pair.class, "com.obric.memorydata.plugin")).component2(), d.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r36, EpisodicMemoryEntity.class) == false) goto L63;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r36, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType() != 1003) goto L63;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r36, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType() == 10105) goto L63;
            r28.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r36, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        L63:
            if (ZeusTransformUtils.instanceOf(r36, ip.class) == false) goto L54;
            r29.add(((ip) ZeusTransformUtils.preCheckCast(r36, ip.class, "com.obric.memorydata.plugin")).getEntityId());
            goto L54
        L66:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L71;
            Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getCollectMemoryWithRelevantByEntityIds(r28), Iterable.class, "com.obric.memorydata.plugin");
            Map r38 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r37, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r39 = r37.iterator();
        L69:
            if (r39.hasNext() == false) goto L73;
            Object r40 = r39.next();
            r38.put(((bt) ZeusTransformUtils.preCheckCast(r40, bt.class, "com.obric.memorydata.plugin")).a().getEntityId(), r40);
        L73:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L78;
            Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getMemoryWithRelevantByEntityIds(r29), Iterable.class, "com.obric.memorydata.plugin");
            Map r42 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r41, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r43 = r41.iterator();
        L76:
            if (r43.hasNext() == false) goto L79;
            Object r44 = r43.next();
            r42.put(((ih) ZeusTransformUtils.preCheckCast(r44, ih.class, "com.obric.memorydata.plugin")).a().getEntityId(), r44);
        L79:
            Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.memorydata.plugin");
            Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r47 = r45.iterator();
        L81:
            if (r47.hasNext() == false) goto L108;
            Pair r48 = (Pair) ZeusTransformUtils.preCheckCast(r47.next(), Pair.class, "com.obric.memorydata.plugin");
            InAppSearchSimpleData r49 = (InAppSearchSimpleData) ZeusTransformUtils.preCheckCast(r48.component1(), InAppSearchSimpleData.class, "com.obric.memorydata.plugin");
            d r116 = (d) ZeusTransformUtils.preCheckCast(r48.component2(), d.class, "com.obric.memorydata.plugin");
            if (r116 != null) goto L86;
        L84:
            c r50 = null;
        L106:
            if (r50 == null) goto L81;
            r46.add(r50);
            goto L81
        L86:
            if (ZeusTransformUtils.instanceOf(r116, EpisodicMemoryEntity.class) == false) goto L97;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r116, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType() != 1003) goto L97;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r116, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType() == 10105) goto L97;
            bt r51 = (bt) ZeusTransformUtils.preCheckCast(r38.get(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r116, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId()), bt.class, "com.obric.memorydata.plugin");
            if (r51 == null) goto L84;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "onSearchResultWithoutEntity, episodic: " + r51.a().getEntityId(), false, 4, null);
            RawMemoryEntity r52 = new bo(r51.a(), r51.b()).a();
            if (r52 == null) goto L84;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "toRawMemoryEntity, episodic: " + r52.getEntityId(), false, 4, null);
            r50 = new c((d) ZeusTransformUtils.preCheckCast(r52, d.class, "com.obric.memorydata.plugin"), r49.getParams(), MemorySearchResultCategory.FAVORITE);
        L97:
            if (ZeusTransformUtils.instanceOf(r116, ip.class) == false) goto L104;
            ih r53 = (ih) ZeusTransformUtils.preCheckCast(r42.get(((ip) ZeusTransformUtils.preCheckCast(r116, ip.class, "com.obric.memorydata.plugin")).getEntityId()), ih.class, "com.obric.memorydata.plugin");
            if (r53 == null) goto L84;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "onSearchResultWithoutEntity, semantic: " + r53.a().getEntityId(), false, 4, null);
            RawMemoryEntity r54 = new ig(r53.a(), r53.b()).c();
            if (r54 == null) goto L84;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "toRawMemoryEntity, semantic: " + r54.getEntityId(), false, 4, null);
            r50 = new c((d) ZeusTransformUtils.preCheckCast(r54, d.class, "com.obric.memorydata.plugin"), r49.getParams(), MemorySearchResultCategory.PERSONAL);
            goto L106
        L104:
            if (ZeusTransformUtils.instanceOf(r116, RawMemoryEntity.class) == true) goto L84;
            r50 = new c(r116, r49.getParams(), null, 4, null);
            goto L106
        L108:
            List<c> r55 = (List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.memorydata.plugin");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r55, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L112;
            r0.a(r55);
        L112:
            return Unit.INSTANCE;
        L78:
            r42 = MapsKt.emptyMap();
            goto L79
        L71:
            r38 = MapsKt.emptyMap();
            goto L73
        }

        private static final void a(InAppSearchResultWithoutEntity r3, com.obric.memorydata.memory.memoryentity.search.a r4) {
            final com.obric.memorydata.memory.memoryentity.search.a r5 = (com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin");
            b r0 = b.f10326a;
            Map<String, Object> r2 = r3.getExtraData();
            if (r2 != null) goto L5;
            r2 = MapsKt.emptyMap();
        L5:
            List<? extends MemorySearchResultCategory> r1 = b.a(r0, r2);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L9;
            r1 = null;
        L9:
            if (r1 == null) goto L11;
            r5.b(r1);
        L11:
            CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r3.getEntities(), Iterable.class, "com.obric.memorydata.plugin"), 100, new $$Lambda$b$a$Uu2b38vCsm3alnl1FIJRoD1fM4(r5));
        }

        private static final void a(com.obric.memorydata.memory.memoryentity.search.a r2) {
            ((com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin")).a();
        }

        private static final void a(com.obric.memorydata.memory.memoryentity.search.a r2, int r3, String r4) {
            ((com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin")).a(r3, r4);
        }

        public static /* synthetic */ void lambda$KrKacGv7igWnm15UMBPZbgIDsSo(com.obric.memorydata.memory.memoryentity.search.a r0) {
            a(r0);
        }

        /* JADX INFO: renamed from: lambda$Uu2b38vCsm3alnl1FIJRoD1fM-4, reason: not valid java name */
        public static /* synthetic */ Unit m742lambda$Uu2b38vCsm3alnl1FIJRoD1fM4(com.obric.memorydata.memory.memoryentity.search.a r0, List r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ void lambda$Z6JEEn4WHFH6ktytJBDW9Oemgrs(com.obric.memorydata.memory.memoryentity.search.a r0, int r1, String r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$ZhlqXjyhftuxhht_yDh9N4kQutc(InAppSearchResultWithoutEntity r0, com.obric.memorydata.memory.memoryentity.search.a r1) {
            a(r0, r1);
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onCompleted() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "InAppSearchClient onCompleted", false, 4, null);
            GlobalHandlerUtil r0 = GlobalHandlerUtil.Companion.getInstance();
            final com.obric.memorydata.memory.memoryentity.search.a r7 = this.f10327a;
            r0.postDelay(0, new $$Lambda$b$a$KrKacGv7igWnm15UMBPZbgIDsSo(r7));
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onError(final int r8, final String r9) {
            Intrinsics.checkNotNullParameter(r9, DTraitConstant.ERROR);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "InAppSearchClient onError, errorCode: " + r8 + ", errorMsg: " + r9, null, 4, null);
            GlobalHandlerUtil r0 = GlobalHandlerUtil.Companion.getInstance();
            final com.obric.memorydata.memory.memoryentity.search.a r7 = this.f10327a;
            r0.postDelay(0, new $$Lambda$b$a$Z6JEEn4WHFH6ktytJBDW9Oemgrs(r7, r8, r9));
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResult(InAppSearchResult r7) {
            Intrinsics.checkNotNullParameter(r7, "result");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "InAppSearchClient onSearchResult: entities size: " + r7.getEntities().size(), false, 4, null);
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r8) {
            Intrinsics.checkNotNullParameter(r8, "result");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInAppSearchUtils", "InAppSearchClient onSearchResultWithoutEntity: entities size: " + r8.getEntities().size(), false, 4, null);
            GlobalHandlerUtil r0 = GlobalHandlerUtil.Companion.getInstance();
            final com.obric.memorydata.memory.memoryentity.search.a r7 = this.f10327a;
            r0.postDelay(0, new $$Lambda$b$a$ZhlqXjyhftuxhht_yDh9N4kQutc(r8, r7));
        }
    }

    static {
        f10326a = new b();
    }

    private b() {
    }

    public static final /* synthetic */ List a(b r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private final List<MemorySearchResultCategory> a(String r8) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        JSONArray r7 = new JSONArray(r8);     // Catch: Exception -> L14
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r7.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Iterator r3 = r1.iterator();     // Catch: Exception -> L14
    L8:
        if (r3.hasNext() == false) goto L12;
        int r4 = ((IntIterator) ZeusTransformUtils.preCheckCast(r3, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();     // Catch: Exception -> L14
        MemorySearchResultCategory.a r5 = MemorySearchResultCategory.Companion;     // Catch: Exception -> L14
        String r6 = r7.optString(r4);     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");     // Catch: Exception -> L14
        MemorySearchResultCategory r9 = r5.a(r6);     // Catch: Exception -> L14
        if (r9 == null) goto L8;
        r2.add(r9);     // Catch: Exception -> L14
        goto L8
    L12:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
    L22:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"));
    L14:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        MemorySearchResultCategory r15 = MemorySearchResultCategory.Companion.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r15 == null) goto L16;
        r12.add(r15);
        goto L16
    L20:
        r10 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        goto L22
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<MemorySearchResultCategory> a(Map<String, ? extends Object> r6) {
        Object r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin")).get("search_result_types");
        if (r7 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (ZeusTransformUtils.instanceOf(r7, List.class) == false) goto L22;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r5.iterator();
    L10:
        if (r9.hasNext() == false) goto L19;
        Object r0 = r9.next();
        if (r0 == null) goto L16;
        String r1 = r0.toString();
        if (r1 == null) goto L16;
        MemorySearchResultCategory r2 = MemorySearchResultCategory.Companion.a(r1);
    L17:
        if (r2 == null) goto L10;
        r8.add(r2);
    L16:
        r2 = null;
        goto L17
    L19:
        Object r10 = ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L20:
        List<MemorySearchResultCategory> r11 = (List) r10;
    L35:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"));
    L22:
        if (ZeusTransformUtils.instanceOf(r7, JSONArray.class) == false) goto L31;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin")).length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L25:
        if (r13.hasNext() == false) goto L29;
        int r4 = ((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        MemorySearchResultCategory.a r14 = MemorySearchResultCategory.Companion;
        String r15 = ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin")).optString(r4);
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        MemorySearchResultCategory r16 = r14.a(r15);
        if (r16 == null) goto L25;
        r3.add(r16);
        goto L25
    L29:
        r10 = ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        goto L20
    L31:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L33;
        r11 = a((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
        goto L35
    L33:
        r11 = CollectionsKt.emptyList();
        goto L35
    }

    public final void a(String r11, com.obric.memorydata.memory.memoryentity.search.a r12) {
        com.obric.memorydata.memory.memoryentity.search.a r10 = (com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        InAppSearchClient.INSTANCE.prepareSearch();
        InAppSearchClient r13 = InAppSearchClient.INSTANCE;
        InAppSearchRequest r9 = new InAppSearchRequest(r11, 0, false, false, 0, 30, null);
        r9.setFirstPageLimit(100);
        r9.setOtherPagesLimit(100);
        Unit r14 = Unit.INSTANCE;
        r13.startAppSearch("search_all_memory_entity", r9, (IAppSearchCallback) ZeusTransformUtils.preCheckCast(new a(r10), IAppSearchCallback.class, "com.obric.memorydata.plugin"));
    }
}
