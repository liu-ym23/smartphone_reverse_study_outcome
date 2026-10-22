package com.obric.memorydata.personalcontext.vectordb;

import android.content.Context;
import com.obric.dejavu.library.DbLogWriter;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.LogLevel;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.n;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.utils.handler.AbstractHandlerInstance;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001.\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010$\u001a\u00020\u0005H\u0000¢\u0006\u0002\b%J\u001a\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+J\b\u0010,\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorDbManager;", "", "<init>", "()V", "TAG", "", "EMBEDDING_DIMS_VLM", "", "TEXT_EMBEDDING_DIMS", "IMAGE_EMBEDDING_DIMS", "COMMON_VECTOR_DB_ALIAS", "encryptSeed", "vdbVersion", "EMBEDDING_ENCRYPT_APPROX_FACTOR_VLM", "", "IMAGE_EMBEDDING_ENCRYPT_APPROX_FACTOR", "TEXT_EMBEDDING_ENCRYPT_APPROX_FACTOR", "registeredDbOptionMap", "", "Lkotlin/Pair;", "Lcom/obric/dejavu/library/DbOptions;", "dbInstanceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "dbOpenLockMap", "Ljava/util/concurrent/locks/ReentrantLock;", "getVectorDb", "rawTableName", "isVlm", "", "register", "", "logicDbName", "options", "optionsVlm", "getDbOptions", "tableName", "getDbOptions$personal_context_obricRelease", "createVectorDbIfNotExists", "createVectorDb", "opt", "getDbLockBy", "getAllTableNames", "", "delayOneMinuteCloseDb", "handler", "com/obric/memorydata/personalcontext/vectordb/VectorDbManager$handler$1", "Lcom/obric/memorydata/personalcontext/vectordb/VectorDbManager$handler$1;", "closeAllVectorDbRunnable", "Ljava/lang/Runnable;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12412b = null;
    private static final int c = 0;
    private static final Map<String, Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d>> d = null;
    private static final ConcurrentHashMap<String, com.obric.dejavu.library.cipher.d> e = null;
    private static final Map<String, ReentrantLock> f = null;
    private static final a g = null;
    private static final Runnable h = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/obric/memorydata/personalcontext/vectordb/VectorDbManager$handler$1", "Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;", "getHandlerThreadName", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends AbstractHandlerInstance {
        a() {
        }

        @Override // com.obric.memorydata.utils.handler.AbstractHandlerInstance
        public String getHandlerThreadName() {
            return "VectorDbManagerHandler";
        }
    }

    static {
        f12411a = new f();
        f12412b = com.obric.memorydata.middleware.database.d.f11652a.c("memory_vector_db_encrypt");
        c = g.f12413a.b();
        d = q.f12255a.u();
        e = new ConcurrentHashMap();
        f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        com.obric.dejavu.library.cipher.d.f7885b.a(LogLevel.Debug);
        com.obric.dejavu.library.cipher.d.f7885b.a((DbLogWriter) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), DbLogWriter.class, "com.obric.memorydata.plugin"));
        g = new a();
        h = $$Lambda$f$DzrrH4cfrrggw6JUfsYYunzM1vg.INSTANCE;
    }

    private f() {
    }

    private final com.obric.dejavu.library.cipher.d b(String r7, boolean r8) {
        Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d> r0 = a(r7);
        if (r0 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_VectorDbManager", "can't find vector db for " + r7, null, 4, null);
        return null;
    L6:
        if (r8 == false) goto L8;
        com.obric.dejavu.library.d r9 = r0.getSecond();
    L9:
        com.obric.dejavu.library.d r10 = (com.obric.dejavu.library.d) ZeusTransformUtils.preCheckCast(r9, com.obric.dejavu.library.d.class, "com.obric.memorydata.plugin");
        com.obric.dejavu.library.cipher.d r1 = (com.obric.dejavu.library.cipher.d) ZeusTransformUtils.preCheckCast(e.get(r10.a()), com.obric.dejavu.library.cipher.d.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        return r1;
    L13:
        return a(r10, r8);
    L8:
        r9 = r0.getFirst();
        goto L9
    }

    private final synchronized ReentrantLock b(String r5) {
        monitor-enter(this);
        Map<String, ReentrantLock> r0 = f;     // Catch: Throwable -> L8
        ReentrantLock r1 = (ReentrantLock) ZeusTransformUtils.preCheckCast(r0.get(r5), ReentrantLock.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        r1 = new ReentrantLock();     // Catch: Throwable -> L8
        r0.put(r5, r1);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    private final void b() {
        g.postDelay(TimeUnit.MINUTES.toMillis(1), h);
    }

    private static final void c() {
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.dejavu.library.cipher.d r1 = (com.obric.dejavu.library.cipher.d) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.obric.dejavu.library.cipher.d.class, "com.obric.memorydata.plugin");
        r0.remove();
        r1.close();
        goto L4
    }

    public static /* synthetic */ void lambda$DzrrH4cfrrggw6JUfsYYunzM1vg() {
        c();
    }

    public final com.obric.dejavu.library.cipher.d a(com.obric.dejavu.library.d r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "opt");
        String r0 = r11.a();
        b(r0).lock();
        ConcurrentHashMap<String, com.obric.dejavu.library.cipher.d> r1 = e;
        com.obric.dejavu.library.cipher.d r2 = (com.obric.dejavu.library.cipher.d) ZeusTransformUtils.preCheckCast(r1.get(r0), com.obric.dejavu.library.cipher.d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        b(r0).unlock();
        return r2;
    L6:
        double r3 = 0.1d;
        if (r12 == false) goto L10;
    L12:
        DbObjResult<com.obric.dejavu.library.cipher.d> r13 = com.obric.dejavu.library.cipher.d.f7885b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getCanonicalPath() + File.separator + "vectorDataBase", r11, new com.obric.dejavu.library.cipher.a(r3, f12412b, c));
        if (r13.a().a() == DbStatus.f7870a.a().a()) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_VectorDbManager", "open " + r0 + " db failed. " + r13.a().b(), null, 4, null);
        b(r0).unlock();
        return null;
    L16:
        com.obric.dejavu.library.cipher.d r14 = r13.b();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.obric.dejavu.library.cipher.DbCipherInstance");
        com.obric.dejavu.library.cipher.d r15 = (com.obric.dejavu.library.cipher.d) ZeusTransformUtils.preCheckCast(r14, com.obric.dejavu.library.cipher.d.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r0, r15);
        b(r0).unlock();
        return r15;
    L10:
        if (r11.b() != 512) goto L12;
        r3 = 0.02d;
        goto L12
    }

    public final com.obric.dejavu.library.cipher.d a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "rawTableName");
        g.removeCallbacks(h);
        com.obric.dejavu.library.cipher.d r5 = b(r3, r4);
        b();
        return r5;
    }

    public final List<String> a() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.plus(d.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.v().keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tableName");
        Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d> r2 = (Pair) ZeusTransformUtils.preCheckCast(d.get(r3), Pair.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        n r4 = (n) ZeusTransformUtils.preCheckCast(q.f12255a.v().get(r3), n.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.c();
    L9:
        return r2;
    }

    public final synchronized void a(String r3, com.obric.dejavu.library.d r4, com.obric.dejavu.library.d r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "logicDbName");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r4, "options");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r5, "optionsVlm");     // Catch: Throwable -> L6
        d.put(r3, new Pair(r4, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
