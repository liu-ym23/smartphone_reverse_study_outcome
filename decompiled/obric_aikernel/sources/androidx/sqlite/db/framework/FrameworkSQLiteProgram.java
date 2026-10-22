package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.delegate = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.delegate.bindBlob(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        this.delegate.bindDouble(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        this.delegate.bindLong(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        this.delegate.bindNull(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.delegate.bindString(r10, r11);
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
