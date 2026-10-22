package com.obric.memorydata.personalcontext.search.bridge.impl;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.bridge.MatchType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl;
import com.obric.memorydata.personalcontext.search.bridge.e;
import com.obric.memorydata.personalcontext.search.bridge.g;
import com.obric.memorydata.personalcontext.search.bridge.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u009d\u0001\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00072\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00072\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00072\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001fJD\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00072\u0006\u0010\u0017\u001a\u00020\u00062\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00072\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/impl/KeywordSearchBridgeImpl;", "Lcom/obric/memorydata/personalcontext/search/bridge/ISearchBridge;", "<init>", "()V", "keywordTransformMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "reversedKeywordTransformMap", "invokeSearch", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "entitySearchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", TrackerImpl.PARAMS, "", "getMethodName", "performKeywordIndexSearch", "keywordMap", "", "keywordToSynonymColumns", "keywordToHomonymColumns", "limit", "entityType", "targetIds", "", "isFullMatch", "", "isResultUnion", "updateEntityParams", "isReverseKeyword", "(Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;IILjava/lang/Long;ZZZZ)Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "transformKeywordMap", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Map<String, String>> f12301b = null;
    private static final ConcurrentHashMap<Integer, Map<String, String>> c = null;

    static {
        f12300a = new a();
        f12301b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    private a() {
    }

    private final com.obric.memorydata.personalcontext.search.bridge.c a(e r28, Map<String, ? extends List<String>> r29, Map<String, ? extends List<String>> r30, Map<String, ? extends List<String>> r31, int r32, int r33, Long r34, boolean r35, boolean r36, boolean r37, boolean r38) {
        Map<String, ? extends List<String>> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L30;
        List<Object> r7 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r28.a()).d().a(r34.longValue());
        if (r7 == null) goto L17;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L8;
        r9.add(r11);
        goto L8
    L12:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r13.add(Long.valueOf(((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        List<Long> r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L18:
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L31;
        RunLog r0 = RunLog.INSTANCE;
        String r2 = "performKeywordIndexSearch called, targetIds is empty";
    L27:
        r0.debug("NativeEntitySearch", r2);
    L29:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r28);
    L31:
        List<Long> r18 = r15;
        Map<String, List<String>> r19 = a(r33, r3, r38);
        Map<String, List<String>> r20 = a(r33, r4, r38);
        Map<String, List<String>> r1 = a(r33, r5, r38);
        if (r19.isEmpty() == true) goto L34;
    L38:
        Map<MatchType, Map<String, List<Map<Long, List<String>>>>> r6 = AppEntityIndexBridgeAPIImpl.INSTANCE.queryMatchedColumns(r33, r19, r20, r1, r32, r18, r35);
        int r21 = 3;
        MatchType[] r22 = {MatchType.ACCURATE_MATCH, MatchType.SYNONYM_MATCH, MatchType.HOMONYM_MATCH};
        Set r23 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Set r25 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        int r26 = 0;
        boolean r27 = false;
    L39:
        if (r26 >= r21) goto L90;
        Map r39 = (Map) ZeusTransformUtils.preCheckCast(r6.get(r22[r26]), Map.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L87;
        Iterator r40 = r39.entrySet().iterator();
    L44:
        if (r40.hasNext() == false) goto L86;
        Map.Entry r41 = (Map.Entry) ZeusTransformUtils.preCheckCast(r40.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r41.getKey(), String.class, "com.obric.memorydata.plugin");
        List r42 = (List) ZeusTransformUtils.preCheckCast(r41.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r36 == true) goto L48;
        Set r111 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L49:
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(r42, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r43.hasNext() == false) goto L79;
        Iterator r112 = ((Map) ZeusTransformUtils.preCheckCast(r43.next(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L54:
        if (r112.hasNext() == false) goto L51;
        Map<MatchType, Map<String, List<Map<Long, List<String>>>>> r310 = r6;
        Map.Entry r44 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r311 = r40;
        long r113 = ((Number) ZeusTransformUtils.preCheckCast(r44.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue();
        List r45 = (List) ZeusTransformUtils.preCheckCast(r44.getValue(), List.class, "com.obric.memorydata.plugin");
        r111.add(Long.valueOf(r113));
        if (r37 == false) goto L76;
        List r46 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r47 = ((Iterable) ZeusTransformUtils.preCheckCast(r45, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L59:
        if (r47.hasNext() == false) goto L67;
        Iterator r312 = r47;
        String r48 = (String) ZeusTransformUtils.preCheckCast(r47.next(), String.class, "com.obric.memorydata.plugin");
        MatchType[] r313 = r22;
        Map r49 = (Map) ZeusTransformUtils.preCheckCast(c.get(Integer.valueOf(r33)), Map.class, "com.obric.memorydata.plugin");
        if (r49 == null) goto L63;
        String r50 = (String) ZeusTransformUtils.preCheckCast(r49.get(r48), String.class, "com.obric.memorydata.plugin");
    L64:
        if (r50 == null) goto L66;
        r46.add(r50);
        r25.add(r50);
    L66:
        r47 = r312;
        r22 = r313;
        goto L59
    L63:
        r50 = null;
        goto L64
    L67:
        MatchType[] r314 = r22;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L77;
        Long r51 = Long.valueOf(r113);
        Object r52 = r24.get(r51);
        if (r52 != null) goto L72;
        r52 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r24.put(r51, r52);
    L72:
        Map r53 = (Map) ZeusTransformUtils.preCheckCast(r52, Map.class, "com.obric.memorydata.plugin");
        Object r54 = r53.get(r110);
        if (r54 != null) goto L75;
        r54 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r53.put(r110, r54);
    L75:
        ((Set) ZeusTransformUtils.preCheckCast(r54, Set.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin"));
    L77:
        r6 = r310;
        r40 = r311;
        r22 = r314;
        goto L54
    L76:
        r314 = r22;
        goto L77
    L79:
        Map<MatchType, Map<String, List<Map<Long, List<String>>>>> r315 = r6;
        Iterator r316 = r40;
        MatchType[] r317 = r22;
        if (r36 == true) goto L85;
        Collection<?> r55 = (Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin");
        if (r27 == false) goto L84;
        r23.retainAll(r55);
        goto L85
    L84:
        r23.addAll(r55);
    L85:
        r6 = r315;
        r40 = r316;
        r22 = r317;
        r27 = true;
        goto L44
    L48:
        r111 = r23;
        goto L49
    L86:
        Map<MatchType, Map<String, List<Map<Long, List<String>>>>> r318 = r6;
        MatchType[] r319 = r22;
        Unit r56 = Unit.INSTANCE;
    L88:
        r26 = r26 + 1;
        r6 = r318;
        r22 = r319;
        r21 = 3;
        goto L39
    L87:
        r318 = r6;
        r319 = r22;
        goto L88
    L90:
        if (r28.b() == false) goto L92;
        Map r57 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L94:
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r28.a()).f() == true) goto L29;
        if (r37 == true) goto L98;
    L143:
        Iterable r58 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
        Collection r59 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r60 = r58.iterator();
    L145:
        if (r60.hasNext() == false) goto L148;
        r59.add(new com.obric.memorydata.personalcontext.search.bridge.d(((Number) ZeusTransformUtils.preCheckCast(r60.next(), Number.class, "com.obric.memorydata.plugin")).longValue(), r33));
        goto L145
    L148:
        return new com.obric.memorydata.personalcontext.search.bridge.c(com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r28.a()).d().a((List) ZeusTransformUtils.preCheckCast(r59, List.class, "com.obric.memorydata.plugin")), r57);
    L98:
        if (r28.f() == false) goto L143;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L143;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r61 = s.a().getRawDaoByEntityType(r33);
        String r62 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r63 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if (r61 == null) goto L143;
        Iterable r64 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.bridge.a.f12279a.b((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id, " + r63 + " FROM " + r61.getTableName() + " WHERE id in (" + r62 + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map r65 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r64, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r66 = r64.iterator();
    L105:
        if (r66.hasNext() == false) goto L116;
        Object r67 = r66.next();
        Object r68 = ((Map) ZeusTransformUtils.preCheckCast(r67, Map.class, "com.obric.memorydata.plugin")).get(OaidModel.KEY_ID);
        if (ZeusTransformUtils.instanceOf(r68, String.class) == false) goto L109;
        String r69 = (String) ZeusTransformUtils.preCheckCast(r68, String.class, "com.obric.memorydata.plugin");
    L110:
        if (r69 == null) goto L114;
        Long r70 = StringsKt.toLongOrNull(r69);
        if (r70 == null) goto L114;
        long r71 = r70.longValue();
    L115:
        r65.put(Long.valueOf(r71), r67);
    L114:
        r71 = -1;
        goto L115
    L109:
        r69 = null;
        goto L110
    L116:
        Iterator r72 = r24.entrySet().iterator();
    L118:
        if (r72.hasNext() == false) goto L143;
        Map.Entry r73 = (Map.Entry) ZeusTransformUtils.preCheckCast(r72.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        long r74 = ((Number) ZeusTransformUtils.preCheckCast(r73.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Map r75 = (Map) ZeusTransformUtils.preCheckCast(r73.getValue(), Map.class, "com.obric.memorydata.plugin");
        Map r76 = (Map) ZeusTransformUtils.preCheckCast(r65.get(Long.valueOf(r74)), Map.class, "com.obric.memorydata.plugin");
        if (r76 == null) goto L142;
        Iterator r77 = r75.entrySet().iterator();
    L123:
        if (r77.hasNext() == false) goto L142;
        Map.Entry r78 = (Map.Entry) ZeusTransformUtils.preCheckCast(r77.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r114 = (String) ZeusTransformUtils.preCheckCast(r78.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r79 = ((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(r78.getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L126:
        if (r79.hasNext() == false) goto L123;
        String r115 = (String) ZeusTransformUtils.preCheckCast(r79.next(), String.class, "com.obric.memorydata.plugin");
        Object r116 = r76.get(r115);
        if (r116 == null) goto L131;
        String r117 = r116.toString();
        if (r117 == null) goto L131;
    L132:
        Iterator r210 = r72;
        h r118 = new h(new InAppSearchEntityParam(r114, r115, r117, false, null, null, 48, null), false, 2, null);
        if (r28.c() == false) goto L135;
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r28.a()).a().a(r33, r74, r118);
    L135:
        if (r57 == null) goto L140;
        String r80 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(r74, Integer.valueOf(r33));
        Object r81 = r57.get(r80);
        if (r81 != null) goto L139;
        r81 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r57.put(r80, r81);
    L139:
        Boolean.valueOf(((List) ZeusTransformUtils.preCheckCast(r81, List.class, "com.obric.memorydata.plugin")).add(r118));
    L140:
        r72 = r210;
    L131:
        r117 = "";
    L142:
        r72 = r72;
        goto L118
    L92:
        r57 = null;
        goto L94
    L34:
        if (r20.isEmpty() == false) goto L38;
        if (r1.isEmpty() == false) goto L38;
        r0 = RunLog.INSTANCE;
        r2 = "performKeywordIndexSearch called, keywordMap is empty";
        goto L27
    L21:
        if (r16.isEmpty() == true) goto L24;
        r17 = false;
        goto L25
    L17:
        r15 = null;
        goto L18
    L30:
        r15 = CollectionsKt.emptyList();
        goto L31
    }

    private final Map<String, List<String>> a(int r8, Map<String, ? extends List<String>> r9, boolean r10) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L15;
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r14.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r11.get(r2);
        if (r3 != null) goto L13;
        r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r11.put(r2, r3);
    L13:
        ((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin")).add(r1);
        goto L9
    L14:
        r7 = r11;
    L15:
        Map<String, String> r15 = (Map) ZeusTransformUtils.preCheckCast(f12301b.get(Integer.valueOf(r8)), Map.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L27;
        com.obric.memorydata.database.index.e r16 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.preCheckCast(s.a().getEntityIndexImplMap().get(Integer.valueOf(r8)), com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L26;
        r15 = r16.getKeywordColumnMap();
        if (r15 == null) goto L26;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin");
        Integer r4 = Integer.valueOf(r8);
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, String>> r6 = r15.entrySet().iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.add(TuplesKt.to((String) ZeusTransformUtils.preCheckCast(r18.getValue(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r18.getKey(), String.class, "com.obric.memorydata.plugin")));
        goto L23
    L25:
        r17.put(r4, MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        ((Map) ZeusTransformUtils.preCheckCast(f12301b, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r8), r15);
    L26:
        r15 = null;
    L27:
        if (r15 != null) goto L30;
        RunLog.INSTANCE.debug("NativeEntitySearch", "transformedKeyMap is null, entityType: " + r8);
        return MapsKt.emptyMap();
    L30:
        Map<String, List<String>> r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r20 = r7.entrySet().iterator();
    L32:
        if (r20.hasNext() == false) goto L42;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(r110.getValue(), Collection.class, "com.obric.memorydata.plugin");
        List<String> r22 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r112.hasNext() == false) goto L40;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r15.get((String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L35;
        r22.add(r23);
        goto L35
    L40:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r19.put(r21, r22);
        goto L32
    L42:
        return r19;
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public com.obric.memorydata.personalcontext.search.bridge.c a(e r16, Map<String, ? extends Object> r17) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r0, TrackerImpl.PARAMS);
        Object r2 = r0.get("keyword_map");
        Boolean r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, Map.class) == false) goto L5;
        Map<String, ? extends List<String>> r3 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        Object r4 = r0.get("keyword_to_synonym_columns");
        if (ZeusTransformUtils.instanceOf(r4, Map.class) == false) goto L11;
        Map<String, ? extends List<String>> r6 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");
    L12:
        if (r6 != null) goto L14;
        r6 = MapsKt.emptyMap();
    L14:
        Map<String, ? extends List<String>> r7 = r6;
        Object r8 = r0.get("keyword_to_homonym_columns");
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == false) goto L17;
        Map<String, ? extends List<String>> r9 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
    L18:
        if (r9 != null) goto L20;
        r9 = MapsKt.emptyMap();
    L20:
        Map<String, ? extends List<String>> r10 = r9;
        Object r11 = r0.get("limit");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
        int r12 = ((Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r13 = r0.get(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Int");
        int r14 = ((Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r15 = r0.get("target_ids");
        if (ZeusTransformUtils.instanceOf(r15, Number.class) == false) goto L23;
        Number r18 = (Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin");
    L24:
        if (r18 == null) goto L26;
        Long r19 = Long.valueOf(r18.longValue());
    L27:
        Object r20 = r0.get("is_full_match");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r110 = ((Boolean) ZeusTransformUtils.preCheckCast(r20, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Object r21 = r0.get("is_result_union");
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r111 = ((Boolean) ZeusTransformUtils.preCheckCast(r21, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Object r22 = r0.get("update_entity_params");
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r112 = ((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Object r1 = r0.get("is_reverse_keyword");
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L30;
        r5 = (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin");
    L30:
        if (r5 == null) goto L32;
        boolean r23 = r5.booleanValue();
    L34:
        return a(r16, r3, r7, r10, r12, r14, r19, r110, r111, r112, r23);
    L32:
        r23 = false;
        goto L34
    L26:
        r19 = null;
        goto L27
    L23:
        r18 = null;
        goto L24
    L17:
        r9 = null;
        goto L18
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public String a() {
        return "perform_keyword_index_search";
    }
}
