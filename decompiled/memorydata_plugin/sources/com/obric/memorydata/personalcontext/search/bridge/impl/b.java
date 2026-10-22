package com.obric.memorydata.personalcontext.search.bridge.impl;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.search.bridge.e;
import com.obric.memorydata.personalcontext.search.bridge.g;
import com.obric.memorydata.personalcontext.search.bridge.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u007f\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/impl/ObtainMetaInfoBridgeImpl;", "Lcom/obric/memorydata/personalcontext/search/bridge/ISearchBridge;", "<init>", "()V", "EQUAL_MODE", "", "MAIN_COLLECTION_MODE", "DEFAULT_RELATED_SEARCH_BACKUP_LIMIT", "invokeSearch", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "entitySearchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", TrackerImpl.PARAMS, "", "", "", "getMethodName", "obtainMetaInfoResults", "metaInfoSearchMethod", "metaInfoSearchParams", "metaInfoTableName", "metaInfoRelativeColumnName", "mainRelativeColumnName", "entityType", "contactField", "relationMode", "fieldArrayUniqueKeyColumnName", "targetIds", "", "limit", "(Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/Long;I)Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12302a = null;

    static {
        f12302a = new b();
    }

    private b() {
    }

    private final com.obric.memorydata.personalcontext.search.bridge.c a(e r32, String r33, Map<String, ? extends Object> r34, String r35, String r36, String r37, int r38, String r39, int r40, String r41, Long r42, int r43) {
        String r1 = r36;
        String r4 = r39;
        String r6 = r41;
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.search.bridge.a.a r9 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r32.a());
        if (r42 == null) goto L29;
        List<Object> r11 = r9.d().a(r42.longValue());
        if (r11 == null) goto L17;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        Object r15 = r14.next();
        if (ZeusTransformUtils.instanceOf(r15, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L8;
        r13.add(r15);
        goto L8
    L12:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        r17.add(Long.valueOf(((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L18:
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin");
        if (r110 != null) goto L21;
    L24:
        boolean r111 = true;
    L25:
        if (r111 == false) goto L31;
        RunLog.INSTANCE.debug("NativeEntitySearch", "obtainMetaInfoResults called, targetIds is empty");
    L28:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r32);
    L31:
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r32.a()).f() == true) goto L28;
        int r112 = Math.max(r43, 100);
        String r113 = r32.e();
        if (r113 != null) goto L47;
        Object r114 = r7.get("foreground_caller_pkg");
        if (ZeusTransformUtils.instanceOf(r114, String.class) == false) goto L38;
        r113 = (String) ZeusTransformUtils.preCheckCast(r114, String.class, "com.obric.memorydata.plugin");
    L39:
        if (r113 != null) goto L41;
    L46:
        String r21 = null;
    L48:
        EntitySearchBridgeApiImpl r115 = EntitySearchBridgeApiImpl.INSTANCE;
        String r116 = r32.a();
        CharSequence r117 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r117 != null) goto L51;
    L54:
        boolean r118 = true;
    L55:
        com.obric.memorydata.personalcontext.search.bridge.c r8 = r115.invokeSearchMethodByParamsResult(new e(r116, true, false, !r118, r21), r33, r7);
        long r119 = r8.a();
        Map<String, List<h>> r10 = r8.b();
        List<Object> r120 = r9.d().a(r119);
        if (r120 == null) goto L79;
        Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(r120, Iterable.class, "com.obric.memorydata.plugin");
        Collection r122 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r123 = r121.iterator();
    L59:
        if (r123.hasNext() == false) goto L65;
        Object r124 = r123.next();
        if (ZeusTransformUtils.instanceOf(r124, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L63;
        com.obric.memorydata.personalcontext.search.bridge.d r125 = (com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r124, com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin");
    L64:
        r122.add(r125);
        goto L59
    L63:
        r125 = null;
        goto L64
    L65:
        List r126 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r122, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r126 == null) goto L79;
        Iterable r127 = (Iterable) ZeusTransformUtils.preCheckCast(r126, Iterable.class, "com.obric.memorydata.plugin");
        Collection r128 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r129 = r127.iterator();
        Integer r130 = null;
    L69:
        if (r129.hasNext() == false) goto L78;
        Iterator r310 = r129;
        com.obric.memorydata.personalcontext.search.bridge.d r131 = (com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r129.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin");
        if (r130 == null) goto L77;
        if (r130.intValue() == r131.getType()) goto L77;
        throw new IllegalStateException("metaInfoSearch result can only have one type");
    L77:
        r130 = Integer.valueOf(r131.getType());
        r128.add(Long.valueOf(r131.a()));
        r129 = r310;
        goto L69
    L78:
        List r132 = (List) ZeusTransformUtils.preCheckCast(r128, List.class, "com.obric.memorydata.plugin");
    L80:
        Collection r133 = (Collection) ZeusTransformUtils.preCheckCast(r132, Collection.class, "com.obric.memorydata.plugin");
        if (r133 != null) goto L83;
    L86:
        boolean r134 = true;
    L87:
        if (r134 == true) goto L28;
        if (r130 == null) goto L28;
        CharSequence r135 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r135 != null) goto L93;
    L96:
        boolean r136 = true;
    L98:
        if (r136 == true) goto L100;
        String r311 = "";
        String r137 = ", " + r6;
    L101:
        SimpleSQLiteQuery r138 = new SimpleSQLiteQuery("select id, " + r1 + r137 + " from " + r35 + " where id in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r132, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')');
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r32.a()).f() == true) goto L28;
        List<Map<String, Object>> r20 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.b((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r138, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        if (r20.isEmpty() == true) goto L28;
        Iterable r139 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r140 = r139.iterator();
    L109:
        if (r140.hasNext() == false) goto L111;
        r2.add(((Map) ZeusTransformUtils.preCheckCast(r140.next(), Map.class, "com.obric.memorydata.plugin")).get(r1));
        goto L109
    L111:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Map r141 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L113:
        if (r22.hasNext() == false) goto L153;
        Iterator r142 = r22;
        Map r23 = (Map) ZeusTransformUtils.preCheckCast(r22.next(), Map.class, "com.obric.memorydata.plugin");
        Object r143 = r23.get(OaidModel.KEY_ID);
        if (ZeusTransformUtils.instanceOf(r143, String.class) == false) goto L117;
        String r144 = (String) ZeusTransformUtils.preCheckCast(r143, String.class, "com.obric.memorydata.plugin");
    L118:
        if (r144 == null) goto L151;
        Long r145 = StringsKt.toLongOrNull(r144);
        if (r145 == null) goto L151;
        List r24 = r3;
        long r5 = r145.longValue();
        Object r146 = r23.get(r1);
        if (r146 == null) goto L152;
        String r147 = r146.toString();
        if (r147 == null) goto L152;
        List r25 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L152;
        List r26 = (List) ZeusTransformUtils.preCheckCast(r10.get(com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(r5, r130)), List.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L152;
        CharSequence r27 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r27 != null) goto L134;
    L137:
        boolean r28 = true;
    L138:
        if (r28 == false) goto L140;
    L139:
        String r29 = null;
    L143:
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L145:
        if (r30.hasNext() == false) goto L147;
        h r31 = (h) ZeusTransformUtils.preCheckCast(r30.next(), h.class, "com.obric.memorydata.plugin");
        r25.add(new h(InAppSearchEntityParam.copy$default(r31.a(), null, r4 + '_' + r31.a().getField(), null, false, null, r29, 29, null), r31.b()));
        r30 = r30;
        goto L145
    L147:
        Object r44 = r141.get(r147);
        if (r44 != null) goto L150;
        r44 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r141.put(r147, r44);
    L150:
        ((List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin"));
        goto L152
    L140:
        Object r45 = r23.get(r6);
        if (r45 == null) goto L139;
        r29 = r45.toString();
        goto L143
    L134:
        if (r27.length() == 0) goto L137;
        r28 = false;
    L152:
        r1 = r36;
        r6 = r41;
        r22 = r142;
        r3 = r24;
    L151:
        r24 = r3;
        goto L152
    L117:
        r144 = null;
        goto L118
    L153:
        List r210 = r3;
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r32.a()).f() == true) goto L28;
        Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin");
        if (r46 != null) goto L159;
    L162:
        boolean r47 = true;
    L163:
        if (r47 == false) goto L165;
        String r48 = r311;
    L166:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r49 = s.a().getRawDaoByEntityType(r38);
        if (r49 == null) goto L28;
        String r50 = r49.getTableName();
        if (r50 == null) goto L28;
        if (r40 != 1) goto L174;
        final String r148 = r37;
        SimpleSQLiteQuery r51 = new SimpleSQLiteQuery("select id, " + r148 + " from " + r50 + " where " + r148 + " in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r210, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ") " + r48 + " LIMIT " + r112);
    L179:
        List<Map<String, Object>> r52 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.b((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r51, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        if (r52.isEmpty() == true) goto L28;
        List<? extends Object> r53 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r32.b() == false) goto L185;
        Map r54 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L186:
        Iterator r55 = ((Iterable) ZeusTransformUtils.preCheckCast(r52, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L188:
        if (r55.hasNext() == false) goto L263;
        Map r56 = (Map) ZeusTransformUtils.preCheckCast(r55.next(), Map.class, "com.obric.memorydata.plugin");
        Object r57 = r56.get(OaidModel.KEY_ID);
        if (ZeusTransformUtils.instanceOf(r57, String.class) == false) goto L192;
        String r58 = (String) ZeusTransformUtils.preCheckCast(r57, String.class, "com.obric.memorydata.plugin");
    L193:
        if (r58 == null) goto L258;
        Long r59 = StringsKt.toLongOrNull(r58);
        if (r59 == null) goto L258;
        long r60 = r59.longValue();
        CharSequence r61 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r61 != null) goto L199;
    L202:
        boolean r62 = true;
    L203:
        if (r62 == false) goto L205;
    L259:
        Map r149 = r141;
        r55 = r55;
        com.obric.memorydata.personalcontext.search.bridge.d r63 = new com.obric.memorydata.personalcontext.search.bridge.d(r60, r38);
    L260:
        r53.add(r63);
    L261:
        r55 = r55;
        r4 = r39;
        r141 = r149;
        goto L188
    L205:
        if (r32.f() == false) goto L259;
        Object r64 = r56.get(r148);
        if (r64 == null) goto L258;
        String r65 = r64.toString();
        if (r65 == null) goto L258;
        r149 = r141;
        if (r40 != 1) goto L215;
        List r66 = (List) ZeusTransformUtils.preCheckCast(r149.get(r65), List.class, "com.obric.memorydata.plugin");
    L226:
        Collection r67 = (Collection) ZeusTransformUtils.preCheckCast(r66, Collection.class, "com.obric.memorydata.plugin");
        if (r67 != null) goto L229;
    L232:
        boolean r68 = true;
    L233:
        if (r68 == true) goto L235;
        Iterator r69 = ((Iterable) ZeusTransformUtils.preCheckCast(r66, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r70 = false;
    L240:
        if (r69.hasNext() == false) goto L255;
        h r71 = (h) ZeusTransformUtils.preCheckCast(r69.next(), h.class, "com.obric.memorydata.plugin");
        if (r32.c() == false) goto L244;
        r9.a().a(r38, r60, r71);
    L244:
        if (r54 == null) goto L251;
        String r72 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(r60, Integer.valueOf(r38));
        Object r150 = r54.get(r72);
        if (r150 != null) goto L248;
        r150 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r54.put(r72, r150);
    L248:
        Boolean.valueOf(((List) ZeusTransformUtils.preCheckCast(r150, List.class, "com.obric.memorydata.plugin")).add(r71));
    L251:
        if (r71.b() == true) goto L253;
        r70 = true;
    L253:
        r69 = r69;
        goto L240
    L255:
        if (r32.d() == true) goto L257;
        if (r70 == false) goto L261;
    L257:
        r63 = new com.obric.memorydata.personalcontext.search.bridge.d(r60, r38);
        goto L260
    L235:
        if (r32.d() == false) goto L261;
        r63 = new com.obric.memorydata.personalcontext.search.bridge.d(r60, r38);
        goto L260
    L229:
        if (r67.isEmpty() == true) goto L232;
        r68 = false;
        goto L233
    L215:
        List r73 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r74 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removeSurrounding(r65, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r75 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r74, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r76 = r74.iterator();
    L217:
        if (r76.hasNext() == false) goto L219;
        r75.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r76.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L217
    L219:
        Iterator r77 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r75, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L221:
        if (r77.hasNext() == false) goto L225;
        List r78 = (List) ZeusTransformUtils.preCheckCast(r149.get((String) ZeusTransformUtils.preCheckCast(r77.next(), String.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        if (r78 == null) goto L221;
        r73.addAll((Collection) ZeusTransformUtils.preCheckCast(r78, Collection.class, "com.obric.memorydata.plugin"));
        Unit r79 = Unit.INSTANCE;
        Unit r80 = Unit.INSTANCE;
        goto L221
    L225:
        r66 = r73;
        goto L226
    L199:
        if (r61.length() == 0) goto L202;
        r62 = false;
    L258:
        r149 = r141;
        r55 = r55;
        goto L261
    L192:
        r58 = null;
        goto L193
    L263:
        return new com.obric.memorydata.personalcontext.search.bridge.c(r9.d().a(r53), r54);
    L185:
        r54 = null;
        goto L186
    L174:
        if (r40 != 2) goto L177;
        r148 = r37;
        r51 = new SimpleSQLiteQuery("select id, " + r148 + " from " + r50 + " where (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r210, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" or ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$b$8VbPq1bQ5dSwgZO3WV1pEtG7Gb8(r148), 30, null) + ") " + r48 + " LIMIT " + r112);
        goto L179
    L177:
        throw new IllegalArgumentException("relationMode '" + r40 + "' is invalid");
    L165:
        r48 = "and id in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')';
        goto L166
    L159:
        if (r46.isEmpty() == true) goto L162;
        r47 = false;
        goto L163
    L100:
        r311 = "";
        r137 = r311;
        goto L101
    L93:
        if (r135.length() == 0) goto L96;
        r136 = false;
        goto L98
    L83:
        if (r133.isEmpty() == true) goto L86;
        r134 = false;
    L79:
        r132 = null;
        r130 = null;
        goto L80
    L51:
        if (r117.length() == 0) goto L54;
        r118 = false;
        goto L55
    L41:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L43;
        boolean r151 = true;
    L44:
        if (r151 == false) goto L46;
    L43:
        r151 = false;
        goto L44
    L38:
        r113 = null;
    L47:
        r21 = r113;
        goto L48
    L21:
        if (r110.isEmpty() == true) goto L24;
        r111 = false;
        goto L25
    L17:
        r19 = null;
        goto L18
    L29:
        r19 = null;
        goto L31
    }

    private static final CharSequence a(String r1, Object r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r1 + " LIKE '%" + r2 + "%'", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$8VbPq1bQ5dSwgZO3WV1pEtG7Gb8(String r0, Object r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public com.obric.memorydata.personalcontext.search.bridge.c a(e r17, Map<String, ? extends Object> r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r0, TrackerImpl.PARAMS);
        RunLog.INSTANCE.debug("NativeEntitySearch", "obtainMetaInfoResults called " + r0);
        Object r2 = r0.get("meta_info_search_method");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        Object r3 = r0.get("meta_info_search_params");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        Object r4 = r0.get("meta_info_table_name");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        Object r8 = r0.get("meta_info_relative_column_name");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.String");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        Object r10 = r0.get("main_relative_column_name");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.String");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        Object r12 = r0.get(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
        int r13 = ((Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r14 = r0.get("contact_field");
        Long r15 = null;
        if (ZeusTransformUtils.instanceOf(r14, String.class) == false) goto L5;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
    L6:
        Object r19 = r0.get("relation_mode");
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Int");
        int r20 = ((Integer) ZeusTransformUtils.preCheckCast(r19, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r110 = r0.get("field_array_unique_key_column_name");
        if (ZeusTransformUtils.instanceOf(r110, String.class) == false) goto L9;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin");
    L10:
        Object r112 = r0.get("target_ids");
        if (ZeusTransformUtils.instanceOf(r112, Number.class) == false) goto L13;
        Number r113 = (Number) ZeusTransformUtils.preCheckCast(r112, Number.class, "com.obric.memorydata.plugin");
    L14:
        if (r113 == null) goto L16;
        r15 = Long.valueOf(r113.longValue());
    L16:
        Object r1 = r0.get("limit");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
        return a(r17, r5, r6, r7, r9, r11, r13, r16, r20, r111, r15, ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L13:
        r113 = null;
        goto L14
    L9:
        r111 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public String a() {
        return "obtainMetaInfoResults";
    }
}
