package com.obric.memorydata.database.manager;

import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/manager/ContextAwarenessDbEngine;", "", "<init>", "()V", "TAG", "", "LEGACY_GEOFENCE_TARGET_TYPE", "LEGACY_FEATURE_TARGET_TYPE", "LEGACY_HOME_STATE_TARGET_NAME", "LEGACY_COMPANY_STATE_TARGET_NAME", "DB_NAME", "migration1To2", "com/obric/memorydata/database/manager/ContextAwarenessDbEngine$migration1To2$1", "Lcom/obric/memorydata/database/manager/ContextAwarenessDbEngine$migration1To2$1;", "lock", "database", "Lcom/obric/memorydata/database/manager/ContextAwarenessDb;", "getDatabase", "context", "Landroid/content/Context;", "getDatabaseOrNull", "createDatabase", "DatabaseNotReadyException", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessDbEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContextAwarenessDbEngine f9556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ContextAwarenessDbEngine$migration1To2$1 f9557b = null;
    private static final Object c = null;
    private static volatile ContextAwarenessDb d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/manager/ContextAwarenessDbEngine$DatabaseNotReadyException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "dbName", "", "<init>", "(Ljava/lang/String;)V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DatabaseNotReadyException extends IllegalStateException {
        public DatabaseNotReadyException(String r3) {
            Intrinsics.checkNotNullParameter(r3, "dbName");
            super("Context awareness db is not ready: " + r3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.memorydata.database.manager.ContextAwarenessDbEngine$migration1To2$1] */
    static {
        f9556a = new ContextAwarenessDbEngine();
        f9557b = new ContextAwarenessDbEngine$migration1To2$1();
        c = new Object();
    }

    private ContextAwarenessDbEngine() {
    }

    private final ContextAwarenessDb c(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextAwarenessDbEngine", "create context awareness db name=context_awareness.db", false, 4, null);
        return (ContextAwarenessDb) ZeusTransformUtils.preCheckCast(Room.databaseBuilder(r7, ContextAwarenessDb.class, "context_awareness.db").openHelperFactory(com.obric.memorydata.middleware.database.d.f11652a.a("context_awareness.db")).addMigrations(new Migration[]{f9557b}).fallbackToDestructiveMigrationOnDowngrade().build(), ContextAwarenessDb.class, "com.obric.memorydata.plugin");
    }

    public final ContextAwarenessDb a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        ContextAwarenessDb r2 = b(r4);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new DatabaseNotReadyException("context_awareness.db");
    }

    public final ContextAwarenessDb b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        ContextAwarenessDbEngine r3 = (ContextAwarenessDbEngine) ZeusTransformUtils.preCheckCast(this, ContextAwarenessDbEngine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        ContextAwarenessDb r1 = d;     // Catch: Throwable -> L19
        if (r1 != null) goto L17;
        Object r2 = c;     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        ContextAwarenessDb r6 = d;     // Catch: Throwable -> L14
        if (r6 != null) goto L11;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r7, "getApplicationContext(...)");     // Catch: Throwable -> L14
        ContextAwarenessDb r8 = r3.c(r7);     // Catch: Throwable -> L14
        d = r8;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L19
        r1 = r8;
        goto L17
    L11:
        r8 = r6;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L17:
        Object r9 = Result.m1421constructorimpl(r1);     // Catch: Throwable -> L19
    L21:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L26;
        RunLog.INSTANCE.warn("ContextAwarenessDbEngine", "get context awareness db failed name=context_awareness.db", r10);
        r9 = null;
    L26:
        return (ContextAwarenessDb) ZeusTransformUtils.preCheckCast(r9, ContextAwarenessDb.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
