package com.obric.search.api.schema.impl;

import android.content.ContentValues;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.search.common.log.RuntimeLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00072\u0006\u0010\u0018\u001a\u00020\u0019J,\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016J\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\t\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/search/api/schema/impl/NonContentLessFTSExecutor;", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "columnList", "", "(Ljava/lang/String;Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;Ljava/util/List;)V", "insertOrReplaceSQLString", "getInsertOrReplaceSQLString", "()Ljava/lang/String;", "insertOrReplaceSQLString$delegate", "Lkotlin/Lazy;", "removeAllSQLString", "getRemoveAllSQLString", "removeAllSQLString$delegate", "removeSQLString", "getRemoveSQLString", "removeSQLString$delegate", "getDocumentsIdAndContentValues", "Lkotlin/Pair;", "", "Landroid/content/ContentValues;", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "putDocuments", "", Constants.KEY_LIST, "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14952b = null;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/schema/impl/NonContentLessFTSExecutor$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14952b = new a(null);
    }

    public c(final String r3, com.obric.search.api.schema.impl.a r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "schemaName");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "columnList");
        super(r3, r4, r6);
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new NonContentLessFTSExecutor$removeSQLString$2(r3), Function0.class, "com.obric.memorydata.plugin"));
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new NonContentLessFTSExecutor$removeAllSQLString$2(r3), Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new NonContentLessFTSExecutor$insertOrReplaceSQLString$2(r3, this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final String e() {
        return (String) ZeusTransformUtils.preCheckCast(this.c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String f() {
        return (String) ZeusTransformUtils.preCheckCast(this.d.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String g() {
        return (String) ZeusTransformUtils.preCheckCast(this.e.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.search.api.schema.impl.b, com.obric.search.api.schema.a.c
    public boolean a(com.obric.search.api.e.b.a r7) {
        com.obric.search.api.e.b.a r8 = (com.obric.search.api.e.b.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "removeSpec");
        RuntimeLogger.f14958a.a("NonContentLessFTSExecutor", "removeDocuments called! SchemaName is " + r8.a());
        if (ZeusTransformUtils.instanceOf(r8, com.obric.search.api.e.a.a.class) == true) goto L7;
        RuntimeLogger.f14958a.d("NonContentLessFTSExecutor", "removeDocuments removeSpec type error.");
        return false;
    L7:
        if (((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r8, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).c() == false) goto L11;
        Pair<Boolean, Integer> r6 = getContext().a().e(a(), f());
        RuntimeLogger.f14958a.b("NonContentLessFTSExecutor", "removeDocuments remove all done. res is " + r6);
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L11:
        if (((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r8, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).b().isEmpty() == false) goto L14;
        RuntimeLogger.f14958a.c("NonContentLessFTSExecutor", "removeDocuments removeSpec list is empty.");
        return true;
    L14:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.search.api.e.a.a) ZeusTransformUtils.preCheckCast(r8, com.obric.search.api.e.a.a.class, "com.obric.memorydata.plugin")).b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L16:
        if (r10.hasNext() == false) goto L23;
        com.obric.search.api.b.a.a r2 = (com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.search.api.b.a.b.class) == false) goto L20;
        Long r3 = Long.valueOf(r2.getId());
    L21:
        if (r3 == null) goto L16;
        r0.add(r3);
        goto L16
    L20:
        r3 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
        goto L21
    L23:
        Pair<Boolean, Integer> r11 = getContext().a().c(a(), e(), (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"));
        RuntimeLogger.f14958a.a("NonContentLessFTSExecutor", "removeDocuments done. res is " + r11);
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.search.api.schema.impl.b, com.obric.search.api.schema.a.c
    public boolean a(List<? extends com.obric.search.api.b.a.a> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, Constants.KEY_LIST);
        if (r11.isEmpty() == false) goto L6;
        RuntimeLogger.f14958a.c("NonContentLessFTSExecutor", "putOrReplaceDocuments called! List is empty! Return true");
        return true;
    L6:
        RuntimeLogger.f14958a.a("NonContentLessFTSExecutor", "putOrReplaceDocuments called! SchemaName is " + ((com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r11.get(0), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin")).getSchemaName());
        List<? extends Pair<Long, ? extends List<String>>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        com.obric.search.api.b.a.a r1 = (com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.search.api.b.a.b.class) == false) goto L11;
        ContentValues r2 = ((com.obric.search.api.b.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.search.api.b.a.b.class, "com.obric.memorydata.plugin")).toContentValues();
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<String> r5 = b().iterator();
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
        boolean r13 = getContext().a().a(a(), g(), r0);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r13;
    L21:
        th = move-exception;
        throw th;
    }

    public final List<Pair<Long, ContentValues>> b(long r15, long r17) {
        RuntimeLogger.f14958a.a("NonContentLessFTSExecutor", "getDocumentsIdAndContentValues called! SchemaName is " + a());
        if (a(r15, r17) == true) goto L5;
        StringBuilder r0 = new StringBuilder("SELECT ROWID, " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(b(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + " FROM " + a() + " ORDER BY ROWID ASC");
        a(r0, r15, r17);
        com.obric.search.storage.sqlite.a r1 = getContext().a();
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "querySQLStringBuilder.toString()");
        return r1.b(r2, "", b());
    L5:
        return CollectionsKt.emptyList();
    }
}
