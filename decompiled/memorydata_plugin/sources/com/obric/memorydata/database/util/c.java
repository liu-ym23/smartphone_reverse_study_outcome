package com.obric.memorydata.database.util;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.h;
import com.obric.memorydata.utils.q;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.common.log.RuntimeLogger;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u0018J\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050&0%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/util/KeywordIndexEngine;", "", "<init>", "()V", "KEYWORD_INDEX_CONTENT_ENCRYPT_DB_NAME", "", "KEYWORD_INDEX_CONTENT_PERSONAL_DB_NAME", "DATABASE_VERSION", "", "KEY_RE_DONATE_CONTEXT_INDEX_KEY", "RE_DONATE_DELAY_TIME_MS", "", "DATABASE_CORRUPTED_LAST_TIMESTAMP_MS", "META_FULL_CONTENT_TABLE_NAME", "searchEngine", "Lcom/obric/search/api/OSearchEngine;", "getSearchEngine", "()Lcom/obric/search/api/OSearchEngine;", "searchEngine$delegate", "Lkotlin/Lazy;", "personalSearchEngine", "getPersonalSearchEngine", "personalSearchEngine$delegate", "metaFullContentEntitySchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "getMetaFullContentEntitySchema", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "metaFullContentEntitySchema$delegate", "TAG", "createSearchEngine", "databaseName", "initRuntimeLogger", "", "getMigrationConfig", "Lcom/obric/search/api/config/MigrationConfig;", "getMetaFullContentSchema", "getTokenizerSamePinyinConfig", "", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9626a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9627b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/database/util/KeywordIndexEngine$createSearchEngine$1$1", "Lcom/obric/search/api/config/SQLiteTrace;", "onDatabaseCorrupted", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.search.api.a.c {
        a() {
        }

        @Override // com.obric.search.api.a.c
        public void a() {
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeywordIndexEngine", "KeywordDatabaseCorrupted", null, 4, null);
            long r2 = System.currentTimeMillis();
            if (Math.abs(r2 - IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("keyword_database_corrupted_last_timestamp", 0)) >= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L5;
            return;
        L5:
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("keyword_database_corrupted_last_timestamp", r2);
            Ensure.ensureNotReachHere("KeywordDatabaseCorrupted");
        }

        @Override // com.obric.search.api.a.c
        public void a(String r1, int r2, long r3) {
            com.obric.search.api.a.c.a.a(this, r1, r2, r3);
        }

        @Override // com.obric.search.api.a.c
        public void a(String r1, long r2, boolean r4) {
            com.obric.search.api.a.c.a.a(this, r1, r2, r4);
        }

        @Override // com.obric.search.api.a.c
        public void a(String r10, long r11, boolean r13, List<com.obric.search.api.a.c.b<String>> r14, List<com.obric.search.api.a.c.b<StackTraceElement[]>> r15) {
            com.obric.search.api.a.c.a.a(this, r10, r11, r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/database/util/KeywordIndexEngine$initRuntimeLogger$1", "Lcom/obric/search/common/log/intf/ILogger;", "debug", "", LocationMonitorConst.TAG, "", "message", "error", "info", "warn", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.search.common.log.b.a {
        b() {
        }

        @Override // com.obric.search.common.log.b.a
        public void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, "message");
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.search.common.log.b.a
        public void b(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, "message");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }

        @Override // com.obric.search.common.log.b.a
        public void c(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, "message");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);
        }

        @Override // com.obric.search.common.log.b.a
        public void d(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, "message");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }
    }

    static {
        c r0 = new c();
        f9626a = r0;
        f9627b = LazyKt.lazy($$Lambda$c$b_GUJZG9rNIzuj6PT2TShrvP9Nk.INSTANCE);
        c = LazyKt.lazy($$Lambda$c$N2ZQClXMqh2Em4AgdyUnfNfIU.INSTANCE);
        d = LazyKt.lazy($$Lambda$c$Q6yYMwX4eYb3MDBqaVQKUIums.INSTANCE);
        r0.f();
    }

    private c() {
    }

    private final com.obric.search.api.a a(String r15) {
        EntityIndexEngine r14 = s.a();
        Uri r6 = Uri.parse("file://android_asset/synonym_dict.osyn");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "KeywordIndexEngine", "init, databaseName: " + q.f13259a.b(r15) + ", synonymUri: " + r6, false, 4, null);
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDatabasePath("dummy").getParentFile();
        if (r0 == null) goto L5;
        String r1 = r0.getAbsolutePath();
    L6:
        String r10 = r1;
        com.obric.search.api.a r2 = new com.obric.search.api.a();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        List<FullTextSearchSchema> r5 = r14.getAllKeywordSchema();
        String r7 = com.obric.memorydata.middleware.database.d.f11652a.c(r15);
        c r16 = f9626a;
        com.obric.search.api.a.a(r2, r3, r15, 8, r5, r6, r7, null, r16.g(), r10, 64, null);
        r2.a(r16.d());
        r2.a((com.obric.search.api.a.c) ZeusTransformUtils.preCheckCast(new a(), com.obric.search.api.a.c.class, "com.obric.memorydata.plugin"));
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    private final FullTextSearchSchema e() {
        return (FullTextSearchSchema) ZeusTransformUtils.preCheckCast(d.getValue(), FullTextSearchSchema.class, "com.obric.memorydata.plugin");
    }

    private final void f() {
        RuntimeLogger.f14958a.a(RuntimeLogger.LogLevel.DEBUG);
        RuntimeLogger.f14958a.a((com.obric.search.common.log.b.a) ZeusTransformUtils.preCheckCast(new b(), com.obric.search.common.log.b.a.class, "com.obric.memorydata.plugin"));
    }

    private final com.obric.search.api.a.a g() {
        EntityIndexEngine r0 = s.a();
        FullTextSearchSchema r1 = r0.getKeywordSchema(NetError.ERR_INVALID_REDIRECT);
        FullTextSearchSchema r2 = r0.getKeywordSchema(-305);
        com.obric.search.api.c.a r3 = new com.obric.search.api.c.d(1, 2).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(new FullTextSearchSchema[]{r1, r2}))}).a();
        FullTextSearchSchema r4 = r0.getKeywordSchema(501);
        FullTextSearchSchema r5 = r0.getKeywordSchema(-307);
        FullTextSearchSchema r6 = r0.getKeywordSchema(EntityType.FILE);
        FullTextSearchSchema r7 = r0.getKeywordSchema(401);
        com.obric.search.api.c.a r8 = new com.obric.search.api.c.d(2, 3).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(new FullTextSearchSchema[]{r4, r5, r6, r7}))}).a();
        FullTextSearchSchema r9 = r0.getKeywordSchema(702);
        com.obric.search.api.c.a r10 = new com.obric.search.api.c.d(3, 4).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(r9))}).a();
        FullTextSearchSchema r11 = r0.getKeywordSchema(NetError.ERR_UNSAFE_REDIRECT);
        FullTextSearchSchema r12 = r0.getKeywordSchema(NetError.ERR_UNSAFE_PORT);
        com.obric.search.api.c.a r13 = new com.obric.search.api.c.d(4, 5).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(new FullTextSearchSchema[]{r11, r12}))}).a();
        FullTextSearchSchema r14 = r0.getKeywordSchema(502);
        com.obric.search.api.c.a r15 = new com.obric.search.api.c.d(5, 6).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(r14))}).a();
        com.obric.search.api.c.a r16 = new com.obric.search.api.c.d(6, 7).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(c()))}).a();
        FullTextSearchSchema r17 = r0.getKeywordSchema(NetError.ERR_CACHE_READ_FAILURE);
        com.obric.search.api.c.a r18 = new com.obric.search.api.c.d(7, 8).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(CollectionsKt.listOfNotNull(r17))}).a();
        com.obric.search.api.a.a r19 = new com.obric.search.api.a.a();
        r19.a(r3);
        r19.a(r8);
        r19.a(r10);
        r19.a(r13);
        r19.a(r15);
        r19.a(r16);
        r19.a(r18);
        return r19;
    }

    private static final com.obric.search.api.a h() {
        return f9626a.a("memory_keyword_content_index.db");
    }

    private static final com.obric.search.api.a i() {
        h.f11660a.a("memory_keyword_content_index_personal.db");
        String r0 = h.f11660a.b("memory_keyword_content_index_personal.db");
        return f9626a.a(r0);
    }

    private static final FullTextSearchSchema j() {
        return new FullTextSearchSchema("MetaInfoFullContent", com.obric.memorydata.database.a.a.a(), FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2, false);
    }

    /* JADX INFO: renamed from: lambda$N2ZQCl-XMqh2Em4A-gdyUnfNfIU, reason: not valid java name */
    public static /* synthetic */ com.obric.search.api.a m575lambda$N2ZQClXMqh2Em4AgdyUnfNfIU() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$Q6yYMwX4eYb-3MDBqaVQKU-Iums, reason: not valid java name */
    public static /* synthetic */ FullTextSearchSchema m576lambda$Q6yYMwX4eYb3MDBqaVQKUIums() {
        return j();
    }

    public static /* synthetic */ com.obric.search.api.a lambda$b_GUJZG9rNIzuj6PT2TShrvP9Nk() {
        return h();
    }

    public final com.obric.search.api.a a() {
        return (com.obric.search.api.a) ZeusTransformUtils.preCheckCast(f9627b.getValue(), com.obric.search.api.a.class, "com.obric.memorydata.plugin");
    }

    public final com.obric.search.api.a b() {
        return (com.obric.search.api.a) ZeusTransformUtils.preCheckCast(c.getValue(), com.obric.search.api.a.class, "com.obric.memorydata.plugin");
    }

    public final FullTextSearchSchema c() {
        return e();
    }

    public final Map<Integer, List<String>> d() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(com.obric.search.api.utils.a.a("六")), CollectionsKt.listOf("lu")), TuplesKt.to(Integer.valueOf(com.obric.search.api.utils.a.a("绿")), CollectionsKt.listOf("lu"))});
    }
}
