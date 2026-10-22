package com.obric.search.api.schema.impl;

import android.content.ContentValues;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import com.tencent.wcdb.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 G2\u00020\u0001:\u0001GB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ$\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\"j\u0002`#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0004J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00072\u0006\u0010(\u001a\u00020)H\u0016J \u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00072\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00072\u0006\u0010(\u001a\u00020)J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00072\u0006\u0010(\u001a\u00020)J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00072\u0006\u0010(\u001a\u0002002\u0006\u00101\u001a\u000202J>\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020%0\u0007H\u0004J\u0018\u00109\u001a\u00020:2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0004J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00072\u0006\u0010<\u001a\u00020\u0003H\u0002J(\u0010=\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0>0\u00070\u00072\u0006\u0010@\u001a\u00020\u0003H\u0002J\u0016\u0010A\u001a\u00020:2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0007H\u0016J\u0010\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020FH\u0016R\u001b\u0010\t\u001a\u00020\u00038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000bR\u001b\u0010\u0018\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u000bR\u001b\u0010\u001b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000b¨\u0006H"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "columnList", "", "(Ljava/lang/String;Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;Ljava/util/List;)V", "argString", "getArgString", "()Ljava/lang/String;", "argString$delegate", "Lkotlin/Lazy;", "getColumnList", "()Ljava/util/List;", "columnString", "getColumnString", "columnString$delegate", "getContext", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "insertSQLString", "getInsertSQLString", "insertSQLString$delegate", "removeAllSQLString", "getRemoveAllSQLString", "removeAllSQLString$delegate", "removeSQLString", "getRemoveSQLString", "removeSQLString$delegate", "getSchemaName", "appendLimitOffset", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "limit", "", TypedValues.CycleType.S_WAVE_OFFSET, "getDocumentsId", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "getDocumentsIdAndIsFullMatch", "Lcom/obric/search/api/schema/impl/bean/DocumentIsFullMatch;", "getDocumentsTokenPosition", "Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "getFTSDocumentInfo", "Lcom/obric/search/api/schema/impl/bean/FullTextSearchDocumentInfo;", "Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "infoSpec", "Lcom/obric/search/api/search/impl/FullTextSearchInfoSpec;", "getQuerySQLString", "selectClause", "tableName", "rankMethod", "Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "targetIdList", "isInvalidLimitOffset", "", "parseIsFullMatch", "isFullMatchStr", "parseTokenPositions", "Lkotlin/Pair;", "", "tokenPositionsStr", "putDocuments", Constants.KEY_LIST, "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class b implements com.obric.search.api.schema.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14951b;
    private final com.obric.search.api.schema.impl.a c;
    private final List<String> d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14950a = new a(null);
    }

    public b(String r3, com.obric.search.api.schema.impl.a r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "schemaName");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "columnList");
        this.f14951b = r3;
        this.c = r4;
        this.d = r6;
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FullTextSearchSchemaExecutor$argString$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FullTextSearchSchemaExecutor$columnString$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FullTextSearchSchemaExecutor$insertSQLString$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FullTextSearchSchemaExecutor$removeSQLString$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FullTextSearchSchemaExecutor$removeAllSQLString$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final List<List<Pair<Integer, Integer>>> a(String r12) {
        int r11 = 1;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{' '}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    L6:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1;
        List<List<Pair<Integer, Integer>>> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (1 > r4) goto L19;
    L8:
        List<Pair<Integer, Integer>> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IntProgression r6 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(r2, ((Number) ZeusTransformUtils.preCheckCast(r15.get(r11), Number.class, "com.obric.memorydata.plugin")).intValue() + r2), IntProgression.class, "com.obric.memorydata.plugin"), 2);
        int r7 = r6.getFirst();
        int r8 = r6.getLast();
        int r9 = r6.getStep();
        if (r9 <= 0) goto L11;
        if (r7 > r8) goto L11;
    L13:
        r5.add(new Pair(r15.get(r7), r15.get(r7 + 1)));
        if (r7 == r8) goto L16;
        r7 = r7 + r9;
    L16:
        r2 = r2 + ((Number) ZeusTransformUtils.preCheckCast(r15.get(r11), Number.class, "com.obric.memorydata.plugin")).intValue();
        r3.add(r5);
        if (r11 == r4) goto L19;
        r11 = r11 + 1;
    L11:
        if (r9 >= 0) goto L16;
        if (r8 > r7) goto L16;
    L19:
        return r3;
    }

    private final List<Boolean> b(String r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{' '}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    L6:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        List<Boolean> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        if (((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L12;
        boolean r3 = true;
    L13:
        r2.add(Boolean.valueOf(r3));
        goto L8
    L12:
        r3 = false;
        goto L13
    L14:
        return r2;
    }

    private final String e() {
        return (String) ZeusTransformUtils.preCheckCast(this.g.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String f() {
        return (String) ZeusTransformUtils.preCheckCast(this.h.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String g() {
        return (String) ZeusTransformUtils.preCheckCast(this.i.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String a() {
        return this.f14951b;
    }

    public final String a(String r18, String r19, FullTextSearchSpec.RankMethod r20, long r21, long r23, List<Long> r25) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, "selectClause");
        Intrinsics.checkNotNullParameter(r19, "tableName");
        Intrinsics.checkNotNullParameter(r20, "rankMethod");
        Intrinsics.checkNotNullParameter(r5, "targetIdList");
        StringBuilder r7 = new StringBuilder("SELECT " + r18 + " FROM " + r19 + " WHERE " + r19 + " MATCH ?");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        r7.append(" AND ROWID IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')');
    L6:
        if (r20 != FullTextSearchSpec.RankMethod.BM25) goto L9;
        r7.append(" AND rank='bm25()' ORDER BY rank");
    L9:
        if (r21 == 0) goto L11;
        r7.append(" LIMIT " + r21 + " OFFSET " + r23);
    L11:
        String r0 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "sb.toString()");
        return r0;
    }

    @Override // com.obric.search.api.schema.a.c
    public List<Long> a(com.obric.search.api.search.a.a r12) {
        com.obric.search.api.search.a.a r13 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "searchSpec");
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "getDocumentsId called! SchemaName is " + r13.a());
        if (ZeusTransformUtils.instanceOf(r13, FullTextSearchSpec.class) == true) goto L7;
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "getDocumentsId searchSpec type error.");
        return CollectionsKt.emptyList();
    L7:
        return this.c.a().b(a("ROWID", this.f14951b, ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).c(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).d(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).e(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).f()), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).b().a());
    }

    public final List<com.obric.search.api.schema.impl.a.c> a(FullTextSearchSpec r19, com.obric.search.api.search.impl.a r20) {
        Intrinsics.checkNotNullParameter(r19, "searchSpec");
        Intrinsics.checkNotNullParameter(r20, "infoSpec");
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "getFTSDocumentInfo called! SchemaName is " + r19.a());
        StringBuilder r1 = new StringBuilder("ROWID");
        if (r20.a() == false) goto L6;
        r1.append(",bm25(" + this.f14951b + ") AS score");
    L6:
        if (r20.b() == false) goto L9;
        r1.append(",is_full_match(" + this.f14951b + ") AS is_full_match");
    L9:
        if (r20.c() == false) goto L11;
        r1.append(",token_position(" + this.f14951b + ") AS token_positions");
    L11:
        String r2 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "selectClauseBuilder.toString()");
        f r3 = this.c.a().d(a(r2, this.f14951b, r19.c(), r19.d(), r19.e(), r19.f()), r19.b().a());
        List<com.obric.search.api.schema.impl.a.c> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "queryRowIdAndStringColumn cursor size is " + r6.getCount());     // Catch: Throwable -> L36
        int r7 = r6.getColumnIndex("rowid");     // Catch: Throwable -> L36
        if (r7 != (-1)) goto L17;
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "queryRowIdAndStringColumn ROWID index is -1");     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r5, null);
        return r4;
    L17:
        int r8 = r6.getColumnIndex("score");     // Catch: Throwable -> L36
        int r9 = r6.getColumnIndex("is_full_match");     // Catch: Throwable -> L36
        int r10 = r6.getColumnIndex("token_positions");     // Catch: Throwable -> L36
    L19:
        if (r6.moveToNext() == false) goto L33;
        long r12 = r6.getLong(r7);     // Catch: Throwable -> L36
        if (r8 == (-1)) goto L23;
        double r11 = ((double) (-1)) * r6.getDouble(r8);     // Catch: Throwable -> L36
    L24:
        double r14 = r11;
        if (r9 == (-1)) goto L27;
        String r13 = r6.getString(r9);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r13, "it.getString(isFullMatchIndex)");     // Catch: Throwable -> L36
        List<Boolean> r15 = b(r13);     // Catch: Throwable -> L36
    L28:
        List<Boolean> r16 = r15;
        if (r10 == (-1)) goto L31;
        String r17 = r6.getString(r10);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r17, "it.getString(tokenPositionsIndex)");     // Catch: Throwable -> L36
        List<List<Pair<Integer, Integer>>> r18 = a(r17);     // Catch: Throwable -> L36
    L32:
        r4.add(new com.obric.search.api.schema.impl.a.c(r12, r14, r16, r18));     // Catch: Throwable -> L36
        goto L19
    L31:
        r18 = CollectionsKt.emptyList();     // Catch: Throwable -> L36
        goto L32
    L27:
        r15 = CollectionsKt.emptyList();     // Catch: Throwable -> L36
        goto L28
    L23:
        r11 = 0.0d;
        goto L24
    L33:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r5, null);
        return r4;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public final void a(StringBuilder r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r3, "sb");
        if (r4 <= 0) goto L7;
        StringBuilder r2 = new StringBuilder().append(" LIMIT ").append(r4);
        String r5 = " OFFSET ";
    L5:
        r3.append(r2.append(r5).append(r6).toString());
        return;
    L7:
        if (r6 <= 0) goto L10;
        r2 = new StringBuilder();
        r5 = " LIMIT -1 OFFSET ";
        goto L5
    }

    public final boolean a(long r4, long r6) {
        if (r4 >= 0) goto L5;
    L9:
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "isInvalidLimitOffset error. schemaName is " + this.f14951b + ", limit is " + r4 + ", offset is " + r6 + '.');
        return true;
    L5:
        if (r6 < 0) goto L9;
        return false;
    }

    @Override // com.obric.search.api.schema.a.c
    public boolean a(com.obric.search.api.e.b.a r15) {
        com.obric.search.api.e.b.a r16 = (com.obric.search.api.e.b.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "removeSpec");
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "removeDocuments called! SchemaName is " + r16.a());
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r16, com.obric.search.api.e.a.a.class) == true) goto L7;
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "removeDocuments removeSpec type error.");
        return false;
    L7:
        if (((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r16, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).c() == false) goto L16;
        monitor-enter(this);
        boolean r17 = this.c.a().a(this.f14951b, g());     // Catch: Throwable -> L12
        RuntimeLogger.f14958a.b("FullTextSearchSchemaExecutor", "removeDocuments remove all done. res is " + r17);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r17;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r16, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).b().isEmpty() == false) goto L19;
        RuntimeLogger.f14958a.c("FullTextSearchSchemaExecutor", "removeDocuments removeSpec list is empty.");
        return true;
    L19:
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends Pair<Long, ? extends List<String>>> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        Iterator<com.obric.search.api.b.a.a> r18 = ((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r16, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).b().iterator();     // Catch: Throwable -> L44
    L23:
        if (r18.hasNext() == false) goto L36;
        com.obric.search.api.b.a.a r4 = (com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (ZeusTransformUtils.instanceOf(r4, com.obric.search.api.b.a.b.class) == false) goto L42;
        if (this.c.a().b("SELECT ROWID FROM " + this.f14951b + " WHERE ROWID = ? LIMIT 1", String.valueOf(r4.getId())).isEmpty() == true) goto L29;
        ContentValues r5 = ((com.obric.search.api.b.a.b) ZeusTransformUtils.preCheckCast(r4, com.obric.search.api.b.a.b.class, "com.obric.memorydata.plugin")).toContentValues();     // Catch: Throwable -> L44
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Iterator<String> r7 = this.d.iterator();     // Catch: Throwable -> L44
    L32:
        if (r7.hasNext() == false) goto L34;
        String r8 = r5.getAsString((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r8, "contentValues.getAsString(column)");     // Catch: Throwable -> L44
        r6.add(r8);     // Catch: Throwable -> L44
        goto L32
    L34:
        r3.add(new Pair(Long.valueOf(r4.getId()), r6));     // Catch: Throwable -> L44
        goto L23
    L29:
        r0.add(Long.valueOf(r4.getId()));     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return r1;
    L36:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L39;
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "removeDocuments removeSpec not exist rowId(" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null) + ").");     // Catch: Throwable -> L44
    L39:
        if (r3.isEmpty() == false) goto L41;
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "removeDocuments removeArguments is empty.");     // Catch: Throwable -> L44
        goto L42
    L41:
        r1 = this.c.a().a(this.f14951b, f(), r3);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.search.api.schema.a.c
    public boolean a(List<? extends com.obric.search.api.b.a.a> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, Constants.KEY_LIST);
        if (r11.isEmpty() == false) goto L6;
        RuntimeLogger.f14958a.c("FullTextSearchSchemaExecutor", "putDocuments called! List is empty! Return true");
        return true;
    L6:
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "putDocuments called! SchemaName is " + ((com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r11.get(0), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin")).getSchemaName());
        List<? extends Pair<Long, ? extends List<String>>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        com.obric.search.api.b.a.a r1 = (com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.search.api.b.a.b.class) == false) goto L11;
        ContentValues r2 = ((com.obric.search.api.b.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.search.api.b.a.b.class, "com.obric.memorydata.plugin")).toContentValues();
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<String> r5 = this.d.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        String r6 = r2.getAsString((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r6, "contentValues.getAsString(column)");
        r4.add(r6);
        goto L14
    L16:
        r0.add(new Pair(Long.valueOf(r1.getId()), r4));
        goto L8
    L11:
        return false;
    L17:
        monitor-enter(this);
        boolean r13 = this.c.a().a(this.f14951b, e(), r0);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r13;
    L21:
        th = move-exception;
        throw th;
    }

    public final List<String> b() {
        return this.d;
    }

    public final List<com.obric.search.api.schema.impl.a.b> b(com.obric.search.api.search.a.a r12) {
        com.obric.search.api.search.a.a r13 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "searchSpec");
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "getDocumentsTokenPosition called! SchemaName is " + r13.a());
        if (ZeusTransformUtils.instanceOf(r13, FullTextSearchSpec.class) == true) goto L6;
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "getDocumentsTokenPosition searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        List<Pair<Long, String>> r14 = this.c.a().c(a("ROWID,token_position(" + this.f14951b + ')', this.f14951b, ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).c(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).d(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).e(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).f()), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).b().a());
        List<com.obric.search.api.schema.impl.a.b> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Pair<Long, String>> r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin");
        r0.add(new com.obric.search.api.schema.impl.a.b(((Number) ZeusTransformUtils.preCheckCast(r2.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue(), a((String) ZeusTransformUtils.preCheckCast(r2.getSecond(), String.class, "com.obric.memorydata.plugin"))));
        goto L8
    L10:
        return r0;
    }

    public final String c() {
        return (String) ZeusTransformUtils.preCheckCast(this.e.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final List<com.obric.search.api.schema.impl.a.a> c(com.obric.search.api.search.a.a r12) {
        com.obric.search.api.search.a.a r13 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "searchSpec");
        RuntimeLogger.f14958a.a("FullTextSearchSchemaExecutor", "getDocumentsIdAndIsFullMatch called! SchemaName is " + r13.a());
        if (ZeusTransformUtils.instanceOf(r13, FullTextSearchSpec.class) == true) goto L6;
        RuntimeLogger.f14958a.d("FullTextSearchSchemaExecutor", "getDocumentsIdAndIsFullMatch searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        List<Pair<Long, String>> r14 = this.c.a().c(a("ROWID,is_full_match(" + this.f14951b + ')', this.f14951b, ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).c(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).d(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).e(), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).f()), ((FullTextSearchSpec) ZeusTransformUtils.preCheckCast(r13, FullTextSearchSpec.class, "com.obric.memorydata.plugin")).b().a());
        List<com.obric.search.api.schema.impl.a.a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Pair<Long, String>> r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin");
        r0.add(new com.obric.search.api.schema.impl.a.a(((Number) ZeusTransformUtils.preCheckCast(r2.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue(), b((String) ZeusTransformUtils.preCheckCast(r2.getSecond(), String.class, "com.obric.memorydata.plugin"))));
        goto L8
    L10:
        return r0;
    }

    public final String d() {
        return (String) ZeusTransformUtils.preCheckCast(this.f.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final com.obric.search.api.schema.impl.a getContext() {
        return this.c;
    }
}
