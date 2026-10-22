package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.island.gr.IslandSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "delegate", "Landroid/database/sqlite/SQLiteProgram;", "(Landroid/database/sqlite/SQLiteProgram;)V", "bindBlob", "", "index", "", EventBody.KEY_VALUE, "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "", "clearBindings", IslandSession.REOPEN_VALUE_CLOSE, "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        this.delegate.bindBlob(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r1, double r2) {
        this.delegate.bindDouble(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r1, long r2) {
        this.delegate.bindLong(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r1) {
        this.delegate.bindNull(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        this.delegate.bindString(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }
}
