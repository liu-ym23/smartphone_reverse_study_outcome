package com.obric.memorydata.personalcontext.vectordb;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u000e\u0010\u0015\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorDbMigrationManager;", "", "<init>", "()V", "TAG", "", "KEY_VERSION", "KEY_INITIALIZED", "CURRENT_VERSION", "", "vectorCopilotToRawDbName", "", "memoryStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "migrate", "", "getCurrentVersion", "setCurrentVersion", "isInitialized", "", "setInitialized", "reDonateVdbEntity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f12414b = null;
    private static final IStore c = null;

    static {
        f12413a = new g();
        f12414b = q.f12255a.m();
        c = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private g() {
    }

    public static final /* synthetic */ void a(g r0) {
        r0.c();
    }

    private final void c() {
        c.save("memory_vector_db_version", 2);
    }

    private final boolean d() {
        return c.getBoolean("is_vector_initialized", false);
    }

    private final void e() {
        c.save("is_vector_initialized", true);
    }

    public final Object a(Continuation<? super Unit> r20) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, VectorDbMigrationManager$reDonateVdbEntity$1.class) == false) goto L7;
        VectorDbMigrationManager$reDonateVdbEntity$1 r2 = (VectorDbMigrationManager$reDonateVdbEntity$1) ZeusTransformUtils.preCheckCast(r0, VectorDbMigrationManager$reDonateVdbEntity$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(r2.L$0, Set.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
    L58:
        EntityManager.INSTANCE.reIndexCertainApps(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")));
    L60:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(f.f12411a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r7.hasNext() == false) goto L53;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(f12414b.get(r8), String.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L16;
        if (q.f12255a.w().contains(r8) == false) goto L23;
        SupportSQLiteOpenHelper r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper();
    L24:
        SupportSQLiteDatabase r11 = r10.getReadableDatabase();
        Cursor r12 = r11.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT DISTINCT rawDbId FROM " + r8), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r14, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        int r16 = r12.getColumnIndexOrThrow("rawDbId");     // Catch: Throwable -> L46
    L27:
        if (r12.moveToNext() == false) goto L29;
        r13.add(Boxing.boxLong(r12.getLong(r16)));     // Catch: Throwable -> L46
        goto L27
    L29:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L46
        CloseableKt.closeFinally(r14, null);
        if (r13.isEmpty() == true) goto L16;
        Cursor r18 = r11.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT DISTINCT packageName FROM " + r9 + " WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        Closeable r19 = (Closeable) ZeusTransformUtils.preCheckCast(r18, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r21 = (Cursor) ZeusTransformUtils.preCheckCast(r19, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        int r22 = r18.getColumnIndexOrThrow(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L40
    L36:
        if (r18.moveToNext() == false) goto L38;
        String r110 = r18.getString(r22);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r110, "getString(...)");     // Catch: Throwable -> L40
        r6.add(r110);     // Catch: Throwable -> L40
        goto L36
    L38:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r19, null);
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);
        throw th;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L23:
        r10 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
        goto L24
    L53:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_VectorDbMigrationManager", "will redonate vector-not-empty entity after 1 min", false, 4, null);
        r2.L$0 = r6;
        r2.label = 1;
        if (au.a(60000, r2) != r3) goto L57;
        return r3;
    L57:
        r5 = r6;
    L7:
        r2 = new VectorDbMigrationManager$reDonateVdbEntity$1(this, r0);
        goto L8
    }

    public final void a() {
        if (d() == true) goto L6;
        c();
        e();
        return;
    L6:
        i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new VectorDbMigrationManager$migrate$1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final int b() {
        return c.getInt("memory_vector_db_version", 1);
    }
}
