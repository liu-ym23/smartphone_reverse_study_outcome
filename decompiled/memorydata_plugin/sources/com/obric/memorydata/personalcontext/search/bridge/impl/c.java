package com.obric.memorydata.personalcontext.search.bridge.impl;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\f\u001a\u00020\nH\u0016Ji\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJU\u0010\u001c\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002¨\u0006$"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/impl/SqlSearchBridgeImpl;", "Lcom/obric/memorydata/personalcontext/search/bridge/ISearchBridge;", "<init>", "()V", "invokeSearch", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "entitySearchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", TrackerImpl.PARAMS, "", "", "", "getMethodName", "performSqlMatchSearch", "entityType", "", "whereClause", "limit", "targetIds", "", "valueColumnName", "fieldName", "keyword", "orderColumn", "isAsc", "", "performSqlMatchSearch$personal_context_obricRelease", "(Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;ILjava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "generateSql", "", "valueColumnNames", "tableName", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;)Ljava/lang/String;", "replaceVariables", ChatMessage.TYPE_QUERY, "searchId", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12303a = null;

    static {
        f12303a = new c();
    }

    private c() {
    }

    private static final CharSequence a(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r1), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(String r11, MatchResult r12) {
        MatchResult r13 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r12, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "matchResult");
        Long r0 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r13.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L11;
        List<Object> r14 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r11).d().a(r0.longValue());
        if (r14 == null) goto L7;
        Object r15 = ZeusTransformUtils.preCheckCast(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), CharSequence.class, "com.obric.memorydata.plugin");
    L9:
        return (CharSequence) r15;
    L7:
        r15 = ZeusTransformUtils.preCheckCast("null", CharSequence.class, "com.obric.memorydata.plugin");
        goto L9
    L11:
        throw new IllegalArgumentException("Invalid remote value ID: " + ((String) ZeusTransformUtils.preCheckCast(r13.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin")));
    }

    private final String a(String r3, final String r4) {
        return new Regex("\\{\\{(\\d+)\\}\\}").replace((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$c$ToQe1e2n3ikHjETa1978_EB5DCA(r4));
    }

    private final String a(String r20, List<Long> r21, String r22, String r23, Boolean r24, int r25, String r26) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List r6 = CollectionsKt.mutableListOf(new String[]{OaidModel.KEY_ID});
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L11;
        r6.add(r22);
    L11:
        String r1 = "SELECT " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + " FROM " + r26;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == true) goto L20;
        r10.add(r20);
    L20:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L23;
    L26:
        boolean r2 = true;
    L27:
        if (r2 == true) goto L29;
        r10.add("id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$mUL2TenI9AAPiNML8mVOpkKDShA.INSTANCE, 30, null) + ')');
    L29:
        String r5 = "";
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        String r3 = " WHERE " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" AND ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L33:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L36;
    L37:
        r8 = true;
    L39:
        if (r8 == true) goto L45;
        StringBuilder r14 = new StringBuilder().append("ORDER BY ").append(r23).append(' ');
        if (Intrinsics.areEqual(r24, true) == false) goto L43;
        String r15 = "ASC";
    L44:
        String r16 = r14.append(r15).toString();
    L46:
        if (r25 < 0) goto L49;
        r5 = " LIMIT " + r25;
    L49:
        return r1 + ' ' + r3 + ' ' + r16 + ' ' + r5;
    L43:
        r15 = "DESC";
        goto L44
    L45:
        r16 = "";
        goto L46
    L36:
        if (StringsKt.isBlank(r13) == false) goto L39;
    L32:
        r3 = "";
        goto L33
    L23:
        if (r0.isEmpty() == true) goto L26;
        r2 = false;
        goto L27
    L14:
        if (StringsKt.isBlank(r11) == true) goto L17;
        r12 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r9 = false;
        goto L9
    }

    public static /* synthetic */ CharSequence lambda$ToQe1e2n3ikHjETa1978_EB5DCA(String r0, MatchResult r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$mUL2TenI9AAPiNML8mVOpkKDShA(long r0) {
        return a(r0);
    }

    public final com.obric.memorydata.personalcontext.search.bridge.c a(e r25, int r26, String r27, int r28, Long r29, String r30, String r31, String r32, String r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r25, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r27, "whereClause");
        if (r29 == null) goto L30;
        List<Object> r4 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r25.a()).d().a(r29.longValue());
        if (r4 == null) goto L17;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r8 = r7.next();
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L8;
        r6.add(r8);
        goto L8
    L12:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r10.add(Long.valueOf(((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        List<Long> r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L18:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L31;
        RunLog r1 = RunLog.INSTANCE;
        String r2 = "performKeywordIndexSearch called, targetIds is empty";
    L27:
        r1.debug("NativeEntitySearch", r2);
    L29:
        return com.obric.memorydata.personalcontext.search.bridge.b.f12290a.a(r25);
    L31:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r15 = s.a().getRawDaoByEntityType(r26);
        if (r15 != null) goto L34;
        r1 = RunLog.INSTANCE;
        r2 = "performKeywordIndexSearch called, rawDbDao is null";
        goto L27
    L34:
        SimpleSQLiteQuery r16 = new SimpleSQLiteQuery(a(a(r27, r25.a()), r12, r30, r33, Boolean.valueOf(r34), r28, r15.getTableName()));
        List<? extends Object> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r25.b() == false) goto L37;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L38:
        com.obric.memorydata.personalcontext.search.bridge.a.a r18 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r25.a());
        if (r18.f() == true) goto L29;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.bridge.a.f12279a.b((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r16, SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r19.hasNext() == false) goto L83;
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(r19.next(), Map.class, "com.obric.memorydata.plugin");
        Object r21 = r20.get(OaidModel.KEY_ID);
        if (ZeusTransformUtils.instanceOf(r21, String.class) == false) goto L47;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin");
    L48:
        if (r22 == null) goto L43;
        Long r23 = StringsKt.toLongOrNull(r22);
        if (r23 == null) goto L43;
        long r24 = r23.longValue();
        r3.add(new com.obric.memorydata.personalcontext.search.bridge.d(r24, r26));
        if (r25.f() == false) goto L43;
        CharSequence r35 = (CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin");
        if (r35 != null) goto L56;
    L59:
        boolean r36 = true;
    L60:
        if (r36 == true) goto L43;
        if (r30 == null) goto L69;
        Object r37 = r20.get(r30);
        if (r37 == null) goto L67;
        String r38 = r37.toString();
        if (r38 == null) goto L67;
    L68:
        String r110 = r38;
    L71:
        if (r32 != null) goto L73;
        String r111 = "";
    L74:
        h r39 = new h(new InAppSearchEntityParam(r111, r31, r110, false, null, null, 48, null), false, 2, null);
        if (r25.c() == false) goto L77;
        r18.a().a(r26, r24, r39);
    L77:
        if (r17 == null) goto L43;
        String r40 = com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(r24, Integer.valueOf(r26));
        Object r41 = r17.get(r40);
        if (r41 != null) goto L81;
        r41 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r17.put(r40, r41);
    L81:
        ((List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.memorydata.plugin")).add(r39);
        goto L43
    L73:
        r111 = r32;
    L67:
        r38 = "";
        goto L68
    L69:
        r110 = "";
        goto L71
    L56:
        if (r35.length() == 0) goto L59;
        r36 = false;
        goto L60
    L47:
        r22 = null;
        goto L48
    L83:
        return new com.obric.memorydata.personalcontext.search.bridge.c(r18.d().a(r3), r17);
    L37:
        r17 = null;
        goto L38
    L21:
        if (r13.isEmpty() == true) goto L24;
        r14 = false;
        goto L25
    L17:
        r12 = null;
        goto L18
    L30:
        r12 = null;
        goto L31
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public com.obric.memorydata.personalcontext.search.bridge.c a(e r15, Map<String, ? extends Object> r16) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "entitySearchOption");
        Intrinsics.checkNotNullParameter(r0, TrackerImpl.PARAMS);
        Object r2 = r0.get(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r3 = r0.get("where_clause");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Object r4 = r0.get("limit");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r8 = r0.get("target_ids");
        Boolean r9 = null;
        if (ZeusTransformUtils.instanceOf(r8, Number.class) == false) goto L5;
        Number r10 = (Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L8;
        Long r11 = Long.valueOf(r10.longValue());
    L9:
        Object r12 = r0.get("value_column_name");
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L12;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
    L13:
        Object r14 = r0.get("field_name");
        if (ZeusTransformUtils.instanceOf(r14, String.class) == false) goto L16;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
    L17:
        Object r18 = r0.get("keyword");
        if (ZeusTransformUtils.instanceOf(r18, String.class) == false) goto L20;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin");
    L21:
        Object r20 = r0.get("order_column");
        if (ZeusTransformUtils.instanceOf(r20, String.class) == false) goto L24;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.memorydata.plugin");
    L25:
        Object r1 = r0.get("is_asc");
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L28;
        r9 = (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin");
    L28:
        if (r9 == null) goto L30;
        boolean r21 = r9.booleanValue();
    L32:
        return a(r15, r5, r6, r7, r11, r13, r17, r19, r110, r21);
    L30:
        r21 = false;
        goto L32
    L24:
        r110 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L16:
        r17 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.search.bridge.g
    public String a() {
        return "perform_sql_match_search";
    }
}
