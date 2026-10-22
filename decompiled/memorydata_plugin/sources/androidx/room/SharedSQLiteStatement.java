package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H$J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/room/SharedSQLiteStatement;", "", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "lock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stmt", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getStmt", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "stmt$delegate", "Lkotlin/Lazy;", "acquire", "assertNotMainThread", "", "createNewStatement", "createQuery", "", "canUseCached", "", "release", "statement", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final Lazy stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "database");
        this.database = r3;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new SharedSQLiteStatement$stmt$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ SupportSQLiteStatement access$createNewStatement(SharedSQLiteStatement r0) {
        return r0.createNewStatement();
    }

    private final SupportSQLiteStatement createNewStatement() {
        String r0 = createQuery();
        return this.database.compileStatement(r0);
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) ZeusTransformUtils.preCheckCast(this.stmt$delegate.getValue(), SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
    }

    private final SupportSQLiteStatement getStmt(boolean r1) {
        if (r1 == false) goto L5;
        return getStmt();
    L5:
        return createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(SupportSQLiteStatement r3) {
        SupportSQLiteStatement r4 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "statement");
        if (r4 != getStmt()) goto L6;
        this.lock.set(false);
        return;
    }
}
