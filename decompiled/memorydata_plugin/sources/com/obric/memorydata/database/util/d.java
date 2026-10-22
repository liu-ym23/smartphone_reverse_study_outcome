package com.obric.memorydata.database.util;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.middleware.api.bridge.MatchType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u001a\u0018\u0010\u0016\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u001a\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0001H\u0007\u001a<\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014\u001at\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014*\u00020\n2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0006\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014\u001a¨\u0001\u0010!\u001a2\u0012\u0004\u0012\u00020\"\u0012(\u0012&\u0012\u0004\u0012\u00020\u0001\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f0\u00140\f0\f*\u00020\n2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f2\u0006\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\b\b\u0002\u0010#\u001a\u00020\u0012\u001av\u0010$\u001a\u00020%*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142*\u0010)\u001a&\u0012\u0004\u0012\u00020\u0001\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\f0\u00140*2\b\b\u0002\u0010#\u001a\u00020\u0012H\u0002\u001a]\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020,0\f0\u0014*\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u00102\u001ak\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020,0\f0\u0014*\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\u00104\u001am\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020,0\f0\u0014*\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002¢\u0006\u0002\u00104\u001a>\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020,0\f0\u0014*\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002\u001a&\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H80\u00142\f\u00109\u001a\b\u0012\u0004\u0012\u0002H80\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006:"}, d2 = {"TAG", "", "META_FULL_CONTENT_PUBLIC_UID_TOKEN", "metaFullContentUidToken", "uid", "createDocumentFromAppDbEntity", "Lcom/obric/memorydata/database/model/CommonTextSearchDocument;", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "schema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "convertColumnMap", "", "relatedDb", "Lcom/obric/search/api/OSearchEngine;", "getRelatedDb", "(Lcom/obric/search/api/schema/impl/FullTextSearchSchema;)Lcom/obric/search/api/OSearchEngine;", "insert", "", Constants.KEY_LIST, "", "Lcom/obric/search/api/document/intf/IDocument;", "delete", "queryInAllColumns", "", "keyword", "queryInCertainRange", "columns", "limit", "targetIds", "keywordToColumns", "keywordToSynonymColumns", "keywordToHomonymColumns", "queryMatchedColumns", "Lcom/obric/memorydata/middleware/api/bridge/MatchType;", "isFullMatch", "oneQuery", "", ChatMessage.TYPE_QUERY, "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "filerColumns", "result", "", "queryMetaInfoFullContentByKeyword", "", "entityType", "", "matchTypes", "keywords", "visibleUids", "(Lcom/obric/search/api/schema/impl/FullTextSearchSchema;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;JLjava/util/List;)Ljava/util/List;", "queryMetaInfoFullContentByKeywordWithKeys", "(Lcom/obric/search/api/schema/impl/FullTextSearchSchema;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;JLjava/util/List;Ljava/util/List;)Ljava/util/List;", "queryMetaInfoFullContentByKeywordInternal", "queryScore", "isSubsetOf", ExifInterface.GPS_DIRECTION_TRUE, "otherList", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    public static final com.obric.search.api.a a(FullTextSearchSchema r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (t.f9438a.a().contains(r1.a()) == false) goto L6;
        return c.f9626a.b();
    L6:
        return c.f9626a.a();
    }

    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "|public|";
    L9:
        return '|' + r2 + '|';
    L5:
        r0 = false;
        goto L6
    }

    private static final List<Map<Long, Double>> a(FullTextSearchSchema r14, FullTextSearchQuery r15, long r16, List<Long> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        FullTextSearchSpec r13 = new FullTextSearchSpec(r14.a(), r15, FullTextSearchSpec.RankMethod.BM25, r16, 0, CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), 16, null);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(a(r14).a(r13, new com.obric.search.api.search.impl.a(true, false, false, 6, null)), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        com.obric.search.api.schema.impl.a.c r4 = (com.obric.search.api.schema.impl.a.c) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.search.api.schema.impl.a.c.class, "com.obric.memorydata.plugin");
        r2.add(MapsKt.mapOf(TuplesKt.to(Long.valueOf(r4.a()), Double.valueOf(r4.b()))));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<Map<Long, Double>> a(FullTextSearchSchema r10, Integer r11, List<Integer> r12, List<String> r13, long r14, List<String> r16) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r4, "matchTypes");
        Intrinsics.checkNotNullParameter(r5, "keywords");
        Intrinsics.checkNotNullParameter(r8, "visibleUids");
        return b(r10, r11, r4, r5, r14, r8, CollectionsKt.emptyList());
    }

    public static final List<Map<Long, Double>> a(FullTextSearchSchema r10, Integer r11, List<Integer> r12, List<String> r13, long r14, List<String> r16, List<Long> r17) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r4, "matchTypes");
        Intrinsics.checkNotNullParameter(r5, "keywords");
        Intrinsics.checkNotNullParameter(r8, "visibleUids");
        Intrinsics.checkNotNullParameter(r0, "targetIds");
        if (r0.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return b(r10, r11, r4, r5, r14, r8, CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")));
    }

    public static final List<Long> a(FullTextSearchSchema r16, String r17, List<String> r18, long r19, List<Long> r21) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r17, "keyword");
        Intrinsics.checkNotNullParameter(r1, "columns");
        Intrinsics.checkNotNullParameter(r12, "targetIds");
        if (r1.isEmpty() == false) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FullTextSearchSchemaExt", r16.a() + " queryInCertainRange columns is empty", null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        if (a(r1, r16.b()) == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FullTextSearchSchemaExt", r16.a() + " queryInCertainRange columns is not in schema", null, 4, null);
        return CollectionsKt.emptyList();
    L11:
        return a(r16).a((com.obric.search.api.search.a.a) ZeusTransformUtils.preCheckCast(new FullTextSearchSpec(r16.a(), FullTextSearchQuery.f14939a.b(r17, TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))).a(r1, false), FullTextSearchSpec.RankMethod.BM25, r19, 0, r12, 16, null), com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin"));
    }

    public static final List<Long> a(FullTextSearchSchema r22, Map<String, ? extends List<String>> r23, Map<String, ? extends List<String>> r24, Map<String, ? extends List<String>> r25, long r26, List<Long> r28) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter(r0, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r2, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r3, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r13, "targetIds");
        Iterator r1 = r0.entrySet().iterator();
        FullTextSearchQuery r5 = null;
    L3:
        boolean r8 = true;
        if (r1.hasNext() == false) goto L21;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == true) goto L7;
        if (a(r7, r22.b()) == false) goto L11;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L16;
        r8 = false;
    L16:
        if (r8 == true) goto L3;
        FullTextSearchQuery r9 = FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, r10, false, 2, null).a(r7, false);
        if (r5 == null) goto L19;
        r5.b(r9);
        goto L3
    L19:
        r5 = r9;
        goto L3
    L11:
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append(r22.a());
        String r12 = " queryInCertainRange keywordToColumns is not in schema, keyword: ";
    L8:
        IRunLog.a.b(r16, "FullTextSearchSchemaExt", r11.append(r12).append(r10).toString(), null, 4, null);
        goto L3
    L7:
        r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r11 = new StringBuilder().append(r22.a());
        r12 = " queryInCertainRange keywordToColumns is empty, keyword: ";
        goto L8
    L21:
        Iterator r4 = r2.entrySet().iterator();
    L23:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r17 = (List) ZeusTransformUtils.preCheckCast(r14.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r17.isEmpty() == true) goto L26;
        if (a(r17, r22.b()) == false) goto L30;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L34;
        boolean r18 = true;
    L35:
        if (r18 == true) goto L23;
        FullTextSearchQuery r19 = FullTextSearchQuery.a.b(FullTextSearchQuery.f14939a, r15, false, 2, null).a(r17, false);
        if (r5 == null) goto L38;
        r5.b(r19);
        goto L23
    L38:
        r5 = r19;
        goto L23
    L34:
        r18 = false;
        goto L35
    L30:
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder().append(r22.a());
        String r111 = " queryInCertainRange synonymColumns is not in schema, keyword: ";
    L27:
        IRunLog.a.b(r110, "FullTextSearchSchemaExt", r20.append(r111).append(r15).toString(), null, 4, null);
        goto L23
    L26:
        r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r20 = new StringBuilder().append(r22.a());
        r111 = " queryInCertainRange synonymColumns is empty, keyword: ";
        goto L27
    L40:
        Iterator r21 = r3.entrySet().iterator();
        FullTextSearchQuery r27 = r5;
    L42:
        if (r21.hasNext() == false) goto L59;
        Map.Entry r29 = (Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r31 = (List) ZeusTransformUtils.preCheckCast(r29.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r31.isEmpty() == true) goto L45;
        if (a(r31, r22.b()) == false) goto L49;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L53;
        boolean r32 = true;
    L54:
        if (r32 == true) goto L42;
        FullTextSearchQuery r33 = FullTextSearchQuery.f14939a.c(r30, new Regex("^[a-zA-Z]+$").matches((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin"))).a(r31, false);
        if (r27 == null) goto L57;
        r27.b(r33);
        goto L42
    L57:
        r27 = r33;
        goto L42
    L53:
        r32 = false;
        goto L54
    L49:
        IRunLog r112 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r34 = new StringBuilder().append(r22.a());
        String r35 = " queryInCertainRange homonymColumns is not in schema, keyword: ";
    L46:
        IRunLog.a.b(r112, "FullTextSearchSchemaExt", r34.append(r35).append(r30).toString(), null, 4, null);
        goto L42
    L45:
        r112 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r34 = new StringBuilder().append(r22.a());
        r35 = " queryInCertainRange homonymColumns is empty, keyword: ";
        goto L46
    L59:
        if (r27 != null) goto L63;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FullTextSearchSchemaExt", r22.a() + " queryInCertainRange finalQuery is null, return empty", null, 4, null);
        return CollectionsKt.emptyList();
    L63:
        return a(r22).a((com.obric.search.api.search.a.a) ZeusTransformUtils.preCheckCast(new FullTextSearchSpec(r22.a(), r27, FullTextSearchSpec.RankMethod.BM25, r26, 0, r13, 16, null), com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin"));
    }

    public static final Map<MatchType, Map<String, List<Map<Long, List<String>>>>> a(FullTextSearchSchema r23, Map<String, ? extends List<String>> r24, Map<String, ? extends List<String>> r25, Map<String, ? extends List<String>> r26, long r27, List<Long> r29, boolean r30) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Intrinsics.checkNotNullParameter(r0, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r2, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r3, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r4, "targetIds");
        HashMap r15 = new HashMap();
        HashMap r13 = new HashMap();
        Iterator r1 = r0.entrySet().iterator();
    L3:
        Object r12 = null;
        int r11 = 2;
        boolean r16 = true;
        boolean r10 = false;
        if (r1.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L11;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append(r23.a());
        String r14 = " queryMatchedColumns keywordToColumns is empty, keyword: ";
    L8:
        IRunLog.a.b(r7, "FullTextSearchSchemaExt", r8.append(r14).append(r6).toString(), null, 4, null);
    L19:
        r13 = r13;
        r1 = r1;
        goto L3
    L11:
        if (a(r9, r23.b()) == true) goto L14;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r8 = new StringBuilder().append(r23.a());
        r14 = " queryMatchedColumns keywordToColumns is not in schema, keyword: ";
        goto L8
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L17;
        r16 = false;
    L17:
        if (r16 == true) goto L19;
        a(r23, r6, r27, r4, FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, r6, false, 2, null).a(r9, false), r9, (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin"), r30);
        goto L19
    L20:
        ((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin")).put(MatchType.ACCURATE_MATCH, r13);
        HashMap r17 = new HashMap();
        Iterator r18 = r2.entrySet().iterator();
    L22:
        if (r18.hasNext() == false) goto L38;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r110 = (List) ZeusTransformUtils.preCheckCast(r19.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r110.isEmpty() == false) goto L29;
        IRunLog r111 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r21 = new StringBuilder().append(r23.a());
        String r22 = " queryMatchedColumns synonymColumns is empty, keyword: ";
    L26:
        IRunLog.a.b(r111, "FullTextSearchSchemaExt", r21.append(r22).append(r20).toString(), null, 4, null);
    L37:
        r10 = r10;
        r11 = r11;
        r12 = r12;
        r18 = r18;
        goto L22
    L29:
        if (a(r110, r23.b()) == true) goto L32;
        r111 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r21 = new StringBuilder().append(r23.a());
        r22 = " queryOneByOne synonymColumns is not in schema, keyword: ";
        goto L26
    L32:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L34;
        boolean r28 = true;
    L35:
        if (r28 == true) goto L37;
        a(r23, r20, r27, r4, FullTextSearchQuery.a.b(FullTextSearchQuery.f14939a, r20, r10, r11, r12).a(r110, r10), r110, (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.memorydata.plugin"), r30);
        goto L37
    L34:
        r28 = r10;
        goto L35
    L38:
        boolean r31 = r10;
        ((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin")).put(MatchType.SYNONYM_MATCH, r17);
        HashMap r32 = new HashMap();
        Iterator r33 = r3.entrySet().iterator();
    L40:
        if (r33.hasNext() == false) goto L54;
        Map.Entry r34 = (Map.Entry) ZeusTransformUtils.preCheckCast(r33.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r35 = (String) ZeusTransformUtils.preCheckCast(r34.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r112 = (List) ZeusTransformUtils.preCheckCast(r34.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r112.isEmpty() == true) goto L43;
        if (a(r112, r23.b()) == false) goto L47;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L51;
        boolean r113 = true;
    L52:
        if (r113 == true) goto L40;
        a(r23, r35, r27, r4, FullTextSearchQuery.f14939a.c(r35, new Regex("^[a-zA-Z]+$").matches((CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.memorydata.plugin"))).a(r112, r31), r112, (Map) ZeusTransformUtils.preCheckCast(r32, Map.class, "com.obric.memorydata.plugin"), r30);
        goto L40
    L51:
        r113 = r31;
        goto L52
    L47:
        IRunLog r36 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r37 = new StringBuilder().append(r23.a());
        String r38 = " queryOneByOne homonymColumns is not in schema, keyword: ";
    L44:
        IRunLog.a.b(r36, "FullTextSearchSchemaExt", r37.append(r38).append(r35).toString(), null, 4, null);
        goto L40
    L43:
        r36 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r37 = new StringBuilder().append(r23.a());
        r38 = " queryOneByOne homonymColumns is empty, keyword: ";
        goto L44
    L54:
        ((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin")).put(MatchType.HOMONYM_MATCH, r32);
        return (Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin");
    }

    private static final void a(FullTextSearchSchema r14, String r15, long r16, List<Long> r18, FullTextSearchQuery r19, List<String> r20, Map<String, List<Map<Long, List<String>>>> r21, boolean r22) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        FullTextSearchSpec r13 = new FullTextSearchSpec(r14.a(), r19, FullTextSearchSpec.RankMethod.BM25, r16, 0, r10, 16, null);
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.search.api.a r4 = a(r14);
        com.obric.search.api.search.a.a r5 = (com.obric.search.api.search.a.a) ZeusTransformUtils.preCheckCast(r13, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        if (r22 == false) goto L20;
        Iterator<com.obric.search.api.schema.impl.a.a> r6 = r4.c(r5).iterator();
    L6:
        if (r6.hasNext() == false) goto L37;
        com.obric.search.api.schema.impl.a.a r7 = (com.obric.search.api.schema.impl.a.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.search.api.schema.impl.a.a.class, "com.obric.memorydata.plugin");
        List<Boolean> r8 = r7.b();
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r12 = 0;
    L9:
        if (r11.hasNext() == false) goto L18;
        Object r17 = r11.next();
        int r110 = r12 + 1;
        if (r12 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L16;
        r9.add(r14.b().get(r12));
    L16:
        r12 = r110;
        goto L9
    L18:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        r2.add(MapsKt.mapOf(TuplesKt.to(Long.valueOf(r7.a()), r9)));
    L37:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L56;
        r1.put(r15, r2);
        return;
    L56:
        return;
    L20:
        Iterator<com.obric.search.api.schema.impl.a.b> r23 = r4.b(r5).iterator();
    L22:
        if (r23.hasNext() == false) goto L37;
        com.obric.search.api.schema.impl.a.b r24 = (com.obric.search.api.schema.impl.a.b) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.search.api.schema.impl.a.b.class, "com.obric.memorydata.plugin");
        List<List<Pair<Integer, Integer>>> r25 = r24.b();
        List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r28 = 0;
    L25:
        if (r27.hasNext() == false) goto L34;
        Object r29 = r27.next();
        int r111 = r28 + 1;
        if (r28 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        if ((!((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r26.add(r14.b().get(r28));
    L32:
        r28 = r111;
        goto L25
    L34:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        r2.add(MapsKt.mapOf(TuplesKt.to(Long.valueOf(r24.a()), r26)));
        goto L22
    }

    private static final <T> boolean a(List<? extends T> r3, List<? extends T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (r6.contains(r8.next()) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    private static final List<Map<Long, Double>> b(FullTextSearchSchema r14, Integer r15, List<Integer> r16, List<String> r17, long r18, List<String> r20, List<Long> r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r1.isEmpty() == false) goto L9;
        r1 = CollectionsKt.listOf(Integer.valueOf(MatchType.ACCURATE_MATCH.getValue()));
    L9:
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L26;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterator r11 = r3.iterator();
    L14:
        if (r11.hasNext() == false) goto L11;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != MatchType.ACCURATE_MATCH.getValue()) goto L19;
    L17:
        FullTextSearchQuery r13 = FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, r12, false, 2, null);
    L24:
        r6.add(r13);
        goto L14
    L19:
        if (r7 != MatchType.SYNONYM_MATCH.getValue()) goto L22;
        r13 = FullTextSearchQuery.a.b(FullTextSearchQuery.f14939a, r12, false, 2, null);
        goto L24
    L22:
        if (r7 != MatchType.HOMONYM_MATCH.getValue()) goto L17;
        r13 = FullTextSearchQuery.a.c(FullTextSearchQuery.f14939a, r12, false, 2, null);
        goto L24
    L26:
        if (r6.isEmpty() == false) goto L30;
        return CollectionsKt.emptyList();
    L30:
        if (r6.size() <= 1) goto L40;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
    L35:
        if (r8.hasNext() == false) goto L37;
        FullTextSearchQuery r19 = (FullTextSearchQuery) ZeusTransformUtils.preCheckCast(r8.next(), FullTextSearchQuery.class, "com.obric.memorydata.plugin");
        r9 = ((FullTextSearchQuery) ZeusTransformUtils.preCheckCast(r9, FullTextSearchQuery.class, "com.obric.memorydata.plugin")).b(r19);
        goto L35
    L37:
        Object r10 = ZeusTransformUtils.preCheckCast(r9, FullTextSearchQuery.class, "com.obric.memorydata.plugin");
    L41:
        FullTextSearchQuery r22 = ((FullTextSearchQuery) r10).a(CollectionsKt.listOf("common2"), false);
        if (r15 == null) goto L47;
        if (r15.intValue() == 0) goto L47;
        r22 = FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, new StringBuilder().append('|').append(r15).append('|').toString(), false, 2, null).a(CollectionsKt.listOf("common1"), false).a(r22);
    L47:
        if (r4.isEmpty() == true) goto L49;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r0.iterator();
    L52:
        if (r24.hasNext() == false) goto L54;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin");
        r23.add(FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, a(r25), false, 2, null).a(CollectionsKt.listOf("common3"), false));
        goto L52
    L54:
        List r26 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
        if (r26.isEmpty() == false) goto L59;
        return CollectionsKt.emptyList();
    L59:
        if (r26.size() <= 1) goto L69;
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r27.hasNext() == false) goto L68;
        Object r28 = r27.next();
    L64:
        if (r27.hasNext() == false) goto L66;
        FullTextSearchQuery r29 = (FullTextSearchQuery) ZeusTransformUtils.preCheckCast(r27.next(), FullTextSearchQuery.class, "com.obric.memorydata.plugin");
        r28 = ((FullTextSearchQuery) ZeusTransformUtils.preCheckCast(r28, FullTextSearchQuery.class, "com.obric.memorydata.plugin")).b(r29);
        goto L64
    L66:
        Object r30 = ZeusTransformUtils.preCheckCast(r28, FullTextSearchQuery.class, "com.obric.memorydata.plugin");
    L71:
        return a(r14, r22.a((FullTextSearchQuery) r30), r18, r5);
    L68:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L69:
        r30 = ZeusTransformUtils.preCheckCast(CollectionsKt.first(r26), FullTextSearchQuery.class, "com.obric.memorydata.plugin");
        goto L71
    L49:
        return CollectionsKt.emptyList();
    L39:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L40:
        r10 = ZeusTransformUtils.preCheckCast(CollectionsKt.first(r6), FullTextSearchQuery.class, "com.obric.memorydata.plugin");
        goto L41
    }

    public static final boolean delete(FullTextSearchSchema r8, List<? extends com.obric.search.api.b.a.a> r9) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r4, Constants.KEY_LIST);
        if (r4.isEmpty() == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r8.a(), ((com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r4.get(0), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin")).getSchemaName()) == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FullTextSearchSchemaExt", r8.a() + " schemaName mismatch when delete doc", null, 4, null);
        return false;
    L11:
        return a(r8).a((com.obric.search.api.e.b.a) ZeusTransformUtils.preCheckCast(new com.obric.search.api.e.a.a(r8.a(), r4, false, 4, null), com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean insert(FullTextSearchSchema r9, List<? extends com.obric.search.api.b.a.a> r10) {
        List<? extends com.obric.search.api.b.a.a> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r11, Constants.KEY_LIST);
        if (r11.isEmpty() == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r9.a(), ((com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r11.get(0), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin")).getSchemaName()) == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FullTextSearchSchemaExt", r9.a() + " schemaName mismatch when insert doc", null, 4, null);
        return false;
    L11:
        return a(r9).a(r11);
    }
}
