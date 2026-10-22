package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final Lazy stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        this.database = r10;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.lazy(new SharedSQLiteStatement$stmt$2(this));
    }

    public static final /* synthetic */ SupportSQLiteStatement access$createNewStatement(SharedSQLiteStatement r10) {
        return r10.createNewStatement();
    }

    private final SupportSQLiteStatement createNewStatement() {
        String r10 = createQuery();
        return this.database.compileStatement(r10);
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    private final SupportSQLiteStatement getStmt(boolean r10) {
        if (r10 == false) goto L5;
        return getStmt();
    L5:
        return createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(SupportSQLiteStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "statement");
        if (r10 != getStmt()) goto L6;
        this.lock.set(false);
        return;
    }
}
