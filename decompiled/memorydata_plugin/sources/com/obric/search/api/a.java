package com.obric.search.api;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.BuildConfig;
import com.obric.search.api.a.b;
import com.obric.search.api.c.e;
import com.obric.search.api.schema.a.c;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0016J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001a\u00020+J(\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010,\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020)2\b\b\u0002\u0010.\u001a\u00020)J \u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002000\u00140!2\u0006\u0010*\u001a\u00020+J4\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002000\u00140!2\u0006\u0010,\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020)2\b\b\u0002\u0010.\u001a\u00020)J\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020!2\u0006\u0010*\u001a\u00020+J\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002040!2\u0006\u0010*\u001a\u00020+J\u0010\u00105\u001a\u0004\u0018\u00010\u00192\u0006\u0010,\u001a\u00020\bJ\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070!2\u0006\u0010*\u001a\u0002082\u0006\u00109\u001a\u00020:Jh\u0010;\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\bJ\u0014\u0010F\u001a\u00020\u000e2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0!JP\u0010I\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020J0!2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020QJ \u0010R\u001a\u00020\u001d2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0TR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/search/api/OSearchEngine;", "", "()V", "callBack", "Lcom/obric/search/api/OSearchEngine$CallBack;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "fullTextSearchSchemaContext", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "", "isInitDone", "()Z", "isInitStart", "pluginList", "", "Lkotlin/Pair;", "Lcom/obric/search/api/plugin/intf/ISearchEnginePlugin;", "Lcom/obric/search/api/plugin/intf/ISearchEnginePluginConfig;", "schemaExecutorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "sqliteSearchEngine", "Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "addExecutor", "", "appContext", "Landroid/content/Context;", "schemaList", "", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "context", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "addPlugin", BuildConfig.BUILD_PRODUCT_TYPE, "config", "getDocumentsId", "", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "schemaName", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "getDocumentsIdAndContentValues", "Landroid/content/ContentValues;", "getDocumentsIdAndIsFullMatch", "Lcom/obric/search/api/schema/impl/bean/DocumentIsFullMatch;", "getDocumentsIdAndTokenPosition", "Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "getExecutor", "getFTSDocumentInfo", "Lcom/obric/search/api/schema/impl/bean/FullTextSearchDocumentInfo;", "Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "infoSpec", "Lcom/obric/search/api/search/impl/FullTextSearchInfoSpec;", CommonConsts.APM_INNER_EVENT_COST_INIT, "version", "", "synonymUri", "Landroid/net/Uri;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationConfig", "Lcom/obric/search/api/config/MigrationConfig;", "databasePath", "putDocuments", Constants.KEY_LIST, "Lcom/obric/search/api/document/intf/IDocument;", "reinitSqlite", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "setCallBack", "setSQLiteDatabaseTraceCallback", "sqliteTrace", "Lcom/obric/search/api/config/SQLiteTrace;", "setTokenizerSamePinyinConfig", "excludedMap", "", "CallBack", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f14922b;
    private volatile boolean c;
    private volatile boolean d;
    private final al e;
    private String f;
    private com.obric.search.storage.sqlite.a g;
    private com.obric.search.api.schema.impl.a h;
    private final List<Pair<com.obric.search.api.d.a.a, com.obric.search.api.d.a.b>> i;
    private volatile InterfaceC0797a j;

    /* JADX INFO: renamed from: com.obric.search.api.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/search/api/OSearchEngine$CallBack;", "", "onInitDone", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface InterfaceC0797a {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/search/api/OSearchEngine$Companion;", "", "()V", "DATABASE_NAME_PREFIX", "", "TAG", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14921a = new b(null);
    }

    public a() {
        this.f14922b = new ConcurrentHashMap();
        this.e = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        this.f = "";
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List a(a r0) {
        return r0.i;
    }

    private final void a(Context r5, List<? extends com.obric.search.api.schema.a.a> r6, com.obric.search.api.schema.a.b r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        com.obric.search.api.schema.a.b r10 = (com.obric.search.api.schema.a.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.search.api.schema.a.b.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        com.obric.search.api.schema.a.a r0 = (com.obric.search.api.schema.a.a) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.search.api.schema.a.a.class, "com.obric.memorydata.plugin");
        this.f14922b.put(r0.a(), r0.a(r8, r10));
        goto L4
    }

    public static /* synthetic */ void a(a r13, Context r14, String r15, int r16, List r17, Uri r18, String r19, b r20, com.obric.search.api.a.a r21, String r22, int r23, Object r24) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.search.api.schema.a.a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        if ((r23 & 16) == 0) goto L5;
        Uri r8 = null;
    L7:
        if ((r23 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r23 & 64) == 0) goto L13;
        b r10 = null;
    L15:
        if ((r23 & 128) == 0) goto L17;
        com.obric.search.api.a.a r11 = null;
    L19:
        if ((r23 & 256) == 0) goto L21;
        String r12 = null;
    L22:
        r13.a(r4, r15, r16, r7, r8, r9, r10, r11, r12);
        return;
    L21:
        r12 = r22;
        goto L22
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }

    public static /* synthetic */ void a(a r10, Context r11, String r12, int r13, List r14, String r15, b r16, com.obric.search.api.a.a r17, int r18, Object r19) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        List<FullTextSearchSchema> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        b r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        com.obric.search.api.a.a r9 = null;
    L14:
        r10.a(r3, r12, r13, r6, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public static final /* synthetic */ void a(a r2, Context r3, List r4, com.obric.search.api.schema.a.b r5) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (com.obric.search.api.schema.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.search.api.schema.a.b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ InterfaceC0797a b(a r0) {
        return r0.j;
    }

    public final synchronized c a(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "schemaName");     // Catch: Throwable -> L6
        c r4 = (c) ZeusTransformUtils.preCheckCast(this.f14922b.get(r3), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final List<Long> a(com.obric.search.api.search.a.a r3) {
        com.obric.search.api.search.a.a r4 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "searchSpec");
        c r2 = a(r4.a());
        if (r2 == null) goto L7;
        List<Long> r5 = r2.a(r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return CollectionsKt.emptyList();
    }

    public final List<com.obric.search.api.schema.impl.a.c> a(FullTextSearchSpec r3, com.obric.search.api.search.impl.a r4) {
        Intrinsics.checkNotNullParameter(r3, "searchSpec");
        Intrinsics.checkNotNullParameter(r4, "infoSpec");
        c r2 = a(r3.a());
        if (r2 != null) goto L5;
    L9:
        RuntimeLogger.f14958a.d("OSearchEngine", "getDocumentIdAndOtherInfo executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.search.api.schema.impl.b.class) == false) goto L9;
        return ((com.obric.search.api.schema.impl.b) ZeusTransformUtils.preCheckCast(r2, com.obric.search.api.schema.impl.b.class, "com.obric.memorydata.plugin")).a(r3, r4);
    }

    public final List<Pair<Long, ContentValues>> a(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        c r1 = a(r2);
        if (r1 != null) goto L5;
    L9:
        RuntimeLogger.f14958a.d("OSearchEngine", "getDocumentsIdAndContentValues executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.search.api.schema.impl.c.class) == false) goto L9;
        return ((com.obric.search.api.schema.impl.c) ZeusTransformUtils.preCheckCast(r1, com.obric.search.api.schema.impl.c.class, "com.obric.memorydata.plugin")).b(r3, r5);
    }

    public final synchronized void a(Context r20, String r21, int r22, List<? extends com.obric.search.api.schema.a.a> r23, Uri r24, String r25, b r26, com.obric.search.api.a.a r27, String r28) {
        monitor-enter(this);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r7, "appContext");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r21, "databaseName");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r1, "schemaList");     // Catch: Throwable -> L38
        if (this.c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.c = true;     // Catch: Throwable -> L38
        HashMap r6 = new HashMap();     // Catch: Throwable -> L38
        Iterator<Pair<com.obric.search.api.d.a.a, com.obric.search.api.d.a.b>> r2 = this.i.iterator();     // Catch: Throwable -> L38
    L10:
        if (r2.hasNext() == false) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put(((Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        goto L10
    L12:
        List<? extends com.obric.search.api.schema.a.a> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L38
    L14:
        if (r5.hasNext() == false) goto L26;
        com.obric.search.api.schema.a.a r8 = (com.obric.search.api.schema.a.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.search.api.schema.a.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (ZeusTransformUtils.instanceOf(r8, FullTextSearchSchema.class) == true) goto L17;
        Iterator<Pair<com.obric.search.api.d.a.a, com.obric.search.api.d.a.b>> r9 = this.i.iterator();     // Catch: Throwable -> L38
    L20:
        if (r9.hasNext() == false) goto L14;
        Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (((com.obric.search.api.d.a.a) ZeusTransformUtils.preCheckCast(r10.getFirst(), com.obric.search.api.d.a.a.class, "com.obric.memorydata.plugin")).a(r8) == false) goto L20;
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6.get(r10.getFirst()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r11 == null) goto L14;
        r11.add(r8);     // Catch: Throwable -> L38
        goto L14
    L17:
        r4.add(r8);     // Catch: Throwable -> L38
        goto L14
    L26:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L38
    L28:
        if (r14.hasNext() == false) goto L30;
        FullTextSearchSchema r15 = (FullTextSearchSchema) ZeusTransformUtils.preCheckCast(r14.next(), FullTextSearchSchema.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        r13.add(new com.obric.search.storage.sqlite.a.a.a(r15.a(), r15.b(), r15.c(), r15.d()));     // Catch: Throwable -> L38
        goto L28
    L30:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r27 == null) goto L34;
        List<com.obric.search.api.c.a> r17 = r27.a();     // Catch: Throwable -> L38
        if (r17 == null) goto L34;
    L35:
        e r18 = new e(r17);     // Catch: Throwable -> L38
        this.f = "OSE_" + r21;     // Catch: Throwable -> L38
        com.obric.search.storage.sqlite.a r0 = new com.obric.search.storage.sqlite.a(r7, this.f, r22, r16, r25, r26, r18, r28);     // Catch: Throwable -> L38
        this.g = r0;     // Catch: Throwable -> L38
        com.obric.search.api.schema.impl.a r19 = new com.obric.search.api.schema.impl.a(r0);     // Catch: Throwable -> L38
        this.h = r19;     // Catch: Throwable -> L38
        a(r7, r4, (com.obric.search.api.schema.a.b) ZeusTransformUtils.preCheckCast(r19, com.obric.search.api.schema.a.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        i.a(this.e, null, null, (Function2) ZeusTransformUtils.preCheckCast(new OSearchEngine$init$2(r24, r3, this, r6, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L34:
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Context r15, String r16, int r17, List<FullTextSearchSchema> r18, String r19, b r20, com.obric.search.api.a.a r21) {
        monitor-enter(this);
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        List<? extends com.obric.search.api.schema.a.a> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r2, "context");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r16, "databaseName");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r11, "schemaList");     // Catch: Throwable -> L23
        com.obric.search.storage.sqlite.a r3 = this.g;     // Catch: Throwable -> L23
        com.obric.search.api.schema.impl.a r12 = this.h;     // Catch: Throwable -> L23
        if (r3 == null) goto L20;
        if (r12 == null) goto L20;
        this.f = "OSE_" + r16;     // Catch: Throwable -> L23
        if (r21 == null) goto L12;
        List<com.obric.search.api.c.a> r0 = r21.a();     // Catch: Throwable -> L23
        if (r0 == null) goto L12;
    L13:
        e r10 = new e(r0);     // Catch: Throwable -> L23
        String r5 = this.f;     // Catch: Throwable -> L23
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Iterator r6 = r1.iterator();     // Catch: Throwable -> L23
    L15:
        if (r6.hasNext() == false) goto L17;
        FullTextSearchSchema r7 = (FullTextSearchSchema) ZeusTransformUtils.preCheckCast(r6.next(), FullTextSearchSchema.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        r4.add(new com.obric.search.storage.sqlite.a.a.a(r7.a(), r7.b(), r7.c(), r7.d()));     // Catch: Throwable -> L23
        goto L15
    L17:
        r3.a(r2, r5, r17, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), r19, r20, r10);     // Catch: Throwable -> L23
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r8, "context.applicationContext");     // Catch: Throwable -> L23
        a(r8, r11, (com.obric.search.api.schema.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.search.api.schema.a.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L12:
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L23
    L20:
        RuntimeLogger.f14958a.d("OSearchEngine", "recreateSqliteDatabaseManager sqliteSearchEngine or fullTextSearchSchemaContext is null.");     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final void a(Map<Integer, ? extends List<String>> r2) {
        Map<Integer, ? extends List<String>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "excludedMap");
        SQLiteFts5Extension.f14967a.a(r1);
    }

    public final boolean a(com.obric.search.api.a.c r3) {
        com.obric.search.api.a.c r4 = (com.obric.search.api.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.search.api.a.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "sqliteTrace");
        com.obric.search.storage.sqlite.a r2 = this.g;
        if (r2 == null) goto L5;
        r2.a(r4);
        Unit r5 = Unit.INSTANCE;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        return true;
    L5:
        r5 = null;
        goto L6
    }

    public final boolean a(com.obric.search.api.e.b.a r3) {
        com.obric.search.api.e.b.a r4 = (com.obric.search.api.e.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "removeSpec");
        c r2 = a(r4.a());
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.a(r4);
    }

    public final boolean a(List<? extends com.obric.search.api.b.a.a> r5) {
        List<? extends com.obric.search.api.b.a.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, Constants.KEY_LIST);
        if (r6.isEmpty() == false) goto L6;
        return true;
    L6:
        c r4 = a(((com.obric.search.api.b.a.a) ZeusTransformUtils.preCheckCast(r6.get(0), com.obric.search.api.b.a.a.class, "com.obric.memorydata.plugin")).getSchemaName());
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.a(r6);
    }

    public final List<com.obric.search.api.schema.impl.a.b> b(com.obric.search.api.search.a.a r3) {
        com.obric.search.api.search.a.a r4 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "searchSpec");
        c r2 = a(r4.a());
        if (r2 != null) goto L5;
    L9:
        RuntimeLogger.f14958a.d("OSearchEngine", "getDocumentsIdAndTokenPosition executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.search.api.schema.impl.b.class) == false) goto L9;
        return ((com.obric.search.api.schema.impl.b) ZeusTransformUtils.preCheckCast(r2, com.obric.search.api.schema.impl.b.class, "com.obric.memorydata.plugin")).b(r4);
    }

    public final List<com.obric.search.api.schema.impl.a.a> c(com.obric.search.api.search.a.a r3) {
        com.obric.search.api.search.a.a r4 = (com.obric.search.api.search.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "searchSpec");
        c r2 = a(r4.a());
        if (r2 != null) goto L5;
    L9:
        RuntimeLogger.f14958a.d("OSearchEngine", "getDocumentsIdAndIsFullMatch executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.search.api.schema.impl.b.class) == false) goto L9;
        return ((com.obric.search.api.schema.impl.b) ZeusTransformUtils.preCheckCast(r2, com.obric.search.api.schema.impl.b.class, "com.obric.memorydata.plugin")).c(r4);
    }
}
