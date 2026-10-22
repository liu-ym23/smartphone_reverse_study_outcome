package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CleanupCallback extends RoomDatabase.Callback {
    public static final CleanupCallback INSTANCE = null;

    static {
        INSTANCE = new CleanupCallback();
    }

    private CleanupCallback() {
    }

    private final String getPruneSQL() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + getPruneDate() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public final long getPruneDate() {
        return System.currentTimeMillis() - WorkDatabaseKt.access$getPRUNE_THRESHOLD_MILLIS$p();
    }

    @Override // androidx.room.RoomDatabase.Callback
    public void onOpen(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        super.onOpen(r10);
        r10.beginTransaction();
        r10.execSQL(getPruneSQL());     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
