package xh8;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class g implements SupportSQLiteProgram {
    public final SQLiteProgram a;

    public final void clearBindings() {
        this.a.clearBindings();
    }

    public final void close() {
        this.a.close();
    }

    public g(SQLiteProgram r1) {
        this.a = r1;
    }

    public final void bindNull(int r2) {
        this.a.bindNull(r2);
    }

    public final void bindBlob(int r2, byte[] r3) {
        this.a.bindBlob(r2, r3);
    }

    public final void bindDouble(int r2, double r3) {
        this.a.bindDouble(r2, r3);
    }

    public final void bindLong(int r2, long r3) {
        this.a.bindLong(r2, r3);
    }

    public final void bindString(int r2, String r3) {
        this.a.bindString(r2, r3);
    }
}
