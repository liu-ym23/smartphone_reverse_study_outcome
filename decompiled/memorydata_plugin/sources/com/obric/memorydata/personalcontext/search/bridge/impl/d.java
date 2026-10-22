package com.obric.memorydata.personalcontext.search.bridge.impl;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.SearchScoreParam;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.entity.i;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.impl.VectorDbBridgeAPIImpl;
import com.obric.memorydata.personalcontext.search.bridge.e;
import com.obric.memorydata.personalcontext.search.bridge.g;
import com.obric.memorydata.personalcontext.search.bridge.h;
import com.obric.memorydata.personalcontext.util.LRUCacheMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016Ja\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\tj\u0002`\n0\tj\u0002`\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/impl/VectorSearchBridgeImpl;", "Lcom/obric/memorydata/personalcontext/search/bridge/ISearchBridge;", "<init>", "()V", "TEXT_VECTOR", "", "IMAGE_VECTOR", "minDistanceExpressionCacheMap", "Lcom/obric/memorydata/personalcontext/util/LRUCacheMap;", "", "LRpnExpress;", "LStatementsRpnExpress;", "invokeSearch", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "entitySearchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", TrackerImpl.PARAMS, "", "", "getMethodName", "performVectorIndexSearch", "entityType", "", "minDistance", "", "wideMinDistance", "keyword", "limit", "vectorType", "targetIds", "", "minDistanceExpression", "(Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;IFFLjava/util/List;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LRUCacheMap<String, List<List<String>>> f12305b = null;

    static {
        f12304a = new d();
        f12305b = new LRUCacheMap(20);
    }

    private d() {
    }

    public final com.obric.memorydata.personalcontext.search.bridge.c a(e r31, int r32, float r33, float r34, List<String> r35, int r36, String r37, Long r38, String r39) {
        float r2 = r33;
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r31, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r37, "vectorType");
        com.obric.memorydata.personalcontext.search.bridge.a.a r7 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r31.a());
        if (r38 == null) goto L28;
        List<Object> r12 = r7.d().a(r38.longValue());
        if (r12 == null) goto L17;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if (ZeusTransformUtils.instanceOf(r16, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        r18.add(Long.valueOf(((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
    L18:
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == false) goto L29;
        RunLog.INSTANCE.debug("NativeEntitySearch", "performVectorIndexSearch called, targetIds is empty");
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L29:
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r113 != null) goto L32;
    L35:
        boolean r114 = true;
    L36:
        if (r114 == false) goto L39;
        RunLog.INSTANCE.debug("NativeEntitySearch", "performVectorIndexSearch called, keyword is empty");
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L39:
        String r115 = "text_vector";
        if (Intrinsics.areEqual(r37, "text_vector") == false) goto L43;
        IAppEntityVectorCopilotDao<i> r116 = s.a().getTextVectorCopilotDao(r32);
    L46:
        if (r116 != null) goto L50;
        RunLog.INSTANCE.debug("NativeEntitySearch", "performVectorIndexSearch called, vectorCopilotTable is null, vectorType: " + r37);
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L50:
        if (r116.isEmpty() == false) goto L53;
        RunLog.INSTANCE.debug("NativeEntitySearch", "performVectorIndexSearch called, Vector assist table is empty, vectorType: " + r37 + ", entityType: " + r32);
    L53:
        if (r34 >= 0.0f) goto L55;
    L57:
        float r9 = r2;
    L58:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L60:
        if (r6.hasNext() == false) goto L86;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.f() == true) goto L64;
        if (Intrinsics.areEqual(r37, r115) == false) goto L70;
        List<Pair<Long, Float>> r11 = VectorDbBridgeAPIImpl.INSTANCE.queryByVector(r116.getTableName(), r8, r36, r31.e(), Float.valueOf(r9));
    L68:
        Iterator r310 = r6;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L75:
        if (r20.hasNext() == false) goto L84;
        Iterator r117 = r20;
        Pair r21 = (Pair) ZeusTransformUtils.preCheckCast(r20.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r10.containsKey(r21.getFirst()) == false) goto L82;
        List r22 = (List) ZeusTransformUtils.preCheckCast(r10.get(r21.getFirst()), List.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L83;
        Boolean.valueOf(r22.add(new Pair(r8, r21.getSecond())));
    L83:
        r20 = r117;
        r9 = r9;
        r115 = r115;
        goto L75
    L82:
        r10.put(r21.getFirst(), CollectionsKt.mutableListOf(new Pair[]{new Pair(r8, r21.getSecond())}));
        Unit r23 = Unit.INSTANCE;
        goto L83
    L84:
        r6 = r310;
        goto L60
    L70:
        if (Intrinsics.areEqual(r37, "image_vector") == false) goto L72;
        r11 = VectorDbBridgeAPIImpl.INSTANCE.queryByImageVector(r116.getTableName(), r8, r36, r31.e(), Float.valueOf(r9));
        goto L68
    L72:
        r11 = CollectionsKt.emptyList();
        goto L68
    L64:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L86:
        if (r10.isEmpty() == false) goto L90;
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L90:
        if (r7.f() == true) goto L92;
        SimpleSQLiteQuery r24 = new SimpleSQLiteQuery("select id, rawDbId, rawDbColumn FROM " + r116.getTableName() + " where id in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r10.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')');
        HashSet r25 = new HashSet();
        if (r7.f() == true) goto L96;
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(r39, CharSequence.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L100;
    L103:
        boolean r27 = true;
    L104:
        if (r27 == true) goto L108;
        LRUCacheMap<String, List<List<String>>> r28 = f12305b;
        List<List<String>> r118 = (List) ZeusTransformUtils.preCheckCast(r28.get(r39), List.class, "com.obric.memorydata.plugin");
        if (r118 != null) goto L109;
        d r119 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");
        r118 = defpackage.b.f87a.a(r39);
        ((Map) ZeusTransformUtils.preCheckCast(r28, Map.class, "com.obric.memorydata.plugin")).put(r39, r118);
    L109:
        List<Map<String, Object>> r4 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.b((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r24, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        Map r29 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r40 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        float r120 = 0.0f;
    L111:
        if (r40.hasNext() == false) goto L175;
        Map r121 = (Map) ZeusTransformUtils.preCheckCast(r40.next(), Map.class, "com.obric.memorydata.plugin");
        Object r122 = r121.get(OaidModel.KEY_ID);
        Iterator r311 = r40;
        if (ZeusTransformUtils.instanceOf(r122, String.class) == false) goto L115;
        String r41 = (String) ZeusTransformUtils.preCheckCast(r122, String.class, "com.obric.memorydata.plugin");
    L116:
        if (r41 == null) goto L172;
        Long r42 = StringsKt.toLongOrNull(r41);
        if (r42 == null) goto L172;
        long r123 = r42.longValue();
        Object r43 = r121.get("rawDbId");
        if (ZeusTransformUtils.instanceOf(r43, String.class) == false) goto L122;
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43, String.class, "com.obric.memorydata.plugin");
    L123:
        if (r44 == null) goto L172;
        Long r45 = StringsKt.toLongOrNull(r44);
        if (r45 == null) goto L172;
        HashSet r312 = r25;
        long r46 = r45.longValue();
        if (r110 != null) goto L129;
    L131:
        Object r124 = r121.get("rawDbColumn");
        if (ZeusTransformUtils.instanceOf(r124, String.class) == false) goto L134;
        String r125 = (String) ZeusTransformUtils.preCheckCast(r124, String.class, "com.obric.memorydata.plugin");
    L135:
        if (r125 != null) goto L138;
    L130:
        HashSet r126 = r312;
    L173:
        r120 = r120;
    L174:
        r40 = r311;
        r25 = r126;
        r110 = r110;
        r118 = r118;
        goto L111
    L138:
        if (r31.f() == false) goto L150;
        r110 = r110;
        List r127 = (List) ZeusTransformUtils.preCheckCast(r10.get(Long.valueOf(r123)), List.class, "com.obric.memorydata.plugin");
        if (r127 == null) goto L151;
        Iterator r128 = ((Iterable) ZeusTransformUtils.preCheckCast(r127, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L143:
        if (r128.hasNext() == false) goto L148;
        Iterator r313 = r128;
        Pair r129 = (Pair) ZeusTransformUtils.preCheckCast(r128.next(), Pair.class, "com.obric.memorydata.plugin");
        float r314 = r120;
        List<List<String>> r210 = r118;
        h r130 = new h(new InAppSearchEntityParam((String) ZeusTransformUtils.preCheckCast(r129.getFirst(), String.class, "com.obric.memorydata.plugin"), r125, "", true, new SearchScoreParam(((Number) ZeusTransformUtils.preCheckCast(r129.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue(), r37), null, 32, null), false, 2, null);
        r7.a().a(r32, r46, r130);
        Long r0 = Long.valueOf(r46);
        Object r131 = r30.get(r0);
        if (r131 != null) goto L147;
        r131 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r30.put(r0, r131);
    L147:
        ((List) ZeusTransformUtils.preCheckCast(r131, List.class, "com.obric.memorydata.plugin")).add(r130);
        r128 = r313;
        r120 = r314;
        r118 = r210;
        goto L143
    L148:
        r118 = r118;
        float r315 = r120;
        Unit r1 = Unit.INSTANCE;
    L152:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r10.get(Long.valueOf(r123)), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L162;
        Iterator r47 = r3.iterator();
        float r132 = r315;
        boolean r133 = false;
    L156:
        if (r47.hasNext() == false) goto L161;
        Pair r134 = (Pair) ZeusTransformUtils.preCheckCast(r47.next(), Pair.class, "com.obric.memorydata.plugin");
        r132 = Math.max(r132, ((Number) ZeusTransformUtils.preCheckCast(r134.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue());
        if (((Number) ZeusTransformUtils.preCheckCast(r134.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() < r2) goto L156;
        r133 = true;
        goto L156
    L161:
        Unit r48 = Unit.INSTANCE;
        Unit r49 = Unit.INSTANCE;
        r120 = r132;
    L163:
        if (r133 == false) goto L165;
    L168:
        r126 = r312;
        r126.add(new com.obric.memorydata.personalcontext.search.bridge.d(r46, r32));
        Long r50 = Long.valueOf(r46);
        Object r51 = r29.get(r50);
        if (r51 != null) goto L171;
        r51 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r29.put(r50, r51);
    L171:
        ((List) ZeusTransformUtils.preCheckCast(r51, List.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r123));
        goto L174
    L165:
        if (r31.d() == true) goto L168;
        r126 = r312;
        goto L174
    L162:
        r120 = r315;
        r133 = false;
    L151:
        r315 = r120;
        goto L152
    L150:
        r110 = r110;
        goto L151
    L134:
        r125 = null;
        goto L135
    L129:
        if (r110.contains(Long.valueOf(r46)) == true) goto L131;
    L122:
        r44 = null;
    L172:
        r126 = r25;
        goto L173
    L115:
        r41 = null;
        goto L116
    L175:
        List<List<String>> r211 = r118;
        float r316 = r120;
        HashSet r135 = r25;
        if (r211 == null) goto L204;
        double r52 = defpackage.b.f87a.a(r211, MapsKt.mutableMapOf(new Pair[]{new Pair("maxValue", Double.valueOf(r316))}));
        float r53 = Math.max(r2, (float) r52);
        if (r31.d() == true) goto L203;
        HashSet r54 = new HashSet();
        Iterator r55 = ((Iterable) ZeusTransformUtils.preCheckCast(r135, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L181:
        if (r55.hasNext() == false) goto L202;
        com.obric.memorydata.personalcontext.search.bridge.d r136 = (com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r55.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin");
        List r137 = (List) ZeusTransformUtils.preCheckCast(r29.get(Long.valueOf(r136.a())), List.class, "com.obric.memorydata.plugin");
        if (r137 == null) goto L197;
        Iterator r138 = ((Iterable) ZeusTransformUtils.preCheckCast(r137, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        float r139 = 0.0f;
    L186:
        if (r138.hasNext() == false) goto L196;
        List r140 = (List) ZeusTransformUtils.preCheckCast(r10.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r138.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), List.class, "com.obric.memorydata.plugin");
        if (r140 == null) goto L194;
        Iterator r141 = r140.iterator();
    L191:
        if (r141.hasNext() == false) goto L193;
        r139 = Math.max(r139, ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r141.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue());
        r53 = r53;
        goto L191
    L193:
        float r317 = r53;
        Unit r56 = Unit.INSTANCE;
        Unit r57 = Unit.INSTANCE;
    L195:
        r53 = r317;
        goto L186
    L194:
        r317 = r53;
        goto L195
    L196:
        float r318 = r53;
        Unit r58 = Unit.INSTANCE;
    L199:
        if (r139 < r52) goto L201;
        r54.add(r136);
    L201:
        r53 = r318;
        goto L181
    L197:
        r318 = r53;
        r139 = 0.0f;
        goto L199
    L202:
        HashSet r59 = r54;
        r2 = r53;
    L206:
        if (r31.b() == false) goto L208;
        Map r142 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L209:
        Iterator r60 = r30.entrySet().iterator();
    L211:
        if (r60.hasNext() == false) goto L229;
        Map.Entry r61 = (Map.Entry) ZeusTransformUtils.preCheckCast(r60.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r62 = ((Iterable) ZeusTransformUtils.preCheckCast(r61.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L214:
        if (r62.hasNext() == false) goto L211;
        h r63 = (h) ZeusTransformUtils.preCheckCast(r62.next(), h.class, "com.obric.memorydata.plugin");
        SearchScoreParam r64 = r63.a().getScore();
        if (r64 == null) goto L218;
        double r65 = r64.getValue();
    L220:
        if (r65 >= r2) goto L223;
        r63.a(true);
    L223:
        if (r142 == null) goto L214;
        String r143 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(((Number) ZeusTransformUtils.preCheckCast(r61.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue(), Integer.valueOf(r32));
        Object r144 = r142.get(r143);
        if (r144 != null) goto L227;
        r144 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r142.put(r143, r144);
    L227:
        Boolean.valueOf(((List) ZeusTransformUtils.preCheckCast(r144, List.class, "com.obric.memorydata.plugin")).add(r63));
        goto L214
    L218:
        r65 = 0.0d;
        goto L220
    L229:
        if (r59.isEmpty() == false) goto L233;
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L233:
        return new com.obric.memorydata.personalcontext.search.bridge.c(r7.d().a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r59, Iterable.class, "com.obric.memorydata.plugin"))), r142);
    L208:
        r142 = null;
        goto L209
    L203:
        r2 = r53;
    L204:
        r59 = r135;
        goto L206
    L108:
        r118 = null;
        goto L109
    L100:
        if (r26.length() == 0) goto L103;
        r27 = false;
        goto L104
    L96:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L92:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r31);
    L55:
        if (r34 >= r2) goto L57;
        r9 = r34;
        goto L58
    L43:
        if (Intrinsics.areEqual(r37, "image_vector") == false) goto L45;
        r116 = s.a().getImageVectorCopilotDao(r32);
        goto L46
    L45:
        r116 = null;
        goto L46
    L32:
        if (r113.isEmpty() == true) goto L35;
        r114 = false;
        goto L36
    L21:
        if (r111.isEmpty() == true) goto L24;
        r112 = false;
        goto L25
    L17:
        r110 = null;
        goto L18
    L28:
        r110 = null;
        goto L29
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public com.obric.memorydata.personalcontext.search.bridge.c a(e r14, Map<String, ? extends Object> r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r16, TrackerImpl.PARAMS);
        Object r0 = r16.get(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r1 = r16.get("min_distance");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Number");
        float r6 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue();
        Object r2 = r16.get("wide_min_distance");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Number");
        float r7 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).floatValue();
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(r16.get("keyword"), List.class, "com.obric.memorydata.plugin");
        Object r3 = r16.get("limit");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r4 = r16.get("vector_type");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        Object r11 = r16.get("target_ids");
        if (ZeusTransformUtils.instanceOf(r11, Number.class) == false) goto L5;
        Number r12 = (Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 == null) goto L8;
        Long r13 = Long.valueOf(r12.longValue());
    L10:
        return a(r14, r5, r6, r7, r8, r9, r10, r13, (String) ZeusTransformUtils.preCheckCast(r16.get("min_distance_expression"), String.class, "com.obric.memorydata.plugin"));
    L8:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public String a() {
        return "perform_vector_search";
    }
}
